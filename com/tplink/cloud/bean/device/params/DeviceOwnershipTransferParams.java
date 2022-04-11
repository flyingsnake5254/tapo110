package com.tplink.cloud.bean.device.params;

import java.util.List;

public class DeviceOwnershipTransferParams
{
  private String locale;
  private String masterDeviceId;
  private List<String> slaveDeviceIdList;
  private String srcCloudPassword;
  private String targetCloudUserName;
  
  public DeviceOwnershipTransferParams() {}
  
  public DeviceOwnershipTransferParams(String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    this.targetCloudUserName = paramString1;
    this.srcCloudPassword = paramString2;
    this.locale = paramString3;
    this.masterDeviceId = paramString4;
    this.slaveDeviceIdList = paramList;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public String getMasterDeviceId()
  {
    return this.masterDeviceId;
  }
  
  public List<String> getSlaveDeviceIdList()
  {
    return this.slaveDeviceIdList;
  }
  
  public String getSrcCloudPassword()
  {
    return this.srcCloudPassword;
  }
  
  public String getTargetCloudUserName()
  {
    return this.targetCloudUserName;
  }
  
  public void setLocale(String paramString)
  {
    this.locale = paramString;
  }
  
  public void setMasterDeviceId(String paramString)
  {
    this.masterDeviceId = paramString;
  }
  
  public void setSlaveDeviceIdList(List<String> paramList)
  {
    this.slaveDeviceIdList = paramList;
  }
  
  public void setSrcCloudPassword(String paramString)
  {
    this.srcCloudPassword = paramString;
  }
  
  public void setTargetCloudUserName(String paramString)
  {
    this.targetCloudUserName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceOwnershipTransferParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */