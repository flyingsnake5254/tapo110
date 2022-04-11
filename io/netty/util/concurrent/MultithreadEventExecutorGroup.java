package io.netty.util.concurrent;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MultithreadEventExecutorGroup
  extends AbstractEventExecutorGroup
{
  private final EventExecutor[] children;
  private final EventExecutorChooserFactory.EventExecutorChooser chooser;
  private final Set<EventExecutor> readonlyChildren;
  private final AtomicInteger terminatedChildren;
  private final Promise<?> terminationFuture;
  
  /* Error */
  protected MultithreadEventExecutorGroup(int paramInt, Executor paramExecutor, EventExecutorChooserFactory paramEventExecutorChooserFactory, Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	io/netty/util/concurrent/AbstractEventExecutorGroup:<init>	()V
    //   4: aload_0
    //   5: new 29	java/util/concurrent/atomic/AtomicInteger
    //   8: dup
    //   9: invokespecial 30	java/util/concurrent/atomic/AtomicInteger:<init>	()V
    //   12: putfield 32	io/netty/util/concurrent/MultithreadEventExecutorGroup:terminatedChildren	Ljava/util/concurrent/atomic/AtomicInteger;
    //   15: aload_0
    //   16: new 34	io/netty/util/concurrent/DefaultPromise
    //   19: dup
    //   20: getstatic 40	io/netty/util/concurrent/GlobalEventExecutor:INSTANCE	Lio/netty/util/concurrent/GlobalEventExecutor;
    //   23: invokespecial 43	io/netty/util/concurrent/DefaultPromise:<init>	(Lio/netty/util/concurrent/EventExecutor;)V
    //   26: putfield 45	io/netty/util/concurrent/MultithreadEventExecutorGroup:terminationFuture	Lio/netty/util/concurrent/Promise;
    //   29: iconst_0
    //   30: istore 5
    //   32: iconst_0
    //   33: istore 6
    //   35: iload_1
    //   36: ifle +257 -> 293
    //   39: aload_2
    //   40: astore 7
    //   42: aload_2
    //   43: ifnonnull +16 -> 59
    //   46: new 47	io/netty/util/concurrent/ThreadPerTaskExecutor
    //   49: dup
    //   50: aload_0
    //   51: invokevirtual 51	io/netty/util/concurrent/MultithreadEventExecutorGroup:newDefaultThreadFactory	()Ljava/util/concurrent/ThreadFactory;
    //   54: invokespecial 54	io/netty/util/concurrent/ThreadPerTaskExecutor:<init>	(Ljava/util/concurrent/ThreadFactory;)V
    //   57: astore 7
    //   59: aload_0
    //   60: iload_1
    //   61: anewarray 56	io/netty/util/concurrent/EventExecutor
    //   64: putfield 58	io/netty/util/concurrent/MultithreadEventExecutorGroup:children	[Lio/netty/util/concurrent/EventExecutor;
    //   67: iconst_0
    //   68: istore 8
    //   70: iload 8
    //   72: iload_1
    //   73: if_icmpge +127 -> 200
    //   76: aload_0
    //   77: getfield 58	io/netty/util/concurrent/MultithreadEventExecutorGroup:children	[Lio/netty/util/concurrent/EventExecutor;
    //   80: iload 8
    //   82: aload_0
    //   83: aload 7
    //   85: aload 4
    //   87: invokevirtual 62	io/netty/util/concurrent/MultithreadEventExecutorGroup:newChild	(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Lio/netty/util/concurrent/EventExecutor;
    //   90: aastore
    //   91: iinc 8 1
    //   94: goto -24 -> 70
    //   97: astore_2
    //   98: goto +17 -> 115
    //   101: astore_2
    //   102: new 64	java/lang/IllegalStateException
    //   105: astore_3
    //   106: aload_3
    //   107: ldc 66
    //   109: aload_2
    //   110: invokespecial 69	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_3
    //   114: athrow
    //   115: iconst_0
    //   116: istore 5
    //   118: iload 6
    //   120: istore_1
    //   121: iload 5
    //   123: iload 8
    //   125: if_icmpge +22 -> 147
    //   128: aload_0
    //   129: getfield 58	io/netty/util/concurrent/MultithreadEventExecutorGroup:children	[Lio/netty/util/concurrent/EventExecutor;
    //   132: iload 5
    //   134: aaload
    //   135: invokeinterface 75 1 0
    //   140: pop
    //   141: iinc 5 1
    //   144: goto -26 -> 118
    //   147: iload_1
    //   148: iload 8
    //   150: if_icmpge +48 -> 198
    //   153: aload_0
    //   154: getfield 58	io/netty/util/concurrent/MultithreadEventExecutorGroup:children	[Lio/netty/util/concurrent/EventExecutor;
    //   157: iload_1
    //   158: aaload
    //   159: astore_3
    //   160: aload_3
    //   161: invokeinterface 81 1 0
    //   166: ifne +19 -> 185
    //   169: aload_3
    //   170: ldc2_w 82
    //   173: getstatic 89	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   176: invokeinterface 93 4 0
    //   181: pop
    //   182: goto -22 -> 160
    //   185: iinc 1 1
    //   188: goto -41 -> 147
    //   191: astore_3
    //   192: invokestatic 99	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   195: invokevirtual 102	java/lang/Thread:interrupt	()V
    //   198: aload_2
    //   199: athrow
    //   200: aload_0
    //   201: aload_3
    //   202: aload_0
    //   203: getfield 58	io/netty/util/concurrent/MultithreadEventExecutorGroup:children	[Lio/netty/util/concurrent/EventExecutor;
    //   206: invokeinterface 108 2 0
    //   211: putfield 110	io/netty/util/concurrent/MultithreadEventExecutorGroup:chooser	Lio/netty/util/concurrent/EventExecutorChooserFactory$EventExecutorChooser;
    //   214: new 6	io/netty/util/concurrent/MultithreadEventExecutorGroup$1
    //   217: dup
    //   218: aload_0
    //   219: invokespecial 113	io/netty/util/concurrent/MultithreadEventExecutorGroup$1:<init>	(Lio/netty/util/concurrent/MultithreadEventExecutorGroup;)V
    //   222: astore_2
    //   223: aload_0
    //   224: getfield 58	io/netty/util/concurrent/MultithreadEventExecutorGroup:children	[Lio/netty/util/concurrent/EventExecutor;
    //   227: astore_3
    //   228: aload_3
    //   229: arraylength
    //   230: istore 8
    //   232: iload 5
    //   234: istore_1
    //   235: iload_1
    //   236: iload 8
    //   238: if_icmpge +24 -> 262
    //   241: aload_3
    //   242: iload_1
    //   243: aaload
    //   244: invokeinterface 115 1 0
    //   249: aload_2
    //   250: invokeinterface 121 2 0
    //   255: pop
    //   256: iinc 1 1
    //   259: goto -24 -> 235
    //   262: new 123	java/util/LinkedHashSet
    //   265: dup
    //   266: aload_0
    //   267: getfield 58	io/netty/util/concurrent/MultithreadEventExecutorGroup:children	[Lio/netty/util/concurrent/EventExecutor;
    //   270: arraylength
    //   271: invokespecial 126	java/util/LinkedHashSet:<init>	(I)V
    //   274: astore_2
    //   275: aload_2
    //   276: aload_0
    //   277: getfield 58	io/netty/util/concurrent/MultithreadEventExecutorGroup:children	[Lio/netty/util/concurrent/EventExecutor;
    //   280: invokestatic 132	java/util/Collections:addAll	(Ljava/util/Collection;[Ljava/lang/Object;)Z
    //   283: pop
    //   284: aload_0
    //   285: aload_2
    //   286: invokestatic 136	java/util/Collections:unmodifiableSet	(Ljava/util/Set;)Ljava/util/Set;
    //   289: putfield 138	io/netty/util/concurrent/MultithreadEventExecutorGroup:readonlyChildren	Ljava/util/Set;
    //   292: return
    //   293: new 140	java/lang/IllegalArgumentException
    //   296: dup
    //   297: ldc -114
    //   299: iconst_1
    //   300: anewarray 144	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: iload_1
    //   306: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: aastore
    //   310: invokestatic 156	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   313: invokespecial 159	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   316: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	MultithreadEventExecutorGroup
    //   0	317	1	paramInt	int
    //   0	317	2	paramExecutor	Executor
    //   0	317	3	paramEventExecutorChooserFactory	EventExecutorChooserFactory
    //   0	317	4	paramVarArgs	Object[]
    //   30	203	5	i	int
    //   33	86	6	j	int
    //   40	44	7	localObject	Object
    //   68	171	8	k	int
    // Exception table:
    //   from	to	target	type
    //   76	91	97	finally
    //   102	115	97	finally
    //   76	91	101	java/lang/Exception
    //   160	182	191	java/lang/InterruptedException
  }
  
  protected MultithreadEventExecutorGroup(int paramInt, Executor paramExecutor, Object... paramVarArgs)
  {
    this(paramInt, paramExecutor, DefaultEventExecutorChooserFactory.INSTANCE, paramVarArgs);
  }
  
  protected MultithreadEventExecutorGroup(int paramInt, ThreadFactory paramThreadFactory, Object... paramVarArgs)
  {
    this(paramInt, paramThreadFactory, paramVarArgs);
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    long l1 = System.nanoTime();
    paramLong = paramTimeUnit.toNanos(paramLong);
    for (paramTimeUnit : this.children)
    {
      long l2;
      do
      {
        l2 = l1 + paramLong - System.nanoTime();
        if (l2 <= 0L) {
          break;
        }
      } while (!paramTimeUnit.awaitTermination(l2, TimeUnit.NANOSECONDS));
    }
    return isTerminated();
  }
  
  public final int executorCount()
  {
    return this.children.length;
  }
  
  public boolean isShutdown()
  {
    EventExecutor[] arrayOfEventExecutor = this.children;
    int i = arrayOfEventExecutor.length;
    for (int j = 0; j < i; j++) {
      if (!arrayOfEventExecutor[j].isShutdown()) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isShuttingDown()
  {
    EventExecutor[] arrayOfEventExecutor = this.children;
    int i = arrayOfEventExecutor.length;
    for (int j = 0; j < i; j++) {
      if (!arrayOfEventExecutor[j].isShuttingDown()) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isTerminated()
  {
    EventExecutor[] arrayOfEventExecutor = this.children;
    int i = arrayOfEventExecutor.length;
    for (int j = 0; j < i; j++) {
      if (!arrayOfEventExecutor[j].isTerminated()) {
        return false;
      }
    }
    return true;
  }
  
  public Iterator<EventExecutor> iterator()
  {
    return this.readonlyChildren.iterator();
  }
  
  protected abstract EventExecutor newChild(Executor paramExecutor, Object... paramVarArgs)
    throws Exception;
  
  protected ThreadFactory newDefaultThreadFactory()
  {
    return new DefaultThreadFactory(getClass());
  }
  
  public EventExecutor next()
  {
    return this.chooser.next();
  }
  
  @Deprecated
  public void shutdown()
  {
    EventExecutor[] arrayOfEventExecutor = this.children;
    int i = arrayOfEventExecutor.length;
    for (int j = 0; j < i; j++) {
      arrayOfEventExecutor[j].shutdown();
    }
  }
  
  public Future<?> shutdownGracefully(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    EventExecutor[] arrayOfEventExecutor = this.children;
    int i = arrayOfEventExecutor.length;
    for (int j = 0; j < i; j++) {
      arrayOfEventExecutor[j].shutdownGracefully(paramLong1, paramLong2, paramTimeUnit);
    }
    return terminationFuture();
  }
  
  public Future<?> terminationFuture()
  {
    return this.terminationFuture;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\MultithreadEventExecutorGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */