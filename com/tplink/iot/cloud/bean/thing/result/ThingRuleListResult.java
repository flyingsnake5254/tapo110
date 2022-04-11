package com.tplink.iot.cloud.bean.thing.result;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

public class ThingRuleListResult<T>
{
  @c(alternate={"current_rule_id"}, value="currentRuleId")
  private String currentRuleId;
  private boolean enable = true;
  @c(alternate={"antitheft_rule_max_count", "countdown_rule_max_count", "schedule_rule_max_count", "max_count"}, value="maxCount")
  private int maxCount;
  @c(alternate={"rule_list"}, value="ruleList")
  private List<T> ruleList = new ArrayList();
  @c(alternate={"start_index"}, value="startIndex")
  private int startIndex;
  private int sum;
  
  public String getCurrentRuleId()
  {
    return this.currentRuleId;
  }
  
  public int getMaxCount()
  {
    return this.maxCount;
  }
  
  public List<T> getRuleList()
  {
    return this.ruleList;
  }
  
  public int getStartIndex()
  {
    return this.startIndex;
  }
  
  public int getSum()
  {
    return this.sum;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setCurrentRuleId(String paramString)
  {
    this.currentRuleId = paramString;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setMaxCount(int paramInt)
  {
    this.maxCount = paramInt;
  }
  
  public void setRuleList(List<T> paramList)
  {
    this.ruleList = paramList;
  }
  
  public void setStartIndex(int paramInt)
  {
    this.startIndex = paramInt;
  }
  
  public void setSum(int paramInt)
  {
    this.sum = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\result\ThingRuleListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */