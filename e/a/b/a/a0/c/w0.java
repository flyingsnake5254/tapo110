package e.a.b.a.a0.c;

import e.a.b.a.d.b;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.c.c;
import java.math.BigInteger;

public class w0
  extends d.b
{
  protected x0 j = new x0(this, null, null);
  
  public w0()
  {
    super(113, 9, 0, 0);
    this.b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("003088250CA6E7C7FE649CE85820F7")));
    this.c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("00E8BEE4D3E2260744188BE0E9C723")));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("0100000000000000D9CCEC8A39E56F"));
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
    return new w0();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final long[] arrayOfLong = new long[paramInt2 * 2 * 2];
    int i = 0;
    int k = 0;
    while (i < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + i)];
      c.d(((v0)localh.n()).g, 0, arrayOfLong, k);
      k += 2;
      c.d(((v0)localh.o()).g, 0, arrayOfLong, k);
      k += 2;
      i++;
    }
    return new a(paramInt2, arrayOfLong);
  }
  
  protected h i(e parame1, e parame2, boolean paramBoolean)
  {
    return new x0(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new x0(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e n(BigInteger paramBigInteger)
  {
    return new v0(paramBigInteger);
  }
  
  public int t()
  {
    return 113;
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
      long[] arrayOfLong1 = c.f();
      long[] arrayOfLong2 = c.f();
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        long l1 = (i ^ paramInt) - 1 >> 31;
        for (int k = 0; k < 2; k++)
        {
          long l2 = arrayOfLong1[k];
          long[] arrayOfLong3 = arrayOfLong;
          arrayOfLong1[k] = (l2 ^ arrayOfLong3[(j + k)] & l1);
          arrayOfLong2[k] ^= arrayOfLong3[(j + 2 + k)] & l1;
        }
        j += 4;
        i++;
      }
      return w0.this.i(new v0(arrayOfLong1), new v0(arrayOfLong2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\w0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */