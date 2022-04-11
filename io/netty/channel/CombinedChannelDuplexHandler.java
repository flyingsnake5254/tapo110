package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.AttributeMap;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;

public class CombinedChannelDuplexHandler<I extends ChannelInboundHandler, O extends ChannelOutboundHandler>
  extends ChannelDuplexHandler
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(CombinedChannelDuplexHandler.class);
  private volatile boolean handlerAdded;
  private DelegatingChannelHandlerContext inboundCtx;
  private I inboundHandler;
  private DelegatingChannelHandlerContext outboundCtx;
  private O outboundHandler;
  
  protected CombinedChannelDuplexHandler()
  {
    ensureNotSharable();
  }
  
  public CombinedChannelDuplexHandler(I paramI, O paramO)
  {
    ensureNotSharable();
    init(paramI, paramO);
  }
  
  private void checkAdded()
  {
    if (this.handlerAdded) {
      return;
    }
    throw new IllegalStateException("handler not added to pipeline yet");
  }
  
  private void validate(I paramI, O paramO)
  {
    if (this.inboundHandler == null)
    {
      ObjectUtil.checkNotNull(paramI, "inboundHandler");
      ObjectUtil.checkNotNull(paramO, "outboundHandler");
      if (!(paramI instanceof ChannelOutboundHandler))
      {
        if (!(paramO instanceof ChannelInboundHandler)) {
          return;
        }
        paramI = new StringBuilder();
        paramI.append("outboundHandler must not implement ");
        paramI.append(ChannelInboundHandler.class.getSimpleName());
        paramI.append(" to get combined.");
        throw new IllegalArgumentException(paramI.toString());
      }
      paramI = new StringBuilder();
      paramI.append("inboundHandler must not implement ");
      paramI.append(ChannelOutboundHandler.class.getSimpleName());
      paramI.append(" to get combined.");
      throw new IllegalArgumentException(paramI.toString());
    }
    paramI = new StringBuilder();
    paramI.append("init() can not be invoked if ");
    paramI.append(CombinedChannelDuplexHandler.class.getSimpleName());
    paramI.append(" was constructed with non-default constructor.");
    throw new IllegalStateException(paramI.toString());
  }
  
  public void bind(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext = this.outboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.outboundHandler.bind(paramChannelHandlerContext, paramSocketAddress, paramChannelPromise);
    } else {
      paramChannelHandlerContext.bind(paramSocketAddress, paramChannelPromise);
    }
  }
  
  public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext = this.inboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.inboundHandler.channelActive(paramChannelHandlerContext);
    } else {
      paramChannelHandlerContext.fireChannelActive();
    }
  }
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext = this.inboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.inboundHandler.channelInactive(paramChannelHandlerContext);
    } else {
      paramChannelHandlerContext.fireChannelInactive();
    }
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    paramChannelHandlerContext = this.inboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.inboundHandler.channelRead(paramChannelHandlerContext, paramObject);
    } else {
      paramChannelHandlerContext.fireChannelRead(paramObject);
    }
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext = this.inboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.inboundHandler.channelReadComplete(paramChannelHandlerContext);
    } else {
      paramChannelHandlerContext.fireChannelReadComplete();
    }
  }
  
  public void channelRegistered(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext = this.inboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.inboundHandler.channelRegistered(paramChannelHandlerContext);
    } else {
      paramChannelHandlerContext.fireChannelRegistered();
    }
  }
  
  public void channelUnregistered(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext = this.inboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.inboundHandler.channelUnregistered(paramChannelHandlerContext);
    } else {
      paramChannelHandlerContext.fireChannelUnregistered();
    }
  }
  
  public void channelWritabilityChanged(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext = this.inboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.inboundHandler.channelWritabilityChanged(paramChannelHandlerContext);
    } else {
      paramChannelHandlerContext.fireChannelWritabilityChanged();
    }
  }
  
  public void close(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext = this.outboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.outboundHandler.close(paramChannelHandlerContext, paramChannelPromise);
    } else {
      paramChannelHandlerContext.close(paramChannelPromise);
    }
  }
  
  public void connect(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext = this.outboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.outboundHandler.connect(paramChannelHandlerContext, paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
    } else {
      paramChannelHandlerContext.connect(paramSocketAddress2, paramChannelPromise);
    }
  }
  
  public void deregister(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext = this.outboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.outboundHandler.deregister(paramChannelHandlerContext, paramChannelPromise);
    } else {
      paramChannelHandlerContext.deregister(paramChannelPromise);
    }
  }
  
  public void disconnect(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext = this.outboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.outboundHandler.disconnect(paramChannelHandlerContext, paramChannelPromise);
    } else {
      paramChannelHandlerContext.disconnect(paramChannelPromise);
    }
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    paramChannelHandlerContext = this.inboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.inboundHandler.exceptionCaught(paramChannelHandlerContext, paramThrowable);
    } else {
      paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
    }
  }
  
  public void flush(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext = this.outboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.outboundHandler.flush(paramChannelHandlerContext);
    } else {
      paramChannelHandlerContext.flush();
    }
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.inboundHandler != null)
    {
      this.outboundCtx = new DelegatingChannelHandlerContext(paramChannelHandlerContext, this.outboundHandler);
      this.inboundCtx = new DelegatingChannelHandlerContext(paramChannelHandlerContext, this.inboundHandler)
      {
        /* Error */
        public ChannelHandlerContext fireExceptionCaught(Throwable paramAnonymousThrowable)
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 15	io/netty/channel/CombinedChannelDuplexHandler$1:this$0	Lio/netty/channel/CombinedChannelDuplexHandler;
          //   4: invokestatic 25	io/netty/channel/CombinedChannelDuplexHandler:access$000	(Lio/netty/channel/CombinedChannelDuplexHandler;)Lio/netty/channel/CombinedChannelDuplexHandler$DelegatingChannelHandlerContext;
          //   7: getfield 29	io/netty/channel/CombinedChannelDuplexHandler$DelegatingChannelHandlerContext:removed	Z
          //   10: ifne +82 -> 92
          //   13: aload_0
          //   14: getfield 15	io/netty/channel/CombinedChannelDuplexHandler$1:this$0	Lio/netty/channel/CombinedChannelDuplexHandler;
          //   17: invokestatic 33	io/netty/channel/CombinedChannelDuplexHandler:access$100	(Lio/netty/channel/CombinedChannelDuplexHandler;)Lio/netty/channel/ChannelOutboundHandler;
          //   20: aload_0
          //   21: getfield 15	io/netty/channel/CombinedChannelDuplexHandler$1:this$0	Lio/netty/channel/CombinedChannelDuplexHandler;
          //   24: invokestatic 25	io/netty/channel/CombinedChannelDuplexHandler:access$000	(Lio/netty/channel/CombinedChannelDuplexHandler;)Lio/netty/channel/CombinedChannelDuplexHandler$DelegatingChannelHandlerContext;
          //   27: aload_1
          //   28: invokeinterface 39 3 0
          //   33: goto +65 -> 98
          //   36: astore_2
          //   37: invokestatic 43	io/netty/channel/CombinedChannelDuplexHandler:access$200	()Lio/netty/util/internal/logging/InternalLogger;
          //   40: invokeinterface 49 1 0
          //   45: ifeq +21 -> 66
          //   48: invokestatic 43	io/netty/channel/CombinedChannelDuplexHandler:access$200	()Lio/netty/util/internal/logging/InternalLogger;
          //   51: ldc 51
          //   53: aload_2
          //   54: invokestatic 57	io/netty/util/internal/ThrowableUtil:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
          //   57: aload_1
          //   58: invokeinterface 61 4 0
          //   63: goto +35 -> 98
          //   66: invokestatic 43	io/netty/channel/CombinedChannelDuplexHandler:access$200	()Lio/netty/util/internal/logging/InternalLogger;
          //   69: invokeinterface 64 1 0
          //   74: ifeq +24 -> 98
          //   77: invokestatic 43	io/netty/channel/CombinedChannelDuplexHandler:access$200	()Lio/netty/util/internal/logging/InternalLogger;
          //   80: ldc 66
          //   82: aload_2
          //   83: aload_1
          //   84: invokeinterface 69 4 0
          //   89: goto +9 -> 98
          //   92: aload_0
          //   93: aload_1
          //   94: invokespecial 71	io/netty/channel/CombinedChannelDuplexHandler$DelegatingChannelHandlerContext:fireExceptionCaught	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelHandlerContext;
          //   97: pop
          //   98: aload_0
          //   99: areturn
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	100	0	this	1
          //   0	100	1	paramAnonymousThrowable	Throwable
          //   36	47	2	localThrowable	Throwable
          // Exception table:
          //   from	to	target	type
          //   13	33	36	finally
        }
      };
      this.handlerAdded = true;
      try
      {
        this.inboundHandler.handlerAdded(this.inboundCtx);
        return;
      }
      finally
      {
        this.outboundHandler.handlerAdded(this.outboundCtx);
      }
    }
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append("init() must be invoked before being added to a ");
    paramChannelHandlerContext.append(ChannelPipeline.class.getSimpleName());
    paramChannelHandlerContext.append(" if ");
    paramChannelHandlerContext.append(CombinedChannelDuplexHandler.class.getSimpleName());
    paramChannelHandlerContext.append(" was constructed with the default constructor.");
    throw new IllegalStateException(paramChannelHandlerContext.toString());
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    try
    {
      this.inboundCtx.remove();
      return;
    }
    finally
    {
      this.outboundCtx.remove();
    }
  }
  
  protected final I inboundHandler()
  {
    return this.inboundHandler;
  }
  
  protected final void init(I paramI, O paramO)
  {
    validate(paramI, paramO);
    this.inboundHandler = paramI;
    this.outboundHandler = paramO;
  }
  
  protected final O outboundHandler()
  {
    return this.outboundHandler;
  }
  
  public void read(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext = this.outboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.outboundHandler.read(paramChannelHandlerContext);
    } else {
      paramChannelHandlerContext.read();
    }
  }
  
  public final void removeInboundHandler()
  {
    checkAdded();
    this.inboundCtx.remove();
  }
  
  public final void removeOutboundHandler()
  {
    checkAdded();
    this.outboundCtx.remove();
  }
  
  public void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    paramChannelHandlerContext = this.inboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.inboundHandler.userEventTriggered(paramChannelHandlerContext, paramObject);
    } else {
      paramChannelHandlerContext.fireUserEventTriggered(paramObject);
    }
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext = this.outboundCtx;
    if (!paramChannelHandlerContext.removed) {
      this.outboundHandler.write(paramChannelHandlerContext, paramObject, paramChannelPromise);
    } else {
      paramChannelHandlerContext.write(paramObject, paramChannelPromise);
    }
  }
  
  private static class DelegatingChannelHandlerContext
    implements ChannelHandlerContext
  {
    private final ChannelHandlerContext ctx;
    private final ChannelHandler handler;
    boolean removed;
    
    DelegatingChannelHandlerContext(ChannelHandlerContext paramChannelHandlerContext, ChannelHandler paramChannelHandler)
    {
      this.ctx = paramChannelHandlerContext;
      this.handler = paramChannelHandler;
    }
    
    /* Error */
    private void remove0()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 36	io/netty/channel/CombinedChannelDuplexHandler$DelegatingChannelHandlerContext:removed	Z
      //   4: ifne +69 -> 73
      //   7: aload_0
      //   8: iconst_1
      //   9: putfield 36	io/netty/channel/CombinedChannelDuplexHandler$DelegatingChannelHandlerContext:removed	Z
      //   12: aload_0
      //   13: getfield 26	io/netty/channel/CombinedChannelDuplexHandler$DelegatingChannelHandlerContext:handler	Lio/netty/channel/ChannelHandler;
      //   16: aload_0
      //   17: invokeinterface 42 2 0
      //   22: goto +51 -> 73
      //   25: astore_1
      //   26: new 44	java/lang/StringBuilder
      //   29: dup
      //   30: invokespecial 45	java/lang/StringBuilder:<init>	()V
      //   33: astore_2
      //   34: aload_2
      //   35: aload_0
      //   36: getfield 26	io/netty/channel/CombinedChannelDuplexHandler$DelegatingChannelHandlerContext:handler	Lio/netty/channel/ChannelHandler;
      //   39: invokevirtual 49	java/lang/Object:getClass	()Ljava/lang/Class;
      //   42: invokevirtual 55	java/lang/Class:getName	()Ljava/lang/String;
      //   45: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   48: pop
      //   49: aload_2
      //   50: ldc 61
      //   52: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   55: pop
      //   56: aload_0
      //   57: new 63	io/netty/channel/ChannelPipelineException
      //   60: dup
      //   61: aload_2
      //   62: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   65: aload_1
      //   66: invokespecial 69	io/netty/channel/ChannelPipelineException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   69: invokevirtual 73	io/netty/channel/CombinedChannelDuplexHandler$DelegatingChannelHandlerContext:fireExceptionCaught	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelHandlerContext;
      //   72: pop
      //   73: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	DelegatingChannelHandlerContext
      //   25	41	1	localThrowable	Throwable
      //   33	29	2	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   12	22	25	finally
    }
    
    public ByteBufAllocator alloc()
    {
      return this.ctx.alloc();
    }
    
    public <T> Attribute<T> attr(AttributeKey<T> paramAttributeKey)
    {
      return this.ctx.channel().attr(paramAttributeKey);
    }
    
    public ChannelFuture bind(SocketAddress paramSocketAddress)
    {
      return this.ctx.bind(paramSocketAddress);
    }
    
    public ChannelFuture bind(SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    {
      return this.ctx.bind(paramSocketAddress, paramChannelPromise);
    }
    
    public Channel channel()
    {
      return this.ctx.channel();
    }
    
    public ChannelFuture close()
    {
      return this.ctx.close();
    }
    
    public ChannelFuture close(ChannelPromise paramChannelPromise)
    {
      return this.ctx.close(paramChannelPromise);
    }
    
    public ChannelFuture connect(SocketAddress paramSocketAddress)
    {
      return this.ctx.connect(paramSocketAddress);
    }
    
    public ChannelFuture connect(SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    {
      return this.ctx.connect(paramSocketAddress, paramChannelPromise);
    }
    
    public ChannelFuture connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    {
      return this.ctx.connect(paramSocketAddress1, paramSocketAddress2);
    }
    
    public ChannelFuture connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    {
      return this.ctx.connect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
    }
    
    public ChannelFuture deregister()
    {
      return this.ctx.deregister();
    }
    
    public ChannelFuture deregister(ChannelPromise paramChannelPromise)
    {
      return this.ctx.deregister(paramChannelPromise);
    }
    
    public ChannelFuture disconnect()
    {
      return this.ctx.disconnect();
    }
    
    public ChannelFuture disconnect(ChannelPromise paramChannelPromise)
    {
      return this.ctx.disconnect(paramChannelPromise);
    }
    
    public EventExecutor executor()
    {
      return this.ctx.executor();
    }
    
    public ChannelHandlerContext fireChannelActive()
    {
      this.ctx.fireChannelActive();
      return this;
    }
    
    public ChannelHandlerContext fireChannelInactive()
    {
      this.ctx.fireChannelInactive();
      return this;
    }
    
    public ChannelHandlerContext fireChannelRead(Object paramObject)
    {
      this.ctx.fireChannelRead(paramObject);
      return this;
    }
    
    public ChannelHandlerContext fireChannelReadComplete()
    {
      this.ctx.fireChannelReadComplete();
      return this;
    }
    
    public ChannelHandlerContext fireChannelRegistered()
    {
      this.ctx.fireChannelRegistered();
      return this;
    }
    
    public ChannelHandlerContext fireChannelUnregistered()
    {
      this.ctx.fireChannelUnregistered();
      return this;
    }
    
    public ChannelHandlerContext fireChannelWritabilityChanged()
    {
      this.ctx.fireChannelWritabilityChanged();
      return this;
    }
    
    public ChannelHandlerContext fireExceptionCaught(Throwable paramThrowable)
    {
      this.ctx.fireExceptionCaught(paramThrowable);
      return this;
    }
    
    public ChannelHandlerContext fireUserEventTriggered(Object paramObject)
    {
      this.ctx.fireUserEventTriggered(paramObject);
      return this;
    }
    
    public ChannelHandlerContext flush()
    {
      this.ctx.flush();
      return this;
    }
    
    public ChannelHandler handler()
    {
      return this.ctx.handler();
    }
    
    public <T> boolean hasAttr(AttributeKey<T> paramAttributeKey)
    {
      return this.ctx.channel().hasAttr(paramAttributeKey);
    }
    
    public boolean isRemoved()
    {
      boolean bool;
      if ((!this.removed) && (!this.ctx.isRemoved())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public String name()
    {
      return this.ctx.name();
    }
    
    public ChannelFuture newFailedFuture(Throwable paramThrowable)
    {
      return this.ctx.newFailedFuture(paramThrowable);
    }
    
    public ChannelProgressivePromise newProgressivePromise()
    {
      return this.ctx.newProgressivePromise();
    }
    
    public ChannelPromise newPromise()
    {
      return this.ctx.newPromise();
    }
    
    public ChannelFuture newSucceededFuture()
    {
      return this.ctx.newSucceededFuture();
    }
    
    public ChannelPipeline pipeline()
    {
      return this.ctx.pipeline();
    }
    
    public ChannelHandlerContext read()
    {
      this.ctx.read();
      return this;
    }
    
    final void remove()
    {
      EventExecutor localEventExecutor = executor();
      if (localEventExecutor.inEventLoop()) {
        remove0();
      } else {
        localEventExecutor.execute(new Runnable()
        {
          public void run()
          {
            CombinedChannelDuplexHandler.DelegatingChannelHandlerContext.this.remove0();
          }
        });
      }
    }
    
    public ChannelPromise voidPromise()
    {
      return this.ctx.voidPromise();
    }
    
    public ChannelFuture write(Object paramObject)
    {
      return this.ctx.write(paramObject);
    }
    
    public ChannelFuture write(Object paramObject, ChannelPromise paramChannelPromise)
    {
      return this.ctx.write(paramObject, paramChannelPromise);
    }
    
    public ChannelFuture writeAndFlush(Object paramObject)
    {
      return this.ctx.writeAndFlush(paramObject);
    }
    
    public ChannelFuture writeAndFlush(Object paramObject, ChannelPromise paramChannelPromise)
    {
      return this.ctx.writeAndFlush(paramObject, paramChannelPromise);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\CombinedChannelDuplexHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */