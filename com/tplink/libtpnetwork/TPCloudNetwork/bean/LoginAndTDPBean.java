package com.tplink.libtpnetwork.TPCloudNetwork.bean;

import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import java.io.Serializable;
import java.util.Map;

public class LoginAndTDPBean
  implements Serializable
{
  private Boolean loginResult;
  private Map<String, ? extends TDPIoTDevice> tDPIoTDeviceMap;
  
  public LoginAndTDPBean(Boolean paramBoolean, Map<String, ? extends TDPIoTDevice> paramMap)
  {
    this.loginResult = paramBoolean;
    this.tDPIoTDeviceMap = paramMap;
  }
  
  public Boolean getLoginResult()
  {
    return this.loginResult;
  }
  
  public Map<String, ? extends TDPIoTDevice> getTDPIoTDeviceMap()
  {
    return this.tDPIoTDeviceMap;
  }
  
  public void setLoginResult(Boolean paramBoolean)
  {
    this.loginResult = paramBoolean;
  }
  
  public void setTDPIoTDeviceMap(Map<String, TDPIoTDevice> paramMap)
  {
    this.tDPIoTDeviceMap = paramMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\bean\LoginAndTDPBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */