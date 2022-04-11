package e.a.b.a.a0.a;

import e.a.b.a.e;
import e.a.b.a.e.b;
import e.a.b.c.g;
import java.math.BigInteger;

public class c
  extends e.b
{
  public static final BigInteger g = a.i;
  private static final int[] h = { 1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848 };
  protected int[] i;
  
  public c()
  {
    this.i = g.h();
  }
  
  public c(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(g) < 0))
    {
      this.i = b.d(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
  }
  
  protected c(int[] paramArrayOfInt)
  {
    this.i = paramArrayOfInt;
  }
  
  public e a(e parame)
  {
    int[] arrayOfInt = g.h();
    b.a(this.i, ((c)parame).i, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e b()
  {
    int[] arrayOfInt = g.h();
    b.b(this.i, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e d(e parame)
  {
    int[] arrayOfInt = g.h();
    e.a.b.c.b.d(b.a, ((c)parame).i, arrayOfInt);
    b.e(arrayOfInt, this.i, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    return g.m(this.i, ((c)paramObject).i);
  }
  
  public int f()
  {
    return g.bitLength();
  }
  
  public e g()
  {
    int[] arrayOfInt = g.h();
    e.a.b.c.b.d(b.a, this.i, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public boolean h()
  {
    return g.t(this.i);
  }
  
  public int hashCode()
  {
    return g.hashCode() ^ org.bouncycastle.util.a.z(this.i, 0, 8);
  }
  
  public boolean i()
  {
    return g.v(this.i);
  }
  
  public e j(e parame)
  {
    int[] arrayOfInt = g.h();
    b.e(this.i, ((c)parame).i, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e m()
  {
    int[] arrayOfInt = g.h();
    b.g(this.i, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e n()
  {
    int[] arrayOfInt1 = this.i;
    if ((!g.v(arrayOfInt1)) && (!g.t(arrayOfInt1)))
    {
      int[] arrayOfInt2 = g.h();
      b.j(arrayOfInt1, arrayOfInt2);
      b.e(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      b.j(arrayOfInt2, arrayOfInt2);
      b.e(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      int[] arrayOfInt3 = g.h();
      b.j(arrayOfInt2, arrayOfInt3);
      b.e(arrayOfInt3, arrayOfInt1, arrayOfInt3);
      int[] arrayOfInt4 = g.h();
      b.k(arrayOfInt3, 3, arrayOfInt4);
      b.e(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      b.k(arrayOfInt4, 4, arrayOfInt2);
      b.e(arrayOfInt2, arrayOfInt3, arrayOfInt2);
      b.k(arrayOfInt2, 4, arrayOfInt4);
      b.e(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      b.k(arrayOfInt4, 15, arrayOfInt3);
      b.e(arrayOfInt3, arrayOfInt4, arrayOfInt3);
      b.k(arrayOfInt3, 30, arrayOfInt4);
      b.e(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      b.k(arrayOfInt4, 60, arrayOfInt3);
      b.e(arrayOfInt3, arrayOfInt4, arrayOfInt3);
      b.k(arrayOfInt3, 11, arrayOfInt4);
      b.e(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      b.k(arrayOfInt4, 120, arrayOfInt2);
      b.e(arrayOfInt2, arrayOfInt3, arrayOfInt2);
      b.j(arrayOfInt2, arrayOfInt2);
      b.j(arrayOfInt2, arrayOfInt3);
      if (g.m(arrayOfInt1, arrayOfInt3)) {
        return new c(arrayOfInt2);
      }
      b.e(arrayOfInt2, h, arrayOfInt2);
      b.j(arrayOfInt2, arrayOfInt3);
      if (g.m(arrayOfInt1, arrayOfInt3)) {
        return new c(arrayOfInt2);
      }
      return null;
    }
    return this;
  }
  
  public e o()
  {
    int[] arrayOfInt = g.h();
    b.j(this.i, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e r(e parame)
  {
    int[] arrayOfInt = g.h();
    b.n(this.i, ((c)parame).i, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public boolean s()
  {
    int[] arrayOfInt = this.i;
    boolean bool = false;
    if (g.q(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger t()
  {
    return g.J(this.i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */