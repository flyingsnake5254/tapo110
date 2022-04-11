package e.a.b.a;

import e.a.b.b.a;
import e.a.b.b.f;
import java.math.BigInteger;

public class b
{
  public static h a(d paramd, h paramh)
  {
    if (paramd.m(paramh.i())) {
      return paramd.k(paramh.l(false));
    }
    throw new IllegalArgumentException("Point must be on the same curve");
  }
  
  static h b(h paramh)
  {
    if (paramh.x()) {
      return paramh;
    }
    throw new IllegalStateException("Invalid result");
  }
  
  static h c(h paramh1, BigInteger paramBigInteger1, h paramh2, BigInteger paramBigInteger2)
  {
    int i = paramBigInteger1.signum();
    int j = 0;
    if (i < 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramBigInteger2.signum() < 0) {
      j = 1;
    }
    BigInteger localBigInteger1 = paramBigInteger1.abs();
    BigInteger localBigInteger2 = paramBigInteger2.abs();
    int k = Math.max(2, Math.min(16, w.j(localBigInteger1.bitLength())));
    int m = Math.max(2, Math.min(16, w.j(localBigInteger2.bitLength())));
    v localv = w.m(paramh1, k, true);
    paramBigInteger2 = w.m(paramh2, m, true);
    if (i != 0) {
      paramh1 = localv.b();
    } else {
      paramh1 = localv.a();
    }
    if (j != 0) {
      paramBigInteger1 = paramBigInteger2.b();
    } else {
      paramBigInteger1 = paramBigInteger2.a();
    }
    if (i != 0) {
      paramh2 = localv.a();
    } else {
      paramh2 = localv.b();
    }
    if (j != 0) {
      paramBigInteger2 = paramBigInteger2.a();
    } else {
      paramBigInteger2 = paramBigInteger2.b();
    }
    return e(paramh1, paramh2, w.f(k, localBigInteger1), paramBigInteger1, paramBigInteger2, w.f(m, localBigInteger2));
  }
  
  static h d(h paramh, BigInteger paramBigInteger1, i parami, BigInteger paramBigInteger2)
  {
    int i = paramBigInteger1.signum();
    int j = 0;
    if (i < 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramBigInteger2.signum() < 0) {
      j = 1;
    }
    BigInteger localBigInteger1 = paramBigInteger1.abs();
    BigInteger localBigInteger2 = paramBigInteger2.abs();
    int k = Math.max(2, Math.min(16, w.j(Math.max(localBigInteger1.bitLength(), localBigInteger2.bitLength()))));
    paramBigInteger1 = w.l(paramh, k, true, parami);
    parami = w.h(paramh);
    paramBigInteger2 = w.h(paramBigInteger1);
    if (i != 0) {
      paramh = parami.b();
    } else {
      paramh = parami.a();
    }
    if (j != 0) {
      paramBigInteger1 = paramBigInteger2.b();
    } else {
      paramBigInteger1 = paramBigInteger2.a();
    }
    if (i != 0) {
      parami = parami.a();
    } else {
      parami = parami.b();
    }
    if (j != 0) {
      paramBigInteger2 = paramBigInteger2.a();
    } else {
      paramBigInteger2 = paramBigInteger2.b();
    }
    return e(paramh, parami, w.f(k, localBigInteger1), paramBigInteger1, paramBigInteger2, w.f(k, localBigInteger2));
  }
  
  private static h e(h[] paramArrayOfh1, h[] paramArrayOfh2, byte[] paramArrayOfByte1, h[] paramArrayOfh3, h[] paramArrayOfh4, byte[] paramArrayOfByte2)
  {
    int i = Math.max(paramArrayOfByte1.length, paramArrayOfByte2.length);
    h localh1 = paramArrayOfh1[0].i().u();
    int j = i - 1;
    h localh2 = localh1;
    i = 0;
    while (j >= 0)
    {
      int k;
      if (j < paramArrayOfByte1.length) {
        k = paramArrayOfByte1[j];
      } else {
        k = 0;
      }
      int m;
      if (j < paramArrayOfByte2.length) {
        m = paramArrayOfByte2[j];
      } else {
        m = 0;
      }
      if ((k | m) == 0)
      {
        i++;
      }
      else
      {
        if (k != 0)
        {
          int n = Math.abs(k);
          if (k < 0) {
            localObject1 = paramArrayOfh2;
          } else {
            localObject1 = paramArrayOfh1;
          }
          localObject1 = localh1.a(localObject1[(n >>> 1)]);
        }
        else
        {
          localObject1 = localh1;
        }
        Object localObject2 = localObject1;
        if (m != 0)
        {
          k = Math.abs(m);
          if (m < 0) {
            localObject2 = paramArrayOfh4;
          } else {
            localObject2 = paramArrayOfh3;
          }
          localObject2 = ((h)localObject1).a(localObject2[(k >>> 1)]);
        }
        k = i;
        Object localObject1 = localh2;
        if (i > 0)
        {
          localObject1 = localh2.I(i);
          k = 0;
        }
        localh2 = ((h)localObject1).K((h)localObject2);
        i = k;
      }
      j--;
    }
    paramArrayOfh1 = localh2;
    if (i > 0) {
      paramArrayOfh1 = localh2.I(i);
    }
    return paramArrayOfh1;
  }
  
  public static h f(d paramd, h paramh)
  {
    if (paramd.m(paramh.i())) {
      return paramd.y(paramh);
    }
    throw new IllegalArgumentException("Point must be on the same curve");
  }
  
  public static boolean g(d paramd)
  {
    return h(paramd.s());
  }
  
  public static boolean h(a parama)
  {
    int i = parama.a();
    boolean bool = true;
    if ((i <= 1) || (!parama.b().equals(c.c)) || (!(parama instanceof f))) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean i(d paramd)
  {
    return j(paramd.s());
  }
  
  public static boolean j(a parama)
  {
    int i = parama.a();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public static void k(e[] paramArrayOfe, int paramInt1, int paramInt2, e parame)
  {
    e[] arrayOfe = new e[paramInt2];
    e locale = paramArrayOfe[paramInt1];
    int i = 0;
    arrayOfe[0] = locale;
    for (;;)
    {
      i++;
      if (i >= paramInt2) {
        break;
      }
      arrayOfe[i] = arrayOfe[(i - 1)].j(paramArrayOfe[(paramInt1 + i)]);
    }
    paramInt2 = i - 1;
    if (parame != null) {
      arrayOfe[paramInt2] = arrayOfe[paramInt2].j(parame);
    }
    parame = arrayOfe[paramInt2].g();
    while (paramInt2 > 0)
    {
      i = paramInt2 - 1;
      paramInt2 += paramInt1;
      locale = paramArrayOfe[paramInt2];
      paramArrayOfe[paramInt2] = arrayOfe[i].j(parame);
      parame = parame.j(locale);
      paramInt2 = i;
    }
    paramArrayOfe[paramInt1] = parame;
  }
  
  public static h l(h paramh, BigInteger paramBigInteger)
  {
    BigInteger localBigInteger = paramBigInteger.abs();
    h localh1 = paramh.i().u();
    int i = localBigInteger.bitLength();
    h localh2 = localh1;
    if (i > 0)
    {
      localh2 = localh1;
      if (localBigInteger.testBit(0)) {
        localh2 = paramh;
      }
      int j = 1;
      localh1 = paramh;
      for (paramh = localh2;; paramh = localh2)
      {
        localh2 = paramh;
        if (j >= i) {
          break;
        }
        localh1 = localh1.J();
        localh2 = paramh;
        if (localBigInteger.testBit(j)) {
          localh2 = paramh.a(localh1);
        }
        j++;
      }
    }
    paramh = localh2;
    if (paramBigInteger.signum() < 0) {
      paramh = localh2.z();
    }
    return paramh;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */