package e.a.b.c;

import java.math.BigInteger;
import org.bouncycastle.util.f;

public abstract class g
{
  public static int A(int paramInt1, long paramLong, int[] paramArrayOfInt, int paramInt2)
  {
    long l1 = paramInt1 & 0xFFFFFFFF;
    long l2 = paramLong & 0xFFFFFFFF;
    paramInt1 = paramInt2 + 0;
    long l3 = l1 * l2 + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt[paramInt1] = ((int)l3);
    paramLong >>>= 32;
    paramInt1 = paramInt2 + 1;
    l2 = (l3 >>> 32) + (l1 * paramLong + l2 + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt[paramInt1] = ((int)l2);
    paramInt1 = paramInt2 + 2;
    paramLong = (l2 >>> 32) + (paramLong + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt[paramInt1] = ((int)paramLong);
    paramInt1 = paramInt2 + 3;
    paramLong = (paramLong >>> 32) + (0xFFFFFFFF & paramArrayOfInt[paramInt1]);
    paramArrayOfInt[paramInt1] = ((int)paramLong);
    if (paramLong >>> 32 == 0L) {
      paramInt1 = 0;
    } else {
      paramInt1 = m.u(8, paramArrayOfInt, paramInt2, 4);
    }
    return paramInt1;
  }
  
  public static int B(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    long l1 = paramInt1;
    long l2 = paramInt2 & 0xFFFFFFFF;
    paramInt1 = paramInt3 + 0;
    l1 = (l1 & 0xFFFFFFFF) * l2 + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt[paramInt1] = ((int)l1);
    paramInt1 = paramInt3 + 1;
    l2 = (l1 >>> 32) + (l2 + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt[paramInt1] = ((int)l2);
    paramInt1 = paramInt3 + 2;
    l2 = (l2 >>> 32) + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF);
    paramArrayOfInt[paramInt1] = ((int)l2);
    if (l2 >>> 32 == 0L) {
      paramInt1 = 0;
    } else {
      paramInt1 = m.u(8, paramArrayOfInt, paramInt3, 3);
    }
    return paramInt1;
  }
  
  public static int C(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l1 = paramArrayOfInt2[0];
    long l2 = paramArrayOfInt2[1] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt2[2];
    long l4 = paramArrayOfInt2[3];
    long l5 = paramArrayOfInt2[4];
    long l6 = paramArrayOfInt2[5] & 0xFFFFFFFF;
    long l7 = paramArrayOfInt2[6];
    long l8 = paramArrayOfInt2[7] & 0xFFFFFFFF;
    long l9 = 0L;
    int j;
    for (int i = 0; i < 8; i = j)
    {
      long l10 = paramArrayOfInt1[i] & 0xFFFFFFFF;
      j = i + 0;
      long l11 = l10 * (l1 & 0xFFFFFFFF) + (paramArrayOfInt3[j] & 0xFFFFFFFF) + 0L;
      paramArrayOfInt3[j] = ((int)l11);
      j = i + 1;
      l11 = (l11 >>> 32) + (l10 * l2 + (paramArrayOfInt3[j] & 0xFFFFFFFF));
      paramArrayOfInt3[j] = ((int)l11);
      int k = i + 2;
      l11 = (l11 >>> 32) + (l10 * (l3 & 0xFFFFFFFF) + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l11);
      k = i + 3;
      l11 = (l11 >>> 32) + (l10 * (l4 & 0xFFFFFFFF) + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l11);
      k = i + 4;
      l11 = (l11 >>> 32) + (l10 * (l5 & 0xFFFFFFFF) + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l11);
      k = i + 5;
      l11 = (l11 >>> 32) + (l10 * l6 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l11);
      k = i + 6;
      l11 = (l11 >>> 32) + (l10 * (l7 & 0xFFFFFFFF) + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l11);
      k = i + 7;
      l10 = (l11 >>> 32) + (l10 * l8 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l10);
      i += 8;
      l9 = (l10 >>> 32) + (l9 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l9);
      l9 >>>= 32;
    }
    return (int)l9;
  }
  
  public static int D(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l1 = paramInt & 0xFFFFFFFF;
    long l2 = (paramArrayOfInt2[0] & 0xFFFFFFFF) * l1 + (paramArrayOfInt1[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt2[0] = ((int)l2);
    l2 = (l2 >>> 32) + ((paramArrayOfInt2[1] & 0xFFFFFFFF) * l1 + (paramArrayOfInt1[1] & 0xFFFFFFFF));
    paramArrayOfInt2[1] = ((int)l2);
    l2 = (l2 >>> 32) + ((paramArrayOfInt2[2] & 0xFFFFFFFF) * l1 + (paramArrayOfInt1[2] & 0xFFFFFFFF));
    paramArrayOfInt2[2] = ((int)l2);
    l2 = (l2 >>> 32) + ((paramArrayOfInt2[3] & 0xFFFFFFFF) * l1 + (paramArrayOfInt1[3] & 0xFFFFFFFF));
    paramArrayOfInt2[3] = ((int)l2);
    l2 = (l2 >>> 32) + ((paramArrayOfInt2[4] & 0xFFFFFFFF) * l1 + (paramArrayOfInt1[4] & 0xFFFFFFFF));
    paramArrayOfInt2[4] = ((int)l2);
    l2 = (l2 >>> 32) + ((paramArrayOfInt2[5] & 0xFFFFFFFF) * l1 + (paramArrayOfInt1[5] & 0xFFFFFFFF));
    paramArrayOfInt2[5] = ((int)l2);
    l2 = (l2 >>> 32) + ((paramArrayOfInt2[6] & 0xFFFFFFFF) * l1 + (paramArrayOfInt1[6] & 0xFFFFFFFF));
    paramArrayOfInt2[6] = ((int)l2);
    l1 = (l2 >>> 32) + (l1 * (paramArrayOfInt2[7] & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt1[7]));
    paramArrayOfInt2[7] = ((int)l1);
    return (int)(l1 >>> 32);
  }
  
  public static void E(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    long l1 = paramArrayOfInt1[(paramInt1 + 0)] & 0xFFFFFFFF;
    int i = 0;
    int j = 16;
    int m;
    for (int k = 7;; k = m)
    {
      m = k - 1;
      long l2 = paramArrayOfInt1[(paramInt1 + k)] & 0xFFFFFFFF;
      l2 *= l2;
      j--;
      paramArrayOfInt2[(paramInt2 + j)] = (i << 31 | (int)(l2 >>> 33));
      j--;
      paramArrayOfInt2[(paramInt2 + j)] = ((int)(l2 >>> 1));
      i = (int)l2;
      if (m <= 0)
      {
        long l3 = l1 * l1;
        long l4 = i << 31;
        paramArrayOfInt2[(paramInt2 + 0)] = ((int)l3);
        i = (int)(l3 >>> 32);
        l2 = paramArrayOfInt1[(paramInt1 + 1)] & 0xFFFFFFFF;
        int n = paramInt2 + 2;
        long l5 = paramArrayOfInt2[n];
        long l6 = (l4 & 0xFFFFFFFF | l3 >>> 33) + l2 * l1;
        k = (int)l6;
        paramArrayOfInt2[(paramInt2 + 1)] = (k << 1 | i & 0x1);
        l4 = paramArrayOfInt1[(paramInt1 + 2)] & 0xFFFFFFFF;
        i = paramInt2 + 3;
        long l7 = paramArrayOfInt2[i];
        j = paramInt2 + 4;
        l3 = paramArrayOfInt2[j];
        l5 = (l5 & 0xFFFFFFFF) + (l6 >>> 32) + l4 * l1;
        m = (int)l5;
        paramArrayOfInt2[n] = (m << 1 | k >>> 31);
        long l8 = (l7 & 0xFFFFFFFF) + ((l5 >>> 32) + l4 * l2);
        l6 = (l3 & 0xFFFFFFFF) + (l8 >>> 32);
        l5 = paramArrayOfInt1[(paramInt1 + 3)] & 0xFFFFFFFF;
        k = paramInt2 + 5;
        l3 = (paramArrayOfInt2[k] & 0xFFFFFFFF) + (l6 >>> 32);
        int i1 = paramInt2 + 6;
        l7 = paramArrayOfInt2[i1];
        l8 = (l8 & 0xFFFFFFFF) + l5 * l1;
        n = (int)l8;
        paramArrayOfInt2[i] = (n << 1 | m >>> 31);
        long l9 = (l6 & 0xFFFFFFFF) + ((l8 >>> 32) + l5 * l2);
        l8 = (l3 & 0xFFFFFFFF) + ((l9 >>> 32) + l5 * l4);
        long l10 = (l7 & 0xFFFFFFFF) + (l3 >>> 32) + (l8 >>> 32);
        l3 = paramArrayOfInt1[(paramInt1 + 4)] & 0xFFFFFFFF;
        int i2 = paramInt2 + 7;
        l7 = (paramArrayOfInt2[i2] & 0xFFFFFFFF) + (l10 >>> 32);
        i = paramInt2 + 8;
        l6 = paramArrayOfInt2[i];
        l9 = (l9 & 0xFFFFFFFF) + l3 * l1;
        m = (int)l9;
        paramArrayOfInt2[j] = (n >>> 31 | m << 1);
        long l11 = (l8 & 0xFFFFFFFF) + ((l9 >>> 32) + l3 * l2);
        l10 = (l10 & 0xFFFFFFFF) + ((l11 >>> 32) + l3 * l4);
        l9 = (l7 & 0xFFFFFFFF) + ((l10 >>> 32) + l3 * l5);
        long l12 = (l6 & 0xFFFFFFFF) + (l7 >>> 32) + (l9 >>> 32);
        l7 = paramArrayOfInt1[(paramInt1 + 5)] & 0xFFFFFFFF;
        n = paramInt2 + 9;
        l6 = (paramArrayOfInt2[n] & 0xFFFFFFFF) + (l12 >>> 32);
        j = paramInt2 + 10;
        l8 = paramArrayOfInt2[j];
        l11 = (l11 & 0xFFFFFFFF) + l7 * l1;
        int i3 = (int)l11;
        paramArrayOfInt2[k] = (m >>> 31 | i3 << 1);
        long l13 = (l10 & 0xFFFFFFFF) + ((l11 >>> 32) + l7 * l2);
        long l14 = (l9 & 0xFFFFFFFF) + ((l13 >>> 32) + l7 * l4);
        l12 = (l12 & 0xFFFFFFFF) + ((l14 >>> 32) + l7 * l5);
        l10 = (l6 & 0xFFFFFFFF) + ((l12 >>> 32) + l7 * l3);
        l11 = (l8 & 0xFFFFFFFF) + (l6 >>> 32) + (l10 >>> 32);
        l6 = paramArrayOfInt1[(paramInt1 + 6)] & 0xFFFFFFFF;
        m = paramInt2 + 11;
        l8 = (paramArrayOfInt2[m] & 0xFFFFFFFF) + (l11 >>> 32);
        k = paramInt2 + 12;
        l9 = paramArrayOfInt2[k];
        l13 = (l13 & 0xFFFFFFFF) + l6 * l1;
        int i4 = (int)l13;
        paramArrayOfInt2[i1] = (i3 >>> 31 | i4 << 1);
        long l15 = (l14 & 0xFFFFFFFF) + ((l13 >>> 32) + l6 * l2);
        l12 = (l12 & 0xFFFFFFFF) + ((l15 >>> 32) + l6 * l4);
        long l16 = (l10 & 0xFFFFFFFF) + ((l12 >>> 32) + l6 * l5);
        l13 = (l11 & 0xFFFFFFFF) + ((l16 >>> 32) + l6 * l3);
        l10 = (l8 & 0xFFFFFFFF) + ((l13 >>> 32) + l6 * l7);
        l14 = (l9 & 0xFFFFFFFF) + (l8 >>> 32) + (l10 >>> 32);
        l11 = paramArrayOfInt1[(paramInt1 + 7)] & 0xFFFFFFFF;
        i1 = paramInt2 + 13;
        l8 = (paramArrayOfInt2[i1] & 0xFFFFFFFF) + (l14 >>> 32);
        paramInt1 = paramInt2 + 14;
        l9 = paramArrayOfInt2[paramInt1];
        l1 = (l15 & 0xFFFFFFFF) + l1 * l11;
        i3 = (int)l1;
        paramArrayOfInt2[i2] = (i3 << 1 | i4 >>> 31);
        l1 = (l12 & 0xFFFFFFFF) + ((l1 >>> 32) + l11 * l2);
        l2 = (l16 & 0xFFFFFFFF) + ((l1 >>> 32) + l11 * l4);
        l4 = (l13 & 0xFFFFFFFF) + ((l2 >>> 32) + l11 * l5);
        l5 = (l10 & 0xFFFFFFFF) + ((l4 >>> 32) + l11 * l3);
        l3 = (l14 & 0xFFFFFFFF) + ((l5 >>> 32) + l11 * l7);
        l7 = (l8 & 0xFFFFFFFF) + ((l3 >>> 32) + l11 * l6);
        l6 = (l9 & 0xFFFFFFFF) + (l8 >>> 32) + (l7 >>> 32);
        i2 = (int)l1;
        paramArrayOfInt2[i] = (i3 >>> 31 | i2 << 1);
        i = (int)l2;
        paramArrayOfInt2[n] = (i2 >>> 31 | i << 1);
        n = (int)l4;
        paramArrayOfInt2[j] = (i >>> 31 | n << 1);
        i = (int)l5;
        paramArrayOfInt2[m] = (n >>> 31 | i << 1);
        j = (int)l3;
        paramArrayOfInt2[k] = (i >>> 31 | j << 1);
        i = (int)l7;
        paramArrayOfInt2[i1] = (j >>> 31 | i << 1);
        j = (int)l6;
        paramArrayOfInt2[paramInt1] = (i >>> 31 | j << 1);
        paramInt1 = paramInt2 + 15;
        paramArrayOfInt2[paramInt1] = (j >>> 31 | paramArrayOfInt2[paramInt1] + (int)(l6 >>> 32) << 1);
        return;
      }
    }
  }
  
  public static void F(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l1 = paramArrayOfInt1[0] & 0xFFFFFFFF;
    int i = 16;
    int j = 7;
    int k = 0;
    for (;;)
    {
      int m = j - 1;
      long l2 = paramArrayOfInt1[j] & 0xFFFFFFFF;
      l2 *= l2;
      i--;
      paramArrayOfInt2[i] = (k << 31 | (int)(l2 >>> 33));
      i--;
      paramArrayOfInt2[i] = ((int)(l2 >>> 1));
      k = (int)l2;
      if (m <= 0)
      {
        long l3 = l1 * l1;
        long l4 = k << 31;
        paramArrayOfInt2[0] = ((int)l3);
        i = (int)(l3 >>> 32);
        l2 = paramArrayOfInt1[1] & 0xFFFFFFFF;
        long l5 = paramArrayOfInt2[2];
        long l6 = (l4 & 0xFFFFFFFF | l3 >>> 33) + l2 * l1;
        k = (int)l6;
        paramArrayOfInt2[1] = (k << 1 | i & 0x1);
        l4 = paramArrayOfInt1[2] & 0xFFFFFFFF;
        long l7 = paramArrayOfInt2[3];
        l3 = paramArrayOfInt2[4];
        l5 = (l5 & 0xFFFFFFFF) + (l6 >>> 32) + l4 * l1;
        i = (int)l5;
        paramArrayOfInt2[2] = (i << 1 | k >>> 31);
        l6 = (l7 & 0xFFFFFFFF) + ((l5 >>> 32) + l4 * l2);
        long l8 = (l3 & 0xFFFFFFFF) + (l6 >>> 32);
        l5 = paramArrayOfInt1[3] & 0xFFFFFFFF;
        l7 = (paramArrayOfInt2[5] & 0xFFFFFFFF) + (l8 >>> 32);
        l3 = paramArrayOfInt2[6];
        l6 = (l6 & 0xFFFFFFFF) + l5 * l1;
        k = (int)l6;
        paramArrayOfInt2[3] = (k << 1 | i >>> 31);
        long l9 = (l8 & 0xFFFFFFFF) + ((l6 >>> 32) + l5 * l2);
        l8 = (l7 & 0xFFFFFFFF) + ((l9 >>> 32) + l5 * l4);
        long l10 = (l3 & 0xFFFFFFFF) + (l7 >>> 32) + (l8 >>> 32);
        l3 = paramArrayOfInt1[4] & 0xFFFFFFFF;
        l6 = (paramArrayOfInt2[7] & 0xFFFFFFFF) + (l10 >>> 32);
        l7 = paramArrayOfInt2[8];
        l9 = (l9 & 0xFFFFFFFF) + l3 * l1;
        j = (int)l9;
        paramArrayOfInt2[4] = (j << 1 | k >>> 31);
        long l11 = (l8 & 0xFFFFFFFF) + ((l9 >>> 32) + l3 * l2);
        long l12 = (l10 & 0xFFFFFFFF) + ((l11 >>> 32) + l3 * l4);
        l10 = (l6 & 0xFFFFFFFF) + ((l12 >>> 32) + l3 * l5);
        l9 = (l7 & 0xFFFFFFFF) + (l6 >>> 32) + (l10 >>> 32);
        l7 = paramArrayOfInt1[5] & 0xFFFFFFFF;
        l8 = (paramArrayOfInt2[9] & 0xFFFFFFFF) + (l9 >>> 32);
        l6 = paramArrayOfInt2[10];
        l11 = (l11 & 0xFFFFFFFF) + l7 * l1;
        i = (int)l11;
        paramArrayOfInt2[5] = (i << 1 | j >>> 31);
        long l13 = (l12 & 0xFFFFFFFF) + ((l11 >>> 32) + l7 * l2);
        long l14 = (l10 & 0xFFFFFFFF) + ((l13 >>> 32) + l7 * l4);
        l12 = (l9 & 0xFFFFFFFF) + ((l14 >>> 32) + l7 * l5);
        l9 = (l8 & 0xFFFFFFFF) + ((l12 >>> 32) + l7 * l3);
        l11 = (l6 & 0xFFFFFFFF) + (l8 >>> 32) + (l9 >>> 32);
        l6 = paramArrayOfInt1[6] & 0xFFFFFFFF;
        l8 = (paramArrayOfInt2[11] & 0xFFFFFFFF) + (l11 >>> 32);
        l10 = paramArrayOfInt2[12];
        l13 = (l13 & 0xFFFFFFFF) + l6 * l1;
        k = (int)l13;
        paramArrayOfInt2[6] = (k << 1 | i >>> 31);
        l14 = (l14 & 0xFFFFFFFF) + ((l13 >>> 32) + l6 * l2);
        long l15 = (l12 & 0xFFFFFFFF) + ((l14 >>> 32) + l6 * l4);
        l13 = (l9 & 0xFFFFFFFF) + ((l15 >>> 32) + l6 * l5);
        l11 = (l11 & 0xFFFFFFFF) + ((l13 >>> 32) + l6 * l3);
        l9 = (l8 & 0xFFFFFFFF) + ((l11 >>> 32) + l6 * l7);
        long l16 = (l10 & 0xFFFFFFFF) + (l8 >>> 32) + (l9 >>> 32);
        l12 = paramArrayOfInt1[7] & 0xFFFFFFFF;
        l10 = (paramArrayOfInt2[13] & 0xFFFFFFFF) + (l16 >>> 32);
        l8 = paramArrayOfInt2[14];
        l1 = (l14 & 0xFFFFFFFF) + l1 * l12;
        i = (int)l1;
        paramArrayOfInt2[7] = (k >>> 31 | i << 1);
        l1 = (l15 & 0xFFFFFFFF) + ((l1 >>> 32) + l12 * l2);
        l2 = (l13 & 0xFFFFFFFF) + ((l1 >>> 32) + l12 * l4);
        l4 = (l11 & 0xFFFFFFFF) + ((l2 >>> 32) + l12 * l5);
        l5 = (l9 & 0xFFFFFFFF) + ((l4 >>> 32) + l12 * l3);
        l3 = (l16 & 0xFFFFFFFF) + ((l5 >>> 32) + l12 * l7);
        l7 = (0xFFFFFFFF & l10) + ((l3 >>> 32) + l12 * l6);
        l6 = (l8 & 0xFFFFFFFF) + (l10 >>> 32) + (l7 >>> 32);
        k = (int)l1;
        paramArrayOfInt2[8] = (i >>> 31 | k << 1);
        j = (int)l2;
        paramArrayOfInt2[9] = (k >>> 31 | j << 1);
        i = (int)l4;
        paramArrayOfInt2[10] = (j >>> 31 | i << 1);
        k = (int)l5;
        paramArrayOfInt2[11] = (i >>> 31 | k << 1);
        i = (int)l3;
        paramArrayOfInt2[12] = (k >>> 31 | i << 1);
        k = (int)l7;
        paramArrayOfInt2[13] = (i >>> 31 | k << 1);
        i = (int)l6;
        paramArrayOfInt2[14] = (k >>> 31 | i << 1);
        paramArrayOfInt2[15] = (i >>> 31 | paramArrayOfInt2[15] + (int)(l6 >>> 32) << 1);
        return;
      }
      j = m;
    }
  }
  
  public static int G(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int[] paramArrayOfInt3, int paramInt3)
  {
    long l = (paramArrayOfInt1[(paramInt1 + 0)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 0)] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[(paramInt3 + 0)] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[(paramInt1 + 1)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 1)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt3 + 1)] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[(paramInt1 + 2)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 2)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt3 + 2)] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[(paramInt1 + 3)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 3)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt3 + 3)] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[(paramInt1 + 4)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 4)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt3 + 4)] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[(paramInt1 + 5)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 5)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt3 + 5)] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[(paramInt1 + 6)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 6)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt3 + 6)] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[(paramInt1 + 7)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 7)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt3 + 7)] = ((int)l);
    return (int)(l >> 32);
  }
  
  public static int H(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = (paramArrayOfInt1[0] & 0xFFFFFFFF) - (paramArrayOfInt2[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[0] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) - (paramArrayOfInt2[1] & 0xFFFFFFFF));
    paramArrayOfInt3[1] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) - (paramArrayOfInt2[2] & 0xFFFFFFFF));
    paramArrayOfInt3[2] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) - (paramArrayOfInt2[3] & 0xFFFFFFFF));
    paramArrayOfInt3[3] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) - (paramArrayOfInt2[4] & 0xFFFFFFFF));
    paramArrayOfInt3[4] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) - (paramArrayOfInt2[5] & 0xFFFFFFFF));
    paramArrayOfInt3[5] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[6] & 0xFFFFFFFF) - (paramArrayOfInt2[6] & 0xFFFFFFFF));
    paramArrayOfInt3[6] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[7] & 0xFFFFFFFF) - (paramArrayOfInt2[7] & 0xFFFFFFFF));
    paramArrayOfInt3[7] = ((int)l);
    return (int)(l >> 32);
  }
  
  public static int I(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l = (paramArrayOfInt2[0] & 0xFFFFFFFF) - (paramArrayOfInt1[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt2[0] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[1] & 0xFFFFFFFF) - (paramArrayOfInt1[1] & 0xFFFFFFFF));
    paramArrayOfInt2[1] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[2] & 0xFFFFFFFF) - (paramArrayOfInt1[2] & 0xFFFFFFFF));
    paramArrayOfInt2[2] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[3] & 0xFFFFFFFF) - (paramArrayOfInt1[3] & 0xFFFFFFFF));
    paramArrayOfInt2[3] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[4] & 0xFFFFFFFF) - (paramArrayOfInt1[4] & 0xFFFFFFFF));
    paramArrayOfInt2[4] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[5] & 0xFFFFFFFF) - (paramArrayOfInt1[5] & 0xFFFFFFFF));
    paramArrayOfInt2[5] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[6] & 0xFFFFFFFF) - (paramArrayOfInt1[6] & 0xFFFFFFFF));
    paramArrayOfInt2[6] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[7] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt1[7]));
    paramArrayOfInt2[7] = ((int)l);
    return (int)(l >> 32);
  }
  
  public static BigInteger J(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[32];
    for (int i = 0; i < 8; i++)
    {
      int j = paramArrayOfInt[i];
      if (j != 0) {
        f.d(j, arrayOfByte, 7 - i << 2);
      }
    }
    return new BigInteger(1, arrayOfByte);
  }
  
  public static BigInteger K(long[] paramArrayOfLong)
  {
    byte[] arrayOfByte = new byte[32];
    for (int i = 0; i < 4; i++)
    {
      long l = paramArrayOfLong[i];
      if (l != 0L) {
        f.l(l, arrayOfByte, 3 - i << 3);
      }
    }
    return new BigInteger(1, arrayOfByte);
  }
  
  public static void L(int[] paramArrayOfInt)
  {
    paramArrayOfInt[0] = 0;
    paramArrayOfInt[1] = 0;
    paramArrayOfInt[2] = 0;
    paramArrayOfInt[3] = 0;
    paramArrayOfInt[4] = 0;
    paramArrayOfInt[5] = 0;
    paramArrayOfInt[6] = 0;
    paramArrayOfInt[7] = 0;
  }
  
  public static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = (paramArrayOfInt1[0] & 0xFFFFFFFF) + (paramArrayOfInt2[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[0] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + (paramArrayOfInt2[1] & 0xFFFFFFFF));
    paramArrayOfInt3[1] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) + (paramArrayOfInt2[2] & 0xFFFFFFFF));
    paramArrayOfInt3[2] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + (paramArrayOfInt2[3] & 0xFFFFFFFF));
    paramArrayOfInt3[3] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + (paramArrayOfInt2[4] & 0xFFFFFFFF));
    paramArrayOfInt3[4] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) + (paramArrayOfInt2[5] & 0xFFFFFFFF));
    paramArrayOfInt3[5] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[6] & 0xFFFFFFFF) + (paramArrayOfInt2[6] & 0xFFFFFFFF));
    paramArrayOfInt3[6] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[7] & 0xFFFFFFFF) + (paramArrayOfInt2[7] & 0xFFFFFFFF));
    paramArrayOfInt3[7] = ((int)l);
    return (int)(l >>> 32);
  }
  
  public static int b(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = (paramArrayOfInt1[0] & 0xFFFFFFFF) + (paramArrayOfInt2[0] & 0xFFFFFFFF) + (paramArrayOfInt3[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[0] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + (paramArrayOfInt2[1] & 0xFFFFFFFF) + (paramArrayOfInt3[1] & 0xFFFFFFFF));
    paramArrayOfInt3[1] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) + (paramArrayOfInt2[2] & 0xFFFFFFFF) + (paramArrayOfInt3[2] & 0xFFFFFFFF));
    paramArrayOfInt3[2] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + (paramArrayOfInt2[3] & 0xFFFFFFFF) + (paramArrayOfInt3[3] & 0xFFFFFFFF));
    paramArrayOfInt3[3] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + (paramArrayOfInt2[4] & 0xFFFFFFFF) + (paramArrayOfInt3[4] & 0xFFFFFFFF));
    paramArrayOfInt3[4] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) + (paramArrayOfInt2[5] & 0xFFFFFFFF) + (paramArrayOfInt3[5] & 0xFFFFFFFF));
    paramArrayOfInt3[5] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[6] & 0xFFFFFFFF) + (paramArrayOfInt2[6] & 0xFFFFFFFF) + (paramArrayOfInt3[6] & 0xFFFFFFFF));
    paramArrayOfInt3[6] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[7] & 0xFFFFFFFF) + (paramArrayOfInt2[7] & 0xFFFFFFFF) + (paramArrayOfInt3[7] & 0xFFFFFFFF));
    paramArrayOfInt3[7] = ((int)l);
    return (int)(l >>> 32);
  }
  
  public static int c(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3)
  {
    long l1 = paramInt3;
    long l2 = paramArrayOfInt1[(paramInt1 + 0)];
    paramInt3 = paramInt2 + 0;
    l2 = (l1 & 0xFFFFFFFF) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[paramInt3] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt3] = ((int)l2);
    l1 = paramArrayOfInt1[(paramInt1 + 1)];
    paramInt3 = paramInt2 + 1;
    l2 = (l2 >>> 32) + ((l1 & 0xFFFFFFFF) + (paramArrayOfInt2[paramInt3] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt3] = ((int)l2);
    l1 = paramArrayOfInt1[(paramInt1 + 2)];
    paramInt3 = paramInt2 + 2;
    l2 = (l2 >>> 32) + ((l1 & 0xFFFFFFFF) + (paramArrayOfInt2[paramInt3] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt3] = ((int)l2);
    l1 = paramArrayOfInt1[(paramInt1 + 3)];
    paramInt3 = paramInt2 + 3;
    l2 = (l2 >>> 32) + ((l1 & 0xFFFFFFFF) + (paramArrayOfInt2[paramInt3] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt3] = ((int)l2);
    l1 = paramArrayOfInt1[(paramInt1 + 4)];
    paramInt3 = paramInt2 + 4;
    l1 = (l2 >>> 32) + ((l1 & 0xFFFFFFFF) + (paramArrayOfInt2[paramInt3] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt3] = ((int)l1);
    l2 = paramArrayOfInt1[(paramInt1 + 5)];
    paramInt3 = paramInt2 + 5;
    l2 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[paramInt3] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt3] = ((int)l2);
    l1 = paramArrayOfInt1[(paramInt1 + 6)];
    paramInt3 = paramInt2 + 6;
    l2 = (l2 >>> 32) + ((l1 & 0xFFFFFFFF) + (paramArrayOfInt2[paramInt3] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt3] = ((int)l2);
    l1 = paramArrayOfInt1[(paramInt1 + 7)];
    paramInt1 = paramInt2 + 7;
    l1 = (l2 >>> 32) + ((l1 & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt2[paramInt1]));
    paramArrayOfInt2[paramInt1] = ((int)l1);
    return (int)(l1 >>> 32);
  }
  
  public static int d(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l = (paramArrayOfInt1[0] & 0xFFFFFFFF) + (paramArrayOfInt2[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt2[0] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + (paramArrayOfInt2[1] & 0xFFFFFFFF));
    paramArrayOfInt2[1] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) + (paramArrayOfInt2[2] & 0xFFFFFFFF));
    paramArrayOfInt2[2] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + (paramArrayOfInt2[3] & 0xFFFFFFFF));
    paramArrayOfInt2[3] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + (paramArrayOfInt2[4] & 0xFFFFFFFF));
    paramArrayOfInt2[4] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) + (paramArrayOfInt2[5] & 0xFFFFFFFF));
    paramArrayOfInt2[5] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[6] & 0xFFFFFFFF) + (paramArrayOfInt2[6] & 0xFFFFFFFF));
    paramArrayOfInt2[6] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[7] & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt2[7]));
    paramArrayOfInt2[7] = ((int)l);
    return (int)(l >>> 32);
  }
  
  public static int e(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    int i = paramInt1 + 0;
    long l1 = paramArrayOfInt1[i];
    int j = paramInt2 + 0;
    l1 = (l1 & 0xFFFFFFFF) + (paramArrayOfInt2[j] & 0xFFFFFFFF) + 0L;
    int k = (int)l1;
    paramArrayOfInt1[i] = k;
    paramArrayOfInt2[j] = k;
    i = paramInt1 + 1;
    long l2 = paramArrayOfInt1[i];
    k = paramInt2 + 1;
    l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[k] & 0xFFFFFFFF));
    j = (int)l1;
    paramArrayOfInt1[i] = j;
    paramArrayOfInt2[k] = j;
    j = paramInt1 + 2;
    l2 = paramArrayOfInt1[j];
    k = paramInt2 + 2;
    l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[k] & 0xFFFFFFFF));
    i = (int)l1;
    paramArrayOfInt1[j] = i;
    paramArrayOfInt2[k] = i;
    k = paramInt1 + 3;
    l2 = paramArrayOfInt1[k];
    i = paramInt2 + 3;
    l2 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[i] & 0xFFFFFFFF));
    j = (int)l2;
    paramArrayOfInt1[k] = j;
    paramArrayOfInt2[i] = j;
    j = paramInt1 + 4;
    l1 = paramArrayOfInt1[j];
    k = paramInt2 + 4;
    l1 = (l2 >>> 32) + ((l1 & 0xFFFFFFFF) + (paramArrayOfInt2[k] & 0xFFFFFFFF));
    i = (int)l1;
    paramArrayOfInt1[j] = i;
    paramArrayOfInt2[k] = i;
    k = paramInt1 + 5;
    l2 = paramArrayOfInt1[k];
    j = paramInt2 + 5;
    l2 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[j] & 0xFFFFFFFF));
    i = (int)l2;
    paramArrayOfInt1[k] = i;
    paramArrayOfInt2[j] = i;
    k = paramInt1 + 6;
    l1 = paramArrayOfInt1[k];
    i = paramInt2 + 6;
    l1 = (l2 >>> 32) + ((l1 & 0xFFFFFFFF) + (paramArrayOfInt2[i] & 0xFFFFFFFF));
    j = (int)l1;
    paramArrayOfInt1[k] = j;
    paramArrayOfInt2[i] = j;
    paramInt1 += 7;
    l2 = paramArrayOfInt1[paramInt1];
    paramInt2 += 7;
    l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt2[paramInt2]));
    k = (int)l1;
    paramArrayOfInt1[paramInt1] = k;
    paramArrayOfInt2[paramInt2] = k;
    return (int)(l1 >>> 32);
  }
  
  public static void f(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    paramArrayOfInt2[(paramInt2 + 0)] = paramArrayOfInt1[(paramInt1 + 0)];
    paramArrayOfInt2[(paramInt2 + 1)] = paramArrayOfInt1[(paramInt1 + 1)];
    paramArrayOfInt2[(paramInt2 + 2)] = paramArrayOfInt1[(paramInt1 + 2)];
    paramArrayOfInt2[(paramInt2 + 3)] = paramArrayOfInt1[(paramInt1 + 3)];
    paramArrayOfInt2[(paramInt2 + 4)] = paramArrayOfInt1[(paramInt1 + 4)];
    paramArrayOfInt2[(paramInt2 + 5)] = paramArrayOfInt1[(paramInt1 + 5)];
    paramArrayOfInt2[(paramInt2 + 6)] = paramArrayOfInt1[(paramInt1 + 6)];
    paramArrayOfInt2[(paramInt2 + 7)] = paramArrayOfInt1[(paramInt1 + 7)];
  }
  
  public static void g(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2)
  {
    paramArrayOfLong2[(paramInt2 + 0)] = paramArrayOfLong1[(paramInt1 + 0)];
    paramArrayOfLong2[(paramInt2 + 1)] = paramArrayOfLong1[(paramInt1 + 1)];
    paramArrayOfLong2[(paramInt2 + 2)] = paramArrayOfLong1[(paramInt1 + 2)];
    paramArrayOfLong2[(paramInt2 + 3)] = paramArrayOfLong1[(paramInt1 + 3)];
  }
  
  public static int[] h()
  {
    return new int[8];
  }
  
  public static long[] i()
  {
    return new long[4];
  }
  
  public static int[] j()
  {
    return new int[16];
  }
  
  public static long[] k()
  {
    return new long[8];
  }
  
  public static boolean l(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int[] paramArrayOfInt3, int paramInt3)
  {
    boolean bool = r(paramArrayOfInt1, paramInt1, paramArrayOfInt2, paramInt2);
    if (bool) {
      G(paramArrayOfInt1, paramInt1, paramArrayOfInt2, paramInt2, paramArrayOfInt3, paramInt3);
    } else {
      G(paramArrayOfInt2, paramInt2, paramArrayOfInt1, paramInt1, paramArrayOfInt3, paramInt3);
    }
    return bool;
  }
  
  public static boolean m(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    for (int i = 7; i >= 0; i--) {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean n(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    for (int i = 3; i >= 0; i--) {
      if (paramArrayOfLong1[i] != paramArrayOfLong2[i]) {
        return false;
      }
    }
    return true;
  }
  
  public static int[] o(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 256))
    {
      int[] arrayOfInt = h();
      for (int i = 0; paramBigInteger.signum() != 0; i++)
      {
        arrayOfInt[i] = paramBigInteger.intValue();
        paramBigInteger = paramBigInteger.shiftRight(32);
      }
      return arrayOfInt;
    }
    throw new IllegalArgumentException();
  }
  
  public static long[] p(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 256))
    {
      long[] arrayOfLong = i();
      for (int i = 0; paramBigInteger.signum() != 0; i++)
      {
        arrayOfLong[i] = paramBigInteger.longValue();
        paramBigInteger = paramBigInteger.shiftRight(64);
      }
      return arrayOfLong;
    }
    throw new IllegalArgumentException();
  }
  
  public static int q(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = paramArrayOfInt[0];; paramInt = paramArrayOfInt[(paramInt >>> 5)] >>> (paramInt & 0x1F))
    {
      return paramInt & 0x1;
      if ((paramInt & 0xFF) != paramInt) {
        return 0;
      }
    }
  }
  
  public static boolean r(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    for (int i = 7; i >= 0; i--)
    {
      int j = paramArrayOfInt1[(paramInt1 + i)] ^ 0x80000000;
      int k = 0x80000000 ^ paramArrayOfInt2[(paramInt2 + i)];
      if (j < k) {
        return false;
      }
      if (j > k) {
        return true;
      }
    }
    return true;
  }
  
  public static boolean s(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    for (int i = 7; i >= 0; i--)
    {
      int j = paramArrayOfInt1[i] ^ 0x80000000;
      int k = 0x80000000 ^ paramArrayOfInt2[i];
      if (j < k) {
        return false;
      }
      if (j > k) {
        return true;
      }
    }
    return true;
  }
  
  public static boolean t(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[0] != 1) {
      return false;
    }
    for (int i = 1; i < 8; i++) {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean u(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong[0] != 1L) {
      return false;
    }
    for (int i = 1; i < 4; i++) {
      if (paramArrayOfLong[i] != 0L) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean v(int[] paramArrayOfInt)
  {
    for (int i = 0; i < 8; i++) {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean w(long[] paramArrayOfLong)
  {
    for (int i = 0; i < 4; i++) {
      if (paramArrayOfLong[i] != 0L) {
        return false;
      }
    }
    return true;
  }
  
  public static void x(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int[] paramArrayOfInt3, int paramInt3)
  {
    long l1 = paramArrayOfInt2[(paramInt2 + 0)] & 0xFFFFFFFF;
    long l2 = paramArrayOfInt2[(paramInt2 + 1)] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt2[(paramInt2 + 2)] & 0xFFFFFFFF;
    long l4 = paramArrayOfInt2[(paramInt2 + 3)] & 0xFFFFFFFF;
    long l5 = paramArrayOfInt2[(paramInt2 + 4)] & 0xFFFFFFFF;
    long l6 = paramArrayOfInt2[(paramInt2 + 5)] & 0xFFFFFFFF;
    long l7 = paramArrayOfInt2[(paramInt2 + 6)] & 0xFFFFFFFF;
    long l8 = paramArrayOfInt2[(paramInt2 + 7)];
    long l9 = paramArrayOfInt1[(paramInt1 + 0)] & 0xFFFFFFFF;
    long l10 = l9 * l1 + 0L;
    paramArrayOfInt3[(paramInt3 + 0)] = ((int)l10);
    l10 = (l10 >>> 32) + l9 * l2;
    paramArrayOfInt3[(paramInt3 + 1)] = ((int)l10);
    l10 = (l10 >>> 32) + l9 * l3;
    paramArrayOfInt3[(paramInt3 + 2)] = ((int)l10);
    l10 = (l10 >>> 32) + l9 * l4;
    paramArrayOfInt3[(paramInt3 + 3)] = ((int)l10);
    l10 = (l10 >>> 32) + l9 * l5;
    paramArrayOfInt3[(paramInt3 + 4)] = ((int)l10);
    l10 = (l10 >>> 32) + l9 * l6;
    paramArrayOfInt3[(paramInt3 + 5)] = ((int)l10);
    l10 = (l10 >>> 32) + l9 * l7;
    paramArrayOfInt3[(paramInt3 + 6)] = ((int)l10);
    l8 &= 0xFFFFFFFF;
    l9 = (l10 >>> 32) + l9 * l8;
    paramArrayOfInt3[(paramInt3 + 7)] = ((int)l9);
    paramArrayOfInt3[(paramInt3 + 8)] = ((int)(l9 >>> 32));
    for (paramInt2 = 1; paramInt2 < 8; paramInt2++)
    {
      paramInt3++;
      l9 = paramArrayOfInt1[(paramInt1 + paramInt2)] & 0xFFFFFFFF;
      int i = paramInt3 + 0;
      l10 = l9 * l1 + (paramArrayOfInt3[i] & 0xFFFFFFFF) + 0L;
      paramArrayOfInt3[i] = ((int)l10);
      i = paramInt3 + 1;
      l10 = (l10 >>> 32) + (l9 * l2 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l10);
      i = paramInt3 + 2;
      l10 = (l10 >>> 32) + (l9 * l3 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l10);
      i = paramInt3 + 3;
      l10 = (l10 >>> 32) + (l9 * l4 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l10);
      i = paramInt3 + 4;
      l10 = (l10 >>> 32) + (l9 * l5 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l10);
      i = paramInt3 + 5;
      l10 = (l10 >>> 32) + (l9 * l6 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l10);
      i = paramInt3 + 6;
      l10 = (l10 >>> 32) + (l9 * l7 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l10);
      i = paramInt3 + 7;
      l9 = (l10 >>> 32) + (l9 * l8 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l9);
      paramArrayOfInt3[(paramInt3 + 8)] = ((int)(l9 >>> 32));
    }
  }
  
  public static void y(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l1 = paramArrayOfInt2[0] & 0xFFFFFFFF;
    long l2 = paramArrayOfInt2[1] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt2[2] & 0xFFFFFFFF;
    long l4 = paramArrayOfInt2[3] & 0xFFFFFFFF;
    long l5 = paramArrayOfInt2[4] & 0xFFFFFFFF;
    long l6 = paramArrayOfInt2[5] & 0xFFFFFFFF;
    long l7 = paramArrayOfInt2[6] & 0xFFFFFFFF;
    long l8 = paramArrayOfInt2[7] & 0xFFFFFFFF;
    long l9 = paramArrayOfInt1[0] & 0xFFFFFFFF;
    long l10 = l9 * l1 + 0L;
    paramArrayOfInt3[0] = ((int)l10);
    l10 = (l10 >>> 32) + l9 * l2;
    paramArrayOfInt3[1] = ((int)l10);
    l10 = (l10 >>> 32) + l9 * l3;
    paramArrayOfInt3[2] = ((int)l10);
    l10 = (l10 >>> 32) + l9 * l4;
    paramArrayOfInt3[3] = ((int)l10);
    l10 = (l10 >>> 32) + l9 * l5;
    paramArrayOfInt3[4] = ((int)l10);
    l10 = (l10 >>> 32) + l9 * l6;
    paramArrayOfInt3[5] = ((int)l10);
    l10 = (l10 >>> 32) + l9 * l7;
    paramArrayOfInt3[6] = ((int)l10);
    l9 = (l10 >>> 32) + l9 * l8;
    paramArrayOfInt3[7] = ((int)l9);
    paramArrayOfInt3[8] = ((int)(l9 >>> 32));
    int j;
    for (int i = 1; i < 8; i = j)
    {
      l9 = paramArrayOfInt1[i] & 0xFFFFFFFF;
      j = i + 0;
      l10 = l9 * l1 + (paramArrayOfInt3[j] & 0xFFFFFFFF) + 0L;
      paramArrayOfInt3[j] = ((int)l10);
      j = i + 1;
      l10 = (l10 >>> 32) + (l9 * l2 + (paramArrayOfInt3[j] & 0xFFFFFFFF));
      paramArrayOfInt3[j] = ((int)l10);
      int k = i + 2;
      l10 = (l10 >>> 32) + (l9 * l3 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l10);
      k = i + 3;
      l10 = (l10 >>> 32) + (l9 * l4 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l10);
      k = i + 4;
      l10 = (l10 >>> 32) + (l9 * l5 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l10);
      k = i + 5;
      l10 = (l10 >>> 32) + (l9 * l6 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l10);
      k = i + 6;
      l10 = (l10 >>> 32) + (l9 * l7 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l10);
      k = i + 7;
      l9 = (l10 >>> 32) + (l9 * l8 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l9);
      paramArrayOfInt3[(i + 8)] = ((int)(l9 >>> 32));
    }
  }
  
  public static long z(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3, int[] paramArrayOfInt3, int paramInt4)
  {
    long l1 = paramInt1 & 0xFFFFFFFF;
    long l2 = paramArrayOfInt1[(paramInt2 + 0)] & 0xFFFFFFFF;
    long l3 = l1 * l2 + (paramArrayOfInt2[(paramInt3 + 0)] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[(paramInt4 + 0)] = ((int)l3);
    long l4 = paramArrayOfInt1[(paramInt2 + 1)] & 0xFFFFFFFF;
    l2 = (l3 >>> 32) + (l1 * l4 + l2 + (paramArrayOfInt2[(paramInt3 + 1)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt4 + 1)] = ((int)l2);
    l3 = paramArrayOfInt1[(paramInt2 + 2)] & 0xFFFFFFFF;
    l4 = (l2 >>> 32) + (l1 * l3 + l4 + (paramArrayOfInt2[(paramInt3 + 2)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt4 + 2)] = ((int)l4);
    l2 = paramArrayOfInt1[(paramInt2 + 3)] & 0xFFFFFFFF;
    l3 = (l4 >>> 32) + (l1 * l2 + l3 + (paramArrayOfInt2[(paramInt3 + 3)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt4 + 3)] = ((int)l3);
    l4 = paramArrayOfInt1[(paramInt2 + 4)] & 0xFFFFFFFF;
    l3 = (l3 >>> 32) + (l1 * l4 + l2 + (paramArrayOfInt2[(paramInt3 + 4)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt4 + 4)] = ((int)l3);
    l2 = paramArrayOfInt1[(paramInt2 + 5)] & 0xFFFFFFFF;
    l3 = (l3 >>> 32) + (l1 * l2 + l4 + (paramArrayOfInt2[(paramInt3 + 5)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt4 + 5)] = ((int)l3);
    l4 = paramArrayOfInt1[(paramInt2 + 6)] & 0xFFFFFFFF;
    l3 = (l3 >>> 32) + (l1 * l4 + l2 + (paramArrayOfInt2[(paramInt3 + 6)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt4 + 6)] = ((int)l3);
    l2 = paramArrayOfInt1[(paramInt2 + 7)] & 0xFFFFFFFF;
    l1 = (l3 >>> 32) + (l1 * l2 + l4 + (0xFFFFFFFF & paramArrayOfInt2[(paramInt3 + 7)]));
    paramArrayOfInt3[(paramInt4 + 7)] = ((int)l1);
    return (l1 >>> 32) + l2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */