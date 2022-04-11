package com.tplink.libtpnetwork.IoTNetwork.bean.bulb.params;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightEffectEnableBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.Utils.i;
import java.util.Map;

public class BulbDeviceInfoParams
  extends DeviceInfoParams
{
  private Boolean auto;
  @c("auto_mode")
  private String autoMode;
  private Integer brightness;
  @c("color_temp")
  private Integer colorTemp;
  @c("dynamic_light_effect_enable")
  private Boolean dynamicLightEffectEnable;
  @c("dynamic_light_effect_id")
  private String dynamicLightEffectId;
  private Integer hue;
  private Integer saturation;
  
  public BulbDeviceInfoParams() {}
  
  public BulbDeviceInfoParams(DefaultStatesBean paramDefaultStatesBean)
  {
    setDefaultStates(paramDefaultStatesBean);
  }
  
  public BulbDeviceInfoParams(AutoLightBean paramAutoLightBean)
  {
    if (paramAutoLightBean != null)
    {
      this.auto = Boolean.valueOf(paramAutoLightBean.isEnable());
      this.autoMode = paramAutoLightBean.getMode();
    }
  }
  
  public BulbDeviceInfoParams(LightEffectEnableBean paramLightEffectEnableBean)
  {
    if (paramLightEffectEnableBean != null)
    {
      this.dynamicLightEffectEnable = Boolean.valueOf(paramLightEffectEnableBean.isEnable());
      this.dynamicLightEffectId = paramLightEffectEnableBean.getId();
    }
  }
  
  public BulbDeviceInfoParams(LightStateBean paramLightStateBean)
  {
    if (paramLightStateBean != null)
    {
      this.brightness = Integer.valueOf(paramLightStateBean.getBrightness());
      this.hue = Integer.valueOf(paramLightStateBean.getHue());
      this.saturation = Integer.valueOf(paramLightStateBean.getSaturation());
      this.colorTemp = Integer.valueOf(paramLightStateBean.getColorTemp());
    }
  }
  
  public BulbDeviceInfoParams(Boolean paramBoolean)
  {
    setDeviceOn(paramBoolean);
  }
  
  public BulbDeviceInfoParams(Integer paramInteger)
  {
    this.brightness = paramInteger;
  }
  
  public BulbDeviceInfoParams(Integer paramInteger1, Integer paramInteger2)
  {
    super(paramInteger1, paramInteger2);
  }
  
  public BulbDeviceInfoParams(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4)
  {
    this.brightness = paramInteger1;
    this.hue = paramInteger2;
    this.saturation = paramInteger3;
    this.colorTemp = paramInteger4;
  }
  
  public BulbDeviceInfoParams(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public Integer getBrightness()
  {
    return this.brightness;
  }
  
  public Integer getColorTemp()
  {
    return this.colorTemp;
  }
  
  public Boolean getDynamicLightEffectEnable()
  {
    return this.dynamicLightEffectEnable;
  }
  
  public String getDynamicLightEffectId()
  {
    return this.dynamicLightEffectId;
  }
  
  public Integer getHue()
  {
    return this.hue;
  }
  
  public Integer getSaturation()
  {
    return this.saturation;
  }
  
  public boolean isMatchThingModel(ThingModel paramThingModel)
  {
    boolean bool;
    if ((super.isMatchThingModel(paramThingModel)) && (paramThingModel.getThingProperty("brightness") != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setBrightness(Integer paramInteger)
  {
    this.brightness = paramInteger;
  }
  
  public void setColorTemp(Integer paramInteger)
  {
    this.colorTemp = paramInteger;
  }
  
  public void setDynamicLightEffectEnable(Boolean paramBoolean)
  {
    this.dynamicLightEffectEnable = paramBoolean;
  }
  
  public void setDynamicLightEffectId(String paramString)
  {
    this.dynamicLightEffectId = paramString;
  }
  
  public void setHue(Integer paramInteger)
  {
    this.hue = paramInteger;
  }
  
  public void setSaturation(Integer paramInteger)
  {
    this.saturation = paramInteger;
  }
  
  public Map<String, Object> toMap(Map<String, Object> paramMap)
  {
    paramMap = super.toMap(paramMap);
    Object localObject = this.brightness;
    if (localObject != null) {
      paramMap.put("brightness", localObject);
    }
    localObject = this.colorTemp;
    if (localObject != null) {
      paramMap.put("color_temp", localObject);
    }
    localObject = this.hue;
    if (localObject != null) {
      paramMap.put("hue", localObject);
    }
    localObject = this.saturation;
    if (localObject != null) {
      paramMap.put("saturation", localObject);
    }
    localObject = this.auto;
    if (localObject != null) {
      paramMap.put("auto", localObject);
    }
    localObject = this.autoMode;
    if (localObject != null) {
      paramMap.put("auto_mode", localObject);
    }
    localObject = this.dynamicLightEffectEnable;
    if (localObject != null) {
      paramMap.put("dynamic_light_effect_enable", localObject);
    }
    localObject = this.dynamicLightEffectId;
    if (localObject != null) {
      paramMap.put("dynamic_light_effect_id", localObject);
    }
    return paramMap;
  }
  
  public ThingSetting toThingSetting()
  {
    ThingSetting localThingSetting = super.toThingSetting();
    if (getDefaultStates() != null) {
      localThingSetting.setDefaultStates(i.i(getDefaultStates()));
    }
    return localThingSetting;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\bulb\params\BulbDeviceInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */