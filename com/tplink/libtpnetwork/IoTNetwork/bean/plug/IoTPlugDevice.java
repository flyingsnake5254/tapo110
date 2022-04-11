package com.tplink.libtpnetwork.IoTNetwork.bean.plug;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.params.PlugDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.PlugDeviceRunningInfoResult;
import com.tplink.libtpnetwork.Utils.i;
import java.util.Map;

public class IoTPlugDevice
  extends LocalIoTBaseDevice
{
  @c("led_enable")
  @Deprecated
  private boolean ledEnable;
  @c("on_time")
  private long onTime;
  @c("time_usage_past30")
  private int timeUsagePast30;
  @c("time_usage_past7")
  private int timeUsagePast7;
  @c("time_usage_today")
  private int timeUsageToday;
  
  public IoTPlugDevice() {}
  
  public IoTPlugDevice(ThingDetail paramThingDetail, ThingSetting paramThingSetting, ThingShadowResult paramThingShadowResult, ThingModel paramThingModel)
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
    Integer localInteger = paramThingSetting.getLatitude();
    this.latitude = localInteger;
    paramThingDetail = this.longitude;
    boolean bool1 = true;
    boolean bool2;
    if ((paramThingDetail != null) && (localInteger != null) && (Math.abs(paramThingDetail.intValue()) <= 1800000) && (Math.abs(this.latitude.intValue()) <= 900000)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.hasSetLocationInfo = bool2;
    this.timeDiff = paramThingSetting.getTimeDiff().intValue();
    this.region = paramThingSetting.getRegion();
    this.lang = paramThingSetting.getLang();
    this.defaultStates = ((DefaultStatesBean)i.a(paramThingSetting.getDefaultStates(), DefaultStatesBean.class));
    if (paramThingModel != null)
    {
      paramThingDetail = paramThingModel.getThingProperty("on");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if (((paramThingDetail instanceof Boolean)) && (((Boolean)paramThingDetail).booleanValue())) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
        this.deviceOn = bool2;
      }
    }
  }
  
  public DeviceInfoParams getDeviceInfoParams()
  {
    PlugDeviceInfoParams localPlugDeviceInfoParams = new PlugDeviceInfoParams();
    localPlugDeviceInfoParams.setNickname(this.nickname);
    localPlugDeviceInfoParams.setLocation(this.location);
    localPlugDeviceInfoParams.setAvatar(this.avatar);
    localPlugDeviceInfoParams.setDeviceOn(Boolean.valueOf(this.deviceOn));
    localPlugDeviceInfoParams.setLongitude(this.longitude);
    localPlugDeviceInfoParams.setLatitude(this.latitude);
    localPlugDeviceInfoParams.setLedEnable(Boolean.valueOf(this.ledEnable));
    localPlugDeviceInfoParams.setDefaultStates(this.defaultStates);
    return localPlugDeviceInfoParams;
  }
  
  public long getOnTime()
  {
    return this.onTime;
  }
  
  public int getTimeUsagePast30()
  {
    return this.timeUsagePast30;
  }
  
  public int getTimeUsagePast7()
  {
    return this.timeUsagePast7;
  }
  
  public int getTimeUsageToday()
  {
    return this.timeUsageToday;
  }
  
  public boolean isLedEnable()
  {
    return this.ledEnable;
  }
  
  public void setLedEnable(boolean paramBoolean)
  {
    this.ledEnable = paramBoolean;
  }
  
  public void setOnTime(long paramLong)
  {
    this.onTime = paramLong;
  }
  
  public void setTimeUsagePast30(int paramInt)
  {
    this.timeUsagePast30 = paramInt;
  }
  
  public void setTimeUsagePast7(int paramInt)
  {
    this.timeUsagePast7 = paramInt;
  }
  
  public void setTimeUsageToday(int paramInt)
  {
    this.timeUsageToday = paramInt;
  }
  
  public void updateDeviceInfoParam(DeviceInfoParams paramDeviceInfoParams)
  {
    super.updateDeviceInfoParam(paramDeviceInfoParams);
    if ((paramDeviceInfoParams instanceof PlugDeviceInfoParams))
    {
      paramDeviceInfoParams = (PlugDeviceInfoParams)paramDeviceInfoParams;
      if (paramDeviceInfoParams.getLedEnable() != null) {
        this.ledEnable = paramDeviceInfoParams.getLedEnable().booleanValue();
      }
    }
  }
  
  public void updateDeviceRunningInfo(DeviceRunningInfoResult paramDeviceRunningInfoResult, boolean paramBoolean)
  {
    super.updateDeviceRunningInfo(paramDeviceRunningInfoResult, paramBoolean);
    if (paramDeviceRunningInfoResult != null) {
      this.onTime = paramDeviceRunningInfoResult.getOnTime();
    }
    if ((paramDeviceRunningInfoResult instanceof PlugDeviceRunningInfoResult))
    {
      paramDeviceRunningInfoResult = (PlugDeviceRunningInfoResult)paramDeviceRunningInfoResult;
      this.ledEnable = paramDeviceRunningInfoResult.isLedEnable();
      this.timeUsageToday = paramDeviceRunningInfoResult.getTimeUsageToday();
      this.timeUsagePast7 = paramDeviceRunningInfoResult.getTimeUsagePast7();
      this.timeUsagePast30 = paramDeviceRunningInfoResult.getTimeUsagePast30();
    }
  }
  
  public void updateDeviceShadow(Map<String, Object> paramMap)
  {
    super.updateDeviceShadow(paramMap);
    if ((paramMap != null) && (paramMap.containsKey("on")))
    {
      paramMap = paramMap.get("on");
      boolean bool;
      if (((paramMap instanceof Boolean)) && (((Boolean)paramMap).booleanValue())) {
        bool = true;
      } else {
        bool = false;
      }
      this.deviceOn = bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\plug\IoTPlugDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */