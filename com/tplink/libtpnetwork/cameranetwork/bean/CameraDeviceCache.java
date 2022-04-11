package com.tplink.libtpnetwork.cameranetwork.bean;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.BaseDeviceCache;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;

public class CameraDeviceCache
  extends BaseDeviceCache
{
  @c("local")
  private CameraBasicInfo cameraBasicInfo;
  
  public CameraDeviceCache() {}
  
  public CameraDeviceCache(ALCameraDevice paramALCameraDevice)
  {
    TCDeviceBean localTCDeviceBean = paramALCameraDevice.getCloudCameraDevice();
    if (localTCDeviceBean != null) {
      this.cloudIoTDevice = localTCDeviceBean.getDeviceInfo();
    }
    this.cameraBasicInfo = paramALCameraDevice.getCameraBasicInfo();
  }
  
  public CameraBasicInfo getCameraBasicInfo()
  {
    return this.cameraBasicInfo;
  }
  
  public void setCameraBasicInfo(CameraBasicInfo paramCameraBasicInfo)
  {
    this.cameraBasicInfo = paramCameraBasicInfo;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\CameraDeviceCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */