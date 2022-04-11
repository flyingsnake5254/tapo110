package e.a.b.a.a0.c;

import e.a.b.a.c;
import e.a.b.a.d.c;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.c.g;
import java.math.BigInteger;

public class e0
  extends d.c
{
  public static final BigInteger i = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));
  protected h0 j = new h0(this, null, null);
  
  public e0()
  {
    super(i);
    this.b = n(c.a);
    this.c = n(BigInteger.valueOf(7L));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
    this.e = BigInteger.valueOf(1L);
    this.f = 2;
  }
  
  public boolean C(int paramInt)
  {
    return paramInt == 2;
  }
  
  protected e.a.b.a.d c()
  {
    return new e0();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final int[] arrayOfInt = new int[paramInt2 * 8 * 2];
    int k = 0;
    int m = 0;
    while (k < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + k)];
      g.f(((g0)localh.n()).h, 0, arrayOfInt, m);
      m += 8;
      g.f(((g0)localh.o()).h, 0, arrayOfInt, m);
      m += 8;
      k++;
    }
    return new a(paramInt2, arrayOfInt);
  }
  
  protected h i(e parame1, e parame2, boolean paramBoolean)
  {
    return new h0(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new h0(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e n(BigInteger paramBigInteger)
  {
    return new g0(paramBigInteger);
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
    implements f
  {
    a(int paramInt, int[] paramArrayOfInt) {}
    
    public int a()
    {
      return paramInt2;
    }
    
    public h b(int paramInt)
    {
      int[] arrayOfInt1 = g.h();
      int[] arrayOfInt2 = g.h();
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        int k = (i ^ paramInt) - 1 >> 31;
        for (int m = 0; m < 8; m++)
        {
          int n = arrayOfInt1[m];
          int[] arrayOfInt3 = arrayOfInt;
          arrayOfInt1[m] = (n ^ arrayOfInt3[(j + m)] & k);
          arrayOfInt2[m] ^= arrayOfInt3[(j + 8 + m)] & k;
        }
        j += 16;
        i++;
      }
      return e0.this.i(new g0(arrayOfInt1), new g0(arrayOfInt2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */