package com.tplink.cloud.bean.firmware.params;

public class FirmwareInfoParams
{
  private String devFwCurrentVer;
  private String deviceId;
  private String fwId;
  private String hwId;
  private String locale;
  private String oemId;
  
  public String getDevFwCurrentVer()
  {
    return this.devFwCurrentVer;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getFwId()
  {
    return this.fwId;
  }
  
  public String getHwId()
  {
    return this.hwId;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public String getOemId()
  {
    return this.oemId;
  }
  
  public void setDevFwCurrentVer(String paramString)
  {
    this.devFwCurrentVer = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setFwId(String paramString)
  {
    this.fwId = paramString;
  }
  
  public void setHwId(String paramString)
  {
    this.hwId = paramString;
  }
  
  public void setLocale(String paramString)
  {
    this.locale = paramString;
  }
  
  public void setOemId(String paramString)
  {
    this.oemId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\firmware\params\FirmwareInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */