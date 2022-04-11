package com.tplink.iot.model.about;

public class DeviceInfo
{
  private String firmwareVersion;
  private String hardwareVersion;
  private String mac;
  private String productModel;
  private String productType;
  
  public String getFirmwareVersion()
  {
    return this.firmwareVersion;
  }
  
  public String getHardwareVersion()
  {
    return this.hardwareVersion;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public String getProductModel()
  {
    return this.productModel;
  }
  
  public String getProductType()
  {
    return this.productType;
  }
  
  public void setFirmwareVersion(String paramString)
  {
    this.firmwareVersion = paramString;
  }
  
  public void setHardwareVersion(String paramString)
  {
    this.hardwareVersion = paramString;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setProductModel(String paramString)
  {
    this.productModel = paramString;
  }
  
  public void setProductType(String paramString)
  {
    this.productType = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\about\DeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */