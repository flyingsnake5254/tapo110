package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t;

public class d
  extends l
{
  private m c;
  private t d;
  
  private d(r paramr)
  {
    if (paramr.size() == 2)
    {
      this.c = m.r(paramr.p(0));
      this.d = t.n(paramr.p(1));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramr.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static d g(Object paramObject)
  {
    if ((paramObject instanceof d)) {
      return (d)paramObject;
    }
    if (paramObject != null) {
      return new d(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    return new b1(localf);
  }
  
  public m f()
  {
    return new m(this.c.q());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */