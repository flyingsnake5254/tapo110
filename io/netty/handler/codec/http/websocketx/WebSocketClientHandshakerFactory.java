package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.HttpHeaders;
import java.net.URI;

public final class WebSocketClientHandshakerFactory
{
  public static WebSocketClientHandshaker newHandshaker(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean, HttpHeaders paramHttpHeaders)
  {
    return newHandshaker(paramURI, paramWebSocketVersion, paramString, paramBoolean, paramHttpHeaders, 65536);
  }
  
  public static WebSocketClientHandshaker newHandshaker(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean, HttpHeaders paramHttpHeaders, int paramInt)
  {
    return newHandshaker(paramURI, paramWebSocketVersion, paramString, paramBoolean, paramHttpHeaders, paramInt, true, false);
  }
  
  public static WebSocketClientHandshaker newHandshaker(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean1, HttpHeaders paramHttpHeaders, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    return newHandshaker(paramURI, paramWebSocketVersion, paramString, paramBoolean1, paramHttpHeaders, paramInt, paramBoolean2, paramBoolean3, -1L);
  }
  
  public static WebSocketClientHandshaker newHandshaker(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean1, HttpHeaders paramHttpHeaders, int paramInt, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    WebSocketVersion localWebSocketVersion = WebSocketVersion.V13;
    if (paramWebSocketVersion == localWebSocketVersion) {
      return new WebSocketClientHandshaker13(paramURI, localWebSocketVersion, paramString, paramBoolean1, paramHttpHeaders, paramInt, paramBoolean2, paramBoolean3, paramLong);
    }
    localWebSocketVersion = WebSocketVersion.V08;
    if (paramWebSocketVersion == localWebSocketVersion) {
      return new WebSocketClientHandshaker08(paramURI, localWebSocketVersion, paramString, paramBoolean1, paramHttpHeaders, paramInt, paramBoolean2, paramBoolean3, paramLong);
    }
    localWebSocketVersion = WebSocketVersion.V07;
    if (paramWebSocketVersion == localWebSocketVersion) {
      return new WebSocketClientHandshaker07(paramURI, localWebSocketVersion, paramString, paramBoolean1, paramHttpHeaders, paramInt, paramBoolean2, paramBoolean3, paramLong);
    }
    localWebSocketVersion = WebSocketVersion.V00;
    if (paramWebSocketVersion == localWebSocketVersion) {
      return new WebSocketClientHandshaker00(paramURI, localWebSocketVersion, paramString, paramHttpHeaders, paramInt, paramLong);
    }
    paramURI = new StringBuilder();
    paramURI.append("Protocol version ");
    paramURI.append(paramWebSocketVersion);
    paramURI.append(" not supported.");
    throw new WebSocketHandshakeException(paramURI.toString());
  }
  
  public static WebSocketClientHandshaker newHandshaker(URI paramURI, WebSocketVersion paramWebSocketVersion, String paramString, boolean paramBoolean1, HttpHeaders paramHttpHeaders, int paramInt, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    WebSocketVersion localWebSocketVersion = WebSocketVersion.V13;
    if (paramWebSocketVersion == localWebSocketVersion) {
      return new WebSocketClientHandshaker13(paramURI, localWebSocketVersion, paramString, paramBoolean1, paramHttpHeaders, paramInt, paramBoolean2, paramBoolean3, paramLong, paramBoolean4);
    }
    localWebSocketVersion = WebSocketVersion.V08;
    if (paramWebSocketVersion == localWebSocketVersion) {
      return new WebSocketClientHandshaker08(paramURI, localWebSocketVersion, paramString, paramBoolean1, paramHttpHeaders, paramInt, paramBoolean2, paramBoolean3, paramLong, paramBoolean4);
    }
    localWebSocketVersion = WebSocketVersion.V07;
    if (paramWebSocketVersion == localWebSocketVersion) {
      return new WebSocketClientHandshaker07(paramURI, localWebSocketVersion, paramString, paramBoolean1, paramHttpHeaders, paramInt, paramBoolean2, paramBoolean3, paramLong, paramBoolean4);
    }
    localWebSocketVersion = WebSocketVersion.V00;
    if (paramWebSocketVersion == localWebSocketVersion) {
      return new WebSocketClientHandshaker00(paramURI, localWebSocketVersion, paramString, paramHttpHeaders, paramInt, paramLong, paramBoolean4);
    }
    paramURI = new StringBuilder();
    paramURI.append("Protocol version ");
    paramURI.append(paramWebSocketVersion);
    paramURI.append(" not supported.");
    throw new WebSocketHandshakeException(paramURI.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketClientHandshakerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */