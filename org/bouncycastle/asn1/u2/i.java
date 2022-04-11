package org.bouncycastle.asn1.u2;

import e.a.b.a.d;
import e.a.b.a.d.e;
import e.a.b.a.d.f;
import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class i
  extends l
  implements p
{
  private d c;
  private byte[] d;
  private org.bouncycastle.asn1.m f = null;
  
  public i(d paramd, byte[] paramArrayOfByte)
  {
    this.c = paramd;
    this.d = paramArrayOfByte;
    h();
  }
  
  public i(n paramn, BigInteger paramBigInteger1, BigInteger paramBigInteger2, r paramr)
  {
    org.bouncycastle.asn1.m localm = paramn.f();
    this.f = localm;
    if (localm.equals(p.t2)) {}
    int i;
    int j;
    int k;
    int m;
    for (paramn = new d.f(((j)paramn.h()).p(), new BigInteger(1, org.bouncycastle.asn1.n.m(paramr.p(0)).o()), new BigInteger(1, org.bouncycastle.asn1.n.m(paramr.p(1)).o()), paramBigInteger1, paramBigInteger2);; paramn = new d.e(i, j, k, m, new BigInteger(1, org.bouncycastle.asn1.n.m(paramr.p(0)).o()), new BigInteger(1, org.bouncycastle.asn1.n.m(paramr.p(1)).o()), paramBigInteger1, paramBigInteger2))
    {
      this.c = paramn;
      break;
      if (!this.f.equals(p.u2)) {
        break label348;
      }
      paramn = r.m(paramn.h());
      i = ((j)paramn.p(0)).p().intValue();
      localm = (org.bouncycastle.asn1.m)paramn.p(1);
      if (localm.equals(p.w2))
      {
        j = j.m(paramn.p(2)).p().intValue();
        k = 0;
        m = 0;
      }
      else
      {
        if (!localm.equals(p.x2)) {
          break label338;
        }
        paramn = r.m(paramn.p(2));
        j = j.m(paramn.p(0)).p().intValue();
        k = j.m(paramn.p(1)).p().intValue();
        m = j.m(paramn.p(2)).p().intValue();
      }
    }
    if (paramr.size() == 3) {
      this.d = ((n0)paramr.p(2)).o();
    }
    return;
    label338:
    throw new IllegalArgumentException("This type of EC basis is not implemented");
    label348:
    throw new IllegalArgumentException("This type of ECCurve is not implemented");
  }
  
  private void h()
  {
    if (e.a.b.a.b.i(this.c)) {}
    for (org.bouncycastle.asn1.m localm = p.t2;; localm = p.u2)
    {
      this.f = localm;
      break;
      if (!e.a.b.a.b.g(this.c)) {
        break label40;
      }
    }
    return;
    label40:
    throw new IllegalArgumentException("This type of ECCurve is not implemented");
  }
  
  public q c()
  {
    f localf = new f();
    if (this.f.equals(p.t2)) {
      localf.a(new m(this.c.o()).c());
    }
    for (m localm = new m(this.c.p());; localm = new m(this.c.p()))
    {
      localf.a(localm.c());
      break;
      if (!this.f.equals(p.u2)) {
        break;
      }
      localf.a(new m(this.c.o()).c());
    }
    if (this.d != null) {
      localf.a(new n0(this.d));
    }
    return new b1(localf);
  }
  
  public d f()
  {
    return this.c;
  }
  
  public byte[] g()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\u2\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */