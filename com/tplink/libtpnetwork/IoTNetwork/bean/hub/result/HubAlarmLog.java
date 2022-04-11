package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import b.d.w.h.a;
import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingEventLog;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode.a;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class HubAlarmLog
{
  @c("device_id")
  private String deviceId;
  private String eventId;
  @c("guard_mode")
  private String guardMode;
  private int id;
  @b(Base64TypeAdapter.class)
  private String nickname;
  private long timestamp;
  
  public HubAlarmLog(int paramInt, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.id = paramInt;
    this.timestamp = paramLong;
    this.guardMode = paramString1;
    this.deviceId = paramString2;
    this.nickname = paramString3;
  }
  
  public HubAlarmLog(ThingEventLog paramThingEventLog)
  {
    this(i, paramThingEventLog.getTimestamp(), null, null, null);
    this.eventId = paramThingEventLog.getEventId();
    localObject1 = paramThingEventLog.getParams();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((Map)localObject1).get("guard_mode");
    } else {
      localObject1 = null;
    }
    Object localObject3 = localObject1;
    if (!(localObject1 instanceof String)) {
      localObject3 = null;
    }
    this.guardMode = ((String)localObject3);
    localObject1 = paramThingEventLog.getParams();
    if (localObject1 != null) {
      localObject1 = ((Map)localObject1).get("device_id");
    } else {
      localObject1 = null;
    }
    localObject3 = localObject1;
    if (!(localObject1 instanceof String)) {
      localObject3 = null;
    }
    this.deviceId = ((String)localObject3);
    paramThingEventLog = paramThingEventLog.getParams();
    if (paramThingEventLog != null) {
      paramThingEventLog = paramThingEventLog.get("nickname");
    } else {
      paramThingEventLog = null;
    }
    if (!(paramThingEventLog instanceof String)) {
      paramThingEventLog = (ThingEventLog)localObject2;
    }
    this.nickname = a.a((String)paramThingEventLog);
  }
  
  public final int component1()
  {
    return this.id;
  }
  
  public final long component2()
  {
    return this.timestamp;
  }
  
  public final String component3()
  {
    return this.guardMode;
  }
  
  public final String component4()
  {
    return this.deviceId;
  }
  
  public final String component5()
  {
    return this.nickname;
  }
  
  public final HubAlarmLog copy(int paramInt, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    return new HubAlarmLog(paramInt, paramLong, paramString1, paramString2, paramString3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof HubAlarmLog))
      {
        paramObject = (HubAlarmLog)paramObject;
        if ((this.id == ((HubAlarmLog)paramObject).id) && (this.timestamp == ((HubAlarmLog)paramObject).timestamp) && (j.a(this.guardMode, ((HubAlarmLog)paramObject).guardMode)) && (j.a(this.deviceId, ((HubAlarmLog)paramObject).deviceId)) && (j.a(this.nickname, ((HubAlarmLog)paramObject).nickname))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getDeviceId()
  {
    return this.deviceId;
  }
  
  public final EnumGuardMode getEnumGuardMode()
  {
    return EnumGuardMode.Companion.b(this.guardMode);
  }
  
  public final String getEventId()
  {
    return this.eventId;
  }
  
  public final String getGuardMode()
  {
    return this.guardMode;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final String getNickname()
  {
    return this.nickname;
  }
  
  public final long getTimestamp()
  {
    return this.timestamp;
  }
  
  public int hashCode()
  {
    int i = this.id;
    long l = this.timestamp;
    int j = (int)(l ^ l >>> 32);
    String str = this.guardMode;
    int k = 0;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.deviceId;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.nickname;
    if (str != null) {
      k = str.hashCode();
    }
    return (((i * 31 + j) * 31 + m) * 31 + n) * 31 + k;
  }
  
  public final void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public final void setEventId(String paramString)
  {
    this.eventId = paramString;
  }
  
  public final void setGuardMode(String paramString)
  {
    this.guardMode = paramString;
  }
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
  
  public final void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HubAlarmLog(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", timestamp=");
    localStringBuilder.append(this.timestamp);
    localStringBuilder.append(", guardMode=");
    localStringBuilder.append(this.guardMode);
    localStringBuilder.append(", deviceId=");
    localStringBuilder.append(this.deviceId);
    localStringBuilder.append(", nickname=");
    localStringBuilder.append(this.nickname);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\result\HubAlarmLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */