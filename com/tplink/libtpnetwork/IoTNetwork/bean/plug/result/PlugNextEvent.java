package com.tplink.libtpnetwork.IoTNetwork.bean.plug.result;

import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.Utils.i;

public class PlugNextEvent
  extends NextEvent
{
  private transient DesiredStatesBean formatDesiredStates;
  
  public PlugNextEvent() {}
  
  public PlugNextEvent(NextEvent paramNextEvent)
  {
    if (paramNextEvent == null) {
      return;
    }
    setId(paramNextEvent.getId());
    setType(paramNextEvent.getType());
    setStartTime(paramNextEvent.getStartTime());
    setEndTime(paramNextEvent.getEndTime());
    setAction(paramNextEvent.getAction());
    paramNextEvent = paramNextEvent.getDesiredStates();
    if (paramNextEvent != null) {
      this.formatDesiredStates = ((DesiredStatesBean)i.a(i.i(paramNextEvent), DesiredStatesBean.class));
    }
  }
  
  public DesiredStatesBean getFormatDesiredStates()
  {
    return this.formatDesiredStates;
  }
  
  public void setFormatDesiredStates(DesiredStatesBean paramDesiredStatesBean)
  {
    this.formatDesiredStates = paramDesiredStatesBean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\plug\result\PlugNextEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */