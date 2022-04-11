package io.netty.channel.embedded;

import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.DefaultChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class EmbeddedChannel
  extends AbstractChannel
{
  private static final ChannelHandler[] EMPTY_HANDLERS;
  private static final SocketAddress LOCAL_ADDRESS = new EmbeddedSocketAddress();
  private static final ChannelMetadata METADATA_DISCONNECT = new ChannelMetadata(true);
  private static final ChannelMetadata METADATA_NO_DISCONNECT;
  private static final SocketAddress REMOTE_ADDRESS = new EmbeddedSocketAddress();
  private static final InternalLogger logger;
  private final ChannelConfig config;
  private Queue<Object> inboundMessages;
  private Throwable lastException;
  private final EmbeddedEventLoop loop = new EmbeddedEventLoop();
  private final ChannelMetadata metadata;
  private Queue<Object> outboundMessages;
  private final ChannelFutureListener recordExceptionListener = new ChannelFutureListener()
  {
    public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
      throws Exception
    {
      EmbeddedChannel.this.recordException(paramAnonymousChannelFuture);
    }
  };
  private State state;
  
  static
  {
    EMPTY_HANDLERS = new ChannelHandler[0];
    logger = InternalLoggerFactory.getInstance(EmbeddedChannel.class);
    METADATA_NO_DISCONNECT = new ChannelMetadata(false);
  }
  
  public EmbeddedChannel()
  {
    this(EMPTY_HANDLERS);
  }
  
  public EmbeddedChannel(Channel paramChannel, ChannelId paramChannelId, boolean paramBoolean1, boolean paramBoolean2, ChannelHandler... paramVarArgs)
  {
    super(paramChannel, paramChannelId);
    this.metadata = metadata(paramBoolean2);
    this.config = new DefaultChannelConfig(this);
    setup(paramBoolean1, paramVarArgs);
  }
  
  public EmbeddedChannel(ChannelId paramChannelId)
  {
    this(paramChannelId, EMPTY_HANDLERS);
  }
  
  public EmbeddedChannel(ChannelId paramChannelId, boolean paramBoolean, ChannelConfig paramChannelConfig, ChannelHandler... paramVarArgs)
  {
    super(null, paramChannelId);
    this.metadata = metadata(paramBoolean);
    this.config = ((ChannelConfig)ObjectUtil.checkNotNull(paramChannelConfig, "config"));
    setup(true, paramVarArgs);
  }
  
  public EmbeddedChannel(ChannelId paramChannelId, boolean paramBoolean1, boolean paramBoolean2, ChannelHandler... paramVarArgs)
  {
    this(null, paramChannelId, paramBoolean1, paramBoolean2, paramVarArgs);
  }
  
  public EmbeddedChannel(ChannelId paramChannelId, boolean paramBoolean, ChannelHandler... paramVarArgs)
  {
    this(paramChannelId, true, paramBoolean, paramVarArgs);
  }
  
  public EmbeddedChannel(ChannelId paramChannelId, ChannelHandler... paramVarArgs)
  {
    this(paramChannelId, false, paramVarArgs);
  }
  
  public EmbeddedChannel(boolean paramBoolean1, boolean paramBoolean2, ChannelHandler... paramVarArgs)
  {
    this(EmbeddedChannelId.INSTANCE, paramBoolean1, paramBoolean2, paramVarArgs);
  }
  
  public EmbeddedChannel(boolean paramBoolean, ChannelHandler... paramVarArgs)
  {
    this(EmbeddedChannelId.INSTANCE, paramBoolean, paramVarArgs);
  }
  
  public EmbeddedChannel(ChannelHandler... paramVarArgs)
  {
    this(EmbeddedChannelId.INSTANCE, paramVarArgs);
  }
  
  private ChannelFuture checkException(ChannelPromise paramChannelPromise)
  {
    Throwable localThrowable = this.lastException;
    if (localThrowable != null)
    {
      this.lastException = null;
      if (paramChannelPromise.isVoid()) {
        PlatformDependent.throwException(localThrowable);
      }
      return paramChannelPromise.setFailure(localThrowable);
    }
    return paramChannelPromise.setSuccess();
  }
  
  private boolean checkOpen(boolean paramBoolean)
  {
    if (!isOpen())
    {
      if (paramBoolean) {
        recordException(new ClosedChannelException());
      }
      return false;
    }
    return true;
  }
  
  private boolean finish(boolean paramBoolean)
  {
    close();
    try
    {
      checkException();
      if (!isNotEmpty(this.inboundMessages))
      {
        bool = isNotEmpty(this.outboundMessages);
        if (!bool)
        {
          bool = false;
          break label41;
        }
      }
      boolean bool = true;
      label41:
      return bool;
    }
    finally
    {
      if (paramBoolean)
      {
        releaseAll(this.inboundMessages);
        releaseAll(this.outboundMessages);
      }
    }
  }
  
  private void finishPendingTasks(boolean paramBoolean)
  {
    runPendingTasks();
    if (paramBoolean) {
      this.loop.cancelScheduledTasks();
    }
  }
  
  private ChannelFuture flushInbound(boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    if (checkOpen(paramBoolean))
    {
      pipeline().fireChannelReadComplete();
      runPendingTasks();
    }
    return checkException(paramChannelPromise);
  }
  
  private void flushOutbound0()
  {
    runPendingTasks();
    flush();
  }
  
  private static boolean isNotEmpty(Queue<Object> paramQueue)
  {
    boolean bool;
    if ((paramQueue != null) && (!paramQueue.isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static ChannelMetadata metadata(boolean paramBoolean)
  {
    ChannelMetadata localChannelMetadata;
    if (paramBoolean) {
      localChannelMetadata = METADATA_DISCONNECT;
    } else {
      localChannelMetadata = METADATA_NO_DISCONNECT;
    }
    return localChannelMetadata;
  }
  
  private static Object poll(Queue<Object> paramQueue)
  {
    if (paramQueue != null) {
      paramQueue = paramQueue.poll();
    } else {
      paramQueue = null;
    }
    return paramQueue;
  }
  
  private void recordException(ChannelFuture paramChannelFuture)
  {
    if (!paramChannelFuture.isSuccess()) {
      recordException(paramChannelFuture.cause());
    }
  }
  
  private void recordException(Throwable paramThrowable)
  {
    if (this.lastException == null) {
      this.lastException = paramThrowable;
    } else {
      logger.warn("More than one exception was raised. Will report only the first one and log others.", paramThrowable);
    }
  }
  
  private static boolean releaseAll(Queue<Object> paramQueue)
  {
    if (isNotEmpty(paramQueue)) {
      for (;;)
      {
        Object localObject = paramQueue.poll();
        if (localObject == null) {
          return true;
        }
        ReferenceCountUtil.release(localObject);
      }
    }
    return false;
  }
  
  private void setup(boolean paramBoolean, final ChannelHandler... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "handlers");
    pipeline().addLast(new ChannelHandler[] { new ChannelInitializer()
    {
      protected void initChannel(Channel paramAnonymousChannel)
        throws Exception
      {
        ChannelPipeline localChannelPipeline = paramAnonymousChannel.pipeline();
        for (paramAnonymousChannel : paramVarArgs)
        {
          if (paramAnonymousChannel == null) {
            break;
          }
          localChannelPipeline.addLast(new ChannelHandler[] { paramAnonymousChannel });
        }
      }
    } });
    if (paramBoolean) {
      this.loop.register(this);
    }
  }
  
  public void checkException()
  {
    checkException(voidPromise());
  }
  
  public final ChannelFuture close()
  {
    return close(newPromise());
  }
  
  public final ChannelFuture close(ChannelPromise paramChannelPromise)
  {
    runPendingTasks();
    paramChannelPromise = super.close(paramChannelPromise);
    finishPendingTasks(true);
    return paramChannelPromise;
  }
  
  public ChannelConfig config()
  {
    return this.config;
  }
  
  public final ChannelFuture disconnect()
  {
    return disconnect(newPromise());
  }
  
  public final ChannelFuture disconnect(ChannelPromise paramChannelPromise)
  {
    paramChannelPromise = super.disconnect(paramChannelPromise);
    finishPendingTasks(this.metadata.hasDisconnect() ^ true);
    return paramChannelPromise;
  }
  
  protected void doBeginRead()
    throws Exception
  {}
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {}
  
  protected void doClose()
    throws Exception
  {
    this.state = State.CLOSED;
  }
  
  protected void doDisconnect()
    throws Exception
  {
    if (!this.metadata.hasDisconnect()) {
      doClose();
    }
  }
  
  protected void doRegister()
    throws Exception
  {
    this.state = State.ACTIVE;
  }
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    for (;;)
    {
      Object localObject = paramChannelOutboundBuffer.current();
      if (localObject == null) {
        return;
      }
      ReferenceCountUtil.retain(localObject);
      handleOutboundMessage(localObject);
      paramChannelOutboundBuffer.remove();
    }
  }
  
  protected final void ensureOpen()
  {
    if (!checkOpen(true)) {
      checkException();
    }
  }
  
  public boolean finish()
  {
    return finish(false);
  }
  
  public boolean finishAndReleaseAll()
  {
    return finish(true);
  }
  
  public EmbeddedChannel flushInbound()
  {
    flushInbound(true, voidPromise());
    return this;
  }
  
  public EmbeddedChannel flushOutbound()
  {
    if (checkOpen(true)) {
      flushOutbound0();
    }
    checkException(voidPromise());
    return this;
  }
  
  protected void handleInboundMessage(Object paramObject)
  {
    inboundMessages().add(paramObject);
  }
  
  protected void handleOutboundMessage(Object paramObject)
  {
    outboundMessages().add(paramObject);
  }
  
  public Queue<Object> inboundMessages()
  {
    if (this.inboundMessages == null) {
      this.inboundMessages = new ArrayDeque();
    }
    return this.inboundMessages;
  }
  
  public boolean isActive()
  {
    boolean bool;
    if (this.state == State.ACTIVE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected boolean isCompatible(EventLoop paramEventLoop)
  {
    return paramEventLoop instanceof EmbeddedEventLoop;
  }
  
  public boolean isOpen()
  {
    boolean bool;
    if (this.state != State.CLOSED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public Queue<Object> lastInboundBuffer()
  {
    return inboundMessages();
  }
  
  @Deprecated
  public Queue<Object> lastOutboundBuffer()
  {
    return outboundMessages();
  }
  
  protected SocketAddress localAddress0()
  {
    SocketAddress localSocketAddress;
    if (isActive()) {
      localSocketAddress = LOCAL_ADDRESS;
    } else {
      localSocketAddress = null;
    }
    return localSocketAddress;
  }
  
  public ChannelMetadata metadata()
  {
    return this.metadata;
  }
  
  protected final DefaultChannelPipeline newChannelPipeline()
  {
    return new EmbeddedChannelPipeline(this);
  }
  
  protected AbstractChannel.AbstractUnsafe newUnsafe()
  {
    return new EmbeddedUnsafe(null);
  }
  
  public Queue<Object> outboundMessages()
  {
    if (this.outboundMessages == null) {
      this.outboundMessages = new ArrayDeque();
    }
    return this.outboundMessages;
  }
  
  public <T> T readInbound()
  {
    Object localObject = poll(this.inboundMessages);
    if (localObject != null) {
      ReferenceCountUtil.touch(localObject, "Caller of readInbound() will handle the message from this point");
    }
    return (T)localObject;
  }
  
  public <T> T readOutbound()
  {
    Object localObject = poll(this.outboundMessages);
    if (localObject != null) {
      ReferenceCountUtil.touch(localObject, "Caller of readOutbound() will handle the message from this point.");
    }
    return (T)localObject;
  }
  
  public void register()
    throws Exception
  {
    Throwable localThrowable = this.loop.register(this).cause();
    if (localThrowable != null) {
      PlatformDependent.throwException(localThrowable);
    }
  }
  
  public boolean releaseInbound()
  {
    return releaseAll(this.inboundMessages);
  }
  
  public boolean releaseOutbound()
  {
    return releaseAll(this.outboundMessages);
  }
  
  protected SocketAddress remoteAddress0()
  {
    SocketAddress localSocketAddress;
    if (isActive()) {
      localSocketAddress = REMOTE_ADDRESS;
    } else {
      localSocketAddress = null;
    }
    return localSocketAddress;
  }
  
  public void runPendingTasks()
  {
    try
    {
      this.loop.runTasks();
    }
    catch (Exception localException1)
    {
      recordException(localException1);
    }
    try
    {
      this.loop.runScheduledTasks();
    }
    catch (Exception localException2)
    {
      recordException(localException2);
    }
  }
  
  public long runScheduledPendingTasks()
  {
    try
    {
      long l = this.loop.runScheduledTasks();
      return l;
    }
    catch (Exception localException)
    {
      recordException(localException);
    }
    return this.loop.nextScheduledTask();
  }
  
  public Channel.Unsafe unsafe()
  {
    return ((EmbeddedUnsafe)super.unsafe()).wrapped;
  }
  
  public boolean writeInbound(Object... paramVarArgs)
  {
    ensureOpen();
    if (paramVarArgs.length == 0) {
      return isNotEmpty(this.inboundMessages);
    }
    ChannelPipeline localChannelPipeline = pipeline();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      localChannelPipeline.fireChannelRead(paramVarArgs[j]);
    }
    flushInbound(false, voidPromise());
    return isNotEmpty(this.inboundMessages);
  }
  
  public ChannelFuture writeOneInbound(Object paramObject)
  {
    return writeOneInbound(paramObject, newPromise());
  }
  
  public ChannelFuture writeOneInbound(Object paramObject, ChannelPromise paramChannelPromise)
  {
    if (checkOpen(true)) {
      pipeline().fireChannelRead(paramObject);
    }
    return checkException(paramChannelPromise);
  }
  
  public ChannelFuture writeOneOutbound(Object paramObject)
  {
    return writeOneOutbound(paramObject, newPromise());
  }
  
  public ChannelFuture writeOneOutbound(Object paramObject, ChannelPromise paramChannelPromise)
  {
    if (checkOpen(true)) {
      return write(paramObject, paramChannelPromise);
    }
    return checkException(paramChannelPromise);
  }
  
  public boolean writeOutbound(Object... paramVarArgs)
  {
    ensureOpen();
    if (paramVarArgs.length == 0) {
      return isNotEmpty(this.outboundMessages);
    }
    RecyclableArrayList localRecyclableArrayList = RecyclableArrayList.newInstance(paramVarArgs.length);
    try
    {
      int i = paramVarArgs.length;
      int j = 0;
      for (int k = 0; k < i; k++)
      {
        Object localObject = paramVarArgs[k];
        if (localObject == null) {
          break;
        }
        localRecyclableArrayList.add(write(localObject));
      }
      flushOutbound0();
      i = localRecyclableArrayList.size();
      for (k = j; k < i; k++)
      {
        paramVarArgs = (ChannelFuture)localRecyclableArrayList.get(k);
        if (paramVarArgs.isDone()) {
          recordException(paramVarArgs);
        } else {
          paramVarArgs.addListener(this.recordExceptionListener);
        }
      }
      checkException();
      boolean bool = isNotEmpty(this.outboundMessages);
      return bool;
    }
    finally
    {
      localRecyclableArrayList.recycle();
    }
  }
  
  private final class EmbeddedChannelPipeline
    extends DefaultChannelPipeline
  {
    EmbeddedChannelPipeline(EmbeddedChannel paramEmbeddedChannel)
    {
      super();
    }
    
    protected void onUnhandledInboundException(Throwable paramThrowable)
    {
      EmbeddedChannel.this.recordException(paramThrowable);
    }
    
    protected void onUnhandledInboundMessage(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    {
      EmbeddedChannel.this.handleInboundMessage(paramObject);
    }
  }
  
  private final class EmbeddedUnsafe
    extends AbstractChannel.AbstractUnsafe
  {
    final Channel.Unsafe wrapped = new Channel.Unsafe()
    {
      public void beginRead()
      {
        EmbeddedChannel.EmbeddedUnsafe.this.beginRead();
        EmbeddedChannel.this.runPendingTasks();
      }
      
      public void bind(SocketAddress paramAnonymousSocketAddress, ChannelPromise paramAnonymousChannelPromise)
      {
        EmbeddedChannel.EmbeddedUnsafe.this.bind(paramAnonymousSocketAddress, paramAnonymousChannelPromise);
        EmbeddedChannel.this.runPendingTasks();
      }
      
      public void close(ChannelPromise paramAnonymousChannelPromise)
      {
        EmbeddedChannel.EmbeddedUnsafe.this.close(paramAnonymousChannelPromise);
        EmbeddedChannel.this.runPendingTasks();
      }
      
      public void closeForcibly()
      {
        EmbeddedChannel.EmbeddedUnsafe.this.closeForcibly();
        EmbeddedChannel.this.runPendingTasks();
      }
      
      public void connect(SocketAddress paramAnonymousSocketAddress1, SocketAddress paramAnonymousSocketAddress2, ChannelPromise paramAnonymousChannelPromise)
      {
        EmbeddedChannel.EmbeddedUnsafe.this.connect(paramAnonymousSocketAddress1, paramAnonymousSocketAddress2, paramAnonymousChannelPromise);
        EmbeddedChannel.this.runPendingTasks();
      }
      
      public void deregister(ChannelPromise paramAnonymousChannelPromise)
      {
        EmbeddedChannel.EmbeddedUnsafe.this.deregister(paramAnonymousChannelPromise);
        EmbeddedChannel.this.runPendingTasks();
      }
      
      public void disconnect(ChannelPromise paramAnonymousChannelPromise)
      {
        EmbeddedChannel.EmbeddedUnsafe.this.disconnect(paramAnonymousChannelPromise);
        EmbeddedChannel.this.runPendingTasks();
      }
      
      public void flush()
      {
        EmbeddedChannel.EmbeddedUnsafe.this.flush();
        EmbeddedChannel.this.runPendingTasks();
      }
      
      public SocketAddress localAddress()
      {
        return EmbeddedChannel.EmbeddedUnsafe.this.localAddress();
      }
      
      public ChannelOutboundBuffer outboundBuffer()
      {
        return EmbeddedChannel.EmbeddedUnsafe.this.outboundBuffer();
      }
      
      public RecvByteBufAllocator.Handle recvBufAllocHandle()
      {
        return EmbeddedChannel.EmbeddedUnsafe.this.recvBufAllocHandle();
      }
      
      public void register(EventLoop paramAnonymousEventLoop, ChannelPromise paramAnonymousChannelPromise)
      {
        EmbeddedChannel.EmbeddedUnsafe.this.register(paramAnonymousEventLoop, paramAnonymousChannelPromise);
        EmbeddedChannel.this.runPendingTasks();
      }
      
      public SocketAddress remoteAddress()
      {
        return EmbeddedChannel.EmbeddedUnsafe.this.remoteAddress();
      }
      
      public ChannelPromise voidPromise()
      {
        return EmbeddedChannel.EmbeddedUnsafe.this.voidPromise();
      }
      
      public void write(Object paramAnonymousObject, ChannelPromise paramAnonymousChannelPromise)
      {
        EmbeddedChannel.EmbeddedUnsafe.this.write(paramAnonymousObject, paramAnonymousChannelPromise);
        EmbeddedChannel.this.runPendingTasks();
      }
    };
    
    private EmbeddedUnsafe()
    {
      super();
    }
    
    public void connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    {
      safeSetSuccess(paramChannelPromise);
    }
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("OPEN", 0);
      OPEN = localState1;
      State localState2 = new State("ACTIVE", 1);
      ACTIVE = localState2;
      State localState3 = new State("CLOSED", 2);
      CLOSED = localState3;
      $VALUES = new State[] { localState1, localState2, localState3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\embedded\EmbeddedChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */