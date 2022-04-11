package com.tplink.libtpgoogleassistant.bean.result;

public class AuthValidClientBean
{
  private String clientIdInternal;
  private long createdAt;
  private String scope;
  
  public String getClientIdInternal()
  {
    return this.clientIdInternal;
  }
  
  public long getCreatedAt()
  {
    return this.createdAt;
  }
  
  public String getScope()
  {
    return this.scope;
  }
  
  public void setClientIdInternal(String paramString)
  {
    this.clientIdInternal = paramString;
  }
  
  public void setCreatedAt(long paramLong)
  {
    this.createdAt = paramLong;
  }
  
  public void setScope(String paramString)
  {
    this.scope = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpgoogleassistant\bean\result\AuthValidClientBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */