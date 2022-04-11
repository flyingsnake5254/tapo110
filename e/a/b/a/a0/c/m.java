package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.b;
import e.a.b.c.b;
import e.a.b.c.d;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class m
  extends e.b
{
  public static final BigInteger g = k.i;
  protected int[] h;
  
  public m()
  {
    this.h = d.d();
  }
  
  public m(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(g) < 0))
    {
      this.h = l.c(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
  }
  
  protected m(int[] paramArrayOfInt)
  {
    this.h = paramArrayOfInt;
  }
  
  public e a(e parame)
  {
    int[] arrayOfInt = d.d();
    l.a(this.h, ((m)parame).h, arrayOfInt);
    return new m(arrayOfInt);
  }
  
  public e b()
  {
    int[] arrayOfInt = d.d();
    l.b(this.h, arrayOfInt);
    return new m(arrayOfInt);
  }
  
  public e d(e parame)
  {
    int[] arrayOfInt = d.d();
    b.d(l.a, ((m)parame).h, arrayOfInt);
    l.d(arrayOfInt, this.h, arrayOfInt);
    return new m(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof m)) {
      return false;
    }
    paramObject = (m)paramObject;
    return d.f(this.h, ((m)paramObject).h);
  }
  
  public int f()
  {
    return g.bitLength();
  }
  
  public e g()
  {
    int[] arrayOfInt = d.d();
    b.d(l.a, this.h, arrayOfInt);
    return new m(arrayOfInt);
  }
  
  public boolean h()
  {
    return d.j(this.h);
  }
  
  public int hashCode()
  {
    return g.hashCode() ^ a.z(this.h, 0, 5);
  }
  
  public boolean i()
  {
    return d.k(this.h);
  }
  
  public e j(e parame)
  {
    int[] arrayOfInt = d.d();
    l.d(this.h, ((m)parame).h, arrayOfInt);
    return new m(arrayOfInt);
  }
  
  public e m()
  {
    int[] arrayOfInt = d.d();
    l.f(this.h, arrayOfInt);
    return new m(arrayOfInt);
  }
  
  public e n()
  {
    int[] arrayOfInt1 = this.h;
    if ((!d.k(arrayOfInt1)) && (!d.j(arrayOfInt1)))
    {
      int[] arrayOfInt2 = d.d();
      l.i(arrayOfInt1, arrayOfInt2);
      l.d(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      int[] arrayOfInt3 = d.d();
      l.i(arrayOfInt2, arrayOfInt3);
      l.d(arrayOfInt3, arrayOfInt1, arrayOfInt3);
      int[] arrayOfInt4 = d.d();
      l.i(arrayOfInt3, arrayOfInt4);
      l.d(arrayOfInt4, arrayOfInt1, arrayOfInt4);
      Object localObject = d.d();
      l.j(arrayOfInt4, 3, (int[])localObject);
      l.d((int[])localObject, arrayOfInt3, (int[])localObject);
      l.j((int[])localObject, 7, arrayOfInt4);
      l.d(arrayOfInt4, (int[])localObject, arrayOfInt4);
      l.j(arrayOfInt4, 3, (int[])localObject);
      l.d((int[])localObject, arrayOfInt3, (int[])localObject);
      int[] arrayOfInt5 = d.d();
      l.j((int[])localObject, 14, arrayOfInt5);
      l.d(arrayOfInt5, arrayOfInt4, arrayOfInt5);
      l.j(arrayOfInt5, 31, arrayOfInt4);
      l.d(arrayOfInt4, arrayOfInt5, arrayOfInt4);
      l.j(arrayOfInt4, 62, arrayOfInt5);
      l.d(arrayOfInt5, arrayOfInt4, arrayOfInt5);
      l.j(arrayOfInt5, 3, arrayOfInt4);
      l.d(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      l.j(arrayOfInt4, 18, arrayOfInt4);
      l.d(arrayOfInt4, (int[])localObject, arrayOfInt4);
      l.j(arrayOfInt4, 2, arrayOfInt4);
      l.d(arrayOfInt4, arrayOfInt1, arrayOfInt4);
      l.j(arrayOfInt4, 3, arrayOfInt4);
      l.d(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      l.j(arrayOfInt4, 6, arrayOfInt4);
      l.d(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      l.j(arrayOfInt4, 2, arrayOfInt4);
      l.d(arrayOfInt4, arrayOfInt1, arrayOfInt4);
      l.i(arrayOfInt4, arrayOfInt2);
      if (d.f(arrayOfInt1, arrayOfInt2)) {
        localObject = new m(arrayOfInt4);
      } else {
        localObject = null;
      }
      return (e)localObject;
    }
    return this;
  }
  
  public e o()
  {
    int[] arrayOfInt = d.d();
    l.i(this.h, arrayOfInt);
    return new m(arrayOfInt);
  }
  
  public e r(e parame)
  {
    int[] arrayOfInt = d.d();
    l.k(this.h, ((m)parame).h, arrayOfInt);
    return new m(arrayOfInt);
  }
  
  public boolean s()
  {
    int[] arrayOfInt = this.h;
    boolean bool = false;
    if (d.h(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger t()
  {
    return d.u(this.h);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */