package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.a;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

class WebSocketServerProtocolHandshakeHandler
  extends ChannelInboundHandlerAdapter
{
  private ChannelHandlerContext ctx;
  private ChannelPromise handshakePromise;
  private final WebSocketServerProtocolConfig serverConfig;
  
  WebSocketServerProtocolHandshakeHandler(WebSocketServerProtocolConfig paramWebSocketServerProtocolConfig)
  {
    this.serverConfig = ((WebSocketServerProtocolConfig)ObjectUtil.checkNotNull(paramWebSocketServerProtocolConfig, "serverConfig"));
  }
  
  private void applyHandshakeTimeout()
  {
    final ChannelPromise localChannelPromise = this.handshakePromise;
    long l = this.serverConfig.handshakeTimeoutMillis();
    if ((l > 0L) && (!localChannelPromise.isDone())) {
      localChannelPromise.addListener(new a()
      {
        public void run()
        {
          if ((!localChannelPromise.isDone()) && (localChannelPromise.tryFailure(new WebSocketHandshakeException("handshake timed out")))) {
            WebSocketServerProtocolHandshakeHandler.this.ctx.flush().fireUserEventTriggered(WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_TIMEOUT).close();
          }
        }
      }
      {
        public void operationComplete(io.netty.util.concurrent.Future<Void> paramAnonymousFuture)
        {
          this.val$timeoutFuture.cancel(false);
        }
      });
    }
  }
  
  private static String getWebSocketLocation(ChannelPipeline paramChannelPipeline, HttpRequest paramHttpRequest, String paramString)
  {
    if (paramChannelPipeline.get(SslHandler.class) != null) {
      paramChannelPipeline = "wss";
    } else {
      paramChannelPipeline = "ws";
    }
    paramHttpRequest = paramHttpRequest.headers().get(HttpHeaderNames.HOST);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramChannelPipeline);
    localStringBuilder.append("://");
    localStringBuilder.append(paramHttpRequest);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private boolean isNotWebSocketPath(FullHttpRequest paramFullHttpRequest)
  {
    String str = this.serverConfig.websocketPath();
    boolean bool1 = this.serverConfig.checkStartsWith();
    boolean bool2 = true;
    paramFullHttpRequest = paramFullHttpRequest.uri();
    if (bool1 ? paramFullHttpRequest.startsWith(str) : paramFullHttpRequest.equals(str)) {
      bool2 = false;
    }
    return bool2;
  }
  
  private static void sendHttpResponse(ChannelHandlerContext paramChannelHandlerContext, HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
  {
    paramChannelHandlerContext = paramChannelHandlerContext.channel().writeAndFlush(paramHttpResponse);
    if ((!HttpUtil.isKeepAlive(paramHttpRequest)) || (paramHttpResponse.status().code() != 200)) {
      paramChannelHandlerContext.addListener(ChannelFutureListener.CLOSE);
    }
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    FullHttpRequest localFullHttpRequest = (FullHttpRequest)paramObject;
    if (isNotWebSocketPath(localFullHttpRequest))
    {
      paramChannelHandlerContext.fireChannelRead(paramObject);
      return;
    }
    try
    {
      if (!HttpMethod.GET.equals(localFullHttpRequest.method()))
      {
        paramObject = new io/netty/handler/codec/http/DefaultFullHttpResponse;
        ((DefaultFullHttpResponse)paramObject).<init>(HttpVersion.HTTP_1_1, HttpResponseStatus.FORBIDDEN, paramChannelHandlerContext.alloc().buffer(0));
        sendHttpResponse(paramChannelHandlerContext, localFullHttpRequest, (HttpResponse)paramObject);
        return;
      }
      paramObject = new io/netty/handler/codec/http/websocketx/WebSocketServerHandshakerFactory;
      ((WebSocketServerHandshakerFactory)paramObject).<init>(getWebSocketLocation(paramChannelHandlerContext.pipeline(), localFullHttpRequest, this.serverConfig.websocketPath()), this.serverConfig.subprotocols(), this.serverConfig.decoderConfig());
      WebSocketServerHandshaker localWebSocketServerHandshaker = ((WebSocketServerHandshakerFactory)paramObject).newHandshaker(localFullHttpRequest);
      paramObject = this.handshakePromise;
      if (localWebSocketServerHandshaker == null)
      {
        WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(paramChannelHandlerContext.channel());
      }
      else
      {
        WebSocketServerProtocolHandler.setHandshaker(paramChannelHandlerContext.channel(), localWebSocketServerHandshaker);
        paramChannelHandlerContext.pipeline().remove(this);
        ChannelFuture localChannelFuture = localWebSocketServerHandshaker.handshake(paramChannelHandlerContext.channel(), localFullHttpRequest);
        ChannelFutureListener local1 = new io/netty/handler/codec/http/websocketx/WebSocketServerProtocolHandshakeHandler$1;
        local1.<init>(this, (ChannelPromise)paramObject, paramChannelHandlerContext, localFullHttpRequest, localWebSocketServerHandshaker);
        localChannelFuture.addListener(local1);
        applyHandshakeTimeout();
      }
      return;
    }
    finally
    {
      localFullHttpRequest.release();
    }
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
  {
    this.ctx = paramChannelHandlerContext;
    this.handshakePromise = paramChannelHandlerContext.newPromise();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketServerProtocolHandshakeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */