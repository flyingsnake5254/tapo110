package io.netty.handler.codec.http.websocketx.extensions;

public abstract interface WebSocketExtension
{
  public static final int RSV1 = 4;
  public static final int RSV2 = 2;
  public static final int RSV3 = 1;
  
  public abstract WebSocketExtensionDecoder newExtensionDecoder();
  
  public abstract WebSocketExtensionEncoder newExtensionEncoder();
  
  public abstract int rsv();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\WebSocketExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */