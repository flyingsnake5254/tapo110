package com.tplink.iot.adapter.quicksetup;

import java.io.Serializable;

public class DeviceCategoryBean
  implements Serializable
{
  private String categoryName;
  private String device;
  private boolean isCategory;
  private boolean isEnable = true;
  
  public DeviceCategoryBean(String paramString)
  {
    this.device = paramString;
  }
  
  public DeviceCategoryBean(String paramString, boolean paramBoolean)
  {
    this.device = paramString;
    this.isEnable = paramBoolean;
  }
  
  public DeviceCategoryBean(boolean paramBoolean, String paramString)
  {
    this.isCategory = paramBoolean;
    this.categoryName = paramString;
  }
  
  public String getCategoryName()
  {
    return this.categoryName;
  }
  
  public String getDevice()
  {
    return this.device;
  }
  
  public boolean isCategory()
  {
    return this.isCategory;
  }
  
  public boolean isEnable()
  {
    return this.isEnable;
  }
  
  public void setCategory(boolean paramBoolean)
  {
    this.isCategory = paramBoolean;
  }
  
  public void setCategoryName(String paramString)
  {
    this.categoryName = paramString;
  }
  
  public void setDevice(String paramString)
  {
    this.device = paramString;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.isEnable = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\quicksetup\DeviceCategoryBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */