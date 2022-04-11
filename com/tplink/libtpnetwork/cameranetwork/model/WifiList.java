package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

public final class WifiList
{
  @c("ap_list")
  private final List<Wifi> wifiList;
  @c("wpa3_supported")
  private final boolean wpa3Supported;
  
  public WifiList(boolean paramBoolean, List<Wifi> paramList)
  {
    this.wpa3Supported = paramBoolean;
    this.wifiList = paramList;
  }
  
  public final boolean component1()
  {
    return this.wpa3Supported;
  }
  
  public final List<Wifi> component2()
  {
    return this.wifiList;
  }
  
  public final WifiList copy(boolean paramBoolean, List<Wifi> paramList)
  {
    j.e(paramList, "wifiList");
    return new WifiList(paramBoolean, paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof WifiList))
      {
        paramObject = (WifiList)paramObject;
        if ((this.wpa3Supported == ((WifiList)paramObject).wpa3Supported) && (j.a(this.wifiList, ((WifiList)paramObject).wifiList))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<Wifi> getWifiList()
  {
    return this.wifiList;
  }
  
  public final boolean getWpa3Supported()
  {
    return this.wpa3Supported;
  }
  
  public int hashCode()
  {
    boolean bool1 = this.wpa3Supported;
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = true;
    }
    List localList = this.wifiList;
    int i;
    if (localList != null) {
      i = localList.hashCode();
    } else {
      i = 0;
    }
    return bool2 * true + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WifiList(wpa3Supported=");
    localStringBuilder.append(this.wpa3Supported);
    localStringBuilder.append(", wifiList=");
    localStringBuilder.append(this.wifiList);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\WifiList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */