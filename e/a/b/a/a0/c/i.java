package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.b;
import e.a.b.c.b;
import e.a.b.c.d;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class i
  extends e.b
{
  public static final BigInteger g = g.i;
  protected int[] h;
  
  public i()
  {
    this.h = d.d();
  }
  
  public i(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(g) < 0))
    {
      this.h = h.c(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP160R1FieldElement");
  }
  
  protected i(int[] paramArrayOfInt)
  {
    this.h = paramArrayOfInt;
  }
  
  public e a(e parame)
  {
    int[] arrayOfInt = d.d();
    h.a(this.h, ((i)parame).h, arrayOfInt);
    return new i(arrayOfInt);
  }
  
  public e b()
  {
    int[] arrayOfInt = d.d();
    h.b(this.h, arrayOfInt);
    return new i(arrayOfInt);
  }
  
  public e d(e parame)
  {
    int[] arrayOfInt = d.d();
    b.d(h.a, ((i)parame).h, arrayOfInt);
    h.d(arrayOfInt, this.h, arrayOfInt);
    return new i(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof i)) {
      return false;
    }
    paramObject = (i)paramObject;
    return d.f(this.h, ((i)paramObject).h);
  }
  
  public int f()
  {
    return g.bitLength();
  }
  
  public e g()
  {
    int[] arrayOfInt = d.d();
    b.d(h.a, this.h, arrayOfInt);
    return new i(arrayOfInt);
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
    h.d(this.h, ((i)parame).h, arrayOfInt);
    return new i(arrayOfInt);
  }
  
  public e m()
  {
    int[] arrayOfInt = d.d();
    h.f(this.h, arrayOfInt);
    return new i(arrayOfInt);
  }
  
  public e n()
  {
    Object localObject = this.h;
    if ((!d.k((int[])localObject)) && (!d.j((int[])localObject)))
    {
      int[] arrayOfInt1 = d.d();
      h.i((int[])localObject, arrayOfInt1);
      h.d(arrayOfInt1, (int[])localObject, arrayOfInt1);
      int[] arrayOfInt2 = d.d();
      h.j(arrayOfInt1, 2, arrayOfInt2);
      h.d(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      h.j(arrayOfInt2, 4, arrayOfInt1);
      h.d(arrayOfInt1, arrayOfInt2, arrayOfInt1);
      h.j(arrayOfInt1, 8, arrayOfInt2);
      h.d(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      h.j(arrayOfInt2, 16, arrayOfInt1);
      h.d(arrayOfInt1, arrayOfInt2, arrayOfInt1);
      h.j(arrayOfInt1, 32, arrayOfInt2);
      h.d(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      h.j(arrayOfInt2, 64, arrayOfInt1);
      h.d(arrayOfInt1, arrayOfInt2, arrayOfInt1);
      h.i(arrayOfInt1, arrayOfInt2);
      h.d(arrayOfInt2, (int[])localObject, arrayOfInt2);
      h.j(arrayOfInt2, 29, arrayOfInt2);
      h.i(arrayOfInt2, arrayOfInt1);
      if (d.f((int[])localObject, arrayOfInt1)) {
        localObject = new i(arrayOfInt2);
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
    h.i(this.h, arrayOfInt);
    return new i(arrayOfInt);
  }
  
  public e r(e parame)
  {
    int[] arrayOfInt = d.d();
    h.k(this.h, ((i)parame).h, arrayOfInt);
    return new i(arrayOfInt);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */