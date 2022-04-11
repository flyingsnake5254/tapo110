package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.Base64TypeAdapter;

public class ThingDetail
{
  private String category;
  private String deviceType;
  private String fwId;
  private String fwVer;
  private String hwId;
  private String hwVer;
  private String ip;
  private String mac;
  private String model;
  private String oemId;
  private int onboardingTime;
  private String originalThingName;
  private int position;
  private int role;
  private int slotNumber;
  @b(Base64TypeAdapter.class)
  private String ssid;
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getDeviceType()
  {
    return this.deviceType;
  }
  
  public String getFwId()
  {
    return this.fwId;
  }
  
  public String getFwVer()
  {
    return this.fwVer;
  }
  
  public String getHwId()
  {
    return this.hwId;
  }
  
  public String getHwVer()
  {
    return this.hwVer;
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public String getModel()
  {
    return this.model;
  }
  
  public String getOemId()
  {
    return this.oemId;
  }
  
  public int getOnboardingTime()
  {
    return this.onboardingTime;
  }
  
  public String getOriginalThingName()
  {
    return this.originalThingName;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public int getRole()
  {
    return this.role;
  }
  
  public int getSlotNumber()
  {
    return this.slotNumber;
  }
  
  public String getSsid()
  {
    return this.ssid;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setDeviceType(String paramString)
  {
    this.deviceType = paramString;
  }
  
  public void setFwId(String paramString)
  {
    this.fwId = paramString;
  }
  
  public void setFwVer(String paramString)
  {
    this.fwVer = paramString;
  }
  
  public void setHwId(String paramString)
  {
    this.hwId = paramString;
  }
  
  public void setHwVer(String paramString)
  {
    this.hwVer = paramString;
  }
  
  public void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setModel(String paramString)
  {
    this.model = paramString;
  }
  
  public void setOemId(String paramString)
  {
    this.oemId = paramString;
  }
  
  public void setOnboardingTime(int paramInt)
  {
    this.onboardingTime = paramInt;
  }
  
  public void setOriginalThingName(String paramString)
  {
    this.originalThingName = paramString;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void setRole(int paramInt)
  {
    this.role = paramInt;
  }
  
  public void setSlotNumber(int paramInt)
  {
    this.slotNumber = paramInt;
  }
  
  public void setSsid(String paramString)
  {
    this.ssid = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */