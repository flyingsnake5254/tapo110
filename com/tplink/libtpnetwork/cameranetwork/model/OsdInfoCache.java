package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class OsdInfoCache
{
  private OptionSwitch enable;
  private OptionSwitch logoEnable;
  private String name;
  private OptionSwitch textEnable;
  
  public OsdInfoCache(OptionSwitch paramOptionSwitch1, String paramString, OptionSwitch paramOptionSwitch2, OptionSwitch paramOptionSwitch3)
  {
    this.enable = paramOptionSwitch1;
    this.name = paramString;
    this.textEnable = paramOptionSwitch2;
    this.logoEnable = paramOptionSwitch3;
  }
  
  public final OptionSwitch component1()
  {
    return this.enable;
  }
  
  public final String component2()
  {
    return this.name;
  }
  
  public final OptionSwitch component3()
  {
    return this.textEnable;
  }
  
  public final OptionSwitch component4()
  {
    return this.logoEnable;
  }
  
  public final OsdInfoCache copy(OptionSwitch paramOptionSwitch1, String paramString, OptionSwitch paramOptionSwitch2, OptionSwitch paramOptionSwitch3)
  {
    return new OsdInfoCache(paramOptionSwitch1, paramString, paramOptionSwitch2, paramOptionSwitch3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof OsdInfoCache))
      {
        paramObject = (OsdInfoCache)paramObject;
        if ((j.a(this.enable, ((OsdInfoCache)paramObject).enable)) && (j.a(this.name, ((OsdInfoCache)paramObject).name)) && (j.a(this.textEnable, ((OsdInfoCache)paramObject).textEnable)) && (j.a(this.logoEnable, ((OsdInfoCache)paramObject).logoEnable))) {}
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
  
  public final OptionSwitch getLogoEnable()
  {
    return this.logoEnable;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final OptionSwitch getTextEnable()
  {
    return this.textEnable;
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
    localObject = this.name;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.textEnable;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.logoEnable;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public final void setEnable(OptionSwitch paramOptionSwitch)
  {
    this.enable = paramOptionSwitch;
  }
  
  public final void setLogoEnable(OptionSwitch paramOptionSwitch)
  {
    this.logoEnable = paramOptionSwitch;
  }
  
  public final void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public final void setTextEnable(OptionSwitch paramOptionSwitch)
  {
    this.textEnable = paramOptionSwitch;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OsdInfoCache(enable=");
    localStringBuilder.append(this.enable);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", textEnable=");
    localStringBuilder.append(this.textEnable);
    localStringBuilder.append(", logoEnable=");
    localStringBuilder.append(this.logoEnable);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\OsdInfoCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */