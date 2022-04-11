package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.URI;

public class WebSocketClientHandshaker08
  extends WebSocketClientHandshaker
{
  public static final String MAGIC_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(WebSocketClientHandshaker08.class);
  private final boolean allowExtensions;
  private final boolean allowMaskMismatch;
  private String expectedChallengeResponseString;
  private final boolean performMasking;
  
  public WebSocketClientHandshaker08(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean, HttpHeaders paramHttpHeaders, int paramInt)
  {
    this(paramURI, paramWebSocketVersion, paramString, paramBoolean, paramHttpHeaders, paramInt, true, false, 10000L);
  }
  
  public WebSocketClientHandshaker08(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean1, HttpHeaders paramHttpHeaders, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramURI, paramWebSocketVersion, paramString, paramBoolean1, paramHttpHeaders, paramInt, paramBoolean2, paramBoolean3, 10000L);
  }
  
  public WebSocketClientHandshaker08(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean1, HttpHeaders paramHttpHeaders, int paramInt, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    this(paramURI, paramWebSocketVersion, paramString, paramBoolean1, paramHttpHeaders, paramInt, paramBoolean2, paramBoolean3, paramLong, false);
  }
  
  WebSocketClientHandshaker08(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean1, HttpHeaders paramHttpHeaders, int paramInt, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    super(paramURI, paramWebSocketVersion, paramString, paramHttpHeaders, paramInt, paramLong, paramBoolean4);
    this.allowExtensions = paramBoolean1;
    this.performMasking = paramBoolean2;
    this.allowMaskMismatch = paramBoolean3;
  }
  
  protected FullHttpRequest newHandshakeRequest()
  {
    Object localObject1 = uri();
    Object localObject2 = WebSocketUtil.base64(WebSocketUtil.randomBytes(16));
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
    this.expectedChallengeResponseString = WebSocketUtil.base64(WebSocketUtil.sha1(((StringBuilder)localObject3).toString().getBytes(CharsetUtil.US_ASCII)));
    localObject3 = logger;
    if (((InternalLogger)localObject3).isDebugEnabled()) {
      ((InternalLogger)localObject3).debug("WebSocket version 08 client handshake key: {}, expected response: {}", localObject2, this.expectedChallengeResponseString);
    }
    localObject3 = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, upgradeUrl((URI)localObject1), Unpooled.EMPTY_BUFFER);
    HttpHeaders localHttpHeaders = ((HttpMessage)localObject3).headers();
    Object localObject4 = this.customHeaders;
    if (localObject4 != null)
    {
      localHttpHeaders.add((HttpHeaders)localObject4);
      localObject4 = HttpHeaderNames.HOST;
      if (!localHttpHeaders.contains((CharSequence)localObject4)) {
        localHttpHeaders.set((CharSequence)localObject4, WebSocketClientHandshaker.websocketHostValue((URI)localObject1));
      }
    }
    else
    {
      localHttpHeaders.set(HttpHeaderNames.HOST, WebSocketClientHandshaker.websocketHostValue((URI)localObject1));
    }
    localHttpHeaders.set(HttpHeaderNames.UPGRADE, HttpHeaderValues.WEBSOCKET).set(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE).set(HttpHeaderNames.SEC_WEBSOCKET_KEY, localObject2);
    localObject2 = HttpHeaderNames.SEC_WEBSOCKET_ORIGIN;
    if (!localHttpHeaders.contains((CharSequence)localObject2)) {
      localHttpHeaders.set((CharSequence)localObject2, WebSocketClientHandshaker.websocketOriginValue((URI)localObject1));
    }
    localObject1 = expectedSubprotocol();
    if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
      localHttpHeaders.set(HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL, localObject1);
    }
    localHttpHeaders.set(HttpHeaderNames.SEC_WEBSOCKET_VERSION, version().toAsciiString());
    return (FullHttpRequest)localObject3;
  }
  
  protected b newWebSocketEncoder()
  {
    return new WebSocket08FrameEncoder(this.performMasking);
  }
  
  protected a newWebsocketDecoder()
  {
    return new WebSocket08FrameDecoder(false, this.allowExtensions, maxFramePayloadLength(), this.allowMaskMismatch);
  }
  
  public WebSocketClientHandshaker08 setForceCloseTimeoutMillis(long paramLong)
  {
    super.setForceCloseTimeoutMillis(paramLong);
    return this;
  }
  
  protected void verify(FullHttpResponse paramFullHttpResponse)
  {
    Object localObject1 = HttpResponseStatus.SWITCHING_PROTOCOLS;
    Object localObject2 = paramFullHttpResponse.headers();
    if (paramFullHttpResponse.status().equals(localObject1))
    {
      paramFullHttpResponse = ((HttpHeaders)localObject2).get(HttpHeaderNames.UPGRADE);
      if (HttpHeaderValues.WEBSOCKET.contentEqualsIgnoreCase(paramFullHttpResponse))
      {
        localObject1 = HttpHeaderNames.CONNECTION;
        if (((HttpHeaders)localObject2).containsValue((CharSequence)localObject1, HttpHeaderValues.UPGRADE, true))
        {
          paramFullHttpResponse = ((HttpHeaders)localObject2).get(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT);
          if ((paramFullHttpResponse != null) && (paramFullHttpResponse.equals(this.expectedChallengeResponseString))) {
            return;
          }
          throw new WebSocketHandshakeException(String.format("Invalid challenge. Actual: %s. Expected: %s", new Object[] { paramFullHttpResponse, this.expectedChallengeResponseString }));
        }
        paramFullHttpResponse = new StringBuilder();
        paramFullHttpResponse.append("Invalid handshake response connection: ");
        paramFullHttpResponse.append(((HttpHeaders)localObject2).get((CharSequence)localObject1));
        throw new WebSocketHandshakeException(paramFullHttpResponse.toString());
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Invalid handshake response upgrade: ");
      ((StringBuilder)localObject2).append(paramFullHttpResponse);
      throw new WebSocketHandshakeException(((StringBuilder)localObject2).toString());
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Invalid handshake response getStatus: ");
    ((StringBuilder)localObject2).append(paramFullHttpResponse.status());
    throw new WebSocketHandshakeException(((StringBuilder)localObject2).toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketClientHandshaker08.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */