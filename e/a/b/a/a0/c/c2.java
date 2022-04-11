package e.a.b.a.a0.c;

import e.a.b.a.d.b;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.a.x;
import java.math.BigInteger;

public class c2
  extends d.b
{
  protected d2 j = new d2(this, null, null);
  
  public c2()
  {
    super(239, 158, 0, 0);
    this.b = n(BigInteger.valueOf(0L));
    this.c = n(BigInteger.valueOf(1L));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("2000000000000000000000000000005A79FEC67CB6E91F1C1DA800E478A5"));
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
    return new c2();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final long[] arrayOfLong = new long[paramInt2 * 4 * 2];
    int i = 0;
    int k = 0;
    while (i < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + i)];
      e.a.b.c.g.g(((b2)localh.n()).g, 0, arrayOfLong, k);
      k += 4;
      e.a.b.c.g.g(((b2)localh.o()).g, 0, arrayOfLong, k);
      k += 4;
      i++;
    }
    return new a(paramInt2, arrayOfLong);
  }
  
  protected e.a.b.a.g f()
  {
    return new x();
  }
  
  protected h i(e parame1, e parame2, boolean paramBoolean)
  {
    return new d2(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new d2(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e n(BigInteger paramBigInteger)
  {
    return new b2(paramBigInteger);
  }
  
  public int t()
  {
    return 239;
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
      long[] arrayOfLong1 = e.a.b.c.g.i();
      long[] arrayOfLong2 = e.a.b.c.g.i();
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        long l1 = (i ^ paramInt) - 1 >> 31;
        for (int k = 0; k < 4; k++)
        {
          long l2 = arrayOfLong1[k];
          long[] arrayOfLong3 = arrayOfLong;
          arrayOfLong1[k] = (l2 ^ arrayOfLong3[(j + k)] & l1);
          arrayOfLong2[k] ^= arrayOfLong3[(j + 4 + k)] & l1;
        }
        j += 8;
        i++;
      }
      return c2.this.i(new b2(arrayOfLong1), new b2(arrayOfLong2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\c2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */