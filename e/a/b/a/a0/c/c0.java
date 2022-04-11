package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.b;
import e.a.b.c.b;
import e.a.b.c.f;
import e.a.b.c.m;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class c0
  extends e.b
{
  public static final BigInteger g = a0.i;
  protected int[] h;
  
  public c0()
  {
    this.h = f.e();
  }
  
  public c0(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(g) < 0))
    {
      this.h = b0.d(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
  }
  
  protected c0(int[] paramArrayOfInt)
  {
    this.h = paramArrayOfInt;
  }
  
  private static void u(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, int[] paramArrayOfInt7)
  {
    b0.e(paramArrayOfInt5, paramArrayOfInt3, paramArrayOfInt7);
    b0.e(paramArrayOfInt7, paramArrayOfInt1, paramArrayOfInt7);
    b0.e(paramArrayOfInt4, paramArrayOfInt2, paramArrayOfInt6);
    b0.a(paramArrayOfInt6, paramArrayOfInt7, paramArrayOfInt6);
    b0.e(paramArrayOfInt4, paramArrayOfInt3, paramArrayOfInt7);
    f.d(paramArrayOfInt6, paramArrayOfInt4);
    b0.e(paramArrayOfInt5, paramArrayOfInt2, paramArrayOfInt5);
    b0.a(paramArrayOfInt5, paramArrayOfInt7, paramArrayOfInt5);
    b0.j(paramArrayOfInt5, paramArrayOfInt6);
    b0.e(paramArrayOfInt6, paramArrayOfInt1, paramArrayOfInt6);
  }
  
  private static void v(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5)
  {
    f.d(paramArrayOfInt1, paramArrayOfInt4);
    int[] arrayOfInt1 = f.e();
    int[] arrayOfInt2 = f.e();
    for (int i = 0; i < 7; i++)
    {
      f.d(paramArrayOfInt2, arrayOfInt1);
      f.d(paramArrayOfInt3, arrayOfInt2);
      int j = 1 << i;
      for (;;)
      {
        j--;
        if (j < 0) {
          break;
        }
        w(paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5);
      }
      u(paramArrayOfInt1, arrayOfInt1, arrayOfInt2, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5);
    }
  }
  
  private static void w(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    b0.e(paramArrayOfInt2, paramArrayOfInt1, paramArrayOfInt2);
    b0.n(paramArrayOfInt2, paramArrayOfInt2);
    b0.j(paramArrayOfInt1, paramArrayOfInt4);
    b0.a(paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt1);
    b0.e(paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt3);
    b0.i(m.G(7, paramArrayOfInt3, 2, 0), paramArrayOfInt3);
  }
  
  private static boolean x(int[] paramArrayOfInt)
  {
    int[] arrayOfInt1 = f.e();
    int[] arrayOfInt2 = f.e();
    f.d(paramArrayOfInt, arrayOfInt1);
    for (int i = 0; i < 7; i++)
    {
      f.d(arrayOfInt1, arrayOfInt2);
      b0.k(arrayOfInt1, 1 << i, arrayOfInt1);
      b0.e(arrayOfInt1, arrayOfInt2, arrayOfInt1);
    }
    b0.k(arrayOfInt1, 95, arrayOfInt1);
    return f.k(arrayOfInt1);
  }
  
  private static boolean y(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt1 = f.e();
    f.d(paramArrayOfInt2, arrayOfInt1);
    paramArrayOfInt2 = f.e();
    paramArrayOfInt2[0] = 1;
    int[] arrayOfInt2 = f.e();
    v(paramArrayOfInt1, arrayOfInt1, paramArrayOfInt2, arrayOfInt2, paramArrayOfInt3);
    paramArrayOfInt1 = f.e();
    int[] arrayOfInt3 = f.e();
    for (int i = 1; i < 96; i++)
    {
      f.d(arrayOfInt1, paramArrayOfInt1);
      f.d(paramArrayOfInt2, arrayOfInt3);
      w(arrayOfInt1, paramArrayOfInt2, arrayOfInt2, paramArrayOfInt3);
      if (f.l(arrayOfInt1))
      {
        b.d(b0.a, arrayOfInt3, paramArrayOfInt3);
        b0.e(paramArrayOfInt3, paramArrayOfInt1, paramArrayOfInt3);
        return true;
      }
    }
    return false;
  }
  
  public e a(e parame)
  {
    int[] arrayOfInt = f.e();
    b0.a(this.h, ((c0)parame).h, arrayOfInt);
    return new c0(arrayOfInt);
  }
  
  public e b()
  {
    int[] arrayOfInt = f.e();
    b0.b(this.h, arrayOfInt);
    return new c0(arrayOfInt);
  }
  
  public e d(e parame)
  {
    int[] arrayOfInt = f.e();
    b.d(b0.a, ((c0)parame).h, arrayOfInt);
    b0.e(arrayOfInt, this.h, arrayOfInt);
    return new c0(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof c0)) {
      return false;
    }
    paramObject = (c0)paramObject;
    return f.g(this.h, ((c0)paramObject).h);
  }
  
  public int f()
  {
    return g.bitLength();
  }
  
  public e g()
  {
    int[] arrayOfInt = f.e();
    b.d(b0.a, this.h, arrayOfInt);
    return new c0(arrayOfInt);
  }
  
  public boolean h()
  {
    return f.k(this.h);
  }
  
  public int hashCode()
  {
    return g.hashCode() ^ a.z(this.h, 0, 7);
  }
  
  public boolean i()
  {
    return f.l(this.h);
  }
  
  public e j(e parame)
  {
    int[] arrayOfInt = f.e();
    b0.e(this.h, ((c0)parame).h, arrayOfInt);
    return new c0(arrayOfInt);
  }
  
  public e m()
  {
    int[] arrayOfInt = f.e();
    b0.g(this.h, arrayOfInt);
    return new c0(arrayOfInt);
  }
  
  public e n()
  {
    int[] arrayOfInt1 = this.h;
    if ((!f.l(arrayOfInt1)) && (!f.k(arrayOfInt1)))
    {
      int[] arrayOfInt2 = f.e();
      b0.g(arrayOfInt1, arrayOfInt2);
      int[] arrayOfInt3 = b.e(b0.a);
      int[] arrayOfInt4 = f.e();
      boolean bool = x(arrayOfInt1);
      c0 localc0 = null;
      if (!bool) {
        return null;
      }
      while (!y(arrayOfInt2, arrayOfInt3, arrayOfInt4)) {
        b0.b(arrayOfInt3, arrayOfInt3);
      }
      b0.j(arrayOfInt4, arrayOfInt3);
      if (f.g(arrayOfInt1, arrayOfInt3)) {
        localc0 = new c0(arrayOfInt4);
      }
      return localc0;
    }
    return this;
  }
  
  public e o()
  {
    int[] arrayOfInt = f.e();
    b0.j(this.h, arrayOfInt);
    return new c0(arrayOfInt);
  }
  
  public e r(e parame)
  {
    int[] arrayOfInt = f.e();
    b0.m(this.h, ((c0)parame).h, arrayOfInt);
    return new c0(arrayOfInt);
  }
  
  public boolean s()
  {
    int[] arrayOfInt = this.h;
    boolean bool = false;
    if (f.i(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger t()
  {
    return f.u(this.h);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */