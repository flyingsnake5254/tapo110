package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.b;
import e.a.b.c.b;
import e.a.b.c.g;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class k0
  extends e.b
{
  public static final BigInteger g = i0.i;
  protected int[] h;
  
  public k0()
  {
    this.h = g.h();
  }
  
  public k0(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(g) < 0))
    {
      this.h = j0.d(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
  }
  
  protected k0(int[] paramArrayOfInt)
  {
    this.h = paramArrayOfInt;
  }
  
  public e a(e parame)
  {
    int[] arrayOfInt = g.h();
    j0.a(this.h, ((k0)parame).h, arrayOfInt);
    return new k0(arrayOfInt);
  }
  
  public e b()
  {
    int[] arrayOfInt = g.h();
    j0.b(this.h, arrayOfInt);
    return new k0(arrayOfInt);
  }
  
  public e d(e parame)
  {
    int[] arrayOfInt = g.h();
    b.d(j0.a, ((k0)parame).h, arrayOfInt);
    j0.e(arrayOfInt, this.h, arrayOfInt);
    return new k0(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof k0)) {
      return false;
    }
    paramObject = (k0)paramObject;
    return g.m(this.h, ((k0)paramObject).h);
  }
  
  public int f()
  {
    return g.bitLength();
  }
  
  public e g()
  {
    int[] arrayOfInt = g.h();
    b.d(j0.a, this.h, arrayOfInt);
    return new k0(arrayOfInt);
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
    j0.e(this.h, ((k0)parame).h, arrayOfInt);
    return new k0(arrayOfInt);
  }
  
  public e m()
  {
    int[] arrayOfInt = g.h();
    j0.g(this.h, arrayOfInt);
    return new k0(arrayOfInt);
  }
  
  public e n()
  {
    int[] arrayOfInt1 = this.h;
    if ((!g.v(arrayOfInt1)) && (!g.t(arrayOfInt1)))
    {
      Object localObject = g.h();
      int[] arrayOfInt2 = g.h();
      j0.j(arrayOfInt1, (int[])localObject);
      j0.e((int[])localObject, arrayOfInt1, (int[])localObject);
      j0.k((int[])localObject, 2, arrayOfInt2);
      j0.e(arrayOfInt2, (int[])localObject, arrayOfInt2);
      j0.k(arrayOfInt2, 4, (int[])localObject);
      j0.e((int[])localObject, arrayOfInt2, (int[])localObject);
      j0.k((int[])localObject, 8, arrayOfInt2);
      j0.e(arrayOfInt2, (int[])localObject, arrayOfInt2);
      j0.k(arrayOfInt2, 16, (int[])localObject);
      j0.e((int[])localObject, arrayOfInt2, (int[])localObject);
      j0.k((int[])localObject, 32, (int[])localObject);
      j0.e((int[])localObject, arrayOfInt1, (int[])localObject);
      j0.k((int[])localObject, 96, (int[])localObject);
      j0.e((int[])localObject, arrayOfInt1, (int[])localObject);
      j0.k((int[])localObject, 94, (int[])localObject);
      j0.j((int[])localObject, arrayOfInt2);
      if (g.m(arrayOfInt1, arrayOfInt2)) {
        localObject = new k0((int[])localObject);
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
    j0.j(this.h, arrayOfInt);
    return new k0(arrayOfInt);
  }
  
  public e r(e parame)
  {
    int[] arrayOfInt = g.h();
    j0.m(this.h, ((k0)parame).h, arrayOfInt);
    return new k0(arrayOfInt);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\k0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */