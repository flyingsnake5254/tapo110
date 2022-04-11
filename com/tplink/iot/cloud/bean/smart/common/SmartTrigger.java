package com.tplink.iot.cloud.bean.smart.common;

import java.util.List;
import java.util.Objects;

public class SmartTrigger
{
  private Byte condition;
  private boolean isManual;
  private List<SmartScheduleSetting> schedules;
  private List<SmartThingTrigger> things;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartTrigger)paramObject;
      if ((this.isManual != ((SmartTrigger)paramObject).isManual) || (!Objects.equals(this.condition, ((SmartTrigger)paramObject).condition)) || (!Objects.equals(this.schedules, ((SmartTrigger)paramObject).schedules)) || (!Objects.equals(this.things, ((SmartTrigger)paramObject).things))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public Byte getCondition()
  {
    return this.condition;
  }
  
  public List<SmartScheduleSetting> getSchedules()
  {
    return this.schedules;
  }
  
  public List<SmartThingTrigger> getThings()
  {
    return this.things;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Boolean.valueOf(this.isManual), this.condition, this.schedules, this.things });
  }
  
  public boolean isManual()
  {
    return this.isManual;
  }
  
  public void setCondition(Byte paramByte)
  {
    this.condition = paramByte;
  }
  
  public void setManual(boolean paramBoolean)
  {
    this.isManual = paramBoolean;
  }
  
  public void setSchedules(List<SmartScheduleSetting> paramList)
  {
    this.schedules = paramList;
  }
  
  public void setThings(List<SmartThingTrigger> paramList)
  {
    this.things = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartTrigger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */