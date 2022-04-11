package com.tplink.iot.view.quicksetup.base;

import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentExtraInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.io.Serializable;

public class QuickSetupInfoBean
  implements Serializable
{
  private QuickSetupComponentResult componentResult;
  private String deviceIdMD5;
  private boolean isKeepInherit;
  private Integer latitude;
  private Integer longitude;
  private long onboardingStartTime;
  private String resultDeviceId;
  private String resultDeviceIdMD5;
  private String ssid;
  
  public QuickSetupInfoBean(String paramString, long paramLong)
  {
    this.deviceIdMD5 = paramString;
    this.onboardingStartTime = paramLong;
  }
  
  public QuickSetupInfoBean(String paramString1, String paramString2, long paramLong)
  {
    this.deviceIdMD5 = paramString1;
    this.ssid = paramString2;
    this.onboardingStartTime = paramLong;
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
    Object localObject = this.componentResult;
    if ((localObject != null) && (((QuickSetupComponentResult)localObject).getExtraInfo() != null)) {
      localObject = this.componentResult.getExtraInfo().getDeviceModel();
    } else {
      localObject = "P100";
    }
    return (String)localObject;
  }
  
  public String getDeviceType()
  {
    String str1 = EnumDeviceType.PLUG.getDeviceType();
    QuickSetupComponentResult localQuickSetupComponentResult = this.componentResult;
    String str2 = str1;
    if (localQuickSetupComponentResult != null)
    {
      str2 = str1;
      if (localQuickSetupComponentResult.getExtraInfo() != null) {
        str2 = this.componentResult.getExtraInfo().getDeviceType();
      }
    }
    return str2;
  }
  
  public Integer getLatitude()
  {
    return this.latitude;
  }
  
  public Integer getLongitude()
  {
    return this.longitude;
  }
  
  public long getOnboardingStartTime()
  {
    return this.onboardingStartTime;
  }
  
  public String getResultDeviceId()
  {
    return this.resultDeviceId;
  }
  
  public String getResultDeviceIdMD5()
  {
    return this.resultDeviceIdMD5;
  }
  
  public String getSsid()
  {
    return this.ssid;
  }
  
  public boolean isKeepInherit()
  {
    return this.isKeepInherit;
  }
  
  public void setComponentResult(QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    this.componentResult = paramQuickSetupComponentResult;
  }
  
  public void setDeviceIdMD5(String paramString)
  {
    this.deviceIdMD5 = paramString;
  }
  
  public void setKeepInherit(boolean paramBoolean)
  {
    this.isKeepInherit = paramBoolean;
  }
  
  public void setLatitude(Integer paramInteger)
  {
    this.latitude = paramInteger;
  }
  
  public void setLongitude(Integer paramInteger)
  {
    this.longitude = paramInteger;
  }
  
  public void setOnboardingStartTime(long paramLong)
  {
    this.onboardingStartTime = paramLong;
  }
  
  public void setResultDeviceId(String paramString)
  {
    this.resultDeviceId = paramString;
  }
  
  public void setResultDeviceIdMD5(String paramString)
  {
    this.resultDeviceIdMD5 = paramString;
  }
  
  public void setSsid(String paramString)
  {
    this.ssid = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\QuickSetupInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */