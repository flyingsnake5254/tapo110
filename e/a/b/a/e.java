package e.a.b.a;

import e.a.b.c.m;
import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.util.a;

public abstract class e
  implements c
{
  public abstract e a(e parame);
  
  public abstract e b();
  
  public int c()
  {
    return t().bitLength();
  }
  
  public abstract e d(e parame);
  
  public byte[] e()
  {
    return org.bouncycastle.util.b.a((f() + 7) / 8, t());
  }
  
  public abstract int f();
  
  public abstract e g();
  
  public boolean h()
  {
    int i = c();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean i()
  {
    boolean bool;
    if (t().signum() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract e j(e parame);
  
  public e k(e parame1, e parame2, e parame3)
  {
    return j(parame1).r(parame2.j(parame3));
  }
  
  public e l(e parame1, e parame2, e parame3)
  {
    return j(parame1).a(parame2.j(parame3));
  }
  
  public abstract e m();
  
  public abstract e n();
  
  public abstract e o();
  
  public e p(e parame1, e parame2)
  {
    return o().a(parame1.j(parame2));
  }
  
  public e q(int paramInt)
  {
    int i = 0;
    e locale = this;
    while (i < paramInt)
    {
      locale = locale.o();
      i++;
    }
    return locale;
  }
  
  public abstract e r(e parame);
  
  public boolean s()
  {
    return t().testBit(0);
  }
  
  public abstract BigInteger t();
  
  public String toString()
  {
    return t().toString(16);
  }
  
  public static abstract class a
    extends e
  {
    public int u()
    {
      int i = f();
      Object localObject1 = this;
      Object localObject2 = localObject1;
      for (int j = 1; j < i; j++)
      {
        localObject2 = ((e)localObject2).o();
        localObject1 = ((e)localObject1).a((e)localObject2);
      }
      if (((e)localObject1).i()) {
        return 0;
      }
      if (((e)localObject1).h()) {
        return 1;
      }
      throw new IllegalStateException("Internal error in trace calculation");
    }
  }
  
  public static abstract class b
    extends e
  {}
  
  public static class c
    extends e.a
  {
    private int g;
    private int h;
    private int[] i;
    n j;
    
    public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BigInteger paramBigInteger)
    {
      if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= paramInt1))
      {
        if ((paramInt3 == 0) && (paramInt4 == 0))
        {
          this.g = 2;
          this.i = new int[] { paramInt2 };
        }
        else
        {
          if (paramInt3 >= paramInt4) {
            break label118;
          }
          if (paramInt3 <= 0) {
            break label108;
          }
          this.g = 3;
          this.i = new int[] { paramInt2, paramInt3, paramInt4 };
        }
        this.h = paramInt1;
        this.j = new n(paramBigInteger);
        return;
        label108:
        throw new IllegalArgumentException("k2 must be larger than 0");
        label118:
        throw new IllegalArgumentException("k2 must be smaller than k3");
      }
      throw new IllegalArgumentException("x value invalid in F2m field element");
    }
    
    c(int paramInt, int[] paramArrayOfInt, n paramn)
    {
      this.h = paramInt;
      if (paramArrayOfInt.length == 1) {
        paramInt = 2;
      } else {
        paramInt = 3;
      }
      this.g = paramInt;
      this.i = paramArrayOfInt;
      this.j = paramn;
    }
    
    public static void v(e parame1, e parame2)
    {
      if (((parame1 instanceof c)) && ((parame2 instanceof c)))
      {
        parame1 = (c)parame1;
        parame2 = (c)parame2;
        if (parame1.g == parame2.g)
        {
          if ((parame1.h == parame2.h) && (a.e(parame1.i, parame2.i))) {
            return;
          }
          throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
        }
        throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
      }
      throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
    }
    
    public e a(e parame)
    {
      n localn = (n)this.j.clone();
      localn.f(((c)parame).j, 0);
      return new c(this.h, this.i, localn);
    }
    
    public e b()
    {
      return new c(this.h, this.i, this.j.d());
    }
    
    public int c()
    {
      return this.j.l();
    }
    
    public e d(e parame)
    {
      return j(parame.g());
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
      if ((this.h != ((c)paramObject).h) || (this.g != ((c)paramObject).g) || (!a.e(this.i, ((c)paramObject).i)) || (!this.j.equals(((c)paramObject).j))) {
        bool = false;
      }
      return bool;
    }
    
    public int f()
    {
      return this.h;
    }
    
    public e g()
    {
      int k = this.h;
      int[] arrayOfInt = this.i;
      return new c(k, arrayOfInt, this.j.v(k, arrayOfInt));
    }
    
    public boolean h()
    {
      return this.j.t();
    }
    
    public int hashCode()
    {
      return this.j.hashCode() ^ this.h ^ a.y(this.i);
    }
    
    public boolean i()
    {
      return this.j.u();
    }
    
    public e j(e parame)
    {
      int k = this.h;
      int[] arrayOfInt = this.i;
      return new c(k, arrayOfInt, this.j.w(((c)parame).j, k, arrayOfInt));
    }
    
    public e k(e parame1, e parame2, e parame3)
    {
      return l(parame1, parame2, parame3);
    }
    
    public e l(e parame1, e parame2, e parame3)
    {
      n localn1 = this.j;
      n localn2 = ((c)parame1).j;
      parame1 = ((c)parame2).j;
      parame3 = ((c)parame3).j;
      parame2 = localn1.z(localn2, this.h, this.i);
      parame3 = parame1.z(parame3, this.h, this.i);
      if (parame2 != localn1)
      {
        parame1 = parame2;
        if (parame2 != localn2) {}
      }
      else
      {
        parame1 = (n)parame2.clone();
      }
      parame1.f(parame3, 0);
      parame1.B(this.h, this.i);
      return new c(this.h, this.i, parame1);
    }
    
    public e m()
    {
      return this;
    }
    
    public e n()
    {
      Object localObject;
      if ((!this.j.u()) && (!this.j.t())) {
        localObject = q(this.h - 1);
      } else {
        localObject = this;
      }
      return (e)localObject;
    }
    
    public e o()
    {
      int k = this.h;
      int[] arrayOfInt = this.i;
      return new c(k, arrayOfInt, this.j.x(k, arrayOfInt));
    }
    
    public e p(e parame1, e parame2)
    {
      n localn1 = this.j;
      parame1 = ((c)parame1).j;
      n localn2 = ((c)parame2).j;
      parame2 = localn1.L(this.h, this.i);
      localn2 = parame1.z(localn2, this.h, this.i);
      parame1 = parame2;
      if (parame2 == localn1) {
        parame1 = (n)parame2.clone();
      }
      parame1.f(localn2, 0);
      parame1.B(this.h, this.i);
      return new c(this.h, this.i, parame1);
    }
    
    public e q(int paramInt)
    {
      Object localObject;
      if (paramInt < 1)
      {
        localObject = this;
      }
      else
      {
        int k = this.h;
        localObject = this.i;
        localObject = new c(k, (int[])localObject, this.j.y(paramInt, k, (int[])localObject));
      }
      return (e)localObject;
    }
    
    public e r(e parame)
    {
      return a(parame);
    }
    
    public boolean s()
    {
      return this.j.O();
    }
    
    public BigInteger t()
    {
      return this.j.P();
    }
  }
  
  public static class d
    extends e.b
  {
    BigInteger g;
    BigInteger h;
    BigInteger i;
    
    d(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
    {
      if ((paramBigInteger3 != null) && (paramBigInteger3.signum() >= 0) && (paramBigInteger3.compareTo(paramBigInteger1) < 0))
      {
        this.g = paramBigInteger1;
        this.h = paramBigInteger2;
        this.i = paramBigInteger3;
        return;
      }
      throw new IllegalArgumentException("x value invalid in Fp field element");
    }
    
    static BigInteger u(BigInteger paramBigInteger)
    {
      int j = paramBigInteger.bitLength();
      if ((j >= 96) && (paramBigInteger.shiftRight(j - 64).longValue() == -1L)) {
        return c.b.shiftLeft(j).subtract(paramBigInteger);
      }
      return null;
    }
    
    private e v(e parame)
    {
      if (!parame.o().equals(this)) {
        parame = null;
      }
      return parame;
    }
    
    private BigInteger[] w(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
    {
      int j = paramBigInteger3.bitLength();
      int k = paramBigInteger3.getLowestSetBit();
      BigInteger localBigInteger1 = c.b;
      Object localObject1 = c.c;
      j--;
      Object localObject2 = paramBigInteger1;
      BigInteger localBigInteger2 = localBigInteger1;
      Object localObject3 = localBigInteger2;
      Object localObject4 = localBigInteger2;
      while (j >= k + 1)
      {
        localBigInteger1 = B(localBigInteger1, (BigInteger)localObject3);
        if (paramBigInteger3.testBit(j))
        {
          localObject3 = B(localBigInteger1, paramBigInteger2);
          BigInteger localBigInteger3 = B((BigInteger)localObject4, (BigInteger)localObject2);
          BigInteger localBigInteger4 = C(((BigInteger)localObject2).multiply((BigInteger)localObject1).subtract(paramBigInteger1.multiply(localBigInteger1)));
          localBigInteger2 = C(((BigInteger)localObject2).multiply((BigInteger)localObject2).subtract(((BigInteger)localObject3).shiftLeft(1)));
          localObject4 = localObject3;
          localObject1 = localBigInteger3;
          localObject2 = localBigInteger4;
        }
        else
        {
          localObject4 = C(((BigInteger)localObject4).multiply((BigInteger)localObject1).subtract(localBigInteger1));
          localBigInteger2 = C(((BigInteger)localObject2).multiply((BigInteger)localObject1).subtract(paramBigInteger1.multiply(localBigInteger1)));
          localObject2 = C(((BigInteger)localObject1).multiply((BigInteger)localObject1).subtract(localBigInteger1.shiftLeft(1)));
          localObject1 = localObject4;
          localObject4 = localBigInteger1;
        }
        j--;
        localObject3 = localObject4;
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localBigInteger2;
      }
      localBigInteger2 = B(localBigInteger1, (BigInteger)localObject3);
      localBigInteger1 = B(localBigInteger2, paramBigInteger2);
      paramBigInteger3 = C(((BigInteger)localObject4).multiply((BigInteger)localObject1).subtract(localBigInteger2));
      paramBigInteger2 = C(((BigInteger)localObject2).multiply((BigInteger)localObject1).subtract(paramBigInteger1.multiply(localBigInteger2)));
      paramBigInteger1 = B(localBigInteger2, localBigInteger1);
      for (j = 1; j <= k; j++)
      {
        paramBigInteger3 = B(paramBigInteger3, paramBigInteger2);
        paramBigInteger2 = C(paramBigInteger2.multiply(paramBigInteger2).subtract(paramBigInteger1.shiftLeft(1)));
        paramBigInteger1 = B(paramBigInteger1, paramBigInteger1);
      }
      return new BigInteger[] { paramBigInteger3, paramBigInteger2 };
    }
    
    protected BigInteger A(BigInteger paramBigInteger)
    {
      int j = f();
      int k = j + 31 >> 5;
      int[] arrayOfInt1 = m.o(j, this.g);
      paramBigInteger = m.o(j, paramBigInteger);
      int[] arrayOfInt2 = m.j(k);
      e.a.b.c.b.d(arrayOfInt1, paramBigInteger, arrayOfInt2);
      return m.P(k, arrayOfInt2);
    }
    
    protected BigInteger B(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      return C(paramBigInteger1.multiply(paramBigInteger2));
    }
    
    protected BigInteger C(BigInteger paramBigInteger)
    {
      if (this.h != null)
      {
        int j;
        if (paramBigInteger.signum() < 0) {
          j = 1;
        } else {
          j = 0;
        }
        BigInteger localBigInteger1 = paramBigInteger;
        if (j != 0) {
          localBigInteger1 = paramBigInteger.abs();
        }
        int k = this.g.bitLength();
        boolean bool = this.h.equals(c.b);
        BigInteger localBigInteger2;
        for (paramBigInteger = localBigInteger1;; paramBigInteger = paramBigInteger.add(localBigInteger2))
        {
          localBigInteger1 = paramBigInteger;
          if (paramBigInteger.bitLength() <= k + 1) {
            break;
          }
          localBigInteger1 = paramBigInteger.shiftRight(k);
          localBigInteger2 = paramBigInteger.subtract(localBigInteger1.shiftLeft(k));
          paramBigInteger = localBigInteger1;
          if (!bool) {
            paramBigInteger = localBigInteger1.multiply(this.h);
          }
        }
        while (localBigInteger1.compareTo(this.g) >= 0) {
          localBigInteger1 = localBigInteger1.subtract(this.g);
        }
        paramBigInteger = localBigInteger1;
        if (j != 0)
        {
          paramBigInteger = localBigInteger1;
          if (localBigInteger1.signum() != 0) {
            paramBigInteger = this.g.subtract(localBigInteger1);
          }
        }
      }
      else
      {
        paramBigInteger = paramBigInteger.mod(this.g);
      }
      return paramBigInteger;
    }
    
    protected BigInteger D(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      paramBigInteger2 = paramBigInteger1.subtract(paramBigInteger2);
      paramBigInteger1 = paramBigInteger2;
      if (paramBigInteger2.signum() < 0) {
        paramBigInteger1 = paramBigInteger2.add(this.g);
      }
      return paramBigInteger1;
    }
    
    public e a(e parame)
    {
      return new d(this.g, this.h, x(this.i, parame.t()));
    }
    
    public e b()
    {
      BigInteger localBigInteger1 = this.i.add(c.b);
      BigInteger localBigInteger2 = localBigInteger1;
      if (localBigInteger1.compareTo(this.g) == 0) {
        localBigInteger2 = c.a;
      }
      return new d(this.g, this.h, localBigInteger2);
    }
    
    public e d(e parame)
    {
      return new d(this.g, this.h, B(this.i, A(parame.t())));
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
      if ((!this.g.equals(((d)paramObject).g)) || (!this.i.equals(((d)paramObject).i))) {
        bool = false;
      }
      return bool;
    }
    
    public int f()
    {
      return this.g.bitLength();
    }
    
    public e g()
    {
      return new d(this.g, this.h, A(this.i));
    }
    
    public int hashCode()
    {
      return this.g.hashCode() ^ this.i.hashCode();
    }
    
    public e j(e parame)
    {
      return new d(this.g, this.h, B(this.i, parame.t()));
    }
    
    public e k(e parame1, e parame2, e parame3)
    {
      BigInteger localBigInteger1 = this.i;
      BigInteger localBigInteger2 = parame1.t();
      parame1 = parame2.t();
      parame2 = parame3.t();
      parame3 = localBigInteger1.multiply(localBigInteger2);
      parame1 = parame1.multiply(parame2);
      return new d(this.g, this.h, C(parame3.subtract(parame1)));
    }
    
    public e l(e parame1, e parame2, e parame3)
    {
      BigInteger localBigInteger = this.i;
      parame1 = parame1.t();
      parame2 = parame2.t();
      parame3 = parame3.t();
      parame1 = localBigInteger.multiply(parame1);
      parame2 = parame2.multiply(parame3);
      return new d(this.g, this.h, C(parame1.add(parame2)));
    }
    
    public e m()
    {
      Object localObject;
      if (this.i.signum() == 0)
      {
        localObject = this;
      }
      else
      {
        localObject = this.g;
        localObject = new d((BigInteger)localObject, this.h, ((BigInteger)localObject).subtract(this.i));
      }
      return (e)localObject;
    }
    
    public e n()
    {
      if ((!i()) && (!h()))
      {
        if (this.g.testBit(0))
        {
          if (this.g.testBit(1))
          {
            localBigInteger1 = this.g.shiftRight(2).add(c.b);
            localBigInteger2 = this.g;
            return v(new d(localBigInteger2, this.h, this.i.modPow(localBigInteger1, localBigInteger2)));
          }
          if (this.g.testBit(2))
          {
            localBigInteger2 = this.i.modPow(this.g.shiftRight(3), this.g);
            localBigInteger1 = B(localBigInteger2, this.i);
            if (B(localBigInteger1, localBigInteger2).equals(c.b)) {
              return v(new d(this.g, this.h, localBigInteger1));
            }
            localBigInteger1 = B(localBigInteger1, c.c.modPow(this.g.shiftRight(2), this.g));
            return v(new d(this.g, this.h, localBigInteger1));
          }
          BigInteger localBigInteger1 = this.g.shiftRight(1);
          BigInteger localBigInteger2 = this.i.modPow(localBigInteger1, this.g);
          Object localObject1 = c.b;
          if (!localBigInteger2.equals(localObject1)) {
            return null;
          }
          BigInteger localBigInteger3 = this.i;
          localBigInteger2 = y(y(localBigInteger3));
          BigInteger localBigInteger4 = localBigInteger1.add((BigInteger)localObject1);
          BigInteger localBigInteger5 = this.g.subtract((BigInteger)localObject1);
          localObject1 = new Random();
          BigInteger localBigInteger6;
          do
          {
            do
            {
              localBigInteger6 = new BigInteger(this.g.bitLength(), (Random)localObject1);
            } while ((localBigInteger6.compareTo(this.g) >= 0) || (!C(localBigInteger6.multiply(localBigInteger6).subtract(localBigInteger2)).modPow(localBigInteger1, this.g).equals(localBigInteger5)));
            Object localObject2 = w(localBigInteger6, localBigInteger3, localBigInteger4);
            localBigInteger6 = localObject2[0];
            localObject2 = localObject2[1];
            if (B((BigInteger)localObject2, (BigInteger)localObject2).equals(localBigInteger2)) {
              return new d(this.g, this.h, z((BigInteger)localObject2));
            }
          } while ((localBigInteger6.equals(c.b)) || (localBigInteger6.equals(localBigInteger5)));
          return null;
        }
        throw new RuntimeException("not done yet");
      }
      return this;
    }
    
    public e o()
    {
      BigInteger localBigInteger1 = this.g;
      BigInteger localBigInteger2 = this.h;
      BigInteger localBigInteger3 = this.i;
      return new d(localBigInteger1, localBigInteger2, B(localBigInteger3, localBigInteger3));
    }
    
    public e p(e parame1, e parame2)
    {
      BigInteger localBigInteger1 = this.i;
      parame1 = parame1.t();
      BigInteger localBigInteger2 = parame2.t();
      parame2 = localBigInteger1.multiply(localBigInteger1);
      parame1 = parame1.multiply(localBigInteger2);
      return new d(this.g, this.h, C(parame2.add(parame1)));
    }
    
    public e r(e parame)
    {
      return new d(this.g, this.h, D(this.i, parame.t()));
    }
    
    public BigInteger t()
    {
      return this.i;
    }
    
    protected BigInteger x(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      paramBigInteger2 = paramBigInteger1.add(paramBigInteger2);
      paramBigInteger1 = paramBigInteger2;
      if (paramBigInteger2.compareTo(this.g) >= 0) {
        paramBigInteger1 = paramBigInteger2.subtract(this.g);
      }
      return paramBigInteger1;
    }
    
    protected BigInteger y(BigInteger paramBigInteger)
    {
      BigInteger localBigInteger = paramBigInteger.shiftLeft(1);
      paramBigInteger = localBigInteger;
      if (localBigInteger.compareTo(this.g) >= 0) {
        paramBigInteger = localBigInteger.subtract(this.g);
      }
      return paramBigInteger;
    }
    
    protected BigInteger z(BigInteger paramBigInteger)
    {
      BigInteger localBigInteger = paramBigInteger;
      if (paramBigInteger.testBit(0)) {
        localBigInteger = this.g.subtract(paramBigInteger);
      }
      return localBigInteger.shiftRight(1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */