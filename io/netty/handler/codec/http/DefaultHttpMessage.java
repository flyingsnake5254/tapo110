package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;

public abstract class DefaultHttpMessage
  extends DefaultHttpObject
  implements HttpMessage
{
  private static final int HASH_CODE_PRIME = 31;
  private final HttpHeaders headers;
  private HttpVersion version;
  
  protected DefaultHttpMessage(HttpVersion paramHttpVersion)
  {
    this(paramHttpVersion, true, false);
  }
  
  protected DefaultHttpMessage(HttpVersion paramHttpVersion, HttpHeaders paramHttpHeaders)
  {
    this.version = ((HttpVersion)ObjectUtil.checkNotNull(paramHttpVersion, "version"));
    this.headers = ((HttpHeaders)ObjectUtil.checkNotNull(paramHttpHeaders, "headers"));
  }
  
  protected DefaultHttpMessage(HttpVersion paramHttpVersion, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramHttpVersion, (HttpHeaders)localObject);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DefaultHttpMessage;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    DefaultHttpMessage localDefaultHttpMessage = (DefaultHttpMessage)paramObject;
    bool1 = bool2;
    if (headers().equals(localDefaultHttpMessage.headers()))
    {
      bool1 = bool2;
      if (protocolVersion().equals(localDefaultHttpMessage.protocolVersion()))
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
  public HttpVersion getProtocolVersion()
  {
    return protocolVersion();
  }
  
  public int hashCode()
  {
    return ((this.headers.hashCode() + 31) * 31 + this.version.hashCode()) * 31 + super.hashCode();
  }
  
  public HttpHeaders headers()
  {
    return this.headers;
  }
  
  public HttpVersion protocolVersion()
  {
    return this.version;
  }
  
  public HttpMessage setProtocolVersion(HttpVersion paramHttpVersion)
  {
    this.version = ((HttpVersion)ObjectUtil.checkNotNull(paramHttpVersion, "version"));
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\DefaultHttpMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */