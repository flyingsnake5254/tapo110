package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.g.b;
import com.google.android.exoplayer2.source.hls.playlist.g.d;
import com.google.android.exoplayer2.source.hls.playlist.g.e;
import com.google.android.exoplayer2.source.u0.a;
import com.google.android.exoplayer2.source.u0.b;
import com.google.android.exoplayer2.source.u0.c;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.n.b;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.j1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class i
{
  private final k a;
  private final l b;
  private final l c;
  private final r d;
  private final Uri[] e;
  private final Format[] f;
  private final HlsPlaylistTracker g;
  private final TrackGroup h;
  @Nullable
  private final List<Format> i;
  private final h j;
  private boolean k;
  private byte[] l;
  @Nullable
  private IOException m;
  @Nullable
  private Uri n;
  private boolean o;
  private com.google.android.exoplayer2.trackselection.g p;
  private long q;
  private boolean r;
  
  public i(k paramk, HlsPlaylistTracker paramHlsPlaylistTracker, Uri[] paramArrayOfUri, Format[] paramArrayOfFormat, j paramj, @Nullable a0 parama0, r paramr, @Nullable List<Format> paramList)
  {
    this.a = paramk;
    this.g = paramHlsPlaylistTracker;
    this.e = paramArrayOfUri;
    this.f = paramArrayOfFormat;
    this.d = paramr;
    this.i = paramList;
    this.j = new h(4);
    this.l = o0.f;
    this.q = -9223372036854775807L;
    paramk = paramj.a(1);
    this.b = paramk;
    if (parama0 != null) {
      paramk.b(parama0);
    }
    this.c = paramj.a(3);
    this.h = new TrackGroup(paramArrayOfFormat);
    paramk = new ArrayList();
    for (int i1 = 0; i1 < paramArrayOfUri.length; i1++) {
      if ((paramArrayOfFormat[i1].x & 0x4000) == 0) {
        paramk.add(Integer.valueOf(i1));
      }
    }
    this.p = new d(this.h, com.google.common.primitives.d.j(paramk));
  }
  
  @Nullable
  private static Uri c(com.google.android.exoplayer2.source.hls.playlist.g paramg, @Nullable g.e parame)
  {
    if (parame != null)
    {
      parame = parame.z;
      if (parame != null) {
        return n0.d(paramg.a, parame);
      }
    }
    return null;
  }
  
  private Pair<Long, Integer> e(@Nullable m paramm, boolean paramBoolean, com.google.android.exoplayer2.source.hls.playlist.g paramg, long paramLong1, long paramLong2)
  {
    int i1 = -1;
    if ((paramm != null) && (!paramBoolean))
    {
      if (paramm.p())
      {
        if (paramm.p == -1) {
          paramLong1 = paramm.g();
        } else {
          paramLong1 = paramm.j;
        }
        i2 = paramm.p;
        if (i2 != -1) {
          i1 = i2 + 1;
        }
        paramm = new Pair(Long.valueOf(paramLong1), Integer.valueOf(i1));
      }
      else
      {
        paramm = new Pair(Long.valueOf(paramm.j), Integer.valueOf(paramm.p));
      }
      return paramm;
    }
    long l1 = paramg.u;
    long l2 = paramLong2;
    if (paramm != null) {
      if (this.o) {
        l2 = paramLong2;
      } else {
        l2 = paramm.g;
      }
    }
    if ((!paramg.o) && (l2 >= l1 + paramLong1)) {
      return new Pair(Long.valueOf(paramg.k + paramg.r.size()), Integer.valueOf(-1));
    }
    l2 -= paramLong1;
    Object localObject = paramg.r;
    paramBoolean = this.g.j();
    int i2 = 0;
    if ((paramBoolean) && (paramm != null)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    int i3 = o0.f((List)localObject, Long.valueOf(l2), true, paramBoolean);
    paramLong2 = i3 + paramg.k;
    int i4 = i1;
    paramLong1 = paramLong2;
    if (i3 >= 0)
    {
      paramm = (g.d)paramg.r.get(i3);
      if (l2 < paramm.x + paramm.f) {
        paramm = paramm.I3;
      } else {
        paramm = paramg.s;
      }
      for (;;)
      {
        i4 = i1;
        paramLong1 = paramLong2;
        if (i2 >= paramm.size()) {
          break;
        }
        localObject = (g.b)paramm.get(i2);
        if (l2 < ((g.e)localObject).x + ((g.e)localObject).f)
        {
          i4 = i1;
          paramLong1 = paramLong2;
          if (!((g.b)localObject).H3) {
            break;
          }
          if (paramm == paramg.s) {
            paramLong1 = 1L;
          } else {
            paramLong1 = 0L;
          }
          paramLong1 = paramLong2 + paramLong1;
          i4 = i2;
          break;
        }
        i2++;
      }
    }
    return new Pair(Long.valueOf(paramLong1), Integer.valueOf(i4));
  }
  
  @Nullable
  private static e f(com.google.android.exoplayer2.source.hls.playlist.g paramg, long paramLong, int paramInt)
  {
    int i1 = (int)(paramLong - paramg.k);
    int i2 = paramg.r.size();
    Object localObject = null;
    if (i1 == i2)
    {
      if (paramInt == -1) {
        paramInt = 0;
      }
      if (paramInt < paramg.s.size()) {
        localObject = new e((g.e)paramg.s.get(paramInt), paramLong, paramInt);
      }
      return (e)localObject;
    }
    localObject = (g.d)paramg.r.get(i1);
    if (paramInt == -1) {
      return new e((g.e)localObject, paramLong, -1);
    }
    if (paramInt < ((g.d)localObject).I3.size()) {
      return new e((g.e)((g.d)localObject).I3.get(paramInt), paramLong, paramInt);
    }
    paramInt = i1 + 1;
    if (paramInt < paramg.r.size()) {
      return new e((g.e)paramg.r.get(paramInt), paramLong + 1L, -1);
    }
    if (!paramg.s.isEmpty()) {
      return new e((g.e)paramg.s.get(0), paramLong + 1L, 0);
    }
    return null;
  }
  
  @VisibleForTesting
  static List<g.e> h(com.google.android.exoplayer2.source.hls.playlist.g paramg, long paramLong, int paramInt)
  {
    int i1 = (int)(paramLong - paramg.k);
    if ((i1 >= 0) && (paramg.r.size() >= i1))
    {
      ArrayList localArrayList = new ArrayList();
      int i2 = paramg.r.size();
      int i3 = 0;
      int i4 = paramInt;
      if (i1 < i2)
      {
        i4 = i1;
        if (paramInt != -1)
        {
          localObject = (g.d)paramg.r.get(i1);
          if (paramInt == 0)
          {
            localArrayList.add(localObject);
          }
          else if (paramInt < ((g.d)localObject).I3.size())
          {
            localObject = ((g.d)localObject).I3;
            localArrayList.addAll(((List)localObject).subList(paramInt, ((List)localObject).size()));
          }
          i4 = i1 + 1;
        }
        Object localObject = paramg.r;
        localArrayList.addAll(((List)localObject).subList(i4, ((List)localObject).size()));
        i4 = 0;
      }
      if (paramg.n != -9223372036854775807L)
      {
        if (i4 == -1) {
          i4 = i3;
        }
        if (i4 < paramg.s.size())
        {
          paramg = paramg.s;
          localArrayList.addAll(paramg.subList(i4, paramg.size()));
        }
      }
      return Collections.unmodifiableList(localArrayList);
    }
    return ImmutableList.of();
  }
  
  @Nullable
  private b k(@Nullable Uri paramUri, int paramInt)
  {
    if (paramUri == null) {
      return null;
    }
    byte[] arrayOfByte = this.j.c(paramUri);
    if (arrayOfByte != null)
    {
      this.j.b(paramUri, arrayOfByte);
      return null;
    }
    paramUri = new n.b().i(paramUri).b(1).a();
    return new a(this.c, paramUri, this.f[paramInt], this.p.t(), this.p.j(), this.l);
  }
  
  private long r(long paramLong)
  {
    long l1 = this.q;
    long l2 = -9223372036854775807L;
    int i1;
    if (l1 != -9223372036854775807L) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      l2 = l1 - paramLong;
    }
    return l2;
  }
  
  private void v(com.google.android.exoplayer2.source.hls.playlist.g paramg)
  {
    long l1;
    if (paramg.o) {
      l1 = -9223372036854775807L;
    } else {
      l1 = paramg.e() - this.g.d();
    }
    this.q = l1;
  }
  
  public com.google.android.exoplayer2.source.u0.e[] a(@Nullable m paramm, long paramLong)
  {
    int i1;
    if (paramm == null) {
      i1 = -1;
    } else {
      i1 = this.h.b(paramm.d);
    }
    int i2 = this.p.length();
    com.google.android.exoplayer2.source.u0.e[] arrayOfe = new com.google.android.exoplayer2.source.u0.e[i2];
    for (int i3 = 0; i3 < i2; i3++)
    {
      int i4 = this.p.h(i3);
      Object localObject = this.e[i4];
      if (!this.g.i((Uri)localObject))
      {
        arrayOfe[i3] = com.google.android.exoplayer2.source.u0.e.a;
      }
      else
      {
        com.google.android.exoplayer2.source.hls.playlist.g localg = this.g.o((Uri)localObject, false);
        com.google.android.exoplayer2.util.g.e(localg);
        long l1 = localg.h - this.g.d();
        boolean bool;
        if (i4 != i1) {
          bool = true;
        } else {
          bool = false;
        }
        localObject = e(paramm, bool, localg, l1, paramLong);
        long l2 = ((Long)((Pair)localObject).first).longValue();
        i4 = ((Integer)((Pair)localObject).second).intValue();
        arrayOfe[i3] = new c(localg.a, l1, h(localg, l2, i4));
      }
    }
    return arrayOfe;
  }
  
  public int b(m paramm)
  {
    int i1 = paramm.p;
    int i2 = 1;
    if (i1 == -1) {
      return 1;
    }
    Object localObject = this.e[this.h.b(paramm.d)];
    com.google.android.exoplayer2.source.hls.playlist.g localg = (com.google.android.exoplayer2.source.hls.playlist.g)com.google.android.exoplayer2.util.g.e(this.g.o((Uri)localObject, false));
    i1 = (int)(paramm.j - localg.k);
    if (i1 < 0) {
      return 1;
    }
    if (i1 < localg.r.size()) {
      localObject = ((g.d)localg.r.get(i1)).I3;
    } else {
      localObject = localg.s;
    }
    if (paramm.p >= ((List)localObject).size()) {
      return 2;
    }
    localObject = (g.b)((List)localObject).get(paramm.p);
    if (((g.b)localObject).I3) {
      return 0;
    }
    if (!o0.b(Uri.parse(n0.c(localg.a, ((g.e)localObject).c)), paramm.b.a)) {
      i2 = 2;
    }
    return i2;
  }
  
  public void d(long paramLong1, long paramLong2, List<m> paramList, boolean paramBoolean, b paramb)
  {
    m localm;
    if (paramList.isEmpty()) {
      localm = null;
    } else {
      localm = (m)j1.f(paramList);
    }
    int i1;
    if (localm == null) {
      i1 = -1;
    } else {
      i1 = this.h.b(localm.d);
    }
    long l1 = paramLong2 - paramLong1;
    long l2 = r(paramLong1);
    long l3 = l1;
    long l4 = l2;
    if (localm != null)
    {
      l3 = l1;
      l4 = l2;
      if (!this.o)
      {
        long l5 = localm.d();
        l1 = Math.max(0L, l1 - l5);
        l3 = l1;
        l4 = l2;
        if (l2 != -9223372036854775807L)
        {
          l4 = Math.max(0L, l2 - l5);
          l3 = l1;
        }
      }
    }
    Object localObject1 = a(localm, paramLong2);
    this.p.q(paramLong1, l3, l4, paramList, (com.google.android.exoplayer2.source.u0.e[])localObject1);
    int i2 = this.p.r();
    boolean bool;
    if (i1 != i2) {
      bool = true;
    } else {
      bool = false;
    }
    localObject1 = this.e[i2];
    if (!this.g.i((Uri)localObject1))
    {
      paramb.c = ((Uri)localObject1);
      this.r &= ((Uri)localObject1).equals(this.n);
      this.n = ((Uri)localObject1);
      return;
    }
    paramList = this.g.o((Uri)localObject1, true);
    com.google.android.exoplayer2.util.g.e(paramList);
    this.o = paramList.c;
    v(paramList);
    paramLong1 = paramList.h - this.g.d();
    Object localObject2 = e(localm, bool, paramList, paramLong1, paramLong2);
    l4 = ((Long)((Pair)localObject2).first).longValue();
    int i3 = ((Integer)((Pair)localObject2).second).intValue();
    if ((l4 < paramList.k) && (localm != null) && (bool))
    {
      localObject1 = this.e[i1];
      paramList = this.g.o((Uri)localObject1, true);
      com.google.android.exoplayer2.util.g.e(paramList);
      paramLong1 = paramList.h - this.g.d();
      localObject2 = e(localm, false, paramList, paramLong1, paramLong2);
      paramLong2 = ((Long)((Pair)localObject2).first).longValue();
      i3 = ((Integer)((Pair)localObject2).second).intValue();
    }
    else
    {
      i1 = i2;
      paramLong2 = l4;
    }
    if (paramLong2 < paramList.k)
    {
      this.m = new BehindLiveWindowException();
      return;
    }
    Object localObject3 = f(paramList, paramLong2, i3);
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      if (!paramList.o)
      {
        paramb.c = ((Uri)localObject1);
        this.r &= ((Uri)localObject1).equals(this.n);
        this.n = ((Uri)localObject1);
        return;
      }
      if ((!paramBoolean) && (!paramList.r.isEmpty()))
      {
        localObject2 = new e((g.e)j1.f(paramList.r), paramList.k + paramList.r.size() - 1L, -1);
      }
      else
      {
        paramb.b = true;
        return;
      }
    }
    this.r = false;
    this.n = null;
    localObject3 = c(paramList, ((e)localObject2).a.d);
    b localb = k((Uri)localObject3, i1);
    paramb.a = localb;
    if (localb != null) {
      return;
    }
    Uri localUri = c(paramList, ((e)localObject2).a);
    localb = k(localUri, i1);
    paramb.a = localb;
    if (localb != null) {
      return;
    }
    paramBoolean = m.w(localm, (Uri)localObject1, paramList, (e)localObject2, paramLong1);
    if ((paramBoolean) && (((e)localObject2).d)) {
      return;
    }
    paramb.a = m.i(this.a, this.b, this.f[i1], paramLong1, paramList, (e)localObject2, (Uri)localObject1, this.i, this.p.t(), this.p.j(), this.k, this.d, localm, this.j.a(localUri), this.j.a((Uri)localObject3), paramBoolean);
  }
  
  public int g(long paramLong, List<? extends com.google.android.exoplayer2.source.u0.d> paramList)
  {
    if ((this.m == null) && (this.p.length() >= 2)) {
      return this.p.o(paramLong, paramList);
    }
    return paramList.size();
  }
  
  public TrackGroup i()
  {
    return this.h;
  }
  
  public com.google.android.exoplayer2.trackselection.g j()
  {
    return this.p;
  }
  
  public boolean l(b paramb, long paramLong)
  {
    com.google.android.exoplayer2.trackselection.g localg = this.p;
    return localg.e(localg.l(this.h.b(paramb.d)), paramLong);
  }
  
  public void m()
    throws IOException
  {
    Object localObject = this.m;
    if (localObject == null)
    {
      localObject = this.n;
      if ((localObject != null) && (this.r)) {
        this.g.c((Uri)localObject);
      }
      return;
    }
    throw ((Throwable)localObject);
  }
  
  public boolean n(Uri paramUri)
  {
    return o0.r(this.e, paramUri);
  }
  
  public void o(b paramb)
  {
    if ((paramb instanceof a))
    {
      paramb = (a)paramb;
      this.l = paramb.h();
      this.j.b(paramb.b.a, (byte[])com.google.android.exoplayer2.util.g.e(paramb.j()));
    }
  }
  
  public boolean p(Uri paramUri, long paramLong)
  {
    boolean bool1 = false;
    for (int i1 = 0;; i1++)
    {
      Uri[] arrayOfUri = this.e;
      if (i1 >= arrayOfUri.length) {
        break;
      }
      if (arrayOfUri[i1].equals(paramUri)) {
        break label44;
      }
    }
    i1 = -1;
    label44:
    if (i1 == -1) {
      return true;
    }
    i1 = this.p.l(i1);
    if (i1 == -1) {
      return true;
    }
    this.r |= paramUri.equals(this.n);
    boolean bool2;
    if (paramLong != -9223372036854775807L)
    {
      bool2 = bool1;
      if (this.p.e(i1, paramLong))
      {
        bool2 = bool1;
        if (!this.g.k(paramUri, paramLong)) {}
      }
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  public void q()
  {
    this.m = null;
  }
  
  public void s(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void t(com.google.android.exoplayer2.trackselection.g paramg)
  {
    this.p = paramg;
  }
  
  public boolean u(long paramLong, b paramb, List<? extends com.google.android.exoplayer2.source.u0.d> paramList)
  {
    if (this.m != null) {
      return false;
    }
    return this.p.g(paramLong, paramb, paramList);
  }
  
  private static final class a
    extends c
  {
    private byte[] l;
    
    public a(l paraml, n paramn, Format paramFormat, int paramInt, @Nullable Object paramObject, byte[] paramArrayOfByte)
    {
      super(paramn, 3, paramFormat, paramInt, paramObject, paramArrayOfByte);
    }
    
    protected void g(byte[] paramArrayOfByte, int paramInt)
    {
      this.l = Arrays.copyOf(paramArrayOfByte, paramInt);
    }
    
    @Nullable
    public byte[] j()
    {
      return this.l;
    }
  }
  
  public static final class b
  {
    @Nullable
    public b a;
    public boolean b;
    @Nullable
    public Uri c;
    
    public b()
    {
      a();
    }
    
    public void a()
    {
      this.a = null;
      this.b = false;
      this.c = null;
    }
  }
  
  @VisibleForTesting
  static final class c
    extends a
  {
    private final List<g.e> e;
    private final long f;
    private final String g;
    
    public c(String paramString, long paramLong, List<g.e> paramList)
    {
      super(paramList.size() - 1);
      this.g = paramString;
      this.f = paramLong;
      this.e = paramList;
    }
    
    public long a()
    {
      c();
      return this.f + ((g.e)this.e.get((int)d())).x;
    }
    
    public long b()
    {
      c();
      g.e locale = (g.e)this.e.get((int)d());
      return this.f + locale.x + locale.f;
    }
  }
  
  private static final class d
    extends com.google.android.exoplayer2.trackselection.e
  {
    private int h = p(paramTrackGroup.a(paramArrayOfInt[0]));
    
    public d(TrackGroup paramTrackGroup, int[] paramArrayOfInt)
    {
      super(paramArrayOfInt);
    }
    
    public int d()
    {
      return this.h;
    }
    
    @Nullable
    public Object j()
    {
      return null;
    }
    
    public void q(long paramLong1, long paramLong2, long paramLong3, List<? extends com.google.android.exoplayer2.source.u0.d> paramList, com.google.android.exoplayer2.source.u0.e[] paramArrayOfe)
    {
      paramLong1 = SystemClock.elapsedRealtime();
      if (!f(this.h, paramLong1)) {
        return;
      }
      for (int i = this.b - 1; i >= 0; i--) {
        if (!f(i, paramLong1))
        {
          this.h = i;
          return;
        }
      }
      throw new IllegalStateException();
    }
    
    public int t()
    {
      return 0;
    }
  }
  
  static final class e
  {
    public final g.e a;
    public final long b;
    public final int c;
    public final boolean d;
    
    public e(g.e parame, long paramLong, int paramInt)
    {
      this.a = parame;
      this.b = paramLong;
      this.c = paramInt;
      boolean bool;
      if (((parame instanceof g.b)) && (((g.b)parame).I3)) {
        bool = true;
      } else {
        bool = false;
      }
      this.d = bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */