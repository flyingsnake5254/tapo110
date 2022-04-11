package io.netty.handler.codec.http.websocketx;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.a;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

class WebSocketClientProtocolHandshakeHandler
  extends ChannelInboundHandlerAdapter
{
  private static final long DEFAULT_HANDSHAKE_TIMEOUT_MS = 10000L;
  private ChannelHandlerContext ctx;
  private ChannelPromise handshakePromise;
  private final long handshakeTimeoutMillis;
  private final WebSocketClientHandshaker handshaker;
  
  WebSocketClientProtocolHandshakeHandler(WebSocketClientHandshaker paramWebSocketClientHandshaker)
  {
    this(paramWebSocketClientHandshaker, 10000L);
  }
  
  WebSocketClientProtocolHandshakeHandler(WebSocketClientHandshaker paramWebSocketClientHandshaker, long paramLong)
  {
    this.handshaker = paramWebSocketClientHandshaker;
    this.handshakeTimeoutMillis = ObjectUtil.checkPositive(paramLong, "handshakeTimeoutMillis");
  }
  
  private void applyHandshakeTimeout()
  {
    final ChannelPromise localChannelPromise = this.handshakePromise;
    if ((this.handshakeTimeoutMillis > 0L) && (!localChannelPromise.isDone())) {
      localChannelPromise.addListener(new a()
      {
        public void run()
        {
          if (localChannelPromise.isDone()) {
            return;
          }
          if (localChannelPromise.tryFailure(new WebSocketHandshakeException("handshake timed out"))) {
            WebSocketClientProtocolHandshakeHandler.this.ctx.flush().fireUserEventTriggered(WebSocketClientProtocolHandler.ClientHandshakeStateEvent.HANDSHAKE_TIMEOUT).close();
          }
        }
      }
      {
        public void operationComplete(io.netty.util.concurrent.Future<Void> paramAnonymousFuture)
          throws Exception
        {
          this.val$timeoutFuture.cancel(false);
        }
      });
    }
  }
  
  public void channelActive(final ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    super.channelActive(paramChannelHandlerContext);
    this.handshaker.handshake(paramChannelHandlerContext.channel()).addListener(new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        throws Exception
      {
        if (!paramAnonymousChannelFuture.isSuccess())
        {
          WebSocketClientProtocolHandshakeHandler.this.handshakePromise.tryFailure(paramAnonymousChannelFuture.cause());
          paramChannelHandlerContext.fireExceptionCaught(paramAnonymousChannelFuture.cause());
        }
        else
        {
          paramChannelHandlerContext.fireUserEventTriggered(WebSocketClientProtocolHandler.ClientHandshakeStateEvent.HANDSHAKE_ISSUED);
        }
      }
    });
    applyHandshakeTimeout();
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if (!(paramObject instanceof FullHttpResponse))
    {
      paramChannelHandlerContext.fireChannelRead(paramObject);
      return;
    }
    paramObject = (FullHttpResponse)paramObject;
    try
    {
      if (!this.handshaker.isHandshakeComplete())
      {
        this.handshaker.finishHandshake(paramChannelHandlerContext.channel(), (FullHttpResponse)paramObject);
        this.handshakePromise.trySuccess();
        paramChannelHandlerContext.fireUserEventTriggered(WebSocketClientProtocolHandler.ClientHandshakeStateEvent.HANDSHAKE_COMPLETE);
        paramChannelHandlerContext.pipeline().remove(this);
        return;
      }
      paramChannelHandlerContext = new java/lang/IllegalStateException;
      paramChannelHandlerContext.<init>("WebSocketClientHandshaker should have been non finished yet");
      throw paramChannelHandlerContext;
    }
    finally
    {
      ((ReferenceCounted)paramObject).release();
    }
  }
  
  ChannelFuture getHandshakeFuture()
  {
    return this.handshakePromise;
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.ctx = paramChannelHandlerContext;
    this.handshakePromise = paramChannelHandlerContext.newPromise();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketClientProtocolHandshakeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */