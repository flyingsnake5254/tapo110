package com.bumptech.glide.load.engine;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.b0.a;
import com.bumptech.glide.util.d;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.k.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class l<R>
  implements h.b<R>, a.f
{
  private static final c c = new c();
  private final AtomicInteger H3 = new AtomicInteger();
  private com.bumptech.glide.load.c I3;
  private boolean J3;
  private boolean K3;
  private boolean L3;
  private boolean M3;
  private u<?> N3;
  DataSource O3;
  private boolean P3;
  GlideException Q3;
  private boolean R3;
  p<?> S3;
  private h<R> T3;
  private volatile boolean U3;
  private boolean V3;
  final e d = new e();
  private final com.bumptech.glide.util.k.c f = com.bumptech.glide.util.k.c.a();
  private final a p0;
  private final a p1;
  private final a p2;
  private final a p3;
  private final p.a q;
  private final Pools.Pool<l<?>> x;
  private final c y;
  private final m z;
  
  l(a parama1, a parama2, a parama3, a parama4, m paramm, p.a parama, Pools.Pool<l<?>> paramPool)
  {
    this(parama1, parama2, parama3, parama4, paramm, parama, paramPool, c);
  }
  
  @VisibleForTesting
  l(a parama1, a parama2, a parama3, a parama4, m paramm, p.a parama, Pools.Pool<l<?>> paramPool, c paramc)
  {
    this.p0 = parama1;
    this.p1 = parama2;
    this.p2 = parama3;
    this.p3 = parama4;
    this.z = paramm;
    this.q = parama;
    this.x = paramPool;
    this.y = paramc;
  }
  
  private a j()
  {
    a locala;
    if (this.K3) {
      locala = this.p2;
    } else if (this.L3) {
      locala = this.p3;
    } else {
      locala = this.p1;
    }
    return locala;
  }
  
  private boolean m()
  {
    boolean bool;
    if ((!this.R3) && (!this.P3) && (!this.U3)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void q()
  {
    try
    {
      if (this.I3 != null)
      {
        this.d.clear();
        this.I3 = null;
        this.S3 = null;
        this.N3 = null;
        this.R3 = false;
        this.U3 = false;
        this.P3 = false;
        this.V3 = false;
        this.T3.w(false);
        this.T3 = null;
        this.Q3 = null;
        this.O3 = null;
        this.x.release(this);
        return;
      }
      IllegalArgumentException localIllegalArgumentException = new java/lang/IllegalArgumentException;
      localIllegalArgumentException.<init>();
      throw localIllegalArgumentException;
    }
    finally {}
  }
  
  void a(com.bumptech.glide.request.h paramh, Executor paramExecutor)
  {
    try
    {
      this.f.c();
      this.d.a(paramh, paramExecutor);
      boolean bool1 = this.P3;
      boolean bool2 = true;
      Object localObject;
      if (bool1)
      {
        k(1);
        localObject = new com/bumptech/glide/load/engine/l$b;
        ((b)localObject).<init>(this, paramh);
        paramExecutor.execute((Runnable)localObject);
      }
      else if (this.R3)
      {
        k(1);
        localObject = new com/bumptech/glide/load/engine/l$a;
        ((a)localObject).<init>(this, paramh);
        paramExecutor.execute((Runnable)localObject);
      }
      else
      {
        if (this.U3) {
          bool2 = false;
        }
        i.a(bool2, "Cannot add callbacks to a cancelled EngineJob");
      }
      return;
    }
    finally {}
  }
  
  public void b(u<R> paramu, DataSource paramDataSource, boolean paramBoolean)
  {
    try
    {
      this.N3 = paramu;
      this.O3 = paramDataSource;
      this.V3 = paramBoolean;
      o();
      return;
    }
    finally {}
  }
  
  public void c(GlideException paramGlideException)
  {
    try
    {
      this.Q3 = paramGlideException;
      n();
      return;
    }
    finally {}
  }
  
  @NonNull
  public com.bumptech.glide.util.k.c d()
  {
    return this.f;
  }
  
  public void e(h<?> paramh)
  {
    j().execute(paramh);
  }
  
  @GuardedBy("this")
  void f(com.bumptech.glide.request.h paramh)
  {
    try
    {
      paramh.c(this.Q3);
      return;
    }
    finally {}
  }
  
  @GuardedBy("this")
  void g(com.bumptech.glide.request.h paramh)
  {
    try
    {
      paramh.b(this.S3, this.O3, this.V3);
      return;
    }
    finally {}
  }
  
  void h()
  {
    if (m()) {
      return;
    }
    this.U3 = true;
    this.T3.b();
    this.z.c(this, this.I3);
  }
  
  void i()
  {
    try
    {
      this.f.c();
      i.a(m(), "Not yet complete!");
      int i = this.H3.decrementAndGet();
      boolean bool;
      if (i >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      i.a(bool, "Can't decrement below 0");
      p localp;
      if (i == 0)
      {
        localp = this.S3;
        q();
      }
      else
      {
        localp = null;
      }
      if (localp != null) {
        localp.g();
      }
      return;
    }
    finally {}
  }
  
  void k(int paramInt)
  {
    try
    {
      i.a(m(), "Not yet complete!");
      if (this.H3.getAndAdd(paramInt) == 0)
      {
        p localp = this.S3;
        if (localp != null) {
          localp.b();
        }
      }
      return;
    }
    finally {}
  }
  
  @VisibleForTesting
  l<R> l(com.bumptech.glide.load.c paramc, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    try
    {
      this.I3 = paramc;
      this.J3 = paramBoolean1;
      this.K3 = paramBoolean2;
      this.L3 = paramBoolean3;
      this.M3 = paramBoolean4;
      return this;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  void n()
  {
    try
    {
      this.f.c();
      if (this.U3)
      {
        q();
        return;
      }
      if (!this.d.isEmpty())
      {
        if (!this.R3)
        {
          this.R3 = true;
          Object localObject1 = this.I3;
          localObject2 = this.d.c();
          k(((e)localObject2).size() + 1);
          this.z.b(this, (com.bumptech.glide.load.c)localObject1, null);
          localObject1 = ((e)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (d)((Iterator)localObject1).next();
            ((d)localObject2).b.execute(new a(((d)localObject2).a));
          }
          i();
          return;
        }
        localObject2 = new java/lang/IllegalStateException;
        ((IllegalStateException)localObject2).<init>("Already failed once");
        throw ((Throwable)localObject2);
      }
      Object localObject2 = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject2).<init>("Received an exception without any callbacks to notify");
      throw ((Throwable)localObject2);
    }
    finally {}
  }
  
  void o()
  {
    try
    {
      this.f.c();
      if (this.U3)
      {
        this.N3.c();
        q();
        return;
      }
      if (!this.d.isEmpty())
      {
        if (!this.P3)
        {
          this.S3 = this.y.a(this.N3, this.J3, this.I3, this.q);
          this.P3 = true;
          Object localObject1 = this.d.c();
          k(((e)localObject1).size() + 1);
          localObject2 = this.I3;
          p localp = this.S3;
          this.z.b(this, (com.bumptech.glide.load.c)localObject2, localp);
          localObject2 = ((e)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (d)((Iterator)localObject2).next();
            ((d)localObject1).b.execute(new b(((d)localObject1).a));
          }
          i();
          return;
        }
        localObject2 = new java/lang/IllegalStateException;
        ((IllegalStateException)localObject2).<init>("Already have resource");
        throw ((Throwable)localObject2);
      }
      Object localObject2 = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject2).<init>("Received a resource without any callbacks to notify");
      throw ((Throwable)localObject2);
    }
    finally {}
  }
  
  boolean p()
  {
    return this.M3;
  }
  
  void r(com.bumptech.glide.request.h paramh)
  {
    try
    {
      this.f.c();
      this.d.e(paramh);
      if (this.d.isEmpty())
      {
        h();
        int i;
        if ((!this.P3) && (!this.R3)) {
          i = 0;
        } else {
          i = 1;
        }
        if ((i != 0) && (this.H3.get() == 0)) {
          q();
        }
      }
      return;
    }
    finally {}
  }
  
  public void s(h<R> paramh)
  {
    try
    {
      this.T3 = paramh;
      a locala;
      if (paramh.C()) {
        locala = this.p0;
      } else {
        locala = j();
      }
      locala.execute(paramh);
      return;
    }
    finally {}
  }
  
  private class a
    implements Runnable
  {
    private final com.bumptech.glide.request.h c;
    
    a(com.bumptech.glide.request.h paramh)
    {
      this.c = paramh;
    }
    
    public void run()
    {
      synchronized (this.c.f())
      {
        synchronized (l.this)
        {
          if (l.this.d.b(this.c)) {
            l.this.f(this.c);
          }
          l.this.i();
          return;
        }
      }
    }
  }
  
  private class b
    implements Runnable
  {
    private final com.bumptech.glide.request.h c;
    
    b(com.bumptech.glide.request.h paramh)
    {
      this.c = paramh;
    }
    
    public void run()
    {
      synchronized (this.c.f())
      {
        synchronized (l.this)
        {
          if (l.this.d.b(this.c))
          {
            l.this.S3.b();
            l.this.g(this.c);
            l.this.r(this.c);
          }
          l.this.i();
          return;
        }
      }
    }
  }
  
  @VisibleForTesting
  static class c
  {
    public <R> p<R> a(u<R> paramu, boolean paramBoolean, com.bumptech.glide.load.c paramc, p.a parama)
    {
      return new p(paramu, paramBoolean, true, paramc, parama);
    }
  }
  
  static final class d
  {
    final com.bumptech.glide.request.h a;
    final Executor b;
    
    d(com.bumptech.glide.request.h paramh, Executor paramExecutor)
    {
      this.a = paramh;
      this.b = paramExecutor;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        return this.a.equals(((d)paramObject).a);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
  }
  
  static final class e
    implements Iterable<l.d>
  {
    private final List<l.d> c;
    
    e()
    {
      this(new ArrayList(2));
    }
    
    e(List<l.d> paramList)
    {
      this.c = paramList;
    }
    
    private static l.d d(com.bumptech.glide.request.h paramh)
    {
      return new l.d(paramh, d.a());
    }
    
    void a(com.bumptech.glide.request.h paramh, Executor paramExecutor)
    {
      this.c.add(new l.d(paramh, paramExecutor));
    }
    
    boolean b(com.bumptech.glide.request.h paramh)
    {
      return this.c.contains(d(paramh));
    }
    
    e c()
    {
      return new e(new ArrayList(this.c));
    }
    
    void clear()
    {
      this.c.clear();
    }
    
    void e(com.bumptech.glide.request.h paramh)
    {
      this.c.remove(d(paramh));
    }
    
    boolean isEmpty()
    {
      return this.c.isEmpty();
    }
    
    @NonNull
    public Iterator<l.d> iterator()
    {
      return this.c.iterator();
    }
    
    int size()
    {
      return this.c.size();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */