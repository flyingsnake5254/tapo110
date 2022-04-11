package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DefaultPromise<V>
  extends AbstractFuture<V>
  implements Promise<V>
{
  private static final CauseHolder CANCELLATION_CAUSE_HOLDER;
  private static final StackTraceElement[] CANCELLATION_STACK;
  private static final int MAX_LISTENER_STACK_DEPTH;
  private static final AtomicReferenceFieldUpdater<DefaultPromise, Object> RESULT_UPDATER;
  private static final Object SUCCESS;
  private static final Object UNCANCELLABLE;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultPromise.class);
  private static final InternalLogger rejectedExecutionLogger;
  private final EventExecutor executor;
  private Object listeners;
  private boolean notifyingListeners;
  private volatile Object result;
  private short waiters;
  
  static
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(DefaultPromise.class.getName());
    ((StringBuilder)localObject).append(".rejectedExecution");
    rejectedExecutionLogger = InternalLoggerFactory.getInstance(((StringBuilder)localObject).toString());
    MAX_LISTENER_STACK_DEPTH = Math.min(8, SystemPropertyUtil.getInt("io.netty.defaultPromise.maxListenerStackDepth", 8));
    RESULT_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultPromise.class, Object.class, "result");
    SUCCESS = new Object();
    UNCANCELLABLE = new Object();
    localObject = new CauseHolder(ThrowableUtil.unknownStackTrace(new CancellationException(), DefaultPromise.class, "cancel(...)"));
    CANCELLATION_CAUSE_HOLDER = (CauseHolder)localObject;
    CANCELLATION_STACK = ((CauseHolder)localObject).cause.getStackTrace();
  }
  
  protected DefaultPromise()
  {
    this.executor = null;
  }
  
  public DefaultPromise(EventExecutor paramEventExecutor)
  {
    this.executor = ((EventExecutor)ObjectUtil.checkNotNull(paramEventExecutor, "executor"));
  }
  
  private void addListener0(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener)
  {
    Object localObject = this.listeners;
    if (localObject == null) {
      this.listeners = paramGenericFutureListener;
    } else if ((localObject instanceof DefaultFutureListeners)) {
      ((DefaultFutureListeners)localObject).add(paramGenericFutureListener);
    } else {
      this.listeners = new DefaultFutureListeners((GenericFutureListener)localObject, paramGenericFutureListener);
    }
  }
  
  /* Error */
  private boolean await0(long paramLong, boolean paramBoolean)
    throws InterruptedException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 198	io/netty/util/concurrent/DefaultPromise:isDone	()Z
    //   4: istore 4
    //   6: iconst_1
    //   7: istore 5
    //   9: iload 4
    //   11: ifeq +5 -> 16
    //   14: iconst_1
    //   15: ireturn
    //   16: lload_1
    //   17: lconst_0
    //   18: lcmp
    //   19: ifgt +8 -> 27
    //   22: aload_0
    //   23: invokevirtual 198	io/netty/util/concurrent/DefaultPromise:isDone	()Z
    //   26: ireturn
    //   27: iload_3
    //   28: ifeq +24 -> 52
    //   31: invokestatic 203	java/lang/Thread:interrupted	()Z
    //   34: ifne +6 -> 40
    //   37: goto +15 -> 52
    //   40: new 194	java/lang/InterruptedException
    //   43: dup
    //   44: aload_0
    //   45: invokevirtual 204	io/netty/util/concurrent/DefaultPromise:toString	()Ljava/lang/String;
    //   48: invokespecial 207	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   51: athrow
    //   52: aload_0
    //   53: invokevirtual 210	io/netty/util/concurrent/DefaultPromise:checkDeadLock	()V
    //   56: invokestatic 216	java/lang/System:nanoTime	()J
    //   59: lstore 6
    //   61: iconst_0
    //   62: istore 8
    //   64: lload_1
    //   65: lstore 9
    //   67: iload 8
    //   69: istore 11
    //   71: aload_0
    //   72: monitorenter
    //   73: iload 8
    //   75: istore 11
    //   77: aload_0
    //   78: invokevirtual 198	io/netty/util/concurrent/DefaultPromise:isDone	()Z
    //   81: ifeq +22 -> 103
    //   84: iload 8
    //   86: istore 11
    //   88: aload_0
    //   89: monitorexit
    //   90: iload 8
    //   92: ifeq +9 -> 101
    //   95: invokestatic 220	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   98: invokevirtual 223	java/lang/Thread:interrupt	()V
    //   101: iconst_1
    //   102: ireturn
    //   103: iload 8
    //   105: istore 11
    //   107: aload_0
    //   108: invokespecial 226	io/netty/util/concurrent/DefaultPromise:incWaiters	()V
    //   111: aload_0
    //   112: lload 9
    //   114: ldc2_w 227
    //   117: ldiv
    //   118: lload 9
    //   120: ldc2_w 227
    //   123: lrem
    //   124: l2i
    //   125: invokevirtual 232	java/lang/Object:wait	(JI)V
    //   128: iload 8
    //   130: istore 11
    //   132: aload_0
    //   133: invokespecial 235	io/netty/util/concurrent/DefaultPromise:decWaiters	()V
    //   136: iload 8
    //   138: istore 12
    //   140: goto +25 -> 165
    //   143: astore 13
    //   145: goto +108 -> 253
    //   148: astore 13
    //   150: iload_3
    //   151: ifne +99 -> 250
    //   154: iload 5
    //   156: istore 12
    //   158: aload_0
    //   159: invokespecial 235	io/netty/util/concurrent/DefaultPromise:decWaiters	()V
    //   162: iconst_1
    //   163: istore 12
    //   165: iload 12
    //   167: istore 11
    //   169: aload_0
    //   170: monitorexit
    //   171: iload 12
    //   173: istore 11
    //   175: aload_0
    //   176: invokevirtual 198	io/netty/util/concurrent/DefaultPromise:isDone	()Z
    //   179: istore 4
    //   181: iload 4
    //   183: ifeq +16 -> 199
    //   186: iload 12
    //   188: ifeq +9 -> 197
    //   191: invokestatic 220	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   194: invokevirtual 223	java/lang/Thread:interrupt	()V
    //   197: iconst_1
    //   198: ireturn
    //   199: iload 12
    //   201: istore 11
    //   203: lload_1
    //   204: invokestatic 216	java/lang/System:nanoTime	()J
    //   207: lload 6
    //   209: lsub
    //   210: lsub
    //   211: lstore 14
    //   213: iload 12
    //   215: istore 8
    //   217: lload 14
    //   219: lstore 9
    //   221: lload 14
    //   223: lconst_0
    //   224: lcmp
    //   225: ifgt -158 -> 67
    //   228: iload 12
    //   230: istore 11
    //   232: aload_0
    //   233: invokevirtual 198	io/netty/util/concurrent/DefaultPromise:isDone	()Z
    //   236: istore_3
    //   237: iload 12
    //   239: ifeq +9 -> 248
    //   242: invokestatic 220	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   245: invokevirtual 223	java/lang/Thread:interrupt	()V
    //   248: iload_3
    //   249: ireturn
    //   250: aload 13
    //   252: athrow
    //   253: iload 8
    //   255: istore 11
    //   257: aload_0
    //   258: invokespecial 235	io/netty/util/concurrent/DefaultPromise:decWaiters	()V
    //   261: iload 8
    //   263: istore 11
    //   265: aload 13
    //   267: athrow
    //   268: astore 13
    //   270: iload 11
    //   272: istore 8
    //   274: iload 8
    //   276: istore 12
    //   278: aload_0
    //   279: monitorexit
    //   280: aload 13
    //   282: athrow
    //   283: astore 13
    //   285: goto +18 -> 303
    //   288: astore 13
    //   290: iload 12
    //   292: istore 8
    //   294: goto -20 -> 274
    //   297: astore 13
    //   299: iload 11
    //   301: istore 8
    //   303: iload 8
    //   305: ifeq +9 -> 314
    //   308: invokestatic 220	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   311: invokevirtual 223	java/lang/Thread:interrupt	()V
    //   314: aload 13
    //   316: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	DefaultPromise
    //   0	317	1	paramLong	long
    //   0	317	3	paramBoolean	boolean
    //   4	178	4	bool	boolean
    //   7	148	5	i	int
    //   59	149	6	l1	long
    //   62	242	8	j	int
    //   65	155	9	l2	long
    //   69	231	11	k	int
    //   138	153	12	m	int
    //   143	1	13	localObject1	Object
    //   148	118	13	localInterruptedException	InterruptedException
    //   268	13	13	localObject2	Object
    //   283	1	13	localObject3	Object
    //   288	1	13	localObject4	Object
    //   297	18	13	localObject5	Object
    //   211	11	14	l3	long
    // Exception table:
    //   from	to	target	type
    //   111	128	143	finally
    //   250	253	143	finally
    //   111	128	148	java/lang/InterruptedException
    //   77	84	268	finally
    //   88	90	268	finally
    //   107	111	268	finally
    //   132	136	268	finally
    //   169	171	268	finally
    //   257	261	268	finally
    //   265	268	268	finally
    //   280	283	283	finally
    //   158	162	288	finally
    //   278	280	288	finally
    //   71	73	297	finally
    //   175	181	297	finally
    //   203	213	297	finally
    //   232	237	297	finally
  }
  
  private Throwable cause0(Object paramObject)
  {
    if (!(paramObject instanceof CauseHolder)) {
      return null;
    }
    CauseHolder localCauseHolder = CANCELLATION_CAUSE_HOLDER;
    Object localObject = paramObject;
    if (paramObject == localCauseHolder)
    {
      paramObject = new LeanCancellationException(null);
      if (RESULT_UPDATER.compareAndSet(this, localCauseHolder, new CauseHolder((Throwable)paramObject))) {
        return (Throwable)paramObject;
      }
      localObject = this.result;
    }
    return ((CauseHolder)localObject).cause;
  }
  
  private boolean checkNotifyWaiters()
  {
    try
    {
      if (this.waiters > 0) {
        notifyAll();
      }
      Object localObject1 = this.listeners;
      boolean bool;
      if (localObject1 != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally {}
  }
  
  private void decWaiters()
  {
    this.waiters = ((short)(short)(this.waiters - 1));
  }
  
  private void incWaiters()
  {
    int i = this.waiters;
    if (i != 32767)
    {
      this.waiters = ((short)(short)(i + 1));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("too many waiters: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private static boolean isCancelled0(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof CauseHolder)) && ((((CauseHolder)paramObject).cause instanceof CancellationException))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean isDone0(Object paramObject)
  {
    boolean bool;
    if ((paramObject != null) && (paramObject != UNCANCELLABLE)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected static void notifyListener(EventExecutor paramEventExecutor, Future<?> paramFuture, GenericFutureListener<?> paramGenericFutureListener)
  {
    notifyListenerWithStackOverFlowProtection((EventExecutor)ObjectUtil.checkNotNull(paramEventExecutor, "eventExecutor"), (Future)ObjectUtil.checkNotNull(paramFuture, "future"), (GenericFutureListener)ObjectUtil.checkNotNull(paramGenericFutureListener, "listener"));
  }
  
  /* Error */
  private static void notifyListener0(Future paramFuture, GenericFutureListener paramGenericFutureListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: invokeinterface 282 2 0
    //   7: goto +66 -> 73
    //   10: astore_2
    //   11: getstatic 54	io/netty/util/concurrent/DefaultPromise:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   14: invokeinterface 287 1 0
    //   19: ifeq +54 -> 73
    //   22: getstatic 54	io/netty/util/concurrent/DefaultPromise:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   25: astore_0
    //   26: new 56	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: ldc_w 289
    //   38: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_3
    //   43: aload_1
    //   44: invokevirtual 293	java/lang/Object:getClass	()Ljava/lang/Class;
    //   47: invokevirtual 65	java/lang/Class:getName	()Ljava/lang/String;
    //   50: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: ldc_w 295
    //   58: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_0
    //   63: aload_3
    //   64: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: aload_2
    //   68: invokeinterface 299 3 0
    //   73: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramFuture	Future
    //   0	74	1	paramGenericFutureListener	GenericFutureListener
    //   10	58	2	localThrowable	Throwable
    //   33	31	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	7	10	finally
  }
  
  private static void notifyListenerWithStackOverFlowProtection(EventExecutor paramEventExecutor, Future<?> paramFuture, final GenericFutureListener<?> paramGenericFutureListener)
  {
    if (paramEventExecutor.inEventLoop())
    {
      InternalThreadLocalMap localInternalThreadLocalMap = InternalThreadLocalMap.get();
      int i = localInternalThreadLocalMap.futureListenerStackDepth();
      if (i < MAX_LISTENER_STACK_DEPTH)
      {
        localInternalThreadLocalMap.setFutureListenerStackDepth(i + 1);
        try
        {
          notifyListener0(paramFuture, paramGenericFutureListener);
          return;
        }
        finally
        {
          localInternalThreadLocalMap.setFutureListenerStackDepth(i);
        }
      }
    }
    safeExecute(paramEventExecutor, new Runnable()
    {
      public void run()
      {
        DefaultPromise.notifyListener0(this.val$future, paramGenericFutureListener);
      }
    });
  }
  
  private void notifyListeners()
  {
    EventExecutor localEventExecutor1 = executor();
    if (localEventExecutor1.inEventLoop())
    {
      InternalThreadLocalMap localInternalThreadLocalMap = InternalThreadLocalMap.get();
      int i = localInternalThreadLocalMap.futureListenerStackDepth();
      if (i < MAX_LISTENER_STACK_DEPTH)
      {
        localInternalThreadLocalMap.setFutureListenerStackDepth(i + 1);
        try
        {
          notifyListenersNow();
          return;
        }
        finally
        {
          localInternalThreadLocalMap.setFutureListenerStackDepth(i);
        }
      }
    }
    safeExecute(localEventExecutor2, new Runnable()
    {
      public void run()
      {
        DefaultPromise.this.notifyListenersNow();
      }
    });
  }
  
  private void notifyListeners0(DefaultFutureListeners paramDefaultFutureListeners)
  {
    GenericFutureListener[] arrayOfGenericFutureListener = paramDefaultFutureListeners.listeners();
    int i = paramDefaultFutureListeners.size();
    for (int j = 0; j < i; j++) {
      notifyListener0(this, arrayOfGenericFutureListener[j]);
    }
  }
  
  private void notifyListenersNow()
  {
    try
    {
      if (!this.notifyingListeners)
      {
        Object localObject1 = this.listeners;
        if (localObject1 != null)
        {
          this.notifyingListeners = true;
          this.listeners = null;
          for (;;)
          {
            if ((localObject1 instanceof DefaultFutureListeners)) {
              notifyListeners0((DefaultFutureListeners)localObject1);
            } else {
              notifyListener0(this, (GenericFutureListener)localObject1);
            }
            try
            {
              localObject1 = this.listeners;
              if (localObject1 == null)
              {
                this.notifyingListeners = false;
                return;
              }
              this.listeners = null;
            }
            finally {}
          }
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private static void notifyProgressiveListener0(ProgressiveFuture paramProgressiveFuture, GenericProgressiveFutureListener paramGenericProgressiveFutureListener, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: lload_2
    //   3: lload 4
    //   5: invokeinterface 346 6 0
    //   10: goto +70 -> 80
    //   13: astore 6
    //   15: getstatic 54	io/netty/util/concurrent/DefaultPromise:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   18: invokeinterface 287 1 0
    //   23: ifeq +57 -> 80
    //   26: getstatic 54	io/netty/util/concurrent/DefaultPromise:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   29: astore 7
    //   31: new 56	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   38: astore_0
    //   39: aload_0
    //   40: ldc_w 289
    //   43: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 293	java/lang/Object:getClass	()Ljava/lang/Class;
    //   52: invokevirtual 65	java/lang/Class:getName	()Ljava/lang/String;
    //   55: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_0
    //   60: ldc_w 348
    //   63: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 7
    //   69: aload_0
    //   70: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: aload 6
    //   75: invokeinterface 299 3 0
    //   80: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	paramProgressiveFuture	ProgressiveFuture
    //   0	81	1	paramGenericProgressiveFutureListener	GenericProgressiveFutureListener
    //   0	81	2	paramLong1	long
    //   0	81	4	paramLong2	long
    //   13	61	6	localThrowable	Throwable
    //   29	39	7	localInternalLogger	InternalLogger
    // Exception table:
    //   from	to	target	type
    //   0	10	13	finally
  }
  
  private static void notifyProgressiveListeners0(ProgressiveFuture<?> paramProgressiveFuture, GenericProgressiveFutureListener<?>[] paramArrayOfGenericProgressiveFutureListener, long paramLong1, long paramLong2)
  {
    int i = paramArrayOfGenericProgressiveFutureListener.length;
    for (int j = 0; j < i; j++)
    {
      GenericProgressiveFutureListener<?> localGenericProgressiveFutureListener = paramArrayOfGenericProgressiveFutureListener[j];
      if (localGenericProgressiveFutureListener == null) {
        break;
      }
      notifyProgressiveListener0(paramProgressiveFuture, localGenericProgressiveFutureListener, paramLong1, paramLong2);
    }
  }
  
  private Object progressiveListeners()
  {
    try
    {
      Object localObject1 = this.listeners;
      if (localObject1 == null) {
        return null;
      }
      if ((localObject1 instanceof DefaultFutureListeners))
      {
        localObject1 = (DefaultFutureListeners)localObject1;
        int i = ((DefaultFutureListeners)localObject1).progressiveSize();
        if (i != 0)
        {
          int j = 0;
          int k = 0;
          if (i != 1)
          {
            GenericFutureListener[] arrayOfGenericFutureListener = ((DefaultFutureListeners)localObject1).listeners();
            localObject3 = new GenericProgressiveFutureListener[i];
            j = 0;
            while (k < i)
            {
              localObject1 = arrayOfGenericFutureListener[j];
              int m = k;
              if ((localObject1 instanceof GenericProgressiveFutureListener))
              {
                localObject3[k] = ((GenericProgressiveFutureListener)localObject1);
                m = k + 1;
              }
              j++;
              k = m;
            }
            return localObject3;
          }
          Object localObject3 = ((DefaultFutureListeners)localObject1).listeners();
          k = localObject3.length;
          while (j < k)
          {
            localObject1 = localObject3[j];
            bool = localObject1 instanceof GenericProgressiveFutureListener;
            if (bool) {
              return localObject1;
            }
            j++;
          }
          return null;
        }
        return null;
      }
      boolean bool = localObject1 instanceof GenericProgressiveFutureListener;
      if (bool) {
        return localObject1;
      }
      return null;
    }
    finally {}
  }
  
  private void removeListener0(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener)
  {
    Object localObject = this.listeners;
    if ((localObject instanceof DefaultFutureListeners)) {
      ((DefaultFutureListeners)localObject).remove(paramGenericFutureListener);
    } else if (localObject == paramGenericFutureListener) {
      this.listeners = null;
    }
  }
  
  private void rethrowIfFailed()
  {
    Throwable localThrowable = cause();
    if (localThrowable == null) {
      return;
    }
    PlatformDependent.throwException(localThrowable);
  }
  
  /* Error */
  private static void safeExecute(EventExecutor paramEventExecutor, Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokeinterface 373 2 0
    //   7: goto +16 -> 23
    //   10: astore_0
    //   11: getstatic 79	io/netty/util/concurrent/DefaultPromise:rejectedExecutionLogger	Lio/netty/util/internal/logging/InternalLogger;
    //   14: ldc_w 375
    //   17: aload_0
    //   18: invokeinterface 378 3 0
    //   23: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	paramEventExecutor	EventExecutor
    //   0	24	1	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   0	7	10	finally
  }
  
  private boolean setFailure0(Throwable paramThrowable)
  {
    return setValue0(new CauseHolder((Throwable)ObjectUtil.checkNotNull(paramThrowable, "cause")));
  }
  
  private boolean setSuccess0(V paramV)
  {
    Object localObject = paramV;
    if (paramV == null) {
      localObject = SUCCESS;
    }
    return setValue0(localObject);
  }
  
  private boolean setValue0(Object paramObject)
  {
    AtomicReferenceFieldUpdater localAtomicReferenceFieldUpdater = RESULT_UPDATER;
    if ((!localAtomicReferenceFieldUpdater.compareAndSet(this, null, paramObject)) && (!localAtomicReferenceFieldUpdater.compareAndSet(this, UNCANCELLABLE, paramObject))) {
      return false;
    }
    if (checkNotifyWaiters()) {
      notifyListeners();
    }
    return true;
  }
  
  public Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener)
  {
    ObjectUtil.checkNotNull(paramGenericFutureListener, "listener");
    try
    {
      addListener0(paramGenericFutureListener);
      if (isDone()) {
        notifyListeners();
      }
      return this;
    }
    finally {}
  }
  
  public Promise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "listeners");
    try
    {
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++)
      {
        GenericFutureListener<? extends Future<? super V>> localGenericFutureListener = paramVarArgs[j];
        if (localGenericFutureListener == null) {
          break;
        }
        addListener0(localGenericFutureListener);
      }
      if (isDone()) {
        notifyListeners();
      }
      return this;
    }
    finally {}
  }
  
  /* Error */
  public Promise<V> await()
    throws InterruptedException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 198	io/netty/util/concurrent/DefaultPromise:isDone	()Z
    //   4: ifeq +5 -> 9
    //   7: aload_0
    //   8: areturn
    //   9: invokestatic 203	java/lang/Thread:interrupted	()Z
    //   12: ifne +47 -> 59
    //   15: aload_0
    //   16: invokevirtual 210	io/netty/util/concurrent/DefaultPromise:checkDeadLock	()V
    //   19: aload_0
    //   20: monitorenter
    //   21: aload_0
    //   22: invokevirtual 198	io/netty/util/concurrent/DefaultPromise:isDone	()Z
    //   25: ifne +25 -> 50
    //   28: aload_0
    //   29: invokespecial 226	io/netty/util/concurrent/DefaultPromise:incWaiters	()V
    //   32: aload_0
    //   33: invokevirtual 412	java/lang/Object:wait	()V
    //   36: aload_0
    //   37: invokespecial 235	io/netty/util/concurrent/DefaultPromise:decWaiters	()V
    //   40: goto -19 -> 21
    //   43: astore_1
    //   44: aload_0
    //   45: invokespecial 235	io/netty/util/concurrent/DefaultPromise:decWaiters	()V
    //   48: aload_1
    //   49: athrow
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_0
    //   53: areturn
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    //   59: new 194	java/lang/InterruptedException
    //   62: dup
    //   63: aload_0
    //   64: invokevirtual 204	io/netty/util/concurrent/DefaultPromise:toString	()Ljava/lang/String;
    //   67: invokespecial 207	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	DefaultPromise
    //   43	6	1	localObject1	Object
    //   54	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	36	43	finally
    //   21	32	54	finally
    //   36	40	54	finally
    //   44	50	54	finally
    //   50	52	54	finally
    //   55	57	54	finally
  }
  
  public boolean await(long paramLong)
    throws InterruptedException
  {
    return await0(TimeUnit.MILLISECONDS.toNanos(paramLong), true);
  }
  
  public boolean await(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return await0(paramTimeUnit.toNanos(paramLong), true);
  }
  
  /* Error */
  public Promise<V> awaitUninterruptibly()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 198	io/netty/util/concurrent/DefaultPromise:isDone	()Z
    //   4: ifeq +5 -> 9
    //   7: aload_0
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 210	io/netty/util/concurrent/DefaultPromise:checkDeadLock	()V
    //   13: iconst_0
    //   14: istore_1
    //   15: aload_0
    //   16: monitorenter
    //   17: aload_0
    //   18: invokevirtual 198	io/netty/util/concurrent/DefaultPromise:isDone	()Z
    //   21: ifne +31 -> 52
    //   24: aload_0
    //   25: invokespecial 226	io/netty/util/concurrent/DefaultPromise:incWaiters	()V
    //   28: aload_0
    //   29: invokevirtual 412	java/lang/Object:wait	()V
    //   32: aload_0
    //   33: invokespecial 235	io/netty/util/concurrent/DefaultPromise:decWaiters	()V
    //   36: goto -19 -> 17
    //   39: astore_2
    //   40: aload_0
    //   41: invokespecial 235	io/netty/util/concurrent/DefaultPromise:decWaiters	()V
    //   44: aload_2
    //   45: athrow
    //   46: astore_2
    //   47: iconst_1
    //   48: istore_1
    //   49: goto -17 -> 32
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_1
    //   55: ifeq +9 -> 64
    //   58: invokestatic 220	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   61: invokevirtual 223	java/lang/Thread:interrupt	()V
    //   64: aload_0
    //   65: areturn
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	DefaultPromise
    //   14	41	1	i	int
    //   39	6	2	localObject1	Object
    //   46	1	2	localInterruptedException	InterruptedException
    //   66	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	32	39	finally
    //   28	32	46	java/lang/InterruptedException
    //   17	28	66	finally
    //   32	36	66	finally
    //   40	46	66	finally
    //   52	54	66	finally
    //   67	69	66	finally
  }
  
  public boolean awaitUninterruptibly(long paramLong)
  {
    try
    {
      boolean bool = await0(TimeUnit.MILLISECONDS.toNanos(paramLong), false);
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new InternalError();
    }
  }
  
  public boolean awaitUninterruptibly(long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = await0(paramTimeUnit.toNanos(paramLong), false);
      return bool;
    }
    catch (InterruptedException paramTimeUnit)
    {
      throw new InternalError();
    }
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    if (RESULT_UPDATER.compareAndSet(this, null, CANCELLATION_CAUSE_HOLDER))
    {
      if (checkNotifyWaiters()) {
        notifyListeners();
      }
      return true;
    }
    return false;
  }
  
  public Throwable cause()
  {
    return cause0(this.result);
  }
  
  protected void checkDeadLock()
  {
    EventExecutor localEventExecutor = executor();
    if ((localEventExecutor != null) && (localEventExecutor.inEventLoop())) {
      throw new BlockingOperationException(toString());
    }
  }
  
  protected EventExecutor executor()
  {
    return this.executor;
  }
  
  public V get()
    throws InterruptedException, ExecutionException
  {
    Object localObject1 = this.result;
    Object localObject2 = localObject1;
    if (!isDone0(localObject1))
    {
      await();
      localObject2 = this.result;
    }
    if ((localObject2 != SUCCESS) && (localObject2 != UNCANCELLABLE))
    {
      localObject1 = cause0(localObject2);
      if (localObject1 == null) {
        return (V)localObject2;
      }
      if ((localObject1 instanceof CancellationException)) {
        throw ((CancellationException)localObject1);
      }
      throw new ExecutionException((Throwable)localObject1);
    }
    return null;
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    Object localObject1 = this.result;
    Object localObject2 = localObject1;
    if (!isDone0(localObject1)) {
      if (await(paramLong, paramTimeUnit)) {
        localObject2 = this.result;
      } else {
        throw new TimeoutException();
      }
    }
    if ((localObject2 != SUCCESS) && (localObject2 != UNCANCELLABLE))
    {
      paramTimeUnit = cause0(localObject2);
      if (paramTimeUnit == null) {
        return (V)localObject2;
      }
      if ((paramTimeUnit instanceof CancellationException)) {
        throw ((CancellationException)paramTimeUnit);
      }
      throw new ExecutionException(paramTimeUnit);
    }
    return null;
  }
  
  public V getNow()
  {
    Object localObject = this.result;
    if ((!(localObject instanceof CauseHolder)) && (localObject != SUCCESS) && (localObject != UNCANCELLABLE)) {
      return (V)localObject;
    }
    return null;
  }
  
  public boolean isCancellable()
  {
    boolean bool;
    if (this.result == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isCancelled()
  {
    return isCancelled0(this.result);
  }
  
  public boolean isDone()
  {
    return isDone0(this.result);
  }
  
  public boolean isSuccess()
  {
    Object localObject = this.result;
    boolean bool;
    if ((localObject != null) && (localObject != UNCANCELLABLE) && (!(localObject instanceof CauseHolder))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void notifyProgressiveListeners(final long paramLong1, long paramLong2)
  {
    final Object localObject = progressiveListeners();
    if (localObject == null) {
      return;
    }
    final ProgressiveFuture localProgressiveFuture = (ProgressiveFuture)this;
    EventExecutor localEventExecutor = executor();
    if (localEventExecutor.inEventLoop())
    {
      if ((localObject instanceof GenericProgressiveFutureListener[])) {
        notifyProgressiveListeners0(localProgressiveFuture, (GenericProgressiveFutureListener[])localObject, paramLong1, paramLong2);
      } else {
        notifyProgressiveListener0(localProgressiveFuture, (GenericProgressiveFutureListener)localObject, paramLong1, paramLong2);
      }
    }
    else if ((localObject instanceof GenericProgressiveFutureListener[])) {
      safeExecute(localEventExecutor, new Runnable()
      {
        public void run()
        {
          DefaultPromise.notifyProgressiveListeners0(localProgressiveFuture, localObject, paramLong1, this.val$total);
        }
      });
    } else {
      safeExecute(localEventExecutor, new Runnable()
      {
        public void run()
        {
          DefaultPromise.notifyProgressiveListener0(localProgressiveFuture, localObject, paramLong1, this.val$total);
        }
      });
    }
  }
  
  public Promise<V> removeListener(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener)
  {
    ObjectUtil.checkNotNull(paramGenericFutureListener, "listener");
    try
    {
      removeListener0(paramGenericFutureListener);
      return this;
    }
    finally {}
  }
  
  public Promise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "listeners");
    try
    {
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++)
      {
        GenericFutureListener<? extends Future<? super V>> localGenericFutureListener = paramVarArgs[j];
        if (localGenericFutureListener == null) {
          break;
        }
        removeListener0(localGenericFutureListener);
      }
      return this;
    }
    finally {}
  }
  
  public Promise<V> setFailure(Throwable paramThrowable)
  {
    if (setFailure0(paramThrowable)) {
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("complete already: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString(), paramThrowable);
  }
  
  public Promise<V> setSuccess(V paramV)
  {
    if (setSuccess0(paramV)) {
      return this;
    }
    paramV = new StringBuilder();
    paramV.append("complete already: ");
    paramV.append(this);
    throw new IllegalStateException(paramV.toString());
  }
  
  public boolean setUncancellable()
  {
    boolean bool1 = RESULT_UPDATER.compareAndSet(this, null, UNCANCELLABLE);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    Object localObject = this.result;
    bool1 = bool2;
    if (isDone0(localObject)) {
      if (!isCancelled0(localObject)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public Promise<V> sync()
    throws InterruptedException
  {
    await();
    rethrowIfFailed();
    return this;
  }
  
  public Promise<V> syncUninterruptibly()
  {
    awaitUninterruptibly();
    rethrowIfFailed();
    return this;
  }
  
  public String toString()
  {
    return toStringBuilder().toString();
  }
  
  protected StringBuilder toStringBuilder()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(hashCode()));
    Object localObject = this.result;
    if (localObject == SUCCESS)
    {
      localStringBuilder.append("(success)");
    }
    else if (localObject == UNCANCELLABLE)
    {
      localStringBuilder.append("(uncancellable)");
    }
    else if ((localObject instanceof CauseHolder))
    {
      localStringBuilder.append("(failure: ");
      localStringBuilder.append(((CauseHolder)localObject).cause);
      localStringBuilder.append(')');
    }
    else if (localObject != null)
    {
      localStringBuilder.append("(success: ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(')');
    }
    else
    {
      localStringBuilder.append("(incomplete)");
    }
    return localStringBuilder;
  }
  
  public boolean tryFailure(Throwable paramThrowable)
  {
    return setFailure0(paramThrowable);
  }
  
  public boolean trySuccess(V paramV)
  {
    return setSuccess0(paramV);
  }
  
  private static final class CauseHolder
  {
    final Throwable cause;
    
    CauseHolder(Throwable paramThrowable)
    {
      this.cause = paramThrowable;
    }
  }
  
  private static final class LeanCancellationException
    extends CancellationException
  {
    private static final long serialVersionUID = 2794674970981187807L;
    
    public Throwable fillInStackTrace()
    {
      setStackTrace(DefaultPromise.CANCELLATION_STACK);
      return this;
    }
    
    public String toString()
    {
      return CancellationException.class.getName();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\DefaultPromise.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */