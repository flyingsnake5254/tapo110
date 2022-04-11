package org.bouncycastle.asn1.n2;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m2.b;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x;
import org.bouncycastle.asn1.x509.a;

public class k
  extends l
{
  public static final a c;
  public static final a d;
  public static final j f = new j(20L);
  public static final j q = new j(1L);
  private j p0;
  private a x;
  private a y;
  private j z;
  
  static
  {
    a locala = new a(b.i, v0.c);
    c = locala;
    d = new a(g.I, locala);
  }
  
  public k()
  {
    this.x = c;
    this.y = d;
    this.z = f;
    this.p0 = q;
  }
  
  private k(r paramr)
  {
    this.x = c;
    this.y = d;
    this.z = f;
    this.p0 = q;
    for (int i = 0; i != paramr.size(); i++)
    {
      x localx = (x)paramr.p(i);
      int j = localx.p();
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j == 3) {
              this.p0 = j.n(localx, true);
            } else {
              throw new IllegalArgumentException("unknown tag");
            }
          }
          else {
            this.z = j.n(localx, true);
          }
        }
        else {
          this.y = a.h(localx, true);
        }
      }
      else {
        this.x = a.h(localx, true);
      }
    }
  }
  
  public k(a parama1, a parama2, j paramj1, j paramj2)
  {
    this.x = parama1;
    this.y = parama2;
    this.z = paramj1;
    this.p0 = paramj2;
  }
  
  public static k g(Object paramObject)
  {
    if ((paramObject instanceof k)) {
      return (k)paramObject;
    }
    if (paramObject != null) {
      return new k(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    if (!this.x.equals(c)) {
      localf.a(new g1(true, 0, this.x));
    }
    if (!this.y.equals(d)) {
      localf.a(new g1(true, 1, this.y));
    }
    if (!this.z.equals(f)) {
      localf.a(new g1(true, 2, this.z));
    }
    if (!this.p0.equals(q)) {
      localf.a(new g1(true, 3, this.p0));
    }
    return new b1(localf);
  }
  
  public a f()
  {
    return this.x;
  }
  
  public a h()
  {
    return this.y;
  }
  
  public BigInteger i()
  {
    return this.z.p();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n2\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */