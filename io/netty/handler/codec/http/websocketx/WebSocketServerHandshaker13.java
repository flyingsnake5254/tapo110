package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;

public class WebSocketServerHandshaker13
  extends WebSocketServerHandshaker
{
  public static final String WEBSOCKET_13_ACCEPT_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
  
  public WebSocketServerHandshaker13(String paramString1, String paramString2, WebSocketDecoderConfig paramWebSocketDecoderConfig)
  {
    super(WebSocketVersion.V13, paramString1, paramString2, paramWebSocketDecoderConfig);
  }
  
  public WebSocketServerHandshaker13(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    this(paramString1, paramString2, paramBoolean, paramInt, false);
  }
  
  public WebSocketServerHandshaker13(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this(paramString1, paramString2, WebSocketDecoderConfig.newBuilder().allowExtensions(paramBoolean1).maxFramePayloadLength(paramInt).allowMaskMismatch(paramBoolean2).build());
  }
  
  protected FullHttpResponse newHandshakeResponse(FullHttpRequest paramFullHttpRequest, HttpHeaders paramHttpHeaders)
  {
    Object localObject = paramFullHttpRequest.headers().get(HttpHeaderNames.SEC_WEBSOCKET_KEY);
    if (localObject != null)
    {
      DefaultFullHttpResponse localDefaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.SWITCHING_PROTOCOLS, paramFullHttpRequest.content().alloc().buffer(0));
      if (paramHttpHeaders != null) {
        localDefaultFullHttpResponse.headers().add(paramHttpHeaders);
      }
      paramHttpHeaders = new StringBuilder();
      paramHttpHeaders.append(localObject);
      paramHttpHeaders.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
      String str = WebSocketUtil.base64(WebSocketUtil.sha1(paramHttpHeaders.toString().getBytes(CharsetUtil.US_ASCII)));
      paramHttpHeaders = WebSocketServerHandshaker.logger;
      if (paramHttpHeaders.isDebugEnabled()) {
        paramHttpHeaders.debug("WebSocket version 13 server handshake key: {}, response: {}", localObject, str);
      }
      localDefaultFullHttpResponse.headers().set(HttpHeaderNames.UPGRADE, HttpHeaderValues.WEBSOCKET).set(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE).set(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT, str);
      localObject = paramFullHttpRequest.headers();
      paramFullHttpRequest = HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL;
      localObject = ((HttpHeaders)localObject).get(paramFullHttpRequest);
      if (localObject != null)
      {
        str = selectSubprotocol((String)localObject);
        if (str == null)
        {
          if (paramHttpHeaders.isDebugEnabled()) {
            paramHttpHeaders.debug("Requested subprotocol(s) not supported: {}", localObject);
          }
        }
        else {
          localDefaultFullHttpResponse.headers().add(paramFullHttpRequest, str);
        }
      }
      return localDefaultFullHttpResponse;
    }
    throw new WebSocketHandshakeException("not a WebSocket request: missing key");
  }
  
  protected b newWebSocketEncoder()
  {
    return new WebSocket13FrameEncoder(false);
  }
  
  protected a newWebsocketDecoder()
  {
    return new WebSocket13FrameDecoder(decoderConfig());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketServerHandshaker13.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */