package com.tplink.libtpnetwork.IoTNetwork.bean.bulb;

import android.text.TextUtils;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.Utils.i;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DesiredStatesBean
  implements Serializable
{
  private boolean auto;
  @c("auto_mode")
  private String autoMode;
  private int brightness;
  @c("color_temp")
  private int colorTemp;
  @c("frost_protection_on")
  private boolean frostProtectionOn;
  private int hue;
  public transient boolean isTRV = false;
  @c("lighting_effect")
  private LightingEffectData lightingEffectData;
  private boolean on;
  private int saturation;
  @c("target_temp")
  private int targetTemp;
  @c("temp_unit")
  private String tempUnit;
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DesiredStatesBean)) {
      return false;
    }
    paramObject = (DesiredStatesBean)paramObject;
    boolean bool3;
    if (this.isTRV)
    {
      bool1 = this.frostProtectionOn;
      if (bool1 == ((DesiredStatesBean)paramObject).frostProtectionOn)
      {
        bool3 = bool2;
        if (!bool1) {
          if ((this.targetTemp == ((DesiredStatesBean)paramObject).targetTemp) && (TextUtils.equals(this.tempUnit, ((DesiredStatesBean)paramObject).tempUnit))) {
            bool3 = bool2;
          } else {
            bool3 = false;
          }
        }
        return bool3;
      }
    }
    else if ((this.on == ((DesiredStatesBean)paramObject).on) && (this.auto == ((DesiredStatesBean)paramObject).isAuto()))
    {
      bool2 = this.on;
      if ((bool2) && (this.auto)) {
        return TextUtils.equals(this.autoMode, ((DesiredStatesBean)paramObject).getAutoMode());
      }
      LightingEffectData localLightingEffectData = this.lightingEffectData;
      if (localLightingEffectData != null) {
        return Objects.equals(localLightingEffectData, ((DesiredStatesBean)paramObject).lightingEffectData);
      }
      bool3 = bool1;
      if (bool2) {
        if ((this.brightness == ((DesiredStatesBean)paramObject).brightness) && (this.colorTemp == ((DesiredStatesBean)paramObject).getColorTemp()) && (this.hue == ((DesiredStatesBean)paramObject).getHue()) && (this.saturation == ((DesiredStatesBean)paramObject).saturation)) {
          bool3 = bool1;
        } else {
          bool3 = false;
        }
      }
      return bool3;
    }
    return false;
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
  
  public int getHue()
  {
    return this.hue;
  }
  
  public LightingEffectData getLightingEffectData()
  {
    return this.lightingEffectData;
  }
  
  public int getSaturation()
  {
    return this.saturation;
  }
  
  public int getTargetTemp()
  {
    return this.targetTemp;
  }
  
  public String getTempUnit()
  {
    return this.tempUnit;
  }
  
  public int hashCode()
  {
    int i = this.brightness;
    int j;
    if (this.on) {
      j = 1231;
    } else {
      j = 1237;
    }
    return i * j;
  }
  
  public boolean isAuto()
  {
    return this.auto;
  }
  
  public boolean isFrostProtectionOn()
  {
    return this.frostProtectionOn;
  }
  
  public boolean isOn()
  {
    return this.on;
  }
  
  public void setAuto(boolean paramBoolean)
  {
    this.auto = paramBoolean;
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
  
  public void setFrostProtectionOn(boolean paramBoolean)
  {
    this.frostProtectionOn = paramBoolean;
  }
  
  public void setHue(int paramInt)
  {
    this.hue = paramInt;
  }
  
  public void setLightingEffectData(LightingEffectData paramLightingEffectData)
  {
    this.lightingEffectData = paramLightingEffectData;
  }
  
  public void setOn(boolean paramBoolean)
  {
    this.on = paramBoolean;
  }
  
  public void setSaturation(int paramInt)
  {
    this.saturation = paramInt;
  }
  
  public void setTargetTemp(int paramInt)
  {
    this.targetTemp = paramInt;
  }
  
  public void setTempUnit(String paramString)
  {
    this.tempUnit = paramString;
  }
  
  public Map<String, Object> toMap()
  {
    HashMap localHashMap = new HashMap();
    if (this.isTRV)
    {
      localHashMap.put("frost_protection_on", Boolean.valueOf(this.frostProtectionOn));
      if (!this.frostProtectionOn)
      {
        localHashMap.put("target_temp", Integer.valueOf(this.targetTemp));
        localHashMap.put("temp_unit", this.tempUnit);
      }
    }
    else
    {
      localHashMap.put("on", Boolean.valueOf(this.on));
      if (this.on)
      {
        Object localObject = this.lightingEffectData;
        if (localObject != null)
        {
          localHashMap.put("lighting_effect", i.i(localObject));
        }
        else
        {
          boolean bool = this.auto;
          if (bool)
          {
            localHashMap.put("auto", Boolean.valueOf(bool));
            localObject = this.autoMode;
            if (localObject != null) {
              localHashMap.put("auto_mode", localObject);
            }
          }
          else
          {
            localHashMap.put("brightness", Integer.valueOf(this.brightness));
            localHashMap.put("color_temp", Integer.valueOf(this.colorTemp));
            localHashMap.put("saturation", Integer.valueOf(this.saturation));
            localHashMap.put("hue", Integer.valueOf(this.hue));
          }
        }
      }
    }
    return localHashMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\bulb\DesiredStatesBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */