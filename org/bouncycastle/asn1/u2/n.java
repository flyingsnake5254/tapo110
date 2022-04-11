package org.bouncycastle.asn1.u2;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class n
  extends l
  implements p
{
  private m c;
  private q d;
  
  public n(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 0, 0);
  }
  
  public n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = p.u2;
    f localf1 = new f();
    localf1.a(new j(paramInt1));
    if (paramInt3 == 0)
    {
      if (paramInt4 == 0)
      {
        localf1.a(p.w2);
        localf1.a(new j(paramInt2));
      }
      else
      {
        throw new IllegalArgumentException("inconsistent k values");
      }
    }
    else
    {
      if ((paramInt3 <= paramInt2) || (paramInt4 <= paramInt3)) {
        break label177;
      }
      localf1.a(p.x2);
      f localf2 = new f();
      localf2.a(new j(paramInt2));
      localf2.a(new j(paramInt3));
      localf2.a(new j(paramInt4));
      localf1.a(new b1(localf2));
    }
    this.d = new b1(localf1);
    return;
    label177:
    throw new IllegalArgumentException("inconsistent k values");
  }
  
  public n(BigInteger paramBigInteger)
  {
    this.c = p.t2;
    this.d = new j(paramBigInteger);
  }
  
  private n(r paramr)
  {
    this.c = m.r(paramr.p(0));
    this.d = paramr.p(1).c();
  }
  
  public static n g(Object paramObject)
  {
    if ((paramObject instanceof n)) {
      return (n)paramObject;
    }
    if (paramObject != null) {
      return new n(r.m(paramObject));
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
  
  public m f()
  {
    return this.c;
  }
  
  public q h()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\u2\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */