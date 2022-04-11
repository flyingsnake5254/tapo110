package com.tplink.iot.cloud.bean.smart.common;

import java.util.List;

public class SmartLogTrigger
{
  private Byte condition;
  private boolean isManual;
  private SmartScheduleSetting schedule;
  private List<SmartThingTrigger> things;
  
  public Byte getCondition()
  {
    return this.condition;
  }
  
  public SmartScheduleSetting getSchedule()
  {
    return this.schedule;
  }
  
  public List<SmartThingTrigger> getThings()
  {
    return this.things;
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
  
  public void setSchedule(SmartScheduleSetting paramSmartScheduleSetting)
  {
    this.schedule = paramSmartScheduleSetting;
  }
  
  public void setThings(List<SmartThingTrigger> paramList)
  {
    this.things = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartLogTrigger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */