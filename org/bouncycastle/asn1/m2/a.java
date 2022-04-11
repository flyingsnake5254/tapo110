package org.bouncycastle.asn1.m2;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class a
  extends l
{
  j c;
  j d;
  
  public a(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this.c = new j(paramBigInteger1);
    this.d = new j(paramBigInteger2);
  }
  
  private a(r paramr)
  {
    paramr = paramr.q();
    this.c = ((j)paramr.nextElement());
    this.d = ((j)paramr.nextElement());
  }
  
  public static a g(Object paramObject)
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
    localf.a(this.d);
    return new b1(localf);
  }
  
  public BigInteger f()
  {
    return this.d.o();
  }
  
  public BigInteger h()
  {
    return this.c.o();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\m2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */