package com.google.android.exoplayer2.source;

import android.content.Context;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.l1.b;
import com.google.android.exoplayer2.l1.c;
import com.google.android.exoplayer2.l1.d;
import com.google.android.exoplayer2.l1.f;
import com.google.android.exoplayer2.l1.g;
import com.google.android.exoplayer2.l1.h;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.ads.h;
import com.google.android.exoplayer2.upstream.l.a;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.r;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

public final class t
  implements g0
{
  private final l.a a;
  private final SparseArray<g0> b;
  private final int[] c;
  @Nullable
  private a d;
  @Nullable
  private com.google.android.exoplayer2.ui.e0 e;
  @Nullable
  private x f;
  private long g;
  private long h;
  private long i;
  private float j;
  private float k;
  
  public t(Context paramContext, o paramo)
  {
    this(new r(paramContext), paramo);
  }
  
  public t(l.a parama, o paramo)
  {
    this.a = parama;
    parama = c(parama, paramo);
    this.b = parama;
    this.c = new int[parama.size()];
    for (int m = 0; m < this.b.size(); m++) {
      this.c[m] = this.b.keyAt(m);
    }
    this.g = -9223372036854775807L;
    this.h = -9223372036854775807L;
    this.i = -9223372036854775807L;
    this.j = -3.4028235E38F;
    this.k = -3.4028235E38F;
  }
  
  private static SparseArray<g0> c(l.a parama, o paramo)
  {
    SparseArray localSparseArray = new SparseArray();
    try
    {
      localSparseArray.put(0, (g0)Class.forName("com.google.android.exoplayer2.source.dash.DashMediaSource$Factory").asSubclass(g0.class).getConstructor(new Class[] { l.a.class }).newInstance(new Object[] { parama }));
    }
    catch (Exception localException3)
    {
      try
      {
        localSparseArray.put(1, (g0)Class.forName("com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory").asSubclass(g0.class).getConstructor(new Class[] { l.a.class }).newInstance(new Object[] { parama }));
      }
      catch (Exception localException3)
      {
        try
        {
          localSparseArray.put(2, (g0)Class.forName("com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory").asSubclass(g0.class).getConstructor(new Class[] { l.a.class }).newInstance(new Object[] { parama }));
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              localSparseArray.put(3, (g0)Class.forName("com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory").asSubclass(g0.class).getConstructor(new Class[0]).newInstance(new Object[0]));
              localSparseArray.put(4, new k0.b(parama, paramo));
              return localSparseArray;
              localException1 = localException1;
              continue;
              localException2 = localException2;
              continue;
              localException3 = localException3;
            }
          }
          catch (Exception localException4)
          {
            for (;;) {}
          }
        }
      }
    }
  }
  
  private static e0 d(l1 paraml1, e0 parame0)
  {
    l1.d locald = paraml1.g;
    long l1 = locald.b;
    if ((l1 == 0L) && (locald.c == Long.MIN_VALUE) && (!locald.e)) {
      return parame0;
    }
    l1 = w0.d(l1);
    long l2 = w0.d(paraml1.g.c);
    paraml1 = paraml1.g;
    return new ClippingMediaSource(parame0, l1, l2, paraml1.f ^ true, paraml1.d, paraml1.e);
  }
  
  private e0 e(l1 paraml1, e0 parame0)
  {
    g.e(paraml1.d);
    l1.b localb = paraml1.d.d;
    if (localb == null) {
      return parame0;
    }
    Object localObject = this.d;
    com.google.android.exoplayer2.ui.e0 locale0 = this.e;
    if ((localObject != null) && (locale0 != null))
    {
      h localh = ((a)localObject).a(localb);
      if (localh == null)
      {
        u.h("DefaultMediaSourceFactory", "Playing media without ads, as no AdsLoader was provided.");
        return parame0;
      }
      n localn = new n(localb.a);
      localObject = localb.b;
      if (localObject != null) {
        paraml1 = (l1)localObject;
      } else {
        paraml1 = ImmutableList.of(paraml1.c, paraml1.d.a, localb.a);
      }
      return new AdsMediaSource(parame0, localn, paraml1, this, localh, locale0);
    }
    u.h("DefaultMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
    return parame0;
  }
  
  public e0 a(l1 paraml1)
  {
    g.e(paraml1.d);
    Object localObject1 = paraml1.d;
    int m = o0.h0(((l1.g)localObject1).a, ((l1.g)localObject1).b);
    Object localObject2 = (g0)this.b.get(m);
    localObject1 = new StringBuilder(68);
    ((StringBuilder)localObject1).append("No suitable media source factory found for content type: ");
    ((StringBuilder)localObject1).append(m);
    g.f(localObject2, ((StringBuilder)localObject1).toString());
    Object localObject3 = paraml1.e;
    if (((((l1.f)localObject3).c != -9223372036854775807L) || (this.g == -9223372036854775807L)) && ((((l1.f)localObject3).f != -3.4028235E38F) || (this.j == -3.4028235E38F)) && ((((l1.f)localObject3).g != -3.4028235E38F) || (this.k == -3.4028235E38F)) && ((((l1.f)localObject3).d != -9223372036854775807L) || (this.h == -9223372036854775807L)))
    {
      localObject1 = paraml1;
      if (((l1.f)localObject3).e == -9223372036854775807L)
      {
        localObject1 = paraml1;
        if (this.i == -9223372036854775807L) {}
      }
    }
    else
    {
      localObject1 = paraml1.a();
      long l1 = paraml1.e.c;
      long l2 = l1;
      if (l1 == -9223372036854775807L) {
        l2 = this.g;
      }
      localObject1 = ((l1.c)localObject1).o(l2);
      float f1 = paraml1.e.f;
      float f2 = f1;
      if (f1 == -3.4028235E38F) {
        f2 = this.j;
      }
      localObject1 = ((l1.c)localObject1).n(f2);
      f1 = paraml1.e.g;
      f2 = f1;
      if (f1 == -3.4028235E38F) {
        f2 = this.k;
      }
      localObject1 = ((l1.c)localObject1).l(f2);
      l1 = paraml1.e.d;
      l2 = l1;
      if (l1 == -9223372036854775807L) {
        l2 = this.h;
      }
      localObject1 = ((l1.c)localObject1).m(l2);
      l1 = paraml1.e.e;
      l2 = l1;
      if (l1 == -9223372036854775807L) {
        l2 = this.i;
      }
      localObject1 = ((l1.c)localObject1).k(l2).a();
    }
    localObject2 = ((g0)localObject2).a((l1)localObject1);
    localObject3 = ((l1.g)o0.i(((l1)localObject1).d)).g;
    paraml1 = (l1)localObject2;
    if (!((List)localObject3).isEmpty())
    {
      paraml1 = new e0[((List)localObject3).size() + 1];
      m = 0;
      paraml1[0] = localObject2;
      localObject2 = new s0.b(this.a).b(this.f);
      while (m < ((List)localObject3).size())
      {
        int n = m + 1;
        paraml1[n] = ((s0.b)localObject2).a((l1.h)((List)localObject3).get(m), -9223372036854775807L);
        m = n;
      }
      paraml1 = new MergingMediaSource(paraml1);
    }
    return e((l1)localObject1, d((l1)localObject1, paraml1));
  }
  
  public int[] b()
  {
    int[] arrayOfInt = this.c;
    return Arrays.copyOf(arrayOfInt, arrayOfInt.length);
  }
  
  public static abstract interface a
  {
    @Nullable
    public abstract h a(l1.b paramb);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */