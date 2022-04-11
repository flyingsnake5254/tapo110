package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params;

import com.google.gson.q.c;

public class QuickSetupInfoParams
{
  private LoginAccountParams account;
  @c("extra_info")
  private QuickSetupExtraInfoParams extraInfo;
  private DeviceTimeParams time;
  private WirelessInfoParams wireless;
  
  public LoginAccountParams getAccount()
  {
    return this.account;
  }
  
  public QuickSetupExtraInfoParams getExtraInfo()
  {
    return this.extraInfo;
  }
  
  public DeviceTimeParams getTime()
  {
    return this.time;
  }
  
  public WirelessInfoParams getWireless()
  {
    return this.wireless;
  }
  
  public void setAccount(LoginAccountParams paramLoginAccountParams)
  {
    this.account = paramLoginAccountParams;
  }
  
  public void setExtraInfo(QuickSetupExtraInfoParams paramQuickSetupExtraInfoParams)
  {
    this.extraInfo = paramQuickSetupExtraInfoParams;
  }
  
  public void setTime(DeviceTimeParams paramDeviceTimeParams)
  {
    this.time = paramDeviceTimeParams;
  }
  
  public void setWireless(WirelessInfoParams paramWirelessInfoParams)
  {
    this.wireless = paramWirelessInfoParams;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\params\QuickSetupInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */