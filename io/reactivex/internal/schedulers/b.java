package io.reactivex.internal.schedulers;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.w;
import io.reactivex.w.c;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class b
  extends w
{
  static final b c;
  static final RxThreadFactory d;
  static final int e = f(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
  static final c f;
  final ThreadFactory g;
  final AtomicReference<b> h;
  
  static
  {
    Object localObject = new c(new RxThreadFactory("RxComputationShutdown"));
    f = (c)localObject;
    ((h)localObject).dispose();
    localObject = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
    d = (RxThreadFactory)localObject;
    localObject = new b(0, (ThreadFactory)localObject);
    c = (b)localObject;
    ((b)localObject).b();
  }
  
  public b()
  {
    this(d);
  }
  
  public b(ThreadFactory paramThreadFactory)
  {
    this.g = paramThreadFactory;
    this.h = new AtomicReference(c);
    g();
  }
  
  static int f(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 > 0) {
      if (paramInt2 > paramInt1) {
        i = paramInt1;
      } else {
        i = paramInt2;
      }
    }
    return i;
  }
  
  public w.c b()
  {
    return new a(((b)this.h.get()).a());
  }
  
  public c d(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return ((b)this.h.get()).a().f(paramRunnable, paramLong, paramTimeUnit);
  }
  
  public c e(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return ((b)this.h.get()).a().g(paramRunnable, paramLong1, paramLong2, paramTimeUnit);
  }
  
  public void g()
  {
    b localb = new b(e, this.g);
    if (!this.h.compareAndSet(c, localb)) {
      localb.b();
    }
  }
  
  static final class a
    extends w.c
  {
    private final io.reactivex.internal.disposables.b c;
    private final io.reactivex.e0.b d;
    private final io.reactivex.internal.disposables.b f;
    private final b.c q;
    volatile boolean x;
    
    a(b.c paramc)
    {
      this.q = paramc;
      io.reactivex.internal.disposables.b localb = new io.reactivex.internal.disposables.b();
      this.c = localb;
      io.reactivex.e0.b localb1 = new io.reactivex.e0.b();
      this.d = localb1;
      paramc = new io.reactivex.internal.disposables.b();
      this.f = paramc;
      paramc.b(localb);
      paramc.b(localb1);
    }
    
    public c b(Runnable paramRunnable)
    {
      if (this.x) {
        return EmptyDisposable.INSTANCE;
      }
      return this.q.e(paramRunnable, 0L, TimeUnit.MILLISECONDS, this.c);
    }
    
    public c c(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      if (this.x) {
        return EmptyDisposable.INSTANCE;
      }
      return this.q.e(paramRunnable, paramLong, paramTimeUnit, this.d);
    }
    
    public void dispose()
    {
      if (!this.x)
      {
        this.x = true;
        this.f.dispose();
      }
    }
    
    public boolean isDisposed()
    {
      return this.x;
    }
  }
  
  static final class b
  {
    final int a;
    final b.c[] b;
    long c;
    
    b(int paramInt, ThreadFactory paramThreadFactory)
    {
      this.a = paramInt;
      this.b = new b.c[paramInt];
      for (int i = 0; i < paramInt; i++) {
        this.b[i] = new b.c(paramThreadFactory);
      }
    }
    
    public b.c a()
    {
      int i = this.a;
      if (i == 0) {
        return b.f;
      }
      b.c[] arrayOfc = this.b;
      long l = this.c;
      this.c = (1L + l);
      return arrayOfc[((int)(l % i))];
    }
    
    public void b()
    {
      b.c[] arrayOfc = this.b;
      int i = arrayOfc.length;
      for (int j = 0; j < i; j++) {
        arrayOfc[j].dispose();
      }
    }
  }
  
  static final class c
    extends h
  {
    c(ThreadFactory paramThreadFactory)
    {
      super();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */