package com.tplink.iot.cloud.bean.smart.common;

import java.util.List;

public class SmartTemplate
{
  private SmartAction actionSetting;
  private String avatarUrl;
  private List<SmartTemplateMarketing> marketingUrls;
  private String name;
  private String subTitle;
  private String title;
  private String titleDetailImgUrl;
  private String titleImgUrl;
  private SmartTrigger triggerSetting;
  
  public SmartAction getActionSetting()
  {
    return this.actionSetting;
  }
  
  public String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  public List<SmartTemplateMarketing> getMarketingUrls()
  {
    return this.marketingUrls;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getSubTitle()
  {
    return this.subTitle;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getTitleDetailImgUrl()
  {
    return this.titleDetailImgUrl;
  }
  
  public String getTitleImgUrl()
  {
    return this.titleImgUrl;
  }
  
  public SmartTrigger getTriggerSetting()
  {
    return this.triggerSetting;
  }
  
  public void setActionSetting(SmartAction paramSmartAction)
  {
    this.actionSetting = paramSmartAction;
  }
  
  public void setAvatarUrl(String paramString)
  {
    this.avatarUrl = paramString;
  }
  
  public void setMarketingUrls(List<SmartTemplateMarketing> paramList)
  {
    this.marketingUrls = paramList;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSubTitle(String paramString)
  {
    this.subTitle = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setTitleDetailImgUrl(String paramString)
  {
    this.titleDetailImgUrl = paramString;
  }
  
  public void setTitleImgUrl(String paramString)
  {
    this.titleImgUrl = paramString;
  }
  
  public void setTriggerSetting(SmartTrigger paramSmartTrigger)
  {
    this.triggerSetting = paramSmartTrigger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\smart\common\SmartTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */