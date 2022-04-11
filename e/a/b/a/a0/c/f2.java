package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.a;
import e.a.b.c.h;
import e.a.b.c.m;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class f2
  extends e.a
{
  protected long[] g;
  
  public f2()
  {
    this.g = h.b();
  }
  
  public f2(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 283))
    {
      this.g = e2.d(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
  }
  
  protected f2(long[] paramArrayOfLong)
  {
    this.g = paramArrayOfLong;
  }
  
  public e a(e parame)
  {
    long[] arrayOfLong = h.b();
    e2.a(this.g, ((f2)parame).g, arrayOfLong);
    return new f2(arrayOfLong);
  }
  
  public e b()
  {
    long[] arrayOfLong = h.b();
    e2.c(this.g, arrayOfLong);
    return new f2(arrayOfLong);
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
    if (!(paramObject instanceof f2)) {
      return false;
    }
    paramObject = (f2)paramObject;
    return h.d(this.g, ((f2)paramObject).g);
  }
  
  public int f()
  {
    return 283;
  }
  
  public e g()
  {
    long[] arrayOfLong = h.b();
    e2.j(this.g, arrayOfLong);
    return new f2(arrayOfLong);
  }
  
  public boolean h()
  {
    return h.f(this.g);
  }
  
  public int hashCode()
  {
    return a.A(this.g, 0, 5) ^ 0x2B33AB;
  }
  
  public boolean i()
  {
    return h.g(this.g);
  }
  
  public e j(e parame)
  {
    long[] arrayOfLong = h.b();
    e2.k(this.g, ((f2)parame).g, arrayOfLong);
    return new f2(arrayOfLong);
  }
  
  public e k(e parame1, e parame2, e parame3)
  {
    return l(parame1, parame2, parame3);
  }
  
  public e l(e parame1, e parame2, e parame3)
  {
    long[] arrayOfLong1 = this.g;
    parame1 = ((f2)parame1).g;
    parame2 = ((f2)parame2).g;
    long[] arrayOfLong2 = ((f2)parame3).g;
    parame3 = m.k(9);
    e2.l(arrayOfLong1, parame1, parame3);
    e2.l(parame2, arrayOfLong2, parame3);
    parame1 = h.b();
    e2.m(parame3, parame1);
    return new f2(parame1);
  }
  
  public e m()
  {
    return this;
  }
  
  public e n()
  {
    long[] arrayOfLong = h.b();
    e2.o(this.g, arrayOfLong);
    return new f2(arrayOfLong);
  }
  
  public e o()
  {
    long[] arrayOfLong = h.b();
    e2.p(this.g, arrayOfLong);
    return new f2(arrayOfLong);
  }
  
  public e p(e parame1, e parame2)
  {
    long[] arrayOfLong1 = this.g;
    long[] arrayOfLong2 = ((f2)parame1).g;
    parame2 = ((f2)parame2).g;
    parame1 = m.k(9);
    e2.q(arrayOfLong1, parame1);
    e2.l(arrayOfLong2, parame2, parame1);
    parame2 = h.b();
    e2.m(parame1, parame2);
    return new f2(parame2);
  }
  
  public e q(int paramInt)
  {
    if (paramInt < 1) {
      return this;
    }
    long[] arrayOfLong = h.b();
    e2.r(this.g, paramInt, arrayOfLong);
    return new f2(arrayOfLong);
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
    return h.h(this.g);
  }
  
  public int u()
  {
    return e2.s(this.g);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\f2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */