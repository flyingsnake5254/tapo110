package e.a.b.a.a0.c;

import e.a.b.a.d.b;
import e.a.b.a.f;
import e.a.b.a.h;
import java.math.BigInteger;

public class m1
  extends d.b
{
  protected n1 j = new n1(this, null, null);
  
  public m1()
  {
    super(163, 3, 6, 7);
    this.b = n(BigInteger.valueOf(1L));
    this.c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("020A601907B8C953CA1481EB10512F78744A3205FD")));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("040000000000000000000292FE77E70C12A4234C33"));
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
    return new m1();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final long[] arrayOfLong = new long[paramInt2 * 3 * 2];
    int i = 0;
    int k = 0;
    while (i < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + i)];
      e.a.b.c.e.f(((h1)localh.n()).g, 0, arrayOfLong, k);
      k += 3;
      e.a.b.c.e.f(((h1)localh.o()).g, 0, arrayOfLong, k);
      k += 3;
      i++;
    }
    return new a(paramInt2, arrayOfLong);
  }
  
  protected h i(e.a.b.a.e parame1, e.a.b.a.e parame2, boolean paramBoolean)
  {
    return new n1(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e.a.b.a.e parame1, e.a.b.a.e parame2, e.a.b.a.e[] paramArrayOfe, boolean paramBoolean)
  {
    return new n1(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e.a.b.a.e n(BigInteger paramBigInteger)
  {
    return new h1(paramBigInteger);
  }
  
  public int t()
  {
    return 163;
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
      return m1.this.i(new h1(arrayOfLong1), new h1(arrayOfLong2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\m1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */