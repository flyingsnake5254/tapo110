package com.tplink.libtpnetwork.IoTNetwork.bean.common.params;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleRemoveParams
{
  @c("remove_all")
  private boolean removeAll;
  @c("rule_list")
  private List<RuleIdParams> ruleList;
  
  public RuleRemoveParams() {}
  
  public RuleRemoveParams(boolean paramBoolean, List<String> paramList)
  {
    this.removeAll = paramBoolean;
    if (paramList != null)
    {
      this.ruleList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (String)localIterator.next();
        this.ruleList.add(new RuleIdParams(paramList));
      }
    }
  }
  
  public List<RuleIdParams> getRuleList()
  {
    return this.ruleList;
  }
  
  public boolean isRemoveAll()
  {
    return this.removeAll;
  }
  
  public void setRemoveAll(boolean paramBoolean)
  {
    this.removeAll = paramBoolean;
  }
  
  public void setRuleList(List<RuleIdParams> paramList)
  {
    this.ruleList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\params\RuleRemoveParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */