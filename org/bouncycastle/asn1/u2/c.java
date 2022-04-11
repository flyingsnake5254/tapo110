package org.bouncycastle.asn1.u2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class c
  extends l
{
  private n0 c;
  private j d;
  
  private c(r paramr)
  {
    if (paramr.size() == 2)
    {
      this.c = n0.s(paramr.p(0));
      this.d = j.m(paramr.p(1));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramr.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
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
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    return new b1(localf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\u2\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */