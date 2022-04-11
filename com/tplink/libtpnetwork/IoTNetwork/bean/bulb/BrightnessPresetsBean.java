package com.tplink.libtpnetwork.IoTNetwork.bean.bulb;

import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import java.util.ArrayList;
import java.util.List;

public class BrightnessPresetsBean
{
  private transient boolean isFromLocal;
  private boolean isSet;
  private PresetBean presets;
  
  public PresetBean getPresets()
  {
    return this.presets;
  }
  
  public boolean isFromLocal()
  {
    return this.isFromLocal;
  }
  
  public boolean isSet()
  {
    return this.isSet;
  }
  
  public void setFromLocal(boolean paramBoolean)
  {
    this.isFromLocal = paramBoolean;
  }
  
  public void setPresets(PresetBean paramPresetBean)
  {
    this.presets = paramPresetBean;
  }
  
  public void setSet(boolean paramBoolean)
  {
    this.isSet = paramBoolean;
  }
  
  public static class PresetBean
  {
    private List<Integer> brightness = new ArrayList();
    private List<LightStateBean> states = new ArrayList();
    
    public List<Integer> getBrightness()
    {
      return this.brightness;
    }
    
    public List<LightStateBean> getStates()
    {
      return this.states;
    }
    
    public void setBrightness(List<Integer> paramList)
    {
      this.brightness = paramList;
    }
    
    public void setStates(List<LightStateBean> paramList)
    {
      this.states = paramList;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\bulb\BrightnessPresetsBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */