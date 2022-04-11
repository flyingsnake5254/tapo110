package com.google.android.exoplayer2;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.trackselection.n;
import com.google.common.collect.ImmutableList;
import java.util.List;

final class s1
{
  private static final e0.a a = new e0.a(new Object());
  public final j2 b;
  public final e0.a c;
  public final long d;
  public final long e;
  public final int f;
  @Nullable
  public final ExoPlaybackException g;
  public final boolean h;
  public final TrackGroupArray i;
  public final n j;
  public final List<Metadata> k;
  public final e0.a l;
  public final boolean m;
  public final int n;
  public final t1 o;
  public final boolean p;
  public final boolean q;
  public volatile long r;
  public volatile long s;
  public volatile long t;
  
  public s1(j2 paramj2, e0.a parama1, long paramLong1, long paramLong2, int paramInt1, @Nullable ExoPlaybackException paramExoPlaybackException, boolean paramBoolean1, TrackGroupArray paramTrackGroupArray, n paramn, List<Metadata> paramList, e0.a parama2, boolean paramBoolean2, int paramInt2, t1 paramt1, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.b = paramj2;
    this.c = parama1;
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramInt1;
    this.g = paramExoPlaybackException;
    this.h = paramBoolean1;
    this.i = paramTrackGroupArray;
    this.j = paramn;
    this.k = paramList;
    this.l = parama2;
    this.m = paramBoolean2;
    this.n = paramInt2;
    this.o = paramt1;
    this.r = paramLong3;
    this.s = paramLong4;
    this.t = paramLong5;
    this.p = paramBoolean3;
    this.q = paramBoolean4;
  }
  
  public static s1 k(n paramn)
  {
    j2 localj2 = j2.a;
    e0.a locala = a;
    return new s1(localj2, locala, -9223372036854775807L, 0L, 1, null, false, TrackGroupArray.c, paramn, ImmutableList.of(), locala, false, 0, t1.a, 0L, 0L, 0L, false, false);
  }
  
  public static e0.a l()
  {
    return a;
  }
  
  @CheckResult
  public s1 a(boolean paramBoolean)
  {
    return new s1(this.b, this.c, this.d, this.e, this.f, this.g, paramBoolean, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.s, this.t, this.p, this.q);
  }
  
  @CheckResult
  public s1 b(e0.a parama)
  {
    return new s1(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, parama, this.m, this.n, this.o, this.r, this.s, this.t, this.p, this.q);
  }
  
  @CheckResult
  public s1 c(e0.a parama, long paramLong1, long paramLong2, long paramLong3, long paramLong4, TrackGroupArray paramTrackGroupArray, n paramn, List<Metadata> paramList)
  {
    return new s1(this.b, parama, paramLong2, paramLong3, this.f, this.g, this.h, paramTrackGroupArray, paramn, paramList, this.l, this.m, this.n, this.o, this.r, paramLong4, paramLong1, this.p, this.q);
  }
  
  @CheckResult
  public s1 d(boolean paramBoolean)
  {
    return new s1(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.s, this.t, paramBoolean, this.q);
  }
  
  @CheckResult
  public s1 e(boolean paramBoolean, int paramInt)
  {
    return new s1(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, paramBoolean, paramInt, this.o, this.r, this.s, this.t, this.p, this.q);
  }
  
  @CheckResult
  public s1 f(@Nullable ExoPlaybackException paramExoPlaybackException)
  {
    return new s1(this.b, this.c, this.d, this.e, this.f, paramExoPlaybackException, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.s, this.t, this.p, this.q);
  }
  
  @CheckResult
  public s1 g(t1 paramt1)
  {
    return new s1(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, paramt1, this.r, this.s, this.t, this.p, this.q);
  }
  
  @CheckResult
  public s1 h(int paramInt)
  {
    return new s1(this.b, this.c, this.d, this.e, paramInt, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.s, this.t, this.p, this.q);
  }
  
  @CheckResult
  public s1 i(boolean paramBoolean)
  {
    return new s1(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.s, this.t, this.p, paramBoolean);
  }
  
  @CheckResult
  public s1 j(j2 paramj2)
  {
    return new s1(paramj2, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.s, this.t, this.p, this.q);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\s1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */