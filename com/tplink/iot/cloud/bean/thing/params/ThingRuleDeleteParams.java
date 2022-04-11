package com.tplink.iot.cloud.bean.thing.params;

import com.tplink.iot.cloud.enumerate.ThingRuleType;
import java.util.List;

public class ThingRuleDeleteParams
{
  private boolean removeAll;
  private List<String> ruleIds;
  private ThingRuleType ruleType;
  
  public ThingRuleDeleteParams() {}
  
  public ThingRuleDeleteParams(boolean paramBoolean, ThingRuleType paramThingRuleType)
  {
    this.removeAll = paramBoolean;
    this.ruleType = paramThingRuleType;
  }
  
  public ThingRuleDeleteParams(boolean paramBoolean, ThingRuleType paramThingRuleType, List<String> paramList)
  {
    this.removeAll = paramBoolean;
    this.ruleType = paramThingRuleType;
    this.ruleIds = paramList;
  }
  
  public List<String> getRuleIds()
  {
    return this.ruleIds;
  }
  
  public ThingRuleType getRuleType()
  {
    return this.ruleType;
  }
  
  public boolean isRemoveAll()
  {
    return this.removeAll;
  }
  
  public void setRemoveAll(boolean paramBoolean)
  {
    this.removeAll = paramBoolean;
  }
  
  public void setRuleIds(List<String> paramList)
  {
    this.ruleIds = paramList;
  }
  
  public void setRuleType(ThingRuleType paramThingRuleType)
  {
    this.ruleType = paramThingRuleType;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\params\ThingRuleDeleteParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */