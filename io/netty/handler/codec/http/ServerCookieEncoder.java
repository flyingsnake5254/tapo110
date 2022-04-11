package io.netty.handler.codec.http;

import java.util.Collection;
import java.util.List;

@Deprecated
public final class ServerCookieEncoder
{
  @Deprecated
  public static String encode(Cookie paramCookie)
  {
    return io.netty.handler.codec.http.cookie.ServerCookieEncoder.LAX.encode(paramCookie);
  }
  
  @Deprecated
  public static String encode(String paramString1, String paramString2)
  {
    return io.netty.handler.codec.http.cookie.ServerCookieEncoder.LAX.encode(paramString1, paramString2);
  }
  
  @Deprecated
  public static List<String> encode(Iterable<Cookie> paramIterable)
  {
    return io.netty.handler.codec.http.cookie.ServerCookieEncoder.LAX.encode(paramIterable);
  }
  
  @Deprecated
  public static List<String> encode(Collection<Cookie> paramCollection)
  {
    return io.netty.handler.codec.http.cookie.ServerCookieEncoder.LAX.encode(paramCollection);
  }
  
  @Deprecated
  public static List<String> encode(Cookie... paramVarArgs)
  {
    return io.netty.handler.codec.http.cookie.ServerCookieEncoder.LAX.encode(paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\ServerCookieEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */