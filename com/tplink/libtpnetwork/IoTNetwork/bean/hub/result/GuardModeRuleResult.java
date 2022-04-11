package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;
import java.util.Collection;
import kotlin.jvm.internal.j;

public final class GuardModeRuleResult
  extends ThingRuleListResult<ThingRuleGuardMode>
{
  public GuardModeRuleResult() {}
  
  public GuardModeRuleResult(ThingRuleListResult<ThingRuleGuardMode> paramThingRuleListResult)
  {
    this();
    setMaxCount(paramThingRuleListResult.getMaxCount());
    setRuleList(paramThingRuleListResult.getRuleList());
    paramThingRuleListResult = paramThingRuleListResult.getRuleList();
    j.d(paramThingRuleListResult, "ruleListResult.ruleList");
    setEnable(paramThingRuleListResult.isEmpty() ^ true);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\result\GuardModeRuleResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */