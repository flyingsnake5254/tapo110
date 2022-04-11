package e.a.b.a;

import e.a.b.c.m;
import java.math.BigInteger;

public class j
  extends a
{
  protected h c(h paramh, BigInteger paramBigInteger)
  {
    d locald = paramh.i();
    int i = l.a(locald);
    if (paramBigInteger.bitLength() <= i)
    {
      k localk = l.b(paramh);
      f localf = localk.a();
      int j = localk.c();
      int k = (i + j - 1) / j;
      paramh = locald.u();
      int m = j * k;
      paramBigInteger = m.o(m, paramBigInteger);
      for (j = 0; j < k; j++)
      {
        int n = m - 1 - j;
        i = 0;
        while (n >= 0)
        {
          i = i << 1 | m.p(paramBigInteger, n);
          n -= k;
        }
        paramh = paramh.K(localf.b(i));
      }
      return paramh.a(localk.b());
    }
    throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */