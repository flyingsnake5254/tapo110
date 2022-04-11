package com.tplink.iot.model.iot;

import kotlin.jvm.internal.j;

public final class c
{
  public static final a a = new a(null);
  private boolean b;
  private final int c;
  private final String d;
  private final com.tplink.iot.g.a.a.b e;
  private final b f;
  
  public c(int paramInt, String paramString, com.tplink.iot.g.a.a.b paramb, b paramb1)
  {
    this.c = paramInt;
    this.d = paramString;
    this.e = paramb;
    this.f = paramb1;
  }
  
  public c(com.tplink.iot.g.a.a.b paramb)
  {
    this(1, null, paramb, null, 8, null);
  }
  
  public c(b paramb)
  {
    this(2, null, null, paramb);
  }
  
  public c(String paramString)
  {
    this(0, paramString, null, null, 12, null);
  }
  
  public final com.tplink.iot.g.a.a.b a()
  {
    return this.e;
  }
  
  public final b b()
  {
    return this.f;
  }
  
  public final String c()
  {
    return this.d;
  }
  
  public final int d()
  {
    return this.c;
  }
  
  public final boolean e()
  {
    int i = this.c;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.c == ((c)paramObject).c) && (j.a(this.d, ((c)paramObject).d)) && (j.a(this.e, ((c)paramObject).e)) && (j.a(this.f, ((c)paramObject).f))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean f()
  {
    return this.b;
  }
  
  public final void g(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public int hashCode()
  {
    int i = this.c;
    Object localObject = this.d;
    int j = 0;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.e;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.f;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return ((i * 31 + k) * 31 + m) * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeaturedActionDeviceSelectBean(type=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", title=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", deviceInfo=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", devicePlaceholder=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\iot\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */