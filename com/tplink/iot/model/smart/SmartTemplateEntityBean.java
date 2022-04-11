package com.tplink.iot.model.smart;

import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;

public class SmartTemplateEntityBean
  extends SmartTemplateBaseBean
{
  private SmartTemplate mEntity;
  
  public SmartTemplateEntityBean(SmartTemplate paramSmartTemplate)
  {
    setType(1);
    setEntity(paramSmartTemplate);
  }
  
  public SmartTemplate getEntity()
  {
    return this.mEntity;
  }
  
  public void setEntity(SmartTemplate paramSmartTemplate)
  {
    this.mEntity = paramSmartTemplate;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\smart\SmartTemplateEntityBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */