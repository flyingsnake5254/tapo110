package com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb;

import androidx.annotation.Nullable;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.io.Serializable;
import java.util.List;

public class LightStateBean
  implements Serializable
{
  private Integer brightness;
  @c("color_temp")
  private Integer colorTemp;
  private Integer hue;
  @c("lighting_effect")
  private LightingEffectData lightingEffectData;
  private Boolean on;
  private Integer saturation;
  
  public LightStateBean() {}
  
  public LightStateBean(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.hue = Integer.valueOf(paramInt1);
    this.saturation = Integer.valueOf(paramInt2);
    this.colorTemp = Integer.valueOf(paramInt3);
    this.brightness = Integer.valueOf(paramInt4);
  }
  
  public LightStateBean(@Nullable LightStateBean paramLightStateBean)
  {
    if (paramLightStateBean != null)
    {
      this.hue = paramLightStateBean.hue;
      this.saturation = paramLightStateBean.saturation;
      this.brightness = paramLightStateBean.brightness;
      this.colorTemp = paramLightStateBean.colorTemp;
      this.on = paramLightStateBean.on;
      this.lightingEffectData = paramLightStateBean.lightingEffectData;
    }
  }
  
  public LightStateBean(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() == 4))
    {
      this.brightness = ((Integer)paramList.get(0));
      this.hue = ((Integer)paramList.get(1));
      this.saturation = ((Integer)paramList.get(2));
      this.colorTemp = ((Integer)paramList.get(3));
    }
  }
  
  public LightStateBean(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.hue = Integer.valueOf(0);
      this.saturation = Integer.valueOf(0);
      this.colorTemp = Integer.valueOf(0);
      this.brightness = Integer.valueOf(0);
    }
  }
  
  public LightStateBean clone()
  {
    return new LightStateBean(getHue(), getSaturation(), getColorTemp(), getBrightness());
  }
  
  public int getBrightness()
  {
    Integer localInteger = this.brightness;
    if (localInteger == null) {
      return 100;
    }
    return localInteger.intValue();
  }
  
  public int getColorTemp()
  {
    Integer localInteger = this.colorTemp;
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public int getHue()
  {
    Integer localInteger = this.hue;
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  @Nullable
  public LightingEffectData getLightingEffectData()
  {
    return this.lightingEffectData;
  }
  
  public int getSaturation()
  {
    Integer localInteger = this.saturation;
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public boolean isOn()
  {
    Boolean localBoolean = this.on;
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public void setBrightness(int paramInt)
  {
    this.brightness = Integer.valueOf(paramInt);
  }
  
  public void setColorTemp(int paramInt)
  {
    this.colorTemp = Integer.valueOf(paramInt);
  }
  
  public void setHue(int paramInt)
  {
    this.hue = Integer.valueOf(paramInt);
  }
  
  public void setLightingEffectData(LightingEffectData paramLightingEffectData)
  {
    this.lightingEffectData = paramLightingEffectData;
  }
  
  public void setOn(boolean paramBoolean)
  {
    this.on = Boolean.valueOf(paramBoolean);
  }
  
  public void setSaturation(int paramInt)
  {
    this.saturation = Integer.valueOf(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\colorbulb\LightStateBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */