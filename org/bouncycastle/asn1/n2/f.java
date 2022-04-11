package org.bouncycastle.asn1.n2;

import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x509.a;

public class f
  extends l
{
  private a c;
  private n d;
  
  private f(r paramr)
  {
    paramr = paramr.q();
    this.c = a.g(paramr.nextElement());
    this.d = n.m(paramr.nextElement());
  }
  
  public static f f(Object paramObject)
  {
    if ((paramObject instanceof f)) {
      return (f)paramObject;
    }
    if (paramObject != null) {
      return new f(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    org.bouncycastle.asn1.f localf = new org.bouncycastle.asn1.f();
    localf.a(this.c);
    localf.a(this.d);
    return new b1(localf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n2\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */