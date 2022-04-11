package com.tplink.iot.adapter.home;

import java.io.Serializable;

public class HomeFamilySelectBean
  implements Serializable
{
  private String familyId;
  private String familyName;
  private boolean isSelected;
  
  public HomeFamilySelectBean() {}
  
  public HomeFamilySelectBean(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.familyId = paramString1;
    this.familyName = paramString2;
    this.isSelected = paramBoolean;
  }
  
  public String getFamilyId()
  {
    return this.familyId;
  }
  
  public String getFamilyName()
  {
    return this.familyName;
  }
  
  public boolean isSelected()
  {
    return this.isSelected;
  }
  
  public void setFamilyId(String paramString)
  {
    this.familyId = paramString;
  }
  
  public void setFamilyName(String paramString)
  {
    this.familyName = paramString;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.isSelected = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\HomeFamilySelectBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */