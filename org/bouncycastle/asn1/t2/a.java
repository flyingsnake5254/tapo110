package org.bouncycastle.asn1.t2;

import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class a
  extends l
{
  private m c;
  private e d;
  
  public a(m paramm, e parame)
  {
    this.c = paramm;
    this.d = parame;
  }
  
  private a(r paramr)
  {
    this.c = ((m)paramr.p(0));
    this.d = paramr.p(1);
  }
  
  public static a f(Object paramObject)
  {
    if ((paramObject instanceof a)) {
      return (a)paramObject;
    }
    if (paramObject != null) {
      return new a(r.m(paramObject));
    }
    throw new IllegalArgumentException("null value in getInstance()");
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    return new b1(localf);
  }
  
  public m g()
  {
    return this.c;
  }
  
  public e h()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\t2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */