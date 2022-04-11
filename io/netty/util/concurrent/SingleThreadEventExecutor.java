package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class SingleThreadEventExecutor
  extends AbstractScheduledEventExecutor
  implements b
{
  static final int DEFAULT_MAX_PENDING_EXECUTOR_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventexecutor.maxPendingTasks", Integer.MAX_VALUE));
  private static final Runnable NOOP_TASK;
  private static final AtomicReferenceFieldUpdater<SingleThreadEventExecutor, ThreadProperties> PROPERTIES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(SingleThreadEventExecutor.class, ThreadProperties.class, "threadProperties");
  private static final long SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS.toNanos(1L);
  private static final AtomicIntegerFieldUpdater<SingleThreadEventExecutor> STATE_UPDATER;
  private static final int ST_NOT_STARTED = 1;
  private static final int ST_SHUTDOWN = 4;
  private static final int ST_SHUTTING_DOWN = 3;
  private static final int ST_STARTED = 2;
  private static final int ST_TERMINATED = 5;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(SingleThreadEventExecutor.class);
  private final boolean addTaskWakesUp;
  private final Executor executor;
  private volatile long gracefulShutdownQuietPeriod;
  private long gracefulShutdownStartTime;
  private volatile long gracefulShutdownTimeout;
  private volatile boolean interrupted;
  private long lastExecutionTime;
  private final int maxPendingTasks;
  private final RejectedExecutionHandler rejectedExecutionHandler;
  private final Set<Runnable> shutdownHooks = new LinkedHashSet();
  private volatile int state = 1;
  private final Queue<Runnable> taskQueue;
  private final Promise<?> terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
  private volatile Thread thread;
  private final CountDownLatch threadLock = new CountDownLatch(1);
  private volatile ThreadProperties threadProperties;
  
  static
  {
    NOOP_TASK = new Runnable()
    {
      public void run() {}
    };
    STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(SingleThreadEventExecutor.class, "state");
  }
  
  protected SingleThreadEventExecutor(EventExecutorGroup paramEventExecutorGroup, Executor paramExecutor, boolean paramBoolean)
  {
    this(paramEventExecutorGroup, paramExecutor, paramBoolean, DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
  }
  
  protected SingleThreadEventExecutor(EventExecutorGroup paramEventExecutorGroup, Executor paramExecutor, boolean paramBoolean, int paramInt, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramEventExecutorGroup);
    this.addTaskWakesUp = paramBoolean;
    paramInt = Math.max(16, paramInt);
    this.maxPendingTasks = paramInt;
    this.executor = ThreadExecutorMap.apply(paramExecutor, this);
    this.taskQueue = newTaskQueue(paramInt);
    this.rejectedExecutionHandler = ((RejectedExecutionHandler)ObjectUtil.checkNotNull(paramRejectedExecutionHandler, "rejectedHandler"));
  }
  
  protected SingleThreadEventExecutor(EventExecutorGroup paramEventExecutorGroup, Executor paramExecutor, boolean paramBoolean, Queue<Runnable> paramQueue, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramEventExecutorGroup);
    this.addTaskWakesUp = paramBoolean;
    this.maxPendingTasks = DEFAULT_MAX_PENDING_EXECUTOR_TASKS;
    this.executor = ThreadExecutorMap.apply(paramExecutor, this);
    this.taskQueue = ((Queue)ObjectUtil.checkNotNull(paramQueue, "taskQueue"));
    this.rejectedExecutionHandler = ((RejectedExecutionHandler)ObjectUtil.checkNotNull(paramRejectedExecutionHandler, "rejectedHandler"));
  }
  
  protected SingleThreadEventExecutor(EventExecutorGroup paramEventExecutorGroup, ThreadFactory paramThreadFactory, boolean paramBoolean)
  {
    this(paramEventExecutorGroup, new ThreadPerTaskExecutor(paramThreadFactory), paramBoolean);
  }
  
  protected SingleThreadEventExecutor(EventExecutorGroup paramEventExecutorGroup, ThreadFactory paramThreadFactory, boolean paramBoolean, int paramInt, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    this(paramEventExecutorGroup, new ThreadPerTaskExecutor(paramThreadFactory), paramBoolean, paramInt, paramRejectedExecutionHandler);
  }
  
  private void doStartThread()
  {
    this.executor.execute(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   4: invokestatic 27	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   7: invokestatic 31	io/netty/util/concurrent/SingleThreadEventExecutor:access$102	(Lio/netty/util/concurrent/SingleThreadEventExecutor;Ljava/lang/Thread;)Ljava/lang/Thread;
        //   10: pop
        //   11: aload_0
        //   12: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   15: invokestatic 35	io/netty/util/concurrent/SingleThreadEventExecutor:access$200	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Z
        //   18: ifeq +13 -> 31
        //   21: aload_0
        //   22: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   25: invokestatic 39	io/netty/util/concurrent/SingleThreadEventExecutor:access$100	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Ljava/lang/Thread;
        //   28: invokevirtual 42	java/lang/Thread:interrupt	()V
        //   31: aload_0
        //   32: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   35: invokevirtual 45	io/netty/util/concurrent/SingleThreadEventExecutor:updateLastExecutionTime	()V
        //   38: aload_0
        //   39: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   42: invokevirtual 47	io/netty/util/concurrent/SingleThreadEventExecutor:run	()V
        //   45: aload_0
        //   46: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   49: invokestatic 51	io/netty/util/concurrent/SingleThreadEventExecutor:access$400	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)I
        //   52: istore_1
        //   53: iload_1
        //   54: iconst_3
        //   55: if_icmpge +18 -> 73
        //   58: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   61: aload_0
        //   62: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   65: iload_1
        //   66: iconst_3
        //   67: invokevirtual 61	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:compareAndSet	(Ljava/lang/Object;II)Z
        //   70: ifeq -25 -> 45
        //   73: aload_0
        //   74: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   77: invokestatic 65	io/netty/util/concurrent/SingleThreadEventExecutor:access$600	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)J
        //   80: lconst_0
        //   81: lcmp
        //   82: ifne +77 -> 159
        //   85: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   88: invokeinterface 75 1 0
        //   93: ifeq +66 -> 159
        //   96: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   99: astore_2
        //   100: new 77	java/lang/StringBuilder
        //   103: dup
        //   104: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   107: astore_3
        //   108: aload_3
        //   109: ldc 80
        //   111: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   114: pop
        //   115: aload_3
        //   116: ldc 86
        //   118: invokevirtual 92	java/lang/Class:getSimpleName	()Ljava/lang/String;
        //   121: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   124: pop
        //   125: aload_3
        //   126: ldc 94
        //   128: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   131: pop
        //   132: aload_3
        //   133: ldc 8
        //   135: invokevirtual 92	java/lang/Class:getSimpleName	()Ljava/lang/String;
        //   138: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   141: pop
        //   142: aload_3
        //   143: ldc 96
        //   145: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: pop
        //   149: aload_2
        //   150: aload_3
        //   151: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   154: invokeinterface 103 2 0
        //   159: aload_0
        //   160: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   163: invokevirtual 106	io/netty/util/concurrent/SingleThreadEventExecutor:confirmShutdown	()Z
        //   166: ifeq -7 -> 159
        //   169: aload_0
        //   170: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   173: invokestatic 51	io/netty/util/concurrent/SingleThreadEventExecutor:access$400	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)I
        //   176: istore_1
        //   177: iload_1
        //   178: iconst_4
        //   179: if_icmpge +18 -> 197
        //   182: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   185: aload_0
        //   186: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   189: iload_1
        //   190: iconst_4
        //   191: invokevirtual 61	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:compareAndSet	(Ljava/lang/Object;II)Z
        //   194: ifeq -25 -> 169
        //   197: aload_0
        //   198: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   201: invokevirtual 106	io/netty/util/concurrent/SingleThreadEventExecutor:confirmShutdown	()Z
        //   204: pop
        //   205: aload_0
        //   206: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   209: invokevirtual 109	io/netty/util/concurrent/SingleThreadEventExecutor:cleanup	()V
        //   212: invokestatic 114	io/netty/util/concurrent/FastThreadLocal:removeAll	()V
        //   215: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   218: aload_0
        //   219: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   222: iconst_5
        //   223: invokevirtual 118	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:set	(Ljava/lang/Object;I)V
        //   226: aload_0
        //   227: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   230: invokestatic 122	io/netty/util/concurrent/SingleThreadEventExecutor:access$700	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Ljava/util/concurrent/CountDownLatch;
        //   233: invokevirtual 127	java/util/concurrent/CountDownLatch:countDown	()V
        //   236: aload_0
        //   237: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   240: invokevirtual 131	io/netty/util/concurrent/SingleThreadEventExecutor:drainTasks	()I
        //   243: istore_1
        //   244: iload_1
        //   245: ifle +56 -> 301
        //   248: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   251: invokeinterface 134 1 0
        //   256: ifeq +45 -> 301
        //   259: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   262: astore_2
        //   263: new 77	java/lang/StringBuilder
        //   266: dup
        //   267: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   270: astore_3
        //   271: aload_3
        //   272: ldc -120
        //   274: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   277: pop
        //   278: aload_3
        //   279: iload_1
        //   280: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   283: pop
        //   284: aload_3
        //   285: bipush 41
        //   287: invokevirtual 142	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   290: pop
        //   291: aload_2
        //   292: aload_3
        //   293: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   296: invokeinterface 145 2 0
        //   301: aload_0
        //   302: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   305: invokestatic 149	io/netty/util/concurrent/SingleThreadEventExecutor:access$800	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Lio/netty/util/concurrent/Promise;
        //   308: aconst_null
        //   309: invokeinterface 155 2 0
        //   314: pop
        //   315: goto +495 -> 810
        //   318: astore_2
        //   319: invokestatic 114	io/netty/util/concurrent/FastThreadLocal:removeAll	()V
        //   322: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   325: aload_0
        //   326: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   329: iconst_5
        //   330: invokevirtual 118	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:set	(Ljava/lang/Object;I)V
        //   333: aload_0
        //   334: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   337: invokestatic 122	io/netty/util/concurrent/SingleThreadEventExecutor:access$700	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Ljava/util/concurrent/CountDownLatch;
        //   340: invokevirtual 127	java/util/concurrent/CountDownLatch:countDown	()V
        //   343: aload_0
        //   344: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   347: invokevirtual 131	io/netty/util/concurrent/SingleThreadEventExecutor:drainTasks	()I
        //   350: istore_1
        //   351: iload_1
        //   352: ifle +61 -> 413
        //   355: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   358: invokeinterface 134 1 0
        //   363: ifeq +50 -> 413
        //   366: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   369: astore_3
        //   370: new 77	java/lang/StringBuilder
        //   373: dup
        //   374: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   377: astore 4
        //   379: aload 4
        //   381: ldc -120
        //   383: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   386: pop
        //   387: aload 4
        //   389: iload_1
        //   390: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   393: pop
        //   394: aload 4
        //   396: bipush 41
        //   398: invokevirtual 142	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   401: pop
        //   402: aload_3
        //   403: aload 4
        //   405: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   408: invokeinterface 145 2 0
        //   413: aload_0
        //   414: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   417: invokestatic 149	io/netty/util/concurrent/SingleThreadEventExecutor:access$800	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Lio/netty/util/concurrent/Promise;
        //   420: aconst_null
        //   421: invokeinterface 155 2 0
        //   426: pop
        //   427: aload_2
        //   428: athrow
        //   429: astore 4
        //   431: aload_0
        //   432: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   435: invokevirtual 109	io/netty/util/concurrent/SingleThreadEventExecutor:cleanup	()V
        //   438: invokestatic 114	io/netty/util/concurrent/FastThreadLocal:removeAll	()V
        //   441: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   444: aload_0
        //   445: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   448: iconst_5
        //   449: invokevirtual 118	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:set	(Ljava/lang/Object;I)V
        //   452: aload_0
        //   453: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   456: invokestatic 122	io/netty/util/concurrent/SingleThreadEventExecutor:access$700	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Ljava/util/concurrent/CountDownLatch;
        //   459: invokevirtual 127	java/util/concurrent/CountDownLatch:countDown	()V
        //   462: aload_0
        //   463: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   466: invokevirtual 131	io/netty/util/concurrent/SingleThreadEventExecutor:drainTasks	()I
        //   469: istore_1
        //   470: iload_1
        //   471: ifle +56 -> 527
        //   474: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   477: invokeinterface 134 1 0
        //   482: ifeq +45 -> 527
        //   485: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   488: astore_2
        //   489: new 77	java/lang/StringBuilder
        //   492: dup
        //   493: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   496: astore_3
        //   497: aload_3
        //   498: ldc -120
        //   500: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   503: pop
        //   504: aload_3
        //   505: iload_1
        //   506: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   509: pop
        //   510: aload_3
        //   511: bipush 41
        //   513: invokevirtual 142	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   516: pop
        //   517: aload_2
        //   518: aload_3
        //   519: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   522: invokeinterface 145 2 0
        //   527: aload_0
        //   528: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   531: invokestatic 149	io/netty/util/concurrent/SingleThreadEventExecutor:access$800	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Lio/netty/util/concurrent/Promise;
        //   534: aconst_null
        //   535: invokeinterface 155 2 0
        //   540: pop
        //   541: aload 4
        //   543: athrow
        //   544: astore_2
        //   545: invokestatic 114	io/netty/util/concurrent/FastThreadLocal:removeAll	()V
        //   548: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   551: aload_0
        //   552: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   555: iconst_5
        //   556: invokevirtual 118	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:set	(Ljava/lang/Object;I)V
        //   559: aload_0
        //   560: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   563: invokestatic 122	io/netty/util/concurrent/SingleThreadEventExecutor:access$700	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Ljava/util/concurrent/CountDownLatch;
        //   566: invokevirtual 127	java/util/concurrent/CountDownLatch:countDown	()V
        //   569: aload_0
        //   570: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   573: invokevirtual 131	io/netty/util/concurrent/SingleThreadEventExecutor:drainTasks	()I
        //   576: istore_1
        //   577: iload_1
        //   578: ifle +61 -> 639
        //   581: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   584: invokeinterface 134 1 0
        //   589: ifeq +50 -> 639
        //   592: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   595: astore_3
        //   596: new 77	java/lang/StringBuilder
        //   599: dup
        //   600: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   603: astore 4
        //   605: aload 4
        //   607: ldc -120
        //   609: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   612: pop
        //   613: aload 4
        //   615: iload_1
        //   616: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   619: pop
        //   620: aload 4
        //   622: bipush 41
        //   624: invokevirtual 142	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   627: pop
        //   628: aload_3
        //   629: aload 4
        //   631: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   634: invokeinterface 145 2 0
        //   639: aload_0
        //   640: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   643: invokestatic 149	io/netty/util/concurrent/SingleThreadEventExecutor:access$800	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Lio/netty/util/concurrent/Promise;
        //   646: aconst_null
        //   647: invokeinterface 155 2 0
        //   652: pop
        //   653: aload_2
        //   654: athrow
        //   655: astore_3
        //   656: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   659: ldc -99
        //   661: aload_3
        //   662: invokeinterface 160 3 0
        //   667: aload_0
        //   668: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   671: invokestatic 51	io/netty/util/concurrent/SingleThreadEventExecutor:access$400	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)I
        //   674: istore_1
        //   675: iload_1
        //   676: iconst_3
        //   677: if_icmpge +18 -> 695
        //   680: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   683: aload_0
        //   684: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   687: iload_1
        //   688: iconst_3
        //   689: invokevirtual 61	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:compareAndSet	(Ljava/lang/Object;II)Z
        //   692: ifeq -25 -> 667
        //   695: aload_0
        //   696: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   699: invokevirtual 106	io/netty/util/concurrent/SingleThreadEventExecutor:confirmShutdown	()Z
        //   702: ifeq -7 -> 695
        //   705: aload_0
        //   706: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   709: invokestatic 51	io/netty/util/concurrent/SingleThreadEventExecutor:access$400	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)I
        //   712: istore_1
        //   713: iload_1
        //   714: iconst_4
        //   715: if_icmpge +18 -> 733
        //   718: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   721: aload_0
        //   722: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   725: iload_1
        //   726: iconst_4
        //   727: invokevirtual 61	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:compareAndSet	(Ljava/lang/Object;II)Z
        //   730: ifeq -25 -> 705
        //   733: aload_0
        //   734: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   737: invokevirtual 106	io/netty/util/concurrent/SingleThreadEventExecutor:confirmShutdown	()Z
        //   740: pop
        //   741: aload_0
        //   742: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   745: invokevirtual 109	io/netty/util/concurrent/SingleThreadEventExecutor:cleanup	()V
        //   748: invokestatic 114	io/netty/util/concurrent/FastThreadLocal:removeAll	()V
        //   751: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   754: aload_0
        //   755: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   758: iconst_5
        //   759: invokevirtual 118	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:set	(Ljava/lang/Object;I)V
        //   762: aload_0
        //   763: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   766: invokestatic 122	io/netty/util/concurrent/SingleThreadEventExecutor:access$700	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Ljava/util/concurrent/CountDownLatch;
        //   769: invokevirtual 127	java/util/concurrent/CountDownLatch:countDown	()V
        //   772: aload_0
        //   773: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   776: invokevirtual 131	io/netty/util/concurrent/SingleThreadEventExecutor:drainTasks	()I
        //   779: istore_1
        //   780: iload_1
        //   781: ifle -480 -> 301
        //   784: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   787: invokeinterface 134 1 0
        //   792: ifeq -491 -> 301
        //   795: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   798: astore_2
        //   799: new 77	java/lang/StringBuilder
        //   802: dup
        //   803: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   806: astore_3
        //   807: goto -536 -> 271
        //   810: return
        //   811: astore_2
        //   812: invokestatic 114	io/netty/util/concurrent/FastThreadLocal:removeAll	()V
        //   815: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   818: aload_0
        //   819: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   822: iconst_5
        //   823: invokevirtual 118	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:set	(Ljava/lang/Object;I)V
        //   826: aload_0
        //   827: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   830: invokestatic 122	io/netty/util/concurrent/SingleThreadEventExecutor:access$700	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Ljava/util/concurrent/CountDownLatch;
        //   833: invokevirtual 127	java/util/concurrent/CountDownLatch:countDown	()V
        //   836: aload_0
        //   837: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   840: invokevirtual 131	io/netty/util/concurrent/SingleThreadEventExecutor:drainTasks	()I
        //   843: istore_1
        //   844: iload_1
        //   845: ifle +61 -> 906
        //   848: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   851: invokeinterface 134 1 0
        //   856: ifeq +50 -> 906
        //   859: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   862: astore_3
        //   863: new 77	java/lang/StringBuilder
        //   866: dup
        //   867: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   870: astore 4
        //   872: aload 4
        //   874: ldc -120
        //   876: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   879: pop
        //   880: aload 4
        //   882: iload_1
        //   883: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   886: pop
        //   887: aload 4
        //   889: bipush 41
        //   891: invokevirtual 142	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   894: pop
        //   895: aload_3
        //   896: aload 4
        //   898: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   901: invokeinterface 145 2 0
        //   906: aload_0
        //   907: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   910: invokestatic 149	io/netty/util/concurrent/SingleThreadEventExecutor:access$800	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Lio/netty/util/concurrent/Promise;
        //   913: aconst_null
        //   914: invokeinterface 155 2 0
        //   919: pop
        //   920: aload_2
        //   921: athrow
        //   922: astore_2
        //   923: aload_0
        //   924: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   927: invokevirtual 109	io/netty/util/concurrent/SingleThreadEventExecutor:cleanup	()V
        //   930: invokestatic 114	io/netty/util/concurrent/FastThreadLocal:removeAll	()V
        //   933: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   936: aload_0
        //   937: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   940: iconst_5
        //   941: invokevirtual 118	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:set	(Ljava/lang/Object;I)V
        //   944: aload_0
        //   945: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   948: invokestatic 122	io/netty/util/concurrent/SingleThreadEventExecutor:access$700	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Ljava/util/concurrent/CountDownLatch;
        //   951: invokevirtual 127	java/util/concurrent/CountDownLatch:countDown	()V
        //   954: aload_0
        //   955: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   958: invokevirtual 131	io/netty/util/concurrent/SingleThreadEventExecutor:drainTasks	()I
        //   961: istore_1
        //   962: iload_1
        //   963: ifle +61 -> 1024
        //   966: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   969: invokeinterface 134 1 0
        //   974: ifeq +50 -> 1024
        //   977: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   980: astore_3
        //   981: new 77	java/lang/StringBuilder
        //   984: dup
        //   985: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   988: astore 4
        //   990: aload 4
        //   992: ldc -120
        //   994: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   997: pop
        //   998: aload 4
        //   1000: iload_1
        //   1001: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   1004: pop
        //   1005: aload 4
        //   1007: bipush 41
        //   1009: invokevirtual 142	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   1012: pop
        //   1013: aload_3
        //   1014: aload 4
        //   1016: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1019: invokeinterface 145 2 0
        //   1024: aload_0
        //   1025: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1028: invokestatic 149	io/netty/util/concurrent/SingleThreadEventExecutor:access$800	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Lio/netty/util/concurrent/Promise;
        //   1031: aconst_null
        //   1032: invokeinterface 155 2 0
        //   1037: pop
        //   1038: aload_2
        //   1039: athrow
        //   1040: astore 4
        //   1042: invokestatic 114	io/netty/util/concurrent/FastThreadLocal:removeAll	()V
        //   1045: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   1048: aload_0
        //   1049: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1052: iconst_5
        //   1053: invokevirtual 118	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:set	(Ljava/lang/Object;I)V
        //   1056: aload_0
        //   1057: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1060: invokestatic 122	io/netty/util/concurrent/SingleThreadEventExecutor:access$700	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Ljava/util/concurrent/CountDownLatch;
        //   1063: invokevirtual 127	java/util/concurrent/CountDownLatch:countDown	()V
        //   1066: aload_0
        //   1067: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1070: invokevirtual 131	io/netty/util/concurrent/SingleThreadEventExecutor:drainTasks	()I
        //   1073: istore_1
        //   1074: iload_1
        //   1075: ifle +56 -> 1131
        //   1078: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   1081: invokeinterface 134 1 0
        //   1086: ifeq +45 -> 1131
        //   1089: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   1092: astore_3
        //   1093: new 77	java/lang/StringBuilder
        //   1096: dup
        //   1097: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   1100: astore_2
        //   1101: aload_2
        //   1102: ldc -120
        //   1104: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1107: pop
        //   1108: aload_2
        //   1109: iload_1
        //   1110: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   1113: pop
        //   1114: aload_2
        //   1115: bipush 41
        //   1117: invokevirtual 142	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   1120: pop
        //   1121: aload_3
        //   1122: aload_2
        //   1123: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1126: invokeinterface 145 2 0
        //   1131: aload_0
        //   1132: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1135: invokestatic 149	io/netty/util/concurrent/SingleThreadEventExecutor:access$800	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Lio/netty/util/concurrent/Promise;
        //   1138: aconst_null
        //   1139: invokeinterface 155 2 0
        //   1144: pop
        //   1145: aload 4
        //   1147: athrow
        //   1148: astore_3
        //   1149: aload_0
        //   1150: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1153: invokestatic 51	io/netty/util/concurrent/SingleThreadEventExecutor:access$400	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)I
        //   1156: istore_1
        //   1157: iload_1
        //   1158: iconst_3
        //   1159: if_icmpge +18 -> 1177
        //   1162: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   1165: aload_0
        //   1166: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1169: iload_1
        //   1170: iconst_3
        //   1171: invokevirtual 61	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:compareAndSet	(Ljava/lang/Object;II)Z
        //   1174: ifeq -25 -> 1149
        //   1177: aload_0
        //   1178: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1181: invokevirtual 106	io/netty/util/concurrent/SingleThreadEventExecutor:confirmShutdown	()Z
        //   1184: ifeq -7 -> 1177
        //   1187: aload_0
        //   1188: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1191: invokestatic 51	io/netty/util/concurrent/SingleThreadEventExecutor:access$400	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)I
        //   1194: istore_1
        //   1195: iload_1
        //   1196: iconst_4
        //   1197: if_icmpge +18 -> 1215
        //   1200: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   1203: aload_0
        //   1204: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1207: iload_1
        //   1208: iconst_4
        //   1209: invokevirtual 61	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:compareAndSet	(Ljava/lang/Object;II)Z
        //   1212: ifeq -25 -> 1187
        //   1215: aload_0
        //   1216: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1219: invokevirtual 106	io/netty/util/concurrent/SingleThreadEventExecutor:confirmShutdown	()Z
        //   1222: pop
        //   1223: aload_0
        //   1224: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1227: invokevirtual 109	io/netty/util/concurrent/SingleThreadEventExecutor:cleanup	()V
        //   1230: invokestatic 114	io/netty/util/concurrent/FastThreadLocal:removeAll	()V
        //   1233: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   1236: aload_0
        //   1237: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1240: iconst_5
        //   1241: invokevirtual 118	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:set	(Ljava/lang/Object;I)V
        //   1244: aload_0
        //   1245: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1248: invokestatic 122	io/netty/util/concurrent/SingleThreadEventExecutor:access$700	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Ljava/util/concurrent/CountDownLatch;
        //   1251: invokevirtual 127	java/util/concurrent/CountDownLatch:countDown	()V
        //   1254: aload_0
        //   1255: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1258: invokevirtual 131	io/netty/util/concurrent/SingleThreadEventExecutor:drainTasks	()I
        //   1261: istore_1
        //   1262: iload_1
        //   1263: ifle +58 -> 1321
        //   1266: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   1269: invokeinterface 134 1 0
        //   1274: ifeq +47 -> 1321
        //   1277: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   1280: astore 4
        //   1282: new 77	java/lang/StringBuilder
        //   1285: dup
        //   1286: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   1289: astore_2
        //   1290: aload_2
        //   1291: ldc -120
        //   1293: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1296: pop
        //   1297: aload_2
        //   1298: iload_1
        //   1299: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   1302: pop
        //   1303: aload_2
        //   1304: bipush 41
        //   1306: invokevirtual 142	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   1309: pop
        //   1310: aload 4
        //   1312: aload_2
        //   1313: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1316: invokeinterface 145 2 0
        //   1321: aload_0
        //   1322: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1325: invokestatic 149	io/netty/util/concurrent/SingleThreadEventExecutor:access$800	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Lio/netty/util/concurrent/Promise;
        //   1328: aconst_null
        //   1329: invokeinterface 155 2 0
        //   1334: pop
        //   1335: aload_3
        //   1336: athrow
        //   1337: astore_2
        //   1338: invokestatic 114	io/netty/util/concurrent/FastThreadLocal:removeAll	()V
        //   1341: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   1344: aload_0
        //   1345: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1348: iconst_5
        //   1349: invokevirtual 118	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:set	(Ljava/lang/Object;I)V
        //   1352: aload_0
        //   1353: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1356: invokestatic 122	io/netty/util/concurrent/SingleThreadEventExecutor:access$700	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Ljava/util/concurrent/CountDownLatch;
        //   1359: invokevirtual 127	java/util/concurrent/CountDownLatch:countDown	()V
        //   1362: aload_0
        //   1363: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1366: invokevirtual 131	io/netty/util/concurrent/SingleThreadEventExecutor:drainTasks	()I
        //   1369: istore_1
        //   1370: iload_1
        //   1371: ifle +58 -> 1429
        //   1374: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   1377: invokeinterface 134 1 0
        //   1382: ifeq +47 -> 1429
        //   1385: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   1388: astore 4
        //   1390: new 77	java/lang/StringBuilder
        //   1393: dup
        //   1394: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   1397: astore_3
        //   1398: aload_3
        //   1399: ldc -120
        //   1401: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1404: pop
        //   1405: aload_3
        //   1406: iload_1
        //   1407: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   1410: pop
        //   1411: aload_3
        //   1412: bipush 41
        //   1414: invokevirtual 142	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   1417: pop
        //   1418: aload 4
        //   1420: aload_3
        //   1421: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1424: invokeinterface 145 2 0
        //   1429: aload_0
        //   1430: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1433: invokestatic 149	io/netty/util/concurrent/SingleThreadEventExecutor:access$800	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Lio/netty/util/concurrent/Promise;
        //   1436: aconst_null
        //   1437: invokeinterface 155 2 0
        //   1442: pop
        //   1443: aload_2
        //   1444: athrow
        //   1445: astore_2
        //   1446: aload_0
        //   1447: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1450: invokevirtual 109	io/netty/util/concurrent/SingleThreadEventExecutor:cleanup	()V
        //   1453: invokestatic 114	io/netty/util/concurrent/FastThreadLocal:removeAll	()V
        //   1456: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   1459: aload_0
        //   1460: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1463: iconst_5
        //   1464: invokevirtual 118	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:set	(Ljava/lang/Object;I)V
        //   1467: aload_0
        //   1468: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1471: invokestatic 122	io/netty/util/concurrent/SingleThreadEventExecutor:access$700	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Ljava/util/concurrent/CountDownLatch;
        //   1474: invokevirtual 127	java/util/concurrent/CountDownLatch:countDown	()V
        //   1477: aload_0
        //   1478: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1481: invokevirtual 131	io/netty/util/concurrent/SingleThreadEventExecutor:drainTasks	()I
        //   1484: istore_1
        //   1485: iload_1
        //   1486: ifle +58 -> 1544
        //   1489: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   1492: invokeinterface 134 1 0
        //   1497: ifeq +47 -> 1544
        //   1500: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   1503: astore 4
        //   1505: new 77	java/lang/StringBuilder
        //   1508: dup
        //   1509: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   1512: astore_3
        //   1513: aload_3
        //   1514: ldc -120
        //   1516: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1519: pop
        //   1520: aload_3
        //   1521: iload_1
        //   1522: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   1525: pop
        //   1526: aload_3
        //   1527: bipush 41
        //   1529: invokevirtual 142	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   1532: pop
        //   1533: aload 4
        //   1535: aload_3
        //   1536: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1539: invokeinterface 145 2 0
        //   1544: aload_0
        //   1545: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1548: invokestatic 149	io/netty/util/concurrent/SingleThreadEventExecutor:access$800	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Lio/netty/util/concurrent/Promise;
        //   1551: aconst_null
        //   1552: invokeinterface 155 2 0
        //   1557: pop
        //   1558: aload_2
        //   1559: athrow
        //   1560: astore_3
        //   1561: invokestatic 114	io/netty/util/concurrent/FastThreadLocal:removeAll	()V
        //   1564: invokestatic 55	io/netty/util/concurrent/SingleThreadEventExecutor:access$500	()Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
        //   1567: aload_0
        //   1568: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1571: iconst_5
        //   1572: invokevirtual 118	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:set	(Ljava/lang/Object;I)V
        //   1575: aload_0
        //   1576: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1579: invokestatic 122	io/netty/util/concurrent/SingleThreadEventExecutor:access$700	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Ljava/util/concurrent/CountDownLatch;
        //   1582: invokevirtual 127	java/util/concurrent/CountDownLatch:countDown	()V
        //   1585: aload_0
        //   1586: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1589: invokevirtual 131	io/netty/util/concurrent/SingleThreadEventExecutor:drainTasks	()I
        //   1592: istore_1
        //   1593: iload_1
        //   1594: ifle +58 -> 1652
        //   1597: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   1600: invokeinterface 134 1 0
        //   1605: ifeq +47 -> 1652
        //   1608: invokestatic 69	io/netty/util/concurrent/SingleThreadEventExecutor:access$300	()Lio/netty/util/internal/logging/InternalLogger;
        //   1611: astore 4
        //   1613: new 77	java/lang/StringBuilder
        //   1616: dup
        //   1617: invokespecial 78	java/lang/StringBuilder:<init>	()V
        //   1620: astore_2
        //   1621: aload_2
        //   1622: ldc -120
        //   1624: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1627: pop
        //   1628: aload_2
        //   1629: iload_1
        //   1630: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   1633: pop
        //   1634: aload_2
        //   1635: bipush 41
        //   1637: invokevirtual 142	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   1640: pop
        //   1641: aload 4
        //   1643: aload_2
        //   1644: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1647: invokeinterface 145 2 0
        //   1652: aload_0
        //   1653: getfield 17	io/netty/util/concurrent/SingleThreadEventExecutor$4:this$0	Lio/netty/util/concurrent/SingleThreadEventExecutor;
        //   1656: invokestatic 149	io/netty/util/concurrent/SingleThreadEventExecutor:access$800	(Lio/netty/util/concurrent/SingleThreadEventExecutor;)Lio/netty/util/concurrent/Promise;
        //   1659: aconst_null
        //   1660: invokeinterface 155 2 0
        //   1665: pop
        //   1666: aload_3
        //   1667: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1668	0	this	4
        //   52	1578	1	i	int
        //   99	193	2	localInternalLogger1	InternalLogger
        //   318	110	2	localObject1	Object
        //   488	30	2	localInternalLogger2	InternalLogger
        //   544	110	2	localObject2	Object
        //   798	1	2	localInternalLogger3	InternalLogger
        //   811	110	2	localObject3	Object
        //   922	117	2	localObject4	Object
        //   1100	213	2	localStringBuilder1	StringBuilder
        //   1337	107	2	localObject5	Object
        //   1445	114	2	localObject6	Object
        //   1620	24	2	localStringBuilder2	StringBuilder
        //   107	522	3	localObject7	Object
        //   655	7	3	localThrowable	Throwable
        //   806	316	3	localObject8	Object
        //   1148	188	3	localObject9	Object
        //   1397	139	3	localStringBuilder3	StringBuilder
        //   1560	107	3	localObject10	Object
        //   377	27	4	localStringBuilder4	StringBuilder
        //   429	113	4	localObject11	Object
        //   603	412	4	localStringBuilder5	StringBuilder
        //   1040	106	4	localObject12	Object
        //   1280	362	4	localInternalLogger4	InternalLogger
        // Exception table:
        //   from	to	target	type
        //   205	212	318	finally
        //   159	169	429	finally
        //   169	177	429	finally
        //   182	197	429	finally
        //   197	205	429	finally
        //   431	438	544	finally
        //   38	45	655	finally
        //   741	748	811	finally
        //   695	705	922	finally
        //   705	713	922	finally
        //   718	733	922	finally
        //   733	741	922	finally
        //   923	930	1040	finally
        //   656	667	1148	finally
        //   1223	1230	1337	finally
        //   1177	1187	1445	finally
        //   1187	1195	1445	finally
        //   1200	1215	1445	finally
        //   1215	1223	1445	finally
        //   1446	1453	1560	finally
      }
    });
  }
  
  /* Error */
  private boolean ensureThreadStarted(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: iconst_1
    //   2: if_icmpne +43 -> 45
    //   5: aload_0
    //   6: invokespecial 260	io/netty/util/concurrent/SingleThreadEventExecutor:doStartThread	()V
    //   9: goto +36 -> 45
    //   12: astore_2
    //   13: getstatic 112	io/netty/util/concurrent/SingleThreadEventExecutor:STATE_UPDATER	Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
    //   16: aload_0
    //   17: iconst_5
    //   18: invokevirtual 264	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:set	(Ljava/lang/Object;I)V
    //   21: aload_0
    //   22: getfield 175	io/netty/util/concurrent/SingleThreadEventExecutor:terminationFuture	Lio/netty/util/concurrent/Promise;
    //   25: aload_2
    //   26: invokeinterface 270 2 0
    //   31: pop
    //   32: aload_2
    //   33: instanceof 272
    //   36: ifne +7 -> 43
    //   39: aload_2
    //   40: invokestatic 278	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   43: iconst_1
    //   44: ireturn
    //   45: iconst_0
    //   46: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	SingleThreadEventExecutor
    //   0	47	1	paramInt	int
    //   12	28	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   5	9	12	finally
  }
  
  private void execute(Runnable paramRunnable, boolean paramBoolean)
  {
    boolean bool1 = inEventLoop();
    addTask(paramRunnable);
    if (!bool1)
    {
      startThread();
      if (isShutdown())
      {
        int i = 0;
        try
        {
          boolean bool2 = removeTask(paramRunnable);
          i = bool2;
        }
        catch (UnsupportedOperationException paramRunnable) {}
        if (i != 0) {
          reject();
        }
      }
    }
    if ((!this.addTaskWakesUp) && (paramBoolean)) {
      wakeup(bool1);
    }
  }
  
  private boolean executeExpiredScheduledTasks()
  {
    Object localObject = this.scheduledTaskQueue;
    if ((localObject != null) && (!((Queue)localObject).isEmpty()))
    {
      long l = AbstractScheduledEventExecutor.nanoTime();
      Runnable localRunnable = pollScheduledTask(l);
      localObject = localRunnable;
      if (localRunnable == null) {
        return false;
      }
      do
      {
        AbstractEventExecutor.safeExecute((Runnable)localObject);
        localRunnable = pollScheduledTask(l);
        localObject = localRunnable;
      } while (localRunnable != null);
      return true;
    }
    return false;
  }
  
  private boolean fetchFromScheduledTaskQueue()
  {
    Object localObject = this.scheduledTaskQueue;
    if ((localObject != null) && (!((Queue)localObject).isEmpty()))
    {
      long l = AbstractScheduledEventExecutor.nanoTime();
      do
      {
        localObject = pollScheduledTask(l);
        if (localObject == null) {
          return true;
        }
      } while (this.taskQueue.offer(localObject));
      this.scheduledTaskQueue.add((ScheduledFutureTask)localObject);
      return false;
    }
    return true;
  }
  
  protected static Runnable pollTaskFrom(Queue<Runnable> paramQueue)
  {
    Runnable localRunnable;
    do
    {
      localRunnable = (Runnable)paramQueue.poll();
    } while (localRunnable == AbstractScheduledEventExecutor.WAKEUP_TASK);
    return localRunnable;
  }
  
  protected static void reject()
  {
    throw new RejectedExecutionException("event executor terminated");
  }
  
  private boolean runExistingTasksFrom(Queue<Runnable> paramQueue)
  {
    Runnable localRunnable = pollTaskFrom(paramQueue);
    if (localRunnable == null) {
      return false;
    }
    int i = Math.min(this.maxPendingTasks, paramQueue.size());
    AbstractEventExecutor.safeExecute(localRunnable);
    while (i > 0)
    {
      localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null) {
        break;
      }
      AbstractEventExecutor.safeExecute(localRunnable);
      i--;
    }
    return true;
  }
  
  /* Error */
  private boolean runShutdownHooks()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 160	io/netty/util/concurrent/SingleThreadEventExecutor:shutdownHooks	Ljava/util/Set;
    //   6: invokeinterface 370 1 0
    //   11: ifne +80 -> 91
    //   14: new 372	java/util/ArrayList
    //   17: dup
    //   18: aload_0
    //   19: getfield 160	io/netty/util/concurrent/SingleThreadEventExecutor:shutdownHooks	Ljava/util/Set;
    //   22: invokespecial 375	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 160	io/netty/util/concurrent/SingleThreadEventExecutor:shutdownHooks	Ljava/util/Set;
    //   30: invokeinterface 378 1 0
    //   35: aload_2
    //   36: invokeinterface 384 1 0
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 389 1 0
    //   48: ifeq -46 -> 2
    //   51: aload_2
    //   52: invokeinterface 392 1 0
    //   57: checkcast 343	java/lang/Runnable
    //   60: astore_3
    //   61: aload_3
    //   62: invokeinterface 395 1 0
    //   67: goto +16 -> 83
    //   70: astore_3
    //   71: getstatic 98	io/netty/util/concurrent/SingleThreadEventExecutor:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   74: ldc_w 397
    //   77: aload_3
    //   78: invokeinterface 403 3 0
    //   83: iconst_1
    //   84: istore_1
    //   85: goto -43 -> 42
    //   88: astore_2
    //   89: aload_2
    //   90: athrow
    //   91: iload_1
    //   92: ifeq +10 -> 102
    //   95: aload_0
    //   96: invokestatic 404	io/netty/util/concurrent/ScheduledFutureTask:nanoTime	()J
    //   99: putfield 406	io/netty/util/concurrent/SingleThreadEventExecutor:lastExecutionTime	J
    //   102: iload_1
    //   103: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	SingleThreadEventExecutor
    //   1	102	1	bool	boolean
    //   25	27	2	localObject1	Object
    //   88	2	2	localObject2	Object
    //   60	2	3	localRunnable	Runnable
    //   70	8	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   61	67	70	finally
    //   71	83	88	finally
  }
  
  /* Error */
  private void startThread()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 162	io/netty/util/concurrent/SingleThreadEventExecutor:state	I
    //   4: iconst_1
    //   5: if_icmpne +35 -> 40
    //   8: getstatic 112	io/netty/util/concurrent/SingleThreadEventExecutor:STATE_UPDATER	Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
    //   11: aload_0
    //   12: iconst_1
    //   13: iconst_2
    //   14: invokevirtual 410	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:compareAndSet	(Ljava/lang/Object;II)Z
    //   17: ifeq +23 -> 40
    //   20: aload_0
    //   21: invokespecial 260	io/netty/util/concurrent/SingleThreadEventExecutor:doStartThread	()V
    //   24: goto +16 -> 40
    //   27: astore_1
    //   28: getstatic 112	io/netty/util/concurrent/SingleThreadEventExecutor:STATE_UPDATER	Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
    //   31: aload_0
    //   32: iconst_2
    //   33: iconst_1
    //   34: invokevirtual 410	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:compareAndSet	(Ljava/lang/Object;II)Z
    //   37: pop
    //   38: aload_1
    //   39: athrow
    //   40: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	SingleThreadEventExecutor
    //   27	12	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	24	27	finally
  }
  
  private void throwIfInEventLoop(String paramString)
  {
    if (!inEventLoop()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Calling ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" from within the EventLoop is not allowed");
    throw new RejectedExecutionException(localStringBuilder.toString());
  }
  
  public void addShutdownHook(final Runnable paramRunnable)
  {
    if (inEventLoop()) {
      this.shutdownHooks.add(paramRunnable);
    } else {
      execute(new Runnable()
      {
        public void run()
        {
          SingleThreadEventExecutor.this.shutdownHooks.add(paramRunnable);
        }
      });
    }
  }
  
  protected void addTask(Runnable paramRunnable)
  {
    ObjectUtil.checkNotNull(paramRunnable, "task");
    if (!offerTask(paramRunnable)) {
      reject(paramRunnable);
    }
  }
  
  protected void afterRunningAllTasks() {}
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    ObjectUtil.checkNotNull(paramTimeUnit, "unit");
    if (!inEventLoop())
    {
      this.threadLock.await(paramLong, paramTimeUnit);
      return isTerminated();
    }
    throw new IllegalStateException("cannot await termination of the current thread");
  }
  
  protected void cleanup() {}
  
  protected boolean confirmShutdown()
  {
    if (!isShuttingDown()) {
      return false;
    }
    if (inEventLoop())
    {
      cancelScheduledTasks();
      if (this.gracefulShutdownStartTime == 0L) {
        this.gracefulShutdownStartTime = ScheduledFutureTask.nanoTime();
      }
      if ((!runAllTasks()) && (!runShutdownHooks()))
      {
        long l = ScheduledFutureTask.nanoTime();
        if ((!isShutdown()) && (l - this.gracefulShutdownStartTime <= this.gracefulShutdownTimeout) && (l - this.lastExecutionTime <= this.gracefulShutdownQuietPeriod)) {
          this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
        }
      }
    }
    try
    {
      Thread.sleep(100L);
      return false;
      return true;
      if (isShutdown()) {
        return true;
      }
      if (this.gracefulShutdownQuietPeriod == 0L) {
        return true;
      }
      this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
      return false;
      throw new IllegalStateException("must be invoked from an event loop");
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  protected long deadlineNanos()
  {
    ScheduledFutureTask localScheduledFutureTask = peekScheduledTask();
    if (localScheduledFutureTask == null) {
      return AbstractScheduledEventExecutor.nanoTime() + SCHEDULE_PURGE_INTERVAL;
    }
    return localScheduledFutureTask.deadlineNanos();
  }
  
  protected long delayNanos(long paramLong)
  {
    ScheduledFutureTask localScheduledFutureTask = peekScheduledTask();
    if (localScheduledFutureTask == null) {
      return SCHEDULE_PURGE_INTERVAL;
    }
    return localScheduledFutureTask.delayNanos(paramLong);
  }
  
  final int drainTasks()
  {
    int i = 0;
    for (;;)
    {
      Runnable localRunnable = (Runnable)this.taskQueue.poll();
      if (localRunnable == null) {
        return i;
      }
      if (AbstractScheduledEventExecutor.WAKEUP_TASK != localRunnable) {
        i++;
      }
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    ObjectUtil.checkNotNull(paramRunnable, "task");
    boolean bool;
    if (wakesUpForTask(paramRunnable)) {
      bool = true;
    } else {
      bool = false;
    }
    execute(paramRunnable, bool);
  }
  
  protected boolean hasTasks()
  {
    return this.taskQueue.isEmpty() ^ true;
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
  
  protected void interruptThread()
  {
    Thread localThread = this.thread;
    if (localThread == null) {
      this.interrupted = true;
    } else {
      localThread.interrupt();
    }
  }
  
  public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection)
    throws InterruptedException
  {
    throwIfInEventLoop("invokeAll");
    return super.invokeAll(paramCollection);
  }
  
  public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    throwIfInEventLoop("invokeAll");
    return super.invokeAll(paramCollection, paramLong, paramTimeUnit);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection)
    throws InterruptedException, ExecutionException
  {
    throwIfInEventLoop("invokeAny");
    return (T)super.invokeAny(paramCollection);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    throwIfInEventLoop("invokeAny");
    return (T)super.invokeAny(paramCollection, paramLong, paramTimeUnit);
  }
  
  public boolean isShutdown()
  {
    boolean bool;
    if (this.state >= 4) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isShuttingDown()
  {
    boolean bool;
    if (this.state >= 3) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isTerminated()
  {
    boolean bool;
    if (this.state == 5) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void lazyExecute(Runnable paramRunnable)
  {
    execute((Runnable)ObjectUtil.checkNotNull(paramRunnable, "task"), false);
  }
  
  @Deprecated
  protected Queue<Runnable> newTaskQueue()
  {
    return newTaskQueue(this.maxPendingTasks);
  }
  
  protected Queue<Runnable> newTaskQueue(int paramInt)
  {
    return new LinkedBlockingQueue(paramInt);
  }
  
  final boolean offerTask(Runnable paramRunnable)
  {
    if (isShutdown()) {
      reject();
    }
    return this.taskQueue.offer(paramRunnable);
  }
  
  protected Runnable peekTask()
  {
    return (Runnable)this.taskQueue.peek();
  }
  
  public int pendingTasks()
  {
    return this.taskQueue.size();
  }
  
  protected Runnable pollTask()
  {
    return pollTaskFrom(this.taskQueue);
  }
  
  protected final void reject(Runnable paramRunnable)
  {
    this.rejectedExecutionHandler.rejected(paramRunnable, this);
  }
  
  public void removeShutdownHook(final Runnable paramRunnable)
  {
    if (inEventLoop()) {
      this.shutdownHooks.remove(paramRunnable);
    } else {
      execute(new Runnable()
      {
        public void run()
        {
          SingleThreadEventExecutor.this.shutdownHooks.remove(paramRunnable);
        }
      });
    }
  }
  
  protected boolean removeTask(Runnable paramRunnable)
  {
    return this.taskQueue.remove(ObjectUtil.checkNotNull(paramRunnable, "task"));
  }
  
  protected abstract void run();
  
  protected boolean runAllTasks()
  {
    boolean bool1 = false;
    boolean bool2;
    boolean bool3;
    do
    {
      bool2 = fetchFromScheduledTaskQueue();
      bool3 = bool1;
      if (runAllTasksFrom(this.taskQueue)) {
        bool3 = true;
      }
      bool1 = bool3;
    } while (!bool2);
    if (bool3) {
      this.lastExecutionTime = ScheduledFutureTask.nanoTime();
    }
    afterRunningAllTasks();
    return bool3;
  }
  
  protected boolean runAllTasks(long paramLong)
  {
    fetchFromScheduledTaskQueue();
    Object localObject = pollTask();
    if (localObject == null)
    {
      afterRunningAllTasks();
      return false;
    }
    if (paramLong > 0L) {
      paramLong = ScheduledFutureTask.nanoTime() + paramLong;
    } else {
      paramLong = 0L;
    }
    long l1 = 0L;
    Runnable localRunnable;
    do
    {
      AbstractEventExecutor.safeExecute((Runnable)localObject);
      long l2 = l1 + 1L;
      if ((0x3F & l2) == 0L)
      {
        l1 = ScheduledFutureTask.nanoTime();
        if (l1 >= paramLong)
        {
          paramLong = l1;
          break;
        }
      }
      localRunnable = pollTask();
      localObject = localRunnable;
      l1 = l2;
    } while (localRunnable != null);
    paramLong = ScheduledFutureTask.nanoTime();
    afterRunningAllTasks();
    this.lastExecutionTime = paramLong;
    return true;
  }
  
  protected final boolean runAllTasksFrom(Queue<Runnable> paramQueue)
  {
    Runnable localRunnable1 = pollTaskFrom(paramQueue);
    Runnable localRunnable2 = localRunnable1;
    if (localRunnable1 == null) {
      return false;
    }
    do
    {
      AbstractEventExecutor.safeExecute(localRunnable2);
      localRunnable1 = pollTaskFrom(paramQueue);
      localRunnable2 = localRunnable1;
    } while (localRunnable1 != null);
    return true;
  }
  
  protected final boolean runScheduledAndExecutorTasks(int paramInt)
  {
    boolean bool = false;
    int i = 0;
    int j;
    do
    {
      j = i;
      if (!(runExistingTasksFrom(this.taskQueue) | executeExpiredScheduledTasks())) {
        break;
      }
      j = i + 1;
      i = j;
    } while (j < paramInt);
    if (j > 0) {
      this.lastExecutionTime = ScheduledFutureTask.nanoTime();
    }
    afterRunningAllTasks();
    if (j > 0) {
      bool = true;
    }
    return bool;
  }
  
  @Deprecated
  public void shutdown()
  {
    if (isShutdown()) {
      return;
    }
    boolean bool = inEventLoop();
    int i;
    int m;
    int n;
    do
    {
      if (isShuttingDown()) {
        return;
      }
      i = this.state;
      int j = 4;
      int k = 1;
      if (bool)
      {
        m = j;
        n = k;
      }
      else
      {
        m = j;
        n = k;
        if (i != 1)
        {
          m = j;
          n = k;
          if (i != 2)
          {
            m = j;
            n = k;
            if (i != 3)
            {
              n = 0;
              m = i;
            }
          }
        }
      }
    } while (!STATE_UPDATER.compareAndSet(this, i, m));
    if (ensureThreadStarted(i)) {
      return;
    }
    if (n != 0)
    {
      this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
      if (!this.addTaskWakesUp) {
        wakeup(bool);
      }
    }
  }
  
  public Future<?> shutdownGracefully(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    ObjectUtil.checkPositiveOrZero(paramLong1, "quietPeriod");
    if (paramLong2 >= paramLong1)
    {
      ObjectUtil.checkNotNull(paramTimeUnit, "unit");
      if (isShuttingDown()) {
        return terminationFuture();
      }
      boolean bool = inEventLoop();
      int i;
      int m;
      int n;
      do
      {
        if (isShuttingDown()) {
          return terminationFuture();
        }
        i = this.state;
        int j = 3;
        int k = 1;
        if (bool)
        {
          m = j;
          n = k;
        }
        else
        {
          m = j;
          n = k;
          if (i != 1)
          {
            m = j;
            n = k;
            if (i != 2)
            {
              n = 0;
              m = i;
            }
          }
        }
      } while (!STATE_UPDATER.compareAndSet(this, i, m));
      this.gracefulShutdownQuietPeriod = paramTimeUnit.toNanos(paramLong1);
      this.gracefulShutdownTimeout = paramTimeUnit.toNanos(paramLong2);
      if (ensureThreadStarted(i)) {
        return this.terminationFuture;
      }
      if (n != 0)
      {
        this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
        if (!this.addTaskWakesUp) {
          wakeup(bool);
        }
      }
      return terminationFuture();
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("timeout: ");
    paramTimeUnit.append(paramLong2);
    paramTimeUnit.append(" (expected >= quietPeriod (");
    paramTimeUnit.append(paramLong1);
    paramTimeUnit.append("))");
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  protected Runnable takeTask()
  {
    Object localObject1 = this.taskQueue;
    if ((localObject1 instanceof BlockingQueue))
    {
      Object localObject2 = (BlockingQueue)localObject1;
      Object localObject3;
      do
      {
        ScheduledFutureTask localScheduledFutureTask = peekScheduledTask();
        localObject3 = null;
        localObject1 = null;
        if (localScheduledFutureTask == null) {}
        for (;;)
        {
          try
          {
            localObject3 = (Runnable)((BlockingQueue)localObject2).take();
          }
          catch (InterruptedException localInterruptedException3)
          {
            long l;
            continue;
          }
          try
          {
            localObject2 = AbstractScheduledEventExecutor.WAKEUP_TASK;
            if (localObject3 != localObject2) {}
          }
          catch (InterruptedException localInterruptedException2) {}
        }
        localObject1 = localObject3;
        return (Runnable)localObject1;
        l = localScheduledFutureTask.delayNanos();
        localObject1 = localObject3;
        if (l > 0L) {
          try
          {
            localObject1 = (Runnable)((BlockingQueue)localObject2).poll(l, TimeUnit.NANOSECONDS);
          }
          catch (InterruptedException localInterruptedException1)
          {
            return null;
          }
        }
        localObject3 = localInterruptedException1;
        if (localInterruptedException1 == null)
        {
          fetchFromScheduledTaskQueue();
          localObject3 = (Runnable)((BlockingQueue)localObject2).poll();
        }
      } while (localObject3 == null);
      return (Runnable)localObject3;
    }
    throw new UnsupportedOperationException();
  }
  
  public Future<?> terminationFuture()
  {
    return this.terminationFuture;
  }
  
  public final ThreadProperties threadProperties()
  {
    Object localObject1 = this.threadProperties;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = this.thread;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        submit(NOOP_TASK).syncUninterruptibly();
        localObject2 = this.thread;
      }
      localObject2 = new DefaultThreadProperties((Thread)localObject2);
      if (!PROPERTIES_UPDATER.compareAndSet(this, null, localObject2)) {
        localObject2 = this.threadProperties;
      }
    }
    return (ThreadProperties)localObject2;
  }
  
  protected void updateLastExecutionTime()
  {
    this.lastExecutionTime = ScheduledFutureTask.nanoTime();
  }
  
  protected boolean wakesUpForTask(Runnable paramRunnable)
  {
    return true;
  }
  
  protected void wakeup(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
    }
  }
  
  private static final class DefaultThreadProperties
    implements ThreadProperties
  {
    private final Thread t;
    
    DefaultThreadProperties(Thread paramThread)
    {
      this.t = paramThread;
    }
    
    public long id()
    {
      return this.t.getId();
    }
    
    public boolean isAlive()
    {
      return this.t.isAlive();
    }
    
    public boolean isDaemon()
    {
      return this.t.isDaemon();
    }
    
    public boolean isInterrupted()
    {
      return this.t.isInterrupted();
    }
    
    public String name()
    {
      return this.t.getName();
    }
    
    public int priority()
    {
      return this.t.getPriority();
    }
    
    public StackTraceElement[] stackTrace()
    {
      return this.t.getStackTrace();
    }
    
    public Thread.State state()
    {
      return this.t.getState();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\SingleThreadEventExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */