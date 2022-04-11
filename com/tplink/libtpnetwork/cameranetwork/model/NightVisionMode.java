package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class NightVisionMode
{
  @c("night_vision_mode")
  private final String nightVisionMode;
  
  public NightVisionMode(NightVisionModeType paramNightVisionModeType)
  {
    this(paramNightVisionModeType.getRaw());
  }
  
  public NightVisionMode(String paramString)
  {
    this.nightVisionMode = paramString;
  }
  
  public final String component1()
  {
    return this.nightVisionMode;
  }
  
  public final NightVisionMode copy(String paramString)
  {
    return new NightVisionMode(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof NightVisionMode))
      {
        paramObject = (NightVisionMode)paramObject;
        if (j.a(this.nightVisionMode, ((NightVisionMode)paramObject).nightVisionMode)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getNightVisionMode()
  {
    return this.nightVisionMode;
  }
  
  public int hashCode()
  {
    String str = this.nightVisionMode;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NightVisionMode(nightVisionMode=");
    localStringBuilder.append(this.nightVisionMode);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\NightVisionMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */