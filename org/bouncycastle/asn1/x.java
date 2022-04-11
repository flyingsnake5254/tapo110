package org.bouncycastle.asn1;

import java.io.IOException;

public abstract class x
  extends q
  implements e, s1
{
  int c;
  boolean d = false;
  boolean f = true;
  e q = null;
  
  public x(boolean paramBoolean, int paramInt, e parame)
  {
    if ((parame instanceof d)) {
      this.f = true;
    } else {
      this.f = paramBoolean;
    }
    this.c = paramInt;
    if (this.f) {}
    for (;;)
    {
      this.q = parame;
      break;
      paramBoolean = parame.c() instanceof t;
    }
  }
  
  public static x m(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof x)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = m(q.i((byte[])paramObject));
          return (x)paramObject;
        }
        catch (IOException paramObject)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("failed to construct tagged object from byte[]: ");
          localStringBuilder.append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (x)paramObject;
  }
  
  public static x n(x paramx, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (x)paramx.o();
    }
    throw new IllegalArgumentException("implicitly tagged tagged object");
  }
  
  public q b()
  {
    return c();
  }
  
  boolean f(q paramq)
  {
    if (!(paramq instanceof x)) {
      return false;
    }
    x localx = (x)paramq;
    if ((this.c == localx.c) && (this.d == localx.d) && (this.f == localx.f))
    {
      paramq = this.q;
      if (paramq == null)
      {
        if (localx.q != null) {
          return false;
        }
      }
      else if (!paramq.c().equals(localx.q.c())) {
        return false;
      }
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = this.c;
    e locale = this.q;
    int j = i;
    if (locale != null) {
      j = i ^ locale.hashCode();
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    return this.d;
  }
  
  q k()
  {
    return new g1(this.f, this.c, this.q);
  }
  
  q l()
  {
    return new q1(this.f, this.c, this.q);
  }
  
  public q o()
  {
    e locale = this.q;
    if (locale != null) {
      return locale.c();
    }
    return null;
  }
  
  public int p()
  {
    return this.c;
  }
  
  public boolean q()
  {
    return this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    localStringBuilder.append(this.q);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */