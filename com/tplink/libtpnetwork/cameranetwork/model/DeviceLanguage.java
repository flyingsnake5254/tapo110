package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class DeviceLanguage
{
  private final String language;
  
  public DeviceLanguage(String paramString)
  {
    this.language = paramString;
  }
  
  public final String component1()
  {
    return this.language;
  }
  
  public final DeviceLanguage copy(String paramString)
  {
    j.e(paramString, "language");
    return new DeviceLanguage(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DeviceLanguage))
      {
        paramObject = (DeviceLanguage)paramObject;
        if (j.a(this.language, ((DeviceLanguage)paramObject).language)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getLanguage()
  {
    return this.language;
  }
  
  public int hashCode()
  {
    String str = this.language;
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
    localStringBuilder.append("DeviceLanguage(language=");
    localStringBuilder.append(this.language);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\DeviceLanguage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */