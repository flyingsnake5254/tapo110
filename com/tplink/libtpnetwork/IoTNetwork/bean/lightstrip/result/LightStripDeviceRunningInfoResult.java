package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.result;

import b.d.w.c.a;
import com.google.gson.k;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.common.ThingShadowState;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DefaultStatesStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.Utils.l;
import java.util.Map;

public class LightStripDeviceRunningInfoResult
  extends DeviceRunningInfoResult
{
  private transient boolean autoEnable;
  private transient String autoMode;
  private int brightness;
  @c("color_temp")
  private int colorTemp;
  private int hue;
  @c("lighting_effect")
  private LightingEffectData lightingEffectData;
  @c("music_rhythm_enable")
  private Boolean musicRhythmEnable;
  @c("music_rhythm_mode")
  private String musicRhythmMode;
  private int saturation;
  
  public LightStripDeviceRunningInfoResult(ThingDetail paramThingDetail, ThingSetting paramThingSetting, ThingShadowResult paramThingShadowResult, ThingModel paramThingModel)
  {
    this.fwVer = paramThingDetail.getFwVer();
    this.ip = paramThingDetail.getIp();
    this.nickname = paramThingSetting.getNickname();
    this.avatar = paramThingSetting.getAvatarUrl();
    this.longitude = paramThingSetting.getLongitude();
    Integer localInteger = paramThingSetting.getLatitude();
    this.latitude = localInteger;
    paramThingDetail = this.longitude;
    boolean bool1 = true;
    boolean bool2;
    if ((paramThingDetail != null) && (localInteger != null) && (Math.abs(paramThingDetail.intValue()) <= 1800000) && (Math.abs(this.latitude.intValue()) <= 900000)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.hasSetLocationInfo = bool2;
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
      paramThingDetail = paramThingModel.getThingProperty("color_temp");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          i = ((Number)paramThingDetail).intValue();
        } else {
          i = 0;
        }
        this.colorTemp = i;
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
      if (paramThingModel.getThingProperty("lighting_effect") != null)
      {
        paramThingSetting = null;
        paramThingDetail = paramThingSetting;
        if (paramThingShadowResult.getState() != null)
        {
          paramThingDetail = paramThingSetting;
          if (paramThingShadowResult.getState().getReported() != null) {
            paramThingDetail = paramThingShadowResult.getState().getReported().get("lighting_effect");
          }
        }
        this.lightingEffectData = LightingEffectData.resolveObject(paramThingDetail);
        paramThingDetail = new StringBuilder();
        paramThingDetail.append("LightStripDeviceRunningInfoResult lightingEffect from shadow: ");
        paramThingDetail.append(l.c(this.lightingEffectData));
        a.n("LightStrip", paramThingDetail.toString());
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
  
  public int getHue()
  {
    return this.hue;
  }
  
  public LightingEffectData getLightingEffectData()
  {
    return this.lightingEffectData;
  }
  
  public String getMusicRhythmMode()
  {
    return this.musicRhythmMode;
  }
  
  public int getSaturation()
  {
    return this.saturation;
  }
  
  public boolean isAutoEnable()
  {
    return this.autoEnable;
  }
  
  public Boolean isMusicRhythmEnable()
  {
    return this.musicRhythmEnable;
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
  
  public void setHue(int paramInt)
  {
    this.hue = paramInt;
  }
  
  public void setLightingEffectData(LightingEffectData paramLightingEffectData)
  {
    this.lightingEffectData = paramLightingEffectData;
  }
  
  public void setMusicRhythmEnable(Boolean paramBoolean)
  {
    this.musicRhythmEnable = paramBoolean;
  }
  
  public void setMusicRhythmMode(String paramString)
  {
    this.musicRhythmMode = paramString;
  }
  
  public void setSaturation(int paramInt)
  {
    this.saturation = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\result\LightStripDeviceRunningInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */