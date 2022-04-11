package com.tplink.iot.view.quicksetup.bulb.utils;

import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.io.Serializable;

public class QuickSetupInfoBundle
  implements Serializable
{
  private String bulbSSID;
  private QuickSetupComponentResult componentResult;
  private String deviceIdMD5;
  private String deviceModel = "";
  private boolean inNeedDisplayInherit;
  private boolean isFromQuickDiscovery = false;
  private boolean isSelectFollowInherit;
  private boolean isSetInheritAndSuccess;
  private Integer latitude;
  private Integer longitude;
  private EnumOnboardingType onBoardingType = EnumOnboardingType.BULB_SOFT_AP;
  private long onboardingStartTime = 0L;
  
  public QuickSetupInfoBundle() {}
  
  public QuickSetupInfoBundle(Integer paramInteger1, Integer paramInteger2)
  {
    this.longitude = paramInteger1;
    this.latitude = paramInteger2;
  }
  
  public QuickSetupInfoBundle(Integer paramInteger1, Integer paramInteger2, String paramString, long paramLong)
  {
    this.longitude = paramInteger1;
    this.latitude = paramInteger2;
    this.deviceModel = paramString;
    this.onboardingStartTime = paramLong;
  }
  
  public String getBulbSSID()
  {
    return this.bulbSSID;
  }
  
  public QuickSetupComponentResult getComponentResult()
  {
    return this.componentResult;
  }
  
  public String getDeviceIdMD5()
  {
    return this.deviceIdMD5;
  }
  
  public String getDeviceModel()
  {
    return this.deviceModel;
  }
  
  public String getDeviceType()
  {
    return b.l(this.deviceModel).getDeviceType();
  }
  
  public Integer getLatitude()
  {
    return this.latitude;
  }
  
  public Integer getLongitude()
  {
    return this.longitude;
  }
  
  public EnumOnboardingType getOnBoardingType()
  {
    return this.onBoardingType;
  }
  
  public long getOnboardingStartTime()
  {
    return this.onboardingStartTime;
  }
  
  public boolean inNeedDisplayInherit()
  {
    return this.inNeedDisplayInherit;
  }
  
  public boolean isFromQuickDiscovery()
  {
    return this.isFromQuickDiscovery;
  }
  
  public boolean isSelectFollowInherit()
  {
    return this.isSelectFollowInherit;
  }
  
  public boolean isSetInheritAndSuccess()
  {
    return this.isSetInheritAndSuccess;
  }
  
  public void setBulbSSID(String paramString)
  {
    this.bulbSSID = paramString;
  }
  
  public void setComponentResult(QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    this.componentResult = paramQuickSetupComponentResult;
  }
  
  public void setDeviceIdMD5(String paramString)
  {
    this.deviceIdMD5 = paramString;
  }
  
  public void setDeviceModel(String paramString)
  {
    this.deviceModel = paramString;
  }
  
  public void setFromQuickDiscovery(boolean paramBoolean)
  {
    this.isFromQuickDiscovery = paramBoolean;
  }
  
  public void setInheritAndSuccess(boolean paramBoolean)
  {
    this.isSetInheritAndSuccess = paramBoolean;
  }
  
  public void setLatitude(Integer paramInteger)
  {
    this.latitude = paramInteger;
  }
  
  public void setLongitude(Integer paramInteger)
  {
    this.longitude = paramInteger;
  }
  
  public void setNeedDisplayInherit(boolean paramBoolean)
  {
    this.inNeedDisplayInherit = paramBoolean;
  }
  
  public void setOnBoardingType(EnumOnboardingType paramEnumOnboardingType)
  {
    this.onBoardingType = paramEnumOnboardingType;
  }
  
  public void setOnboardingStartTime(long paramLong)
  {
    this.onboardingStartTime = paramLong;
  }
  
  public void setSelectFollowInherit(boolean paramBoolean)
  {
    this.isSelectFollowInherit = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\utils\QuickSetupInfoBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */