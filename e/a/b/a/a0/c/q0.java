package e.a.b.a.a0.c;

import e.a.b.a.d.c;
import e.a.b.a.e;
import e.a.b.a.f;
import e.a.b.a.h;
import e.a.b.c.m;
import java.math.BigInteger;

public class q0
  extends d.c
{
  public static final BigInteger i = new BigInteger(1, org.bouncycastle.util.encoders.d.a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));
  protected t0 j = new t0(this, null, null);
  
  public q0()
  {
    super(i);
    this.b = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC")));
    this.c = n(new BigInteger(1, org.bouncycastle.util.encoders.d.a("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00")));
    this.d = new BigInteger(1, org.bouncycastle.util.encoders.d.a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409"));
    this.e = BigInteger.valueOf(1L);
    this.f = 2;
  }
  
  public boolean C(int paramInt)
  {
    return paramInt == 2;
  }
  
  protected e.a.b.a.d c()
  {
    return new q0();
  }
  
  public f e(h[] paramArrayOfh, int paramInt1, final int paramInt2)
  {
    final int[] arrayOfInt = new int[paramInt2 * 17 * 2];
    int k = 0;
    int m = 0;
    while (k < paramInt2)
    {
      h localh = paramArrayOfh[(paramInt1 + k)];
      m.h(17, ((s0)localh.n()).h, 0, arrayOfInt, m);
      m += 17;
      m.h(17, ((s0)localh.o()).h, 0, arrayOfInt, m);
      m += 17;
      k++;
    }
    return new a(paramInt2, arrayOfInt);
  }
  
  protected h i(e parame1, e parame2, boolean paramBoolean)
  {
    return new t0(this, parame1, parame2, paramBoolean);
  }
  
  protected h j(e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
  {
    return new t0(this, parame1, parame2, paramArrayOfe, paramBoolean);
  }
  
  public e n(BigInteger paramBigInteger)
  {
    return new s0(paramBigInteger);
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
      int[] arrayOfInt1 = m.j(17);
      int[] arrayOfInt2 = m.j(17);
      int i = 0;
      int j = 0;
      while (i < paramInt2)
      {
        int k = (i ^ paramInt) - 1 >> 31;
        for (int m = 0; m < 17; m++)
        {
          int n = arrayOfInt1[m];
          int[] arrayOfInt3 = arrayOfInt;
          arrayOfInt1[m] = (n ^ arrayOfInt3[(j + m)] & k);
          arrayOfInt2[m] ^= arrayOfInt3[(j + 17 + m)] & k;
        }
        j += 34;
        i++;
      }
      return q0.this.i(new s0(arrayOfInt1), new s0(arrayOfInt2), false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\a0\c\q0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */