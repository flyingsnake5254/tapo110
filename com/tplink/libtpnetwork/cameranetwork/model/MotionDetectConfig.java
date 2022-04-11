package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class MotionDetectConfig
{
  @c("digital_sensitivity")
  private final String digitalSensitivity;
  private final String enabled;
  private final String enhanced;
  private final String sensitivity;
  
  public MotionDetectConfig(int paramInt, boolean paramBoolean, Boolean paramBoolean1)
  {
    this(String.valueOf(paramInt), str, null, paramBoolean1);
  }
  
  public MotionDetectConfig(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.digitalSensitivity = paramString1;
    this.enabled = paramString2;
    this.sensitivity = paramString3;
    this.enhanced = paramString4;
  }
  
  public final String component1()
  {
    return this.digitalSensitivity;
  }
  
  public final String component2()
  {
    return this.enabled;
  }
  
  public final String component3()
  {
    return this.sensitivity;
  }
  
  public final String component4()
  {
    return this.enhanced;
  }
  
  public final MotionDetectConfig copy(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    j.e(paramString1, "digitalSensitivity");
    j.e(paramString2, "enabled");
    return new MotionDetectConfig(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MotionDetectConfig))
      {
        paramObject = (MotionDetectConfig)paramObject;
        if ((j.a(this.digitalSensitivity, ((MotionDetectConfig)paramObject).digitalSensitivity)) && (j.a(this.enabled, ((MotionDetectConfig)paramObject).enabled)) && (j.a(this.sensitivity, ((MotionDetectConfig)paramObject).sensitivity)) && (j.a(this.enhanced, ((MotionDetectConfig)paramObject).enhanced))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getDigitalSensitivity()
  {
    return this.digitalSensitivity;
  }
  
  public final String getEnabled()
  {
    return this.enabled;
  }
  
  public final String getEnhanced()
  {
    return this.enhanced;
  }
  
  public final String getSensitivity()
  {
    return this.sensitivity;
  }
  
  public int hashCode()
  {
    String str = this.digitalSensitivity;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.enabled;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.sensitivity;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.enhanced;
    if (str != null) {
      i = str.hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MotionDetectConfig(digitalSensitivity=");
    localStringBuilder.append(this.digitalSensitivity);
    localStringBuilder.append(", enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(", sensitivity=");
    localStringBuilder.append(this.sensitivity);
    localStringBuilder.append(", enhanced=");
    localStringBuilder.append(this.enhanced);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\MotionDetectConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */