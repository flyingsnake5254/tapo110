package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class NetworkInfoCache
{
  private final String linkType;
  private String rssi;
  private String rssiValue;
  private String ssid;
  
  public NetworkInfoCache(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.ssid = paramString1;
    this.linkType = paramString2;
    this.rssi = paramString3;
    this.rssiValue = paramString4;
  }
  
  public final String component1()
  {
    return this.ssid;
  }
  
  public final String component2()
  {
    return this.linkType;
  }
  
  public final String component3()
  {
    return this.rssi;
  }
  
  public final String component4()
  {
    return this.rssiValue;
  }
  
  public final NetworkInfoCache copy(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return new NetworkInfoCache(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof NetworkInfoCache))
      {
        paramObject = (NetworkInfoCache)paramObject;
        if ((j.a(this.ssid, ((NetworkInfoCache)paramObject).ssid)) && (j.a(this.linkType, ((NetworkInfoCache)paramObject).linkType)) && (j.a(this.rssi, ((NetworkInfoCache)paramObject).rssi)) && (j.a(this.rssiValue, ((NetworkInfoCache)paramObject).rssiValue))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getLinkType()
  {
    return this.linkType;
  }
  
  public final String getRssi()
  {
    return this.rssi;
  }
  
  public final String getRssiValue()
  {
    return this.rssiValue;
  }
  
  public final String getSsid()
  {
    return this.ssid;
  }
  
  public int hashCode()
  {
    String str = this.ssid;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.linkType;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.rssi;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.rssiValue;
    if (str != null) {
      i = str.hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public final void setRssi(String paramString)
  {
    this.rssi = paramString;
  }
  
  public final void setRssiValue(String paramString)
  {
    this.rssiValue = paramString;
  }
  
  public final void setSsid(String paramString)
  {
    this.ssid = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetworkInfoCache(ssid=");
    localStringBuilder.append(this.ssid);
    localStringBuilder.append(", linkType=");
    localStringBuilder.append(this.linkType);
    localStringBuilder.append(", rssi=");
    localStringBuilder.append(this.rssi);
    localStringBuilder.append(", rssiValue=");
    localStringBuilder.append(this.rssiValue);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\NetworkInfoCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */