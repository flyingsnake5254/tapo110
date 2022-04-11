package com.tplink.libtpanalytics.bean;

import com.google.gson.q.c;

public class EncryptedContent
{
  @c("api")
  private String appId;
  @c("apv")
  private String appVersion;
  private String cpu;
  private String dpi;
  private Boolean isro;
  @c("mbn")
  private String mobileBrand;
  @c("mmn")
  private String mobileModel;
  @c("nt")
  private String networkType;
  private String ram;
  @c("rg")
  private String region;
  @c("reso")
  private String resolution;
  private String rom;
  @c("sv")
  private String systemVersion;
  
  public EncryptedContent() {}
  
  public EncryptedContent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.appId = paramString1;
    this.appVersion = paramString2;
    this.region = paramString3;
    this.networkType = paramString4;
    this.mobileBrand = paramString5;
    this.mobileModel = paramString6;
    this.systemVersion = paramString7;
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getAppVersion()
  {
    return this.appVersion;
  }
  
  public String getCpu()
  {
    return this.cpu;
  }
  
  public String getDpi()
  {
    return this.dpi;
  }
  
  public Boolean getIsro()
  {
    return this.isro;
  }
  
  public String getMobileBrand()
  {
    return this.mobileBrand;
  }
  
  public String getMobileModel()
  {
    return this.mobileModel;
  }
  
  public String getNetworkType()
  {
    return this.networkType;
  }
  
  public String getRam()
  {
    return this.ram;
  }
  
  public String getRegion()
  {
    return this.region;
  }
  
  public String getResolution()
  {
    return this.resolution;
  }
  
  public String getRom()
  {
    return this.rom;
  }
  
  public String getSystemVersion()
  {
    return this.systemVersion;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setAppVersion(String paramString)
  {
    this.appVersion = paramString;
  }
  
  public void setCpu(String paramString)
  {
    this.cpu = paramString;
  }
  
  public void setDpi(String paramString)
  {
    this.dpi = paramString;
  }
  
  public void setIsro(Boolean paramBoolean)
  {
    this.isro = paramBoolean;
  }
  
  public void setMobileBrand(String paramString)
  {
    this.mobileBrand = paramString;
  }
  
  public void setMobileModel(String paramString)
  {
    this.mobileModel = paramString;
  }
  
  public void setNetworkType(String paramString)
  {
    this.networkType = paramString;
  }
  
  public void setRam(String paramString)
  {
    this.ram = paramString;
  }
  
  public void setRegion(String paramString)
  {
    this.region = paramString;
  }
  
  public void setResolution(String paramString)
  {
    this.resolution = paramString;
  }
  
  public void setRom(String paramString)
  {
    this.rom = paramString;
  }
  
  public void setSystemVersion(String paramString)
  {
    this.systemVersion = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\bean\EncryptedContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */