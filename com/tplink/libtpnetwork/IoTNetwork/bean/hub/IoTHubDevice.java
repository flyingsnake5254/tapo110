package com.tplink.libtpnetwork.IoTNetwork.bean.hub;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.HubDeviceParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.HubDeviceRunningInfoResult;
import java.util.Map;

public class IoTHubDevice
  extends LocalIoTBaseDevice
{
  @c("guard_mode")
  private String guardMode;
  @c("guard_on")
  private boolean guardOn;
  @c("in_alarm")
  private boolean inAlarm;
  
  public IoTHubDevice() {}
  
  public IoTHubDevice(ThingDetail paramThingDetail, ThingSetting paramThingSetting, ThingShadowResult paramThingShadowResult, ThingModel paramThingModel)
  {
    this.deviceId = paramThingShadowResult.getThingName();
    this.type = paramThingDetail.getDeviceType();
    this.model = paramThingDetail.getModel();
    this.ssid = paramThingDetail.getSsid();
    this.mac = paramThingDetail.getMac();
    this.hwVer = paramThingDetail.getHwVer();
    this.hwId = paramThingDetail.getHwId();
    this.fwVer = paramThingDetail.getFwVer();
    this.fwId = paramThingDetail.getFwId();
    this.oemId = paramThingDetail.getOemId();
    this.ip = paramThingDetail.getIp();
    this.nickname = paramThingSetting.getNickname();
    this.avatar = paramThingSetting.getAvatarUrl();
    this.longitude = paramThingSetting.getLongitude();
    paramThingDetail = paramThingSetting.getLatitude();
    this.latitude = paramThingDetail;
    Integer localInteger = this.longitude;
    boolean bool1 = true;
    boolean bool2;
    if ((localInteger != null) && (paramThingDetail != null) && (Math.abs(localInteger.intValue()) <= 1800000) && (Math.abs(this.latitude.intValue()) <= 900000)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.hasSetLocationInfo = bool2;
    this.timeDiff = paramThingSetting.getTimeDiff().intValue();
    this.region = paramThingSetting.getRegion();
    this.lang = paramThingSetting.getLang();
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
  
  public DeviceInfoParams getDeviceInfoParams()
  {
    HubDeviceParams localHubDeviceParams = new HubDeviceParams();
    localHubDeviceParams.setNickname(this.nickname);
    localHubDeviceParams.setLocation(this.location);
    localHubDeviceParams.setAvatar(this.avatar);
    localHubDeviceParams.setDeviceOn(Boolean.valueOf(this.deviceOn));
    localHubDeviceParams.setLongitude(this.longitude);
    localHubDeviceParams.setLatitude(this.latitude);
    localHubDeviceParams.setGuardOn(Boolean.valueOf(this.guardOn));
    localHubDeviceParams.setGuardMode(this.guardMode);
    localHubDeviceParams.setInAlarm(Boolean.valueOf(this.inAlarm));
    return localHubDeviceParams;
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
  
  public void updateDeviceInfoParam(DeviceInfoParams paramDeviceInfoParams)
  {
    super.updateDeviceInfoParam(paramDeviceInfoParams);
    if ((paramDeviceInfoParams instanceof HubDeviceParams))
    {
      paramDeviceInfoParams = (HubDeviceParams)paramDeviceInfoParams;
      if (paramDeviceInfoParams.getGuardOn() != null) {
        setGuardOn(paramDeviceInfoParams.getGuardOn().booleanValue());
      }
      if (paramDeviceInfoParams.getGuardMode() != null) {
        setGuardMode(paramDeviceInfoParams.getGuardMode());
      }
      if (paramDeviceInfoParams.getInAlarm() != null) {
        setInAlarm(paramDeviceInfoParams.getInAlarm().booleanValue());
      }
    }
  }
  
  public void updateDeviceRunningInfo(DeviceRunningInfoResult paramDeviceRunningInfoResult, boolean paramBoolean)
  {
    super.updateDeviceRunningInfo(paramDeviceRunningInfoResult, paramBoolean);
    if ((paramDeviceRunningInfoResult instanceof HubDeviceRunningInfoResult))
    {
      paramDeviceRunningInfoResult = (HubDeviceRunningInfoResult)paramDeviceRunningInfoResult;
      this.guardOn = paramDeviceRunningInfoResult.isGuardOn();
      this.guardMode = paramDeviceRunningInfoResult.getGuardMode();
      this.inAlarm = paramDeviceRunningInfoResult.isInAlarm();
    }
  }
  
  public void updateDeviceShadow(Map<String, Object> paramMap)
  {
    super.updateDeviceShadow(paramMap);
    if (paramMap != null)
    {
      boolean bool1 = paramMap.containsKey("guard_on");
      boolean bool2 = true;
      if (bool1)
      {
        Object localObject = paramMap.get("guard_on");
        if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.guardOn = bool1;
      }
      if (paramMap.containsKey("guard_mode")) {
        this.guardMode = ((String)paramMap.get("guard_mode"));
      }
      if (paramMap.containsKey("in_alarm"))
      {
        paramMap = paramMap.get("in_alarm");
        if (((paramMap instanceof Boolean)) && (((Boolean)paramMap).booleanValue())) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        this.inAlarm = bool1;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\IoTHubDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */