package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.d.w.c.a;
import com.google.gson.k;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingProperty;
import com.tplink.iot.cloud.bean.thing.common.ThingPropertySpec;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.common.ThingShadowState;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DefaultStatesStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightStripDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.result.LightStripDeviceRunningInfoResult;
import com.tplink.libtpnetwork.Utils.l;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import java.util.Map;

public class IoTLightStripDevice
  extends LocalIoTBaseDevice
{
  private transient boolean autoEnable;
  private transient String autoMode;
  private int brightness;
  @c("color_temp")
  private int colorTemp;
  @c("color_temp_range")
  @Nullable
  private int[] colorTempRange;
  private int hue;
  @c("lighting_effect")
  @Nullable
  private LightingEffectData lightingEffectData;
  @c("music_rhythm_enable")
  private Boolean musicRhythmEnable;
  @c("music_rhythm_mode")
  @Nullable
  private String musicRhythmMode;
  private int saturation;
  private transient int segments;
  
  public IoTLightStripDevice() {}
  
  public IoTLightStripDevice(ThingDetail paramThingDetail, ThingSetting paramThingSetting, ThingShadowResult paramThingShadowResult, ThingModel paramThingModel)
  {
    this.deviceId = paramThingShadowResult.getThingName();
    this.type = paramThingDetail.getDeviceType();
    this.model = paramThingDetail.getModel();
    this.ssid = paramThingDetail.getSsid();
    this.mac = paramThingDetail.getMac();
    this.hwVer = paramThingDetail.getHwVer();
    this.hwId = paramThingDetail.getHwId();
    this.fwVer = paramThingDetail.getFwVer();
    this.fwId = paramThingDetail.getFwId();
    this.oemId = paramThingDetail.getOemId();
    this.ip = paramThingDetail.getIp();
    this.nickname = paramThingSetting.getNickname();
    this.avatar = paramThingSetting.getAvatarUrl();
    this.longitude = paramThingSetting.getLongitude();
    paramThingDetail = paramThingSetting.getLatitude();
    this.latitude = paramThingDetail;
    Integer localInteger = this.longitude;
    boolean bool1 = true;
    boolean bool2;
    if ((localInteger != null) && (paramThingDetail != null) && (Math.abs(localInteger.intValue()) <= 1800000) && (Math.abs(this.latitude.intValue()) <= 900000)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.hasSetLocationInfo = bool2;
    this.timeDiff = paramThingSetting.getTimeDiff().intValue();
    this.region = paramThingSetting.getRegion();
    this.lang = paramThingSetting.getLang();
    if (paramThingSetting.getDefaultStates() != null)
    {
      paramThingDetail = paramThingSetting.getDefaultStates();
      this.defaultStates = new DefaultStatesBean(paramThingDetail.c().n("type").e(), (DefaultStatesStateBean)com.tplink.libtpnetwork.Utils.i.a(paramThingDetail.c().n("state"), DefaultStatesStateBean.class));
    }
    if (paramThingModel != null)
    {
      paramThingDetail = paramThingModel.getThingProperty("on");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if (((paramThingDetail instanceof Boolean)) && (((Boolean)paramThingDetail).booleanValue())) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        this.deviceOn = bool2;
      }
      paramThingDetail = paramThingModel.getThingProperty("brightness");
      int i;
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          i = ((Number)paramThingDetail).intValue();
        } else {
          i = 0;
        }
        this.brightness = i;
      }
      paramThingDetail = paramThingModel.getThingProperty("hue");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          i = ((Number)paramThingDetail).intValue();
        } else {
          i = 0;
        }
        this.hue = i;
      }
      paramThingDetail = paramThingModel.getThingProperty("saturation");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          i = ((Number)paramThingDetail).intValue();
        } else {
          i = 0;
        }
        this.saturation = i;
      }
      paramThingSetting = paramThingModel.getThingProperty("color_temp");
      if (paramThingSetting != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingSetting);
        if ((paramThingDetail instanceof Number)) {
          i = ((Number)paramThingDetail).intValue();
        } else {
          i = 0;
        }
        this.colorTemp = i;
        if (paramThingSetting.getSpecs() != null)
        {
          int j = (int)paramThingSetting.getSpecs().getMin();
          i = (int)paramThingSetting.getSpecs().getMax();
          if ((j != 0) && (i != 0) && (j <= i)) {
            this.colorTempRange = new int[] { j, i };
          }
        }
      }
      paramThingDetail = paramThingModel.getThingProperty("auto");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if (((paramThingDetail instanceof Boolean)) && (((Boolean)paramThingDetail).booleanValue())) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        this.autoEnable = bool2;
      }
      paramThingDetail = paramThingModel.getThingProperty("auto_mode");
      if (paramThingDetail != null) {
        this.autoMode = ((String)paramThingShadowResult.getReportedValue(paramThingDetail));
      }
      paramThingDetail = paramThingModel.getThingProperty("music_rhythm_enable");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if (((paramThingDetail instanceof Boolean)) && (((Boolean)paramThingDetail).booleanValue())) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
        this.musicRhythmEnable = Boolean.valueOf(bool2);
      }
      paramThingDetail = paramThingModel.getThingProperty("music_rhythm_mode");
      if (paramThingDetail != null) {
        this.musicRhythmMode = ((String)paramThingShadowResult.getReportedValue(paramThingDetail));
      }
      if (paramThingModel.getThingProperty("lighting_effect") != null)
      {
        if ((paramThingShadowResult.getState() != null) && (paramThingShadowResult.getState().getReported() != null)) {
          paramThingDetail = paramThingShadowResult.getState().getReported().get("lighting_effect");
        } else {
          paramThingDetail = null;
        }
        paramThingDetail = LightingEffectData.resolveObject(paramThingDetail);
        if (paramThingDetail != null)
        {
          paramThingShadowResult = paramThingDetail.bAdjusted;
          if (paramThingShadowResult != null)
          {
            paramThingSetting = paramThingDetail.brightness;
            if (paramThingSetting != null)
            {
              paramThingModel = this.lightingEffectData;
              if (paramThingModel != null)
              {
                paramThingModel.brightness = paramThingSetting;
                break label843;
              }
            }
          }
          if (paramThingShadowResult == null) {
            this.lightingEffectData = paramThingDetail;
          } else {
            this.lightingEffectData = null;
          }
        }
        else
        {
          this.lightingEffectData = null;
        }
        label843:
        paramThingSetting = new StringBuilder();
        paramThingSetting.append("IoTLightStripDevice lightingEffect from shadow: ");
        paramThingSetting.append(l.c(paramThingDetail));
        a.n("LightStrip", paramThingSetting.toString());
      }
    }
  }
  
  public String getAutoMode()
  {
    return this.autoMode;
  }
  
  public int getBrightness()
  {
    return this.brightness;
  }
  
  public int getColorTemp()
  {
    return this.colorTemp;
  }
  
  @Nullable
  public int[] getColorTempRange()
  {
    return this.colorTempRange;
  }
  
  public DeviceInfoParams getDeviceInfoParams()
  {
    LightStripDeviceInfoParams localLightStripDeviceInfoParams = new LightStripDeviceInfoParams();
    localLightStripDeviceInfoParams.setNickname(this.nickname);
    localLightStripDeviceInfoParams.setAvatar(this.avatar);
    localLightStripDeviceInfoParams.setDeviceOn(Boolean.valueOf(this.deviceOn));
    localLightStripDeviceInfoParams.setLongitude(this.longitude);
    localLightStripDeviceInfoParams.setLatitude(this.latitude);
    localLightStripDeviceInfoParams.setBrightness(Integer.valueOf(this.brightness));
    localLightStripDeviceInfoParams.setSaturation(Integer.valueOf(this.saturation));
    localLightStripDeviceInfoParams.setHue(Integer.valueOf(this.hue));
    localLightStripDeviceInfoParams.setColorTemp(Integer.valueOf(this.colorTemp));
    localLightStripDeviceInfoParams.setDefaultStates(this.defaultStates);
    localLightStripDeviceInfoParams.setLightingEffect(this.lightingEffectData);
    localLightStripDeviceInfoParams.setMusicRhythmEnable(this.musicRhythmEnable);
    localLightStripDeviceInfoParams.setMusicRhythmMode(this.musicRhythmMode);
    return localLightStripDeviceInfoParams;
  }
  
  public int getHue()
  {
    return this.hue;
  }
  
  public int getLightingEffectBrightness()
  {
    Object localObject = this.lightingEffectData;
    if (localObject != null)
    {
      localObject = ((LightingEffectData)localObject).brightness;
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
    }
    return 100;
  }
  
  @Nullable
  public LightingEffectData getLightingEffectData()
  {
    return this.lightingEffectData;
  }
  
  @Nullable
  public String getMusicRhythmMode()
  {
    return this.musicRhythmMode;
  }
  
  public int getSaturation()
  {
    return this.saturation;
  }
  
  public int getSegments()
  {
    return this.segments;
  }
  
  public boolean isAutoEnable()
  {
    return this.autoEnable;
  }
  
  public boolean isLightingEffectEnabled()
  {
    LightingEffectData localLightingEffectData = this.lightingEffectData;
    boolean bool = true;
    if ((localLightingEffectData == null) || (localLightingEffectData.enable.intValue() != 1) || (TextUtils.isEmpty(this.lightingEffectData.id)) || (this.lightingEffectData.isGoogleLightingEffect())) {
      bool = false;
    }
    return bool;
  }
  
  public Boolean isMusicRhythmEnable()
  {
    return this.musicRhythmEnable;
  }
  
  public boolean isV1MusicRhythmEnableComponent()
  {
    int i = getComponentVersion(EnumIoTComponent.MUSIC_RHYTHM);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public void setAutoEnable(boolean paramBoolean)
  {
    this.autoEnable = paramBoolean;
  }
  
  public void setAutoMode(String paramString)
  {
    this.autoMode = paramString;
  }
  
  public void setBrightness(int paramInt)
  {
    this.brightness = paramInt;
  }
  
  public void setColorTemp(int paramInt)
  {
    this.colorTemp = paramInt;
  }
  
  public void setColorTempRange(@Nullable int[] paramArrayOfInt)
  {
    this.colorTempRange = paramArrayOfInt;
  }
  
  public void setHue(int paramInt)
  {
    this.hue = paramInt;
  }
  
  public void setLightingEffectData(@Nullable LightingEffectData paramLightingEffectData)
  {
    this.lightingEffectData = paramLightingEffectData;
  }
  
  public void setMusicRhythmEnable(Boolean paramBoolean)
  {
    this.musicRhythmEnable = paramBoolean;
  }
  
  public void setMusicRhythmMode(@Nullable String paramString)
  {
    this.musicRhythmMode = paramString;
  }
  
  public void setSaturation(int paramInt)
  {
    this.saturation = paramInt;
  }
  
  public void setSegments(int paramInt)
  {
    this.segments = paramInt;
  }
  
  public void updateDeviceInfoParam(DeviceInfoParams paramDeviceInfoParams)
  {
    super.updateDeviceInfoParam(paramDeviceInfoParams);
    if ((paramDeviceInfoParams instanceof LightStripDeviceInfoParams))
    {
      paramDeviceInfoParams = (LightStripDeviceInfoParams)paramDeviceInfoParams;
      if (paramDeviceInfoParams.getBrightness() != null) {
        this.brightness = paramDeviceInfoParams.getBrightness().intValue();
      }
      if (paramDeviceInfoParams.getHue() != null) {
        this.hue = paramDeviceInfoParams.getHue().intValue();
      }
      if (paramDeviceInfoParams.getSaturation() != null) {
        this.saturation = paramDeviceInfoParams.getSaturation().intValue();
      }
      if (paramDeviceInfoParams.getColorTemp() != null) {
        this.colorTemp = paramDeviceInfoParams.getColorTemp().intValue();
      }
      if (paramDeviceInfoParams.getLightingEffect() != null) {
        this.lightingEffectData = paramDeviceInfoParams.getLightingEffect();
      }
      if (paramDeviceInfoParams.isMusicRhythmEnable() != null) {
        this.musicRhythmEnable = paramDeviceInfoParams.isMusicRhythmEnable();
      }
      if (paramDeviceInfoParams.getMusicRhythmMode() != null) {
        this.musicRhythmMode = paramDeviceInfoParams.getMusicRhythmMode();
      }
    }
  }
  
  public void updateDeviceRunningInfo(DeviceRunningInfoResult paramDeviceRunningInfoResult, boolean paramBoolean)
  {
    super.updateDeviceRunningInfo(paramDeviceRunningInfoResult, paramBoolean);
    if ((paramDeviceRunningInfoResult instanceof LightStripDeviceRunningInfoResult))
    {
      LightStripDeviceRunningInfoResult localLightStripDeviceRunningInfoResult = (LightStripDeviceRunningInfoResult)paramDeviceRunningInfoResult;
      this.brightness = localLightStripDeviceRunningInfoResult.getBrightness();
      this.hue = localLightStripDeviceRunningInfoResult.getHue();
      this.saturation = localLightStripDeviceRunningInfoResult.getSaturation();
      this.colorTemp = localLightStripDeviceRunningInfoResult.getColorTemp();
      if (localLightStripDeviceRunningInfoResult.getAutoMode() != null) {
        this.autoMode = localLightStripDeviceRunningInfoResult.getAutoMode();
      }
      LightingEffectData localLightingEffectData = localLightStripDeviceRunningInfoResult.getLightingEffectData();
      if (localLightingEffectData != null)
      {
        Integer localInteger1 = localLightingEffectData.bAdjusted;
        if (localInteger1 != null)
        {
          Integer localInteger2 = localLightingEffectData.brightness;
          if (localInteger2 != null)
          {
            paramDeviceRunningInfoResult = this.lightingEffectData;
            if (paramDeviceRunningInfoResult != null)
            {
              paramDeviceRunningInfoResult.brightness = localInteger2;
              break label145;
            }
          }
        }
        if (localInteger1 == null) {
          this.lightingEffectData = localLightingEffectData;
        } else {
          this.lightingEffectData = null;
        }
      }
      else
      {
        this.lightingEffectData = null;
      }
      label145:
      this.musicRhythmEnable = localLightStripDeviceRunningInfoResult.isMusicRhythmEnable();
      this.musicRhythmMode = localLightStripDeviceRunningInfoResult.getMusicRhythmMode();
    }
  }
  
  public void updateDeviceShadow(Map<String, Object> paramMap)
  {
    super.updateDeviceShadow(paramMap);
    if (paramMap != null)
    {
      boolean bool1 = paramMap.containsKey("on");
      boolean bool2 = true;
      Object localObject;
      if (bool1)
      {
        localObject = paramMap.get("on");
        if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.deviceOn = bool1;
      }
      int i;
      if (paramMap.containsKey("brightness"))
      {
        localObject = paramMap.get("brightness");
        if ((localObject instanceof Number)) {
          i = ((Number)localObject).intValue();
        } else {
          i = 0;
        }
        this.brightness = i;
      }
      if (paramMap.containsKey("hue"))
      {
        localObject = paramMap.get("hue");
        if ((localObject instanceof Number)) {
          i = ((Number)localObject).intValue();
        } else {
          i = 0;
        }
        this.hue = i;
      }
      if (paramMap.containsKey("saturation"))
      {
        localObject = paramMap.get("saturation");
        if ((localObject instanceof Number)) {
          i = ((Number)localObject).intValue();
        } else {
          i = 0;
        }
        this.saturation = i;
      }
      if (paramMap.containsKey("color_temp"))
      {
        localObject = paramMap.get("color_temp");
        if ((localObject instanceof Number)) {
          i = ((Number)localObject).intValue();
        } else {
          i = 0;
        }
        this.colorTemp = i;
      }
      if (paramMap.containsKey("auto"))
      {
        localObject = paramMap.get("auto");
        if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.autoEnable = bool1;
      }
      if (paramMap.containsKey("auto_mode")) {
        this.autoMode = ((String)paramMap.get("auto_mode"));
      }
      if (paramMap.containsKey("music_rhythm_enable"))
      {
        localObject = paramMap.get("music_rhythm_enable");
        if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        this.musicRhythmEnable = Boolean.valueOf(bool1);
      }
      if (paramMap.containsKey("music_rhythm_mode")) {
        this.musicRhythmMode = ((String)paramMap.get("music_rhythm_mode"));
      }
      if (paramMap.containsKey("lighting_effect"))
      {
        paramMap = LightingEffectData.resolveObject(paramMap.get("lighting_effect"));
        if (paramMap != null)
        {
          Integer localInteger = paramMap.bAdjusted;
          if (localInteger != null)
          {
            localObject = paramMap.brightness;
            if (localObject != null)
            {
              LightingEffectData localLightingEffectData = this.lightingEffectData;
              if (localLightingEffectData != null)
              {
                localLightingEffectData.brightness = ((Integer)localObject);
                break label534;
              }
            }
          }
          if (localInteger == null) {
            this.lightingEffectData = paramMap;
          } else {
            this.lightingEffectData = null;
          }
        }
        else
        {
          this.lightingEffectData = null;
        }
        label534:
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateDeviceShadow lightingEffect from shadow: ");
        ((StringBuilder)localObject).append(l.c(paramMap));
        a.n("LightStrip", ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\IoTLightStripDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */