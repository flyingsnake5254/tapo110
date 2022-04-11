package com.tplink.iot.cloud.bean.smart.common;

import java.util.Objects;

public class SmartScheduleSetting
{
  private byte daysOfWeek;
  private int mode;
  private Integer offsetMins;
  private Integer time;
  
  public SmartScheduleSetting() {}
  
  public SmartScheduleSetting(int paramInt, byte paramByte)
  {
    this.mode = paramInt;
    this.daysOfWeek = ((byte)paramByte);
  }
  
  public SmartScheduleSetting(int paramInt, byte paramByte, Integer paramInteger)
  {
    this.mode = paramInt;
    this.daysOfWeek = ((byte)paramByte);
    this.time = paramInteger;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartScheduleSetting)paramObject;
      if ((this.mode != ((SmartScheduleSetting)paramObject).mode) || (this.daysOfWeek != ((SmartScheduleSetting)paramObject).daysOfWeek) || (!Objects.equals(this.time, ((SmartScheduleSetting)paramObject).time)) || (!Objects.equals(this.offsetMins, ((SmartScheduleSetting)paramObject).offsetMins))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public byte getDaysOfWeek()
  {
    return this.daysOfWeek;
  }
  
  public int getMode()
  {
    return this.mode;
  }
  
  public Integer getOffsetMins()
  {
    return this.offsetMins;
  }
  
  public Integer getTime()
  {
    return this.time;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(this.mode), Byte.valueOf(this.daysOfWeek), this.time, this.offsetMins });
  }
  
  public void setDaysOfWeek(byte paramByte)
  {
    this.daysOfWeek = ((byte)paramByte);
  }
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public void setOffsetMins(Integer paramInteger)
  {
    this.offsetMins = paramInteger;
  }
  
  public void setTime(Integer paramInteger)
  {
    this.time = paramInteger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartScheduleSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */