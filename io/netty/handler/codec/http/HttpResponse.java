package io.netty.handler.codec.http;

public abstract interface HttpResponse
  extends HttpMessage
{
  @Deprecated
  public abstract HttpResponseStatus getStatus();
  
  public abstract HttpResponse setProtocolVersion(HttpVersion paramHttpVersion);
  
  public abstract HttpResponse setStatus(HttpResponseStatus paramHttpResponseStatus);
  
  public abstract HttpResponseStatus status();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */