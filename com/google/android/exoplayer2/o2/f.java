package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.util.o0;

public class f
  implements y
{
  private final long a;
  private final long b;
  private final int c;
  private final long d;
  private final int e;
  private final long f;
  
  public f(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    int i = paramInt2;
    if (paramInt2 == -1) {
      i = 1;
    }
    this.c = i;
    this.e = paramInt1;
    if (paramLong1 == -1L)
    {
      this.d = -1L;
      this.f = -9223372036854775807L;
    }
    else
    {
      this.d = (paramLong1 - paramLong2);
      this.f = d(paramLong1, paramLong2, paramInt1);
    }
  }
  
  private long b(long paramLong)
  {
    paramLong = paramLong * this.e / 8000000L;
    int i = this.c;
    paramLong = o0.q(paramLong / i * i, 0L, this.d - i);
    return this.b + paramLong;
  }
  
  private static long d(long paramLong1, long paramLong2, int paramInt)
  {
    return Math.max(0L, paramLong1 - paramLong2) * 8L * 1000000L / paramInt;
  }
  
  public y.a a(long paramLong)
  {
    if (this.d == -1L) {
      return new y.a(new z(0L, this.b));
    }
    long l1 = b(paramLong);
    long l2 = c(l1);
    z localz = new z(l2, l1);
    if (l2 < paramLong)
    {
      int i = this.c;
      if (i + l1 < this.a)
      {
        paramLong = l1 + i;
        return new y.a(localz, new z(c(paramLong), paramLong));
      }
    }
    return new y.a(localz);
  }
  
  public long c(long paramLong)
  {
    return d(paramLong, this.b, this.e);
  }
  
  public boolean g()
  {
    boolean bool;
    if (this.d != -1L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public long i()
  {
    return this.f;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */