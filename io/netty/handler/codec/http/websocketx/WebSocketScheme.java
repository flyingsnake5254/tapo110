package io.netty.handler.codec.http.websocketx;

import io.netty.util.AsciiString;

public final class WebSocketScheme
{
  public static final WebSocketScheme WS = new WebSocketScheme(80, "ws");
  public static final WebSocketScheme WSS = new WebSocketScheme(443, "wss");
  private final AsciiString name;
  private final int port;
  
  private WebSocketScheme(int paramInt, String paramString)
  {
    this.port = paramInt;
    this.name = AsciiString.cached(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof WebSocketScheme;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (WebSocketScheme)paramObject;
    bool1 = bool2;
    if (((WebSocketScheme)paramObject).port() == this.port)
    {
      bool1 = bool2;
      if (((WebSocketScheme)paramObject).name().equals(this.name)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.port * 31 + this.name.hashCode();
  }
  
  public AsciiString name()
  {
    return this.name;
  }
  
  public int port()
  {
    return this.port;
  }
  
  public String toString()
  {
    return this.name.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */