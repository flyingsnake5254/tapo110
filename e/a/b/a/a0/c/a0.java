package e.a.b.a.a0.c;

import e.a.b.a.d.c;
import e.a.b.a.e;
import e.a.b.a.h;
import java.math.BigInteger;

public class a0
  extends d.c
{
  public static final BigInteger i = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));
  protected d0 j = new d0(this, null, null);
  
  public a0()
  {
    super(i);
    this.b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
    this.c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
    this.e = BigInteger.valueOf(1L);
    this.f = 2;
  }
  
  public boolean C(int paramInt)
  {
    return paramInt == 2;
  }
  
  protected e.a.b.a.d c()
  {
    return new a0();
  }
  
  public e.a.b.a.f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final int[] arrayOfInt = new int[paramInt2 * 7 * 2];
    int k = 0;
    int m = 0;
    while (k < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + k)];
      e.a.b.c.f.c(((c0)localh.n()).h, 0, arrayOfInt, m);
      m += 7;
      e.a.b.c.f.c(((c0)localh.o()).h, 0, arrayOfInt, m);
      m += 7;
      k++;
    }
    return new a(paramInt2, arrayOfInt);
  }
  
  protected h i(e parame1, e parame2, boolean paramBoolean)
  {
    return new d0(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new d0(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e n(BigInteger paramBigInteger)
  {
    return new c0(paramBigInteger);
  }
  
  public int t()
  {
    return i.bitLength();
  }
  
  public h u()
  {
    return this.j;
  }
  
  class a
    implements e.a.b.a.f
  {
    a(int paramInt, int[] paramArrayOfInt) {}
    
    public int a()
    {
      return paramInt2;
    }
    
    public h b(int paramInt)
    {
      int[] arrayOfInt1 = e.a.b.c.f.e();
      int[] arrayOfInt2 = e.a.b.c.f.e();
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        int k = (i ^ paramInt) - 1 >> 31;
        for (int m = 0; m < 7; m++)
        {
          int n = arrayOfInt1[m];
          int[] arrayOfInt3 = arrayOfInt;
          arrayOfInt1[m] = (n ^ arrayOfInt3[(j + m)] & k);
          arrayOfInt2[m] ^= arrayOfInt3[(j + 7 + m)] & k;
        }
        j += 14;
        i++;
      }
      return a0.this.i(new c0(arrayOfInt1), new c0(arrayOfInt2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */