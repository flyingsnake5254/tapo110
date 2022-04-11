package com.tplink.libtpnetwork.IoTNetwork.bean.sub.result;

import b.d.w.c.a;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.enumerate.EnumTRVState;
import java.util.ArrayList;
import java.util.List;

public class SubDeviceRunningInfoResult
  extends DeviceRunningInfoResult
{
  private transient boolean atLowBattery;
  @c("bind_count")
  private int bindCount;
  private String category;
  @c("current_temp")
  private float currentTemp;
  @c("frost_protection_on")
  private boolean frostProtectionOn;
  @c("max_control_temp")
  private int maxControlTemp;
  @c("min_control_temp")
  private int minControlTemp;
  private String status;
  @c("target_temp")
  private int targetTemp;
  @c("temp_offset")
  private int tempOffset;
  @c("temp_unit")
  private String tempUnit;
  @c("trv_states")
  private List<EnumTRVState> trvStates;
  
  public SubDeviceRunningInfoResult(ThingDetail paramThingDetail, ThingSetting paramThingSetting, ThingShadowResult paramThingShadowResult, ThingModel paramThingModel)
  {
    boolean bool1 = false;
    this.atLowBattery = false;
    this.fwVer = paramThingDetail.getFwVer();
    this.ip = paramThingDetail.getIp();
    this.nickname = paramThingSetting.getNickname();
    this.avatar = paramThingSetting.getAvatarUrl();
    this.longitude = paramThingSetting.getLongitude();
    paramThingDetail = paramThingSetting.getLatitude();
    this.latitude = paramThingDetail;
    paramThingSetting = this.longitude;
    boolean bool2;
    if ((paramThingSetting != null) && (paramThingDetail != null) && (Math.abs(paramThingSetting.intValue()) <= 1800000) && (Math.abs(this.latitude.intValue()) <= 900000)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.hasSetLocationInfo = bool2;
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
      int i;
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          i = ((Number)paramThingDetail).intValue();
        } else {
          i = 0;
        }
        this.targetTemp = i;
      }
      paramThingDetail = paramThingModel.getThingProperty("min_control_temp");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          i = ((Number)paramThingDetail).intValue();
        } else {
          i = 0;
        }
        this.minControlTemp = i;
      }
      paramThingDetail = paramThingModel.getThingProperty("max_control_temp");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          i = ((Number)paramThingDetail).intValue();
        } else {
          i = 0;
        }
        this.maxControlTemp = i;
      }
      paramThingDetail = paramThingModel.getThingProperty("temp_offset");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if ((paramThingDetail instanceof Number)) {
          i = ((Number)paramThingDetail).intValue();
        } else {
          i = 0;
        }
        this.tempOffset = i;
      }
      paramThingDetail = paramThingModel.getThingProperty("frost_protection_on");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        if (((paramThingDetail instanceof Boolean)) && (((Boolean)paramThingDetail).booleanValue())) {
          bool2 = true;
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
          String[] arrayOfString = (String[])paramThingSetting;
          int j = arrayOfString.length;
          for (i = 0; i < j; i++)
          {
            paramThingSetting = EnumTRVState.fromString(arrayOfString[i]);
            if (paramThingSetting != null) {
              paramThingDetail.add(paramThingSetting);
            }
          }
        }
        paramThingSetting = new StringBuilder();
        paramThingSetting.append("enumTrvStates: ");
        paramThingSetting.append(i.j(paramThingDetail));
        a.n("TRV", paramThingSetting.toString());
        this.trvStates = paramThingDetail;
      }
      paramThingDetail = paramThingModel.getThingProperty("at_low_battery");
      if (paramThingDetail != null)
      {
        paramThingDetail = paramThingShadowResult.getReportedValue(paramThingDetail);
        bool2 = bool1;
        if ((paramThingDetail instanceof Boolean))
        {
          bool2 = bool1;
          if (((Boolean)paramThingDetail).booleanValue()) {
            bool2 = true;
          }
        }
        this.atLowBattery = bool2;
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
  
  public int getMaxControlTemp()
  {
    return this.maxControlTemp;
  }
  
  public int getMinControlTemp()
  {
    return this.minControlTemp;
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
  
  public void setMaxControlTemp(int paramInt)
  {
    this.maxControlTemp = paramInt;
  }
  
  public void setMinControlTemp(int paramInt)
  {
    this.minControlTemp = paramInt;
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\result\SubDeviceRunningInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */