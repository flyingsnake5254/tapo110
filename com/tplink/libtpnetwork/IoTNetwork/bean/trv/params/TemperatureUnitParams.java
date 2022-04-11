package com.tplink.libtpnetwork.IoTNetwork.bean.trv.params;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class TemperatureUnitParams
{
  @c("temp_unit")
  private String tempUnit;
  
  public TemperatureUnitParams(String paramString)
  {
    this.tempUnit = paramString;
  }
  
  public final String component1()
  {
    return this.tempUnit;
  }
  
  public final TemperatureUnitParams copy(String paramString)
  {
    j.e(paramString, "tempUnit");
    return new TemperatureUnitParams(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TemperatureUnitParams))
      {
        paramObject = (TemperatureUnitParams)paramObject;
        if (j.a(this.tempUnit, ((TemperatureUnitParams)paramObject).tempUnit)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getTempUnit()
  {
    return this.tempUnit;
  }
  
  public int hashCode()
  {
    String str = this.tempUnit;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public final void setTempUnit(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.tempUnit = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TemperatureUnitParams(tempUnit=");
    localStringBuilder.append(this.tempUnit);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\trv\params\TemperatureUnitParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */