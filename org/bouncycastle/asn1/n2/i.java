package org.bouncycastle.asn1.n2;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class i
  extends l
{
  private BigInteger c;
  private BigInteger d;
  private BigInteger f;
  private BigInteger p0;
  private BigInteger p1;
  private r p2 = null;
  private BigInteger q;
  private BigInteger x;
  private BigInteger y;
  private BigInteger z;
  
  public i(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5, BigInteger paramBigInteger6, BigInteger paramBigInteger7, BigInteger paramBigInteger8)
  {
    this.c = BigInteger.valueOf(0L);
    this.d = paramBigInteger1;
    this.f = paramBigInteger2;
    this.q = paramBigInteger3;
    this.x = paramBigInteger4;
    this.y = paramBigInteger5;
    this.z = paramBigInteger6;
    this.p0 = paramBigInteger7;
    this.p1 = paramBigInteger8;
  }
  
  private i(r paramr)
  {
    paramr = paramr.q();
    BigInteger localBigInteger = ((j)paramr.nextElement()).p();
    if ((localBigInteger.intValue() != 0) && (localBigInteger.intValue() != 1)) {
      throw new IllegalArgumentException("wrong version for RSA private key");
    }
    this.c = localBigInteger;
    this.d = ((j)paramr.nextElement()).p();
    this.f = ((j)paramr.nextElement()).p();
    this.q = ((j)paramr.nextElement()).p();
    this.x = ((j)paramr.nextElement()).p();
    this.y = ((j)paramr.nextElement()).p();
    this.z = ((j)paramr.nextElement()).p();
    this.p0 = ((j)paramr.nextElement()).p();
    this.p1 = ((j)paramr.nextElement()).p();
    if (paramr.hasMoreElements()) {
      this.p2 = ((r)paramr.nextElement());
    }
  }
  
  public static i i(Object paramObject)
  {
    if ((paramObject instanceof i)) {
      return (i)paramObject;
    }
    if (paramObject != null) {
      return new i(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(new j(this.c));
    localf.a(new j(j()));
    localf.a(new j(n()));
    localf.a(new j(m()));
    localf.a(new j(k()));
    localf.a(new j(l()));
    localf.a(new j(g()));
    localf.a(new j(h()));
    localf.a(new j(f()));
    r localr = this.p2;
    if (localr != null) {
      localf.a(localr);
    }
    return new b1(localf);
  }
  
  public BigInteger f()
  {
    return this.p1;
  }
  
  public BigInteger g()
  {
    return this.z;
  }
  
  public BigInteger h()
  {
    return this.p0;
  }
  
  public BigInteger j()
  {
    return this.d;
  }
  
  public BigInteger k()
  {
    return this.x;
  }
  
  public BigInteger l()
  {
    return this.y;
  }
  
  public BigInteger m()
  {
    return this.q;
  }
  
  public BigInteger n()
  {
    return this.f;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n2\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */