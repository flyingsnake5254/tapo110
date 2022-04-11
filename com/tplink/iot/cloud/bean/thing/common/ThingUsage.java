package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;

public class ThingUsage
{
  @c("energy_usage")
  private ThingEnergyUsage energyUsage;
  @c("power_usage")
  private ThingUsageDetail powerUsage;
  @c("saved_power")
  private ThingUsageDetail savedUsage;
  @c("temperature_records")
  private ThingTemperatureRecords temperatureRecords;
  @c("time_usage")
  private ThingUsageDetail timeUsage;
  
  public ThingEnergyUsage getEnergyUsage()
  {
    return this.energyUsage;
  }
  
  public ThingUsageDetail getPowerUsage()
  {
    return this.powerUsage;
  }
  
  public ThingUsageDetail getSavedUsage()
  {
    return this.savedUsage;
  }
  
  public ThingTemperatureRecords getTemperatureRecords()
  {
    return this.temperatureRecords;
  }
  
  public ThingUsageDetail getTimeUsage()
  {
    return this.timeUsage;
  }
  
  public void setEnergyUsage(ThingEnergyUsage paramThingEnergyUsage)
  {
    this.energyUsage = paramThingEnergyUsage;
  }
  
  public void setPowerUsage(ThingUsageDetail paramThingUsageDetail)
  {
    this.powerUsage = paramThingUsageDetail;
  }
  
  public void setSavedUsage(ThingUsageDetail paramThingUsageDetail)
  {
    this.savedUsage = paramThingUsageDetail;
  }
  
  public void setTemperatureRecords(ThingTemperatureRecords paramThingTemperatureRecords)
  {
    this.temperatureRecords = paramThingTemperatureRecords;
  }
  
  public void setTimeUsage(ThingUsageDetail paramThingUsageDetail)
  {
    this.timeUsage = paramThingUsageDetail;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingUsage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */