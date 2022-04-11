package com.tplink.cloud.bean.account.result;

@Deprecated
public class CheckPasswordResult
{
  private long accountId;
  private String email;
  private String registerDate;
  private int status;
  
  public long getAccountId()
  {
    return this.accountId;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public String getRegisterDate()
  {
    return this.registerDate;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setAccountId(long paramLong)
  {
    this.accountId = paramLong;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setRegisterDate(String paramString)
  {
    this.registerDate = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\result\CheckPasswordResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */