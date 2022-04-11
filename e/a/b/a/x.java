package e.a.b.a;

import java.math.BigInteger;

public class x
  extends a
{
  private static h.b d(h.b paramb, byte[] paramArrayOfByte)
  {
    Object localObject = (d.b)paramb.i();
    h.b[] arrayOfb1 = ((y)((d)localObject).B(paramb, "bc_wtnaf", new a(paramb, ((d)localObject).o().t().byteValue()))).a();
    h.b[] arrayOfb2 = new h.b[arrayOfb1.length];
    for (int i = 0; i < arrayOfb1.length; i++) {
      arrayOfb2[i] = ((h.b)arrayOfb1[i].z());
    }
    paramb = (h.b)paramb.i().u();
    int j = paramArrayOfByte.length - 1;
    i = 0;
    while (j >= 0)
    {
      int k = i + 1;
      int m = paramArrayOfByte[j];
      i = k;
      localObject = paramb;
      if (m != 0)
      {
        localObject = paramb.L(k);
        if (m > 0) {
          paramb = arrayOfb1[(m >>> 1)];
        } else {
          paramb = arrayOfb2[(-m >>> 1)];
        }
        localObject = (h.b)((h)localObject).a(paramb);
        i = 0;
      }
      j--;
      paramb = (h.b)localObject;
    }
    paramArrayOfByte = paramb;
    if (i > 0) {
      paramArrayOfByte = paramb.L(i);
    }
    return paramArrayOfByte;
  }
  
  private h.b e(h.b paramb, z paramz, byte paramByte1, byte paramByte2)
  {
    z[] arrayOfz;
    if (paramByte1 == 0) {
      arrayOfz = s.d;
    } else {
      arrayOfz = s.f;
    }
    BigInteger localBigInteger = s.g(paramByte2, 4);
    return d(paramb, s.l(paramByte2, paramz, (byte)4, BigInteger.valueOf(16L), localBigInteger, arrayOfz));
  }
  
  protected h c(h paramh, BigInteger paramBigInteger)
  {
    if ((paramh instanceof h.b))
    {
      paramh = (h.b)paramh;
      d.b localb = (d.b)paramh.i();
      int i = localb.t();
      byte b1 = localb.o().t().byteValue();
      byte b2 = s.c(b1);
      return e(paramh, s.j(paramBigInteger, i, b1, localb.F(), b2, (byte)10), b1, b2);
    }
    throw new IllegalArgumentException("Only ECPoint.AbstractF2m can be used in WTauNafMultiplier");
  }
  
  static final class a
    implements o
  {
    a(h.b paramb, byte paramByte) {}
    
    public p a(p paramp)
    {
      if ((paramp instanceof y)) {
        return paramp;
      }
      paramp = new y();
      paramp.b(s.d(this.a, this.b));
      return paramp;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */