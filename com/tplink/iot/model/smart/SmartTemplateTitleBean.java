package com.tplink.iot.model.smart;

public class SmartTemplateTitleBean
  extends SmartTemplateBaseBean
{
  String title;
  
  public SmartTemplateTitleBean(String paramString)
  {
    setType(0);
    setTitle(paramString);
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\smart\SmartTemplateTitleBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */