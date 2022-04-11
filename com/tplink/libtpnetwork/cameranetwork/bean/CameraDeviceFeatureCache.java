package com.tplink.libtpnetwork.cameranetwork.bean;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentBean;
import java.util.List;

public class CameraDeviceFeatureCache
{
  @c("component_list")
  private List<ComponentBean> componentList;
  @c("firmware_version")
  private String firmwareVersion;
  
  public CameraDeviceFeatureCache() {}
  
  public CameraDeviceFeatureCache(String paramString, List<ComponentBean> paramList)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\CameraDeviceFeatureCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */