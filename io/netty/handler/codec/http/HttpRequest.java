package io.netty.handler.codec.http;

public abstract interface HttpRequest
  extends HttpMessage
{
  @Deprecated
  public abstract HttpMethod getMethod();
  
  @Deprecated
  public abstract String getUri();
  
  public abstract HttpMethod method();
  
  public abstract HttpRequest setMethod(HttpMethod paramHttpMethod);
  
  public abstract HttpRequest setProtocolVersion(HttpVersion paramHttpVersion);
  
  public abstract HttpRequest setUri(String paramString);
  
  public abstract String uri();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */