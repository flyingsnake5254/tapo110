package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.b;
import e.a.b.c.b;
import e.a.b.c.g;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class g0
  extends e.b
{
  public static final BigInteger g = e0.i;
  protected int[] h;
  
  public g0()
  {
    this.h = g.h();
  }
  
  public g0(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(g) < 0))
    {
      this.h = f0.c(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
  }
  
  protected g0(int[] paramArrayOfInt)
  {
    this.h = paramArrayOfInt;
  }
  
  public e a(e parame)
  {
    int[] arrayOfInt = g.h();
    f0.a(this.h, ((g0)parame).h, arrayOfInt);
    return new g0(arrayOfInt);
  }
  
  public e b()
  {
    int[] arrayOfInt = g.h();
    f0.b(this.h, arrayOfInt);
    return new g0(arrayOfInt);
  }
  
  public e d(e parame)
  {
    int[] arrayOfInt = g.h();
    b.d(f0.a, ((g0)parame).h, arrayOfInt);
    f0.d(arrayOfInt, this.h, arrayOfInt);
    return new g0(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof g0)) {
      return false;
    }
    paramObject = (g0)paramObject;
    return g.m(this.h, ((g0)paramObject).h);
  }
  
  public int f()
  {
    return g.bitLength();
  }
  
  public e g()
  {
    int[] arrayOfInt = g.h();
    b.d(f0.a, this.h, arrayOfInt);
    return new g0(arrayOfInt);
  }
  
  public boolean h()
  {
    return g.t(this.h);
  }
  
  public int hashCode()
  {
    return g.hashCode() ^ a.z(this.h, 0, 8);
  }
  
  public boolean i()
  {
    return g.v(this.h);
  }
  
  public e j(e parame)
  {
    int[] arrayOfInt = g.h();
    f0.d(this.h, ((g0)parame).h, arrayOfInt);
    return new g0(arrayOfInt);
  }
  
  public e m()
  {
    int[] arrayOfInt = g.h();
    f0.f(this.h, arrayOfInt);
    return new g0(arrayOfInt);
  }
  
  public e n()
  {
    int[] arrayOfInt1 = this.h;
    if ((!g.v(arrayOfInt1)) && (!g.t(arrayOfInt1)))
    {
      int[] arrayOfInt2 = g.h();
      f0.i(arrayOfInt1, arrayOfInt2);
      f0.d(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      int[] arrayOfInt3 = g.h();
      f0.i(arrayOfInt2, arrayOfInt3);
      f0.d(arrayOfInt3, arrayOfInt1, arrayOfInt3);
      int[] arrayOfInt4 = g.h();
      f0.j(arrayOfInt3, 3, arrayOfInt4);
      f0.d(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      f0.j(arrayOfInt4, 3, arrayOfInt4);
      f0.d(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      f0.j(arrayOfInt4, 2, arrayOfInt4);
      f0.d(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      int[] arrayOfInt5 = g.h();
      f0.j(arrayOfInt4, 11, arrayOfInt5);
      f0.d(arrayOfInt5, arrayOfInt4, arrayOfInt5);
      f0.j(arrayOfInt5, 22, arrayOfInt4);
      f0.d(arrayOfInt4, arrayOfInt5, arrayOfInt4);
      int[] arrayOfInt6 = g.h();
      f0.j(arrayOfInt4, 44, arrayOfInt6);
      f0.d(arrayOfInt6, arrayOfInt4, arrayOfInt6);
      Object localObject = g.h();
      f0.j(arrayOfInt6, 88, (int[])localObject);
      f0.d((int[])localObject, arrayOfInt6, (int[])localObject);
      f0.j((int[])localObject, 44, arrayOfInt6);
      f0.d(arrayOfInt6, arrayOfInt4, arrayOfInt6);
      f0.j(arrayOfInt6, 3, arrayOfInt4);
      f0.d(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      f0.j(arrayOfInt4, 23, arrayOfInt4);
      f0.d(arrayOfInt4, arrayOfInt5, arrayOfInt4);
      f0.j(arrayOfInt4, 6, arrayOfInt4);
      f0.d(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      f0.j(arrayOfInt4, 2, arrayOfInt4);
      f0.i(arrayOfInt4, arrayOfInt2);
      if (g.m(arrayOfInt1, arrayOfInt2)) {
        localObject = new g0(arrayOfInt4);
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
    f0.i(this.h, arrayOfInt);
    return new g0(arrayOfInt);
  }
  
  public e r(e parame)
  {
    int[] arrayOfInt = g.h();
    f0.k(this.h, ((g0)parame).h, arrayOfInt);
    return new g0(arrayOfInt);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */