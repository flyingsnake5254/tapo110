package org.bouncycastle.asn1.n2;

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
  private BigInteger c;
  private BigInteger d;
  
  public j(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this.c = paramBigInteger1;
    this.d = paramBigInteger2;
  }
  
  private j(r paramr)
  {
    if (paramr.size() == 2)
    {
      paramr = paramr.q();
      this.c = org.bouncycastle.asn1.j.m(paramr.nextElement()).o();
      this.d = org.bouncycastle.asn1.j.m(paramr.nextElement()).o();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramr.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static j f(Object paramObject)
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
    localf.a(new org.bouncycastle.asn1.j(g()));
    localf.a(new org.bouncycastle.asn1.j(h()));
    return new b1(localf);
  }
  
  public BigInteger g()
  {
    return this.c;
  }
  
  public BigInteger h()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n2\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */