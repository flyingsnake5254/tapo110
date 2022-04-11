package io.netty.handler.codec.http;

import io.netty.util.AsciiString;

public final class HttpScheme
{
  public static final HttpScheme HTTP = new HttpScheme(80, "http");
  public static final HttpScheme HTTPS = new HttpScheme(443, "https");
  private final AsciiString name;
  private final int port;
  
  private HttpScheme(int paramInt, String paramString)
  {
    this.port = paramInt;
    this.name = AsciiString.cached(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof HttpScheme;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (HttpScheme)paramObject;
    bool1 = bool2;
    if (((HttpScheme)paramObject).port() == this.port)
    {
      bool1 = bool2;
      if (((HttpScheme)paramObject).name().equals(this.name)) {
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */