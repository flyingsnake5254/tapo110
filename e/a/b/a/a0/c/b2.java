package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.a;
import e.a.b.c.g;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class b2
  extends e.a
{
  protected long[] g;
  
  public b2()
  {
    this.g = g.i();
  }
  
  public b2(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 239))
    {
      this.g = a2.d(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
  }
  
  protected b2(long[] paramArrayOfLong)
  {
    this.g = paramArrayOfLong;
  }
  
  public e a(e parame)
  {
    long[] arrayOfLong = g.i();
    a2.a(this.g, ((b2)parame).g, arrayOfLong);
    return new b2(arrayOfLong);
  }
  
  public e b()
  {
    long[] arrayOfLong = g.i();
    a2.c(this.g, arrayOfLong);
    return new b2(arrayOfLong);
  }
  
  public e d(e parame)
  {
    return j(parame.g());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof b2)) {
      return false;
    }
    paramObject = (b2)paramObject;
    return g.n(this.g, ((b2)paramObject).g);
  }
  
  public int f()
  {
    return 239;
  }
  
  public e g()
  {
    long[] arrayOfLong = g.i();
    a2.j(this.g, arrayOfLong);
    return new b2(arrayOfLong);
  }
  
  public boolean h()
  {
    return g.u(this.g);
  }
  
  public int hashCode()
  {
    return a.A(this.g, 0, 4) ^ 0x16CAFFE;
  }
  
  public boolean i()
  {
    return g.w(this.g);
  }
  
  public e j(e parame)
  {
    long[] arrayOfLong = g.i();
    a2.k(this.g, ((b2)parame).g, arrayOfLong);
    return new b2(arrayOfLong);
  }
  
  public e k(e parame1, e parame2, e parame3)
  {
    return l(parame1, parame2, parame3);
  }
  
  public e l(e parame1, e parame2, e parame3)
  {
    long[] arrayOfLong1 = this.g;
    parame1 = ((b2)parame1).g;
    parame2 = ((b2)parame2).g;
    long[] arrayOfLong2 = ((b2)parame3).g;
    parame3 = g.k();
    a2.l(arrayOfLong1, parame1, parame3);
    a2.l(parame2, arrayOfLong2, parame3);
    parame1 = g.i();
    a2.m(parame3, parame1);
    return new b2(parame1);
  }
  
  public e m()
  {
    return this;
  }
  
  public e n()
  {
    long[] arrayOfLong = g.i();
    a2.o(this.g, arrayOfLong);
    return new b2(arrayOfLong);
  }
  
  public e o()
  {
    long[] arrayOfLong = g.i();
    a2.p(this.g, arrayOfLong);
    return new b2(arrayOfLong);
  }
  
  public e p(e parame1, e parame2)
  {
    long[] arrayOfLong1 = this.g;
    long[] arrayOfLong2 = ((b2)parame1).g;
    parame2 = ((b2)parame2).g;
    parame1 = g.k();
    a2.q(arrayOfLong1, parame1);
    a2.l(arrayOfLong2, parame2, parame1);
    parame2 = g.i();
    a2.m(parame1, parame2);
    return new b2(parame2);
  }
  
  public e q(int paramInt)
  {
    if (paramInt < 1) {
      return this;
    }
    long[] arrayOfLong = g.i();
    a2.r(this.g, paramInt, arrayOfLong);
    return new b2(arrayOfLong);
  }
  
  public e r(e parame)
  {
    return a(parame);
  }
  
  public boolean s()
  {
    long[] arrayOfLong = this.g;
    boolean bool = false;
    if ((arrayOfLong[0] & 1L) != 0L) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger t()
  {
    return g.K(this.g);
  }
  
  public int u()
  {
    return a2.s(this.g);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\b2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */