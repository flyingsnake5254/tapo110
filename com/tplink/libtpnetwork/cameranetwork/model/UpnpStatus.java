package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class UpnpStatus
{
  @c("vhttpd")
  private VHttpd vHttpd;
  
  public UpnpStatus(VHttpd paramVHttpd)
  {
    this.vHttpd = paramVHttpd;
  }
  
  public UpnpStatus(Wrappers paramWrappers) {}
  
  public final VHttpd component1()
  {
    return this.vHttpd;
  }
  
  public final UpnpStatus copy(VHttpd paramVHttpd)
  {
    return new UpnpStatus(paramVHttpd);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof UpnpStatus))
      {
        paramObject = (UpnpStatus)paramObject;
        if (j.a(this.vHttpd, ((UpnpStatus)paramObject).vHttpd)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final VHttpd getVHttpd()
  {
    return this.vHttpd;
  }
  
  public int hashCode()
  {
    VHttpd localVHttpd = this.vHttpd;
    int i;
    if (localVHttpd != null) {
      i = localVHttpd.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public final void setVHttpd(VHttpd paramVHttpd)
  {
    this.vHttpd = paramVHttpd;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpnpStatus(vHttpd=");
    localStringBuilder.append(this.vHttpd);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\UpnpStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */