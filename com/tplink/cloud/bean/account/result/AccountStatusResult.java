package com.tplink.cloud.bean.account.result;

public class AccountStatusResult
{
  private int deletePending;
  private int status;
  
  public int getDeletePending()
  {
    return this.deletePending;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setDeletePending(int paramInt)
  {
    this.deletePending = paramInt;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\result\AccountStatusResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */