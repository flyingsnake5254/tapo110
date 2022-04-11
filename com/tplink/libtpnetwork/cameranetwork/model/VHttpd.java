package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class VHttpd
{
  private String desc;
  @c("ext_port")
  private String extPort;
  @c("inner_port")
  private String innerPort;
  private String ipaddr;
  private String proto;
  private String status;
  
  public VHttpd(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.ipaddr = paramString1;
    this.status = paramString2;
    this.proto = paramString3;
    this.innerPort = paramString4;
    this.desc = paramString5;
    this.extPort = paramString6;
  }
  
  public final String component1()
  {
    return this.ipaddr;
  }
  
  public final String component2()
  {
    return this.status;
  }
  
  public final String component3()
  {
    return this.proto;
  }
  
  public final String component4()
  {
    return this.innerPort;
  }
  
  public final String component5()
  {
    return this.desc;
  }
  
  public final String component6()
  {
    return this.extPort;
  }
  
  public final VHttpd copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    j.e(paramString3, "proto");
    return new VHttpd(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VHttpd))
      {
        paramObject = (VHttpd)paramObject;
        if ((j.a(this.ipaddr, ((VHttpd)paramObject).ipaddr)) && (j.a(this.status, ((VHttpd)paramObject).status)) && (j.a(this.proto, ((VHttpd)paramObject).proto)) && (j.a(this.innerPort, ((VHttpd)paramObject).innerPort)) && (j.a(this.desc, ((VHttpd)paramObject).desc)) && (j.a(this.extPort, ((VHttpd)paramObject).extPort))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getDesc()
  {
    return this.desc;
  }
  
  public final String getExtPort()
  {
    return this.extPort;
  }
  
  public final String getInnerPort()
  {
    return this.innerPort;
  }
  
  public final String getIpaddr()
  {
    return this.ipaddr;
  }
  
  public final String getProto()
  {
    return this.proto;
  }
  
  public final String getStatus()
  {
    return this.status;
  }
  
  public int hashCode()
  {
    String str = this.ipaddr;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.status;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.proto;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.innerPort;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.desc;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.extPort;
    if (str != null) {
      i = str.hashCode();
    }
    return ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i;
  }
  
  public final void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public final void setExtPort(String paramString)
  {
    this.extPort = paramString;
  }
  
  public final void setInnerPort(String paramString)
  {
    this.innerPort = paramString;
  }
  
  public final void setIpaddr(String paramString)
  {
    this.ipaddr = paramString;
  }
  
  public final void setProto(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.proto = paramString;
  }
  
  public final void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VHttpd(ipaddr=");
    localStringBuilder.append(this.ipaddr);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", proto=");
    localStringBuilder.append(this.proto);
    localStringBuilder.append(", innerPort=");
    localStringBuilder.append(this.innerPort);
    localStringBuilder.append(", desc=");
    localStringBuilder.append(this.desc);
    localStringBuilder.append(", extPort=");
    localStringBuilder.append(this.extPort);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\VHttpd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */