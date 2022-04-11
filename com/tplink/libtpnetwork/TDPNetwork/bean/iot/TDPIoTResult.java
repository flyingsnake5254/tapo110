package com.tplink.libtpnetwork.TDPNetwork.bean.iot;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.Utils.i;
import java.io.Serializable;

public class TDPIoTResult
  extends BaseTDPJsonResult
  implements Serializable
{
  @c("device_id")
  private String deviceIdMd5;
  @c("mgt_encrypt_schm")
  private EncryptScheme encryptScheme;
  @c("is_support_iot_cloud")
  private boolean isSupportIoTCloud;
  @c("obd_src")
  private String obdSrc;
  private String owner;
  
  public String getDeviceIdMd5()
  {
    return this.deviceIdMd5;
  }
  
  public EncryptScheme getEncryptScheme()
  {
    return this.encryptScheme;
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
  
  public void setEncryptScheme(EncryptScheme paramEncryptScheme)
  {
    this.encryptScheme = paramEncryptScheme;
  }
  
  public void setObdSrc(String paramString)
  {
    this.obdSrc = paramString;
  }
  
  public void setOwner(String paramString)
  {
    this.owner = paramString;
  }
  
  public void setSupportIoTCloud(boolean paramBoolean)
  {
    this.isSupportIoTCloud = paramBoolean;
  }
  
  public String toString()
  {
    return i.h(this);
  }
  
  public static class EncryptScheme
    implements Serializable
  {
    @c("encrypt_type")
    private EnumEncryptType encryptType;
    @c("http_port")
    private int httpPort;
    @c("is_support_https")
    private boolean isSupportHttps = false;
    
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TDPNetwork\bean\iot\TDPIoTResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */