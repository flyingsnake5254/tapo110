package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class Timezone
{
  @c("timing_mode")
  private final String mode;
  private final String offset;
  private String timezone;
  @c("zone_id")
  private final String zoneId;
  
  public Timezone(String paramString1, String paramString2)
  {
    this(paramString1, "ntp", paramString2, null);
  }
  
  public Timezone(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.timezone = paramString1;
    this.mode = paramString2;
    this.zoneId = paramString3;
    this.offset = paramString4;
  }
  
  public final String component1()
  {
    return this.timezone;
  }
  
  public final String component2()
  {
    return this.mode;
  }
  
  public final String component3()
  {
    return this.zoneId;
  }
  
  public final String component4()
  {
    return this.offset;
  }
  
  public final Timezone copy(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    j.e(paramString1, "timezone");
    return new Timezone(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Timezone))
      {
        paramObject = (Timezone)paramObject;
        if ((j.a(this.timezone, ((Timezone)paramObject).timezone)) && (j.a(this.mode, ((Timezone)paramObject).mode)) && (j.a(this.zoneId, ((Timezone)paramObject).zoneId)) && (j.a(this.offset, ((Timezone)paramObject).offset))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getMode()
  {
    return this.mode;
  }
  
  public final String getOffset()
  {
    return this.offset;
  }
  
  public final String getTimezone()
  {
    return this.timezone;
  }
  
  public final String getZoneId()
  {
    return this.zoneId;
  }
  
  public int hashCode()
  {
    String str = this.timezone;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.mode;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.zoneId;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.offset;
    if (str != null) {
      i = str.hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public final void setTimezone(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.timezone = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Timezone(timezone=");
    localStringBuilder.append(this.timezone);
    localStringBuilder.append(", mode=");
    localStringBuilder.append(this.mode);
    localStringBuilder.append(", zoneId=");
    localStringBuilder.append(this.zoneId);
    localStringBuilder.append(", offset=");
    localStringBuilder.append(this.offset);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Timezone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */