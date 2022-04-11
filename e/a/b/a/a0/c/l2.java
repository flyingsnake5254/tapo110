package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.a;
import e.a.b.c.j;
import e.a.b.c.m;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class l2
  extends e.a
{
  protected long[] g;
  
  public l2()
  {
    this.g = j.b();
  }
  
  public l2(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 409))
    {
      this.g = k2.d(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
  }
  
  protected l2(long[] paramArrayOfLong)
  {
    this.g = paramArrayOfLong;
  }
  
  public e a(e parame)
  {
    long[] arrayOfLong = j.b();
    k2.a(this.g, ((l2)parame).g, arrayOfLong);
    return new l2(arrayOfLong);
  }
  
  public e b()
  {
    long[] arrayOfLong = j.b();
    k2.c(this.g, arrayOfLong);
    return new l2(arrayOfLong);
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
    if (!(paramObject instanceof l2)) {
      return false;
    }
    paramObject = (l2)paramObject;
    return j.d(this.g, ((l2)paramObject).g);
  }
  
  public int f()
  {
    return 409;
  }
  
  public e g()
  {
    long[] arrayOfLong = j.b();
    k2.j(this.g, arrayOfLong);
    return new l2(arrayOfLong);
  }
  
  public boolean h()
  {
    return j.f(this.g);
  }
  
  public int hashCode()
  {
    return a.A(this.g, 0, 7) ^ 0x3E68E7;
  }
  
  public boolean i()
  {
    return j.g(this.g);
  }
  
  public e j(e parame)
  {
    long[] arrayOfLong = j.b();
    k2.k(this.g, ((l2)parame).g, arrayOfLong);
    return new l2(arrayOfLong);
  }
  
  public e k(e parame1, e parame2, e parame3)
  {
    return l(parame1, parame2, parame3);
  }
  
  public e l(e parame1, e parame2, e parame3)
  {
    long[] arrayOfLong1 = this.g;
    parame1 = ((l2)parame1).g;
    parame2 = ((l2)parame2).g;
    long[] arrayOfLong2 = ((l2)parame3).g;
    parame3 = m.k(13);
    k2.l(arrayOfLong1, parame1, parame3);
    k2.l(parame2, arrayOfLong2, parame3);
    parame1 = j.b();
    k2.m(parame3, parame1);
    return new l2(parame1);
  }
  
  public e m()
  {
    return this;
  }
  
  public e n()
  {
    long[] arrayOfLong = j.b();
    k2.o(this.g, arrayOfLong);
    return new l2(arrayOfLong);
  }
  
  public e o()
  {
    long[] arrayOfLong = j.b();
    k2.p(this.g, arrayOfLong);
    return new l2(arrayOfLong);
  }
  
  public e p(e parame1, e parame2)
  {
    long[] arrayOfLong1 = this.g;
    parame1 = ((l2)parame1).g;
    long[] arrayOfLong2 = ((l2)parame2).g;
    parame2 = m.k(13);
    k2.q(arrayOfLong1, parame2);
    k2.l(parame1, arrayOfLong2, parame2);
    parame1 = j.b();
    k2.m(parame2, parame1);
    return new l2(parame1);
  }
  
  public e q(int paramInt)
  {
    if (paramInt < 1) {
      return this;
    }
    long[] arrayOfLong = j.b();
    k2.r(this.g, paramInt, arrayOfLong);
    return new l2(arrayOfLong);
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
    return j.h(this.g);
  }
  
  public int u()
  {
    return k2.s(this.g);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\l2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */