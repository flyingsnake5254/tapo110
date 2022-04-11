package e.a.b.a.a0.c;

import e.a.b.a.e.b;
import e.a.b.c.b;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class q
  extends e.b
{
  public static final BigInteger g = o.i;
  protected int[] h;
  
  public q()
  {
    this.h = e.a.b.c.e.g();
  }
  
  public q(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(g) < 0))
    {
      this.h = p.c(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
  }
  
  protected q(int[] paramArrayOfInt)
  {
    this.h = paramArrayOfInt;
  }
  
  public e.a.b.a.e a(e.a.b.a.e parame)
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    p.a(this.h, ((q)parame).h, arrayOfInt);
    return new q(arrayOfInt);
  }
  
  public e.a.b.a.e b()
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    p.b(this.h, arrayOfInt);
    return new q(arrayOfInt);
  }
  
  public e.a.b.a.e d(e.a.b.a.e parame)
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    b.d(p.a, ((q)parame).h, arrayOfInt);
    p.d(arrayOfInt, this.h, arrayOfInt);
    return new q(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof q)) {
      return false;
    }
    paramObject = (q)paramObject;
    return e.a.b.c.e.l(this.h, ((q)paramObject).h);
  }
  
  public int f()
  {
    return g.bitLength();
  }
  
  public e.a.b.a.e g()
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    b.d(p.a, this.h, arrayOfInt);
    return new q(arrayOfInt);
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
    p.d(this.h, ((q)parame).h, arrayOfInt);
    return new q(arrayOfInt);
  }
  
  public e.a.b.a.e m()
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    p.f(this.h, arrayOfInt);
    return new q(arrayOfInt);
  }
  
  public e.a.b.a.e n()
  {
    int[] arrayOfInt1 = this.h;
    if ((!e.a.b.c.e.u(arrayOfInt1)) && (!e.a.b.c.e.s(arrayOfInt1)))
    {
      int[] arrayOfInt2 = e.a.b.c.e.g();
      p.i(arrayOfInt1, arrayOfInt2);
      p.d(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      Object localObject = e.a.b.c.e.g();
      p.i(arrayOfInt2, (int[])localObject);
      p.d((int[])localObject, arrayOfInt1, (int[])localObject);
      int[] arrayOfInt3 = e.a.b.c.e.g();
      p.j((int[])localObject, 3, arrayOfInt3);
      p.d(arrayOfInt3, (int[])localObject, arrayOfInt3);
      p.j(arrayOfInt3, 2, arrayOfInt3);
      p.d(arrayOfInt3, arrayOfInt2, arrayOfInt3);
      p.j(arrayOfInt3, 8, arrayOfInt2);
      p.d(arrayOfInt2, arrayOfInt3, arrayOfInt2);
      p.j(arrayOfInt2, 3, arrayOfInt3);
      p.d(arrayOfInt3, (int[])localObject, arrayOfInt3);
      int[] arrayOfInt4 = e.a.b.c.e.g();
      p.j(arrayOfInt3, 16, arrayOfInt4);
      p.d(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      p.j(arrayOfInt4, 35, arrayOfInt2);
      p.d(arrayOfInt2, arrayOfInt4, arrayOfInt2);
      p.j(arrayOfInt2, 70, arrayOfInt4);
      p.d(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      p.j(arrayOfInt4, 19, arrayOfInt2);
      p.d(arrayOfInt2, arrayOfInt3, arrayOfInt2);
      p.j(arrayOfInt2, 20, arrayOfInt2);
      p.d(arrayOfInt2, arrayOfInt3, arrayOfInt2);
      p.j(arrayOfInt2, 4, arrayOfInt2);
      p.d(arrayOfInt2, (int[])localObject, arrayOfInt2);
      p.j(arrayOfInt2, 6, arrayOfInt2);
      p.d(arrayOfInt2, (int[])localObject, arrayOfInt2);
      p.i(arrayOfInt2, arrayOfInt2);
      p.i(arrayOfInt2, (int[])localObject);
      if (e.a.b.c.e.l(arrayOfInt1, (int[])localObject)) {
        localObject = new q(arrayOfInt2);
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
    p.i(this.h, arrayOfInt);
    return new q(arrayOfInt);
  }
  
  public e.a.b.a.e r(e.a.b.a.e parame)
  {
    int[] arrayOfInt = e.a.b.c.e.g();
    p.k(this.h, ((q)parame).h, arrayOfInt);
    return new q(arrayOfInt);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */