package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class DeviceInfoCache
{
  private String deviceId;
  private String imgUrl;
  private String ip;
  private String mac;
  
  public DeviceInfoCache(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mac = paramString1;
    this.deviceId = paramString2;
    this.ip = paramString3;
    this.imgUrl = paramString4;
  }
  
  public final String component1()
  {
    return this.mac;
  }
  
  public final String component2()
  {
    return this.deviceId;
  }
  
  public final String component3()
  {
    return this.ip;
  }
  
  public final String component4()
  {
    return this.imgUrl;
  }
  
  public final DeviceInfoCache copy(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    j.e(paramString2, "deviceId");
    return new DeviceInfoCache(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DeviceInfoCache))
      {
        paramObject = (DeviceInfoCache)paramObject;
        if ((j.a(this.mac, ((DeviceInfoCache)paramObject).mac)) && (j.a(this.deviceId, ((DeviceInfoCache)paramObject).deviceId)) && (j.a(this.ip, ((DeviceInfoCache)paramObject).ip)) && (j.a(this.imgUrl, ((DeviceInfoCache)paramObject).imgUrl))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getDeviceId()
  {
    return this.deviceId;
  }
  
  public final String getImgUrl()
  {
    return this.imgUrl;
  }
  
  public final String getIp()
  {
    return this.ip;
  }
  
  public final String getMac()
  {
    return this.mac;
  }
  
  public int hashCode()
  {
    String str = this.mac;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.deviceId;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.ip;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.imgUrl;
    if (str != null) {
      i = str.hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public final void setDeviceId(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.deviceId = paramString;
  }
  
  public final void setImgUrl(String paramString)
  {
    this.imgUrl = paramString;
  }
  
  public final void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public final void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceInfoCache(mac=");
    localStringBuilder.append(this.mac);
    localStringBuilder.append(", deviceId=");
    localStringBuilder.append(this.deviceId);
    localStringBuilder.append(", ip=");
    localStringBuilder.append(this.ip);
    localStringBuilder.append(", imgUrl=");
    localStringBuilder.append(this.imgUrl);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\DeviceInfoCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */