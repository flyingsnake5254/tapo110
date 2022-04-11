package e.a.b.a.a0.c;

import e.a.b.a.e.b;
import e.a.b.c.b;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class u
  extends e.b
{
  public static final BigInteger g = s.i;
  protected int[] h;
  
  public u()
  {
    this.h = e.a.b.c.e.g();
  }
  
  public u(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(g) < 0))
    {
      this.h = t.d(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
  }
  
  protected u(int[] paramArrayOfInt)
  {
    this.h = paramArrayOfInt;
  }
  
  public e.a.b.a.e a(e.a.b.a.e parame)
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    t.a(this.h, ((u)parame).h, arrayOfInt);
    return new u(arrayOfInt);
  }
  
  public e.a.b.a.e b()
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    t.b(this.h, arrayOfInt);
    return new u(arrayOfInt);
  }
  
  public e.a.b.a.e d(e.a.b.a.e parame)
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    b.d(t.a, ((u)parame).h, arrayOfInt);
    t.e(arrayOfInt, this.h, arrayOfInt);
    return new u(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof u)) {
      return false;
    }
    paramObject = (u)paramObject;
    return e.a.b.c.e.l(this.h, ((u)paramObject).h);
  }
  
  public int f()
  {
    return g.bitLength();
  }
  
  public e.a.b.a.e g()
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    b.d(t.a, this.h, arrayOfInt);
    return new u(arrayOfInt);
  }
  
  public boolean h()
  {
    return e.a.b.c.e.s(this.h);
  }
  
  public int hashCode()
  {
    return g.hashCode() ^ a.z(this.h, 0, 6);
  }
  
  public boolean i()
  {
    return e.a.b.c.e.u(this.h);
  }
  
  public e.a.b.a.e j(e.a.b.a.e parame)
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    t.e(this.h, ((u)parame).h, arrayOfInt);
    return new u(arrayOfInt);
  }
  
  public e.a.b.a.e m()
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    t.g(this.h, arrayOfInt);
    return new u(arrayOfInt);
  }
  
  public e.a.b.a.e n()
  {
    int[] arrayOfInt1 = this.h;
    if ((!e.a.b.c.e.u(arrayOfInt1)) && (!e.a.b.c.e.s(arrayOfInt1)))
    {
      Object localObject = e.a.b.c.e.g();
      int[] arrayOfInt2 = e.a.b.c.e.g();
      t.j(arrayOfInt1, (int[])localObject);
      t.e((int[])localObject, arrayOfInt1, (int[])localObject);
      t.k((int[])localObject, 2, arrayOfInt2);
      t.e(arrayOfInt2, (int[])localObject, arrayOfInt2);
      t.k(arrayOfInt2, 4, (int[])localObject);
      t.e((int[])localObject, arrayOfInt2, (int[])localObject);
      t.k((int[])localObject, 8, arrayOfInt2);
      t.e(arrayOfInt2, (int[])localObject, arrayOfInt2);
      t.k(arrayOfInt2, 16, (int[])localObject);
      t.e((int[])localObject, arrayOfInt2, (int[])localObject);
      t.k((int[])localObject, 32, arrayOfInt2);
      t.e(arrayOfInt2, (int[])localObject, arrayOfInt2);
      t.k(arrayOfInt2, 64, (int[])localObject);
      t.e((int[])localObject, arrayOfInt2, (int[])localObject);
      t.k((int[])localObject, 62, (int[])localObject);
      t.j((int[])localObject, arrayOfInt2);
      if (e.a.b.c.e.l(arrayOfInt1, arrayOfInt2)) {
        localObject = new u((int[])localObject);
      } else {
        localObject = null;
      }
      return (e.a.b.a.e)localObject;
    }
    return this;
  }
  
  public e.a.b.a.e o()
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    t.j(this.h, arrayOfInt);
    return new u(arrayOfInt);
  }
  
  public e.a.b.a.e r(e.a.b.a.e parame)
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    t.m(this.h, ((u)parame).h, arrayOfInt);
    return new u(arrayOfInt);
  }
  
  public boolean s()
  {
    int[] arrayOfInt = this.h;
    boolean bool = false;
    if (e.a.b.c.e.p(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger t()
  {
    return e.a.b.c.e.H(this.h);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */