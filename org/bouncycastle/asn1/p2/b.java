package org.bouncycastle.asn1.p2;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.g1;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;
import org.bouncycastle.asn1.x0;

public class b
  extends l
{
  private r c;
  
  public b(BigInteger paramBigInteger, e parame)
  {
    this(paramBigInteger, null, parame);
  }
  
  public b(BigInteger paramBigInteger, n0 paramn0, e parame)
  {
    byte[] arrayOfByte = org.bouncycastle.util.b.b(paramBigInteger);
    paramBigInteger = new f();
    paramBigInteger.a(new j(1L));
    paramBigInteger.a(new x0(arrayOfByte));
    if (parame != null) {
      paramBigInteger.a(new g1(true, 0, parame));
    }
    if (paramn0 != null) {
      paramBigInteger.a(new g1(true, 1, paramn0));
    }
    this.c = new b1(paramBigInteger);
  }
  
  public b(r paramr)
  {
    this.c = paramr;
  }
  
  private q g(int paramInt)
  {
    Enumeration localEnumeration = this.c.q();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = (e)localEnumeration.nextElement();
      if ((localObject instanceof x))
      {
        localObject = (x)localObject;
        if (((x)localObject).p() == paramInt) {
          return ((x)localObject).o().c();
        }
      }
    }
    return null;
  }
  
  public q c()
  {
    return this.c;
  }
  
  public BigInteger f()
  {
    return new BigInteger(1, ((n)this.c.p(1)).o());
  }
  
  public n0 h()
  {
    return (n0)g(1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\p2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */