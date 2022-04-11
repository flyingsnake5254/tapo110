package com.tplink.libtpnetwork.cameranetwork.bean;

import android.text.TextUtils;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.cameranetwork.model.BasicInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import java.io.Serializable;
import org.apache.commons.lang.b;

public class CameraBasicInfo
  implements Serializable
{
  @c("avatar")
  private String avatar;
  @c("barcode")
  private String barcode;
  @c("cameraAvatarInfo")
  private CameraAvatarInfo cameraAvatarInfo;
  @c("cameraComponent")
  private CameraComponent cameraComponent;
  @c("cameraLastEvent")
  private CameraLastEvent cameraLastEvent;
  @c("device_alias")
  private String deviceAlias;
  @c("device_id")
  private String deviceId;
  @c("device_info")
  private String deviceInfo;
  @c("device_mode")
  private String deviceModel;
  @c("device_name")
  private String deviceName;
  @c("device_type")
  private String deviceType;
  @c("feature")
  private String feature;
  @c("ffs")
  private boolean ffs;
  @c("hw_desc")
  private String hardwareDesc;
  @c("hw_ver")
  private String hardwareVer;
  @c("lock_message")
  private String lockMessage;
  @c("lock_status")
  private int lockStatus;
  @c("mac")
  private String mac;
  @c("oem_id")
  private String oemId;
  @c("oem_name")
  private String oemName;
  @c("fw_ver")
  private String softwareVer;
  
  public CameraBasicInfo clone()
  {
    CameraBasicInfo localCameraBasicInfo = new CameraBasicInfo();
    localCameraBasicInfo.deviceType = this.deviceType;
    localCameraBasicInfo.deviceModel = this.deviceModel;
    localCameraBasicInfo.deviceName = this.deviceName;
    localCameraBasicInfo.deviceInfo = this.deviceInfo;
    localCameraBasicInfo.deviceAlias = this.deviceAlias;
    localCameraBasicInfo.hardwareVer = this.hardwareVer;
    localCameraBasicInfo.softwareVer = this.softwareVer;
    localCameraBasicInfo.deviceId = this.deviceId;
    localCameraBasicInfo.barcode = this.barcode;
    localCameraBasicInfo.mac = this.mac;
    localCameraBasicInfo.feature = this.feature;
    localCameraBasicInfo.oemId = this.oemId;
    localCameraBasicInfo.hardwareDesc = this.hardwareDesc;
    localCameraBasicInfo.ffs = this.ffs;
    localCameraBasicInfo.cameraAvatarInfo = this.cameraAvatarInfo;
    localCameraBasicInfo.cameraLastEvent = this.cameraLastEvent;
    localCameraBasicInfo.cameraComponent = this.cameraComponent;
    localCameraBasicInfo.oemName = this.oemName;
    localCameraBasicInfo.lockStatus = this.lockStatus;
    localCameraBasicInfo.lockMessage = this.lockMessage;
    return localCameraBasicInfo;
  }
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public String getAvatarName()
  {
    CameraAvatarInfo localCameraAvatarInfo = this.cameraAvatarInfo;
    if ((localCameraAvatarInfo != null) && (localCameraAvatarInfo.getAvatarName() != null)) {
      return this.cameraAvatarInfo.getAvatarName();
    }
    return "";
  }
  
  public String getBarcode()
  {
    return this.barcode;
  }
  
  public CameraAvatarInfo getCameraAvatarInfo()
  {
    return this.cameraAvatarInfo;
  }
  
  public CameraComponent getCameraComponent()
  {
    return this.cameraComponent;
  }
  
  public CameraLastEvent getCameraLastEvent()
  {
    return this.cameraLastEvent;
  }
  
  public String getCustomLocationUrl()
  {
    Object localObject1 = this.cameraAvatarInfo;
    Object localObject2 = "";
    if (localObject1 != null) {
      localObject1 = ((CameraAvatarInfo)localObject1).getAvatarRemoteUrl();
    } else {
      localObject1 = "";
    }
    if (localObject1 != null) {
      localObject2 = localObject1;
    }
    return (String)localObject2;
  }
  
  public String getDeviceAlias()
  {
    return this.deviceAlias;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getDeviceInfo()
  {
    return this.deviceInfo;
  }
  
  public String getDeviceLocation()
  {
    Object localObject1 = this.cameraAvatarInfo;
    Object localObject2 = "";
    if (localObject1 != null) {
      localObject1 = ((CameraAvatarInfo)localObject1).getAvatarName();
    } else {
      localObject1 = "";
    }
    if (localObject1 != null) {
      localObject2 = localObject1;
    }
    return (String)localObject2;
  }
  
  public String getDeviceModel()
  {
    return this.deviceModel;
  }
  
  public String getDeviceName()
  {
    return this.deviceName;
  }
  
  public String getDeviceType()
  {
    return this.deviceType;
  }
  
  public String getFeature()
  {
    return this.feature;
  }
  
  public String getHardwareDesc()
  {
    return this.hardwareDesc;
  }
  
  public String getHardwareVer()
  {
    return this.hardwareVer;
  }
  
  public long getLastAlarmTime()
  {
    CameraLastEvent localCameraLastEvent = this.cameraLastEvent;
    if ((localCameraLastEvent != null) && (localCameraLastEvent.getAlarmTime() > 0L)) {
      return this.cameraLastEvent.getAlarmTime();
    }
    return 0L;
  }
  
  public String getLastAlarmType()
  {
    CameraLastEvent localCameraLastEvent = this.cameraLastEvent;
    if ((localCameraLastEvent != null) && (!TextUtils.isEmpty(localCameraLastEvent.getAlarmType()))) {
      return this.cameraLastEvent.getAlarmType();
    }
    return "";
  }
  
  public String getLockMessage()
  {
    return this.lockMessage;
  }
  
  public int getLockStatus()
  {
    return this.lockStatus;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public String getOemId()
  {
    return this.oemId;
  }
  
  public String getOemName()
  {
    return this.oemName;
  }
  
  public String getSoftwareVer()
  {
    return this.softwareVer;
  }
  
  public boolean isDefaultLocation()
  {
    CameraAvatarInfo localCameraAvatarInfo = this.cameraAvatarInfo;
    boolean bool;
    if ((localCameraAvatarInfo != null) && (!b.b(localCameraAvatarInfo.getAvatarDefault()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isFfs()
  {
    return this.ffs;
  }
  
  public void setAvatar(String paramString)
  {
    this.avatar = paramString;
  }
  
  public void setBarcode(String paramString)
  {
    this.barcode = paramString;
  }
  
  public void setBasicInfo(BasicInfo paramBasicInfo)
  {
    if (paramBasicInfo == null) {
      return;
    }
    this.deviceType = paramBasicInfo.getType();
    this.deviceModel = paramBasicInfo.getModel();
    this.deviceName = paramBasicInfo.getName();
    this.deviceInfo = paramBasicInfo.getInfo();
    this.hardwareVer = paramBasicInfo.getHardwareVer();
    this.softwareVer = paramBasicInfo.getSoftwareVer();
    this.deviceAlias = paramBasicInfo.getDeviceAlias();
    this.avatar = paramBasicInfo.getAvatar();
    this.feature = paramBasicInfo.getFeature();
    this.barcode = paramBasicInfo.getBarcode();
    this.mac = paramBasicInfo.getMac();
    this.deviceId = paramBasicInfo.getDeviceId();
    this.oemId = paramBasicInfo.getOemId();
    this.hardwareDesc = paramBasicInfo.getHardwareDesc();
    this.ffs = paramBasicInfo.getFfs();
    this.oemName = paramBasicInfo.getOenName();
    int i;
    if (paramBasicInfo.getLockStatus() == null) {
      i = 0;
    } else {
      i = paramBasicInfo.getLockStatus().intValue();
    }
    this.lockStatus = i;
    this.lockMessage = paramBasicInfo.getLockMessage();
  }
  
  public void setCameraAvatarInfo(CameraAvatarInfo paramCameraAvatarInfo)
  {
    this.cameraAvatarInfo = paramCameraAvatarInfo;
  }
  
  public void setCameraComponent(CameraComponent paramCameraComponent)
  {
    this.cameraComponent = paramCameraComponent;
  }
  
  public void setCameraLastEvent(CameraLastEvent paramCameraLastEvent)
  {
    this.cameraLastEvent = paramCameraLastEvent;
  }
  
  public void setDeviceAlias(String paramString)
  {
    this.deviceAlias = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setDeviceInfo(String paramString)
  {
    this.deviceInfo = paramString;
  }
  
  public void setDeviceModel(String paramString)
  {
    this.deviceModel = paramString;
  }
  
  public void setDeviceName(String paramString)
  {
    this.deviceName = paramString;
  }
  
  public void setDeviceType(String paramString)
  {
    this.deviceType = paramString;
  }
  
  public void setFeature(String paramString)
  {
    this.feature = paramString;
  }
  
  public void setFfs(boolean paramBoolean)
  {
    this.ffs = paramBoolean;
  }
  
  public void setHardwareDesc(String paramString)
  {
    this.hardwareDesc = paramString;
  }
  
  public void setHardwareVer(String paramString)
  {
    this.hardwareVer = paramString;
  }
  
  public void setLockStatus(int paramInt)
  {
    this.lockStatus = paramInt;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setOemId(String paramString)
  {
    this.oemId = paramString;
  }
  
  public void setOemName(String paramString)
  {
    this.oemName = paramString;
  }
  
  public void setSoftwareVer(String paramString)
  {
    this.softwareVer = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\CameraBasicInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */