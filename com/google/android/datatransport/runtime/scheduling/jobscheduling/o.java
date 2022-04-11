package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Objects;
import java.util.Set;

final class o
  extends SchedulerConfig.b
{
  private final long a;
  private final long b;
  private final Set<SchedulerConfig.Flag> c;
  
  private o(long paramLong1, long paramLong2, Set<SchedulerConfig.Flag> paramSet)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramSet;
  }
  
  long b()
  {
    return this.a;
  }
  
  Set<SchedulerConfig.Flag> c()
  {
    return this.c;
  }
  
  long d()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof SchedulerConfig.b))
    {
      paramObject = (SchedulerConfig.b)paramObject;
      if ((this.a != ((SchedulerConfig.b)paramObject).b()) || (this.b != ((SchedulerConfig.b)paramObject).d()) || (!this.c.equals(((SchedulerConfig.b)paramObject).c()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = this.a;
    int i = (int)(l ^ l >>> 32);
    l = this.b;
    int j = (int)(l >>> 32 ^ l);
    return this.c.hashCode() ^ ((i ^ 0xF4243) * 1000003 ^ j) * 1000003;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConfigValue{delta=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", maxAllowedDelay=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", flags=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class b
    extends SchedulerConfig.b.a
  {
    private Long a;
    private Long b;
    private Set<SchedulerConfig.Flag> c;
    
    public SchedulerConfig.b a()
    {
      Object localObject1 = this.a;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" delta");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.b == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" maxAllowedDelay");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.c == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" flags");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new o(this.a.longValue(), this.b.longValue(), this.c, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public SchedulerConfig.b.a b(long paramLong)
    {
      this.a = Long.valueOf(paramLong);
      return this;
    }
    
    public SchedulerConfig.b.a c(Set<SchedulerConfig.Flag> paramSet)
    {
      Objects.requireNonNull(paramSet, "Null flags");
      this.c = paramSet;
      return this;
    }
    
    public SchedulerConfig.b.a d(long paramLong)
    {
      this.b = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */