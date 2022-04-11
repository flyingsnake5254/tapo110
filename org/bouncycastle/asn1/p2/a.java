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
import org.bouncycastle.util.b;

public class a
  extends l
{
  private r c;
  
  public a(int paramInt, BigInteger paramBigInteger, e parame)
  {
    this(paramInt, paramBigInteger, null, parame);
  }
  
  public a(int paramInt, BigInteger paramBigInteger, n0 paramn0, e parame)
  {
    byte[] arrayOfByte = b.a((paramInt + 7) / 8, paramBigInteger);
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
  
  private a(r paramr)
  {
    this.c = paramr;
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
  
  private q h(int paramInt)
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
  
  public BigInteger g()
  {
    return new BigInteger(1, ((n)this.c.p(1)).o());
  }
  
  public q i()
  {
    return h(0);
  }
  
  public n0 j()
  {
    return (n0)h(1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\p2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */