package org.bouncycastle.asn1.r2;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

public class b
  extends l
{
  BigInteger c = BigInteger.valueOf(0L);
  a d;
  j f;
  n q;
  j x;
  n y;
  
  private b(r paramr)
  {
    int i = 0;
    if ((paramr.p(0) instanceof x))
    {
      x localx = (x)paramr.p(0);
      if ((localx.q()) && (localx.p() == 0))
      {
        this.c = j.m(localx.b()).p();
        i = 1;
      }
      else
      {
        throw new IllegalArgumentException("object parse error");
      }
    }
    this.d = a.f(paramr.p(i));
    i++;
    this.f = j.m(paramr.p(i));
    i++;
    this.q = n.m(paramr.p(i));
    i++;
    this.x = j.m(paramr.p(i));
    this.y = n.m(paramr.p(i + 1));
  }
  
  public static b j(Object paramObject)
  {
    if ((paramObject instanceof b)) {
      return (b)paramObject;
    }
    if (paramObject != null) {
      return new b(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    if (this.c.compareTo(BigInteger.valueOf(0L)) != 0) {
      localf.a(new g1(true, 0, new j(this.c)));
    }
    localf.a(this.d);
    localf.a(this.f);
    localf.a(this.q);
    localf.a(this.x);
    localf.a(this.y);
    return new b1(localf);
  }
  
  public BigInteger f()
  {
    return this.f.p();
  }
  
  public byte[] g()
  {
    return org.bouncycastle.util.a.g(this.q.o());
  }
  
  public a h()
  {
    return this.d;
  }
  
  public byte[] i()
  {
    return org.bouncycastle.util.a.g(this.y.o());
  }
  
  public BigInteger k()
  {
    return this.x.p();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\r2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */