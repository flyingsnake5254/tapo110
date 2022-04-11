package com.tplink.libtpnetwork.TDPNetwork.bean.camera;

import com.google.gson.q.c;

public class TDPCameraEncryptResult
{
  @c("connect_ssid")
  private String connectSsid;
  @c("connect_type")
  private String connectType;
  @c("device_id")
  private String deviceId;
  @c("http_port")
  private int httpPort;
  @c("last_alarm_time")
  private String lastAlarmTime;
  @c("last_alarm_type")
  private String lastAlarmType;
  @c("owner")
  private String owner;
  @c("sd_status")
  private String sdStatus;
  
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
  
  public int getHttpPort()
  {
    return this.httpPort;
  }
  
  public String getLastAlarmTime()
  {
    return this.lastAlarmTime;
  }
  
  public String getLastAlarmType()
  {
    return this.lastAlarmType;
  }
  
  public String getOwner()
  {
    return this.owner;
  }
  
  public String getSdStatus()
  {
    return this.sdStatus;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TDPNetwork\bean\camera\TDPCameraEncryptResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */