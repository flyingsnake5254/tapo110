package com.tplink.libtpnetwork.IoTNetwork.bean.bulb;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.params.BulbDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.result.BulbDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.Utils.i;
import java.util.Map;

public class IoTBulbDevice
  extends LocalIoTBaseDevice
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
  
  public IoTBulbDevice() {}
  
  public IoTBulbDevice(ThingDetail paramThingDetail, ThingSetting paramThingSetting, ThingShadowResult paramThingShadowResult, ThingModel paramThingModel)
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
  
  public DeviceInfoParams getDeviceInfoParams()
  {
    BulbDeviceInfoParams localBulbDeviceInfoParams = new BulbDeviceInfoParams();
    localBulbDeviceInfoParams.setNickname(this.nickname);
    localBulbDeviceInfoParams.setAvatar(this.avatar);
    localBulbDeviceInfoParams.setDeviceOn(Boolean.valueOf(this.deviceOn));
    localBulbDeviceInfoParams.setLongitude(this.longitude);
    localBulbDeviceInfoParams.setLatitude(this.latitude);
    localBulbDeviceInfoParams.setBrightness(Integer.valueOf(this.brightness));
    localBulbDeviceInfoParams.setColorTemp(Integer.valueOf(this.colorTemp));
    localBulbDeviceInfoParams.setSaturation(Integer.valueOf(this.saturation));
    localBulbDeviceInfoParams.setHue(Integer.valueOf(this.hue));
    localBulbDeviceInfoParams.setDefaultStates(this.defaultStates);
    localBulbDeviceInfoParams.setDynamicLightEffectEnable(Boolean.valueOf(this.dynamicLightEffectEnable));
    localBulbDeviceInfoParams.setDynamicLightEffectId(this.dynamicLightEffectId);
    return localBulbDeviceInfoParams;
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
  
  public void updateDeviceInfoParam(DeviceInfoParams paramDeviceInfoParams)
  {
    super.updateDeviceInfoParam(paramDeviceInfoParams);
    if ((paramDeviceInfoParams instanceof BulbDeviceInfoParams))
    {
      paramDeviceInfoParams = (BulbDeviceInfoParams)paramDeviceInfoParams;
      if (paramDeviceInfoParams.getBrightness() != null) {
        this.brightness = paramDeviceInfoParams.getBrightness().intValue();
      }
      if (paramDeviceInfoParams.getHue() != null) {
        this.hue = paramDeviceInfoParams.getHue().intValue();
      }
      if (paramDeviceInfoParams.getSaturation() != null) {
        this.saturation = paramDeviceInfoParams.getSaturation().intValue();
      }
      if (paramDeviceInfoParams.getColorTemp() != null) {
        this.colorTemp = paramDeviceInfoParams.getColorTemp().intValue();
      }
      if (paramDeviceInfoParams.getDynamicLightEffectEnable() != null) {
        this.dynamicLightEffectEnable = paramDeviceInfoParams.getDynamicLightEffectEnable().booleanValue();
      }
      if (paramDeviceInfoParams.getDynamicLightEffectId() != null) {
        this.dynamicLightEffectId = paramDeviceInfoParams.getDynamicLightEffectId();
      }
    }
  }
  
  public void updateDeviceRunningInfo(DeviceRunningInfoResult paramDeviceRunningInfoResult, boolean paramBoolean)
  {
    super.updateDeviceRunningInfo(paramDeviceRunningInfoResult, paramBoolean);
    if ((paramDeviceRunningInfoResult instanceof BulbDeviceRunningInfoResult))
    {
      paramDeviceRunningInfoResult = (BulbDeviceRunningInfoResult)paramDeviceRunningInfoResult;
      this.brightness = paramDeviceRunningInfoResult.getBrightness();
      this.colorTemp = paramDeviceRunningInfoResult.getColorTemp();
      this.hue = paramDeviceRunningInfoResult.getHue();
      this.saturation = paramDeviceRunningInfoResult.getSaturation();
      if (paramDeviceRunningInfoResult.getAutoMode() != null) {
        this.autoMode = paramDeviceRunningInfoResult.getAutoMode();
      }
      this.dynamicLightEffectEnable = paramDeviceRunningInfoResult.isDynamicLightEffectEnable();
      this.dynamicLightEffectId = paramDeviceRunningInfoResult.getDynamicLightEffectId();
    }
  }
  
  public void updateDeviceShadow(Map<String, Object> paramMap)
  {
    super.updateDeviceShadow(paramMap);
    if (paramMap != null)
    {
      boolean bool1 = paramMap.containsKey("on");
      boolean bool2 = true;
      Object localObject;
      if (bool1)
      {
        localObject = paramMap.get("on");
        if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.deviceOn = bool1;
      }
      int i;
      if (paramMap.containsKey("brightness"))
      {
        localObject = paramMap.get("brightness");
        if ((localObject instanceof Number)) {
          i = ((Number)localObject).intValue();
        } else {
          i = 0;
        }
        this.brightness = i;
      }
      if (paramMap.containsKey("color_temp"))
      {
        localObject = paramMap.get("color_temp");
        if ((localObject instanceof Number)) {
          i = ((Number)localObject).intValue();
        } else {
          i = 0;
        }
        this.colorTemp = i;
      }
      if (paramMap.containsKey("hue"))
      {
        localObject = paramMap.get("hue");
        if ((localObject instanceof Number)) {
          i = ((Number)localObject).intValue();
        } else {
          i = 0;
        }
        this.hue = i;
      }
      if (paramMap.containsKey("saturation"))
      {
        localObject = paramMap.get("saturation");
        if ((localObject instanceof Number)) {
          i = ((Number)localObject).intValue();
        } else {
          i = 0;
        }
        this.saturation = i;
      }
      if (paramMap.containsKey("auto"))
      {
        localObject = paramMap.get("auto");
        if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.autoEnable = bool1;
      }
      if (paramMap.containsKey("auto_mode")) {
        this.autoMode = ((String)paramMap.get("auto_mode"));
      }
      if (paramMap.containsKey("dynamic_light_effect_enable"))
      {
        localObject = paramMap.get("dynamic_light_effect_enable");
        if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        this.dynamicLightEffectEnable = bool1;
      }
      if (paramMap.containsKey("dynamic_light_effect_id")) {
        this.dynamicLightEffectId = ((String)paramMap.get("dynamic_light_effect_id"));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\bulb\IoTBulbDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */