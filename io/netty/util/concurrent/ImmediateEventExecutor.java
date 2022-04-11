package io.netty.util.concurrent;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public final class ImmediateEventExecutor
  extends AbstractEventExecutor
{
  private static final FastThreadLocal<Queue<Runnable>> DELAYED_RUNNABLES = new FastThreadLocal()
  {
    protected Queue<Runnable> initialValue()
      throws Exception
    {
      return new ArrayDeque();
    }
  };
  public static final ImmediateEventExecutor INSTANCE;
  private static final FastThreadLocal<Boolean> RUNNING = new FastThreadLocal()
  {
    protected Boolean initialValue()
      throws Exception
    {
      return Boolean.FALSE;
    }
  };
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ImmediateEventExecutor.class);
  private final Future<?> terminationFuture = new FailedFuture(GlobalEventExecutor.INSTANCE, new UnsupportedOperationException());
  
  static
  {
    INSTANCE = new ImmediateEventExecutor();
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    return false;
  }
  
  /* Error */
  public void execute(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 70
    //   3: invokestatic 76	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: getstatic 47	io/netty/util/concurrent/ImmediateEventExecutor:RUNNING	Lio/netty/util/concurrent/FastThreadLocal;
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 82	io/netty/util/concurrent/FastThreadLocal:get	()Ljava/lang/Object;
    //   15: checkcast 84	java/lang/Boolean
    //   18: invokevirtual 88	java/lang/Boolean:booleanValue	()Z
    //   21: ifne +202 -> 223
    //   24: aload_2
    //   25: getstatic 92	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   28: invokevirtual 96	io/netty/util/concurrent/FastThreadLocal:set	(Ljava/lang/Object;)V
    //   31: aload_1
    //   32: invokeinterface 101 1 0
    //   37: getstatic 44	io/netty/util/concurrent/ImmediateEventExecutor:DELAYED_RUNNABLES	Lio/netty/util/concurrent/FastThreadLocal;
    //   40: invokevirtual 82	io/netty/util/concurrent/FastThreadLocal:get	()Ljava/lang/Object;
    //   43: checkcast 103	java/util/Queue
    //   46: astore_1
    //   47: aload_1
    //   48: invokeinterface 106 1 0
    //   53: checkcast 98	java/lang/Runnable
    //   56: astore_2
    //   57: aload_2
    //   58: ifnull +28 -> 86
    //   61: aload_2
    //   62: invokeinterface 101 1 0
    //   67: goto -20 -> 47
    //   70: astore_3
    //   71: getstatic 36	io/netty/util/concurrent/ImmediateEventExecutor:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   74: ldc 108
    //   76: aload_2
    //   77: aload_3
    //   78: invokeinterface 114 4 0
    //   83: goto -36 -> 47
    //   86: getstatic 47	io/netty/util/concurrent/ImmediateEventExecutor:RUNNING	Lio/netty/util/concurrent/FastThreadLocal;
    //   89: getstatic 117	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   92: invokevirtual 96	io/netty/util/concurrent/FastThreadLocal:set	(Ljava/lang/Object;)V
    //   95: goto +144 -> 239
    //   98: astore_2
    //   99: getstatic 36	io/netty/util/concurrent/ImmediateEventExecutor:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   102: ldc 108
    //   104: aload_1
    //   105: aload_2
    //   106: invokeinterface 114 4 0
    //   111: getstatic 44	io/netty/util/concurrent/ImmediateEventExecutor:DELAYED_RUNNABLES	Lio/netty/util/concurrent/FastThreadLocal;
    //   114: invokevirtual 82	io/netty/util/concurrent/FastThreadLocal:get	()Ljava/lang/Object;
    //   117: checkcast 103	java/util/Queue
    //   120: astore_2
    //   121: aload_2
    //   122: invokeinterface 106 1 0
    //   127: checkcast 98	java/lang/Runnable
    //   130: astore_3
    //   131: aload_3
    //   132: ifnull -46 -> 86
    //   135: aload_3
    //   136: invokeinterface 101 1 0
    //   141: goto -20 -> 121
    //   144: astore_1
    //   145: getstatic 36	io/netty/util/concurrent/ImmediateEventExecutor:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   148: ldc 108
    //   150: aload_3
    //   151: aload_1
    //   152: invokeinterface 114 4 0
    //   157: goto -36 -> 121
    //   160: astore_1
    //   161: getstatic 44	io/netty/util/concurrent/ImmediateEventExecutor:DELAYED_RUNNABLES	Lio/netty/util/concurrent/FastThreadLocal;
    //   164: invokevirtual 82	io/netty/util/concurrent/FastThreadLocal:get	()Ljava/lang/Object;
    //   167: checkcast 103	java/util/Queue
    //   170: astore_2
    //   171: aload_2
    //   172: invokeinterface 106 1 0
    //   177: checkcast 98	java/lang/Runnable
    //   180: astore_3
    //   181: aload_3
    //   182: ifnull +30 -> 212
    //   185: aload_3
    //   186: invokeinterface 101 1 0
    //   191: goto -20 -> 171
    //   194: astore 4
    //   196: getstatic 36	io/netty/util/concurrent/ImmediateEventExecutor:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   199: ldc 108
    //   201: aload_3
    //   202: aload 4
    //   204: invokeinterface 114 4 0
    //   209: goto -38 -> 171
    //   212: getstatic 47	io/netty/util/concurrent/ImmediateEventExecutor:RUNNING	Lio/netty/util/concurrent/FastThreadLocal;
    //   215: getstatic 117	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   218: invokevirtual 96	io/netty/util/concurrent/FastThreadLocal:set	(Ljava/lang/Object;)V
    //   221: aload_1
    //   222: athrow
    //   223: getstatic 44	io/netty/util/concurrent/ImmediateEventExecutor:DELAYED_RUNNABLES	Lio/netty/util/concurrent/FastThreadLocal;
    //   226: invokevirtual 82	io/netty/util/concurrent/FastThreadLocal:get	()Ljava/lang/Object;
    //   229: checkcast 103	java/util/Queue
    //   232: aload_1
    //   233: invokeinterface 121 2 0
    //   238: pop
    //   239: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	ImmediateEventExecutor
    //   0	240	1	paramRunnable	Runnable
    //   10	67	2	localObject1	Object
    //   98	8	2	localObject2	Object
    //   120	52	2	localQueue	Queue
    //   70	8	3	localObject3	Object
    //   130	72	3	localRunnable	Runnable
    //   194	9	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   61	67	70	finally
    //   31	37	98	finally
    //   135	141	144	finally
    //   99	111	160	finally
    //   185	191	194	finally
  }
  
  public boolean inEventLoop()
  {
    return true;
  }
  
  public boolean inEventLoop(Thread paramThread)
  {
    return true;
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
  
  public <V> ProgressivePromise<V> newProgressivePromise()
  {
    return new ImmediateProgressivePromise(this);
  }
  
  public <V> Promise<V> newPromise()
  {
    return new ImmediatePromise(this);
  }
  
  @Deprecated
  public void shutdown() {}
  
  public Future<?> shutdownGracefully(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return terminationFuture();
  }
  
  public Future<?> terminationFuture()
  {
    return this.terminationFuture;
  }
  
  static class ImmediateProgressivePromise<V>
    extends DefaultProgressivePromise<V>
  {
    ImmediateProgressivePromise(EventExecutor paramEventExecutor)
    {
      super();
    }
    
    protected void checkDeadLock() {}
  }
  
  static class ImmediatePromise<V>
    extends DefaultPromise<V>
  {
    ImmediatePromise(EventExecutor paramEventExecutor)
    {
      super();
    }
    
    protected void checkDeadLock() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\ImmediateEventExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */