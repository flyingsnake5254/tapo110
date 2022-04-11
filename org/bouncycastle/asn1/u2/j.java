package org.bouncycastle.asn1.u2;

import e.a.b.a.b;
import e.a.b.a.d;
import e.a.b.a.h;
import e.a.b.b.a;
import e.a.b.b.e;
import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class j
  extends org.bouncycastle.asn1.l
  implements p
{
  private static final BigInteger c = BigInteger.valueOf(1L);
  private n d;
  private d f;
  private l q;
  private BigInteger x;
  private BigInteger y;
  private byte[] z;
  
  public j(d paramd, h paramh, BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte)
  {
    this(paramd, new l(paramh), paramBigInteger1, paramBigInteger2, paramArrayOfByte);
  }
  
  public j(d paramd, l paraml, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this(paramd, paraml, paramBigInteger1, paramBigInteger2, null);
  }
  
  public j(d paramd, l paraml, BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte)
  {
    this.f = paramd;
    this.q = paraml;
    this.x = paramBigInteger1;
    this.y = paramBigInteger2;
    this.z = paramArrayOfByte;
    if (b.i(paramd)) {
      paramd = new n(paramd.s().b());
    }
    for (;;)
    {
      this.d = paramd;
      break;
      if (!b.g(paramd)) {
        break label151;
      }
      paramd = ((e.a.b.b.f)paramd.s()).c().a();
      if (paramd.length == 3)
      {
        paramd = new n(paramd[2], paramd[1]);
      }
      else
      {
        if (paramd.length != 5) {
          break label141;
        }
        paramd = new n(paramd[4], paramd[1], paramd[2], paramd[3]);
      }
    }
    return;
    label141:
    throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
    label151:
    throw new IllegalArgumentException("'curve' is of an unsupported type");
  }
  
  private j(r paramr)
  {
    if (((paramr.p(0) instanceof org.bouncycastle.asn1.j)) && (((org.bouncycastle.asn1.j)paramr.p(0)).p().equals(c)))
    {
      this.x = ((org.bouncycastle.asn1.j)paramr.p(4)).p();
      if (paramr.size() == 6) {
        this.y = ((org.bouncycastle.asn1.j)paramr.p(5)).p();
      }
      i locali = new i(n.g(paramr.p(1)), this.x, this.y, r.m(paramr.p(2)));
      this.f = locali.f();
      paramr = paramr.p(3);
      if ((paramr instanceof l)) {
        this.q = ((l)paramr);
      } else {
        this.q = new l(this.f, (org.bouncycastle.asn1.n)paramr);
      }
      this.z = locali.g();
      return;
    }
    throw new IllegalArgumentException("bad version in X9ECParameters");
  }
  
  public static j i(Object paramObject)
  {
    if ((paramObject instanceof j)) {
      return (j)paramObject;
    }
    if (paramObject != null) {
      return new j(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    org.bouncycastle.asn1.f localf = new org.bouncycastle.asn1.f();
    localf.a(new org.bouncycastle.asn1.j(c));
    localf.a(this.d);
    localf.a(new i(this.f, this.z));
    localf.a(this.q);
    localf.a(new org.bouncycastle.asn1.j(this.x));
    BigInteger localBigInteger = this.y;
    if (localBigInteger != null) {
      localf.a(new org.bouncycastle.asn1.j(localBigInteger));
    }
    return new b1(localf);
  }
  
  public d f()
  {
    return this.f;
  }
  
  public h g()
  {
    return this.q.f();
  }
  
  public BigInteger h()
  {
    return this.y;
  }
  
  public BigInteger j()
  {
    return this.x;
  }
  
  public byte[] k()
  {
    return this.z;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\u2\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */