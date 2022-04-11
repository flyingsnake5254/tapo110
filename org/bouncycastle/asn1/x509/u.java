package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

public class u
  extends l
{
  g c;
  m d;
  a f;
  n0 q;
  
  private u(r paramr)
  {
    if ((paramr.size() <= 4) && (paramr.size() >= 3))
    {
      int i = 0;
      this.c = g.n(paramr.p(0));
      if (paramr.size() == 4)
      {
        this.d = m.r(paramr.p(1));
        i = 1;
      }
      this.f = a.g(paramr.p(i + 1));
      this.q = n0.s(paramr.p(i + 2));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramr.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static u f(Object paramObject)
  {
    if ((paramObject instanceof u)) {
      return (u)paramObject;
    }
    if (paramObject != null) {
      return new u(r.m(paramObject));
    }
    return null;
  }
  
  public static u g(x paramx, boolean paramBoolean)
  {
    return f(r.n(paramx, paramBoolean));
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    m localm = this.d;
    if (localm != null) {
      localf.a(localm);
    }
    localf.a(this.f);
    localf.a(this.q);
    return new b1(localf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */