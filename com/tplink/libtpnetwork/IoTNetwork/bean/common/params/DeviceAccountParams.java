package com.tplink.libtpnetwork.IoTNetwork.bean.common.params;

import com.google.gson.q.c;

public class DeviceAccountParams
{
  @c("cloud_account")
  private DeviceAccountBean deviceAccount;
  
  public DeviceAccountParams() {}
  
  public DeviceAccountParams(DeviceAccountBean paramDeviceAccountBean)
  {
    this.deviceAccount = paramDeviceAccountBean;
  }
  
  public DeviceAccountBean getDeviceAccount()
  {
    return this.deviceAccount;
  }
  
  public void setDeviceAccount(DeviceAccountBean paramDeviceAccountBean)
  {
    this.deviceAccount = paramDeviceAccountBean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\params\DeviceAccountParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */