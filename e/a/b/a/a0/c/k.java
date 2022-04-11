package e.a.b.a.a0.c;

import e.a.b.a.d.c;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import java.math.BigInteger;

public class k
  extends d.c
{
  public static final BigInteger i = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73"));
  protected n j = new n(this, null, null);
  
  public k()
  {
    super(i);
    this.b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC70")));
    this.c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("B4E134D3FB59EB8BAB57274904664D5AF50388BA")));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("0100000000000000000000351EE786A818F3A1A16B"));
    this.e = BigInteger.valueOf(1L);
    this.f = 2;
  }
  
  public boolean C(int paramInt)
  {
    return paramInt == 2;
  }
  
  protected e.a.b.a.d c()
  {
    return new k();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final int[] arrayOfInt = new int[paramInt2 * 5 * 2];
    int k = 0;
    int m = 0;
    while (k < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + k)];
      e.a.b.c.d.c(((m)localh.n()).h, 0, arrayOfInt, m);
      m += 5;
      e.a.b.c.d.c(((m)localh.o()).h, 0, arrayOfInt, m);
      m += 5;
      k++;
    }
    return new a(paramInt2, arrayOfInt);
  }
  
  protected h i(e parame1, e parame2, boolean paramBoolean)
  {
    return new n(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new n(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e n(BigInteger paramBigInteger)
  {
    return new m(paramBigInteger);
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
    implements f
  {
    a(int paramInt, int[] paramArrayOfInt) {}
    
    public int a()
    {
      return paramInt2;
    }
    
    public h b(int paramInt)
    {
      int[] arrayOfInt1 = e.a.b.c.d.d();
      int[] arrayOfInt2 = e.a.b.c.d.d();
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        int k = (i ^ paramInt) - 1 >> 31;
        for (int m = 0; m < 5; m++)
        {
          int n = arrayOfInt1[m];
          int[] arrayOfInt3 = arrayOfInt;
          arrayOfInt1[m] = (n ^ arrayOfInt3[(j + m)] & k);
          arrayOfInt2[m] ^= arrayOfInt3[(j + 5 + m)] & k;
        }
        j += 10;
        i++;
      }
      return k.this.i(new m(arrayOfInt1), new m(arrayOfInt2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */