package com.tplink.libtpappcommonmedia.bean;

public class TPMediaDeviceContext
{
  protected b.d.d.b.c cloudAccountContext;
  protected TPMediaDevice device;
  protected String deviceIdMd5;
  
  public TPMediaDeviceContext() {}
  
  public TPMediaDeviceContext(TPMediaDevice paramTPMediaDevice, b.d.d.b.c paramc)
  {
    if (paramTPMediaDevice != null) {
      this.deviceIdMd5 = paramTPMediaDevice.getDeviceIdMd5();
    }
    this.device = paramTPMediaDevice;
    this.cloudAccountContext = paramc;
  }
  
  public TPMediaDeviceContext(String paramString, b.d.d.b.c paramc)
  {
    this.deviceIdMd5 = paramString;
    this.cloudAccountContext = paramc;
  }
  
  public b.d.d.b.c getAccountContext()
  {
    return this.cloudAccountContext;
  }
  
  public TPMediaDevice getDevice()
  {
    return this.device;
  }
  
  public String getDeviceIdMd5()
  {
    Object localObject = this.device;
    if (localObject != null) {
      localObject = b.d.p.c.b(((TPMediaDevice)localObject).getDeviceId());
    } else {
      localObject = this.deviceIdMd5;
    }
    return (String)localObject;
  }
  
  public String getModel()
  {
    Object localObject = this.device;
    if (localObject != null) {
      localObject = ((TPMediaDevice)localObject).getModel();
    } else {
      localObject = "";
    }
    return (String)localObject;
  }
  
  public void setCloudAccountContext(b.d.d.b.c paramc)
  {
    this.cloudAccountContext = paramc;
  }
  
  public void setDevice(TPMediaDevice paramTPMediaDevice)
  {
    this.device = paramTPMediaDevice;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpappcommonmedia\bean\TPMediaDeviceContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */