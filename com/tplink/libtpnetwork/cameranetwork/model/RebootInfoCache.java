package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class RebootInfoCache
{
  private OptionSwitch enable;
  private String time;
  
  public RebootInfoCache(OptionSwitch paramOptionSwitch, String paramString)
  {
    this.enable = paramOptionSwitch;
    this.time = paramString;
  }
  
  public final OptionSwitch component1()
  {
    return this.enable;
  }
  
  public final String component2()
  {
    return this.time;
  }
  
  public final RebootInfoCache copy(OptionSwitch paramOptionSwitch, String paramString)
  {
    return new RebootInfoCache(paramOptionSwitch, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RebootInfoCache))
      {
        paramObject = (RebootInfoCache)paramObject;
        if ((j.a(this.enable, ((RebootInfoCache)paramObject).enable)) && (j.a(this.time, ((RebootInfoCache)paramObject).time))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final OptionSwitch getEnable()
  {
    return this.enable;
  }
  
  public final String getTime()
  {
    return this.time;
  }
  
  public int hashCode()
  {
    Object localObject = this.enable;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.time;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public final void setEnable(OptionSwitch paramOptionSwitch)
  {
    this.enable = paramOptionSwitch;
  }
  
  public final void setTime(String paramString)
  {
    this.time = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RebootInfoCache(enable=");
    localStringBuilder.append(this.enable);
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.time);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\RebootInfoCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */