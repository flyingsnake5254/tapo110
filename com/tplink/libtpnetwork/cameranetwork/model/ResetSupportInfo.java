package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class ResetSupportInfo
{
  @c("reset_wifi_supported")
  private final String resetWifiSupported;
  
  public ResetSupportInfo(String paramString)
  {
    this.resetWifiSupported = paramString;
  }
  
  public final String component1()
  {
    return this.resetWifiSupported;
  }
  
  public final ResetSupportInfo copy(String paramString)
  {
    return new ResetSupportInfo(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ResetSupportInfo))
      {
        paramObject = (ResetSupportInfo)paramObject;
        if (j.a(this.resetWifiSupported, ((ResetSupportInfo)paramObject).resetWifiSupported)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getResetWifiSupported()
  {
    return this.resetWifiSupported;
  }
  
  public int hashCode()
  {
    String str = this.resetWifiSupported;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResetSupportInfo(resetWifiSupported=");
    localStringBuilder.append(this.resetWifiSupported);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ResetSupportInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */