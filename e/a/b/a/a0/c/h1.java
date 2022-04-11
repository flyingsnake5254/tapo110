package e.a.b.a.a0.c;

import e.a.b.a.e.a;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class h1
  extends e.a
{
  protected long[] g;
  
  public h1()
  {
    this.g = e.a.b.c.e.h();
  }
  
  public h1(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 163))
    {
      this.g = g1.d(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecT163FieldElement");
  }
  
  protected h1(long[] paramArrayOfLong)
  {
    this.g = paramArrayOfLong;
  }
  
  public e.a.b.a.e a(e.a.b.a.e parame)
  {
    long[] arrayOfLong = e.a.b.c.e.h();
    g1.a(this.g, ((h1)parame).g, arrayOfLong);
    return new h1(arrayOfLong);
  }
  
  public e.a.b.a.e b()
  {
    long[] arrayOfLong = e.a.b.c.e.h();
    g1.c(this.g, arrayOfLong);
    return new h1(arrayOfLong);
  }
  
  public e.a.b.a.e d(e.a.b.a.e parame)
  {
    return j(parame.g());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof h1)) {
      return false;
    }
    paramObject = (h1)paramObject;
    return e.a.b.c.e.m(this.g, ((h1)paramObject).g);
  }
  
  public int f()
  {
    return 163;
  }
  
  public e.a.b.a.e g()
  {
    long[] arrayOfLong = e.a.b.c.e.h();
    g1.i(this.g, arrayOfLong);
    return new h1(arrayOfLong);
  }
  
  public boolean h()
  {
    return e.a.b.c.e.t(this.g);
  }
  
  public int hashCode()
  {
    return a.A(this.g, 0, 3) ^ 0x27FB3;
  }
  
  public boolean i()
  {
    return e.a.b.c.e.v(this.g);
  }
  
  public e.a.b.a.e j(e.a.b.a.e parame)
  {
    long[] arrayOfLong = e.a.b.c.e.h();
    g1.j(this.g, ((h1)parame).g, arrayOfLong);
    return new h1(arrayOfLong);
  }
  
  public e.a.b.a.e k(e.a.b.a.e parame1, e.a.b.a.e parame2, e.a.b.a.e parame3)
  {
    return l(parame1, parame2, parame3);
  }
  
  public e.a.b.a.e l(e.a.b.a.e parame1, e.a.b.a.e parame2, e.a.b.a.e parame3)
  {
    long[] arrayOfLong1 = this.g;
    parame1 = ((h1)parame1).g;
    parame2 = ((h1)parame2).g;
    long[] arrayOfLong2 = ((h1)parame3).g;
    parame3 = e.a.b.c.e.j();
    g1.k(arrayOfLong1, parame1, parame3);
    g1.k(parame2, arrayOfLong2, parame3);
    parame1 = e.a.b.c.e.h();
    g1.l(parame3, parame1);
    return new h1(parame1);
  }
  
  public e.a.b.a.e m()
  {
    return this;
  }
  
  public e.a.b.a.e n()
  {
    long[] arrayOfLong = e.a.b.c.e.h();
    g1.n(this.g, arrayOfLong);
    return new h1(arrayOfLong);
  }
  
  public e.a.b.a.e o()
  {
    long[] arrayOfLong = e.a.b.c.e.h();
    g1.o(this.g, arrayOfLong);
    return new h1(arrayOfLong);
  }
  
  public e.a.b.a.e p(e.a.b.a.e parame1, e.a.b.a.e parame2)
  {
    long[] arrayOfLong1 = this.g;
    parame1 = ((h1)parame1).g;
    long[] arrayOfLong2 = ((h1)parame2).g;
    parame2 = e.a.b.c.e.j();
    g1.p(arrayOfLong1, parame2);
    g1.k(parame1, arrayOfLong2, parame2);
    parame1 = e.a.b.c.e.h();
    g1.l(parame2, parame1);
    return new h1(parame1);
  }
  
  public e.a.b.a.e q(int paramInt)
  {
    if (paramInt < 1) {
      return this;
    }
    long[] arrayOfLong = e.a.b.c.e.h();
    g1.q(this.g, paramInt, arrayOfLong);
    return new h1(arrayOfLong);
  }
  
  public e.a.b.a.e r(e.a.b.a.e parame)
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
    return e.a.b.c.e.I(this.g);
  }
  
  public int u()
  {
    return g1.r(this.g);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\h1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */