package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class Light
{
  @c("inf_type")
  private final String infrared;
  @c("light_freq_mode")
  private final String mode;
  
  public Light(String paramString1, String paramString2)
  {
    this.mode = paramString1;
    this.infrared = paramString2;
  }
  
  public final String component1()
  {
    return this.mode;
  }
  
  public final String component2()
  {
    return this.infrared;
  }
  
  public final Light copy(String paramString1, String paramString2)
  {
    return new Light(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Light))
      {
        paramObject = (Light)paramObject;
        if ((j.a(this.mode, ((Light)paramObject).mode)) && (j.a(this.infrared, ((Light)paramObject).infrared))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getInfrared()
  {
    return this.infrared;
  }
  
  public final LightFrequencyMode getLightFrequencyMode()
  {
    Object localObject = this.mode;
    if (localObject != null) {
      localObject = LightFrequencyMode.Companion.fromString((String)localObject);
    } else {
      localObject = null;
    }
    return (LightFrequencyMode)localObject;
  }
  
  public final String getMode()
  {
    return this.mode;
  }
  
  public final NightMode getNightMode()
  {
    Object localObject = this.infrared;
    if (localObject != null) {
      localObject = NightMode.Companion.fromString((String)localObject);
    } else {
      localObject = null;
    }
    return (NightMode)localObject;
  }
  
  public int hashCode()
  {
    String str = this.mode;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.infrared;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Light(mode=");
    localStringBuilder.append(this.mode);
    localStringBuilder.append(", infrared=");
    localStringBuilder.append(this.infrared);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Light.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */