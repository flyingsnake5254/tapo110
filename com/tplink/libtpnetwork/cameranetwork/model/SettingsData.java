package com.tplink.libtpnetwork.cameranetwork.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class SettingsData
{
  private AccountInfoCache accountInfo;
  private CameraInfoCache cameraInfo;
  private DeviceInfoCache deviceInfoCache;
  private FirmwareUpdateStatus firmwareUpdateStatus;
  private boolean hasNewFirmware;
  private ImageFlip imageFlip;
  private ImageFlipOptionSwitch imageFlipEnable;
  private String ipAddress;
  private OptionSwitch ledEnable;
  private LightFrequencyMode lightFrequencyMode;
  private String mac;
  private NetworkInfoCache networkInfo;
  private OsdInfoCache osdConfig;
  private RebootInfoCache rebootInfoCache;
  private OptionSwitch recordEnable;
  private ResolutionType resolutionType;
  private List<ResolutionType> resolutionTypes = new ArrayList();
  private SdCardInfoCache sdCardInfoCache;
  private ServiceList tapoCareNeedPayFunctionList;
  private String timezone;
  private String zoneId;
  
  public AccountInfoCache getAccountInfo()
  {
    return this.accountInfo;
  }
  
  public CameraInfoCache getCameraInfo()
  {
    return this.cameraInfo;
  }
  
  public DeviceInfoCache getDeviceInfoCache()
  {
    return this.deviceInfoCache;
  }
  
  public ImageFlip getImageFlip()
  {
    return this.imageFlip;
  }
  
  public boolean getImageFlipEnable()
  {
    return ImageFlipOptionSwitch.ON.equals(this.imageFlipEnable);
  }
  
  public String getIpAddress()
  {
    return this.ipAddress;
  }
  
  public LightFrequencyMode getLightFrequencyMode()
  {
    return this.lightFrequencyMode;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public NetworkInfoCache getNetworkInfo()
  {
    return this.networkInfo;
  }
  
  public OsdInfoCache getOsdConfig()
  {
    return this.osdConfig;
  }
  
  public RebootInfoCache getRebootConfig()
  {
    return this.rebootInfoCache;
  }
  
  public ResolutionType getResolutionType()
  {
    return this.resolutionType;
  }
  
  public List<ResolutionType> getResolutionTypes()
  {
    return this.resolutionTypes;
  }
  
  public SdCardInfoCache getSdCardInfoCache()
  {
    return this.sdCardInfoCache;
  }
  
  public ServiceList getTapoCareNeedPayFunctionList()
  {
    return this.tapoCareNeedPayFunctionList;
  }
  
  public String getTimezone()
  {
    return this.timezone;
  }
  
  public String getZoneId()
  {
    return this.zoneId;
  }
  
  public boolean isFirmwareUpgrading()
  {
    return "upgrading".equals(this.firmwareUpdateStatus.getStatus());
  }
  
  public boolean isHasNewFirmware()
  {
    return this.hasNewFirmware;
  }
  
  public boolean isLastUpgradeSuccess()
  {
    return this.firmwareUpdateStatus.getLastUpgradingSuccess();
  }
  
  public boolean isLedEnable()
  {
    return OptionSwitch.ON.equals(this.ledEnable);
  }
  
  public boolean isRebootEnable()
  {
    RebootInfoCache localRebootInfoCache = this.rebootInfoCache;
    if ((localRebootInfoCache != null) && (localRebootInfoCache.getEnable() != null)) {
      return OptionSwitch.ON.equals(this.rebootInfoCache.getEnable());
    }
    return false;
  }
  
  public boolean isRecordEnable()
  {
    return OptionSwitch.ON.equals(this.recordEnable);
  }
  
  public void setAccountInfo(AccountInfoCache paramAccountInfoCache)
  {
    this.accountInfo = paramAccountInfoCache;
  }
  
  public void setCameraInfo(CameraInfoCache paramCameraInfoCache)
  {
    this.cameraInfo = paramCameraInfoCache;
  }
  
  public void setDeviceInfoCache(DeviceInfoCache paramDeviceInfoCache)
  {
    this.deviceInfoCache = paramDeviceInfoCache;
  }
  
  public void setFirmwareUpdateStatus(FirmwareUpdateStatus paramFirmwareUpdateStatus)
  {
    this.firmwareUpdateStatus = paramFirmwareUpdateStatus;
  }
  
  public void setHasNewFirmware(boolean paramBoolean)
  {
    this.hasNewFirmware = paramBoolean;
  }
  
  public void setImageFlip(ImageFlip paramImageFlip)
  {
    this.imageFlip = paramImageFlip;
  }
  
  public void setImageFlipEnable(String paramString)
  {
    this.imageFlipEnable = ImageFlipOptionSwitch.fromString(paramString);
  }
  
  public void setImageFlipEnable(boolean paramBoolean)
  {
    ImageFlipOptionSwitch localImageFlipOptionSwitch;
    if (paramBoolean) {
      localImageFlipOptionSwitch = ImageFlipOptionSwitch.ON;
    } else {
      localImageFlipOptionSwitch = ImageFlipOptionSwitch.OFF;
    }
    this.imageFlipEnable = localImageFlipOptionSwitch;
  }
  
  public void setIpAddress(String paramString)
  {
    this.ipAddress = paramString;
  }
  
  public void setLedEnable(String paramString)
  {
    this.ledEnable = OptionSwitch.fromString(paramString);
  }
  
  public void setLedEnable(boolean paramBoolean)
  {
    OptionSwitch localOptionSwitch;
    if (paramBoolean) {
      localOptionSwitch = OptionSwitch.ON;
    } else {
      localOptionSwitch = OptionSwitch.OFF;
    }
    this.ledEnable = localOptionSwitch;
  }
  
  public void setLightFrequencyMode(LightFrequencyMode paramLightFrequencyMode)
  {
    this.lightFrequencyMode = paramLightFrequencyMode;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setNetworkInfo(NetworkInfoCache paramNetworkInfoCache)
  {
    this.networkInfo = paramNetworkInfoCache;
  }
  
  public void setOsdConfig(OsdInfoCache paramOsdInfoCache)
  {
    this.osdConfig = paramOsdInfoCache;
  }
  
  public void setRebootConfig(RebootInfoCache paramRebootInfoCache)
  {
    this.rebootInfoCache = paramRebootInfoCache;
  }
  
  public void setRecordEnable(String paramString)
  {
    this.recordEnable = OptionSwitch.fromString(paramString);
  }
  
  public void setRecordEnable(boolean paramBoolean)
  {
    OptionSwitch localOptionSwitch;
    if (paramBoolean) {
      localOptionSwitch = OptionSwitch.ON;
    } else {
      localOptionSwitch = OptionSwitch.OFF;
    }
    this.recordEnable = localOptionSwitch;
  }
  
  public void setResolutionType(ResolutionType paramResolutionType)
  {
    this.resolutionType = paramResolutionType;
  }
  
  public void setResolutionTypes(List<ResolutionType> paramList)
  {
    this.resolutionTypes = paramList;
  }
  
  public void setSdCardInfoCache(SdCardInfoCache paramSdCardInfoCache)
  {
    this.sdCardInfoCache = paramSdCardInfoCache;
    if ((TextUtils.equals(paramSdCardInfoCache.getTotalSpace(), paramSdCardInfoCache.getUsedSpace())) && (paramSdCardInfoCache.getStatus() == SdCardStatus.NORMAL)) {
      paramSdCardInfoCache.setStatus(SdCardStatus.FULL);
    }
  }
  
  public void setTapoCareNeedPayFunctionList(ServiceList paramServiceList)
  {
    this.tapoCareNeedPayFunctionList = paramServiceList;
  }
  
  public void setTimezone(String paramString1, String paramString2)
  {
    this.timezone = paramString1;
    this.zoneId = paramString2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\SettingsData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */