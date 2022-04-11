package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

public final class AlarmInfo
{
  @c("alarm_type")
  private final String alarmType;
  private final String enabled;
  @c("light_type")
  private final String lightType;
  @c("alarm_mode")
  private final List<String> modes;
  
  public AlarmInfo(String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    this.alarmType = paramString1;
    this.enabled = paramString2;
    this.lightType = paramString3;
    this.modes = paramList;
  }
  
  public final String component1()
  {
    return this.alarmType;
  }
  
  public final String component2()
  {
    return this.enabled;
  }
  
  public final String component3()
  {
    return this.lightType;
  }
  
  public final List<String> component4()
  {
    return this.modes;
  }
  
  public final AlarmInfo copy(String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    j.e(paramString1, "alarmType");
    j.e(paramString2, "enabled");
    j.e(paramList, "modes");
    return new AlarmInfo(paramString1, paramString2, paramString3, paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof AlarmInfo))
      {
        paramObject = (AlarmInfo)paramObject;
        if ((j.a(this.alarmType, ((AlarmInfo)paramObject).alarmType)) && (j.a(this.enabled, ((AlarmInfo)paramObject).enabled)) && (j.a(this.lightType, ((AlarmInfo)paramObject).lightType)) && (j.a(this.modes, ((AlarmInfo)paramObject).modes))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getAlarmType()
  {
    return this.alarmType;
  }
  
  public final String getEnabled()
  {
    return this.enabled;
  }
  
  public final String getLightType()
  {
    return this.lightType;
  }
  
  public final List<String> getModes()
  {
    return this.modes;
  }
  
  public int hashCode()
  {
    Object localObject = this.alarmType;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.enabled;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.lightType;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.modes;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AlarmInfo(alarmType=");
    localStringBuilder.append(this.alarmType);
    localStringBuilder.append(", enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(", lightType=");
    localStringBuilder.append(this.lightType);
    localStringBuilder.append(", modes=");
    localStringBuilder.append(this.modes);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\AlarmInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */