package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class LatestFirmwareInfo
{
  private String location;
  private String release_date;
  private String release_log;
  private String type;
  private String version;
  
  public LatestFirmwareInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.type = paramString1;
    this.version = paramString2;
    this.release_date = paramString3;
    this.release_log = paramString4;
    this.location = paramString5;
  }
  
  public final String component1()
  {
    return this.type;
  }
  
  public final String component2()
  {
    return this.version;
  }
  
  public final String component3()
  {
    return this.release_date;
  }
  
  public final String component4()
  {
    return this.release_log;
  }
  
  public final String component5()
  {
    return this.location;
  }
  
  public final LatestFirmwareInfo copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return new LatestFirmwareInfo(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LatestFirmwareInfo))
      {
        paramObject = (LatestFirmwareInfo)paramObject;
        if ((j.a(this.type, ((LatestFirmwareInfo)paramObject).type)) && (j.a(this.version, ((LatestFirmwareInfo)paramObject).version)) && (j.a(this.release_date, ((LatestFirmwareInfo)paramObject).release_date)) && (j.a(this.release_log, ((LatestFirmwareInfo)paramObject).release_log)) && (j.a(this.location, ((LatestFirmwareInfo)paramObject).location))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getLocation()
  {
    return this.location;
  }
  
  public final String getRelease_date()
  {
    return this.release_date;
  }
  
  public final String getRelease_log()
  {
    return this.release_log;
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public final String getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    String str = this.type;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.version;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.release_date;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.release_log;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.location;
    if (str != null) {
      i = str.hashCode();
    }
    return (((j * 31 + k) * 31 + m) * 31 + n) * 31 + i;
  }
  
  public final void setLocation(String paramString)
  {
    this.location = paramString;
  }
  
  public final void setRelease_date(String paramString)
  {
    this.release_date = paramString;
  }
  
  public final void setRelease_log(String paramString)
  {
    this.release_log = paramString;
  }
  
  public final void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public final void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LatestFirmwareInfo(type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", release_date=");
    localStringBuilder.append(this.release_date);
    localStringBuilder.append(", release_log=");
    localStringBuilder.append(this.release_log);
    localStringBuilder.append(", location=");
    localStringBuilder.append(this.location);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\LatestFirmwareInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */