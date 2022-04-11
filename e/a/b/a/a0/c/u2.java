package e.a.b.a.a0.c;

import e.a.b.a.d.b;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.c.l;
import java.math.BigInteger;

public class u2
  extends d.b
{
  static final r2 j;
  static final r2 k;
  protected v2 l = new v2(this, null, null);
  
  static
  {
    r2 localr2 = new r2(new BigInteger(1, org.bouncycastle.util.encoders.d.a("02F40E7E2221F295DE297117B7F3D62F5C6A97FFCB8CEFF1CD6BA8CE4A9A18AD84FFABBD8EFA59332BE7AD6756A66E294AFD185A78FF12AA520E4DE739BACA0C7FFEFF7F2955727A")));
    j = localr2;
    k = (r2)localr2.n();
  }
  
  public u2()
  {
    super(571, 2, 5, 10);
    this.b = n(BigInteger.valueOf(1L));
    this.c = j;
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE661CE18FF55987308059B186823851EC7DD9CA1161DE93D5174D66E8382E9BB2FE84E47"));
    this.e = BigInteger.valueOf(2L);
    this.f = 6;
  }
  
  public boolean C(int paramInt)
  {
    return paramInt == 6;
  }
  
  public boolean G()
  {
    return false;
  }
  
  protected e.a.b.a.d c()
  {
    return new u2();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final long[] arrayOfLong = new long[paramInt2 * 9 * 2];
    int i = 0;
    int m = 0;
    while (i < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + i)];
      l.a(((r2)localh.n()).g, 0, arrayOfLong, m);
      m += 9;
      l.a(((r2)localh.o()).g, 0, arrayOfLong, m);
      m += 9;
      i++;
    }
    return new a(paramInt2, arrayOfLong);
  }
  
  protected h i(e parame1, e parame2, boolean paramBoolean)
  {
    return new v2(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new v2(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e n(BigInteger paramBigInteger)
  {
    return new r2(paramBigInteger);
  }
  
  public int t()
  {
    return 571;
  }
  
  public h u()
  {
    return this.l;
  }
  
  class a
    implements f
  {
    a(int paramInt, long[] paramArrayOfLong) {}
    
    public int a()
    {
      return paramInt2;
    }
    
    public h b(int paramInt)
    {
      long[] arrayOfLong1 = l.b();
      long[] arrayOfLong2 = l.b();
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        long l1 = (i ^ paramInt) - 1 >> 31;
        for (int k = 0; k < 9; k++)
        {
          long l2 = arrayOfLong1[k];
          long[] arrayOfLong3 = arrayOfLong;
          arrayOfLong1[k] = (l2 ^ arrayOfLong3[(j + k)] & l1);
          arrayOfLong2[k] ^= arrayOfLong3[(j + 9 + k)] & l1;
        }
        j += 18;
        i++;
      }
      return u2.this.i(new r2(arrayOfLong1), new r2(arrayOfLong2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\u2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */