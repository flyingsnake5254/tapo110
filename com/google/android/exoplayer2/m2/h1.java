package com.google.android.exoplayer2.m2;

import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.j2.b;
import com.google.android.exoplayer2.j2.c;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.u1.b;
import com.google.android.exoplayer2.u1.e;
import com.google.android.exoplayer2.u1.f;
import com.google.android.exoplayer2.upstream.g.a;
import com.google.android.exoplayer2.util.t.a;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.b;
import com.google.common.collect.j1;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class h1
  implements u1.e, com.google.android.exoplayer2.audio.t, com.google.android.exoplayer2.video.y, com.google.android.exoplayer2.source.f0, g.a, com.google.android.exoplayer2.drm.v
{
  private final com.google.android.exoplayer2.util.h c;
  private final j2.b d;
  private final j2.c f;
  private com.google.android.exoplayer2.util.r p0;
  private boolean p1;
  private final a q;
  private final SparseArray<i1.a> x;
  private com.google.android.exoplayer2.util.t<i1> y;
  private u1 z;
  
  public h1(com.google.android.exoplayer2.util.h paramh)
  {
    this.c = ((com.google.android.exoplayer2.util.h)com.google.android.exoplayer2.util.g.e(paramh));
    this.y = new com.google.android.exoplayer2.util.t(com.google.android.exoplayer2.util.o0.L(), paramh, m0.a);
    paramh = new j2.b();
    this.d = paramh;
    this.f = new j2.c();
    this.q = new a(paramh);
    this.x = new SparseArray();
  }
  
  private i1.a p0(@Nullable e0.a parama)
  {
    com.google.android.exoplayer2.util.g.e(this.z);
    j2 localj2;
    if (parama == null) {
      localj2 = null;
    } else {
      localj2 = this.q.f(parama);
    }
    if ((parama != null) && (localj2 != null)) {
      return o0(localj2, localj2.h(parama.a, this.d).d, parama);
    }
    int i = this.z.m();
    parama = this.z.w();
    int j;
    if (i < parama.p()) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0) {
      parama = j2.a;
    }
    return o0(parama, i, null);
  }
  
  private i1.a q0()
  {
    return p0(this.q.e());
  }
  
  private i1.a r0(int paramInt, @Nullable e0.a parama)
  {
    com.google.android.exoplayer2.util.g.e(this.z);
    int i = 1;
    int j = 1;
    if (parama != null)
    {
      if (this.q.f(parama) == null) {
        j = 0;
      }
      if (j != 0) {
        parama = p0(parama);
      } else {
        parama = o0(j2.a, paramInt, parama);
      }
      return parama;
    }
    parama = this.z.w();
    if (paramInt < parama.p()) {
      j = i;
    } else {
      j = 0;
    }
    if (j == 0) {
      parama = j2.a;
    }
    return o0(parama, paramInt, null);
  }
  
  private i1.a s0()
  {
    return p0(this.q.g());
  }
  
  private i1.a t0()
  {
    return p0(this.q.h());
  }
  
  public final void D(Format paramFormat, @Nullable com.google.android.exoplayer2.decoder.e parame)
  {
    i1.a locala = t0();
    F1(locala, 1022, new t0(locala, paramFormat, parame));
  }
  
  public final void D1()
  {
    if (!this.p1)
    {
      i1.a locala = n0();
      this.p1 = true;
      F1(locala, -1, new o(locala));
    }
  }
  
  public final void E(long paramLong)
  {
    i1.a locala = t0();
    F1(locala, 1011, new x0(locala, paramLong));
  }
  
  @CallSuper
  public void E1()
  {
    i1.a locala = n0();
    this.x.put(1036, locala);
    F1(locala, 1036, new y(locala));
    ((com.google.android.exoplayer2.util.r)com.google.android.exoplayer2.util.g.i(this.p0)).h(new v(this));
  }
  
  public final void F(Exception paramException)
  {
    i1.a locala = t0();
    F1(locala, 1038, new d(locala, paramException));
  }
  
  protected final void F1(i1.a parama, int paramInt, t.a<i1> parama1)
  {
    this.x.put(paramInt, parama);
    this.y.j(paramInt, parama1);
  }
  
  public final void G(TrackGroupArray paramTrackGroupArray, com.google.android.exoplayer2.trackselection.k paramk)
  {
    i1.a locala = n0();
    F1(locala, 2, new f0(locala, paramTrackGroupArray, paramk));
  }
  
  @CallSuper
  public void G1(u1 paramu1, Looper paramLooper)
  {
    boolean bool;
    if ((this.z != null) && (!a.a(this.q).isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    com.google.android.exoplayer2.util.g.g(bool);
    this.z = ((u1)com.google.android.exoplayer2.util.g.e(paramu1));
    this.p0 = this.c.b(paramLooper, null);
    this.y = this.y.b(paramLooper, new f(this, paramu1));
  }
  
  public final void H(com.google.android.exoplayer2.decoder.d paramd)
  {
    i1.a locala = s0();
    F1(locala, 1025, new o0(locala, paramd));
  }
  
  public final void H1(List<e0.a> paramList, @Nullable e0.a parama)
  {
    this.q.k(paramList, parama, (u1)com.google.android.exoplayer2.util.g.e(this.z));
  }
  
  public void I(int paramInt1, int paramInt2)
  {
    i1.a locala = t0();
    F1(locala, 1029, new h(locala, paramInt1, paramInt2));
  }
  
  public final void L(com.google.android.exoplayer2.decoder.d paramd)
  {
    i1.a locala = s0();
    F1(locala, 1014, new q(locala, paramd));
  }
  
  public final void M(boolean paramBoolean)
  {
    i1.a locala = n0();
    F1(locala, 4, new k(locala, paramBoolean));
  }
  
  public final void N(int paramInt, @Nullable e0.a parama, com.google.android.exoplayer2.source.a0 parama0)
  {
    parama = r0(paramInt, parama);
    F1(parama, 1005, new w0(parama, parama0));
  }
  
  public final void O()
  {
    i1.a locala = n0();
    F1(locala, -1, new r0(locala));
  }
  
  public final void P(PlaybackException paramPlaybackException)
  {
    if ((paramPlaybackException instanceof ExoPlaybackException))
    {
      localObject1 = ((ExoPlaybackException)paramPlaybackException).mediaPeriodId;
      if (localObject1 != null)
      {
        localObject1 = p0(new e0.a((com.google.android.exoplayer2.source.c0)localObject1));
        break label37;
      }
    }
    Object localObject1 = null;
    label37:
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = n0();
    }
    F1((i1.a)localObject2, 11, new p0((i1.a)localObject2, paramPlaybackException));
  }
  
  public final void Q(int paramInt, @Nullable e0.a parama, Exception paramException)
  {
    parama = r0(paramInt, parama);
    F1(parama, 1032, new w(parama, paramException));
  }
  
  public final void R(float paramFloat)
  {
    i1.a locala = t0();
    F1(locala, 1019, new e1(locala, paramFloat));
  }
  
  public final void T(int paramInt, long paramLong)
  {
    i1.a locala = s0();
    F1(locala, 1023, new z(locala, paramInt, paramLong));
  }
  
  public final void U(boolean paramBoolean, int paramInt)
  {
    i1.a locala = n0();
    F1(locala, -1, new a0(locala, paramBoolean, paramInt));
  }
  
  public final void V(Format paramFormat, @Nullable com.google.android.exoplayer2.decoder.e parame)
  {
    i1.a locala = t0();
    F1(locala, 1010, new e0(locala, paramFormat, parame));
  }
  
  public final void X(Object paramObject, long paramLong)
  {
    i1.a locala = t0();
    F1(locala, 1027, new j0(locala, paramObject, paramLong));
  }
  
  public final void Y(@Nullable l1 paraml1, int paramInt)
  {
    i1.a locala = n0();
    F1(locala, 1, new v0(locala, paraml1, paramInt));
  }
  
  public final void Z(com.google.android.exoplayer2.decoder.d paramd)
  {
    i1.a locala = t0();
    F1(locala, 1020, new j(locala, paramd));
  }
  
  public final void a(boolean paramBoolean)
  {
    i1.a locala = t0();
    F1(locala, 1017, new d0(locala, paramBoolean));
  }
  
  public final void a0(int paramInt, @Nullable e0.a parama)
  {
    parama = r0(paramInt, parama);
    F1(parama, 1031, new p(parama));
  }
  
  public final void b(Exception paramException)
  {
    i1.a locala = t0();
    F1(locala, 1018, new g(locala, paramException));
  }
  
  public final void b0(Exception paramException)
  {
    i1.a locala = t0();
    F1(locala, 1037, new a1(locala, paramException));
  }
  
  public final void c(com.google.android.exoplayer2.video.z paramz)
  {
    i1.a locala = t0();
    F1(locala, 1028, new g1(locala, paramz));
  }
  
  public final void d(t1 paramt1)
  {
    i1.a locala = n0();
    F1(locala, 13, new r(locala, paramt1));
  }
  
  public final void d0(boolean paramBoolean, int paramInt)
  {
    i1.a locala = n0();
    F1(locala, 6, new y0(locala, paramBoolean, paramInt));
  }
  
  public final void e(u1.f paramf1, u1.f paramf2, int paramInt)
  {
    if (paramInt == 1) {
      this.p1 = false;
    }
    this.q.j((u1)com.google.android.exoplayer2.util.g.e(this.z));
    i1.a locala = n0();
    F1(locala, 12, new c1(locala, paramInt, paramf1, paramf2));
  }
  
  public final void e0(int paramInt, @Nullable e0.a parama, com.google.android.exoplayer2.source.x paramx, com.google.android.exoplayer2.source.a0 parama0)
  {
    parama = r0(paramInt, parama);
    F1(parama, 1001, new m(parama, paramx, parama0));
  }
  
  public final void f(int paramInt)
  {
    i1.a locala = n0();
    F1(locala, 7, new a(locala, paramInt));
  }
  
  public final void f0(int paramInt1, @Nullable e0.a parama, int paramInt2)
  {
    parama = r0(paramInt1, parama);
    F1(parama, 1030, new i0(parama, paramInt2));
  }
  
  public final void g0(int paramInt, @Nullable e0.a parama)
  {
    parama = r0(paramInt, parama);
    F1(parama, 1035, new u(parama));
  }
  
  public final void h(String paramString)
  {
    i1.a locala = t0();
    F1(locala, 1024, new n0(locala, paramString));
  }
  
  public final void h0(int paramInt, long paramLong1, long paramLong2)
  {
    i1.a locala = t0();
    F1(locala, 1012, new b1(locala, paramInt, paramLong1, paramLong2));
  }
  
  public final void i(com.google.android.exoplayer2.decoder.d paramd)
  {
    i1.a locala = t0();
    F1(locala, 1008, new n(locala, paramd));
  }
  
  public final void i0(int paramInt, @Nullable e0.a parama, com.google.android.exoplayer2.source.x paramx, com.google.android.exoplayer2.source.a0 parama0, IOException paramIOException, boolean paramBoolean)
  {
    parama = r0(paramInt, parama);
    F1(parama, 1003, new l(parama, paramx, parama0, paramIOException, paramBoolean));
  }
  
  @Deprecated
  public final void j(List<Metadata> paramList)
  {
    i1.a locala = n0();
    F1(locala, 3, new t(locala, paramList));
  }
  
  public final void j0(long paramLong, int paramInt)
  {
    i1.a locala = s0();
    F1(locala, 1026, new z0(locala, paramLong, paramInt));
  }
  
  public final void k(String paramString, long paramLong1, long paramLong2)
  {
    i1.a locala = t0();
    F1(locala, 1021, new b(locala, paramString, paramLong2, paramLong1));
  }
  
  public final void l(int paramInt, @Nullable e0.a parama, com.google.android.exoplayer2.source.a0 parama0)
  {
    parama = r0(paramInt, parama);
    F1(parama, 1004, new d1(parama, parama0));
  }
  
  public final void l0(int paramInt, @Nullable e0.a parama)
  {
    parama = r0(paramInt, parama);
    F1(parama, 1033, new i(parama));
  }
  
  public final void m(int paramInt, @Nullable e0.a parama, com.google.android.exoplayer2.source.x paramx, com.google.android.exoplayer2.source.a0 parama0)
  {
    parama = r0(paramInt, parama);
    F1(parama, 1002, new q0(parama, paramx, parama0));
  }
  
  public void m0(boolean paramBoolean)
  {
    i1.a locala = n0();
    F1(locala, 8, new l0(locala, paramBoolean));
  }
  
  public void n(u1.b paramb)
  {
    i1.a locala = n0();
    F1(locala, 14, new c(locala, paramb));
  }
  
  protected final i1.a n0()
  {
    return p0(this.q.d());
  }
  
  public final void o(j2 paramj2, int paramInt)
  {
    this.q.l((u1)com.google.android.exoplayer2.util.g.e(this.z));
    paramj2 = n0();
    F1(paramj2, 0, new u0(paramj2, paramInt));
  }
  
  @RequiresNonNull({"player"})
  protected final i1.a o0(j2 paramj2, int paramInt, @Nullable e0.a parama)
  {
    if (paramj2.q()) {
      parama = null;
    }
    long l1 = this.c.elapsedRealtime();
    boolean bool = paramj2.equals(this.z.w());
    int i = 1;
    int j;
    if ((bool) && (paramInt == this.z.m())) {
      j = 1;
    } else {
      j = 0;
    }
    long l2 = 0L;
    if ((parama != null) && (parama.b()))
    {
      if ((j != 0) && (this.z.r() == parama.b) && (this.z.K() == parama.c)) {
        j = i;
      } else {
        j = 0;
      }
      if (j != 0) {
        l2 = this.z.V();
      }
    }
    else if (j != 0)
    {
      l2 = this.z.M();
    }
    else if (!paramj2.q())
    {
      l2 = paramj2.n(paramInt, this.f).b();
    }
    e0.a locala = this.q.d();
    return new i1.a(l1, paramj2, paramInt, parama, l2, this.z.w(), this.z.m(), locala, this.z.V(), this.z.g());
  }
  
  public final void onRepeatModeChanged(int paramInt)
  {
    i1.a locala = n0();
    F1(locala, 9, new f1(locala, paramInt));
  }
  
  public final void p(int paramInt, @Nullable e0.a parama, com.google.android.exoplayer2.source.x paramx, com.google.android.exoplayer2.source.a0 parama0)
  {
    parama = r0(paramInt, parama);
    F1(parama, 1000, new s(parama, paramx, parama0));
  }
  
  public final void q(int paramInt)
  {
    i1.a locala = n0();
    F1(locala, 5, new s0(locala, paramInt));
  }
  
  public final void r(int paramInt, long paramLong1, long paramLong2)
  {
    i1.a locala = q0();
    F1(locala, 1006, new c0(locala, paramInt, paramLong1, paramLong2));
  }
  
  public void s(m1 paramm1)
  {
    i1.a locala = n0();
    F1(locala, 15, new h0(locala, paramm1));
  }
  
  public final void t(String paramString)
  {
    i1.a locala = t0();
    F1(locala, 1013, new e(locala, paramString));
  }
  
  public final void u(String paramString, long paramLong1, long paramLong2)
  {
    i1.a locala = t0();
    F1(locala, 1009, new g0(locala, paramString, paramLong2, paramLong1));
  }
  
  public final void v(boolean paramBoolean)
  {
    i1.a locala = n0();
    F1(locala, 10, new b0(locala, paramBoolean));
  }
  
  public final void w(Metadata paramMetadata)
  {
    i1.a locala = n0();
    F1(locala, 1007, new k0(locala, paramMetadata));
  }
  
  public final void y(int paramInt, @Nullable e0.a parama)
  {
    parama = r0(paramInt, parama);
    F1(parama, 1034, new x(parama));
  }
  
  private static final class a
  {
    private final j2.b a;
    private ImmutableList<e0.a> b;
    private ImmutableMap<e0.a, j2> c;
    @Nullable
    private e0.a d;
    private e0.a e;
    private e0.a f;
    
    public a(j2.b paramb)
    {
      this.a = paramb;
      this.b = ImmutableList.of();
      this.c = ImmutableMap.of();
    }
    
    private void b(ImmutableMap.b<e0.a, j2> paramb, @Nullable e0.a parama, j2 paramj2)
    {
      if (parama == null) {
        return;
      }
      if (paramj2.b(parama.a) != -1)
      {
        paramb.c(parama, paramj2);
      }
      else
      {
        paramj2 = (j2)this.c.get(parama);
        if (paramj2 != null) {
          paramb.c(parama, paramj2);
        }
      }
    }
    
    @Nullable
    private static e0.a c(u1 paramu1, ImmutableList<e0.a> paramImmutableList, @Nullable e0.a parama, j2.b paramb)
    {
      j2 localj2 = paramu1.w();
      int i = paramu1.H();
      Object localObject;
      if (localj2.q()) {
        localObject = null;
      } else {
        localObject = localj2.m(i);
      }
      if ((!paramu1.f()) && (!localj2.q())) {
        i = localj2.f(i, paramb).d(com.google.android.exoplayer2.w0.d(paramu1.V()) - paramb.m());
      } else {
        i = -1;
      }
      for (int j = 0; j < paramImmutableList.size(); j++)
      {
        paramb = (e0.a)paramImmutableList.get(j);
        if (i(paramb, localObject, paramu1.f(), paramu1.r(), paramu1.K(), i)) {
          return paramb;
        }
      }
      if ((paramImmutableList.isEmpty()) && (parama != null) && (i(parama, localObject, paramu1.f(), paramu1.r(), paramu1.K(), i))) {
        return parama;
      }
      return null;
    }
    
    private static boolean i(e0.a parama, @Nullable Object paramObject, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
    {
      boolean bool1 = parama.a.equals(paramObject);
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      if ((!paramBoolean) || (parama.b != paramInt1) || (parama.c != paramInt2))
      {
        bool1 = bool2;
        if (!paramBoolean)
        {
          bool1 = bool2;
          if (parama.b == -1)
          {
            bool1 = bool2;
            if (parama.e != paramInt3) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    
    private void m(j2 paramj2)
    {
      ImmutableMap.b localb = ImmutableMap.builder();
      if (this.b.isEmpty())
      {
        b(localb, this.e, paramj2);
        if (!com.google.common.base.k.a(this.f, this.e)) {
          b(localb, this.f, paramj2);
        }
        if ((!com.google.common.base.k.a(this.d, this.e)) && (!com.google.common.base.k.a(this.d, this.f))) {
          b(localb, this.d, paramj2);
        }
      }
      else
      {
        for (int i = 0; i < this.b.size(); i++) {
          b(localb, (e0.a)this.b.get(i), paramj2);
        }
        if (!this.b.contains(this.d)) {
          b(localb, this.d, paramj2);
        }
      }
      this.c = localb.a();
    }
    
    @Nullable
    public e0.a d()
    {
      return this.d;
    }
    
    @Nullable
    public e0.a e()
    {
      e0.a locala;
      if (this.b.isEmpty()) {
        locala = null;
      } else {
        locala = (e0.a)j1.f(this.b);
      }
      return locala;
    }
    
    @Nullable
    public j2 f(e0.a parama)
    {
      return (j2)this.c.get(parama);
    }
    
    @Nullable
    public e0.a g()
    {
      return this.e;
    }
    
    @Nullable
    public e0.a h()
    {
      return this.f;
    }
    
    public void j(u1 paramu1)
    {
      this.d = c(paramu1, this.b, this.e, this.a);
    }
    
    public void k(List<e0.a> paramList, @Nullable e0.a parama, u1 paramu1)
    {
      this.b = ImmutableList.copyOf(paramList);
      if (!paramList.isEmpty())
      {
        this.e = ((e0.a)paramList.get(0));
        this.f = ((e0.a)com.google.android.exoplayer2.util.g.e(parama));
      }
      if (this.d == null) {
        this.d = c(paramu1, this.b, this.e, this.a);
      }
      m(paramu1.w());
    }
    
    public void l(u1 paramu1)
    {
      this.d = c(paramu1, this.b, this.e, this.a);
      m(paramu1.w());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\m2\h1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */