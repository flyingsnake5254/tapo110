package io.reactivex;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.h;
import io.reactivex.j0.a;
import java.util.concurrent.TimeUnit;

public abstract class w
{
  static boolean a = Boolean.getBoolean("rx2.scheduler.use-nanotime");
  static final long b = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15L).longValue());
  
  static long a(TimeUnit paramTimeUnit)
  {
    if (!a) {
      return paramTimeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
    return paramTimeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
  }
  
  public abstract c b();
  
  public c c(Runnable paramRunnable)
  {
    return d(paramRunnable, 0L, TimeUnit.NANOSECONDS);
  }
  
  public c d(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    c localc = b();
    paramRunnable = new a(a.t(paramRunnable), localc);
    localc.c(paramRunnable, paramLong, paramTimeUnit);
    return paramRunnable;
  }
  
  public c e(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    c localc = b();
    paramRunnable = new b(a.t(paramRunnable), localc);
    paramTimeUnit = localc.d(paramRunnable, paramLong1, paramLong2, paramTimeUnit);
    if (paramTimeUnit == EmptyDisposable.INSTANCE) {
      return paramTimeUnit;
    }
    return paramRunnable;
  }
  
  static final class a
    implements c, Runnable
  {
    final Runnable c;
    final w.c d;
    Thread f;
    
    a(Runnable paramRunnable, w.c paramc)
    {
      this.c = paramRunnable;
      this.d = paramc;
    }
    
    public void dispose()
    {
      if (this.f == Thread.currentThread())
      {
        w.c localc = this.d;
        if ((localc instanceof h))
        {
          ((h)localc).h();
          return;
        }
      }
      this.d.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.d.isDisposed();
    }
    
    public void run()
    {
      this.f = Thread.currentThread();
      try
      {
        this.c.run();
        return;
      }
      finally
      {
        dispose();
        this.f = null;
      }
    }
  }
  
  static final class b
    implements c, Runnable
  {
    final Runnable c;
    final w.c d;
    volatile boolean f;
    
    b(Runnable paramRunnable, w.c paramc)
    {
      this.c = paramRunnable;
      this.d = paramc;
    }
    
    public void dispose()
    {
      this.f = true;
      this.d.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.f;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 30	io/reactivex/w$b:f	Z
      //   4: ifne +34 -> 38
      //   7: aload_0
      //   8: getfield 24	io/reactivex/w$b:c	Ljava/lang/Runnable;
      //   11: invokeinterface 37 1 0
      //   16: goto +22 -> 38
      //   19: astore_1
      //   20: aload_1
      //   21: invokestatic 42	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   24: aload_0
      //   25: getfield 26	io/reactivex/w$b:d	Lio/reactivex/w$c;
      //   28: invokeinterface 32 1 0
      //   33: aload_1
      //   34: invokestatic 48	io/reactivex/internal/util/e:e	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
      //   37: athrow
      //   38: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	39	0	this	b
      //   19	15	1	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   7	16	19	finally
    }
  }
  
  public static abstract class c
    implements c
  {
    public long a(TimeUnit paramTimeUnit)
    {
      return w.a(paramTimeUnit);
    }
    
    public c b(Runnable paramRunnable)
    {
      return c(paramRunnable, 0L, TimeUnit.NANOSECONDS);
    }
    
    public abstract c c(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit);
    
    public c d(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      SequentialDisposable localSequentialDisposable1 = new SequentialDisposable();
      SequentialDisposable localSequentialDisposable2 = new SequentialDisposable(localSequentialDisposable1);
      paramRunnable = a.t(paramRunnable);
      paramLong2 = paramTimeUnit.toNanos(paramLong2);
      long l = a(TimeUnit.NANOSECONDS);
      paramRunnable = c(new a(l + paramTimeUnit.toNanos(paramLong1), paramRunnable, l, localSequentialDisposable2, paramLong2), paramLong1, paramTimeUnit);
      if (paramRunnable == EmptyDisposable.INSTANCE) {
        return paramRunnable;
      }
      localSequentialDisposable1.replace(paramRunnable);
      return localSequentialDisposable2;
    }
    
    final class a
      implements Runnable
    {
      final Runnable c;
      final SequentialDisposable d;
      final long f;
      long q;
      long x;
      long y;
      
      a(long paramLong1, Runnable paramRunnable, long paramLong2, SequentialDisposable paramSequentialDisposable, long paramLong3)
      {
        this.c = paramRunnable;
        this.d = paramSequentialDisposable;
        this.f = paramLong3;
        this.x = paramLong2;
        this.y = paramLong1;
      }
      
      public void run()
      {
        this.c.run();
        if (!this.d.isDisposed())
        {
          w.c localc = w.c.this;
          TimeUnit localTimeUnit = TimeUnit.NANOSECONDS;
          long l1 = localc.a(localTimeUnit);
          long l2 = w.b;
          long l3 = this.x;
          if (l1 + l2 >= l3)
          {
            l4 = this.f;
            if (l1 < l3 + l4 + l2)
            {
              l2 = this.y;
              l3 = this.q + 1L;
              this.q = l3;
              l4 = l2 + l3 * l4;
              break label148;
            }
          }
          l2 = this.f;
          long l4 = l1 + l2;
          l3 = this.q + 1L;
          this.q = l3;
          this.y = (l4 - l2 * l3);
          label148:
          this.x = l1;
          this.d.replace(w.c.this.c(this, l4 - l1, localTimeUnit));
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */