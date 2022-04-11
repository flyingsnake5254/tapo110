package com.tplink.libtpappcommonmedia.bean;

import com.google.gson.q.c;

public class TPMediaAccountInfo
{
  @c("accountId")
  private String accountId;
  
  public TPMediaAccountInfo() {}
  
  public TPMediaAccountInfo(String paramString)
  {
    this.accountId = paramString;
  }
  
  public String getAccountId()
  {
    return this.accountId;
  }
  
  public void setAccountId(String paramString)
  {
    this.accountId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpappcommonmedia\bean\TPMediaAccountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */