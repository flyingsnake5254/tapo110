package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

public class a
  extends l
{
  private m c;
  private e d;
  
  public a(m paramm)
  {
    this.c = paramm;
  }
  
  public a(m paramm, e parame)
  {
    this.c = paramm;
    this.d = parame;
  }
  
  private a(r paramr)
  {
    if ((paramr.size() >= 1) && (paramr.size() <= 2))
    {
      this.c = m.r(paramr.p(0));
      if (paramr.size() == 2) {
        paramr = paramr.p(1);
      } else {
        paramr = null;
      }
      this.d = paramr;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramr.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static a g(Object paramObject)
  {
    if ((paramObject instanceof a)) {
      return (a)paramObject;
    }
    if (paramObject != null) {
      return new a(r.m(paramObject));
    }
    return null;
  }
  
  public static a h(x paramx, boolean paramBoolean)
  {
    return g(r.n(paramx, paramBoolean));
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    e locale = this.d;
    if (locale != null) {
      localf.a(locale);
    }
    return new b1(localf);
  }
  
  public m f()
  {
    return this.c;
  }
  
  public e i()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */