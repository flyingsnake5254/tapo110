package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public abstract class AbstractScheduledEventExecutor
  extends AbstractEventExecutor
{
  private static final Comparator<ScheduledFutureTask<?>> SCHEDULED_FUTURE_TASK_COMPARATOR = new Comparator()
  {
    public int compare(ScheduledFutureTask<?> paramAnonymousScheduledFutureTask1, ScheduledFutureTask<?> paramAnonymousScheduledFutureTask2)
    {
      return paramAnonymousScheduledFutureTask1.compareTo(paramAnonymousScheduledFutureTask2);
    }
  };
  static final Runnable WAKEUP_TASK = new Runnable()
  {
    public void run() {}
  };
  long nextTaskId;
  PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue;
  
  protected AbstractScheduledEventExecutor() {}
  
  protected AbstractScheduledEventExecutor(EventExecutorGroup paramEventExecutorGroup)
  {
    super(paramEventExecutorGroup);
  }
  
  protected static long deadlineToDelayNanos(long paramLong)
  {
    return ScheduledFutureTask.deadlineToDelayNanos(paramLong);
  }
  
  protected static long initialNanoTime()
  {
    return ScheduledFutureTask.initialNanoTime();
  }
  
  private static boolean isNullOrEmpty(Queue<ScheduledFutureTask<?>> paramQueue)
  {
    boolean bool;
    if ((paramQueue != null) && (!paramQueue.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected static long nanoTime()
  {
    return ScheduledFutureTask.nanoTime();
  }
  
  private <V> c<V> schedule(ScheduledFutureTask<V> paramScheduledFutureTask)
  {
    if (inEventLoop())
    {
      scheduleFromEventLoop(paramScheduledFutureTask);
    }
    else
    {
      long l = paramScheduledFutureTask.deadlineNanos();
      if (beforeScheduledTaskSubmitted(l))
      {
        execute(paramScheduledFutureTask);
      }
      else
      {
        lazyExecute(paramScheduledFutureTask);
        if (afterScheduledTaskSubmitted(l)) {
          execute(WAKEUP_TASK);
        }
      }
    }
    return paramScheduledFutureTask;
  }
  
  private void validateScheduled0(long paramLong, TimeUnit paramTimeUnit)
  {
    validateScheduled(paramLong, paramTimeUnit);
  }
  
  protected boolean afterScheduledTaskSubmitted(long paramLong)
  {
    return true;
  }
  
  protected boolean beforeScheduledTaskSubmitted(long paramLong)
  {
    return true;
  }
  
  protected void cancelScheduledTasks()
  {
    PriorityQueue localPriorityQueue = this.scheduledTaskQueue;
    if (isNullOrEmpty(localPriorityQueue)) {
      return;
    }
    ScheduledFutureTask[] arrayOfScheduledFutureTask = (ScheduledFutureTask[])localPriorityQueue.toArray(new ScheduledFutureTask[0]);
    int i = arrayOfScheduledFutureTask.length;
    for (int j = 0; j < i; j++) {
      arrayOfScheduledFutureTask[j].cancelWithoutRemove(false);
    }
    localPriorityQueue.clearIgnoringIndexes();
  }
  
  protected final boolean hasScheduledTasks()
  {
    ScheduledFutureTask localScheduledFutureTask = peekScheduledTask();
    boolean bool;
    if ((localScheduledFutureTask != null) && (localScheduledFutureTask.deadlineNanos() <= nanoTime())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected final long nextScheduledTaskDeadlineNanos()
  {
    ScheduledFutureTask localScheduledFutureTask = peekScheduledTask();
    long l;
    if (localScheduledFutureTask != null) {
      l = localScheduledFutureTask.deadlineNanos();
    } else {
      l = -1L;
    }
    return l;
  }
  
  protected final long nextScheduledTaskNano()
  {
    ScheduledFutureTask localScheduledFutureTask = peekScheduledTask();
    long l;
    if (localScheduledFutureTask != null) {
      l = localScheduledFutureTask.delayNanos();
    } else {
      l = -1L;
    }
    return l;
  }
  
  final ScheduledFutureTask<?> peekScheduledTask()
  {
    Object localObject = this.scheduledTaskQueue;
    if (localObject != null) {
      localObject = (ScheduledFutureTask)((Queue)localObject).peek();
    } else {
      localObject = null;
    }
    return (ScheduledFutureTask<?>)localObject;
  }
  
  protected final Runnable pollScheduledTask()
  {
    return pollScheduledTask(nanoTime());
  }
  
  protected final Runnable pollScheduledTask(long paramLong)
  {
    ScheduledFutureTask localScheduledFutureTask = peekScheduledTask();
    if ((localScheduledFutureTask != null) && (localScheduledFutureTask.deadlineNanos() - paramLong <= 0L))
    {
      this.scheduledTaskQueue.remove();
      localScheduledFutureTask.setConsumed();
      return localScheduledFutureTask;
    }
    return null;
  }
  
  final void removeScheduled(ScheduledFutureTask<?> paramScheduledFutureTask)
  {
    if (inEventLoop()) {
      scheduledTaskQueue().removeTyped(paramScheduledFutureTask);
    } else {
      lazyExecute(paramScheduledFutureTask);
    }
  }
  
  public c<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    ObjectUtil.checkNotNull(paramRunnable, "command");
    ObjectUtil.checkNotNull(paramTimeUnit, "unit");
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    validateScheduled0(l, paramTimeUnit);
    return schedule(new ScheduledFutureTask(this, paramRunnable, ScheduledFutureTask.deadlineNanos(paramTimeUnit.toNanos(l))));
  }
  
  public <V> c<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    ObjectUtil.checkNotNull(paramCallable, "callable");
    ObjectUtil.checkNotNull(paramTimeUnit, "unit");
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    validateScheduled0(l, paramTimeUnit);
    return schedule(new ScheduledFutureTask(this, paramCallable, ScheduledFutureTask.deadlineNanos(paramTimeUnit.toNanos(l))));
  }
  
  public c<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    ObjectUtil.checkNotNull(paramRunnable, "command");
    ObjectUtil.checkNotNull(paramTimeUnit, "unit");
    if (paramLong1 >= 0L)
    {
      if (paramLong2 > 0L)
      {
        validateScheduled0(paramLong1, paramTimeUnit);
        validateScheduled0(paramLong2, paramTimeUnit);
        return schedule(new ScheduledFutureTask(this, paramRunnable, ScheduledFutureTask.deadlineNanos(paramTimeUnit.toNanos(paramLong1)), paramTimeUnit.toNanos(paramLong2)));
      }
      throw new IllegalArgumentException(String.format("period: %d (expected: > 0)", new Object[] { Long.valueOf(paramLong2) }));
    }
    throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", new Object[] { Long.valueOf(paramLong1) }));
  }
  
  final void scheduleFromEventLoop(ScheduledFutureTask<?> paramScheduledFutureTask)
  {
    PriorityQueue localPriorityQueue = scheduledTaskQueue();
    long l = this.nextTaskId + 1L;
    this.nextTaskId = l;
    localPriorityQueue.add(paramScheduledFutureTask.setId(l));
  }
  
  public c<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    ObjectUtil.checkNotNull(paramRunnable, "command");
    ObjectUtil.checkNotNull(paramTimeUnit, "unit");
    if (paramLong1 >= 0L)
    {
      if (paramLong2 > 0L)
      {
        validateScheduled0(paramLong1, paramTimeUnit);
        validateScheduled0(paramLong2, paramTimeUnit);
        return schedule(new ScheduledFutureTask(this, paramRunnable, ScheduledFutureTask.deadlineNanos(paramTimeUnit.toNanos(paramLong1)), -paramTimeUnit.toNanos(paramLong2)));
      }
      throw new IllegalArgumentException(String.format("delay: %d (expected: > 0)", new Object[] { Long.valueOf(paramLong2) }));
    }
    throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", new Object[] { Long.valueOf(paramLong1) }));
  }
  
  PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue()
  {
    if (this.scheduledTaskQueue == null) {
      this.scheduledTaskQueue = new DefaultPriorityQueue(SCHEDULED_FUTURE_TASK_COMPARATOR, 11);
    }
    return this.scheduledTaskQueue;
  }
  
  @Deprecated
  protected void validateScheduled(long paramLong, TimeUnit paramTimeUnit) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\AbstractScheduledEventExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */