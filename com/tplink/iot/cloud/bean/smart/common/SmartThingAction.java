package com.tplink.iot.cloud.bean.smart.common;

import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.Base64TypeAdapter;
import com.tplink.iot.cloud.bean.common.MapJsonAdapter;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import java.util.Map;
import java.util.Objects;

public class SmartThingAction
{
  private String avatarUrl;
  private String category;
  private int delaySeconds;
  private SmartThingFutureAction futureAction;
  private boolean isSubThing;
  @b(Base64TypeAdapter.class)
  private String nickname;
  private ThingServiceParams service;
  @b(MapJsonAdapter.class)
  private Map<String, Object> stateDesired;
  private String thingName;
  
  public SmartThingAction() {}
  
  public SmartThingAction(String paramString, SmartThingFutureAction paramSmartThingFutureAction, int paramInt)
  {
    this.thingName = paramString;
    this.futureAction = paramSmartThingFutureAction;
    this.delaySeconds = paramInt;
  }
  
  public SmartThingAction(String paramString, ThingServiceParams paramThingServiceParams, int paramInt)
  {
    this.thingName = paramString;
    this.service = paramThingServiceParams;
    this.delaySeconds = paramInt;
  }
  
  public SmartThingAction(String paramString, Map<String, Object> paramMap, int paramInt)
  {
    this.thingName = paramString;
    this.stateDesired = paramMap;
    this.delaySeconds = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartThingAction)paramObject;
      if ((this.isSubThing != ((SmartThingAction)paramObject).isSubThing) || (this.delaySeconds != ((SmartThingAction)paramObject).delaySeconds) || (!Objects.equals(this.thingName, ((SmartThingAction)paramObject).thingName)) || (!Objects.equals(this.nickname, ((SmartThingAction)paramObject).nickname)) || (!Objects.equals(this.avatarUrl, ((SmartThingAction)paramObject).avatarUrl)) || (!Objects.equals(this.stateDesired, ((SmartThingAction)paramObject).stateDesired)) || (!Objects.equals(this.service, ((SmartThingAction)paramObject).service)) || (!Objects.equals(this.futureAction, ((SmartThingAction)paramObject).futureAction))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public int getDelaySeconds()
  {
    return this.delaySeconds;
  }
  
  public SmartThingFutureAction getFutureAction()
  {
    return this.futureAction;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public ThingServiceParams getService()
  {
    return this.service;
  }
  
  public Map<String, Object> getStateDesired()
  {
    return this.stateDesired;
  }
  
  public String getThingName()
  {
    return this.thingName;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.thingName, this.nickname, this.avatarUrl, Boolean.valueOf(this.isSubThing), this.stateDesired, this.service, Integer.valueOf(this.delaySeconds), this.category, this.futureAction });
  }
  
  public boolean isSubThing()
  {
    return this.isSubThing;
  }
  
  public void setAvatarUrl(String paramString)
  {
    this.avatarUrl = paramString;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setDelaySeconds(int paramInt)
  {
    this.delaySeconds = paramInt;
  }
  
  public void setFutureAction(SmartThingFutureAction paramSmartThingFutureAction)
  {
    this.futureAction = paramSmartThingFutureAction;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
  
  public void setService(ThingServiceParams paramThingServiceParams)
  {
    this.service = paramThingServiceParams;
  }
  
  public void setStateDesired(Map<String, Object> paramMap)
  {
    this.stateDesired = paramMap;
  }
  
  public void setSubThing(boolean paramBoolean)
  {
    this.isSubThing = paramBoolean;
  }
  
  public void setThingName(String paramString)
  {
    this.thingName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartThingAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */