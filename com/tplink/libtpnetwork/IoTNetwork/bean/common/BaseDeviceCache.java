package com.tplink.libtpnetwork.IoTNetwork.bean.common;

import com.google.gson.q.c;
import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;

public abstract class BaseDeviceCache
{
  @c("cloud")
  protected DeviceInfoResult cloudIoTDevice;
  protected ThingDevice thingDevice;
  
  public DeviceInfoResult getCloudIoTDevice()
  {
    return this.cloudIoTDevice;
  }
  
  public ThingDevice getThingDevice()
  {
    return this.thingDevice;
  }
  
  public void setCloudIoTDevice(DeviceInfoResult paramDeviceInfoResult)
  {
    this.cloudIoTDevice = paramDeviceInfoResult;
  }
  
  public void setThingDevice(ThingDevice paramThingDevice)
  {
    this.thingDevice = paramThingDevice;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\BaseDeviceCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */