package com.tplink.iot.cloud.bean.thing.params;

import com.google.gson.q.c;
import java.util.List;

public class SubThingAddListParams
{
  @c("child_device_list")
  private List<SubThingAddParams> childDeviceList;
  
  public SubThingAddListParams() {}
  
  public SubThingAddListParams(List<SubThingAddParams> paramList)
  {
    this.childDeviceList = paramList;
  }
  
  public List<SubThingAddParams> getChildDeviceList()
  {
    return this.childDeviceList;
  }
  
  public void setChildDeviceList(List<SubThingAddParams> paramList)
  {
    this.childDeviceList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\params\SubThingAddListParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */