package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class TamperDetectConfig
{
  @c("digital_sensitivity")
  private final String digitalSensitivity;
  private final String enabled;
  private final String sensitivity;
  
  public TamperDetectConfig(String paramString1, String paramString2, String paramString3)
  {
    this.digitalSensitivity = paramString1;
    this.enabled = paramString2;
    this.sensitivity = paramString3;
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
  
  public final TamperDetectConfig copy(String paramString1, String paramString2, String paramString3)
  {
    return new TamperDetectConfig(paramString1, paramString2, paramString3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TamperDetectConfig))
      {
        paramObject = (TamperDetectConfig)paramObject;
        if ((j.a(this.digitalSensitivity, ((TamperDetectConfig)paramObject).digitalSensitivity)) && (j.a(this.enabled, ((TamperDetectConfig)paramObject).enabled)) && (j.a(this.sensitivity, ((TamperDetectConfig)paramObject).sensitivity))) {}
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
    if (str != null) {
      i = str.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TamperDetectConfig(digitalSensitivity=");
    localStringBuilder.append(this.digitalSensitivity);
    localStringBuilder.append(", enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(", sensitivity=");
    localStringBuilder.append(this.sensitivity);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\TamperDetectConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */