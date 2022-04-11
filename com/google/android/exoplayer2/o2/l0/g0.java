package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;

final class g0
{
  private final int a;
  private final l0 b;
  private final d0 c;
  private boolean d;
  private boolean e;
  private boolean f;
  private long g;
  private long h;
  private long i;
  
  g0(int paramInt)
  {
    this.a = paramInt;
    this.b = new l0(0L);
    this.g = -9223372036854775807L;
    this.h = -9223372036854775807L;
    this.i = -9223372036854775807L;
    this.c = new d0();
  }
  
  private int a(k paramk)
  {
    this.c.M(o0.f);
    this.d = true;
    paramk.e();
    return 0;
  }
  
  private int f(k paramk, x paramx, int paramInt)
    throws IOException
  {
    int j = (int)Math.min(this.a, paramk.a());
    long l1 = paramk.getPosition();
    long l2 = 0;
    if (l1 != l2)
    {
      paramx.a = l2;
      return 1;
    }
    this.c.L(j);
    paramk.e();
    paramk.n(this.c.d(), 0, j);
    this.g = g(this.c, paramInt);
    this.e = true;
    return 0;
  }
  
  private long g(d0 paramd0, int paramInt)
  {
    int j = paramd0.e();
    int k = paramd0.f();
    while (j < k)
    {
      if (paramd0.d()[j] == 71)
      {
        long l = j0.c(paramd0, j, paramInt);
        if (l != -9223372036854775807L) {
          return l;
        }
      }
      j++;
    }
    return -9223372036854775807L;
  }
  
  private int h(k paramk, x paramx, int paramInt)
    throws IOException
  {
    long l = paramk.a();
    int j = (int)Math.min(this.a, l);
    l -= j;
    if (paramk.getPosition() != l)
    {
      paramx.a = l;
      return 1;
    }
    this.c.L(j);
    paramk.e();
    paramk.n(this.c.d(), 0, j);
    this.h = i(this.c, paramInt);
    this.f = true;
    return 0;
  }
  
  private long i(d0 paramd0, int paramInt)
  {
    int j = paramd0.e();
    int k = paramd0.f();
    for (int m = k - 188; m >= j; m--) {
      if (j0.b(paramd0.d(), j, k, m))
      {
        long l = j0.c(paramd0, m, paramInt);
        if (l != -9223372036854775807L) {
          return l;
        }
      }
    }
    return -9223372036854775807L;
  }
  
  public long b()
  {
    return this.i;
  }
  
  public l0 c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public int e(k paramk, x paramx, int paramInt)
    throws IOException
  {
    if (paramInt <= 0) {
      return a(paramk);
    }
    if (!this.f) {
      return h(paramk, paramx, paramInt);
    }
    if (this.h == -9223372036854775807L) {
      return a(paramk);
    }
    if (!this.e) {
      return f(paramk, paramx, paramInt);
    }
    long l = this.g;
    if (l == -9223372036854775807L) {
      return a(paramk);
    }
    l = this.b.b(l);
    this.i = (this.b.b(this.h) - l);
    return a(paramk);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */