package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.h;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class c
  extends l
{
  h c;
  h d;
  
  private c(r paramr)
  {
    if (paramr.size() == 2)
    {
      this.c = h.p(paramr.p(0));
      this.d = h.p(paramr.p(1));
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
  
  public h g()
  {
    return this.d;
  }
  
  public h h()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */