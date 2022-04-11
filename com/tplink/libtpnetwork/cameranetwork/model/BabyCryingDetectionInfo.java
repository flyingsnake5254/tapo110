package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class BabyCryingDetectionInfo
{
  private final String enabled;
  private final String sensitivity;
  
  public BabyCryingDetectionInfo(String paramString1, String paramString2)
  {
    this.enabled = paramString1;
    this.sensitivity = paramString2;
  }
  
  public BabyCryingDetectionInfo(boolean paramBoolean, String paramString)
  {
    this(str, paramString);
  }
  
  public final String component1()
  {
    return this.enabled;
  }
  
  public final String component2()
  {
    return this.sensitivity;
  }
  
  public final BabyCryingDetectionInfo copy(String paramString1, String paramString2)
  {
    j.e(paramString1, "enabled");
    j.e(paramString2, "sensitivity");
    return new BabyCryingDetectionInfo(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof BabyCryingDetectionInfo))
      {
        paramObject = (BabyCryingDetectionInfo)paramObject;
        if ((j.a(this.enabled, ((BabyCryingDetectionInfo)paramObject).enabled)) && (j.a(this.sensitivity, ((BabyCryingDetectionInfo)paramObject).sensitivity))) {}
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
  
  public final String getSensitivity()
  {
    return this.sensitivity;
  }
  
  public int hashCode()
  {
    String str = this.enabled;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.sensitivity;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BabyCryingDetectionInfo(enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(", sensitivity=");
    localStringBuilder.append(this.sensitivity);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\BabyCryingDetectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */