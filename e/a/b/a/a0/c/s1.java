package e.a.b.a.a0.c;

import e.a.b.a.d.b;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.c.g;
import java.math.BigInteger;

public class s1
  extends d.b
{
  protected t1 j = new t1(this, null, null);
  
  public s1()
  {
    super(193, 15, 0, 0);
    this.b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B")));
    this.c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE")));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("010000000000000000000000015AAB561B005413CCD4EE99D5"));
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
    return new s1();
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
    return new t1(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new t1(this, parame1, parame2, paramArrayOfe, paramBoolean);
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
      return s1.this.i(new p1(arrayOfLong1), new p1(arrayOfLong2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\s1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */