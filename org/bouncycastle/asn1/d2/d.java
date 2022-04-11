package org.bouncycastle.asn1.d2;

import java.math.BigInteger;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.f;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;

public class d
  extends l
{
  int c;
  j d;
  j f;
  j q;
  
  public d(int paramInt, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    this.c = paramInt;
    this.d = new j(paramBigInteger1);
    this.f = new j(paramBigInteger2);
    this.q = new j(paramBigInteger3);
  }
  
  public q c()
  {
    f localf = new f();
    localf.a(new j(this.c));
    localf.a(this.d);
    localf.a(this.f);
    localf.a(this.q);
    return new b1(localf);
  }
  
  public BigInteger f()
  {
    return this.q.o();
  }
  
  public BigInteger g()
  {
    return this.d.o();
  }
  
  public BigInteger h()
  {
    return this.f.o();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\d2\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */