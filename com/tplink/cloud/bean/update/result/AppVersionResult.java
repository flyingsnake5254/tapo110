package com.tplink.cloud.bean.update.result;

public class AppVersionResult
  implements Cloneable
{
  private int appUpdateType;
  private String appUrl;
  private String size;
  private int versionCode;
  private String versionLog;
  private String versionName;
  
  public AppVersionResult clone()
  {
    AppVersionResult localAppVersionResult2;
    try
    {
      AppVersionResult localAppVersionResult1 = (AppVersionResult)super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
      localAppVersionResult2 = null;
    }
    return localAppVersionResult2;
  }
  
  public int getAppUpdateType()
  {
    return this.appUpdateType;
  }
  
  public String getAppUrl()
  {
    return this.appUrl;
  }
  
  public String getSize()
  {
    return this.size;
  }
  
  public int getVersionCode()
  {
    return this.versionCode;
  }
  
  public String getVersionLog()
  {
    return this.versionLog;
  }
  
  public String getVersionName()
  {
    return this.versionName;
  }
  
  public void setAppUpdateType(int paramInt)
  {
    this.appUpdateType = paramInt;
  }
  
  public void setAppUrl(String paramString)
  {
    this.appUrl = paramString;
  }
  
  public void setSize(String paramString)
  {
    this.size = paramString;
  }
  
  public void setVersionCode(int paramInt)
  {
    this.versionCode = paramInt;
  }
  
  public void setVersionLog(String paramString)
  {
    this.versionLog = paramString;
  }
  
  public void setVersionName(String paramString)
  {
    this.versionName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\update\result\AppVersionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */