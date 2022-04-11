package com.tplink.cloud.bean.share.result;

import com.tplink.cloud.bean.share.EnumDeviceShareStatus;

public class ShareDeviceResult
{
  private String alias;
  private String deviceId;
  private String deviceType;
  private Boolean isExpired;
  private String ownerNickName;
  private String ownerUserName;
  private String shareCreatedTime;
  private String shareExpiredTime;
  private String shareId;
  private EnumDeviceShareStatus shareStatus;
  private String sharerNickName;
  private String sharerUserName;
  
  public String getAlias()
  {
    return this.alias;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getDeviceType()
  {
    return this.deviceType;
  }
  
  public Boolean getExpired()
  {
    return this.isExpired;
  }
  
  public String getOwnerNickName()
  {
    return this.ownerNickName;
  }
  
  public String getOwnerUserName()
  {
    return this.ownerUserName;
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
  
  public String getSharerNickName()
  {
    return this.sharerNickName;
  }
  
  public String getSharerUserName()
  {
    return this.sharerUserName;
  }
  
  public void setAlias(String paramString)
  {
    this.alias = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setDeviceType(String paramString)
  {
    this.deviceType = paramString;
  }
  
  public void setExpired(Boolean paramBoolean)
  {
    this.isExpired = paramBoolean;
  }
  
  public void setOwnerNickName(String paramString)
  {
    this.ownerNickName = paramString;
  }
  
  public void setOwnerUserName(String paramString)
  {
    this.ownerUserName = paramString;
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
  
  public void setSharerNickName(String paramString)
  {
    this.sharerNickName = paramString;
  }
  
  public void setSharerUserName(String paramString)
  {
    this.sharerUserName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\share\result\ShareDeviceResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */