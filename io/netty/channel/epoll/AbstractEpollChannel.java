package io.netty.channel.epoll;

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
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.UnresolvedAddressException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

abstract class AbstractEpollChannel
  extends AbstractChannel
  implements UnixChannel
{
  private static final ChannelMetadata METADATA = new ChannelMetadata(false);
  protected volatile boolean active;
  private ChannelPromise connectPromise;
  private ScheduledFuture<?> connectTimeoutFuture;
  boolean epollInReadyRunnablePending;
  protected int flags = Native.EPOLLET;
  boolean inputClosedSeenErrorOnRead;
  private volatile SocketAddress local;
  private volatile SocketAddress remote;
  private SocketAddress requestedRemoteAddress;
  final LinuxSocket socket;
  
  AbstractEpollChannel(Channel paramChannel, LinuxSocket paramLinuxSocket, SocketAddress paramSocketAddress)
  {
    super(paramChannel);
    this.socket = ((LinuxSocket)ObjectUtil.checkNotNull(paramLinuxSocket, "fd"));
    this.active = true;
    this.remote = paramSocketAddress;
    this.local = paramLinuxSocket.localAddress();
  }
  
  AbstractEpollChannel(Channel paramChannel, LinuxSocket paramLinuxSocket, boolean paramBoolean)
  {
    super(paramChannel);
    this.socket = ((LinuxSocket)ObjectUtil.checkNotNull(paramLinuxSocket, "fd"));
    this.active = paramBoolean;
    if (paramBoolean)
    {
      this.local = paramLinuxSocket.localAddress();
      this.remote = paramLinuxSocket.remoteAddress();
    }
  }
  
  AbstractEpollChannel(LinuxSocket paramLinuxSocket)
  {
    this(null, paramLinuxSocket, false);
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
        setFlag(Native.EPOLLOUT);
      }
      return bool;
    }
    finally
    {
      doClose();
    }
  }
  
  private static boolean isAllowHalfClosure(ChannelConfig paramChannelConfig)
  {
    if ((paramChannelConfig instanceof EpollDomainSocketChannelConfig)) {
      return ((EpollDomainSocketChannelConfig)paramChannelConfig).isAllowHalfClosure();
    }
    boolean bool;
    if (((paramChannelConfig instanceof SocketChannelConfig)) && (((SocketChannelConfig)paramChannelConfig).isAllowHalfClosure())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean isSoErrorZero(Socket paramSocket)
  {
    try
    {
      int i = paramSocket.getSoError();
      boolean bool;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    catch (IOException paramSocket)
    {
      throw new ChannelException(paramSocket);
    }
  }
  
  private void modifyEvents()
    throws IOException
  {
    if ((isOpen()) && (isRegistered())) {
      ((EpollEventLoop)eventLoop()).modify(this);
    }
  }
  
  private static ByteBuf newDirectBuffer0(Object paramObject, ByteBuf paramByteBuf, ByteBufAllocator paramByteBufAllocator, int paramInt)
  {
    paramByteBufAllocator = paramByteBufAllocator.directBuffer(paramInt);
    paramByteBufAllocator.writeBytes(paramByteBuf, paramByteBuf.readerIndex(), paramInt);
    ReferenceCountUtil.safeRelease(paramObject);
    return paramByteBufAllocator;
  }
  
  final void clearEpollIn()
  {
    if (isRegistered())
    {
      EventLoop localEventLoop = eventLoop();
      final AbstractEpollUnsafe localAbstractEpollUnsafe = (AbstractEpollUnsafe)unsafe();
      if (localEventLoop.inEventLoop()) {
        localAbstractEpollUnsafe.clearEpollIn0();
      } else {
        localEventLoop.execute(new Runnable()
        {
          public void run()
          {
            if ((!localAbstractEpollUnsafe.readPending) && (!AbstractEpollChannel.this.config().isAutoRead())) {
              localAbstractEpollUnsafe.clearEpollIn0();
            }
          }
        });
      }
    }
    else
    {
      this.flags &= (Native.EPOLLIN ^ 0xFFFFFFFF);
    }
  }
  
  void clearFlag(int paramInt)
    throws IOException
  {
    if (isFlagSet(paramInt))
    {
      this.flags = ((paramInt ^ 0xFFFFFFFF) & this.flags);
      modifyEvents();
    }
  }
  
  public abstract EpollChannelConfig config();
  
  protected final void doBeginRead()
    throws Exception
  {
    AbstractEpollUnsafe localAbstractEpollUnsafe = (AbstractEpollUnsafe)unsafe();
    localAbstractEpollUnsafe.readPending = true;
    setFlag(Native.EPOLLIN);
    if (localAbstractEpollUnsafe.maybeMoreDataToRead) {
      localAbstractEpollUnsafe.executeEpollInReadyRunnable(config());
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
    try
    {
      Object localObject1 = this.connectPromise;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = new java/nio/channels/ClosedChannelException;
        ((ClosedChannelException)localObject3).<init>();
        ((Promise)localObject1).tryFailure((Throwable)localObject3);
        this.connectPromise = null;
      }
      localObject1 = this.connectTimeoutFuture;
      if (localObject1 != null)
      {
        ((ScheduledFuture)localObject1).cancel(false);
        this.connectTimeoutFuture = null;
      }
      if (isRegistered())
      {
        localObject3 = eventLoop();
        if (((EventExecutor)localObject3).inEventLoop())
        {
          doDeregister();
        }
        else
        {
          localObject1 = new io/netty/channel/epoll/AbstractEpollChannel$1;
          ((1)localObject1).<init>(this);
          ((ScheduledExecutorService)localObject3).execute((Runnable)localObject1);
        }
      }
      return;
    }
    finally
    {
      this.socket.close();
    }
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
    ((EpollEventLoop)eventLoop()).remove(this);
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
    this.epollInReadyRunnablePending = false;
    ((EpollEventLoop)eventLoop()).add(this);
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
    return paramEventLoop instanceof EpollEventLoop;
  }
  
  boolean isFlagSet(int paramInt)
  {
    boolean bool;
    if ((paramInt & this.flags) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
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
  
  protected abstract AbstractEpollUnsafe newUnsafe();
  
  protected SocketAddress remoteAddress0()
  {
    return this.remote;
  }
  
  void resetCachedAddresses()
  {
    this.local = this.socket.localAddress();
    this.remote = this.socket.remoteAddress();
  }
  
  void setFlag(int paramInt)
    throws IOException
  {
    if (!isFlagSet(paramInt))
    {
      this.flags = (paramInt | this.flags);
      modifyEvents();
    }
  }
  
  final boolean shouldBreakEpollInReady(ChannelConfig paramChannelConfig)
  {
    boolean bool;
    if ((this.socket.isInputShutdown()) && ((this.inputClosedSeenErrorOnRead) || (!isAllowHalfClosure(paramChannelConfig)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected abstract class AbstractEpollUnsafe
    extends AbstractChannel.AbstractUnsafe
  {
    private EpollRecvByteAllocatorHandle allocHandle;
    private final Runnable epollInReadyRunnable = new Runnable()
    {
      public void run()
      {
        AbstractEpollChannel.AbstractEpollUnsafe localAbstractEpollUnsafe = AbstractEpollChannel.AbstractEpollUnsafe.this;
        localAbstractEpollUnsafe.this$0.epollInReadyRunnablePending = false;
        localAbstractEpollUnsafe.epollInReady();
      }
    };
    boolean maybeMoreDataToRead;
    boolean readPending;
    
    protected AbstractEpollUnsafe()
    {
      super();
    }
    
    private void clearEpollRdHup()
    {
      try
      {
        AbstractEpollChannel.this.clearFlag(Native.EPOLLRDHUP);
      }
      catch (IOException localIOException)
      {
        AbstractEpollChannel.this.pipeline().fireExceptionCaught(localIOException);
        close(voidPromise());
      }
    }
    
    private boolean doFinishConnect()
      throws Exception
    {
      if (AbstractEpollChannel.this.socket.finishConnect())
      {
        AbstractEpollChannel.this.clearFlag(Native.EPOLLOUT);
        if ((AbstractEpollChannel.this.requestedRemoteAddress instanceof InetSocketAddress))
        {
          AbstractEpollChannel localAbstractEpollChannel = AbstractEpollChannel.this;
          AbstractEpollChannel.access$402(localAbstractEpollChannel, UnixChannelUtil.computeRemoteAddr((InetSocketAddress)localAbstractEpollChannel.requestedRemoteAddress, AbstractEpollChannel.this.socket.remoteAddress()));
        }
        AbstractEpollChannel.access$202(AbstractEpollChannel.this, null);
        return true;
      }
      AbstractEpollChannel.this.setFlag(Native.EPOLLOUT);
      return false;
    }
    
    private void finishConnect()
    {
      for (;;)
      {
        try
        {
          boolean bool = AbstractEpollChannel.this.isActive();
          if (!doFinishConnect()) {
            return;
          }
          fulfillConnectPromise(AbstractEpollChannel.this.connectPromise, bool);
          if (AbstractEpollChannel.this.connectTimeoutFuture != null) {
            AbstractEpollChannel.this.connectTimeoutFuture.cancel(false);
          }
          AbstractEpollChannel.access$102(AbstractEpollChannel.this, null);
        }
        finally {}
        try
        {
          fulfillConnectPromise(AbstractEpollChannel.this.connectPromise, annotateConnectException(localThrowable, AbstractEpollChannel.this.requestedRemoteAddress));
          if (AbstractEpollChannel.this.connectTimeoutFuture != null) {}
        }
        finally
        {
          if (AbstractEpollChannel.this.connectTimeoutFuture == null) {
            break label127;
          }
          AbstractEpollChannel.this.connectTimeoutFuture.cancel(false);
          label127:
          AbstractEpollChannel.access$102(AbstractEpollChannel.this, null);
        }
      }
    }
    
    private void fireEventAndClose(Object paramObject)
    {
      AbstractEpollChannel.this.pipeline().fireUserEventTriggered(paramObject);
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
      AbstractEpollChannel.this.active = true;
      boolean bool1 = AbstractEpollChannel.this.isActive();
      boolean bool2 = paramChannelPromise.trySuccess();
      if ((!paramBoolean) && (bool1)) {
        AbstractEpollChannel.this.pipeline().fireChannelActive();
      }
      if (!bool2) {
        close(voidPromise());
      }
    }
    
    protected final void clearEpollIn0()
    {
      try
      {
        this.readPending = false;
        AbstractEpollChannel.this.clearFlag(Native.EPOLLIN);
      }
      catch (IOException localIOException)
      {
        AbstractEpollChannel.this.pipeline().fireExceptionCaught(localIOException);
        AbstractEpollChannel.this.unsafe().close(AbstractEpollChannel.this.unsafe().voidPromise());
      }
    }
    
    public void connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    {
      if ((paramChannelPromise.setUncancellable()) && (ensureOpen(paramChannelPromise))) {
        try
        {
          if (AbstractEpollChannel.this.connectPromise == null)
          {
            boolean bool = AbstractEpollChannel.this.isActive();
            if (AbstractEpollChannel.this.doConnect(paramSocketAddress1, paramSocketAddress2))
            {
              fulfillConnectPromise(paramChannelPromise, bool);
            }
            else
            {
              AbstractEpollChannel.access$102(AbstractEpollChannel.this, paramChannelPromise);
              AbstractEpollChannel.access$202(AbstractEpollChannel.this, paramSocketAddress1);
              int i = AbstractEpollChannel.this.config().getConnectTimeoutMillis();
              if (i > 0)
              {
                AbstractEpollChannel localAbstractEpollChannel = AbstractEpollChannel.this;
                paramSocketAddress2 = localAbstractEpollChannel.eventLoop();
                Runnable local2 = new io/netty/channel/epoll/AbstractEpollChannel$AbstractEpollUnsafe$2;
                local2.<init>(this, paramSocketAddress1);
                AbstractEpollChannel.access$302(localAbstractEpollChannel, paramSocketAddress2.schedule(local2, i, TimeUnit.MILLISECONDS));
              }
              paramSocketAddress2 = new io/netty/channel/epoll/AbstractEpollChannel$AbstractEpollUnsafe$3;
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
    
    final void epollInBefore()
    {
      this.maybeMoreDataToRead = false;
    }
    
    final void epollInFinally(ChannelConfig paramChannelConfig)
    {
      this.maybeMoreDataToRead = this.allocHandle.maybeMoreDataToRead();
      if (!this.allocHandle.isReceivedRdHup())
      {
        boolean bool = this.readPending;
        if ((!bool) || (!this.maybeMoreDataToRead))
        {
          if ((bool) || (paramChannelConfig.isAutoRead())) {
            return;
          }
          AbstractEpollChannel.this.clearEpollIn();
          return;
        }
      }
      executeEpollInReadyRunnable(paramChannelConfig);
    }
    
    abstract void epollInReady();
    
    final void epollOutReady()
    {
      if (AbstractEpollChannel.this.connectPromise != null) {
        finishConnect();
      } else if (!AbstractEpollChannel.this.socket.isOutputShutdown()) {
        super.flush0();
      }
    }
    
    final void epollRdHupReady()
    {
      recvBufAllocHandle().receivedRdHup();
      if (AbstractEpollChannel.this.isActive()) {
        epollInReady();
      } else {
        shutdownInput(true);
      }
      clearEpollRdHup();
    }
    
    final void executeEpollInReadyRunnable(ChannelConfig paramChannelConfig)
    {
      AbstractEpollChannel localAbstractEpollChannel = AbstractEpollChannel.this;
      if ((!localAbstractEpollChannel.epollInReadyRunnablePending) && (localAbstractEpollChannel.isActive()) && (!AbstractEpollChannel.this.shouldBreakEpollInReady(paramChannelConfig)))
      {
        paramChannelConfig = AbstractEpollChannel.this;
        paramChannelConfig.epollInReadyRunnablePending = true;
        paramChannelConfig.eventLoop().execute(this.epollInReadyRunnable);
      }
    }
    
    protected final void flush0()
    {
      if (!AbstractEpollChannel.this.isFlagSet(Native.EPOLLOUT)) {
        super.flush0();
      }
    }
    
    EpollRecvByteAllocatorHandle newEpollHandle(RecvByteBufAllocator.ExtendedHandle paramExtendedHandle)
    {
      return new EpollRecvByteAllocatorHandle(paramExtendedHandle);
    }
    
    public EpollRecvByteAllocatorHandle recvBufAllocHandle()
    {
      if (this.allocHandle == null) {
        this.allocHandle = newEpollHandle((RecvByteBufAllocator.ExtendedHandle)super.recvBufAllocHandle());
      }
      return this.allocHandle;
    }
    
    void shutdownInput(boolean paramBoolean)
    {
      if ((AbstractEpollChannel.this.socket.isInputShutdown()) || (AbstractEpollChannel.isAllowHalfClosure(AbstractEpollChannel.this.config()))) {}
      try
      {
        try
        {
          AbstractEpollChannel.this.socket.shutdown(true, false);
          AbstractEpollChannel.this.clearEpollIn();
          AbstractEpollChannel.this.pipeline().fireUserEventTriggered(ChannelInputShutdownEvent.INSTANCE);
        }
        catch (IOException localIOException)
        {
          fireEventAndClose(ChannelInputShutdownEvent.INSTANCE);
          return;
        }
        close(voidPromise());
        break label111;
        if (!paramBoolean)
        {
          AbstractEpollChannel localAbstractEpollChannel = AbstractEpollChannel.this;
          localAbstractEpollChannel.inputClosedSeenErrorOnRead = true;
          localAbstractEpollChannel.pipeline().fireUserEventTriggered(ChannelInputShutdownReadComplete.INSTANCE);
        }
        label111:
        return;
      }
      catch (NotYetConnectedException localNotYetConnectedException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\AbstractEpollChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */