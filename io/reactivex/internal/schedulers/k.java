package io.reactivex.internal.schedulers;

import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.w;
import io.reactivex.w.c;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class k
  extends w
{
  static final RxThreadFactory c = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
  static final ScheduledExecutorService d;
  final ThreadFactory e;
  final AtomicReference<ScheduledExecutorService> f;
  
  static
  {
    ScheduledExecutorService localScheduledExecutorService = Executors.newScheduledThreadPool(0);
    d = localScheduledExecutorService;
    localScheduledExecutorService.shutdown();
  }
  
  public k()
  {
    this(c);
  }
  
  public k(ThreadFactory paramThreadFactory)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    this.f = localAtomicReference;
    this.e = paramThreadFactory;
    localAtomicReference.lazySet(f(paramThreadFactory));
  }
  
  static ScheduledExecutorService f(ThreadFactory paramThreadFactory)
  {
    return j.a(paramThreadFactory);
  }
  
  public w.c b()
  {
    return new a((ScheduledExecutorService)this.f.get());
  }
  
  public c d(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    ScheduledDirectTask localScheduledDirectTask = new ScheduledDirectTask(io.reactivex.j0.a.t(paramRunnable));
    if (paramLong <= 0L) {}
    try
    {
      paramRunnable = ((ScheduledExecutorService)this.f.get()).submit(localScheduledDirectTask);
      break label61;
      paramRunnable = ((ScheduledExecutorService)this.f.get()).schedule(localScheduledDirectTask, paramLong, paramTimeUnit);
      label61:
      localScheduledDirectTask.setFuture(paramRunnable);
      return localScheduledDirectTask;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      io.reactivex.j0.a.r(paramRunnable);
    }
    return EmptyDisposable.INSTANCE;
  }
  
  public c e(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    Object localObject = io.reactivex.j0.a.t(paramRunnable);
    if (paramLong2 <= 0L)
    {
      paramRunnable = (ScheduledExecutorService)this.f.get();
      localObject = new e((Runnable)localObject, paramRunnable);
      if (paramLong1 <= 0L) {}
      try
      {
        paramRunnable = paramRunnable.submit((Callable)localObject);
        break label66;
        paramRunnable = paramRunnable.schedule((Callable)localObject, paramLong1, paramTimeUnit);
        label66:
        ((e)localObject).b(paramRunnable);
        return (c)localObject;
      }
      catch (RejectedExecutionException paramRunnable)
      {
        io.reactivex.j0.a.r(paramRunnable);
        return EmptyDisposable.INSTANCE;
      }
    }
    paramRunnable = new ScheduledDirectPeriodicTask((Runnable)localObject);
    try
    {
      paramRunnable.setFuture(((ScheduledExecutorService)this.f.get()).scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, paramTimeUnit));
      return paramRunnable;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      io.reactivex.j0.a.r(paramRunnable);
    }
    return EmptyDisposable.INSTANCE;
  }
  
  static final class a
    extends w.c
  {
    final ScheduledExecutorService c;
    final b d;
    volatile boolean f;
    
    a(ScheduledExecutorService paramScheduledExecutorService)
    {
      this.c = paramScheduledExecutorService;
      this.d = new b();
    }
    
    public c c(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      if (this.f) {
        return EmptyDisposable.INSTANCE;
      }
      ScheduledRunnable localScheduledRunnable = new ScheduledRunnable(io.reactivex.j0.a.t(paramRunnable), this.d);
      this.d.b(localScheduledRunnable);
      if (paramLong <= 0L) {}
      try
      {
        paramRunnable = this.c.submit(localScheduledRunnable);
        break label74;
        paramRunnable = this.c.schedule(localScheduledRunnable, paramLong, paramTimeUnit);
        label74:
        localScheduledRunnable.setFuture(paramRunnable);
        return localScheduledRunnable;
      }
      catch (RejectedExecutionException paramRunnable)
      {
        dispose();
        io.reactivex.j0.a.r(paramRunnable);
      }
      return EmptyDisposable.INSTANCE;
    }
    
    public void dispose()
    {
      if (!this.f)
      {
        this.f = true;
        this.d.dispose();
      }
    }
    
    public boolean isDisposed()
    {
      return this.f;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */