package e.a.b.a.a0.c;

import e.a.b.a.d.b;
import e.a.b.a.f;
import e.a.b.a.h;
import java.math.BigInteger;

public class c1
  extends d.b
{
  protected d1 j = new d1(this, null, null);
  
  public c1()
  {
    super(131, 2, 3, 8);
    this.b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("07A11B09A76B562144418FF3FF8C2570B8")));
    this.c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("0217C05610884B63B9C6C7291678F9D341")));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("0400000000000000023123953A9464B54D"));
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
    return new c1();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final long[] arrayOfLong = new long[paramInt2 * 3 * 2];
    int i = 0;
    int k = 0;
    while (i < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + i)];
      e.a.b.c.e.f(((b1)localh.n()).g, 0, arrayOfLong, k);
      k += 3;
      e.a.b.c.e.f(((b1)localh.o()).g, 0, arrayOfLong, k);
      k += 3;
      i++;
    }
    return new a(paramInt2, arrayOfLong);
  }
  
  protected h i(e.a.b.a.e parame1, e.a.b.a.e parame2, boolean paramBoolean)
  {
    return new d1(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e.a.b.a.e parame1, e.a.b.a.e parame2, e.a.b.a.e[] paramArrayOfe, boolean paramBoolean)
  {
    return new d1(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e.a.b.a.e n(BigInteger paramBigInteger)
  {
    return new b1(paramBigInteger);
  }
  
  public int t()
  {
    return 131;
  }
  
  public h u()
  {
    return this.j;
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
      long[] arrayOfLong1 = e.a.b.c.e.h();
      long[] arrayOfLong2 = e.a.b.c.e.h();
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        long l1 = (i ^ paramInt) - 1 >> 31;
        for (int k = 0; k < 3; k++)
        {
          long l2 = arrayOfLong1[k];
          long[] arrayOfLong3 = arrayOfLong;
          arrayOfLong1[k] = (l2 ^ arrayOfLong3[(j + k)] & l1);
          arrayOfLong2[k] ^= arrayOfLong3[(j + 3 + k)] & l1;
        }
        j += 6;
        i++;
      }
      return c1.this.i(new b1(arrayOfLong1), new b1(arrayOfLong2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\c1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */