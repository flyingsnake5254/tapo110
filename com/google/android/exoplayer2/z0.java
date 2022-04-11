package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.android.exoplayer2.util.o0;
import com.google.common.primitives.e;

public final class z0
  implements j1
{
  private final float a;
  private final float b;
  private final long c;
  private final float d;
  private final long e;
  private final long f;
  private final float g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  private long m;
  private float n;
  private float o;
  private float p;
  private long q;
  private long r;
  private long s;
  
  private z0(float paramFloat1, float paramFloat2, long paramLong1, float paramFloat3, long paramLong2, long paramLong3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramLong1;
    this.d = paramFloat3;
    this.e = paramLong2;
    this.f = paramLong3;
    this.g = paramFloat4;
    this.h = -9223372036854775807L;
    this.i = -9223372036854775807L;
    this.k = -9223372036854775807L;
    this.l = -9223372036854775807L;
    this.o = paramFloat1;
    this.n = paramFloat2;
    this.p = 1.0F;
    this.q = -9223372036854775807L;
    this.j = -9223372036854775807L;
    this.m = -9223372036854775807L;
    this.r = -9223372036854775807L;
    this.s = -9223372036854775807L;
  }
  
  private void f(long paramLong)
  {
    long l1 = this.r + this.s * 3L;
    if (this.m > l1)
    {
      paramLong = w0.d(this.c);
      float f1 = this.p;
      float f2 = (float)paramLong;
      paramLong = ((f1 - 1.0F) * f2);
      long l2 = ((this.n - 1.0F) * f2);
      this.m = e.h(new long[] { l1, this.j, this.m - (paramLong + l2) });
    }
    else
    {
      paramLong = o0.q(paramLong - (Math.max(0.0F, this.p - 1.0F) / this.d), this.m, l1);
      this.m = paramLong;
      l1 = this.l;
      if ((l1 != -9223372036854775807L) && (paramLong > l1)) {
        this.m = l1;
      }
    }
  }
  
  private void g()
  {
    long l1 = this.h;
    if (l1 != -9223372036854775807L)
    {
      long l2 = this.i;
      if (l2 != -9223372036854775807L) {
        l1 = l2;
      }
      long l3 = this.k;
      l2 = l1;
      if (l3 != -9223372036854775807L)
      {
        l2 = l1;
        if (l1 < l3) {
          l2 = l3;
        }
      }
      l3 = this.l;
      l1 = l2;
      if (l3 != -9223372036854775807L)
      {
        l1 = l2;
        if (l2 > l3) {
          l1 = l3;
        }
      }
    }
    else
    {
      l1 = -9223372036854775807L;
    }
    if (this.j == l1) {
      return;
    }
    this.j = l1;
    this.m = l1;
    this.r = -9223372036854775807L;
    this.s = -9223372036854775807L;
    this.q = -9223372036854775807L;
  }
  
  private static long h(long paramLong1, long paramLong2, float paramFloat)
  {
    return ((float)paramLong1 * paramFloat + (1.0F - paramFloat) * (float)paramLong2);
  }
  
  private void i(long paramLong1, long paramLong2)
  {
    paramLong1 -= paramLong2;
    paramLong2 = this.r;
    if (paramLong2 == -9223372036854775807L)
    {
      this.r = paramLong1;
      this.s = 0L;
    }
    else
    {
      paramLong2 = Math.max(paramLong1, h(paramLong2, paramLong1, this.g));
      this.r = paramLong2;
      paramLong1 = Math.abs(paramLong1 - paramLong2);
      this.s = h(this.s, paramLong1, this.g);
    }
  }
  
  public void a(l1.f paramf)
  {
    this.h = w0.d(paramf.c);
    this.k = w0.d(paramf.d);
    this.l = w0.d(paramf.e);
    float f1 = paramf.f;
    if (f1 == -3.4028235E38F) {
      f1 = this.a;
    }
    this.o = f1;
    f1 = paramf.g;
    if (f1 == -3.4028235E38F) {
      f1 = this.b;
    }
    this.n = f1;
    g();
  }
  
  public float b(long paramLong1, long paramLong2)
  {
    if (this.h == -9223372036854775807L) {
      return 1.0F;
    }
    i(paramLong1, paramLong2);
    if ((this.q != -9223372036854775807L) && (SystemClock.elapsedRealtime() - this.q < this.c)) {
      return this.p;
    }
    this.q = SystemClock.elapsedRealtime();
    f(paramLong1);
    paramLong1 -= this.m;
    if (Math.abs(paramLong1) < this.e) {
      this.p = 1.0F;
    } else {
      this.p = o0.o(this.d * (float)paramLong1 + 1.0F, this.o, this.n);
    }
    return this.p;
  }
  
  public long c()
  {
    return this.m;
  }
  
  public void d()
  {
    long l1 = this.m;
    if (l1 == -9223372036854775807L) {
      return;
    }
    l1 += this.f;
    this.m = l1;
    long l2 = this.l;
    if ((l2 != -9223372036854775807L) && (l1 > l2)) {
      this.m = l2;
    }
    this.q = -9223372036854775807L;
  }
  
  public void e(long paramLong)
  {
    this.i = paramLong;
    g();
  }
  
  public static final class b
  {
    private float a = 0.97F;
    private float b = 1.03F;
    private long c = 1000L;
    private float d = 1.0E-7F;
    private long e = w0.d(20L);
    private long f = w0.d(500L);
    private float g = 0.999F;
    
    public z0 a()
    {
      return new z0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\z0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */