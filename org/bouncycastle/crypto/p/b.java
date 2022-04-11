package org.bouncycastle.crypto.p;

import org.bouncycastle.crypto.h;
import org.bouncycastle.util.a;
import org.bouncycastle.util.f;

public class b
  implements h
{
  private static long[] a = { 1L, 32898L, -9223372036854742902L, -9223372034707259392L, 32907L, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138L, 136L, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778L, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L };
  protected long[] b = new long[25];
  protected byte[] c = new byte['À'];
  protected int d;
  protected int e;
  protected int f;
  protected boolean g;
  
  public b(int paramInt)
  {
    r(paramInt);
  }
  
  private void m(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.d;
    for (int j = 0; j < i >> 6; j++)
    {
      long[] arrayOfLong = this.b;
      arrayOfLong[j] ^= f.j(paramArrayOfByte, paramInt);
      paramInt += 8;
    }
    o();
  }
  
  private void n()
  {
    f.p(this.b, 0, this.d >> 6, this.c, 0);
  }
  
  private void o()
  {
    long[] arrayOfLong = this.b;
    int i = 0;
    long l1 = arrayOfLong[0];
    long l2 = arrayOfLong[1];
    long l3 = arrayOfLong[2];
    long l4 = arrayOfLong[3];
    long l5 = arrayOfLong[4];
    long l6 = arrayOfLong[5];
    long l7 = arrayOfLong[6];
    long l8 = arrayOfLong[7];
    long l9 = arrayOfLong[8];
    long l10 = arrayOfLong[9];
    long l11 = arrayOfLong[10];
    long l12 = arrayOfLong[11];
    long l13 = arrayOfLong[12];
    long l14 = arrayOfLong[13];
    long l15 = arrayOfLong[14];
    long l16 = arrayOfLong[15];
    long l17 = arrayOfLong[16];
    long l18 = arrayOfLong[17];
    long l19 = arrayOfLong[18];
    long l20 = arrayOfLong[19];
    long l21 = arrayOfLong[20];
    long l22 = arrayOfLong[21];
    long l23 = arrayOfLong[22];
    long l24 = arrayOfLong[23];
    long l25 = arrayOfLong[24];
    while (i < 24)
    {
      long l26 = l1 ^ l6 ^ l11 ^ l16 ^ l21;
      long l27 = l2 ^ l7 ^ l12 ^ l17 ^ l22;
      long l28 = l3 ^ l8 ^ l13 ^ l18 ^ l23;
      long l29 = l4 ^ l9 ^ l14 ^ l19 ^ l24;
      long l30 = l5 ^ l10 ^ l15 ^ l20 ^ l25;
      long l31 = (l27 << 1 | l27 >>> -1) ^ l30;
      long l32 = (l28 << 1 | l28 >>> -1) ^ l26;
      l27 = (l29 << 1 | l29 >>> -1) ^ l27;
      l28 = (l30 << 1 | l30 >>> -1) ^ l28;
      l26 = (l26 << 1 | l26 >>> -1) ^ l29;
      l1 ^= l31;
      l6 ^= l31;
      l11 ^= l31;
      l16 ^= l31;
      l21 ^= l31;
      l2 ^= l32;
      l7 ^= l32;
      l12 ^= l32;
      l17 ^= l32;
      l22 ^= l32;
      l3 ^= l27;
      l8 ^= l27;
      l13 ^= l27;
      l18 ^= l27;
      l27 = l23 ^ l27;
      l4 ^= l28;
      l23 = l9 ^ l28;
      l31 = l14 ^ l28;
      l14 = l19 ^ l28;
      l19 = l24 ^ l28;
      l32 = l5 ^ l26;
      l5 = l10 ^ l26;
      l24 = l15 ^ l26;
      l10 = l20 ^ l26;
      l29 = l25 ^ l26;
      l15 = l2 << 1 | l2 >>> 63;
      l26 = l7 << 44 | l7 >>> 20;
      l25 = l5 << 20 | l5 >>> 44;
      l5 = l27 << 61 | l27 >>> 3;
      l20 = l24 << 39 | l24 >>> 25;
      l9 = l21 << 18 | l21 >>> 46;
      l27 = l3 << 62 | l3 >>> 2;
      l28 = l13 << 43 | l13 >>> 21;
      l24 = l31 << 25 | l31 >>> 39;
      long l33 = l10 << 8 | l10 >>> 56;
      l19 = l19 << 56 | l19 >>> 8;
      l10 = l16 << 41 | l16 >>> 23;
      l2 = l32 << 27 | l32 >>> 37;
      l29 = l29 << 14 | l29 >>> 50;
      l32 = l22 << 2 | l22 >>> 62;
      l31 = l23 << 55 | l23 >>> 9;
      l16 = l17 << 45 | l17 >>> 19;
      l17 = l6 << 36 | l6 >>> 28;
      l6 = l4 << 28 | l4 >>> 36;
      l30 = l14 << 21 | l14 >>> 43;
      long l34 = l18 << 15 | l18 >>> 49;
      long l35 = l12 << 10 | l12 >>> 54;
      l18 = l8 << 6 | l8 >>> 58;
      long l36 = l11 << 3 | l11 >>> 61;
      l3 = l28 ^ (l30 ^ 0xFFFFFFFFFFFFFFFF) & l29;
      l4 = l30 ^ (l29 ^ 0xFFFFFFFFFFFFFFFF) & l1;
      l11 = l15 ^ (l18 ^ 0xFFFFFFFFFFFFFFFF) & l24;
      l21 = l27 ^ (l31 ^ 0xFFFFFFFFFFFFFFFF) & l20;
      long l37 = a[i];
      i++;
      l7 = (l36 ^ 0xFFFFFFFFFFFFFFFF) & l16 ^ l25;
      l13 = (l33 ^ 0xFFFFFFFFFFFFFFFF) & l9 ^ l24;
      l12 = (l24 ^ 0xFFFFFFFFFFFFFFFF) & l33 ^ l18;
      l14 = l33 ^ (l9 ^ 0xFFFFFFFFFFFFFFFF) & l15;
      l22 = (l20 ^ 0xFFFFFFFFFFFFFFFF) & l10 ^ l31;
      l24 = (l32 ^ 0xFFFFFFFFFFFFFFFF) & l27 ^ l10;
      l23 = l20 ^ (l10 ^ 0xFFFFFFFFFFFFFFFF) & l32;
      l10 = (l6 ^ 0xFFFFFFFFFFFFFFFF) & l25 ^ l5;
      l20 = (l2 ^ 0xFFFFFFFFFFFFFFFF) & l17 ^ l19;
      l15 = (l15 ^ 0xFFFFFFFFFFFFFFFF) & l18 ^ l9;
      l8 = (l16 ^ 0xFFFFFFFFFFFFFFFF) & l5 ^ l36;
      l9 = l16 ^ (l5 ^ 0xFFFFFFFFFFFFFFFF) & l6;
      l18 = l35 ^ (l34 ^ 0xFFFFFFFFFFFFFFFF) & l19;
      l16 = l2 ^ (l17 ^ 0xFFFFFFFFFFFFFFFF) & l35;
      l5 = l29 ^ (l1 ^ 0xFFFFFFFFFFFFFFFF) & l26;
      l6 ^= (l25 ^ 0xFFFFFFFFFFFFFFFF) & l36;
      l19 = (l19 ^ 0xFFFFFFFFFFFFFFFF) & l2 ^ l34;
      l17 = (l35 ^ 0xFFFFFFFFFFFFFFFF) & l34 ^ l17;
      l2 = (l28 ^ 0xFFFFFFFFFFFFFFFF) & l30 ^ l26;
      l25 = (l27 ^ 0xFFFFFFFFFFFFFFFF) & l31 ^ l32;
      l1 = (l26 ^ 0xFFFFFFFFFFFFFFFF) & l28 ^ l1 ^ l37;
    }
    arrayOfLong[0] = l1;
    arrayOfLong[1] = l2;
    arrayOfLong[2] = l3;
    arrayOfLong[3] = l4;
    arrayOfLong[4] = l5;
    arrayOfLong[5] = l6;
    arrayOfLong[6] = l7;
    arrayOfLong[7] = l8;
    arrayOfLong[8] = l9;
    arrayOfLong[9] = l10;
    arrayOfLong[10] = l11;
    arrayOfLong[11] = l12;
    arrayOfLong[12] = l13;
    arrayOfLong[13] = l14;
    arrayOfLong[14] = l15;
    arrayOfLong[15] = l16;
    arrayOfLong[16] = l17;
    arrayOfLong[17] = l18;
    arrayOfLong[18] = l19;
    arrayOfLong[19] = l20;
    arrayOfLong[20] = l21;
    arrayOfLong[21] = l22;
    arrayOfLong[22] = l23;
    arrayOfLong[23] = l24;
    arrayOfLong[24] = l25;
  }
  
  private void r(int paramInt)
  {
    if ((paramInt != 128) && (paramInt != 224) && (paramInt != 256) && (paramInt != 288) && (paramInt != 384) && (paramInt != 512)) {
      throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
    }
    s(1600 - (paramInt << 1));
  }
  
  private void s(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 1600) && (paramInt % 64 == 0))
    {
      this.d = paramInt;
      for (int i = 0;; i++)
      {
        long[] arrayOfLong = this.b;
        if (i >= arrayOfLong.length) {
          break;
        }
        arrayOfLong[i] = 0L;
      }
      a.u(this.c, (byte)0);
      this.e = 0;
      this.g = false;
      this.f = ((1600 - paramInt) / 2);
      return;
    }
    throw new IllegalStateException("invalid rate value");
  }
  
  private void t()
  {
    Object localObject = this.c;
    int i = this.e;
    int j = i >> 3;
    localObject[j] = ((byte)(byte)(localObject[j] | (byte)(int)(1L << (i & 0x7))));
    int k = i + 1;
    this.e = k;
    i = this.d;
    j = 0;
    if (k == i)
    {
      m((byte[])localObject, 0);
      this.e = 0;
    }
    i = this.e;
    k = i >> 6;
    int m = i & 0x3F;
    i = 0;
    while (j < k)
    {
      localObject = this.b;
      localObject[j] ^= f.j(this.c, i);
      i += 8;
      j++;
    }
    if (m > 0)
    {
      localObject = this.b;
      localObject[k] ^= f.j(this.c, i) & (1L << m) - 1L;
    }
    localObject = this.b;
    j = this.d - 1 >> 6;
    localObject[j] ^= 0x8000000000000000;
    o();
    n();
    this.e = this.d;
    this.g = true;
  }
  
  public void c(byte paramByte)
  {
    p(new byte[] { paramByte }, 0, 1);
  }
  
  public int e()
  {
    return this.f / 8;
  }
  
  public int k()
  {
    return this.d / 8;
  }
  
  protected void p(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.e;
    if (i % 8 == 0)
    {
      if (!this.g)
      {
        int j = i >> 3;
        int k = this.d >> 3;
        i = 0;
        while (i < paramInt2)
        {
          if (j == 0)
          {
            m = paramInt2 - k;
            if (i <= m)
            {
              do
              {
                m(paramArrayOfByte, paramInt1 + i);
                n = i + k;
                i = n;
              } while (n <= m);
              i = n;
              continue;
            }
          }
          int n = Math.min(k - j, paramInt2 - i);
          System.arraycopy(paramArrayOfByte, paramInt1 + i, this.c, j, n);
          int m = j + n;
          n = i + n;
          j = m;
          i = n;
          if (m == k)
          {
            m(this.c, 0);
            j = 0;
            i = n;
          }
        }
        this.e = (j << 3);
        return;
      }
      throw new IllegalStateException("attempt to absorb while squeezing");
    }
    throw new IllegalStateException("attempt to absorb with odd length queue");
  }
  
  protected void q(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 1) && (paramInt2 <= 7))
    {
      int i = this.e;
      if (i % 8 == 0)
      {
        if (!this.g)
        {
          this.c[(i >> 3)] = ((byte)(byte)(paramInt1 & (1 << paramInt2) - 1));
          this.e = (i + paramInt2);
          return;
        }
        throw new IllegalStateException("attempt to absorb while squeezing");
      }
      throw new IllegalStateException("attempt to absorb with odd length queue");
    }
    throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
  }
  
  public void reset()
  {
    r(this.f);
  }
  
  protected void u(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    if (!this.g) {
      t();
    }
    long l = 0L;
    if (paramLong % 8L == 0L)
    {
      while (l < paramLong)
      {
        if (this.e == 0)
        {
          o();
          n();
          this.e = this.d;
        }
        int i = (int)Math.min(this.e, paramLong - l);
        System.arraycopy(this.c, (this.d - this.e) / 8, paramArrayOfByte, (int)(l / 8L) + paramInt, i / 8);
        this.e -= i;
        l += i;
      }
      return;
    }
    throw new IllegalStateException("outputLength not a multiple of 8");
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    p(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\p\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */