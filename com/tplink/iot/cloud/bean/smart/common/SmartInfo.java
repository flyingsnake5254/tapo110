package com.tplink.iot.cloud.bean.smart.common;

import java.util.Objects;

public class SmartInfo
{
  private SmartAction actionSetting;
  private SmartLocation appLocationInfo;
  private String avatarUrl;
  private SmartPeriodSetting effectivePeriod;
  private boolean enabled;
  private String id;
  private String name;
  private SmartTrigger triggerSetting;
  
  public SmartInfo() {}
  
  public SmartInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean, SmartLocation paramSmartLocation, SmartTrigger paramSmartTrigger, SmartAction paramSmartAction)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.avatarUrl = paramString3;
    this.enabled = paramBoolean;
    this.appLocationInfo = paramSmartLocation;
    this.triggerSetting = paramSmartTrigger;
    this.actionSetting = paramSmartAction;
  }
  
  public SmartInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean, SmartTrigger paramSmartTrigger, SmartAction paramSmartAction)
  {
    this(paramString1, paramString2, paramString3, paramBoolean, null, paramSmartTrigger, paramSmartAction);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (SmartInfo)paramObject;
      if ((this.enabled != ((SmartInfo)paramObject).enabled) || (!Objects.equals(this.id, ((SmartInfo)paramObject).id)) || (!Objects.equals(this.name, ((SmartInfo)paramObject).name)) || (!Objects.equals(this.avatarUrl, ((SmartInfo)paramObject).avatarUrl)) || (!Objects.equals(this.appLocationInfo, ((SmartInfo)paramObject).appLocationInfo)) || (!Objects.equals(this.triggerSetting, ((SmartInfo)paramObject).triggerSetting)) || (!Objects.equals(this.actionSetting, ((SmartInfo)paramObject).actionSetting)) || (!Objects.equals(this.effectivePeriod, ((SmartInfo)paramObject).effectivePeriod))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public SmartAction getActionSetting()
  {
    return this.actionSetting;
  }
  
  public SmartLocation getAppLocationInfo()
  {
    return this.appLocationInfo;
  }
  
  public String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  public SmartPeriodSetting getEffectivePeriod()
  {
    return this.effectivePeriod;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public SmartTrigger getTriggerSetting()
  {
    return this.triggerSetting;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.id, this.name, this.avatarUrl, Boolean.valueOf(this.enabled), this.appLocationInfo, this.triggerSetting, this.actionSetting, this.effectivePeriod });
  }
  
  public boolean isEnabled()
  {
    return this.enabled;
  }
  
  public void setActionSetting(SmartAction paramSmartAction)
  {
    this.actionSetting = paramSmartAction;
  }
  
  public void setAppLocationInfo(SmartLocation paramSmartLocation)
  {
    this.appLocationInfo = paramSmartLocation;
  }
  
  public void setAvatarUrl(String paramString)
  {
    this.avatarUrl = paramString;
  }
  
  public void setEffectivePeriod(SmartPeriodSetting paramSmartPeriodSetting)
  {
    this.effectivePeriod = paramSmartPeriodSetting;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setTriggerSetting(SmartTrigger paramSmartTrigger)
  {
    this.triggerSetting = paramSmartTrigger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */