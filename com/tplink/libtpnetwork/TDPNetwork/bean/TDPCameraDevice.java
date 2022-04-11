package com.tplink.libtpnetwork.TDPNetwork.bean;

import com.google.gson.q.c;
import com.tplink.tdp.bean.BaseTDPDevice;
import java.io.Serializable;

public class TDPCameraDevice
  extends TDPIoTDevice
  implements Serializable
{
  @c("ssid")
  private String connectSsid;
  @c("connect_type")
  private String connectType;
  @c("device_id")
  protected String deviceId;
  @c("device_name")
  private String deviceName;
  @c("fw_ver")
  private String firmwareVer;
  @c("hw_ver")
  private String hardwareVer;
  @c("isResetWiFi")
  private boolean isResetWiFi;
  @c("last_alarm_time")
  private String lastAlarmTime;
  @c("last_alarm_type")
  private String lastAlarmType;
  @c("sd_status")
  private String sdStatus;
  
  public TDPCameraDevice clone()
  {
    TDPCameraDevice localTDPCameraDevice = new TDPCameraDevice();
    localTDPCameraDevice.deviceName = this.deviceName;
    localTDPCameraDevice.hardwareVer = this.hardwareVer;
    localTDPCameraDevice.firmwareVer = this.firmwareVer;
    localTDPCameraDevice.deviceId = this.deviceId;
    localTDPCameraDevice.deviceIdMd5 = this.deviceIdMd5;
    localTDPCameraDevice.ip = this.ip;
    localTDPCameraDevice.mac = this.mac;
    localTDPCameraDevice.httpPort = this.httpPort;
    localTDPCameraDevice.connectType = this.connectType;
    localTDPCameraDevice.connectSsid = this.connectSsid;
    localTDPCameraDevice.owner = this.owner;
    localTDPCameraDevice.lastAlarmType = this.lastAlarmType;
    localTDPCameraDevice.lastAlarmTime = this.lastAlarmTime;
    localTDPCameraDevice.sdStatus = this.sdStatus;
    localTDPCameraDevice.deviceModel = this.deviceModel;
    localTDPCameraDevice.isResetWiFi = this.isResetWiFi;
    return localTDPCameraDevice;
  }
  
  public String getConnectSsid()
  {
    return this.connectSsid;
  }
  
  public String getConnectType()
  {
    return this.connectType;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getDeviceName()
  {
    return this.deviceName;
  }
  
  public String getFirmwareVer()
  {
    return this.firmwareVer;
  }
  
  public String getHardwareVer()
  {
    return this.hardwareVer;
  }
  
  public int getHttpPort()
  {
    int i = this.httpPort;
    if (i == 0) {
      i = 443;
    }
    return i;
  }
  
  public String getLastAlarmTime()
  {
    return this.lastAlarmTime;
  }
  
  public String getLastAlarmType()
  {
    return this.lastAlarmType;
  }
  
  public String getSdStatus()
  {
    return this.sdStatus;
  }
  
  public boolean isResetWiFi()
  {
    return this.isResetWiFi;
  }
  
  public void setConnectSsid(String paramString)
  {
    this.connectSsid = paramString;
  }
  
  public void setConnectType(String paramString)
  {
    this.connectType = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setDeviceName(String paramString)
  {
    this.deviceName = paramString;
  }
  
  public void setFirmwareVer(String paramString)
  {
    this.firmwareVer = paramString;
  }
  
  public void setHardwareVer(String paramString)
  {
    this.hardwareVer = paramString;
  }
  
  public void setLastAlarmTime(String paramString)
  {
    this.lastAlarmTime = paramString;
  }
  
  public void setLastAlarmType(String paramString)
  {
    this.lastAlarmType = paramString;
  }
  
  public void setResetWiFi(boolean paramBoolean)
  {
    this.isResetWiFi = paramBoolean;
  }
  
  public void setSdStatus(String paramString)
  {
    this.sdStatus = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TDPNetwork\bean\TDPCameraDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */