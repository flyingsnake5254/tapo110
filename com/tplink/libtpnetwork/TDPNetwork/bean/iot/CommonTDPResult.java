package com.tplink.libtpnetwork.TDPNetwork.bean.iot;

import com.google.gson.q.c;

public class CommonTDPResult
  extends BaseTDPJsonResult
{
  @c("device_id")
  private String deviceIdMd5;
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
  private boolean isResetWiFi = true;
  @c("is_support_iot_cloud")
  private boolean isSupportIoTCloud;
  @c("obd_src")
  private String obdSrc;
  private String owner;
  
  public String getDeviceIdMd5()
  {
    return this.deviceIdMd5;
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
  
  public int getHttpPort()
  {
    EncryptScheme localEncryptScheme = this.encryptScheme;
    int i;
    if (localEncryptScheme != null) {
      i = localEncryptScheme.getHttpPort();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String getObdSrc()
  {
    return this.obdSrc;
  }
  
  public String getOwner()
  {
    return this.owner;
  }
  
  public boolean isResetWiFi()
  {
    return this.isResetWiFi;
  }
  
  public boolean isSupportHttps()
  {
    EncryptScheme localEncryptScheme = this.encryptScheme;
    boolean bool;
    if ((localEncryptScheme != null) && (localEncryptScheme.isSupportHttps())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSupportIoTCloud()
  {
    return this.isSupportIoTCloud;
  }
  
  public void setDeviceIdMd5(String paramString)
  {
    this.deviceIdMd5 = paramString;
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
  
  public void setObdSrc(String paramString)
  {
    this.obdSrc = paramString;
  }
  
  public void setOwner(String paramString)
  {
    this.owner = paramString;
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
    @c("encrypt_type")
    private EnumEncryptType encryptType;
    @c("http_port")
    private int httpPort;
    @c("is_support_https")
    private boolean isSupportHttps;
    
    public EnumEncryptType getEncryptType()
    {
      return this.encryptType;
    }
    
    public int getHttpPort()
    {
      return this.httpPort;
    }
    
    public boolean isSupportHttps()
    {
      return this.isSupportHttps;
    }
    
    public void setEncryptType(EnumEncryptType paramEnumEncryptType)
    {
      this.encryptType = paramEnumEncryptType;
    }
    
    public void setHttpPort(int paramInt)
    {
      this.httpPort = paramInt;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TDPNetwork\bean\iot\CommonTDPResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */