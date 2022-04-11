package com.tplink.libmediaapi.device.apibean;

public class MediaDevice
{
  @com.google.gson.q.c("P2P_Available")
  private boolean P2PAvailable;
  @com.google.gson.q.c("app_server_url")
  protected String appServerUrl;
  @com.google.gson.q.c("device_id")
  protected String deviceId;
  @com.google.gson.q.c("device_local")
  private boolean deviceLocal;
  @com.google.gson.q.c("mac")
  protected String deviceMac;
  @com.google.gson.q.c("device_remote_online")
  private boolean deviceRemoteOnline;
  @com.google.gson.q.c("force_main_stream")
  private boolean forceMainStream;
  @com.google.gson.q.c("http_port")
  protected int httpPort;
  @com.google.gson.q.c("iot_thing_url")
  protected String iotThingUrl;
  @com.google.gson.q.c("is_support_iot_cloud")
  protected boolean isSupportIoTCloud;
  @com.google.gson.q.c("localIp")
  protected String localIp;
  @com.google.gson.q.c("model")
  protected String model;
  @com.google.gson.q.c("user_role_type_device")
  private boolean userRoleTypeDevice;
  @com.google.gson.q.c("user_share_password")
  protected String userSharePassword;
  @com.google.gson.q.c("user_share_username")
  protected String userShareUsername;
  
  public String getAppServerUrl()
  {
    return this.appServerUrl;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getDeviceIdMd5()
  {
    return b.d.p.c.b(this.deviceId);
  }
  
  public String getDeviceMac()
  {
    return this.deviceMac;
  }
  
  public int getHttpPort()
  {
    return this.httpPort;
  }
  
  public String getIotThingUrl()
  {
    return this.iotThingUrl;
  }
  
  public String getLocalIp()
  {
    return this.localIp;
  }
  
  public String getModel()
  {
    return this.model;
  }
  
  public String getUserSharePassword()
  {
    return this.userSharePassword;
  }
  
  public String getUserShareUsername()
  {
    return this.userShareUsername;
  }
  
  public boolean isDeviceLocal()
  {
    return this.deviceLocal;
  }
  
  public boolean isDeviceRemoteOnline()
  {
    return this.deviceRemoteOnline;
  }
  
  public boolean isForceMainStream()
  {
    return this.forceMainStream;
  }
  
  public boolean isP2PAvailable()
  {
    return this.P2PAvailable;
  }
  
  public boolean isSupportIoTCloud()
  {
    return this.isSupportIoTCloud;
  }
  
  public boolean isUserRoleTypeDevice()
  {
    return this.userRoleTypeDevice;
  }
  
  public void setAppServerUrl(String paramString)
  {
    this.appServerUrl = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setDeviceLocal(boolean paramBoolean)
  {
    this.deviceLocal = paramBoolean;
  }
  
  public void setDeviceMac(String paramString)
  {
    this.deviceMac = paramString;
  }
  
  public void setDeviceRemoteOnline(boolean paramBoolean)
  {
    this.deviceRemoteOnline = paramBoolean;
  }
  
  public void setForceMainStream(boolean paramBoolean)
  {
    this.forceMainStream = paramBoolean;
  }
  
  public void setHttpPort(int paramInt)
  {
    this.httpPort = paramInt;
  }
  
  public void setIotThingUrl(String paramString)
  {
    this.iotThingUrl = paramString;
  }
  
  public void setLocalIp(String paramString)
  {
    this.localIp = paramString;
  }
  
  public void setModel(String paramString)
  {
    this.model = paramString;
  }
  
  public void setP2PAvailable(boolean paramBoolean)
  {
    this.P2PAvailable = paramBoolean;
  }
  
  public void setSupportIoTCloud(boolean paramBoolean)
  {
    this.isSupportIoTCloud = paramBoolean;
  }
  
  public void setUserRoleTypeDevice(boolean paramBoolean)
  {
    this.userRoleTypeDevice = paramBoolean;
  }
  
  public void setUserSharePassword(String paramString)
  {
    this.userSharePassword = paramString;
  }
  
  public void setUserShareUsername(String paramString)
  {
    this.userShareUsername = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\device\apibean\MediaDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */