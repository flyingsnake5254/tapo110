package com.tplink.libtpnetwork.cameranetwork.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.d.w.h.a;
import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.BaseDeviceCache;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.cameranetwork.model.BasicInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.LastAlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.P2PSharePwd;
import com.tplink.libtpnetwork.cameranetwork.model.PubIp;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpCommStatus;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpInfo;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpPsk;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpStatus;
import com.tplink.libtpnetwork.cameranetwork.util.f;
import com.tplink.libtpnetwork.enumerate.EnumDeviceStatus;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.tdp.bean.BaseTDPDevice;
import java.io.Serializable;

public class ALCameraDevice
  extends BaseALIoTDevice<TDPCameraDevice>
  implements Serializable
{
  private static final int LOCAL_TLL = 3;
  private CameraBasicInfo cameraBasicInfo;
  private boolean isDataFromThing;
  private boolean isLocal;
  private int localTLL;
  private P2PSharePwd p2pSharePwd;
  private PubIp pubIp;
  private ThingDevice thingDevice;
  private UpnpCommStatus upnpCommStatus;
  private UpnpInfo upnpInfo;
  private UpnpPsk upnpPsk;
  private UpnpStatus upnpStatus;
  
  public ALCameraDevice()
  {
    this.isDataFromThing = false;
  }
  
  public ALCameraDevice(TDPCameraDevice paramTDPCameraDevice)
  {
    super(paramTDPCameraDevice);
    int i = 0;
    this.isDataFromThing = false;
    boolean bool;
    if (paramTDPCameraDevice != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.isLocal = bool;
    if (paramTDPCameraDevice != null) {
      i = 3;
    }
    this.localTLL = i;
  }
  
  public ALCameraDevice(ThingDevice paramThingDevice)
  {
    this.isDataFromThing = false;
    this.thingDevice = paramThingDevice;
  }
  
  public ALCameraDevice(TCDeviceBean paramTCDeviceBean)
  {
    super(paramTCDeviceBean);
    this.isDataFromThing = false;
  }
  
  public ALCameraDevice(CameraDeviceCache paramCameraDeviceCache)
  {
    int i = 0;
    this.isDataFromThing = false;
    DeviceInfoResult localDeviceInfoResult = paramCameraDeviceCache.getCloudIoTDevice();
    if (localDeviceInfoResult != null) {
      super.setCloudIoTDevice(new TCDeviceBean(localDeviceInfoResult));
    }
    setCameraBasicInfo(paramCameraDeviceCache.getCameraBasicInfo());
    if (paramCameraDeviceCache.getThingDevice() != null) {
      this.thingDevice = paramCameraDeviceCache.getThingDevice();
    }
    paramCameraDeviceCache = this.tdpIoTDevice;
    boolean bool;
    if (paramCameraDeviceCache != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.isLocal = bool;
    if (paramCameraDeviceCache != null) {
      i = 3;
    }
    this.localTLL = i;
    this.isBackupFromCache = true;
  }
  
  private long getLongValue(String paramString)
  {
    long l;
    try
    {
      l = Long.valueOf(paramString).longValue();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      l = 0L;
    }
    return l;
  }
  
  public void ageLocalDevice()
  {
    int i = this.localTLL - 1;
    this.localTLL = i;
    if (i <= 0) {
      this.localTLL = 0;
    }
  }
  
  public ALCameraDevice clone()
  {
    ALCameraDevice localALCameraDevice = new ALCameraDevice();
    Object localObject1 = this.cloudIoTDevice;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((TCDeviceBean)localObject1).clone();
    } else {
      localObject1 = null;
    }
    localALCameraDevice.cloudIoTDevice = ((TCDeviceBean)localObject1);
    localObject1 = this.tdpIoTDevice;
    if (localObject1 != null) {
      localObject1 = ((TDPCameraDevice)localObject1).clone();
    } else {
      localObject1 = null;
    }
    localALCameraDevice.tdpIoTDevice = ((TDPIoTDevice)localObject1);
    localALCameraDevice.deviceState = this.deviceState;
    localALCameraDevice.isBackupFromCache = this.isBackupFromCache;
    CameraBasicInfo localCameraBasicInfo = this.cameraBasicInfo;
    localObject1 = localObject2;
    if (localCameraBasicInfo != null) {
      localObject1 = localCameraBasicInfo.clone();
    }
    localALCameraDevice.cameraBasicInfo = ((CameraBasicInfo)localObject1);
    localALCameraDevice.isLocal = this.isLocal;
    return localALCameraDevice;
  }
  
  public String getAppServerUrl()
  {
    TCDeviceBean localTCDeviceBean = this.cloudIoTDevice;
    if (localTCDeviceBean != null) {
      return localTCDeviceBean.getAppServerUrl();
    }
    return "";
  }
  
  public CameraBasicInfo getBasicInfo()
  {
    return this.cameraBasicInfo;
  }
  
  public int getBindCount()
  {
    return 0;
  }
  
  public int getBrightness()
  {
    return 0;
  }
  
  @Nullable
  public CameraAvatarInfo getCameraAvatarInfo()
  {
    Object localObject = this.cameraBasicInfo;
    if (localObject != null) {
      localObject = ((CameraBasicInfo)localObject).getCameraAvatarInfo();
    } else {
      localObject = null;
    }
    return (CameraAvatarInfo)localObject;
  }
  
  public CameraBasicInfo getCameraBasicInfo()
  {
    return this.cameraBasicInfo;
  }
  
  public CameraComponent getCameraComponent()
  {
    CameraBasicInfo localCameraBasicInfo = this.cameraBasicInfo;
    if ((localCameraBasicInfo != null) && (localCameraBasicInfo.getCameraComponent() != null)) {
      return this.cameraBasicInfo.getCameraComponent();
    }
    return null;
  }
  
  @Nullable
  public String getCategory()
  {
    Object localObject = this.thingDevice;
    if (localObject != null) {
      localObject = ((ThingDevice)localObject).getCategory();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public TCDeviceBean getCloudCameraDevice()
  {
    return this.cloudIoTDevice;
  }
  
  public int getColorTemp()
  {
    return 0;
  }
  
  public String getCustomLocationUrl()
  {
    Object localObject = this.cameraBasicInfo;
    if (localObject != null) {
      localObject = ((CameraBasicInfo)localObject).getCustomLocationUrl();
    } else {
      localObject = "";
    }
    return (String)localObject;
  }
  
  public String getDeviceAlias()
  {
    return getDeviceName();
  }
  
  public String getDeviceFwVer()
  {
    return getSoftwareVersion();
  }
  
  public String getDeviceHwVer()
  {
    return getHardwareVersion();
  }
  
  public String getDeviceIcon()
  {
    if (isFirmwareSupportIoTCloud()) {
      return this.cameraBasicInfo.getAvatar();
    }
    CameraBasicInfo localCameraBasicInfo = this.cameraBasicInfo;
    if ((localCameraBasicInfo != null) && (localCameraBasicInfo.getAvatarName() != null)) {
      return this.cameraBasicInfo.getAvatarName();
    }
    return null;
  }
  
  public String getDeviceId()
  {
    Object localObject = this.cameraBasicInfo;
    if ((localObject != null) && (((CameraBasicInfo)localObject).getDeviceId() != null)) {
      return this.cameraBasicInfo.getDeviceId();
    }
    localObject = this.cloudIoTDevice;
    if ((localObject != null) && (((TCDeviceBean)localObject).getDeviceId() != null)) {
      return this.cloudIoTDevice.getDeviceId();
    }
    localObject = this.tdpIoTDevice;
    if ((localObject != null) && (((TDPCameraDevice)localObject).getDeviceId() != null)) {
      return ((TDPCameraDevice)this.tdpIoTDevice).getDeviceId();
    }
    localObject = this.thingDevice;
    if ((localObject != null) && (((ThingDevice)localObject).getThingName() != null)) {
      return this.thingDevice.getThingName();
    }
    return "";
  }
  
  public String getDeviceIdMD5()
  {
    Object localObject = this.cameraBasicInfo;
    if ((localObject != null) && (((CameraBasicInfo)localObject).getDeviceId() != null)) {
      return a.g(this.cameraBasicInfo.getDeviceId());
    }
    localObject = this.cloudIoTDevice;
    if ((localObject != null) && (!TextUtils.isEmpty(((TCDeviceBean)localObject).getDeviceId()))) {
      return a.g(this.cloudIoTDevice.getDeviceId());
    }
    localObject = this.tdpIoTDevice;
    if ((localObject != null) && (!TextUtils.isEmpty(((TDPCameraDevice)localObject).getDeviceId()))) {
      return a.g(((TDPCameraDevice)this.tdpIoTDevice).getDeviceId());
    }
    localObject = this.thingDevice;
    if ((localObject != null) && (((ThingDevice)localObject).getThingName() != null)) {
      return a.g(this.thingDevice.getThingName());
    }
    return "";
  }
  
  public String getDeviceLocation()
  {
    boolean bool = isFirmwareSupportIoTCloud();
    String str = "";
    if (bool)
    {
      CameraBasicInfo localCameraBasicInfo = this.cameraBasicInfo;
      localObject = str;
      if (localCameraBasicInfo != null)
      {
        localObject = str;
        if (localCameraBasicInfo.getAvatar() != null) {
          localObject = this.cameraBasicInfo.getAvatar();
        }
      }
      return (String)localObject;
    }
    Object localObject = this.cameraBasicInfo;
    if (localObject != null) {
      localObject = ((CameraBasicInfo)localObject).getDeviceLocation();
    } else {
      localObject = "";
    }
    return getSuitableValue((String)localObject, "", "", "");
  }
  
  public String getDeviceMac()
  {
    return f.a(getMacAddress());
  }
  
  public String getDeviceModel()
  {
    Object localObject1 = this.cloudIoTDevice;
    String str = null;
    if (localObject1 != null) {
      localObject1 = ((TCDeviceBean)localObject1).getDeviceModel();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.cameraBasicInfo;
    if (localObject2 != null) {
      localObject2 = ((CameraBasicInfo)localObject2).getDeviceModel();
    } else {
      localObject2 = null;
    }
    Object localObject3 = this.thingDevice;
    if (localObject3 != null) {
      localObject3 = ((ThingDevice)localObject3).getModel();
    } else {
      localObject3 = null;
    }
    TDPIoTDevice localTDPIoTDevice = this.tdpIoTDevice;
    if (localTDPIoTDevice != null) {
      str = ((TDPCameraDevice)localTDPIoTDevice).getDeviceModel();
    }
    return getSuitableValue((String)localObject1, (String)localObject2, (String)localObject3, str, "");
  }
  
  public String getDeviceName()
  {
    Object localObject1 = this.tdpIoTDevice;
    String str = null;
    if (localObject1 != null) {
      localObject1 = ((TDPCameraDevice)localObject1).getDeviceName();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.thingDevice;
    if (localObject2 != null) {
      localObject2 = ((ThingDevice)localObject2).getNickname();
    } else {
      localObject2 = null;
    }
    Object localObject3 = this.cloudIoTDevice;
    if (localObject3 != null) {
      localObject3 = ((TCDeviceBean)localObject3).getAlias();
    } else {
      localObject3 = null;
    }
    CameraBasicInfo localCameraBasicInfo = this.cameraBasicInfo;
    if (localCameraBasicInfo != null) {
      str = localCameraBasicInfo.getDeviceAlias();
    }
    return getSuitableValue((String)localObject1, (String)localObject2, (String)localObject3, str, "");
  }
  
  public String getDeviceRegion()
  {
    return "";
  }
  
  public String getDeviceType()
  {
    return EnumDeviceType.CAMERA.getDeviceType();
  }
  
  public String getDynamicLightEffectId()
  {
    return null;
  }
  
  public EnumDeviceType getEnumDeviceType()
  {
    return EnumDeviceType.CAMERA;
  }
  
  public String getFamilyId()
  {
    Object localObject = this.thingDevice;
    if (localObject != null) {
      localObject = ((ThingDevice)localObject).getFamilyId();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getGuardMode()
  {
    return null;
  }
  
  public boolean getGuardOn()
  {
    return false;
  }
  
  public String getHardwareVersion()
  {
    Object localObject1 = this.cameraBasicInfo;
    String str = null;
    if (localObject1 != null) {
      localObject1 = ((CameraBasicInfo)localObject1).getHardwareVer();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.cloudIoTDevice;
    if (localObject2 != null) {
      localObject2 = ((TCDeviceBean)localObject2).getDeviceHwVer();
    } else {
      localObject2 = null;
    }
    TDPIoTDevice localTDPIoTDevice = this.tdpIoTDevice;
    if (localTDPIoTDevice != null) {
      str = ((TDPCameraDevice)localTDPIoTDevice).getHardwareVer();
    }
    return getSuitableValue((String)localObject1, (String)localObject2, str, "");
  }
  
  public int getHue()
  {
    return 0;
  }
  
  public String getHwId()
  {
    Object localObject = this.cloudIoTDevice;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((TCDeviceBean)localObject).getHwId();
    }
    return (String)localObject;
  }
  
  public String getIPAddress()
  {
    TDPIoTDevice localTDPIoTDevice = this.tdpIoTDevice;
    if ((localTDPIoTDevice != null) && (((TDPCameraDevice)localTDPIoTDevice).getIp() != null)) {
      return ((TDPCameraDevice)this.tdpIoTDevice).getIp();
    }
    return "";
  }
  
  public CameraLastEvent getLastAlarmInfo()
  {
    Object localObject = this.cameraBasicInfo;
    if (localObject != null) {
      localObject = ((CameraBasicInfo)localObject).getCameraLastEvent();
    } else {
      localObject = null;
    }
    return (CameraLastEvent)localObject;
  }
  
  public long getLastAlarmTime()
  {
    Object localObject = this.cameraBasicInfo;
    if ((localObject != null) && (((CameraBasicInfo)localObject).getLastAlarmTime() > 0L)) {
      return this.cameraBasicInfo.getLastAlarmTime();
    }
    localObject = this.tdpIoTDevice;
    if ((localObject != null) && (((TDPCameraDevice)localObject).getLastAlarmType() != null)) {
      return getLongValue(((TDPCameraDevice)this.tdpIoTDevice).getLastAlarmTime());
    }
    return 0L;
  }
  
  public String getLastAlarmType()
  {
    Object localObject = this.cameraBasicInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((CameraBasicInfo)localObject).getLastAlarmType()))) {
      return this.cameraBasicInfo.getLastAlarmType();
    }
    localObject = this.tdpIoTDevice;
    if ((localObject != null) && (((TDPCameraDevice)localObject).getLastAlarmType() != null)) {
      return ((TDPCameraDevice)this.tdpIoTDevice).getLastAlarmType();
    }
    return "";
  }
  
  public long getLatestLogTimestamp()
  {
    return 0L;
  }
  
  public CameraBasicInfo getLocalIoTDevice()
  {
    return this.cameraBasicInfo;
  }
  
  public String getLockMessage()
  {
    Object localObject = this.cameraBasicInfo;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((CameraBasicInfo)localObject).getLockMessage();
    }
    return (String)localObject;
  }
  
  public String getMacAddress()
  {
    Object localObject = this.cloudIoTDevice;
    if ((localObject != null) && (((TCDeviceBean)localObject).getDeviceMac() != null)) {
      return this.cloudIoTDevice.getDeviceMac();
    }
    localObject = this.tdpIoTDevice;
    if ((localObject != null) && (((TDPCameraDevice)localObject).getMac() != null)) {
      return ((TDPCameraDevice)this.tdpIoTDevice).getMac();
    }
    localObject = this.thingDevice;
    if ((localObject != null) && (((ThingDevice)localObject).getMac() != null)) {
      return this.thingDevice.getMac();
    }
    return "";
  }
  
  public String getModel()
  {
    return getDeviceModel();
  }
  
  public String getOemId()
  {
    Object localObject = this.cameraBasicInfo;
    if (localObject != null) {
      localObject = ((CameraBasicInfo)localObject).getOemId();
    } else {
      localObject = "";
    }
    TCDeviceBean localTCDeviceBean = this.cloudIoTDevice;
    if (localTCDeviceBean != null) {
      localObject = localTCDeviceBean.getOemId();
    }
    return (String)localObject;
  }
  
  public int getOnBoardingTime()
  {
    ThingDevice localThingDevice = this.thingDevice;
    if (localThingDevice != null) {
      return localThingDevice.getOnBoardingTime();
    }
    return 0;
  }
  
  public String getOriginalDeviceId()
  {
    return null;
  }
  
  public P2PSharePwd getP2PSharePwd()
  {
    return this.p2pSharePwd;
  }
  
  public String getParentDeviceIDMD5()
  {
    return null;
  }
  
  public String getParentDeviceId()
  {
    return null;
  }
  
  public PubIp getPubIp()
  {
    return this.pubIp;
  }
  
  public String getRoomId()
  {
    ThingDevice localThingDevice = this.thingDevice;
    if (localThingDevice != null) {
      return localThingDevice.getRoomId();
    }
    return null;
  }
  
  public int getSaturation()
  {
    return 0;
  }
  
  public String getSoftwareVersion()
  {
    Object localObject1 = this.cameraBasicInfo;
    String str = null;
    if (localObject1 != null) {
      localObject1 = ((CameraBasicInfo)localObject1).getSoftwareVer();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.cloudIoTDevice;
    if (localObject2 != null) {
      localObject2 = ((TCDeviceBean)localObject2).getFwVer();
    } else {
      localObject2 = null;
    }
    TDPIoTDevice localTDPIoTDevice = this.tdpIoTDevice;
    if (localTDPIoTDevice != null) {
      str = ((TDPCameraDevice)localTDPIoTDevice).getFirmwareVer();
    }
    return getSuitableValue((String)localObject1, (String)localObject2, str, "");
  }
  
  public String getSpecs()
  {
    return null;
  }
  
  public TDPCameraDevice getTdpCameraDevice()
  {
    return (TDPCameraDevice)this.tdpIoTDevice;
  }
  
  public ThingDevice getThingDevice()
  {
    return this.thingDevice;
  }
  
  @Nullable
  public String getThingModelId()
  {
    Object localObject = this.thingDevice;
    if (localObject != null) {
      localObject = ((ThingDevice)localObject).getThingModelId();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getThingUrl()
  {
    Object localObject = this.thingDevice;
    if (localObject != null) {
      localObject = ((ThingDevice)localObject).getThingUrl();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public UpnpCommStatus getUpnpCommStatus()
  {
    return this.upnpCommStatus;
  }
  
  public UpnpInfo getUpnpInfo()
  {
    return this.upnpInfo;
  }
  
  public UpnpPsk getUpnpPsk()
  {
    return this.upnpPsk;
  }
  
  public UpnpStatus getUpnpStatus()
  {
    return this.upnpStatus;
  }
  
  public boolean isCameraLocked()
  {
    CameraBasicInfo localCameraBasicInfo = this.cameraBasicInfo;
    boolean bool1 = true;
    if (localCameraBasicInfo != null)
    {
      bool2 = bool1;
      if (localCameraBasicInfo.getLockStatus() == 1) {
        return bool2;
      }
      if (this.cameraBasicInfo.getLockStatus() == 17) {
        return bool1;
      }
    }
    boolean bool2 = false;
    return bool2;
  }
  
  public boolean isCommonDevice()
  {
    ThingDevice localThingDevice = this.thingDevice;
    if (localThingDevice != null) {
      return localThingDevice.isCommonDevice();
    }
    return true;
  }
  
  public boolean isDataFromThing()
  {
    return false;
  }
  
  public boolean isDefaultLocation()
  {
    boolean bool1 = isFirmwareSupportIoTCloud();
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    CameraBasicInfo localCameraBasicInfo = this.cameraBasicInfo;
    bool1 = bool2;
    if (localCameraBasicInfo != null) {
      if (localCameraBasicInfo.isDefaultLocation()) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean isDeviceOn()
  {
    return false;
  }
  
  public boolean isDynamicLightEffectEnable()
  {
    return false;
  }
  
  public boolean isFirmwareSupportIoTCloud()
  {
    Object localObject = this.cameraBasicInfo;
    if ((localObject != null) && (((CameraBasicInfo)localObject).getCameraComponent() != null))
    {
      localObject = this.cameraBasicInfo.getCameraComponent();
      if (localObject != null) {
        return ((CameraComponent)localObject).isSupportIoTCloud();
      }
    }
    localObject = this.tdpIoTDevice;
    if ((localObject != null) && (((TDPCameraDevice)localObject).isSupportIoTCloud())) {
      return ((TDPCameraDevice)this.tdpIoTDevice).isSupportIoTCloud();
    }
    boolean bool;
    if (this.thingDevice != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isHasThingOrCloudDevice()
  {
    boolean bool;
    if ((this.cloudIoTDevice == null) && (this.thingDevice == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @Deprecated
  public boolean isLocal()
  {
    boolean bool;
    if ((this.isLocal) && (this.tdpIoTDevice != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isLocalOnly()
  {
    boolean bool;
    if ((this.isLocal) && (((isFirmwareSupportIoTCloud()) && (this.thingDevice == null)) || ((!isFirmwareSupportIoTCloud()) && (this.cloudIoTDevice == null)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isLocalStateValid()
  {
    boolean bool;
    if (this.localTLL > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public boolean isRemote()
  {
    boolean bool;
    if ((this.cloudIoTDevice == null) && (this.thingDevice == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isRemoteOnline()
  {
    Object localObject = this.cloudIoTDevice;
    if ((localObject == null) || (EnumDeviceStatus.STATUS_ONLINE != ((TCDeviceBean)localObject).getStatus()))
    {
      localObject = this.thingDevice;
      if ((localObject == null) || (!((ThingDevice)localObject).isThingOnline())) {}
    }
    else
    {
      return true;
    }
    boolean bool = false;
    return bool;
  }
  
  public boolean isRemoteOnly()
  {
    boolean bool;
    if ((!this.isLocal) && ((this.cloudIoTDevice != null) || (this.thingDevice != null))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSubDevice()
  {
    return false;
  }
  
  public boolean isSupportChild()
  {
    return false;
  }
  
  public boolean isSupportCloudConnect()
  {
    return false;
  }
  
  public boolean isSupportDeviceShare()
  {
    CameraComponent localCameraComponent = getCameraComponent();
    if (localCameraComponent != null) {
      return localCameraComponent.hasComponent(ComponentType.DEVICE_SHARE);
    }
    return false;
  }
  
  public boolean isSupportIoTCloud()
  {
    boolean bool;
    if (this.thingDevice != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSupportIoTComponent(EnumIoTComponent paramEnumIoTComponent)
  {
    return false;
  }
  
  public boolean isSupportLED()
  {
    return false;
  }
  
  public boolean isSupportSunriseSunset()
  {
    return false;
  }
  
  public boolean isThingOnline()
  {
    ThingDevice localThingDevice = this.thingDevice;
    if (localThingDevice != null) {
      return localThingDevice.isThingOnline();
    }
    return false;
  }
  
  public void setBasicInfo(BasicInfo paramBasicInfo)
  {
    if (this.cameraBasicInfo == null) {
      this.cameraBasicInfo = new CameraBasicInfo();
    }
    this.cameraBasicInfo.setBasicInfo(paramBasicInfo);
  }
  
  public void setCameraAvatar(String paramString)
  {
    if (this.cameraBasicInfo == null) {
      this.cameraBasicInfo = new CameraBasicInfo();
    }
    if (paramString != null) {
      this.cameraBasicInfo.setAvatar(paramString);
    }
  }
  
  public void setCameraAvatarInfo(CameraAvatarInfo paramCameraAvatarInfo)
  {
    if (this.cameraBasicInfo == null) {
      this.cameraBasicInfo = new CameraBasicInfo();
    }
    this.cameraBasicInfo.setCameraAvatarInfo(paramCameraAvatarInfo);
  }
  
  public void setCameraBasicInfo(CameraBasicInfo paramCameraBasicInfo)
  {
    this.cameraBasicInfo = paramCameraBasicInfo;
  }
  
  public void setCameraComponent(CameraComponent paramCameraComponent)
  {
    if (this.cameraBasicInfo == null) {
      this.cameraBasicInfo = new CameraBasicInfo();
    }
    this.cameraBasicInfo.setCameraComponent(paramCameraComponent);
  }
  
  public void setCloudIoTDevice(TCDeviceBean paramTCDeviceBean)
  {
    super.setCloudIoTDevice(paramTCDeviceBean);
  }
  
  public void setCommonDevice(boolean paramBoolean)
  {
    ThingDevice localThingDevice = this.thingDevice;
    if (localThingDevice != null) {
      localThingDevice.setCommonDevice(paramBoolean);
    }
  }
  
  public void setDataFromThing(boolean paramBoolean)
  {
    this.isDataFromThing = paramBoolean;
  }
  
  public void setDeviceAlias(String paramString)
  {
    Object localObject = this.cameraBasicInfo;
    if (localObject != null) {
      ((CameraBasicInfo)localObject).setDeviceAlias(paramString);
    }
    localObject = this.cloudIoTDevice;
    if (localObject != null) {
      ((TCDeviceBean)localObject).setAlias(paramString);
    }
  }
  
  public void setDeviceOffline()
  {
    this.isLocal = false;
    TCDeviceBean localTCDeviceBean = this.cloudIoTDevice;
    if (localTCDeviceBean != null) {
      localTCDeviceBean.setStatus(EnumDeviceStatus.STATUS_OFFLINE);
    }
  }
  
  public void setDeviceOn(boolean paramBoolean) {}
  
  public void setDeviceRemoteOffline()
  {
    TCDeviceBean localTCDeviceBean = this.cloudIoTDevice;
    if (localTCDeviceBean != null) {
      localTCDeviceBean.setStatus(EnumDeviceStatus.STATUS_OFFLINE);
    }
  }
  
  public void setLastAlarmInfo(CameraLastEvent paramCameraLastEvent)
  {
    if (this.cameraBasicInfo == null) {
      this.cameraBasicInfo = new CameraBasicInfo();
    }
    this.cameraBasicInfo.setCameraLastEvent(paramCameraLastEvent);
  }
  
  public void setLastAlarmInfo(LastAlarmInfo paramLastAlarmInfo)
  {
    if (this.cameraBasicInfo == null) {
      this.cameraBasicInfo = new CameraBasicInfo();
    }
    this.cameraBasicInfo.setCameraLastEvent(new CameraLastEvent(paramLastAlarmInfo));
  }
  
  public void setLocalIoTDevice(Object paramObject)
  {
    if ((paramObject instanceof CameraBasicInfo)) {
      this.cameraBasicInfo = ((CameraBasicInfo)paramObject);
    }
  }
  
  public void setP2PSharePwd(P2PSharePwd paramP2PSharePwd)
  {
    this.p2pSharePwd = paramP2PSharePwd;
  }
  
  public void setPubIp(PubIp paramPubIp)
  {
    this.pubIp = paramPubIp;
  }
  
  public void setTDPIoTDevice(TDPCameraDevice paramTDPCameraDevice)
  {
    super.setTDPIoTDevice(paramTDPCameraDevice);
    int i = 0;
    boolean bool;
    if (paramTDPCameraDevice != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.isLocal = bool;
    if (paramTDPCameraDevice != null) {
      i = 3;
    }
    this.localTLL = i;
  }
  
  public void setThingDevice(ThingDevice paramThingDevice)
  {
    this.thingDevice = paramThingDevice;
  }
  
  public void setUpnpCommStatus(UpnpCommStatus paramUpnpCommStatus)
  {
    this.upnpCommStatus = paramUpnpCommStatus;
  }
  
  public void setUpnpInfo(UpnpInfo paramUpnpInfo)
  {
    this.upnpInfo = paramUpnpInfo;
  }
  
  public void setUpnpPsk(UpnpPsk paramUpnpPsk)
  {
    this.upnpPsk = paramUpnpPsk;
  }
  
  public void setUpnpStatus(UpnpStatus paramUpnpStatus)
  {
    this.upnpStatus = paramUpnpStatus;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\ALCameraDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */