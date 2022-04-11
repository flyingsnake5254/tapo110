package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.a;
import e.a.b.c.l;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class r2
  extends e.a
{
  protected long[] g;
  
  public r2()
  {
    this.g = l.b();
  }
  
  public r2(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 571))
    {
      this.g = q2.g(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
  }
  
  protected r2(long[] paramArrayOfLong)
  {
    this.g = paramArrayOfLong;
  }
  
  public e a(e parame)
  {
    long[] arrayOfLong = l.b();
    q2.b(this.g, ((r2)parame).g, arrayOfLong);
    return new r2(arrayOfLong);
  }
  
  public e b()
  {
    long[] arrayOfLong = l.b();
    q2.f(this.g, arrayOfLong);
    return new r2(arrayOfLong);
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
    if (!(paramObject instanceof r2)) {
      return false;
    }
    paramObject = (r2)paramObject;
    return l.d(this.g, ((r2)paramObject).g);
  }
  
  public int f()
  {
    return 571;
  }
  
  public e g()
  {
    long[] arrayOfLong = l.b();
    q2.k(this.g, arrayOfLong);
    return new r2(arrayOfLong);
  }
  
  public boolean h()
  {
    return l.f(this.g);
  }
  
  public int hashCode()
  {
    return a.A(this.g, 0, 9) ^ 0x5724CC;
  }
  
  public boolean i()
  {
    return l.g(this.g);
  }
  
  public e j(e parame)
  {
    long[] arrayOfLong = l.b();
    q2.l(this.g, ((r2)parame).g, arrayOfLong);
    return new r2(arrayOfLong);
  }
  
  public e k(e parame1, e parame2, e parame3)
  {
    return l(parame1, parame2, parame3);
  }
  
  public e l(e parame1, e parame2, e parame3)
  {
    long[] arrayOfLong1 = this.g;
    parame1 = ((r2)parame1).g;
    parame2 = ((r2)parame2).g;
    long[] arrayOfLong2 = ((r2)parame3).g;
    parame3 = l.c();
    q2.m(arrayOfLong1, parame1, parame3);
    q2.m(parame2, arrayOfLong2, parame3);
    parame1 = l.b();
    q2.q(parame3, parame1);
    return new r2(parame1);
  }
  
  public e m()
  {
    return this;
  }
  
  public e n()
  {
    long[] arrayOfLong = l.b();
    q2.s(this.g, arrayOfLong);
    return new r2(arrayOfLong);
  }
  
  public e o()
  {
    long[] arrayOfLong = l.b();
    q2.t(this.g, arrayOfLong);
    return new r2(arrayOfLong);
  }
  
  public e p(e parame1, e parame2)
  {
    long[] arrayOfLong1 = this.g;
    long[] arrayOfLong2 = ((r2)parame1).g;
    parame2 = ((r2)parame2).g;
    parame1 = l.c();
    q2.u(arrayOfLong1, parame1);
    q2.m(arrayOfLong2, parame2, parame1);
    parame2 = l.b();
    q2.q(parame1, parame2);
    return new r2(parame2);
  }
  
  public e q(int paramInt)
  {
    if (paramInt < 1) {
      return this;
    }
    long[] arrayOfLong = l.b();
    q2.v(this.g, paramInt, arrayOfLong);
    return new r2(arrayOfLong);
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
    return l.h(this.g);
  }
  
  public int u()
  {
    return q2.w(this.g);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\r2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */