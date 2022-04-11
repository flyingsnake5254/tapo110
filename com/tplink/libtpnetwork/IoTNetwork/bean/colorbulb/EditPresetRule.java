package com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb;

public class EditPresetRule
{
  private int index;
  private LightStateBean state;
  
  public int getIndex()
  {
    return this.index;
  }
  
  public LightStateBean getState()
  {
    return this.state;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setState(LightStateBean paramLightStateBean)
  {
    this.state = paramLightStateBean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\colorbulb\EditPresetRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */