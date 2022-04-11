package com.tplink.libtpnetwork.IoTNetwork.bean.common;

import android.text.TextUtils;
import com.google.gson.q.c;
import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;

public class IoTDeviceCache
  extends BaseDeviceCache
{
  @c("local")
  private LocalIoTBaseDevice localIoTDevice;
  
  public IoTDeviceCache() {}
  
  public IoTDeviceCache(ALIoTDevice paramALIoTDevice)
  {
    if (paramALIoTDevice.getCloudIoTDevice() != null) {
      this.cloudIoTDevice = paramALIoTDevice.getCloudIoTDevice().getDeviceInfo();
    }
    if (paramALIoTDevice.getThingDevice() != null) {
      this.thingDevice = paramALIoTDevice.getThingDevice();
    }
    this.localIoTDevice = paramALIoTDevice.getLocalIoTDevice();
  }
  
  public String getDeviceType()
  {
    Object localObject = this.cloudIoTDevice;
    if ((localObject != null) && (!TextUtils.isEmpty(((DeviceInfoResult)localObject).getDeviceType()))) {
      return this.cloudIoTDevice.getDeviceType();
    }
    localObject = this.thingDevice;
    if ((localObject != null) && (!TextUtils.isEmpty(((ThingDevice)localObject).getDeviceType()))) {
      return this.thingDevice.getDeviceType();
    }
    localObject = this.localIoTDevice;
    if ((localObject != null) && (!TextUtils.isEmpty(((LocalIoTBaseDevice)localObject).getType()))) {
      return this.localIoTDevice.getType();
    }
    return "";
  }
  
  public LocalIoTBaseDevice getLocalIoTDevice()
  {
    return this.localIoTDevice;
  }
  
  public void setLocalIoTDevice(LocalIoTBaseDevice paramLocalIoTBaseDevice)
  {
    this.localIoTDevice = paramLocalIoTBaseDevice;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\IoTDeviceCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */