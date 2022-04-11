package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import com.tplink.iot.cloud.bean.thing.common.ThingRuleLightEffect;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;

public class LightEffectRuleResult
  extends ThingRuleListResult<ThingRuleLightEffect>
{
  public LightEffectRuleResult() {}
  
  public LightEffectRuleResult(ThingRuleListResult<ThingRuleLightEffect> paramThingRuleListResult)
  {
    setEnable(paramThingRuleListResult.isEnable());
    setCurrentRuleId(paramThingRuleListResult.getCurrentRuleId());
    setMaxCount(paramThingRuleListResult.getMaxCount());
    setRuleList(paramThingRuleListResult.getRuleList());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\LightEffectRuleResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */