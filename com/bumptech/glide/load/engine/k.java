package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.a0.a.a;
import com.bumptech.glide.load.engine.a0.b;
import com.bumptech.glide.load.engine.a0.h.a;
import com.bumptech.glide.load.f;
import com.bumptech.glide.util.k.a.d;
import java.util.Map;
import java.util.concurrent.Executor;

public class k
  implements m, h.a, p.a
{
  private static final boolean a = Log.isLoggable("Engine", 2);
  private final r b;
  private final o c;
  private final com.bumptech.glide.load.engine.a0.h d;
  private final b e;
  private final x f;
  private final c g;
  private final a h;
  private final a i;
  
  @VisibleForTesting
  k(com.bumptech.glide.load.engine.a0.h paramh, a.a parama, com.bumptech.glide.load.engine.b0.a parama1, com.bumptech.glide.load.engine.b0.a parama2, com.bumptech.glide.load.engine.b0.a parama3, com.bumptech.glide.load.engine.b0.a parama4, r paramr, o paramo, a parama5, b paramb, a parama6, x paramx, boolean paramBoolean)
  {
    this.d = paramh;
    c localc = new c(parama);
    this.g = localc;
    if (parama5 == null) {
      parama = new a(paramBoolean);
    } else {
      parama = parama5;
    }
    this.i = parama;
    parama.f(this);
    if (paramo == null) {
      paramo = new o();
    }
    this.c = paramo;
    if (paramr == null) {
      paramr = new r();
    }
    this.b = paramr;
    if (paramb == null) {
      parama = new b(parama1, parama2, parama3, parama4, this, this);
    } else {
      parama = paramb;
    }
    this.e = parama;
    if (parama6 == null) {
      parama6 = new a(localc);
    }
    this.h = parama6;
    if (paramx == null) {
      parama = new x();
    } else {
      parama = paramx;
    }
    this.f = parama;
    paramh.e(this);
  }
  
  public k(com.bumptech.glide.load.engine.a0.h paramh, a.a parama, com.bumptech.glide.load.engine.b0.a parama1, com.bumptech.glide.load.engine.b0.a parama2, com.bumptech.glide.load.engine.b0.a parama3, com.bumptech.glide.load.engine.b0.a parama4, boolean paramBoolean)
  {
    this(paramh, parama, parama1, parama2, parama3, parama4, null, null, null, null, null, null, paramBoolean);
  }
  
  private p<?> e(c paramc)
  {
    u localu = this.d.d(paramc);
    if (localu == null) {
      paramc = null;
    } else if ((localu instanceof p)) {
      paramc = (p)localu;
    } else {
      paramc = new p(localu, true, true, paramc, this);
    }
    return paramc;
  }
  
  @Nullable
  private p<?> g(c paramc)
  {
    paramc = this.i.e(paramc);
    if (paramc != null) {
      paramc.b();
    }
    return paramc;
  }
  
  private p<?> h(c paramc)
  {
    p localp = e(paramc);
    if (localp != null)
    {
      localp.b();
      this.i.a(paramc, localp);
    }
    return localp;
  }
  
  @Nullable
  private p<?> i(n paramn, boolean paramBoolean, long paramLong)
  {
    if (!paramBoolean) {
      return null;
    }
    p localp = g(paramn);
    if (localp != null)
    {
      if (a) {
        j("Loaded resource from active resources", paramLong, paramn);
      }
      return localp;
    }
    localp = h(paramn);
    if (localp != null)
    {
      if (a) {
        j("Loaded resource from cache", paramLong, paramn);
      }
      return localp;
    }
    return null;
  }
  
  private static void j(String paramString, long paramLong, c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" in ");
    localStringBuilder.append(com.bumptech.glide.util.e.a(paramLong));
    localStringBuilder.append("ms, key: ");
    localStringBuilder.append(paramc);
    Log.v("Engine", localStringBuilder.toString());
  }
  
  private <R> d l(com.bumptech.glide.e parame, Object paramObject, c paramc, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, Priority paramPriority, j paramj, Map<Class<?>, com.bumptech.glide.load.i<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, f paramf, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, com.bumptech.glide.request.h paramh, Executor paramExecutor, n paramn, long paramLong)
  {
    l locall = this.b.a(paramn, paramBoolean6);
    if (locall != null)
    {
      locall.a(paramh, paramExecutor);
      if (a) {
        j("Added to existing load", paramLong, paramn);
      }
      return new d(paramh, locall);
    }
    locall = this.e.a(paramn, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6);
    parame = this.h.a(parame, paramObject, paramn, paramc, paramInt1, paramInt2, paramClass, paramClass1, paramPriority, paramj, paramMap, paramBoolean1, paramBoolean2, paramBoolean6, paramf, locall);
    this.b.c(paramn, locall);
    locall.a(paramh, paramExecutor);
    locall.s(parame);
    if (a) {
      j("Started new load", paramLong, paramn);
    }
    return new d(paramh, locall);
  }
  
  public void a(@NonNull u<?> paramu)
  {
    this.f.a(paramu, true);
  }
  
  public void b(l<?> paraml, c paramc, p<?> paramp)
  {
    if (paramp != null) {}
    try
    {
      if (paramp.f()) {
        this.i.a(paramc, paramp);
      }
      this.b.d(paramc, paraml);
      return;
    }
    finally {}
  }
  
  public void c(l<?> paraml, c paramc)
  {
    try
    {
      this.b.d(paramc, paraml);
      return;
    }
    finally
    {
      paraml = finally;
      throw paraml;
    }
  }
  
  public void d(c paramc, p<?> paramp)
  {
    this.i.d(paramc);
    if (paramp.f()) {
      this.d.c(paramc, paramp);
    } else {
      this.f.a(paramp, false);
    }
  }
  
  public <R> d f(com.bumptech.glide.e parame, Object paramObject, c paramc, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, Priority paramPriority, j paramj, Map<Class<?>, com.bumptech.glide.load.i<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, f paramf, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, com.bumptech.glide.request.h paramh, Executor paramExecutor)
  {
    long l;
    if (a) {
      l = com.bumptech.glide.util.e.b();
    } else {
      l = 0L;
    }
    n localn = this.c.a(paramObject, paramc, paramInt1, paramInt2, paramMap, paramClass, paramClass1, paramf);
    try
    {
      p localp = i(localn, paramBoolean3, l);
      if (localp == null)
      {
        parame = l(parame, paramObject, paramc, paramInt1, paramInt2, paramClass, paramClass1, paramPriority, paramj, paramMap, paramBoolean1, paramBoolean2, paramf, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramh, paramExecutor, localn, l);
        return parame;
      }
      paramh.b(localp, DataSource.MEMORY_CACHE, false);
      return null;
    }
    finally {}
  }
  
  public void k(u<?> paramu)
  {
    if ((paramu instanceof p))
    {
      ((p)paramu).g();
      return;
    }
    throw new IllegalArgumentException("Cannot release anything but an EngineResource");
  }
  
  @VisibleForTesting
  static class a
  {
    final h.e a;
    final Pools.Pool<h<?>> b = com.bumptech.glide.util.k.a.d(150, new a());
    private int c;
    
    a(h.e parame)
    {
      this.a = parame;
    }
    
    <R> h<R> a(com.bumptech.glide.e parame, Object paramObject, n paramn, c paramc, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, Priority paramPriority, j paramj, Map<Class<?>, com.bumptech.glide.load.i<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, f paramf, h.b<R> paramb)
    {
      h localh = (h)com.bumptech.glide.util.i.d((h)this.b.acquire());
      int i = this.c;
      this.c = (i + 1);
      return localh.n(parame, paramObject, paramn, paramc, paramInt1, paramInt2, paramClass, paramClass1, paramPriority, paramj, paramMap, paramBoolean1, paramBoolean2, paramBoolean3, paramf, paramb, i);
    }
    
    class a
      implements a.d<h<?>>
    {
      a() {}
      
      public h<?> a()
      {
        k.a locala = k.a.this;
        return new h(locala.a, locala.b);
      }
    }
  }
  
  @VisibleForTesting
  static class b
  {
    final com.bumptech.glide.load.engine.b0.a a;
    final com.bumptech.glide.load.engine.b0.a b;
    final com.bumptech.glide.load.engine.b0.a c;
    final com.bumptech.glide.load.engine.b0.a d;
    final m e;
    final p.a f;
    final Pools.Pool<l<?>> g = com.bumptech.glide.util.k.a.d(150, new a());
    
    b(com.bumptech.glide.load.engine.b0.a parama1, com.bumptech.glide.load.engine.b0.a parama2, com.bumptech.glide.load.engine.b0.a parama3, com.bumptech.glide.load.engine.b0.a parama4, m paramm, p.a parama)
    {
      this.a = parama1;
      this.b = parama2;
      this.c = parama3;
      this.d = parama4;
      this.e = paramm;
      this.f = parama;
    }
    
    <R> l<R> a(c paramc, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      return ((l)com.bumptech.glide.util.i.d((l)this.g.acquire())).l(paramc, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
    }
    
    class a
      implements a.d<l<?>>
    {
      a() {}
      
      public l<?> a()
      {
        k.b localb = k.b.this;
        return new l(localb.a, localb.b, localb.c, localb.d, localb.e, localb.f, localb.g);
      }
    }
  }
  
  private static class c
    implements h.e
  {
    private final a.a a;
    private volatile com.bumptech.glide.load.engine.a0.a b;
    
    c(a.a parama)
    {
      this.a = parama;
    }
    
    public com.bumptech.glide.load.engine.a0.a a()
    {
      if (this.b == null) {
        try
        {
          if (this.b == null) {
            this.b = this.a.build();
          }
          if (this.b == null)
          {
            b localb = new com/bumptech/glide/load/engine/a0/b;
            localb.<init>();
            this.b = localb;
          }
        }
        finally {}
      }
      return this.b;
    }
  }
  
  public class d
  {
    private final l<?> a;
    private final com.bumptech.glide.request.h b;
    
    d(l<?> paraml)
    {
      this.b = paraml;
      l locall;
      this.a = locall;
    }
    
    public void a()
    {
      synchronized (k.this)
      {
        this.a.r(this.b);
        return;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */