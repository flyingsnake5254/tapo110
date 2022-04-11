package e.a.b.a.a0.c;

import e.a.b.a.c;
import e.a.b.a.d.c;
import e.a.b.a.f;
import e.a.b.a.h;
import java.math.BigInteger;

public class o
  extends d.c
{
  public static final BigInteger i = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));
  protected r j = new r(this, null, null);
  
  public o()
  {
    super(i);
    this.b = n(c.a);
    this.c = n(BigInteger.valueOf(3L));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D"));
    this.e = BigInteger.valueOf(1L);
    this.f = 2;
  }
  
  public boolean C(int paramInt)
  {
    return paramInt == 2;
  }
  
  protected e.a.b.a.d c()
  {
    return new o();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final int[] arrayOfInt = new int[paramInt2 * 6 * 2];
    int k = 0;
    int m = 0;
    while (k < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + k)];
      e.a.b.c.e.e(((q)localh.n()).h, 0, arrayOfInt, m);
      m += 6;
      e.a.b.c.e.e(((q)localh.o()).h, 0, arrayOfInt, m);
      m += 6;
      k++;
    }
    return new a(paramInt2, arrayOfInt);
  }
  
  protected h i(e.a.b.a.e parame1, e.a.b.a.e parame2, boolean paramBoolean)
  {
    return new r(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e.a.b.a.e parame1, e.a.b.a.e parame2, e.a.b.a.e[] paramArrayOfe, boolean paramBoolean)
  {
    return new r(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e.a.b.a.e n(BigInteger paramBigInteger)
  {
    return new q(paramBigInteger);
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
      int[] arrayOfInt1 = e.a.b.c.e.g();
      int[] arrayOfInt2 = e.a.b.c.e.g();
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        int k = (i ^ paramInt) - 1 >> 31;
        for (int m = 0; m < 6; m++)
        {
          int n = arrayOfInt1[m];
          int[] arrayOfInt3 = arrayOfInt;
          arrayOfInt1[m] = (n ^ arrayOfInt3[(j + m)] & k);
          arrayOfInt2[m] ^= arrayOfInt3[(j + 6 + m)] & k;
        }
        j += 12;
        i++;
      }
      return o.this.i(new q(arrayOfInt1), new q(arrayOfInt2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */