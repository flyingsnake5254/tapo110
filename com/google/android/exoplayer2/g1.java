package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession.DrmSessionException;
import com.google.android.exoplayer2.m2.h1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.b0.a;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.source.p0;
import com.google.android.exoplayer2.text.l;
import com.google.android.exoplayer2.trackselection.j;
import com.google.android.exoplayer2.trackselection.m;
import com.google.android.exoplayer2.trackselection.m.a;
import com.google.android.exoplayer2.trackselection.n;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.util.h;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.r.a;
import com.google.android.exoplayer2.util.u;
import com.google.common.base.t;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

final class g1
  implements Handler.Callback, b0.a, m.a, r1.d, b1.a, x1.a
{
  private final long H3;
  private final boolean I3;
  private final b1 J3;
  private final ArrayList<d> K3;
  private final h L3;
  private final f M3;
  private final p1 N3;
  private final r1 O3;
  private final j1 P3;
  private final long Q3;
  private g2 R3;
  private s1 S3;
  private e T3;
  private boolean U3;
  private boolean V3;
  private boolean W3;
  private boolean X3;
  private boolean Y3;
  private int Z3;
  private boolean a4;
  private boolean b4;
  private final b2[] c;
  private boolean c4;
  private final d2[] d;
  private boolean d4;
  private int e4;
  private final m f;
  @Nullable
  private h f4;
  private long g4;
  private int h4;
  private boolean i4;
  @Nullable
  private ExoPlaybackException j4;
  private long k4;
  private final HandlerThread p0;
  private final Looper p1;
  private final j2.c p2;
  private final j2.b p3;
  private final n q;
  private final k1 x;
  private final com.google.android.exoplayer2.upstream.g y;
  private final r z;
  
  public g1(b2[] paramArrayOfb2, m paramm, n paramn, k1 paramk1, com.google.android.exoplayer2.upstream.g paramg, int paramInt, boolean paramBoolean1, @Nullable h1 paramh1, g2 paramg2, j1 paramj1, long paramLong, boolean paramBoolean2, Looper paramLooper, h paramh, f paramf)
  {
    this.M3 = paramf;
    this.c = paramArrayOfb2;
    this.f = paramm;
    this.q = paramn;
    this.x = paramk1;
    this.y = paramg;
    this.Z3 = paramInt;
    this.a4 = paramBoolean1;
    this.R3 = paramg2;
    this.P3 = paramj1;
    this.Q3 = paramLong;
    this.k4 = paramLong;
    this.V3 = paramBoolean2;
    this.L3 = paramh;
    this.H3 = paramk1.d();
    this.I3 = paramk1.c();
    paramn = s1.k(paramn);
    this.S3 = paramn;
    this.T3 = new e(paramn);
    this.d = new d2[paramArrayOfb2.length];
    for (paramInt = 0; paramInt < paramArrayOfb2.length; paramInt++)
    {
      paramArrayOfb2[paramInt].h(paramInt);
      this.d[paramInt] = paramArrayOfb2[paramInt].o();
    }
    this.J3 = new b1(this, paramh);
    this.K3 = new ArrayList();
    this.p2 = new j2.c();
    this.p3 = new j2.b();
    paramm.b(this, paramg);
    this.i4 = true;
    paramArrayOfb2 = new Handler(paramLooper);
    this.N3 = new p1(paramh1, paramArrayOfb2);
    this.O3 = new r1(this, paramh1, paramArrayOfb2);
    paramArrayOfb2 = new HandlerThread("ExoPlayer:Playback", -16);
    this.p0 = paramArrayOfb2;
    paramArrayOfb2.start();
    paramArrayOfb2 = paramArrayOfb2.getLooper();
    this.p1 = paramArrayOfb2;
    this.z = paramh.b(paramArrayOfb2, this);
  }
  
  private void A0(long paramLong1, long paramLong2)
  {
    this.z.k(2);
    this.z.j(2, paramLong1 + paramLong2);
  }
  
  private long B()
  {
    return C(this.S3.r);
  }
  
  private long C(long paramLong)
  {
    n1 localn1 = this.N3.i();
    if (localn1 == null) {
      return 0L;
    }
    return Math.max(0L, paramLong - localn1.y(this.g4));
  }
  
  private void C0(boolean paramBoolean)
    throws ExoPlaybackException
  {
    e0.a locala = this.N3.o().f.a;
    long l = F0(locala, this.S3.t, true, false);
    if (l != this.S3.t)
    {
      s1 locals1 = this.S3;
      this.S3 = K(locala, l, locals1.d, locals1.e, paramBoolean, 5);
    }
  }
  
  private void D(com.google.android.exoplayer2.source.b0 paramb0)
  {
    if (!this.N3.u(paramb0)) {
      return;
    }
    this.N3.y(this.g4);
    V();
  }
  
  private void D0(h paramh)
    throws ExoPlaybackException
  {
    Object localObject1 = this.T3;
    boolean bool1 = true;
    ((e)localObject1).b(1);
    Object localObject2 = y0(this.S3.b, paramh, true, this.Z3, this.a4, this.p2, this.p3);
    long l1;
    boolean bool2;
    long l2;
    if (localObject2 == null)
    {
      Pair localPair = z(this.S3.b);
      localObject1 = (e0.a)localPair.first;
      l1 = ((Long)localPair.second).longValue();
      bool2 = this.S3.b.q() ^ true;
      l2 = -9223372036854775807L;
    }
    long l3;
    for (;;)
    {
      l3 = l2;
      l2 = l1;
      break;
      localObject1 = ((Pair)localObject2).first;
      l1 = ((Long)((Pair)localObject2).second).longValue();
      if (paramh.c == -9223372036854775807L) {
        l2 = -9223372036854775807L;
      } else {
        l2 = l1;
      }
      localObject1 = this.N3.A(this.S3.b, localObject1, l1);
      if (((c0)localObject1).b())
      {
        this.S3.b.h(((c0)localObject1).a, this.p3);
        if (this.p3.j(((c0)localObject1).b) == ((c0)localObject1).c) {
          l1 = this.p3.g();
        } else {
          l1 = 0L;
        }
        l3 = l2;
        bool2 = true;
        l2 = l1;
        break;
      }
      if (paramh.c == -9223372036854775807L) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    try
    {
      if (this.S3.b.q())
      {
        this.f4 = paramh;
      }
      else
      {
        if (localObject2 != null) {
          break label321;
        }
        if (this.S3.f != 1) {
          a1(4);
        }
        r0(false, true, false, true);
      }
      break label544;
      label321:
      long l4;
      if (((c0)localObject1).equals(this.S3.c))
      {
        paramh = this.N3.o();
        if ((paramh != null) && (paramh.d) && (l2 != 0L)) {
          l1 = paramh.a.j(l2, this.R3);
        } else {
          l1 = l2;
        }
        l4 = l1;
        if (w0.e(l1) == w0.e(this.S3.t))
        {
          paramh = this.S3;
          int i = paramh.f;
          if (i != 2)
          {
            l4 = l1;
            if (i != 3) {}
          }
          else
          {
            l1 = paramh.t;
            this.S3 = K((e0.a)localObject1, l1, l3, l1, bool2, 2);
          }
        }
      }
      else
      {
        l4 = l2;
      }
      boolean bool3;
      if (this.S3.f == 4) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      l1 = E0((e0.a)localObject1, l4, bool3);
      if (l2 == l1) {
        bool1 = false;
      }
      bool2 = bool1 | bool2;
      try
      {
        paramh = this.S3;
        localObject2 = paramh.b;
        l1((j2)localObject2, (e0.a)localObject1, (j2)localObject2, paramh.c, l3);
        l2 = l1;
        label544:
        this.S3 = K((e0.a)localObject1, l2, l3, l2, bool2, 2);
        return;
      }
      finally
      {
        l2 = l1;
      }
      this.S3 = K((e0.a)localObject1, l2, l3, l2, bool2, 2);
    }
    finally {}
    throw paramh;
  }
  
  private void E(IOException paramIOException, int paramInt)
  {
    ExoPlaybackException localExoPlaybackException = ExoPlaybackException.createForSource(paramIOException, paramInt);
    n1 localn1 = this.N3.o();
    paramIOException = localExoPlaybackException;
    if (localn1 != null) {
      paramIOException = localExoPlaybackException.copyWithMediaPeriodId(localn1.f.a);
    }
    u.d("ExoPlayerImplInternal", "Playback error", paramIOException);
    i1(false, false);
    this.S3 = this.S3.f(paramIOException);
  }
  
  private long E0(e0.a parama, long paramLong, boolean paramBoolean)
    throws ExoPlaybackException
  {
    boolean bool;
    if (this.N3.o() != this.N3.p()) {
      bool = true;
    } else {
      bool = false;
    }
    return F0(parama, paramLong, bool, paramBoolean);
  }
  
  private void F(boolean paramBoolean)
  {
    n1 localn1 = this.N3.i();
    if (localn1 == null) {
      localObject = this.S3.c;
    } else {
      localObject = localn1.f.a;
    }
    boolean bool = this.S3.l.equals(localObject) ^ true;
    if (bool) {
      this.S3 = this.S3.b((e0.a)localObject);
    }
    Object localObject = this.S3;
    long l;
    if (localn1 == null) {
      l = ((s1)localObject).t;
    } else {
      l = localn1.i();
    }
    ((s1)localObject).r = l;
    this.S3.s = B();
    if (((bool) || (paramBoolean)) && (localn1 != null) && (localn1.d)) {
      m1(localn1.n(), localn1.o());
    }
  }
  
  private long F0(e0.a parama, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    throws ExoPlaybackException
  {
    j1();
    this.X3 = false;
    if ((paramBoolean2) || (this.S3.f == 3)) {
      a1(2);
    }
    n1 localn11 = this.N3.o();
    for (n1 localn12 = localn11; (localn12 != null) && (!parama.equals(localn12.f.a)); localn12 = localn12.j()) {}
    if ((paramBoolean1) || (localn11 != localn12) || ((localn12 != null) && (localn12.z(paramLong) < 0L)))
    {
      parama = this.c;
      int i = parama.length;
      for (int j = 0; j < i; j++) {
        k(parama[j]);
      }
      if (localn12 != null)
      {
        while (this.N3.o() != localn12) {
          this.N3.a();
        }
        this.N3.z(localn12);
        localn12.x(0L);
        q();
      }
    }
    if (localn12 != null)
    {
      this.N3.z(localn12);
      if (!localn12.d)
      {
        localn12.f = localn12.f.b(paramLong);
      }
      else
      {
        long l1 = localn12.f.e;
        long l2 = paramLong;
        if (l1 != -9223372036854775807L)
        {
          l2 = paramLong;
          if (paramLong >= l1) {
            l2 = Math.max(0L, l1 - 1L);
          }
        }
        paramLong = l2;
        if (localn12.e)
        {
          paramLong = localn12.a.i(l2);
          localn12.a.u(paramLong - this.H3, this.I3);
        }
      }
      t0(paramLong);
      V();
    }
    else
    {
      this.N3.e();
      t0(paramLong);
    }
    F(false);
    this.z.i(2);
    return paramLong;
  }
  
  private void G(j2 paramj2, boolean paramBoolean)
    throws ExoPlaybackException
  {
    Object localObject1 = x0(paramj2, this.S3, this.f4, this.N3, this.Z3, this.a4, this.p2, this.p3);
    e0.a locala = ((g)localObject1).a;
    long l1 = ((g)localObject1).c;
    boolean bool = ((g)localObject1).d;
    long l2 = ((g)localObject1).b;
    int i;
    if ((this.S3.c.equals(locala)) && (l2 == this.S3.t)) {
      i = 0;
    } else {
      i = 1;
    }
    int j = 3;
    long l3 = -9223372036854775807L;
    try
    {
      if (((g)localObject1).e)
      {
        if (this.S3.f != 1) {
          a1(4);
        }
        r0(false, false, false, true);
      }
      Object localObject2;
      long l4;
      long l5;
      if (i == 0)
      {
        localObject2 = this.N3;
        l4 = this.g4;
        l5 = y();
        l6 = l2;
      }
      try
      {
        if (!((p1)localObject2).F(paramj2, l4, l5))
        {
          C0(false);
          l6 = l2;
          break label274;
          l6 = l2;
          if (!paramj2.q())
          {
            for (localObject2 = this.N3.o(); localObject2 != null; localObject2 = ((n1)localObject2).j()) {
              if (((n1)localObject2).f.a.equals(locala))
              {
                ((n1)localObject2).f = this.N3.q(paramj2, ((n1)localObject2).f);
                ((n1)localObject2).A();
              }
            }
            l6 = E0(locala, l2, bool);
          }
        }
        label274:
        localObject5 = this.S3;
        localObject2 = ((s1)localObject5).b;
        localObject5 = ((s1)localObject5).c;
        if (((g)localObject1).f) {
          l2 = l6;
        } else {
          l2 = -9223372036854775807L;
        }
        l1(paramj2, locala, (j2)localObject2, (e0.a)localObject5, l2);
        if ((i != 0) || (l1 != this.S3.d))
        {
          localObject1 = this.S3;
          localObject2 = ((s1)localObject1).c.a;
          localObject1 = ((s1)localObject1).b;
          if ((i != 0) && (paramBoolean) && (!((j2)localObject1).q()) && (!((j2)localObject1).h(localObject2, this.p3).g)) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          l2 = this.S3.e;
          if (paramj2.b(localObject2) == -1) {
            j = 4;
          }
          this.S3 = K(locala, l6, l1, l2, paramBoolean, j);
        }
        s0();
        w0(paramj2, this.S3.b);
        this.S3 = this.S3.j(paramj2);
        if (!paramj2.q()) {
          this.f4 = null;
        }
        F(false);
        return;
      }
      finally {}
      localObject6 = this.S3;
    }
    finally {}
    Object localObject5 = ((s1)localObject6).b;
    Object localObject6 = ((s1)localObject6).c;
    long l6 = l3;
    if (((g)localObject1).f) {
      l6 = l2;
    }
    l1(paramj2, locala, (j2)localObject5, (e0.a)localObject6, l6);
    if ((i != 0) || (l1 != this.S3.d))
    {
      localObject5 = this.S3;
      localObject1 = ((s1)localObject5).c.a;
      localObject5 = ((s1)localObject5).b;
      if ((i != 0) && (paramBoolean) && (!((j2)localObject5).q()) && (!((j2)localObject5).h(localObject1, this.p3).g)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      l6 = this.S3.e;
      if (paramj2.b(localObject1) == -1) {
        j = 4;
      }
      this.S3 = K(locala, l2, l1, l6, paramBoolean, j);
    }
    s0();
    w0(paramj2, this.S3.b);
    this.S3 = this.S3.j(paramj2);
    if (!paramj2.q()) {
      this.f4 = null;
    }
    F(false);
    throw ((Throwable)localObject4);
  }
  
  private void G0(x1 paramx1)
    throws ExoPlaybackException
  {
    if (paramx1.e() == -9223372036854775807L)
    {
      H0(paramx1);
    }
    else if (this.S3.b.q())
    {
      this.K3.add(new d(paramx1));
    }
    else
    {
      d locald = new d(paramx1);
      j2 localj2 = this.S3.b;
      if (v0(locald, localj2, localj2, this.Z3, this.a4, this.p2, this.p3))
      {
        this.K3.add(locald);
        Collections.sort(this.K3);
      }
      else
      {
        paramx1.k(false);
      }
    }
  }
  
  private void H(com.google.android.exoplayer2.source.b0 paramb0)
    throws ExoPlaybackException
  {
    if (!this.N3.u(paramb0)) {
      return;
    }
    n1 localn1 = this.N3.i();
    localn1.p(this.J3.c().c, this.S3.b);
    m1(localn1.n(), localn1.o());
    if (localn1 == this.N3.o())
    {
      t0(localn1.f.b);
      q();
      paramb0 = this.S3;
      e0.a locala = paramb0.c;
      long l = localn1.f.b;
      this.S3 = K(locala, l, paramb0.d, l, false, 5);
    }
    V();
  }
  
  private void H0(x1 paramx1)
    throws ExoPlaybackException
  {
    if (paramx1.c() == this.p1)
    {
      j(paramx1);
      int i = this.S3.f;
      if ((i == 3) || (i == 2)) {
        this.z.i(2);
      }
    }
    else
    {
      this.z.e(15, paramx1).a();
    }
  }
  
  private void I(t1 paramt1, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
    throws ExoPlaybackException
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        this.T3.b(1);
      }
      this.S3 = this.S3.g(paramt1);
    }
    p1(paramt1.c);
    for (b2 localb2 : this.c) {
      if (localb2 != null) {
        localb2.q(paramFloat, paramt1.c);
      }
    }
  }
  
  private void I0(x1 paramx1)
  {
    Looper localLooper = paramx1.c();
    if (!localLooper.getThread().isAlive())
    {
      u.h("TAG", "Trying to send message on a dead thread.");
      paramx1.k(false);
      return;
    }
    this.L3.b(localLooper, null).h(new b0(this, paramx1));
  }
  
  private void J(t1 paramt1, boolean paramBoolean)
    throws ExoPlaybackException
  {
    I(paramt1, paramt1.c, true, paramBoolean);
  }
  
  private void J0(long paramLong)
  {
    for (b2 localb2 : this.c) {
      if (localb2.getStream() != null) {
        K0(localb2, paramLong);
      }
    }
  }
  
  @CheckResult
  private s1 K(e0.a parama, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, int paramInt)
  {
    boolean bool;
    if ((!this.i4) && (paramLong1 == this.S3.t) && (parama.equals(this.S3.c))) {
      bool = false;
    } else {
      bool = true;
    }
    this.i4 = bool;
    s0();
    Object localObject = this.S3;
    TrackGroupArray localTrackGroupArray = ((s1)localObject).i;
    n localn = ((s1)localObject).j;
    localObject = ((s1)localObject).k;
    if (this.O3.r())
    {
      n1 localn1 = this.N3.o();
      if (localn1 == null) {
        localTrackGroupArray = TrackGroupArray.c;
      } else {
        localTrackGroupArray = localn1.n();
      }
      if (localn1 == null) {
        localn = this.q;
      } else {
        localn = localn1.o();
      }
      localObject = u(localn.c);
      if (localn1 != null)
      {
        o1 localo1 = localn1.f;
        if (localo1.c != paramLong2) {
          localn1.f = localo1.a(paramLong2);
        }
      }
    }
    else if (!parama.equals(this.S3.c))
    {
      localTrackGroupArray = TrackGroupArray.c;
      localn = this.q;
      localObject = ImmutableList.of();
    }
    if (paramBoolean) {
      this.T3.e(paramInt);
    }
    return this.S3.c(parama, paramLong1, paramLong2, paramLong3, B(), localTrackGroupArray, localn, (List)localObject);
  }
  
  private void K0(b2 paramb2, long paramLong)
  {
    paramb2.j();
    if ((paramb2 instanceof l)) {
      ((l)paramb2).V(paramLong);
    }
  }
  
  private boolean L(b2 paramb2, n1 paramn1)
  {
    n1 localn1 = paramn1.j();
    boolean bool;
    if ((paramn1.f.f) && (localn1.d) && (((paramb2 instanceof l)) || (paramb2.u() >= localn1.m()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void L0(boolean paramBoolean, @Nullable AtomicBoolean paramAtomicBoolean)
  {
    if (this.b4 != paramBoolean)
    {
      this.b4 = paramBoolean;
      if (!paramBoolean) {
        for (b2 localb2 : this.c) {
          if (!O(localb2)) {
            localb2.reset();
          }
        }
      }
    }
    if (paramAtomicBoolean != null) {
      try
      {
        paramAtomicBoolean.set(true);
        notifyAll();
      }
      finally {}
    }
  }
  
  private boolean M()
  {
    n1 localn1 = this.N3.p();
    if (!localn1.d) {
      return false;
    }
    for (int i = 0;; i++)
    {
      Object localObject = this.c;
      if (i >= localObject.length) {
        break label87;
      }
      localObject = localObject[i];
      n0 localn0 = localn1.c[i];
      if ((((b2)localObject).getStream() != localn0) || ((localn0 != null) && (!((b2)localObject).i()) && (!L((b2)localObject, localn1)))) {
        break;
      }
    }
    return false;
    label87:
    return true;
  }
  
  private void M0(b paramb)
    throws ExoPlaybackException
  {
    this.T3.b(1);
    if (b.a(paramb) != -1) {
      this.f4 = new h(new y1(b.b(paramb), b.c(paramb)), b.a(paramb), b.d(paramb));
    }
    G(this.O3.C(b.b(paramb), b.c(paramb)), false);
  }
  
  private boolean N()
  {
    n1 localn1 = this.N3.i();
    if (localn1 == null) {
      return false;
    }
    return localn1.k() != Long.MIN_VALUE;
  }
  
  private static boolean O(b2 paramb2)
  {
    boolean bool;
    if (paramb2.getState() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void O0(boolean paramBoolean)
  {
    if (paramBoolean == this.d4) {
      return;
    }
    this.d4 = paramBoolean;
    s1 locals1 = this.S3;
    int i = locals1.f;
    if ((!paramBoolean) && (i != 4) && (i != 1)) {
      this.z.i(2);
    } else {
      this.S3 = locals1.d(paramBoolean);
    }
  }
  
  private boolean P()
  {
    n1 localn1 = this.N3.o();
    long l = localn1.f.e;
    boolean bool;
    if ((localn1.d) && ((l == -9223372036854775807L) || (this.S3.t < l) || (!d1()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void P0(boolean paramBoolean)
    throws ExoPlaybackException
  {
    this.V3 = paramBoolean;
    s0();
    if ((this.W3) && (this.N3.p() != this.N3.o()))
    {
      C0(true);
      F(false);
    }
  }
  
  private static boolean Q(s1 params1, j2.b paramb)
  {
    e0.a locala = params1.c;
    params1 = params1.b;
    boolean bool;
    if ((!params1.q()) && (!params1.h(locala.a, paramb).g)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void R0(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
    throws ExoPlaybackException
  {
    this.T3.b(paramBoolean2);
    this.T3.c(paramInt2);
    this.S3 = this.S3.e(paramBoolean1, paramInt1);
    this.X3 = false;
    g0(paramBoolean1);
    if (!d1())
    {
      j1();
      o1();
    }
    else
    {
      paramInt1 = this.S3.f;
      if (paramInt1 == 3)
      {
        g1();
        this.z.i(2);
      }
      else if (paramInt1 == 2)
      {
        this.z.i(2);
      }
    }
  }
  
  private void T0(t1 paramt1)
    throws ExoPlaybackException
  {
    this.J3.e(paramt1);
    J(this.J3.c(), true);
  }
  
  private void V()
  {
    boolean bool = c1();
    this.Y3 = bool;
    if (bool) {
      this.N3.i().d(this.g4);
    }
    k1();
  }
  
  private void V0(int paramInt)
    throws ExoPlaybackException
  {
    this.Z3 = paramInt;
    if (!this.N3.G(this.S3.b, paramInt)) {
      C0(true);
    }
    F(false);
  }
  
  private void W()
  {
    this.T3.d(this.S3);
    if (e.a(this.T3))
    {
      this.M3.a(this.T3);
      this.T3 = new e(this.S3);
    }
  }
  
  private void W0(g2 paramg2)
  {
    this.R3 = paramg2;
  }
  
  private boolean X(long paramLong1, long paramLong2)
  {
    if ((this.d4) && (this.c4)) {
      return false;
    }
    A0(paramLong1, paramLong2);
    return true;
  }
  
  /* Error */
  private void Y(long paramLong1, long paramLong2)
    throws ExoPlaybackException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 188	com/google/android/exoplayer2/g1:K3	Ljava/util/ArrayList;
    //   4: invokevirtual 867	java/util/ArrayList:isEmpty	()Z
    //   7: ifne +530 -> 537
    //   10: aload_0
    //   11: getfield 158	com/google/android/exoplayer2/g1:S3	Lcom/google/android/exoplayer2/s1;
    //   14: getfield 401	com/google/android/exoplayer2/s1:c	Lcom/google/android/exoplayer2/source/e0$a;
    //   17: invokevirtual 374	com/google/android/exoplayer2/source/c0:b	()Z
    //   20: ifeq +6 -> 26
    //   23: goto +514 -> 537
    //   26: lload_1
    //   27: lstore 5
    //   29: aload_0
    //   30: getfield 205	com/google/android/exoplayer2/g1:i4	Z
    //   33: ifeq +13 -> 46
    //   36: lload_1
    //   37: lconst_1
    //   38: lsub
    //   39: lstore 5
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 205	com/google/android/exoplayer2/g1:i4	Z
    //   46: aload_0
    //   47: getfield 158	com/google/android/exoplayer2/g1:S3	Lcom/google/android/exoplayer2/s1;
    //   50: astore 7
    //   52: aload 7
    //   54: getfield 335	com/google/android/exoplayer2/s1:b	Lcom/google/android/exoplayer2/j2;
    //   57: aload 7
    //   59: getfield 401	com/google/android/exoplayer2/s1:c	Lcom/google/android/exoplayer2/source/e0$a;
    //   62: getfield 376	com/google/android/exoplayer2/source/c0:a	Ljava/lang/Object;
    //   65: invokevirtual 554	com/google/android/exoplayer2/j2:b	(Ljava/lang/Object;)I
    //   68: istore 8
    //   70: aload_0
    //   71: getfield 869	com/google/android/exoplayer2/g1:h4	I
    //   74: aload_0
    //   75: getfield 188	com/google/android/exoplayer2/g1:K3	Ljava/util/ArrayList;
    //   78: invokevirtual 872	java/util/ArrayList:size	()I
    //   81: invokestatic 876	java/lang/Math:min	(II)I
    //   84: istore 9
    //   86: iload 9
    //   88: istore 10
    //   90: lload 5
    //   92: lstore_1
    //   93: iload 9
    //   95: ifle +26 -> 121
    //   98: aload_0
    //   99: getfield 188	com/google/android/exoplayer2/g1:K3	Ljava/util/ArrayList;
    //   102: iload 9
    //   104: iconst_1
    //   105: isub
    //   106: invokevirtual 880	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   109: checkcast 26	com/google/android/exoplayer2/g1$d
    //   112: astore 7
    //   114: iload 9
    //   116: istore 10
    //   118: goto +9 -> 127
    //   121: aconst_null
    //   122: astore 7
    //   124: lload_1
    //   125: lstore 5
    //   127: aload 7
    //   129: ifnull +76 -> 205
    //   132: aload 7
    //   134: getfield 882	com/google/android/exoplayer2/g1$d:d	I
    //   137: istore 9
    //   139: iload 9
    //   141: iload 8
    //   143: if_icmpgt +21 -> 164
    //   146: iload 9
    //   148: iload 8
    //   150: if_icmpne +55 -> 205
    //   153: aload 7
    //   155: getfield 884	com/google/android/exoplayer2/g1$d:f	J
    //   158: lload 5
    //   160: lcmp
    //   161: ifle +44 -> 205
    //   164: iload 10
    //   166: iconst_1
    //   167: isub
    //   168: istore 9
    //   170: iload 9
    //   172: istore 10
    //   174: lload 5
    //   176: lstore_1
    //   177: iload 9
    //   179: ifle -58 -> 121
    //   182: aload_0
    //   183: getfield 188	com/google/android/exoplayer2/g1:K3	Ljava/util/ArrayList;
    //   186: iload 9
    //   188: iconst_1
    //   189: isub
    //   190: invokevirtual 880	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   193: checkcast 26	com/google/android/exoplayer2/g1$d
    //   196: astore 7
    //   198: iload 9
    //   200: istore 10
    //   202: goto -75 -> 127
    //   205: iload 10
    //   207: istore 9
    //   209: lload 5
    //   211: lstore_1
    //   212: iload 10
    //   214: aload_0
    //   215: getfield 188	com/google/android/exoplayer2/g1:K3	Ljava/util/ArrayList;
    //   218: invokevirtual 872	java/util/ArrayList:size	()I
    //   221: if_icmpge +20 -> 241
    //   224: aload_0
    //   225: getfield 188	com/google/android/exoplayer2/g1:K3	Ljava/util/ArrayList;
    //   228: iload 10
    //   230: invokevirtual 880	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   233: checkcast 26	com/google/android/exoplayer2/g1$d
    //   236: astore 7
    //   238: goto +13 -> 251
    //   241: aconst_null
    //   242: astore 7
    //   244: lload_1
    //   245: lstore 5
    //   247: iload 9
    //   249: istore 10
    //   251: iload 10
    //   253: istore 9
    //   255: aload 7
    //   257: astore 11
    //   259: aload 7
    //   261: ifnull +106 -> 367
    //   264: iload 10
    //   266: istore 9
    //   268: aload 7
    //   270: astore 11
    //   272: aload 7
    //   274: getfield 886	com/google/android/exoplayer2/g1$d:q	Ljava/lang/Object;
    //   277: ifnull +90 -> 367
    //   280: aload 7
    //   282: getfield 882	com/google/android/exoplayer2/g1$d:d	I
    //   285: istore 12
    //   287: iload 12
    //   289: iload 8
    //   291: if_icmplt +37 -> 328
    //   294: iload 10
    //   296: istore 9
    //   298: aload 7
    //   300: astore 11
    //   302: iload 12
    //   304: iload 8
    //   306: if_icmpne +61 -> 367
    //   309: iload 10
    //   311: istore 9
    //   313: aload 7
    //   315: astore 11
    //   317: aload 7
    //   319: getfield 884	com/google/android/exoplayer2/g1$d:f	J
    //   322: lload 5
    //   324: lcmp
    //   325: ifgt +42 -> 367
    //   328: iinc 10 1
    //   331: iload 10
    //   333: istore 9
    //   335: lload 5
    //   337: lstore_1
    //   338: iload 10
    //   340: aload_0
    //   341: getfield 188	com/google/android/exoplayer2/g1:K3	Ljava/util/ArrayList;
    //   344: invokevirtual 872	java/util/ArrayList:size	()I
    //   347: if_icmpge -106 -> 241
    //   350: aload_0
    //   351: getfield 188	com/google/android/exoplayer2/g1:K3	Ljava/util/ArrayList;
    //   354: iload 10
    //   356: invokevirtual 880	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   359: checkcast 26	com/google/android/exoplayer2/g1$d
    //   362: astore 7
    //   364: goto -113 -> 251
    //   367: aload 11
    //   369: ifnull +162 -> 531
    //   372: aload 11
    //   374: getfield 886	com/google/android/exoplayer2/g1$d:q	Ljava/lang/Object;
    //   377: ifnull +154 -> 531
    //   380: aload 11
    //   382: getfield 882	com/google/android/exoplayer2/g1$d:d	I
    //   385: iload 8
    //   387: if_icmpne +144 -> 531
    //   390: aload 11
    //   392: getfield 884	com/google/android/exoplayer2/g1$d:f	J
    //   395: lstore_1
    //   396: lload_1
    //   397: lload 5
    //   399: lcmp
    //   400: ifle +131 -> 531
    //   403: lload_1
    //   404: lload_3
    //   405: lcmp
    //   406: ifgt +125 -> 531
    //   409: aload_0
    //   410: aload 11
    //   412: getfield 889	com/google/android/exoplayer2/g1$d:c	Lcom/google/android/exoplayer2/x1;
    //   415: invokespecial 573	com/google/android/exoplayer2/g1:H0	(Lcom/google/android/exoplayer2/x1;)V
    //   418: aload 11
    //   420: getfield 889	com/google/android/exoplayer2/g1$d:c	Lcom/google/android/exoplayer2/x1;
    //   423: invokevirtual 890	com/google/android/exoplayer2/x1:b	()Z
    //   426: ifne +23 -> 449
    //   429: aload 11
    //   431: getfield 889	com/google/android/exoplayer2/g1$d:c	Lcom/google/android/exoplayer2/x1;
    //   434: invokevirtual 892	com/google/android/exoplayer2/x1:j	()Z
    //   437: ifeq +6 -> 443
    //   440: goto +9 -> 449
    //   443: iinc 9 1
    //   446: goto +13 -> 459
    //   449: aload_0
    //   450: getfield 188	com/google/android/exoplayer2/g1:K3	Ljava/util/ArrayList;
    //   453: iload 9
    //   455: invokevirtual 895	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   458: pop
    //   459: iload 9
    //   461: aload_0
    //   462: getfield 188	com/google/android/exoplayer2/g1:K3	Ljava/util/ArrayList;
    //   465: invokevirtual 872	java/util/ArrayList:size	()I
    //   468: if_icmpge +20 -> 488
    //   471: aload_0
    //   472: getfield 188	com/google/android/exoplayer2/g1:K3	Ljava/util/ArrayList;
    //   475: iload 9
    //   477: invokevirtual 880	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   480: checkcast 26	com/google/android/exoplayer2/g1$d
    //   483: astore 11
    //   485: goto -118 -> 367
    //   488: aconst_null
    //   489: astore 11
    //   491: goto -124 -> 367
    //   494: astore 7
    //   496: aload 11
    //   498: getfield 889	com/google/android/exoplayer2/g1$d:c	Lcom/google/android/exoplayer2/x1;
    //   501: invokevirtual 890	com/google/android/exoplayer2/x1:b	()Z
    //   504: ifne +14 -> 518
    //   507: aload 11
    //   509: getfield 889	com/google/android/exoplayer2/g1$d:c	Lcom/google/android/exoplayer2/x1;
    //   512: invokevirtual 892	com/google/android/exoplayer2/x1:j	()Z
    //   515: ifeq +13 -> 528
    //   518: aload_0
    //   519: getfield 188	com/google/android/exoplayer2/g1:K3	Ljava/util/ArrayList;
    //   522: iload 9
    //   524: invokevirtual 895	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   527: pop
    //   528: aload 7
    //   530: athrow
    //   531: aload_0
    //   532: iload 9
    //   534: putfield 869	com/google/android/exoplayer2/g1:h4	I
    //   537: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	this	g1
    //   0	538	1	paramLong1	long
    //   0	538	3	paramLong2	long
    //   27	371	5	l	long
    //   50	313	7	localObject1	Object
    //   494	35	7	localObject2	Object
    //   68	320	8	i	int
    //   84	449	9	j	int
    //   88	267	10	k	int
    //   257	251	11	localObject3	Object
    //   285	22	12	m	int
    // Exception table:
    //   from	to	target	type
    //   409	418	494	finally
  }
  
  private void Y0(boolean paramBoolean)
    throws ExoPlaybackException
  {
    this.a4 = paramBoolean;
    if (!this.N3.H(this.S3.b, paramBoolean)) {
      C0(true);
    }
    F(false);
  }
  
  private void Z()
    throws ExoPlaybackException
  {
    this.N3.y(this.g4);
    if (this.N3.D())
    {
      o1 localo1 = this.N3.n(this.g4, this.S3);
      if (localo1 != null)
      {
        n1 localn1 = this.N3.f(this.d, this.f, this.x.getAllocator(), this.O3, localo1, this.q);
        localn1.a.l(this, localo1.b);
        if (this.N3.o() == localn1) {
          t0(localn1.m());
        }
        F(false);
      }
    }
    if (this.Y3)
    {
      this.Y3 = N();
      k1();
    }
    else
    {
      V();
    }
  }
  
  private void Z0(p0 paramp0)
    throws ExoPlaybackException
  {
    this.T3.b(1);
    G(this.O3.D(paramp0), false);
  }
  
  private void a0()
    throws ExoPlaybackException
  {
    for (int i = 0; b1(); i = 1)
    {
      if (i != 0) {
        W();
      }
      n1 localn11 = this.N3.o();
      n1 localn12 = this.N3.a();
      o1 localo1 = localn12.f;
      Object localObject = localo1.a;
      long l = localo1.b;
      localObject = K((e0.a)localObject, l, localo1.c, l, true, 0);
      this.S3 = ((s1)localObject);
      localObject = ((s1)localObject).b;
      l1((j2)localObject, localn12.f.a, (j2)localObject, localn11.f.a, -9223372036854775807L);
      s0();
      o1();
    }
  }
  
  private void a1(int paramInt)
  {
    s1 locals1 = this.S3;
    if (locals1.f != paramInt) {
      this.S3 = locals1.h(paramInt);
    }
  }
  
  private void b0()
  {
    Object localObject1 = this.N3.p();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((n1)localObject1).j();
    int i = 0;
    e2 locale2;
    if ((localObject2 != null) && (!this.W3))
    {
      if (!M()) {
        return;
      }
      if ((!((n1)localObject1).j().d) && (this.g4 < ((n1)localObject1).j().m())) {
        return;
      }
      localObject2 = ((n1)localObject1).o();
      n1 localn1 = this.N3.b();
      n localn = localn1.o();
      if ((localn1.d) && (localn1.a.k() != -9223372036854775807L))
      {
        J0(localn1.m());
        return;
      }
      for (j = 0; j < this.c.length; j++)
      {
        boolean bool1 = ((n)localObject2).c(j);
        boolean bool2 = localn.c(j);
        if ((bool1) && (!this.c[j].m()))
        {
          if (this.d[j].f() == 7) {
            i = 1;
          } else {
            i = 0;
          }
          localObject1 = localObject2.b[j];
          locale2 = localn.b[j];
          if ((!bool2) || (!locale2.equals(localObject1)) || (i != 0)) {
            K0(this.c[j], localn1.m());
          }
        }
      }
      return;
    }
    int j = i;
    if (!((n1)localObject1).f.i)
    {
      if (!this.W3) {}
    }
    else {
      for (j = i;; j++)
      {
        localObject2 = this.c;
        if (j >= localObject2.length) {
          break;
        }
        locale2 = localObject2[j];
        localObject2 = localObject1.c[j];
        if ((localObject2 != null) && (locale2.getStream() == localObject2) && (locale2.i()))
        {
          long l = ((n1)localObject1).f.e;
          if ((l != -9223372036854775807L) && (l != Long.MIN_VALUE)) {
            l = ((n1)localObject1).l() + ((n1)localObject1).f.e;
          } else {
            l = -9223372036854775807L;
          }
          K0(locale2, l);
        }
      }
    }
  }
  
  private boolean b1()
  {
    boolean bool1 = d1();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (this.W3) {
      return false;
    }
    n1 localn1 = this.N3.o();
    if (localn1 == null) {
      return false;
    }
    localn1 = localn1.j();
    bool1 = bool2;
    if (localn1 != null)
    {
      bool1 = bool2;
      if (this.g4 >= localn1.m())
      {
        bool1 = bool2;
        if (localn1.g) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void c0()
    throws ExoPlaybackException
  {
    n1 localn1 = this.N3.p();
    if ((localn1 != null) && (this.N3.o() != localn1) && (!localn1.g) && (p0())) {
      q();
    }
  }
  
  private boolean c1()
  {
    if (!N()) {
      return false;
    }
    n1 localn1 = this.N3.i();
    long l1 = C(localn1.k());
    long l2;
    if (localn1 == this.N3.o()) {
      l2 = localn1.y(this.g4);
    } else {
      l2 = localn1.y(this.g4) - localn1.f.b;
    }
    return this.x.i(l2, l1, this.J3.c().c);
  }
  
  private void d0()
    throws ExoPlaybackException
  {
    G(this.O3.h(), true);
  }
  
  private boolean d1()
  {
    s1 locals1 = this.S3;
    boolean bool;
    if ((locals1.m) && (locals1.n == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void e0(c paramc)
    throws ExoPlaybackException
  {
    this.T3.b(1);
    G(this.O3.v(paramc.a, paramc.b, paramc.c, paramc.d), false);
  }
  
  private boolean e1(boolean paramBoolean)
  {
    if (this.e4 == 0) {
      return P();
    }
    boolean bool = false;
    if (!paramBoolean) {
      return false;
    }
    Object localObject = this.S3;
    if (!((s1)localObject).h) {
      return true;
    }
    long l;
    if (f1(((s1)localObject).b, this.N3.o().f.a)) {
      l = this.P3.c();
    } else {
      l = -9223372036854775807L;
    }
    localObject = this.N3.i();
    int i;
    if ((((n1)localObject).q()) && (((n1)localObject).f.i)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((((n1)localObject).f.a.b()) && (!((n1)localObject).d)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i == 0) && (j == 0))
    {
      paramBoolean = bool;
      if (!this.x.f(B(), this.J3.c().c, this.X3, l)) {}
    }
    else
    {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private void f0()
  {
    for (n1 localn1 = this.N3.o(); localn1 != null; localn1 = localn1.j()) {
      for (com.google.android.exoplayer2.trackselection.g localg : localn1.o().c) {
        if (localg != null) {
          localg.k();
        }
      }
    }
  }
  
  private boolean f1(j2 paramj2, e0.a parama)
  {
    boolean bool1 = parama.b();
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (!bool1) {
      if (paramj2.q())
      {
        bool3 = bool2;
      }
      else
      {
        paramj2.n(paramj2.h(parama.a, this.p3).d, this.p2);
        bool3 = bool2;
        if (this.p2.f())
        {
          paramj2 = this.p2;
          bool3 = bool2;
          if (paramj2.m)
          {
            bool3 = bool2;
            if (paramj2.j != -9223372036854775807L) {
              bool3 = true;
            }
          }
        }
      }
    }
    return bool3;
  }
  
  private void g0(boolean paramBoolean)
  {
    for (n1 localn1 = this.N3.o(); localn1 != null; localn1 = localn1.j()) {
      for (com.google.android.exoplayer2.trackselection.g localg : localn1.o().c) {
        if (localg != null) {
          localg.n(paramBoolean);
        }
      }
    }
  }
  
  private void g1()
    throws ExoPlaybackException
  {
    int i = 0;
    this.X3 = false;
    this.J3.g();
    b2[] arrayOfb2 = this.c;
    int j = arrayOfb2.length;
    while (i < j)
    {
      b2 localb2 = arrayOfb2[i];
      if (O(localb2)) {
        localb2.start();
      }
      i++;
    }
  }
  
  private void h(b paramb, int paramInt)
    throws ExoPlaybackException
  {
    this.T3.b(1);
    r1 localr1 = this.O3;
    int i = paramInt;
    if (paramInt == -1) {
      i = localr1.p();
    }
    G(localr1.e(i, b.b(paramb), b.c(paramb)), false);
  }
  
  private void h0()
  {
    for (n1 localn1 = this.N3.o(); localn1 != null; localn1 = localn1.j()) {
      for (com.google.android.exoplayer2.trackselection.g localg : localn1.o().c) {
        if (localg != null) {
          localg.u();
        }
      }
    }
  }
  
  private void i()
    throws ExoPlaybackException
  {
    C0(true);
  }
  
  private void i1(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (this.b4)) {
      paramBoolean1 = false;
    } else {
      paramBoolean1 = true;
    }
    r0(paramBoolean1, false, true, false);
    this.T3.b(paramBoolean2);
    this.x.g();
    a1(1);
  }
  
  private void j(x1 paramx1)
    throws ExoPlaybackException
  {
    if (paramx1.j()) {
      return;
    }
    try
    {
      paramx1.f().k(paramx1.h(), paramx1.d());
      return;
    }
    finally
    {
      paramx1.k(true);
    }
  }
  
  private void j1()
    throws ExoPlaybackException
  {
    this.J3.h();
    for (b2 localb2 : this.c) {
      if (O(localb2)) {
        s(localb2);
      }
    }
  }
  
  private void k(b2 paramb2)
    throws ExoPlaybackException
  {
    if (!O(paramb2)) {
      return;
    }
    this.J3.a(paramb2);
    s(paramb2);
    paramb2.b();
    this.e4 -= 1;
  }
  
  private void k0()
  {
    this.T3.b(1);
    r0(false, false, false, true);
    this.x.b();
    int i;
    if (this.S3.b.q()) {
      i = 4;
    } else {
      i = 2;
    }
    a1(i);
    this.O3.w(this.y.c());
    this.z.i(2);
  }
  
  private void k1()
  {
    Object localObject = this.N3.i();
    boolean bool;
    if ((!this.Y3) && ((localObject == null) || (!((n1)localObject).a.c()))) {
      bool = false;
    } else {
      bool = true;
    }
    localObject = this.S3;
    if (bool != ((s1)localObject).h) {
      this.S3 = ((s1)localObject).a(bool);
    }
  }
  
  private void l()
    throws ExoPlaybackException, IOException
  {
    long l1 = this.L3.a();
    n1();
    int i = this.S3.f;
    if ((i != 1) && (i != 4))
    {
      Object localObject1 = this.N3.o();
      if (localObject1 == null)
      {
        A0(l1, 10L);
        return;
      }
      m0.a("doSomeWork");
      o1();
      Object localObject2;
      if (((n1)localObject1).d)
      {
        l2 = SystemClock.elapsedRealtime();
        ((n1)localObject1).a.u(this.S3.t - this.H3, this.I3);
        int j = 0;
        i = 1;
        for (bool1 = true;; bool1 = bool2)
        {
          localObject2 = this.c;
          k = i;
          bool2 = bool1;
          if (j >= localObject2.length) {
            break;
          }
          localObject2 = localObject2[j];
          if (!O((b2)localObject2))
          {
            k = i;
            bool2 = bool1;
          }
          else
          {
            ((b2)localObject2).t(this.g4, l2 * 1000L);
            if ((i != 0) && (((b2)localObject2).d())) {
              i = 1;
            } else {
              i = 0;
            }
            if (localObject1.c[j] != ((b2)localObject2).getStream()) {
              k = 1;
            } else {
              k = 0;
            }
            int m;
            if ((k == 0) && (((b2)localObject2).i())) {
              m = 1;
            } else {
              m = 0;
            }
            if ((k == 0) && (m == 0) && (!((b2)localObject2).g()) && (!((b2)localObject2).d())) {
              m = 0;
            } else {
              m = 1;
            }
            if ((bool1) && (m != 0)) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            k = i;
            bool2 = bool1;
            if (m == 0)
            {
              ((b2)localObject2).l();
              bool2 = bool1;
              k = i;
            }
          }
          j++;
          i = k;
        }
      }
      ((n1)localObject1).a.q();
      int k = 1;
      boolean bool2 = true;
      long l2 = ((n1)localObject1).f.e;
      if ((k != 0) && (((n1)localObject1).d) && ((l2 == -9223372036854775807L) || (l2 <= this.S3.t))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (this.W3))
      {
        this.W3 = false;
        R0(false, this.S3.n, false, 5);
      }
      if ((i != 0) && (((n1)localObject1).f.i))
      {
        a1(4);
        j1();
      }
      else if ((this.S3.f == 2) && (e1(bool2)))
      {
        a1(3);
        this.j4 = null;
        if (d1()) {
          g1();
        }
      }
      else if ((this.S3.f == 3) && (this.e4 == 0 ? !P() : !bool2))
      {
        this.X3 = d1();
        a1(2);
        if (this.X3)
        {
          h0();
          this.P3.d();
        }
        j1();
      }
      if (this.S3.f == 2)
      {
        for (i = 0;; i++)
        {
          localObject2 = this.c;
          if (i >= localObject2.length) {
            break;
          }
          if ((O(localObject2[i])) && (this.c[i].getStream() == localObject1.c[i])) {
            this.c[i].l();
          }
        }
        localObject1 = this.S3;
        if ((!((s1)localObject1).h) && (((s1)localObject1).s < 500000L) && (N())) {
          throw new IllegalStateException("Playback stuck buffering and not loading");
        }
      }
      boolean bool1 = this.d4;
      localObject1 = this.S3;
      if (bool1 != ((s1)localObject1).p) {
        this.S3 = ((s1)localObject1).d(bool1);
      }
      if ((!d1()) || (this.S3.f != 3))
      {
        i = this.S3.f;
        if (i != 2) {}
      }
      else
      {
        bool1 = X(l1, 10L) ^ true;
        break label825;
      }
      if ((this.e4 != 0) && (i != 4)) {
        A0(l1, 1000L);
      } else {
        this.z.k(2);
      }
      bool1 = false;
      label825:
      localObject1 = this.S3;
      if (((s1)localObject1).q != bool1) {
        this.S3 = ((s1)localObject1).i(bool1);
      }
      this.c4 = false;
      m0.c();
      return;
    }
    this.z.k(2);
  }
  
  private void l1(j2 paramj21, e0.a parama1, j2 paramj22, e0.a parama2, long paramLong)
  {
    if ((!paramj21.q()) && (f1(paramj21, parama1)))
    {
      paramj21.n(paramj21.h(parama1.a, this.p3).d, this.p2);
      this.P3.a((l1.f)o0.i(this.p2.o));
      if (paramLong != -9223372036854775807L)
      {
        this.P3.e(x(paramj21, parama1.a, paramLong));
      }
      else
      {
        parama1 = this.p2.e;
        paramj21 = null;
        if (!paramj22.q()) {
          paramj21 = paramj22.n(paramj22.h(parama2.a, this.p3).d, this.p2).e;
        }
        if (!o0.b(paramj21, parama1)) {
          this.P3.e(-9223372036854775807L);
        }
      }
      return;
    }
    float f1 = this.J3.c().c;
    paramj21 = this.S3.o;
    if (f1 != paramj21.c) {
      this.J3.e(paramj21);
    }
  }
  
  private void m(int paramInt, boolean paramBoolean)
    throws ExoPlaybackException
  {
    b2 localb2 = this.c[paramInt];
    if (O(localb2)) {
      return;
    }
    n1 localn1 = this.N3.p();
    boolean bool;
    if (localn1 == this.N3.o()) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = localn1.o();
    e2 locale2 = localObject.b[paramInt];
    localObject = w(localObject.c[paramInt]);
    int i;
    if ((d1()) && (this.S3.f == 3)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!paramBoolean) && (i != 0)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.e4 += 1;
    localb2.r(locale2, (Format[])localObject, localn1.c[paramInt], this.g4, paramBoolean, bool, localn1.m(), localn1.l());
    localb2.k(103, new a());
    this.J3.b(localb2);
    if (i != 0) {
      localb2.start();
    }
  }
  
  private void m0()
  {
    r0(true, false, true, false);
    this.x.h();
    a1(1);
    this.p0.quit();
    try
    {
      this.U3 = true;
      notifyAll();
      return;
    }
    finally {}
  }
  
  private void m1(TrackGroupArray paramTrackGroupArray, n paramn)
  {
    this.x.e(this.c, paramTrackGroupArray, paramn.c);
  }
  
  private void n0(int paramInt1, int paramInt2, p0 paramp0)
    throws ExoPlaybackException
  {
    this.T3.b(1);
    G(this.O3.A(paramInt1, paramInt2, paramp0), false);
  }
  
  private void n1()
    throws ExoPlaybackException, IOException
  {
    if ((!this.S3.b.q()) && (this.O3.r()))
    {
      Z();
      b0();
      c0();
      a0();
    }
  }
  
  private void o1()
    throws ExoPlaybackException
  {
    n1 localn1 = this.N3.o();
    if (localn1 == null) {
      return;
    }
    long l;
    if (localn1.d) {
      l = localn1.a.k();
    } else {
      l = -9223372036854775807L;
    }
    if (l != -9223372036854775807L)
    {
      t0(l);
      if (l != this.S3.t)
      {
        localObject = this.S3;
        this.S3 = K(((s1)localObject).c, l, ((s1)localObject).d, l, true, 5);
      }
    }
    else
    {
      localObject = this.J3;
      boolean bool;
      if (localn1 != this.N3.p()) {
        bool = true;
      } else {
        bool = false;
      }
      l = ((b1)localObject).i(bool);
      this.g4 = l;
      l = localn1.y(l);
      Y(this.S3.t, l);
      this.S3.t = l;
    }
    Object localObject = this.N3.i();
    this.S3.r = ((n1)localObject).i();
    this.S3.s = B();
    localObject = this.S3;
    if ((((s1)localObject).m) && (((s1)localObject).f == 3) && (f1(((s1)localObject).b, ((s1)localObject).c)) && (this.S3.o.c == 1.0F))
    {
      float f1 = this.P3.b(v(), B());
      if (this.J3.c().c != f1)
      {
        this.J3.e(this.S3.o.b(f1));
        I(this.S3.o, this.J3.c().c, false, false);
      }
    }
  }
  
  private boolean p0()
    throws ExoPlaybackException
  {
    n1 localn1 = this.N3.p();
    n localn = localn1.o();
    int i = 0;
    int j = 0;
    for (;;)
    {
      Object localObject = this.c;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (O((b2)localObject))
      {
        int k;
        if (((b2)localObject).getStream() != localn1.c[i]) {
          k = 1;
        } else {
          k = 0;
        }
        if ((!localn.c(i)) || (k != 0)) {
          if (!((b2)localObject).m()) {
            ((b2)localObject).n(w(localn.c[i]), localn1.c[i], localn1.m(), localn1.l());
          } else if (((b2)localObject).d()) {
            k((b2)localObject);
          } else {
            j = 1;
          }
        }
      }
      i++;
    }
    return j ^ 0x1;
  }
  
  private void p1(float paramFloat)
  {
    for (n1 localn1 = this.N3.o(); localn1 != null; localn1 = localn1.j()) {
      for (com.google.android.exoplayer2.trackselection.g localg : localn1.o().c) {
        if (localg != null) {
          localg.i(paramFloat);
        }
      }
    }
  }
  
  private void q()
    throws ExoPlaybackException
  {
    r(new boolean[this.c.length]);
  }
  
  private void q0()
    throws ExoPlaybackException
  {
    float f1 = this.J3.c().c;
    n1 localn1 = this.N3.o();
    Object localObject1 = this.N3.p();
    int i = 1;
    while ((localn1 != null) && (localn1.d))
    {
      Object localObject2 = localn1.v(f1, this.S3.b);
      if (!((n)localObject2).a(localn1.o()))
      {
        if (i != 0)
        {
          localn1 = this.N3.o();
          boolean bool = this.N3.z(localn1);
          localObject1 = new boolean[this.c.length];
          long l = localn1.b((n)localObject2, this.S3.t, bool, (boolean[])localObject1);
          localObject2 = this.S3;
          if ((((s1)localObject2).f != 4) && (l != ((s1)localObject2).t)) {
            bool = true;
          } else {
            bool = false;
          }
          localObject2 = this.S3;
          this.S3 = K(((s1)localObject2).c, l, ((s1)localObject2).d, ((s1)localObject2).e, bool, 5);
          if (bool) {
            t0(l);
          }
          localObject2 = new boolean[this.c.length];
          for (i = 0;; i++)
          {
            Object localObject3 = this.c;
            if (i >= localObject3.length) {
              break;
            }
            b2 localb2 = localObject3[i];
            localObject2[i] = O(localb2);
            localObject3 = localn1.c[i];
            if (localObject2[i] != 0) {
              if (localObject3 != localb2.getStream()) {
                k(localb2);
              } else if (localObject1[i] != 0) {
                localb2.v(this.g4);
              }
            }
          }
          r((boolean[])localObject2);
        }
        else
        {
          this.N3.z(localn1);
          if (localn1.d) {
            localn1.a((n)localObject2, Math.max(localn1.f.b, localn1.y(this.g4)), false);
          }
        }
        F(true);
        if (this.S3.f != 4)
        {
          V();
          o1();
          this.z.i(2);
        }
        return;
      }
      if (localn1 == localObject1) {
        i = 0;
      }
      localn1 = localn1.j();
    }
  }
  
  private void q1(t<Boolean> paramt, long paramLong)
  {
    try
    {
      long l1 = this.L3.elapsedRealtime();
      int i = 0;
      for (long l2 = paramLong;; l2 = l1 + paramLong - this.L3.elapsedRealtime())
      {
        boolean bool = ((Boolean)paramt.get()).booleanValue();
        if ((bool) || (l2 <= 0L)) {
          break;
        }
        try
        {
          this.L3.c();
          wait(l2);
        }
        catch (InterruptedException localInterruptedException)
        {
          i = 1;
        }
      }
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      return;
    }
    finally {}
  }
  
  private void r(boolean[] paramArrayOfBoolean)
    throws ExoPlaybackException
  {
    n1 localn1 = this.N3.p();
    n localn = localn1.o();
    int i = 0;
    int k;
    for (int j = 0;; j++)
    {
      k = i;
      if (j >= this.c.length) {
        break;
      }
      if (!localn.c(j)) {
        this.c[j].reset();
      }
    }
    while (k < this.c.length)
    {
      if (localn.c(k)) {
        m(k, paramArrayOfBoolean[k]);
      }
      k++;
    }
    localn1.g = true;
  }
  
  private void r0(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.z.k(2);
    TrackGroupArray localTrackGroupArray = null;
    this.j4 = null;
    this.X3 = false;
    this.J3.h();
    this.g4 = 0L;
    for (b2 localb2 : this.c)
    {
      try
      {
        k(localb2);
      }
      catch (RuntimeException localRuntimeException2) {}catch (ExoPlaybackException localExoPlaybackException) {}
      u.d("ExoPlayerImplInternal", "Disable failed.", localExoPlaybackException);
    }
    if (paramBoolean1) {
      for (??? : this.c) {
        try
        {
          ???.reset();
        }
        catch (RuntimeException localRuntimeException1)
        {
          u.d("ExoPlayerImplInternal", "Reset failed.", localRuntimeException1);
        }
      }
    }
    this.e4 = 0;
    Object localObject1 = this.S3;
    ??? = ((s1)localObject1).c;
    long l1 = ((s1)localObject1).t;
    long l2;
    if ((!this.S3.c.b()) && (!Q(this.S3, this.p3))) {
      l2 = this.S3.t;
    } else {
      l2 = this.S3.d;
    }
    if (paramBoolean2)
    {
      this.f4 = null;
      ??? = z(this.S3.b);
      localObject1 = (e0.a)((Pair)???).first;
      l3 = ((Long)((Pair)???).second).longValue();
      long l4 = -9223372036854775807L;
      ??? = localObject1;
      l1 = l3;
      l2 = l4;
      if (!((c0)localObject1).equals(this.S3.c))
      {
        ??? = 1;
        ??? = localObject1;
        l2 = l4;
        break label331;
      }
    }
    ??? = 0;
    long l3 = l1;
    label331:
    this.N3.e();
    this.Y3 = false;
    Object localObject3 = this.S3;
    j2 localj2 = ((s1)localObject3).b;
    ??? = ((s1)localObject3).f;
    if (paramBoolean4) {
      localObject1 = localTrackGroupArray;
    } else {
      localObject1 = ((s1)localObject3).g;
    }
    if (??? != 0) {
      localTrackGroupArray = TrackGroupArray.c;
    } else {
      localTrackGroupArray = ((s1)localObject3).i;
    }
    n localn;
    if (??? != 0) {
      localn = this.q;
    } else {
      localn = ((s1)localObject3).j;
    }
    if (??? != 0) {
      localObject3 = ImmutableList.of();
    } else {
      localObject3 = ((s1)localObject3).k;
    }
    s1 locals1 = this.S3;
    this.S3 = new s1(localj2, (e0.a)???, l2, l3, ???, (ExoPlaybackException)localObject1, false, localTrackGroupArray, localn, (List)localObject3, (e0.a)???, locals1.m, locals1.n, locals1.o, l3, 0L, l3, this.d4, false);
    if (paramBoolean3) {
      this.O3.y();
    }
  }
  
  private void s(b2 paramb2)
    throws ExoPlaybackException
  {
    if (paramb2.getState() == 2) {
      paramb2.stop();
    }
  }
  
  private void s0()
  {
    n1 localn1 = this.N3.o();
    boolean bool;
    if ((localn1 != null) && (localn1.f.h) && (this.V3)) {
      bool = true;
    } else {
      bool = false;
    }
    this.W3 = bool;
  }
  
  private void t0(long paramLong)
    throws ExoPlaybackException
  {
    Object localObject = this.N3.o();
    if (localObject != null) {
      paramLong = ((n1)localObject).z(paramLong);
    }
    this.g4 = paramLong;
    this.J3.d(paramLong);
    for (b2 localb2 : this.c) {
      if (O(localb2)) {
        localb2.v(this.g4);
      }
    }
    f0();
  }
  
  private ImmutableList<Metadata> u(com.google.android.exoplayer2.trackselection.g[] paramArrayOfg)
  {
    ImmutableList.a locala = new ImmutableList.a();
    int i = paramArrayOfg.length;
    int j = 0;
    int m;
    for (int k = 0; j < i; k = m)
    {
      Object localObject = paramArrayOfg[j];
      m = k;
      if (localObject != null)
      {
        localObject = ((j)localObject).a(0).p2;
        if (localObject == null)
        {
          locala.h(new Metadata(new Metadata.Entry[0]));
          m = k;
        }
        else
        {
          locala.h(localObject);
          m = 1;
        }
      }
      j++;
    }
    if (k != 0) {
      paramArrayOfg = locala.j();
    } else {
      paramArrayOfg = ImmutableList.of();
    }
    return paramArrayOfg;
  }
  
  private static void u0(j2 paramj2, d paramd, j2.c paramc, j2.b paramb)
  {
    int i = paramj2.n(paramj2.h(paramd.q, paramb).d, paramc).t;
    paramj2 = paramj2.g(i, paramb, true).c;
    long l = paramb.e;
    if (l != -9223372036854775807L) {
      l -= 1L;
    } else {
      l = Long.MAX_VALUE;
    }
    paramd.b(i, l, paramj2);
  }
  
  private long v()
  {
    s1 locals1 = this.S3;
    return x(locals1.b, locals1.c.a, locals1.t);
  }
  
  private static boolean v0(d paramd, j2 paramj21, j2 paramj22, int paramInt, boolean paramBoolean, j2.c paramc, j2.b paramb)
  {
    Object localObject = paramd.q;
    long l1;
    if (localObject == null)
    {
      if (paramd.c.e() == Long.MIN_VALUE) {
        l1 = -9223372036854775807L;
      } else {
        l1 = w0.d(paramd.c.e());
      }
      paramj22 = y0(paramj21, new h(paramd.c.g(), paramd.c.i(), l1), false, paramInt, paramBoolean, paramc, paramb);
      if (paramj22 == null) {
        return false;
      }
      paramd.b(paramj21.b(paramj22.first), ((Long)paramj22.second).longValue(), paramj22.first);
      if (paramd.c.e() == Long.MIN_VALUE) {
        u0(paramj21, paramd, paramc, paramb);
      }
      return true;
    }
    paramInt = paramj21.b(localObject);
    if (paramInt == -1) {
      return false;
    }
    if (paramd.c.e() == Long.MIN_VALUE)
    {
      u0(paramj21, paramd, paramc, paramb);
      return true;
    }
    paramd.d = paramInt;
    paramj22.h(paramd.q, paramb);
    if ((paramb.g) && (paramj22.n(paramb.d, paramc).s == paramj22.b(paramd.q)))
    {
      l1 = paramd.f;
      long l2 = paramb.m();
      paramj22 = paramj21.j(paramc, paramb, paramj21.h(paramd.q, paramb).d, l1 + l2);
      paramd.b(paramj21.b(paramj22.first), ((Long)paramj22.second).longValue(), paramj22.first);
    }
    return true;
  }
  
  private static Format[] w(com.google.android.exoplayer2.trackselection.g paramg)
  {
    int i = 0;
    int j;
    if (paramg != null) {
      j = paramg.length();
    } else {
      j = 0;
    }
    Format[] arrayOfFormat = new Format[j];
    while (i < j)
    {
      arrayOfFormat[i] = paramg.a(i);
      i++;
    }
    return arrayOfFormat;
  }
  
  private void w0(j2 paramj21, j2 paramj22)
  {
    if ((paramj21.q()) && (paramj22.q())) {
      return;
    }
    for (int i = this.K3.size() - 1; i >= 0; i--) {
      if (!v0((d)this.K3.get(i), paramj21, paramj22, this.Z3, this.a4, this.p2, this.p3))
      {
        ((d)this.K3.get(i)).c.k(false);
        this.K3.remove(i);
      }
    }
    Collections.sort(this.K3);
  }
  
  private long x(j2 paramj2, Object paramObject, long paramLong)
  {
    paramj2.n(paramj2.h(paramObject, this.p3).d, this.p2);
    paramj2 = this.p2;
    if ((paramj2.j != -9223372036854775807L) && (paramj2.f()))
    {
      paramj2 = this.p2;
      if (paramj2.m) {
        return w0.d(paramj2.a() - this.p2.j) - (paramLong + this.p3.m());
      }
    }
    return -9223372036854775807L;
  }
  
  private static g x0(j2 paramj2, s1 params1, @Nullable h paramh, p1 paramp1, int paramInt, boolean paramBoolean, j2.c paramc, j2.b paramb)
  {
    if (paramj2.q()) {
      return new g(s1.l(), 0L, -9223372036854775807L, false, true, false);
    }
    e0.a locala = params1.c;
    Object localObject1 = locala.a;
    boolean bool1 = Q(params1, paramb);
    if ((!params1.c.b()) && (!bool1)) {
      l1 = params1.t;
    } else {
      l1 = params1.d;
    }
    int i = 0;
    Object localObject2;
    long l2;
    boolean bool2;
    boolean bool3;
    if (paramh != null)
    {
      localObject2 = y0(paramj2, paramh, true, paramInt, paramBoolean, paramc, paramb);
      if (localObject2 == null)
      {
        paramInt = paramj2.a(paramBoolean);
        l2 = l1;
        bool2 = false;
        bool3 = false;
        paramBoolean = true;
      }
      else
      {
        if (paramh.c == -9223372036854775807L)
        {
          paramInt = paramj2.h(((Pair)localObject2).first, paramb).d;
          l2 = l1;
          bool2 = false;
        }
        else
        {
          localObject1 = ((Pair)localObject2).first;
          l2 = ((Long)((Pair)localObject2).second).longValue();
          bool2 = true;
          paramInt = -1;
        }
        if (params1.f == 4) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        paramBoolean = false;
      }
      bool4 = bool2;
      bool2 = paramBoolean;
      paramBoolean = bool3;
      bool3 = bool4;
    }
    else
    {
      if (params1.b.q()) {
        paramInt = paramj2.a(paramBoolean);
      }
      for (;;)
      {
        for (bool2 = false;; bool2 = paramBoolean)
        {
          paramBoolean = false;
          l2 = l1;
          bool3 = false;
          break label496;
          if (paramj2.b(localObject1) != -1) {
            break;
          }
          paramh = z0(paramc, paramb, paramInt, paramBoolean, localObject1, params1.b, paramj2);
          if (paramh == null)
          {
            paramInt = paramj2.a(paramBoolean);
            paramBoolean = true;
          }
          else
          {
            paramInt = paramj2.h(paramh, paramb).d;
            paramBoolean = false;
          }
        }
        if (l1 == -9223372036854775807L)
        {
          paramInt = paramj2.h(localObject1, paramb).d;
        }
        else
        {
          if (bool1)
          {
            localObject2 = params1.b;
            paramh = locala;
            ((j2)localObject2).h(paramh.a, paramb);
            if (params1.b.n(paramb.d, paramc).s == params1.b.b(paramh.a))
            {
              l2 = paramb.m();
              paramh = paramj2.j(paramc, paramb, paramj2.h(localObject1, paramb).d, l1 + l2);
              localObject1 = paramh.first;
              l2 = ((Long)paramh.second).longValue();
            }
            else
            {
              l2 = l1;
            }
            paramInt = -1;
            paramBoolean = false;
            bool2 = false;
            bool3 = true;
            break;
          }
          paramInt = -1;
        }
      }
    }
    label496:
    long l3;
    if (paramInt != -1)
    {
      paramh = paramj2.j(paramc, paramb, paramInt, -9223372036854775807L);
      localObject1 = paramh.first;
      l2 = ((Long)paramh.second).longValue();
      l3 = -9223372036854775807L;
    }
    else
    {
      l3 = l2;
    }
    paramh = paramp1.A(paramj2, localObject1, l2);
    if (paramh.e != -1)
    {
      paramInt = locala.e;
      if ((paramInt == -1) || (paramh.b < paramInt))
      {
        paramInt = 0;
        break label598;
      }
    }
    paramInt = 1;
    label598:
    boolean bool4 = locala.a.equals(localObject1);
    if ((bool4) && (!locala.b()) && (!paramh.b()) && (paramInt != 0)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    paramj2.h(localObject1, paramb);
    int j = i;
    if (bool4)
    {
      j = i;
      if (!bool1)
      {
        j = i;
        if (l1 == l3) {
          if ((!paramh.b()) || (!paramb.p(paramh.b)))
          {
            j = i;
            if (locala.b())
            {
              j = i;
              if (!paramb.p(locala.b)) {}
            }
          }
          else
          {
            j = 1;
          }
        }
      }
    }
    if ((paramInt != 0) || (j != 0)) {
      paramh = locala;
    }
    long l1 = l2;
    if (paramh.b()) {
      if (paramh.equals(locala))
      {
        l1 = params1.t;
      }
      else
      {
        paramj2.h(paramh.a, paramb);
        if (paramh.c == paramb.j(paramh.b)) {
          l1 = paramb.g();
        } else {
          l1 = 0L;
        }
      }
    }
    return new g(paramh, l1, l3, paramBoolean, bool2, bool3);
  }
  
  private long y()
  {
    n1 localn1 = this.N3.p();
    if (localn1 == null) {
      return 0L;
    }
    long l1 = localn1.l();
    if (!localn1.d) {
      return l1;
    }
    int i = 0;
    for (;;)
    {
      b2[] arrayOfb2 = this.c;
      if (i >= arrayOfb2.length) {
        break;
      }
      long l2 = l1;
      if (O(arrayOfb2[i])) {
        if (this.c[i].getStream() != localn1.c[i])
        {
          l2 = l1;
        }
        else
        {
          l2 = this.c[i].u();
          if (l2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
          }
          l2 = Math.max(l2, l1);
        }
      }
      i++;
      l1 = l2;
    }
    return l1;
  }
  
  @Nullable
  private static Pair<Object, Long> y0(j2 paramj2, h paramh, boolean paramBoolean1, int paramInt, boolean paramBoolean2, j2.c paramc, j2.b paramb)
  {
    j2 localj2 = paramh.a;
    if (paramj2.q()) {
      return null;
    }
    if (localj2.q()) {
      localj2 = paramj2;
    }
    try
    {
      Pair localPair1 = localj2.j(paramc, paramb, paramh.b, paramh.c);
      if (paramj2.equals(localj2)) {
        return localPair1;
      }
      if (paramj2.b(localPair1.first) != -1)
      {
        Pair localPair2 = localPair1;
        if (localj2.h(localPair1.first, paramb).g)
        {
          localPair2 = localPair1;
          if (localj2.n(paramb.d, paramc).s == localj2.b(localPair1.first)) {
            localPair2 = paramj2.j(paramc, paramb, paramj2.h(localPair1.first, paramb).d, paramh.c);
          }
        }
        return localPair2;
      }
      if (paramBoolean1)
      {
        paramh = z0(paramc, paramb, paramInt, paramBoolean2, localPair1.first, localj2, paramj2);
        if (paramh != null) {
          return paramj2.j(paramc, paramb, paramj2.h(paramh, paramb).d, -9223372036854775807L);
        }
      }
    }
    catch (IndexOutOfBoundsException paramj2)
    {
      for (;;) {}
    }
    return null;
  }
  
  private Pair<e0.a, Long> z(j2 paramj2)
  {
    boolean bool = paramj2.q();
    long l1 = 0L;
    if (bool) {
      return Pair.create(s1.l(), Long.valueOf(0L));
    }
    int i = paramj2.a(this.a4);
    Pair localPair = paramj2.j(this.p2, this.p3, i, -9223372036854775807L);
    e0.a locala = this.N3.A(paramj2, localPair.first, 0L);
    long l2 = ((Long)localPair.second).longValue();
    if (locala.b())
    {
      paramj2.h(locala.a, this.p3);
      l2 = l1;
      if (locala.c == this.p3.j(locala.b)) {
        l2 = this.p3.g();
      }
    }
    return Pair.create(locala, Long.valueOf(l2));
  }
  
  @Nullable
  static Object z0(j2.c paramc, j2.b paramb, int paramInt, boolean paramBoolean, Object paramObject, j2 paramj21, j2 paramj22)
  {
    int i = paramj21.b(paramObject);
    int j = paramj21.i();
    int k = 0;
    int m = -1;
    while ((k < j) && (m == -1))
    {
      i = paramj21.d(i, paramb, paramc, paramInt, paramBoolean);
      if (i == -1) {
        break;
      }
      m = paramj22.b(paramj21.m(i));
      k++;
    }
    if (m == -1) {
      paramc = null;
    } else {
      paramc = paramj22.m(m);
    }
    return paramc;
  }
  
  public Looper A()
  {
    return this.p1;
  }
  
  public void B0(j2 paramj2, int paramInt, long paramLong)
  {
    this.z.e(3, new h(paramj2, paramInt, paramLong)).a();
  }
  
  public void N0(List<r1.c> paramList, int paramInt, long paramLong, p0 paramp0)
  {
    this.z.e(17, new b(paramList, paramp0, paramInt, paramLong, null)).a();
  }
  
  public void Q0(boolean paramBoolean, int paramInt)
  {
    this.z.g(1, paramBoolean, paramInt).a();
  }
  
  public void S0(t1 paramt1)
  {
    this.z.e(4, paramt1).a();
  }
  
  public void U0(int paramInt)
  {
    this.z.g(11, paramInt, 0).a();
  }
  
  public void X0(boolean paramBoolean)
  {
    this.z.g(12, paramBoolean, 0).a();
  }
  
  public void a()
  {
    this.z.i(10);
  }
  
  public void c()
  {
    this.z.i(22);
  }
  
  public void d(t1 paramt1)
  {
    this.z.e(16, paramt1).a();
  }
  
  public void e(x1 paramx1)
  {
    try
    {
      if ((!this.U3) && (this.p0.isAlive()))
      {
        this.z.e(14, paramx1).a();
        return;
      }
      u.h("ExoPlayerImplInternal", "Ignoring messages sent after release.");
      paramx1.k(false);
      return;
    }
    finally {}
  }
  
  public void h1()
  {
    this.z.a(6).a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 1000;
    try
    {
      boolean bool;
      switch (paramMessage.what)
      {
      default: 
        return false;
      case 25: 
        i();
        break;
      case 24: 
        if (paramMessage.arg1 == 1) {
          bool = true;
        } else {
          bool = false;
        }
        O0(bool);
        break;
      case 23: 
        if (paramMessage.arg1 != 0) {
          bool = true;
        } else {
          bool = false;
        }
        P0(bool);
        break;
      case 22: 
        d0();
        break;
      case 21: 
        Z0((p0)paramMessage.obj);
        break;
      case 20: 
        n0(paramMessage.arg1, paramMessage.arg2, (p0)paramMessage.obj);
        break;
      case 19: 
        e0((c)paramMessage.obj);
        break;
      case 18: 
        h((b)paramMessage.obj, paramMessage.arg1);
        break;
      case 17: 
        M0((b)paramMessage.obj);
        break;
      case 16: 
        J((t1)paramMessage.obj, false);
        break;
      case 15: 
        I0((x1)paramMessage.obj);
        break;
      case 14: 
        G0((x1)paramMessage.obj);
        break;
      case 13: 
        if (paramMessage.arg1 != 0) {
          bool = true;
        } else {
          bool = false;
        }
        L0(bool, (AtomicBoolean)paramMessage.obj);
        break;
      case 12: 
        if (paramMessage.arg1 != 0) {
          bool = true;
        } else {
          bool = false;
        }
        Y0(bool);
        break;
      case 11: 
        V0(paramMessage.arg1);
        break;
      case 10: 
        q0();
        break;
      case 9: 
        D((com.google.android.exoplayer2.source.b0)paramMessage.obj);
        break;
      case 8: 
        H((com.google.android.exoplayer2.source.b0)paramMessage.obj);
        break;
      case 7: 
        m0();
        return true;
      case 6: 
        i1(false, true);
        break;
      case 5: 
        W0((g2)paramMessage.obj);
        break;
      case 4: 
        T0((t1)paramMessage.obj);
        break;
      case 3: 
        D0((h)paramMessage.obj);
        break;
      case 2: 
        l();
        break;
      case 1: 
        if (paramMessage.arg1 != 0) {
          bool = true;
        } else {
          bool = false;
        }
        R0(bool, paramMessage.arg2, true, 1);
        break;
      case 0: 
        k0();
      }
    }
    catch (RuntimeException paramMessage)
    {
      if (((paramMessage instanceof IllegalStateException)) || ((paramMessage instanceof IllegalArgumentException))) {
        i = 1004;
      }
      paramMessage = ExoPlaybackException.createForUnexpected(paramMessage, i);
      u.d("ExoPlayerImplInternal", "Playback error", paramMessage);
      i1(true, false);
      this.S3 = this.S3.f(paramMessage);
    }
    catch (IOException paramMessage)
    {
      E(paramMessage, 2000);
    }
    catch (BehindLiveWindowException paramMessage)
    {
      E(paramMessage, 1002);
    }
    catch (DataSourceException paramMessage)
    {
      E(paramMessage, paramMessage.reason);
    }
    catch (ParserException paramMessage)
    {
      int j = paramMessage.dataType;
      if (j == 1)
      {
        if (paramMessage.contentIsMalformed) {
          i = 3001;
        } else {
          i = 3003;
        }
      }
      else if (j == 4) {
        if (paramMessage.contentIsMalformed) {
          i = 3002;
        } else {
          i = 3004;
        }
      }
      E(paramMessage, i);
    }
    catch (DrmSession.DrmSessionException paramMessage)
    {
      E(paramMessage, paramMessage.errorCode);
    }
    catch (ExoPlaybackException localExoPlaybackException)
    {
      paramMessage = localExoPlaybackException;
      Object localObject2;
      if (localExoPlaybackException.type == 1)
      {
        localObject2 = this.N3.p();
        paramMessage = localExoPlaybackException;
        if (localObject2 != null) {
          paramMessage = localExoPlaybackException.copyWithMediaPeriodId(((n1)localObject2).f.a);
        }
      }
      Object localObject1;
      if ((paramMessage.isRecoverable) && (this.j4 == null))
      {
        u.i("ExoPlayerImplInternal", "Recoverable renderer error", paramMessage);
        this.j4 = paramMessage;
        localObject1 = this.z;
        ((r)localObject1).b(((r)localObject1).e(25, paramMessage));
      }
      else
      {
        localObject2 = this.j4;
        localObject1 = paramMessage;
        if (localObject2 != null)
        {
          ((Exception)localObject2).addSuppressed(paramMessage);
          localObject1 = this.j4;
        }
        u.d("ExoPlayerImplInternal", "Playback error", (Throwable)localObject1);
        i1(true, false);
        this.S3 = this.S3.f((ExoPlaybackException)localObject1);
      }
    }
    W();
    return true;
  }
  
  public void i0(com.google.android.exoplayer2.source.b0 paramb0)
  {
    this.z.e(9, paramb0).a();
  }
  
  public void j0()
  {
    this.z.a(0).a();
  }
  
  public boolean l0()
  {
    try
    {
      if ((!this.U3) && (this.p0.isAlive()))
      {
        this.z.i(7);
        a0 locala0 = new com/google/android/exoplayer2/a0;
        locala0.<init>(this);
        q1(locala0, this.Q3);
        boolean bool = this.U3;
        return bool;
      }
      return true;
    }
    finally {}
  }
  
  public void o0(int paramInt1, int paramInt2, p0 paramp0)
  {
    this.z.d(20, paramInt1, paramInt2, paramp0).a();
  }
  
  public void p(com.google.android.exoplayer2.source.b0 paramb0)
  {
    this.z.e(8, paramb0).a();
  }
  
  public void t(long paramLong)
  {
    this.k4 = paramLong;
  }
  
  class a
    implements b2.a
  {
    a() {}
    
    public void a()
    {
      g1.g(g1.this).i(2);
    }
    
    public void b(long paramLong)
    {
      if (paramLong >= 2000L) {
        g1.f(g1.this, true);
      }
    }
  }
  
  private static final class b
  {
    private final List<r1.c> a;
    private final p0 b;
    private final int c;
    private final long d;
    
    private b(List<r1.c> paramList, p0 paramp0, int paramInt, long paramLong)
    {
      this.a = paramList;
      this.b = paramp0;
      this.c = paramInt;
      this.d = paramLong;
    }
  }
  
  private static class c
  {
    public final int a;
    public final int b;
    public final int c;
    public final p0 d;
  }
  
  private static final class d
    implements Comparable<d>
  {
    public final x1 c;
    public int d;
    public long f;
    @Nullable
    public Object q;
    
    public d(x1 paramx1)
    {
      this.c = paramx1;
    }
    
    public int a(d paramd)
    {
      Object localObject = this.q;
      int i = 1;
      if (localObject == null) {
        j = 1;
      } else {
        j = 0;
      }
      int k;
      if (paramd.q == null) {
        k = 1;
      } else {
        k = 0;
      }
      if (j != k)
      {
        j = i;
        if (localObject != null) {
          j = -1;
        }
        return j;
      }
      if (localObject == null) {
        return 0;
      }
      int j = this.d - paramd.d;
      if (j != 0) {
        return j;
      }
      return o0.n(this.f, paramd.f);
    }
    
    public void b(int paramInt, long paramLong, Object paramObject)
    {
      this.d = paramInt;
      this.f = paramLong;
      this.q = paramObject;
    }
  }
  
  public static final class e
  {
    private boolean a;
    public s1 b;
    public int c;
    public boolean d;
    public int e;
    public boolean f;
    public int g;
    
    public e(s1 params1)
    {
      this.b = params1;
    }
    
    public void b(int paramInt)
    {
      boolean bool1 = this.a;
      boolean bool2;
      if (paramInt > 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.a = (bool1 | bool2);
      this.c += paramInt;
    }
    
    public void c(int paramInt)
    {
      this.a = true;
      this.f = true;
      this.g = paramInt;
    }
    
    public void d(s1 params1)
    {
      boolean bool1 = this.a;
      boolean bool2;
      if (this.b != params1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.a = (bool1 | bool2);
      this.b = params1;
    }
    
    public void e(int paramInt)
    {
      boolean bool1 = this.d;
      boolean bool2 = true;
      if ((bool1) && (this.e != 5))
      {
        if (paramInt != 5) {
          bool2 = false;
        }
        com.google.android.exoplayer2.util.g.a(bool2);
        return;
      }
      this.a = true;
      this.d = true;
      this.e = paramInt;
    }
  }
  
  public static abstract interface f
  {
    public abstract void a(g1.e parame);
  }
  
  private static final class g
  {
    public final e0.a a;
    public final long b;
    public final long c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    
    public g(e0.a parama, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.a = parama;
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramBoolean1;
      this.e = paramBoolean2;
      this.f = paramBoolean3;
    }
  }
  
  private static final class h
  {
    public final j2 a;
    public final int b;
    public final long c;
    
    public h(j2 paramj2, int paramInt, long paramLong)
    {
      this.a = paramj2;
      this.b = paramInt;
      this.c = paramLong;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\g1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */