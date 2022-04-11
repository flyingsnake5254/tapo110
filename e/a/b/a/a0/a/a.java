package e.a.b.a.a0.a;

import e.a.b.a.d.c;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.c.g;
import java.math.BigInteger;

public class a
  extends d.c
{
  public static final BigInteger i = g.J(b.a);
  protected d j = new d(this, null, null);
  
  public a()
  {
    super(i);
    this.b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144")));
    this.c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864")));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
    this.e = BigInteger.valueOf(8L);
    this.f = 4;
  }
  
  public boolean C(int paramInt)
  {
    return paramInt == 4;
  }
  
  protected e.a.b.a.d c()
  {
    return new a();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final int[] arrayOfInt = new int[paramInt2 * 8 * 2];
    int k = 0;
    int m = 0;
    while (k < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + k)];
      g.f(((c)localh.n()).i, 0, arrayOfInt, m);
      m += 8;
      g.f(((c)localh.o()).i, 0, arrayOfInt, m);
      m += 8;
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
      return a.this.i(new c(arrayOfInt1), new c(arrayOfInt2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */