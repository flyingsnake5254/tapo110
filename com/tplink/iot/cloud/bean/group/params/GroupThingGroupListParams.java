package com.tplink.iot.cloud.bean.group.params;

import java.util.List;

public class GroupThingGroupListParams
{
  private List<String> groupIds;
  private List<String> thingNames;
  
  public GroupThingGroupListParams() {}
  
  public GroupThingGroupListParams(List<String> paramList1, List<String> paramList2)
  {
    this.thingNames = paramList1;
    this.groupIds = paramList2;
  }
  
  public List<String> getGroupIds()
  {
    return this.groupIds;
  }
  
  public List<String> getThingNames()
  {
    return this.thingNames;
  }
  
  public void setGroupIds(List<String> paramList)
  {
    this.groupIds = paramList;
  }
  
  public void setThingNames(List<String> paramList)
  {
    this.thingNames = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\group\params\GroupThingGroupListParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */