package e.a.b.a.a0.c;

import e.a.b.a.d.b;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.c.g;
import java.math.BigInteger;

public class q1
  extends d.b
{
  protected r1 j = new r1(this, null, null);
  
  public q1()
  {
    super(193, 15, 0, 0);
    this.b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("0017858FEB7A98975169E171F77B4087DE098AC8A911DF7B01")));
    this.c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("00FDFB49BFE6C3A89FACADAA7A1E5BBC7CC1C2E5D831478814")));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("01000000000000000000000000C7F34A778F443ACC920EBA49"));
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
    return new q1();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final long[] arrayOfLong = new long[paramInt2 * 4 * 2];
    int i = 0;
    int k = 0;
    while (i < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + i)];
      g.g(((p1)localh.n()).g, 0, arrayOfLong, k);
      k += 4;
      g.g(((p1)localh.o()).g, 0, arrayOfLong, k);
      k += 4;
      i++;
    }
    return new a(paramInt2, arrayOfLong);
  }
  
  protected h i(e parame1, e parame2, boolean paramBoolean)
  {
    return new r1(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new r1(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e n(BigInteger paramBigInteger)
  {
    return new p1(paramBigInteger);
  }
  
  public int t()
  {
    return 193;
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
      long[] arrayOfLong1 = g.i();
      long[] arrayOfLong2 = g.i();
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
      return q1.this.i(new p1(arrayOfLong1), new p1(arrayOfLong2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\q1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */