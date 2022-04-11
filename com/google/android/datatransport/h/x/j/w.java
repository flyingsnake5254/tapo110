package com.google.android.datatransport.h.x.j;

final class w
  extends z
{
  private final long b;
  private final int c;
  private final int d;
  private final long e;
  private final int f;
  
  private w(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3)
  {
    this.b = paramLong1;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramLong2;
    this.f = paramInt3;
  }
  
  int b()
  {
    return this.d;
  }
  
  long c()
  {
    return this.e;
  }
  
  int d()
  {
    return this.c;
  }
  
  int e()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof z))
    {
      paramObject = (z)paramObject;
      if ((this.b != ((z)paramObject).f()) || (this.c != ((z)paramObject).d()) || (this.d != ((z)paramObject).b()) || (this.e != ((z)paramObject).c()) || (this.f != ((z)paramObject).e())) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  long f()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    long l = this.b;
    int i = (int)(l ^ l >>> 32);
    int j = this.c;
    int k = this.d;
    l = this.e;
    int m = (int)(l >>> 32 ^ l);
    return this.f ^ ((((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m) * 1000003;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EventStoreConfig{maxStorageSizeInBytes=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", loadBatchSize=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", criticalSectionEnterTimeoutMs=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", eventCleanUpAge=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", maxBlobByteSizePerRow=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class b
    extends z.a
  {
    private Long a;
    private Integer b;
    private Integer c;
    private Long d;
    private Integer e;
    
    z a()
    {
      Object localObject1 = this.a;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" maxStorageSizeInBytes");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.b == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" loadBatchSize");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.c == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" criticalSectionEnterTimeoutMs");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.d == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" eventCleanUpAge");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.e == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" maxBlobByteSizePerRow");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new w(this.a.longValue(), this.b.intValue(), this.c.intValue(), this.d.longValue(), this.e.intValue(), null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    z.a b(int paramInt)
    {
      this.c = Integer.valueOf(paramInt);
      return this;
    }
    
    z.a c(long paramLong)
    {
      this.d = Long.valueOf(paramLong);
      return this;
    }
    
    z.a d(int paramInt)
    {
      this.b = Integer.valueOf(paramInt);
      return this;
    }
    
    z.a e(int paramInt)
    {
      this.e = Integer.valueOf(paramInt);
      return this;
    }
    
    z.a f(long paramLong)
    {
      this.a = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\x\j\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */