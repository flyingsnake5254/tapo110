package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.ObjectUtil;

public class DefaultCookie
  implements Cookie
{
  private String domain;
  private boolean httpOnly;
  private long maxAge = Long.MIN_VALUE;
  private final String name;
  private String path;
  private CookieHeaderNames.SameSite sameSite;
  private boolean secure;
  private String value;
  private boolean wrap;
  
  public DefaultCookie(String paramString1, String paramString2)
  {
    paramString1 = ((String)ObjectUtil.checkNotNull(paramString1, "name")).trim();
    if (!paramString1.isEmpty())
    {
      this.name = paramString1;
      setValue(paramString2);
      return;
    }
    throw new IllegalArgumentException("empty name");
  }
  
  public int compareTo(Cookie paramCookie)
  {
    int i = name().compareTo(paramCookie.name());
    if (i != 0) {
      return i;
    }
    if (path() == null)
    {
      if (paramCookie.path() != null) {
        return -1;
      }
    }
    else
    {
      if (paramCookie.path() == null) {
        return 1;
      }
      i = path().compareTo(paramCookie.path());
      if (i != 0) {
        return i;
      }
    }
    if (domain() == null)
    {
      if (paramCookie.domain() != null) {
        return -1;
      }
      return 0;
    }
    if (paramCookie.domain() == null) {
      return 1;
    }
    return domain().compareToIgnoreCase(paramCookie.domain());
  }
  
  public String domain()
  {
    return this.domain;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Cookie)) {
      return false;
    }
    paramObject = (Cookie)paramObject;
    if (!name().equals(((Cookie)paramObject).name())) {
      return false;
    }
    if (path() == null)
    {
      if (((Cookie)paramObject).path() != null) {
        return false;
      }
    }
    else
    {
      if (((Cookie)paramObject).path() == null) {
        return false;
      }
      if (!path().equals(((Cookie)paramObject).path())) {
        return false;
      }
    }
    if (domain() == null) {
      return ((Cookie)paramObject).domain() == null;
    }
    return domain().equalsIgnoreCase(((Cookie)paramObject).domain());
  }
  
  public int hashCode()
  {
    return name().hashCode();
  }
  
  public boolean isHttpOnly()
  {
    return this.httpOnly;
  }
  
  public boolean isSecure()
  {
    return this.secure;
  }
  
  public long maxAge()
  {
    return this.maxAge;
  }
  
  public String name()
  {
    return this.name;
  }
  
  public String path()
  {
    return this.path;
  }
  
  public CookieHeaderNames.SameSite sameSite()
  {
    return this.sameSite;
  }
  
  public void setDomain(String paramString)
  {
    this.domain = CookieUtil.validateAttributeValue("domain", paramString);
  }
  
  public void setHttpOnly(boolean paramBoolean)
  {
    this.httpOnly = paramBoolean;
  }
  
  public void setMaxAge(long paramLong)
  {
    this.maxAge = paramLong;
  }
  
  public void setPath(String paramString)
  {
    this.path = CookieUtil.validateAttributeValue("path", paramString);
  }
  
  public void setSameSite(CookieHeaderNames.SameSite paramSameSite)
  {
    this.sameSite = paramSameSite;
  }
  
  public void setSecure(boolean paramBoolean)
  {
    this.secure = paramBoolean;
  }
  
  public void setValue(String paramString)
  {
    this.value = ((String)ObjectUtil.checkNotNull(paramString, "value"));
  }
  
  public void setWrap(boolean paramBoolean)
  {
    this.wrap = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = CookieUtil.stringBuilder();
    localStringBuilder.append(name());
    localStringBuilder.append('=');
    localStringBuilder.append(value());
    if (domain() != null)
    {
      localStringBuilder.append(", domain=");
      localStringBuilder.append(domain());
    }
    if (path() != null)
    {
      localStringBuilder.append(", path=");
      localStringBuilder.append(path());
    }
    if (maxAge() >= 0L)
    {
      localStringBuilder.append(", maxAge=");
      localStringBuilder.append(maxAge());
      localStringBuilder.append('s');
    }
    if (isSecure()) {
      localStringBuilder.append(", secure");
    }
    if (isHttpOnly()) {
      localStringBuilder.append(", HTTPOnly");
    }
    if (sameSite() != null)
    {
      localStringBuilder.append(", SameSite=");
      localStringBuilder.append(sameSite());
    }
    return localStringBuilder.toString();
  }
  
  @Deprecated
  protected String validateValue(String paramString1, String paramString2)
  {
    return CookieUtil.validateAttributeValue(paramString1, paramString2);
  }
  
  public String value()
  {
    return this.value;
  }
  
  public boolean wrap()
  {
    return this.wrap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\cookie\DefaultCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */