package com.google.android.datatransport.h;

import androidx.annotation.Nullable;
import java.util.Map;
import java.util.Objects;

final class b
  extends i
{
  private final String a;
  private final Integer b;
  private final h c;
  private final long d;
  private final long e;
  private final Map<String, String> f;
  
  private b(String paramString, @Nullable Integer paramInteger, h paramh, long paramLong1, long paramLong2, Map<String, String> paramMap)
  {
    this.a = paramString;
    this.b = paramInteger;
    this.c = paramh;
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramMap;
  }
  
  protected Map<String, String> c()
  {
    return this.f;
  }
  
  @Nullable
  public Integer d()
  {
    return this.b;
  }
  
  public h e()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof i))
    {
      paramObject = (i)paramObject;
      if (this.a.equals(((i)paramObject).j()))
      {
        Integer localInteger = this.b;
        if ((localInteger == null ? ((i)paramObject).d() == null : localInteger.equals(((i)paramObject).d())) && (this.c.equals(((i)paramObject).e())) && (this.d == ((i)paramObject).f()) && (this.e == ((i)paramObject).k()) && (this.f.equals(((i)paramObject).c()))) {}
      }
      else
      {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public long f()
  {
    return this.d;
  }
  
  public int hashCode()
  {
    int i = this.a.hashCode();
    Integer localInteger = this.b;
    int j;
    if (localInteger == null) {
      j = 0;
    } else {
      j = localInteger.hashCode();
    }
    int k = this.c.hashCode();
    long l = this.d;
    int m = (int)(l ^ l >>> 32);
    l = this.e;
    return (((((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ (int)(l ^ l >>> 32)) * 1000003 ^ this.f.hashCode();
  }
  
  public String j()
  {
    return this.a;
  }
  
  public long k()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EventInternal{transportName=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", code=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", encodedPayload=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", eventMillis=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", uptimeMillis=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", autoMetadata=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class b
    extends i.a
  {
    private String a;
    private Integer b;
    private h c;
    private Long d;
    private Long e;
    private Map<String, String> f;
    
    public i d()
    {
      Object localObject1 = this.a;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" transportName");
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = localObject2;
      if (this.c == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" encodedPayload");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.d == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" eventMillis");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.e == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" uptimeMillis");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.f == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" autoMetadata");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new b(this.a, this.b, this.c, this.d.longValue(), this.e.longValue(), this.f, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    protected Map<String, String> e()
    {
      Map localMap = this.f;
      if (localMap != null) {
        return localMap;
      }
      throw new IllegalStateException("Property \"autoMetadata\" has not been set");
    }
    
    protected i.a f(Map<String, String> paramMap)
    {
      Objects.requireNonNull(paramMap, "Null autoMetadata");
      this.f = paramMap;
      return this;
    }
    
    public i.a g(Integer paramInteger)
    {
      this.b = paramInteger;
      return this;
    }
    
    public i.a h(h paramh)
    {
      Objects.requireNonNull(paramh, "Null encodedPayload");
      this.c = paramh;
      return this;
    }
    
    public i.a i(long paramLong)
    {
      this.d = Long.valueOf(paramLong);
      return this;
    }
    
    public i.a j(String paramString)
    {
      Objects.requireNonNull(paramString, "Null transportName");
      this.a = paramString;
      return this;
    }
    
    public i.a k(long paramLong)
    {
      this.e = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */