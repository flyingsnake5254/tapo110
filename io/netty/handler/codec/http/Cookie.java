package io.netty.handler.codec.http;

import java.util.Set;

@Deprecated
public abstract interface Cookie
  extends io.netty.handler.codec.http.cookie.Cookie
{
  @Deprecated
  public abstract String comment();
  
  @Deprecated
  public abstract String commentUrl();
  
  @Deprecated
  public abstract String getComment();
  
  @Deprecated
  public abstract String getCommentUrl();
  
  @Deprecated
  public abstract String getDomain();
  
  @Deprecated
  public abstract long getMaxAge();
  
  @Deprecated
  public abstract String getName();
  
  @Deprecated
  public abstract String getPath();
  
  @Deprecated
  public abstract Set<Integer> getPorts();
  
  @Deprecated
  public abstract String getValue();
  
  @Deprecated
  public abstract int getVersion();
  
  @Deprecated
  public abstract boolean isDiscard();
  
  @Deprecated
  public abstract long maxAge();
  
  @Deprecated
  public abstract Set<Integer> ports();
  
  @Deprecated
  public abstract void setComment(String paramString);
  
  @Deprecated
  public abstract void setCommentUrl(String paramString);
  
  @Deprecated
  public abstract void setDiscard(boolean paramBoolean);
  
  @Deprecated
  public abstract void setMaxAge(long paramLong);
  
  @Deprecated
  public abstract void setPorts(Iterable<Integer> paramIterable);
  
  @Deprecated
  public abstract void setPorts(int... paramVarArgs);
  
  @Deprecated
  public abstract void setVersion(int paramInt);
  
  @Deprecated
  public abstract int version();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\Cookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */