package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;

public class DefaultHttpRequest
  extends DefaultHttpMessage
  implements HttpRequest
{
  private static final int HASH_CODE_PRIME = 31;
  private HttpMethod method;
  private String uri;
  
  public DefaultHttpRequest(HttpVersion paramHttpVersion, HttpMethod paramHttpMethod, String paramString)
  {
    this(paramHttpVersion, paramHttpMethod, paramString, true);
  }
  
  public DefaultHttpRequest(HttpVersion paramHttpVersion, HttpMethod paramHttpMethod, String paramString, HttpHeaders paramHttpHeaders)
  {
    super(paramHttpVersion, paramHttpHeaders);
    this.method = ((HttpMethod)ObjectUtil.checkNotNull(paramHttpMethod, "method"));
    this.uri = ((String)ObjectUtil.checkNotNull(paramString, "uri"));
  }
  
  public DefaultHttpRequest(HttpVersion paramHttpVersion, HttpMethod paramHttpMethod, String paramString, boolean paramBoolean)
  {
    super(paramHttpVersion, paramBoolean, false);
    this.method = ((HttpMethod)ObjectUtil.checkNotNull(paramHttpMethod, "method"));
    this.uri = ((String)ObjectUtil.checkNotNull(paramString, "uri"));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DefaultHttpRequest;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    DefaultHttpRequest localDefaultHttpRequest = (DefaultHttpRequest)paramObject;
    bool1 = bool2;
    if (method().equals(localDefaultHttpRequest.method()))
    {
      bool1 = bool2;
      if (uri().equalsIgnoreCase(localDefaultHttpRequest.uri()))
      {
        bool1 = bool2;
        if (super.equals(paramObject)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @Deprecated
  public HttpMethod getMethod()
  {
    return method();
  }
  
  @Deprecated
  public String getUri()
  {
    return uri();
  }
  
  public int hashCode()
  {
    return ((this.method.hashCode() + 31) * 31 + this.uri.hashCode()) * 31 + super.hashCode();
  }
  
  public HttpMethod method()
  {
    return this.method;
  }
  
  public HttpRequest setMethod(HttpMethod paramHttpMethod)
  {
    this.method = ((HttpMethod)ObjectUtil.checkNotNull(paramHttpMethod, "method"));
    return this;
  }
  
  public HttpRequest setProtocolVersion(HttpVersion paramHttpVersion)
  {
    super.setProtocolVersion(paramHttpVersion);
    return this;
  }
  
  public HttpRequest setUri(String paramString)
  {
    this.uri = ((String)ObjectUtil.checkNotNull(paramString, "uri"));
    return this;
  }
  
  public String toString()
  {
    return HttpMessageUtil.appendRequest(new StringBuilder(256), this).toString();
  }
  
  public String uri()
  {
    return this.uri;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\DefaultHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */