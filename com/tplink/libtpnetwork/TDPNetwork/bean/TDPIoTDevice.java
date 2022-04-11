package com.tplink.libtpnetwork.TDPNetwork.bean;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.TDPNetwork.bean.iot.BaseTDPJsonResult;
import com.tplink.libtpnetwork.TDPNetwork.bean.iot.CommonTDPResult;
import com.tplink.libtpnetwork.TDPNetwork.bean.iot.TDPIoTResult;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.tdp.bean.BaseTDPDevice;
import java.io.Serializable;

public class TDPIoTDevice
  extends BaseTDPDevice
  implements Serializable
{
  @c("device_id_md5")
  protected String deviceIdMd5;
  @c("device_model")
  protected String deviceModel;
  @c("device_type")
  protected String deviceType;
  @c("factory_default")
  private boolean factoryDefault;
  @c("http_port")
  protected int httpPort;
  @c("is_support_https")
  private boolean isSupportHttps;
  @c("is_support_iot_cloud")
  private boolean isSupportIoTCloud;
  @c("obd_src")
  private String obdSrc;
  @c("owner")
  protected String owner;
  
  public TDPIoTDevice() {}
  
  public TDPIoTDevice(CommonTDPResult paramCommonTDPResult)
  {
    this.ip = paramCommonTDPResult.getIp();
    this.mac = paramCommonTDPResult.getMac();
    this.deviceIdMd5 = paramCommonTDPResult.getDeviceIdMd5();
    this.deviceType = paramCommonTDPResult.getDeviceType();
    this.deviceModel = paramCommonTDPResult.getDeviceModel();
    this.owner = paramCommonTDPResult.getOwner();
    this.factoryDefault = paramCommonTDPResult.isFactoryDefault();
    this.isSupportHttps = paramCommonTDPResult.isSupportHttps();
    this.httpPort = paramCommonTDPResult.getHttpPort();
    this.isSupportIoTCloud = paramCommonTDPResult.isSupportIoTCloud();
    this.obdSrc = paramCommonTDPResult.getObdSrc();
  }
  
  public TDPIoTDevice(TDPIoTResult paramTDPIoTResult)
  {
    this.ip = paramTDPIoTResult.getIp();
    this.mac = paramTDPIoTResult.getMac();
    this.deviceIdMd5 = paramTDPIoTResult.getDeviceIdMd5();
    this.deviceType = paramTDPIoTResult.getDeviceType();
    this.deviceModel = paramTDPIoTResult.getDeviceModel();
    this.owner = paramTDPIoTResult.getOwner();
    this.factoryDefault = paramTDPIoTResult.isFactoryDefault();
    this.isSupportHttps = paramTDPIoTResult.isSupportHttps();
    this.httpPort = paramTDPIoTResult.getHttpPort();
    this.isSupportIoTCloud = paramTDPIoTResult.isSupportIoTCloud();
    this.obdSrc = paramTDPIoTResult.getObdSrc();
  }
  
  public String getDeviceIdMd5()
  {
    return this.deviceIdMd5;
  }
  
  public String getDeviceModel()
  {
    return this.deviceModel;
  }
  
  public String getDeviceType()
  {
    return this.deviceType;
  }
  
  public int getHttpPort()
  {
    return this.httpPort;
  }
  
  public String getObdSrc()
  {
    return this.obdSrc;
  }
  
  public String getOwner()
  {
    return this.owner;
  }
  
  public boolean isFactoryDefault()
  {
    return this.factoryDefault;
  }
  
  public boolean isSupportHttps()
  {
    return this.isSupportHttps;
  }
  
  public boolean isSupportIoTCloud()
  {
    return this.isSupportIoTCloud;
  }
  
  public void setDeviceIdMd5(String paramString)
  {
    this.deviceIdMd5 = paramString;
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
  
  public void setHttpPort(int paramInt)
  {
    this.httpPort = paramInt;
  }
  
  public void setObdSrc(String paramString)
  {
    this.obdSrc = paramString;
  }
  
  public void setOwner(String paramString)
  {
    this.owner = paramString;
  }
  
  public void setSupportHttps(boolean paramBoolean)
  {
    this.isSupportHttps = paramBoolean;
  }
  
  public void setSupportIoTCloud(boolean paramBoolean)
  {
    this.isSupportIoTCloud = paramBoolean;
  }
  
  public String toString()
  {
    return i.h(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TDPNetwork\bean\TDPIoTDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */