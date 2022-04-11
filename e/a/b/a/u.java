package e.a.b.a;

import java.math.BigInteger;

public class u
  extends a
{
  protected h c(h paramh, BigInteger paramBigInteger)
  {
    int i = Math.max(2, Math.min(16, d(paramBigInteger.bitLength())));
    Object localObject = w.m(paramh, i, true);
    h[] arrayOfh = ((v)localObject).a();
    localObject = ((v)localObject).b();
    int[] arrayOfInt = w.d(i, paramBigInteger);
    paramh = paramh.i().u();
    int j = arrayOfInt.length;
    int k = j;
    int n;
    if (j > 1)
    {
      j--;
      k = arrayOfInt[j];
      int m = k >> 16;
      k &= 0xFFFF;
      n = Math.abs(m);
      if (m < 0) {
        paramh = (h)localObject;
      } else {
        paramh = arrayOfh;
      }
      if (n << 2 < 1 << i)
      {
        m = n.y[n];
        int i1 = i - m;
        paramh = paramh[((1 << i - 1) - 1 >>> 1)].a(paramh[(((n ^ 1 << m - 1) << i1) + 1 >>> 1)]);
        k -= i1;
      }
      else
      {
        paramh = paramh[(n >>> 1)];
      }
      paramh = paramh.I(k);
      k = j;
    }
    while (k > 0)
    {
      k--;
      j = arrayOfInt[k];
      i = j >> 16;
      n = Math.abs(i);
      if (i < 0) {
        paramBigInteger = (BigInteger)localObject;
      } else {
        paramBigInteger = arrayOfh;
      }
      paramh = paramh.K(paramBigInteger[(n >>> 1)]).I(j & 0xFFFF);
    }
    return paramh;
  }
  
  protected int d(int paramInt)
  {
    return w.j(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */