package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.EventLoop;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator.DelegatingHandle;
import io.netty.channel.RecvByteBufAllocator.ExtendedHandle;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.socket.DuplexChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.SocketWritableByteChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public abstract class AbstractEpollStreamChannel
  extends AbstractEpollChannel
  implements DuplexChannel
{
  private static final String EXPECTED_TYPES;
  private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractEpollStreamChannel.class);
  private WritableByteChannel byteChannel;
  private final Runnable flushTask = new Runnable()
  {
    public void run()
    {
      ((AbstractEpollChannel.AbstractEpollUnsafe)AbstractEpollStreamChannel.this.unsafe()).flush0();
    }
  };
  private FileDescriptor pipeIn;
  private FileDescriptor pipeOut;
  private volatile Queue<SpliceInTask> spliceQueue;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" (expected: ");
    localStringBuilder.append(StringUtil.simpleClassName(ByteBuf.class));
    localStringBuilder.append(", ");
    localStringBuilder.append(StringUtil.simpleClassName(DefaultFileRegion.class));
    localStringBuilder.append(')');
    EXPECTED_TYPES = localStringBuilder.toString();
  }
  
  protected AbstractEpollStreamChannel(int paramInt)
  {
    this(new LinuxSocket(paramInt));
  }
  
  protected AbstractEpollStreamChannel(Channel paramChannel, int paramInt)
  {
    this(paramChannel, new LinuxSocket(paramInt));
  }
  
  AbstractEpollStreamChannel(Channel paramChannel, LinuxSocket paramLinuxSocket)
  {
    super(paramChannel, paramLinuxSocket, true);
    this.flags |= Native.EPOLLRDHUP;
  }
  
  AbstractEpollStreamChannel(Channel paramChannel, LinuxSocket paramLinuxSocket, SocketAddress paramSocketAddress)
  {
    super(paramChannel, paramLinuxSocket, paramSocketAddress);
    this.flags |= Native.EPOLLRDHUP;
  }
  
  AbstractEpollStreamChannel(LinuxSocket paramLinuxSocket)
  {
    this(paramLinuxSocket, AbstractEpollChannel.isSoErrorZero(paramLinuxSocket));
  }
  
  protected AbstractEpollStreamChannel(LinuxSocket paramLinuxSocket, boolean paramBoolean)
  {
    super(null, paramLinuxSocket, paramBoolean);
    this.flags |= Native.EPOLLRDHUP;
  }
  
  private void addToSpliceQueue(SpliceInTask paramSpliceInTask)
  {
    Queue localQueue1 = this.spliceQueue;
    Queue localQueue2 = localQueue1;
    if (localQueue1 == null) {
      try
      {
        localQueue1 = this.spliceQueue;
        localQueue2 = localQueue1;
        if (localQueue1 == null)
        {
          localQueue2 = PlatformDependent.newMpscQueue();
          this.spliceQueue = localQueue2;
        }
      }
      finally {}
    }
    localQueue2.add(paramSpliceInTask);
  }
  
  private void adjustMaxBytesPerGatheringWrite(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 == paramLong2)
    {
      paramLong1 <<= 1;
      if (paramLong1 > paramLong3) {
        config().setMaxBytesPerGatheringWrite(paramLong1);
      }
    }
    else if (paramLong1 > 4096L)
    {
      paramLong1 >>>= 1;
      if (paramLong2 < paramLong1) {
        config().setMaxBytesPerGatheringWrite(paramLong1);
      }
    }
  }
  
  private void clearSpliceQueue()
  {
    Queue localQueue = this.spliceQueue;
    if (localQueue == null) {
      return;
    }
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      SpliceInTask localSpliceInTask = (SpliceInTask)localQueue.poll();
      if (localSpliceInTask == null) {
        return;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ClosedChannelException();
      }
      localSpliceInTask.promise.tryFailure((Throwable)localObject2);
    }
  }
  
  private int doWriteMultiple(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    long l = config().getMaxBytesPerGatheringWrite();
    IovArray localIovArray = ((EpollEventLoop)eventLoop()).cleanIovArray();
    localIovArray.maxBytes(l);
    paramChannelOutboundBuffer.forEachFlushedMessage(localIovArray);
    if (localIovArray.count() >= 1) {
      return writeBytesMultiple(paramChannelOutboundBuffer, localIovArray);
    }
    paramChannelOutboundBuffer.removeBytes(0L);
    return 0;
  }
  
  private void failSpliceIfClosed(ChannelPromise paramChannelPromise)
  {
    if ((!isOpen()) && (paramChannelPromise.tryFailure(new ClosedChannelException()))) {
      eventLoop().execute(new Runnable()
      {
        public void run()
        {
          AbstractEpollStreamChannel.this.clearSpliceQueue();
        }
      });
    }
  }
  
  private static void safeClosePipe(FileDescriptor paramFileDescriptor)
  {
    if (paramFileDescriptor != null) {
      try
      {
        paramFileDescriptor.close();
      }
      catch (IOException paramFileDescriptor)
      {
        logger.warn("Error while closing a pipe", paramFileDescriptor);
      }
    }
  }
  
  private static void shutdownDone(ChannelFuture paramChannelFuture1, ChannelFuture paramChannelFuture2, ChannelPromise paramChannelPromise)
  {
    paramChannelFuture1 = paramChannelFuture1.cause();
    paramChannelFuture2 = paramChannelFuture2.cause();
    if (paramChannelFuture1 != null)
    {
      if (paramChannelFuture2 != null) {
        logger.debug("Exception suppressed because a previous exception occurred.", paramChannelFuture2);
      }
      paramChannelPromise.setFailure(paramChannelFuture1);
    }
    else if (paramChannelFuture2 != null)
    {
      paramChannelPromise.setFailure(paramChannelFuture2);
    }
    else
    {
      paramChannelPromise.setSuccess();
    }
  }
  
  /* Error */
  private void shutdownInput0(ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 326	io/netty/channel/epoll/AbstractEpollChannel:socket	Lio/netty/channel/epoll/LinuxSocket;
    //   4: iconst_1
    //   5: iconst_0
    //   6: invokevirtual 332	io/netty/channel/unix/Socket:shutdown	(ZZ)V
    //   9: aload_1
    //   10: invokeinterface 322 1 0
    //   15: pop
    //   16: goto +12 -> 28
    //   19: astore_2
    //   20: aload_1
    //   21: aload_2
    //   22: invokeinterface 318 2 0
    //   27: pop
    //   28: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	AbstractEpollStreamChannel
    //   0	29	1	paramChannelPromise	ChannelPromise
    //   19	3	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	16	19	finally
  }
  
  private void shutdownOutputDone(final ChannelFuture paramChannelFuture, final ChannelPromise paramChannelPromise)
  {
    ChannelFuture localChannelFuture = shutdownInput();
    if (localChannelFuture.isDone()) {
      shutdownDone(paramChannelFuture, localChannelFuture, paramChannelPromise);
    } else {
      localChannelFuture.addListener(new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
          throws Exception
        {
          AbstractEpollStreamChannel.shutdownDone(paramChannelFuture, paramAnonymousChannelFuture, paramChannelPromise);
        }
      });
    }
  }
  
  private int writeBytes(ChannelOutboundBuffer paramChannelOutboundBuffer, ByteBuf paramByteBuf)
    throws Exception
  {
    int i = paramByteBuf.readableBytes();
    if (i == 0)
    {
      paramChannelOutboundBuffer.remove();
      return 0;
    }
    if ((!paramByteBuf.hasMemoryAddress()) && (paramByteBuf.nioBufferCount() != 1))
    {
      paramByteBuf = paramByteBuf.nioBuffers();
      return writeBytesMultiple(paramChannelOutboundBuffer, paramByteBuf, paramByteBuf.length, i, config().getMaxBytesPerGatheringWrite());
    }
    return doWriteBytes(paramChannelOutboundBuffer, paramByteBuf);
  }
  
  private int writeBytesMultiple(ChannelOutboundBuffer paramChannelOutboundBuffer, IovArray paramIovArray)
    throws IOException
  {
    long l1 = paramIovArray.size();
    int i = paramIovArray.count();
    long l2 = this.socket.writevAddresses(paramIovArray.memoryAddress(0), i);
    if (l2 > 0L)
    {
      adjustMaxBytesPerGatheringWrite(l1, l2, paramIovArray.maxBytes());
      paramChannelOutboundBuffer.removeBytes(l2);
      return 1;
    }
    return Integer.MAX_VALUE;
  }
  
  private int writeBytesMultiple(ChannelOutboundBuffer paramChannelOutboundBuffer, ByteBuffer[] paramArrayOfByteBuffer, int paramInt, long paramLong1, long paramLong2)
    throws IOException
  {
    long l = paramLong1;
    if (paramLong1 > paramLong2) {
      l = paramLong2;
    }
    paramLong1 = this.socket.writev(paramArrayOfByteBuffer, 0, paramInt, l);
    if (paramLong1 > 0L)
    {
      adjustMaxBytesPerGatheringWrite(l, paramLong1, paramLong2);
      paramChannelOutboundBuffer.removeBytes(paramLong1);
      return 1;
    }
    return Integer.MAX_VALUE;
  }
  
  private int writeDefaultFileRegion(ChannelOutboundBuffer paramChannelOutboundBuffer, DefaultFileRegion paramDefaultFileRegion)
    throws Exception
  {
    long l1 = paramDefaultFileRegion.transferred();
    long l2 = paramDefaultFileRegion.count();
    if (l1 >= l2)
    {
      paramChannelOutboundBuffer.remove();
      return 0;
    }
    long l3 = this.socket.sendFile(paramDefaultFileRegion, paramDefaultFileRegion.position(), l1, l2 - l1);
    boolean bool = l3 < 0L;
    if (bool)
    {
      paramChannelOutboundBuffer.progress(l3);
      if (paramDefaultFileRegion.transferred() >= l2) {
        paramChannelOutboundBuffer.remove();
      }
      return 1;
    }
    if (!bool) {
      validateFileRegion(paramDefaultFileRegion, l1);
    }
    return Integer.MAX_VALUE;
  }
  
  private int writeFileRegion(ChannelOutboundBuffer paramChannelOutboundBuffer, FileRegion paramFileRegion)
    throws Exception
  {
    if (paramFileRegion.transferred() >= paramFileRegion.count())
    {
      paramChannelOutboundBuffer.remove();
      return 0;
    }
    if (this.byteChannel == null) {
      this.byteChannel = new EpollSocketWritableByteChannel();
    }
    long l = paramFileRegion.transferTo(this.byteChannel, paramFileRegion.transferred());
    if (l > 0L)
    {
      paramChannelOutboundBuffer.progress(l);
      if (paramFileRegion.transferred() >= paramFileRegion.count()) {
        paramChannelOutboundBuffer.remove();
      }
      return 1;
    }
    return Integer.MAX_VALUE;
  }
  
  protected void doClose()
    throws Exception
  {
    try
    {
      super.doClose();
      return;
    }
    finally
    {
      safeClosePipe(this.pipeIn);
      safeClosePipe(this.pipeOut);
      clearSpliceQueue();
    }
  }
  
  protected final void doShutdownOutput()
    throws Exception
  {
    this.socket.shutdown(false, true);
  }
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    int i = config().getWriteSpinCount();
    int j;
    do
    {
      j = paramChannelOutboundBuffer.size();
      if ((j > 1) && ((paramChannelOutboundBuffer.current() instanceof ByteBuf)))
      {
        j = doWriteMultiple(paramChannelOutboundBuffer);
      }
      else
      {
        if (j == 0)
        {
          clearFlag(Native.EPOLLOUT);
          return;
        }
        j = doWriteSingle(paramChannelOutboundBuffer);
      }
      j = i - j;
      i = j;
    } while (j > 0);
    if (j == 0)
    {
      clearFlag(Native.EPOLLOUT);
      eventLoop().execute(this.flushTask);
    }
    else
    {
      setFlag(Native.EPOLLOUT);
    }
  }
  
  protected int doWriteSingle(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    Object localObject = paramChannelOutboundBuffer.current();
    if ((localObject instanceof ByteBuf)) {
      return writeBytes(paramChannelOutboundBuffer, (ByteBuf)localObject);
    }
    if ((localObject instanceof DefaultFileRegion)) {
      return writeDefaultFileRegion(paramChannelOutboundBuffer, (DefaultFileRegion)localObject);
    }
    if ((localObject instanceof FileRegion)) {
      return writeFileRegion(paramChannelOutboundBuffer, (FileRegion)localObject);
    }
    if ((localObject instanceof SpliceOutTask))
    {
      if (!((SpliceOutTask)localObject).spliceOut()) {
        return Integer.MAX_VALUE;
      }
      paramChannelOutboundBuffer.remove();
      return 1;
    }
    throw new Error();
  }
  
  protected Object filterOutboundMessage(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof ByteBuf))
    {
      localObject = (ByteBuf)paramObject;
      paramObject = localObject;
      if (UnixChannelUtil.isBufferCopyNeededForWrite((ByteBuf)localObject)) {
        paramObject = newDirectBuffer((ByteBuf)localObject);
      }
      return paramObject;
    }
    if ((!(paramObject instanceof FileRegion)) && (!(paramObject instanceof SpliceOutTask)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unsupported message type: ");
      ((StringBuilder)localObject).append(StringUtil.simpleClassName(paramObject));
      ((StringBuilder)localObject).append(EXPECTED_TYPES);
      throw new UnsupportedOperationException(((StringBuilder)localObject).toString());
    }
    return paramObject;
  }
  
  public boolean isInputShutdown()
  {
    return this.socket.isInputShutdown();
  }
  
  public boolean isOutputShutdown()
  {
    return this.socket.isOutputShutdown();
  }
  
  public boolean isShutdown()
  {
    return this.socket.isShutdown();
  }
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  protected AbstractEpollChannel.AbstractEpollUnsafe newUnsafe()
  {
    return new EpollStreamUnsafe();
  }
  
  public ChannelFuture shutdown()
  {
    return shutdown(newPromise());
  }
  
  public ChannelFuture shutdown(final ChannelPromise paramChannelPromise)
  {
    ChannelFuture localChannelFuture = shutdownOutput();
    if (localChannelFuture.isDone()) {
      shutdownOutputDone(localChannelFuture, paramChannelPromise);
    } else {
      localChannelFuture.addListener(new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
          throws Exception
        {
          AbstractEpollStreamChannel.this.shutdownOutputDone(paramAnonymousChannelFuture, paramChannelPromise);
        }
      });
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture shutdownInput()
  {
    return shutdownInput(newPromise());
  }
  
  public ChannelFuture shutdownInput(final ChannelPromise paramChannelPromise)
  {
    Object localObject = ((EpollStreamUnsafe)unsafe()).prepareToClose();
    if (localObject != null)
    {
      ((Executor)localObject).execute(new Runnable()
      {
        public void run()
        {
          AbstractEpollStreamChannel.this.shutdownInput0(paramChannelPromise);
        }
      });
    }
    else
    {
      localObject = eventLoop();
      if (((EventExecutor)localObject).inEventLoop()) {
        shutdownInput0(paramChannelPromise);
      } else {
        ((ScheduledExecutorService)localObject).execute(new Runnable()
        {
          public void run()
          {
            AbstractEpollStreamChannel.this.shutdownInput0(paramChannelPromise);
          }
        });
      }
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture shutdownOutput()
  {
    return shutdownOutput(newPromise());
  }
  
  public ChannelFuture shutdownOutput(final ChannelPromise paramChannelPromise)
  {
    EventLoop localEventLoop = eventLoop();
    if (localEventLoop.inEventLoop()) {
      ((AbstractChannel.AbstractUnsafe)unsafe()).shutdownOutput(paramChannelPromise);
    } else {
      localEventLoop.execute(new Runnable()
      {
        public void run()
        {
          ((AbstractChannel.AbstractUnsafe)AbstractEpollStreamChannel.this.unsafe()).shutdownOutput(paramChannelPromise);
        }
      });
    }
    return paramChannelPromise;
  }
  
  public final ChannelFuture spliceTo(AbstractEpollStreamChannel paramAbstractEpollStreamChannel, int paramInt)
  {
    return spliceTo(paramAbstractEpollStreamChannel, paramInt, newPromise());
  }
  
  public final ChannelFuture spliceTo(AbstractEpollStreamChannel paramAbstractEpollStreamChannel, int paramInt, ChannelPromise paramChannelPromise)
  {
    if (paramAbstractEpollStreamChannel.eventLoop() == eventLoop())
    {
      ObjectUtil.checkPositiveOrZero(paramInt, "len");
      EpollMode localEpollMode1 = paramAbstractEpollStreamChannel.config().getEpollMode();
      EpollMode localEpollMode2 = EpollMode.LEVEL_TRIGGERED;
      if ((localEpollMode1 == localEpollMode2) && (config().getEpollMode() == localEpollMode2))
      {
        ObjectUtil.checkNotNull(paramChannelPromise, "promise");
        if (!isOpen())
        {
          paramChannelPromise.tryFailure(new ClosedChannelException());
        }
        else
        {
          addToSpliceQueue(new SpliceInChannelTask(paramAbstractEpollStreamChannel, paramInt, paramChannelPromise));
          failSpliceIfClosed(paramChannelPromise);
        }
        return paramChannelPromise;
      }
      paramAbstractEpollStreamChannel = new StringBuilder();
      paramAbstractEpollStreamChannel.append("spliceTo() supported only when using ");
      paramAbstractEpollStreamChannel.append(localEpollMode2);
      throw new IllegalStateException(paramAbstractEpollStreamChannel.toString());
    }
    throw new IllegalArgumentException("EventLoops are not the same.");
  }
  
  public final ChannelFuture spliceTo(FileDescriptor paramFileDescriptor, int paramInt1, int paramInt2)
  {
    return spliceTo(paramFileDescriptor, paramInt1, paramInt2, newPromise());
  }
  
  public final ChannelFuture spliceTo(FileDescriptor paramFileDescriptor, int paramInt1, int paramInt2, ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkPositiveOrZero(paramInt2, "len");
    ObjectUtil.checkPositiveOrZero(paramInt1, "offset");
    EpollMode localEpollMode1 = config().getEpollMode();
    EpollMode localEpollMode2 = EpollMode.LEVEL_TRIGGERED;
    if (localEpollMode1 == localEpollMode2)
    {
      ObjectUtil.checkNotNull(paramChannelPromise, "promise");
      if (!isOpen())
      {
        paramChannelPromise.tryFailure(new ClosedChannelException());
      }
      else
      {
        addToSpliceQueue(new SpliceFdTask(paramFileDescriptor, paramInt1, paramInt2, paramChannelPromise));
        failSpliceIfClosed(paramChannelPromise);
      }
      return paramChannelPromise;
    }
    paramFileDescriptor = new StringBuilder();
    paramFileDescriptor.append("spliceTo() supported only when using ");
    paramFileDescriptor.append(localEpollMode2);
    throw new IllegalStateException(paramFileDescriptor.toString());
  }
  
  private final class EpollSocketWritableByteChannel
    extends SocketWritableByteChannel
  {
    EpollSocketWritableByteChannel()
    {
      super();
    }
    
    protected ByteBufAllocator alloc()
    {
      return AbstractEpollStreamChannel.this.alloc();
    }
  }
  
  class EpollStreamUnsafe
    extends AbstractEpollChannel.AbstractEpollUnsafe
  {
    EpollStreamUnsafe()
    {
      super();
    }
    
    private void handleReadException(ChannelPipeline paramChannelPipeline, ByteBuf paramByteBuf, Throwable paramThrowable, boolean paramBoolean, EpollRecvByteAllocatorHandle paramEpollRecvByteAllocatorHandle)
    {
      if (paramByteBuf != null) {
        if (paramByteBuf.isReadable())
        {
          this.readPending = false;
          paramChannelPipeline.fireChannelRead(paramByteBuf);
        }
        else
        {
          paramByteBuf.release();
        }
      }
      paramEpollRecvByteAllocatorHandle.readComplete();
      paramChannelPipeline.fireChannelReadComplete();
      paramChannelPipeline.fireExceptionCaught(paramThrowable);
      if ((paramBoolean) || ((paramThrowable instanceof IOException))) {
        shutdownInput(false);
      }
    }
    
    void epollInReady()
    {
      EpollChannelConfig localEpollChannelConfig = AbstractEpollStreamChannel.this.config();
      if (AbstractEpollStreamChannel.this.shouldBreakEpollInReady(localEpollChannelConfig))
      {
        clearEpollIn0();
        return;
      }
      EpollRecvByteAllocatorHandle localEpollRecvByteAllocatorHandle = recvBufAllocHandle();
      localEpollRecvByteAllocatorHandle.edgeTriggered(AbstractEpollStreamChannel.this.isFlagSet(Native.EPOLLET));
      ChannelPipeline localChannelPipeline = AbstractEpollStreamChannel.this.pipeline();
      ByteBufAllocator localByteBufAllocator = localEpollChannelConfig.getAllocator();
      localEpollRecvByteAllocatorHandle.reset(localEpollChannelConfig);
      epollInBefore();
      Object localObject1 = null;
      Object localObject4;
      label157:
      boolean bool2;
      for (;;)
      {
        localObject4 = localObject1;
        if (localObject1 == null) {}
        try
        {
          localObject4 = AbstractEpollStreamChannel.this.spliceQueue;
          localObject1 = localObject4;
          boolean bool1;
          if (localObject4 != null)
          {
            AbstractEpollStreamChannel.SpliceInTask localSpliceInTask = (AbstractEpollStreamChannel.SpliceInTask)((Queue)localObject4).peek();
            localObject1 = localObject4;
            if (localSpliceInTask != null)
            {
              if (localSpliceInTask.spliceIn(localEpollRecvByteAllocatorHandle))
              {
                localObject1 = localObject4;
                if (!AbstractEpollStreamChannel.this.isActive()) {
                  break label281;
                }
                ((Queue)localObject4).remove();
                localObject1 = localObject4;
                break label281;
              }
              bool1 = false;
              break label295;
            }
          }
          localObject4 = localEpollRecvByteAllocatorHandle.allocate(localByteBufAllocator);
          try
          {
            localEpollRecvByteAllocatorHandle.lastBytesRead(AbstractEpollStreamChannel.this.doReadBytes((ByteBuf)localObject4));
            int i = localEpollRecvByteAllocatorHandle.lastBytesRead();
            bool2 = true;
            boolean bool3;
            if (i <= 0)
            {
              ((ReferenceCounted)localObject4).release();
              i = localEpollRecvByteAllocatorHandle.lastBytesRead();
              if (i >= 0) {
                bool2 = false;
              }
              bool1 = bool2;
              if (!bool2) {
                break label295;
              }
              bool3 = bool2;
            }
            try
            {
              this.readPending = false;
              bool1 = bool2;
              break label295;
              localEpollRecvByteAllocatorHandle.incMessagesRead(1);
              this.readPending = false;
              localChannelPipeline.fireChannelRead(localObject4);
              if (AbstractEpollStreamChannel.this.shouldBreakEpollInReady(localEpollChannelConfig)) {
                break label157;
              }
              label281:
              bool2 = localEpollRecvByteAllocatorHandle.continueReading();
              if (bool2) {
                continue;
              }
              break label157;
              label295:
              bool3 = bool1;
              localEpollRecvByteAllocatorHandle.readComplete();
              bool3 = bool1;
              localChannelPipeline.fireChannelReadComplete();
              if (!bool1) {
                break label368;
              }
              bool3 = bool1;
              shutdownInput(false);
            }
            finally
            {
              localObject4 = null;
              bool2 = bool3;
            }
            localThrowable = finally;
          }
          finally {}
          bool2 = false;
        }
        finally {}
      }
      try
      {
        handleReadException(localChannelPipeline, (ByteBuf)localObject4, localThrowable, bool2, localEpollRecvByteAllocatorHandle);
        label368:
        return;
      }
      finally
      {
        epollInFinally(localEpollChannelConfig);
      }
    }
    
    EpollRecvByteAllocatorHandle newEpollHandle(RecvByteBufAllocator.ExtendedHandle paramExtendedHandle)
    {
      return new EpollRecvByteAllocatorStreamingHandle(paramExtendedHandle);
    }
    
    protected Executor prepareToClose()
    {
      return super.prepareToClose();
    }
  }
  
  private final class SpliceFdTask
    extends AbstractEpollStreamChannel.SpliceInTask
  {
    private final FileDescriptor fd;
    private int offset;
    private final ChannelPromise promise;
    
    SpliceFdTask(FileDescriptor paramFileDescriptor, int paramInt1, int paramInt2, ChannelPromise paramChannelPromise)
    {
      super(paramInt2, paramChannelPromise);
      this.fd = paramFileDescriptor;
      this.promise = paramChannelPromise;
      this.offset = paramInt1;
    }
    
    public boolean spliceIn(RecvByteBufAllocator.Handle paramHandle)
    {
      if (this.len == 0)
      {
        this.promise.setSuccess();
        return true;
      }
      try
      {
        Object localObject = FileDescriptor.pipe();
        FileDescriptor localFileDescriptor = localObject[0];
        localObject = localObject[1];
        try
        {
          int i = spliceIn((FileDescriptor)localObject, paramHandle);
          if (i > 0)
          {
            int j = this.len;
            int k = i;
            if (j != Integer.MAX_VALUE)
            {
              this.len = (j - i);
              k = i;
            }
            do
            {
              i = Native.splice(localFileDescriptor.intValue(), -1L, this.fd.intValue(), this.offset, k);
              this.offset += i;
              i = k - i;
              k = i;
            } while (i > 0);
            if (this.len == 0) {
              return true;
            }
          }
          return false;
        }
        finally
        {
          AbstractEpollStreamChannel.safeClosePipe(localFileDescriptor);
          AbstractEpollStreamChannel.safeClosePipe((FileDescriptor)localObject);
        }
        return true;
      }
      finally
      {
        this.promise.setFailure(paramHandle);
      }
    }
  }
  
  private final class SpliceInChannelTask
    extends AbstractEpollStreamChannel.SpliceInTask
    implements ChannelFutureListener
  {
    private final AbstractEpollStreamChannel ch;
    
    SpliceInChannelTask(AbstractEpollStreamChannel paramAbstractEpollStreamChannel, int paramInt, ChannelPromise paramChannelPromise)
    {
      super(paramInt, paramChannelPromise);
      this.ch = paramAbstractEpollStreamChannel;
    }
    
    public void operationComplete(ChannelFuture paramChannelFuture)
      throws Exception
    {
      if (!paramChannelFuture.isSuccess()) {
        this.promise.setFailure(paramChannelFuture.cause());
      }
    }
    
    public boolean spliceIn(RecvByteBufAllocator.Handle paramHandle)
    {
      int i = this.len;
      boolean bool1 = true;
      if (i == 0)
      {
        this.promise.setSuccess();
        return true;
      }
      try
      {
        Object localObject1 = this.ch.pipeOut;
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = FileDescriptor.pipe();
          AbstractEpollStreamChannel.access$602(this.ch, localObject2[0]);
          localObject2 = AbstractEpollStreamChannel.access$502(this.ch, localObject2[1]);
        }
        i = spliceIn((FileDescriptor)localObject2, paramHandle);
        if (i > 0)
        {
          int j = this.len;
          if (j != Integer.MAX_VALUE) {
            this.len = (j - i);
          }
          if (this.len == 0) {
            paramHandle = this.promise;
          } else {
            paramHandle = this.ch.newPromise().addListener(this);
          }
          boolean bool2 = AbstractEpollStreamChannel.this.config().isAutoRead();
          localObject2 = this.ch.unsafe();
          localObject1 = new io/netty/channel/epoll/AbstractEpollStreamChannel$SpliceOutTask;
          ((AbstractEpollStreamChannel.SpliceOutTask)localObject1).<init>(AbstractEpollStreamChannel.this, this.ch, i, bool2);
          ((Channel.Unsafe)localObject2).write(localObject1, paramHandle);
          this.ch.unsafe().flush();
          if ((bool2) && (!paramHandle.isDone())) {
            AbstractEpollStreamChannel.this.config().setAutoRead(false);
          }
        }
        i = this.len;
        if (i != 0) {
          bool1 = false;
        }
        return bool1;
      }
      finally
      {
        this.promise.setFailure(paramHandle);
      }
      return true;
    }
  }
  
  protected abstract class SpliceInTask
  {
    int len;
    final ChannelPromise promise;
    
    protected SpliceInTask(int paramInt, ChannelPromise paramChannelPromise)
    {
      this.promise = paramChannelPromise;
      this.len = paramInt;
    }
    
    protected final int spliceIn(FileDescriptor paramFileDescriptor, RecvByteBufAllocator.Handle paramHandle)
      throws IOException
    {
      int i = Math.min(paramHandle.guess(), this.len);
      int j = 0;
      for (;;)
      {
        int k = Native.splice(AbstractEpollStreamChannel.this.socket.intValue(), -1L, paramFileDescriptor.intValue(), -1L, i);
        if (k == 0) {
          return j;
        }
        j += k;
        i -= k;
      }
    }
    
    abstract boolean spliceIn(RecvByteBufAllocator.Handle paramHandle);
  }
  
  private final class SpliceOutTask
  {
    private final boolean autoRead;
    private final AbstractEpollStreamChannel ch;
    private int len;
    
    SpliceOutTask(AbstractEpollStreamChannel paramAbstractEpollStreamChannel, int paramInt, boolean paramBoolean)
    {
      this.ch = paramAbstractEpollStreamChannel;
      this.len = paramInt;
      this.autoRead = paramBoolean;
    }
    
    public boolean spliceOut()
      throws Exception
    {
      try
      {
        int i = Native.splice(this.ch.pipeIn.intValue(), -1L, this.ch.socket.intValue(), -1L, this.len);
        i = this.len - i;
        this.len = i;
        if (i == 0)
        {
          if (this.autoRead) {
            AbstractEpollStreamChannel.this.config().setAutoRead(true);
          }
          return true;
        }
        return false;
      }
      catch (IOException localIOException)
      {
        if (this.autoRead) {
          AbstractEpollStreamChannel.this.config().setAutoRead(true);
        }
        throw localIOException;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\AbstractEpollStreamChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */