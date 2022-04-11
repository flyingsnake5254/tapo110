package com.tplink.iot.cloud.bean.share.result;

import com.tplink.iot.cloud.bean.share.EnumDeviceShareStatus;

public class ShareDeviceResult
{
  private String deviceHwVer;
  private String deviceModel;
  private String deviceName;
  private String deviceType;
  private Boolean isExpired;
  private boolean isSubThing;
  private String nickname;
  private String ownerNickname;
  private String ownerUsername;
  private String shareCreatedTime;
  private String shareExpiredTime;
  private String shareId;
  private EnumDeviceShareStatus shareStatus;
  private String sharerNickname;
  private String sharerUsername;
  private String thingName;
  
  public String getDeviceHwVer()
  {
    return this.deviceHwVer;
  }
  
  public String getDeviceModel()
  {
    return this.deviceModel;
  }
  
  public String getDeviceName()
  {
    return this.deviceName;
  }
  
  public String getDeviceType()
  {
    return this.deviceType;
  }
  
  public Boolean getExpired()
  {
    return this.isExpired;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public String getOwnerNickname()
  {
    return this.ownerNickname;
  }
  
  public String getOwnerUsername()
  {
    return this.ownerUsername;
  }
  
  public String getShareCreatedTime()
  {
    return this.shareCreatedTime;
  }
  
  public String getShareExpiredTime()
  {
    return this.shareExpiredTime;
  }
  
  public String getShareId()
  {
    return this.shareId;
  }
  
  public EnumDeviceShareStatus getShareStatus()
  {
    return this.shareStatus;
  }
  
  public String getSharerNickname()
  {
    return this.sharerNickname;
  }
  
  public String getSharerUsername()
  {
    return this.sharerUsername;
  }
  
  public String getThingName()
  {
    return this.thingName;
  }
  
  public boolean isSubThing()
  {
    return this.isSubThing;
  }
  
  public void setDeviceHwVer(String paramString)
  {
    this.deviceHwVer = paramString;
  }
  
  public void setDeviceModel(String paramString)
  {
    this.deviceModel = paramString;
  }
  
  public void setDeviceName(String paramString)
  {
    this.deviceName = paramString;
  }
  
  public void setDeviceType(String paramString)
  {
    this.deviceType = paramString;
  }
  
  public void setExpired(Boolean paramBoolean)
  {
    this.isExpired = paramBoolean;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
  
  public void setOwnerNickname(String paramString)
  {
    this.ownerNickname = paramString;
  }
  
  public void setOwnerUsername(String paramString)
  {
    this.ownerUsername = paramString;
  }
  
  public void setShareCreatedTime(String paramString)
  {
    this.shareCreatedTime = paramString;
  }
  
  public void setShareExpiredTime(String paramString)
  {
    this.shareExpiredTime = paramString;
  }
  
  public void setShareId(String paramString)
  {
    this.shareId = paramString;
  }
  
  public void setShareStatus(EnumDeviceShareStatus paramEnumDeviceShareStatus)
  {
    this.shareStatus = paramEnumDeviceShareStatus;
  }
  
  public void setSharerNickname(String paramString)
  {
    this.sharerNickname = paramString;
  }
  
  public void setSharerUsername(String paramString)
  {
    this.sharerUsername = paramString;
  }
  
  public void setSubThing(boolean paramBoolean)
  {
    this.isSubThing = paramBoolean;
  }
  
  public void setThingName(String paramString)
  {
    this.thingName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\result\ShareDeviceResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */