package com.google.android.exoplayer2.source.hls;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.z;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.l1.c;
import com.google.android.exoplayer2.l1.f;
import com.google.android.exoplayer2.l1.g;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.source.f0.a;
import com.google.android.exoplayer2.source.g0;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.a;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.hls.playlist.g.b;
import com.google.android.exoplayer2.source.hls.playlist.g.d;
import com.google.android.exoplayer2.source.hls.playlist.g.e;
import com.google.android.exoplayer2.source.hls.playlist.g.f;
import com.google.android.exoplayer2.source.hls.playlist.i;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.q0;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.l.a;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public final class HlsMediaSource
  extends m
  implements HlsPlaylistTracker.c
{
  private final k g;
  private final l1.g h;
  private final j i;
  private final r j;
  private final com.google.android.exoplayer2.drm.x k;
  private final com.google.android.exoplayer2.upstream.x l;
  private final boolean m;
  private final int n;
  private final boolean o;
  private final HlsPlaylistTracker p;
  private final long q;
  private final l1 r;
  private l1.f s;
  @Nullable
  private a0 t;
  
  static
  {
    h1.a("goog.exo.hls");
  }
  
  private HlsMediaSource(l1 paraml1, j paramj, k paramk, r paramr, com.google.android.exoplayer2.drm.x paramx, com.google.android.exoplayer2.upstream.x paramx1, HlsPlaylistTracker paramHlsPlaylistTracker, long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.h = ((l1.g)com.google.android.exoplayer2.util.g.e(paraml1.d));
    this.r = paraml1;
    this.s = paraml1.e;
    this.i = paramj;
    this.g = paramk;
    this.j = paramr;
    this.k = paramx;
    this.l = paramx1;
    this.p = paramHlsPlaylistTracker;
    this.q = paramLong;
    this.m = paramBoolean1;
    this.n = paramInt;
    this.o = paramBoolean2;
  }
  
  private q0 A(com.google.android.exoplayer2.source.hls.playlist.g paramg, long paramLong1, long paramLong2, l paraml)
  {
    long l1 = paramg.h - this.p.d();
    long l2;
    if (paramg.o) {
      l2 = l1 + paramg.u;
    } else {
      l2 = -9223372036854775807L;
    }
    long l3 = E(paramg);
    long l4 = this.s.c;
    if (l4 != -9223372036854775807L) {
      l4 = w0.d(l4);
    } else {
      l4 = G(paramg, l3);
    }
    H(o0.q(l4, l3, paramg.u + l3));
    l4 = F(paramg, l3);
    boolean bool;
    if ((paramg.d == 2) && (paramg.f)) {
      bool = true;
    } else {
      bool = false;
    }
    return new q0(paramLong1, paramLong2, -9223372036854775807L, l2, paramg.u, l1, l4, true, paramg.o ^ true, bool, paraml, this.r, this.s);
  }
  
  private q0 B(com.google.android.exoplayer2.source.hls.playlist.g paramg, long paramLong1, long paramLong2, l paraml)
  {
    long l1;
    if ((paramg.e != -9223372036854775807L) && (!paramg.r.isEmpty()))
    {
      if (!paramg.g)
      {
        l1 = paramg.e;
        if (l1 != paramg.u)
        {
          l1 = D(paramg.r, l1).x;
          break label81;
        }
      }
      l1 = paramg.e;
    }
    else
    {
      l1 = 0L;
    }
    label81:
    long l2 = paramg.u;
    return new q0(paramLong1, paramLong2, -9223372036854775807L, l2, l2, 0L, l1, true, false, true, paraml, this.r, null);
  }
  
  @Nullable
  private static g.b C(List<g.b> paramList, long paramLong)
  {
    Object localObject1 = null;
    int i1 = 0;
    while (i1 < paramList.size())
    {
      Object localObject2 = (g.b)paramList.get(i1);
      long l1 = ((g.e)localObject2).x;
      if ((l1 > paramLong) || (!((g.b)localObject2).H3))
      {
        localObject2 = localObject1;
        if (l1 > paramLong) {
          break;
        }
      }
      i1++;
      localObject1 = localObject2;
    }
    return (g.b)localObject1;
  }
  
  private static g.d D(List<g.d> paramList, long paramLong)
  {
    return (g.d)paramList.get(o0.f(paramList, Long.valueOf(paramLong), true, true));
  }
  
  private long E(com.google.android.exoplayer2.source.hls.playlist.g paramg)
  {
    long l1;
    if (paramg.p) {
      l1 = w0.d(o0.T(this.q)) - paramg.e();
    } else {
      l1 = 0L;
    }
    return l1;
  }
  
  private long F(com.google.android.exoplayer2.source.hls.playlist.g paramg, long paramLong)
  {
    long l1 = paramg.e;
    if (l1 != -9223372036854775807L) {
      paramLong = l1;
    } else {
      paramLong = paramg.u + paramLong - w0.d(this.s.c);
    }
    if (paramg.g) {
      return paramLong;
    }
    g.b localb = C(paramg.s, paramLong);
    if (localb != null) {
      return localb.x;
    }
    if (paramg.r.isEmpty()) {
      return 0L;
    }
    paramg = D(paramg.r, paramLong);
    localb = C(paramg.I3, paramLong);
    if (localb != null) {
      return localb.x;
    }
    return paramg.x;
  }
  
  private static long G(com.google.android.exoplayer2.source.hls.playlist.g paramg, long paramLong)
  {
    g.f localf = paramg.v;
    long l1 = paramg.e;
    if (l1 != -9223372036854775807L)
    {
      l1 = paramg.u - l1;
    }
    else
    {
      l1 = localf.d;
      if ((l1 == -9223372036854775807L) || (paramg.n == -9223372036854775807L))
      {
        l1 = localf.c;
        if (l1 == -9223372036854775807L) {
          l1 = paramg.m * 3L;
        }
      }
    }
    return l1 + paramLong;
  }
  
  private void H(long paramLong)
  {
    paramLong = w0.e(paramLong);
    if (paramLong != this.s.c) {
      this.s = this.r.a().o(paramLong).a().e;
    }
  }
  
  public b0 a(e0.a parama, com.google.android.exoplayer2.upstream.e parame, long paramLong)
  {
    f0.a locala = t(parama);
    parama = r(parama);
    return new o(this.g, this.p, this.i, this.t, this.k, parama, this.l, locala, parame, this.j, this.m, this.n, this.o);
  }
  
  public void c(com.google.android.exoplayer2.source.hls.playlist.g paramg)
  {
    long l1;
    if (paramg.p) {
      l1 = w0.e(paramg.h);
    } else {
      l1 = -9223372036854775807L;
    }
    int i1 = paramg.d;
    long l2;
    if ((i1 != 2) && (i1 != 1)) {
      l2 = -9223372036854775807L;
    } else {
      l2 = l1;
    }
    l locall = new l((com.google.android.exoplayer2.source.hls.playlist.f)com.google.android.exoplayer2.util.g.e(this.p.e()), paramg);
    if (this.p.j()) {
      paramg = A(paramg, l2, l1, locall);
    } else {
      paramg = B(paramg, l2, l1, locall);
    }
    y(paramg);
  }
  
  public l1 f()
  {
    return this.r;
  }
  
  public void g(b0 paramb0)
  {
    ((o)paramb0).B();
  }
  
  public void n()
    throws IOException
  {
    this.p.m();
  }
  
  protected void x(@Nullable a0 parama0)
  {
    this.t = parama0;
    this.k.prepare();
    parama0 = t(null);
    this.p.l(this.h.a, parama0, this);
  }
  
  protected void z()
  {
    this.p.stop();
    this.k.release();
  }
  
  public static final class Factory
    implements g0
  {
    private final j a;
    private k b;
    private i c;
    private HlsPlaylistTracker.a d;
    private r e;
    private z f;
    private com.google.android.exoplayer2.upstream.x g;
    private boolean h;
    private int i;
    private boolean j;
    private List<StreamKey> k;
    @Nullable
    private Object l;
    private long m;
    
    public Factory(j paramj)
    {
      this.a = ((j)com.google.android.exoplayer2.util.g.e(paramj));
      this.f = new com.google.android.exoplayer2.drm.s();
      this.c = new c();
      this.d = d.c;
      this.b = k.a;
      this.g = new t();
      this.e = new com.google.android.exoplayer2.source.s();
      this.i = 1;
      this.k = Collections.emptyList();
      this.m = -9223372036854775807L;
    }
    
    public Factory(l.a parama)
    {
      this(new f(parama));
    }
    
    public int[] b()
    {
      return new int[] { 2 };
    }
    
    public HlsMediaSource c(l1 paraml1)
    {
      l1 locall1 = paraml1;
      com.google.android.exoplayer2.util.g.e(locall1.d);
      Object localObject1 = this.c;
      if (locall1.d.e.isEmpty()) {
        localObject2 = this.k;
      } else {
        localObject2 = locall1.d.e;
      }
      Object localObject3 = localObject1;
      if (!((List)localObject2).isEmpty()) {
        localObject3 = new com.google.android.exoplayer2.source.hls.playlist.e((i)localObject1, (List)localObject2);
      }
      Object localObject4 = locall1.d;
      localObject1 = ((l1.g)localObject4).h;
      int n = 1;
      int i1;
      if ((localObject1 == null) && (this.l != null)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((!((l1.g)localObject4).e.isEmpty()) || (((List)localObject2).isEmpty())) {
        n = 0;
      }
      if ((i1 != 0) && (n != 0)) {
        locall1 = paraml1.a().t(this.l).r((List)localObject2).a();
      } else if (i1 != 0) {
        locall1 = paraml1.a().t(this.l).a();
      } else if (n != 0) {
        locall1 = paraml1.a().r((List)localObject2).a();
      }
      Object localObject2 = this.a;
      k localk = this.b;
      localObject4 = this.e;
      paraml1 = this.f.a(locall1);
      localObject1 = this.g;
      return new HlsMediaSource(locall1, (j)localObject2, localk, (r)localObject4, paraml1, (com.google.android.exoplayer2.upstream.x)localObject1, this.d.a(this.a, (com.google.android.exoplayer2.upstream.x)localObject1, (i)localObject3), this.m, this.h, this.i, this.j, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\HlsMediaSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */