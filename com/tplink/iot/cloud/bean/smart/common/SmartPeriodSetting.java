package com.tplink.iot.cloud.bean.smart.common;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public class SmartPeriodSetting
{
  private SmartTimeSetting customTime;
  private byte daysOfWeek;
  private String periodType;
  
  public SmartPeriodSetting() {}
  
  public SmartPeriodSetting(String paramString, byte paramByte)
  {
    this.periodType = paramString;
    this.daysOfWeek = ((byte)paramByte);
  }
  
  public SmartPeriodSetting(String paramString, byte paramByte, SmartTimeSetting paramSmartTimeSetting)
  {
    this.periodType = paramString;
    this.daysOfWeek = ((byte)paramByte);
    this.customTime = paramSmartTimeSetting;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartPeriodSetting)paramObject;
      if ((this.daysOfWeek != ((SmartPeriodSetting)paramObject).daysOfWeek) || (!Objects.equals(this.periodType, ((SmartPeriodSetting)paramObject).periodType)) || (!Objects.equals(this.customTime, ((SmartPeriodSetting)paramObject).customTime))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public SmartTimeSetting getCustomTime()
  {
    return this.customTime;
  }
  
  public byte getDaysOfWeek()
  {
    return this.daysOfWeek;
  }
  
  public String getPeriodType()
  {
    return this.periodType;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.periodType, Byte.valueOf(this.daysOfWeek), this.customTime });
  }
  
  public void setCustomTime(SmartTimeSetting paramSmartTimeSetting)
  {
    this.customTime = paramSmartTimeSetting;
  }
  
  public void setDaysOfWeek(byte paramByte)
  {
    this.daysOfWeek = ((byte)paramByte);
  }
  
  public void setPeriodType(String paramString)
  {
    this.periodType = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PeriodType
  {
    public static final String ALL_DAY = "ALL_DAY";
    public static final String CUSTOM = "CUSTOM";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartPeriodSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */