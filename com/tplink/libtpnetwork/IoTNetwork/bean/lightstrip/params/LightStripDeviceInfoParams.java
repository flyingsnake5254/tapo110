package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import java.util.Map;

public class LightStripDeviceInfoParams
  extends DeviceInfoParams
{
  private Boolean auto;
  @c("auto_mode")
  private String autoMode;
  private Integer brightness;
  @c("color_temp")
  private Integer colorTemp;
  private Integer hue;
  @c("lighting_effect")
  private LightingEffectData lightingEffect;
  @c("music_rhythm_enable")
  private Boolean musicRhythmEnable;
  @c("music_rhythm_mode")
  private String musicRhythmMode;
  private Integer saturation;
  
  public LightStripDeviceInfoParams() {}
  
  public LightStripDeviceInfoParams(DefaultStatesBean paramDefaultStatesBean)
  {
    setDefaultStates(paramDefaultStatesBean);
  }
  
  public LightStripDeviceInfoParams(AutoLightBean paramAutoLightBean)
  {
    if (paramAutoLightBean != null)
    {
      this.auto = Boolean.valueOf(paramAutoLightBean.isEnable());
      this.autoMode = paramAutoLightBean.getMode();
    }
  }
  
  public LightStripDeviceInfoParams(LightStateBean paramLightStateBean)
  {
    if (paramLightStateBean != null)
    {
      this.hue = Integer.valueOf(paramLightStateBean.getHue());
      this.saturation = Integer.valueOf(paramLightStateBean.getSaturation());
      this.brightness = Integer.valueOf(paramLightStateBean.getBrightness());
      this.colorTemp = Integer.valueOf(paramLightStateBean.getColorTemp());
    }
  }
  
  public LightStripDeviceInfoParams(LightingEffectData paramLightingEffectData)
  {
    this.lightingEffect = paramLightingEffectData;
  }
  
  public LightStripDeviceInfoParams(Boolean paramBoolean)
  {
    setDeviceOn(paramBoolean);
  }
  
  public LightStripDeviceInfoParams(Integer paramInteger)
  {
    this.brightness = paramInteger;
  }
  
  public Boolean getAuto()
  {
    return this.auto;
  }
  
  public String getAutoMode()
  {
    return this.autoMode;
  }
  
  public Integer getBrightness()
  {
    return this.brightness;
  }
  
  public Integer getColorTemp()
  {
    return this.colorTemp;
  }
  
  public Integer getHue()
  {
    return this.hue;
  }
  
  public LightingEffectData getLightingEffect()
  {
    return this.lightingEffect;
  }
  
  public String getMusicRhythmMode()
  {
    return this.musicRhythmMode;
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
  
  public Boolean isMusicRhythmEnable()
  {
    return this.musicRhythmEnable;
  }
  
  public void setAuto(Boolean paramBoolean)
  {
    this.auto = paramBoolean;
  }
  
  public void setAutoMode(String paramString)
  {
    this.autoMode = paramString;
  }
  
  public void setBrightness(Integer paramInteger)
  {
    this.brightness = paramInteger;
  }
  
  public void setColorTemp(Integer paramInteger)
  {
    this.colorTemp = paramInteger;
  }
  
  public void setHue(Integer paramInteger)
  {
    this.hue = paramInteger;
  }
  
  public void setLightingEffect(LightingEffectData paramLightingEffectData)
  {
    this.lightingEffect = paramLightingEffectData;
  }
  
  public void setMusicRhythmEnable(Boolean paramBoolean)
  {
    this.musicRhythmEnable = paramBoolean;
  }
  
  public void setMusicRhythmMode(String paramString)
  {
    this.musicRhythmMode = paramString;
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
    localObject = this.hue;
    if (localObject != null) {
      paramMap.put("hue", localObject);
    }
    localObject = this.saturation;
    if (localObject != null) {
      paramMap.put("saturation", localObject);
    }
    localObject = this.colorTemp;
    if (localObject != null) {
      paramMap.put("color_temp", localObject);
    }
    localObject = this.lightingEffect;
    if (localObject != null) {
      paramMap.put("lighting_effect", localObject);
    }
    localObject = this.auto;
    if (localObject != null) {
      paramMap.put("auto", localObject);
    }
    localObject = this.autoMode;
    if (localObject != null) {
      paramMap.put("auto_mode", localObject);
    }
    localObject = this.musicRhythmEnable;
    if (localObject != null) {
      paramMap.put("music_rhythm_enable", localObject);
    }
    localObject = this.musicRhythmMode;
    if (localObject != null) {
      paramMap.put("music_rhythm_mode", localObject);
    }
    return paramMap;
  }
  
  public ThingSetting toThingSetting()
  {
    ThingSetting localThingSetting = super.toThingSetting();
    if (getDefaultStates() != null) {
      localThingSetting.setDefaultStates(getDefaultStates().toJsonTree());
    }
    return localThingSetting;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\params\LightStripDeviceInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */