package org.bouncycastle.asn1.l2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

public class a
  extends l
{
  b c;
  c d;
  
  private a(r paramr)
  {
    this.c = b.f(paramr.p(0));
    if (paramr.size() == 2) {
      this.d = c.g((x)paramr.p(1), true);
    }
  }
  
  public static a f(Object paramObject)
  {
    if ((paramObject instanceof a)) {
      return (a)paramObject;
    }
    if (paramObject != null) {
      return new a(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    if (this.d != null) {
      localf.a(new g1(true, 0, this.d));
    }
    return new b1(localf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\l2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */