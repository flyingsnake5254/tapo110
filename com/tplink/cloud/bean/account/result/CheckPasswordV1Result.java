package com.tplink.cloud.bean.account.result;

public class CheckPasswordV1Result
{
  private String accountId;
  private String email;
  private int errorCode;
  private String errorMsg;
  private int failedAttempts;
  private int lockedMinutes;
  private int remainAttempts;
  
  public String getAccountId()
  {
    return this.accountId;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMsg()
  {
    return this.errorMsg;
  }
  
  public int getFailedAttempts()
  {
    return this.failedAttempts;
  }
  
  public int getLockedMinutes()
  {
    return this.lockedMinutes;
  }
  
  public int getRemainAttempts()
  {
    return this.remainAttempts;
  }
  
  public void setAccountId(String paramString)
  {
    this.accountId = paramString;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setErrorMsg(String paramString)
  {
    this.errorMsg = paramString;
  }
  
  public void setFailedAttempts(int paramInt)
  {
    this.failedAttempts = paramInt;
  }
  
  public void setLockedMinutes(int paramInt)
  {
    this.lockedMinutes = paramInt;
  }
  
  public void setRemainAttempts(int paramInt)
  {
    this.remainAttempts = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\result\CheckPasswordV1Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */