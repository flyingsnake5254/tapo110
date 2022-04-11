package com.tplink.libtpnetwork.IoTNetwork.bean.plug.result;

import com.google.gson.q.c;
import java.io.Serializable;

public class LedInfoBean
  implements Serializable
{
  @c("led_rule")
  private String ledRule;
  @c("led_status")
  private Boolean ledStatus;
  @c("night_mode")
  private LedNightModeBean nightMode;
  
  public String getLedRule()
  {
    return this.ledRule;
  }
  
  public Boolean getLedStatus()
  {
    return this.ledStatus;
  }
  
  public boolean getLocalLedStatus()
  {
    Boolean localBoolean = this.ledStatus;
    boolean bool;
    if (localBoolean == null) {
      bool = true;
    } else {
      bool = localBoolean.booleanValue();
    }
    return bool;
  }
  
  public LedNightModeBean getNightMode()
  {
    return this.nightMode;
  }
  
  public void setLedRule(String paramString)
  {
    this.ledRule = paramString;
  }
  
  public void setLedStatus(Boolean paramBoolean)
  {
    this.ledStatus = paramBoolean;
  }
  
  public void setNightMode(LedNightModeBean paramLedNightModeBean)
  {
    this.nightMode = paramLedNightModeBean;
  }
  
  public void updateLedInfoParams(LedInfoBean paramLedInfoBean)
  {
    if (paramLedInfoBean != null)
    {
      setLedStatus(paramLedInfoBean.getLedStatus());
      setLedRule(paramLedInfoBean.getLedRule());
      setNightMode(paramLedInfoBean.getNightMode());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\plug\result\LedInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */