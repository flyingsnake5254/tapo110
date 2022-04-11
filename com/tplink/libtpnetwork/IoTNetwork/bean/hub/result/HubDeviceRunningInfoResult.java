package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;

public class HubDeviceRunningInfoResult
  extends DeviceRunningInfoResult
{
  @c("guard_mode")
  private String guardMode;
  @c("guard_on")
  private boolean guardOn;
  @c("in_alarm")
  private boolean inAlarm;
  @c("led_enable")
  @Deprecated
  private boolean ledEnable;
  
  public HubDeviceRunningInfoResult(ThingDetail paramThingDetail, ThingSetting paramThingSetting, ThingShadowResult paramThingShadowResult, ThingModel paramThingModel)
  {
    this.fwVer = paramThingDetail.getFwVer();
    this.ip = paramThingDetail.getIp();
    this.nickname = paramThingSetting.getNickname();
    this.avatar = paramThingSetting.getAvatarUrl();
    this.longitude = paramThingSetting.getLongitude();
    paramThingDetail = paramThingSetting.getLatitude();
    this.latitude = paramThingDetail;
    paramThingSetting = this.longitude;
    boolean bool1 = true;
    boolean bool2;
    if ((paramThingSetting != null) && (paramThingDetail != null) && (Math.abs(paramThingSetting.intValue()) <= 1800000) && (Math.abs(this.latitude.intValue()) <= 900000)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.hasSetLocationInfo = bool2;
    if (paramThingModel != null)
    {
      paramThingDetail = paramThingModel.getThingProperty("guard_on");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if (((paramThingDetail instanceof Boolean)) && (((Boolean)paramThingDetail).booleanValue())) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        this.guardOn = bool2;
      }
      paramThingDetail = paramThingModel.getThingProperty("guard_mode");
      if (paramThingDetail != null) {
        this.guardMode = ((String)paramThingShadowResult.getReportedValue(paramThingDetail));
      }
      paramThingDetail = paramThingModel.getThingProperty("in_alarm");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if (((paramThingDetail instanceof Boolean)) && (((Boolean)paramThingDetail).booleanValue())) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
        this.inAlarm = bool2;
      }
    }
  }
  
  public String getGuardMode()
  {
    return this.guardMode;
  }
  
  public boolean isGuardOn()
  {
    return this.guardOn;
  }
  
  public boolean isInAlarm()
  {
    return this.inAlarm;
  }
  
  public boolean isLedEnable()
  {
    return this.ledEnable;
  }
  
  public void setGuardMode(String paramString)
  {
    this.guardMode = paramString;
  }
  
  public void setGuardOn(boolean paramBoolean)
  {
    this.guardOn = paramBoolean;
  }
  
  public void setInAlarm(boolean paramBoolean)
  {
    this.inAlarm = paramBoolean;
  }
  
  public void setLedEnable(boolean paramBoolean)
  {
    this.ledEnable = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\result\HubDeviceRunningInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */