package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.i;
import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.Base64TypeAdapter;

public class ThingSetting
{
  private String avatarUrl;
  private Boolean commonDevice;
  private i defaultStates;
  private String lang;
  private Integer latitude;
  private Integer longitude;
  @b(Base64TypeAdapter.class)
  private String nickname;
  private String region;
  private String specs;
  private Integer timeDiff;
  
  public String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  public Boolean getCommonDevice()
  {
    return this.commonDevice;
  }
  
  public i getDefaultStates()
  {
    return this.defaultStates;
  }
  
  public String getLang()
  {
    return this.lang;
  }
  
  public Integer getLatitude()
  {
    return this.latitude;
  }
  
  public Integer getLongitude()
  {
    return this.longitude;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public String getRegion()
  {
    return this.region;
  }
  
  public String getSpecs()
  {
    return this.specs;
  }
  
  public Integer getTimeDiff()
  {
    return this.timeDiff;
  }
  
  public void setAvatarUrl(String paramString)
  {
    this.avatarUrl = paramString;
  }
  
  public void setCommonDevice(Boolean paramBoolean)
  {
    this.commonDevice = paramBoolean;
  }
  
  public void setDefaultStates(i parami)
  {
    this.defaultStates = parami;
  }
  
  public void setLang(String paramString)
  {
    this.lang = paramString;
  }
  
  public void setLatitude(Integer paramInteger)
  {
    this.latitude = paramInteger;
  }
  
  public void setLongitude(Integer paramInteger)
  {
    this.longitude = paramInteger;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
  
  public void setRegion(String paramString)
  {
    this.region = paramString;
  }
  
  public void setSpecs(String paramString)
  {
    this.specs = paramString;
  }
  
  public void setTimeDiff(Integer paramInteger)
  {
    this.timeDiff = paramInteger;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */