package io.reactivex.internal.schedulers;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.w.c;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class h
  extends w.c
  implements c
{
  private final ScheduledExecutorService c;
  volatile boolean d;
  
  public h(ThreadFactory paramThreadFactory)
  {
    this.c = j.a(paramThreadFactory);
  }
  
  public c b(Runnable paramRunnable)
  {
    return c(paramRunnable, 0L, null);
  }
  
  public c c(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.d) {
      return EmptyDisposable.INSTANCE;
    }
    return e(paramRunnable, paramLong, paramTimeUnit, null);
  }
  
  public void dispose()
  {
    if (!this.d)
    {
      this.d = true;
      this.c.shutdownNow();
    }
  }
  
  public ScheduledRunnable e(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit, io.reactivex.internal.disposables.a parama)
  {
    ScheduledRunnable localScheduledRunnable = new ScheduledRunnable(io.reactivex.j0.a.t(paramRunnable), parama);
    if ((parama != null) && (!parama.b(localScheduledRunnable))) {
      return localScheduledRunnable;
    }
    if (paramLong <= 0L) {}
    try
    {
      paramRunnable = this.c.submit(localScheduledRunnable);
      break label71;
      paramRunnable = this.c.schedule(localScheduledRunnable, paramLong, paramTimeUnit);
      label71:
      localScheduledRunnable.setFuture(paramRunnable);
    }
    catch (RejectedExecutionException paramRunnable)
    {
      if (parama != null) {
        parama.a(localScheduledRunnable);
      }
      io.reactivex.j0.a.r(paramRunnable);
    }
    return localScheduledRunnable;
  }
  
  public c f(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    ScheduledDirectTask localScheduledDirectTask = new ScheduledDirectTask(io.reactivex.j0.a.t(paramRunnable));
    if (paramLong <= 0L) {}
    try
    {
      paramRunnable = this.c.submit(localScheduledDirectTask);
      break label49;
      paramRunnable = this.c.schedule(localScheduledDirectTask, paramLong, paramTimeUnit);
      label49:
      localScheduledDirectTask.setFuture(paramRunnable);
      return localScheduledDirectTask;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      io.reactivex.j0.a.r(paramRunnable);
    }
    return EmptyDisposable.INSTANCE;
  }
  
  public c g(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    paramRunnable = io.reactivex.j0.a.t(paramRunnable);
    if (paramLong2 <= 0L)
    {
      e locale = new e(paramRunnable, this.c);
      if (paramLong1 <= 0L) {}
      try
      {
        paramRunnable = this.c.submit(locale);
        break label62;
        paramRunnable = this.c.schedule(locale, paramLong1, paramTimeUnit);
        label62:
        locale.b(paramRunnable);
        return locale;
      }
      catch (RejectedExecutionException paramRunnable)
      {
        io.reactivex.j0.a.r(paramRunnable);
        return EmptyDisposable.INSTANCE;
      }
    }
    paramRunnable = new ScheduledDirectPeriodicTask(paramRunnable);
    try
    {
      paramRunnable.setFuture(this.c.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, paramTimeUnit));
      return paramRunnable;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      io.reactivex.j0.a.r(paramRunnable);
    }
    return EmptyDisposable.INSTANCE;
  }
  
  public void h()
  {
    if (!this.d)
    {
      this.d = true;
      this.c.shutdown();
    }
  }
  
  public boolean isDisposed()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */