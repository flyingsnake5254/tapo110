package io.netty.handler.proxy;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.channel.PendingWriteQueue;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.c;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.nio.channels.ConnectionPendingException;
import java.util.concurrent.TimeUnit;

public abstract class ProxyHandler
  extends ChannelDuplexHandler
{
  static final String AUTH_NONE = "none";
  private static final long DEFAULT_CONNECT_TIMEOUT_MILLIS = 10000L;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ProxyHandler.class);
  private final LazyChannelPromise connectPromise = new LazyChannelPromise(null);
  private c<?> connectTimeoutFuture;
  private volatile long connectTimeoutMillis = 10000L;
  private volatile ChannelHandlerContext ctx;
  private volatile SocketAddress destinationAddress;
  private boolean finished;
  private boolean flushedPrematurely;
  private PendingWriteQueue pendingWrites;
  private final SocketAddress proxyAddress;
  private boolean suppressChannelReadComplete;
  private final ChannelFutureListener writeListener = new ChannelFutureListener()
  {
    public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
      throws Exception
    {
      if (!paramAnonymousChannelFuture.isSuccess()) {
        ProxyHandler.this.setConnectFailure(paramAnonymousChannelFuture.cause());
      }
    }
  };
  
  protected ProxyHandler(SocketAddress paramSocketAddress)
  {
    this.proxyAddress = ((SocketAddress)ObjectUtil.checkNotNull(paramSocketAddress, "proxyAddress"));
  }
  
  private void addPendingWrite(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
  {
    PendingWriteQueue localPendingWriteQueue1 = this.pendingWrites;
    PendingWriteQueue localPendingWriteQueue2 = localPendingWriteQueue1;
    if (localPendingWriteQueue1 == null)
    {
      localPendingWriteQueue2 = new PendingWriteQueue(paramChannelHandlerContext);
      this.pendingWrites = localPendingWriteQueue2;
    }
    localPendingWriteQueue2.add(paramObject, paramChannelPromise);
  }
  
  private void cancelConnectTimeoutFuture()
  {
    c localc = this.connectTimeoutFuture;
    if (localc != null)
    {
      localc.cancel(false);
      this.connectTimeoutFuture = null;
    }
  }
  
  private void failPendingWrites(Throwable paramThrowable)
  {
    PendingWriteQueue localPendingWriteQueue = this.pendingWrites;
    if (localPendingWriteQueue != null)
    {
      localPendingWriteQueue.removeAndFailAll(paramThrowable);
      this.pendingWrites = null;
    }
  }
  
  private void failPendingWritesAndClose(Throwable paramThrowable)
  {
    failPendingWrites(paramThrowable);
    this.connectPromise.tryFailure(paramThrowable);
    this.ctx.fireExceptionCaught(paramThrowable);
    this.ctx.close();
  }
  
  private static void readIfNeeded(ChannelHandlerContext paramChannelHandlerContext)
  {
    if (!paramChannelHandlerContext.channel().config().isAutoRead()) {
      paramChannelHandlerContext.read();
    }
  }
  
  private boolean safeRemoveDecoder()
  {
    try
    {
      removeDecoder(this.ctx);
      return true;
    }
    catch (Exception localException)
    {
      logger.warn("Failed to remove proxy decoders:", localException);
    }
    return false;
  }
  
  private boolean safeRemoveEncoder()
  {
    try
    {
      removeEncoder(this.ctx);
      return true;
    }
    catch (Exception localException)
    {
      logger.warn("Failed to remove proxy encoders:", localException);
    }
    return false;
  }
  
  private void sendInitialMessage(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    long l = this.connectTimeoutMillis;
    if (l > 0L) {
      this.connectTimeoutFuture = paramChannelHandlerContext.executor().schedule(new Runnable()
      {
        public void run()
        {
          if (!ProxyHandler.this.connectPromise.isDone()) {
            ProxyHandler.this.setConnectFailure(new ProxyConnectException(ProxyHandler.this.exceptionMessage("timeout")));
          }
        }
      }, l, TimeUnit.MILLISECONDS);
    }
    Object localObject = newInitialMessage(paramChannelHandlerContext);
    if (localObject != null) {
      sendToProxyServer(localObject);
    }
    readIfNeeded(paramChannelHandlerContext);
  }
  
  private void setConnectFailure(Throwable paramThrowable)
  {
    this.finished = true;
    cancelConnectTimeoutFuture();
    if (!this.connectPromise.isDone())
    {
      Object localObject = paramThrowable;
      if (!(paramThrowable instanceof ProxyConnectException)) {
        localObject = new ProxyConnectException(exceptionMessage(paramThrowable.toString()), paramThrowable);
      }
      safeRemoveDecoder();
      safeRemoveEncoder();
      failPendingWritesAndClose((Throwable)localObject);
    }
  }
  
  private void setConnectSuccess()
  {
    this.finished = true;
    cancelConnectTimeoutFuture();
    if (!this.connectPromise.isDone())
    {
      boolean bool = safeRemoveEncoder();
      this.ctx.fireUserEventTriggered(new ProxyConnectionEvent(protocol(), authScheme(), this.proxyAddress, this.destinationAddress));
      if ((true & bool & safeRemoveDecoder()))
      {
        writePendingWrites();
        if (this.flushedPrematurely) {
          this.ctx.flush();
        }
        this.connectPromise.trySuccess(this.ctx.channel());
      }
      else
      {
        failPendingWritesAndClose(new ProxyConnectException("failed to remove all codec handlers added by the proxy handler; bug?"));
      }
    }
  }
  
  private void writePendingWrites()
  {
    PendingWriteQueue localPendingWriteQueue = this.pendingWrites;
    if (localPendingWriteQueue != null)
    {
      localPendingWriteQueue.removeAndWriteAll();
      this.pendingWrites = null;
    }
  }
  
  protected abstract void addCodec(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception;
  
  public abstract String authScheme();
  
  public final void channelActive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    sendInitialMessage(paramChannelHandlerContext);
    paramChannelHandlerContext.fireChannelActive();
  }
  
  public final void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.finished) {
      paramChannelHandlerContext.fireChannelInactive();
    } else {
      setConnectFailure(new ProxyConnectException(exceptionMessage("disconnected")));
    }
  }
  
  /* Error */
  public final void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 209	io/netty/handler/proxy/ProxyHandler:finished	Z
    //   4: ifeq +19 -> 23
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 289	io/netty/handler/proxy/ProxyHandler:suppressChannelReadComplete	Z
    //   12: aload_1
    //   13: aload_2
    //   14: invokeinterface 292 2 0
    //   19: pop
    //   20: goto +40 -> 60
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 289	io/netty/handler/proxy/ProxyHandler:suppressChannelReadComplete	Z
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: invokevirtual 296	io/netty/handler/proxy/ProxyHandler:handleResponse	(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Object;)Z
    //   34: ifeq +7 -> 41
    //   37: aload_0
    //   38: invokespecial 298	io/netty/handler/proxy/ProxyHandler:setConnectSuccess	()V
    //   41: aload_2
    //   42: invokestatic 303	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   45: pop
    //   46: goto +14 -> 60
    //   49: astore_1
    //   50: aload_2
    //   51: invokestatic 303	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   54: pop
    //   55: aload_0
    //   56: aload_1
    //   57: invokespecial 84	io/netty/handler/proxy/ProxyHandler:setConnectFailure	(Ljava/lang/Throwable;)V
    //   60: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	ProxyHandler
    //   0	61	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	61	2	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	41	49	finally
  }
  
  public final void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.suppressChannelReadComplete)
    {
      this.suppressChannelReadComplete = false;
      readIfNeeded(paramChannelHandlerContext);
    }
    else
    {
      paramChannelHandlerContext.fireChannelReadComplete();
    }
  }
  
  public final void connect(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if (this.destinationAddress != null)
    {
      paramChannelPromise.setFailure(new ConnectionPendingException());
      return;
    }
    this.destinationAddress = paramSocketAddress1;
    paramChannelHandlerContext.connect(this.proxyAddress, paramSocketAddress2, paramChannelPromise);
  }
  
  public final Future<Channel> connectFuture()
  {
    return this.connectPromise;
  }
  
  public final long connectTimeoutMillis()
  {
    return this.connectTimeoutMillis;
  }
  
  public final <T extends SocketAddress> T destinationAddress()
  {
    return this.destinationAddress;
  }
  
  public final void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    if (this.finished) {
      paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
    } else {
      setConnectFailure(paramThrowable);
    }
  }
  
  protected final String exceptionMessage(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder(str.length() + 128);
    paramString.append(protocol());
    paramString.append(", ");
    paramString.append(authScheme());
    paramString.append(", ");
    paramString.append(this.proxyAddress);
    paramString.append(" => ");
    paramString.append(this.destinationAddress);
    if (!str.isEmpty())
    {
      paramString.append(", ");
      paramString.append(str);
    }
    return paramString.toString();
  }
  
  public final void flush(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.finished)
    {
      writePendingWrites();
      paramChannelHandlerContext.flush();
    }
    else
    {
      this.flushedPrematurely = true;
    }
  }
  
  protected abstract boolean handleResponse(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception;
  
  public final void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.ctx = paramChannelHandlerContext;
    addCodec(paramChannelHandlerContext);
    if (paramChannelHandlerContext.channel().isActive()) {
      sendInitialMessage(paramChannelHandlerContext);
    }
  }
  
  public final boolean isConnected()
  {
    return this.connectPromise.isSuccess();
  }
  
  protected abstract Object newInitialMessage(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception;
  
  public abstract String protocol();
  
  public final <T extends SocketAddress> T proxyAddress()
  {
    return this.proxyAddress;
  }
  
  protected abstract void removeDecoder(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception;
  
  protected abstract void removeEncoder(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception;
  
  protected final void sendToProxyServer(Object paramObject)
  {
    this.ctx.writeAndFlush(paramObject).addListener(this.writeListener);
  }
  
  public final void setConnectTimeoutMillis(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = 0L;
    }
    this.connectTimeoutMillis = l;
  }
  
  public final void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if (this.finished)
    {
      writePendingWrites();
      paramChannelHandlerContext.write(paramObject, paramChannelPromise);
    }
    else
    {
      addPendingWrite(paramChannelHandlerContext, paramObject, paramChannelPromise);
    }
  }
  
  private final class LazyChannelPromise
    extends DefaultPromise<Channel>
  {
    private LazyChannelPromise() {}
    
    protected EventExecutor executor()
    {
      if (ProxyHandler.this.ctx != null) {
        return ProxyHandler.this.ctx.executor();
      }
      throw new IllegalStateException();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\proxy\ProxyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */