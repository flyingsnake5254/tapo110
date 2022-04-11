package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.v.a;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.b0.a;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.f0.a;
import com.google.android.exoplayer2.source.m0;
import com.google.android.exoplayer2.source.m0.d;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.source.o0.a;
import com.google.android.exoplayer2.trackselection.j;
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.b;
import com.google.android.exoplayer2.upstream.Loader.c;
import com.google.android.exoplayer2.upstream.Loader.e;
import com.google.android.exoplayer2.upstream.Loader.f;
import com.google.android.exoplayer2.upstream.x.b;
import com.google.android.exoplayer2.upstream.x.c;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.a;
import com.google.common.collect.j1;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class q
  implements Loader.b<com.google.android.exoplayer2.source.u0.b>, Loader.f, com.google.android.exoplayer2.source.o0, com.google.android.exoplayer2.o2.l, m0.d
{
  private static final Set<Integer> c = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(5) })));
  private final int H3;
  private final i.b I3;
  private final ArrayList<m> J3;
  private final List<m> K3;
  private final Runnable L3;
  private final Runnable M3;
  private final Handler N3;
  private final ArrayList<p> O3;
  private final Map<String, DrmInitData> P3;
  @Nullable
  private com.google.android.exoplayer2.source.u0.b Q3;
  private d[] R3;
  private int[] S3;
  private Set<Integer> T3;
  private SparseIntArray U3;
  private b0 V3;
  private int W3;
  private int X3;
  private boolean Y3;
  private boolean Z3;
  private int a4;
  private Format b4;
  @Nullable
  private Format c4;
  private final int d;
  private boolean d4;
  private TrackGroupArray e4;
  private final b f;
  private Set<TrackGroup> f4;
  private int[] g4;
  private int h4;
  private boolean i4;
  private boolean[] j4;
  private boolean[] k4;
  private long l4;
  private long m4;
  private boolean n4;
  private boolean o4;
  private final v.a p0;
  private final com.google.android.exoplayer2.upstream.x p1;
  private final Loader p2;
  private final f0.a p3;
  private boolean p4;
  private final i q;
  private boolean q4;
  private long r4;
  @Nullable
  private DrmInitData s4;
  @Nullable
  private m t4;
  private final com.google.android.exoplayer2.upstream.e x;
  @Nullable
  private final Format y;
  private final com.google.android.exoplayer2.drm.x z;
  
  public q(int paramInt1, b paramb, i parami, Map<String, DrmInitData> paramMap, com.google.android.exoplayer2.upstream.e parame, long paramLong, @Nullable Format paramFormat, com.google.android.exoplayer2.drm.x paramx, v.a parama, com.google.android.exoplayer2.upstream.x paramx1, f0.a parama1, int paramInt2)
  {
    this.d = paramInt1;
    this.f = paramb;
    this.q = parami;
    this.P3 = paramMap;
    this.x = parame;
    this.y = paramFormat;
    this.z = paramx;
    this.p0 = parama;
    this.p1 = paramx1;
    this.p3 = parama1;
    this.H3 = paramInt2;
    this.p2 = new Loader("Loader:HlsSampleStreamWrapper");
    this.I3 = new i.b();
    this.S3 = new int[0];
    paramb = c;
    this.T3 = new HashSet(paramb.size());
    this.U3 = new SparseIntArray(paramb.size());
    this.R3 = new d[0];
    this.k4 = new boolean[0];
    this.j4 = new boolean[0];
    paramb = new ArrayList();
    this.J3 = paramb;
    this.K3 = Collections.unmodifiableList(paramb);
    this.O3 = new ArrayList();
    this.L3 = new b(this);
    this.M3 = new a(this);
    this.N3 = com.google.android.exoplayer2.util.o0.v();
    this.l4 = paramLong;
    this.m4 = paramLong;
  }
  
  private static com.google.android.exoplayer2.o2.i A(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(54);
    localStringBuilder.append("Unmapped track with id ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" of type ");
    localStringBuilder.append(paramInt2);
    u.h("HlsSampleStreamWrapper", localStringBuilder.toString());
    return new com.google.android.exoplayer2.o2.i();
  }
  
  private m0 B(int paramInt1, int paramInt2)
  {
    int i = this.R3.length;
    int j = 1;
    int k = j;
    if (paramInt2 != 1) {
      if (paramInt2 == 2) {
        k = j;
      } else {
        k = 0;
      }
    }
    d locald = new d(this.x, this.N3.getLooper(), this.z, this.p0, this.P3, null);
    locald.U(this.l4);
    if (k != 0) {
      locald.b0(this.s4);
    }
    locald.T(this.r4);
    Object localObject = this.t4;
    if (localObject != null) {
      locald.c0((m)localObject);
    }
    locald.W(this);
    localObject = this.S3;
    int m = i + 1;
    localObject = Arrays.copyOf((int[])localObject, m);
    this.S3 = ((int[])localObject);
    localObject[i] = paramInt1;
    this.R3 = ((d[])com.google.android.exoplayer2.util.o0.u0(this.R3, locald));
    localObject = Arrays.copyOf(this.k4, m);
    this.k4 = ((boolean[])localObject);
    localObject[i] = k;
    k = this.i4;
    this.i4 = (localObject[i] | k);
    this.T3.add(Integer.valueOf(paramInt2));
    this.U3.append(paramInt2, i);
    if (K(paramInt2) > K(this.W3))
    {
      this.X3 = i;
      this.W3 = paramInt2;
    }
    this.j4 = Arrays.copyOf(this.j4, m);
    return locald;
  }
  
  private TrackGroupArray C(TrackGroup[] paramArrayOfTrackGroup)
  {
    for (int i = 0; i < paramArrayOfTrackGroup.length; i++)
    {
      TrackGroup localTrackGroup = paramArrayOfTrackGroup[i];
      Format[] arrayOfFormat = new Format[localTrackGroup.c];
      for (int j = 0; j < localTrackGroup.c; j++)
      {
        Format localFormat = localTrackGroup.a(j);
        arrayOfFormat[j] = localFormat.b(this.z.c(localFormat));
      }
      paramArrayOfTrackGroup[i] = new TrackGroup(arrayOfFormat);
    }
    return new TrackGroupArray(paramArrayOfTrackGroup);
  }
  
  private static Format D(@Nullable Format paramFormat1, Format paramFormat2, boolean paramBoolean)
  {
    if (paramFormat1 == null) {
      return paramFormat2;
    }
    int i = com.google.android.exoplayer2.util.y.k(paramFormat2.H3);
    if (com.google.android.exoplayer2.util.o0.F(paramFormat1.p1, i) == 1)
    {
      localObject1 = com.google.android.exoplayer2.util.o0.G(paramFormat1.p1, i);
      localObject2 = com.google.android.exoplayer2.util.y.g((String)localObject1);
    }
    else
    {
      localObject1 = com.google.android.exoplayer2.util.y.d(paramFormat1.p1, paramFormat2.H3);
      localObject2 = paramFormat2.H3;
    }
    Format.b localb = paramFormat2.a().S(paramFormat1.c).U(paramFormat1.d).V(paramFormat1.f).g0(paramFormat1.q).c0(paramFormat1.x);
    if (paramBoolean) {
      j = paramFormat1.y;
    } else {
      j = -1;
    }
    localb = localb.G(j);
    if (paramBoolean) {
      j = paramFormat1.z;
    } else {
      j = -1;
    }
    Object localObject1 = localb.Z(j).I((String)localObject1);
    if (i == 2) {
      ((Format.b)localObject1).j0(paramFormat1.M3).Q(paramFormat1.N3).P(paramFormat1.O3);
    }
    if (localObject2 != null) {
      ((Format.b)localObject1).e0((String)localObject2);
    }
    int j = paramFormat1.U3;
    if ((j != -1) && (i == 1)) {
      ((Format.b)localObject1).H(j);
    }
    Object localObject2 = paramFormat1.p2;
    if (localObject2 != null)
    {
      paramFormat2 = paramFormat2.p2;
      paramFormat1 = (Format)localObject2;
      if (paramFormat2 != null) {
        paramFormat1 = paramFormat2.b((Metadata)localObject2);
      }
      ((Format.b)localObject1).X(paramFormat1);
    }
    return ((Format.b)localObject1).E();
  }
  
  private void E(int paramInt)
  {
    com.google.android.exoplayer2.util.g.g(this.p2.i() ^ true);
    while (paramInt < this.J3.size())
    {
      if (y(paramInt)) {
        break label42;
      }
      paramInt++;
    }
    paramInt = -1;
    label42:
    if (paramInt == -1) {
      return;
    }
    long l = I().h;
    m localm = F(paramInt);
    if (this.J3.isEmpty()) {
      this.m4 = this.l4;
    } else {
      ((m)j1.f(this.J3)).n();
    }
    this.p4 = false;
    this.p3.D(this.W3, localm.g, l);
  }
  
  private m F(int paramInt)
  {
    m localm = (m)this.J3.get(paramInt);
    ArrayList localArrayList = this.J3;
    com.google.android.exoplayer2.util.o0.B0(localArrayList, paramInt, localArrayList.size());
    for (paramInt = 0; paramInt < this.R3.length; paramInt++)
    {
      int i = localm.l(paramInt);
      this.R3[paramInt].q(i);
    }
    return localm;
  }
  
  private boolean G(m paramm)
  {
    int i = paramm.l;
    int j = this.R3.length;
    for (int k = 0; k < j; k++) {
      if ((this.j4[k] != 0) && (this.R3[k].K() == i)) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean H(Format paramFormat1, Format paramFormat2)
  {
    String str1 = paramFormat1.H3;
    String str2 = paramFormat2.H3;
    int i = com.google.android.exoplayer2.util.y.k(str1);
    boolean bool1 = true;
    boolean bool2 = true;
    if (i != 3)
    {
      if (i != com.google.android.exoplayer2.util.y.k(str2)) {
        bool2 = false;
      }
      return bool2;
    }
    if (!com.google.android.exoplayer2.util.o0.b(str1, str2)) {
      return false;
    }
    if ((!"application/cea-608".equals(str1)) && (!"application/cea-708".equals(str1))) {
      return true;
    }
    if (paramFormat1.Z3 == paramFormat2.Z3) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    return bool2;
  }
  
  private m I()
  {
    ArrayList localArrayList = this.J3;
    return (m)localArrayList.get(localArrayList.size() - 1);
  }
  
  @Nullable
  private b0 J(int paramInt1, int paramInt2)
  {
    com.google.android.exoplayer2.util.g.a(c.contains(Integer.valueOf(paramInt2)));
    int i = this.U3.get(paramInt2, -1);
    if (i == -1) {
      return null;
    }
    if (this.T3.add(Integer.valueOf(paramInt2))) {
      this.S3[i] = paramInt1;
    }
    Object localObject;
    if (this.S3[i] == paramInt1) {
      localObject = this.R3[i];
    } else {
      localObject = A(paramInt1, paramInt2);
    }
    return (b0)localObject;
  }
  
  private static int K(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return 0;
        }
        return 1;
      }
      return 3;
    }
    return 2;
  }
  
  private void L(m paramm)
  {
    this.t4 = paramm;
    this.b4 = paramm.d;
    this.m4 = -9223372036854775807L;
    this.J3.add(paramm);
    Object localObject = ImmutableList.builder();
    d[] arrayOfd = this.R3;
    int i = arrayOfd.length;
    int j = 0;
    for (int k = 0; k < i; k++) {
      ((ImmutableList.a)localObject).h(Integer.valueOf(arrayOfd[k].A()));
    }
    paramm.m(this, ((ImmutableList.a)localObject).j());
    localObject = this.R3;
    i = localObject.length;
    for (k = j; k < i; k++)
    {
      arrayOfd = localObject[k];
      arrayOfd.c0(paramm);
      if (paramm.o) {
        arrayOfd.Z();
      }
    }
  }
  
  private static boolean M(com.google.android.exoplayer2.source.u0.b paramb)
  {
    return paramb instanceof m;
  }
  
  private boolean N()
  {
    boolean bool;
    if (this.m4 != -9223372036854775807L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @EnsuresNonNull({"trackGroupToSampleQueueIndex"})
  @RequiresNonNull({"trackGroups"})
  private void R()
  {
    int i = this.e4.d;
    Object localObject = new int[i];
    this.g4 = ((int[])localObject);
    Arrays.fill((int[])localObject, -1);
    for (int j = 0; j < i; j++) {
      for (int k = 0;; k++)
      {
        localObject = this.R3;
        if (k >= localObject.length) {
          break;
        }
        if (H((Format)com.google.android.exoplayer2.util.g.i(localObject[k].z()), this.e4.a(j).a(0)))
        {
          this.g4[j] = k;
          break;
        }
      }
    }
    localObject = this.O3.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((p)((Iterator)localObject).next()).d();
    }
  }
  
  private void S()
  {
    if ((!this.d4) && (this.g4 == null) && (this.Y3))
    {
      d[] arrayOfd = this.R3;
      int i = arrayOfd.length;
      for (int j = 0; j < i; j++) {
        if (arrayOfd[j].z() == null) {
          return;
        }
      }
      if (this.e4 != null)
      {
        R();
      }
      else
      {
        x();
        k0();
        this.f.b();
      }
    }
  }
  
  private void b0()
  {
    this.Y3 = true;
    S();
  }
  
  private void f0()
  {
    d[] arrayOfd = this.R3;
    int i = arrayOfd.length;
    for (int j = 0; j < i; j++) {
      arrayOfd[j].Q(this.n4);
    }
    this.n4 = false;
  }
  
  private boolean g0(long paramLong)
  {
    int i = this.R3.length;
    for (int j = 0; j < i; j++) {
      if ((!this.R3[j].S(paramLong, false)) && ((this.k4[j] != 0) || (!this.i4))) {
        return false;
      }
    }
    return true;
  }
  
  @RequiresNonNull({"trackGroups", "optionalTrackGroups"})
  private void k0()
  {
    this.Z3 = true;
  }
  
  private void p0(n0[] paramArrayOfn0)
  {
    this.O3.clear();
    int i = paramArrayOfn0.length;
    for (int j = 0; j < i; j++)
    {
      n0 localn0 = paramArrayOfn0[j];
      if (localn0 != null) {
        this.O3.add((p)localn0);
      }
    }
  }
  
  @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
  private void v()
  {
    com.google.android.exoplayer2.util.g.g(this.Z3);
    com.google.android.exoplayer2.util.g.e(this.e4);
    com.google.android.exoplayer2.util.g.e(this.f4);
  }
  
  @EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
  private void x()
  {
    int i = this.R3.length;
    boolean bool = false;
    int j = 0;
    int k = 7;
    Object localObject;
    for (int m = -1;; m = i1)
    {
      n = 2;
      if (j >= i) {
        break;
      }
      localObject = ((Format)com.google.android.exoplayer2.util.g.i(this.R3[j].z())).H3;
      if (!com.google.android.exoplayer2.util.y.q((String)localObject)) {
        if (com.google.android.exoplayer2.util.y.o((String)localObject)) {
          n = 1;
        } else if (com.google.android.exoplayer2.util.y.p((String)localObject)) {
          n = 3;
        } else {
          n = 7;
        }
      }
      int i2;
      if (K(n) > K(k))
      {
        i1 = j;
        i2 = n;
      }
      else
      {
        i2 = k;
        i1 = m;
        if (n == k)
        {
          i2 = k;
          i1 = m;
          if (m != -1)
          {
            i1 = -1;
            i2 = k;
          }
        }
      }
      j++;
      k = i2;
    }
    TrackGroup localTrackGroup = this.q.i();
    int i1 = localTrackGroup.c;
    this.h4 = -1;
    this.g4 = new int[i];
    for (int n = 0; n < i; n++) {
      this.g4[n] = n;
    }
    TrackGroup[] arrayOfTrackGroup = new TrackGroup[i];
    for (n = 0; n < i; n++)
    {
      Format localFormat = (Format)com.google.android.exoplayer2.util.g.i(this.R3[n].z());
      if (n == m)
      {
        localObject = new Format[i1];
        if (i1 == 1) {
          localObject[0] = localFormat.e(localTrackGroup.a(0));
        } else {
          for (j = 0; j < i1; j++) {
            localObject[j] = D(localTrackGroup.a(j), localFormat, true);
          }
        }
        arrayOfTrackGroup[n] = new TrackGroup((Format[])localObject);
        this.h4 = n;
      }
      else
      {
        if ((k == 2) && (com.google.android.exoplayer2.util.y.o(localFormat.H3))) {
          localObject = this.y;
        } else {
          localObject = null;
        }
        arrayOfTrackGroup[n] = new TrackGroup(new Format[] { D((Format)localObject, localFormat, false) });
      }
    }
    this.e4 = C(arrayOfTrackGroup);
    if (this.f4 == null) {
      bool = true;
    }
    com.google.android.exoplayer2.util.g.g(bool);
    this.f4 = Collections.emptySet();
  }
  
  private boolean y(int paramInt)
  {
    for (int i = paramInt; i < this.J3.size(); i++) {
      if (((m)this.J3.get(i)).o) {
        return false;
      }
    }
    m localm = (m)this.J3.get(paramInt);
    for (paramInt = 0; paramInt < this.R3.length; paramInt++)
    {
      i = localm.l(paramInt);
      if (this.R3[paramInt].w() > i) {
        return false;
      }
    }
    return true;
  }
  
  public boolean O(int paramInt)
  {
    boolean bool;
    if ((!N()) && (this.R3[paramInt].E(this.p4))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void T()
    throws IOException
  {
    this.p2.j();
    this.q.m();
  }
  
  public void U(int paramInt)
    throws IOException
  {
    T();
    this.R3[paramInt].H();
  }
  
  public void V(com.google.android.exoplayer2.source.u0.b paramb, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.Q3 = null;
    com.google.android.exoplayer2.source.x localx = new com.google.android.exoplayer2.source.x(paramb.a, paramb.b, paramb.f(), paramb.e(), paramLong1, paramLong2, paramb.b());
    this.p1.d(paramb.a);
    this.p3.r(localx, paramb.c, this.d, paramb.d, paramb.e, paramb.f, paramb.g, paramb.h);
    if (!paramBoolean)
    {
      if ((N()) || (this.a4 == 0)) {
        f0();
      }
      if (this.a4 > 0) {
        this.f.n(this);
      }
    }
  }
  
  public void W(com.google.android.exoplayer2.source.u0.b paramb, long paramLong1, long paramLong2)
  {
    this.Q3 = null;
    this.q.o(paramb);
    com.google.android.exoplayer2.source.x localx = new com.google.android.exoplayer2.source.x(paramb.a, paramb.b, paramb.f(), paramb.e(), paramLong1, paramLong2, paramb.b());
    this.p1.d(paramb.a);
    this.p3.u(localx, paramb.c, this.d, paramb.d, paramb.e, paramb.f, paramb.g, paramb.h);
    if (!this.Z3) {
      d(this.l4);
    } else {
      this.f.n(this);
    }
  }
  
  public Loader.c X(com.google.android.exoplayer2.source.u0.b paramb, long paramLong1, long paramLong2, IOException paramIOException, int paramInt)
  {
    boolean bool1 = M(paramb);
    if ((bool1) && (!((m)paramb).q()) && ((paramIOException instanceof HttpDataSource.InvalidResponseCodeException)))
    {
      int i = ((HttpDataSource.InvalidResponseCodeException)paramIOException).responseCode;
      if ((i == 410) || (i == 404)) {
        return Loader.a;
      }
    }
    long l = paramb.b();
    com.google.android.exoplayer2.source.x localx = new com.google.android.exoplayer2.source.x(paramb.a, paramb.b, paramb.f(), paramb.e(), paramLong1, paramLong2, l);
    x.c localc = new x.c(localx, new a0(paramb.c, this.d, paramb.d, paramb.e, paramb.f, w0.e(paramb.g), w0.e(paramb.h)), paramIOException, paramInt);
    Object localObject = this.p1.c(com.google.android.exoplayer2.trackselection.l.a(this.q.j()), localc);
    boolean bool2 = false;
    boolean bool3;
    if ((localObject != null) && (((x.b)localObject).a == 2)) {
      bool3 = this.q.l(paramb, ((x.b)localObject).b);
    } else {
      bool3 = false;
    }
    if (bool3)
    {
      if ((bool1) && (l == 0L))
      {
        localObject = this.J3;
        if ((m)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1) == paramb) {
          bool2 = true;
        }
        com.google.android.exoplayer2.util.g.g(bool2);
        if (this.J3.isEmpty()) {
          this.m4 = this.l4;
        } else {
          ((m)j1.f(this.J3)).n();
        }
      }
      localObject = Loader.c;
    }
    for (;;)
    {
      break;
      paramLong1 = this.p1.a(localc);
      if (paramLong1 != -9223372036854775807L) {
        localObject = Loader.g(false, paramLong1);
      } else {
        localObject = Loader.d;
      }
    }
    bool2 = ((Loader.c)localObject).c() ^ true;
    this.p3.w(localx, paramb.c, this.d, paramb.d, paramb.e, paramb.f, paramb.g, paramb.h, paramIOException, bool2);
    if (bool2)
    {
      this.Q3 = null;
      this.p1.d(paramb.a);
    }
    if (bool3) {
      if (!this.Z3) {
        d(this.l4);
      } else {
        this.f.n(this);
      }
    }
    return (Loader.c)localObject;
  }
  
  public void Y()
  {
    this.T3.clear();
  }
  
  public boolean Z(Uri paramUri, x.c paramc, boolean paramBoolean)
  {
    if (!this.q.n(paramUri)) {
      return true;
    }
    long l1 = -9223372036854775807L;
    long l2 = l1;
    if (!paramBoolean)
    {
      paramc = this.p1.c(com.google.android.exoplayer2.trackselection.l.a(this.q.j()), paramc);
      l2 = l1;
      if (paramc != null)
      {
        l2 = l1;
        if (paramc.a == 2) {
          l2 = paramc.b;
        }
      }
    }
    return this.q.p(paramUri, l2);
  }
  
  public long a()
  {
    if (N()) {
      return this.m4;
    }
    long l;
    if (this.p4) {
      l = Long.MIN_VALUE;
    } else {
      l = I().h;
    }
    return l;
  }
  
  public void a0()
  {
    if (this.J3.isEmpty()) {
      return;
    }
    m localm = (m)j1.f(this.J3);
    int i = this.q.b(localm);
    if (i == 1) {
      localm.v();
    } else if ((i == 2) && (!this.p4) && (this.p2.i())) {
      this.p2.e();
    }
  }
  
  public boolean c()
  {
    return this.p2.i();
  }
  
  public void c0(TrackGroup[] paramArrayOfTrackGroup, int paramInt, int... paramVarArgs)
  {
    this.e4 = C(paramArrayOfTrackGroup);
    this.f4 = new HashSet();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramVarArgs[j];
      this.f4.add(this.e4.a(k));
    }
    this.h4 = paramInt;
    paramArrayOfTrackGroup = this.N3;
    paramVarArgs = this.f;
    Objects.requireNonNull(paramVarArgs);
    paramArrayOfTrackGroup.post(new c(paramVarArgs));
    k0();
  }
  
  public boolean d(long paramLong)
  {
    if ((!this.p4) && (!this.p2.i()) && (!this.p2.h()))
    {
      long l2;
      if (N())
      {
        localObject1 = Collections.emptyList();
        long l1 = this.m4;
        d[] arrayOfd = this.R3;
        int i = arrayOfd.length;
        for (int j = 0;; j++)
        {
          localObject2 = localObject1;
          l2 = l1;
          if (j >= i) {
            break;
          }
          arrayOfd[j].U(this.m4);
        }
      }
      Object localObject2 = this.K3;
      Object localObject1 = I();
      if (((m)localObject1).p()) {
        l2 = ((com.google.android.exoplayer2.source.u0.b)localObject1).h;
      } else {
        l2 = Math.max(this.l4, ((com.google.android.exoplayer2.source.u0.b)localObject1).g);
      }
      this.I3.a();
      localObject1 = this.q;
      if ((!this.Z3) && (((List)localObject2).isEmpty())) {
        bool = false;
      } else {
        bool = true;
      }
      ((i)localObject1).d(paramLong, l2, (List)localObject2, bool, this.I3);
      localObject1 = this.I3;
      boolean bool = ((i.b)localObject1).b;
      localObject2 = ((i.b)localObject1).a;
      localObject1 = ((i.b)localObject1).c;
      if (bool)
      {
        this.m4 = -9223372036854775807L;
        this.p4 = true;
        return true;
      }
      if (localObject2 == null)
      {
        if (localObject1 != null) {
          this.f.o((Uri)localObject1);
        }
        return false;
      }
      if (M((com.google.android.exoplayer2.source.u0.b)localObject2)) {
        L((m)localObject2);
      }
      this.Q3 = ((com.google.android.exoplayer2.source.u0.b)localObject2);
      paramLong = this.p2.n((Loader.e)localObject2, this, this.p1.b(((com.google.android.exoplayer2.source.u0.b)localObject2).c));
      this.p3.A(new com.google.android.exoplayer2.source.x(((com.google.android.exoplayer2.source.u0.b)localObject2).a, ((com.google.android.exoplayer2.source.u0.b)localObject2).b, paramLong), ((com.google.android.exoplayer2.source.u0.b)localObject2).c, this.d, ((com.google.android.exoplayer2.source.u0.b)localObject2).d, ((com.google.android.exoplayer2.source.u0.b)localObject2).e, ((com.google.android.exoplayer2.source.u0.b)localObject2).f, ((com.google.android.exoplayer2.source.u0.b)localObject2).g, ((com.google.android.exoplayer2.source.u0.b)localObject2).h);
      return true;
    }
    return false;
  }
  
  public int d0(int paramInt1, i1 parami1, DecoderInputBuffer paramDecoderInputBuffer, int paramInt2)
  {
    if (N()) {
      return -3;
    }
    boolean bool = this.J3.isEmpty();
    int i = 0;
    int j;
    Format localFormat;
    if (!bool)
    {
      for (j = 0; (j < this.J3.size() - 1) && (G((m)this.J3.get(j))); j++) {}
      com.google.android.exoplayer2.util.o0.B0(this.J3, 0, j);
      m localm = (m)this.J3.get(0);
      localFormat = localm.d;
      if (!localFormat.equals(this.c4)) {
        this.p3.c(this.d, localFormat, localm.e, localm.f, localm.g);
      }
      this.c4 = localFormat;
    }
    if ((!this.J3.isEmpty()) && (!((m)this.J3.get(0)).q())) {
      return -3;
    }
    paramInt2 = this.R3[paramInt1].M(parami1, paramDecoderInputBuffer, paramInt2, this.p4);
    if (paramInt2 == -5)
    {
      localFormat = (Format)com.google.android.exoplayer2.util.g.e(parami1.b);
      paramDecoderInputBuffer = localFormat;
      if (paramInt1 == this.X3)
      {
        j = this.R3[paramInt1].K();
        for (paramInt1 = i; (paramInt1 < this.J3.size()) && (((m)this.J3.get(paramInt1)).l != j); paramInt1++) {}
        if (paramInt1 < this.J3.size()) {
          paramDecoderInputBuffer = ((m)this.J3.get(paramInt1)).d;
        } else {
          paramDecoderInputBuffer = (Format)com.google.android.exoplayer2.util.g.e(this.b4);
        }
        paramDecoderInputBuffer = localFormat.e(paramDecoderInputBuffer);
      }
      parami1.b = paramDecoderInputBuffer;
    }
    return paramInt2;
  }
  
  public long e()
  {
    if (this.p4) {
      return Long.MIN_VALUE;
    }
    if (N()) {
      return this.m4;
    }
    long l1 = this.l4;
    Object localObject = I();
    if (!((m)localObject).p()) {
      if (this.J3.size() > 1)
      {
        localObject = this.J3;
        localObject = (m)((ArrayList)localObject).get(((ArrayList)localObject).size() - 2);
      }
      else
      {
        localObject = null;
      }
    }
    long l2 = l1;
    if (localObject != null) {
      l2 = Math.max(l1, ((com.google.android.exoplayer2.source.u0.b)localObject).h);
    }
    l1 = l2;
    if (this.Y3)
    {
      localObject = this.R3;
      int i = localObject.length;
      for (int j = 0;; j++)
      {
        l1 = l2;
        if (j >= i) {
          break;
        }
        l2 = Math.max(l2, localObject[j].t());
      }
    }
    return l1;
  }
  
  public void e0()
  {
    if (this.Z3)
    {
      d[] arrayOfd = this.R3;
      int i = arrayOfd.length;
      for (int j = 0; j < i; j++) {
        arrayOfd[j].L();
      }
    }
    this.p2.m(this);
    this.N3.removeCallbacksAndMessages(null);
    this.d4 = true;
    this.O3.clear();
  }
  
  public void f(long paramLong)
  {
    if ((!this.p2.h()) && (!N()))
    {
      if (this.p2.i())
      {
        com.google.android.exoplayer2.util.g.e(this.Q3);
        if (this.q.u(paramLong, this.Q3, this.K3)) {
          this.p2.e();
        }
        return;
      }
      for (int i = this.K3.size(); (i > 0) && (this.q.b((m)this.K3.get(i - 1)) == 2); i--) {}
      if (i < this.K3.size()) {
        E(i);
      }
      i = this.q.g(paramLong, this.K3);
      if (i < this.J3.size()) {
        E(i);
      }
    }
  }
  
  public void g(Format paramFormat)
  {
    this.N3.post(this.L3);
  }
  
  public boolean h0(long paramLong, boolean paramBoolean)
  {
    this.l4 = paramLong;
    if (N())
    {
      this.m4 = paramLong;
      return true;
    }
    boolean bool = this.Y3;
    int i = 0;
    if ((bool) && (!paramBoolean) && (g0(paramLong))) {
      return false;
    }
    this.m4 = paramLong;
    this.p4 = false;
    this.J3.clear();
    if (this.p2.i())
    {
      if (this.Y3)
      {
        d[] arrayOfd = this.R3;
        int j = arrayOfd.length;
        while (i < j)
        {
          arrayOfd[i].o();
          i++;
        }
      }
      this.p2.e();
    }
    else
    {
      this.p2.f();
      f0();
    }
    return true;
  }
  
  public boolean i0(com.google.android.exoplayer2.trackselection.g[] paramArrayOfg, boolean[] paramArrayOfBoolean1, n0[] paramArrayOfn0, boolean[] paramArrayOfBoolean2, long paramLong, boolean paramBoolean)
  {
    v();
    int i = this.a4;
    int j = 0;
    int k = 0;
    Object localObject;
    for (int m = 0; m < paramArrayOfg.length; m++)
    {
      localObject = (p)paramArrayOfn0[m];
      if ((localObject != null) && ((paramArrayOfg[m] == null) || (paramArrayOfBoolean1[m] == 0)))
      {
        this.a4 -= 1;
        ((p)localObject).f();
        paramArrayOfn0[m] = null;
      }
    }
    boolean bool1;
    if ((!paramBoolean) && (this.o4 ? i != 0 : paramLong == this.l4)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    com.google.android.exoplayer2.trackselection.g localg = this.q.j();
    paramArrayOfBoolean1 = localg;
    m = 0;
    boolean bool2;
    while (m < paramArrayOfg.length)
    {
      localObject = paramArrayOfg[m];
      if (localObject == null)
      {
        localObject = paramArrayOfBoolean1;
        bool2 = bool1;
      }
      else
      {
        i = this.e4.b(((j)localObject).m());
        if (i == this.h4)
        {
          this.q.t((com.google.android.exoplayer2.trackselection.g)localObject);
          paramArrayOfBoolean1 = (boolean[])localObject;
        }
        localObject = paramArrayOfBoolean1;
        bool2 = bool1;
        if (paramArrayOfn0[m] == null)
        {
          this.a4 += 1;
          paramArrayOfn0[m] = new p(this, i);
          paramArrayOfBoolean2[m] = true;
          localObject = paramArrayOfBoolean1;
          bool2 = bool1;
          if (this.g4 != null)
          {
            ((p)paramArrayOfn0[m]).d();
            localObject = paramArrayOfBoolean1;
            bool2 = bool1;
            if (!bool1)
            {
              localObject = this.R3[this.g4[i]];
              if ((!((m0)localObject).S(paramLong, true)) && (((m0)localObject).w() != 0)) {
                bool1 = true;
              } else {
                bool1 = false;
              }
              bool2 = bool1;
              localObject = paramArrayOfBoolean1;
            }
          }
        }
      }
      m++;
      paramArrayOfBoolean1 = (boolean[])localObject;
      bool1 = bool2;
    }
    if (this.a4 == 0)
    {
      this.q.q();
      this.c4 = null;
      this.n4 = true;
      this.J3.clear();
      if (this.p2.i())
      {
        if (this.Y3)
        {
          paramArrayOfg = this.R3;
          j = paramArrayOfg.length;
          for (m = k; m < j; m++) {
            paramArrayOfg[m].o();
          }
        }
        this.p2.e();
        bool2 = bool1;
      }
      else
      {
        f0();
        bool2 = bool1;
      }
    }
    else
    {
      if ((!this.J3.isEmpty()) && (!com.google.android.exoplayer2.util.o0.b(paramArrayOfBoolean1, localg)))
      {
        if (!this.o4)
        {
          long l = 0L;
          if (paramLong < 0L) {
            l = -paramLong;
          }
          paramArrayOfg = I();
          localObject = this.q.a(paramArrayOfg, paramLong);
          paramArrayOfBoolean1.q(paramLong, l, -9223372036854775807L, this.K3, (com.google.android.exoplayer2.source.u0.e[])localObject);
          m = this.q.i().b(paramArrayOfg.d);
          if (paramArrayOfBoolean1.r() == m)
          {
            m = 0;
            break label566;
          }
        }
        m = 1;
        label566:
        if (m != 0)
        {
          this.n4 = true;
          paramBoolean = true;
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        h0(paramLong, paramBoolean);
        for (m = j;; m++)
        {
          bool2 = bool1;
          if (m >= paramArrayOfn0.length) {
            break;
          }
          if (paramArrayOfn0[m] != null) {
            paramArrayOfBoolean2[m] = true;
          }
        }
      }
    }
    p0(paramArrayOfn0);
    this.o4 = true;
    return bool2;
  }
  
  public void j0(@Nullable DrmInitData paramDrmInitData)
  {
    if (!com.google.android.exoplayer2.util.o0.b(this.s4, paramDrmInitData))
    {
      this.s4 = paramDrmInitData;
      for (int i = 0;; i++)
      {
        d[] arrayOfd = this.R3;
        if (i >= arrayOfd.length) {
          break;
        }
        if (this.k4[i] != 0) {
          arrayOfd[i].b0(paramDrmInitData);
        }
      }
    }
  }
  
  public void l0(boolean paramBoolean)
  {
    this.q.s(paramBoolean);
  }
  
  public void m0(long paramLong)
  {
    if (this.r4 != paramLong)
    {
      this.r4 = paramLong;
      d[] arrayOfd = this.R3;
      int i = arrayOfd.length;
      for (int j = 0; j < i; j++) {
        arrayOfd[j].T(paramLong);
      }
    }
  }
  
  public int n0(int paramInt, long paramLong)
  {
    if (N()) {
      return 0;
    }
    d locald = this.R3[paramInt];
    int i = locald.y(paramLong, this.p4);
    m localm = (m)j1.g(this.J3, null);
    int j = i;
    if (localm != null)
    {
      j = i;
      if (!localm.q())
      {
        j = locald.w();
        j = Math.min(i, localm.l(paramInt) - j);
      }
    }
    locald.X(j);
    return j;
  }
  
  public void o(com.google.android.exoplayer2.o2.y paramy) {}
  
  public void o0(int paramInt)
  {
    v();
    com.google.android.exoplayer2.util.g.e(this.g4);
    paramInt = this.g4[paramInt];
    com.google.android.exoplayer2.util.g.g(this.j4[paramInt]);
    this.j4[paramInt] = false;
  }
  
  public void p()
  {
    d[] arrayOfd = this.R3;
    int i = arrayOfd.length;
    for (int j = 0; j < i; j++) {
      arrayOfd[j].N();
    }
  }
  
  public void q()
    throws IOException
  {
    T();
    if ((this.p4) && (!this.Z3)) {
      throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
    }
  }
  
  public void r()
  {
    this.q4 = true;
    this.N3.post(this.M3);
  }
  
  public TrackGroupArray s()
  {
    v();
    return this.e4;
  }
  
  public b0 t(int paramInt1, int paramInt2)
  {
    Object localObject1;
    if (c.contains(Integer.valueOf(paramInt2)))
    {
      localObject1 = J(paramInt1, paramInt2);
    }
    else
    {
      for (int i = 0;; i++)
      {
        localObject1 = this.R3;
        if (i >= localObject1.length) {
          break;
        }
        if (this.S3[i] == paramInt1)
        {
          localObject1 = localObject1[i];
          break label67;
        }
      }
      localObject1 = null;
    }
    label67:
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (this.q4) {
        return A(paramInt1, paramInt2);
      }
      localObject2 = B(paramInt1, paramInt2);
    }
    if (paramInt2 == 5)
    {
      if (this.V3 == null) {
        this.V3 = new c((b0)localObject2, this.H3);
      }
      return this.V3;
    }
    return (b0)localObject2;
  }
  
  public void u(long paramLong, boolean paramBoolean)
  {
    if ((this.Y3) && (!N()))
    {
      int i = this.R3.length;
      for (int j = 0; j < i; j++) {
        this.R3[j].n(paramLong, paramBoolean, this.j4[j]);
      }
    }
  }
  
  public int w(int paramInt)
  {
    v();
    com.google.android.exoplayer2.util.g.e(this.g4);
    int i = this.g4[paramInt];
    int j = -2;
    if (i == -1)
    {
      if (this.f4.contains(this.e4.a(paramInt))) {
        j = -3;
      }
      return j;
    }
    boolean[] arrayOfBoolean = this.j4;
    if (arrayOfBoolean[i] != 0) {
      return -2;
    }
    arrayOfBoolean[i] = true;
    return i;
  }
  
  public void z()
  {
    if (!this.Z3) {
      d(this.l4);
    }
  }
  
  public static abstract interface b
    extends o0.a<q>
  {
    public abstract void b();
    
    public abstract void o(Uri paramUri);
  }
  
  private static class c
    implements b0
  {
    private static final Format a = new Format.b().e0("application/id3").E();
    private static final Format b = new Format.b().e0("application/x-emsg").E();
    private final com.google.android.exoplayer2.metadata.emsg.a c = new com.google.android.exoplayer2.metadata.emsg.a();
    private final b0 d;
    private final Format e;
    private Format f;
    private byte[] g;
    private int h;
    
    public c(b0 paramb0, int paramInt)
    {
      this.d = paramb0;
      if (paramInt != 1)
      {
        if (paramInt == 3)
        {
          this.e = b;
        }
        else
        {
          paramb0 = new StringBuilder(33);
          paramb0.append("Unknown metadataType: ");
          paramb0.append(paramInt);
          throw new IllegalArgumentException(paramb0.toString());
        }
      }
      else {
        this.e = a;
      }
      this.g = new byte[0];
      this.h = 0;
    }
    
    private boolean g(EventMessage paramEventMessage)
    {
      paramEventMessage = paramEventMessage.g();
      boolean bool;
      if ((paramEventMessage != null) && (com.google.android.exoplayer2.util.o0.b(this.e.H3, paramEventMessage.H3))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    private void h(int paramInt)
    {
      byte[] arrayOfByte = this.g;
      if (arrayOfByte.length < paramInt) {
        this.g = Arrays.copyOf(arrayOfByte, paramInt + paramInt / 2);
      }
    }
    
    private d0 i(int paramInt1, int paramInt2)
    {
      int i = this.h - paramInt2;
      d0 locald0 = new d0(Arrays.copyOfRange(this.g, i - paramInt1, i));
      byte[] arrayOfByte = this.g;
      System.arraycopy(arrayOfByte, i, arrayOfByte, 0, paramInt2);
      this.h = paramInt2;
      return locald0;
    }
    
    public int a(com.google.android.exoplayer2.upstream.i parami, int paramInt1, boolean paramBoolean, int paramInt2)
      throws IOException
    {
      h(this.h + paramInt1);
      paramInt1 = parami.read(this.g, this.h, paramInt1);
      if (paramInt1 == -1)
      {
        if (paramBoolean) {
          return -1;
        }
        throw new EOFException();
      }
      this.h += paramInt1;
      return paramInt1;
    }
    
    public void d(Format paramFormat)
    {
      this.f = paramFormat;
      this.d.d(this.e);
    }
    
    public void e(long paramLong, int paramInt1, int paramInt2, int paramInt3, @Nullable b0.a parama)
    {
      com.google.android.exoplayer2.util.g.e(this.f);
      Object localObject = i(paramInt2, paramInt3);
      if (!com.google.android.exoplayer2.util.o0.b(this.f.H3, this.e.H3))
      {
        if ("application/x-emsg".equals(this.f.H3))
        {
          localObject = this.c.c((d0)localObject);
          if (!g((EventMessage)localObject))
          {
            u.h("EmsgUnwrappingTrackOutput", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", new Object[] { this.e.H3, ((EventMessage)localObject).g() }));
            return;
          }
          localObject = new d0((byte[])com.google.android.exoplayer2.util.g.e(((EventMessage)localObject).k()));
        }
      }
      else
      {
        paramInt2 = ((d0)localObject).a();
        this.d.c((d0)localObject, paramInt2);
        this.d.e(paramLong, paramInt1, paramInt2, paramInt3, parama);
        return;
      }
      parama = String.valueOf(this.f.H3);
      if (parama.length() != 0) {
        parama = "Ignoring sample for unsupported format: ".concat(parama);
      } else {
        parama = new String("Ignoring sample for unsupported format: ");
      }
      u.h("EmsgUnwrappingTrackOutput", parama);
    }
    
    public void f(d0 paramd0, int paramInt1, int paramInt2)
    {
      h(this.h + paramInt1);
      paramd0.j(this.g, this.h, paramInt1);
      this.h += paramInt1;
    }
  }
  
  private static final class d
    extends m0
  {
    private final Map<String, DrmInitData> I;
    @Nullable
    private DrmInitData J;
    
    private d(com.google.android.exoplayer2.upstream.e parame, Looper paramLooper, com.google.android.exoplayer2.drm.x paramx, v.a parama, Map<String, DrmInitData> paramMap)
    {
      super(paramLooper, paramx, parama);
      this.I = paramMap;
    }
    
    @Nullable
    private Metadata a0(@Nullable Metadata paramMetadata)
    {
      if (paramMetadata == null) {
        return null;
      }
      int i = paramMetadata.d();
      int j = 0;
      for (int k = 0; k < i; k++)
      {
        localObject = paramMetadata.c(k);
        if (((localObject instanceof PrivFrame)) && ("com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame)localObject).d)))
        {
          m = k;
          break label70;
        }
      }
      int m = -1;
      label70:
      if (m == -1) {
        return paramMetadata;
      }
      if (i == 1) {
        return null;
      }
      Object localObject = new Metadata.Entry[i - 1];
      for (k = j; k < i; k++) {
        if (k != m)
        {
          if (k < m) {
            j = k;
          } else {
            j = k - 1;
          }
          localObject[j] = paramMetadata.c(k);
        }
      }
      return new Metadata((Metadata.Entry[])localObject);
    }
    
    public void b0(@Nullable DrmInitData paramDrmInitData)
    {
      this.J = paramDrmInitData;
      C();
    }
    
    public void c0(m paramm)
    {
      Y(paramm.l);
    }
    
    public void e(long paramLong, int paramInt1, int paramInt2, int paramInt3, @Nullable b0.a parama)
    {
      super.e(paramLong, paramInt1, paramInt2, paramInt3, parama);
    }
    
    public Format s(Format paramFormat)
    {
      Object localObject1 = this.J;
      if (localObject1 == null) {
        localObject1 = paramFormat.K3;
      }
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject3 = (DrmInitData)this.I.get(((DrmInitData)localObject1).f);
        localObject2 = localObject1;
        if (localObject3 != null) {
          localObject2 = localObject3;
        }
      }
      Object localObject3 = a0(paramFormat.p2);
      if (localObject2 == paramFormat.K3)
      {
        localObject1 = paramFormat;
        if (localObject3 == paramFormat.p2) {}
      }
      else
      {
        localObject1 = paramFormat.a().L((DrmInitData)localObject2).X((Metadata)localObject3).E();
      }
      return super.s((Format)localObject1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */