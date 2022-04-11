package com.tplink.cloud.bean.protocol.result;

public class HelloCloudResult
{
  private String appUrl;
  private String tcspInfo;
  private int tcspStatus;
  
  public String getAppUrl()
  {
    return this.appUrl;
  }
  
  public String getTcspInfo()
  {
    return this.tcspInfo;
  }
  
  public int getTcspStatus()
  {
    return this.tcspStatus;
  }
  
  public void setAppUrl(String paramString)
  {
    this.appUrl = paramString;
  }
  
  public void setTcspInfo(String paramString)
  {
    this.tcspInfo = paramString;
  }
  
  public void setTcspStatus(int paramInt)
  {
    this.tcspStatus = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\protocol\result\HelloCloudResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */