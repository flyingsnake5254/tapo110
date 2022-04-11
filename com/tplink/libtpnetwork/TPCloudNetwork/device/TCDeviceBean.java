package com.tplink.libtpnetwork.TPCloudNetwork.device;

import android.text.TextUtils;
import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import com.tplink.libtpnetwork.enumerate.EnumDeviceStatus;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumUserRole;
import java.io.Serializable;

public class TCDeviceBean
  implements Serializable
{
  private String alias;
  private String appServerUrl;
  private String deviceHwVer;
  private String deviceId;
  private String deviceMac;
  private String deviceModel;
  private String deviceName;
  private String deviceType;
  private String fwId;
  private String fwVer;
  private String hwId;
  private boolean isSameRegion;
  private String oemId;
  private EnumUserRole role;
  private EnumDeviceStatus status;
  
  public TCDeviceBean() {}
  
  public TCDeviceBean(DeviceInfoResult paramDeviceInfoResult)
  {
    this.deviceId = paramDeviceInfoResult.getDeviceId();
    EnumDeviceStatus localEnumDeviceStatus;
    if (paramDeviceInfoResult.getStatus() == 0) {
      localEnumDeviceStatus = EnumDeviceStatus.STATUS_OFFLINE;
    } else {
      localEnumDeviceStatus = EnumDeviceStatus.STATUS_ONLINE;
    }
    this.status = localEnumDeviceStatus;
    this.deviceName = paramDeviceInfoResult.getDeviceName();
    this.deviceType = paramDeviceInfoResult.getDeviceType();
    this.alias = paramDeviceInfoResult.getAlias();
    this.deviceMac = swapMacAddress(paramDeviceInfoResult.getDeviceMac());
    this.hwId = paramDeviceInfoResult.getHwId();
    this.deviceModel = paramDeviceInfoResult.getDeviceModel();
    this.deviceHwVer = paramDeviceInfoResult.getDeviceHwVer();
    this.fwId = paramDeviceInfoResult.getFwId();
    this.oemId = paramDeviceInfoResult.getOemId();
    this.fwVer = paramDeviceInfoResult.getFwVer();
    this.appServerUrl = paramDeviceInfoResult.getAppServerUrl();
    this.isSameRegion = paramDeviceInfoResult.isSameRegion();
    if (paramDeviceInfoResult.getRole() == 0) {
      paramDeviceInfoResult = EnumUserRole.ROLE_OWNER;
    } else {
      paramDeviceInfoResult = EnumUserRole.ROLE_USER;
    }
    this.role = paramDeviceInfoResult;
  }
  
  public TCDeviceBean(String paramString1, EnumDeviceStatus paramEnumDeviceStatus, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean, EnumUserRole paramEnumUserRole)
  {
    this.deviceId = paramString1;
    this.status = paramEnumDeviceStatus;
    this.deviceName = paramString2;
    this.deviceType = paramString3;
    this.alias = paramString4;
    this.deviceMac = paramString5;
    this.hwId = paramString6;
    this.deviceModel = paramString7;
    this.deviceHwVer = paramString8;
    this.fwId = paramString9;
    this.oemId = paramString10;
    this.fwVer = paramString11;
    this.appServerUrl = paramString12;
    this.isSameRegion = paramBoolean;
    this.role = paramEnumUserRole;
  }
  
  private String swapMacAddress(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.length() == 12)
      {
        paramString = paramString.toUpperCase();
        str = String.format("%s-%s-%s-%s-%s-%s", new Object[] { paramString.subSequence(0, 2), paramString.substring(2, 4), paramString.substring(4, 6), paramString.substring(6, 8), paramString.substring(8, 10), paramString.substring(10, 12) });
      }
    }
    return str;
  }
  
  public TCDeviceBean clone()
  {
    TCDeviceBean localTCDeviceBean = new TCDeviceBean();
    localTCDeviceBean.deviceId = this.deviceId;
    localTCDeviceBean.status = this.status;
    localTCDeviceBean.deviceName = this.deviceName;
    localTCDeviceBean.deviceType = this.deviceType;
    localTCDeviceBean.alias = this.alias;
    localTCDeviceBean.deviceMac = this.deviceMac;
    localTCDeviceBean.hwId = this.hwId;
    localTCDeviceBean.deviceModel = this.deviceModel;
    localTCDeviceBean.deviceHwVer = this.deviceHwVer;
    localTCDeviceBean.fwId = this.fwId;
    localTCDeviceBean.oemId = this.oemId;
    localTCDeviceBean.fwVer = this.fwVer;
    localTCDeviceBean.appServerUrl = this.appServerUrl;
    localTCDeviceBean.isSameRegion = this.isSameRegion;
    localTCDeviceBean.role = this.role;
    return localTCDeviceBean;
  }
  
  public String getAlias()
  {
    return this.alias;
  }
  
  public String getAppServerUrl()
  {
    return this.appServerUrl;
  }
  
  public String getDeviceHwVer()
  {
    return this.deviceHwVer;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public DeviceInfoResult getDeviceInfo()
  {
    DeviceInfoResult localDeviceInfoResult = new DeviceInfoResult();
    localDeviceInfoResult.setDeviceId(this.deviceId);
    EnumDeviceStatus localEnumDeviceStatus1 = this.status;
    EnumDeviceStatus localEnumDeviceStatus2 = EnumDeviceStatus.STATUS_OFFLINE;
    int i = 0;
    int j;
    if (localEnumDeviceStatus1 == localEnumDeviceStatus2) {
      j = 0;
    } else {
      j = 1;
    }
    localDeviceInfoResult.setStatus(j);
    localDeviceInfoResult.setDeviceName(this.deviceName);
    localDeviceInfoResult.setDeviceType(this.deviceType);
    localDeviceInfoResult.setAlias(this.alias);
    localDeviceInfoResult.setDeviceMac(this.deviceMac.replace("-", ""));
    localDeviceInfoResult.setHwId(this.hwId);
    localDeviceInfoResult.setDeviceModel(this.deviceModel);
    localDeviceInfoResult.setDeviceHwVer(this.deviceHwVer);
    localDeviceInfoResult.setFwId(this.fwId);
    localDeviceInfoResult.setOemId(this.oemId);
    localDeviceInfoResult.setFwVer(this.fwVer);
    localDeviceInfoResult.setAppServerUrl(this.appServerUrl);
    localDeviceInfoResult.setSameRegion(this.isSameRegion);
    if (this.role == EnumUserRole.ROLE_OWNER) {
      j = i;
    } else {
      j = 1;
    }
    localDeviceInfoResult.setRole(j);
    return localDeviceInfoResult;
  }
  
  public String getDeviceMac()
  {
    return this.deviceMac;
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
  
  public String getOemId()
  {
    return this.oemId;
  }
  
  public EnumUserRole getRole()
  {
    return this.role;
  }
  
  public EnumDeviceStatus getStatus()
  {
    return this.status;
  }
  
  public boolean isCamera()
  {
    boolean bool;
    if (EnumDeviceType.CAMERA == EnumDeviceType.fromType(this.deviceType)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSameRegion()
  {
    return this.isSameRegion;
  }
  
  public void setAlias(String paramString)
  {
    this.alias = paramString;
  }
  
  public void setAppServerUrl(String paramString)
  {
    this.appServerUrl = paramString;
  }
  
  public void setDeviceHwVer(String paramString)
  {
    this.deviceHwVer = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setDeviceMac(String paramString)
  {
    this.deviceMac = paramString;
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
  
  public void setOemId(String paramString)
  {
    this.oemId = paramString;
  }
  
  public void setRole(EnumUserRole paramEnumUserRole)
  {
    this.role = paramEnumUserRole;
  }
  
  public void setSameRegion(boolean paramBoolean)
  {
    this.isSameRegion = paramBoolean;
  }
  
  public void setStatus(EnumDeviceStatus paramEnumDeviceStatus)
  {
    this.status = paramEnumDeviceStatus;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\device\TCDeviceBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */