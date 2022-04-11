package com.tplink.libtpnetwork.IoTNetwork.bean.hub.params;

import com.google.gson.q.c;
import java.util.List;

public class DeviceIdListParams
{
  @c("child_device_list")
  private List<DeviceIdBean> childDeviceList;
  
  public DeviceIdListParams() {}
  
  public DeviceIdListParams(List<DeviceIdBean> paramList)
  {
    this.childDeviceList = paramList;
  }
  
  public List<DeviceIdBean> getChildDeviceList()
  {
    return this.childDeviceList;
  }
  
  public void setChildDeviceList(List<DeviceIdBean> paramList)
  {
    this.childDeviceList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\params\DeviceIdListParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */