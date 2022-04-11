package org.bouncycastle.asn1.n2;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;

public class e
  extends l
{
  j c;
  j d;
  j f;
  
  public e(BigInteger paramBigInteger1, BigInteger paramBigInteger2, int paramInt)
  {
    this.c = new j(paramBigInteger1);
    this.d = new j(paramBigInteger2);
    if (paramInt != 0) {
      paramBigInteger1 = new j(paramInt);
    } else {
      paramBigInteger1 = null;
    }
    this.f = paramBigInteger1;
  }
  
  private e(r paramr)
  {
    paramr = paramr.q();
    this.c = j.m(paramr.nextElement());
    this.d = j.m(paramr.nextElement());
    if (paramr.hasMoreElements()) {
      paramr = (j)paramr.nextElement();
    } else {
      paramr = null;
    }
    this.f = paramr;
  }
  
  public static e g(Object paramObject)
  {
    if ((paramObject instanceof e)) {
      return (e)paramObject;
    }
    if (paramObject != null) {
      return new e(r.m(paramObject));
    }
    return null;
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(this.c);
    localf.a(this.d);
    if (h() != null) {
      localf.a(this.f);
    }
    return new b1(localf);
  }
  
  public BigInteger f()
  {
    return this.d.o();
  }
  
  public BigInteger h()
  {
    j localj = this.f;
    if (localj == null) {
      return null;
    }
    return localj.o();
  }
  
  public BigInteger i()
  {
    return this.c.o();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\n2\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */