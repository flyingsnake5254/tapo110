package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.handler.codec.http.websocketx.WebSocketFrame;

public abstract interface WebSocketExtensionFilter
{
  public static final WebSocketExtensionFilter ALWAYS_SKIP = new WebSocketExtensionFilter()
  {
    public boolean mustSkip(WebSocketFrame paramAnonymousWebSocketFrame)
    {
      return true;
    }
  };
  public static final WebSocketExtensionFilter NEVER_SKIP = new WebSocketExtensionFilter()
  {
    public boolean mustSkip(WebSocketFrame paramAnonymousWebSocketFrame)
    {
      return false;
    }
  };
  
  public abstract boolean mustSkip(WebSocketFrame paramWebSocketFrame);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\extensions\WebSocketExtensionFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */