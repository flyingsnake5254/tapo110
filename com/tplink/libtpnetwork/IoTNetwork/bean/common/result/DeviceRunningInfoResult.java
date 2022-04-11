package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;

public class DeviceRunningInfoResult
{
  protected String avatar;
  @c("default_states")
  protected DefaultStatesBean defaultStates;
  @c("device_on")
  protected boolean deviceOn;
  @c("fw_ver")
  protected String fwVer;
  @c("has_set_location_info")
  protected boolean hasSetLocationInfo;
  protected String ip;
  protected String lang;
  protected Integer latitude;
  @Deprecated
  protected String location;
  protected Integer longitude;
  @b(Base64TypeAdapter.class)
  protected String nickname;
  @c("on_time")
  @Deprecated
  protected long onTime;
  @c("overheated")
  protected boolean overheated;
  protected Integer rssi;
  @c("signal_level")
  protected int signalLevel;
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public DefaultStatesBean getDefaultStates()
  {
    return this.defaultStates;
  }
  
  public String getFwVer()
  {
    return this.fwVer;
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public String getLang()
  {
    return this.lang;
  }
  
  public Integer getLatitude()
  {
    return this.latitude;
  }
  
  public String getLocation()
  {
    return this.location;
  }
  
  public Integer getLongitude()
  {
    return this.longitude;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public long getOnTime()
  {
    return this.onTime;
  }
  
  public Integer getRssi()
  {
    return this.rssi;
  }
  
  public int getSignalLevel()
  {
    return this.signalLevel;
  }
  
  public boolean isDeviceOn()
  {
    return this.deviceOn;
  }
  
  public boolean isHasSetLocationInfo()
  {
    if (this.hasSetLocationInfo)
    {
      Integer localInteger = this.longitude;
      if ((localInteger != null) && (this.latitude != null) && (Math.abs(localInteger.intValue()) <= 1800000) && (Math.abs(this.latitude.intValue()) <= 900000)) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public boolean isOverheated()
  {
    return this.overheated;
  }
  
  public void setAvatar(String paramString)
  {
    this.avatar = paramString;
  }
  
  public void setDefaultStates(DefaultStatesBean paramDefaultStatesBean)
  {
    this.defaultStates = paramDefaultStatesBean;
  }
  
  public void setDeviceOn(boolean paramBoolean)
  {
    this.deviceOn = paramBoolean;
  }
  
  public void setFwVer(String paramString)
  {
    this.fwVer = paramString;
  }
  
  public void setHasSetLocationInfo(boolean paramBoolean)
  {
    this.hasSetLocationInfo = paramBoolean;
  }
  
  public void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public void setLang(String paramString)
  {
    this.lang = paramString;
  }
  
  public void setLatitude(Integer paramInteger)
  {
    this.latitude = paramInteger;
  }
  
  public void setLocation(String paramString)
  {
    this.location = paramString;
  }
  
  public void setLongitude(Integer paramInteger)
  {
    this.longitude = paramInteger;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
  
  public void setOnTime(long paramLong)
  {
    this.onTime = paramLong;
  }
  
  public void setOverheated(boolean paramBoolean)
  {
    this.overheated = paramBoolean;
  }
  
  public void setRssi(Integer paramInteger)
  {
    this.rssi = paramInteger;
  }
  
  public void setSignalLevel(int paramInt)
  {
    this.signalLevel = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\DeviceRunningInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */