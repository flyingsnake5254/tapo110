package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.h.y.a;
import java.util.Map;
import java.util.Objects;

final class n
  extends SchedulerConfig
{
  private final a a;
  private final Map<Priority, SchedulerConfig.b> b;
  
  n(a parama, Map<Priority, SchedulerConfig.b> paramMap)
  {
    Objects.requireNonNull(parama, "Null clock");
    this.a = parama;
    Objects.requireNonNull(paramMap, "Null values");
    this.b = paramMap;
  }
  
  a e()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof SchedulerConfig))
    {
      paramObject = (SchedulerConfig)paramObject;
      if ((!this.a.equals(((SchedulerConfig)paramObject).e())) || (!this.b.equals(((SchedulerConfig)paramObject).h()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  Map<Priority, SchedulerConfig.b> h()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    return (this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SchedulerConfig{clock=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", values=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */