package com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb;

public class AutoLightBean
{
  public static final String MODE_LIGHT_COMPENSATE = "light_compensate";
  public static final String MODE_LIGHT_TRACK = "light_track";
  private boolean enable;
  private String mode;
  
  public AutoLightBean() {}
  
  public AutoLightBean(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public AutoLightBean(boolean paramBoolean, String paramString)
  {
    this.enable = paramBoolean;
    this.mode = paramString;
  }
  
  public String getMode()
  {
    return this.mode;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setMode(String paramString)
  {
    this.mode = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\colorbulb\AutoLightBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */