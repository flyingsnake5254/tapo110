package com.tplink.libtpnetwork.cameranetwork.bean;

import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import java.io.Serializable;

public class CloudCameraDevice
  implements Serializable
{
  private String alias;
  private String appServerUrl;
  private String deviceHwVer;
  private String deviceId;
  private String deviceMac;
  private String deviceModel;
  private String deviceName;
  private String deviceType;
  private String fwId;
  private String fwVer;
  private String hwId;
  private boolean isSameRegion;
  private String oemId;
  private int role;
  private int status;
  
  public CloudCameraDevice() {}
  
  public CloudCameraDevice(DeviceInfoResult paramDeviceInfoResult)
  {
    this.deviceId = paramDeviceInfoResult.getDeviceId();
    this.status = paramDeviceInfoResult.getStatus();
    this.deviceName = paramDeviceInfoResult.getDeviceName();
    this.deviceType = paramDeviceInfoResult.getDeviceType();
    this.alias = paramDeviceInfoResult.getAlias();
    this.deviceMac = paramDeviceInfoResult.getDeviceMac();
    this.hwId = paramDeviceInfoResult.getHwId();
    this.deviceModel = paramDeviceInfoResult.getDeviceModel();
    this.deviceHwVer = paramDeviceInfoResult.getDeviceHwVer();
    this.fwId = paramDeviceInfoResult.getFwId();
    this.oemId = paramDeviceInfoResult.getOemId();
    this.fwVer = paramDeviceInfoResult.getFwVer();
    this.appServerUrl = paramDeviceInfoResult.getAppServerUrl();
    this.isSameRegion = paramDeviceInfoResult.isSameRegion();
    this.role = paramDeviceInfoResult.getRole();
  }
  
  public CloudCameraDevice clone()
  {
    CloudCameraDevice localCloudCameraDevice = new CloudCameraDevice();
    localCloudCameraDevice.deviceId = this.deviceId;
    localCloudCameraDevice.status = this.status;
    localCloudCameraDevice.deviceName = this.deviceName;
    localCloudCameraDevice.deviceType = this.deviceType;
    localCloudCameraDevice.alias = this.alias;
    localCloudCameraDevice.deviceMac = this.deviceMac;
    localCloudCameraDevice.hwId = this.hwId;
    localCloudCameraDevice.deviceModel = this.deviceModel;
    localCloudCameraDevice.deviceHwVer = this.deviceHwVer;
    localCloudCameraDevice.fwId = this.fwId;
    localCloudCameraDevice.oemId = this.oemId;
    localCloudCameraDevice.fwVer = this.fwVer;
    localCloudCameraDevice.appServerUrl = this.appServerUrl;
    localCloudCameraDevice.isSameRegion = this.isSameRegion;
    localCloudCameraDevice.role = this.role;
    return localCloudCameraDevice;
  }
  
  public String getAlias()
  {
    return this.alias;
  }
  
  public String getAppServerUrl()
  {
    return this.appServerUrl;
  }
  
  public String getDeviceHwVer()
  {
    return this.deviceHwVer;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public DeviceInfoResult getDeviceInfo()
  {
    DeviceInfoResult localDeviceInfoResult = new DeviceInfoResult();
    localDeviceInfoResult.setDeviceId(this.deviceId);
    localDeviceInfoResult.setStatus(this.status);
    localDeviceInfoResult.setDeviceName(this.deviceName);
    localDeviceInfoResult.setDeviceType(this.deviceType);
    localDeviceInfoResult.setAlias(this.alias);
    localDeviceInfoResult.setDeviceMac(this.deviceMac.replace("-", ""));
    localDeviceInfoResult.setHwId(this.hwId);
    localDeviceInfoResult.setDeviceModel(this.deviceModel);
    localDeviceInfoResult.setDeviceHwVer(this.deviceHwVer);
    localDeviceInfoResult.setFwId(this.fwId);
    localDeviceInfoResult.setOemId(this.oemId);
    localDeviceInfoResult.setFwVer(this.fwVer);
    localDeviceInfoResult.setAppServerUrl(this.appServerUrl);
    localDeviceInfoResult.setSameRegion(this.isSameRegion);
    localDeviceInfoResult.setRole(this.role);
    return localDeviceInfoResult;
  }
  
  public String getDeviceMac()
  {
    return this.deviceMac;
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
  
  public String getFwId()
  {
    return this.fwId;
  }
  
  public String getFwVer()
  {
    return this.fwVer;
  }
  
  public String getHwId()
  {
    return this.hwId;
  }
  
  public String getOemId()
  {
    return this.oemId;
  }
  
  public int getRole()
  {
    return this.role;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public boolean isSameRegion()
  {
    return this.isSameRegion;
  }
  
  public void setAlias(String paramString)
  {
    this.alias = paramString;
  }
  
  public void setAppServerUrl(String paramString)
  {
    this.appServerUrl = paramString;
  }
  
  public void setDeviceHwVer(String paramString)
  {
    this.deviceHwVer = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setDeviceMac(String paramString)
  {
    this.deviceMac = paramString;
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
  
  public void setFwId(String paramString)
  {
    this.fwId = paramString;
  }
  
  public void setFwVer(String paramString)
  {
    this.fwVer = paramString;
  }
  
  public void setHwId(String paramString)
  {
    this.hwId = paramString;
  }
  
  public void setOemId(String paramString)
  {
    this.oemId = paramString;
  }
  
  public void setRole(int paramInt)
  {
    this.role = paramInt;
  }
  
  public void setSameRegion(boolean paramBoolean)
  {
    this.isSameRegion = paramBoolean;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\CloudCameraDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */