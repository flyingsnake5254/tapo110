package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x;

public class r
  extends l
{
  p c;
  j d;
  n0 f;
  
  private r(org.bouncycastle.asn1.r paramr)
  {
    if ((paramr.size() != 2) && (paramr.size() != 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Bad sequence size: ");
      localStringBuilder.append(paramr.size());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.c = p.f(paramr.p(0));
    this.d = j.m(paramr.p(1));
    if (paramr.size() == 3) {
      this.f = n0.s(paramr.p(2));
    }
  }
  
  public static r f(Object paramObject)
  {
    if ((paramObject instanceof r)) {
      return (r)paramObject;
    }
    if (paramObject != null) {
      return new r(org.bouncycastle.asn1.r.m(paramObject));
    }
    return null;
  }
  
  public static r g(x paramx, boolean paramBoolean)
  {
    return f(org.bouncycastle.asn1.r.n(paramx, paramBoolean));
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    n0 localn0 = this.f;
    if (localn0 != null) {
      localf.a(localn0);
    }
    return new b1(localf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */