package io.netty.channel.kqueue;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.util.IntSupplier;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

final class KQueueEventLoop
  extends SingleThreadEventLoop
{
  private static final int KQUEUE_WAKE_UP_IDENT = 0;
  private static final AtomicIntegerFieldUpdater<KQueueEventLoop> WAKEN_UP_UPDATER;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(KQueueEventLoop.class);
  private final boolean allowGrowing;
  private final KQueueEventArray changeList;
  private final IntObjectMap<AbstractKQueueChannel> channels = new IntObjectHashMap(4096);
  private final KQueueEventArray eventList;
  private volatile int ioRatio = 50;
  private final IovArray iovArray = new IovArray();
  private final FileDescriptor kqueueFd;
  private final IntSupplier selectNowSupplier = new IntSupplier()
  {
    public int get()
      throws Exception
    {
      return KQueueEventLoop.this.kqueueWaitNow();
    }
  };
  private final SelectStrategy selectStrategy;
  private volatile int wakenUp;
  
  static
  {
    WAKEN_UP_UPDATER = AtomicIntegerFieldUpdater.newUpdater(KQueueEventLoop.class, "wakenUp");
    KQueue.ensureAvailability();
  }
  
  KQueueEventLoop(EventLoopGroup paramEventLoopGroup, Executor paramExecutor, int paramInt, SelectStrategy paramSelectStrategy, RejectedExecutionHandler paramRejectedExecutionHandler, EventLoopTaskQueueFactory paramEventLoopTaskQueueFactory)
  {
    super(paramEventLoopGroup, paramExecutor, false, newTaskQueue(paramEventLoopTaskQueueFactory), newTaskQueue(paramEventLoopTaskQueueFactory), paramRejectedExecutionHandler);
    this.selectStrategy = ((SelectStrategy)ObjectUtil.checkNotNull(paramSelectStrategy, "strategy"));
    paramEventLoopGroup = Native.newKQueue();
    this.kqueueFd = paramEventLoopGroup;
    if (paramInt == 0)
    {
      this.allowGrowing = true;
      paramInt = 4096;
    }
    else
    {
      this.allowGrowing = false;
    }
    this.changeList = new KQueueEventArray(paramInt);
    this.eventList = new KQueueEventArray(paramInt);
    paramInt = Native.keventAddUserEvent(paramEventLoopGroup.intValue(), 0);
    if (paramInt >= 0) {
      return;
    }
    cleanup();
    paramEventLoopGroup = new StringBuilder();
    paramEventLoopGroup.append("kevent failed to add user event with errno: ");
    paramEventLoopGroup.append(-paramInt);
    throw new IllegalStateException(paramEventLoopGroup.toString());
  }
  
  private void closeAll()
  {
    try
    {
      kqueueWaitNow();
      Collection localCollection = this.channels.values();
      int i = 0;
      AbstractKQueueChannel[] arrayOfAbstractKQueueChannel = (AbstractKQueueChannel[])localCollection.toArray(new AbstractKQueueChannel[0]);
      int j = arrayOfAbstractKQueueChannel.length;
      while (i < j)
      {
        localCollection = arrayOfAbstractKQueueChannel[i];
        localCollection.unsafe().close(localCollection.unsafe().voidPromise());
        i++;
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  private static void handleLoopException(Throwable paramThrowable)
  {
    logger.warn("Unexpected exception in the selector loop.", paramThrowable);
    try
    {
      Thread.sleep(1000L);
      return;
    }
    catch (InterruptedException paramThrowable)
    {
      for (;;) {}
    }
  }
  
  private int kqueueWait(int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = Native.keventWait(this.kqueueFd.intValue(), this.changeList, this.eventList, paramInt1, paramInt2);
    this.changeList.clear();
    return paramInt1;
  }
  
  private int kqueueWait(boolean paramBoolean)
    throws IOException
  {
    if ((paramBoolean) && (hasTasks())) {
      return kqueueWaitNow();
    }
    long l = delayNanos(System.nanoTime());
    int i = (int)Math.min(l / 1000000000L, 2147483647L);
    return kqueueWait(i, (int)Math.min(l - i * 1000000000L, 2147483647L));
  }
  
  private int kqueueWaitNow()
    throws IOException
  {
    return kqueueWait(0, 0);
  }
  
  private static Queue<Runnable> newTaskQueue(EventLoopTaskQueueFactory paramEventLoopTaskQueueFactory)
  {
    if (paramEventLoopTaskQueueFactory == null) {
      return newTaskQueue0(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
    }
    return paramEventLoopTaskQueueFactory.newTaskQueue(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
  }
  
  private static Queue<Runnable> newTaskQueue0(int paramInt)
  {
    Queue localQueue;
    if (paramInt == Integer.MAX_VALUE) {
      localQueue = PlatformDependent.newMpscQueue();
    } else {
      localQueue = PlatformDependent.newMpscQueue(paramInt);
    }
    return localQueue;
  }
  
  private void processReady(int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
    {
      short s = this.eventList.filter(i);
      int j = this.eventList.flags(i);
      int k = this.eventList.fd(i);
      if ((s != Native.EVFILT_USER) && ((Native.EV_ERROR & j) == 0))
      {
        Object localObject = (AbstractKQueueChannel)this.channels.get(k);
        if (localObject == null)
        {
          logger.warn("events[{}]=[{}, {}] had no channel!", new Object[] { Integer.valueOf(i), Integer.valueOf(this.eventList.fd(i)), Short.valueOf(s) });
        }
        else
        {
          localObject = (AbstractKQueueChannel.AbstractKQueueUnsafe)((AbstractChannel)localObject).unsafe();
          if (s == Native.EVFILT_WRITE) {
            ((AbstractKQueueChannel.AbstractKQueueUnsafe)localObject).writeReady();
          } else if (s == Native.EVFILT_READ) {
            ((AbstractKQueueChannel.AbstractKQueueUnsafe)localObject).readReady(this.eventList.data(i));
          } else if ((s == Native.EVFILT_SOCK) && ((this.eventList.fflags(i) & Native.NOTE_RDHUP) != 0)) {
            ((AbstractKQueueChannel.AbstractKQueueUnsafe)localObject).readEOF();
          }
          if ((Native.EV_EOF & j) != 0) {
            ((AbstractKQueueChannel.AbstractKQueueUnsafe)localObject).readEOF();
          }
        }
      }
    }
  }
  
  private void wakeup()
  {
    Native.keventTriggerUserEvent(this.kqueueFd.intValue(), 0);
  }
  
  void add(AbstractKQueueChannel paramAbstractKQueueChannel)
  {
    paramAbstractKQueueChannel = (AbstractKQueueChannel)this.channels.put(paramAbstractKQueueChannel.fd().intValue(), paramAbstractKQueueChannel);
  }
  
  IovArray cleanArray()
  {
    this.iovArray.clear();
    return this.iovArray;
  }
  
  /* Error */
  protected void cleanup()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 107	io/netty/channel/kqueue/KQueueEventLoop:kqueueFd	Lio/netty/channel/unix/FileDescriptor;
    //   4: invokevirtual 364	io/netty/channel/unix/FileDescriptor:close	()V
    //   7: goto +20 -> 27
    //   10: astore_1
    //   11: goto +31 -> 42
    //   14: astore_1
    //   15: getstatic 43	io/netty/channel/kqueue/KQueueEventLoop:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   18: ldc_w 366
    //   21: aload_1
    //   22: invokeinterface 203 3 0
    //   27: aload_0
    //   28: getfield 114	io/netty/channel/kqueue/KQueueEventLoop:changeList	Lio/netty/channel/kqueue/KQueueEventArray;
    //   31: invokevirtual 369	io/netty/channel/kqueue/KQueueEventArray:free	()V
    //   34: aload_0
    //   35: getfield 116	io/netty/channel/kqueue/KQueueEventLoop:eventList	Lio/netty/channel/kqueue/KQueueEventArray;
    //   38: invokevirtual 369	io/netty/channel/kqueue/KQueueEventArray:free	()V
    //   41: return
    //   42: aload_0
    //   43: getfield 114	io/netty/channel/kqueue/KQueueEventLoop:changeList	Lio/netty/channel/kqueue/KQueueEventArray;
    //   46: invokevirtual 369	io/netty/channel/kqueue/KQueueEventArray:free	()V
    //   49: aload_0
    //   50: getfield 116	io/netty/channel/kqueue/KQueueEventLoop:eventList	Lio/netty/channel/kqueue/KQueueEventArray;
    //   53: invokevirtual 369	io/netty/channel/kqueue/KQueueEventArray:free	()V
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	KQueueEventLoop
    //   10	1	1	localObject	Object
    //   14	43	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	7	10	finally
    //   15	27	10	finally
    //   0	7	14	java/io/IOException
  }
  
  void evSet(AbstractKQueueChannel paramAbstractKQueueChannel, short paramShort1, short paramShort2, int paramInt)
  {
    this.changeList.evSet(paramAbstractKQueueChannel, paramShort1, paramShort2, paramInt);
  }
  
  public int getIoRatio()
  {
    return this.ioRatio;
  }
  
  protected Queue<Runnable> newTaskQueue(int paramInt)
  {
    return newTaskQueue0(paramInt);
  }
  
  public int registeredChannels()
  {
    return this.channels.size();
  }
  
  void remove(AbstractKQueueChannel paramAbstractKQueueChannel)
    throws Exception
  {
    int i = paramAbstractKQueueChannel.fd().intValue();
    AbstractKQueueChannel localAbstractKQueueChannel = (AbstractKQueueChannel)this.channels.remove(i);
    if ((localAbstractKQueueChannel != null) && (localAbstractKQueueChannel != paramAbstractKQueueChannel)) {
      this.channels.put(i, localAbstractKQueueChannel);
    } else if (paramAbstractKQueueChannel.isOpen()) {
      paramAbstractKQueueChannel.unregisterFilters();
    }
  }
  
  /* Error */
  protected void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 99	io/netty/channel/kqueue/KQueueEventLoop:selectStrategy	Lio/netty/channel/SelectStrategy;
    //   4: aload_0
    //   5: getfield 78	io/netty/channel/kqueue/KQueueEventLoop:selectNowSupplier	Lio/netty/util/IntSupplier;
    //   8: aload_0
    //   9: invokevirtual 224	io/netty/channel/SingleThreadEventLoop:hasTasks	()Z
    //   12: invokeinterface 394 3 0
    //   17: istore_1
    //   18: iload_1
    //   19: bipush -3
    //   21: if_icmpeq +17 -> 38
    //   24: iload_1
    //   25: bipush -2
    //   27: if_icmpeq -27 -> 0
    //   30: iload_1
    //   31: iconst_m1
    //   32: if_icmpeq +6 -> 38
    //   35: goto +44 -> 79
    //   38: getstatic 52	io/netty/channel/kqueue/KQueueEventLoop:WAKEN_UP_UPDATER	Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;
    //   41: aload_0
    //   42: iconst_0
    //   43: invokevirtual 398	java/util/concurrent/atomic/AtomicIntegerFieldUpdater:getAndSet	(Ljava/lang/Object;I)I
    //   46: iconst_1
    //   47: if_icmpne +8 -> 55
    //   50: iconst_1
    //   51: istore_2
    //   52: goto +5 -> 57
    //   55: iconst_0
    //   56: istore_2
    //   57: aload_0
    //   58: iload_2
    //   59: invokespecial 400	io/netty/channel/kqueue/KQueueEventLoop:kqueueWait	(Z)I
    //   62: istore_3
    //   63: iload_3
    //   64: istore_1
    //   65: aload_0
    //   66: getfield 402	io/netty/channel/kqueue/KQueueEventLoop:wakenUp	I
    //   69: iconst_1
    //   70: if_icmpne +9 -> 79
    //   73: aload_0
    //   74: invokespecial 404	io/netty/channel/kqueue/KQueueEventLoop:wakeup	()V
    //   77: iload_3
    //   78: istore_1
    //   79: aload_0
    //   80: getfield 87	io/netty/channel/kqueue/KQueueEventLoop:ioRatio	I
    //   83: istore_3
    //   84: iload_3
    //   85: bipush 100
    //   87: if_icmpne +33 -> 120
    //   90: iload_1
    //   91: ifle +21 -> 112
    //   94: aload_0
    //   95: iload_1
    //   96: invokespecial 406	io/netty/channel/kqueue/KQueueEventLoop:processReady	(I)V
    //   99: goto +13 -> 112
    //   102: astore 4
    //   104: aload_0
    //   105: invokevirtual 409	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	()Z
    //   108: pop
    //   109: aload 4
    //   111: athrow
    //   112: aload_0
    //   113: invokevirtual 409	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	()Z
    //   116: pop
    //   117: goto +65 -> 182
    //   120: invokestatic 230	java/lang/System:nanoTime	()J
    //   123: lstore 5
    //   125: iload_1
    //   126: ifle +36 -> 162
    //   129: aload_0
    //   130: iload_1
    //   131: invokespecial 406	io/netty/channel/kqueue/KQueueEventLoop:processReady	(I)V
    //   134: goto +28 -> 162
    //   137: astore 4
    //   139: aload_0
    //   140: invokestatic 230	java/lang/System:nanoTime	()J
    //   143: lload 5
    //   145: lsub
    //   146: bipush 100
    //   148: iload_3
    //   149: isub
    //   150: i2l
    //   151: lmul
    //   152: iload_3
    //   153: i2l
    //   154: ldiv
    //   155: invokevirtual 412	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	(J)Z
    //   158: pop
    //   159: aload 4
    //   161: athrow
    //   162: aload_0
    //   163: invokestatic 230	java/lang/System:nanoTime	()J
    //   166: lload 5
    //   168: lsub
    //   169: bipush 100
    //   171: iload_3
    //   172: isub
    //   173: i2l
    //   174: lmul
    //   175: iload_3
    //   176: i2l
    //   177: ldiv
    //   178: invokevirtual 412	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	(J)Z
    //   181: pop
    //   182: aload_0
    //   183: getfield 109	io/netty/channel/kqueue/KQueueEventLoop:allowGrowing	Z
    //   186: ifeq +32 -> 218
    //   189: iload_1
    //   190: aload_0
    //   191: getfield 116	io/netty/channel/kqueue/KQueueEventLoop:eventList	Lio/netty/channel/kqueue/KQueueEventArray;
    //   194: invokevirtual 415	io/netty/channel/kqueue/KQueueEventArray:capacity	()I
    //   197: if_icmpne +21 -> 218
    //   200: aload_0
    //   201: getfield 116	io/netty/channel/kqueue/KQueueEventLoop:eventList	Lio/netty/channel/kqueue/KQueueEventArray;
    //   204: iconst_0
    //   205: invokevirtual 419	io/netty/channel/kqueue/KQueueEventArray:realloc	(Z)V
    //   208: goto +10 -> 218
    //   211: astore 4
    //   213: aload 4
    //   215: invokestatic 421	io/netty/channel/kqueue/KQueueEventLoop:handleLoopException	(Ljava/lang/Throwable;)V
    //   218: aload_0
    //   219: invokevirtual 424	io/netty/util/concurrent/SingleThreadEventExecutor:isShuttingDown	()Z
    //   222: ifeq -222 -> 0
    //   225: aload_0
    //   226: invokespecial 426	io/netty/channel/kqueue/KQueueEventLoop:closeAll	()V
    //   229: aload_0
    //   230: invokevirtual 429	io/netty/util/concurrent/SingleThreadEventExecutor:confirmShutdown	()Z
    //   233: istore_2
    //   234: iload_2
    //   235: ifeq -235 -> 0
    //   238: return
    //   239: astore 4
    //   241: aload 4
    //   243: invokestatic 421	io/netty/channel/kqueue/KQueueEventLoop:handleLoopException	(Ljava/lang/Throwable;)V
    //   246: goto -246 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	KQueueEventLoop
    //   17	181	1	i	int
    //   51	184	2	bool	boolean
    //   62	114	3	j	int
    //   102	8	4	localObject1	Object
    //   137	23	4	localObject2	Object
    //   211	3	4	localThrowable1	Throwable
    //   239	3	4	localThrowable2	Throwable
    //   123	44	5	l	long
    // Exception table:
    //   from	to	target	type
    //   94	99	102	finally
    //   129	134	137	finally
    //   0	18	211	finally
    //   38	50	211	finally
    //   57	63	211	finally
    //   65	77	211	finally
    //   79	84	211	finally
    //   104	112	211	finally
    //   112	117	211	finally
    //   120	125	211	finally
    //   139	162	211	finally
    //   162	182	211	finally
    //   182	208	211	finally
    //   218	234	239	finally
  }
  
  public void setIoRatio(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 100))
    {
      this.ioRatio = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ioRatio: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: 0 < ioRatio <= 100)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  protected void wakeup(boolean paramBoolean)
  {
    if ((!paramBoolean) && (WAKEN_UP_UPDATER.compareAndSet(this, 0, 1))) {
      wakeup();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueEventLoop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */