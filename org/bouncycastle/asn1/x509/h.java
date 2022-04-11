package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t2.c;

public class h
  extends l
{
  r c;
  y d;
  a f;
  n0 q;
  
  private h(r paramr)
  {
    this.c = paramr;
    if (paramr.size() == 3)
    {
      this.d = y.h(paramr.p(0));
      this.f = a.g(paramr.p(1));
      this.q = n0.s(paramr.p(2));
      return;
    }
    throw new IllegalArgumentException("sequence wrong size for a certificate");
  }
  
  public static h g(Object paramObject)
  {
    if ((paramObject instanceof h)) {
      return (h)paramObject;
    }
    if (paramObject != null) {
      return new h(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    return this.c;
  }
  
  public z f()
  {
    return this.d.f();
  }
  
  public c h()
  {
    return this.d.i();
  }
  
  public j i()
  {
    return this.d.k();
  }
  
  public n0 j()
  {
    return this.q;
  }
  
  public a k()
  {
    return this.f;
  }
  
  public z l()
  {
    return this.d.m();
  }
  
  public c m()
  {
    return this.d.n();
  }
  
  public w n()
  {
    return this.d.o();
  }
  
  public y o()
  {
    return this.d;
  }
  
  public int p()
  {
    return this.d.q();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */