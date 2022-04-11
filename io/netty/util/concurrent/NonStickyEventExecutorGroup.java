package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public final class NonStickyEventExecutorGroup
  implements EventExecutorGroup
{
  private final EventExecutorGroup group;
  private final int maxTaskExecutePerRun;
  
  public NonStickyEventExecutorGroup(EventExecutorGroup paramEventExecutorGroup)
  {
    this(paramEventExecutorGroup, 1024);
  }
  
  public NonStickyEventExecutorGroup(EventExecutorGroup paramEventExecutorGroup, int paramInt)
  {
    this.group = verify(paramEventExecutorGroup);
    this.maxTaskExecutePerRun = ObjectUtil.checkPositive(paramInt, "maxTaskExecutePerRun");
  }
  
  private NonStickyOrderedEventExecutor newExecutor(EventExecutor paramEventExecutor)
  {
    return new NonStickyOrderedEventExecutor(paramEventExecutor, this.maxTaskExecutePerRun);
  }
  
  private static EventExecutorGroup verify(EventExecutorGroup paramEventExecutorGroup)
  {
    Object localObject = ((EventExecutorGroup)ObjectUtil.checkNotNull(paramEventExecutorGroup, "group")).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EventExecutor localEventExecutor = (EventExecutor)((Iterator)localObject).next();
      if ((localEventExecutor instanceof b))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("EventExecutorGroup ");
        ((StringBuilder)localObject).append(paramEventExecutorGroup);
        ((StringBuilder)localObject).append(" contains OrderedEventExecutors: ");
        ((StringBuilder)localObject).append(localEventExecutor);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    return paramEventExecutorGroup;
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.group.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.group.execute(paramRunnable);
  }
  
  public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection)
    throws InterruptedException
  {
    return this.group.invokeAll(paramCollection);
  }
  
  public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.group.invokeAll(paramCollection, paramLong, paramTimeUnit);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection)
    throws InterruptedException, ExecutionException
  {
    return (T)this.group.invokeAny(paramCollection);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return (T)this.group.invokeAny(paramCollection, paramLong, paramTimeUnit);
  }
  
  public boolean isShutdown()
  {
    return this.group.isShutdown();
  }
  
  public boolean isShuttingDown()
  {
    return this.group.isShuttingDown();
  }
  
  public boolean isTerminated()
  {
    return this.group.isTerminated();
  }
  
  public Iterator<EventExecutor> iterator()
  {
    new Iterator()
    {
      public boolean hasNext()
      {
        return this.val$itr.hasNext();
      }
      
      public EventExecutor next()
      {
        return NonStickyEventExecutorGroup.this.newExecutor((EventExecutor)this.val$itr.next());
      }
      
      public void remove()
      {
        this.val$itr.remove();
      }
    };
  }
  
  public EventExecutor next()
  {
    return newExecutor(this.group.next());
  }
  
  public c<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.group.schedule(paramRunnable, paramLong, paramTimeUnit);
  }
  
  public <V> c<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.group.schedule(paramCallable, paramLong, paramTimeUnit);
  }
  
  public c<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return this.group.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, paramTimeUnit);
  }
  
  public c<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return this.group.scheduleWithFixedDelay(paramRunnable, paramLong1, paramLong2, paramTimeUnit);
  }
  
  public void shutdown()
  {
    this.group.shutdown();
  }
  
  public Future<?> shutdownGracefully()
  {
    return this.group.shutdownGracefully();
  }
  
  public Future<?> shutdownGracefully(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return this.group.shutdownGracefully(paramLong1, paramLong2, paramTimeUnit);
  }
  
  public List<Runnable> shutdownNow()
  {
    return this.group.shutdownNow();
  }
  
  public Future<?> submit(Runnable paramRunnable)
  {
    return this.group.submit(paramRunnable);
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    return this.group.submit(paramRunnable, paramT);
  }
  
  public <T> Future<T> submit(Callable<T> paramCallable)
  {
    return this.group.submit(paramCallable);
  }
  
  public Future<?> terminationFuture()
  {
    return this.group.terminationFuture();
  }
  
  private static final class NonStickyOrderedEventExecutor
    extends AbstractEventExecutor
    implements Runnable, b
  {
    private static final int NONE = 0;
    private static final int RUNNING = 2;
    private static final int SUBMITTED = 1;
    private final EventExecutor executor;
    private final int maxTaskExecutePerRun;
    private final AtomicInteger state = new AtomicInteger();
    private final Queue<Runnable> tasks = PlatformDependent.newMpscQueue();
    
    NonStickyOrderedEventExecutor(EventExecutor paramEventExecutor, int paramInt)
    {
      super();
      this.executor = paramEventExecutor;
      this.maxTaskExecutePerRun = paramInt;
    }
    
    public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
      throws InterruptedException
    {
      return this.executor.awaitTermination(paramLong, paramTimeUnit);
    }
    
    /* Error */
    public void execute(Runnable paramRunnable)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 39	io/netty/util/concurrent/NonStickyEventExecutorGroup$NonStickyOrderedEventExecutor:tasks	Ljava/util/Queue;
      //   4: aload_1
      //   5: invokeinterface 68 2 0
      //   10: ifeq +45 -> 55
      //   13: aload_0
      //   14: getfield 46	io/netty/util/concurrent/NonStickyEventExecutorGroup$NonStickyOrderedEventExecutor:state	Ljava/util/concurrent/atomic/AtomicInteger;
      //   17: iconst_0
      //   18: iconst_1
      //   19: invokevirtual 72	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
      //   22: ifeq +32 -> 54
      //   25: aload_0
      //   26: getfield 48	io/netty/util/concurrent/NonStickyEventExecutorGroup$NonStickyOrderedEventExecutor:executor	Lio/netty/util/concurrent/EventExecutor;
      //   29: aload_0
      //   30: invokeinterface 74 2 0
      //   35: goto +19 -> 54
      //   38: astore_2
      //   39: aload_0
      //   40: getfield 39	io/netty/util/concurrent/NonStickyEventExecutorGroup$NonStickyOrderedEventExecutor:tasks	Ljava/util/Queue;
      //   43: aload_1
      //   44: invokeinterface 77 2 0
      //   49: pop
      //   50: aload_2
      //   51: invokestatic 81	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
      //   54: return
      //   55: new 83	java/util/concurrent/RejectedExecutionException
      //   58: dup
      //   59: invokespecial 84	java/util/concurrent/RejectedExecutionException:<init>	()V
      //   62: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	NonStickyOrderedEventExecutor
      //   0	63	1	paramRunnable	Runnable
      //   38	13	2	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   25	35	38	finally
    }
    
    public boolean inEventLoop()
    {
      return false;
    }
    
    public boolean inEventLoop(Thread paramThread)
    {
      return false;
    }
    
    public boolean isShutdown()
    {
      return this.executor.isShutdown();
    }
    
    public boolean isShuttingDown()
    {
      return this.executor.isShutdown();
    }
    
    public boolean isTerminated()
    {
      return this.executor.isTerminated();
    }
    
    public void run()
    {
      if (!this.state.compareAndSet(1, 2)) {
        return;
      }
      for (;;)
      {
        int i = 0;
        label200:
        try
        {
          while (i < this.maxTaskExecutePerRun)
          {
            Runnable localRunnable = (Runnable)this.tasks.poll();
            if (localRunnable == null) {
              break;
            }
            AbstractEventExecutor.safeExecute(localRunnable);
            i++;
          }
          if (i == this.maxTaskExecutePerRun)
          {
            try
            {
              this.state.set(1);
              this.executor.execute(this);
              return;
            }
            finally
            {
              this.state.set(2);
            }
          }
          else
          {
            this.state.set(0);
            if ((this.tasks.isEmpty()) || (!this.state.compareAndSet(0, 2))) {}
          }
        }
        finally
        {
          if (i == this.maxTaskExecutePerRun) {
            try
            {
              this.state.set(1);
              this.executor.execute(this);
              return;
            }
            finally
            {
              this.state.set(2);
              break label200;
            }
          }
          this.state.set(0);
          if (!this.tasks.isEmpty()) {
            if (!this.state.compareAndSet(0, 2)) {
              break;
            }
          }
        }
      }
    }
    
    public void shutdown()
    {
      this.executor.shutdown();
    }
    
    public Future<?> shutdownGracefully(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      return this.executor.shutdownGracefully(paramLong1, paramLong2, paramTimeUnit);
    }
    
    public Future<?> terminationFuture()
    {
      return this.executor.terminationFuture();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\NonStickyEventExecutorGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */