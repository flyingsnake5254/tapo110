package com.tplink.iot.cloud.bean.family.params;

import java.util.List;

public class FamilyCommonOrderParams
{
  private List<String> commonOrders;
  
  public FamilyCommonOrderParams(List<String> paramList)
  {
    this.commonOrders = paramList;
  }
  
  public List<String> getCommonOrders()
  {
    return this.commonOrders;
  }
  
  public void setCommonOrders(List<String> paramList)
  {
    this.commonOrders = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\family\params\FamilyCommonOrderParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */