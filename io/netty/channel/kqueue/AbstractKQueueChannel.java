package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator.ExtendedHandle;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.UnixChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.UnresolvedAddressException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

abstract class AbstractKQueueChannel
  extends AbstractChannel
  implements UnixChannel
{
  private static final ChannelMetadata METADATA = new ChannelMetadata(false);
  protected volatile boolean active;
  private ChannelPromise connectPromise;
  private ScheduledFuture<?> connectTimeoutFuture;
  boolean inputClosedSeenErrorOnRead;
  private volatile SocketAddress local;
  private boolean readFilterEnabled;
  boolean readReadyRunnablePending;
  private volatile SocketAddress remote;
  private SocketAddress requestedRemoteAddress;
  final BsdSocket socket;
  private boolean writeFilterEnabled;
  
  AbstractKQueueChannel(Channel paramChannel, BsdSocket paramBsdSocket, SocketAddress paramSocketAddress)
  {
    super(paramChannel);
    this.socket = ((BsdSocket)ObjectUtil.checkNotNull(paramBsdSocket, "fd"));
    this.active = true;
    this.remote = paramSocketAddress;
    this.local = paramBsdSocket.localAddress();
  }
  
  AbstractKQueueChannel(Channel paramChannel, BsdSocket paramBsdSocket, boolean paramBoolean)
  {
    super(paramChannel);
    this.socket = ((BsdSocket)ObjectUtil.checkNotNull(paramBsdSocket, "fd"));
    this.active = paramBoolean;
    if (paramBoolean)
    {
      this.local = paramBsdSocket.localAddress();
      this.remote = paramBsdSocket.remoteAddress();
    }
  }
  
  protected static void checkResolvable(InetSocketAddress paramInetSocketAddress)
  {
    if (!paramInetSocketAddress.isUnresolved()) {
      return;
    }
    throw new UnresolvedAddressException();
  }
  
  private boolean doConnect0(SocketAddress paramSocketAddress)
    throws Exception
  {
    try
    {
      boolean bool = this.socket.connect(paramSocketAddress);
      if (!bool) {
        writeFilter(true);
      }
      return bool;
    }
    finally
    {
      doClose();
    }
  }
  
  private void evSet(short paramShort1, short paramShort2)
  {
    if (isRegistered()) {
      evSet0(paramShort1, paramShort2);
    }
  }
  
  private void evSet0(short paramShort1, short paramShort2)
  {
    evSet0(paramShort1, paramShort2, 0);
  }
  
  private void evSet0(short paramShort1, short paramShort2, int paramInt)
  {
    if (isOpen()) {
      ((KQueueEventLoop)eventLoop()).evSet(this, paramShort1, paramShort2, paramInt);
    }
  }
  
  private static boolean isAllowHalfClosure(ChannelConfig paramChannelConfig)
  {
    if ((paramChannelConfig instanceof KQueueDomainSocketChannelConfig)) {
      return ((KQueueDomainSocketChannelConfig)paramChannelConfig).isAllowHalfClosure();
    }
    boolean bool;
    if (((paramChannelConfig instanceof SocketChannelConfig)) && (((SocketChannelConfig)paramChannelConfig).isAllowHalfClosure())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean isSoErrorZero(BsdSocket paramBsdSocket)
  {
    try
    {
      int i = paramBsdSocket.getSoError();
      boolean bool;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    catch (IOException paramBsdSocket)
    {
      throw new ChannelException(paramBsdSocket);
    }
  }
  
  private static ByteBuf newDirectBuffer0(Object paramObject, ByteBuf paramByteBuf, ByteBufAllocator paramByteBufAllocator, int paramInt)
  {
    paramByteBufAllocator = paramByteBufAllocator.directBuffer(paramInt);
    paramByteBufAllocator.writeBytes(paramByteBuf, paramByteBuf.readerIndex(), paramInt);
    ReferenceCountUtil.safeRelease(paramObject);
    return paramByteBufAllocator;
  }
  
  final void clearReadFilter()
  {
    if (isRegistered())
    {
      EventLoop localEventLoop = eventLoop();
      final AbstractKQueueUnsafe localAbstractKQueueUnsafe = (AbstractKQueueUnsafe)unsafe();
      if (localEventLoop.inEventLoop()) {
        localAbstractKQueueUnsafe.clearReadFilter0();
      } else {
        localEventLoop.execute(new Runnable()
        {
          public void run()
          {
            if ((!localAbstractKQueueUnsafe.readPending) && (!AbstractKQueueChannel.this.config().isAutoRead())) {
              localAbstractKQueueUnsafe.clearReadFilter0();
            }
          }
        });
      }
    }
    else
    {
      this.readFilterEnabled = false;
    }
  }
  
  public abstract KQueueChannelConfig config();
  
  protected final void doBeginRead()
    throws Exception
  {
    AbstractKQueueUnsafe localAbstractKQueueUnsafe = (AbstractKQueueUnsafe)unsafe();
    localAbstractKQueueUnsafe.readPending = true;
    readFilter(true);
    if (localAbstractKQueueUnsafe.maybeMoreDataToRead) {
      localAbstractKQueueUnsafe.executeReadReadyRunnable(config());
    }
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    if ((paramSocketAddress instanceof InetSocketAddress)) {
      checkResolvable((InetSocketAddress)paramSocketAddress);
    }
    this.socket.bind(paramSocketAddress);
    this.local = this.socket.localAddress();
  }
  
  protected void doClose()
    throws Exception
  {
    this.active = false;
    this.inputClosedSeenErrorOnRead = true;
    this.socket.close();
  }
  
  protected boolean doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    if ((paramSocketAddress2 instanceof InetSocketAddress)) {
      checkResolvable((InetSocketAddress)paramSocketAddress2);
    }
    InetSocketAddress localInetSocketAddress;
    if ((paramSocketAddress1 instanceof InetSocketAddress)) {
      localInetSocketAddress = (InetSocketAddress)paramSocketAddress1;
    } else {
      localInetSocketAddress = null;
    }
    if (localInetSocketAddress != null) {
      checkResolvable(localInetSocketAddress);
    }
    if (this.remote == null)
    {
      if (paramSocketAddress2 != null) {
        this.socket.bind(paramSocketAddress2);
      }
      boolean bool = doConnect0(paramSocketAddress1);
      if (bool)
      {
        if (localInetSocketAddress != null) {
          paramSocketAddress1 = UnixChannelUtil.computeRemoteAddr(localInetSocketAddress, this.socket.remoteAddress());
        }
        this.remote = paramSocketAddress1;
      }
      this.local = this.socket.localAddress();
      return bool;
    }
    throw new AlreadyConnectedException();
  }
  
  protected void doDeregister()
    throws Exception
  {
    ((KQueueEventLoop)eventLoop()).remove(this);
    this.readFilterEnabled = false;
    this.writeFilterEnabled = false;
  }
  
  protected void doDisconnect()
    throws Exception
  {
    doClose();
  }
  
  protected final int doReadBytes(ByteBuf paramByteBuf)
    throws Exception
  {
    int i = paramByteBuf.writerIndex();
    unsafe().recvBufAllocHandle().attemptedBytesRead(paramByteBuf.writableBytes());
    int j;
    if (paramByteBuf.hasMemoryAddress())
    {
      j = this.socket.readAddress(paramByteBuf.memoryAddress(), i, paramByteBuf.capacity());
    }
    else
    {
      ByteBuffer localByteBuffer = paramByteBuf.internalNioBuffer(i, paramByteBuf.writableBytes());
      j = this.socket.read(localByteBuffer, localByteBuffer.position(), localByteBuffer.limit());
    }
    if (j > 0) {
      paramByteBuf.writerIndex(i + j);
    }
    return j;
  }
  
  protected void doRegister()
    throws Exception
  {
    this.readReadyRunnablePending = false;
    ((KQueueEventLoop)eventLoop()).add(this);
    if (this.writeFilterEnabled) {
      evSet0(Native.EVFILT_WRITE, Native.EV_ADD_CLEAR_ENABLE);
    }
    if (this.readFilterEnabled) {
      evSet0(Native.EVFILT_READ, Native.EV_ADD_CLEAR_ENABLE);
    }
    evSet0(Native.EVFILT_SOCK, Native.EV_ADD, Native.NOTE_RDHUP);
  }
  
  protected final int doWriteBytes(ChannelOutboundBuffer paramChannelOutboundBuffer, ByteBuf paramByteBuf)
    throws Exception
  {
    int i;
    if (paramByteBuf.hasMemoryAddress())
    {
      i = this.socket.writeAddress(paramByteBuf.memoryAddress(), paramByteBuf.readerIndex(), paramByteBuf.writerIndex());
      if (i > 0)
      {
        paramChannelOutboundBuffer.removeBytes(i);
        return 1;
      }
    }
    else
    {
      if (paramByteBuf.nioBufferCount() == 1) {
        paramByteBuf = paramByteBuf.internalNioBuffer(paramByteBuf.readerIndex(), paramByteBuf.readableBytes());
      } else {
        paramByteBuf = paramByteBuf.nioBuffer();
      }
      i = this.socket.write(paramByteBuf, paramByteBuf.position(), paramByteBuf.limit());
      if (i > 0)
      {
        paramByteBuf.position(paramByteBuf.position() + i);
        paramChannelOutboundBuffer.removeBytes(i);
        return 1;
      }
    }
    return Integer.MAX_VALUE;
  }
  
  public final FileDescriptor fd()
  {
    return this.socket;
  }
  
  public boolean isActive()
  {
    return this.active;
  }
  
  protected boolean isCompatible(EventLoop paramEventLoop)
  {
    return paramEventLoop instanceof KQueueEventLoop;
  }
  
  public boolean isOpen()
  {
    return this.socket.isOpen();
  }
  
  protected SocketAddress localAddress0()
  {
    return this.local;
  }
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  protected final ByteBuf newDirectBuffer(ByteBuf paramByteBuf)
  {
    return newDirectBuffer(paramByteBuf, paramByteBuf);
  }
  
  protected final ByteBuf newDirectBuffer(Object paramObject, ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    if (i == 0)
    {
      ReferenceCountUtil.release(paramObject);
      return Unpooled.EMPTY_BUFFER;
    }
    ByteBufAllocator localByteBufAllocator = alloc();
    if (localByteBufAllocator.isDirectBufferPooled()) {
      return newDirectBuffer0(paramObject, paramByteBuf, localByteBufAllocator, i);
    }
    ByteBuf localByteBuf = ByteBufUtil.threadLocalDirectBuffer();
    if (localByteBuf == null) {
      return newDirectBuffer0(paramObject, paramByteBuf, localByteBufAllocator, i);
    }
    localByteBuf.writeBytes(paramByteBuf, paramByteBuf.readerIndex(), i);
    ReferenceCountUtil.safeRelease(paramObject);
    return localByteBuf;
  }
  
  protected abstract AbstractKQueueUnsafe newUnsafe();
  
  void readFilter(boolean paramBoolean)
    throws IOException
  {
    if (this.readFilterEnabled != paramBoolean)
    {
      this.readFilterEnabled = paramBoolean;
      short s1 = Native.EVFILT_READ;
      short s2;
      short s3;
      if (paramBoolean)
      {
        s2 = Native.EV_ADD_CLEAR_ENABLE;
        s3 = s2;
      }
      else
      {
        s2 = Native.EV_DELETE_DISABLE;
        s3 = s2;
      }
      evSet(s1, s3);
    }
  }
  
  protected SocketAddress remoteAddress0()
  {
    return this.remote;
  }
  
  void resetCachedAddresses()
  {
    this.local = this.socket.localAddress();
    this.remote = this.socket.remoteAddress();
  }
  
  final boolean shouldBreakReadReady(ChannelConfig paramChannelConfig)
  {
    boolean bool;
    if ((this.socket.isInputShutdown()) && ((this.inputClosedSeenErrorOnRead) || (!isAllowHalfClosure(paramChannelConfig)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void unregisterFilters()
    throws Exception
  {
    readFilter(false);
    writeFilter(false);
    evSet0(Native.EVFILT_SOCK, Native.EV_DELETE, 0);
  }
  
  void writeFilter(boolean paramBoolean)
    throws IOException
  {
    if (this.writeFilterEnabled != paramBoolean)
    {
      this.writeFilterEnabled = paramBoolean;
      short s1 = Native.EVFILT_WRITE;
      short s2;
      short s3;
      if (paramBoolean)
      {
        s2 = Native.EV_ADD_CLEAR_ENABLE;
        s3 = s2;
      }
      else
      {
        s2 = Native.EV_DELETE_DISABLE;
        s3 = s2;
      }
      evSet(s1, s3);
    }
  }
  
  abstract class AbstractKQueueUnsafe
    extends AbstractChannel.AbstractUnsafe
  {
    private KQueueRecvByteAllocatorHandle allocHandle;
    boolean maybeMoreDataToRead;
    boolean readPending;
    private final Runnable readReadyRunnable = new Runnable()
    {
      public void run()
      {
        AbstractKQueueChannel.AbstractKQueueUnsafe localAbstractKQueueUnsafe = AbstractKQueueChannel.AbstractKQueueUnsafe.this;
        localAbstractKQueueUnsafe.this$0.readReadyRunnablePending = false;
        localAbstractKQueueUnsafe.readReady(localAbstractKQueueUnsafe.recvBufAllocHandle());
      }
    };
    
    AbstractKQueueUnsafe()
    {
      super();
    }
    
    private boolean doFinishConnect()
      throws Exception
    {
      if (AbstractKQueueChannel.this.socket.finishConnect())
      {
        AbstractKQueueChannel.this.writeFilter(false);
        if ((AbstractKQueueChannel.this.requestedRemoteAddress instanceof InetSocketAddress))
        {
          AbstractKQueueChannel localAbstractKQueueChannel = AbstractKQueueChannel.this;
          AbstractKQueueChannel.access$502(localAbstractKQueueChannel, UnixChannelUtil.computeRemoteAddr((InetSocketAddress)localAbstractKQueueChannel.requestedRemoteAddress, AbstractKQueueChannel.this.socket.remoteAddress()));
        }
        AbstractKQueueChannel.access$302(AbstractKQueueChannel.this, null);
        return true;
      }
      AbstractKQueueChannel.this.writeFilter(true);
      return false;
    }
    
    private void finishConnect()
    {
      for (;;)
      {
        try
        {
          boolean bool = AbstractKQueueChannel.this.isActive();
          if (!doFinishConnect()) {
            return;
          }
          fulfillConnectPromise(AbstractKQueueChannel.this.connectPromise, bool);
          if (AbstractKQueueChannel.this.connectTimeoutFuture != null) {
            AbstractKQueueChannel.this.connectTimeoutFuture.cancel(false);
          }
          AbstractKQueueChannel.access$002(AbstractKQueueChannel.this, null);
        }
        finally {}
        try
        {
          fulfillConnectPromise(AbstractKQueueChannel.this.connectPromise, annotateConnectException(localThrowable, AbstractKQueueChannel.this.requestedRemoteAddress));
          if (AbstractKQueueChannel.this.connectTimeoutFuture != null) {}
        }
        finally
        {
          if (AbstractKQueueChannel.this.connectTimeoutFuture == null) {
            break label127;
          }
          AbstractKQueueChannel.this.connectTimeoutFuture.cancel(false);
          label127:
          AbstractKQueueChannel.access$002(AbstractKQueueChannel.this, null);
        }
      }
    }
    
    private void fireEventAndClose(Object paramObject)
    {
      AbstractKQueueChannel.this.pipeline().fireUserEventTriggered(paramObject);
      close(voidPromise());
    }
    
    private void fulfillConnectPromise(ChannelPromise paramChannelPromise, Throwable paramThrowable)
    {
      if (paramChannelPromise == null) {
        return;
      }
      paramChannelPromise.tryFailure(paramThrowable);
      closeIfClosed();
    }
    
    private void fulfillConnectPromise(ChannelPromise paramChannelPromise, boolean paramBoolean)
    {
      if (paramChannelPromise == null) {
        return;
      }
      AbstractKQueueChannel.this.active = true;
      boolean bool1 = AbstractKQueueChannel.this.isActive();
      boolean bool2 = paramChannelPromise.trySuccess();
      if ((!paramBoolean) && (bool1)) {
        AbstractKQueueChannel.this.pipeline().fireChannelActive();
      }
      if (!bool2) {
        close(voidPromise());
      }
    }
    
    protected final void clearReadFilter0()
    {
      try
      {
        this.readPending = false;
        AbstractKQueueChannel.this.readFilter(false);
      }
      catch (IOException localIOException)
      {
        AbstractKQueueChannel.this.pipeline().fireExceptionCaught(localIOException);
        AbstractKQueueChannel.this.unsafe().close(AbstractKQueueChannel.this.unsafe().voidPromise());
      }
    }
    
    public void connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    {
      if ((paramChannelPromise.setUncancellable()) && (ensureOpen(paramChannelPromise))) {
        try
        {
          if (AbstractKQueueChannel.this.connectPromise == null)
          {
            boolean bool = AbstractKQueueChannel.this.isActive();
            if (AbstractKQueueChannel.this.doConnect(paramSocketAddress1, paramSocketAddress2))
            {
              fulfillConnectPromise(paramChannelPromise, bool);
            }
            else
            {
              AbstractKQueueChannel.access$002(AbstractKQueueChannel.this, paramChannelPromise);
              AbstractKQueueChannel.access$302(AbstractKQueueChannel.this, paramSocketAddress1);
              int i = AbstractKQueueChannel.this.config().getConnectTimeoutMillis();
              if (i > 0)
              {
                AbstractKQueueChannel localAbstractKQueueChannel = AbstractKQueueChannel.this;
                paramSocketAddress2 = localAbstractKQueueChannel.eventLoop();
                Runnable local2 = new io/netty/channel/kqueue/AbstractKQueueChannel$AbstractKQueueUnsafe$2;
                local2.<init>(this, paramSocketAddress1);
                AbstractKQueueChannel.access$402(localAbstractKQueueChannel, paramSocketAddress2.schedule(local2, i, TimeUnit.MILLISECONDS));
              }
              paramSocketAddress2 = new io/netty/channel/kqueue/AbstractKQueueChannel$AbstractKQueueUnsafe$3;
              paramSocketAddress2.<init>(this);
              paramChannelPromise.addListener(paramSocketAddress2);
            }
          }
          else
          {
            paramSocketAddress2 = new java/nio/channels/ConnectionPendingException;
            paramSocketAddress2.<init>();
            throw paramSocketAddress2;
          }
        }
        finally
        {
          closeIfClosed();
          paramChannelPromise.tryFailure(annotateConnectException(paramSocketAddress2, paramSocketAddress1));
        }
      }
    }
    
    final void executeReadReadyRunnable(ChannelConfig paramChannelConfig)
    {
      AbstractKQueueChannel localAbstractKQueueChannel = AbstractKQueueChannel.this;
      if ((!localAbstractKQueueChannel.readReadyRunnablePending) && (localAbstractKQueueChannel.isActive()) && (!AbstractKQueueChannel.this.shouldBreakReadReady(paramChannelConfig)))
      {
        paramChannelConfig = AbstractKQueueChannel.this;
        paramChannelConfig.readReadyRunnablePending = true;
        paramChannelConfig.eventLoop().execute(this.readReadyRunnable);
      }
    }
    
    final boolean failConnectPromise(Throwable paramThrowable)
    {
      if (AbstractKQueueChannel.this.connectPromise != null)
      {
        ChannelPromise localChannelPromise = AbstractKQueueChannel.this.connectPromise;
        AbstractKQueueChannel.access$002(AbstractKQueueChannel.this, null);
        if (!(paramThrowable instanceof ConnectException)) {
          paramThrowable = new ConnectException("failed to connect").initCause(paramThrowable);
        }
        if (localChannelPromise.tryFailure(paramThrowable))
        {
          closeIfClosed();
          return true;
        }
      }
      return false;
    }
    
    protected final void flush0()
    {
      if (!AbstractKQueueChannel.this.writeFilterEnabled) {
        super.flush0();
      }
    }
    
    final void readEOF()
    {
      KQueueRecvByteAllocatorHandle localKQueueRecvByteAllocatorHandle = recvBufAllocHandle();
      localKQueueRecvByteAllocatorHandle.readEOF();
      if (AbstractKQueueChannel.this.isActive()) {
        readReady(localKQueueRecvByteAllocatorHandle);
      } else {
        shutdownInput(true);
      }
    }
    
    final void readReady(long paramLong)
    {
      KQueueRecvByteAllocatorHandle localKQueueRecvByteAllocatorHandle = recvBufAllocHandle();
      localKQueueRecvByteAllocatorHandle.numberBytesPending(paramLong);
      readReady(localKQueueRecvByteAllocatorHandle);
    }
    
    abstract void readReady(KQueueRecvByteAllocatorHandle paramKQueueRecvByteAllocatorHandle);
    
    final void readReadyBefore()
    {
      this.maybeMoreDataToRead = false;
    }
    
    final void readReadyFinally(ChannelConfig paramChannelConfig)
    {
      this.maybeMoreDataToRead = this.allocHandle.maybeMoreDataToRead();
      if (!this.allocHandle.isReadEOF())
      {
        boolean bool = this.readPending;
        if ((!bool) || (!this.maybeMoreDataToRead))
        {
          if ((bool) || (paramChannelConfig.isAutoRead())) {
            return;
          }
          clearReadFilter0();
          return;
        }
      }
      executeReadReadyRunnable(paramChannelConfig);
    }
    
    public KQueueRecvByteAllocatorHandle recvBufAllocHandle()
    {
      if (this.allocHandle == null) {
        this.allocHandle = new KQueueRecvByteAllocatorHandle((RecvByteBufAllocator.ExtendedHandle)super.recvBufAllocHandle());
      }
      return this.allocHandle;
    }
    
    void shutdownInput(boolean paramBoolean)
    {
      if ((paramBoolean) && (AbstractKQueueChannel.this.connectPromise != null)) {
        finishConnect();
      }
      if ((AbstractKQueueChannel.this.socket.isInputShutdown()) || (AbstractKQueueChannel.isAllowHalfClosure(AbstractKQueueChannel.this.config()))) {}
      try
      {
        try
        {
          AbstractKQueueChannel.this.socket.shutdown(true, false);
          AbstractKQueueChannel.this.pipeline().fireUserEventTriggered(ChannelInputShutdownEvent.INSTANCE);
        }
        catch (IOException localIOException)
        {
          fireEventAndClose(ChannelInputShutdownEvent.INSTANCE);
          return;
        }
        close(voidPromise());
        break label122;
        if (!paramBoolean)
        {
          AbstractKQueueChannel localAbstractKQueueChannel = AbstractKQueueChannel.this;
          localAbstractKQueueChannel.inputClosedSeenErrorOnRead = true;
          localAbstractKQueueChannel.pipeline().fireUserEventTriggered(ChannelInputShutdownReadComplete.INSTANCE);
        }
        label122:
        return;
      }
      catch (NotYetConnectedException localNotYetConnectedException)
      {
        for (;;) {}
      }
    }
    
    final void writeReady()
    {
      if (AbstractKQueueChannel.this.connectPromise != null) {
        finishConnect();
      } else if (!AbstractKQueueChannel.this.socket.isOutputShutdown()) {
        super.flush0();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\AbstractKQueueChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */