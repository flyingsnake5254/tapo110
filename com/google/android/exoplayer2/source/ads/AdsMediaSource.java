package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.j2.b;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.l1.c;
import com.google.android.exoplayer2.l1.e;
import com.google.android.exoplayer2.l1.g;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.source.f0.a;
import com.google.android.exoplayer2.source.g0;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class AdsMediaSource
  extends p<e0.a>
{
  private static final e0.a j = new e0.a(new Object());
  private final com.google.android.exoplayer2.source.e0 k;
  private final g0 l;
  private final h m;
  private final com.google.android.exoplayer2.ui.e0 n;
  private final n o;
  private final Object p;
  private final Handler q;
  private final j2.b r;
  @Nullable
  private c s;
  @Nullable
  private j2 t;
  @Nullable
  private g u;
  private a[][] v;
  
  public AdsMediaSource(com.google.android.exoplayer2.source.e0 parame0, n paramn, Object paramObject, g0 paramg0, h paramh, com.google.android.exoplayer2.ui.e0 parame01)
  {
    this.k = parame0;
    this.l = paramg0;
    this.m = paramh;
    this.n = parame01;
    this.o = paramn;
    this.p = paramObject;
    this.q = new Handler(Looper.getMainLooper());
    this.r = new j2.b();
    this.v = new a[0][];
    paramh.e(paramg0.b());
  }
  
  private long[][] O()
  {
    long[][] arrayOfLong = new long[this.v.length][];
    for (int i = 0;; i++)
    {
      Object localObject1 = this.v;
      if (i >= localObject1.length) {
        break;
      }
      arrayOfLong[i] = new long[localObject1[i].length];
      for (int i1 = 0;; i1++)
      {
        localObject1 = this.v;
        if (i1 >= localObject1[i].length) {
          break;
        }
        Object localObject2 = localObject1[i][i1];
        localObject1 = arrayOfLong[i];
        long l1;
        if (localObject2 == null) {
          l1 = -9223372036854775807L;
        } else {
          l1 = ((a)localObject2).b();
        }
        localObject1[i1] = l1;
      }
    }
    return arrayOfLong;
  }
  
  private void U()
  {
    g localg = this.u;
    if (localg == null) {
      return;
    }
    for (int i = 0; i < this.v.length; i++) {
      for (int i1 = 0;; i1++)
      {
        Object localObject1 = this.v;
        if (i1 >= localObject1[i].length) {
          break;
        }
        localObject1 = localObject1[i][i1];
        Object localObject2 = localg.a(i);
        if ((localObject1 != null) && (!((a)localObject1).d()))
        {
          localObject2 = ((g.a)localObject2).d;
          if (i1 < localObject2.length)
          {
            localObject2 = localObject2[i1];
            if (localObject2 != null)
            {
              l1.c localc = new l1.c().u((Uri)localObject2);
              Object localObject3 = this.k.f().d;
              if (localObject3 != null)
              {
                localObject3 = ((l1.g)localObject3).c;
                if (localObject3 != null)
                {
                  localc.j(((l1.e)localObject3).a);
                  localc.d(((l1.e)localObject3).a());
                  localc.f(((l1.e)localObject3).b);
                  localc.c(((l1.e)localObject3).f);
                  localc.e(((l1.e)localObject3).c);
                  localc.g(((l1.e)localObject3).d);
                  localc.h(((l1.e)localObject3).e);
                  localc.i(((l1.e)localObject3).g);
                }
              }
              ((a)localObject1).e(this.l.a(localc.a()), (Uri)localObject2);
            }
          }
        }
      }
    }
  }
  
  private void V()
  {
    j2 localj2 = this.t;
    g localg = this.u;
    if ((localg != null) && (localj2 != null)) {
      if (localg.e == 0)
      {
        y(localj2);
      }
      else
      {
        this.u = localg.e(O());
        y(new i(localj2, this.u));
      }
    }
  }
  
  protected e0.a P(e0.a parama1, e0.a parama2)
  {
    if (!parama1.b()) {
      parama1 = parama2;
    }
    return parama1;
  }
  
  protected void W(e0.a parama, com.google.android.exoplayer2.source.e0 parame0, j2 paramj2)
  {
    int i1;
    if (parama.b())
    {
      int i = parama.b;
      i1 = parama.c;
      ((a)com.google.android.exoplayer2.util.g.e(this.v[i][i1])).c(paramj2);
    }
    else
    {
      i1 = paramj2.i();
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      com.google.android.exoplayer2.util.g.a(bool);
      this.t = paramj2;
    }
    V();
  }
  
  public b0 a(e0.a parama, com.google.android.exoplayer2.upstream.e parame, long paramLong)
  {
    if ((((g)com.google.android.exoplayer2.util.g.e(this.u)).e > 0) && (parama.b()))
    {
      int i = parama.b;
      int i1 = parama.c;
      Object localObject = this.v;
      if (localObject[i].length <= i1) {
        localObject[i] = ((a[])Arrays.copyOf(localObject[i], i1 + 1));
      }
      a locala = this.v[i][i1];
      localObject = locala;
      if (locala == null)
      {
        localObject = new a(parama);
        this.v[i][i1] = localObject;
        U();
      }
      return ((a)localObject).a(parama, parame, paramLong);
    }
    parame = new y(parama, parame, paramLong);
    parame.y(this.k);
    parame.g(parama);
    return parame;
  }
  
  public l1 f()
  {
    return this.k.f();
  }
  
  public void g(b0 paramb0)
  {
    y localy = (y)paramb0;
    paramb0 = localy.c;
    if (paramb0.b())
    {
      a locala = (a)com.google.android.exoplayer2.util.g.e(this.v[paramb0.b][paramb0.c]);
      locala.h(localy);
      if (locala.f())
      {
        locala.g();
        this.v[paramb0.b][paramb0.c] = null;
      }
    }
    else
    {
      localy.x();
    }
  }
  
  protected void x(@Nullable a0 parama0)
  {
    super.x(parama0);
    parama0 = new c();
    this.s = parama0;
    G(j, this.k);
    this.q.post(new c(this, parama0));
  }
  
  protected void z()
  {
    super.z();
    c localc = (c)com.google.android.exoplayer2.util.g.e(this.s);
    this.s = null;
    localc.a();
    this.t = null;
    this.u = null;
    this.v = new a[0][];
    this.q.post(new f(this, localc));
  }
  
  public static final class AdLoadException
    extends IOException
  {
    public static final int TYPE_AD = 0;
    public static final int TYPE_AD_GROUP = 1;
    public static final int TYPE_ALL_ADS = 2;
    public static final int TYPE_UNEXPECTED = 3;
    public final int type;
    
    private AdLoadException(int paramInt, Exception paramException)
    {
      super();
      this.type = paramInt;
    }
    
    public static AdLoadException createForAd(Exception paramException)
    {
      return new AdLoadException(0, paramException);
    }
    
    public static AdLoadException createForAdGroup(Exception paramException, int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder(35);
      localStringBuilder.append("Failed to load ad group ");
      localStringBuilder.append(paramInt);
      return new AdLoadException(1, new IOException(localStringBuilder.toString(), paramException));
    }
    
    public static AdLoadException createForAllAds(Exception paramException)
    {
      return new AdLoadException(2, paramException);
    }
    
    public static AdLoadException createForUnexpected(RuntimeException paramRuntimeException)
    {
      return new AdLoadException(3, paramRuntimeException);
    }
    
    public RuntimeException getRuntimeExceptionForUnexpected()
    {
      boolean bool;
      if (this.type == 3) {
        bool = true;
      } else {
        bool = false;
      }
      com.google.android.exoplayer2.util.g.g(bool);
      return (RuntimeException)com.google.android.exoplayer2.util.g.e(getCause());
    }
  }
  
  private final class a
  {
    private final e0.a a;
    private final List<y> b;
    private Uri c;
    private com.google.android.exoplayer2.source.e0 d;
    private j2 e;
    
    public a(e0.a parama)
    {
      this.a = parama;
      this.b = new ArrayList();
    }
    
    public b0 a(e0.a parama, com.google.android.exoplayer2.upstream.e parame, long paramLong)
    {
      parame = new y(parama, parame, paramLong);
      this.b.add(parame);
      Object localObject = this.d;
      if (localObject != null)
      {
        parame.y((com.google.android.exoplayer2.source.e0)localObject);
        parame.z(new AdsMediaSource.b(AdsMediaSource.this, (Uri)com.google.android.exoplayer2.util.g.e(this.c)));
      }
      localObject = this.e;
      if (localObject != null) {
        parame.g(new e0.a(((j2)localObject).m(0), parama.d));
      }
      return parame;
    }
    
    public long b()
    {
      j2 localj2 = this.e;
      long l;
      if (localj2 == null) {
        l = -9223372036854775807L;
      } else {
        l = localj2.f(0, AdsMediaSource.M(AdsMediaSource.this)).i();
      }
      return l;
    }
    
    public void c(j2 paramj2)
    {
      int i = paramj2.i();
      int j = 0;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      com.google.android.exoplayer2.util.g.a(bool);
      if (this.e == null)
      {
        Object localObject = paramj2.m(0);
        while (j < this.b.size())
        {
          y localy = (y)this.b.get(j);
          localy.g(new e0.a(localObject, localy.c.d));
          j++;
        }
      }
      this.e = paramj2;
    }
    
    public boolean d()
    {
      boolean bool;
      if (this.d != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void e(com.google.android.exoplayer2.source.e0 parame0, Uri paramUri)
    {
      this.d = parame0;
      this.c = paramUri;
      for (int i = 0; i < this.b.size(); i++)
      {
        y localy = (y)this.b.get(i);
        localy.y(parame0);
        localy.z(new AdsMediaSource.b(AdsMediaSource.this, paramUri));
      }
      AdsMediaSource.L(AdsMediaSource.this, this.a, parame0);
    }
    
    public boolean f()
    {
      return this.b.isEmpty();
    }
    
    public void g()
    {
      if (d()) {
        AdsMediaSource.N(AdsMediaSource.this, this.a);
      }
    }
    
    public void h(y paramy)
    {
      this.b.remove(paramy);
      paramy.x();
    }
  }
  
  private final class b
    implements y.a
  {
    private final Uri a;
    
    public b(Uri paramUri)
    {
      this.a = paramUri;
    }
    
    public void a(e0.a parama)
    {
      AdsMediaSource.I(AdsMediaSource.this).post(new e(this, parama));
    }
    
    public void b(e0.a parama, IOException paramIOException)
    {
      AdsMediaSource.J(AdsMediaSource.this, parama).x(new x(x.a(), new n(this.a), SystemClock.elapsedRealtime()), 6, AdsMediaSource.AdLoadException.createForAd(paramIOException), true);
      AdsMediaSource.I(AdsMediaSource.this).post(new d(this, parama, paramIOException));
    }
  }
  
  private final class c
    implements h.a
  {
    private final Handler a = o0.v();
    private volatile boolean b;
    
    public c() {}
    
    public void a()
    {
      this.b = true;
      this.a.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\ads\AdsMediaSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */