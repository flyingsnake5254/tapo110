package com.tplink.iot.adapter.iotsensor;

import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.TriggerLog;
import kotlin.jvm.internal.j;

public final class a
{
  public static final a a = new a(null);
  private final boolean b;
  private final boolean c;
  private final int d;
  private Long e;
  private TriggerLog f;
  
  public a(int paramInt, Long paramLong, TriggerLog paramTriggerLog)
  {
    this.d = paramInt;
    this.e = paramLong;
    this.f = paramTriggerLog;
    boolean bool1 = false;
    if (paramInt == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.b = bool2;
    boolean bool2 = bool1;
    if (paramInt == 2) {
      bool2 = true;
    }
    this.c = bool2;
  }
  
  public final Long a()
  {
    return this.e;
  }
  
  public final TriggerLog b()
  {
    return this.f;
  }
  
  public final boolean c()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.d == ((a)paramObject).d) && (j.a(this.e, ((a)paramObject).e)) && (j.a(this.f, ((a)paramObject).f))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = this.d;
    Object localObject = this.e;
    int j = 0;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.f;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (i * 31 + k) * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SensorTriggerLogItem(type=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", timestamp=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", triggerLog=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\iotsensor\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */