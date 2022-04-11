package io.netty.handler.codec.http.websocketx.extensions;

public abstract interface WebSocketClientExtensionHandshaker
{
  public abstract a handshakeExtension(WebSocketExtensionData paramWebSocketExtensionData);
  
  public abstract WebSocketExtensionData newRequestData();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\WebSocketClientExtensionHandshaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */