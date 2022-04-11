package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.source.g0;
import com.google.android.exoplayer2.source.p0;
import com.google.android.exoplayer2.source.p0.a;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.upstream.g.a;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

final class f1
  extends t0
  implements e1
{
  private g2 A;
  private p0 B;
  private boolean C;
  private u1.b D;
  private m1 E;
  private m1 F;
  private s1 G;
  private int H;
  private int I;
  private long J;
  final com.google.android.exoplayer2.trackselection.n b;
  final u1.b c;
  private final b2[] d;
  private final com.google.android.exoplayer2.trackselection.m e;
  private final com.google.android.exoplayer2.util.r f;
  private final g1.f g;
  private final g1 h;
  private final com.google.android.exoplayer2.util.t<u1.c> i;
  private final CopyOnWriteArraySet<e1.a> j;
  private final j2.b k;
  private final List<a> l;
  private final boolean m;
  private final g0 n;
  @Nullable
  private final com.google.android.exoplayer2.m2.h1 o;
  private final Looper p;
  private final com.google.android.exoplayer2.upstream.g q;
  private final long r;
  private final long s;
  private final com.google.android.exoplayer2.util.h t;
  private int u;
  private boolean v;
  private int w;
  private int x;
  private boolean y;
  private int z;
  
  @SuppressLint({"HandlerLeak"})
  public f1(b2[] paramArrayOfb2, com.google.android.exoplayer2.trackselection.m paramm, g0 paramg0, k1 paramk1, com.google.android.exoplayer2.upstream.g paramg, @Nullable com.google.android.exoplayer2.m2.h1 paramh1, boolean paramBoolean1, g2 paramg2, long paramLong1, long paramLong2, j1 paramj1, long paramLong3, boolean paramBoolean2, com.google.android.exoplayer2.util.h paramh, Looper paramLooper, @Nullable u1 paramu1, u1.b paramb)
  {
    String str1 = Integer.toHexString(System.identityHashCode(this));
    String str2 = o0.e;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 30 + String.valueOf(str2).length());
    localStringBuilder.append("Init ");
    localStringBuilder.append(str1);
    localStringBuilder.append(" [");
    localStringBuilder.append("ExoPlayerLib/2.15.0");
    localStringBuilder.append("] [");
    localStringBuilder.append(str2);
    localStringBuilder.append("]");
    com.google.android.exoplayer2.util.u.f("ExoPlayerImpl", localStringBuilder.toString());
    boolean bool;
    if (paramArrayOfb2.length > 0) {
      bool = true;
    } else {
      bool = false;
    }
    com.google.android.exoplayer2.util.g.g(bool);
    this.d = ((b2[])com.google.android.exoplayer2.util.g.e(paramArrayOfb2));
    this.e = ((com.google.android.exoplayer2.trackselection.m)com.google.android.exoplayer2.util.g.e(paramm));
    this.n = paramg0;
    this.q = paramg;
    this.o = paramh1;
    this.m = paramBoolean1;
    this.A = paramg2;
    this.r = paramLong1;
    this.s = paramLong2;
    this.C = paramBoolean2;
    this.p = paramLooper;
    this.t = paramh;
    this.u = 0;
    if (paramu1 != null) {
      paramg0 = paramu1;
    } else {
      paramg0 = this;
    }
    this.i = new com.google.android.exoplayer2.util.t(paramLooper, paramh, new n(paramg0));
    this.j = new CopyOnWriteArraySet();
    this.l = new ArrayList();
    this.B = new p0.a(0);
    paramu1 = new com.google.android.exoplayer2.trackselection.n(new e2[paramArrayOfb2.length], new com.google.android.exoplayer2.trackselection.g[paramArrayOfb2.length], null);
    this.b = paramu1;
    this.k = new j2.b();
    paramb = new u1.b.a().c(new int[] { 1, 2, 12, 13, 14, 15, 16, 17, 18, 19 }).b(paramb).e();
    this.c = paramb;
    this.D = new u1.b.a().b(paramb).a(3).a(9).e();
    paramb = m1.a;
    this.E = paramb;
    this.F = paramb;
    this.H = -1;
    this.f = paramh.b(paramLooper, null);
    paramb = new r(this);
    this.g = paramb;
    this.G = s1.k(paramu1);
    if (paramh1 != null)
    {
      paramh1.G1(paramg0, paramLooper);
      N(paramh1);
      paramg.g(new Handler(paramLooper), paramh1);
    }
    this.h = new g1(paramArrayOfb2, paramm, paramu1, paramk1, paramg, this.u, this.v, paramh1, paramg2, paramj1, paramLong3, paramBoolean2, paramLooper, paramh, paramb);
  }
  
  private u1.f A0(long paramLong)
  {
    int i1 = m();
    boolean bool = this.G.b.q();
    Object localObject1 = null;
    Object localObject2;
    int i2;
    if (!bool)
    {
      localObject1 = this.G;
      localObject2 = ((s1)localObject1).c.a;
      ((s1)localObject1).b.h(localObject2, this.k);
      i2 = this.G.b.b(localObject2);
      localObject1 = this.G.b.n(i1, this.a).e;
    }
    else
    {
      localObject2 = null;
      i2 = -1;
    }
    long l1 = w0.e(paramLong);
    if (this.G.c.b()) {
      paramLong = w0.e(C0(this.G));
    } else {
      paramLong = l1;
    }
    e0.a locala = this.G.c;
    return new u1.f(localObject1, i1, localObject2, i2, l1, paramLong, locala.b, locala.c);
  }
  
  private u1.f B0(int paramInt1, s1 params1, int paramInt2)
  {
    j2.b localb = new j2.b();
    Object localObject1;
    int i1;
    Object localObject2;
    if (!params1.b.q())
    {
      localObject1 = params1.c.a;
      params1.b.h(localObject1, localb);
      i1 = localb.d;
      paramInt2 = params1.b.b(localObject1);
      localObject2 = params1.b.n(i1, this.a).e;
    }
    else
    {
      i1 = paramInt2;
      localObject2 = null;
      localObject1 = localObject2;
      paramInt2 = -1;
    }
    if (paramInt1 == 0)
    {
      l1 = localb.f + localb.e;
      if (params1.c.b())
      {
        e0.a locala = params1.c;
        l1 = localb.b(locala.b, locala.c);
        l2 = C0(params1);
        break label242;
      }
      l2 = l1;
      if (params1.c.e != -1)
      {
        l2 = l1;
        if (this.G.c.b()) {
          l2 = C0(this.G);
        }
      }
    }
    else
    {
      if (params1.c.b())
      {
        l1 = params1.t;
        l2 = C0(params1);
        break label242;
      }
      l2 = localb.f + params1.t;
    }
    long l3 = l2;
    long l1 = l2;
    long l2 = l3;
    label242:
    l1 = w0.e(l1);
    l2 = w0.e(l2);
    params1 = params1.c;
    return new u1.f(localObject2, i1, localObject1, paramInt2, l1, l2, params1.b, params1.c);
  }
  
  private static long C0(s1 params1)
  {
    j2.c localc = new j2.c();
    j2.b localb = new j2.b();
    params1.b.h(params1.c.a, localb);
    long l1;
    if (params1.d == -9223372036854775807L) {
      l1 = params1.b.n(localb.d, localc).c();
    } else {
      l1 = localb.m() + params1.d;
    }
    return l1;
  }
  
  private void D0(g1.e parame)
  {
    int i1 = this.w - parame.c;
    this.w = i1;
    boolean bool1 = parame.d;
    boolean bool2 = true;
    if (bool1)
    {
      this.x = parame.e;
      this.y = true;
    }
    if (parame.f) {
      this.z = parame.g;
    }
    if (i1 == 0)
    {
      j2 localj2 = parame.b.b;
      if ((!this.G.b.q()) && (localj2.q()))
      {
        this.H = -1;
        this.J = 0L;
        this.I = 0;
      }
      Object localObject;
      if (!localj2.q())
      {
        localObject = ((y1)localj2).E();
        if (((List)localObject).size() == this.l.size()) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        com.google.android.exoplayer2.util.g.g(bool1);
        for (i1 = 0; i1 < ((List)localObject).size(); i1++) {
          a.b((a)this.l.get(i1), (j2)((List)localObject).get(i1));
        }
      }
      long l1;
      if (this.y)
      {
        bool1 = bool2;
        if (parame.b.c.equals(this.G.c)) {
          if (parame.b.e != this.G.t) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        if (bool1)
        {
          if ((!localj2.q()) && (!parame.b.c.b()))
          {
            localObject = parame.b;
            l1 = i1(localj2, ((s1)localObject).c, ((s1)localObject).e);
          }
          else
          {
            l1 = parame.b.e;
          }
        }
        else {
          l1 = -9223372036854775807L;
        }
      }
      else
      {
        l1 = -9223372036854775807L;
        bool1 = false;
      }
      this.y = false;
      r1(parame.b, 1, this.z, false, bool1, this.x, l1, -1);
    }
  }
  
  private static boolean E0(s1 params1)
  {
    boolean bool;
    if ((params1.f == 3) && (params1.m) && (params1.n == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private s1 g1(s1 params1, j2 paramj2, @Nullable Pair<Object, Long> paramPair)
  {
    boolean bool1;
    if ((!paramj2.q()) && (paramPair == null)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    com.google.android.exoplayer2.util.g.a(bool1);
    j2 localj2 = params1.b;
    s1 locals1 = params1.j(paramj2);
    if (paramj2.q())
    {
      params1 = s1.l();
      l1 = w0.d(this.J);
      params1 = locals1.c(params1, l1, l1, l1, 0L, TrackGroupArray.c, this.b, ImmutableList.of()).b(params1);
      params1.r = params1.t;
      return params1;
    }
    params1 = locals1.c.a;
    boolean bool2 = params1.equals(((Pair)o0.i(paramPair)).first) ^ true;
    e0.a locala;
    if (bool2) {
      locala = new e0.a(paramPair.first);
    } else {
      locala = locals1.c;
    }
    long l2 = ((Long)paramPair.second).longValue();
    long l3 = w0.d(M());
    long l1 = l3;
    if (!localj2.q()) {
      l1 = l3 - localj2.h(params1, this.k).m();
    }
    if (!bool2)
    {
      boolean bool3 = l2 < l1;
      if (!bool3)
      {
        if (!bool3)
        {
          int i1 = paramj2.b(locals1.l.a);
          if (i1 != -1)
          {
            params1 = locals1;
            if (paramj2.f(i1, this.k).d == paramj2.h(locala.a, this.k).d) {}
          }
          else
          {
            paramj2.h(locala.a, this.k);
            if (locala.b()) {
              l1 = this.k.b(locala.b, locala.c);
            } else {
              l1 = this.k.e;
            }
            params1 = locals1.c(locala, locals1.t, locals1.t, locals1.e, l1 - locals1.t, locals1.i, locals1.j, locals1.k).b(locala);
          }
        }
        for (params1.r = l1;; params1.r = l1)
        {
          break;
          com.google.android.exoplayer2.util.g.g(locala.b() ^ true);
          l3 = Math.max(0L, locals1.s - (l2 - l1));
          l1 = locals1.r;
          if (locals1.l.equals(locals1.c)) {
            l1 = l2 + l3;
          }
          params1 = locals1.c(locala, l2, l2, l2, l3, locals1.i, locals1.j, locals1.k);
        }
      }
    }
    com.google.android.exoplayer2.util.g.g(locala.b() ^ true);
    if (bool2) {
      params1 = TrackGroupArray.c;
    } else {
      params1 = locals1.i;
    }
    if (bool2) {
      paramj2 = this.b;
    } else {
      paramj2 = locals1.j;
    }
    if (bool2) {
      paramPair = ImmutableList.of();
    } else {
      paramPair = locals1.k;
    }
    params1 = locals1.c(locala, l2, l2, l2, 0L, params1, paramj2, paramPair).b(locala);
    params1.r = l2;
    return params1;
  }
  
  private long i1(j2 paramj2, e0.a parama, long paramLong)
  {
    paramj2.h(parama.a, this.k);
    return paramLong + this.k.m();
  }
  
  private s1 k1(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    boolean bool;
    if ((paramInt1 >= 0) && (paramInt2 >= paramInt1) && (paramInt2 <= this.l.size())) {
      bool = true;
    } else {
      bool = false;
    }
    com.google.android.exoplayer2.util.g.a(bool);
    int i2 = m();
    Object localObject1 = w();
    int i3 = this.l.size();
    this.w += 1;
    l1(paramInt1, paramInt2);
    Object localObject2 = o0();
    localObject1 = g1(this.G, (j2)localObject2, x0((j2)localObject1, (j2)localObject2));
    int i4 = ((s1)localObject1).f;
    int i5 = i1;
    if (i4 != 1)
    {
      i5 = i1;
      if (i4 != 4)
      {
        i5 = i1;
        if (paramInt1 < paramInt2)
        {
          i5 = i1;
          if (paramInt2 == i3)
          {
            i5 = i1;
            if (i2 >= ((s1)localObject1).b.p()) {
              i5 = 1;
            }
          }
        }
      }
    }
    localObject2 = localObject1;
    if (i5 != 0) {
      localObject2 = ((s1)localObject1).h(4);
    }
    this.h.o0(paramInt1, paramInt2, this.B);
    return (s1)localObject2;
  }
  
  private void l1(int paramInt1, int paramInt2)
  {
    for (int i1 = paramInt2 - 1; i1 >= paramInt1; i1--) {
      this.l.remove(i1);
    }
    this.B = this.B.b(paramInt1, paramInt2);
  }
  
  private List<r1.c> n0(int paramInt, List<e0> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i1 = 0; i1 < paramList.size(); i1++)
    {
      r1.c localc = new r1.c((e0)paramList.get(i1), this.m);
      localArrayList.add(localc);
      this.l.add(i1 + paramInt, new a(localc.b, localc.a.M()));
    }
    this.B = this.B.h(paramInt, localArrayList.size());
    return localArrayList;
  }
  
  private void n1(List<e0> paramList, int paramInt, long paramLong, boolean paramBoolean)
  {
    int i1 = w0();
    long l1 = V();
    int i2 = this.w;
    boolean bool = true;
    this.w = (i2 + 1);
    if (!this.l.isEmpty()) {
      l1(0, this.l.size());
    }
    paramList = n0(0, paramList);
    Object localObject = o0();
    if ((!((j2)localObject).q()) && (paramInt >= ((j2)localObject).p())) {
      throw new IllegalSeekPositionException((j2)localObject, paramInt, paramLong);
    }
    if (paramBoolean)
    {
      paramInt = ((j2)localObject).a(this.v);
      paramLong = -9223372036854775807L;
    }
    else if (paramInt == -1)
    {
      paramInt = i1;
      paramLong = l1;
    }
    s1 locals1 = g1(this.G, (j2)localObject, y0((j2)localObject, paramInt, paramLong));
    i2 = locals1.f;
    i1 = i2;
    if (paramInt != -1)
    {
      i1 = i2;
      if (i2 != 1) {
        if ((!((j2)localObject).q()) && (paramInt < ((j2)localObject).p())) {
          i1 = 2;
        } else {
          i1 = 4;
        }
      }
    }
    localObject = locals1.h(i1);
    this.h.N0(paramList, paramInt, w0.d(paramLong), this.B);
    if ((!this.G.c.a.equals(((s1)localObject).c.a)) && (!this.G.b.q())) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    r1((s1)localObject, 0, 1, false, paramBoolean, 4, v0((s1)localObject), -1);
  }
  
  private j2 o0()
  {
    return new y1(this.l, this.B);
  }
  
  private List<e0> p0(List<l1> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i1 = 0; i1 < paramList.size(); i1++) {
      localArrayList.add(this.n.a((l1)paramList.get(i1)));
    }
    return localArrayList;
  }
  
  private void q1()
  {
    u1.b localb1 = this.D;
    u1.b localb2 = d(this.c);
    this.D = localb2;
    if (!localb2.equals(localb1)) {
      this.i.g(14, new v(this));
    }
  }
  
  private Pair<Boolean, Integer> r0(s1 params11, s1 params12, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    j2 localj21 = params12.b;
    j2 localj22 = params11.b;
    boolean bool1 = localj22.q();
    Integer localInteger = Integer.valueOf(-1);
    if ((bool1) && (localj21.q())) {
      return new Pair(Boolean.FALSE, localInteger);
    }
    boolean bool2 = localj22.q();
    bool1 = localj21.q();
    int i1 = 3;
    if (bool2 != bool1) {
      return new Pair(Boolean.TRUE, Integer.valueOf(3));
    }
    if (!localj21.n(localj21.h(params12.c.a, this.k).d, this.a).e.equals(localj22.n(localj22.h(params11.c.a, this.k).d, this.a).e))
    {
      if ((paramBoolean1) && (paramInt == 0))
      {
        paramInt = 1;
      }
      else if ((paramBoolean1) && (paramInt == 1))
      {
        paramInt = 2;
      }
      else
      {
        if (!paramBoolean2) {
          break label214;
        }
        paramInt = i1;
      }
      return new Pair(Boolean.TRUE, Integer.valueOf(paramInt));
      label214:
      throw new IllegalStateException();
    }
    if ((paramBoolean1) && (paramInt == 0) && (params12.c.d < params11.c.d)) {
      return new Pair(Boolean.TRUE, Integer.valueOf(0));
    }
    return new Pair(Boolean.FALSE, localInteger);
  }
  
  private void r1(s1 params1, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, long paramLong, int paramInt4)
  {
    s1 locals1 = this.G;
    this.G = params1;
    Object localObject1 = r0(params1, locals1, paramBoolean2, paramInt3, locals1.b.equals(params1.b) ^ true);
    boolean bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
    int i1 = ((Integer)((Pair)localObject1).second).intValue();
    localObject1 = this.E;
    Object localObject2 = null;
    Object localObject3 = null;
    if (bool1)
    {
      localObject2 = localObject3;
      if (!params1.b.q())
      {
        int i2 = params1.b.h(params1.c.a, this.k).d;
        localObject2 = params1.b.n(i2, this.a).g;
      }
      if (localObject2 != null) {
        localObject1 = ((l1)localObject2).f;
      } else {
        localObject1 = m1.a;
      }
    }
    localObject3 = localObject1;
    if (!locals1.k.equals(params1.k)) {
      localObject3 = ((m1)localObject1).a().I(params1.k).F();
    }
    boolean bool2 = ((m1)localObject3).equals(this.E);
    this.E = ((m1)localObject3);
    if (!locals1.b.equals(params1.b)) {
      this.i.g(0, new q(params1, paramInt1));
    }
    if (paramBoolean2)
    {
      localObject3 = B0(paramInt3, locals1, paramInt4);
      localObject1 = A0(paramLong);
      this.i.g(12, new o(paramInt3, (u1.f)localObject3, (u1.f)localObject1));
    }
    if (bool1) {
      this.i.g(1, new m((l1)localObject2, i1));
    }
    if (locals1.g != params1.g)
    {
      this.i.g(11, new h(params1));
      if (params1.g != null) {
        this.i.g(11, new e(params1));
      }
    }
    localObject1 = locals1.j;
    localObject2 = params1.j;
    if (localObject1 != localObject2)
    {
      this.e.d(((com.google.android.exoplayer2.trackselection.n)localObject2).d);
      localObject1 = new com.google.android.exoplayer2.trackselection.k(params1.j.c);
      this.i.g(2, new l(params1, (com.google.android.exoplayer2.trackselection.k)localObject1));
    }
    if (!locals1.k.equals(params1.k)) {
      this.i.g(3, new i(params1));
    }
    if ((bool2 ^ true))
    {
      localObject1 = this.E;
      this.i.g(15, new u((m1)localObject1));
    }
    if (locals1.h != params1.h) {
      this.i.g(4, new w(params1));
    }
    if ((locals1.f != params1.f) || (locals1.m != params1.m)) {
      this.i.g(-1, new g(params1));
    }
    if (locals1.f != params1.f) {
      this.i.g(5, new z(params1));
    }
    if (locals1.m != params1.m) {
      this.i.g(6, new k(params1, paramInt2));
    }
    if (locals1.n != params1.n) {
      this.i.g(7, new y(params1));
    }
    if (E0(locals1) != E0(params1)) {
      this.i.g(8, new j(params1));
    }
    if (!locals1.o.equals(params1.o)) {
      this.i.g(13, new p(params1));
    }
    if (paramBoolean1) {
      this.i.g(-1, a.a);
    }
    q1();
    this.i.c();
    if (locals1.p != params1.p)
    {
      localObject1 = this.j.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((e1.a)((Iterator)localObject1).next()).I(params1.p);
      }
    }
    if (locals1.q != params1.q)
    {
      localObject1 = this.j.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((e1.a)((Iterator)localObject1).next()).y(params1.q);
      }
    }
  }
  
  private long v0(s1 params1)
  {
    if (params1.b.q()) {
      return w0.d(this.J);
    }
    if (params1.c.b()) {
      return params1.t;
    }
    return i1(params1.b, params1.c, params1.t);
  }
  
  private int w0()
  {
    if (this.G.b.q()) {
      return this.H;
    }
    s1 locals1 = this.G;
    return locals1.b.h(locals1.c.a, this.k).d;
  }
  
  @Nullable
  private Pair<Object, Long> x0(j2 paramj21, j2 paramj22)
  {
    long l1 = M();
    boolean bool = paramj21.q();
    int i1 = -1;
    int i2;
    if ((!bool) && (!paramj22.q()))
    {
      i2 = m();
      Pair localPair = paramj21.j(this.a, this.k, i2, w0.d(l1));
      Object localObject = ((Pair)o0.i(localPair)).first;
      if (paramj22.b(localObject) != -1) {
        return localPair;
      }
      paramj21 = g1.z0(this.a, this.k, this.u, this.v, localObject, paramj21, paramj22);
      if (paramj21 != null)
      {
        paramj22.h(paramj21, this.k);
        i2 = this.k.d;
        return y0(paramj22, i2, paramj22.n(i2, this.a).b());
      }
      return y0(paramj22, -1, -9223372036854775807L);
    }
    if ((!paramj21.q()) && (paramj22.q())) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (i2 == 0) {
      i1 = w0();
    }
    if (i2 != 0) {
      l1 = -9223372036854775807L;
    }
    return y0(paramj22, i1, l1);
  }
  
  @Nullable
  private Pair<Object, Long> y0(j2 paramj2, int paramInt, long paramLong)
  {
    if (paramj2.q())
    {
      this.H = paramInt;
      long l1 = paramLong;
      if (paramLong == -9223372036854775807L) {
        l1 = 0L;
      }
      this.J = l1;
      this.I = 0;
      return null;
    }
    int i1;
    if (paramInt != -1)
    {
      i1 = paramInt;
      if (paramInt < paramj2.p()) {}
    }
    else
    {
      i1 = paramj2.a(this.v);
      paramLong = paramj2.n(i1, this.a).b();
    }
    return paramj2.j(this.a, this.k, i1, w0.d(paramLong));
  }
  
  public com.google.android.exoplayer2.trackselection.k A()
  {
    return new com.google.android.exoplayer2.trackselection.k(this.G.j.c);
  }
  
  public void B(int paramInt, long paramLong)
  {
    Object localObject = this.G.b;
    if ((paramInt >= 0) && ((((j2)localObject).q()) || (paramInt < ((j2)localObject).p())))
    {
      int i1 = this.w;
      int i2 = 1;
      this.w = (i1 + 1);
      if (f())
      {
        com.google.android.exoplayer2.util.u.h("ExoPlayerImpl", "seekTo ignored because an ad is playing");
        localObject = new g1.e(this.G);
        ((g1.e)localObject).b(1);
        this.g.a((g1.e)localObject);
        return;
      }
      if (getPlaybackState() != 1) {
        i2 = 2;
      }
      i1 = m();
      s1 locals1 = g1(this.G.h(i2), (j2)localObject, y0((j2)localObject, paramInt, paramLong));
      this.h.B0((j2)localObject, paramInt, w0.d(paramLong));
      r1(locals1, 0, 1, true, true, 1, v0(locals1), i1);
      return;
    }
    throw new IllegalSeekPositionException((j2)localObject, paramInt, paramLong);
  }
  
  public u1.b C()
  {
    return this.D;
  }
  
  public boolean E()
  {
    return this.G.m;
  }
  
  public void F(boolean paramBoolean)
  {
    if (this.v != paramBoolean)
    {
      this.v = paramBoolean;
      this.h.X0(paramBoolean);
      this.i.g(10, new f(paramBoolean));
      q1();
      this.i.c();
    }
  }
  
  public int G()
  {
    return 3000;
  }
  
  public int H()
  {
    if (this.G.b.q()) {
      return this.I;
    }
    s1 locals1 = this.G;
    return locals1.b.b(locals1.c.a);
  }
  
  public void I(@Nullable TextureView paramTextureView) {}
  
  public com.google.android.exoplayer2.video.z J()
  {
    return com.google.android.exoplayer2.video.z.a;
  }
  
  public int K()
  {
    int i1;
    if (f()) {
      i1 = this.G.c.c;
    } else {
      i1 = -1;
    }
    return i1;
  }
  
  public long L()
  {
    return this.s;
  }
  
  public long M()
  {
    if (f())
    {
      s1 locals1 = this.G;
      locals1.b.h(locals1.c.a, this.k);
      locals1 = this.G;
      long l1;
      if (locals1.d == -9223372036854775807L) {
        l1 = locals1.b.n(m(), this.a).b();
      } else {
        l1 = this.k.l() + w0.e(this.G.d);
      }
      return l1;
    }
    return V();
  }
  
  public void N(u1.e parame)
  {
    m0(parame);
  }
  
  public void P(@Nullable SurfaceView paramSurfaceView) {}
  
  public boolean Q()
  {
    return this.v;
  }
  
  public long R()
  {
    if (this.G.b.q()) {
      return this.J;
    }
    Object localObject = this.G;
    if (((s1)localObject).l.d != ((s1)localObject).c.d) {
      return ((s1)localObject).b.n(m(), this.a).d();
    }
    long l1 = ((s1)localObject).r;
    if (this.G.l.b())
    {
      localObject = this.G;
      localObject = ((s1)localObject).b.h(((s1)localObject).l.a, this.k);
      l1 = ((j2.b)localObject).f(this.G.l.b);
      if (l1 == Long.MIN_VALUE) {
        l1 = ((j2.b)localObject).e;
      }
    }
    localObject = this.G;
    return w0.e(i1(((s1)localObject).b, ((s1)localObject).l, l1));
  }
  
  public m1 U()
  {
    return this.E;
  }
  
  public long V()
  {
    return w0.e(v0(this.G));
  }
  
  public long W()
  {
    return this.r;
  }
  
  @Nullable
  public com.google.android.exoplayer2.trackselection.m a()
  {
    return this.e;
  }
  
  public t1 c()
  {
    return this.G.o;
  }
  
  public void e(t1 paramt1)
  {
    t1 localt1 = paramt1;
    if (paramt1 == null) {
      localt1 = t1.a;
    }
    if (this.G.o.equals(localt1)) {
      return;
    }
    paramt1 = this.G.g(localt1);
    this.w += 1;
    this.h.S0(localt1);
    r1(paramt1, 0, 1, false, false, 5, -9223372036854775807L, -1);
  }
  
  public boolean f()
  {
    return this.G.c.b();
  }
  
  public long g()
  {
    return w0.e(this.G.s);
  }
  
  public int getPlaybackState()
  {
    return this.G.f;
  }
  
  public int getRepeatMode()
  {
    return this.u;
  }
  
  public void h1(Metadata paramMetadata)
  {
    paramMetadata = this.E.a().H(paramMetadata).F();
    if (paramMetadata.equals(this.E)) {
      return;
    }
    this.E = paramMetadata;
    this.i.j(15, new s(this));
  }
  
  public void i(u1.e parame)
  {
    j1(parame);
  }
  
  public void j(List<l1> paramList, boolean paramBoolean)
  {
    m1(p0(paramList), paramBoolean);
  }
  
  public void j1(u1.c paramc)
  {
    this.i.i(paramc);
  }
  
  public void k(@Nullable SurfaceView paramSurfaceView) {}
  
  public void l(int paramInt1, int paramInt2)
  {
    s1 locals1 = k1(paramInt1, Math.min(paramInt2, this.l.size()));
    r1(locals1, 0, 1, false, locals1.c.a.equals(this.G.c.a) ^ true, 4, v0(locals1), -1);
  }
  
  public void l0(e1.a parama)
  {
    this.j.add(parama);
  }
  
  public int m()
  {
    int i1 = w0();
    int i2 = i1;
    if (i1 == -1) {
      i2 = 0;
    }
    return i2;
  }
  
  public void m0(u1.c paramc)
  {
    this.i.a(paramc);
  }
  
  public void m1(List<e0> paramList, boolean paramBoolean)
  {
    n1(paramList, -1, -9223372036854775807L, paramBoolean);
  }
  
  public void o1(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    s1 locals1 = this.G;
    if ((locals1.m == paramBoolean) && (locals1.n == paramInt1)) {
      return;
    }
    this.w += 1;
    locals1 = locals1.e(paramBoolean, paramInt1);
    this.h.Q0(paramBoolean, paramInt1);
    r1(locals1, 0, paramInt2, false, false, 5, -9223372036854775807L, -1);
  }
  
  public void p(boolean paramBoolean)
  {
    o1(paramBoolean, 0, 1);
  }
  
  public void p1(boolean paramBoolean, @Nullable ExoPlaybackException paramExoPlaybackException)
  {
    if (paramBoolean)
    {
      localObject = k1(0, this.l.size()).f(null);
    }
    else
    {
      localObject = this.G;
      localObject = ((s1)localObject).b(((s1)localObject).c);
      ((s1)localObject).r = ((s1)localObject).t;
      ((s1)localObject).s = 0L;
    }
    s1 locals1 = ((s1)localObject).h(1);
    Object localObject = locals1;
    if (paramExoPlaybackException != null) {
      localObject = locals1.f(paramExoPlaybackException);
    }
    this.w += 1;
    this.h.h1();
    if ((((s1)localObject).b.q()) && (!this.G.b.q())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    r1((s1)localObject, 0, 1, false, paramBoolean, 4, v0((s1)localObject), -1);
  }
  
  public void prepare()
  {
    s1 locals1 = this.G;
    if (locals1.f != 1) {
      return;
    }
    locals1 = locals1.f(null);
    int i1;
    if (locals1.b.q()) {
      i1 = 4;
    } else {
      i1 = 2;
    }
    locals1 = locals1.h(i1);
    this.w += 1;
    this.h.j0();
    r1(locals1, 1, 1, false, false, 5, -9223372036854775807L, -1);
  }
  
  public x1 q0(x1.b paramb)
  {
    return new x1(this.h, paramb, this.G.b, m(), this.t, this.h.A());
  }
  
  public int r()
  {
    int i1;
    if (f()) {
      i1 = this.G.c.b;
    } else {
      i1 = -1;
    }
    return i1;
  }
  
  public void release()
  {
    String str1 = Integer.toHexString(System.identityHashCode(this));
    String str2 = o0.e;
    Object localObject = h1.b();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 36 + String.valueOf(str2).length() + String.valueOf(localObject).length());
    localStringBuilder.append("Release ");
    localStringBuilder.append(str1);
    localStringBuilder.append(" [");
    localStringBuilder.append("ExoPlayerLib/2.15.0");
    localStringBuilder.append("] [");
    localStringBuilder.append(str2);
    localStringBuilder.append("] [");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    com.google.android.exoplayer2.util.u.f("ExoPlayerImpl", localStringBuilder.toString());
    if (!this.h.l0()) {
      this.i.j(11, t.a);
    }
    this.i.h();
    this.f.f(null);
    localObject = this.o;
    if (localObject != null) {
      this.q.d((g.a)localObject);
    }
    localObject = this.G.h(1);
    this.G = ((s1)localObject);
    localObject = ((s1)localObject).b(((s1)localObject).c);
    this.G = ((s1)localObject);
    ((s1)localObject).r = ((s1)localObject).t;
    this.G.s = 0L;
  }
  
  public boolean s0()
  {
    return this.G.q;
  }
  
  public void setRepeatMode(int paramInt)
  {
    if (this.u != paramInt)
    {
      this.u = paramInt;
      this.h.U0(paramInt);
      this.i.g(9, new d(paramInt));
      q1();
      this.i.c();
    }
  }
  
  public int t()
  {
    return this.G.n;
  }
  
  public void t0(long paramLong)
  {
    this.h.t(paramLong);
  }
  
  public TrackGroupArray u()
  {
    return this.G.i;
  }
  
  public ImmutableList<c> u0()
  {
    return ImmutableList.of();
  }
  
  public long v()
  {
    if (f())
    {
      s1 locals1 = this.G;
      e0.a locala = locals1.c;
      locals1.b.h(locala.a, this.k);
      return w0.e(this.k.b(locala.b, locala.c));
    }
    return X();
  }
  
  public j2 w()
  {
    return this.G.b;
  }
  
  public Looper x()
  {
    return this.p;
  }
  
  public void z(@Nullable TextureView paramTextureView) {}
  
  @Nullable
  public ExoPlaybackException z0()
  {
    return this.G.g;
  }
  
  private static final class a
    implements q1
  {
    private final Object a;
    private j2 b;
    
    public a(Object paramObject, j2 paramj2)
    {
      this.a = paramObject;
      this.b = paramj2;
    }
    
    public j2 a()
    {
      return this.b;
    }
    
    public Object getUid()
    {
      return this.a;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\f1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */