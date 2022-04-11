package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.a;
import e.a.b.c.c;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class v0
  extends e.a
{
  protected long[] g;
  
  public v0()
  {
    this.g = c.f();
  }
  
  public v0(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 113))
    {
      this.g = u0.d(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
  }
  
  protected v0(long[] paramArrayOfLong)
  {
    this.g = paramArrayOfLong;
  }
  
  public e a(e parame)
  {
    long[] arrayOfLong = c.f();
    u0.a(this.g, ((v0)parame).g, arrayOfLong);
    return new v0(arrayOfLong);
  }
  
  public e b()
  {
    long[] arrayOfLong = c.f();
    u0.c(this.g, arrayOfLong);
    return new v0(arrayOfLong);
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
    if (!(paramObject instanceof v0)) {
      return false;
    }
    paramObject = (v0)paramObject;
    return c.j(this.g, ((v0)paramObject).g);
  }
  
  public int f()
  {
    return 113;
  }
  
  public e g()
  {
    long[] arrayOfLong = c.f();
    u0.h(this.g, arrayOfLong);
    return new v0(arrayOfLong);
  }
  
  public boolean h()
  {
    return c.p(this.g);
  }
  
  public int hashCode()
  {
    return a.A(this.g, 0, 2) ^ 0x1B971;
  }
  
  public boolean i()
  {
    return c.r(this.g);
  }
  
  public e j(e parame)
  {
    long[] arrayOfLong = c.f();
    u0.i(this.g, ((v0)parame).g, arrayOfLong);
    return new v0(arrayOfLong);
  }
  
  public e k(e parame1, e parame2, e parame3)
  {
    return l(parame1, parame2, parame3);
  }
  
  public e l(e parame1, e parame2, e parame3)
  {
    long[] arrayOfLong1 = this.g;
    parame1 = ((v0)parame1).g;
    long[] arrayOfLong2 = ((v0)parame2).g;
    parame3 = ((v0)parame3).g;
    parame2 = c.h();
    u0.j(arrayOfLong1, parame1, parame2);
    u0.j(arrayOfLong2, parame3, parame2);
    parame1 = c.f();
    u0.k(parame2, parame1);
    return new v0(parame1);
  }
  
  public e m()
  {
    return this;
  }
  
  public e n()
  {
    long[] arrayOfLong = c.f();
    u0.m(this.g, arrayOfLong);
    return new v0(arrayOfLong);
  }
  
  public e o()
  {
    long[] arrayOfLong = c.f();
    u0.n(this.g, arrayOfLong);
    return new v0(arrayOfLong);
  }
  
  public e p(e parame1, e parame2)
  {
    long[] arrayOfLong1 = this.g;
    parame1 = ((v0)parame1).g;
    long[] arrayOfLong2 = ((v0)parame2).g;
    parame2 = c.h();
    u0.o(arrayOfLong1, parame2);
    u0.j(parame1, arrayOfLong2, parame2);
    parame1 = c.f();
    u0.k(parame2, parame1);
    return new v0(parame1);
  }
  
  public e q(int paramInt)
  {
    if (paramInt < 1) {
      return this;
    }
    long[] arrayOfLong = c.f();
    u0.p(this.g, paramInt, arrayOfLong);
    return new v0(arrayOfLong);
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
    return c.y(this.g);
  }
  
  public int u()
  {
    return u0.q(this.g);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\v0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */