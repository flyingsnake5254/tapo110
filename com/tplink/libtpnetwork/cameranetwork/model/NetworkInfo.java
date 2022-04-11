package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class NetworkInfo
{
  @c("link_type")
  private final String linkType;
  private final String rssi;
  private final String rssiValue;
  private final String ssid;
  
  public NetworkInfo(String paramString1, String paramString2, String paramString3, String paramString4)
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
  
  public final NetworkInfo copy(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    j.e(paramString1, "ssid");
    j.e(paramString3, "rssi");
    j.e(paramString4, "rssiValue");
    return new NetworkInfo(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof NetworkInfo))
      {
        paramObject = (NetworkInfo)paramObject;
        if ((j.a(this.ssid, ((NetworkInfo)paramObject).ssid)) && (j.a(this.linkType, ((NetworkInfo)paramObject).linkType)) && (j.a(this.rssi, ((NetworkInfo)paramObject).rssi)) && (j.a(this.rssiValue, ((NetworkInfo)paramObject).rssiValue))) {}
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetworkInfo(ssid=");
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\NetworkInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */