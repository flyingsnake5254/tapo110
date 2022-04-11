package com.tplink.libtpnetwork.IoTNetwork.bean.bulb;

import androidx.annotation.Nullable;
import com.google.gson.k;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DefaultStatesStateBean;
import java.io.Serializable;

public class DefaultStatesBean
  implements Serializable
{
  public static final String KEY_BRIGHTNESS = "brightness";
  public static final String KEY_STATE = "state";
  public static final String KEY_TYPE = "type";
  public static final String TYPE_CUSTOM = "custom";
  public static final String TYPE_LAST_STATES = "last_states";
  private BrightnessBean brightness;
  @Nullable
  private DefaultStatesStateBean state;
  private String type;
  
  public DefaultStatesBean() {}
  
  public DefaultStatesBean(String paramString, @Nullable DefaultStatesStateBean paramDefaultStatesStateBean)
  {
    this.type = paramString;
    this.state = paramDefaultStatesStateBean;
  }
  
  public BrightnessBean getBrightness()
  {
    return this.brightness;
  }
  
  public LightStateBean getLightState()
  {
    return this.state;
  }
  
  @Nullable
  public DefaultStatesStateBean getState()
  {
    return this.state;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setBrightness(BrightnessBean paramBrightnessBean)
  {
    this.brightness = paramBrightnessBean;
  }
  
  public void setLightState(LightStateBean paramLightStateBean)
  {
    this.state = new DefaultStatesStateBean(paramLightStateBean);
  }
  
  public void setState(@Nullable DefaultStatesStateBean paramDefaultStatesStateBean)
  {
    this.state = paramDefaultStatesStateBean;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public com.google.gson.i toJsonTree()
  {
    if (this.brightness != null)
    {
      localk = new k();
      localk.j("brightness", com.tplink.libtpnetwork.Utils.i.i(this.brightness));
      return localk;
    }
    k localk = new k();
    localk.m("type", this.type);
    DefaultStatesStateBean localDefaultStatesStateBean = this.state;
    if (localDefaultStatesStateBean != null) {
      localk.j("state", localDefaultStatesStateBean.toJsonTree());
    }
    return localk;
  }
  
  public static class BrightnessBean
    implements Serializable
  {
    private String type;
    private Integer value;
    
    public String getType()
    {
      return this.type;
    }
    
    public int getValue()
    {
      Integer localInteger = this.value;
      int i;
      if (localInteger == null) {
        i = 1;
      } else {
        i = localInteger.intValue();
      }
      return i;
    }
    
    public void setType(String paramString)
    {
      this.type = paramString;
    }
    
    public void setValue(Integer paramInteger)
    {
      this.value = paramInteger;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\bulb\DefaultStatesBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */