package com.tplink.libtpnetwork.IoTNetwork.bean.common.params;

public class AntiTheftEnableParams
{
  private boolean enable;
  
  public AntiTheftEnableParams() {}
  
  public AntiTheftEnableParams(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\params\AntiTheftEnableParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */