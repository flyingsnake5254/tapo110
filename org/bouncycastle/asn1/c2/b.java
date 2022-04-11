package org.bouncycastle.asn1.c2;

import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.e0;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.i0;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

public class b
  extends l
  implements a
{
  private m c;
  private e d;
  
  public b(r paramr)
  {
    if ((paramr.size() >= 1) && (paramr.size() <= 2))
    {
      this.c = ((m)paramr.p(0));
      if (paramr.size() > 1)
      {
        paramr = (x)paramr.p(1);
        if ((paramr.q()) && (paramr.p() == 0)) {
          this.d = paramr.o();
        } else {
          throw new IllegalArgumentException("Bad tag for 'content'");
        }
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramr.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static b f(Object paramObject)
  {
    if ((paramObject instanceof b)) {
      return (b)paramObject;
    }
    if (paramObject != null) {
      return new b(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    e locale = this.d;
    if (locale != null) {
      localf.a(new i0(0, locale));
    }
    return new e0(localf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\c2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */