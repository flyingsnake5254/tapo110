package com.tplink.iot.cloud.bean.smart.common;

import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.Base64TypeAdapter;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import java.util.Objects;

public class SmartThingTrigger
{
  private String avatarUrl;
  private String category;
  private ThingEventParams event;
  private boolean isSubThing;
  @b(Base64TypeAdapter.class)
  private String nickname;
  private SmartThingStateReported stateReported;
  private String thingName;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartThingTrigger)paramObject;
      if ((this.isSubThing != ((SmartThingTrigger)paramObject).isSubThing) || (!Objects.equals(this.thingName, ((SmartThingTrigger)paramObject).thingName)) || (!Objects.equals(this.nickname, ((SmartThingTrigger)paramObject).nickname)) || (!Objects.equals(this.avatarUrl, ((SmartThingTrigger)paramObject).avatarUrl)) || (!Objects.equals(this.stateReported, ((SmartThingTrigger)paramObject).stateReported)) || (!Objects.equals(this.event, ((SmartThingTrigger)paramObject).event))) {
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
  
  public ThingEventParams getEvent()
  {
    return this.event;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public SmartThingStateReported getStateReported()
  {
    return this.stateReported;
  }
  
  public String getThingName()
  {
    return this.thingName;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.thingName, this.nickname, this.avatarUrl, Boolean.valueOf(this.isSubThing), this.stateReported, this.event, this.category });
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
  
  public void setEvent(ThingEventParams paramThingEventParams)
  {
    this.event = paramThingEventParams;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
  
  public void setStateReported(SmartThingStateReported paramSmartThingStateReported)
  {
    this.stateReported = paramSmartThingStateReported;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartThingTrigger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */