package e.a.b.a.a0.b;

import e.a.b.a.e;
import e.a.b.a.e.b;
import e.a.b.c.g;
import java.math.BigInteger;

public class c
  extends e.b
{
  public static final BigInteger g = a.i;
  protected int[] h;
  
  public c()
  {
    this.h = g.h();
  }
  
  public c(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(g) < 0))
    {
      this.h = b.d(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
  }
  
  protected c(int[] paramArrayOfInt)
  {
    this.h = paramArrayOfInt;
  }
  
  public e a(e parame)
  {
    int[] arrayOfInt = g.h();
    b.a(this.h, ((c)parame).h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e b()
  {
    int[] arrayOfInt = g.h();
    b.b(this.h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e d(e parame)
  {
    int[] arrayOfInt = g.h();
    e.a.b.c.b.d(b.a, ((c)parame).h, arrayOfInt);
    b.e(arrayOfInt, this.h, arrayOfInt);
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
    return g.m(this.h, ((c)paramObject).h);
  }
  
  public int f()
  {
    return g.bitLength();
  }
  
  public e g()
  {
    int[] arrayOfInt = g.h();
    e.a.b.c.b.d(b.a, this.h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public boolean h()
  {
    return g.t(this.h);
  }
  
  public int hashCode()
  {
    return g.hashCode() ^ org.bouncycastle.util.a.z(this.h, 0, 8);
  }
  
  public boolean i()
  {
    return g.v(this.h);
  }
  
  public e j(e parame)
  {
    int[] arrayOfInt = g.h();
    b.e(this.h, ((c)parame).h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e m()
  {
    int[] arrayOfInt = g.h();
    b.g(this.h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e n()
  {
    int[] arrayOfInt1 = this.h;
    if ((!g.v(arrayOfInt1)) && (!g.t(arrayOfInt1)))
    {
      int[] arrayOfInt2 = g.h();
      b.j(arrayOfInt1, arrayOfInt2);
      b.e(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      int[] arrayOfInt3 = g.h();
      b.k(arrayOfInt2, 2, arrayOfInt3);
      b.e(arrayOfInt3, arrayOfInt2, arrayOfInt3);
      int[] arrayOfInt4 = g.h();
      b.k(arrayOfInt3, 2, arrayOfInt4);
      b.e(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      b.k(arrayOfInt4, 6, arrayOfInt2);
      b.e(arrayOfInt2, arrayOfInt4, arrayOfInt2);
      Object localObject = g.h();
      b.k(arrayOfInt2, 12, (int[])localObject);
      b.e((int[])localObject, arrayOfInt2, (int[])localObject);
      b.k((int[])localObject, 6, arrayOfInt2);
      b.e(arrayOfInt2, arrayOfInt4, arrayOfInt2);
      b.j(arrayOfInt2, arrayOfInt4);
      b.e(arrayOfInt4, arrayOfInt1, arrayOfInt4);
      b.k(arrayOfInt4, 31, (int[])localObject);
      b.e((int[])localObject, arrayOfInt4, arrayOfInt2);
      b.k((int[])localObject, 32, (int[])localObject);
      b.e((int[])localObject, arrayOfInt2, (int[])localObject);
      b.k((int[])localObject, 62, (int[])localObject);
      b.e((int[])localObject, arrayOfInt2, (int[])localObject);
      b.k((int[])localObject, 4, (int[])localObject);
      b.e((int[])localObject, arrayOfInt3, (int[])localObject);
      b.k((int[])localObject, 32, (int[])localObject);
      b.e((int[])localObject, arrayOfInt1, (int[])localObject);
      b.k((int[])localObject, 62, (int[])localObject);
      b.j((int[])localObject, arrayOfInt3);
      if (g.m(arrayOfInt1, arrayOfInt3)) {
        localObject = new c((int[])localObject);
      } else {
        localObject = null;
      }
      return (e)localObject;
    }
    return this;
  }
  
  public e o()
  {
    int[] arrayOfInt = g.h();
    b.j(this.h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e r(e parame)
  {
    int[] arrayOfInt = g.h();
    b.m(this.h, ((c)parame).h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public boolean s()
  {
    int[] arrayOfInt = this.h;
    boolean bool = false;
    if (g.q(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger t()
  {
    return g.J(this.h);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */