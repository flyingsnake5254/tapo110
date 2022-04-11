package com.tplink.libtpnetwork.IoTNetwork.bean.plug.result;

import com.google.gson.q.c;

public class LedInfoSetResult
{
  @c("led_status")
  private boolean ledStatus;
  @c("night_mode")
  private LedNightModeBean nightMode;
  
  public LedNightModeBean getNightMode()
  {
    return this.nightMode;
  }
  
  public boolean isLedStatus()
  {
    return this.ledStatus;
  }
  
  public void setLedStatus(boolean paramBoolean)
  {
    this.ledStatus = paramBoolean;
  }
  
  public void setNightMode(LedNightModeBean paramLedNightModeBean)
  {
    this.nightMode = paramLedNightModeBean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\plug\result\LedInfoSetResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */