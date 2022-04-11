package io.reactivex.internal.schedulers;

import io.reactivex.e0.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.w;
import io.reactivex.w.c;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class d
  extends w
{
  static final w c = ;
  final boolean d;
  final Executor e;
  
  public d(Executor paramExecutor, boolean paramBoolean)
  {
    this.e = paramExecutor;
    this.d = paramBoolean;
  }
  
  public w.c b()
  {
    return new c(this.e, this.d);
  }
  
  public io.reactivex.e0.c c(Runnable paramRunnable)
  {
    paramRunnable = io.reactivex.j0.a.t(paramRunnable);
    try
    {
      if ((this.e instanceof ExecutorService))
      {
        localObject = new io/reactivex/internal/schedulers/ScheduledDirectTask;
        ((ScheduledDirectTask)localObject).<init>(paramRunnable);
        ((a)localObject).setFuture(((ExecutorService)this.e).submit((Callable)localObject));
        return (io.reactivex.e0.c)localObject;
      }
      if (this.d)
      {
        localObject = new io/reactivex/internal/schedulers/d$c$b;
        ((d.c.b)localObject).<init>(paramRunnable, null);
        this.e.execute((Runnable)localObject);
        return (io.reactivex.e0.c)localObject;
      }
      Object localObject = new io/reactivex/internal/schedulers/d$c$a;
      ((d.c.a)localObject).<init>(paramRunnable);
      this.e.execute((Runnable)localObject);
      return (io.reactivex.e0.c)localObject;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      io.reactivex.j0.a.r(paramRunnable);
    }
    return EmptyDisposable.INSTANCE;
  }
  
  public io.reactivex.e0.c d(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    paramRunnable = io.reactivex.j0.a.t(paramRunnable);
    if ((this.e instanceof ScheduledExecutorService)) {
      try
      {
        ScheduledDirectTask localScheduledDirectTask = new io/reactivex/internal/schedulers/ScheduledDirectTask;
        localScheduledDirectTask.<init>(paramRunnable);
        localScheduledDirectTask.setFuture(((ScheduledExecutorService)this.e).schedule(localScheduledDirectTask, paramLong, paramTimeUnit));
        return localScheduledDirectTask;
      }
      catch (RejectedExecutionException paramRunnable)
      {
        io.reactivex.j0.a.r(paramRunnable);
        return EmptyDisposable.INSTANCE;
      }
    }
    paramRunnable = new b(paramRunnable);
    paramTimeUnit = c.d(new a(paramRunnable), paramLong, paramTimeUnit);
    paramRunnable.c.replace(paramTimeUnit);
    return paramRunnable;
  }
  
  public io.reactivex.e0.c e(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    if ((this.e instanceof ScheduledExecutorService))
    {
      paramRunnable = io.reactivex.j0.a.t(paramRunnable);
      try
      {
        ScheduledDirectPeriodicTask localScheduledDirectPeriodicTask = new io/reactivex/internal/schedulers/ScheduledDirectPeriodicTask;
        localScheduledDirectPeriodicTask.<init>(paramRunnable);
        localScheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService)this.e).scheduleAtFixedRate(localScheduledDirectPeriodicTask, paramLong1, paramLong2, paramTimeUnit));
        return localScheduledDirectPeriodicTask;
      }
      catch (RejectedExecutionException paramRunnable)
      {
        io.reactivex.j0.a.r(paramRunnable);
        return EmptyDisposable.INSTANCE;
      }
    }
    return super.e(paramRunnable, paramLong1, paramLong2, paramTimeUnit);
  }
  
  final class a
    implements Runnable
  {
    private final d.b c;
    
    a(d.b paramb)
    {
      this.c = paramb;
    }
    
    public void run()
    {
      d.b localb = this.c;
      localb.d.replace(d.this.c(localb));
    }
  }
  
  static final class b
    extends AtomicReference<Runnable>
    implements Runnable, io.reactivex.e0.c
  {
    final SequentialDisposable c = new SequentialDisposable();
    final SequentialDisposable d = new SequentialDisposable();
    
    b(Runnable paramRunnable)
    {
      super();
    }
    
    public void dispose()
    {
      if (getAndSet(null) != null)
      {
        this.c.dispose();
        this.d.dispose();
      }
    }
    
    public boolean isDisposed()
    {
      boolean bool;
      if (get() == null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 43	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   4: checkcast 7	java/lang/Runnable
      //   7: astore_1
      //   8: aload_1
      //   9: ifnull +67 -> 76
      //   12: aload_1
      //   13: invokeinterface 46 1 0
      //   18: aload_0
      //   19: aconst_null
      //   20: invokevirtual 49	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
      //   23: aload_0
      //   24: getfield 27	io/reactivex/internal/schedulers/d$b:c	Lio/reactivex/internal/disposables/SequentialDisposable;
      //   27: astore_2
      //   28: getstatic 55	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
      //   31: astore_1
      //   32: aload_2
      //   33: aload_1
      //   34: invokevirtual 49	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
      //   37: aload_0
      //   38: getfield 29	io/reactivex/internal/schedulers/d$b:d	Lio/reactivex/internal/disposables/SequentialDisposable;
      //   41: aload_1
      //   42: invokevirtual 49	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
      //   45: goto +31 -> 76
      //   48: astore_1
      //   49: aload_0
      //   50: aconst_null
      //   51: invokevirtual 49	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
      //   54: aload_0
      //   55: getfield 27	io/reactivex/internal/schedulers/d$b:c	Lio/reactivex/internal/disposables/SequentialDisposable;
      //   58: getstatic 55	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
      //   61: invokevirtual 49	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
      //   64: aload_0
      //   65: getfield 29	io/reactivex/internal/schedulers/d$b:d	Lio/reactivex/internal/disposables/SequentialDisposable;
      //   68: getstatic 55	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
      //   71: invokevirtual 49	java/util/concurrent/atomic/AtomicReference:lazySet	(Ljava/lang/Object;)V
      //   74: aload_1
      //   75: athrow
      //   76: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	77	0	this	b
      //   7	35	1	localObject1	Object
      //   48	27	1	localObject2	Object
      //   27	6	2	localSequentialDisposable	SequentialDisposable
      // Exception table:
      //   from	to	target	type
      //   12	18	48	finally
    }
  }
  
  public static final class c
    extends w.c
    implements Runnable
  {
    final boolean c;
    final Executor d;
    final io.reactivex.internal.queue.a<Runnable> f;
    volatile boolean q;
    final AtomicInteger x = new AtomicInteger();
    final b y = new b();
    
    public c(Executor paramExecutor, boolean paramBoolean)
    {
      this.d = paramExecutor;
      this.f = new io.reactivex.internal.queue.a();
      this.c = paramBoolean;
    }
    
    public io.reactivex.e0.c b(Runnable paramRunnable)
    {
      if (this.q) {
        return EmptyDisposable.INSTANCE;
      }
      paramRunnable = io.reactivex.j0.a.t(paramRunnable);
      if (this.c)
      {
        paramRunnable = new b(paramRunnable, this.y);
        this.y.b(paramRunnable);
      }
      else
      {
        paramRunnable = new a(paramRunnable);
      }
      this.f.offer(paramRunnable);
      if (this.x.getAndIncrement() == 0) {
        try
        {
          this.d.execute(this);
        }
        catch (RejectedExecutionException paramRunnable)
        {
          this.q = true;
          this.f.clear();
          io.reactivex.j0.a.r(paramRunnable);
          return EmptyDisposable.INSTANCE;
        }
      }
      return paramRunnable;
    }
    
    public io.reactivex.e0.c c(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong <= 0L) {
        return b(paramRunnable);
      }
      if (this.q) {
        return EmptyDisposable.INSTANCE;
      }
      SequentialDisposable localSequentialDisposable1 = new SequentialDisposable();
      SequentialDisposable localSequentialDisposable2 = new SequentialDisposable(localSequentialDisposable1);
      ScheduledRunnable localScheduledRunnable = new ScheduledRunnable(new c(localSequentialDisposable2, io.reactivex.j0.a.t(paramRunnable)), this.y);
      this.y.b(localScheduledRunnable);
      paramRunnable = this.d;
      if ((paramRunnable instanceof ScheduledExecutorService)) {
        try
        {
          localScheduledRunnable.setFuture(((ScheduledExecutorService)paramRunnable).schedule(localScheduledRunnable, paramLong, paramTimeUnit));
        }
        catch (RejectedExecutionException paramRunnable)
        {
          this.q = true;
          io.reactivex.j0.a.r(paramRunnable);
          return EmptyDisposable.INSTANCE;
        }
      } else {
        localScheduledRunnable.setFuture(new c(d.c.d(localScheduledRunnable, paramLong, paramTimeUnit)));
      }
      localSequentialDisposable1.replace(localScheduledRunnable);
      return localSequentialDisposable2;
    }
    
    public void dispose()
    {
      if (!this.q)
      {
        this.q = true;
        this.y.dispose();
        if (this.x.getAndIncrement() == 0) {
          this.f.clear();
        }
      }
    }
    
    public boolean isDisposed()
    {
      return this.q;
    }
    
    public void run()
    {
      io.reactivex.internal.queue.a locala = this.f;
      int i = 1;
      if (this.q)
      {
        locala.clear();
        return;
      }
      do
      {
        Runnable localRunnable = (Runnable)locala.poll();
        if (localRunnable == null)
        {
          if (this.q)
          {
            locala.clear();
            return;
          }
          int j = this.x.addAndGet(-i);
          i = j;
          if (j != 0) {
            break;
          }
          return;
        }
        localRunnable.run();
      } while (!this.q);
      locala.clear();
    }
    
    static final class a
      extends AtomicBoolean
      implements Runnable, io.reactivex.e0.c
    {
      final Runnable c;
      
      a(Runnable paramRunnable)
      {
        this.c = paramRunnable;
      }
      
      public void dispose()
      {
        lazySet(true);
      }
      
      public boolean isDisposed()
      {
        return get();
      }
      
      public void run()
      {
        if (get()) {
          return;
        }
        try
        {
          this.c.run();
          return;
        }
        finally
        {
          lazySet(true);
        }
      }
    }
    
    static final class b
      extends AtomicInteger
      implements Runnable, io.reactivex.e0.c
    {
      final Runnable c;
      final io.reactivex.internal.disposables.a d;
      volatile Thread f;
      
      b(Runnable paramRunnable, io.reactivex.internal.disposables.a parama)
      {
        this.c = paramRunnable;
        this.d = parama;
      }
      
      void a()
      {
        io.reactivex.internal.disposables.a locala = this.d;
        if (locala != null) {
          locala.c(this);
        }
      }
      
      public void dispose()
      {
        do
        {
          do
          {
            int i = get();
            if (i >= 2) {
              return;
            }
            if (i != 0) {
              break;
            }
          } while (!compareAndSet(0, 4));
          a();
          break;
        } while (!compareAndSet(1, 3));
        Thread localThread = this.f;
        if (localThread != null)
        {
          localThread.interrupt();
          this.f = null;
        }
        set(4);
        a();
      }
      
      public boolean isDisposed()
      {
        boolean bool;
        if (get() >= 2) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 40	java/util/concurrent/atomic/AtomicInteger:get	()I
        //   4: ifne +117 -> 121
        //   7: aload_0
        //   8: invokestatic 64	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   11: putfield 48	io/reactivex/internal/schedulers/d$c$b:f	Ljava/lang/Thread;
        //   14: aload_0
        //   15: iconst_0
        //   16: iconst_1
        //   17: invokevirtual 44	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
        //   20: ifeq +96 -> 116
        //   23: aload_0
        //   24: getfield 26	io/reactivex/internal/schedulers/d$c$b:c	Ljava/lang/Runnable;
        //   27: invokeinterface 66 1 0
        //   32: aload_0
        //   33: aconst_null
        //   34: putfield 48	io/reactivex/internal/schedulers/d$c$b:f	Ljava/lang/Thread;
        //   37: aload_0
        //   38: iconst_1
        //   39: iconst_2
        //   40: invokevirtual 44	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
        //   43: ifeq +10 -> 53
        //   46: aload_0
        //   47: invokevirtual 46	io/reactivex/internal/schedulers/d$c$b:a	()V
        //   50: goto +71 -> 121
        //   53: aload_0
        //   54: invokevirtual 40	java/util/concurrent/atomic/AtomicInteger:get	()I
        //   57: iconst_3
        //   58: if_icmpne +9 -> 67
        //   61: invokestatic 69	java/lang/Thread:yield	()V
        //   64: goto -11 -> 53
        //   67: invokestatic 72	java/lang/Thread:interrupted	()Z
        //   70: pop
        //   71: goto +50 -> 121
        //   74: astore_1
        //   75: aload_0
        //   76: aconst_null
        //   77: putfield 48	io/reactivex/internal/schedulers/d$c$b:f	Ljava/lang/Thread;
        //   80: aload_0
        //   81: iconst_1
        //   82: iconst_2
        //   83: invokevirtual 44	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
        //   86: ifne +24 -> 110
        //   89: aload_0
        //   90: invokevirtual 40	java/util/concurrent/atomic/AtomicInteger:get	()I
        //   93: iconst_3
        //   94: if_icmpne +9 -> 103
        //   97: invokestatic 69	java/lang/Thread:yield	()V
        //   100: goto -11 -> 89
        //   103: invokestatic 72	java/lang/Thread:interrupted	()Z
        //   106: pop
        //   107: goto +7 -> 114
        //   110: aload_0
        //   111: invokevirtual 46	io/reactivex/internal/schedulers/d$c$b:a	()V
        //   114: aload_1
        //   115: athrow
        //   116: aload_0
        //   117: aconst_null
        //   118: putfield 48	io/reactivex/internal/schedulers/d$c$b:f	Ljava/lang/Thread;
        //   121: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	122	0	this	b
        //   74	41	1	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   23	32	74	finally
      }
    }
    
    final class c
      implements Runnable
    {
      private final SequentialDisposable c;
      private final Runnable d;
      
      c(SequentialDisposable paramSequentialDisposable, Runnable paramRunnable)
      {
        this.c = paramSequentialDisposable;
        this.d = paramRunnable;
      }
      
      public void run()
      {
        this.c.replace(d.c.this.b(this.d));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */