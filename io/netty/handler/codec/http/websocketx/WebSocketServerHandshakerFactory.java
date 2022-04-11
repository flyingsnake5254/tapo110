package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.internal.ObjectUtil;

public class WebSocketServerHandshakerFactory
{
  private final WebSocketDecoderConfig decoderConfig;
  private final String subprotocols;
  private final String webSocketURL;
  
  public WebSocketServerHandshakerFactory(String paramString1, String paramString2, WebSocketDecoderConfig paramWebSocketDecoderConfig)
  {
    this.webSocketURL = paramString1;
    this.subprotocols = paramString2;
    this.decoderConfig = ((WebSocketDecoderConfig)ObjectUtil.checkNotNull(paramWebSocketDecoderConfig, "decoderConfig"));
  }
  
  public WebSocketServerHandshakerFactory(String paramString1, String paramString2, boolean paramBoolean)
  {
    this(paramString1, paramString2, paramBoolean, 65536);
  }
  
  public WebSocketServerHandshakerFactory(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    this(paramString1, paramString2, paramBoolean, paramInt, false);
  }
  
  public WebSocketServerHandshakerFactory(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this(paramString1, paramString2, WebSocketDecoderConfig.newBuilder().allowExtensions(paramBoolean1).maxFramePayloadLength(paramInt).allowMaskMismatch(paramBoolean2).build());
  }
  
  public static ChannelFuture sendUnsupportedVersionResponse(Channel paramChannel)
  {
    return sendUnsupportedVersionResponse(paramChannel, paramChannel.newPromise());
  }
  
  public static ChannelFuture sendUnsupportedVersionResponse(Channel paramChannel, ChannelPromise paramChannelPromise)
  {
    DefaultFullHttpResponse localDefaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.UPGRADE_REQUIRED, paramChannel.alloc().buffer(0));
    localDefaultFullHttpResponse.headers().set(HttpHeaderNames.SEC_WEBSOCKET_VERSION, WebSocketVersion.V13.toHttpHeaderValue());
    HttpUtil.setContentLength(localDefaultFullHttpResponse, 0L);
    return paramChannel.writeAndFlush(localDefaultFullHttpResponse, paramChannelPromise);
  }
  
  @Deprecated
  public static void sendUnsupportedWebSocketVersionResponse(Channel paramChannel)
  {
    sendUnsupportedVersionResponse(paramChannel);
  }
  
  public WebSocketServerHandshaker newHandshaker(HttpRequest paramHttpRequest)
  {
    paramHttpRequest = paramHttpRequest.headers().get(HttpHeaderNames.SEC_WEBSOCKET_VERSION);
    if (paramHttpRequest != null)
    {
      if (paramHttpRequest.equals(WebSocketVersion.V13.toHttpHeaderValue())) {
        return new WebSocketServerHandshaker13(this.webSocketURL, this.subprotocols, this.decoderConfig);
      }
      if (paramHttpRequest.equals(WebSocketVersion.V08.toHttpHeaderValue())) {
        return new WebSocketServerHandshaker08(this.webSocketURL, this.subprotocols, this.decoderConfig);
      }
      if (paramHttpRequest.equals(WebSocketVersion.V07.toHttpHeaderValue())) {
        return new WebSocketServerHandshaker07(this.webSocketURL, this.subprotocols, this.decoderConfig);
      }
      return null;
    }
    return new WebSocketServerHandshaker00(this.webSocketURL, this.subprotocols, this.decoderConfig);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketServerHandshakerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */