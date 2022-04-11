package com.tplink.iot.cloud.bean.family.result;

import java.util.List;

public class FamilyCommonOrderResult
{
  private List<String> commonOrders;
  private Long recordTimestamp;
  
  public List<String> getCommonOrders()
  {
    return this.commonOrders;
  }
  
  public Long getRecordTimestamp()
  {
    return this.recordTimestamp;
  }
  
  public void setCommonOrders(List<String> paramList)
  {
    this.commonOrders = paramList;
  }
  
  public void setRecordTimestamp(Long paramLong)
  {
    this.recordTimestamp = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\family\result\FamilyCommonOrderResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */