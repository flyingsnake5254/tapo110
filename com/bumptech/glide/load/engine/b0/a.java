package com.bumptech.glide.load.engine.b0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class a
  implements ExecutorService
{
  private static final long c = TimeUnit.SECONDS.toMillis(10L);
  private static volatile int d;
  private final ExecutorService f;
  
  @VisibleForTesting
  a(ExecutorService paramExecutorService)
  {
    this.f = paramExecutorService;
  }
  
  public static int a()
  {
    if (d == 0) {
      d = Math.min(4, b.a());
    }
    return d;
  }
  
  public static a b()
  {
    int i;
    if (a() >= 4) {
      i = 2;
    } else {
      i = 1;
    }
    return new a(true).c(i).b("animation");
  }
  
  public static a c()
  {
    return b().a();
  }
  
  public static a d()
  {
    return new a(true).c(1).b("disk-cache");
  }
  
  public static a e()
  {
    return d().a();
  }
  
  public static a f()
  {
    return new a(false).c(a()).b("source");
  }
  
  public static a g()
  {
    return f().a();
  }
  
  public static a h()
  {
    return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, c, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b("source-unlimited", c.d, false)));
  }
  
  public boolean awaitTermination(long paramLong, @NonNull TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.f.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    this.f.execute(paramRunnable);
  }
  
  @NonNull
  public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> paramCollection)
    throws InterruptedException
  {
    return this.f.invokeAll(paramCollection);
  }
  
  @NonNull
  public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> paramCollection, long paramLong, @NonNull TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.f.invokeAll(paramCollection, paramLong, paramTimeUnit);
  }
  
  @NonNull
  public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> paramCollection)
    throws InterruptedException, ExecutionException
  {
    return (T)this.f.invokeAny(paramCollection);
  }
  
  public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> paramCollection, long paramLong, @NonNull TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return (T)this.f.invokeAny(paramCollection, paramLong, paramTimeUnit);
  }
  
  public boolean isShutdown()
  {
    return this.f.isShutdown();
  }
  
  public boolean isTerminated()
  {
    return this.f.isTerminated();
  }
  
  public void shutdown()
  {
    this.f.shutdown();
  }
  
  @NonNull
  public List<Runnable> shutdownNow()
  {
    return this.f.shutdownNow();
  }
  
  @NonNull
  public Future<?> submit(@NonNull Runnable paramRunnable)
  {
    return this.f.submit(paramRunnable);
  }
  
  @NonNull
  public <T> Future<T> submit(@NonNull Runnable paramRunnable, T paramT)
  {
    return this.f.submit(paramRunnable, paramT);
  }
  
  public <T> Future<T> submit(@NonNull Callable<T> paramCallable)
  {
    return this.f.submit(paramCallable);
  }
  
  public String toString()
  {
    return this.f.toString();
  }
  
  public static final class a
  {
    private final boolean a;
    private int b;
    private int c;
    @NonNull
    private a.c d = a.c.d;
    private String e;
    private long f;
    
    a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public a a()
    {
      if (!TextUtils.isEmpty(this.e))
      {
        localObject = new ThreadPoolExecutor(this.b, this.c, this.f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a.b(this.e, this.d, this.a));
        if (this.f != 0L) {
          ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
        }
        return new a((ExecutorService)localObject);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Name must be non-null and non-empty, but given: ");
      ((StringBuilder)localObject).append(this.e);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public a b(String paramString)
    {
      this.e = paramString;
      return this;
    }
    
    public a c(@IntRange(from=1L) int paramInt)
    {
      this.b = paramInt;
      this.c = paramInt;
      return this;
    }
  }
  
  private static final class b
    implements ThreadFactory
  {
    private final String c;
    final a.c d;
    final boolean f;
    private int q;
    
    b(String paramString, a.c paramc, boolean paramBoolean)
    {
      this.c = paramString;
      this.d = paramc;
      this.f = paramBoolean;
    }
    
    public Thread newThread(@NonNull Runnable paramRunnable)
    {
      try
      {
        a locala = new com/bumptech/glide/load/engine/b0/a$b$a;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("glide-");
        localStringBuilder.append(this.c);
        localStringBuilder.append("-thread-");
        localStringBuilder.append(this.q);
        locala.<init>(this, paramRunnable, localStringBuilder.toString());
        this.q += 1;
        return locala;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
    
    class a
      extends Thread
    {
      a(Runnable paramRunnable, String paramString)
      {
        super(paramString);
      }
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: bipush 9
        //   2: invokestatic 30	android/os/Process:setThreadPriority	(I)V
        //   5: aload_0
        //   6: getfield 18	com/bumptech/glide/load/engine/b0/a$b$a:c	Lcom/bumptech/glide/load/engine/b0/a$b;
        //   9: getfield 34	com/bumptech/glide/load/engine/b0/a$b:f	Z
        //   12: ifeq +22 -> 34
        //   15: new 36	android/os/StrictMode$ThreadPolicy$Builder
        //   18: dup
        //   19: invokespecial 38	android/os/StrictMode$ThreadPolicy$Builder:<init>	()V
        //   22: invokevirtual 42	android/os/StrictMode$ThreadPolicy$Builder:detectNetwork	()Landroid/os/StrictMode$ThreadPolicy$Builder;
        //   25: invokevirtual 45	android/os/StrictMode$ThreadPolicy$Builder:penaltyDeath	()Landroid/os/StrictMode$ThreadPolicy$Builder;
        //   28: invokevirtual 49	android/os/StrictMode$ThreadPolicy$Builder:build	()Landroid/os/StrictMode$ThreadPolicy;
        //   31: invokestatic 55	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
        //   34: aload_0
        //   35: invokespecial 57	java/lang/Thread:run	()V
        //   38: goto +17 -> 55
        //   41: astore_1
        //   42: aload_0
        //   43: getfield 18	com/bumptech/glide/load/engine/b0/a$b$a:c	Lcom/bumptech/glide/load/engine/b0/a$b;
        //   46: getfield 61	com/bumptech/glide/load/engine/b0/a$b:d	Lcom/bumptech/glide/load/engine/b0/a$c;
        //   49: aload_1
        //   50: invokeinterface 67 2 0
        //   55: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	56	0	this	a
        //   41	9	1	localThrowable	Throwable
        // Exception table:
        //   from	to	target	type
        //   34	38	41	finally
      }
    }
  }
  
  public static abstract interface c
  {
    public static final c a = new a();
    public static final c b;
    public static final c c;
    public static final c d;
    
    static
    {
      b localb = new b();
      b = localb;
      c = new c();
      d = localb;
    }
    
    public abstract void a(Throwable paramThrowable);
    
    class a
      implements a.c
    {
      public void a(Throwable paramThrowable) {}
    }
    
    class b
      implements a.c
    {
      public void a(Throwable paramThrowable)
      {
        if ((paramThrowable != null) && (Log.isLoggable("GlideExecutor", 6))) {
          Log.e("GlideExecutor", "Request threw uncaught throwable", paramThrowable);
        }
      }
    }
    
    class c
      implements a.c
    {
      public void a(Throwable paramThrowable)
      {
        if (paramThrowable == null) {
          return;
        }
        throw new RuntimeException("Request threw uncaught throwable", paramThrowable);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\b0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */