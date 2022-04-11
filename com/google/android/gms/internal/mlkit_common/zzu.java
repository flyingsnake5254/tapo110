package com.google.android.gms.internal.mlkit_common;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class zzu
  extends zzj
  implements ExecutorService
{
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return zzb().awaitTermination(paramLong, paramTimeUnit);
  }
  
  public void execute(Runnable paramRunnable)
  {
    zzb().execute(paramRunnable);
  }
  
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection)
    throws InterruptedException
  {
    return zzb().invokeAll(paramCollection);
  }
  
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return zzb().invokeAll(paramCollection, paramLong, paramTimeUnit);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection)
    throws InterruptedException, ExecutionException
  {
    return (T)zzb().invokeAny(paramCollection);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return (T)zzb().invokeAny(paramCollection, paramLong, paramTimeUnit);
  }
  
  public boolean isShutdown()
  {
    return zzb().isShutdown();
  }
  
  public boolean isTerminated()
  {
    return zzb().isTerminated();
  }
  
  public void shutdown()
  {
    zzb().shutdown();
  }
  
  public List<Runnable> shutdownNow()
  {
    return zzb().shutdownNow();
  }
  
  public Future<?> submit(Runnable paramRunnable)
  {
    return zzb().submit(paramRunnable);
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    return zzb().submit(paramRunnable, paramT);
  }
  
  public <T> Future<T> submit(Callable<T> paramCallable)
  {
    return zzb().submit(paramCallable);
  }
  
  protected abstract ExecutorService zzb();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */