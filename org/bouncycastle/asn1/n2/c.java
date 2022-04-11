package org.bouncycastle.asn1.n2;

import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t;
import org.bouncycastle.asn1.x;
import org.bouncycastle.asn1.x509.w;

public class c
  extends l
{
  j c = new j(0L);
  org.bouncycastle.asn1.t2.c d;
  w f;
  t q = null;
  
  public c(r paramr)
  {
    this.c = ((j)paramr.p(0));
    this.d = org.bouncycastle.asn1.t2.c.f(paramr.p(1));
    this.f = w.h(paramr.p(2));
    if (paramr.size() > 3) {
      this.q = t.o((x)paramr.p(3), false);
    }
    g(this.q);
    if ((this.d != null) && (this.c != null) && (this.f != null)) {
      return;
    }
    throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
  }
  
  public static c f(Object paramObject)
  {
    if ((paramObject instanceof c)) {
      return (c)paramObject;
    }
    if (paramObject != null) {
      return new c(r.m(paramObject));
    }
    return null;
  }
  
  private static void g(t paramt)
  {
    if (paramt == null) {
      return;
    }
    paramt = paramt.r();
    while (paramt.hasMoreElements())
    {
      a locala = a.h(paramt.nextElement());
      if ((locala.f().equals(g.E0)) && (locala.g().size() != 1)) {
        throw new IllegalArgumentException("challengePassword attribute must have one value");
      }
    }
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    localf.a(this.f);
    if (this.q != null) {
      localf.a(new g1(false, 0, this.q));
    }
    return new b1(localf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n2\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */