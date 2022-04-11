package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo.Builder;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.h.y.a;
import com.google.auto.value.AutoValue;
import com.google.auto.value.AutoValue.Builder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@AutoValue
public abstract class SchedulerConfig
{
  private long a(int paramInt, long paramLong)
  {
    
    long l;
    if (paramLong > 1L) {
      l = paramLong;
    } else {
      l = 2L;
    }
    double d = Math.max(1.0D, Math.log(10000.0D) / Math.log(l * paramInt));
    return (Math.pow(3.0D, paramInt) * paramLong * d);
  }
  
  public static a b()
  {
    return new a();
  }
  
  static SchedulerConfig d(a parama, Map<Priority, b> paramMap)
  {
    return new n(parama, paramMap);
  }
  
  public static SchedulerConfig f(a parama)
  {
    return b().a(Priority.DEFAULT, b.a().b(30000L).d(86400000L).a()).a(Priority.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(Priority.VERY_LOW, b.a().b(86400000L).d(86400000L).c(i(new Flag[] { Flag.NETWORK_UNMETERED, Flag.DEVICE_IDLE })).a()).c(parama).b();
  }
  
  private static <T> Set<T> i(T... paramVarArgs)
  {
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(paramVarArgs)));
  }
  
  @RequiresApi(api=21)
  private void j(JobInfo.Builder paramBuilder, Set<Flag> paramSet)
  {
    if (paramSet.contains(Flag.NETWORK_UNMETERED)) {
      paramBuilder.setRequiredNetworkType(2);
    } else {
      paramBuilder.setRequiredNetworkType(1);
    }
    if (paramSet.contains(Flag.DEVICE_CHARGING)) {
      paramBuilder.setRequiresCharging(true);
    }
    if (paramSet.contains(Flag.DEVICE_IDLE)) {
      paramBuilder.setRequiresDeviceIdle(true);
    }
  }
  
  @RequiresApi(api=21)
  public JobInfo.Builder c(JobInfo.Builder paramBuilder, Priority paramPriority, long paramLong, int paramInt)
  {
    paramBuilder.setMinimumLatency(g(paramPriority, paramLong, paramInt));
    j(paramBuilder, ((b)h().get(paramPriority)).c());
    return paramBuilder;
  }
  
  abstract a e();
  
  public long g(Priority paramPriority, long paramLong, int paramInt)
  {
    long l = e().a();
    paramPriority = (b)h().get(paramPriority);
    return Math.min(Math.max(a(paramInt, paramPriority.b()), paramLong - l), paramPriority.d());
  }
  
  abstract Map<Priority, b> h();
  
  public static enum Flag
  {
    static
    {
      Flag localFlag1 = new Flag("NETWORK_UNMETERED", 0);
      NETWORK_UNMETERED = localFlag1;
      Flag localFlag2 = new Flag("DEVICE_IDLE", 1);
      DEVICE_IDLE = localFlag2;
      Flag localFlag3 = new Flag("DEVICE_CHARGING", 2);
      DEVICE_CHARGING = localFlag3;
      $VALUES = new Flag[] { localFlag1, localFlag2, localFlag3 };
    }
  }
  
  public static class a
  {
    private a a;
    private Map<Priority, SchedulerConfig.b> b = new HashMap();
    
    public a a(Priority paramPriority, SchedulerConfig.b paramb)
    {
      this.b.put(paramPriority, paramb);
      return this;
    }
    
    public SchedulerConfig b()
    {
      Objects.requireNonNull(this.a, "missing required property: clock");
      if (this.b.keySet().size() >= Priority.values().length)
      {
        Map localMap = this.b;
        this.b = new HashMap();
        return SchedulerConfig.d(this.a, localMap);
      }
      throw new IllegalStateException("Not all priorities have been configured");
    }
    
    public a c(a parama)
    {
      this.a = parama;
      return this;
    }
  }
  
  @AutoValue
  public static abstract class b
  {
    public static a a()
    {
      return new o.b().c(Collections.emptySet());
    }
    
    abstract long b();
    
    abstract Set<SchedulerConfig.Flag> c();
    
    abstract long d();
    
    @AutoValue.Builder
    public static abstract class a
    {
      public abstract SchedulerConfig.b a();
      
      public abstract a b(long paramLong);
      
      public abstract a c(Set<SchedulerConfig.Flag> paramSet);
      
      public abstract a d(long paramLong);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\SchedulerConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */