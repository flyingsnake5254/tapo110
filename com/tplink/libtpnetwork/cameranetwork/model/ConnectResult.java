package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class ConnectResult
{
  @c("connect_time")
  private final Integer connectTime;
  private final String mac;
  @c("support_ap")
  private final String supportAp;
  
  public ConnectResult(Integer paramInteger, String paramString1, String paramString2)
  {
    this.connectTime = paramInteger;
    this.mac = paramString1;
    this.supportAp = paramString2;
  }
  
  public final Integer component1()
  {
    return this.connectTime;
  }
  
  public final String component2()
  {
    return this.mac;
  }
  
  public final String component3()
  {
    return this.supportAp;
  }
  
  public final ConnectResult copy(Integer paramInteger, String paramString1, String paramString2)
  {
    return new ConnectResult(paramInteger, paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ConnectResult))
      {
        paramObject = (ConnectResult)paramObject;
        if ((j.a(this.connectTime, ((ConnectResult)paramObject).connectTime)) && (j.a(this.mac, ((ConnectResult)paramObject).mac)) && (j.a(this.supportAp, ((ConnectResult)paramObject).supportAp))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final Integer getConnectTime()
  {
    return this.connectTime;
  }
  
  public final String getMac()
  {
    return this.mac;
  }
  
  public final String getSupportAp()
  {
    return this.supportAp;
  }
  
  public int hashCode()
  {
    Object localObject = this.connectTime;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.mac;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.supportAp;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConnectResult(connectTime=");
    localStringBuilder.append(this.connectTime);
    localStringBuilder.append(", mac=");
    localStringBuilder.append(this.mac);
    localStringBuilder.append(", supportAp=");
    localStringBuilder.append(this.supportAp);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\ConnectResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */