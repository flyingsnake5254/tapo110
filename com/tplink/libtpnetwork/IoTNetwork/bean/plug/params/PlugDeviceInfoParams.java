package com.tplink.libtpnetwork.IoTNetwork.bean.plug.params;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.Utils.i;

public class PlugDeviceInfoParams
  extends DeviceInfoParams
{
  @c("led_enable")
  private Boolean ledEnable;
  
  public PlugDeviceInfoParams() {}
  
  public PlugDeviceInfoParams(DefaultStatesBean paramDefaultStatesBean)
  {
    setDefaultStates(paramDefaultStatesBean);
  }
  
  public PlugDeviceInfoParams(Boolean paramBoolean)
  {
    setDeviceOn(paramBoolean);
  }
  
  public PlugDeviceInfoParams(Integer paramInteger1, Integer paramInteger2)
  {
    super(paramInteger1, paramInteger2);
  }
  
  public PlugDeviceInfoParams(String paramString)
  {
    setLocation(paramString);
  }
  
  public PlugDeviceInfoParams(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public Boolean getLedEnable()
  {
    return this.ledEnable;
  }
  
  public void setLedEnable(Boolean paramBoolean)
  {
    this.ledEnable = paramBoolean;
  }
  
  public ThingSetting toThingSetting()
  {
    ThingSetting localThingSetting = super.toThingSetting();
    if (getDefaultStates() != null) {
      localThingSetting.setDefaultStates(i.i(getDefaultStates()));
    }
    return localThingSetting;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\plug\params\PlugDeviceInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */