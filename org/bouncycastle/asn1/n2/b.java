package org.bouncycastle.asn1.n2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x509.a;

public class b
  extends l
{
  protected c c = null;
  protected a d = null;
  protected n0 f = null;
  
  protected b() {}
  
  public b(r paramr)
  {
    this.c = c.f(paramr.p(0));
    this.d = a.g(paramr.p(1));
    this.f = ((n0)paramr.p(2));
  }
  
  public static b f(Object paramObject)
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
    localf.a(this.c);
    localf.a(this.d);
    localf.a(this.f);
    return new b1(localf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */