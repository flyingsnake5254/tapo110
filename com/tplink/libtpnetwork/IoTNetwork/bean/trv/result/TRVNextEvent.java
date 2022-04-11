package com.tplink.libtpnetwork.IoTNetwork.bean.trv.result;

import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.Utils.i;

public final class TRVNextEvent
  extends NextEvent
{
  private transient DesiredStatesBean desiredStatesBean;
  
  public TRVNextEvent() {}
  
  public TRVNextEvent(NextEvent paramNextEvent)
  {
    this();
    if (paramNextEvent != null)
    {
      setId(paramNextEvent.getId());
      setType(paramNextEvent.getType());
      setStartTime(paramNextEvent.getStartTime());
      setEndTime(paramNextEvent.getEndTime());
      setDesiredStates(paramNextEvent.getDesiredStates());
    }
    if (paramNextEvent != null)
    {
      paramNextEvent = paramNextEvent.getDesiredStates();
      if (paramNextEvent != null) {
        this.desiredStatesBean = ((DesiredStatesBean)i.a(i.i(paramNextEvent), DesiredStatesBean.class));
      }
    }
  }
  
  public final DesiredStatesBean getDesiredStatesBean()
  {
    return this.desiredStatesBean;
  }
  
  public final void setDesiredStatesBean(DesiredStatesBean paramDesiredStatesBean)
  {
    this.desiredStatesBean = paramDesiredStatesBean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\trv\result\TRVNextEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */