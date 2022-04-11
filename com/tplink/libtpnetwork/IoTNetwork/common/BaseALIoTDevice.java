package com.tplink.libtpnetwork.IoTNetwork.common;

import android.text.TextUtils;
import b.d.w.h.b;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import com.tplink.libtpnetwork.enumerate.EnumUserRole;
import com.tplink.tdp.bean.BaseTDPDevice;
import java.io.Serializable;

public abstract class BaseALIoTDevice<T extends TDPIoTDevice>
  implements Serializable
{
  protected TCDeviceBean cloudIoTDevice;
  protected DeviceManagerInfoBean deviceManagerInfo;
  protected EnumIoTDeviceState deviceState;
  protected boolean isBackupFromCache;
  private EnumIoTDeviceState lastDeviceStatus;
  private long loadingStartTimestamp;
  protected T tdpIoTDevice;
  
  public BaseALIoTDevice()
  {
    EnumIoTDeviceState localEnumIoTDeviceState = EnumIoTDeviceState.LOADING;
    this.deviceState = localEnumIoTDeviceState;
    this.isBackupFromCache = false;
    this.loadingStartTimestamp = System.currentTimeMillis();
    this.lastDeviceStatus = localEnumIoTDeviceState;
    this.deviceManagerInfo = new DeviceManagerInfoBean();
  }
  
  public BaseALIoTDevice(T paramT)
  {
    EnumIoTDeviceState localEnumIoTDeviceState = EnumIoTDeviceState.LOADING;
    this.deviceState = localEnumIoTDeviceState;
    this.isBackupFromCache = false;
    this.loadingStartTimestamp = System.currentTimeMillis();
    this.lastDeviceStatus = localEnumIoTDeviceState;
    this.tdpIoTDevice = paramT;
    this.deviceManagerInfo = new DeviceManagerInfoBean();
  }
  
  public BaseALIoTDevice(TCDeviceBean paramTCDeviceBean)
  {
    EnumIoTDeviceState localEnumIoTDeviceState = EnumIoTDeviceState.LOADING;
    this.deviceState = localEnumIoTDeviceState;
    this.isBackupFromCache = false;
    this.loadingStartTimestamp = System.currentTimeMillis();
    this.lastDeviceStatus = localEnumIoTDeviceState;
    this.cloudIoTDevice = paramTCDeviceBean;
    this.deviceManagerInfo = new DeviceManagerInfoBean();
  }
  
  public String getAppServerUrl()
  {
    TCDeviceBean localTCDeviceBean = this.cloudIoTDevice;
    if (localTCDeviceBean != null) {
      return localTCDeviceBean.getAppServerUrl();
    }
    return "";
  }
  
  public abstract int getBindCount();
  
  public abstract int getBrightness();
  
  public abstract String getCategory();
  
  public TCDeviceBean getCloudIoTDevice()
  {
    return this.cloudIoTDevice;
  }
  
  public abstract int getColorTemp();
  
  public abstract String getDeviceFwVer();
  
  public abstract String getDeviceHwVer();
  
  public abstract String getDeviceIcon();
  
  public abstract String getDeviceId();
  
  public abstract String getDeviceIdMD5();
  
  public abstract String getDeviceLocation();
  
  public abstract String getDeviceMac();
  
  public DeviceManagerInfoBean getDeviceManagerInfo()
  {
    return this.deviceManagerInfo;
  }
  
  public abstract String getDeviceModel();
  
  public abstract String getDeviceName();
  
  public abstract String getDeviceRegion();
  
  public EnumIoTDeviceState getDeviceState()
  {
    return this.deviceState;
  }
  
  public abstract String getDeviceType();
  
  public abstract String getDynamicLightEffectId();
  
  public abstract EnumDeviceType getEnumDeviceType();
  
  public abstract String getFamilyId();
  
  public abstract String getGuardMode();
  
  public abstract boolean getGuardOn();
  
  public abstract int getHue();
  
  public String getIp()
  {
    TDPIoTDevice localTDPIoTDevice = this.tdpIoTDevice;
    if ((localTDPIoTDevice != null) && (localTDPIoTDevice.getIp() != null)) {
      return this.tdpIoTDevice.getIp();
    }
    return "";
  }
  
  public EnumIoTDeviceState getLastDeviceStatus()
  {
    return this.lastDeviceStatus;
  }
  
  public abstract long getLatestLogTimestamp();
  
  public long getLoadingStartTimestamp()
  {
    return this.loadingStartTimestamp;
  }
  
  public abstract Object getLocalIoTDevice();
  
  public abstract int getOnBoardingTime();
  
  public abstract String getOriginalDeviceId();
  
  public abstract String getParentDeviceIDMD5();
  
  public abstract String getParentDeviceId();
  
  public abstract String getRoomId();
  
  public abstract int getSaturation();
  
  public abstract String getSpecs();
  
  protected String getSuitableValue(String paramString1, String paramString2, String paramString3)
  {
    if (!b.d(paramString1)) {
      return paramString1;
    }
    if (!b.d(paramString2)) {
      return paramString2;
    }
    return paramString3;
  }
  
  protected String getSuitableValue(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!b.d(paramString1)) {
      return paramString1;
    }
    if (!b.d(paramString2)) {
      return paramString2;
    }
    if (!b.d(paramString3)) {
      return paramString3;
    }
    return paramString4;
  }
  
  protected String getSuitableValue(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!b.d(paramString1)) {
      return paramString1;
    }
    if (!b.d(paramString2)) {
      return paramString2;
    }
    if (!b.d(paramString3)) {
      return paramString3;
    }
    if (!b.d(paramString4)) {
      return paramString4;
    }
    return paramString5;
  }
  
  public TDPIoTDevice getTDPIoTDevice()
  {
    return this.tdpIoTDevice;
  }
  
  public abstract ThingDevice getThingDevice();
  
  public boolean isBackupFromCache()
  {
    return this.isBackupFromCache;
  }
  
  public boolean isBulb()
  {
    boolean bool;
    if (EnumDeviceType.BULB == EnumDeviceType.fromType(getDeviceType())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isCamera()
  {
    boolean bool;
    if (EnumDeviceType.CAMERA == EnumDeviceType.fromType(getDeviceType())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract boolean isCommonDevice();
  
  public abstract boolean isDataFromThing();
  
  public boolean isDeviceOffLine()
  {
    boolean bool;
    if (this.deviceState == EnumIoTDeviceState.OFFLINE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract boolean isDeviceOn();
  
  public abstract boolean isDynamicLightEffectEnable();
  
  public boolean isEnergy()
  {
    boolean bool;
    if (EnumDeviceType.ENERGY == EnumDeviceType.fromType(getDeviceType())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract boolean isFirmwareSupportIoTCloud();
  
  public abstract boolean isHasThingOrCloudDevice();
  
  public boolean isHub()
  {
    boolean bool;
    if (EnumDeviceType.HUB == EnumDeviceType.fromType(getDeviceType())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isLightStrip()
  {
    boolean bool1 = isBulb();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    String str = getDeviceModel();
    bool1 = isSupportIoTComponent(EnumIoTComponent.LIGHT_STRIP);
    int i;
    if ((!TextUtils.isEmpty(str)) && ((str.startsWith("L900")) || (str.startsWith("L920")) || (str.startsWith("L930")))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((bool1) || (i != 0)) {
      bool2 = true;
    }
    return bool2;
  }
  
  public boolean isOnline()
  {
    boolean bool;
    if (this.deviceState == EnumIoTDeviceState.ONLINE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isPlug()
  {
    boolean bool;
    if (EnumDeviceType.PLUG == EnumDeviceType.fromType(getDeviceType())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSensor()
  {
    boolean bool;
    if (EnumDeviceType.SENSOR == EnumDeviceType.fromType(getDeviceType())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract boolean isSubDevice();
  
  public abstract boolean isSupportChild();
  
  public abstract boolean isSupportCloudConnect();
  
  public abstract boolean isSupportDeviceShare();
  
  public abstract boolean isSupportIoTCloud();
  
  public abstract boolean isSupportIoTComponent(EnumIoTComponent paramEnumIoTComponent);
  
  public abstract boolean isSupportLED();
  
  public abstract boolean isSupportSunriseSunset();
  
  public boolean isSwitch()
  {
    boolean bool;
    if (EnumDeviceType.SWITCH == EnumDeviceType.fromType(getDeviceType())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract boolean isThingOnline();
  
  public boolean isUserRoleTypeDevice()
  {
    ThingDevice localThingDevice = getThingDevice();
    TCDeviceBean localTCDeviceBean = this.cloudIoTDevice;
    boolean bool = false;
    int i;
    if ((localTCDeviceBean == null) && (localThingDevice != null) && (localThingDevice.getThingInfo() != null) && (localThingDevice.getThingInfo().getRole() == 1)) {
      i = 1;
    } else {
      i = 0;
    }
    localTCDeviceBean = this.cloudIoTDevice;
    if (((localTCDeviceBean != null) && (localTCDeviceBean.getRole() == EnumUserRole.ROLE_USER)) || (i != 0)) {
      bool = true;
    }
    return bool;
  }
  
  public void setBackupFromCache(boolean paramBoolean)
  {
    this.isBackupFromCache = paramBoolean;
  }
  
  public void setCloudIoTDevice(TCDeviceBean paramTCDeviceBean)
  {
    this.cloudIoTDevice = paramTCDeviceBean;
  }
  
  public abstract void setCommonDevice(boolean paramBoolean);
  
  public abstract void setDataFromThing(boolean paramBoolean);
  
  public void setDeviceManagerInfo(DeviceManagerInfoBean paramDeviceManagerInfoBean)
  {
    this.deviceManagerInfo = paramDeviceManagerInfoBean;
  }
  
  public abstract void setDeviceOn(boolean paramBoolean);
  
  public void setDeviceState(EnumIoTDeviceState paramEnumIoTDeviceState)
  {
    this.lastDeviceStatus = this.deviceState;
    this.deviceState = paramEnumIoTDeviceState;
  }
  
  public void setLoadingStartTimestamp(long paramLong)
  {
    this.loadingStartTimestamp = paramLong;
  }
  
  public abstract void setLocalIoTDevice(Object paramObject);
  
  public void setTDPIoTDevice(T paramT)
  {
    this.tdpIoTDevice = paramT;
  }
  
  public abstract void setThingDevice(ThingDevice paramThingDevice);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\common\BaseALIoTDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */