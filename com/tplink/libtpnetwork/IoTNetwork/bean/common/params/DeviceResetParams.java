package com.tplink.libtpnetwork.IoTNetwork.bean.common.params;

public class DeviceResetParams
{
  private int delay;
  
  public DeviceResetParams() {}
  
  public DeviceResetParams(int paramInt)
  {
    this.delay = paramInt;
  }
  
  public int getDelay()
  {
    return this.delay;
  }
  
  public void setDelay(int paramInt)
  {
    this.delay = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\params\DeviceResetParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */