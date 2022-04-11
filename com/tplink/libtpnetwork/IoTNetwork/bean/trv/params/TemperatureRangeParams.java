package com.tplink.libtpnetwork.IoTNetwork.bean.trv.params;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class TemperatureRangeParams
{
  @c("max_control_temp")
  private int maxControlTemp;
  @c("min_control_temp")
  private int minControlTemp;
  @c("temp_unit")
  private String tempUnit;
  
  public TemperatureRangeParams(int paramInt1, int paramInt2, String paramString)
  {
    this.minControlTemp = paramInt1;
    this.maxControlTemp = paramInt2;
    this.tempUnit = paramString;
  }
  
  public final int component1()
  {
    return this.minControlTemp;
  }
  
  public final int component2()
  {
    return this.maxControlTemp;
  }
  
  public final String component3()
  {
    return this.tempUnit;
  }
  
  public final TemperatureRangeParams copy(int paramInt1, int paramInt2, String paramString)
  {
    j.e(paramString, "tempUnit");
    return new TemperatureRangeParams(paramInt1, paramInt2, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TemperatureRangeParams))
      {
        paramObject = (TemperatureRangeParams)paramObject;
        if ((this.minControlTemp == ((TemperatureRangeParams)paramObject).minControlTemp) && (this.maxControlTemp == ((TemperatureRangeParams)paramObject).maxControlTemp) && (j.a(this.tempUnit, ((TemperatureRangeParams)paramObject).tempUnit))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getMaxControlTemp()
  {
    return this.maxControlTemp;
  }
  
  public final int getMinControlTemp()
  {
    return this.minControlTemp;
  }
  
  public final String getTempUnit()
  {
    return this.tempUnit;
  }
  
  public int hashCode()
  {
    int i = this.minControlTemp;
    int j = this.maxControlTemp;
    String str = this.tempUnit;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    return (i * 31 + j) * 31 + k;
  }
  
  public final void setMaxControlTemp(int paramInt)
  {
    this.maxControlTemp = paramInt;
  }
  
  public final void setMinControlTemp(int paramInt)
  {
    this.minControlTemp = paramInt;
  }
  
  public final void setTempUnit(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.tempUnit = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TemperatureRangeParams(minControlTemp=");
    localStringBuilder.append(this.minControlTemp);
    localStringBuilder.append(", maxControlTemp=");
    localStringBuilder.append(this.maxControlTemp);
    localStringBuilder.append(", tempUnit=");
    localStringBuilder.append(this.tempUnit);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\trv\params\TemperatureRangeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */