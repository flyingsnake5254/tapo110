package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.r;

public class f
  extends l
{
  private j c;
  private q d;
  private b f;
  private n0 p0;
  private m p1;
  private a q;
  private j x;
  private c y;
  private r z;
  
  private f(r paramr)
  {
    if ((paramr.size() >= 6) && (paramr.size() <= 9))
    {
      int i = 0;
      if ((paramr.p(0) instanceof j))
      {
        this.c = j.m(paramr.p(0));
        i = 1;
      }
      else
      {
        this.c = new j(0L);
      }
      this.d = q.f(paramr.p(i));
      this.f = b.f(paramr.p(i + 1));
      this.q = a.g(paramr.p(i + 2));
      this.x = j.m(paramr.p(i + 3));
      this.y = c.f(paramr.p(i + 4));
      this.z = r.m(paramr.p(i + 5));
      i += 6;
      while (i < paramr.size())
      {
        localObject = paramr.p(i);
        if ((localObject instanceof n0)) {
          this.p0 = n0.s(paramr.p(i));
        } else if (((localObject instanceof r)) || ((localObject instanceof m))) {
          this.p1 = m.k(paramr.p(i));
        }
        i++;
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramr.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static f j(Object paramObject)
  {
    if ((paramObject instanceof f)) {
      return (f)paramObject;
    }
    if (paramObject != null) {
      return new f(r.m(paramObject));
    }
    return null;
  }
  
  public org.bouncycastle.asn1.q c()
  {
    org.bouncycastle.asn1.f localf = new org.bouncycastle.asn1.f();
    if (this.c.p().intValue() != 0) {
      localf.a(this.c);
    }
    localf.a(this.d);
    localf.a(this.f);
    localf.a(this.q);
    localf.a(this.x);
    localf.a(this.y);
    localf.a(this.z);
    Object localObject = this.p0;
    if (localObject != null) {
      localf.a((e)localObject);
    }
    localObject = this.p1;
    if (localObject != null) {
      localf.a((e)localObject);
    }
    return new b1(localf);
  }
  
  public c f()
  {
    return this.y;
  }
  
  public r g()
  {
    return this.z;
  }
  
  public m h()
  {
    return this.p1;
  }
  
  public q i()
  {
    return this.d;
  }
  
  public b k()
  {
    return this.f;
  }
  
  public n0 l()
  {
    return this.p0;
  }
  
  public j m()
  {
    return this.x;
  }
  
  public a n()
  {
    return this.q;
  }
  
  public j o()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */