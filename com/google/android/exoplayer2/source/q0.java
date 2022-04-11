package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.j2.b;
import com.google.android.exoplayer2.j2.c;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.l1.c;
import com.google.android.exoplayer2.l1.f;
import com.google.android.exoplayer2.util.g;

public final class q0
  extends j2
{
  private static final Object c = new Object();
  private static final l1 d = new l1.c().p("SinglePeriodTimeline").u(Uri.EMPTY).a();
  private final long e;
  private final long f;
  private final long g;
  private final long h;
  private final long i;
  private final long j;
  private final long k;
  private final boolean l;
  private final boolean m;
  private final boolean n;
  @Nullable
  private final Object o;
  @Nullable
  private final l1 p;
  @Nullable
  private final l1.f q;
  
  public q0(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @Nullable Object paramObject, l1 paraml1, @Nullable l1.f paramf)
  {
    this.e = paramLong1;
    this.f = paramLong2;
    this.g = paramLong3;
    this.h = paramLong4;
    this.i = paramLong5;
    this.j = paramLong6;
    this.k = paramLong7;
    this.l = paramBoolean1;
    this.m = paramBoolean2;
    this.n = paramBoolean3;
    this.o = paramObject;
    this.p = ((l1)g.e(paraml1));
    this.q = paramf;
  }
  
  public q0(long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @Nullable Object paramObject, l1 paraml1)
  {
    this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3, paramLong4, paramBoolean1, paramBoolean2, false, paramObject, paraml1, localf);
  }
  
  public q0(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @Nullable Object paramObject, l1 paraml1)
  {
    this(paramLong, paramLong, 0L, 0L, paramBoolean1, paramBoolean2, paramBoolean3, paramObject, paraml1);
  }
  
  public int b(Object paramObject)
  {
    int i1;
    if (c.equals(paramObject)) {
      i1 = 0;
    } else {
      i1 = -1;
    }
    return i1;
  }
  
  public j2.b g(int paramInt, j2.b paramb, boolean paramBoolean)
  {
    g.c(paramInt, 0, 1);
    Object localObject;
    if (paramBoolean) {
      localObject = c;
    } else {
      localObject = null;
    }
    return paramb.q(null, localObject, 0, this.h, -this.j);
  }
  
  public int i()
  {
    return 1;
  }
  
  public Object m(int paramInt)
  {
    g.c(paramInt, 0, 1);
    return c;
  }
  
  public j2.c o(int paramInt, j2.c paramc, long paramLong)
  {
    g.c(paramInt, 0, 1);
    long l1 = this.k;
    boolean bool = this.m;
    long l2 = l1;
    if (bool)
    {
      l2 = l1;
      if (!this.n)
      {
        l2 = l1;
        if (paramLong != 0L)
        {
          long l3 = this.i;
          if (l3 == -9223372036854775807L) {}
          do
          {
            paramLong = -9223372036854775807L;
            break;
            paramLong = l1 + paramLong;
            l2 = paramLong;
          } while (paramLong > l3);
        }
      }
    }
    paramLong = l2;
    return paramc.g(j2.c.a, this.p, this.o, this.e, this.f, this.g, this.l, bool, this.q, paramLong, this.i, 0, 0, this.j);
  }
  
  public int p()
  {
    return 1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\q0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */