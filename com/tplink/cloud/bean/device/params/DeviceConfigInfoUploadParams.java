package com.tplink.cloud.bean.device.params;

public class DeviceConfigInfoUploadParams
{
  private String cloudUserName;
  private String deviceId;
  private String featureInfo;
  private String token;
  
  public DeviceConfigInfoUploadParams() {}
  
  public DeviceConfigInfoUploadParams(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.deviceId = paramString1;
    this.cloudUserName = paramString2;
    this.featureInfo = paramString3;
    this.token = paramString4;
  }
  
  public String getCloudUserName()
  {
    return this.cloudUserName;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getFeatureInfo()
  {
    return this.featureInfo;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setCloudUserName(String paramString)
  {
    this.cloudUserName = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setFeatureInfo(String paramString)
  {
    this.featureInfo = paramString;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\params\DeviceConfigInfoUploadParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */