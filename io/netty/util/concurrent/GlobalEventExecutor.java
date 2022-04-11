package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class GlobalEventExecutor
  extends AbstractScheduledEventExecutor
  implements b
{
  public static final GlobalEventExecutor INSTANCE = new GlobalEventExecutor();
  private static final long SCHEDULE_QUIET_PERIOD_INTERVAL;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(GlobalEventExecutor.class);
  final ScheduledFutureTask<Void> quietPeriodTask;
  private final AtomicBoolean started;
  final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue();
  private final TaskRunner taskRunner;
  private final Future<?> terminationFuture;
  volatile Thread thread;
  final ThreadFactory threadFactory;
  
  static
  {
    SCHEDULE_QUIET_PERIOD_INTERVAL = TimeUnit.SECONDS.toNanos(1L);
  }
  
  private GlobalEventExecutor()
  {
    Object localObject = Executors.callable(new Runnable()
    {
      public void run() {}
    }, null);
    long l = SCHEDULE_QUIET_PERIOD_INTERVAL;
    localObject = new ScheduledFutureTask(this, (Callable)localObject, ScheduledFutureTask.deadlineNanos(l), -l);
    this.quietPeriodTask = ((ScheduledFutureTask)localObject);
    this.taskRunner = new TaskRunner();
    this.started = new AtomicBoolean();
    this.terminationFuture = new FailedFuture(this, new UnsupportedOperationException());
    scheduledTaskQueue().add(localObject);
    this.threadFactory = ThreadExecutorMap.apply(new DefaultThreadFactory(DefaultThreadFactory.toPoolName(GlobalEventExecutor.class), false, 5, null), this);
  }
  
  private void addTask(Runnable paramRunnable)
  {
    this.taskQueue.add(ObjectUtil.checkNotNull(paramRunnable, "task"));
  }
  
  private void fetchFromScheduledTaskQueue()
  {
    long l = AbstractScheduledEventExecutor.nanoTime();
    for (Runnable localRunnable = pollScheduledTask(l); localRunnable != null; localRunnable = pollScheduledTask(l)) {
      this.taskQueue.add(localRunnable);
    }
  }
  
  private void startThread()
  {
    if (this.started.compareAndSet(false, true))
    {
      final Thread localThread = this.threadFactory.newThread(this.taskRunner);
      AccessController.doPrivileged(new PrivilegedAction()
      {
        public Void run()
        {
          localThread.setContextClassLoader(null);
          return null;
        }
      });
      this.thread = localThread;
      localThread.start();
    }
  }
  
  public boolean awaitInactivity(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    ObjectUtil.checkNotNull(paramTimeUnit, "unit");
    Thread localThread = this.thread;
    if (localThread != null)
    {
      localThread.join(paramTimeUnit.toMillis(paramLong));
      return localThread.isAlive() ^ true;
    }
    throw new IllegalStateException("thread was not started");
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    return false;
  }
  
  public void execute(Runnable paramRunnable)
  {
    addTask((Runnable)ObjectUtil.checkNotNull(paramRunnable, "task"));
    if (!inEventLoop()) {
      startThread();
    }
  }
  
  public boolean inEventLoop(Thread paramThread)
  {
    boolean bool;
    if (paramThread == this.thread) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isShutdown()
  {
    return false;
  }
  
  public boolean isShuttingDown()
  {
    return false;
  }
  
  public boolean isTerminated()
  {
    return false;
  }
  
  public int pendingTasks()
  {
    return this.taskQueue.size();
  }
  
  @Deprecated
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<?> shutdownGracefully(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return terminationFuture();
  }
  
  Runnable takeTask()
  {
    BlockingQueue localBlockingQueue = this.taskQueue;
    Object localObject1;
    do
    {
      ScheduledFutureTask localScheduledFutureTask = peekScheduledTask();
      localObject1 = null;
      Object localObject2 = null;
      if (localScheduledFutureTask == null) {}
      try
      {
        localObject1 = (Runnable)localBlockingQueue.take();
        localObject2 = localObject1;
      }
      catch (InterruptedException localInterruptedException1)
      {
        long l;
        for (;;) {}
      }
      return (Runnable)localObject2;
      l = localScheduledFutureTask.delayNanos();
      localObject2 = localObject1;
      if (l > 0L) {
        try
        {
          localObject2 = (Runnable)localBlockingQueue.poll(l, TimeUnit.NANOSECONDS);
        }
        catch (InterruptedException localInterruptedException2)
        {
          return null;
        }
      }
      localObject1 = localInterruptedException2;
      if (localInterruptedException2 == null)
      {
        fetchFromScheduledTaskQueue();
        localObject1 = (Runnable)localBlockingQueue.poll();
      }
    } while (localObject1 == null);
    return (Runnable)localObject1;
  }
  
  public Future<?> terminationFuture()
  {
    return this.terminationFuture;
  }
  
  final class TaskRunner
    implements Runnable
  {
    TaskRunner() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 21	io/netty/util/concurrent/GlobalEventExecutor$TaskRunner:this$0	Lio/netty/util/concurrent/GlobalEventExecutor;
      //   4: invokevirtual 28	io/netty/util/concurrent/GlobalEventExecutor:takeTask	()Ljava/lang/Runnable;
      //   7: astore_1
      //   8: aload_1
      //   9: ifnull +38 -> 47
      //   12: aload_1
      //   13: invokeinterface 30 1 0
      //   18: goto +15 -> 33
      //   21: astore_2
      //   22: invokestatic 34	io/netty/util/concurrent/GlobalEventExecutor:access$000	()Lio/netty/util/internal/logging/InternalLogger;
      //   25: ldc 36
      //   27: aload_2
      //   28: invokeinterface 42 3 0
      //   33: aload_1
      //   34: aload_0
      //   35: getfield 21	io/netty/util/concurrent/GlobalEventExecutor$TaskRunner:this$0	Lio/netty/util/concurrent/GlobalEventExecutor;
      //   38: getfield 46	io/netty/util/concurrent/GlobalEventExecutor:quietPeriodTask	Lio/netty/util/concurrent/ScheduledFutureTask;
      //   41: if_acmpeq +6 -> 47
      //   44: goto -44 -> 0
      //   47: aload_0
      //   48: getfield 21	io/netty/util/concurrent/GlobalEventExecutor$TaskRunner:this$0	Lio/netty/util/concurrent/GlobalEventExecutor;
      //   51: astore_2
      //   52: aload_2
      //   53: getfield 52	io/netty/util/concurrent/AbstractScheduledEventExecutor:scheduledTaskQueue	Lio/netty/util/internal/PriorityQueue;
      //   56: astore_1
      //   57: aload_2
      //   58: getfield 56	io/netty/util/concurrent/GlobalEventExecutor:taskQueue	Ljava/util/concurrent/BlockingQueue;
      //   61: invokeinterface 62 1 0
      //   66: ifeq -66 -> 0
      //   69: aload_1
      //   70: ifnull +13 -> 83
      //   73: aload_1
      //   74: invokeinterface 68 1 0
      //   79: iconst_1
      //   80: if_icmpne -80 -> 0
      //   83: aload_0
      //   84: getfield 21	io/netty/util/concurrent/GlobalEventExecutor$TaskRunner:this$0	Lio/netty/util/concurrent/GlobalEventExecutor;
      //   87: invokestatic 72	io/netty/util/concurrent/GlobalEventExecutor:access$100	(Lio/netty/util/concurrent/GlobalEventExecutor;)Ljava/util/concurrent/atomic/AtomicBoolean;
      //   90: iconst_1
      //   91: iconst_0
      //   92: invokevirtual 78	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
      //   95: pop
      //   96: aload_0
      //   97: getfield 21	io/netty/util/concurrent/GlobalEventExecutor$TaskRunner:this$0	Lio/netty/util/concurrent/GlobalEventExecutor;
      //   100: getfield 56	io/netty/util/concurrent/GlobalEventExecutor:taskQueue	Ljava/util/concurrent/BlockingQueue;
      //   103: invokeinterface 62 1 0
      //   108: ifeq +20 -> 128
      //   111: aload_1
      //   112: ifnull +31 -> 143
      //   115: aload_1
      //   116: invokeinterface 68 1 0
      //   121: iconst_1
      //   122: if_icmpne +6 -> 128
      //   125: goto +18 -> 143
      //   128: aload_0
      //   129: getfield 21	io/netty/util/concurrent/GlobalEventExecutor$TaskRunner:this$0	Lio/netty/util/concurrent/GlobalEventExecutor;
      //   132: invokestatic 72	io/netty/util/concurrent/GlobalEventExecutor:access$100	(Lio/netty/util/concurrent/GlobalEventExecutor;)Ljava/util/concurrent/atomic/AtomicBoolean;
      //   135: iconst_0
      //   136: iconst_1
      //   137: invokevirtual 78	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
      //   140: ifne -140 -> 0
      //   143: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	144	0	this	TaskRunner
      //   7	109	1	localObject	Object
      //   21	7	2	localThrowable	Throwable
      //   51	7	2	localGlobalEventExecutor	GlobalEventExecutor
      // Exception table:
      //   from	to	target	type
      //   12	18	21	finally
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\GlobalEventExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */