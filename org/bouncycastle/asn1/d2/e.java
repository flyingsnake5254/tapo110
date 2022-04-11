package org.bouncycastle.asn1.d2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class e
  extends l
{
  private m c;
  private m d;
  private m f;
  
  public e(m paramm1, m paramm2)
  {
    this.c = paramm1;
    this.d = paramm2;
    this.f = null;
  }
  
  public e(m paramm1, m paramm2, m paramm3)
  {
    this.c = paramm1;
    this.d = paramm2;
    this.f = paramm3;
  }
  
  public e(r paramr)
  {
    this.c = ((m)paramr.p(0));
    this.d = ((m)paramr.p(1));
    if (paramr.size() > 2) {
      this.f = ((m)paramr.p(2));
    }
  }
  
  public static e h(Object paramObject)
  {
    if ((paramObject instanceof e)) {
      return (e)paramObject;
    }
    if (paramObject != null) {
      return new e(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    m localm = this.f;
    if (localm != null) {
      localf.a(localm);
    }
    return new b1(localf);
  }
  
  public m f()
  {
    return this.d;
  }
  
  public m g()
  {
    return this.f;
  }
  
  public m i()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\d2\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */