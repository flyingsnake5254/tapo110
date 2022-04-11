package org.bouncycastle.crypto.engines;

public class d
  extends k
{
  public static void n(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1.length == 16)
    {
      if (paramArrayOfInt2.length == 16)
      {
        if (paramInt % 2 == 0)
        {
          int i = paramArrayOfInt1[0];
          int j = paramArrayOfInt1[1];
          int k = paramArrayOfInt1[2];
          int m = paramArrayOfInt1[3];
          int n = paramArrayOfInt1[4];
          int i1 = paramArrayOfInt1[5];
          int i2 = paramArrayOfInt1[6];
          int i3 = paramArrayOfInt1[7];
          int i4 = paramArrayOfInt1[8];
          int i5 = paramArrayOfInt1[9];
          int i6 = paramArrayOfInt1[10];
          int i7 = paramArrayOfInt1[11];
          int i8 = paramArrayOfInt1[12];
          int i9 = paramArrayOfInt1[13];
          int i10 = paramArrayOfInt1[14];
          int i11 = paramArrayOfInt1[15];
          while (paramInt > 0)
          {
            i += n;
            i8 = k.l(i8 ^ i, 16);
            i4 += i8;
            n = k.l(n ^ i4, 12);
            i += n;
            i8 = k.l(i8 ^ i, 8);
            i4 += i8;
            n = k.l(n ^ i4, 7);
            j += i1;
            i9 = k.l(i9 ^ j, 16);
            i5 += i9;
            i1 = k.l(i1 ^ i5, 12);
            j += i1;
            i9 = k.l(i9 ^ j, 8);
            i5 += i9;
            i1 = k.l(i1 ^ i5, 7);
            k += i2;
            i10 = k.l(i10 ^ k, 16);
            i6 += i10;
            i2 = k.l(i2 ^ i6, 12);
            k += i2;
            i10 = k.l(i10 ^ k, 8);
            i6 += i10;
            i2 = k.l(i2 ^ i6, 7);
            m += i3;
            i11 = k.l(i11 ^ m, 16);
            i7 += i11;
            i3 = k.l(i3 ^ i7, 12);
            m += i3;
            i11 = k.l(i11 ^ m, 8);
            i7 += i11;
            i3 = k.l(i3 ^ i7, 7);
            i += i1;
            i11 = k.l(i11 ^ i, 16);
            i6 += i11;
            i1 = k.l(i1 ^ i6, 12);
            i += i1;
            i11 = k.l(i11 ^ i, 8);
            i6 += i11;
            i1 = k.l(i1 ^ i6, 7);
            j += i2;
            i8 = k.l(i8 ^ j, 16);
            i7 += i8;
            i2 = k.l(i2 ^ i7, 12);
            j += i2;
            i8 = k.l(i8 ^ j, 8);
            i7 += i8;
            i2 = k.l(i2 ^ i7, 7);
            k += i3;
            i9 = k.l(i9 ^ k, 16);
            i4 += i9;
            i3 = k.l(i3 ^ i4, 12);
            k += i3;
            i9 = k.l(i9 ^ k, 8);
            i4 += i9;
            i3 = k.l(i3 ^ i4, 7);
            m += n;
            i10 = k.l(i10 ^ m, 16);
            i5 += i10;
            n = k.l(n ^ i5, 12);
            m += n;
            i10 = k.l(i10 ^ m, 8);
            i5 += i10;
            n = k.l(n ^ i5, 7);
            paramInt -= 2;
          }
          paramArrayOfInt2[0] = (i + paramArrayOfInt1[0]);
          paramArrayOfInt2[1] = (j + paramArrayOfInt1[1]);
          paramArrayOfInt2[2] = (k + paramArrayOfInt1[2]);
          paramArrayOfInt2[3] = (m + paramArrayOfInt1[3]);
          paramArrayOfInt2[4] = (n + paramArrayOfInt1[4]);
          paramArrayOfInt2[5] = (i1 + paramArrayOfInt1[5]);
          paramArrayOfInt2[6] = (i2 + paramArrayOfInt1[6]);
          paramArrayOfInt2[7] = (i3 + paramArrayOfInt1[7]);
          paramArrayOfInt2[8] = (i4 + paramArrayOfInt1[8]);
          paramArrayOfInt2[9] = (i5 + paramArrayOfInt1[9]);
          paramArrayOfInt2[10] = (i6 + paramArrayOfInt1[10]);
          paramArrayOfInt2[11] = (i7 + paramArrayOfInt1[11]);
          paramArrayOfInt2[12] = (i8 + paramArrayOfInt1[12]);
          paramArrayOfInt2[13] = (i9 + paramArrayOfInt1[13]);
          paramArrayOfInt2[14] = (i10 + paramArrayOfInt1[14]);
          paramArrayOfInt2[15] = (i11 + paramArrayOfInt1[15]);
          return;
        }
        throw new IllegalArgumentException("Number of rounds must be even");
      }
      throw new IllegalArgumentException();
    }
    throw new IllegalArgumentException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\engines\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */