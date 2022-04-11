package e.a.b.a.a0.c;

import e.a.b.a.e;
import e.a.b.a.e.b;
import e.a.b.c.b;
import e.a.b.c.m;
import java.math.BigInteger;
import org.bouncycastle.util.a;

public class s0
  extends e.b
{
  public static final BigInteger g = q0.i;
  protected int[] h;
  
  public s0()
  {
    this.h = m.j(17);
  }
  
  public s0(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(g) < 0))
    {
      this.h = r0.c(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
  }
  
  protected s0(int[] paramArrayOfInt)
  {
    this.h = paramArrayOfInt;
  }
  
  public e a(e parame)
  {
    int[] arrayOfInt = m.j(17);
    r0.a(this.h, ((s0)parame).h, arrayOfInt);
    return new s0(arrayOfInt);
  }
  
  public e b()
  {
    int[] arrayOfInt = m.j(17);
    r0.b(this.h, arrayOfInt);
    return new s0(arrayOfInt);
  }
  
  public e d(e parame)
  {
    int[] arrayOfInt = m.j(17);
    b.d(r0.a, ((s0)parame).h, arrayOfInt);
    r0.f(arrayOfInt, this.h, arrayOfInt);
    return new s0(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof s0)) {
      return false;
    }
    paramObject = (s0)paramObject;
    return m.n(17, this.h, ((s0)paramObject).h);
  }
  
  public int f()
  {
    return g.bitLength();
  }
  
  public e g()
  {
    int[] arrayOfInt = m.j(17);
    b.d(r0.a, this.h, arrayOfInt);
    return new s0(arrayOfInt);
  }
  
  public boolean h()
  {
    return m.v(17, this.h);
  }
  
  public int hashCode()
  {
    return g.hashCode() ^ a.z(this.h, 0, 17);
  }
  
  public boolean i()
  {
    return m.w(17, this.h);
  }
  
  public e j(e parame)
  {
    int[] arrayOfInt = m.j(17);
    r0.f(this.h, ((s0)parame).h, arrayOfInt);
    return new s0(arrayOfInt);
  }
  
  public e m()
  {
    int[] arrayOfInt = m.j(17);
    r0.g(this.h, arrayOfInt);
    return new s0(arrayOfInt);
  }
  
  public e n()
  {
    Object localObject = this.h;
    if ((!m.w(17, (int[])localObject)) && (!m.v(17, (int[])localObject)))
    {
      int[] arrayOfInt1 = m.j(17);
      int[] arrayOfInt2 = m.j(17);
      r0.k((int[])localObject, 519, arrayOfInt1);
      r0.j(arrayOfInt1, arrayOfInt2);
      if (m.n(17, (int[])localObject, arrayOfInt2)) {
        localObject = new s0(arrayOfInt1);
      } else {
        localObject = null;
      }
      return (e)localObject;
    }
    return this;
  }
  
  public e o()
  {
    int[] arrayOfInt = m.j(17);
    r0.j(this.h, arrayOfInt);
    return new s0(arrayOfInt);
  }
  
  public e r(e parame)
  {
    int[] arrayOfInt = m.j(17);
    r0.l(this.h, ((s0)parame).h, arrayOfInt);
    return new s0(arrayOfInt);
  }
  
  public boolean s()
  {
    int[] arrayOfInt = this.h;
    boolean bool = false;
    if (m.p(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger t()
  {
    return m.P(17, this.h);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\s0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */