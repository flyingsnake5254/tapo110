package com.tplink.libtpnetwork.IoTNetwork.bean.group;

import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupPresetBean
  implements Serializable
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\group\GroupPresetBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */