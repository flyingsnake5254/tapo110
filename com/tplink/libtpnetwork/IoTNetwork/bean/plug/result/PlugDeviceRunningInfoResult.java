package com.tplink.libtpnetwork.IoTNetwork.bean.plug.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.Utils.i;

public class PlugDeviceRunningInfoResult
  extends DeviceRunningInfoResult
{
  @c("led_enable")
  @Deprecated
  private boolean ledEnable;
  @c("time_usage_past30")
  private int timeUsagePast30;
  @c("time_usage_past7")
  private int timeUsagePast7;
  @c("time_usage_today")
  private int timeUsageToday;
  
  public PlugDeviceRunningInfoResult(ThingDetail paramThingDetail, ThingSetting paramThingSetting, ThingShadowResult paramThingShadowResult, ThingModel paramThingModel)
  {
    this.fwVer = paramThingDetail.getFwVer();
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\plug\result\PlugDeviceRunningInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */