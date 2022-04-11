package com.tplink.libtpnetwork.IoTNetwork.bean.bulb.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.Utils.i;

public class BulbDeviceRunningInfoResult
  extends DeviceRunningInfoResult
{
  private transient boolean autoEnable;
  private transient String autoMode;
  private int brightness;
  @c("color_temp")
  private int colorTemp;
  @c("dynamic_light_effect_enable")
  private boolean dynamicLightEffectEnable;
  @c("dynamic_light_effect_id")
  private String dynamicLightEffectId;
  private int hue;
  private int saturation;
  
  public BulbDeviceRunningInfoResult() {}
  
  public BulbDeviceRunningInfoResult(ThingDetail paramThingDetail, ThingSetting paramThingSetting, ThingShadowResult paramThingShadowResult, ThingModel paramThingModel)
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
          bool2 = true;
        } else {
          bool2 = false;
        }
        this.deviceOn = bool2;
      }
      paramThingDetail = paramThingModel.getThingProperty("brightness");
      int i;
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          i = ((Number)paramThingDetail).intValue();
        } else {
          i = 0;
        }
        this.brightness = i;
      }
      paramThingDetail = paramThingModel.getThingProperty("color_temp");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          i = ((Number)paramThingDetail).intValue();
        } else {
          i = 0;
        }
        this.colorTemp = i;
      }
      paramThingDetail = paramThingModel.getThingProperty("hue");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          i = ((Number)paramThingDetail).intValue();
        } else {
          i = 0;
        }
        this.hue = i;
      }
      paramThingDetail = paramThingModel.getThingProperty("saturation");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          i = ((Number)paramThingDetail).intValue();
        } else {
          i = 0;
        }
        this.saturation = i;
      }
      paramThingDetail = paramThingModel.getThingProperty("auto");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if (((paramThingDetail instanceof Boolean)) && (((Boolean)paramThingDetail).booleanValue())) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        this.autoEnable = bool2;
      }
      paramThingDetail = paramThingModel.getThingProperty("auto_mode");
      if (paramThingDetail != null) {
        this.autoMode = ((String)paramThingShadowResult.getReportedValue(paramThingDetail));
      }
      paramThingDetail = paramThingModel.getThingProperty("dynamic_light_effect_enable");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if (((paramThingDetail instanceof Boolean)) && (((Boolean)paramThingDetail).booleanValue())) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
        this.dynamicLightEffectEnable = bool2;
      }
      paramThingDetail = paramThingModel.getThingProperty("dynamic_light_effect_id");
      if (paramThingDetail != null) {
        this.dynamicLightEffectId = ((String)paramThingShadowResult.getReportedValue(paramThingDetail));
      }
    }
  }
  
  public String getAutoMode()
  {
    return this.autoMode;
  }
  
  public int getBrightness()
  {
    return this.brightness;
  }
  
  public int getColorTemp()
  {
    return this.colorTemp;
  }
  
  public String getDynamicLightEffectId()
  {
    return this.dynamicLightEffectId;
  }
  
  public int getHue()
  {
    return this.hue;
  }
  
  public int getSaturation()
  {
    return this.saturation;
  }
  
  public boolean isAutoEnable()
  {
    return this.autoEnable;
  }
  
  public boolean isDynamicLightEffectEnable()
  {
    return this.dynamicLightEffectEnable;
  }
  
  public void setAutoEnable(boolean paramBoolean)
  {
    this.autoEnable = paramBoolean;
  }
  
  public void setAutoMode(String paramString)
  {
    this.autoMode = paramString;
  }
  
  public void setBrightness(int paramInt)
  {
    this.brightness = paramInt;
  }
  
  public void setColorTemp(int paramInt)
  {
    this.colorTemp = paramInt;
  }
  
  public void setDynamicLightEffectEnable(boolean paramBoolean)
  {
    this.dynamicLightEffectEnable = paramBoolean;
  }
  
  public void setDynamicLightEffectId(String paramString)
  {
    this.dynamicLightEffectId = paramString;
  }
  
  public void setHue(int paramInt)
  {
    this.hue = paramInt;
  }
  
  public void setSaturation(int paramInt)
  {
    this.saturation = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\bulb\result\BulbDeviceRunningInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */