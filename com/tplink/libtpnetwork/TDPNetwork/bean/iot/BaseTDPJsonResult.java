package com.tplink.libtpnetwork.TDPNetwork.bean.iot;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.tdp.bean.BaseTDPDevice;

public abstract class BaseTDPJsonResult
  extends BaseTDPDevice
{
  @c("device_model")
  private String deviceModel;
  @c("device_type")
  private String deviceType;
  @c("factory_default")
  private boolean factoryDefault;
  
  public String getDeviceModel()
  {
    return this.deviceModel;
  }
  
  public String getDeviceType()
  {
    return this.deviceType;
  }
  
  public boolean isFactoryDefault()
  {
    return this.factoryDefault;
  }
  
  public void setDeviceModel(String paramString)
  {
    this.deviceModel = paramString;
  }
  
  public void setDeviceType(String paramString)
  {
    this.deviceType = paramString;
  }
  
  public void setFactoryDefault(boolean paramBoolean)
  {
    this.factoryDefault = paramBoolean;
  }
  
  public String toString()
  {
    return i.f(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TDPNetwork\bean\iot\BaseTDPJsonResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */