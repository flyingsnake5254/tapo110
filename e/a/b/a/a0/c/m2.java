package e.a.b.a.a0.c;

import e.a.b.a.d.b;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.g;
import e.a.b.a.h;
import e.a.b.a.x;
import e.a.b.c.j;
import java.math.BigInteger;

public class m2
  extends d.b
{
  protected n2 j = new n2(this, null, null);
  
  public m2()
  {
    super(409, 87, 0, 0);
    this.b = n(BigInteger.valueOf(0L));
    this.c = n(BigInteger.valueOf(1L));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF"));
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
    return new m2();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final long[] arrayOfLong = new long[paramInt2 * 7 * 2];
    int i = 0;
    int k = 0;
    while (i < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + i)];
      j.a(((l2)localh.n()).g, 0, arrayOfLong, k);
      k += 7;
      j.a(((l2)localh.o()).g, 0, arrayOfLong, k);
      k += 7;
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
    return new n2(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new n2(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e n(BigInteger paramBigInteger)
  {
    return new l2(paramBigInteger);
  }
  
  public int t()
  {
    return 409;
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
      long[] arrayOfLong1 = j.b();
      long[] arrayOfLong2 = j.b();
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        long l1 = (i ^ paramInt) - 1 >> 31;
        for (int k = 0; k < 7; k++)
        {
          long l2 = arrayOfLong1[k];
          long[] arrayOfLong3 = arrayOfLong;
          arrayOfLong1[k] = (l2 ^ arrayOfLong3[(j + k)] & l1);
          arrayOfLong2[k] ^= arrayOfLong3[(j + 7 + k)] & l1;
        }
        j += 14;
        i++;
      }
      return m2.this.i(new l2(arrayOfLong1), new l2(arrayOfLong2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\m2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */