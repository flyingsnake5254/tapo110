package io.netty.handler.codec.http;

@Deprecated
public final class ClientCookieEncoder
{
  @Deprecated
  public static String encode(Cookie paramCookie)
  {
    return io.netty.handler.codec.http.cookie.ClientCookieEncoder.LAX.encode(paramCookie);
  }
  
  @Deprecated
  public static String encode(Iterable<Cookie> paramIterable)
  {
    return io.netty.handler.codec.http.cookie.ClientCookieEncoder.LAX.encode(paramIterable);
  }
  
  @Deprecated
  public static String encode(String paramString1, String paramString2)
  {
    return io.netty.handler.codec.http.cookie.ClientCookieEncoder.LAX.encode(paramString1, paramString2);
  }
  
  @Deprecated
  public static String encode(Cookie... paramVarArgs)
  {
    return io.netty.handler.codec.http.cookie.ClientCookieEncoder.LAX.encode(paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\ClientCookieEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */