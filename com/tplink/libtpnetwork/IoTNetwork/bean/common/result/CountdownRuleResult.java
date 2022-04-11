package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import com.tplink.iot.cloud.bean.thing.common.ThingRuleTimer;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;
import java.util.List;

public class CountdownRuleResult
  extends ThingRuleListResult<ThingRuleTimer>
{
  public CountdownRuleResult() {}
  
  public CountdownRuleResult(ThingRuleListResult<ThingRuleTimer> paramThingRuleListResult)
  {
    setMaxCount(paramThingRuleListResult.getMaxCount());
    setRuleList(paramThingRuleListResult.getRuleList());
    setEnable(paramThingRuleListResult.getRuleList().isEmpty() ^ true);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\CountdownRuleResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */