package e.a.b.a.a0.c;

import e.a.b.a.e.a;
import e.a.b.c.m;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class b1
  extends e.a
{
  protected long[] g;
  
  public b1()
  {
    this.g = e.a.b.c.e.h();
  }
  
  public b1(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 131))
    {
      this.g = a1.d(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
  }
  
  protected b1(long[] paramArrayOfLong)
  {
    this.g = paramArrayOfLong;
  }
  
  public e.a.b.a.e a(e.a.b.a.e parame)
  {
    long[] arrayOfLong = e.a.b.c.e.h();
    a1.a(this.g, ((b1)parame).g, arrayOfLong);
    return new b1(arrayOfLong);
  }
  
  public e.a.b.a.e b()
  {
    long[] arrayOfLong = e.a.b.c.e.h();
    a1.c(this.g, arrayOfLong);
    return new b1(arrayOfLong);
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
    if (!(paramObject instanceof b1)) {
      return false;
    }
    paramObject = (b1)paramObject;
    return e.a.b.c.e.m(this.g, ((b1)paramObject).g);
  }
  
  public int f()
  {
    return 131;
  }
  
  public e.a.b.a.e g()
  {
    long[] arrayOfLong = e.a.b.c.e.h();
    a1.i(this.g, arrayOfLong);
    return new b1(arrayOfLong);
  }
  
  public boolean h()
  {
    return e.a.b.c.e.t(this.g);
  }
  
  public int hashCode()
  {
    return a.A(this.g, 0, 3) ^ 0x202F8;
  }
  
  public boolean i()
  {
    return e.a.b.c.e.v(this.g);
  }
  
  public e.a.b.a.e j(e.a.b.a.e parame)
  {
    long[] arrayOfLong = e.a.b.c.e.h();
    a1.j(this.g, ((b1)parame).g, arrayOfLong);
    return new b1(arrayOfLong);
  }
  
  public e.a.b.a.e k(e.a.b.a.e parame1, e.a.b.a.e parame2, e.a.b.a.e parame3)
  {
    return l(parame1, parame2, parame3);
  }
  
  public e.a.b.a.e l(e.a.b.a.e parame1, e.a.b.a.e parame2, e.a.b.a.e parame3)
  {
    long[] arrayOfLong1 = this.g;
    parame1 = ((b1)parame1).g;
    long[] arrayOfLong2 = ((b1)parame2).g;
    parame3 = ((b1)parame3).g;
    parame2 = m.k(5);
    a1.k(arrayOfLong1, parame1, parame2);
    a1.k(arrayOfLong2, parame3, parame2);
    parame1 = e.a.b.c.e.h();
    a1.l(parame2, parame1);
    return new b1(parame1);
  }
  
  public e.a.b.a.e m()
  {
    return this;
  }
  
  public e.a.b.a.e n()
  {
    long[] arrayOfLong = e.a.b.c.e.h();
    a1.n(this.g, arrayOfLong);
    return new b1(arrayOfLong);
  }
  
  public e.a.b.a.e o()
  {
    long[] arrayOfLong = e.a.b.c.e.h();
    a1.o(this.g, arrayOfLong);
    return new b1(arrayOfLong);
  }
  
  public e.a.b.a.e p(e.a.b.a.e parame1, e.a.b.a.e parame2)
  {
    long[] arrayOfLong1 = this.g;
    parame1 = ((b1)parame1).g;
    long[] arrayOfLong2 = ((b1)parame2).g;
    parame2 = m.k(5);
    a1.p(arrayOfLong1, parame2);
    a1.k(parame1, arrayOfLong2, parame2);
    parame1 = e.a.b.c.e.h();
    a1.l(parame2, parame1);
    return new b1(parame1);
  }
  
  public e.a.b.a.e q(int paramInt)
  {
    if (paramInt < 1) {
      return this;
    }
    long[] arrayOfLong = e.a.b.c.e.h();
    a1.q(this.g, paramInt, arrayOfLong);
    return new b1(arrayOfLong);
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
    return a1.r(this.g);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\b1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */