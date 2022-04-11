package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.b;
import java.math.BigInteger;

public class c
  extends e.b
{
  public static final BigInteger g = a.i;
  protected int[] h;
  
  public c()
  {
    this.h = e.a.b.c.c.e();
  }
  
  public c(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(g) < 0))
    {
      this.h = b.d(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
  }
  
  protected c(int[] paramArrayOfInt)
  {
    this.h = paramArrayOfInt;
  }
  
  public e a(e parame)
  {
    int[] arrayOfInt = e.a.b.c.c.e();
    b.a(this.h, ((c)parame).h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e b()
  {
    int[] arrayOfInt = e.a.b.c.c.e();
    b.b(this.h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e d(e parame)
  {
    int[] arrayOfInt = e.a.b.c.c.e();
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
    return e.a.b.c.c.i(this.h, ((c)paramObject).h);
  }
  
  public int f()
  {
    return g.bitLength();
  }
  
  public e g()
  {
    int[] arrayOfInt = e.a.b.c.c.e();
    e.a.b.c.b.d(b.a, this.h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public boolean h()
  {
    return e.a.b.c.c.o(this.h);
  }
  
  public int hashCode()
  {
    return g.hashCode() ^ org.bouncycastle.util.a.z(this.h, 0, 4);
  }
  
  public boolean i()
  {
    return e.a.b.c.c.q(this.h);
  }
  
  public e j(e parame)
  {
    int[] arrayOfInt = e.a.b.c.c.e();
    b.e(this.h, ((c)parame).h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e m()
  {
    int[] arrayOfInt = e.a.b.c.c.e();
    b.g(this.h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e n()
  {
    int[] arrayOfInt1 = this.h;
    if ((!e.a.b.c.c.q(arrayOfInt1)) && (!e.a.b.c.c.o(arrayOfInt1)))
    {
      int[] arrayOfInt2 = e.a.b.c.c.e();
      b.j(arrayOfInt1, arrayOfInt2);
      b.e(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      int[] arrayOfInt3 = e.a.b.c.c.e();
      b.k(arrayOfInt2, 2, arrayOfInt3);
      b.e(arrayOfInt3, arrayOfInt2, arrayOfInt3);
      Object localObject = e.a.b.c.c.e();
      b.k(arrayOfInt3, 4, (int[])localObject);
      b.e((int[])localObject, arrayOfInt3, (int[])localObject);
      b.k((int[])localObject, 2, arrayOfInt3);
      b.e(arrayOfInt3, arrayOfInt2, arrayOfInt3);
      b.k(arrayOfInt3, 10, arrayOfInt2);
      b.e(arrayOfInt2, arrayOfInt3, arrayOfInt2);
      b.k(arrayOfInt2, 10, (int[])localObject);
      b.e((int[])localObject, arrayOfInt3, (int[])localObject);
      b.j((int[])localObject, arrayOfInt3);
      b.e(arrayOfInt3, arrayOfInt1, arrayOfInt3);
      b.k(arrayOfInt3, 95, arrayOfInt3);
      b.j(arrayOfInt3, (int[])localObject);
      if (e.a.b.c.c.i(arrayOfInt1, (int[])localObject)) {
        localObject = new c(arrayOfInt3);
      } else {
        localObject = null;
      }
      return (e)localObject;
    }
    return this;
  }
  
  public e o()
  {
    int[] arrayOfInt = e.a.b.c.c.e();
    b.j(this.h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public e r(e parame)
  {
    int[] arrayOfInt = e.a.b.c.c.e();
    b.m(this.h, ((c)parame).h, arrayOfInt);
    return new c(arrayOfInt);
  }
  
  public boolean s()
  {
    int[] arrayOfInt = this.h;
    boolean bool = false;
    if (e.a.b.c.c.m(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger t()
  {
    return e.a.b.c.c.x(this.h);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */