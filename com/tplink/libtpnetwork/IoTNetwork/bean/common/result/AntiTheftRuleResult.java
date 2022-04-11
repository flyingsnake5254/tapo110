package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import com.tplink.iot.cloud.bean.thing.common.ThingRuleAwayMode;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;
import java.util.List;

public class AntiTheftRuleResult
  extends ThingRuleListResult<ThingRuleAwayMode>
{
  public AntiTheftRuleResult() {}
  
  public AntiTheftRuleResult(ThingRuleListResult<ThingRuleAwayMode> paramThingRuleListResult)
  {
    setMaxCount(paramThingRuleListResult.getMaxCount());
    setRuleList(paramThingRuleListResult.getRuleList());
    setEnable(paramThingRuleListResult.getRuleList().isEmpty() ^ true);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\AntiTheftRuleResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */