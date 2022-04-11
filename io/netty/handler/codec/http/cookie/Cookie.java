package io.netty.handler.codec.http.cookie;

public abstract interface Cookie
  extends Comparable<Cookie>
{
  public static final long UNDEFINED_MAX_AGE = Long.MIN_VALUE;
  
  public abstract String domain();
  
  public abstract boolean isHttpOnly();
  
  public abstract boolean isSecure();
  
  public abstract long maxAge();
  
  public abstract String name();
  
  public abstract String path();
  
  public abstract void setDomain(String paramString);
  
  public abstract void setHttpOnly(boolean paramBoolean);
  
  public abstract void setMaxAge(long paramLong);
  
  public abstract void setPath(String paramString);
  
  public abstract void setSecure(boolean paramBoolean);
  
  public abstract void setValue(String paramString);
  
  public abstract void setWrap(boolean paramBoolean);
  
  public abstract String value();
  
  public abstract boolean wrap();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\cookie\Cookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */