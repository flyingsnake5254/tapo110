package io.reactivex.internal.schedulers;

import io.reactivex.e0.c;
import io.reactivex.e0.d;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.j0.a;
import io.reactivex.w;
import io.reactivex.w.c;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
  extends w
{
  private static final l c = new l();
  
  public static l f()
  {
    return c;
  }
  
  public w.c b()
  {
    return new c();
  }
  
  public c c(Runnable paramRunnable)
  {
    a.t(paramRunnable).run();
    return EmptyDisposable.INSTANCE;
  }
  
  public c d(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      paramTimeUnit.sleep(paramLong);
      a.t(paramRunnable).run();
    }
    catch (InterruptedException paramRunnable)
    {
      Thread.currentThread().interrupt();
      a.r(paramRunnable);
    }
    return EmptyDisposable.INSTANCE;
  }
  
  static final class a
    implements Runnable
  {
    private final Runnable c;
    private final l.c d;
    private final long f;
    
    a(Runnable paramRunnable, l.c paramc, long paramLong)
    {
      this.c = paramRunnable;
      this.d = paramc;
      this.f = paramLong;
    }
    
    public void run()
    {
      if (!this.d.q)
      {
        long l1 = this.d.a(TimeUnit.MILLISECONDS);
        long l2 = this.f;
        if (l2 > l1) {
          try
          {
            Thread.sleep(l2 - l1);
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
            a.r(localInterruptedException);
            return;
          }
        }
        if (!this.d.q) {
          this.c.run();
        }
      }
    }
  }
  
  static final class b
    implements Comparable<b>
  {
    final Runnable c;
    final long d;
    final int f;
    volatile boolean q;
    
    b(Runnable paramRunnable, Long paramLong, int paramInt)
    {
      this.c = paramRunnable;
      this.d = paramLong.longValue();
      this.f = paramInt;
    }
    
    public int a(b paramb)
    {
      int i = b.b(this.d, paramb.d);
      if (i == 0) {
        return b.a(this.f, paramb.f);
      }
      return i;
    }
  }
  
  static final class c
    extends w.c
    implements c
  {
    final PriorityBlockingQueue<l.b> c = new PriorityBlockingQueue();
    private final AtomicInteger d = new AtomicInteger();
    final AtomicInteger f = new AtomicInteger();
    volatile boolean q;
    
    public c b(Runnable paramRunnable)
    {
      return e(paramRunnable, a(TimeUnit.MILLISECONDS));
    }
    
    public c c(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      paramLong = a(TimeUnit.MILLISECONDS) + paramTimeUnit.toMillis(paramLong);
      return e(new l.a(paramRunnable, this, paramLong), paramLong);
    }
    
    public void dispose()
    {
      this.q = true;
    }
    
    c e(Runnable paramRunnable, long paramLong)
    {
      if (this.q) {
        return EmptyDisposable.INSTANCE;
      }
      paramRunnable = new l.b(paramRunnable, Long.valueOf(paramLong), this.f.incrementAndGet());
      this.c.add(paramRunnable);
      if (this.d.getAndIncrement() == 0)
      {
        int i = 1;
        for (;;)
        {
          if (this.q)
          {
            this.c.clear();
            return EmptyDisposable.INSTANCE;
          }
          paramRunnable = (l.b)this.c.poll();
          if (paramRunnable == null)
          {
            int j = this.d.addAndGet(-i);
            i = j;
            if (j == 0) {
              return EmptyDisposable.INSTANCE;
            }
          }
          else if (!paramRunnable.q)
          {
            paramRunnable.c.run();
          }
        }
      }
      return d.d(new a(paramRunnable));
    }
    
    public boolean isDisposed()
    {
      return this.q;
    }
    
    final class a
      implements Runnable
    {
      final l.b c;
      
      a(l.b paramb)
      {
        this.c = paramb;
      }
      
      public void run()
      {
        this.c.q = true;
        l.c.this.c.remove(this.c);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */