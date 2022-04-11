package com.tplink.libtpnetwork.IoTNetwork.bean.trv.params;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class TemperatureOffsetParams
{
  private int offset;
  @c("temp_unit")
  private String tempUnit;
  
  public TemperatureOffsetParams(int paramInt, String paramString)
  {
    this.offset = paramInt;
    this.tempUnit = paramString;
  }
  
  public final int component1()
  {
    return this.offset;
  }
  
  public final String component2()
  {
    return this.tempUnit;
  }
  
  public final TemperatureOffsetParams copy(int paramInt, String paramString)
  {
    j.e(paramString, "tempUnit");
    return new TemperatureOffsetParams(paramInt, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TemperatureOffsetParams))
      {
        paramObject = (TemperatureOffsetParams)paramObject;
        if ((this.offset == ((TemperatureOffsetParams)paramObject).offset) && (j.a(this.tempUnit, ((TemperatureOffsetParams)paramObject).tempUnit))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getOffset()
  {
    return this.offset;
  }
  
  public final String getTempUnit()
  {
    return this.tempUnit;
  }
  
  public int hashCode()
  {
    int i = this.offset;
    String str = this.tempUnit;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public final void setOffset(int paramInt)
  {
    this.offset = paramInt;
  }
  
  public final void setTempUnit(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.tempUnit = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TemperatureOffsetParams(offset=");
    localStringBuilder.append(this.offset);
    localStringBuilder.append(", tempUnit=");
    localStringBuilder.append(this.tempUnit);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\trv\params\TemperatureOffsetParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */