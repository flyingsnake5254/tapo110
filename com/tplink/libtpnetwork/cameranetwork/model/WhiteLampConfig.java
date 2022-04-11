package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class WhiteLampConfig
{
  @c("wtl_intensity_level")
  private final String wtlIntensityLevel;
  
  public WhiteLampConfig(int paramInt)
  {
    this(String.valueOf(paramInt));
  }
  
  public WhiteLampConfig(String paramString)
  {
    this.wtlIntensityLevel = paramString;
  }
  
  public final String component1()
  {
    return this.wtlIntensityLevel;
  }
  
  public final WhiteLampConfig copy(String paramString)
  {
    return new WhiteLampConfig(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof WhiteLampConfig))
      {
        paramObject = (WhiteLampConfig)paramObject;
        if (j.a(this.wtlIntensityLevel, ((WhiteLampConfig)paramObject).wtlIntensityLevel)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getWtlIntensityLevel()
  {
    return this.wtlIntensityLevel;
  }
  
  public int hashCode()
  {
    String str = this.wtlIntensityLevel;
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
    localStringBuilder.append("WhiteLampConfig(wtlIntensityLevel=");
    localStringBuilder.append(this.wtlIntensityLevel);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\WhiteLampConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */