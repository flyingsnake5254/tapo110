package com.tplink.libtpnetwork.IoTNetwork.bean.sub;

import android.text.TextUtils;
import b.d.w.c.a;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.SubDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.SubDeviceRunningInfoResult;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.enumerate.EnumTRVState;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IoTSubDevice
  extends LocalIoTBaseDevice
{
  private transient boolean atLowBattery;
  @c("bind_count")
  private int bindCount;
  private String category;
  @c("current_temp")
  private float currentTemp;
  @c("frost_protection_on")
  private boolean frostProtectionOn;
  private transient long latestLogTimestamp = -1L;
  @c("max_control_temp")
  private int maxControlTemp;
  @c("min_control_temp")
  private int minControlTemp;
  @c("original_device_id")
  private String originalDeviceId;
  private int position;
  @c("slot_number")
  private int slotNumber;
  private String status;
  @c("target_temp")
  private int targetTemp;
  @c("temp_offset")
  private int tempOffset;
  @c("temp_unit")
  private String tempUnit;
  @c("trv_states")
  private List<EnumTRVState> trvStates;
  
  public IoTSubDevice()
  {
    this.atLowBattery = false;
  }
  
  public IoTSubDevice(ThingDetail paramThingDetail, ThingSetting paramThingSetting, ThingShadowResult paramThingShadowResult, ThingModel paramThingModel)
  {
    int i = 0;
    this.atLowBattery = false;
    this.deviceId = paramThingShadowResult.getThingName();
    this.type = paramThingDetail.getDeviceType();
    this.model = paramThingDetail.getModel();
    this.mac = paramThingDetail.getMac();
    this.hwVer = paramThingDetail.getHwVer();
    this.hwId = paramThingDetail.getHwId();
    this.fwVer = paramThingDetail.getFwVer();
    this.fwId = paramThingDetail.getFwId();
    this.oemId = paramThingDetail.getOemId();
    this.originalDeviceId = paramThingDetail.getOriginalThingName();
    this.slotNumber = paramThingDetail.getSlotNumber();
    this.position = paramThingDetail.getPosition();
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
    this.timeDiff = paramThingSetting.getTimeDiff().intValue();
    this.region = paramThingSetting.getRegion();
    this.lang = paramThingSetting.getLang();
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
      paramThingDetail = paramThingModel.getThingProperty("at_low_battery");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if (((paramThingDetail instanceof Boolean)) && (((Boolean)paramThingDetail).booleanValue())) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        this.atLowBattery = bool2;
      }
      paramThingDetail = paramThingModel.getThingProperty("temp_unit");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof String)) {
          paramThingDetail = (String)paramThingDetail;
        } else {
          paramThingDetail = "celsius";
        }
        this.tempUnit = paramThingDetail;
      }
      paramThingDetail = paramThingModel.getThingProperty("current_temp");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        float f;
        if ((paramThingDetail instanceof Number)) {
          f = ((Number)paramThingDetail).floatValue();
        } else {
          f = 0.0F;
        }
        this.currentTemp = f;
      }
      paramThingDetail = paramThingModel.getThingProperty("target_temp");
      int j;
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          j = ((Number)paramThingDetail).intValue();
        } else {
          j = 0;
        }
        this.targetTemp = j;
      }
      paramThingDetail = paramThingModel.getThingProperty("min_control_temp");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          j = ((Number)paramThingDetail).intValue();
        } else {
          j = 0;
        }
        this.minControlTemp = j;
      }
      paramThingDetail = paramThingModel.getThingProperty("max_control_temp");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          j = ((Number)paramThingDetail).intValue();
        } else {
          j = 0;
        }
        this.maxControlTemp = j;
      }
      paramThingDetail = paramThingModel.getThingProperty("temp_offset");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          j = ((Number)paramThingDetail).intValue();
        } else {
          j = 0;
        }
        this.tempOffset = j;
      }
      paramThingDetail = paramThingModel.getThingProperty("frost_protection_on");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if (((paramThingDetail instanceof Boolean)) && (((Boolean)paramThingDetail).booleanValue())) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
        this.frostProtectionOn = bool2;
      }
      paramThingDetail = paramThingModel.getThingProperty("trv_states");
      if (paramThingDetail != null)
      {
        paramThingSetting = paramThingShadowResult.getReportedValue(paramThingDetail);
        paramThingDetail = new ArrayList();
        if ((paramThingSetting instanceof String[]))
        {
          paramThingSetting = (String[])paramThingSetting;
          int k = paramThingSetting.length;
          for (j = i; j < k; j++)
          {
            paramThingShadowResult = EnumTRVState.fromString(paramThingSetting[j]);
            if (paramThingShadowResult != null) {
              paramThingDetail.add(paramThingShadowResult);
            }
          }
        }
        paramThingSetting = new StringBuilder();
        paramThingSetting.append("enumTrvStates: ");
        paramThingSetting.append(i.j(paramThingDetail));
        a.n("TRV", paramThingSetting.toString());
        this.trvStates = paramThingDetail;
      }
    }
  }
  
  public int getBindCount()
  {
    return this.bindCount;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public float getCurrentTemp()
  {
    return this.currentTemp;
  }
  
  public DeviceInfoParams getDeviceInfoParams()
  {
    SubDeviceInfoParams localSubDeviceInfoParams = new SubDeviceInfoParams();
    localSubDeviceInfoParams.setNickname(this.nickname);
    localSubDeviceInfoParams.setAvatar(this.avatar);
    localSubDeviceInfoParams.setDeviceOn(Boolean.valueOf(this.deviceOn));
    localSubDeviceInfoParams.setLongitude(this.longitude);
    localSubDeviceInfoParams.setLatitude(this.latitude);
    localSubDeviceInfoParams.setTempUnit(this.tempUnit);
    localSubDeviceInfoParams.setTargetTemp(Integer.valueOf(this.targetTemp));
    localSubDeviceInfoParams.setTempOffset(Integer.valueOf(this.tempOffset));
    localSubDeviceInfoParams.setFrostProtectionOn(Boolean.valueOf(this.frostProtectionOn));
    localSubDeviceInfoParams.setMinControlTemp(Integer.valueOf(this.minControlTemp));
    localSubDeviceInfoParams.setMaxControlTemp(Integer.valueOf(this.maxControlTemp));
    return localSubDeviceInfoParams;
  }
  
  public EnumTemperatureUnit getEnumTempUnit()
  {
    return EnumTemperatureUnit.fromString(getTempUnit());
  }
  
  public long getLatestLogTimestamp()
  {
    return this.latestLogTimestamp;
  }
  
  public int getMaxControlTemp()
  {
    return this.maxControlTemp;
  }
  
  public int getMinControlTemp()
  {
    return this.minControlTemp;
  }
  
  public String getOriginalDeviceId()
  {
    return this.originalDeviceId;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public int getSlotNumber()
  {
    return this.slotNumber;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public int getTargetTemp()
  {
    return this.targetTemp;
  }
  
  public int getTempOffset()
  {
    return this.tempOffset;
  }
  
  public String getTempUnit()
  {
    return this.tempUnit;
  }
  
  public List<EnumTRVState> getTrvStates()
  {
    return this.trvStates;
  }
  
  public boolean isAtLowBattery()
  {
    return this.atLowBattery;
  }
  
  public boolean isFrostProtectionOn()
  {
    return this.frostProtectionOn;
  }
  
  public void setAtLowBattery(boolean paramBoolean)
  {
    this.atLowBattery = paramBoolean;
  }
  
  public void setBindCount(int paramInt)
  {
    this.bindCount = paramInt;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setCurrentTemp(float paramFloat)
  {
    this.currentTemp = paramFloat;
  }
  
  public void setFrostProtectionOn(boolean paramBoolean)
  {
    this.frostProtectionOn = paramBoolean;
  }
  
  public void setLatestLogTimestamp(long paramLong)
  {
    this.latestLogTimestamp = paramLong;
  }
  
  public void setMaxControlTemp(int paramInt)
  {
    this.maxControlTemp = paramInt;
  }
  
  public void setMinControlTemp(int paramInt)
  {
    this.minControlTemp = paramInt;
  }
  
  public void setOriginalDeviceId(String paramString)
  {
    this.originalDeviceId = paramString;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void setSlotNumber(int paramInt)
  {
    this.slotNumber = paramInt;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public void setTargetTemp(int paramInt)
  {
    this.targetTemp = paramInt;
  }
  
  public void setTempOffset(int paramInt)
  {
    this.tempOffset = paramInt;
  }
  
  public void setTempUnit(String paramString)
  {
    this.tempUnit = paramString;
  }
  
  public void setTrvStates(List<EnumTRVState> paramList)
  {
    this.trvStates = paramList;
  }
  
  public void updateDeviceInfoParam(DeviceInfoParams paramDeviceInfoParams)
  {
    super.updateDeviceInfoParam(paramDeviceInfoParams);
    if ((paramDeviceInfoParams instanceof SubDeviceInfoParams))
    {
      paramDeviceInfoParams = (SubDeviceInfoParams)paramDeviceInfoParams;
      if (paramDeviceInfoParams.getTempUnit() != null) {
        this.tempUnit = paramDeviceInfoParams.getTempUnit();
      }
      if (paramDeviceInfoParams.getTargetTemp() != null) {
        this.targetTemp = paramDeviceInfoParams.getTargetTemp().intValue();
      }
      if (paramDeviceInfoParams.getTempOffset() != null) {
        this.tempOffset = paramDeviceInfoParams.getTempOffset().intValue();
      }
      if (paramDeviceInfoParams.getFrostProtectionOn() != null) {
        this.frostProtectionOn = paramDeviceInfoParams.getFrostProtectionOn().booleanValue();
      }
      if (paramDeviceInfoParams.getMinControlTemp() != null) {
        this.minControlTemp = paramDeviceInfoParams.getMinControlTemp().intValue();
      }
      if (paramDeviceInfoParams.getMaxControlTemp() != null) {
        this.maxControlTemp = paramDeviceInfoParams.getMaxControlTemp().intValue();
      }
    }
  }
  
  public void updateDeviceRunningInfo(DeviceRunningInfoResult paramDeviceRunningInfoResult, boolean paramBoolean)
  {
    if (paramDeviceRunningInfoResult != null)
    {
      if (!TextUtils.isEmpty(paramDeviceRunningInfoResult.getFwVer())) {
        this.fwVer = paramDeviceRunningInfoResult.getFwVer();
      }
      this.nickname = paramDeviceRunningInfoResult.getNickname();
      this.avatar = paramDeviceRunningInfoResult.getAvatar();
      this.deviceOn = paramDeviceRunningInfoResult.isDeviceOn();
      this.overheated = paramDeviceRunningInfoResult.isOverheated();
      this.hasSetLocationInfo = paramDeviceRunningInfoResult.isHasSetLocationInfo();
      if ((paramDeviceRunningInfoResult.getLongitude() != null) && (paramDeviceRunningInfoResult.getLatitude() != null))
      {
        this.longitude = paramDeviceRunningInfoResult.getLongitude();
        this.latitude = paramDeviceRunningInfoResult.getLatitude();
      }
      this.lang = paramDeviceRunningInfoResult.getLang();
      this.defaultStates = paramDeviceRunningInfoResult.getDefaultStates();
    }
    if ((paramDeviceRunningInfoResult instanceof SubDeviceRunningInfoResult))
    {
      paramDeviceRunningInfoResult = (SubDeviceRunningInfoResult)paramDeviceRunningInfoResult;
      if (paramBoolean) {
        this.atLowBattery = paramDeviceRunningInfoResult.isAtLowBattery();
      }
      if (!TextUtils.isEmpty(paramDeviceRunningInfoResult.getStatus())) {
        this.status = paramDeviceRunningInfoResult.getStatus();
      }
      this.bindCount = paramDeviceRunningInfoResult.getBindCount();
      this.tempUnit = paramDeviceRunningInfoResult.getTempUnit();
      this.currentTemp = paramDeviceRunningInfoResult.getCurrentTemp();
      this.targetTemp = paramDeviceRunningInfoResult.getTargetTemp();
      this.minControlTemp = paramDeviceRunningInfoResult.getMinControlTemp();
      this.maxControlTemp = paramDeviceRunningInfoResult.getMaxControlTemp();
      this.tempOffset = paramDeviceRunningInfoResult.getTempOffset();
      this.frostProtectionOn = paramDeviceRunningInfoResult.isFrostProtectionOn();
      this.trvStates = paramDeviceRunningInfoResult.getTrvStates();
    }
  }
  
  public void updateDeviceShadow(Map<String, Object> paramMap)
  {
    super.updateDeviceShadow(paramMap);
    if (paramMap != null)
    {
      boolean bool1 = paramMap.containsKey("on");
      boolean bool2 = true;
      Object localObject1;
      if (bool1)
      {
        localObject1 = paramMap.get("on");
        if (((localObject1 instanceof Boolean)) && (((Boolean)localObject1).booleanValue())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.deviceOn = bool1;
      }
      if (paramMap.containsKey("at_low_battery"))
      {
        localObject1 = paramMap.get("at_low_battery");
        if (((localObject1 instanceof Boolean)) && (((Boolean)localObject1).booleanValue())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.atLowBattery = bool1;
      }
      if (paramMap.containsKey("temp_unit"))
      {
        localObject1 = paramMap.get("temp_unit");
        if ((localObject1 instanceof String)) {
          localObject1 = (String)localObject1;
        } else {
          localObject1 = "celsius";
        }
        this.tempUnit = ((String)localObject1);
      }
      if (paramMap.containsKey("current_temp"))
      {
        localObject1 = paramMap.get("current_temp");
        float f;
        if ((localObject1 instanceof Number)) {
          f = ((Number)localObject1).floatValue();
        } else {
          f = 0.0F;
        }
        this.currentTemp = f;
      }
      int i;
      if (paramMap.containsKey("target_temp"))
      {
        localObject1 = paramMap.get("target_temp");
        if ((localObject1 instanceof Number)) {
          i = ((Number)localObject1).intValue();
        } else {
          i = 0;
        }
        this.targetTemp = i;
      }
      if (paramMap.containsKey("temp_offset"))
      {
        localObject1 = paramMap.get("temp_offset");
        if ((localObject1 instanceof Number)) {
          i = ((Number)localObject1).intValue();
        } else {
          i = 0;
        }
        this.tempOffset = i;
      }
      if (paramMap.containsKey("min_control_temp"))
      {
        localObject1 = paramMap.get("min_control_temp");
        if ((localObject1 instanceof Number)) {
          i = ((Number)localObject1).intValue();
        } else {
          i = 0;
        }
        this.minControlTemp = i;
      }
      if (paramMap.containsKey("max_control_temp"))
      {
        localObject1 = paramMap.get("max_control_temp");
        if ((localObject1 instanceof Number)) {
          i = ((Number)localObject1).intValue();
        } else {
          i = 0;
        }
        this.maxControlTemp = i;
      }
      if (paramMap.containsKey("frost_protection_on"))
      {
        localObject1 = paramMap.get("frost_protection_on");
        if (((localObject1 instanceof Boolean)) && (((Boolean)localObject1).booleanValue())) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        this.frostProtectionOn = bool1;
      }
      if (paramMap.containsKey("trv_states"))
      {
        Object localObject2 = paramMap.get("trv_states");
        paramMap = new ArrayList();
        localObject1 = new ArrayList();
        if ((localObject2 instanceof String[]))
        {
          ((List)localObject1).addAll(Arrays.asList((String[])localObject2));
        }
        else if ((localObject2 instanceof List))
        {
          Iterator localIterator = ((List)localObject2).iterator();
          while (localIterator.hasNext())
          {
            localObject2 = localIterator.next();
            if ((localObject2 instanceof String)) {
              ((List)localObject1).add((String)localObject2);
            }
          }
        }
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = EnumTRVState.fromString((String)((Iterator)localObject2).next());
          if (localObject1 != null) {
            paramMap.add(localObject1);
          }
        }
        this.trvStates = paramMap;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("enumTrvStates: ");
        ((StringBuilder)localObject1).append(i.j(paramMap));
        a.n("TRV", ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\IoTSubDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */