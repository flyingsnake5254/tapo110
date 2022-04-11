package com.tplink.libtpnetwork.IoTNetwork.bean.sub.params;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import java.util.HashMap;
import java.util.Map;

public final class SubDeviceInfoParams
  extends DeviceInfoParams
{
  @c("frost_protection_on")
  private Boolean frostProtectionOn;
  @c("max_control_temp")
  private Integer maxControlTemp;
  @c("min_control_temp")
  private Integer minControlTemp;
  @c("target_temp")
  private Integer targetTemp;
  @c("temp_offset")
  private Integer tempOffset;
  @c("temp_unit")
  private String tempUnit;
  
  public final Boolean getFrostProtectionOn()
  {
    return this.frostProtectionOn;
  }
  
  public final Integer getMaxControlTemp()
  {
    return this.maxControlTemp;
  }
  
  public final Integer getMinControlTemp()
  {
    return this.minControlTemp;
  }
  
  public final Integer getTargetTemp()
  {
    return this.targetTemp;
  }
  
  public final Integer getTempOffset()
  {
    return this.tempOffset;
  }
  
  public final String getTempUnit()
  {
    return this.tempUnit;
  }
  
  public boolean isMatchThingModel(ThingModel paramThingModel)
  {
    boolean bool;
    if (paramThingModel != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void setFrostProtectionOn(Boolean paramBoolean)
  {
    this.frostProtectionOn = paramBoolean;
  }
  
  public final void setMaxControlTemp(Integer paramInteger)
  {
    this.maxControlTemp = paramInteger;
  }
  
  public final void setMinControlTemp(Integer paramInteger)
  {
    this.minControlTemp = paramInteger;
  }
  
  public final void setTargetTemp(Integer paramInteger)
  {
    this.targetTemp = paramInteger;
  }
  
  public final void setTempOffset(Integer paramInteger)
  {
    this.tempOffset = paramInteger;
  }
  
  public final void setTempUnit(String paramString)
  {
    this.tempUnit = paramString;
  }
  
  public Map<String, Object> toMap()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = this.tempUnit;
    if (localObject != null) {
      localHashMap.put("temp_unit", localObject);
    }
    localObject = this.targetTemp;
    if (localObject != null) {
      localHashMap.put("target_temp", Integer.valueOf(((Number)localObject).intValue()));
    }
    localObject = this.tempOffset;
    if (localObject != null) {
      localHashMap.put("temp_offset", Integer.valueOf(((Number)localObject).intValue()));
    }
    localObject = this.frostProtectionOn;
    if (localObject != null) {
      localHashMap.put("frost_protection_on", Boolean.valueOf(((Boolean)localObject).booleanValue()));
    }
    localObject = this.minControlTemp;
    if (localObject != null) {
      localHashMap.put("min_control_temp", Integer.valueOf(((Number)localObject).intValue()));
    }
    localObject = this.maxControlTemp;
    if (localObject != null) {
      localHashMap.put("max_control_temp", Integer.valueOf(((Number)localObject).intValue()));
    }
    return localHashMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\params\SubDeviceInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */