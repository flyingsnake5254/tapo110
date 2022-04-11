package com.tplink.libtpnetwork.IoTNetwork.bean.hub.params;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class PlayAlarmParams
{
  @c("alarm_type")
  private String alarmType;
  @c("alarm_volume")
  private String alarmVolume;
  
  public PlayAlarmParams(String paramString1, String paramString2)
  {
    this.alarmType = paramString1;
    this.alarmVolume = paramString2;
  }
  
  public final String component1()
  {
    return this.alarmType;
  }
  
  public final String component2()
  {
    return this.alarmVolume;
  }
  
  public final PlayAlarmParams copy(String paramString1, String paramString2)
  {
    j.e(paramString1, "alarmType");
    j.e(paramString2, "alarmVolume");
    return new PlayAlarmParams(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PlayAlarmParams))
      {
        paramObject = (PlayAlarmParams)paramObject;
        if ((j.a(this.alarmType, ((PlayAlarmParams)paramObject).alarmType)) && (j.a(this.alarmVolume, ((PlayAlarmParams)paramObject).alarmVolume))) {}
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
  
  public final String getAlarmVolume()
  {
    return this.alarmVolume;
  }
  
  public int hashCode()
  {
    String str = this.alarmType;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.alarmVolume;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayAlarmParams(alarmType=");
    localStringBuilder.append(this.alarmType);
    localStringBuilder.append(", alarmVolume=");
    localStringBuilder.append(this.alarmVolume);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\params\PlayAlarmParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */