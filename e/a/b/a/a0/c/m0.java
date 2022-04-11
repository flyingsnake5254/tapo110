package e.a.b.a.a0.c;

import e.a.b.a.d.c;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.c.m;
import java.math.BigInteger;

public class m0
  extends d.c
{
  public static final BigInteger i = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));
  protected p0 j = new p0(this, null, null);
  
  public m0()
  {
    super(i);
    this.b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC")));
    this.c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF")));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973"));
    this.e = BigInteger.valueOf(1L);
    this.f = 2;
  }
  
  public boolean C(int paramInt)
  {
    return paramInt == 2;
  }
  
  protected e.a.b.a.d c()
  {
    return new m0();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final int[] arrayOfInt = new int[paramInt2 * 12 * 2];
    int k = 0;
    int m = 0;
    while (k < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + k)];
      m.h(12, ((o0)localh.n()).h, 0, arrayOfInt, m);
      m += 12;
      m.h(12, ((o0)localh.o()).h, 0, arrayOfInt, m);
      m += 12;
      k++;
    }
    return new a(paramInt2, arrayOfInt);
  }
  
  protected h i(e parame1, e parame2, boolean paramBoolean)
  {
    return new p0(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new p0(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e n(BigInteger paramBigInteger)
  {
    return new o0(paramBigInteger);
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
      int[] arrayOfInt1 = m.j(12);
      int[] arrayOfInt2 = m.j(12);
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        int k = (i ^ paramInt) - 1 >> 31;
        for (int m = 0; m < 12; m++)
        {
          int n = arrayOfInt1[m];
          int[] arrayOfInt3 = arrayOfInt;
          arrayOfInt1[m] = (n ^ arrayOfInt3[(j + m)] & k);
          arrayOfInt2[m] ^= arrayOfInt3[(j + 12 + m)] & k;
        }
        j += 24;
        i++;
      }
      return m0.this.i(new o0(arrayOfInt1), new o0(arrayOfInt2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\m0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */