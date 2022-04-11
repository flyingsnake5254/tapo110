package e.a.b.a;

import java.math.BigInteger;

public abstract class w
{
  private static final int[] a = { 13, 41, 121, 337, 897, 2305 };
  private static final byte[] b = new byte[0];
  private static final int[] c = new int[0];
  private static final h[] d = new h[0];
  
  public static int[] c(BigInteger paramBigInteger)
  {
    if (paramBigInteger.bitLength() >>> 16 == 0)
    {
      if (paramBigInteger.signum() == 0) {
        return c;
      }
      BigInteger localBigInteger = paramBigInteger.shiftLeft(1).add(paramBigInteger);
      int i = localBigInteger.bitLength();
      int j = i >> 1;
      int[] arrayOfInt = new int[j];
      localBigInteger = localBigInteger.xor(paramBigInteger);
      int k = 0;
      int m = 0;
      for (int n = 1; n < i - 1; n++) {
        if (!localBigInteger.testBit(n))
        {
          m++;
        }
        else
        {
          int i1;
          if (paramBigInteger.testBit(n)) {
            i1 = -1;
          } else {
            i1 = 1;
          }
          arrayOfInt[k] = (m | i1 << 16);
          n++;
          k++;
          m = 1;
        }
      }
      n = k + 1;
      arrayOfInt[k] = (0x10000 | m);
      paramBigInteger = arrayOfInt;
      if (j > n) {
        paramBigInteger = p(arrayOfInt, n);
      }
      return paramBigInteger;
    }
    throw new IllegalArgumentException("'k' must have bitlength < 2^16");
  }
  
  public static int[] d(int paramInt, BigInteger paramBigInteger)
  {
    if (paramInt == 2) {
      return c(paramBigInteger);
    }
    if ((paramInt >= 2) && (paramInt <= 16))
    {
      if (paramBigInteger.bitLength() >>> 16 == 0)
      {
        if (paramBigInteger.signum() == 0) {
          return c;
        }
        int i = paramBigInteger.bitLength() / paramInt + 1;
        int[] arrayOfInt = new int[i];
        int j = 1 << paramInt;
        int k = 0;
        int m = 0;
        int n = 0;
        while (k <= paramBigInteger.bitLength()) {
          if (paramBigInteger.testBit(k) == n)
          {
            k++;
          }
          else
          {
            paramBigInteger = paramBigInteger.shiftRight(k);
            int i1 = paramBigInteger.intValue() & j - 1;
            int i2 = i1;
            if (n != 0) {
              i2 = i1 + 1;
            }
            if ((i2 & j >>> 1) != 0) {
              n = 1;
            } else {
              n = 0;
            }
            i1 = i2;
            if (n != 0) {
              i1 = i2 - j;
            }
            i2 = k;
            if (m > 0) {
              i2 = k - 1;
            }
            arrayOfInt[m] = (i2 | i1 << 16);
            k = paramInt;
            m++;
          }
        }
        paramBigInteger = arrayOfInt;
        if (i > m) {
          paramBigInteger = p(arrayOfInt, m);
        }
        return paramBigInteger;
      }
      throw new IllegalArgumentException("'k' must have bitlength < 2^16");
    }
    throw new IllegalArgumentException("'width' must be in the range [2, 16]");
  }
  
  public static byte[] e(BigInteger paramBigInteger)
  {
    if (paramBigInteger.signum() == 0) {
      return b;
    }
    BigInteger localBigInteger = paramBigInteger.shiftLeft(1).add(paramBigInteger);
    int i = localBigInteger.bitLength() - 1;
    byte[] arrayOfByte = new byte[i];
    localBigInteger = localBigInteger.xor(paramBigInteger);
    int k;
    for (int j = 1; j < i; j = k + 1)
    {
      k = j;
      if (localBigInteger.testBit(j))
      {
        if (paramBigInteger.testBit(j)) {
          k = -1;
        } else {
          k = 1;
        }
        arrayOfByte[(j - 1)] = ((byte)(byte)k);
        k = j + 1;
      }
    }
    arrayOfByte[(i - 1)] = ((byte)1);
    return arrayOfByte;
  }
  
  public static byte[] f(int paramInt, BigInteger paramBigInteger)
  {
    if (paramInt == 2) {
      return e(paramBigInteger);
    }
    if ((paramInt >= 2) && (paramInt <= 8))
    {
      if (paramBigInteger.signum() == 0) {
        return b;
      }
      int i = paramBigInteger.bitLength() + 1;
      byte[] arrayOfByte = new byte[i];
      int j = 1 << paramInt;
      int k = 0;
      int m = 0;
      int n = 0;
      while (k <= paramBigInteger.bitLength()) {
        if (paramBigInteger.testBit(k) == n)
        {
          k++;
        }
        else
        {
          paramBigInteger = paramBigInteger.shiftRight(k);
          int i1 = paramBigInteger.intValue() & j - 1;
          int i2 = i1;
          if (n != 0) {
            i2 = i1 + 1;
          }
          if ((i2 & j >>> 1) != 0) {
            n = 1;
          } else {
            n = 0;
          }
          i1 = i2;
          if (n != 0) {
            i1 = i2 - j;
          }
          i2 = k;
          if (m > 0) {
            i2 = k - 1;
          }
          k = m + i2;
          arrayOfByte[k] = ((byte)(byte)i1);
          m = k + 1;
          k = paramInt;
        }
      }
      paramBigInteger = arrayOfByte;
      if (i > m) {
        paramBigInteger = o(arrayOfByte, m);
      }
      return paramBigInteger;
    }
    throw new IllegalArgumentException("'width' must be in the range [2, 8]");
  }
  
  public static int g(BigInteger paramBigInteger)
  {
    if (paramBigInteger.signum() == 0) {
      return 0;
    }
    return paramBigInteger.shiftLeft(1).add(paramBigInteger).xor(paramBigInteger).bitCount();
  }
  
  public static v h(h paramh)
  {
    return i(paramh.i().x(paramh, "bc_wnaf"));
  }
  
  public static v i(p paramp)
  {
    if ((paramp instanceof v)) {
      paramp = (v)paramp;
    } else {
      paramp = null;
    }
    return paramp;
  }
  
  public static int j(int paramInt)
  {
    return k(paramInt, a);
  }
  
  public static int k(int paramInt, int[] paramArrayOfInt)
  {
    for (int i = 0; (i < paramArrayOfInt.length) && (paramInt >= paramArrayOfInt[i]); i++) {}
    return i + 2;
  }
  
  public static h l(h paramh, int paramInt, final boolean paramBoolean, final i parami)
  {
    d locald = paramh.i();
    v localv = m(paramh, paramInt, paramBoolean);
    paramh = parami.a(paramh);
    locald.B(paramh, "bc_wnaf", new a(localv, parami, paramBoolean));
    return paramh;
  }
  
  public static v m(final h paramh, int paramInt, final boolean paramBoolean)
  {
    final d locald = paramh.i();
    return (v)locald.B(paramh, "bc_wnaf", new b(paramInt, paramBoolean, paramh, locald));
  }
  
  private static h[] n(h[] paramArrayOfh, int paramInt)
  {
    h[] arrayOfh = new h[paramInt];
    System.arraycopy(paramArrayOfh, 0, arrayOfh, 0, paramArrayOfh.length);
    return arrayOfh;
  }
  
  private static byte[] o(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  private static int[] p(int[] paramArrayOfInt, int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt);
    return arrayOfInt;
  }
  
  static final class a
    implements o
  {
    a(v paramv, i parami, boolean paramBoolean) {}
    
    public p a(p paramp)
    {
      paramp = new v();
      Object localObject = this.a.c();
      if (localObject != null) {
        paramp.f(parami.a((h)localObject));
      }
      h[] arrayOfh = this.a.a();
      int i = arrayOfh.length;
      localObject = new h[i];
      int j = 0;
      for (int k = 0; k < arrayOfh.length; k++) {
        localObject[k] = parami.a(arrayOfh[k]);
      }
      paramp.d((h[])localObject);
      if (paramBoolean)
      {
        arrayOfh = new h[i];
        for (k = j; k < i; k++) {
          arrayOfh[k] = localObject[k].z();
        }
        paramp.e(arrayOfh);
      }
      return paramp;
    }
  }
  
  static final class b
    implements o
  {
    b(int paramInt, boolean paramBoolean, h paramh, d paramd) {}
    
    private boolean b(v paramv, int paramInt, boolean paramBoolean)
    {
      if ((paramv != null) && (c(paramv.a(), paramInt)) && ((!paramBoolean) || (c(paramv.b(), paramInt)))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      return paramBoolean;
    }
    
    private boolean c(h[] paramArrayOfh, int paramInt)
    {
      boolean bool;
      if ((paramArrayOfh != null) && (paramArrayOfh.length >= paramInt)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public p a(p paramp)
    {
      boolean bool = paramp instanceof v;
      Object localObject1 = null;
      Object localObject2 = null;
      if (bool) {
        paramp = (v)paramp;
      } else {
        paramp = null;
      }
      int i = this.a;
      int j = 0;
      int k = 1 << Math.max(0, i - 2);
      if (b(paramp, k, paramBoolean)) {
        return paramp;
      }
      Object localObject4;
      if (paramp != null)
      {
        localObject3 = paramp.a();
        localObject4 = paramp.b();
        paramp = paramp.c();
      }
      else
      {
        paramp = null;
        localObject3 = paramp;
        localObject4 = localObject3;
      }
      if (localObject3 == null)
      {
        localObject3 = w.a();
        i = 0;
      }
      else
      {
        i = localObject3.length;
      }
      Object localObject5 = localObject3;
      Object localObject6 = paramp;
      int m;
      if (i < k)
      {
        h[] arrayOfh = w.b((h[])localObject3, k);
        if (k == 1)
        {
          arrayOfh[0] = paramh.A();
          localObject5 = arrayOfh;
          localObject6 = paramp;
        }
        else
        {
          if (i == 0)
          {
            arrayOfh[0] = paramh;
            m = 1;
          }
          else
          {
            m = i;
          }
          if (k == 2)
          {
            arrayOfh[1] = paramh.H();
            localObject2 = localObject1;
            localObject6 = paramp;
          }
          else
          {
            localObject5 = arrayOfh[(m - 1)];
            localObject3 = paramp;
            if (paramp == null)
            {
              localObject6 = arrayOfh[0].J();
              localObject3 = localObject6;
              if (!((h)localObject6).u())
              {
                localObject3 = localObject6;
                if (b.i(locald))
                {
                  localObject3 = localObject6;
                  if (locald.t() >= 64)
                  {
                    n = locald.r();
                    if ((n != 2) && (n != 3) && (n != 4))
                    {
                      localObject3 = localObject6;
                    }
                    else
                    {
                      localObject2 = ((h)localObject6).s(0);
                      h localh1 = locald.g(((h)localObject6).q().t(), ((h)localObject6).r().t());
                      paramp = ((e)localObject2).o();
                      localObject3 = paramp.j((e)localObject2);
                      h localh2 = ((h)localObject5).E(paramp).F((e)localObject3);
                      localObject5 = localObject2;
                      localObject1 = localh1;
                      paramp = localh2;
                      n = m;
                      localObject3 = localObject6;
                      if (i != 0) {
                        break label439;
                      }
                      arrayOfh[0] = localh2;
                      localObject5 = localObject2;
                      localObject1 = localh1;
                      paramp = localh2;
                      n = m;
                      localObject3 = localObject6;
                      break label439;
                    }
                  }
                }
              }
            }
            localObject1 = localObject3;
            int n = m;
            paramp = (p)localObject5;
            localObject5 = localObject2;
            for (;;)
            {
              label439:
              localObject2 = localObject5;
              localObject6 = localObject3;
              if (n >= k) {
                break;
              }
              paramp = paramp.a((h)localObject1);
              arrayOfh[n] = paramp;
              n++;
            }
          }
          locald.A(arrayOfh, i, k - i, (e)localObject2);
          localObject5 = arrayOfh;
        }
      }
      Object localObject3 = localObject4;
      if (paramBoolean)
      {
        if (localObject4 == null) {
          paramp = new h[k];
        }
        for (i = j;; i = m)
        {
          break;
          m = localObject4.length;
          i = m;
          paramp = (p)localObject4;
          if (m >= k) {
            break;
          }
          paramp = w.b((h[])localObject4, k);
        }
        for (;;)
        {
          localObject3 = paramp;
          if (i >= k) {
            break;
          }
          paramp[i] = localObject5[i].z();
          i++;
        }
      }
      paramp = new v();
      paramp.d((h[])localObject5);
      paramp.e((h[])localObject3);
      paramp.f((h)localObject6);
      return paramp;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */