package com.google.android.exoplayer2.o2.i0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.e0.a;
import com.google.android.exoplayer2.o2.y.a;
import com.google.android.exoplayer2.o2.z;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;

final class i
  implements g
{
  private final long a;
  private final int b;
  private final long c;
  private final long d;
  private final long e;
  @Nullable
  private final long[] f;
  
  private i(long paramLong1, int paramInt, long paramLong2)
  {
    this(paramLong1, paramInt, paramLong2, -1L, null);
  }
  
  private i(long paramLong1, int paramInt, long paramLong2, long paramLong3, @Nullable long[] paramArrayOfLong)
  {
    this.a = paramLong1;
    this.b = paramInt;
    this.c = paramLong2;
    this.f = paramArrayOfLong;
    this.d = paramLong3;
    paramLong2 = -1L;
    if (paramLong3 == -1L) {
      paramLong1 = paramLong2;
    } else {
      paramLong1 += paramLong3;
    }
    this.e = paramLong1;
  }
  
  @Nullable
  public static i b(long paramLong1, long paramLong2, e0.a parama, d0 paramd0)
  {
    int i = parama.g;
    int j = parama.d;
    int k = paramd0.n();
    if ((k & 0x1) == 1)
    {
      int m = paramd0.H();
      if (m != 0)
      {
        long l1 = o0.C0(m, i * 1000000L, j);
        if ((k & 0x6) != 6) {
          return new i(paramLong2, parama.c, l1);
        }
        long l2 = paramd0.F();
        long[] arrayOfLong = new long[100];
        for (m = 0; m < 100; m++) {
          arrayOfLong[m] = paramd0.D();
        }
        if (paramLong1 != -1L)
        {
          long l3 = paramLong2 + l2;
          if (paramLong1 != l3)
          {
            paramd0 = new StringBuilder(67);
            paramd0.append("XING data size mismatch: ");
            paramd0.append(paramLong1);
            paramd0.append(", ");
            paramd0.append(l3);
            u.h("XingSeeker", paramd0.toString());
          }
        }
        return new i(paramLong2, parama.c, l1, l2, arrayOfLong);
      }
    }
    return null;
  }
  
  private long c(int paramInt)
  {
    return this.c * paramInt / 100L;
  }
  
  public y.a a(long paramLong)
  {
    if (!g()) {
      return new y.a(new z(0L, this.a + this.b));
    }
    long l = o0.q(paramLong, 0L, this.c);
    double d1 = l * 100.0D / this.c;
    double d2 = 0.0D;
    if (d1 > 0.0D) {
      if (d1 >= 100.0D)
      {
        d2 = 256.0D;
      }
      else
      {
        int i = (int)d1;
        long[] arrayOfLong = (long[])com.google.android.exoplayer2.util.g.i(this.f);
        double d3 = arrayOfLong[i];
        if (i == 99) {
          d2 = 256.0D;
        } else {
          d2 = arrayOfLong[(i + 1)];
        }
        d2 = d3 + (d1 - i) * (d2 - d3);
      }
    }
    paramLong = o0.q(Math.round(d2 / 256.0D * this.d), this.b, this.d - 1L);
    return new y.a(new z(l, this.a + paramLong));
  }
  
  public long f()
  {
    return this.e;
  }
  
  public boolean g()
  {
    boolean bool;
    if (this.f != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public long h(long paramLong)
  {
    paramLong -= this.a;
    if ((g()) && (paramLong > this.b))
    {
      long[] arrayOfLong = (long[])com.google.android.exoplayer2.util.g.i(this.f);
      double d1 = paramLong * 256.0D / this.d;
      int i = o0.h(arrayOfLong, d1, true, true);
      long l1 = c(i);
      long l2 = arrayOfLong[i];
      int j = i + 1;
      long l3 = c(j);
      if (i == 99) {
        paramLong = 256L;
      } else {
        paramLong = arrayOfLong[j];
      }
      if (l2 == paramLong) {
        d1 = 0.0D;
      } else {
        d1 = (d1 - l2) / (paramLong - l2);
      }
      return l1 + Math.round(d1 * (l3 - l1));
    }
    return 0L;
  }
  
  public long i()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\i0\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */