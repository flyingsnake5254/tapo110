package e.a.b.a.a0.c;

import e.a.b.a.c;
import e.a.b.a.d.c;
import e.a.b.a.e;
import e.a.b.a.h;
import java.math.BigInteger;

public class w
  extends d.c
{
  public static final BigInteger i = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));
  protected z j = new z(this, null, null);
  
  public w()
  {
    super(i);
    this.b = n(c.a);
    this.c = n(BigInteger.valueOf(5L));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("010000000000000000000000000001DCE8D2EC6184CAF0A971769FB1F7"));
    this.e = BigInteger.valueOf(1L);
    this.f = 2;
  }
  
  public boolean C(int paramInt)
  {
    return paramInt == 2;
  }
  
  protected e.a.b.a.d c()
  {
    return new w();
  }
  
  public e.a.b.a.f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final int[] arrayOfInt = new int[paramInt2 * 7 * 2];
    int k = 0;
    int m = 0;
    while (k < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + k)];
      e.a.b.c.f.c(((y)localh.n()).i, 0, arrayOfInt, m);
      m += 7;
      e.a.b.c.f.c(((y)localh.o()).i, 0, arrayOfInt, m);
      m += 7;
      k++;
    }
    return new a(paramInt2, arrayOfInt);
  }
  
  protected h i(e parame1, e parame2, boolean paramBoolean)
  {
    return new z(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new z(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e n(BigInteger paramBigInteger)
  {
    return new y(paramBigInteger);
  }
  
  public int t()
  {
    return i.bitLength();
  }
  
  public h u()
  {
    return this.j;
  }
  
  class a
    implements e.a.b.a.f
  {
    a(int paramInt, int[] paramArrayOfInt) {}
    
    public int a()
    {
      return paramInt2;
    }
    
    public h b(int paramInt)
    {
      int[] arrayOfInt1 = e.a.b.c.f.e();
      int[] arrayOfInt2 = e.a.b.c.f.e();
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        int k = (i ^ paramInt) - 1 >> 31;
        for (int m = 0; m < 7; m++)
        {
          int n = arrayOfInt1[m];
          int[] arrayOfInt3 = arrayOfInt;
          arrayOfInt1[m] = (n ^ arrayOfInt3[(j + m)] & k);
          arrayOfInt2[m] ^= arrayOfInt3[(j + 7 + m)] & k;
        }
        j += 14;
        i++;
      }
      return w.this.i(new y(arrayOfInt1), new y(arrayOfInt2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */