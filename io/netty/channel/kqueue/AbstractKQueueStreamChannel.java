package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel;
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
import io.netty.channel.socket.DuplexChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.SocketWritableByteChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public abstract class AbstractKQueueStreamChannel
  extends AbstractKQueueChannel
  implements DuplexChannel
{
  private static final String EXPECTED_TYPES;
  private static final ChannelMetadata METADATA;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractKQueueStreamChannel.class);
  private WritableByteChannel byteChannel;
  private final Runnable flushTask = new Runnable()
  {
    public void run()
    {
      ((AbstractKQueueChannel.AbstractKQueueUnsafe)AbstractKQueueStreamChannel.this.unsafe()).flush0();
    }
  };
  
  static
  {
    METADATA = new ChannelMetadata(false, 16);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" (expected: ");
    localStringBuilder.append(StringUtil.simpleClassName(ByteBuf.class));
    localStringBuilder.append(", ");
    localStringBuilder.append(StringUtil.simpleClassName(DefaultFileRegion.class));
    localStringBuilder.append(')');
    EXPECTED_TYPES = localStringBuilder.toString();
  }
  
  AbstractKQueueStreamChannel(Channel paramChannel, BsdSocket paramBsdSocket, SocketAddress paramSocketAddress)
  {
    super(paramChannel, paramBsdSocket, paramSocketAddress);
  }
  
  AbstractKQueueStreamChannel(Channel paramChannel, BsdSocket paramBsdSocket, boolean paramBoolean)
  {
    super(paramChannel, paramBsdSocket, paramBoolean);
  }
  
  AbstractKQueueStreamChannel(BsdSocket paramBsdSocket)
  {
    this(null, paramBsdSocket, AbstractKQueueChannel.isSoErrorZero(paramBsdSocket));
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
  
  private int doWriteMultiple(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    long l = config().getMaxBytesPerGatheringWrite();
    IovArray localIovArray = ((KQueueEventLoop)eventLoop()).cleanArray();
    localIovArray.maxBytes(l);
    paramChannelOutboundBuffer.forEachFlushedMessage(localIovArray);
    if (localIovArray.count() >= 1) {
      return writeBytesMultiple(paramChannelOutboundBuffer, localIovArray);
    }
    paramChannelOutboundBuffer.removeBytes(0L);
    return 0;
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
  
  private void shutdownInput0(ChannelPromise paramChannelPromise)
  {
    try
    {
      this.socket.shutdown(true, false);
      return;
    }
    finally
    {
      paramChannelPromise.setFailure(localThrowable);
    }
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
          AbstractKQueueStreamChannel.shutdownDone(paramChannelFuture, paramAnonymousChannelFuture, paramChannelPromise);
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
    long l1 = paramDefaultFileRegion.count();
    long l2 = paramDefaultFileRegion.transferred();
    if (l2 >= l1)
    {
      paramChannelOutboundBuffer.remove();
      return 0;
    }
    long l3 = this.socket.sendFile(paramDefaultFileRegion, paramDefaultFileRegion.position(), l2, l1 - l2);
    boolean bool = l3 < 0L;
    if (bool)
    {
      paramChannelOutboundBuffer.progress(l3);
      if (paramDefaultFileRegion.transferred() >= l1) {
        paramChannelOutboundBuffer.remove();
      }
      return 1;
    }
    if (!bool) {
      validateFileRegion(paramDefaultFileRegion, l2);
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
      this.byteChannel = new KQueueSocketWritableByteChannel();
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
          writeFilter(false);
          return;
        }
        j = doWriteSingle(paramChannelOutboundBuffer);
      }
      j = i - j;
      i = j;
    } while (j > 0);
    if (j == 0)
    {
      writeFilter(false);
      eventLoop().execute(this.flushTask);
    }
    else
    {
      writeFilter(true);
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
    throw new Error();
  }
  
  protected Object filterOutboundMessage(Object paramObject)
  {
    if ((paramObject instanceof ByteBuf))
    {
      localObject = (ByteBuf)paramObject;
      paramObject = localObject;
      if (UnixChannelUtil.isBufferCopyNeededForWrite((ByteBuf)localObject)) {
        paramObject = newDirectBuffer((ByteBuf)localObject);
      }
      return paramObject;
    }
    if ((paramObject instanceof FileRegion)) {
      return paramObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unsupported message type: ");
    ((StringBuilder)localObject).append(StringUtil.simpleClassName(paramObject));
    ((StringBuilder)localObject).append(EXPECTED_TYPES);
    throw new UnsupportedOperationException(((StringBuilder)localObject).toString());
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
  
  protected AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe()
  {
    return new KQueueStreamUnsafe();
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
          AbstractKQueueStreamChannel.this.shutdownOutputDone(paramAnonymousChannelFuture, paramChannelPromise);
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
    EventLoop localEventLoop = eventLoop();
    if (localEventLoop.inEventLoop()) {
      shutdownInput0(paramChannelPromise);
    } else {
      localEventLoop.execute(new Runnable()
      {
        public void run()
        {
          AbstractKQueueStreamChannel.this.shutdownInput0(paramChannelPromise);
        }
      });
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
          ((AbstractChannel.AbstractUnsafe)AbstractKQueueStreamChannel.this.unsafe()).shutdownOutput(paramChannelPromise);
        }
      });
    }
    return paramChannelPromise;
  }
  
  private final class KQueueSocketWritableByteChannel
    extends SocketWritableByteChannel
  {
    KQueueSocketWritableByteChannel()
    {
      super();
    }
    
    protected ByteBufAllocator alloc()
    {
      return AbstractKQueueStreamChannel.this.alloc();
    }
  }
  
  class KQueueStreamUnsafe
    extends AbstractKQueueChannel.AbstractKQueueUnsafe
  {
    KQueueStreamUnsafe()
    {
      super();
    }
    
    private void handleReadException(ChannelPipeline paramChannelPipeline, ByteBuf paramByteBuf, Throwable paramThrowable, boolean paramBoolean, KQueueRecvByteAllocatorHandle paramKQueueRecvByteAllocatorHandle)
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
      if (!failConnectPromise(paramThrowable))
      {
        paramKQueueRecvByteAllocatorHandle.readComplete();
        paramChannelPipeline.fireChannelReadComplete();
        paramChannelPipeline.fireExceptionCaught(paramThrowable);
        if ((paramBoolean) || ((paramThrowable instanceof IOException))) {
          shutdownInput(false);
        }
      }
    }
    
    protected Executor prepareToClose()
    {
      return super.prepareToClose();
    }
    
    void readReady(KQueueRecvByteAllocatorHandle paramKQueueRecvByteAllocatorHandle)
    {
      localKQueueChannelConfig = AbstractKQueueStreamChannel.this.config();
      if (AbstractKQueueStreamChannel.this.shouldBreakReadReady(localKQueueChannelConfig))
      {
        clearReadFilter0();
        return;
      }
      localChannelPipeline = AbstractKQueueStreamChannel.this.pipeline();
      ByteBufAllocator localByteBufAllocator = localKQueueChannelConfig.getAllocator();
      paramKQueueRecvByteAllocatorHandle.reset(localKQueueChannelConfig);
      readReadyBefore();
      try
      {
        ByteBuf localByteBuf;
        boolean bool1;
        for (;;)
        {
          localByteBuf = paramKQueueRecvByteAllocatorHandle.allocate(localByteBufAllocator);
          try
          {
            paramKQueueRecvByteAllocatorHandle.lastBytesRead(AbstractKQueueStreamChannel.this.doReadBytes(localByteBuf));
            int i = paramKQueueRecvByteAllocatorHandle.lastBytesRead();
            bool1 = true;
            boolean bool2;
            boolean bool3;
            if (i <= 0)
            {
              localByteBuf.release();
              i = paramKQueueRecvByteAllocatorHandle.lastBytesRead();
              if (i >= 0) {
                bool1 = false;
              }
              bool2 = bool1;
              if (!bool1) {
                break label181;
              }
              bool3 = bool1;
            }
            try
            {
              this.readPending = false;
              bool2 = bool1;
              break label181;
              paramKQueueRecvByteAllocatorHandle.incMessagesRead(1);
              this.readPending = false;
              localChannelPipeline.fireChannelRead(localByteBuf);
              if (!AbstractKQueueStreamChannel.this.shouldBreakReadReady(localKQueueChannelConfig))
              {
                bool1 = paramKQueueRecvByteAllocatorHandle.continueReading();
                if (bool1) {
                  continue;
                }
              }
              bool2 = false;
              label181:
              bool3 = bool2;
              paramKQueueRecvByteAllocatorHandle.readComplete();
              bool3 = bool2;
              localChannelPipeline.fireChannelReadComplete();
              if (!bool2) {
                break label257;
              }
              bool3 = bool2;
              shutdownInput(false);
            }
            finally
            {
              localByteBuf = null;
              bool1 = bool3;
              break label245;
            }
            localThrowable = finally;
          }
          finally
          {
            bool1 = false;
          }
        }
        try
        {
          handleReadException(localChannelPipeline, localByteBuf, localThrowable, bool1, paramKQueueRecvByteAllocatorHandle);
          return;
        }
        finally
        {
          readReadyFinally(localKQueueChannelConfig);
        }
      }
      finally
      {
        bool1 = false;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\AbstractKQueueStreamChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */