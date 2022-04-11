package com.tplink.cloud.bean.device.params;

public class DeviceOwnershipParams
{
  private String deviceId;
  private String newOwnerAccount;
  private String oldOwnerAccount;
  
  public DeviceOwnershipParams() {}
  
  public DeviceOwnershipParams(String paramString1, String paramString2, String paramString3)
  {
    this.deviceId = paramString1;
    this.oldOwnerAccount = paramString2;
    this.newOwnerAccount = paramString3;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getNewOwnerAccount()
  {
    return this.newOwnerAccount;
  }
  
  public String getOldOwnerAccount()
  {
    return this.oldOwnerAccount;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setNewOwnerAccount(String paramString)
  {
    this.newOwnerAccount = paramString;
  }
  
  public void setOldOwnerAccount(String paramString)
  {
    this.oldOwnerAccount = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceOwnershipParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */