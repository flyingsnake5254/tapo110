package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class SystemInfo
{
  @c("dev_alias")
  private String alias;
  @c("append_dns")
  private final String appendDns;
  @c("avatar")
  private String avatar;
  @c("diagnose_mode")
  private String diagnoseMode;
  @c("hostname")
  private final String hostname;
  @c("is_factory")
  private final String isFactory;
  @c("makeroom_status")
  private final String makeRoomStatus;
  @c("alias")
  private final String name;
  @c("network_type")
  private final String networkType;
  
  public SystemInfo()
  {
    this(null, null, null, null, null, null, null, null, null, 511, null);
  }
  
  public SystemInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.diagnoseMode = paramString1;
    this.alias = paramString2;
    this.name = paramString3;
    this.avatar = paramString4;
    this.appendDns = paramString5;
    this.networkType = paramString6;
    this.isFactory = paramString7;
    this.hostname = paramString8;
    this.makeRoomStatus = paramString9;
  }
  
  public final String component1()
  {
    return this.diagnoseMode;
  }
  
  public final String component2()
  {
    return this.alias;
  }
  
  public final String component3()
  {
    return this.name;
  }
  
  public final String component4()
  {
    return this.avatar;
  }
  
  public final String component5()
  {
    return this.appendDns;
  }
  
  public final String component6()
  {
    return this.networkType;
  }
  
  public final String component7()
  {
    return this.isFactory;
  }
  
  public final String component8()
  {
    return this.hostname;
  }
  
  public final String component9()
  {
    return this.makeRoomStatus;
  }
  
  public final SystemInfo copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    return new SystemInfo(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SystemInfo))
      {
        paramObject = (SystemInfo)paramObject;
        if ((j.a(this.diagnoseMode, ((SystemInfo)paramObject).diagnoseMode)) && (j.a(this.alias, ((SystemInfo)paramObject).alias)) && (j.a(this.name, ((SystemInfo)paramObject).name)) && (j.a(this.avatar, ((SystemInfo)paramObject).avatar)) && (j.a(this.appendDns, ((SystemInfo)paramObject).appendDns)) && (j.a(this.networkType, ((SystemInfo)paramObject).networkType)) && (j.a(this.isFactory, ((SystemInfo)paramObject).isFactory)) && (j.a(this.hostname, ((SystemInfo)paramObject).hostname)) && (j.a(this.makeRoomStatus, ((SystemInfo)paramObject).makeRoomStatus))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getAlias()
  {
    return this.alias;
  }
  
  public final String getAppendDns()
  {
    return this.appendDns;
  }
  
  public final String getAvatar()
  {
    return this.avatar;
  }
  
  public final String getDiagnoseMode()
  {
    return this.diagnoseMode;
  }
  
  public final String getHostname()
  {
    return this.hostname;
  }
  
  public final String getMakeRoomStatus()
  {
    return this.makeRoomStatus;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final String getNetworkType()
  {
    return this.networkType;
  }
  
  public int hashCode()
  {
    String str = this.diagnoseMode;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.alias;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.name;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.avatar;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.appendDns;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.networkType;
    int i2;
    if (str != null) {
      i2 = str.hashCode();
    } else {
      i2 = 0;
    }
    str = this.isFactory;
    int i3;
    if (str != null) {
      i3 = str.hashCode();
    } else {
      i3 = 0;
    }
    str = this.hostname;
    int i4;
    if (str != null) {
      i4 = str.hashCode();
    } else {
      i4 = 0;
    }
    str = this.makeRoomStatus;
    if (str != null) {
      i = str.hashCode();
    }
    return (((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i;
  }
  
  public final String isFactory()
  {
    return this.isFactory;
  }
  
  public final void setAlias(String paramString)
  {
    this.alias = paramString;
  }
  
  public final void setAvatar(String paramString)
  {
    this.avatar = paramString;
  }
  
  public final void setDiagnoseMode(String paramString)
  {
    this.diagnoseMode = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SystemInfo(diagnoseMode=");
    localStringBuilder.append(this.diagnoseMode);
    localStringBuilder.append(", alias=");
    localStringBuilder.append(this.alias);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", avatar=");
    localStringBuilder.append(this.avatar);
    localStringBuilder.append(", appendDns=");
    localStringBuilder.append(this.appendDns);
    localStringBuilder.append(", networkType=");
    localStringBuilder.append(this.networkType);
    localStringBuilder.append(", isFactory=");
    localStringBuilder.append(this.isFactory);
    localStringBuilder.append(", hostname=");
    localStringBuilder.append(this.hostname);
    localStringBuilder.append(", makeRoomStatus=");
    localStringBuilder.append(this.makeRoomStatus);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\SystemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */