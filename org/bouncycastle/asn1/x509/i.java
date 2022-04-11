package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t2.c;

public class i
  extends l
{
  x c;
  a d;
  n0 f;
  boolean q = false;
  int x;
  
  public i(r paramr)
  {
    if (paramr.size() == 3)
    {
      this.c = x.g(paramr.p(0));
      this.d = a.g(paramr.p(1));
      this.f = n0.s(paramr.p(2));
      return;
    }
    throw new IllegalArgumentException("sequence wrong size for CertificateList");
  }
  
  public static i f(Object paramObject)
  {
    if ((paramObject instanceof i)) {
      return (i)paramObject;
    }
    if (paramObject != null) {
      return new i(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    localf.a(this.f);
    return new b1(localf);
  }
  
  public c g()
  {
    return this.c.h();
  }
  
  public Enumeration h()
  {
    return this.c.i();
  }
  
  public int hashCode()
  {
    if (!this.q)
    {
      this.x = super.hashCode();
      this.q = true;
    }
    return this.x;
  }
  
  public x.b[] i()
  {
    return this.c.j();
  }
  
  public n0 j()
  {
    return this.f;
  }
  
  public a k()
  {
    return this.d;
  }
  
  public x l()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */