package io.reactivex.internal.schedulers;

import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.w;
import io.reactivex.w.c;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class f
  extends w
{
  static final RxThreadFactory c;
  static final RxThreadFactory d;
  private static final long e;
  private static final TimeUnit f = TimeUnit.SECONDS;
  static final c g;
  static boolean h;
  static final a i;
  final ThreadFactory j;
  final AtomicReference<a> k;
  
  static
  {
    e = Long.getLong("rx2.io-keep-alive-time", 60L).longValue();
    Object localObject = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    g = (c)localObject;
    ((h)localObject).dispose();
    int m = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
    localObject = new RxThreadFactory("RxCachedThreadScheduler", m);
    c = (RxThreadFactory)localObject;
    d = new RxThreadFactory("RxCachedWorkerPoolEvictor", m);
    h = Boolean.getBoolean("rx2.io-scheduled-release");
    localObject = new a(0L, null, (ThreadFactory)localObject);
    i = (a)localObject;
    ((a)localObject).e();
  }
  
  public f()
  {
    this(c);
  }
  
  public f(ThreadFactory paramThreadFactory)
  {
    this.j = paramThreadFactory;
    this.k = new AtomicReference(i);
    f();
  }
  
  public w.c b()
  {
    return new b((a)this.k.get());
  }
  
  public void f()
  {
    a locala = new a(e, f, this.j);
    if (!this.k.compareAndSet(i, locala)) {
      locala.e();
    }
  }
  
  static final class a
    implements Runnable
  {
    private final long c;
    private final ConcurrentLinkedQueue<f.c> d;
    final b f;
    private final ScheduledExecutorService q;
    private final Future<?> x;
    private final ThreadFactory y;
    
    a(long paramLong, TimeUnit paramTimeUnit, ThreadFactory paramThreadFactory)
    {
      if (paramTimeUnit != null) {
        paramLong = paramTimeUnit.toNanos(paramLong);
      } else {
        paramLong = 0L;
      }
      this.c = paramLong;
      this.d = new ConcurrentLinkedQueue();
      this.f = new b();
      this.y = paramThreadFactory;
      Object localObject = null;
      if (paramTimeUnit != null)
      {
        paramTimeUnit = Executors.newScheduledThreadPool(1, f.d);
        paramThreadFactory = paramTimeUnit.scheduleWithFixedDelay(this, paramLong, paramLong, TimeUnit.NANOSECONDS);
      }
      else
      {
        paramThreadFactory = null;
        paramTimeUnit = (TimeUnit)localObject;
      }
      this.q = paramTimeUnit;
      this.x = paramThreadFactory;
    }
    
    void a()
    {
      if (!this.d.isEmpty())
      {
        long l = c();
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          f.c localc = (f.c)localIterator.next();
          if (localc.i() > l) {
            break;
          }
          if (this.d.remove(localc)) {
            this.f.a(localc);
          }
        }
      }
    }
    
    f.c b()
    {
      if (this.f.isDisposed()) {
        return f.g;
      }
      while (!this.d.isEmpty())
      {
        localc = (f.c)this.d.poll();
        if (localc != null) {
          return localc;
        }
      }
      f.c localc = new f.c(this.y);
      this.f.b(localc);
      return localc;
    }
    
    long c()
    {
      return System.nanoTime();
    }
    
    void d(f.c paramc)
    {
      paramc.j(c() + this.c);
      this.d.offer(paramc);
    }
    
    void e()
    {
      this.f.dispose();
      Object localObject = this.x;
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
      localObject = this.q;
      if (localObject != null) {
        ((ScheduledExecutorService)localObject).shutdownNow();
      }
    }
    
    public void run()
    {
      a();
    }
  }
  
  static final class b
    extends w.c
    implements Runnable
  {
    private final b c;
    private final f.a d;
    private final f.c f;
    final AtomicBoolean q = new AtomicBoolean();
    
    b(f.a parama)
    {
      this.d = parama;
      this.c = new b();
      this.f = parama.b();
    }
    
    public c c(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      if (this.c.isDisposed()) {
        return EmptyDisposable.INSTANCE;
      }
      return this.f.e(paramRunnable, paramLong, paramTimeUnit, this.c);
    }
    
    public void dispose()
    {
      if (this.q.compareAndSet(false, true))
      {
        this.c.dispose();
        if (f.h) {
          this.f.e(this, 0L, TimeUnit.NANOSECONDS, null);
        } else {
          this.d.d(this.f);
        }
      }
    }
    
    public boolean isDisposed()
    {
      return this.q.get();
    }
    
    public void run()
    {
      this.d.d(this.f);
    }
  }
  
  static final class c
    extends h
  {
    private long f = 0L;
    
    c(ThreadFactory paramThreadFactory)
    {
      super();
    }
    
    public long i()
    {
      return this.f;
    }
    
    public void j(long paramLong)
    {
      this.f = paramLong;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */