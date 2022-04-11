package io.netty.util.concurrent;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class UnorderedThreadPoolEventExecutor
  extends ScheduledThreadPoolExecutor
  implements EventExecutor
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(UnorderedThreadPoolEventExecutor.class);
  private final Set<EventExecutor> executorSet = Collections.singleton(this);
  private final Promise<?> terminationFuture = GlobalEventExecutor.INSTANCE.newPromise();
  
  public UnorderedThreadPoolEventExecutor(int paramInt)
  {
    this(paramInt, new DefaultThreadFactory(UnorderedThreadPoolEventExecutor.class));
  }
  
  public UnorderedThreadPoolEventExecutor(int paramInt, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    this(paramInt, new DefaultThreadFactory(UnorderedThreadPoolEventExecutor.class), paramRejectedExecutionHandler);
  }
  
  public UnorderedThreadPoolEventExecutor(int paramInt, ThreadFactory paramThreadFactory)
  {
    super(paramInt, paramThreadFactory);
  }
  
  public UnorderedThreadPoolEventExecutor(int paramInt, ThreadFactory paramThreadFactory, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramInt, paramThreadFactory, paramRejectedExecutionHandler);
  }
  
  protected <V> RunnableScheduledFuture<V> decorateTask(Runnable paramRunnable, RunnableScheduledFuture<V> paramRunnableScheduledFuture)
  {
    if (!(paramRunnable instanceof NonNotifyRunnable)) {
      paramRunnableScheduledFuture = new RunnableScheduledFutureTask(this, paramRunnable, paramRunnableScheduledFuture);
    }
    return paramRunnableScheduledFuture;
  }
  
  protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> paramCallable, RunnableScheduledFuture<V> paramRunnableScheduledFuture)
  {
    return new RunnableScheduledFutureTask(this, paramCallable, paramRunnableScheduledFuture);
  }
  
  public void execute(Runnable paramRunnable)
  {
    super.schedule(new NonNotifyRunnable(paramRunnable), 0L, TimeUnit.NANOSECONDS);
  }
  
  public boolean inEventLoop()
  {
    return false;
  }
  
  public boolean inEventLoop(Thread paramThread)
  {
    return false;
  }
  
  public boolean isShuttingDown()
  {
    return isShutdown();
  }
  
  public Iterator<EventExecutor> iterator()
  {
    return this.executorSet.iterator();
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
  
  public EventExecutor next()
  {
    return this;
  }
  
  public EventExecutorGroup parent()
  {
    return this;
  }
  
  public c<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return (c)super.schedule(paramRunnable, paramLong, paramTimeUnit);
  }
  
  public <V> c<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    return (c)super.schedule(paramCallable, paramLong, paramTimeUnit);
  }
  
  public c<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return (c)super.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, paramTimeUnit);
  }
  
  public c<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return (c)super.scheduleWithFixedDelay(paramRunnable, paramLong1, paramLong2, paramTimeUnit);
  }
  
  public void shutdown()
  {
    super.shutdown();
    this.terminationFuture.trySuccess(null);
  }
  
  public Future<?> shutdownGracefully()
  {
    return shutdownGracefully(2L, 15L, TimeUnit.SECONDS);
  }
  
  public Future<?> shutdownGracefully(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    shutdown();
    return terminationFuture();
  }
  
  public List<Runnable> shutdownNow()
  {
    List localList = super.shutdownNow();
    this.terminationFuture.trySuccess(null);
    return localList;
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
  
  public Future<?> terminationFuture()
  {
    return this.terminationFuture;
  }
  
  private static final class NonNotifyRunnable
    implements Runnable
  {
    private final Runnable task;
    
    NonNotifyRunnable(Runnable paramRunnable)
    {
      this.task = paramRunnable;
    }
    
    public void run()
    {
      this.task.run();
    }
  }
  
  private static final class RunnableScheduledFutureTask<V>
    extends PromiseTask<V>
    implements RunnableScheduledFuture<V>, c<V>
  {
    private final RunnableScheduledFuture<V> future;
    
    RunnableScheduledFutureTask(EventExecutor paramEventExecutor, Runnable paramRunnable, RunnableScheduledFuture<V> paramRunnableScheduledFuture)
    {
      super(paramRunnable);
      this.future = paramRunnableScheduledFuture;
    }
    
    RunnableScheduledFutureTask(EventExecutor paramEventExecutor, Callable<V> paramCallable, RunnableScheduledFuture<V> paramRunnableScheduledFuture)
    {
      super(paramCallable);
      this.future = paramRunnableScheduledFuture;
    }
    
    public int compareTo(Delayed paramDelayed)
    {
      return this.future.compareTo(paramDelayed);
    }
    
    public long getDelay(TimeUnit paramTimeUnit)
    {
      return this.future.getDelay(paramTimeUnit);
    }
    
    public boolean isPeriodic()
    {
      return this.future.isPeriodic();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 50	io/netty/util/concurrent/UnorderedThreadPoolEventExecutor$RunnableScheduledFutureTask:isPeriodic	()Z
      //   4: ifne +10 -> 14
      //   7: aload_0
      //   8: invokespecial 52	io/netty/util/concurrent/PromiseTask:run	()V
      //   11: goto +38 -> 49
      //   14: aload_0
      //   15: invokevirtual 57	io/netty/util/concurrent/DefaultPromise:isDone	()Z
      //   18: ifne +31 -> 49
      //   21: aload_0
      //   22: invokevirtual 61	io/netty/util/concurrent/PromiseTask:runTask	()Ljava/lang/Object;
      //   25: pop
      //   26: goto +23 -> 49
      //   29: astore_1
      //   30: aload_0
      //   31: aload_1
      //   32: invokevirtual 65	io/netty/util/concurrent/PromiseTask:tryFailureInternal	(Ljava/lang/Throwable;)Z
      //   35: ifne +14 -> 49
      //   38: invokestatic 69	io/netty/util/concurrent/UnorderedThreadPoolEventExecutor:access$000	()Lio/netty/util/internal/logging/InternalLogger;
      //   41: ldc 71
      //   43: aload_1
      //   44: invokeinterface 77 3 0
      //   49: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	50	0	this	RunnableScheduledFutureTask
      //   29	15	1	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   21	26	29	finally
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\UnorderedThreadPoolEventExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */