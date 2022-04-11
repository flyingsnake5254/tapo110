package com.tplink.libtpmediastatistics.bean;

public class StatisticsCameraDevice
{
  private String deviceId;
  private String deviceIdMD5;
  private boolean localOnly;
  private String model;
  private String softwareVersion;
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getDeviceIdMD5()
  {
    return this.deviceIdMD5;
  }
  
  public String getModel()
  {
    return this.model;
  }
  
  public String getSoftwareVersion()
  {
    return this.softwareVersion;
  }
  
  public boolean isLocalOnly()
  {
    return this.localOnly;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setDeviceIdMD5(String paramString)
  {
    this.deviceIdMD5 = paramString;
  }
  
  public void setLocalOnly(boolean paramBoolean)
  {
    this.localOnly = paramBoolean;
  }
  
  public void setModel(String paramString)
  {
    this.model = paramString;
  }
  
  public void setSoftwareVersion(String paramString)
  {
    this.softwareVersion = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediastatistics\bean\StatisticsCameraDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */