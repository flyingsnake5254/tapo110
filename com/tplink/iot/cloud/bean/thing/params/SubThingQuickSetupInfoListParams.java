package com.tplink.iot.cloud.bean.thing.params;

import java.util.List;

public class SubThingQuickSetupInfoListParams
{
  private List<SubThingQuickSetupInfoParams> dataList;
  
  public SubThingQuickSetupInfoListParams() {}
  
  public SubThingQuickSetupInfoListParams(List<SubThingQuickSetupInfoParams> paramList)
  {
    this.dataList = paramList;
  }
  
  public List<SubThingQuickSetupInfoParams> getDataList()
  {
    return this.dataList;
  }
  
  public void setDataList(List<SubThingQuickSetupInfoParams> paramList)
  {
    this.dataList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\params\SubThingQuickSetupInfoListParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */