package com.tplink.cloud.bean.push.params;

import android.text.TextUtils;

public class PushInfoParams
{
  private String appPackageName;
  private String appType;
  private String deviceToken;
  private String locale;
  private String mobileType;
  private boolean supportNotificationMsg;
  private String terminalUUID;
  private int versionCode;
  
  public PushInfoParams() {}
  
  public PushInfoParams(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mobileType = paramString1;
    this.versionCode = paramInt;
    this.appPackageName = paramString2;
    this.deviceToken = paramString3;
    this.appType = paramString4;
    this.locale = paramString5;
  }
  
  public PushInfoParams(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5);
    this.terminalUUID = paramString6;
  }
  
  public PushInfoParams(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    this(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5);
    this.terminalUUID = paramString6;
    this.supportNotificationMsg = paramBoolean;
  }
  
  public String getAppPackageName()
  {
    return this.appPackageName;
  }
  
  public String getAppType()
  {
    return this.appType;
  }
  
  public String getDeviceToken()
  {
    return this.deviceToken;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public String getMobileType()
  {
    return this.mobileType;
  }
  
  public String getTerminalUUID()
  {
    return this.terminalUUID;
  }
  
  public int getVersionCode()
  {
    return this.versionCode;
  }
  
  public boolean isPushMessageInfoEmpty()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.mobileType)) && (!TextUtils.isEmpty(this.appPackageName)) && (!TextUtils.isEmpty(this.deviceToken)) && (!TextUtils.isEmpty(this.appType)) && (!TextUtils.isEmpty(this.locale))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isSupportNotificationMsg()
  {
    return this.supportNotificationMsg;
  }
  
  public void setAppPackageName(String paramString)
  {
    this.appPackageName = paramString;
  }
  
  public void setAppType(String paramString)
  {
    this.appType = paramString;
  }
  
  public void setDeviceToken(String paramString)
  {
    this.deviceToken = paramString;
  }
  
  public void setLocale(String paramString)
  {
    this.locale = paramString;
  }
  
  public void setMobileType(String paramString)
  {
    this.mobileType = paramString;
  }
  
  public void setSupportNotificationMsg(boolean paramBoolean)
  {
    this.supportNotificationMsg = paramBoolean;
  }
  
  public void setTerminalUUID(String paramString)
  {
    this.terminalUUID = paramString;
  }
  
  public void setVersionCode(int paramInt)
  {
    this.versionCode = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\push\params\PushInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */