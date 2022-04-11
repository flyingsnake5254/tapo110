package e.a.b.a.a0.c;

import e.a.b.a.d.b;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.g;
import e.a.b.a.x;
import java.math.BigInteger;

public class g2
  extends d.b
{
  protected h2 j = new h2(this, null, null);
  
  public g2()
  {
    super(283, 5, 7, 12);
    this.b = n(BigInteger.valueOf(0L));
    this.c = n(BigInteger.valueOf(1L));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE9AE2ED07577265DFF7F94451E061E163C61"));
    this.e = BigInteger.valueOf(4L);
    this.f = 6;
  }
  
  public boolean C(int paramInt)
  {
    return paramInt == 6;
  }
  
  public boolean G()
  {
    return true;
  }
  
  protected e.a.b.a.d c()
  {
    return new g2();
  }
  
  public f e(e.a.b.a.h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final long[] arrayOfLong = new long[paramInt2 * 5 * 2];
    int i = 0;
    int k = 0;
    while (i < paramInt2)
    {
      e.a.b.a.h localh = paramArrayOfh[(paramInt1 + i)];
      e.a.b.c.h.a(((f2)localh.n()).g, 0, arrayOfLong, k);
      k += 5;
      e.a.b.c.h.a(((f2)localh.o()).g, 0, arrayOfLong, k);
      k += 5;
      i++;
    }
    return new a(paramInt2, arrayOfLong);
  }
  
  protected g f()
  {
    return new x();
  }
  
  protected e.a.b.a.h i(e parame1, e parame2, boolean paramBoolean)
  {
    return new h2(this, parame1, parame2, paramBoolean);
  }
  
  protected e.a.b.a.h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new h2(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e n(BigInteger paramBigInteger)
  {
    return new f2(paramBigInteger);
  }
  
  public int t()
  {
    return 283;
  }
  
  public e.a.b.a.h u()
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
    
    public e.a.b.a.h b(int paramInt)
    {
      long[] arrayOfLong1 = e.a.b.c.h.b();
      long[] arrayOfLong2 = e.a.b.c.h.b();
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        long l1 = (i ^ paramInt) - 1 >> 31;
        for (int k = 0; k < 5; k++)
        {
          long l2 = arrayOfLong1[k];
          long[] arrayOfLong3 = arrayOfLong;
          arrayOfLong1[k] = (l2 ^ arrayOfLong3[(j + k)] & l1);
          arrayOfLong2[k] ^= arrayOfLong3[(j + 5 + k)] & l1;
        }
        j += 10;
        i++;
      }
      return g2.this.i(new f2(arrayOfLong1), new f2(arrayOfLong2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\g2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */