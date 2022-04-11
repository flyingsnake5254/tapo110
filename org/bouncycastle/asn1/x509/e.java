package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class e
  extends l
{
  f c;
  a d;
  n0 f;
  
  public e(r paramr)
  {
    if (paramr.size() == 3)
    {
      this.c = f.j(paramr.p(0));
      this.d = a.g(paramr.p(1));
      this.f = n0.s(paramr.p(2));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramr.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static e g(Object paramObject)
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
    org.bouncycastle.asn1.f localf = new org.bouncycastle.asn1.f();
    localf.a(this.c);
    localf.a(this.d);
    localf.a(this.f);
    return new b1(localf);
  }
  
  public f f()
  {
    return this.c;
  }
  
  public a h()
  {
    return this.d;
  }
  
  public n0 i()
  {
    return this.f;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */