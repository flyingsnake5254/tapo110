package com.tplink.libtpnetwork.IoTNetwork.common;

import androidx.annotation.Nullable;
import b.d.w.h.b;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.common.ThingShadowState;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.BaseDeviceCache;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDeviceCache;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.IoTHubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.IoTPlugDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.cameranetwork.util.f;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import com.tplink.tdp.bean.BaseTDPDevice;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.lang.e;

public class ALIoTDevice
  extends BaseALIoTDevice<TDPIoTDevice>
  implements Serializable
{
  private boolean isDataFromThing = false;
  private LocalIoTBaseDevice localIoTDevice;
  private ThingDevice thingDevice;
  
  public ALIoTDevice(IoTDeviceCache paramIoTDeviceCache)
  {
    if (paramIoTDeviceCache.getCloudIoTDevice() != null) {
      this.cloudIoTDevice = new TCDeviceBean(paramIoTDeviceCache.getCloudIoTDevice());
    }
    if (paramIoTDeviceCache.getThingDevice() != null) {
      this.thingDevice = paramIoTDeviceCache.getThingDevice();
    }
    this.localIoTDevice = paramIoTDeviceCache.getLocalIoTDevice();
    this.isBackupFromCache = true;
  }
  
  public ALIoTDevice(LocalIoTBaseDevice paramLocalIoTBaseDevice)
  {
    this.localIoTDevice = paramLocalIoTBaseDevice;
  }
  
  public ALIoTDevice(TDPIoTDevice paramTDPIoTDevice)
  {
    super(paramTDPIoTDevice);
  }
  
  public ALIoTDevice(ThingDevice paramThingDevice)
  {
    this.thingDevice = paramThingDevice;
  }
  
  public ALIoTDevice(TCDeviceBean paramTCDeviceBean)
  {
    super(paramTCDeviceBean);
  }
  
  public int getBindCount()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if ((localLocalIoTBaseDevice instanceof IoTSubDevice)) {
      return ((IoTSubDevice)localLocalIoTBaseDevice).getBindCount();
    }
    return 0;
  }
  
  public int getBrightness()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if ((localLocalIoTBaseDevice instanceof IoTBulbDevice)) {
      return ((IoTBulbDevice)localLocalIoTBaseDevice).getBrightness();
    }
    if ((localLocalIoTBaseDevice instanceof IoTLightStripDevice)) {
      return ((IoTLightStripDevice)localLocalIoTBaseDevice).getBrightness();
    }
    return 0;
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
  
  public int getColorTemp()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if ((localLocalIoTBaseDevice instanceof IoTBulbDevice)) {
      return ((IoTBulbDevice)localLocalIoTBaseDevice).getColorTemp();
    }
    if ((localLocalIoTBaseDevice instanceof IoTLightStripDevice)) {
      return ((IoTLightStripDevice)localLocalIoTBaseDevice).getColorTemp();
    }
    return 0;
  }
  
  public String getDeviceFwVer()
  {
    Object localObject = this.localIoTDevice;
    String str = null;
    if (localObject != null) {
      localObject = ((LocalIoTBaseDevice)localObject).getFwVer();
    } else {
      localObject = null;
    }
    TCDeviceBean localTCDeviceBean = this.cloudIoTDevice;
    if (localTCDeviceBean != null) {
      str = localTCDeviceBean.getFwVer();
    }
    return getSuitableValue((String)localObject, str, "");
  }
  
  public String getDeviceHwVer()
  {
    Object localObject = this.cloudIoTDevice;
    String str = null;
    if (localObject != null) {
      localObject = ((TCDeviceBean)localObject).getDeviceHwVer();
    } else {
      localObject = null;
    }
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      str = localLocalIoTBaseDevice.getHwVer();
    }
    return getSuitableValue((String)localObject, str, "");
  }
  
  public String getDeviceIcon()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if ((localLocalIoTBaseDevice != null) && (localLocalIoTBaseDevice.getAvatar() != null)) {
      return this.localIoTDevice.getAvatar();
    }
    return null;
  }
  
  public String getDeviceId()
  {
    return getThingName();
  }
  
  public String getDeviceIdMD5()
  {
    Object localObject = this.localIoTDevice;
    if ((localObject != null) && (!b.d(((LocalIoTBaseDevice)localObject).getDeviceId()))) {
      return b.d.w.h.a.g(this.localIoTDevice.getDeviceId());
    }
    localObject = this.thingDevice;
    if ((localObject != null) && (!b.d(((ThingDevice)localObject).getThingName()))) {
      return b.d.w.h.a.g(this.thingDevice.getThingName());
    }
    localObject = this.cloudIoTDevice;
    if ((localObject != null) && (!b.d(((TCDeviceBean)localObject).getDeviceId()))) {
      return b.d.w.h.a.g(this.cloudIoTDevice.getDeviceId());
    }
    localObject = this.tdpIoTDevice;
    if ((localObject != null) && (!b.d(((TDPIoTDevice)localObject).getDeviceIdMd5()))) {
      return this.tdpIoTDevice.getDeviceIdMd5();
    }
    return "";
  }
  
  public String getDeviceLocation()
  {
    Object localObject = this.localIoTDevice;
    if (localObject != null) {
      localObject = ((LocalIoTBaseDevice)localObject).getLocation();
    } else {
      localObject = "";
    }
    return (String)localObject;
  }
  
  public String getDeviceMac()
  {
    Object localObject1 = this.cloudIoTDevice;
    String str = null;
    if (localObject1 != null) {
      localObject1 = ((TCDeviceBean)localObject1).getDeviceMac();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.localIoTDevice;
    if (localObject2 != null) {
      localObject2 = ((LocalIoTBaseDevice)localObject2).getMac();
    } else {
      localObject2 = null;
    }
    Object localObject3 = this.tdpIoTDevice;
    if (localObject3 != null) {
      localObject3 = ((BaseTDPDevice)localObject3).getMac();
    } else {
      localObject3 = null;
    }
    ThingDevice localThingDevice = this.thingDevice;
    if (localThingDevice != null) {
      str = localThingDevice.getMac();
    }
    return f.a(getSuitableValue((String)localObject1, (String)localObject2, (String)localObject3, str, ""));
  }
  
  public String getDeviceModel()
  {
    Object localObject1 = this.cloudIoTDevice;
    String str = null;
    if (localObject1 != null) {
      localObject1 = ((TCDeviceBean)localObject1).getDeviceName();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.localIoTDevice;
    if (localObject2 != null) {
      localObject2 = ((LocalIoTBaseDevice)localObject2).getModel();
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
      str = localTDPIoTDevice.getDeviceModel();
    }
    return getSuitableValue((String)localObject1, (String)localObject2, (String)localObject3, str, "");
  }
  
  public String getDeviceName()
  {
    Object localObject = this.localIoTDevice;
    if ((localObject != null) && (!b.d(((LocalIoTBaseDevice)localObject).getNickname()))) {
      return this.localIoTDevice.getNickname();
    }
    localObject = this.thingDevice;
    if ((localObject != null) && (!b.d(((ThingDevice)localObject).getNickname()))) {
      return this.thingDevice.getNickname();
    }
    localObject = this.cloudIoTDevice;
    if ((localObject != null) && (!b.d(((TCDeviceBean)localObject).getAlias()))) {
      try
      {
        localObject = b.d.w.h.a.a(this.cloudIoTDevice.getAlias());
        return (String)localObject;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Base64 decode error. Origin string: ");
        ((StringBuilder)localObject).append(this.cloudIoTDevice.getAlias());
        b.d.w.c.a.d(((StringBuilder)localObject).toString());
        localIllegalArgumentException.printStackTrace();
      }
    }
    return "";
  }
  
  public String getDeviceRegion()
  {
    Object localObject = this.localIoTDevice;
    if ((localObject != null) && (!e.a(((LocalIoTBaseDevice)localObject).getRegion()))) {
      return this.localIoTDevice.getRegion();
    }
    localObject = this.thingDevice;
    if ((localObject != null) && (((ThingDevice)localObject).getThingInfo() != null) && (!e.a(this.thingDevice.getThingInfo().getRegion()))) {
      return this.thingDevice.getThingInfo().getRegion();
    }
    return "";
  }
  
  public String getDeviceType()
  {
    Object localObject1 = this.cloudIoTDevice;
    String str = null;
    if (localObject1 != null) {
      localObject1 = ((TCDeviceBean)localObject1).getDeviceType();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.thingDevice;
    if (localObject2 != null) {
      localObject2 = ((ThingDevice)localObject2).getDeviceType();
    } else {
      localObject2 = null;
    }
    Object localObject3 = this.tdpIoTDevice;
    if (localObject3 != null) {
      localObject3 = ((TDPIoTDevice)localObject3).getDeviceType();
    } else {
      localObject3 = null;
    }
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      str = localLocalIoTBaseDevice.getType();
    }
    return getSuitableValue((String)localObject1, (String)localObject2, (String)localObject3, str, "");
  }
  
  public String getDynamicLightEffectId()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if ((localLocalIoTBaseDevice instanceof IoTBulbDevice)) {
      return ((IoTBulbDevice)localLocalIoTBaseDevice).getDynamicLightEffectId();
    }
    return null;
  }
  
  public EnumDeviceType getEnumDeviceType()
  {
    return EnumDeviceType.fromType(getDeviceType());
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
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if ((localLocalIoTBaseDevice instanceof IoTHubDevice)) {
      return ((IoTHubDevice)localLocalIoTBaseDevice).getGuardMode();
    }
    return null;
  }
  
  public boolean getGuardOn()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if ((localLocalIoTBaseDevice instanceof IoTHubDevice)) {
      return ((IoTHubDevice)localLocalIoTBaseDevice).isGuardOn();
    }
    return false;
  }
  
  public int getHue()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if ((localLocalIoTBaseDevice instanceof IoTBulbDevice)) {
      return ((IoTBulbDevice)localLocalIoTBaseDevice).getHue();
    }
    if ((localLocalIoTBaseDevice instanceof IoTLightStripDevice)) {
      return ((IoTLightStripDevice)localLocalIoTBaseDevice).getHue();
    }
    return 0;
  }
  
  public String getLang()
  {
    Object localObject = this.localIoTDevice;
    if ((localObject != null) && (((LocalIoTBaseDevice)localObject).getLang() != null)) {
      return this.localIoTDevice.getLang();
    }
    localObject = this.thingDevice;
    if (localObject != null) {
      localObject = ((ThingDevice)localObject).getLang();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public long getLatestLogTimestamp()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if ((localLocalIoTBaseDevice instanceof IoTSubDevice)) {
      return ((IoTSubDevice)localLocalIoTBaseDevice).getLatestLogTimestamp();
    }
    return 0L;
  }
  
  public LocalIoTBaseDevice getLocalIoTDevice()
  {
    return this.localIoTDevice;
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
    Object localObject = this.localIoTDevice;
    if ((localObject instanceof IoTSubDevice))
    {
      localObject = ((IoTSubDevice)localObject).getOriginalDeviceId();
      if (!e.a((String)localObject)) {
        return (String)localObject;
      }
    }
    return "";
  }
  
  public String getParentDeviceIDMD5()
  {
    Object localObject = this.localIoTDevice;
    if ((localObject != null) && (!b.d(((LocalIoTBaseDevice)localObject).getParentDeviceId()))) {
      return b.d.w.h.a.g(this.localIoTDevice.getParentDeviceId());
    }
    localObject = this.thingDevice;
    if ((localObject != null) && (!e.a(((ThingDevice)localObject).getEdgeThingName()))) {
      return b.d.w.h.a.g(this.thingDevice.getEdgeThingName());
    }
    return "";
  }
  
  public String getParentDeviceId()
  {
    Object localObject = this.localIoTDevice;
    if ((localObject != null) && (!b.d(((LocalIoTBaseDevice)localObject).getParentDeviceId()))) {
      return this.localIoTDevice.getParentDeviceId();
    }
    localObject = this.thingDevice;
    if ((localObject != null) && (!e.a(((ThingDevice)localObject).getEdgeThingName()))) {
      return this.thingDevice.getEdgeThingName();
    }
    return "";
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
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if ((localLocalIoTBaseDevice instanceof IoTBulbDevice)) {
      return ((IoTBulbDevice)localLocalIoTBaseDevice).getSaturation();
    }
    if ((localLocalIoTBaseDevice instanceof IoTLightStripDevice)) {
      return ((IoTLightStripDevice)localLocalIoTBaseDevice).getSaturation();
    }
    return 0;
  }
  
  public String getSpecs()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.getSpecs();
    }
    return null;
  }
  
  public ThingDevice getThingDevice()
  {
    return this.thingDevice;
  }
  
  @Deprecated
  public String getThingGatewayUrl()
  {
    Object localObject = this.thingDevice;
    if (localObject != null) {
      localObject = ((ThingDevice)localObject).getThingGatewayUrl();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String getThingGatewayUrlV2()
  {
    Object localObject = this.thingDevice;
    if (localObject != null) {
      localObject = ((ThingDevice)localObject).getThingGatewayUrlV2();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
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
  
  public String getThingName()
  {
    Object localObject = this.localIoTDevice;
    if ((localObject != null) && (!b.d(((LocalIoTBaseDevice)localObject).getDeviceId()))) {
      return this.localIoTDevice.getDeviceId();
    }
    localObject = this.thingDevice;
    if ((localObject != null) && (!b.d(((ThingDevice)localObject).getThingName()))) {
      return this.thingDevice.getThingName();
    }
    localObject = this.cloudIoTDevice;
    if ((localObject != null) && (!b.d(((TCDeviceBean)localObject).getDeviceId()))) {
      return this.cloudIoTDevice.getDeviceId();
    }
    return "";
  }
  
  public ThingSetting getThingSetting()
  {
    Object localObject = this.thingDevice;
    if (localObject != null) {
      localObject = ((ThingDevice)localObject).getThingSetting();
    } else {
      localObject = null;
    }
    return (ThingSetting)localObject;
  }
  
  public ThingShadow getThingShadow()
  {
    Object localObject = this.thingDevice;
    if (localObject != null) {
      localObject = ((ThingDevice)localObject).getThingShadow();
    } else {
      localObject = null;
    }
    return (ThingShadow)localObject;
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
    return this.isDataFromThing;
  }
  
  public boolean isDeviceOn()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.isDeviceOn();
    }
    return false;
  }
  
  public boolean isDynamicLightEffectEnable()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if ((localLocalIoTBaseDevice instanceof IoTBulbDevice)) {
      return ((IoTBulbDevice)localLocalIoTBaseDevice).isDynamicLightEffectEnable();
    }
    return false;
  }
  
  public boolean isFirmwareSupportIoTCloud()
  {
    boolean bool1 = isBulb();
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    TDPIoTDevice localTDPIoTDevice = this.tdpIoTDevice;
    if (localTDPIoTDevice != null) {
      return localTDPIoTDevice.isSupportIoTCloud();
    }
    if (this.thingDevice == null) {
      bool2 = false;
    }
    return bool2;
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
  
  public boolean isPlugP105OfJP()
  {
    if (!"P105".equals(getDeviceModel())) {
      return false;
    }
    Object localObject = this.localIoTDevice;
    if (((localObject instanceof IoTPlugDevice)) && ("JP".equals(((LocalIoTBaseDevice)localObject).getSpecs()))) {
      return true;
    }
    localObject = this.cloudIoTDevice;
    return (localObject != null) && (((TCDeviceBean)localObject).getDeviceModel() != null) && (this.cloudIoTDevice.getDeviceModel().contains("JP"));
  }
  
  public boolean isSubDevice()
  {
    if (!e.a(getParentDeviceId())) {
      return true;
    }
    ThingDevice localThingDevice = this.thingDevice;
    if (localThingDevice != null) {
      return localThingDevice.isSubThing();
    }
    return false;
  }
  
  public boolean isSupportChild()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.isSupportChild();
    }
    return false;
  }
  
  public boolean isSupportCloudConnect()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.isSupportCloudConnect();
    }
    return false;
  }
  
  public boolean isSupportColorAndColorTemp()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.isSupportColorAndColorTemp();
    }
    return false;
  }
  
  public boolean isSupportDefaultStates()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.isSupportDefaultStates();
    }
    return false;
  }
  
  public boolean isSupportDeviceLocalTime()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.isSupportComponent(EnumIoTComponent.DEVICE_LOCAL_TIME);
    }
    return false;
  }
  
  public boolean isSupportDeviceShare()
  {
    return true;
  }
  
  public boolean isSupportFirmware()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.isSupportFirmware();
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
  
  public boolean isSupportIoTCloudComponent()
  {
    if (this.localIoTDevice != null)
    {
      if (isBulb()) {
        return true;
      }
      return this.localIoTDevice.isSupportIoTCloudComponent();
    }
    return false;
  }
  
  public boolean isSupportIoTComponent(EnumIoTComponent paramEnumIoTComponent)
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.isSupportComponent(paramEnumIoTComponent);
    }
    return false;
  }
  
  public boolean isSupportLED()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.isSupportLED();
    }
    return false;
  }
  
  public boolean isSupportLightEffect()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.isSupportComponent(EnumIoTComponent.LIGHT_EFFECT);
    }
    return false;
  }
  
  public boolean isSupportSunriseSunset()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.isSupportSunriseSunset();
    }
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
  
  public void setDeviceOn(boolean paramBoolean)
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    if (localLocalIoTBaseDevice != null) {
      localLocalIoTBaseDevice.setDeviceOn(paramBoolean);
    }
  }
  
  public void setLocalIoTDevice(LocalIoTBaseDevice paramLocalIoTBaseDevice)
  {
    this.localIoTDevice = paramLocalIoTBaseDevice;
  }
  
  public void setLocalIoTDevice(Object paramObject)
  {
    if ((paramObject instanceof LocalIoTBaseDevice)) {
      this.localIoTDevice = ((LocalIoTBaseDevice)paramObject);
    }
  }
  
  public void setThingDevice(ThingDevice paramThingDevice)
  {
    if (paramThingDevice == null)
    {
      this.thingDevice = null;
      return;
    }
    ThingDevice localThingDevice = this.thingDevice;
    this.thingDevice = paramThingDevice;
    if ((paramThingDevice.getThingShadow() == null) && (localThingDevice != null) && (localThingDevice.getThingShadow() != null)) {
      this.thingDevice.setThingShadow(localThingDevice.getThingShadow());
    }
    if ((this.thingDevice.getThingSetting() == null) && (localThingDevice != null) && (localThingDevice.getThingSetting() != null)) {
      this.thingDevice.setThingSetting(localThingDevice.getThingSetting());
    }
  }
  
  public void setThingSetting(ThingSetting paramThingSetting)
  {
    ThingDevice localThingDevice = this.thingDevice;
    if (localThingDevice != null) {
      localThingDevice.setThingSetting(paramThingSetting);
    }
  }
  
  public void setThingShadow(ThingShadow paramThingShadow)
  {
    ThingDevice localThingDevice = this.thingDevice;
    if (localThingDevice != null) {
      localThingDevice.setThingShadow(paramThingShadow);
    }
    if ((this.localIoTDevice != null) && (paramThingShadow != null) && (paramThingShadow.getState() != null)) {
      this.localIoTDevice.updateDeviceShadow(paramThingShadow.getState().getReported());
    }
  }
  
  public void updateIoTDeviceStateOnline()
  {
    if ((this.isDataFromThing) && (!this.thingDevice.isThingOnline())) {
      setDeviceState(EnumIoTDeviceState.OFFLINE);
    } else {
      setDeviceState(EnumIoTDeviceState.ONLINE);
    }
  }
  
  public void updateLocalIoTDevice(LocalIoTBaseDevice paramLocalIoTBaseDevice)
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = this.localIoTDevice;
    this.localIoTDevice = paramLocalIoTBaseDevice;
    if ((paramLocalIoTBaseDevice != null) && (paramLocalIoTBaseDevice.getComponents() == null) && (localLocalIoTBaseDevice != null) && (localLocalIoTBaseDevice.getComponents() != null)) {
      this.localIoTDevice.setComponents(localLocalIoTBaseDevice.getComponents());
    }
    updateIoTDeviceStateOnline();
  }
  
  public void updateThingShadow(long paramLong, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    Object localObject = this.thingDevice;
    if (localObject != null) {
      ((ThingDevice)localObject).updateThingShadow(paramLong, paramMap1, paramMap2);
    }
    localObject = getThingShadow();
    if ((this.localIoTDevice != null) && (localObject != null) && (paramLong >= ((ThingShadow)localObject).getVersion()))
    {
      localObject = this.localIoTDevice;
      if (paramMap2 != null) {
        paramMap1 = paramMap2;
      }
      ((LocalIoTBaseDevice)localObject).updateDeviceShadow(paramMap1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\common\ALIoTDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */