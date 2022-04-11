package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.b;
import e.a.b.c.b;
import e.a.b.c.f;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class y
  extends e.b
{
  public static final BigInteger g = w.i;
  private static final int[] h = { 868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644 };
  protected int[] i;
  
  public y()
  {
    this.i = f.e();
  }
  
  public y(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(g) < 0))
    {
      this.i = x.c(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
  }
  
  protected y(int[] paramArrayOfInt)
  {
    this.i = paramArrayOfInt;
  }
  
  public e a(e parame)
  {
    int[] arrayOfInt = f.e();
    x.a(this.i, ((y)parame).i, arrayOfInt);
    return new y(arrayOfInt);
  }
  
  public e b()
  {
    int[] arrayOfInt = f.e();
    x.b(this.i, arrayOfInt);
    return new y(arrayOfInt);
  }
  
  public e d(e parame)
  {
    int[] arrayOfInt = f.e();
    b.d(x.a, ((y)parame).i, arrayOfInt);
    x.d(arrayOfInt, this.i, arrayOfInt);
    return new y(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof y)) {
      return false;
    }
    paramObject = (y)paramObject;
    return f.g(this.i, ((y)paramObject).i);
  }
  
  public int f()
  {
    return g.bitLength();
  }
  
  public e g()
  {
    int[] arrayOfInt = f.e();
    b.d(x.a, this.i, arrayOfInt);
    return new y(arrayOfInt);
  }
  
  public boolean h()
  {
    return f.k(this.i);
  }
  
  public int hashCode()
  {
    return g.hashCode() ^ a.z(this.i, 0, 7);
  }
  
  public boolean i()
  {
    return f.l(this.i);
  }
  
  public e j(e parame)
  {
    int[] arrayOfInt = f.e();
    x.d(this.i, ((y)parame).i, arrayOfInt);
    return new y(arrayOfInt);
  }
  
  public e m()
  {
    int[] arrayOfInt = f.e();
    x.f(this.i, arrayOfInt);
    return new y(arrayOfInt);
  }
  
  public e n()
  {
    int[] arrayOfInt1 = this.i;
    if ((!f.l(arrayOfInt1)) && (!f.k(arrayOfInt1)))
    {
      int[] arrayOfInt2 = f.e();
      x.i(arrayOfInt1, arrayOfInt2);
      x.d(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      x.i(arrayOfInt2, arrayOfInt2);
      x.d(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      int[] arrayOfInt3 = f.e();
      x.i(arrayOfInt2, arrayOfInt3);
      x.d(arrayOfInt3, arrayOfInt1, arrayOfInt3);
      int[] arrayOfInt4 = f.e();
      x.j(arrayOfInt3, 4, arrayOfInt4);
      x.d(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      int[] arrayOfInt5 = f.e();
      x.j(arrayOfInt4, 3, arrayOfInt5);
      x.d(arrayOfInt5, arrayOfInt2, arrayOfInt5);
      x.j(arrayOfInt5, 8, arrayOfInt5);
      x.d(arrayOfInt5, arrayOfInt4, arrayOfInt5);
      x.j(arrayOfInt5, 4, arrayOfInt4);
      x.d(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      x.j(arrayOfInt4, 19, arrayOfInt3);
      x.d(arrayOfInt3, arrayOfInt5, arrayOfInt3);
      int[] arrayOfInt6 = f.e();
      x.j(arrayOfInt3, 42, arrayOfInt6);
      x.d(arrayOfInt6, arrayOfInt3, arrayOfInt6);
      x.j(arrayOfInt6, 23, arrayOfInt3);
      x.d(arrayOfInt3, arrayOfInt4, arrayOfInt3);
      x.j(arrayOfInt3, 84, arrayOfInt4);
      x.d(arrayOfInt4, arrayOfInt6, arrayOfInt4);
      x.j(arrayOfInt4, 20, arrayOfInt4);
      x.d(arrayOfInt4, arrayOfInt5, arrayOfInt4);
      x.j(arrayOfInt4, 3, arrayOfInt4);
      x.d(arrayOfInt4, arrayOfInt1, arrayOfInt4);
      x.j(arrayOfInt4, 2, arrayOfInt4);
      x.d(arrayOfInt4, arrayOfInt1, arrayOfInt4);
      x.j(arrayOfInt4, 4, arrayOfInt4);
      x.d(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      x.i(arrayOfInt4, arrayOfInt4);
      x.i(arrayOfInt4, arrayOfInt6);
      if (f.g(arrayOfInt1, arrayOfInt6)) {
        return new y(arrayOfInt4);
      }
      x.d(arrayOfInt4, h, arrayOfInt4);
      x.i(arrayOfInt4, arrayOfInt6);
      if (f.g(arrayOfInt1, arrayOfInt6)) {
        return new y(arrayOfInt4);
      }
      return null;
    }
    return this;
  }
  
  public e o()
  {
    int[] arrayOfInt = f.e();
    x.i(this.i, arrayOfInt);
    return new y(arrayOfInt);
  }
  
  public e r(e parame)
  {
    int[] arrayOfInt = f.e();
    x.k(this.i, ((y)parame).i, arrayOfInt);
    return new y(arrayOfInt);
  }
  
  public boolean s()
  {
    int[] arrayOfInt = this.i;
    boolean bool = false;
    if (f.i(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger t()
  {
    return f.u(this.i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */