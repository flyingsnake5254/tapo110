package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;

public class DefaultHttpResponse
  extends DefaultHttpMessage
  implements HttpResponse
{
  private HttpResponseStatus status;
  
  public DefaultHttpResponse(HttpVersion paramHttpVersion, HttpResponseStatus paramHttpResponseStatus)
  {
    this(paramHttpVersion, paramHttpResponseStatus, true, false);
  }
  
  public DefaultHttpResponse(HttpVersion paramHttpVersion, HttpResponseStatus paramHttpResponseStatus, HttpHeaders paramHttpHeaders)
  {
    super(paramHttpVersion, paramHttpHeaders);
    this.status = ((HttpResponseStatus)ObjectUtil.checkNotNull(paramHttpResponseStatus, "status"));
  }
  
  public DefaultHttpResponse(HttpVersion paramHttpVersion, HttpResponseStatus paramHttpResponseStatus, boolean paramBoolean)
  {
    this(paramHttpVersion, paramHttpResponseStatus, paramBoolean, false);
  }
  
  public DefaultHttpResponse(HttpVersion paramHttpVersion, HttpResponseStatus paramHttpResponseStatus, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramHttpVersion, paramBoolean1, paramBoolean2);
    this.status = ((HttpResponseStatus)ObjectUtil.checkNotNull(paramHttpResponseStatus, "status"));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DefaultHttpResponse;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    DefaultHttpResponse localDefaultHttpResponse = (DefaultHttpResponse)paramObject;
    bool1 = bool2;
    if (this.status.equals(localDefaultHttpResponse.status()))
    {
      bool1 = bool2;
      if (super.equals(paramObject)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @Deprecated
  public HttpResponseStatus getStatus()
  {
    return status();
  }
  
  public int hashCode()
  {
    return (this.status.hashCode() + 31) * 31 + super.hashCode();
  }
  
  public HttpResponse setProtocolVersion(HttpVersion paramHttpVersion)
  {
    super.setProtocolVersion(paramHttpVersion);
    return this;
  }
  
  public HttpResponse setStatus(HttpResponseStatus paramHttpResponseStatus)
  {
    this.status = ((HttpResponseStatus)ObjectUtil.checkNotNull(paramHttpResponseStatus, "status"));
    return this;
  }
  
  public HttpResponseStatus status()
  {
    return this.status;
  }
  
  public String toString()
  {
    return HttpMessageUtil.appendResponse(new StringBuilder(256), this).toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\DefaultHttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */