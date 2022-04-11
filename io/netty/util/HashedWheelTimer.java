package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;

public class HashedWheelTimer
  implements Timer
{
  private static final AtomicInteger INSTANCE_COUNTER;
  private static final int INSTANCE_COUNT_LIMIT = 64;
  private static final long MILLISECOND_NANOS;
  private static final AtomicBoolean WARNED_TOO_MANY_INSTANCES;
  public static final int WORKER_STATE_INIT = 0;
  public static final int WORKER_STATE_SHUTDOWN = 2;
  public static final int WORKER_STATE_STARTED = 1;
  private static final AtomicIntegerFieldUpdater<HashedWheelTimer> WORKER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimer.class, "workerState");
  private static final ResourceLeakDetector<HashedWheelTimer> leakDetector;
  static final InternalLogger logger = InternalLoggerFactory.getInstance(HashedWheelTimer.class);
  private final Queue<HashedWheelTimeout> cancelledTimeouts;
  private final ResourceLeakTracker<HashedWheelTimer> leak;
  private final int mask;
  private final long maxPendingTimeouts;
  private final AtomicLong pendingTimeouts;
  private volatile long startTime;
  private final CountDownLatch startTimeInitialized;
  private final long tickDuration;
  private final Queue<HashedWheelTimeout> timeouts;
  private final HashedWheelBucket[] wheel;
  private final Worker worker;
  private volatile int workerState;
  private final Thread workerThread;
  
  static
  {
    INSTANCE_COUNTER = new AtomicInteger();
    WARNED_TOO_MANY_INSTANCES = new AtomicBoolean();
    MILLISECOND_NANOS = TimeUnit.MILLISECONDS.toNanos(1L);
    leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(HashedWheelTimer.class, 1);
  }
  
  public HashedWheelTimer()
  {
    this(Executors.defaultThreadFactory());
  }
  
  public HashedWheelTimer(long paramLong, TimeUnit paramTimeUnit)
  {
    this(Executors.defaultThreadFactory(), paramLong, paramTimeUnit);
  }
  
  public HashedWheelTimer(long paramLong, TimeUnit paramTimeUnit, int paramInt)
  {
    this(Executors.defaultThreadFactory(), paramLong, paramTimeUnit, paramInt);
  }
  
  public HashedWheelTimer(ThreadFactory paramThreadFactory)
  {
    this(paramThreadFactory, 100L, TimeUnit.MILLISECONDS);
  }
  
  public HashedWheelTimer(ThreadFactory paramThreadFactory, long paramLong, TimeUnit paramTimeUnit)
  {
    this(paramThreadFactory, paramLong, paramTimeUnit, 512);
  }
  
  public HashedWheelTimer(ThreadFactory paramThreadFactory, long paramLong, TimeUnit paramTimeUnit, int paramInt)
  {
    this(paramThreadFactory, paramLong, paramTimeUnit, paramInt, true);
  }
  
  public HashedWheelTimer(ThreadFactory paramThreadFactory, long paramLong, TimeUnit paramTimeUnit, int paramInt, boolean paramBoolean)
  {
    this(paramThreadFactory, paramLong, paramTimeUnit, paramInt, paramBoolean, -1L);
  }
  
  public HashedWheelTimer(ThreadFactory paramThreadFactory, long paramLong1, TimeUnit paramTimeUnit, int paramInt, boolean paramBoolean, long paramLong2)
  {
    Object localObject = null;
    Worker localWorker = new Worker(null);
    this.worker = localWorker;
    this.startTimeInitialized = new CountDownLatch(1);
    this.timeouts = PlatformDependent.newMpscQueue();
    this.cancelledTimeouts = PlatformDependent.newMpscQueue();
    this.pendingTimeouts = new AtomicLong(0L);
    ObjectUtil.checkNotNull(paramThreadFactory, "threadFactory");
    ObjectUtil.checkNotNull(paramTimeUnit, "unit");
    ObjectUtil.checkPositive(paramLong1, "tickDuration");
    ObjectUtil.checkPositive(paramInt, "ticksPerWheel");
    HashedWheelBucket[] arrayOfHashedWheelBucket = createWheel(paramInt);
    this.wheel = arrayOfHashedWheelBucket;
    this.mask = (arrayOfHashedWheelBucket.length - 1);
    long l1 = paramTimeUnit.toNanos(paramLong1);
    if (l1 < Long.MAX_VALUE / arrayOfHashedWheelBucket.length)
    {
      long l2 = MILLISECOND_NANOS;
      if (l1 < l2)
      {
        logger.warn("Configured tickDuration {} smaller then {}, using 1ms.", Long.valueOf(paramLong1), Long.valueOf(l2));
        this.tickDuration = l2;
      }
      else
      {
        this.tickDuration = l1;
      }
      paramTimeUnit = paramThreadFactory.newThread(localWorker);
      this.workerThread = paramTimeUnit;
      if (!paramBoolean)
      {
        paramThreadFactory = (ThreadFactory)localObject;
        if (paramTimeUnit.isDaemon()) {}
      }
      else
      {
        paramThreadFactory = leakDetector.track(this);
      }
      this.leak = paramThreadFactory;
      this.maxPendingTimeouts = paramLong2;
      if ((INSTANCE_COUNTER.incrementAndGet() > 64) && (WARNED_TOO_MANY_INSTANCES.compareAndSet(false, true))) {
        reportTooManyInstances();
      }
      return;
    }
    throw new IllegalArgumentException(String.format("tickDuration: %d (expected: 0 < tickDuration in nanos < %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(Long.MAX_VALUE / arrayOfHashedWheelBucket.length) }));
  }
  
  private static HashedWheelBucket[] createWheel(int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt <= 1073741824)
      {
        int i = normalizeTicksPerWheel(paramInt);
        localObject = new HashedWheelBucket[i];
        for (paramInt = 0; paramInt < i; paramInt++) {
          localObject[paramInt] = new HashedWheelBucket(null);
        }
        return (HashedWheelBucket[])localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ticksPerWheel may not be greater than 2^30: ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ticksPerWheel must be greater than 0: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private static int normalizeTicksPerWheel(int paramInt)
  {
    int i = 1;
    while (i < paramInt) {
      i <<= 1;
    }
    return i;
  }
  
  private static void reportTooManyInstances()
  {
    InternalLogger localInternalLogger = logger;
    if (localInternalLogger.isErrorEnabled())
    {
      String str = StringUtil.simpleClassName(HashedWheelTimer.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("You are creating too many ");
      localStringBuilder.append(str);
      localStringBuilder.append(" instances. ");
      localStringBuilder.append(str);
      localStringBuilder.append(" is a shared resource that must be reused across the JVM,so that only a few instances are created.");
      localInternalLogger.error(localStringBuilder.toString());
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      super.finalize();
      return;
    }
    finally
    {
      if (WORKER_STATE_UPDATER.getAndSet(this, 2) != 2) {
        INSTANCE_COUNTER.decrementAndGet();
      }
    }
  }
  
  public Timeout newTimeout(TimerTask paramTimerTask, long paramLong, TimeUnit paramTimeUnit)
  {
    ObjectUtil.checkNotNull(paramTimerTask, "task");
    ObjectUtil.checkNotNull(paramTimeUnit, "unit");
    long l1 = this.pendingTimeouts.incrementAndGet();
    long l2 = this.maxPendingTimeouts;
    if ((l2 > 0L) && (l1 > l2))
    {
      this.pendingTimeouts.decrementAndGet();
      paramTimerTask = new StringBuilder();
      paramTimerTask.append("Number of pending timeouts (");
      paramTimerTask.append(l1);
      paramTimerTask.append(") is greater than or equal to maximum allowed pending timeouts (");
      paramTimerTask.append(this.maxPendingTimeouts);
      paramTimerTask.append(")");
      throw new RejectedExecutionException(paramTimerTask.toString());
    }
    start();
    l2 = System.nanoTime() + paramTimeUnit.toNanos(paramLong) - this.startTime;
    l1 = l2;
    if (paramLong > 0L)
    {
      l1 = l2;
      if (l2 < 0L) {
        l1 = Long.MAX_VALUE;
      }
    }
    paramTimerTask = new HashedWheelTimeout(this, paramTimerTask, l1);
    this.timeouts.add(paramTimerTask);
    return paramTimerTask;
  }
  
  public long pendingTimeouts()
  {
    return this.pendingTimeouts.get();
  }
  
  public void start()
  {
    AtomicIntegerFieldUpdater localAtomicIntegerFieldUpdater = WORKER_STATE_UPDATER;
    int i = localAtomicIntegerFieldUpdater.get(this);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          throw new Error("Invalid WorkerState");
        }
        throw new IllegalStateException("cannot be started once stopped");
      }
    }
    else if (localAtomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
      this.workerThread.start();
    }
    while (this.startTime == 0L) {
      try
      {
        this.startTimeInitialized.await();
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public Set<Timeout> stop()
  {
    if (Thread.currentThread() != this.workerThread)
    {
      Object localObject1 = WORKER_STATE_UPDATER;
      if (!((AtomicIntegerFieldUpdater)localObject1).compareAndSet(this, 1, 2))
      {
        if (((AtomicIntegerFieldUpdater)localObject1).getAndSet(this, 2) != 2)
        {
          INSTANCE_COUNTER.decrementAndGet();
          localObject1 = this.leak;
          if (localObject1 != null) {
            ((ResourceLeakTracker)localObject1).close(this);
          }
        }
        return Collections.emptySet();
      }
      int i = 0;
      try
      {
        while (this.workerThread.isAlive())
        {
          this.workerThread.interrupt();
          try
          {
            this.workerThread.join(100L);
          }
          catch (InterruptedException localInterruptedException)
          {
            i = 1;
          }
        }
        if (i != 0) {
          Thread.currentThread().interrupt();
        }
        return this.worker.unprocessedTimeouts();
      }
      finally
      {
        INSTANCE_COUNTER.decrementAndGet();
        localObject2 = this.leak;
        if (localObject2 != null) {
          ((ResourceLeakTracker)localObject2).close(this);
        }
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HashedWheelTimer.class.getSimpleName());
    ((StringBuilder)localObject2).append(".stop() cannot be called from ");
    ((StringBuilder)localObject2).append(TimerTask.class.getSimpleName());
    throw new IllegalStateException(((StringBuilder)localObject2).toString());
  }
  
  private static final class HashedWheelBucket
  {
    private HashedWheelTimer.HashedWheelTimeout head;
    private HashedWheelTimer.HashedWheelTimeout tail;
    
    private HashedWheelTimer.HashedWheelTimeout pollTimeout()
    {
      HashedWheelTimer.HashedWheelTimeout localHashedWheelTimeout1 = this.head;
      if (localHashedWheelTimeout1 == null) {
        return null;
      }
      HashedWheelTimer.HashedWheelTimeout localHashedWheelTimeout2 = localHashedWheelTimeout1.next;
      if (localHashedWheelTimeout2 == null)
      {
        this.head = null;
        this.tail = null;
      }
      else
      {
        this.head = localHashedWheelTimeout2;
        localHashedWheelTimeout2.prev = null;
      }
      localHashedWheelTimeout1.next = null;
      localHashedWheelTimeout1.prev = null;
      localHashedWheelTimeout1.bucket = null;
      return localHashedWheelTimeout1;
    }
    
    public void addTimeout(HashedWheelTimer.HashedWheelTimeout paramHashedWheelTimeout)
    {
      paramHashedWheelTimeout.bucket = this;
      if (this.head == null)
      {
        this.tail = paramHashedWheelTimeout;
        this.head = paramHashedWheelTimeout;
      }
      else
      {
        HashedWheelTimer.HashedWheelTimeout localHashedWheelTimeout = this.tail;
        localHashedWheelTimeout.next = paramHashedWheelTimeout;
        paramHashedWheelTimeout.prev = localHashedWheelTimeout;
        this.tail = paramHashedWheelTimeout;
      }
    }
    
    public void clearTimeouts(Set<Timeout> paramSet)
    {
      for (;;)
      {
        HashedWheelTimer.HashedWheelTimeout localHashedWheelTimeout = pollTimeout();
        if (localHashedWheelTimeout == null) {
          return;
        }
        if ((!localHashedWheelTimeout.isExpired()) && (!localHashedWheelTimeout.isCancelled())) {
          paramSet.add(localHashedWheelTimeout);
        }
      }
    }
    
    public void expireTimeouts(long paramLong)
    {
      Object localObject = this.head;
      while (localObject != null)
      {
        HashedWheelTimer.HashedWheelTimeout localHashedWheelTimeout = ((HashedWheelTimer.HashedWheelTimeout)localObject).next;
        if (((HashedWheelTimer.HashedWheelTimeout)localObject).remainingRounds <= 0L)
        {
          localHashedWheelTimeout = remove((HashedWheelTimer.HashedWheelTimeout)localObject);
          if (HashedWheelTimer.HashedWheelTimeout.access$800((HashedWheelTimer.HashedWheelTimeout)localObject) <= paramLong)
          {
            ((HashedWheelTimer.HashedWheelTimeout)localObject).expire();
            localObject = localHashedWheelTimeout;
          }
          else
          {
            throw new IllegalStateException(String.format("timeout.deadline (%d) > deadline (%d)", new Object[] { Long.valueOf(HashedWheelTimer.HashedWheelTimeout.access$800((HashedWheelTimer.HashedWheelTimeout)localObject)), Long.valueOf(paramLong) }));
          }
        }
        else if (((HashedWheelTimer.HashedWheelTimeout)localObject).isCancelled())
        {
          localObject = remove((HashedWheelTimer.HashedWheelTimeout)localObject);
        }
        else
        {
          ((HashedWheelTimer.HashedWheelTimeout)localObject).remainingRounds -= 1L;
          localObject = localHashedWheelTimeout;
        }
      }
    }
    
    public HashedWheelTimer.HashedWheelTimeout remove(HashedWheelTimer.HashedWheelTimeout paramHashedWheelTimeout)
    {
      HashedWheelTimer.HashedWheelTimeout localHashedWheelTimeout1 = paramHashedWheelTimeout.next;
      HashedWheelTimer.HashedWheelTimeout localHashedWheelTimeout2 = paramHashedWheelTimeout.prev;
      if (localHashedWheelTimeout2 != null) {
        localHashedWheelTimeout2.next = localHashedWheelTimeout1;
      }
      HashedWheelTimer.HashedWheelTimeout localHashedWheelTimeout3 = paramHashedWheelTimeout.next;
      if (localHashedWheelTimeout3 != null) {
        localHashedWheelTimeout3.prev = localHashedWheelTimeout2;
      }
      if (paramHashedWheelTimeout == this.head)
      {
        if (paramHashedWheelTimeout == this.tail)
        {
          this.tail = null;
          this.head = null;
        }
        else
        {
          this.head = localHashedWheelTimeout1;
        }
      }
      else if (paramHashedWheelTimeout == this.tail) {
        this.tail = paramHashedWheelTimeout.prev;
      }
      paramHashedWheelTimeout.prev = null;
      paramHashedWheelTimeout.next = null;
      paramHashedWheelTimeout.bucket = null;
      HashedWheelTimer.HashedWheelTimeout.access$1200(paramHashedWheelTimeout).pendingTimeouts.decrementAndGet();
      return localHashedWheelTimeout1;
    }
  }
  
  private static final class HashedWheelTimeout
    implements Timeout
  {
    private static final AtomicIntegerFieldUpdater<HashedWheelTimeout> STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimeout.class, "state");
    private static final int ST_CANCELLED = 1;
    private static final int ST_EXPIRED = 2;
    private static final int ST_INIT = 0;
    HashedWheelTimer.HashedWheelBucket bucket;
    private final long deadline;
    HashedWheelTimeout next;
    HashedWheelTimeout prev;
    long remainingRounds;
    private volatile int state = 0;
    private final TimerTask task;
    private final HashedWheelTimer timer;
    
    HashedWheelTimeout(HashedWheelTimer paramHashedWheelTimer, TimerTask paramTimerTask, long paramLong)
    {
      this.timer = paramHashedWheelTimer;
      this.task = paramTimerTask;
      this.deadline = paramLong;
    }
    
    public boolean cancel()
    {
      if (!compareAndSetState(0, 1)) {
        return false;
      }
      this.timer.cancelledTimeouts.add(this);
      return true;
    }
    
    public boolean compareAndSetState(int paramInt1, int paramInt2)
    {
      return STATE_UPDATER.compareAndSet(this, paramInt1, paramInt2);
    }
    
    /* Error */
    public void expire()
    {
      // Byte code:
      //   0: aload_0
      //   1: iconst_0
      //   2: iconst_2
      //   3: invokevirtual 66	io/netty/util/HashedWheelTimer$HashedWheelTimeout:compareAndSetState	(II)Z
      //   6: ifne +4 -> 10
      //   9: return
      //   10: aload_0
      //   11: getfield 54	io/netty/util/HashedWheelTimer$HashedWheelTimeout:task	Lio/netty/util/TimerTask;
      //   14: aload_0
      //   15: invokeinterface 87 2 0
      //   20: goto +60 -> 80
      //   23: astore_1
      //   24: getstatic 91	io/netty/util/HashedWheelTimer:logger	Lio/netty/util/internal/logging/InternalLogger;
      //   27: astore_2
      //   28: aload_2
      //   29: invokeinterface 96 1 0
      //   34: ifeq +46 -> 80
      //   37: new 98	java/lang/StringBuilder
      //   40: dup
      //   41: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   44: astore_3
      //   45: aload_3
      //   46: ldc 101
      //   48: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   51: pop
      //   52: aload_3
      //   53: ldc 83
      //   55: invokevirtual 111	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   58: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   61: pop
      //   62: aload_3
      //   63: bipush 46
      //   65: invokevirtual 114	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   68: pop
      //   69: aload_2
      //   70: aload_3
      //   71: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   74: aload_1
      //   75: invokeinterface 121 3 0
      //   80: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	81	0	this	HashedWheelTimeout
      //   23	52	1	localThrowable	Throwable
      //   27	43	2	localInternalLogger	InternalLogger
      //   44	27	3	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   10	20	23	finally
    }
    
    public boolean isCancelled()
    {
      int i = state();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      return bool;
    }
    
    public boolean isExpired()
    {
      boolean bool;
      if (state() == 2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void remove()
    {
      HashedWheelTimer.HashedWheelBucket localHashedWheelBucket = this.bucket;
      if (localHashedWheelBucket != null) {
        localHashedWheelBucket.remove(this);
      } else {
        this.timer.pendingTimeouts.decrementAndGet();
      }
    }
    
    public int state()
    {
      return this.state;
    }
    
    public TimerTask task()
    {
      return this.task;
    }
    
    public Timer timer()
    {
      return this.timer;
    }
    
    public String toString()
    {
      long l = System.nanoTime();
      l = this.deadline - l + this.timer.startTime;
      StringBuilder localStringBuilder = new StringBuilder(192);
      localStringBuilder.append(StringUtil.simpleClassName(this));
      localStringBuilder.append('(');
      localStringBuilder.append("deadline: ");
      boolean bool = l < 0L;
      if (bool)
      {
        localStringBuilder.append(l);
        localStringBuilder.append(" ns later");
      }
      else if (bool)
      {
        localStringBuilder.append(-l);
        localStringBuilder.append(" ns ago");
      }
      else
      {
        localStringBuilder.append("now");
      }
      if (isCancelled()) {
        localStringBuilder.append(", cancelled");
      }
      localStringBuilder.append(", task: ");
      localStringBuilder.append(task());
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
  
  private final class Worker
    implements Runnable
  {
    private long tick;
    private final Set<Timeout> unprocessedTimeouts = new HashSet();
    
    private Worker() {}
    
    /* Error */
    private void processCancelledTasks()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 20	io/netty/util/HashedWheelTimer$Worker:this$0	Lio/netty/util/HashedWheelTimer;
      //   4: invokestatic 37	io/netty/util/HashedWheelTimer:access$1000	(Lio/netty/util/HashedWheelTimer;)Ljava/util/Queue;
      //   7: invokeinterface 43 1 0
      //   12: checkcast 45	io/netty/util/HashedWheelTimer$HashedWheelTimeout
      //   15: astore_1
      //   16: aload_1
      //   17: ifnonnull +4 -> 21
      //   20: return
      //   21: aload_1
      //   22: invokevirtual 48	io/netty/util/HashedWheelTimer$HashedWheelTimeout:remove	()V
      //   25: goto -25 -> 0
      //   28: astore_1
      //   29: getstatic 52	io/netty/util/HashedWheelTimer:logger	Lio/netty/util/internal/logging/InternalLogger;
      //   32: invokeinterface 58 1 0
      //   37: ifeq -37 -> 0
      //   40: getstatic 52	io/netty/util/HashedWheelTimer:logger	Lio/netty/util/internal/logging/InternalLogger;
      //   43: ldc 60
      //   45: aload_1
      //   46: invokeinterface 64 3 0
      //   51: goto -51 -> 0
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	54	0	this	Worker
      //   15	7	1	localHashedWheelTimeout	HashedWheelTimer.HashedWheelTimeout
      //   28	18	1	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   21	25	28	finally
    }
    
    private void transferTimeoutsToBuckets()
    {
      for (int i = 0; i < 100000; i++)
      {
        HashedWheelTimer.HashedWheelTimeout localHashedWheelTimeout = (HashedWheelTimer.HashedWheelTimeout)HashedWheelTimer.this.timeouts.poll();
        if (localHashedWheelTimeout == null) {
          break;
        }
        if (localHashedWheelTimeout.state() != 1)
        {
          long l = localHashedWheelTimeout.deadline / HashedWheelTimer.this.tickDuration;
          localHashedWheelTimeout.remainingRounds = ((l - this.tick) / HashedWheelTimer.this.wheel.length);
          int j = (int)(Math.max(l, this.tick) & HashedWheelTimer.this.mask);
          HashedWheelTimer.this.wheel[j].addTimeout(localHashedWheelTimeout);
        }
      }
    }
    
    private long waitForNextTick()
    {
      long l1 = HashedWheelTimer.this.tickDuration;
      long l2 = this.tick;
      do
      {
        for (;;)
        {
          long l3 = System.nanoTime() - HashedWheelTimer.this.startTime;
          long l4 = (l1 * (l2 + 1L) - l3 + 999999L) / 1000000L;
          if (l4 <= 0L)
          {
            if (l3 == Long.MIN_VALUE) {
              return -9223372036854775807L;
            }
            return l3;
          }
          l3 = l4;
          if (PlatformDependent.isWindows())
          {
            l4 = l4 / 10L * 10L;
            l3 = l4;
            if (l4 == 0L) {
              l3 = 1L;
            }
          }
          try
          {
            Thread.sleep(l3);
          }
          catch (InterruptedException localInterruptedException) {}
        }
      } while (HashedWheelTimer.WORKER_STATE_UPDATER.get(HashedWheelTimer.this) != 2);
      return Long.MIN_VALUE;
    }
    
    public void run()
    {
      HashedWheelTimer.access$202(HashedWheelTimer.this, System.nanoTime());
      if (HashedWheelTimer.this.startTime == 0L) {
        HashedWheelTimer.access$202(HashedWheelTimer.this, 1L);
      }
      HashedWheelTimer.this.startTimeInitialized.countDown();
      do
      {
        long l = waitForNextTick();
        if (l > 0L)
        {
          i = (int)(this.tick & HashedWheelTimer.this.mask);
          processCancelledTasks();
          localObject = HashedWheelTimer.this.wheel[i];
          transferTimeoutsToBuckets();
          ((HashedWheelTimer.HashedWheelBucket)localObject).expireTimeouts(l);
          this.tick += 1L;
        }
      } while (HashedWheelTimer.WORKER_STATE_UPDATER.get(HashedWheelTimer.this) == 1);
      Object localObject = HashedWheelTimer.this.wheel;
      int j = localObject.length;
      for (int i = 0; i < j; i++) {
        localObject[i].clearTimeouts(this.unprocessedTimeouts);
      }
      for (;;)
      {
        localObject = (HashedWheelTimer.HashedWheelTimeout)HashedWheelTimer.this.timeouts.poll();
        if (localObject == null)
        {
          processCancelledTasks();
          return;
        }
        if (!((HashedWheelTimer.HashedWheelTimeout)localObject).isCancelled()) {
          this.unprocessedTimeouts.add(localObject);
        }
      }
    }
    
    public Set<Timeout> unprocessedTimeouts()
    {
      return Collections.unmodifiableSet(this.unprocessedTimeouts);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\HashedWheelTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */