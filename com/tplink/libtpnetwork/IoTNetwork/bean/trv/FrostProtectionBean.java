package com.tplink.libtpnetwork.IoTNetwork.bean.trv;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class FrostProtectionBean
{
  @c("min_temp")
  private int minTemp;
  @c("temp_unit")
  private String tempUnit;
  
  public FrostProtectionBean(int paramInt, String paramString)
  {
    this.minTemp = paramInt;
    this.tempUnit = paramString;
  }
  
  public final int component1()
  {
    return this.minTemp;
  }
  
  public final String component2()
  {
    return this.tempUnit;
  }
  
  public final FrostProtectionBean copy(int paramInt, String paramString)
  {
    return new FrostProtectionBean(paramInt, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof FrostProtectionBean))
      {
        paramObject = (FrostProtectionBean)paramObject;
        if ((this.minTemp == ((FrostProtectionBean)paramObject).minTemp) && (j.a(this.tempUnit, ((FrostProtectionBean)paramObject).tempUnit))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getMinTemp()
  {
    return this.minTemp;
  }
  
  public final String getTempUnit()
  {
    return this.tempUnit;
  }
  
  public int hashCode()
  {
    int i = this.minTemp;
    String str = this.tempUnit;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public final void setMinTemp(int paramInt)
  {
    this.minTemp = paramInt;
  }
  
  public final void setTempUnit(String paramString)
  {
    this.tempUnit = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FrostProtectionBean(minTemp=");
    localStringBuilder.append(this.minTemp);
    localStringBuilder.append(", tempUnit=");
    localStringBuilder.append(this.tempUnit);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\trv\FrostProtectionBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */