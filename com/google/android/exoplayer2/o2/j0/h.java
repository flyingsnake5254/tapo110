package com.google.android.exoplayer2.o2.j0;

import com.google.android.exoplayer2.util.o0;

final class h
{
  public static b a(int paramInt, long[] paramArrayOfLong, int[] paramArrayOfInt, long paramLong)
  {
    int i = 8192 / paramInt;
    int j = paramArrayOfInt.length;
    int k = 0;
    int m = 0;
    int n = 0;
    while (m < j)
    {
      n += o0.k(paramArrayOfInt[m], i);
      m++;
    }
    long[] arrayOfLong1 = new long[n];
    int[] arrayOfInt1 = new int[n];
    long[] arrayOfLong2 = new long[n];
    int[] arrayOfInt2 = new int[n];
    int i1 = 0;
    n = 0;
    j = 0;
    for (m = k; m < paramArrayOfInt.length; m++)
    {
      k = paramArrayOfInt[m];
      long l = paramArrayOfLong[m];
      while (k > 0)
      {
        int i2 = Math.min(i, k);
        arrayOfLong1[n] = l;
        arrayOfInt1[n] = (paramInt * i2);
        j = Math.max(j, arrayOfInt1[n]);
        arrayOfLong2[n] = (i1 * paramLong);
        arrayOfInt2[n] = 1;
        l += arrayOfInt1[n];
        i1 += i2;
        k -= i2;
        n++;
      }
    }
    return new b(arrayOfLong1, arrayOfInt1, j, arrayOfLong2, arrayOfInt2, paramLong * i1, null);
  }
  
  public static final class b
  {
    public final long[] a;
    public final int[] b;
    public final int c;
    public final long[] d;
    public final int[] e;
    public final long f;
    
    private b(long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2, long paramLong)
    {
      this.a = paramArrayOfLong1;
      this.b = paramArrayOfInt1;
      this.c = paramInt;
      this.d = paramArrayOfLong2;
      this.e = paramArrayOfInt2;
      this.f = paramLong;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\j0\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */