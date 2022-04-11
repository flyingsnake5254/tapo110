package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.firebase.encoders.annotations.Encodable.Field;
import java.util.List;

final class g
  extends l
{
  private final long a;
  private final long b;
  private final ClientInfo c;
  private final Integer d;
  private final String e;
  private final List<k> f;
  private final QosTier g;
  
  private g(long paramLong1, long paramLong2, @Nullable ClientInfo paramClientInfo, @Nullable Integer paramInteger, @Nullable String paramString, @Nullable List<k> paramList, @Nullable QosTier paramQosTier)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramClientInfo;
    this.d = paramInteger;
    this.e = paramString;
    this.f = paramList;
    this.g = paramQosTier;
  }
  
  @Nullable
  public ClientInfo b()
  {
    return this.c;
  }
  
  @Encodable.Field(name="logEvent")
  @Nullable
  public List<k> c()
  {
    return this.f;
  }
  
  @Nullable
  public Integer d()
  {
    return this.d;
  }
  
  @Nullable
  public String e()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof l))
    {
      paramObject = (l)paramObject;
      if ((this.a == ((l)paramObject).g()) && (this.b == ((l)paramObject).h()))
      {
        Object localObject = this.c;
        if (localObject == null ? ((l)paramObject).b() == null : localObject.equals(((l)paramObject).b()))
        {
          localObject = this.d;
          if (localObject == null ? ((l)paramObject).d() == null : ((Integer)localObject).equals(((l)paramObject).d()))
          {
            localObject = this.e;
            if (localObject == null ? ((l)paramObject).e() == null : ((String)localObject).equals(((l)paramObject).e()))
            {
              localObject = this.f;
              if (localObject == null ? ((l)paramObject).c() == null : ((List)localObject).equals(((l)paramObject).c()))
              {
                localObject = this.g;
                if (localObject == null ? ((l)paramObject).f() == null : ((Enum)localObject).equals(((l)paramObject).f())) {
                  break label202;
                }
              }
            }
          }
        }
      }
      bool = false;
      label202:
      return bool;
    }
    return false;
  }
  
  @Nullable
  public QosTier f()
  {
    return this.g;
  }
  
  public long g()
  {
    return this.a;
  }
  
  public long h()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    long l = this.a;
    int i = (int)(l ^ l >>> 32);
    l = this.b;
    int j = (int)(l >>> 32 ^ l);
    Object localObject = this.c;
    int k = 0;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = localObject.hashCode();
    }
    localObject = this.d;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = ((Integer)localObject).hashCode();
    }
    localObject = this.e;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((String)localObject).hashCode();
    }
    localObject = this.f;
    int i2;
    if (localObject == null) {
      i2 = 0;
    } else {
      i2 = ((List)localObject).hashCode();
    }
    localObject = this.g;
    if (localObject != null) {
      k = ((Enum)localObject).hashCode();
    }
    return ((((((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ i2) * 1000003 ^ k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LogRequest{requestTimeMs=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", requestUptimeMs=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", clientInfo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", logSource=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", logSourceName=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", logEvents=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", qosTier=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class b
    extends l.a
  {
    private Long a;
    private Long b;
    private ClientInfo c;
    private Integer d;
    private String e;
    private List<k> f;
    private QosTier g;
    
    public l a()
    {
      Object localObject1 = this.a;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" requestTimeMs");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.b == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" requestUptimeMs");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new g(this.a.longValue(), this.b.longValue(), this.c, this.d, this.e, this.f, this.g, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public l.a b(@Nullable ClientInfo paramClientInfo)
    {
      this.c = paramClientInfo;
      return this;
    }
    
    public l.a c(@Nullable List<k> paramList)
    {
      this.f = paramList;
      return this;
    }
    
    l.a d(@Nullable Integer paramInteger)
    {
      this.d = paramInteger;
      return this;
    }
    
    l.a e(@Nullable String paramString)
    {
      this.e = paramString;
      return this;
    }
    
    public l.a f(@Nullable QosTier paramQosTier)
    {
      this.g = paramQosTier;
      return this;
    }
    
    public l.a g(long paramLong)
    {
      this.a = Long.valueOf(paramLong);
      return this;
    }
    
    public l.a h(long paramLong)
    {
      this.b = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */