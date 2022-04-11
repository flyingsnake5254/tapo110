package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ComponentBean;
import java.util.List;

public class ChildComponentBean
{
  @c("component_list")
  private List<ComponentBean> componentList;
  @c("device_id")
  private String deviceId;
  
  public List<ComponentBean> getComponentList()
  {
    return this.componentList;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public void setComponentList(List<ComponentBean> paramList)
  {
    this.componentList = paramList;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\result\ChildComponentBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */