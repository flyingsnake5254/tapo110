package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import com.tplink.iot.cloud.bean.thing.common.ThingRuleTimer;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.Utils.i;

public class CountdownRuleBean
  extends ThingRuleTimer
{
  private transient DesiredStatesBean formatDesiredStates;
  
  public CountdownRuleBean() {}
  
  public CountdownRuleBean(ThingRuleTimer paramThingRuleTimer)
  {
    if (paramThingRuleTimer == null) {
      return;
    }
    setId(paramThingRuleTimer.getId());
    setEnable(paramThingRuleTimer.isEnable());
    setDelay(paramThingRuleTimer.getDelay());
    setRemain(paramThingRuleTimer.getRemain());
    setDesiredStates(paramThingRuleTimer.getDesiredStates());
    setAction(paramThingRuleTimer.getAction());
    paramThingRuleTimer = getDesiredStates();
    if (paramThingRuleTimer != null) {
      this.formatDesiredStates = ((DesiredStatesBean)i.a(i.i(paramThingRuleTimer), DesiredStatesBean.class));
    }
  }
  
  public DesiredStatesBean getFormatDesiredStates()
  {
    return this.formatDesiredStates;
  }
  
  public void setFormatDesiredStates(DesiredStatesBean paramDesiredStatesBean)
  {
    this.formatDesiredStates = paramDesiredStatesBean;
    if (paramDesiredStatesBean != null) {
      setDesiredStates(paramDesiredStatesBean.toMap());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\CountdownRuleBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */