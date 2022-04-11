package com.tplink.libtpnetwork.IoTNetwork.bean.common;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ComponentBean;
import java.util.List;

public class IoTDeviceFeatureCache
{
  @c("component_list")
  private List<ComponentBean> componentList;
  @c("firmware_version")
  private String firmwareVersion;
  
  public IoTDeviceFeatureCache() {}
  
  public IoTDeviceFeatureCache(String paramString, List<ComponentBean> paramList)
  {
    this.firmwareVersion = paramString;
    this.componentList = paramList;
  }
  
  public List<ComponentBean> getComponentList()
  {
    return this.componentList;
  }
  
  public String getFirmwareVersion()
  {
    return this.firmwareVersion;
  }
  
  public void setComponentList(List<ComponentBean> paramList)
  {
    this.componentList = paramList;
  }
  
  public void setFirmwareVersion(String paramString)
  {
    this.firmwareVersion = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\IoTDeviceFeatureCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */