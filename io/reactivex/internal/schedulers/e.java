package io.reactivex.internal.schedulers;

import io.reactivex.e0.c;
import io.reactivex.h0.a.a;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

final class e
  implements Callable<Void>, c
{
  static final FutureTask<Void> c = new FutureTask(a.b, null);
  final Runnable d;
  final AtomicReference<Future<?>> f;
  final AtomicReference<Future<?>> q;
  final ExecutorService x;
  Thread y;
  
  e(Runnable paramRunnable, ExecutorService paramExecutorService)
  {
    this.d = paramRunnable;
    this.q = new AtomicReference();
    this.f = new AtomicReference();
    this.x = paramExecutorService;
  }
  
  /* Error */
  public Void a()
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 62	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4: putfield 64	io/reactivex/internal/schedulers/e:y	Ljava/lang/Thread;
    //   7: aload_0
    //   8: getfield 43	io/reactivex/internal/schedulers/e:d	Ljava/lang/Runnable;
    //   11: invokeinterface 69 1 0
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 52	io/reactivex/internal/schedulers/e:x	Ljava/util/concurrent/ExecutorService;
    //   21: aload_0
    //   22: invokeinterface 75 2 0
    //   27: invokevirtual 78	io/reactivex/internal/schedulers/e:c	(Ljava/util/concurrent/Future;)V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 64	io/reactivex/internal/schedulers/e:y	Ljava/lang/Thread;
    //   35: goto +13 -> 48
    //   38: astore_1
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 64	io/reactivex/internal/schedulers/e:y	Ljava/lang/Thread;
    //   44: aload_1
    //   45: invokestatic 84	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   48: aconst_null
    //   49: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	e
    //   38	7	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	35	38	finally
  }
  
  void b(Future<?> paramFuture)
  {
    Future localFuture;
    do
    {
      localFuture = (Future)this.q.get();
      if (localFuture == c)
      {
        boolean bool;
        if (this.y != Thread.currentThread()) {
          bool = true;
        } else {
          bool = false;
        }
        paramFuture.cancel(bool);
        return;
      }
    } while (!this.q.compareAndSet(localFuture, paramFuture));
  }
  
  void c(Future<?> paramFuture)
  {
    Future localFuture;
    do
    {
      localFuture = (Future)this.f.get();
      if (localFuture == c)
      {
        boolean bool;
        if (this.y != Thread.currentThread()) {
          bool = true;
        } else {
          bool = false;
        }
        paramFuture.cancel(bool);
        return;
      }
    } while (!this.f.compareAndSet(localFuture, paramFuture));
  }
  
  public void dispose()
  {
    Object localObject = this.q;
    FutureTask localFutureTask = c;
    localObject = (Future)((AtomicReference)localObject).getAndSet(localFutureTask);
    boolean bool1 = true;
    boolean bool2;
    if ((localObject != null) && (localObject != localFutureTask))
    {
      if (this.y != Thread.currentThread()) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      ((Future)localObject).cancel(bool2);
    }
    localObject = (Future)this.f.getAndSet(localFutureTask);
    if ((localObject != null) && (localObject != localFutureTask))
    {
      if (this.y != Thread.currentThread()) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      ((Future)localObject).cancel(bool2);
    }
  }
  
  public boolean isDisposed()
  {
    boolean bool;
    if (this.q.get() == c) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */