package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result;

import com.google.gson.q.c;
import java.io.Serializable;

public class QuickSetupComponentExtraInfoBean
  implements Serializable
{
  @c("device_model")
  private String deviceModel;
  @c("device_type")
  private String deviceType;
  
  public String getDeviceModel()
  {
    return this.deviceModel;
  }
  
  public String getDeviceType()
  {
    return this.deviceType;
  }
  
  public void setDeviceModel(String paramString)
  {
    this.deviceModel = paramString;
  }
  
  public void setDeviceType(String paramString)
  {
    this.deviceType = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\result\QuickSetupComponentExtraInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */