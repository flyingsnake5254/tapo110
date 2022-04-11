package com.tplink.iot.cloud.bean.thing.result;

import com.google.gson.q.c;

public class ThingRuleUpdateResult
{
  @c("conflict_id")
  private String conflictId;
  @c("end_min")
  private int endMin;
  private String id;
  @c(alternate={"s_min"}, value="start_min")
  private int startMin;
  
  public String getConflictId()
  {
    return this.conflictId;
  }
  
  public int getEndMin()
  {
    return this.endMin;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public int getStartMin()
  {
    return this.startMin;
  }
  
  public void setConflictId(String paramString)
  {
    this.conflictId = paramString;
  }
  
  public void setEndMin(int paramInt)
  {
    this.endMin = paramInt;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setStartMin(int paramInt)
  {
    this.startMin = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\result\ThingRuleUpdateResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */