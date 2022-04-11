package com.tplink.libtpnetwork.TDPNetwork.bean.camera;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.TDPNetwork.bean.iot.BaseTDPJsonResult;

public class TDPCameraResult
  extends BaseTDPJsonResult
{
  @c("device_id")
  private String deviceId;
  @c("device_name")
  private String deviceName;
  @c("mgt_encrypt_schm")
  private EncryptScheme encryptScheme;
  @c("encrypt_info")
  private EncryptedInfo encryptedInfo;
  @c(alternate={"firmware_version"}, value="firmware_ver")
  private String firmwareVer;
  @c("hardware_version")
  private String hardwareVer;
  @c("isResetWiFi")
  private boolean isResetWiFi;
  @c("is_support_iot_cloud")
  private boolean isSupportIoTCloud;
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getDeviceName()
  {
    return this.deviceName;
  }
  
  public EncryptScheme getEncryptScheme()
  {
    return this.encryptScheme;
  }
  
  public EncryptedInfo getEncryptedInfo()
  {
    return this.encryptedInfo;
  }
  
  public String getFirmwareVer()
  {
    return this.firmwareVer;
  }
  
  public String getHardwareVer()
  {
    return this.hardwareVer;
  }
  
  public boolean isResetWiFi()
  {
    return this.isResetWiFi;
  }
  
  public boolean isSupportIoTCloud()
  {
    return this.isSupportIoTCloud;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setDeviceName(String paramString)
  {
    this.deviceName = paramString;
  }
  
  public void setEncryptScheme(EncryptScheme paramEncryptScheme)
  {
    this.encryptScheme = paramEncryptScheme;
  }
  
  public void setEncryptedInfo(EncryptedInfo paramEncryptedInfo)
  {
    this.encryptedInfo = paramEncryptedInfo;
  }
  
  public void setFirmwareVer(String paramString)
  {
    this.firmwareVer = paramString;
  }
  
  public void setHardwareVer(String paramString)
  {
    this.hardwareVer = paramString;
  }
  
  public void setResetWiFi(boolean paramBoolean)
  {
    this.isResetWiFi = paramBoolean;
  }
  
  public void setSupportIoTCloud(boolean paramBoolean)
  {
    this.isSupportIoTCloud = paramBoolean;
  }
  
  public static class EncryptScheme
  {
    @c("is_support_https")
    private boolean isSupportHttps;
    
    public boolean isSupportHttps()
    {
      return this.isSupportHttps;
    }
    
    public void setSupportHttps(boolean paramBoolean)
    {
      this.isSupportHttps = paramBoolean;
    }
  }
  
  public static class EncryptedInfo
  {
    @c("data")
    private String data;
    @c("key")
    private String key;
    @c("sym_schm")
    private String symmetricScheme;
    
    public String getData()
    {
      return this.data;
    }
    
    public String getKey()
    {
      return this.key;
    }
    
    public String getSymmetricScheme()
    {
      return this.symmetricScheme;
    }
    
    public void setData(String paramString)
    {
      this.data = paramString;
    }
    
    public void setKey(String paramString)
    {
      this.key = paramString;
    }
    
    public void setSymmetricScheme(String paramString)
    {
      this.symmetricScheme = paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TDPNetwork\bean\camera\TDPCameraResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */