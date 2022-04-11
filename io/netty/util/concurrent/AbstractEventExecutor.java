package io.netty.util.concurrent;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

public abstract class AbstractEventExecutor
  extends AbstractExecutorService
  implements EventExecutor
{
  static final long DEFAULT_SHUTDOWN_QUIET_PERIOD = 2L;
  static final long DEFAULT_SHUTDOWN_TIMEOUT = 15L;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractEventExecutor.class);
  private final EventExecutorGroup parent;
  private final Collection<EventExecutor> selfCollection = Collections.singleton(this);
  
  protected AbstractEventExecutor()
  {
    this(null);
  }
  
  protected AbstractEventExecutor(EventExecutorGroup paramEventExecutorGroup)
  {
    this.parent = paramEventExecutorGroup;
  }
  
  /* Error */
  protected static void safeExecute(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 54 1 0
    //   6: goto +16 -> 22
    //   9: astore_1
    //   10: getstatic 30	io/netty/util/concurrent/AbstractEventExecutor:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   13: ldc 56
    //   15: aload_0
    //   16: aload_1
    //   17: invokeinterface 62 4 0
    //   22: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	23	0	paramRunnable	Runnable
    //   9	8	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	6	9	finally
  }
  
  public boolean inEventLoop()
  {
    return inEventLoop(Thread.currentThread());
  }
  
  public Iterator<EventExecutor> iterator()
  {
    return this.selfCollection.iterator();
  }
  
  public void lazyExecute(Runnable paramRunnable)
  {
    execute(paramRunnable);
  }
  
  public <V> Future<V> newFailedFuture(Throwable paramThrowable)
  {
    return new FailedFuture(this, paramThrowable);
  }
  
  public <V> ProgressivePromise<V> newProgressivePromise()
  {
    return new DefaultProgressivePromise(this);
  }
  
  public <V> Promise<V> newPromise()
  {
    return new DefaultPromise(this);
  }
  
  public <V> Future<V> newSucceededFuture(V paramV)
  {
    return new SucceededFuture(this, paramV);
  }
  
  protected final <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return new PromiseTask(this, paramRunnable, paramT);
  }
  
  protected final <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable)
  {
    return new PromiseTask(this, paramCallable);
  }
  
  public EventExecutor next()
  {
    return this;
  }
  
  public EventExecutorGroup parent()
  {
    return this.parent;
  }
  
  public c<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public <V> c<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public c<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public c<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public abstract void shutdown();
  
  public Future<?> shutdownGracefully()
  {
    return shutdownGracefully(2L, 15L, TimeUnit.SECONDS);
  }
  
  @Deprecated
  public List<Runnable> shutdownNow()
  {
    shutdown();
    return Collections.emptyList();
  }
  
  public Future<?> submit(Runnable paramRunnable)
  {
    return (Future)super.submit(paramRunnable);
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    return (Future)super.submit(paramRunnable, paramT);
  }
  
  public <T> Future<T> submit(Callable<T> paramCallable)
  {
    return (Future)super.submit(paramCallable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\AbstractEventExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */