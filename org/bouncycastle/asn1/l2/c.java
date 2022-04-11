package org.bouncycastle.asn1.l2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

public class c
  extends l
{
  m c;
  n d;
  
  public c(r paramr)
  {
    this.c = ((m)paramr.p(0));
    this.d = ((n)paramr.p(1));
  }
  
  public static c f(Object paramObject)
  {
    if ((paramObject instanceof c)) {
      return (c)paramObject;
    }
    if (paramObject != null) {
      return new c(r.m(paramObject));
    }
    return null;
  }
  
  public static c g(x paramx, boolean paramBoolean)
  {
    return f(r.n(paramx, paramBoolean));
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    return new b1(localf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\l2\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */