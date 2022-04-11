package org.bouncycastle.cert;

import org.bouncycastle.asn1.x509.l;
import org.bouncycastle.asn1.x509.m;
import org.bouncycastle.asn1.x509.p;
import org.bouncycastle.asn1.x509.x.b;

public class d
{
  private x.b a;
  private p b;
  
  d(x.b paramb, boolean paramBoolean, p paramp)
  {
    this.a = paramb;
    this.b = paramp;
    if ((paramBoolean) && (paramb.i()))
    {
      paramb = paramb.f().g(l.J3);
      if (paramb != null) {
        this.b = p.f(paramb.j());
      }
    }
  }
  
  public p a()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */