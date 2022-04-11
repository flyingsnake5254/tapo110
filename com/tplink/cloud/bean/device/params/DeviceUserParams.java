package com.tplink.cloud.bean.device.params;

public class DeviceUserParams
{
  private String deviceId;
  private String ownerAccount;
  private String userAccount;
  
  public DeviceUserParams() {}
  
  public DeviceUserParams(String paramString1, String paramString2, String paramString3)
  {
    this.deviceId = paramString1;
    this.ownerAccount = paramString2;
    this.userAccount = paramString3;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getOwnerAccount()
  {
    return this.ownerAccount;
  }
  
  public String getUserAccount()
  {
    return this.userAccount;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setOwnerAccount(String paramString)
  {
    this.ownerAccount = paramString;
  }
  
  public void setUserAccount(String paramString)
  {
    this.userAccount = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceUserParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */