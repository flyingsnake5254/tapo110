package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.common.MapJsonAdapter;
import java.util.Map;

public class ThingRuleTimer
{
  @Deprecated
  private String action;
  private int delay;
  @b(MapJsonAdapter.class)
  @c("desired_states")
  private Map<String, Object> desiredStates;
  private boolean enable;
  private String id;
  private int remain;
  
  public ThingRuleTimer() {}
  
  public ThingRuleTimer(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    this.enable = paramBoolean;
    this.delay = paramInt1;
    this.remain = paramInt2;
    this.action = paramString;
  }
  
  public ThingRuleTimer(boolean paramBoolean, int paramInt1, int paramInt2, Map<String, Object> paramMap)
  {
    this.enable = paramBoolean;
    this.delay = paramInt1;
    this.remain = paramInt2;
    this.desiredStates = paramMap;
  }
  
  public ThingRuleTimer(boolean paramBoolean, int paramInt, Map<String, Object> paramMap)
  {
    this.enable = paramBoolean;
    this.delay = paramInt;
    this.desiredStates = paramMap;
  }
  
  public String getAction()
  {
    return this.action;
  }
  
  public int getDelay()
  {
    return this.delay;
  }
  
  public Map<String, Object> getDesiredStates()
  {
    return this.desiredStates;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public int getRemain()
  {
    return this.remain;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public void setDelay(int paramInt)
  {
    this.delay = paramInt;
  }
  
  public void setDesiredStates(Map<String, Object> paramMap)
  {
    this.desiredStates = paramMap;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setRemain(int paramInt)
  {
    this.remain = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingRuleTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */