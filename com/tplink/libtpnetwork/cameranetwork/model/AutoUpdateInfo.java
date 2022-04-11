package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class AutoUpdateInfo
{
  private String enabled;
  @c("random_range")
  private Integer randomRange;
  private String time;
  
  public AutoUpdateInfo(String paramString1, String paramString2, Integer paramInteger)
  {
    this.enabled = paramString1;
    this.time = paramString2;
    this.randomRange = paramInteger;
  }
  
  public final String component1()
  {
    return this.enabled;
  }
  
  public final String component2()
  {
    return this.time;
  }
  
  public final Integer component3()
  {
    return this.randomRange;
  }
  
  public final AutoUpdateInfo copy(String paramString1, String paramString2, Integer paramInteger)
  {
    j.e(paramString1, "enabled");
    return new AutoUpdateInfo(paramString1, paramString2, paramInteger);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof AutoUpdateInfo))
      {
        paramObject = (AutoUpdateInfo)paramObject;
        if ((j.a(this.enabled, ((AutoUpdateInfo)paramObject).enabled)) && (j.a(this.time, ((AutoUpdateInfo)paramObject).time)) && (j.a(this.randomRange, ((AutoUpdateInfo)paramObject).randomRange))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getEnabled()
  {
    return this.enabled;
  }
  
  public final Integer getRandomRange()
  {
    return this.randomRange;
  }
  
  public final String getTime()
  {
    return this.time;
  }
  
  public int hashCode()
  {
    Object localObject = this.enabled;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.time;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.randomRange;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public final void setEnabled(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.enabled = paramString;
  }
  
  public final void setRandomRange(Integer paramInteger)
  {
    this.randomRange = paramInteger;
  }
  
  public final void setTime(String paramString)
  {
    this.time = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AutoUpdateInfo(enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.time);
    localStringBuilder.append(", randomRange=");
    localStringBuilder.append(this.randomRange);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\AutoUpdateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */