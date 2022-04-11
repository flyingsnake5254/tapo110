package com.google.android.datatransport.h;

import com.google.android.datatransport.b;
import com.google.android.datatransport.d;
import java.util.Objects;

final class c
  extends m
{
  private final n a;
  private final String b;
  private final com.google.android.datatransport.c<?> c;
  private final d<?, byte[]> d;
  private final b e;
  
  private c(n paramn, String paramString, com.google.android.datatransport.c<?> paramc, d<?, byte[]> paramd, b paramb)
  {
    this.a = paramn;
    this.b = paramString;
    this.c = paramc;
    this.d = paramd;
    this.e = paramb;
  }
  
  public b b()
  {
    return this.e;
  }
  
  com.google.android.datatransport.c<?> c()
  {
    return this.c;
  }
  
  d<?, byte[]> e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof m))
    {
      paramObject = (m)paramObject;
      if ((!this.a.equals(((m)paramObject).f())) || (!this.b.equals(((m)paramObject).g())) || (!this.c.equals(((m)paramObject).c())) || (!this.d.equals(((m)paramObject).e())) || (!this.e.equals(((m)paramObject).b()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public n f()
  {
    return this.a;
  }
  
  public String g()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    return ((((this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode()) * 1000003 ^ this.d.hashCode()) * 1000003 ^ this.e.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SendRequest{transportContext=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", transportName=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", event=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", transformer=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", encoding=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class b
    extends m.a
  {
    private n a;
    private String b;
    private com.google.android.datatransport.c<?> c;
    private d<?, byte[]> d;
    private b e;
    
    public m a()
    {
      Object localObject1 = this.a;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" transportContext");
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = localObject2;
      if (this.b == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" transportName");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.c == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" event");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.d == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" transformer");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.e == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" encoding");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new c(this.a, this.b, this.c, this.d, this.e, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    m.a b(b paramb)
    {
      Objects.requireNonNull(paramb, "Null encoding");
      this.e = paramb;
      return this;
    }
    
    m.a c(com.google.android.datatransport.c<?> paramc)
    {
      Objects.requireNonNull(paramc, "Null event");
      this.c = paramc;
      return this;
    }
    
    m.a d(d<?, byte[]> paramd)
    {
      Objects.requireNonNull(paramd, "Null transformer");
      this.d = paramd;
      return this;
    }
    
    public m.a e(n paramn)
    {
      Objects.requireNonNull(paramn, "Null transportContext");
      this.a = paramn;
      return this;
    }
    
    public m.a f(String paramString)
    {
      Objects.requireNonNull(paramString, "Null transportName");
      this.b = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */