package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class j
  extends l
{
  org.bouncycastle.asn1.j c;
  org.bouncycastle.asn1.j d;
  org.bouncycastle.asn1.j f;
  
  public j(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    this.c = new org.bouncycastle.asn1.j(paramBigInteger1);
    this.d = new org.bouncycastle.asn1.j(paramBigInteger2);
    this.f = new org.bouncycastle.asn1.j(paramBigInteger3);
  }
  
  private j(r paramr)
  {
    if (paramr.size() == 3)
    {
      paramr = paramr.q();
      this.c = org.bouncycastle.asn1.j.m(paramr.nextElement());
      this.d = org.bouncycastle.asn1.j.m(paramr.nextElement());
      this.f = org.bouncycastle.asn1.j.m(paramr.nextElement());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramr.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static j g(Object paramObject)
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
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    localf.a(this.f);
    return new b1(localf);
  }
  
  public BigInteger f()
  {
    return this.f.o();
  }
  
  public BigInteger h()
  {
    return this.c.o();
  }
  
  public BigInteger i()
  {
    return this.d.o();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\x509\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */