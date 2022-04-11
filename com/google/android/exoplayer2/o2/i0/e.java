package com.google.android.exoplayer2.o2.i0;

import android.util.Pair;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.o2.y.a;
import com.google.android.exoplayer2.o2.z;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;

final class e
  implements g
{
  private final long[] a;
  private final long[] b;
  private final long c;
  
  private e(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong)
  {
    this.a = paramArrayOfLong1;
    this.b = paramArrayOfLong2;
    if (paramLong == -9223372036854775807L) {
      paramLong = w0.d(paramArrayOfLong2[(paramArrayOfLong2.length - 1)]);
    }
    this.c = paramLong;
  }
  
  public static e b(long paramLong1, MlltFrame paramMlltFrame, long paramLong2)
  {
    int i = paramMlltFrame.x.length;
    int j = i + 1;
    long[] arrayOfLong1 = new long[j];
    long[] arrayOfLong2 = new long[j];
    arrayOfLong1[0] = paramLong1;
    long l1 = 0L;
    arrayOfLong2[0] = 0L;
    j = 1;
    long l2 = paramLong1;
    paramLong1 = l1;
    while (j <= i)
    {
      int k = paramMlltFrame.f;
      int[] arrayOfInt = paramMlltFrame.x;
      int m = j - 1;
      l2 += k + arrayOfInt[m];
      paramLong1 += paramMlltFrame.q + paramMlltFrame.y[m];
      arrayOfLong1[j] = l2;
      arrayOfLong2[j] = paramLong1;
      j++;
    }
    return new e(arrayOfLong1, arrayOfLong2, paramLong2);
  }
  
  private static Pair<Long, Long> c(long paramLong, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    int i = o0.h(paramArrayOfLong1, paramLong, true, true);
    long l1 = paramArrayOfLong1[i];
    long l2 = paramArrayOfLong2[i];
    i++;
    if (i == paramArrayOfLong1.length) {
      return Pair.create(Long.valueOf(l1), Long.valueOf(l2));
    }
    long l3 = paramArrayOfLong1[i];
    long l4 = paramArrayOfLong2[i];
    double d;
    if (l3 == l1) {
      d = 0.0D;
    } else {
      d = (paramLong - l1) / (l3 - l1);
    }
    return Pair.create(Long.valueOf(paramLong), Long.valueOf((d * (l4 - l2)) + l2));
  }
  
  public y.a a(long paramLong)
  {
    Pair localPair = c(w0.e(o0.q(paramLong, 0L, this.c)), this.b, this.a);
    return new y.a(new z(w0.d(((Long)localPair.first).longValue()), ((Long)localPair.second).longValue()));
  }
  
  public long f()
  {
    return -1L;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public long h(long paramLong)
  {
    return w0.d(((Long)c(paramLong, this.a, this.b).second).longValue());
  }
  
  public long i()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\i0\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */