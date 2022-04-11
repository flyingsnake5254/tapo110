package com.tplink.iot.cloud.bean.smart.common;

import java.util.Objects;

public class SmartTimeSetting
{
  private int endTime;
  private int startTime;
  
  public SmartTimeSetting() {}
  
  public SmartTimeSetting(int paramInt1, int paramInt2)
  {
    this.startTime = paramInt1;
    this.endTime = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartTimeSetting)paramObject;
      if ((this.startTime != ((SmartTimeSetting)paramObject).startTime) || (this.endTime != ((SmartTimeSetting)paramObject).endTime)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int getEndTime()
  {
    return this.endTime;
  }
  
  public int getStartTime()
  {
    return this.startTime;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(this.startTime), Integer.valueOf(this.endTime) });
  }
  
  public void setEndTime(int paramInt)
  {
    this.endTime = paramInt;
  }
  
  public void setStartTime(int paramInt)
  {
    this.startTime = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartTimeSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */