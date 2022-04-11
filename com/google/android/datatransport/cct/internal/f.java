package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import java.util.Arrays;

final class f
  extends k
{
  private final long a;
  private final Integer b;
  private final long c;
  private final byte[] d;
  private final String e;
  private final long f;
  private final NetworkConnectionInfo g;
  
  private f(long paramLong1, @Nullable Integer paramInteger, long paramLong2, @Nullable byte[] paramArrayOfByte, @Nullable String paramString, long paramLong3, @Nullable NetworkConnectionInfo paramNetworkConnectionInfo)
  {
    this.a = paramLong1;
    this.b = paramInteger;
    this.c = paramLong2;
    this.d = paramArrayOfByte;
    this.e = paramString;
    this.f = paramLong3;
    this.g = paramNetworkConnectionInfo;
  }
  
  @Nullable
  public Integer b()
  {
    return this.b;
  }
  
  public long c()
  {
    return this.a;
  }
  
  public long d()
  {
    return this.c;
  }
  
  @Nullable
  public NetworkConnectionInfo e()
  {
    return this.g;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof k))
    {
      k localk = (k)paramObject;
      if (this.a == localk.c())
      {
        paramObject = this.b;
        if ((paramObject == null ? localk.b() == null : ((Integer)paramObject).equals(localk.b())) && (this.c == localk.d()))
        {
          byte[] arrayOfByte = this.d;
          if ((localk instanceof f)) {
            paramObject = ((f)localk).d;
          } else {
            paramObject = localk.f();
          }
          if (Arrays.equals(arrayOfByte, (byte[])paramObject))
          {
            paramObject = this.e;
            if ((paramObject == null ? localk.g() == null : ((String)paramObject).equals(localk.g())) && (this.f == localk.h()))
            {
              paramObject = this.g;
              if (paramObject == null ? localk.e() == null : paramObject.equals(localk.e())) {
                break label190;
              }
            }
          }
        }
      }
      bool = false;
      label190:
      return bool;
    }
    return false;
  }
  
  @Nullable
  public byte[] f()
  {
    return this.d;
  }
  
  @Nullable
  public String g()
  {
    return this.e;
  }
  
  public long h()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    long l = this.a;
    int i = (int)(l ^ l >>> 32);
    Object localObject = this.b;
    int j = 0;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((Integer)localObject).hashCode();
    }
    l = this.c;
    int m = (int)(l ^ l >>> 32);
    int n = Arrays.hashCode(this.d);
    localObject = this.e;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((String)localObject).hashCode();
    }
    l = this.f;
    int i2 = (int)(l >>> 32 ^ l);
    localObject = this.g;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return ((((((i ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ i2) * 1000003 ^ j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LogEvent{eventTimeMs=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", eventCode=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", eventUptimeMs=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", sourceExtension=");
    localStringBuilder.append(Arrays.toString(this.d));
    localStringBuilder.append(", sourceExtensionJsonProto3=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", timezoneOffsetSeconds=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", networkConnectionInfo=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class b
    extends k.a
  {
    private Long a;
    private Integer b;
    private Long c;
    private byte[] d;
    private String e;
    private Long f;
    private NetworkConnectionInfo g;
    
    public k a()
    {
      Object localObject1 = this.a;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" eventTimeMs");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.c == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" eventUptimeMs");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.f == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" timezoneOffsetSeconds");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new f(this.a.longValue(), this.b, this.c.longValue(), this.d, this.e, this.f.longValue(), this.g, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public k.a b(@Nullable Integer paramInteger)
    {
      this.b = paramInteger;
      return this;
    }
    
    public k.a c(long paramLong)
    {
      this.a = Long.valueOf(paramLong);
      return this;
    }
    
    public k.a d(long paramLong)
    {
      this.c = Long.valueOf(paramLong);
      return this;
    }
    
    public k.a e(@Nullable NetworkConnectionInfo paramNetworkConnectionInfo)
    {
      this.g = paramNetworkConnectionInfo;
      return this;
    }
    
    k.a f(@Nullable byte[] paramArrayOfByte)
    {
      this.d = paramArrayOfByte;
      return this;
    }
    
    k.a g(@Nullable String paramString)
    {
      this.e = paramString;
      return this;
    }
    
    public k.a h(long paramLong)
    {
      this.f = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */