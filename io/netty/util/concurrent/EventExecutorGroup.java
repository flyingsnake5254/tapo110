package io.netty.util.concurrent;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract interface EventExecutorGroup
  extends ScheduledExecutorService, Iterable<EventExecutor>
{
  public abstract boolean isShuttingDown();
  
  public abstract Iterator<EventExecutor> iterator();
  
  public abstract EventExecutor next();
  
  public abstract c<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit);
  
  public abstract <V> c<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit);
  
  public abstract c<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit);
  
  public abstract c<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit);
  
  @Deprecated
  public abstract void shutdown();
  
  public abstract Future<?> shutdownGracefully();
  
  public abstract Future<?> shutdownGracefully(long paramLong1, long paramLong2, TimeUnit paramTimeUnit);
  
  @Deprecated
  public abstract List<Runnable> shutdownNow();
  
  public abstract Future<?> submit(Runnable paramRunnable);
  
  public abstract <T> Future<T> submit(Runnable paramRunnable, T paramT);
  
  public abstract <T> Future<T> submit(Callable<T> paramCallable);
  
  public abstract Future<?> terminationFuture();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\EventExecutorGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */