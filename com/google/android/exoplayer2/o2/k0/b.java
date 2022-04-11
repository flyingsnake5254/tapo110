package com.google.android.exoplayer2.o2.k0;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.m;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.y.a;
import com.google.android.exoplayer2.o2.z;
import com.google.android.exoplayer2.util.o0;
import java.io.EOFException;
import java.io.IOException;

final class b
  implements g
{
  private final f a;
  private final long b;
  private final long c;
  private final i d;
  private int e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  
  public b(i parami, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean)
  {
    boolean bool;
    if ((paramLong1 >= 0L) && (paramLong2 > paramLong1)) {
      bool = true;
    } else {
      bool = false;
    }
    com.google.android.exoplayer2.util.g.a(bool);
    this.d = parami;
    this.b = paramLong1;
    this.c = paramLong2;
    if ((paramLong3 != paramLong2 - paramLong1) && (!paramBoolean))
    {
      this.e = 0;
    }
    else
    {
      this.f = paramLong4;
      this.e = 4;
    }
    this.a = new f();
  }
  
  private long i(k paramk)
    throws IOException
  {
    if (this.i == this.j) {
      return -1L;
    }
    long l1 = paramk.getPosition();
    if (!this.a.d(paramk, this.j))
    {
      l2 = this.i;
      if (l2 != l1) {
        return l2;
      }
      throw new IOException("No ogg page can be found.");
    }
    this.a.a(paramk, false);
    paramk.e();
    long l2 = this.h;
    f localf = this.a;
    long l3 = localf.c;
    l2 -= l3;
    int m = localf.h + localf.i;
    if ((0L <= l2) && (l2 < 72000L)) {
      return -1L;
    }
    boolean bool = l2 < 0L;
    if (bool)
    {
      this.j = l1;
      this.l = l3;
    }
    else
    {
      this.i = (paramk.getPosition() + m);
      this.k = this.a.c;
    }
    l3 = this.j;
    l1 = this.i;
    if (l3 - l1 < 100000L)
    {
      this.j = l1;
      return l1;
    }
    l3 = m;
    if (!bool) {
      l1 = 2L;
    } else {
      l1 = 1L;
    }
    long l4 = paramk.getPosition();
    long l5 = this.j;
    long l6 = this.i;
    return o0.q(l4 - l3 * l1 + l2 * (l5 - l6) / (this.l - this.k), l6, l5 - 1L);
  }
  
  private void k(k paramk)
    throws IOException
  {
    for (;;)
    {
      this.a.c(paramk);
      this.a.a(paramk, false);
      f localf = this.a;
      if (localf.c > this.h)
      {
        paramk.e();
        return;
      }
      paramk.l(localf.h + localf.i);
      this.i = paramk.getPosition();
      this.k = this.a.c;
    }
  }
  
  public long a(k paramk)
    throws IOException
  {
    int m = this.e;
    long l1;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m == 4) {
              return -1L;
            }
            throw new IllegalStateException();
          }
        }
        else
        {
          l1 = i(paramk);
          if (l1 != -1L) {
            return l1;
          }
          this.e = 3;
        }
        k(paramk);
        this.e = 4;
        return -(this.k + 2L);
      }
    }
    else
    {
      long l2 = paramk.getPosition();
      this.g = l2;
      this.e = 1;
      l1 = this.c - 65307L;
      if (l1 > l2) {
        return l1;
      }
    }
    this.f = j(paramk);
    this.e = 4;
    return this.g;
  }
  
  public void c(long paramLong)
  {
    this.h = o0.q(paramLong, 0L, this.f - 1L);
    this.e = 2;
    this.i = this.b;
    this.j = this.c;
    this.k = 0L;
    this.l = this.f;
  }
  
  @Nullable
  public b h()
  {
    long l1 = this.f;
    b localb = null;
    if (l1 != 0L) {
      localb = new b(null);
    }
    return localb;
  }
  
  @VisibleForTesting
  long j(k paramk)
    throws IOException
  {
    this.a.b();
    if (this.a.c(paramk))
    {
      this.a.a(paramk, false);
      f localf = this.a;
      paramk.l(localf.h + localf.i);
      for (long l1 = this.a.c;; l1 = this.a.c)
      {
        localf = this.a;
        if (((localf.b & 0x4) == 4) || (!localf.c(paramk)) || (paramk.getPosition() >= this.c) || (!this.a.a(paramk, true))) {
          break;
        }
        localf = this.a;
        if (!m.e(paramk, localf.h + localf.i)) {
          break;
        }
      }
      return l1;
    }
    throw new EOFException();
  }
  
  private final class b
    implements y
  {
    private b() {}
    
    public y.a a(long paramLong)
    {
      long l = b.d(b.this).c(paramLong);
      return new y.a(new z(paramLong, o0.q(b.e(b.this) + l * (b.f(b.this) - b.e(b.this)) / b.g(b.this) - 30000L, b.e(b.this), b.f(b.this) - 1L)));
    }
    
    public boolean g()
    {
      return true;
    }
    
    public long i()
    {
      return b.d(b.this).b(b.g(b.this));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\k0\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */