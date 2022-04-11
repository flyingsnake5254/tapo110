package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t2.c;
import org.bouncycastle.asn1.x;

public class y
  extends l
{
  m H3;
  r c;
  j d;
  j f;
  c p0;
  w p1;
  n0 p2;
  n0 p3;
  a q;
  c x;
  z y;
  z z;
  
  private y(r paramr)
  {
    this.c = paramr;
    if ((paramr.p(0) instanceof x))
    {
      this.d = j.n((x)paramr.p(0), true);
      i = 0;
    }
    else
    {
      this.d = new j(0L);
      i = -1;
    }
    if (this.d.p().equals(BigInteger.valueOf(0L))) {}
    int m;
    for (int j = 1;; j = 0)
    {
      k = 0;
      m = j;
      j = k;
      break;
      if (this.d.p().equals(BigInteger.valueOf(1L)))
      {
        m = 0;
        j = 1;
        break;
      }
      if (!this.d.p().equals(BigInteger.valueOf(2L))) {
        break label393;
      }
    }
    this.f = j.m(paramr.p(i + 1));
    this.q = a.g(paramr.p(i + 2));
    this.x = c.f(paramr.p(i + 3));
    Object localObject = (r)paramr.p(i + 4);
    this.y = z.g(((r)localObject).p(0));
    this.z = z.g(((r)localObject).p(1));
    this.p0 = c.f(paramr.p(i + 5));
    int n = i + 6;
    this.p1 = w.h(paramr.p(n));
    int k = paramr.size() - n - 1;
    int i = k;
    if (k != 0) {
      if (m == 0) {
        i = k;
      } else {
        throw new IllegalArgumentException("version 1 certificate contains extra data");
      }
    }
    while (i > 0)
    {
      localObject = (x)paramr.p(n + i);
      m = ((x)localObject).p();
      if (m != 1)
      {
        if (m != 2)
        {
          if (m == 3) {
            if (j == 0) {
              this.H3 = m.k(r.n((x)localObject, true));
            } else {
              throw new IllegalArgumentException("version 2 certificate cannot contain extensions");
            }
          }
        }
        else {
          this.p3 = n0.t((x)localObject, false);
        }
      }
      else {
        this.p2 = n0.t((x)localObject, false);
      }
      i--;
    }
    return;
    label393:
    throw new IllegalArgumentException("version number not recognised");
  }
  
  public static y h(Object paramObject)
  {
    if ((paramObject instanceof y)) {
      return (y)paramObject;
    }
    if (paramObject != null) {
      return new y(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    return this.c;
  }
  
  public z f()
  {
    return this.z;
  }
  
  public m g()
  {
    return this.H3;
  }
  
  public c i()
  {
    return this.x;
  }
  
  public n0 j()
  {
    return this.p2;
  }
  
  public j k()
  {
    return this.f;
  }
  
  public a l()
  {
    return this.q;
  }
  
  public z m()
  {
    return this.y;
  }
  
  public c n()
  {
    return this.p0;
  }
  
  public w o()
  {
    return this.p1;
  }
  
  public n0 p()
  {
    return this.p3;
  }
  
  public int q()
  {
    return this.d.p().intValue() + 1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */