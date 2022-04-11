package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode.a;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.collections.l;
import kotlin.jvm.internal.j;
import kotlin.n;

public final class GuardModeConfigBean
{
  @c("alarm_time")
  private GuardModeAlarmTimeBean alarmTime;
  @c("alarm_type")
  private String alarmType;
  @c("alarm_volume")
  private String alarmVolume;
  @c("device_id_list")
  private List<String> deviceIdList;
  private String id;
  
  public GuardModeConfigBean(ThingRuleGuardMode paramThingRuleGuardMode)
  {
    this("", l.d(), "", "", GuardModeAlarmTimeBean.Companion.getDefault());
    Object localObject = paramThingRuleGuardMode.getId();
    if (localObject == null) {
      localObject = EnumGuardMode.HOME.getValue();
    }
    this.id = ((String)localObject);
    localObject = paramThingRuleGuardMode.getDeviceIdList();
    if (localObject == null) {
      localObject = l.d();
    }
    this.deviceIdList = ((List)localObject);
    localObject = paramThingRuleGuardMode.getAlarmType();
    if (localObject == null) {
      localObject = "";
    }
    this.alarmType = ((String)localObject);
    localObject = paramThingRuleGuardMode.getAlarmVolume();
    if (localObject == null) {
      localObject = EnumGuardModeAlarmVolume.HIGH.getValue();
    }
    this.alarmVolume = ((String)localObject);
    Map localMap = paramThingRuleGuardMode.getAlarmTime();
    if (localMap != null)
    {
      GuardModeAlarmTimeBean localGuardModeAlarmTimeBean = this.alarmTime;
      localObject = localMap.get("type");
      paramThingRuleGuardMode = (ThingRuleGuardMode)localObject;
      if (!(localObject instanceof String)) {
        paramThingRuleGuardMode = null;
      }
      paramThingRuleGuardMode = (String)paramThingRuleGuardMode;
      if (paramThingRuleGuardMode == null) {
        paramThingRuleGuardMode = EnumGuardModeAlarmTimeType.ALWAYS.getValue();
      }
      localGuardModeAlarmTimeBean.setType(paramThingRuleGuardMode);
      paramThingRuleGuardMode = this.alarmTime;
      localObject = localMap.get("time");
      int i;
      if ((localObject instanceof Long)) {
        i = (int)((Number)localObject).longValue();
      } else if ((localObject instanceof Integer)) {
        i = ((Number)localObject).intValue();
      } else {
        i = 0;
      }
      paramThingRuleGuardMode.setTime(i);
    }
  }
  
  public GuardModeConfigBean(String paramString1, List<String> paramList, String paramString2, String paramString3, GuardModeAlarmTimeBean paramGuardModeAlarmTimeBean)
  {
    this.id = paramString1;
    this.deviceIdList = paramList;
    this.alarmType = paramString2;
    this.alarmVolume = paramString3;
    this.alarmTime = paramGuardModeAlarmTimeBean;
  }
  
  public final String component1()
  {
    return this.id;
  }
  
  public final List<String> component2()
  {
    return this.deviceIdList;
  }
  
  public final String component3()
  {
    return this.alarmType;
  }
  
  public final String component4()
  {
    return this.alarmVolume;
  }
  
  public final GuardModeAlarmTimeBean component5()
  {
    return this.alarmTime;
  }
  
  public final GuardModeConfigBean copy(String paramString1, List<String> paramList, String paramString2, String paramString3, GuardModeAlarmTimeBean paramGuardModeAlarmTimeBean)
  {
    j.e(paramString1, "id");
    j.e(paramList, "deviceIdList");
    j.e(paramString2, "alarmType");
    j.e(paramString3, "alarmVolume");
    j.e(paramGuardModeAlarmTimeBean, "alarmTime");
    return new GuardModeConfigBean(paramString1, paramList, paramString2, paramString3, paramGuardModeAlarmTimeBean);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof GuardModeConfigBean))
      {
        paramObject = (GuardModeConfigBean)paramObject;
        if ((j.a(this.id, ((GuardModeConfigBean)paramObject).id)) && (j.a(this.deviceIdList, ((GuardModeConfigBean)paramObject).deviceIdList)) && (j.a(this.alarmType, ((GuardModeConfigBean)paramObject).alarmType)) && (j.a(this.alarmVolume, ((GuardModeConfigBean)paramObject).alarmVolume)) && (j.a(this.alarmTime, ((GuardModeConfigBean)paramObject).alarmTime))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final GuardModeAlarmTimeBean getAlarmTime()
  {
    return this.alarmTime;
  }
  
  public final String getAlarmType()
  {
    return this.alarmType;
  }
  
  public final String getAlarmVolume()
  {
    return this.alarmVolume;
  }
  
  public final List<String> getDeviceIdList()
  {
    return this.deviceIdList;
  }
  
  public final EnumGuardModeAlarmVolume getEnumAlarmVolume()
  {
    String str = this.alarmVolume;
    Object localObject = EnumGuardModeAlarmVolume.MUTE;
    if (!j.a(str, ((EnumGuardModeAlarmVolume)localObject).getValue()))
    {
      localObject = EnumGuardModeAlarmVolume.LOW;
      if (!j.a(str, ((EnumGuardModeAlarmVolume)localObject).getValue()))
      {
        EnumGuardModeAlarmVolume localEnumGuardModeAlarmVolume = EnumGuardModeAlarmVolume.NORMAL;
        if (j.a(str, localEnumGuardModeAlarmVolume.getValue())) {}
        for (localObject = localEnumGuardModeAlarmVolume;; localObject = localEnumGuardModeAlarmVolume)
        {
          break;
          localEnumGuardModeAlarmVolume = EnumGuardModeAlarmVolume.HIGH;
          if (!j.a(str, localEnumGuardModeAlarmVolume.getValue())) {
            break;
          }
        }
      }
    }
    return (EnumGuardModeAlarmVolume)localObject;
  }
  
  public final EnumGuardMode getEnumGuardMode()
  {
    return EnumGuardMode.Companion.a(this.id);
  }
  
  public final String getId()
  {
    return this.id;
  }
  
  public int hashCode()
  {
    Object localObject = this.id;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.deviceIdList;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.alarmType;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.alarmVolume;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.alarmTime;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (((j * 31 + k) * 31 + m) * 31 + n) * 31 + i;
  }
  
  public final void setAlarmTime(GuardModeAlarmTimeBean paramGuardModeAlarmTimeBean)
  {
    j.e(paramGuardModeAlarmTimeBean, "<set-?>");
    this.alarmTime = paramGuardModeAlarmTimeBean;
  }
  
  public final void setAlarmType(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.alarmType = paramString;
  }
  
  public final void setAlarmVolume(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.alarmVolume = paramString;
  }
  
  public final void setDeviceIdList(List<String> paramList)
  {
    j.e(paramList, "<set-?>");
    this.deviceIdList = paramList;
  }
  
  public final void setId(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.id = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuardModeConfigBean(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", deviceIdList=");
    localStringBuilder.append(this.deviceIdList);
    localStringBuilder.append(", alarmType=");
    localStringBuilder.append(this.alarmType);
    localStringBuilder.append(", alarmVolume=");
    localStringBuilder.append(this.alarmVolume);
    localStringBuilder.append(", alarmTime=");
    localStringBuilder.append(this.alarmTime);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public final ThingRuleGuardMode toThingRuleGuardMode()
  {
    return new ThingRuleGuardMode(this.id, this.deviceIdList, this.alarmType, this.alarmVolume, b0.f(new Pair[] { n.a("type", this.alarmTime.getType()), n.a("time", Integer.valueOf(this.alarmTime.getTime())) }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\result\GuardModeConfigBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */