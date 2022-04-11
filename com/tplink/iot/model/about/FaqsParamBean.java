package com.tplink.iot.model.about;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

public class FaqsParamBean
{
  @c("appVersion")
  private String appVersion;
  @c("area")
  private String area;
  @c("country")
  private String country;
  @c("deviceInfo")
  private List<DeviceInfo> deviceInfoList = new ArrayList();
  @c("id")
  private String id;
  @c("mobileOsVersion")
  private String mobileOsVersion;
  @c("mobileType")
  private String mobileType;
  @c("modeltype")
  private String modeltype;
  @c("name")
  private String name;
  @c("timeStamp")
  private String timeStamp;
  @c("totalProductType")
  private String totalProductType;
  
  public String getAppVersion()
  {
    return this.appVersion;
  }
  
  public String getArea()
  {
    return this.area;
  }
  
  public String getCountry()
  {
    return this.country;
  }
  
  public List<DeviceInfo> getDeviceInfoList()
  {
    return this.deviceInfoList;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getMobileOsVersion()
  {
    return this.mobileOsVersion;
  }
  
  public String getMobileType()
  {
    return this.mobileType;
  }
  
  public String getModeltype()
  {
    return this.modeltype;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public String getTotalProductType()
  {
    return this.totalProductType;
  }
  
  public void setAppVersion(String paramString)
  {
    this.appVersion = paramString;
  }
  
  public void setArea(String paramString)
  {
    this.area = paramString;
  }
  
  public void setCountry(String paramString)
  {
    this.country = paramString;
  }
  
  public void setDeviceInfoList(List<DeviceInfo> paramList)
  {
    this.deviceInfoList = paramList;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setMobileOsVersion(String paramString)
  {
    this.mobileOsVersion = paramString;
  }
  
  public void setMobileType(String paramString)
  {
    this.mobileType = paramString;
  }
  
  public void setModeltype(String paramString)
  {
    this.modeltype = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setTimeStamp(String paramString)
  {
    this.timeStamp = paramString;
  }
  
  public void setTotalProductType(String paramString)
  {
    this.totalProductType = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\about\FaqsParamBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */