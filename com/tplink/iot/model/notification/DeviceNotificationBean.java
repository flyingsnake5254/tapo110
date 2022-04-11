package com.tplink.iot.model.notification;

import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

public class DeviceNotificationBean
{
  boolean isSubscribe;
  BaseALIoTDevice mAlIoTDevice;
  
  public DeviceNotificationBean(BaseALIoTDevice paramBaseALIoTDevice, boolean paramBoolean)
  {
    this.mAlIoTDevice = paramBaseALIoTDevice;
    this.isSubscribe = paramBoolean;
  }
  
  public BaseALIoTDevice getAlIoTDevice()
  {
    return this.mAlIoTDevice;
  }
  
  public boolean isSubscribe()
  {
    return this.isSubscribe;
  }
  
  public void setAlIoTDevice(BaseALIoTDevice paramBaseALIoTDevice)
  {
    this.mAlIoTDevice = paramBaseALIoTDevice;
  }
  
  public void setSubscribe(boolean paramBoolean)
  {
    this.isSubscribe = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\notification\DeviceNotificationBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */