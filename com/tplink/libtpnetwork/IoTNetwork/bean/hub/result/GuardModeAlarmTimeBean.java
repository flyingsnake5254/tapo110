package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;
import kotlin.jvm.internal.j;

public final class GuardModeAlarmTimeBean
{
  public static final Companion Companion = new Companion(null);
  private static final GuardModeAlarmTimeBean DEFAULT = new GuardModeAlarmTimeBean(EnumGuardModeAlarmTimeType.CUSTOM_TIME.getValue(), 300);
  public static final int DEFAULT_ALARM_TIME_IN_SEC = 300;
  private int time;
  private String type;
  
  public GuardModeAlarmTimeBean()
  {
    this(localGuardModeAlarmTimeBean.type, localGuardModeAlarmTimeBean.time);
  }
  
  public GuardModeAlarmTimeBean(String paramString, int paramInt)
  {
    this.type = paramString;
    this.time = paramInt;
  }
  
  public static final GuardModeAlarmTimeBean getDefault()
  {
    return Companion.getDefault();
  }
  
  public final String component1()
  {
    return this.type;
  }
  
  public final int component2()
  {
    return this.time;
  }
  
  public final GuardModeAlarmTimeBean copy(String paramString, int paramInt)
  {
    j.e(paramString, "type");
    return new GuardModeAlarmTimeBean(paramString, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof GuardModeAlarmTimeBean))
      {
        paramObject = (GuardModeAlarmTimeBean)paramObject;
        if ((j.a(this.type, ((GuardModeAlarmTimeBean)paramObject).type)) && (this.time == ((GuardModeAlarmTimeBean)paramObject).time)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final EnumGuardModeAlarmTimeType getEnumType()
  {
    String str = this.type;
    Object localObject = EnumGuardModeAlarmTimeType.ALWAYS;
    if (!j.a(str, ((EnumGuardModeAlarmTimeType)localObject).getValue()))
    {
      EnumGuardModeAlarmTimeType localEnumGuardModeAlarmTimeType = EnumGuardModeAlarmTimeType.CUSTOM_TIME;
      if (j.a(str, localEnumGuardModeAlarmTimeType.getValue())) {
        localObject = localEnumGuardModeAlarmTimeType;
      }
    }
    return (EnumGuardModeAlarmTimeType)localObject;
  }
  
  public final int getTime()
  {
    return this.time;
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    String str = this.type;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.time;
  }
  
  public final void setTime(int paramInt)
  {
    this.time = paramInt;
  }
  
  public final void setType(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.type = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuardModeAlarmTimeBean(type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.time);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
  {
    public final GuardModeAlarmTimeBean getDefault()
    {
      return new GuardModeAlarmTimeBean(GuardModeAlarmTimeBean.access$getDEFAULT$cp().getType(), GuardModeAlarmTimeBean.access$getDEFAULT$cp().getTime());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\result\GuardModeAlarmTimeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */