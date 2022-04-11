package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
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
import java.net.URI;
import java.nio.ByteBuffer;

public class WebSocketClientHandshaker00
  extends WebSocketClientHandshaker
{
  private static final AsciiString WEBSOCKET = AsciiString.cached("WebSocket");
  private ByteBuf expectedChallengeResponseBytes;
  
  public WebSocketClientHandshaker00(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, HttpHeaders paramHttpHeaders, int paramInt)
  {
    this(paramURI, paramWebSocketVersion, paramString, paramHttpHeaders, paramInt, 10000L);
  }
  
  public WebSocketClientHandshaker00(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, HttpHeaders paramHttpHeaders, int paramInt, long paramLong)
  {
    this(paramURI, paramWebSocketVersion, paramString, paramHttpHeaders, paramInt, paramLong, false);
  }
  
  WebSocketClientHandshaker00(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, HttpHeaders paramHttpHeaders, int paramInt, long paramLong, boolean paramBoolean)
  {
    super(paramURI, paramWebSocketVersion, paramString, paramHttpHeaders, paramInt, paramLong, paramBoolean);
  }
  
  private static String insertRandomCharacters(String paramString)
  {
    int i = WebSocketUtil.randomNumber(1, 12);
    char[] arrayOfChar = new char[i];
    label13:
    int k;
    for (int j = 0; j < i; j++)
    {
      k = (int)(Math.random() * 126.0D + 33.0D);
      if (((33 >= k) || (k >= 47)) && ((58 >= k) || (k >= 126))) {
        break label13;
      }
      arrayOfChar[j] = ((char)(char)k);
    }
    for (j = 0; j < i; j++)
    {
      k = WebSocketUtil.randomNumber(0, paramString.length());
      String str1 = paramString.substring(0, k);
      String str2 = paramString.substring(k);
      paramString = new StringBuilder();
      paramString.append(str1);
      paramString.append(arrayOfChar[j]);
      paramString.append(str2);
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  private static String insertSpaces(String paramString, int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
    {
      int j = WebSocketUtil.randomNumber(1, paramString.length() - 1);
      String str1 = paramString.substring(0, j);
      String str2 = paramString.substring(j);
      paramString = new StringBuilder();
      paramString.append(str1);
      paramString.append(' ');
      paramString.append(str2);
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  protected FullHttpRequest newHandshakeRequest()
  {
    int i = WebSocketUtil.randomNumber(1, 12);
    int j = WebSocketUtil.randomNumber(1, 12);
    int k = Integer.MAX_VALUE / i;
    int m = Integer.MAX_VALUE / j;
    k = WebSocketUtil.randomNumber(0, k);
    m = WebSocketUtil.randomNumber(0, m);
    Object localObject1 = Integer.toString(k * i);
    Object localObject2 = Integer.toString(m * j);
    localObject1 = insertRandomCharacters((String)localObject1);
    localObject2 = insertRandomCharacters((String)localObject2);
    localObject1 = insertSpaces((String)localObject1, i);
    String str = insertSpaces((String)localObject2, j);
    localObject2 = WebSocketUtil.randomBytes(8);
    Object localObject3 = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject3).putInt(k);
    localObject3 = ((ByteBuffer)localObject3).array();
    Object localObject4 = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject4).putInt(m);
    Object localObject5 = ((ByteBuffer)localObject4).array();
    localObject4 = new byte[16];
    System.arraycopy(localObject3, 0, localObject4, 0, 4);
    System.arraycopy(localObject5, 0, localObject4, 4, 4);
    System.arraycopy(localObject2, 0, localObject4, 8, 8);
    this.expectedChallengeResponseBytes = Unpooled.wrappedBuffer(WebSocketUtil.md5((byte[])localObject4));
    localObject5 = uri();
    localObject3 = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, upgradeUrl((URI)localObject5), Unpooled.wrappedBuffer((byte[])localObject2));
    localObject4 = ((HttpMessage)localObject3).headers();
    HttpHeaders localHttpHeaders = this.customHeaders;
    if (localHttpHeaders != null) {
      ((HttpHeaders)localObject4).add(localHttpHeaders);
    }
    ((HttpHeaders)localObject4).set(HttpHeaderNames.UPGRADE, WEBSOCKET).set(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE).set(HttpHeaderNames.HOST, WebSocketClientHandshaker.websocketHostValue((URI)localObject5)).set(HttpHeaderNames.SEC_WEBSOCKET_KEY1, localObject1).set(HttpHeaderNames.SEC_WEBSOCKET_KEY2, str);
    localObject1 = HttpHeaderNames.ORIGIN;
    if (!((HttpHeaders)localObject4).contains((CharSequence)localObject1)) {
      ((HttpHeaders)localObject4).set((CharSequence)localObject1, WebSocketClientHandshaker.websocketOriginValue((URI)localObject5));
    }
    localObject1 = expectedSubprotocol();
    if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
      ((HttpHeaders)localObject4).set(HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL, localObject1);
    }
    ((HttpHeaders)localObject4).set(HttpHeaderNames.CONTENT_LENGTH, Integer.valueOf(localObject2.length));
    return (FullHttpRequest)localObject3;
  }
  
  protected b newWebSocketEncoder()
  {
    return new WebSocket00FrameEncoder();
  }
  
  protected a newWebsocketDecoder()
  {
    return new WebSocket00FrameDecoder(maxFramePayloadLength());
  }
  
  public WebSocketClientHandshaker00 setForceCloseTimeoutMillis(long paramLong)
  {
    super.setForceCloseTimeoutMillis(paramLong);
    return this;
  }
  
  protected void verify(FullHttpResponse paramFullHttpResponse)
  {
    if (paramFullHttpResponse.status().equals(HttpResponseStatus.SWITCHING_PROTOCOLS))
    {
      localObject1 = paramFullHttpResponse.headers();
      Object localObject2 = ((HttpHeaders)localObject1).get(HttpHeaderNames.UPGRADE);
      if (WEBSOCKET.contentEqualsIgnoreCase((CharSequence)localObject2))
      {
        localObject2 = HttpHeaderNames.CONNECTION;
        if (((HttpHeaders)localObject1).containsValue((CharSequence)localObject2, HttpHeaderValues.UPGRADE, true))
        {
          if (paramFullHttpResponse.content().equals(this.expectedChallengeResponseBytes)) {
            return;
          }
          throw new WebSocketHandshakeException("Invalid challenge");
        }
        paramFullHttpResponse = new StringBuilder();
        paramFullHttpResponse.append("Invalid handshake response connection: ");
        paramFullHttpResponse.append(((HttpHeaders)localObject1).get((CharSequence)localObject2));
        throw new WebSocketHandshakeException(paramFullHttpResponse.toString());
      }
      paramFullHttpResponse = new StringBuilder();
      paramFullHttpResponse.append("Invalid handshake response upgrade: ");
      paramFullHttpResponse.append(localObject2);
      throw new WebSocketHandshakeException(paramFullHttpResponse.toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Invalid handshake response getStatus: ");
    ((StringBuilder)localObject1).append(paramFullHttpResponse.status());
    throw new WebSocketHandshakeException(((StringBuilder)localObject1).toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketClientHandshaker00.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */