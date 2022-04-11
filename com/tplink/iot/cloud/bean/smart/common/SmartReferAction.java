package com.tplink.iot.cloud.bean.smart.common;

import java.util.Objects;

public class SmartReferAction
{
  private int action;
  private String avatarUrl;
  private int delaySeconds;
  private String id;
  private String name;
  
  public SmartReferAction() {}
  
  public SmartReferAction(String paramString, int paramInt1, int paramInt2)
  {
    this.id = paramString;
    this.action = paramInt1;
    this.delaySeconds = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartReferAction)paramObject;
      if ((this.action != ((SmartReferAction)paramObject).action) || (this.delaySeconds != ((SmartReferAction)paramObject).delaySeconds) || (!Objects.equals(this.id, ((SmartReferAction)paramObject).id)) || (!Objects.equals(this.name, ((SmartReferAction)paramObject).name)) || (!Objects.equals(this.avatarUrl, ((SmartReferAction)paramObject).avatarUrl))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int getAction()
  {
    return this.action;
  }
  
  public String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  public int getDelaySeconds()
  {
    return this.delaySeconds;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.id, this.name, this.avatarUrl, Integer.valueOf(this.action), Integer.valueOf(this.delaySeconds) });
  }
  
  public void setAction(int paramInt)
  {
    this.action = paramInt;
  }
  
  public void setAvatarUrl(String paramString)
  {
    this.avatarUrl = paramString;
  }
  
  public void setDelaySeconds(int paramInt)
  {
    this.delaySeconds = paramInt;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartReferAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */