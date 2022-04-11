package com.tplink.libtpnetwork.IoTNetwork.bean.trv;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import kotlin.jvm.internal.j;

public final class WindowOpenDetectionBean
{
  public static final Companion Companion = new Companion(null);
  public static final int DEFAULT_DOWN_TEMP_CELSIUS = 3;
  public static final int DEFAULT_DOWN_TEMP_FAHRENHEIT = 5;
  public static final int DEFAULT_OPEN_TIME = 15;
  public static final int DEFAULT_SHUTOFF_DURATION = 30;
  @c("down_temp")
  private int downTemp;
  private boolean enable;
  @c("open_time")
  private int openTime;
  @c("shutoff_duration")
  private int shutoffDuration;
  @c("temp_unit")
  private String tempUnit;
  
  public WindowOpenDetectionBean(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, int paramInt3)
  {
    this.openTime = paramInt1;
    this.downTemp = paramInt2;
    this.tempUnit = paramString;
    this.enable = paramBoolean;
    this.shutoffDuration = paramInt3;
  }
  
  public WindowOpenDetectionBean(boolean paramBoolean, EnumTemperatureUnit paramEnumTemperatureUnit, int paramInt)
  {
    this(15, i, paramEnumTemperatureUnit.getValue(), paramBoolean, paramInt);
  }
  
  public final int component1()
  {
    return this.openTime;
  }
  
  public final int component2()
  {
    return this.downTemp;
  }
  
  public final String component3()
  {
    return this.tempUnit;
  }
  
  public final boolean component4()
  {
    return this.enable;
  }
  
  public final int component5()
  {
    return this.shutoffDuration;
  }
  
  public final WindowOpenDetectionBean copy(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, int paramInt3)
  {
    return new WindowOpenDetectionBean(paramInt1, paramInt2, paramString, paramBoolean, paramInt3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof WindowOpenDetectionBean))
      {
        paramObject = (WindowOpenDetectionBean)paramObject;
        if ((this.openTime == ((WindowOpenDetectionBean)paramObject).openTime) && (this.downTemp == ((WindowOpenDetectionBean)paramObject).downTemp) && (j.a(this.tempUnit, ((WindowOpenDetectionBean)paramObject).tempUnit)) && (this.enable == ((WindowOpenDetectionBean)paramObject).enable) && (this.shutoffDuration == ((WindowOpenDetectionBean)paramObject).shutoffDuration)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getDownTemp()
  {
    return this.downTemp;
  }
  
  public final boolean getEnable()
  {
    return this.enable;
  }
  
  public final int getOpenTime()
  {
    return this.openTime;
  }
  
  public final int getShutoffDuration()
  {
    return this.shutoffDuration;
  }
  
  public final String getTempUnit()
  {
    return this.tempUnit;
  }
  
  public int hashCode()
  {
    int i = this.openTime;
    int j = this.downTemp;
    String str = this.tempUnit;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    int m = this.enable;
    int n = m;
    if (m != 0) {
      n = 1;
    }
    return (((i * 31 + j) * 31 + k) * 31 + n) * 31 + this.shutoffDuration;
  }
  
  public final void setDownTemp(int paramInt)
  {
    this.downTemp = paramInt;
  }
  
  public final void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public final void setOpenTime(int paramInt)
  {
    this.openTime = paramInt;
  }
  
  public final void setShutoffDuration(int paramInt)
  {
    this.shutoffDuration = paramInt;
  }
  
  public final void setTempUnit(String paramString)
  {
    this.tempUnit = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WindowOpenDetectionBean(openTime=");
    localStringBuilder.append(this.openTime);
    localStringBuilder.append(", downTemp=");
    localStringBuilder.append(this.downTemp);
    localStringBuilder.append(", tempUnit=");
    localStringBuilder.append(this.tempUnit);
    localStringBuilder.append(", enable=");
    localStringBuilder.append(this.enable);
    localStringBuilder.append(", shutoffDuration=");
    localStringBuilder.append(this.shutoffDuration);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\trv\WindowOpenDetectionBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */