package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.PriorityQueue;
import io.netty.util.internal.PriorityQueueNode;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class ScheduledFutureTask<V>
  extends PromiseTask<V>
  implements c<V>, PriorityQueueNode
{
  private static final long START_TIME = ;
  private long deadlineNanos;
  private long id;
  private final long periodNanos;
  private int queueIndex = -1;
  
  ScheduledFutureTask(AbstractScheduledEventExecutor paramAbstractScheduledEventExecutor, Runnable paramRunnable, long paramLong)
  {
    super(paramAbstractScheduledEventExecutor, paramRunnable);
    this.deadlineNanos = paramLong;
    this.periodNanos = 0L;
  }
  
  ScheduledFutureTask(AbstractScheduledEventExecutor paramAbstractScheduledEventExecutor, Runnable paramRunnable, long paramLong1, long paramLong2)
  {
    super(paramAbstractScheduledEventExecutor, paramRunnable);
    this.deadlineNanos = paramLong1;
    this.periodNanos = validatePeriod(paramLong2);
  }
  
  ScheduledFutureTask(AbstractScheduledEventExecutor paramAbstractScheduledEventExecutor, Callable<V> paramCallable, long paramLong)
  {
    super(paramAbstractScheduledEventExecutor, paramCallable);
    this.deadlineNanos = paramLong;
    this.periodNanos = 0L;
  }
  
  ScheduledFutureTask(AbstractScheduledEventExecutor paramAbstractScheduledEventExecutor, Callable<V> paramCallable, long paramLong1, long paramLong2)
  {
    super(paramAbstractScheduledEventExecutor, paramCallable);
    this.deadlineNanos = paramLong1;
    this.periodNanos = validatePeriod(paramLong2);
  }
  
  static long deadlineNanos(long paramLong)
  {
    long l = nanoTime() + paramLong;
    paramLong = l;
    if (l < 0L) {
      paramLong = Long.MAX_VALUE;
    }
    return paramLong;
  }
  
  static long deadlineToDelayNanos(long paramLong)
  {
    long l = 0L;
    if (paramLong == 0L) {
      paramLong = l;
    } else {
      paramLong = Math.max(0L, paramLong - nanoTime());
    }
    return paramLong;
  }
  
  static long initialNanoTime()
  {
    return START_TIME;
  }
  
  static long nanoTime()
  {
    return System.nanoTime() - START_TIME;
  }
  
  private AbstractScheduledEventExecutor scheduledExecutor()
  {
    return (AbstractScheduledEventExecutor)executor();
  }
  
  private static long validatePeriod(long paramLong)
  {
    if (paramLong != 0L) {
      return paramLong;
    }
    throw new IllegalArgumentException("period: 0 (expected: != 0)");
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    paramBoolean = super.cancel(paramBoolean);
    if (paramBoolean) {
      scheduledExecutor().removeScheduled(this);
    }
    return paramBoolean;
  }
  
  boolean cancelWithoutRemove(boolean paramBoolean)
  {
    return super.cancel(paramBoolean);
  }
  
  public int compareTo(Delayed paramDelayed)
  {
    if (this == paramDelayed) {
      return 0;
    }
    paramDelayed = (ScheduledFutureTask)paramDelayed;
    boolean bool = deadlineNanos() - paramDelayed.deadlineNanos() < 0L;
    if (bool) {
      return -1;
    }
    if (bool) {
      return 1;
    }
    if (this.id < paramDelayed.id) {
      return -1;
    }
    return 1;
  }
  
  public long deadlineNanos()
  {
    return this.deadlineNanos;
  }
  
  public long delayNanos()
  {
    return deadlineToDelayNanos(deadlineNanos());
  }
  
  public long delayNanos(long paramLong)
  {
    long l1 = this.deadlineNanos;
    long l2 = 0L;
    if (l1 == 0L) {
      paramLong = l2;
    } else {
      paramLong = Math.max(0L, deadlineNanos() - (paramLong - START_TIME));
    }
    return paramLong;
  }
  
  protected EventExecutor executor()
  {
    return super.executor();
  }
  
  public long getDelay(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(delayNanos(), TimeUnit.NANOSECONDS);
  }
  
  public int priorityQueueIndex(DefaultPriorityQueue<?> paramDefaultPriorityQueue)
  {
    return this.queueIndex;
  }
  
  public void priorityQueueIndex(DefaultPriorityQueue<?> paramDefaultPriorityQueue, int paramInt)
  {
    this.queueIndex = paramInt;
  }
  
  public void run()
  {
    try
    {
      if (delayNanos() > 0L)
      {
        if (isCancelled()) {
          scheduledExecutor().scheduledTaskQueue().removeTyped(this);
        } else {
          scheduledExecutor().scheduleFromEventLoop(this);
        }
        return;
      }
      if (this.periodNanos == 0L)
      {
        if (setUncancellableInternal()) {
          setSuccessInternal(runTask());
        }
      }
      else if (!isCancelled())
      {
        runTask();
        if (!executor().isShutdown())
        {
          long l = this.periodNanos;
          if (l > 0L) {
            this.deadlineNanos += l;
          } else {
            this.deadlineNanos = (nanoTime() - this.periodNanos);
          }
          if (isCancelled()) {}
        }
      }
    }
    finally
    {
      setFailureInternal(localThrowable);
    }
  }
  
  void setConsumed()
  {
    if (this.periodNanos == 0L) {
      this.deadlineNanos = 0L;
    }
  }
  
  ScheduledFutureTask<V> setId(long paramLong)
  {
    if (this.id == 0L) {
      this.id = paramLong;
    }
    return this;
  }
  
  protected StringBuilder toStringBuilder()
  {
    StringBuilder localStringBuilder = super.toStringBuilder();
    localStringBuilder.setCharAt(localStringBuilder.length() - 1, ',');
    localStringBuilder.append(" deadline: ");
    localStringBuilder.append(this.deadlineNanos);
    localStringBuilder.append(", period: ");
    localStringBuilder.append(this.periodNanos);
    localStringBuilder.append(')');
    return localStringBuilder;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\ScheduledFutureTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */