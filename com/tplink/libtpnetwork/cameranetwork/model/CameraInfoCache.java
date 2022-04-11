package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class CameraInfoCache
{
  private final String hardwareVer;
  private final String mac;
  private final String model;
  private String name;
  private final String softwareVer;
  
  public CameraInfoCache(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.name = paramString1;
    this.hardwareVer = paramString2;
    this.softwareVer = paramString3;
    this.model = paramString4;
    this.mac = paramString5;
  }
  
  public final String component1()
  {
    return this.name;
  }
  
  public final String component2()
  {
    return this.hardwareVer;
  }
  
  public final String component3()
  {
    return this.softwareVer;
  }
  
  public final String component4()
  {
    return this.model;
  }
  
  public final String component5()
  {
    return this.mac;
  }
  
  public final CameraInfoCache copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return new CameraInfoCache(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CameraInfoCache))
      {
        paramObject = (CameraInfoCache)paramObject;
        if ((j.a(this.name, ((CameraInfoCache)paramObject).name)) && (j.a(this.hardwareVer, ((CameraInfoCache)paramObject).hardwareVer)) && (j.a(this.softwareVer, ((CameraInfoCache)paramObject).softwareVer)) && (j.a(this.model, ((CameraInfoCache)paramObject).model)) && (j.a(this.mac, ((CameraInfoCache)paramObject).mac))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getHardwareVer()
  {
    return this.hardwareVer;
  }
  
  public final String getMac()
  {
    return this.mac;
  }
  
  public final String getModel()
  {
    return this.model;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final String getSoftwareVer()
  {
    return this.softwareVer;
  }
  
  public int hashCode()
  {
    String str = this.name;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.hardwareVer;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.softwareVer;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.model;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.mac;
    if (str != null) {
      i = str.hashCode();
    }
    return (((j * 31 + k) * 31 + m) * 31 + n) * 31 + i;
  }
  
  public final void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraInfoCache(name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", hardwareVer=");
    localStringBuilder.append(this.hardwareVer);
    localStringBuilder.append(", softwareVer=");
    localStringBuilder.append(this.softwareVer);
    localStringBuilder.append(", model=");
    localStringBuilder.append(this.model);
    localStringBuilder.append(", mac=");
    localStringBuilder.append(this.mac);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\CameraInfoCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */