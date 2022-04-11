package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.f0.a;
import com.google.android.exoplayer2.source.hls.j;
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.b;
import com.google.android.exoplayer2.upstream.Loader.c;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.x.a;
import com.google.android.exoplayer2.upstream.x.b;
import com.google.android.exoplayer2.upstream.x.c;
import com.google.android.exoplayer2.upstream.y;
import com.google.android.exoplayer2.upstream.y.a;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.j1;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class d
  implements HlsPlaylistTracker, Loader.b<y<h>>
{
  public static final HlsPlaylistTracker.a c = b.a;
  @Nullable
  private f H3;
  @Nullable
  private Uri I3;
  @Nullable
  private g J3;
  private boolean K3;
  private long L3;
  private final j d;
  private final i f;
  @Nullable
  private f0.a p0;
  @Nullable
  private Loader p1;
  @Nullable
  private Handler p2;
  @Nullable
  private HlsPlaylistTracker.c p3;
  private final com.google.android.exoplayer2.upstream.x q;
  private final HashMap<Uri, c> x;
  private final CopyOnWriteArrayList<HlsPlaylistTracker.b> y;
  private final double z;
  
  public d(j paramj, com.google.android.exoplayer2.upstream.x paramx, i parami)
  {
    this(paramj, paramx, parami, 3.5D);
  }
  
  public d(j paramj, com.google.android.exoplayer2.upstream.x paramx, i parami, double paramDouble)
  {
    this.d = paramj;
    this.f = parami;
    this.q = paramx;
    this.z = paramDouble;
    this.y = new CopyOnWriteArrayList();
    this.x = new HashMap();
    this.L3 = -9223372036854775807L;
  }
  
  private void E(List<Uri> paramList)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++)
    {
      Uri localUri = (Uri)paramList.get(j);
      c localc = new c(localUri);
      this.x.put(localUri, localc);
    }
  }
  
  private static g.d F(g paramg1, g paramg2)
  {
    int i = (int)(paramg2.k - paramg1.k);
    paramg1 = paramg1.r;
    if (i < paramg1.size()) {
      paramg1 = (g.d)paramg1.get(i);
    } else {
      paramg1 = null;
    }
    return paramg1;
  }
  
  private g G(@Nullable g paramg1, g paramg2)
  {
    if (!paramg2.f(paramg1))
    {
      g localg = paramg1;
      if (paramg2.o) {
        localg = paramg1.d();
      }
      return localg;
    }
    return paramg2.c(I(paramg1, paramg2), H(paramg1, paramg2));
  }
  
  private int H(@Nullable g paramg1, g paramg2)
  {
    if (paramg2.i) {
      return paramg2.j;
    }
    Object localObject = this.J3;
    int i;
    if (localObject != null) {
      i = ((g)localObject).j;
    } else {
      i = 0;
    }
    if (paramg1 == null) {
      return i;
    }
    localObject = F(paramg1, paramg2);
    if (localObject != null) {
      return paramg1.j + ((g.e)localObject).q - ((g.d)paramg2.r.get(0)).q;
    }
    return i;
  }
  
  private long I(@Nullable g paramg1, g paramg2)
  {
    if (paramg2.p) {
      return paramg2.h;
    }
    Object localObject = this.J3;
    long l;
    if (localObject != null) {
      l = ((g)localObject).h;
    } else {
      l = 0L;
    }
    if (paramg1 == null) {
      return l;
    }
    int i = paramg1.r.size();
    localObject = F(paramg1, paramg2);
    if (localObject != null) {
      return paramg1.h + ((g.e)localObject).x;
    }
    if (i == paramg2.k - paramg1.k) {
      return paramg1.e();
    }
    return l;
  }
  
  private Uri J(Uri paramUri)
  {
    Object localObject = this.J3;
    Uri localUri = paramUri;
    if (localObject != null)
    {
      localUri = paramUri;
      if (((g)localObject).v.e)
      {
        localObject = (g.c)((g)localObject).t.get(paramUri);
        localUri = paramUri;
        if (localObject != null)
        {
          paramUri = paramUri.buildUpon();
          paramUri.appendQueryParameter("_HLS_msn", String.valueOf(((g.c)localObject).b));
          int i = ((g.c)localObject).c;
          if (i != -1) {
            paramUri.appendQueryParameter("_HLS_part", String.valueOf(i));
          }
          localUri = paramUri.build();
        }
      }
    }
    return localUri;
  }
  
  private boolean K(Uri paramUri)
  {
    List localList = this.H3.f;
    for (int i = 0; i < localList.size(); i++) {
      if (paramUri.equals(((f.b)localList.get(i)).a)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean L()
  {
    Object localObject = this.H3.f;
    int i = ((List)localObject).size();
    long l = SystemClock.elapsedRealtime();
    for (int j = 0; j < i; j++)
    {
      c localc = (c)com.google.android.exoplayer2.util.g.e((c)this.x.get(((f.b)((List)localObject).get(j)).a));
      if (l > c.d(localc))
      {
        localObject = c.e(localc);
        this.I3 = ((Uri)localObject);
        c.f(localc, J((Uri)localObject));
        return true;
      }
    }
    return false;
  }
  
  private void M(Uri paramUri)
  {
    if ((!paramUri.equals(this.I3)) && (K(paramUri)))
    {
      Object localObject = this.J3;
      if ((localObject == null) || (!((g)localObject).o))
      {
        this.I3 = paramUri;
        localObject = (c)this.x.get(paramUri);
        g localg = c.g((c)localObject);
        if ((localg != null) && (localg.o))
        {
          this.J3 = localg;
          this.p3.c(localg);
        }
        else
        {
          c.f((c)localObject, J(paramUri));
        }
      }
    }
  }
  
  private boolean N(Uri paramUri, x.c paramc, boolean paramBoolean)
  {
    Iterator localIterator = this.y.iterator();
    boolean bool = false;
    while (localIterator.hasNext()) {
      bool |= ((HlsPlaylistTracker.b)localIterator.next()).h(paramUri, paramc, paramBoolean) ^ true;
    }
    return bool;
  }
  
  private void R(Uri paramUri, g paramg)
  {
    if (paramUri.equals(this.I3))
    {
      if (this.J3 == null)
      {
        this.K3 = (paramg.o ^ true);
        this.L3 = paramg.h;
      }
      this.J3 = paramg;
      this.p3.c(paramg);
    }
    paramUri = this.y.iterator();
    while (paramUri.hasNext()) {
      ((HlsPlaylistTracker.b)paramUri.next()).g();
    }
  }
  
  public void O(y<h> paramy, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    com.google.android.exoplayer2.source.x localx = new com.google.android.exoplayer2.source.x(paramy.a, paramy.b, paramy.f(), paramy.d(), paramLong1, paramLong2, paramy.b());
    this.q.d(paramy.a);
    this.p0.q(localx, 4);
  }
  
  public void P(y<h> paramy, long paramLong1, long paramLong2)
  {
    h localh = (h)paramy.e();
    boolean bool = localh instanceof g;
    if (bool) {
      localObject = f.e(localh.a);
    } else {
      localObject = (f)localh;
    }
    this.H3 = ((f)localObject);
    this.I3 = ((f.b)((f)localObject).f.get(0)).a;
    this.y.add(new b(null));
    E(((f)localObject).e);
    Object localObject = new com.google.android.exoplayer2.source.x(paramy.a, paramy.b, paramy.f(), paramy.d(), paramLong1, paramLong2, paramy.b());
    c localc = (c)this.x.get(this.I3);
    if (bool) {
      c.c(localc, (g)localh, (com.google.android.exoplayer2.source.x)localObject);
    } else {
      localc.p();
    }
    this.q.d(paramy.a);
    this.p0.t((com.google.android.exoplayer2.source.x)localObject, 4);
  }
  
  public Loader.c Q(y<h> paramy, long paramLong1, long paramLong2, IOException paramIOException, int paramInt)
  {
    com.google.android.exoplayer2.source.x localx = new com.google.android.exoplayer2.source.x(paramy.a, paramy.b, paramy.f(), paramy.d(), paramLong1, paramLong2, paramy.b());
    a0 locala0 = new a0(paramy.c);
    paramLong1 = this.q.a(new x.c(localx, locala0, paramIOException, paramInt));
    boolean bool;
    if (paramLong1 == -9223372036854775807L) {
      bool = true;
    } else {
      bool = false;
    }
    this.p0.x(localx, paramy.c, paramIOException, bool);
    if (bool) {
      this.q.d(paramy.a);
    }
    if (bool) {
      paramy = Loader.d;
    } else {
      paramy = Loader.g(false, paramLong1);
    }
    return paramy;
  }
  
  public void a(HlsPlaylistTracker.b paramb)
  {
    this.y.remove(paramb);
  }
  
  public void c(Uri paramUri)
    throws IOException
  {
    ((c)this.x.get(paramUri)).s();
  }
  
  public long d()
  {
    return this.L3;
  }
  
  @Nullable
  public f e()
  {
    return this.H3;
  }
  
  public void f(Uri paramUri)
  {
    ((c)this.x.get(paramUri)).p();
  }
  
  public void g(HlsPlaylistTracker.b paramb)
  {
    com.google.android.exoplayer2.util.g.e(paramb);
    this.y.add(paramb);
  }
  
  public boolean i(Uri paramUri)
  {
    return ((c)this.x.get(paramUri)).l();
  }
  
  public boolean j()
  {
    return this.K3;
  }
  
  public boolean k(Uri paramUri, long paramLong)
  {
    paramUri = (c)this.x.get(paramUri);
    if (paramUri != null) {
      return c.a(paramUri, paramLong) ^ true;
    }
    return false;
  }
  
  public void l(Uri paramUri, f0.a parama, HlsPlaylistTracker.c paramc)
  {
    this.p2 = o0.v();
    this.p0 = parama;
    this.p3 = paramc;
    paramc = new y(this.d.a(4), paramUri, 4, this.f.b());
    boolean bool;
    if (this.p1 == null) {
      bool = true;
    } else {
      bool = false;
    }
    com.google.android.exoplayer2.util.g.g(bool);
    paramUri = new Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
    this.p1 = paramUri;
    long l = paramUri.n(paramc, this, this.q.b(paramc.c));
    parama.z(new com.google.android.exoplayer2.source.x(paramc.a, paramc.b, l), paramc.c);
  }
  
  public void m()
    throws IOException
  {
    Object localObject = this.p1;
    if (localObject != null) {
      ((Loader)localObject).j();
    }
    localObject = this.I3;
    if (localObject != null) {
      c((Uri)localObject);
    }
  }
  
  @Nullable
  public g o(Uri paramUri, boolean paramBoolean)
  {
    g localg = ((c)this.x.get(paramUri)).k();
    if ((localg != null) && (paramBoolean)) {
      M(paramUri);
    }
    return localg;
  }
  
  public void stop()
  {
    this.I3 = null;
    this.J3 = null;
    this.H3 = null;
    this.L3 = -9223372036854775807L;
    this.p1.l();
    this.p1 = null;
    Iterator localIterator = this.x.values().iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).x();
    }
    this.p2.removeCallbacksAndMessages(null);
    this.p2 = null;
    this.x.clear();
  }
  
  private class b
    implements HlsPlaylistTracker.b
  {
    private b() {}
    
    public void g()
    {
      d.y(d.this).remove(this);
    }
    
    public boolean h(Uri paramUri, x.c paramc, boolean paramBoolean)
    {
      if (d.z(d.this) == null)
      {
        long l = SystemClock.elapsedRealtime();
        Object localObject = ((f)o0.i(d.r(d.this))).f;
        int i = 0;
        int k;
        for (int j = 0; i < ((List)localObject).size(); j = k)
        {
          d.c localc = (d.c)d.A(d.this).get(((f.b)((List)localObject).get(i)).a);
          k = j;
          if (localc != null)
          {
            k = j;
            if (l < d.c.d(localc)) {
              k = j + 1;
            }
          }
          i++;
        }
        localObject = new x.a(1, 0, d.r(d.this).f.size(), j);
        paramc = d.D(d.this).c((x.a)localObject, paramc);
        if ((paramc != null) && (paramc.a == 2))
        {
          paramUri = (d.c)d.A(d.this).get(paramUri);
          if (paramUri != null) {
            d.c.a(paramUri, paramc.b);
          }
        }
      }
      return false;
    }
  }
  
  private final class c
    implements Loader.b<y<h>>
  {
    private final Uri c;
    private final Loader d;
    private final l f;
    private long p0;
    private boolean p1;
    @Nullable
    private IOException p2;
    @Nullable
    private g q;
    private long x;
    private long y;
    private long z;
    
    public c(Uri paramUri)
    {
      this.c = paramUri;
      this.d = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
      this.f = d.B(d.this).a(4);
    }
    
    private boolean i(long paramLong)
    {
      this.p0 = (SystemClock.elapsedRealtime() + paramLong);
      boolean bool;
      if ((this.c.equals(d.w(d.this))) && (!d.x(d.this))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    private Uri j()
    {
      Object localObject = this.q;
      if (localObject != null)
      {
        localObject = ((g)localObject).v;
        if ((((g.f)localObject).a != -9223372036854775807L) || (((g.f)localObject).e))
        {
          Uri.Builder localBuilder = this.c.buildUpon();
          localObject = this.q;
          if (((g)localObject).v.e)
          {
            localBuilder.appendQueryParameter("_HLS_msn", String.valueOf(((g)localObject).k + ((g)localObject).r.size()));
            localObject = this.q;
            if (((g)localObject).n != -9223372036854775807L)
            {
              localObject = ((g)localObject).s;
              int i = ((List)localObject).size();
              int j = i;
              if (!((List)localObject).isEmpty())
              {
                j = i;
                if (((g.b)j1.f((Iterable)localObject)).I3) {
                  j = i - 1;
                }
              }
              localBuilder.appendQueryParameter("_HLS_part", String.valueOf(j));
            }
          }
          localObject = this.q.v;
          if (((g.f)localObject).a != -9223372036854775807L)
          {
            if (((g.f)localObject).b) {
              localObject = "v2";
            } else {
              localObject = "YES";
            }
            localBuilder.appendQueryParameter("_HLS_skip", (String)localObject);
          }
          return localBuilder.build();
        }
      }
      return this.c;
    }
    
    private void q(Uri paramUri)
    {
      y.a locala = d.s(d.this).a(d.r(d.this), this.q);
      paramUri = new y(this.f, paramUri, 4, locala);
      long l = this.d.n(paramUri, this, d.D(d.this).b(paramUri.c));
      d.C(d.this).z(new com.google.android.exoplayer2.source.x(paramUri.a, paramUri.b, l), paramUri.c);
    }
    
    private void r(Uri paramUri)
    {
      this.p0 = 0L;
      if ((!this.p1) && (!this.d.i()) && (!this.d.h()))
      {
        long l = SystemClock.elapsedRealtime();
        if (l < this.z)
        {
          this.p1 = true;
          d.q(d.this).postDelayed(new a(this, paramUri), this.z - l);
        }
        else
        {
          q(paramUri);
        }
      }
    }
    
    private void w(g paramg, com.google.android.exoplayer2.source.x paramx)
    {
      g localg1 = this.q;
      long l1 = SystemClock.elapsedRealtime();
      this.x = l1;
      g localg2 = d.t(d.this, localg1, paramg);
      this.q = localg2;
      int i = 0;
      Object localObject = null;
      if (localg2 != localg1)
      {
        this.p2 = null;
        this.y = l1;
        d.u(d.this, this.c, localg2);
      }
      else if (!localg2.o)
      {
        long l2 = paramg.k;
        l3 = paramg.r.size();
        localg2 = this.q;
        boolean bool;
        if (l2 + l3 < localg2.k)
        {
          paramg = new HlsPlaylistTracker.PlaylistResetException(this.c);
          bool = true;
        }
        else
        {
          paramg = (g)localObject;
          if (l1 - this.y > w0.e(localg2.m) * d.v(d.this)) {
            paramg = new HlsPlaylistTracker.PlaylistStuckException(this.c);
          }
          bool = false;
        }
        if (paramg != null)
        {
          this.p2 = paramg;
          d.p(d.this, this.c, new x.c(paramx, new a0(4), paramg, 1), bool);
        }
      }
      long l3 = 0L;
      paramg = this.q;
      if (!paramg.v.e) {
        if (paramg != localg1) {
          l3 = paramg.m;
        } else {
          l3 = paramg.m / 2L;
        }
      }
      this.z = (l1 + w0.e(l3));
      if ((this.q.n != -9223372036854775807L) || (this.c.equals(d.w(d.this)))) {
        i = 1;
      }
      if ((i != 0) && (!this.q.o)) {
        r(j());
      }
    }
    
    @Nullable
    public g k()
    {
      return this.q;
    }
    
    public boolean l()
    {
      g localg = this.q;
      boolean bool = false;
      if (localg == null) {
        return false;
      }
      long l1 = SystemClock.elapsedRealtime();
      long l2 = Math.max(30000L, w0.e(this.q.u));
      localg = this.q;
      if (!localg.o)
      {
        int i = localg.d;
        if ((i != 2) && (i != 1) && (this.x + l2 <= l1)) {}
      }
      else
      {
        bool = true;
      }
      return bool;
    }
    
    public void p()
    {
      r(this.c);
    }
    
    public void s()
      throws IOException
    {
      this.d.j();
      IOException localIOException = this.p2;
      if (localIOException == null) {
        return;
      }
      throw localIOException;
    }
    
    public void t(y<h> paramy, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      com.google.android.exoplayer2.source.x localx = new com.google.android.exoplayer2.source.x(paramy.a, paramy.b, paramy.f(), paramy.d(), paramLong1, paramLong2, paramy.b());
      d.D(d.this).d(paramy.a);
      d.C(d.this).q(localx, 4);
    }
    
    public void u(y<h> paramy, long paramLong1, long paramLong2)
    {
      h localh = (h)paramy.e();
      com.google.android.exoplayer2.source.x localx = new com.google.android.exoplayer2.source.x(paramy.a, paramy.b, paramy.f(), paramy.d(), paramLong1, paramLong2, paramy.b());
      if ((localh instanceof g))
      {
        w((g)localh, localx);
        d.C(d.this).t(localx, 4);
      }
      else
      {
        this.p2 = ParserException.createForMalformedManifest("Loaded playlist has unexpected type.", null);
        d.C(d.this).x(localx, 4, this.p2, true);
      }
      d.D(d.this).d(paramy.a);
    }
    
    public Loader.c v(y<h> paramy, long paramLong1, long paramLong2, IOException paramIOException, int paramInt)
    {
      com.google.android.exoplayer2.source.x localx = new com.google.android.exoplayer2.source.x(paramy.a, paramy.b, paramy.f(), paramy.d(), paramLong1, paramLong2, paramy.b());
      int i;
      if (paramy.f().getQueryParameter("_HLS_msn") != null) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool = paramIOException instanceof HlsPlaylistParser.DeltaUpdateException;
      if ((i != 0) || (bool))
      {
        i = Integer.MAX_VALUE;
        if ((paramIOException instanceof HttpDataSource.InvalidResponseCodeException)) {
          i = ((HttpDataSource.InvalidResponseCodeException)paramIOException).responseCode;
        }
        if ((bool) || (i == 400) || (i == 503)) {}
      }
      else
      {
        Object localObject = new x.c(localx, new a0(paramy.c), paramIOException, paramInt);
        if (d.p(d.this, this.c, (x.c)localObject, false))
        {
          paramLong1 = d.D(d.this).a((x.c)localObject);
          if (paramLong1 != -9223372036854775807L) {
            localObject = Loader.g(false, paramLong1);
          } else {
            localObject = Loader.d;
          }
        }
        else
        {
          localObject = Loader.c;
        }
        bool = true ^ ((Loader.c)localObject).c();
        d.C(d.this).x(localx, paramy.c, paramIOException, bool);
        if (bool) {
          d.D(d.this).d(paramy.a);
        }
        return (Loader.c)localObject;
      }
      this.z = SystemClock.elapsedRealtime();
      p();
      ((f0.a)o0.i(d.C(d.this))).x(localx, paramy.c, paramIOException, true);
      return Loader.c;
    }
    
    public void x()
    {
      this.d.l();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\playlist\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */