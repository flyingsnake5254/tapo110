package e.a.b.a.a0.c;

import e.a.b.a.d.c;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import java.math.BigInteger;

public class a
  extends d.c
{
  public static final BigInteger i = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));
  protected d j = new d(this, null, null);
  
  public a()
  {
    super(i);
    this.b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
    this.c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("E87579C11079F43DD824993C2CEE5ED3")));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFE0000000075A30D1B9038A115"));
    this.e = BigInteger.valueOf(1L);
    this.f = 2;
  }
  
  public boolean C(int paramInt)
  {
    return paramInt == 2;
  }
  
  protected e.a.b.a.d c()
  {
    return new a();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final int[] arrayOfInt = new int[paramInt2 * 4 * 2];
    int k = 0;
    int m = 0;
    while (k < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + k)];
      e.a.b.c.c.c(((c)localh.n()).h, 0, arrayOfInt, m);
      m += 4;
      e.a.b.c.c.c(((c)localh.o()).h, 0, arrayOfInt, m);
      m += 4;
      k++;
    }
    return new a(paramInt2, arrayOfInt);
  }
  
  protected h i(e parame1, e parame2, boolean paramBoolean)
  {
    return new d(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new d(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e n(BigInteger paramBigInteger)
  {
    return new c(paramBigInteger);
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
      int[] arrayOfInt1 = e.a.b.c.c.e();
      int[] arrayOfInt2 = e.a.b.c.c.e();
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        int k = (i ^ paramInt) - 1 >> 31;
        for (int m = 0; m < 4; m++)
        {
          int n = arrayOfInt1[m];
          int[] arrayOfInt3 = arrayOfInt;
          arrayOfInt1[m] = (n ^ arrayOfInt3[(j + m)] & k);
          arrayOfInt2[m] ^= arrayOfInt3[(j + 4 + m)] & k;
        }
        j += 8;
        i++;
      }
      return a.this.i(new c(arrayOfInt1), new c(arrayOfInt2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */