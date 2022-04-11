package com.tplink.iot.model.smart;

import java.io.Serializable;

public class SmartTemplateBaseBean
  implements Serializable
{
  public static final int TYPE_TEMPLATE = 1;
  public static final int TYPE_TITLE = 0;
  private int type;
  
  public int getType()
  {
    return this.type;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\smart\SmartTemplateBaseBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */