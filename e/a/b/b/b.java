package e.a.b.b;

import java.math.BigInteger;

public abstract class b
{
  static final a a = new g(BigInteger.valueOf(2L));
  static final a b = new g(BigInteger.valueOf(3L));
  
  public static f a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[0] == 0)
    {
      int i = 1;
      while (i < paramArrayOfInt.length) {
        if (paramArrayOfInt[i] > paramArrayOfInt[(i - 1)]) {
          i++;
        } else {
          throw new IllegalArgumentException("Polynomial exponents must be montonically increasing");
        }
      }
      return new d(a, new c(paramArrayOfInt));
    }
    throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
  }
  
  public static a b(BigInteger paramBigInteger)
  {
    int i = paramBigInteger.bitLength();
    if ((paramBigInteger.signum() > 0) && (i >= 2))
    {
      if (i < 3)
      {
        i = paramBigInteger.intValue();
        if (i != 2)
        {
          if (i == 3) {
            return b;
          }
        }
        else {
          return a;
        }
      }
      return new g(paramBigInteger);
    }
    throw new IllegalArgumentException("'characteristic' must be >= 2");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */