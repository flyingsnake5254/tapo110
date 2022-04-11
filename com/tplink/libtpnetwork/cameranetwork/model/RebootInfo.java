package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class RebootInfo
{
  private String day;
  private String enabled;
  private final String now;
  private Integer random_range;
  private String time;
  
  public RebootInfo(String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger)
  {
    this.now = paramString1;
    this.day = paramString2;
    this.enabled = paramString3;
    this.time = paramString4;
    this.random_range = paramInteger;
  }
  
  public final String component1()
  {
    return this.now;
  }
  
  public final String component2()
  {
    return this.day;
  }
  
  public final String component3()
  {
    return this.enabled;
  }
  
  public final String component4()
  {
    return this.time;
  }
  
  public final Integer component5()
  {
    return this.random_range;
  }
  
  public final RebootInfo copy(String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger)
  {
    j.e(paramString3, "enabled");
    return new RebootInfo(paramString1, paramString2, paramString3, paramString4, paramInteger);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RebootInfo))
      {
        paramObject = (RebootInfo)paramObject;
        if ((j.a(this.now, ((RebootInfo)paramObject).now)) && (j.a(this.day, ((RebootInfo)paramObject).day)) && (j.a(this.enabled, ((RebootInfo)paramObject).enabled)) && (j.a(this.time, ((RebootInfo)paramObject).time)) && (j.a(this.random_range, ((RebootInfo)paramObject).random_range))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getDay()
  {
    return this.day;
  }
  
  public final String getEnabled()
  {
    return this.enabled;
  }
  
  public final String getNow()
  {
    return this.now;
  }
  
  public final Integer getRandom_range()
  {
    return this.random_range;
  }
  
  public final String getTime()
  {
    return this.time;
  }
  
  public int hashCode()
  {
    Object localObject = this.now;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.day;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.enabled;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.time;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.random_range;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (((j * 31 + k) * 31 + m) * 31 + n) * 31 + i;
  }
  
  public final void setDay(String paramString)
  {
    this.day = paramString;
  }
  
  public final void setEnabled(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.enabled = paramString;
  }
  
  public final void setRandom_range(Integer paramInteger)
  {
    this.random_range = paramInteger;
  }
  
  public final void setTime(String paramString)
  {
    this.time = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RebootInfo(now=");
    localStringBuilder.append(this.now);
    localStringBuilder.append(", day=");
    localStringBuilder.append(this.day);
    localStringBuilder.append(", enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.time);
    localStringBuilder.append(", random_range=");
    localStringBuilder.append(this.random_range);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\RebootInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */