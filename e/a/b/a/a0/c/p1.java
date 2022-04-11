package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.a;
import e.a.b.c.g;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class p1
  extends e.a
{
  protected long[] g;
  
  public p1()
  {
    this.g = g.i();
  }
  
  public p1(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 193))
    {
      this.g = o1.d(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecT193FieldElement");
  }
  
  protected p1(long[] paramArrayOfLong)
  {
    this.g = paramArrayOfLong;
  }
  
  public e a(e parame)
  {
    long[] arrayOfLong = g.i();
    o1.a(this.g, ((p1)parame).g, arrayOfLong);
    return new p1(arrayOfLong);
  }
  
  public e b()
  {
    long[] arrayOfLong = g.i();
    o1.c(this.g, arrayOfLong);
    return new p1(arrayOfLong);
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
    if (!(paramObject instanceof p1)) {
      return false;
    }
    paramObject = (p1)paramObject;
    return g.n(this.g, ((p1)paramObject).g);
  }
  
  public int f()
  {
    return 193;
  }
  
  public e g()
  {
    long[] arrayOfLong = g.i();
    o1.j(this.g, arrayOfLong);
    return new p1(arrayOfLong);
  }
  
  public boolean h()
  {
    return g.u(this.g);
  }
  
  public int hashCode()
  {
    return a.A(this.g, 0, 4) ^ 0x1D731F;
  }
  
  public boolean i()
  {
    return g.w(this.g);
  }
  
  public e j(e parame)
  {
    long[] arrayOfLong = g.i();
    o1.k(this.g, ((p1)parame).g, arrayOfLong);
    return new p1(arrayOfLong);
  }
  
  public e k(e parame1, e parame2, e parame3)
  {
    return l(parame1, parame2, parame3);
  }
  
  public e l(e parame1, e parame2, e parame3)
  {
    long[] arrayOfLong1 = this.g;
    parame1 = ((p1)parame1).g;
    parame2 = ((p1)parame2).g;
    long[] arrayOfLong2 = ((p1)parame3).g;
    parame3 = g.k();
    o1.l(arrayOfLong1, parame1, parame3);
    o1.l(parame2, arrayOfLong2, parame3);
    parame1 = g.i();
    o1.m(parame3, parame1);
    return new p1(parame1);
  }
  
  public e m()
  {
    return this;
  }
  
  public e n()
  {
    long[] arrayOfLong = g.i();
    o1.o(this.g, arrayOfLong);
    return new p1(arrayOfLong);
  }
  
  public e o()
  {
    long[] arrayOfLong = g.i();
    o1.p(this.g, arrayOfLong);
    return new p1(arrayOfLong);
  }
  
  public e p(e parame1, e parame2)
  {
    long[] arrayOfLong1 = this.g;
    parame1 = ((p1)parame1).g;
    long[] arrayOfLong2 = ((p1)parame2).g;
    parame2 = g.k();
    o1.q(arrayOfLong1, parame2);
    o1.l(parame1, arrayOfLong2, parame2);
    parame1 = g.i();
    o1.m(parame2, parame1);
    return new p1(parame1);
  }
  
  public e q(int paramInt)
  {
    if (paramInt < 1) {
      return this;
    }
    long[] arrayOfLong = g.i();
    o1.r(this.g, paramInt, arrayOfLong);
    return new p1(arrayOfLong);
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
    return o1.s(this.g);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\p1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */