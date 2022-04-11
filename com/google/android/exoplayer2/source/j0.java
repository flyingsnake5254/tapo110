package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.v.a;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.o2.y.a;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.b;
import com.google.android.exoplayer2.upstream.Loader.c;
import com.google.android.exoplayer2.upstream.Loader.e;
import com.google.android.exoplayer2.upstream.Loader.f;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.n.b;
import com.google.android.exoplayer2.upstream.x.c;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class j0
  implements b0, com.google.android.exoplayer2.o2.l, Loader.b<a>, Loader.f, m0.d
{
  private static final Map<String, String> c = ;
  private static final Format d = new Format.b().S("icy").e0("application/x-icy").E();
  private final long H3;
  private final Loader I3;
  private final i0 J3;
  private final k K3;
  private final Runnable L3;
  private final Runnable M3;
  private final Handler N3;
  @Nullable
  private b0.a O3;
  @Nullable
  private IcyHeaders P3;
  private m0[] Q3;
  private d[] R3;
  private boolean S3;
  private boolean T3;
  private boolean U3;
  private e V3;
  private com.google.android.exoplayer2.o2.y W3;
  private long X3;
  private boolean Y3;
  private int Z3;
  private boolean a4;
  private boolean b4;
  private int c4;
  private long d4;
  private long e4;
  private final Uri f;
  private long f4;
  private boolean g4;
  private int h4;
  private boolean i4;
  private boolean j4;
  private final v.a p0;
  private final b p1;
  private final e p2;
  @Nullable
  private final String p3;
  private final com.google.android.exoplayer2.upstream.l q;
  private final com.google.android.exoplayer2.drm.x x;
  private final com.google.android.exoplayer2.upstream.x y;
  private final f0.a z;
  
  public j0(Uri paramUri, com.google.android.exoplayer2.upstream.l paraml, i0 parami0, com.google.android.exoplayer2.drm.x paramx, v.a parama, com.google.android.exoplayer2.upstream.x paramx1, f0.a parama1, b paramb, e parame, @Nullable String paramString, int paramInt)
  {
    this.f = paramUri;
    this.q = paraml;
    this.x = paramx;
    this.p0 = parama;
    this.y = paramx1;
    this.z = parama1;
    this.p1 = paramb;
    this.p2 = parame;
    this.p3 = paramString;
    this.H3 = paramInt;
    this.I3 = new Loader("ProgressiveMediaPeriod");
    this.J3 = parami0;
    this.K3 = new k();
    this.L3 = new h(this);
    this.M3 = new j(this);
    this.N3 = o0.v();
    this.R3 = new d[0];
    this.Q3 = new m0[0];
    this.f4 = -9223372036854775807L;
    this.d4 = -1L;
    this.X3 = -9223372036854775807L;
    this.Z3 = 1;
  }
  
  @EnsuresNonNull({"trackState", "seekMap"})
  private void E()
  {
    com.google.android.exoplayer2.util.g.g(this.T3);
    com.google.android.exoplayer2.util.g.e(this.V3);
    com.google.android.exoplayer2.util.g.e(this.W3);
  }
  
  private boolean F(a parama, int paramInt)
  {
    if (this.d4 == -1L)
    {
      Object localObject = this.W3;
      if ((localObject == null) || (((com.google.android.exoplayer2.o2.y)localObject).i() == -9223372036854775807L))
      {
        boolean bool = this.T3;
        paramInt = 0;
        if ((bool) && (!h0()))
        {
          this.g4 = true;
          return false;
        }
        this.b4 = this.T3;
        this.e4 = 0L;
        this.h4 = 0;
        localObject = this.Q3;
        int i = localObject.length;
        while (paramInt < i)
        {
          localObject[paramInt].P();
          paramInt++;
        }
        a.i(parama, 0L, 0L);
        return true;
      }
    }
    this.h4 = paramInt;
    return true;
  }
  
  private void G(a parama)
  {
    if (this.d4 == -1L) {
      this.d4 = a.h(parama);
    }
  }
  
  private static Map<String, String> H()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Icy-MetaData", "1");
    return Collections.unmodifiableMap(localHashMap);
  }
  
  private int I()
  {
    m0[] arrayOfm0 = this.Q3;
    int i = arrayOfm0.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += arrayOfm0[j].A();
      j++;
    }
    return k;
  }
  
  private long J()
  {
    m0[] arrayOfm0 = this.Q3;
    int i = arrayOfm0.length;
    long l = Long.MIN_VALUE;
    for (int j = 0; j < i; j++) {
      l = Math.max(l, arrayOfm0[j].t());
    }
    return l;
  }
  
  private boolean L()
  {
    boolean bool;
    if (this.f4 != -9223372036854775807L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void S()
  {
    if ((!this.j4) && (!this.T3) && (this.S3) && (this.W3 != null))
    {
      Object localObject = this.Q3;
      int i = localObject.length;
      for (int j = 0; j < i; j++) {
        if (localObject[j].z() == null) {
          return;
        }
      }
      this.K3.c();
      i = this.Q3.length;
      TrackGroup[] arrayOfTrackGroup = new TrackGroup[i];
      boolean[] arrayOfBoolean = new boolean[i];
      for (j = 0; j < i; j++)
      {
        Format localFormat1 = (Format)com.google.android.exoplayer2.util.g.e(this.Q3[j].z());
        localObject = localFormat1.H3;
        boolean bool = com.google.android.exoplayer2.util.y.o((String)localObject);
        int k;
        if ((!bool) && (!com.google.android.exoplayer2.util.y.q((String)localObject))) {
          k = 0;
        } else {
          k = 1;
        }
        arrayOfBoolean[j] = k;
        this.U3 = (k | this.U3);
        IcyHeaders localIcyHeaders = this.P3;
        localObject = localFormat1;
        if (localIcyHeaders != null)
        {
          Format localFormat2;
          if (!bool)
          {
            localFormat2 = localFormat1;
            if (!this.R3[j].b) {}
          }
          else
          {
            localObject = localFormat1.p2;
            if (localObject == null) {
              localObject = new Metadata(new Metadata.Entry[] { localIcyHeaders });
            } else {
              localObject = ((Metadata)localObject).a(new Metadata.Entry[] { localIcyHeaders });
            }
            localFormat2 = localFormat1.a().X((Metadata)localObject).E();
          }
          localObject = localFormat2;
          if (bool)
          {
            localObject = localFormat2;
            if (localFormat2.y == -1)
            {
              localObject = localFormat2;
              if (localFormat2.z == -1)
              {
                localObject = localFormat2;
                if (localIcyHeaders.c != -1) {
                  localObject = localFormat2.a().G(localIcyHeaders.c).E();
                }
              }
            }
          }
        }
        arrayOfTrackGroup[j] = new TrackGroup(new Format[] { ((Format)localObject).b(this.x.c((Format)localObject)) });
      }
      this.V3 = new e(new TrackGroupArray(arrayOfTrackGroup), arrayOfBoolean);
      this.T3 = true;
      ((b0.a)com.google.android.exoplayer2.util.g.e(this.O3)).p(this);
    }
  }
  
  private void T(int paramInt)
  {
    E();
    Object localObject = this.V3;
    boolean[] arrayOfBoolean = ((e)localObject).d;
    if (arrayOfBoolean[paramInt] == 0)
    {
      localObject = ((e)localObject).a.a(paramInt).a(0);
      this.z.c(com.google.android.exoplayer2.util.y.k(((Format)localObject).H3), (Format)localObject, 0, null, this.e4);
      arrayOfBoolean[paramInt] = true;
    }
  }
  
  private void U(int paramInt)
  {
    E();
    Object localObject = this.V3.b;
    if ((this.g4) && (localObject[paramInt] != 0))
    {
      localObject = this.Q3[paramInt];
      paramInt = 0;
      if (!((m0)localObject).E(false))
      {
        this.f4 = 0L;
        this.g4 = false;
        this.b4 = true;
        this.e4 = 0L;
        this.h4 = 0;
        localObject = this.Q3;
        int i = localObject.length;
        while (paramInt < i)
        {
          localObject[paramInt].P();
          paramInt++;
        }
        ((b0.a)com.google.android.exoplayer2.util.g.e(this.O3)).n(this);
      }
    }
  }
  
  private com.google.android.exoplayer2.o2.b0 a0(d paramd)
  {
    int i = this.Q3.length;
    for (int j = 0; j < i; j++) {
      if (paramd.equals(this.R3[j])) {
        return this.Q3[j];
      }
    }
    m0 localm0 = m0.j(this.p2, this.N3.getLooper(), this.x, this.p0);
    localm0.W(this);
    d[] arrayOfd = this.R3;
    j = i + 1;
    arrayOfd = (d[])Arrays.copyOf(arrayOfd, j);
    arrayOfd[i] = paramd;
    this.R3 = ((d[])o0.j(arrayOfd));
    paramd = (m0[])Arrays.copyOf(this.Q3, j);
    paramd[i] = localm0;
    this.Q3 = ((m0[])o0.j(paramd));
    return localm0;
  }
  
  private boolean d0(boolean[] paramArrayOfBoolean, long paramLong)
  {
    int i = this.Q3.length;
    for (int j = 0; j < i; j++) {
      if ((!this.Q3[j].S(paramLong, false)) && ((paramArrayOfBoolean[j] != 0) || (!this.U3))) {
        return false;
      }
    }
    return true;
  }
  
  private void e0(com.google.android.exoplayer2.o2.y paramy)
  {
    Object localObject;
    if (this.P3 == null) {
      localObject = paramy;
    } else {
      localObject = new y.b(-9223372036854775807L);
    }
    this.W3 = ((com.google.android.exoplayer2.o2.y)localObject);
    this.X3 = paramy.i();
    long l = this.d4;
    int i = 1;
    boolean bool;
    if ((l == -1L) && (paramy.i() == -9223372036854775807L)) {
      bool = true;
    } else {
      bool = false;
    }
    this.Y3 = bool;
    if (bool) {
      i = 7;
    }
    this.Z3 = i;
    this.p1.k(this.X3, paramy.g(), this.Y3);
    if (!this.T3) {
      S();
    }
  }
  
  private void g0()
  {
    a locala = new a(this.f, this.q, this.J3, this, this.K3);
    if (this.T3)
    {
      com.google.android.exoplayer2.util.g.g(L());
      l = this.X3;
      if ((l != -9223372036854775807L) && (this.f4 > l))
      {
        this.i4 = true;
        this.f4 = -9223372036854775807L;
        return;
      }
      a.i(locala, ((com.google.android.exoplayer2.o2.y)com.google.android.exoplayer2.util.g.e(this.W3)).a(this.f4).a.c, this.f4);
      localObject = this.Q3;
      int i = localObject.length;
      for (int j = 0; j < i; j++) {
        localObject[j].U(this.f4);
      }
      this.f4 = -9223372036854775807L;
    }
    this.h4 = I();
    long l = this.I3.n(locala, this, this.y.b(this.Z3));
    Object localObject = a.f(locala);
    this.z.A(new x(a.e(locala), (n)localObject, l), 1, -1, null, 0, null, a.g(locala), this.X3);
  }
  
  private boolean h0()
  {
    boolean bool;
    if ((!this.b4) && (!L())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  com.google.android.exoplayer2.o2.b0 K()
  {
    return a0(new d(0, true));
  }
  
  boolean M(int paramInt)
  {
    boolean bool;
    if ((!h0()) && (this.Q3[paramInt].E(this.i4))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void V()
    throws IOException
  {
    this.I3.k(this.y.b(this.Z3));
  }
  
  void W(int paramInt)
    throws IOException
  {
    this.Q3[paramInt].H();
    V();
  }
  
  public void X(a parama, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject = a.d(parama);
    localObject = new x(a.e(parama), a.f(parama), ((com.google.android.exoplayer2.upstream.z)localObject).p(), ((com.google.android.exoplayer2.upstream.z)localObject).q(), paramLong1, paramLong2, ((com.google.android.exoplayer2.upstream.z)localObject).o());
    this.y.d(a.e(parama));
    this.z.r((x)localObject, 1, -1, null, 0, null, a.g(parama), this.X3);
    if (!paramBoolean)
    {
      G(parama);
      parama = this.Q3;
      int i = parama.length;
      for (int j = 0; j < i; j++) {
        parama[j].P();
      }
      if (this.c4 > 0) {
        ((b0.a)com.google.android.exoplayer2.util.g.e(this.O3)).n(this);
      }
    }
  }
  
  public void Y(a parama, long paramLong1, long paramLong2)
  {
    if (this.X3 == -9223372036854775807L)
    {
      localObject = this.W3;
      if (localObject != null)
      {
        boolean bool = ((com.google.android.exoplayer2.o2.y)localObject).g();
        long l = J();
        if (l == Long.MIN_VALUE) {
          l = 0L;
        } else {
          l += 10000L;
        }
        this.X3 = l;
        this.p1.k(l, bool, this.Y3);
      }
    }
    Object localObject = a.d(parama);
    localObject = new x(a.e(parama), a.f(parama), ((com.google.android.exoplayer2.upstream.z)localObject).p(), ((com.google.android.exoplayer2.upstream.z)localObject).q(), paramLong1, paramLong2, ((com.google.android.exoplayer2.upstream.z)localObject).o());
    this.y.d(a.e(parama));
    this.z.u((x)localObject, 1, -1, null, 0, null, a.g(parama), this.X3);
    G(parama);
    this.i4 = true;
    ((b0.a)com.google.android.exoplayer2.util.g.e(this.O3)).n(this);
  }
  
  public Loader.c Z(a parama, long paramLong1, long paramLong2, IOException paramIOException, int paramInt)
  {
    G(parama);
    Object localObject = a.d(parama);
    x localx = new x(a.e(parama), a.f(parama), ((com.google.android.exoplayer2.upstream.z)localObject).p(), ((com.google.android.exoplayer2.upstream.z)localObject).q(), paramLong1, paramLong2, ((com.google.android.exoplayer2.upstream.z)localObject).o());
    localObject = new a0(1, -1, null, 0, null, w0.e(a.g(parama)), w0.e(this.X3));
    paramLong1 = this.y.a(new x.c(localx, (a0)localObject, paramIOException, paramInt));
    if (paramLong1 == -9223372036854775807L)
    {
      localObject = Loader.d;
    }
    else
    {
      paramInt = I();
      if (paramInt > this.h4) {
        bool = true;
      } else {
        bool = false;
      }
      if (F(parama, paramInt)) {
        localObject = Loader.g(bool, paramLong1);
      } else {
        localObject = Loader.c;
      }
    }
    boolean bool = ((Loader.c)localObject).c() ^ true;
    this.z.w(localx, 1, -1, null, 0, null, a.g(parama), this.X3, paramIOException, bool);
    if (bool) {
      this.y.d(a.e(parama));
    }
    return (Loader.c)localObject;
  }
  
  public long a()
  {
    long l;
    if (this.c4 == 0) {
      l = Long.MIN_VALUE;
    } else {
      l = e();
    }
    return l;
  }
  
  int b0(int paramInt1, i1 parami1, DecoderInputBuffer paramDecoderInputBuffer, int paramInt2)
  {
    if (h0()) {
      return -3;
    }
    T(paramInt1);
    paramInt2 = this.Q3[paramInt1].M(parami1, paramDecoderInputBuffer, paramInt2, this.i4);
    if (paramInt2 == -3) {
      U(paramInt1);
    }
    return paramInt2;
  }
  
  public boolean c()
  {
    boolean bool;
    if ((this.I3.i()) && (this.K3.d())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void c0()
  {
    if (this.T3)
    {
      m0[] arrayOfm0 = this.Q3;
      int i = arrayOfm0.length;
      for (int j = 0; j < i; j++) {
        arrayOfm0[j].L();
      }
    }
    this.I3.m(this);
    this.N3.removeCallbacksAndMessages(null);
    this.O3 = null;
    this.j4 = true;
  }
  
  public boolean d(long paramLong)
  {
    if ((!this.i4) && (!this.I3.h()) && (!this.g4) && ((!this.T3) || (this.c4 != 0)))
    {
      boolean bool = this.K3.e();
      if (!this.I3.i())
      {
        g0();
        bool = true;
      }
      return bool;
    }
    return false;
  }
  
  public long e()
  {
    E();
    boolean[] arrayOfBoolean = this.V3.b;
    if (this.i4) {
      return Long.MIN_VALUE;
    }
    if (L()) {
      return this.f4;
    }
    if (this.U3)
    {
      int i = this.Q3.length;
      int j = 0;
      for (l1 = Long.MAX_VALUE;; l1 = l2)
      {
        l2 = l1;
        if (j >= i) {
          break;
        }
        l2 = l1;
        if (arrayOfBoolean[j] != 0)
        {
          l2 = l1;
          if (!this.Q3[j].D()) {
            l2 = Math.min(l1, this.Q3[j].t());
          }
        }
        j++;
      }
    }
    long l2 = Long.MAX_VALUE;
    long l1 = l2;
    if (l2 == Long.MAX_VALUE) {
      l1 = J();
    }
    l2 = l1;
    if (l1 == Long.MIN_VALUE) {
      l2 = this.e4;
    }
    return l2;
  }
  
  public void f(long paramLong) {}
  
  int f0(int paramInt, long paramLong)
  {
    if (h0()) {
      return 0;
    }
    T(paramInt);
    m0 localm0 = this.Q3[paramInt];
    int i = localm0.y(paramLong, this.i4);
    localm0.X(i);
    if (i == 0) {
      U(paramInt);
    }
    return i;
  }
  
  public void g(Format paramFormat)
  {
    this.N3.post(this.L3);
  }
  
  public long i(long paramLong)
  {
    E();
    Object localObject = this.V3.b;
    if (!this.W3.g()) {
      paramLong = 0L;
    }
    int i = 0;
    int j = 0;
    this.b4 = false;
    this.e4 = paramLong;
    if (L())
    {
      this.f4 = paramLong;
      return paramLong;
    }
    if ((this.Z3 != 7) && (d0((boolean[])localObject, paramLong))) {
      return paramLong;
    }
    this.g4 = false;
    this.f4 = paramLong;
    this.i4 = false;
    if (this.I3.i())
    {
      localObject = this.Q3;
      i = localObject.length;
      while (j < i)
      {
        localObject[j].o();
        j++;
      }
      this.I3.e();
    }
    else
    {
      this.I3.f();
      localObject = this.Q3;
      int k = localObject.length;
      for (j = i; j < k; j++) {
        localObject[j].P();
      }
    }
    return paramLong;
  }
  
  public long j(long paramLong, g2 paramg2)
  {
    E();
    if (!this.W3.g()) {
      return 0L;
    }
    y.a locala = this.W3.a(paramLong);
    return paramg2.a(paramLong, locala.a.b, locala.b.b);
  }
  
  public long k()
  {
    if ((this.b4) && ((this.i4) || (I() > this.h4)))
    {
      this.b4 = false;
      return this.e4;
    }
    return -9223372036854775807L;
  }
  
  public void l(b0.a parama, long paramLong)
  {
    this.O3 = parama;
    this.K3.e();
    g0();
  }
  
  public long m(com.google.android.exoplayer2.trackselection.g[] paramArrayOfg, boolean[] paramArrayOfBoolean1, n0[] paramArrayOfn0, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    E();
    Object localObject = this.V3;
    TrackGroupArray localTrackGroupArray = ((e)localObject).a;
    localObject = ((e)localObject).c;
    int i = this.c4;
    int j = 0;
    int k = 0;
    int m = 0;
    for (int n = 0; n < paramArrayOfg.length; n++) {
      if ((paramArrayOfn0[n] != null) && ((paramArrayOfg[n] == null) || (paramArrayOfBoolean1[n] == 0)))
      {
        i1 = c.d((c)paramArrayOfn0[n]);
        com.google.android.exoplayer2.util.g.g(localObject[i1]);
        this.c4 -= 1;
        localObject[i1] = 0;
        paramArrayOfn0[n] = null;
      }
    }
    if (this.a4 ? i == 0 : paramLong != 0L) {
      n = 1;
    } else {
      n = 0;
    }
    i = 0;
    for (int i1 = n; i < paramArrayOfg.length; i1 = n)
    {
      n = i1;
      if (paramArrayOfn0[i] == null)
      {
        n = i1;
        if (paramArrayOfg[i] != null)
        {
          paramArrayOfBoolean1 = paramArrayOfg[i];
          boolean bool;
          if (paramArrayOfBoolean1.length() == 1) {
            bool = true;
          } else {
            bool = false;
          }
          com.google.android.exoplayer2.util.g.g(bool);
          if (paramArrayOfBoolean1.h(0) == 0) {
            bool = true;
          } else {
            bool = false;
          }
          com.google.android.exoplayer2.util.g.g(bool);
          int i2 = localTrackGroupArray.b(paramArrayOfBoolean1.m());
          com.google.android.exoplayer2.util.g.g(localObject[i2] ^ 0x1);
          this.c4 += 1;
          localObject[i2] = 1;
          paramArrayOfn0[i] = new c(i2);
          paramArrayOfBoolean2[i] = true;
          n = i1;
          if (i1 == 0)
          {
            paramArrayOfBoolean1 = this.Q3[i2];
            if ((!paramArrayOfBoolean1.S(paramLong, true)) && (paramArrayOfBoolean1.w() != 0)) {
              n = 1;
            } else {
              n = 0;
            }
          }
        }
      }
      i++;
    }
    long l;
    if (this.c4 == 0)
    {
      this.g4 = false;
      this.b4 = false;
      if (this.I3.i())
      {
        paramArrayOfg = this.Q3;
        i = paramArrayOfg.length;
        for (n = m; n < i; n++) {
          paramArrayOfg[n].o();
        }
        this.I3.e();
        l = paramLong;
      }
      else
      {
        paramArrayOfg = this.Q3;
        i = paramArrayOfg.length;
        for (n = j;; n++)
        {
          l = paramLong;
          if (n >= i) {
            break;
          }
          paramArrayOfg[n].P();
        }
      }
    }
    else
    {
      l = paramLong;
      if (i1 != 0)
      {
        paramLong = i(paramLong);
        for (n = k;; n++)
        {
          l = paramLong;
          if (n >= paramArrayOfn0.length) {
            break;
          }
          if (paramArrayOfn0[n] != null) {
            paramArrayOfBoolean2[n] = true;
          }
        }
      }
    }
    this.a4 = true;
    return l;
  }
  
  public void o(com.google.android.exoplayer2.o2.y paramy)
  {
    this.N3.post(new i(this, paramy));
  }
  
  public void p()
  {
    m0[] arrayOfm0 = this.Q3;
    int i = arrayOfm0.length;
    for (int j = 0; j < i; j++) {
      arrayOfm0[j].N();
    }
    this.J3.release();
  }
  
  public void q()
    throws IOException
  {
    V();
    if ((this.i4) && (!this.T3)) {
      throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
    }
  }
  
  public void r()
  {
    this.S3 = true;
    this.N3.post(this.L3);
  }
  
  public TrackGroupArray s()
  {
    E();
    return this.V3.a;
  }
  
  public com.google.android.exoplayer2.o2.b0 t(int paramInt1, int paramInt2)
  {
    return a0(new d(paramInt1, false));
  }
  
  public void u(long paramLong, boolean paramBoolean)
  {
    E();
    if (L()) {
      return;
    }
    boolean[] arrayOfBoolean = this.V3.c;
    int i = this.Q3.length;
    for (int j = 0; j < i; j++) {
      this.Q3[j].n(paramLong, paramBoolean, arrayOfBoolean[j]);
    }
  }
  
  final class a
    implements Loader.e, w.a
  {
    private final long a;
    private final Uri b;
    private final com.google.android.exoplayer2.upstream.z c;
    private final i0 d;
    private final com.google.android.exoplayer2.o2.l e;
    private final k f;
    private final com.google.android.exoplayer2.o2.x g;
    private volatile boolean h;
    private boolean i;
    private long j;
    private n k;
    private long l;
    @Nullable
    private com.google.android.exoplayer2.o2.b0 m;
    private boolean n;
    
    public a(Uri paramUri, com.google.android.exoplayer2.upstream.l paraml, i0 parami0, com.google.android.exoplayer2.o2.l paraml1, k paramk)
    {
      this.b = paramUri;
      this.c = new com.google.android.exoplayer2.upstream.z(paraml);
      this.d = parami0;
      this.e = paraml1;
      this.f = paramk;
      this.g = new com.google.android.exoplayer2.o2.x();
      this.i = true;
      this.l = -1L;
      this.a = x.a();
      this.k = j(0L);
    }
    
    private n j(long paramLong)
    {
      return new n.b().i(this.b).h(paramLong).f(j0.z(j0.this)).b(6).e(j0.y()).a();
    }
    
    private void k(long paramLong1, long paramLong2)
    {
      this.g.a = paramLong1;
      this.j = paramLong2;
      this.i = true;
      this.n = false;
    }
    
    public void a()
      throws IOException
    {
      int i1 = 0;
      while ((i1 == 0) && (!this.h))
      {
        int i2 = i1;
        try
        {
          long l1 = this.g.a;
          i2 = i1;
          Object localObject1 = j(l1);
          i2 = i1;
          this.k = ((n)localObject1);
          i2 = i1;
          long l2 = this.c.j((n)localObject1);
          i2 = i1;
          this.l = l2;
          if (l2 != -1L)
          {
            i2 = i1;
            this.l = (l2 + l1);
          }
          i2 = i1;
          j0.B(j0.this, IcyHeaders.a(this.c.d()));
          i2 = i1;
          Object localObject3 = this.c;
          localObject1 = localObject3;
          i2 = i1;
          if (j0.A(j0.this) != null)
          {
            localObject1 = localObject3;
            i2 = i1;
            if (j0.A(j0.this).y != -1)
            {
              i2 = i1;
              localObject1 = new com/google/android/exoplayer2/source/w;
              i2 = i1;
              ((w)localObject1).<init>(this.c, j0.A(j0.this).y, this);
              i2 = i1;
              localObject3 = j0.this.K();
              i2 = i1;
              this.m = ((com.google.android.exoplayer2.o2.b0)localObject3);
              i2 = i1;
              ((com.google.android.exoplayer2.o2.b0)localObject3).d(j0.C());
            }
          }
          i2 = i1;
          i0 locali0 = this.d;
          i2 = i1;
          Uri localUri = this.b;
          i2 = i1;
          Map localMap = this.c.d();
          i2 = i1;
          long l3 = this.l;
          i2 = i1;
          localObject3 = this.e;
          l2 = l1;
          i2 = i1;
          locali0.d((com.google.android.exoplayer2.upstream.i)localObject1, localUri, localMap, l1, l3, (com.google.android.exoplayer2.o2.l)localObject3);
          i2 = i1;
          if (j0.A(j0.this) != null)
          {
            i2 = i1;
            this.d.b();
          }
          int i3 = i1;
          l1 = l2;
          i2 = i1;
          if (this.i)
          {
            i2 = i1;
            this.d.c(l2, this.j);
            i2 = i1;
            this.i = false;
            l1 = l2;
            i3 = i1;
          }
          for (;;)
          {
            l2 = l1;
            i1 = i3;
            label344:
            if (i1 == 0)
            {
              i2 = i1;
              boolean bool = this.h;
              if (!bool)
              {
                i2 = i1;
                try
                {
                  this.f.a();
                  i2 = i1;
                  i3 = this.d.a(this.g);
                  i2 = i3;
                  l1 = this.d.e();
                  i1 = i3;
                  i2 = i3;
                  if (l1 <= j0.D(j0.this) + l2) {
                    break label344;
                  }
                  i2 = i3;
                  this.f.c();
                  i2 = i3;
                  j0.w(j0.this).post(j0.v(j0.this));
                }
                catch (InterruptedException localInterruptedException)
                {
                  i2 = i1;
                  InterruptedIOException localInterruptedIOException = new java/io/InterruptedIOException;
                  i2 = i1;
                  localInterruptedIOException.<init>();
                  i2 = i1;
                  throw localInterruptedIOException;
                }
              }
            }
          }
          if (i1 == 1)
          {
            i2 = 0;
          }
          else
          {
            i2 = i1;
            if (this.d.e() != -1L)
            {
              this.g.a = this.d.e();
              i2 = i1;
            }
          }
          o0.l(this.c);
          i1 = i2;
        }
        finally
        {
          if ((i2 != 1) && (this.d.e() != -1L)) {
            this.g.a = this.d.e();
          }
          o0.l(this.c);
        }
      }
    }
    
    public void b(d0 paramd0)
    {
      long l1;
      if (!this.n) {
        l1 = this.j;
      } else {
        l1 = Math.max(j0.x(j0.this), this.j);
      }
      int i1 = paramd0.a();
      com.google.android.exoplayer2.o2.b0 localb0 = (com.google.android.exoplayer2.o2.b0)com.google.android.exoplayer2.util.g.e(this.m);
      localb0.c(paramd0, i1);
      localb0.e(l1, 1, i1, 0, null);
      this.n = true;
    }
    
    public void c()
    {
      this.h = true;
    }
  }
  
  static abstract interface b
  {
    public abstract void k(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  }
  
  private final class c
    implements n0
  {
    private final int a;
    
    public c(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void a()
      throws IOException
    {
      j0.this.W(this.a);
    }
    
    public int b(i1 parami1, DecoderInputBuffer paramDecoderInputBuffer, int paramInt)
    {
      return j0.this.b0(this.a, parami1, paramDecoderInputBuffer, paramInt);
    }
    
    public int c(long paramLong)
    {
      return j0.this.f0(this.a, paramLong);
    }
    
    public boolean g()
    {
      return j0.this.M(this.a);
    }
  }
  
  private static final class d
  {
    public final int a;
    public final boolean b;
    
    public d(int paramInt, boolean paramBoolean)
    {
      this.a = paramInt;
      this.b = paramBoolean;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (d.class == paramObject.getClass()))
      {
        paramObject = (d)paramObject;
        if ((this.a != ((d)paramObject).a) || (this.b != ((d)paramObject).b)) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a * 31 + this.b;
    }
  }
  
  private static final class e
  {
    public final TrackGroupArray a;
    public final boolean[] b;
    public final boolean[] c;
    public final boolean[] d;
    
    public e(TrackGroupArray paramTrackGroupArray, boolean[] paramArrayOfBoolean)
    {
      this.a = paramTrackGroupArray;
      this.b = paramArrayOfBoolean;
      int i = paramTrackGroupArray.d;
      this.c = new boolean[i];
      this.d = new boolean[i];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\j0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */