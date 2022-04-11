package e.a.b.a.a0.c;

import e.a.b.a.d.b;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.g;
import e.a.b.a.h;
import e.a.b.a.x;
import e.a.b.c.l;
import java.math.BigInteger;

public class s2
  extends d.b
{
  protected t2 j = new t2(this, null, null);
  
  public s2()
  {
    super(571, 2, 5, 10);
    this.b = n(BigInteger.valueOf(0L));
    this.c = n(BigInteger.valueOf(1L));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("020000000000000000000000000000000000000000000000000000000000000000000000131850E1F19A63E4B391A8DB917F4138B630D84BE5D639381E91DEB45CFE778F637C1001"));
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
    return new s2();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final long[] arrayOfLong = new long[paramInt2 * 9 * 2];
    int i = 0;
    int k = 0;
    while (i < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + i)];
      l.a(((r2)localh.n()).g, 0, arrayOfLong, k);
      k += 9;
      l.a(((r2)localh.o()).g, 0, arrayOfLong, k);
      k += 9;
      i++;
    }
    return new a(paramInt2, arrayOfLong);
  }
  
  protected g f()
  {
    return new x();
  }
  
  protected h i(e parame1, e parame2, boolean paramBoolean)
  {
    return new t2(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new t2(this, parame1, parame2, paramArrayOfe, paramBoolean);
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
      return s2.this.i(new r2(arrayOfLong1), new r2(arrayOfLong2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\s2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */