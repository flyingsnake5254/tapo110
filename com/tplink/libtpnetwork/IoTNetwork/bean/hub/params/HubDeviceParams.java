package com.tplink.libtpnetwork.IoTNetwork.bean.hub.params;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import java.util.Map;

public class HubDeviceParams
  extends DeviceInfoParams
{
  @c("guard_mode")
  private String guardMode;
  @c("guard_on")
  private Boolean guardOn;
  @c("in_alarm")
  private Boolean inAlarm;
  
  public HubDeviceParams() {}
  
  public HubDeviceParams(GuardModeParams paramGuardModeParams)
  {
    this.guardOn = Boolean.valueOf(paramGuardModeParams.getEnable());
    this.guardMode = paramGuardModeParams.getGuardMode();
  }
  
  public String getGuardMode()
  {
    return this.guardMode;
  }
  
  public Boolean getGuardOn()
  {
    return this.guardOn;
  }
  
  public Boolean getInAlarm()
  {
    return this.inAlarm;
  }
  
  public boolean isMatchThingModel(ThingModel paramThingModel)
  {
    boolean bool = false;
    if (paramThingModel == null) {
      return false;
    }
    if (paramThingModel.getThingProperty("guard_on") != null) {
      bool = true;
    }
    return bool;
  }
  
  public void setGuardMode(String paramString)
  {
    this.guardMode = paramString;
  }
  
  public void setGuardOn(Boolean paramBoolean)
  {
    this.guardOn = paramBoolean;
  }
  
  public void setInAlarm(Boolean paramBoolean)
  {
    this.inAlarm = paramBoolean;
  }
  
  public Map<String, Object> toMap()
  {
    Map localMap = super.toMap();
    Object localObject = this.guardOn;
    if (localObject != null) {
      localMap.put("guard_on", localObject);
    }
    localObject = this.guardMode;
    if (localObject != null) {
      localMap.put("guard_mode", localObject);
    }
    localObject = this.inAlarm;
    if (localObject != null) {
      localMap.put("in_alarm", localObject);
    }
    return localMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\params\HubDeviceParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */