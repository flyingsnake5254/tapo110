package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.b;
import e.a.b.c.b;
import e.a.b.c.m;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class o0
  extends e.b
{
  public static final BigInteger g = m0.i;
  protected int[] h;
  
  public o0()
  {
    this.h = m.j(12);
  }
  
  public o0(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(g) < 0))
    {
      this.h = n0.e(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
  }
  
  protected o0(int[] paramArrayOfInt)
  {
    this.h = paramArrayOfInt;
  }
  
  public e a(e parame)
  {
    int[] arrayOfInt = m.j(12);
    n0.a(this.h, ((o0)parame).h, arrayOfInt);
    return new o0(arrayOfInt);
  }
  
  public e b()
  {
    int[] arrayOfInt = m.j(12);
    n0.c(this.h, arrayOfInt);
    return new o0(arrayOfInt);
  }
  
  public e d(e parame)
  {
    int[] arrayOfInt = m.j(12);
    b.d(n0.a, ((o0)parame).h, arrayOfInt);
    n0.f(arrayOfInt, this.h, arrayOfInt);
    return new o0(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof o0)) {
      return false;
    }
    paramObject = (o0)paramObject;
    return m.n(12, this.h, ((o0)paramObject).h);
  }
  
  public int f()
  {
    return g.bitLength();
  }
  
  public e g()
  {
    int[] arrayOfInt = m.j(12);
    b.d(n0.a, this.h, arrayOfInt);
    return new o0(arrayOfInt);
  }
  
  public boolean h()
  {
    return m.v(12, this.h);
  }
  
  public int hashCode()
  {
    return g.hashCode() ^ a.z(this.h, 0, 12);
  }
  
  public boolean i()
  {
    return m.w(12, this.h);
  }
  
  public e j(e parame)
  {
    int[] arrayOfInt = m.j(12);
    n0.f(this.h, ((o0)parame).h, arrayOfInt);
    return new o0(arrayOfInt);
  }
  
  public e m()
  {
    int[] arrayOfInt = m.j(12);
    n0.g(this.h, arrayOfInt);
    return new o0(arrayOfInt);
  }
  
  public e n()
  {
    Object localObject = this.h;
    if ((!m.w(12, (int[])localObject)) && (!m.v(12, (int[])localObject)))
    {
      int[] arrayOfInt1 = m.j(12);
      int[] arrayOfInt2 = m.j(12);
      int[] arrayOfInt3 = m.j(12);
      int[] arrayOfInt4 = m.j(12);
      n0.j((int[])localObject, arrayOfInt1);
      n0.f(arrayOfInt1, (int[])localObject, arrayOfInt1);
      n0.k(arrayOfInt1, 2, arrayOfInt2);
      n0.f(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      n0.j(arrayOfInt2, arrayOfInt2);
      n0.f(arrayOfInt2, (int[])localObject, arrayOfInt2);
      n0.k(arrayOfInt2, 5, arrayOfInt3);
      n0.f(arrayOfInt3, arrayOfInt2, arrayOfInt3);
      n0.k(arrayOfInt3, 5, arrayOfInt4);
      n0.f(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      n0.k(arrayOfInt4, 15, arrayOfInt2);
      n0.f(arrayOfInt2, arrayOfInt4, arrayOfInt2);
      n0.k(arrayOfInt2, 2, arrayOfInt3);
      n0.f(arrayOfInt1, arrayOfInt3, arrayOfInt1);
      n0.k(arrayOfInt3, 28, arrayOfInt3);
      n0.f(arrayOfInt2, arrayOfInt3, arrayOfInt2);
      n0.k(arrayOfInt2, 60, arrayOfInt3);
      n0.f(arrayOfInt3, arrayOfInt2, arrayOfInt3);
      n0.k(arrayOfInt3, 120, arrayOfInt2);
      n0.f(arrayOfInt2, arrayOfInt3, arrayOfInt2);
      n0.k(arrayOfInt2, 15, arrayOfInt2);
      n0.f(arrayOfInt2, arrayOfInt4, arrayOfInt2);
      n0.k(arrayOfInt2, 33, arrayOfInt2);
      n0.f(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      n0.k(arrayOfInt2, 64, arrayOfInt2);
      n0.f(arrayOfInt2, (int[])localObject, arrayOfInt2);
      n0.k(arrayOfInt2, 30, arrayOfInt1);
      n0.j(arrayOfInt1, arrayOfInt2);
      if (m.n(12, (int[])localObject, arrayOfInt2)) {
        localObject = new o0(arrayOfInt1);
      } else {
        localObject = null;
      }
      return (e)localObject;
    }
    return this;
  }
  
  public e o()
  {
    int[] arrayOfInt = m.j(12);
    n0.j(this.h, arrayOfInt);
    return new o0(arrayOfInt);
  }
  
  public e r(e parame)
  {
    int[] arrayOfInt = m.j(12);
    n0.m(this.h, ((o0)parame).h, arrayOfInt);
    return new o0(arrayOfInt);
  }
  
  public boolean s()
  {
    int[] arrayOfInt = this.h;
    boolean bool = false;
    if (m.p(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger t()
  {
    return m.P(12, this.h);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\o0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */