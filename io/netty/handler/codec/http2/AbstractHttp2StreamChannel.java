package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.DefaultChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.MessageSizeEstimator.Handle;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator.ExtendedHandle;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.VoidChannelPromise;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

abstract class AbstractHttp2StreamChannel
  extends DefaultAttributeMap
  implements Http2StreamChannel
{
  private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
  private static final int MIN_HTTP2_FRAME_SIZE = 9;
  private static final AtomicLongFieldUpdater<AbstractHttp2StreamChannel> TOTAL_PENDING_SIZE_UPDATER = AtomicLongFieldUpdater.newUpdater(AbstractHttp2StreamChannel.class, "totalPendingSize");
  private static final AtomicIntegerFieldUpdater<AbstractHttp2StreamChannel> UNWRITABLE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractHttp2StreamChannel.class, "unwritable");
  static final Http2FrameStreamVisitor WRITABLE_VISITOR = new Http2FrameStreamVisitor()
  {
    public boolean visit(Http2FrameStream paramAnonymousHttp2FrameStream)
    {
      ((AbstractHttp2StreamChannel)((Http2FrameCodec.DefaultHttp2FrameStream)paramAnonymousHttp2FrameStream).attachment).trySetWritable();
      return true;
    }
  };
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractHttp2StreamChannel.class);
  private final ChannelId channelId;
  private final ChannelPromise closePromise;
  private final Http2StreamChannelConfig config = new Http2StreamChannelConfig(this);
  private Runnable fireChannelWritabilityChangedTask;
  private boolean firstFrameWritten;
  private int flowControlledBytes;
  private Queue<Object> inboundBuffer;
  private boolean outboundClosed;
  private final ChannelPipeline pipeline;
  private boolean readCompletePending;
  private ReadStatus readStatus = ReadStatus.IDLE;
  private volatile boolean registered;
  private final Http2FrameCodec.DefaultHttp2FrameStream stream;
  private volatile long totalPendingSize;
  private final Http2ChannelUnsafe unsafe = new Http2ChannelUnsafe(null);
  private volatile int unwritable;
  private final ChannelFutureListener windowUpdateFrameWriteListener = new ChannelFutureListener()
  {
    public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
    {
      AbstractHttp2StreamChannel.windowUpdateFrameWriteComplete(paramAnonymousChannelFuture, AbstractHttp2StreamChannel.this);
    }
  };
  
  AbstractHttp2StreamChannel(Http2FrameCodec.DefaultHttp2FrameStream paramDefaultHttp2FrameStream, int paramInt, ChannelHandler paramChannelHandler)
  {
    this.stream = paramDefaultHttp2FrameStream;
    paramDefaultHttp2FrameStream.attachment = this;
    paramDefaultHttp2FrameStream = new DefaultChannelPipeline(this)
    {
      protected void decrementPendingOutboundBytes(long paramAnonymousLong)
      {
        AbstractHttp2StreamChannel.this.decrementPendingOutboundBytes(paramAnonymousLong, true);
      }
      
      protected void incrementPendingOutboundBytes(long paramAnonymousLong)
      {
        AbstractHttp2StreamChannel.this.incrementPendingOutboundBytes(paramAnonymousLong, true);
      }
    };
    this.pipeline = paramDefaultHttp2FrameStream;
    this.closePromise = paramDefaultHttp2FrameStream.newPromise();
    this.channelId = new Http2StreamChannelId(parent().id(), paramInt);
    if (paramChannelHandler != null) {
      paramDefaultHttp2FrameStream.addLast(new ChannelHandler[] { paramChannelHandler });
    }
  }
  
  private void decrementPendingOutboundBytes(long paramLong, boolean paramBoolean)
  {
    if (paramLong == 0L) {
      return;
    }
    if ((TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -paramLong) < config().getWriteBufferLowWaterMark()) && (parent().isWritable())) {
      setWritable(paramBoolean);
    }
  }
  
  private void fireChannelWritabilityChanged(boolean paramBoolean)
  {
    final ChannelPipeline localChannelPipeline = pipeline();
    if (paramBoolean)
    {
      Runnable localRunnable = this.fireChannelWritabilityChangedTask;
      Object localObject = localRunnable;
      if (localRunnable == null)
      {
        localObject = new Runnable()
        {
          public void run()
          {
            localChannelPipeline.fireChannelWritabilityChanged();
          }
        };
        this.fireChannelWritabilityChangedTask = ((Runnable)localObject);
      }
      eventLoop().execute((Runnable)localObject);
    }
    else
    {
      localChannelPipeline.fireChannelWritabilityChanged();
    }
  }
  
  private void incrementPendingOutboundBytes(long paramLong, boolean paramBoolean)
  {
    if (paramLong == 0L) {
      return;
    }
    if (TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, paramLong) > config().getWriteBufferHighWaterMark()) {
      setUnwritable(paramBoolean);
    }
  }
  
  private void maybeAddChannelToReadCompletePendingQueue()
  {
    if (!this.readCompletePending)
    {
      this.readCompletePending = true;
      addChannelToReadCompletePendingQueue();
    }
  }
  
  private void setUnwritable(boolean paramBoolean)
  {
    int i;
    int j;
    do
    {
      i = this.unwritable;
      j = i | 0x1;
    } while (!UNWRITABLE_UPDATER.compareAndSet(this, i, j));
    if ((i == 0) && (j != 0)) {
      fireChannelWritabilityChanged(paramBoolean);
    }
  }
  
  private void setWritable(boolean paramBoolean)
  {
    int i;
    int j;
    do
    {
      i = this.unwritable;
      j = i & 0xFFFFFFFE;
    } while (!UNWRITABLE_UPDATER.compareAndSet(this, i, j));
    if ((i != 0) && (j == 0)) {
      fireChannelWritabilityChanged(paramBoolean);
    }
  }
  
  private static void windowUpdateFrameWriteComplete(ChannelFuture paramChannelFuture, Channel paramChannel)
  {
    Throwable localThrowable1 = paramChannelFuture.cause();
    if (localThrowable1 != null)
    {
      paramChannelFuture = localThrowable1;
      if ((localThrowable1 instanceof Http2FrameStreamException))
      {
        Throwable localThrowable2 = localThrowable1.getCause();
        paramChannelFuture = localThrowable1;
        if (localThrowable2 != null) {
          paramChannelFuture = localThrowable2;
        }
      }
      paramChannel.pipeline().fireExceptionCaught(paramChannelFuture);
      paramChannel.unsafe().close(paramChannel.unsafe().voidPromise());
    }
  }
  
  protected abstract void addChannelToReadCompletePendingQueue();
  
  public ByteBufAllocator alloc()
  {
    return config().getAllocator();
  }
  
  public ChannelFuture bind(SocketAddress paramSocketAddress)
  {
    return pipeline().bind(paramSocketAddress);
  }
  
  public ChannelFuture bind(SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
  {
    return pipeline().bind(paramSocketAddress, paramChannelPromise);
  }
  
  public long bytesBeforeUnwritable()
  {
    long l = config().getWriteBufferHighWaterMark() - this.totalPendingSize;
    if (l > 0L)
    {
      if (!isWritable()) {
        l = 0L;
      }
      return l;
    }
    return 0L;
  }
  
  public long bytesBeforeWritable()
  {
    long l = this.totalPendingSize - config().getWriteBufferLowWaterMark();
    if (l > 0L)
    {
      if (isWritable()) {
        l = 0L;
      }
      return l;
    }
    return 0L;
  }
  
  public ChannelFuture close()
  {
    return pipeline().close();
  }
  
  public ChannelFuture close(ChannelPromise paramChannelPromise)
  {
    return pipeline().close(paramChannelPromise);
  }
  
  public ChannelFuture closeFuture()
  {
    return this.closePromise;
  }
  
  void closeOutbound()
  {
    this.outboundClosed = true;
  }
  
  public int compareTo(Channel paramChannel)
  {
    if (this == paramChannel) {
      return 0;
    }
    return id().compareTo(paramChannel.id());
  }
  
  public ChannelConfig config()
  {
    return this.config;
  }
  
  public ChannelFuture connect(SocketAddress paramSocketAddress)
  {
    return pipeline().connect(paramSocketAddress);
  }
  
  public ChannelFuture connect(SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
  {
    return pipeline().connect(paramSocketAddress, paramChannelPromise);
  }
  
  public ChannelFuture connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
  {
    return pipeline().connect(paramSocketAddress1, paramSocketAddress2);
  }
  
  public ChannelFuture connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
  {
    return pipeline().connect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
  }
  
  public ChannelFuture deregister()
  {
    return pipeline().deregister();
  }
  
  public ChannelFuture deregister(ChannelPromise paramChannelPromise)
  {
    return pipeline().deregister(paramChannelPromise);
  }
  
  public ChannelFuture disconnect()
  {
    return pipeline().disconnect();
  }
  
  public ChannelFuture disconnect(ChannelPromise paramChannelPromise)
  {
    return pipeline().disconnect(paramChannelPromise);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public EventLoop eventLoop()
  {
    return parent().eventLoop();
  }
  
  void fireChildRead(Http2Frame paramHttp2Frame)
  {
    if (!isActive())
    {
      ReferenceCountUtil.release(paramHttp2Frame);
    }
    else if (this.readStatus != ReadStatus.IDLE)
    {
      RecvByteBufAllocator.Handle localHandle = this.unsafe.recvBufAllocHandle();
      this.unsafe.doRead0(paramHttp2Frame, localHandle);
      if (localHandle.continueReading()) {
        maybeAddChannelToReadCompletePendingQueue();
      } else {
        this.unsafe.notifyReadComplete(localHandle, true);
      }
    }
    else
    {
      if (this.inboundBuffer == null) {
        this.inboundBuffer = new ArrayDeque(4);
      }
      this.inboundBuffer.add(paramHttp2Frame);
    }
  }
  
  void fireChildReadComplete()
  {
    Http2ChannelUnsafe localHttp2ChannelUnsafe = this.unsafe;
    localHttp2ChannelUnsafe.notifyReadComplete(localHttp2ChannelUnsafe.recvBufAllocHandle(), false);
  }
  
  public Channel flush()
  {
    pipeline().flush();
    return this;
  }
  
  protected void flush0(ChannelHandlerContext paramChannelHandlerContext)
  {
    paramChannelHandlerContext.flush();
  }
  
  public int hashCode()
  {
    return id().hashCode();
  }
  
  public ChannelId id()
  {
    return this.channelId;
  }
  
  public boolean isActive()
  {
    return isOpen();
  }
  
  public boolean isOpen()
  {
    return this.closePromise.isDone() ^ true;
  }
  
  protected abstract boolean isParentReadInProgress();
  
  public boolean isRegistered()
  {
    return this.registered;
  }
  
  public boolean isWritable()
  {
    boolean bool;
    if (this.unwritable == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public SocketAddress localAddress()
  {
    return parent().localAddress();
  }
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  public ChannelFuture newFailedFuture(Throwable paramThrowable)
  {
    return pipeline().newFailedFuture(paramThrowable);
  }
  
  public ChannelProgressivePromise newProgressivePromise()
  {
    return pipeline().newProgressivePromise();
  }
  
  public ChannelPromise newPromise()
  {
    return pipeline().newPromise();
  }
  
  public ChannelFuture newSucceededFuture()
  {
    return pipeline().newSucceededFuture();
  }
  
  public Channel parent()
  {
    return parentContext().channel();
  }
  
  protected abstract ChannelHandlerContext parentContext();
  
  public ChannelPipeline pipeline()
  {
    return this.pipeline;
  }
  
  public Channel read()
  {
    pipeline().read();
    return this;
  }
  
  public SocketAddress remoteAddress()
  {
    return parent().remoteAddress();
  }
  
  public Http2FrameStream stream()
  {
    return this.stream;
  }
  
  void streamClosed()
  {
    this.unsafe.readEOS();
    this.unsafe.doBeginRead();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parent().toString());
    localStringBuilder.append("(H2 - ");
    localStringBuilder.append(this.stream);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  final void trySetWritable()
  {
    if (this.totalPendingSize < config().getWriteBufferLowWaterMark()) {
      setWritable(false);
    }
  }
  
  public Channel.Unsafe unsafe()
  {
    return this.unsafe;
  }
  
  public ChannelPromise voidPromise()
  {
    return pipeline().voidPromise();
  }
  
  public ChannelFuture write(Object paramObject)
  {
    return pipeline().write(paramObject);
  }
  
  public ChannelFuture write(Object paramObject, ChannelPromise paramChannelPromise)
  {
    return pipeline().write(paramObject, paramChannelPromise);
  }
  
  protected ChannelFuture write0(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
  {
    ChannelPromise localChannelPromise = paramChannelHandlerContext.newPromise();
    paramChannelHandlerContext.write(paramObject, localChannelPromise);
    return localChannelPromise;
  }
  
  public ChannelFuture writeAndFlush(Object paramObject)
  {
    return pipeline().writeAndFlush(paramObject);
  }
  
  public ChannelFuture writeAndFlush(Object paramObject, ChannelPromise paramChannelPromise)
  {
    return pipeline().writeAndFlush(paramObject, paramChannelPromise);
  }
  
  private static final class FlowControlledFrameSizeEstimator
    implements MessageSizeEstimator
  {
    private static final MessageSizeEstimator.Handle HANDLE_INSTANCE = new MessageSizeEstimator.Handle()
    {
      public int size(Object paramAnonymousObject)
      {
        int i;
        if ((paramAnonymousObject instanceof Http2DataFrame)) {
          i = (int)Math.min(2147483647L, ((Http2DataFrame)paramAnonymousObject).initialFlowControlledBytes() + 9L);
        } else {
          i = 9;
        }
        return i;
      }
    };
    static final FlowControlledFrameSizeEstimator INSTANCE = new FlowControlledFrameSizeEstimator();
    
    public MessageSizeEstimator.Handle newHandle()
    {
      return HANDLE_INSTANCE;
    }
  }
  
  private final class Http2ChannelUnsafe
    implements Channel.Unsafe
  {
    private boolean closeInitiated;
    private boolean readEOS;
    private RecvByteBufAllocator.Handle recvHandle;
    private final VoidChannelPromise unsafeVoidPromise = new VoidChannelPromise(AbstractHttp2StreamChannel.this, false);
    private boolean writeDoneAndNoFlush;
    
    private Http2ChannelUnsafe() {}
    
    private void fireChannelInactiveAndDeregister(final ChannelPromise paramChannelPromise, final boolean paramBoolean)
    {
      if (!paramChannelPromise.setUncancellable()) {
        return;
      }
      if (!AbstractHttp2StreamChannel.this.registered)
      {
        paramChannelPromise.setSuccess();
        return;
      }
      invokeLater(new Runnable()
      {
        public void run()
        {
          if (paramBoolean) {
            AbstractHttp2StreamChannel.this.pipeline.fireChannelInactive();
          }
          if (AbstractHttp2StreamChannel.this.registered)
          {
            AbstractHttp2StreamChannel.access$402(AbstractHttp2StreamChannel.this, false);
            AbstractHttp2StreamChannel.this.pipeline.fireChannelUnregistered();
          }
          AbstractHttp2StreamChannel.Http2ChannelUnsafe.this.safeSetSuccess(paramChannelPromise);
        }
      });
    }
    
    private void firstWriteComplete(ChannelFuture paramChannelFuture, ChannelPromise paramChannelPromise)
    {
      paramChannelFuture = paramChannelFuture.cause();
      if (paramChannelFuture == null)
      {
        paramChannelPromise.setSuccess();
      }
      else
      {
        closeForcibly();
        paramChannelPromise.setFailure(wrapStreamClosedError(paramChannelFuture));
      }
    }
    
    private void invokeLater(Runnable paramRunnable)
    {
      try
      {
        AbstractHttp2StreamChannel.this.eventLoop().execute(paramRunnable);
      }
      catch (RejectedExecutionException paramRunnable)
      {
        AbstractHttp2StreamChannel.logger.warn("Can't invoke task later as EventLoop rejected it", paramRunnable);
      }
    }
    
    private Object pollQueuedMessage()
    {
      Object localObject;
      if (AbstractHttp2StreamChannel.this.inboundBuffer == null) {
        localObject = null;
      } else {
        localObject = AbstractHttp2StreamChannel.this.inboundBuffer.poll();
      }
      return localObject;
    }
    
    private void safeSetSuccess(ChannelPromise paramChannelPromise)
    {
      if ((!(paramChannelPromise instanceof VoidChannelPromise)) && (!paramChannelPromise.trySuccess())) {
        AbstractHttp2StreamChannel.logger.warn("Failed to mark a promise as success because it is done already: {}", paramChannelPromise);
      }
    }
    
    private void updateLocalWindowIfNeeded()
    {
      if (AbstractHttp2StreamChannel.this.flowControlledBytes != 0)
      {
        int i = AbstractHttp2StreamChannel.this.flowControlledBytes;
        AbstractHttp2StreamChannel.access$1602(AbstractHttp2StreamChannel.this, 0);
        Object localObject = AbstractHttp2StreamChannel.this;
        localObject = ((AbstractHttp2StreamChannel)localObject).write0(((AbstractHttp2StreamChannel)localObject).parentContext(), new DefaultHttp2WindowUpdateFrame(i).stream(AbstractHttp2StreamChannel.this.stream));
        this.writeDoneAndNoFlush = true;
        if (((java.util.concurrent.Future)localObject).isDone()) {
          AbstractHttp2StreamChannel.windowUpdateFrameWriteComplete((ChannelFuture)localObject, AbstractHttp2StreamChannel.this);
        } else {
          ((ChannelFuture)localObject).addListener(AbstractHttp2StreamChannel.this.windowUpdateFrameWriteListener);
        }
      }
    }
    
    private Http2StreamFrame validateStreamFrame(Http2StreamFrame paramHttp2StreamFrame)
    {
      if ((paramHttp2StreamFrame.stream() != null) && (paramHttp2StreamFrame.stream() != AbstractHttp2StreamChannel.this.stream))
      {
        String str = paramHttp2StreamFrame.toString();
        ReferenceCountUtil.release(paramHttp2StreamFrame);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Stream ");
        localStringBuilder.append(paramHttp2StreamFrame.stream());
        localStringBuilder.append(" must not be set on the frame: ");
        localStringBuilder.append(str);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return paramHttp2StreamFrame;
    }
    
    private Throwable wrapStreamClosedError(Throwable paramThrowable)
    {
      Throwable localThrowable = paramThrowable;
      if ((paramThrowable instanceof Http2Exception))
      {
        localThrowable = paramThrowable;
        if (((Http2Exception)paramThrowable).error() == Http2Error.STREAM_CLOSED) {
          localThrowable = new ClosedChannelException().initCause(paramThrowable);
        }
      }
      return localThrowable;
    }
    
    private void writeComplete(ChannelFuture paramChannelFuture, ChannelPromise paramChannelPromise)
    {
      paramChannelFuture = paramChannelFuture.cause();
      if (paramChannelFuture == null)
      {
        paramChannelPromise.setSuccess();
      }
      else
      {
        paramChannelFuture = wrapStreamClosedError(paramChannelFuture);
        if ((paramChannelFuture instanceof IOException)) {
          if (AbstractHttp2StreamChannel.this.config.isAutoClose()) {
            closeForcibly();
          } else {
            AbstractHttp2StreamChannel.access$902(AbstractHttp2StreamChannel.this, true);
          }
        }
        paramChannelPromise.setFailure(paramChannelFuture);
      }
    }
    
    private void writeHttp2StreamFrame(Http2StreamFrame paramHttp2StreamFrame, final ChannelPromise paramChannelPromise)
    {
      if ((!AbstractHttp2StreamChannel.this.firstFrameWritten) && (!Http2CodecUtil.isStreamIdValid(AbstractHttp2StreamChannel.this.stream().id())) && (!(paramHttp2StreamFrame instanceof Http2HeadersFrame)))
      {
        ReferenceCountUtil.release(paramHttp2StreamFrame);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("The first frame must be a headers frame. Was: ");
        ((StringBuilder)localObject).append(paramHttp2StreamFrame.name());
        paramChannelPromise.setFailure(new IllegalArgumentException(((StringBuilder)localObject).toString()));
        return;
      }
      final boolean bool;
      if (AbstractHttp2StreamChannel.this.firstFrameWritten) {
        bool = false;
      } else {
        bool = AbstractHttp2StreamChannel.access$1802(AbstractHttp2StreamChannel.this, true);
      }
      Object localObject = AbstractHttp2StreamChannel.this;
      localObject = ((AbstractHttp2StreamChannel)localObject).write0(((AbstractHttp2StreamChannel)localObject).parentContext(), paramHttp2StreamFrame);
      if (((java.util.concurrent.Future)localObject).isDone())
      {
        if (bool) {
          firstWriteComplete((ChannelFuture)localObject, paramChannelPromise);
        } else {
          writeComplete((ChannelFuture)localObject, paramChannelPromise);
        }
      }
      else
      {
        final long l = AbstractHttp2StreamChannel.FlowControlledFrameSizeEstimator.HANDLE_INSTANCE.size(paramHttp2StreamFrame);
        AbstractHttp2StreamChannel.this.incrementPendingOutboundBytes(l, false);
        ((ChannelFuture)localObject).addListener(new ChannelFutureListener()
        {
          public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
          {
            if (bool) {
              AbstractHttp2StreamChannel.Http2ChannelUnsafe.this.firstWriteComplete(paramAnonymousChannelFuture, paramChannelPromise);
            } else {
              AbstractHttp2StreamChannel.Http2ChannelUnsafe.this.writeComplete(paramAnonymousChannelFuture, paramChannelPromise);
            }
            AbstractHttp2StreamChannel.this.decrementPendingOutboundBytes(l, false);
          }
        });
        this.writeDoneAndNoFlush = true;
      }
    }
    
    public void beginRead()
    {
      if (!AbstractHttp2StreamChannel.this.isActive()) {
        return;
      }
      updateLocalWindowIfNeeded();
      int i = AbstractHttp2StreamChannel.5.$SwitchMap$io$netty$handler$codec$http2$AbstractHttp2StreamChannel$ReadStatus[AbstractHttp2StreamChannel.this.readStatus.ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          AbstractHttp2StreamChannel.access$1302(AbstractHttp2StreamChannel.this, AbstractHttp2StreamChannel.ReadStatus.REQUESTED);
        }
      }
      else
      {
        AbstractHttp2StreamChannel.access$1302(AbstractHttp2StreamChannel.this, AbstractHttp2StreamChannel.ReadStatus.IN_PROGRESS);
        doBeginRead();
      }
    }
    
    public void bind(SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    {
      if (!paramChannelPromise.setUncancellable()) {
        return;
      }
      paramChannelPromise.setFailure(new UnsupportedOperationException());
    }
    
    public void close(final ChannelPromise paramChannelPromise)
    {
      if (!paramChannelPromise.setUncancellable()) {
        return;
      }
      if (this.closeInitiated)
      {
        if (AbstractHttp2StreamChannel.this.closePromise.isDone()) {
          paramChannelPromise.setSuccess();
        } else if (!(paramChannelPromise instanceof VoidChannelPromise)) {
          AbstractHttp2StreamChannel.this.closePromise.addListener(new ChannelFutureListener()
          {
            public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
            {
              paramChannelPromise.setSuccess();
            }
          });
        }
        return;
      }
      this.closeInitiated = true;
      AbstractHttp2StreamChannel.access$602(AbstractHttp2StreamChannel.this, false);
      boolean bool = AbstractHttp2StreamChannel.this.isActive();
      if ((AbstractHttp2StreamChannel.this.parent().isActive()) && (!this.readEOS) && (Http2CodecUtil.isStreamIdValid(AbstractHttp2StreamChannel.this.stream.id())))
      {
        write(new DefaultHttp2ResetFrame(Http2Error.CANCEL).stream(AbstractHttp2StreamChannel.this.stream()), AbstractHttp2StreamChannel.this.unsafe().voidPromise());
        flush();
      }
      if (AbstractHttp2StreamChannel.this.inboundBuffer != null) {
        for (;;)
        {
          Object localObject = AbstractHttp2StreamChannel.this.inboundBuffer.poll();
          if (localObject == null)
          {
            AbstractHttp2StreamChannel.access$802(AbstractHttp2StreamChannel.this, null);
            break;
          }
          ReferenceCountUtil.release(localObject);
        }
      }
      AbstractHttp2StreamChannel.access$902(AbstractHttp2StreamChannel.this, true);
      AbstractHttp2StreamChannel.this.closePromise.setSuccess();
      paramChannelPromise.setSuccess();
      fireChannelInactiveAndDeregister(voidPromise(), bool);
    }
    
    public void closeForcibly()
    {
      close(AbstractHttp2StreamChannel.this.unsafe().voidPromise());
    }
    
    public void connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    {
      if (!paramChannelPromise.setUncancellable()) {
        return;
      }
      paramChannelPromise.setFailure(new UnsupportedOperationException());
    }
    
    public void deregister(ChannelPromise paramChannelPromise)
    {
      fireChannelInactiveAndDeregister(paramChannelPromise, false);
    }
    
    public void disconnect(ChannelPromise paramChannelPromise)
    {
      close(paramChannelPromise);
    }
    
    void doBeginRead()
    {
      while (AbstractHttp2StreamChannel.this.readStatus != AbstractHttp2StreamChannel.ReadStatus.IDLE)
      {
        Object localObject1 = pollQueuedMessage();
        if (localObject1 == null)
        {
          if (this.readEOS) {
            AbstractHttp2StreamChannel.this.unsafe.closeForcibly();
          }
          flush();
          break;
        }
        RecvByteBufAllocator.Handle localHandle = recvBufAllocHandle();
        localHandle.reset(AbstractHttp2StreamChannel.this.config());
        boolean bool1 = false;
        boolean bool2;
        Object localObject2;
        do
        {
          doRead0((Http2Frame)localObject1, localHandle);
          bool2 = bool1;
          if (!this.readEOS)
          {
            bool1 = localHandle.continueReading();
            bool2 = bool1;
            if (!bool1) {
              break;
            }
            bool2 = bool1;
          }
          localObject2 = pollQueuedMessage();
          localObject1 = localObject2;
          bool1 = bool2;
        } while (localObject2 != null);
        if ((bool2) && (AbstractHttp2StreamChannel.this.isParentReadInProgress()) && (!this.readEOS)) {
          AbstractHttp2StreamChannel.this.maybeAddChannelToReadCompletePendingQueue();
        } else {
          notifyReadComplete(localHandle, true);
        }
      }
    }
    
    void doRead0(Http2Frame paramHttp2Frame, RecvByteBufAllocator.Handle paramHandle)
    {
      int i;
      if ((paramHttp2Frame instanceof Http2DataFrame))
      {
        i = ((Http2DataFrame)paramHttp2Frame).initialFlowControlledBytes();
        AbstractHttp2StreamChannel localAbstractHttp2StreamChannel = AbstractHttp2StreamChannel.this;
        AbstractHttp2StreamChannel.access$1602(localAbstractHttp2StreamChannel, localAbstractHttp2StreamChannel.flowControlledBytes + i);
      }
      else
      {
        i = 9;
      }
      paramHandle.attemptedBytesRead(i);
      paramHandle.lastBytesRead(i);
      paramHandle.incMessagesRead(1);
      AbstractHttp2StreamChannel.this.pipeline().fireChannelRead(paramHttp2Frame);
    }
    
    public void flush()
    {
      if ((this.writeDoneAndNoFlush) && (!AbstractHttp2StreamChannel.this.isParentReadInProgress()))
      {
        this.writeDoneAndNoFlush = false;
        AbstractHttp2StreamChannel localAbstractHttp2StreamChannel = AbstractHttp2StreamChannel.this;
        localAbstractHttp2StreamChannel.flush0(localAbstractHttp2StreamChannel.parentContext());
      }
    }
    
    public SocketAddress localAddress()
    {
      return AbstractHttp2StreamChannel.this.parent().unsafe().localAddress();
    }
    
    void notifyReadComplete(RecvByteBufAllocator.Handle paramHandle, boolean paramBoolean)
    {
      if ((!AbstractHttp2StreamChannel.this.readCompletePending) && (!paramBoolean)) {
        return;
      }
      AbstractHttp2StreamChannel.access$602(AbstractHttp2StreamChannel.this, false);
      if (AbstractHttp2StreamChannel.this.readStatus == AbstractHttp2StreamChannel.ReadStatus.REQUESTED) {
        AbstractHttp2StreamChannel.access$1302(AbstractHttp2StreamChannel.this, AbstractHttp2StreamChannel.ReadStatus.IN_PROGRESS);
      } else {
        AbstractHttp2StreamChannel.access$1302(AbstractHttp2StreamChannel.this, AbstractHttp2StreamChannel.ReadStatus.IDLE);
      }
      paramHandle.readComplete();
      AbstractHttp2StreamChannel.this.pipeline().fireChannelReadComplete();
      flush();
      if (this.readEOS) {
        AbstractHttp2StreamChannel.this.unsafe.closeForcibly();
      }
    }
    
    public ChannelOutboundBuffer outboundBuffer()
    {
      return null;
    }
    
    void readEOS()
    {
      this.readEOS = true;
    }
    
    public RecvByteBufAllocator.Handle recvBufAllocHandle()
    {
      if (this.recvHandle == null)
      {
        RecvByteBufAllocator.Handle localHandle = AbstractHttp2StreamChannel.this.config().getRecvByteBufAllocator().newHandle();
        this.recvHandle = localHandle;
        localHandle.reset(AbstractHttp2StreamChannel.this.config());
      }
      return this.recvHandle;
    }
    
    public void register(EventLoop paramEventLoop, ChannelPromise paramChannelPromise)
    {
      if (!paramChannelPromise.setUncancellable()) {
        return;
      }
      if (AbstractHttp2StreamChannel.this.registered)
      {
        paramChannelPromise.setFailure(new UnsupportedOperationException("Re-register is not supported"));
        return;
      }
      AbstractHttp2StreamChannel.access$402(AbstractHttp2StreamChannel.this, true);
      paramChannelPromise.setSuccess();
      AbstractHttp2StreamChannel.this.pipeline().fireChannelRegistered();
      if (AbstractHttp2StreamChannel.this.isActive()) {
        AbstractHttp2StreamChannel.this.pipeline().fireChannelActive();
      }
    }
    
    public SocketAddress remoteAddress()
    {
      return AbstractHttp2StreamChannel.this.parent().unsafe().remoteAddress();
    }
    
    public ChannelPromise voidPromise()
    {
      return this.unsafeVoidPromise;
    }
    
    public void write(Object paramObject, ChannelPromise paramChannelPromise)
    {
      if (!paramChannelPromise.setUncancellable())
      {
        ReferenceCountUtil.release(paramObject);
        return;
      }
      if ((AbstractHttp2StreamChannel.this.isActive()) && ((!AbstractHttp2StreamChannel.this.outboundClosed) || ((!(paramObject instanceof Http2HeadersFrame)) && (!(paramObject instanceof Http2DataFrame)))))
      {
        try
        {
          if ((paramObject instanceof Http2StreamFrame))
          {
            writeHttp2StreamFrame(validateStreamFrame((Http2StreamFrame)paramObject).stream(AbstractHttp2StreamChannel.this.stream()), paramChannelPromise);
          }
          else
          {
            String str = paramObject.toString();
            ReferenceCountUtil.release(paramObject);
            paramObject = new java/lang/IllegalArgumentException;
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            localStringBuilder.append("Message must be an ");
            localStringBuilder.append(StringUtil.simpleClassName(Http2StreamFrame.class));
            localStringBuilder.append(": ");
            localStringBuilder.append(str);
            ((IllegalArgumentException)paramObject).<init>(localStringBuilder.toString());
          }
        }
        finally
        {
          paramChannelPromise.tryFailure((Throwable)paramObject);
        }
        return;
      }
      ReferenceCountUtil.release(paramObject);
      paramChannelPromise.setFailure(new ClosedChannelException());
    }
  }
  
  private static final class Http2StreamChannelConfig
    extends DefaultChannelConfig
  {
    Http2StreamChannelConfig(Channel paramChannel)
    {
      super();
    }
    
    public MessageSizeEstimator getMessageSizeEstimator()
    {
      return AbstractHttp2StreamChannel.FlowControlledFrameSizeEstimator.INSTANCE;
    }
    
    public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator)
    {
      throw new UnsupportedOperationException();
    }
    
    public ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator)
    {
      if ((paramRecvByteBufAllocator.newHandle() instanceof RecvByteBufAllocator.ExtendedHandle))
      {
        super.setRecvByteBufAllocator(paramRecvByteBufAllocator);
        return this;
      }
      paramRecvByteBufAllocator = new StringBuilder();
      paramRecvByteBufAllocator.append("allocator.newHandle() must return an object of type: ");
      paramRecvByteBufAllocator.append(RecvByteBufAllocator.ExtendedHandle.class);
      throw new IllegalArgumentException(paramRecvByteBufAllocator.toString());
    }
  }
  
  private static enum ReadStatus
  {
    static
    {
      ReadStatus localReadStatus1 = new ReadStatus("IDLE", 0);
      IDLE = localReadStatus1;
      ReadStatus localReadStatus2 = new ReadStatus("IN_PROGRESS", 1);
      IN_PROGRESS = localReadStatus2;
      ReadStatus localReadStatus3 = new ReadStatus("REQUESTED", 2);
      REQUESTED = localReadStatus3;
      $VALUES = new ReadStatus[] { localReadStatus1, localReadStatus2, localReadStatus3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\AbstractHttp2StreamChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */