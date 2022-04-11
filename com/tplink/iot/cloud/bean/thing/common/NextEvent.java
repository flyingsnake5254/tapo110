package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.common.MapJsonAdapter;
import java.util.Map;

public class NextEvent
{
  @Deprecated
  private int action;
  @b(MapJsonAdapter.class)
  @c("desired_states")
  private Map<String, Object> desiredStates;
  @c("e_time")
  private int endTime;
  private String id;
  @c("s_time")
  private int startTime;
  private int type;
  
  public int getAction()
  {
    return this.action;
  }
  
  public Map<String, Object> getDesiredStates()
  {
    return this.desiredStates;
  }
  
  public int getEndTime()
  {
    return this.endTime;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public int getStartTime()
  {
    return this.startTime;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setAction(int paramInt)
  {
    this.action = paramInt;
  }
  
  public void setDesiredStates(Map<String, Object> paramMap)
  {
    this.desiredStates = paramMap;
  }
  
  public void setEndTime(int paramInt)
  {
    this.endTime = paramInt;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setStartTime(int paramInt)
  {
    this.startTime = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\NextEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */