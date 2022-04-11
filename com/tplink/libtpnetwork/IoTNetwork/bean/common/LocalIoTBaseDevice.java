package com.tplink.libtpnetwork.IoTNetwork.bean.common;

import androidx.annotation.NonNull;
import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingRealTimeInfo;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ComponentBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LocalIoTBaseDevice
  implements Serializable, Comparable<LocalIoTBaseDevice>, Cloneable
{
  protected String avatar;
  protected List<ComponentBean> components;
  @c("default_states")
  protected DefaultStatesBean defaultStates;
  @c("device_id")
  protected String deviceId;
  @c("device_on")
  protected boolean deviceOn;
  @c("fw_id")
  protected String fwId;
  @c("fw_ver")
  protected String fwVer;
  @c("has_set_location_info")
  protected boolean hasSetLocationInfo;
  @c("hw_id")
  protected String hwId;
  @c("hw_ver")
  protected String hwVer;
  protected String ip;
  protected String lang;
  protected Integer latitude;
  @Deprecated
  protected String location;
  protected Integer longitude;
  protected String mac;
  protected String model;
  @b(Base64TypeAdapter.class)
  protected String nickname;
  @c("oem_id")
  protected String oemId;
  protected boolean overheated;
  @c("parent_device_id")
  protected String parentDeviceId;
  protected String region;
  protected Integer rssi;
  @c("signal_level")
  protected int signalLevel;
  protected String specs;
  @b(Base64TypeAdapter.class)
  protected String ssid;
  @c("time_diff")
  protected int timeDiff;
  protected String type;
  
  public LocalIoTBaseDevice clone()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice2;
    try
    {
      LocalIoTBaseDevice localLocalIoTBaseDevice1 = (LocalIoTBaseDevice)super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
      localLocalIoTBaseDevice2 = null;
    }
    return localLocalIoTBaseDevice2;
  }
  
  public int compareTo(@NonNull LocalIoTBaseDevice paramLocalIoTBaseDevice)
  {
    return 0;
  }
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public int getComponentVersion(EnumIoTComponent paramEnumIoTComponent)
  {
    Object localObject = this.components;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      Iterator localIterator = this.components.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ComponentBean)localIterator.next();
        if ((localObject != null) && (paramEnumIoTComponent == ((ComponentBean)localObject).getId())) {
          return Math.max(((ComponentBean)localObject).getVersion(), 0);
        }
      }
    }
    return 0;
  }
  
  public List<ComponentBean> getComponents()
  {
    return this.components;
  }
  
  public DefaultStatesBean getDefaultStates()
  {
    return this.defaultStates;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public DeviceInfoParams getDeviceInfoParams()
  {
    DeviceInfoParams localDeviceInfoParams = new DeviceInfoParams();
    localDeviceInfoParams.setNickname(this.nickname);
    localDeviceInfoParams.setLocation(this.location);
    localDeviceInfoParams.setAvatar(this.avatar);
    localDeviceInfoParams.setDeviceOn(Boolean.valueOf(this.deviceOn));
    localDeviceInfoParams.setLongitude(this.longitude);
    localDeviceInfoParams.setLatitude(this.latitude);
    return localDeviceInfoParams;
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
  
  public String getMac()
  {
    return this.mac;
  }
  
  public String getModel()
  {
    return this.model;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public String getOemId()
  {
    return this.oemId;
  }
  
  public String getParentDeviceId()
  {
    return this.parentDeviceId;
  }
  
  public String getRegion()
  {
    return this.region;
  }
  
  public Integer getRssi()
  {
    return this.rssi;
  }
  
  public int getSignalLevel()
  {
    return this.signalLevel;
  }
  
  public String getSpecs()
  {
    return this.specs;
  }
  
  public String getSsid()
  {
    return this.ssid;
  }
  
  public int getTimeDiff()
  {
    return this.timeDiff;
  }
  
  public String getType()
  {
    return this.type;
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
  
  public boolean isSupportChild()
  {
    boolean bool;
    if ((isSupportComponent(EnumIoTComponent.CHILD_DEVICE)) && (isSupportComponent(EnumIoTComponent.CONTROL_CHILD))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSupportCloudConnect()
  {
    return isSupportComponent(EnumIoTComponent.CLOUD_CONNECT);
  }
  
  public boolean isSupportColorAndColorTemp()
  {
    boolean bool;
    if ((isSupportComponent(EnumIoTComponent.COLOR)) && (isSupportComponent(EnumIoTComponent.COLOR_TEMPERATURE))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSupportComponent(EnumIoTComponent paramEnumIoTComponent)
  {
    return paramEnumIoTComponent.isTargetComponentVersionAPPSupport(getComponentVersion(paramEnumIoTComponent));
  }
  
  public boolean isSupportDefaultStates()
  {
    return isSupportComponent(EnumIoTComponent.DEFAULT_STATES);
  }
  
  public boolean isSupportFirmware()
  {
    return isSupportComponent(EnumIoTComponent.FIRMWARE);
  }
  
  public boolean isSupportIoTCloudComponent()
  {
    return isSupportComponent(EnumIoTComponent.IOT_CLOUD);
  }
  
  public boolean isSupportLED()
  {
    return isSupportComponent(EnumIoTComponent.LED);
  }
  
  public boolean isSupportSunriseSunset()
  {
    return isSupportComponent(EnumIoTComponent.SUNRISE_SUNSET);
  }
  
  public void setAvatar(String paramString)
  {
    this.avatar = paramString;
  }
  
  public void setComponents(List<ComponentBean> paramList)
  {
    this.components = paramList;
  }
  
  public void setDefaultStates(DefaultStatesBean paramDefaultStatesBean)
  {
    this.defaultStates = paramDefaultStatesBean;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setDeviceOn(boolean paramBoolean)
  {
    this.deviceOn = paramBoolean;
  }
  
  public void setFwId(String paramString)
  {
    this.fwId = paramString;
  }
  
  public void setFwVer(String paramString)
  {
    this.fwVer = paramString;
  }
  
  public void setHasSetLocationInfo(boolean paramBoolean)
  {
    this.hasSetLocationInfo = paramBoolean;
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
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setModel(String paramString)
  {
    this.model = paramString;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
  
  public void setOemId(String paramString)
  {
    this.oemId = paramString;
  }
  
  public void setOverheated(boolean paramBoolean)
  {
    this.overheated = paramBoolean;
  }
  
  public void setParentDeviceId(String paramString)
  {
    this.parentDeviceId = paramString;
  }
  
  public void setRegion(String paramString)
  {
    this.region = paramString;
  }
  
  public void setRssi(Integer paramInteger)
  {
    this.rssi = paramInteger;
  }
  
  public void setSignalLevel(int paramInt)
  {
    this.signalLevel = paramInt;
  }
  
  public void setSpecs(String paramString)
  {
    this.specs = paramString;
  }
  
  public void setSsid(String paramString)
  {
    this.ssid = paramString;
  }
  
  public void setTimeDiff(int paramInt)
  {
    this.timeDiff = paramInt;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void updateDeviceInfoParam(DeviceInfoParams paramDeviceInfoParams)
  {
    if (paramDeviceInfoParams != null)
    {
      if (paramDeviceInfoParams.getNickname() != null) {
        this.nickname = paramDeviceInfoParams.getNickname();
      }
      if (paramDeviceInfoParams.getAvatar() != null) {
        this.avatar = paramDeviceInfoParams.getAvatar();
      }
      if (paramDeviceInfoParams.getLocation() != null) {
        this.location = paramDeviceInfoParams.getLocation();
      }
      if (paramDeviceInfoParams.getDeviceOn() != null) {
        this.deviceOn = paramDeviceInfoParams.getDeviceOn().booleanValue();
      }
      if (paramDeviceInfoParams.getLongitude() != null) {
        this.longitude = paramDeviceInfoParams.getLongitude();
      }
      if (paramDeviceInfoParams.getLatitude() != null) {
        this.latitude = paramDeviceInfoParams.getLatitude();
      }
      if (paramDeviceInfoParams.getDefaultStates() != null) {
        this.defaultStates = paramDeviceInfoParams.getDefaultStates();
      }
    }
  }
  
  public void updateDeviceRunningInfo(DeviceRunningInfoResult paramDeviceRunningInfoResult, boolean paramBoolean)
  {
    if (paramDeviceRunningInfoResult != null)
    {
      this.fwVer = paramDeviceRunningInfoResult.getFwVer();
      this.nickname = paramDeviceRunningInfoResult.getNickname();
      this.location = paramDeviceRunningInfoResult.getLocation();
      this.avatar = paramDeviceRunningInfoResult.getAvatar();
      this.ip = paramDeviceRunningInfoResult.getIp();
      this.deviceOn = paramDeviceRunningInfoResult.isDeviceOn();
      this.overheated = paramDeviceRunningInfoResult.isOverheated();
      this.hasSetLocationInfo = paramDeviceRunningInfoResult.isHasSetLocationInfo();
      this.longitude = paramDeviceRunningInfoResult.getLongitude();
      this.latitude = paramDeviceRunningInfoResult.getLatitude();
      this.lang = paramDeviceRunningInfoResult.getLang();
      this.defaultStates = paramDeviceRunningInfoResult.getDefaultStates();
      if (!paramBoolean)
      {
        this.signalLevel = paramDeviceRunningInfoResult.getSignalLevel();
        this.rssi = paramDeviceRunningInfoResult.getRssi();
      }
    }
  }
  
  public void updateDeviceShadow(Map<String, Object> paramMap) {}
  
  public void updateThingRealTimeInfo(ThingRealTimeInfo paramThingRealTimeInfo)
  {
    if (paramThingRealTimeInfo != null)
    {
      this.signalLevel = paramThingRealTimeInfo.getSignalLevel();
      this.rssi = paramThingRealTimeInfo.getRssi();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\LocalIoTBaseDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */