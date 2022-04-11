package io.netty.channel.epoll;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.util.IntSupplier;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

class EpollEventLoop
  extends SingleThreadEventLoop
{
  private static final long AWAKE = -1L;
  private static final long MAX_SCHEDULED_TIMERFD_NS = 999999999L;
  private static final long NONE = Long.MAX_VALUE;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(EpollEventLoop.class);
  private final boolean allowGrowing;
  private final IntObjectMap<AbstractEpollChannel> channels;
  private NativeDatagramPacketArray datagramPacketArray;
  private final FileDescriptor epollFd;
  private final FileDescriptor eventFd;
  private final EpollEventArray events;
  private volatile int ioRatio;
  private IovArray iovArray;
  private final AtomicLong nextWakeupNanos;
  private boolean pendingWakeup;
  private final IntSupplier selectNowSupplier;
  private final SelectStrategy selectStrategy;
  private final FileDescriptor timerFd;
  
  static
  {
    Epoll.ensureAvailability();
  }
  
  /* Error */
  EpollEventLoop(io.netty.channel.EventLoopGroup paramEventLoopGroup, java.util.concurrent.Executor paramExecutor, int paramInt, SelectStrategy paramSelectStrategy, io.netty.util.concurrent.RejectedExecutionHandler paramRejectedExecutionHandler, EventLoopTaskQueueFactory paramEventLoopTaskQueueFactory)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iconst_0
    //   4: aload 6
    //   6: invokestatic 70	io/netty/channel/epoll/EpollEventLoop:newTaskQueue	(Lio/netty/channel/EventLoopTaskQueueFactory;)Ljava/util/Queue;
    //   9: aload 6
    //   11: invokestatic 70	io/netty/channel/epoll/EpollEventLoop:newTaskQueue	(Lio/netty/channel/EventLoopTaskQueueFactory;)Ljava/util/Queue;
    //   14: aload 5
    //   16: invokespecial 73	io/netty/channel/SingleThreadEventLoop:<init>	(Lio/netty/channel/EventLoopGroup;Ljava/util/concurrent/Executor;ZLjava/util/Queue;Ljava/util/Queue;Lio/netty/util/concurrent/RejectedExecutionHandler;)V
    //   19: aload_0
    //   20: new 75	io/netty/util/collection/IntObjectHashMap
    //   23: dup
    //   24: sipush 4096
    //   27: invokespecial 78	io/netty/util/collection/IntObjectHashMap:<init>	(I)V
    //   30: putfield 80	io/netty/channel/epoll/EpollEventLoop:channels	Lio/netty/util/collection/IntObjectMap;
    //   33: aload_0
    //   34: new 6	io/netty/channel/epoll/EpollEventLoop$1
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 83	io/netty/channel/epoll/EpollEventLoop$1:<init>	(Lio/netty/channel/epoll/EpollEventLoop;)V
    //   42: putfield 85	io/netty/channel/epoll/EpollEventLoop:selectNowSupplier	Lio/netty/util/IntSupplier;
    //   45: aload_0
    //   46: new 87	java/util/concurrent/atomic/AtomicLong
    //   49: dup
    //   50: ldc2_w 12
    //   53: invokespecial 90	java/util/concurrent/atomic/AtomicLong:<init>	(J)V
    //   56: putfield 92	io/netty/channel/epoll/EpollEventLoop:nextWakeupNanos	Ljava/util/concurrent/atomic/AtomicLong;
    //   59: aload_0
    //   60: bipush 50
    //   62: putfield 94	io/netty/channel/epoll/EpollEventLoop:ioRatio	I
    //   65: aload_0
    //   66: aload 4
    //   68: ldc 96
    //   70: invokestatic 102	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   73: checkcast 104	io/netty/channel/SelectStrategy
    //   76: putfield 106	io/netty/channel/epoll/EpollEventLoop:selectStrategy	Lio/netty/channel/SelectStrategy;
    //   79: iload_3
    //   80: ifne +25 -> 105
    //   83: aload_0
    //   84: iconst_1
    //   85: putfield 108	io/netty/channel/epoll/EpollEventLoop:allowGrowing	Z
    //   88: aload_0
    //   89: new 110	io/netty/channel/epoll/EpollEventArray
    //   92: dup
    //   93: sipush 4096
    //   96: invokespecial 111	io/netty/channel/epoll/EpollEventArray:<init>	(I)V
    //   99: putfield 113	io/netty/channel/epoll/EpollEventLoop:events	Lio/netty/channel/epoll/EpollEventArray;
    //   102: goto +20 -> 122
    //   105: aload_0
    //   106: iconst_0
    //   107: putfield 108	io/netty/channel/epoll/EpollEventLoop:allowGrowing	Z
    //   110: aload_0
    //   111: new 110	io/netty/channel/epoll/EpollEventArray
    //   114: dup
    //   115: iload_3
    //   116: invokespecial 111	io/netty/channel/epoll/EpollEventArray:<init>	(I)V
    //   119: putfield 113	io/netty/channel/epoll/EpollEventLoop:events	Lio/netty/channel/epoll/EpollEventArray;
    //   122: aconst_null
    //   123: astore 6
    //   125: aconst_null
    //   126: astore 4
    //   128: invokestatic 119	io/netty/channel/epoll/Native:newEpollCreate	()Lio/netty/channel/unix/FileDescriptor;
    //   131: astore_2
    //   132: aload_0
    //   133: aload_2
    //   134: putfield 121	io/netty/channel/epoll/EpollEventLoop:epollFd	Lio/netty/channel/unix/FileDescriptor;
    //   137: invokestatic 124	io/netty/channel/epoll/Native:newEventFd	()Lio/netty/channel/unix/FileDescriptor;
    //   140: astore 5
    //   142: aload 4
    //   144: astore_1
    //   145: aload_0
    //   146: aload 5
    //   148: putfield 126	io/netty/channel/epoll/EpollEventLoop:eventFd	Lio/netty/channel/unix/FileDescriptor;
    //   151: aload 4
    //   153: astore_1
    //   154: aload_2
    //   155: invokevirtual 132	io/netty/channel/unix/FileDescriptor:intValue	()I
    //   158: istore_3
    //   159: aload 4
    //   161: astore_1
    //   162: aload 5
    //   164: invokevirtual 132	io/netty/channel/unix/FileDescriptor:intValue	()I
    //   167: istore 7
    //   169: aload 4
    //   171: astore_1
    //   172: getstatic 135	io/netty/channel/epoll/Native:EPOLLIN	I
    //   175: istore 8
    //   177: aload 4
    //   179: astore_1
    //   180: getstatic 138	io/netty/channel/epoll/Native:EPOLLET	I
    //   183: istore 9
    //   185: aload 4
    //   187: astore_1
    //   188: iload_3
    //   189: iload 7
    //   191: iload 8
    //   193: iload 9
    //   195: ior
    //   196: invokestatic 142	io/netty/channel/epoll/Native:epollCtlAdd	(III)V
    //   199: aload 4
    //   201: astore_1
    //   202: invokestatic 145	io/netty/channel/epoll/Native:newTimerFd	()Lio/netty/channel/unix/FileDescriptor;
    //   205: astore 4
    //   207: aload 4
    //   209: astore_1
    //   210: aload_0
    //   211: aload 4
    //   213: putfield 147	io/netty/channel/epoll/EpollEventLoop:timerFd	Lio/netty/channel/unix/FileDescriptor;
    //   216: aload 4
    //   218: astore_1
    //   219: aload_2
    //   220: invokevirtual 132	io/netty/channel/unix/FileDescriptor:intValue	()I
    //   223: aload 4
    //   225: invokevirtual 132	io/netty/channel/unix/FileDescriptor:intValue	()I
    //   228: iload 8
    //   230: iload 9
    //   232: ior
    //   233: invokestatic 142	io/netty/channel/epoll/Native:epollCtlAdd	(III)V
    //   236: return
    //   237: astore 10
    //   239: aload 4
    //   241: astore_1
    //   242: new 149	java/lang/IllegalStateException
    //   245: astore 6
    //   247: aload 4
    //   249: astore_1
    //   250: aload 6
    //   252: ldc -105
    //   254: aload 10
    //   256: invokespecial 154	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   259: aload 4
    //   261: astore_1
    //   262: aload 6
    //   264: athrow
    //   265: astore 6
    //   267: aload 4
    //   269: astore_1
    //   270: new 149	java/lang/IllegalStateException
    //   273: astore 10
    //   275: aload 4
    //   277: astore_1
    //   278: aload 10
    //   280: ldc -100
    //   282: aload 6
    //   284: invokespecial 154	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   287: aload 4
    //   289: astore_1
    //   290: aload 10
    //   292: athrow
    //   293: astore 4
    //   295: goto +24 -> 319
    //   298: astore 4
    //   300: aconst_null
    //   301: astore 5
    //   303: aload 5
    //   305: astore_1
    //   306: goto +13 -> 319
    //   309: astore 4
    //   311: aconst_null
    //   312: astore_1
    //   313: aload_1
    //   314: astore 5
    //   316: aload 6
    //   318: astore_2
    //   319: aload_2
    //   320: ifnull +11 -> 331
    //   323: aload_2
    //   324: invokevirtual 159	io/netty/channel/unix/FileDescriptor:close	()V
    //   327: goto +4 -> 331
    //   330: astore_2
    //   331: aload 5
    //   333: ifnull +12 -> 345
    //   336: aload 5
    //   338: invokevirtual 159	io/netty/channel/unix/FileDescriptor:close	()V
    //   341: goto +4 -> 345
    //   344: astore_2
    //   345: aload_1
    //   346: ifnull +7 -> 353
    //   349: aload_1
    //   350: invokevirtual 159	io/netty/channel/unix/FileDescriptor:close	()V
    //   353: aload 4
    //   355: athrow
    //   356: astore_1
    //   357: goto -4 -> 353
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	EpollEventLoop
    //   0	360	1	paramEventLoopGroup	io.netty.channel.EventLoopGroup
    //   0	360	2	paramExecutor	java.util.concurrent.Executor
    //   0	360	3	paramInt	int
    //   0	360	4	paramSelectStrategy	SelectStrategy
    //   0	360	5	paramRejectedExecutionHandler	io.netty.util.concurrent.RejectedExecutionHandler
    //   0	360	6	paramEventLoopTaskQueueFactory	EventLoopTaskQueueFactory
    //   167	23	7	i	int
    //   175	58	8	j	int
    //   183	50	9	k	int
    //   237	18	10	localIOException	IOException
    //   273	18	10	localIllegalStateException	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   219	236	237	java/io/IOException
    //   154	159	265	java/io/IOException
    //   162	169	265	java/io/IOException
    //   172	177	265	java/io/IOException
    //   180	185	265	java/io/IOException
    //   188	199	265	java/io/IOException
    //   145	151	293	finally
    //   154	159	293	finally
    //   162	169	293	finally
    //   172	177	293	finally
    //   180	185	293	finally
    //   188	199	293	finally
    //   202	207	293	finally
    //   210	216	293	finally
    //   219	236	293	finally
    //   242	247	293	finally
    //   250	259	293	finally
    //   262	265	293	finally
    //   270	275	293	finally
    //   278	287	293	finally
    //   290	293	293	finally
    //   132	142	298	finally
    //   128	132	309	finally
    //   323	327	330	java/lang/Exception
    //   336	341	344	java/lang/Exception
    //   349	353	356	java/lang/Exception
  }
  
  private void closeAll()
  {
    Object localObject1 = this.channels.values();
    int i = 0;
    localObject1 = (AbstractEpollChannel[])((Collection)localObject1).toArray(new AbstractEpollChannel[0]);
    int j = localObject1.length;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      ((AbstractChannel)localObject2).unsafe().close(((AbstractChannel)localObject2).unsafe().voidPromise());
      i++;
    }
  }
  
  private int epollBusyWait()
    throws IOException
  {
    return Native.epollBusyWait(this.epollFd, this.events);
  }
  
  private int epollWait(long paramLong)
    throws IOException
  {
    if (paramLong == Long.MAX_VALUE) {
      return Native.epollWait(this.epollFd, this.events, this.timerFd, Integer.MAX_VALUE, 0);
    }
    paramLong = AbstractScheduledEventExecutor.deadlineToDelayNanos(paramLong);
    int i = (int)Math.min(paramLong / 1000000000L, 2147483647L);
    int j = (int)Math.min(paramLong - i * 1000000000L, 999999999L);
    return Native.epollWait(this.epollFd, this.events, this.timerFd, i, j);
  }
  
  private int epollWaitNoTimerChange()
    throws IOException
  {
    return Native.epollWait(this.epollFd, this.events, false);
  }
  
  private int epollWaitNow()
    throws IOException
  {
    return Native.epollWait(this.epollFd, this.events, true);
  }
  
  private int epollWaitTimeboxed()
    throws IOException
  {
    return Native.epollWait(this.epollFd, this.events, 1000);
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
  
  private boolean processReady(EpollEventArray paramEpollEventArray, int paramInt)
  {
    int i = 0;
    for (bool1 = false; i < paramInt; bool1 = bool2)
    {
      int j = paramEpollEventArray.fd(i);
      boolean bool2;
      if (j == this.eventFd.intValue())
      {
        this.pendingWakeup = false;
        bool2 = bool1;
      }
      else if (j == this.timerFd.intValue())
      {
        bool2 = true;
      }
      else
      {
        long l = paramEpollEventArray.events(i);
        Object localObject = (AbstractEpollChannel)this.channels.get(j);
        if (localObject != null)
        {
          localObject = (AbstractEpollChannel.AbstractEpollUnsafe)((AbstractChannel)localObject).unsafe();
          j = Native.EPOLLERR;
          if (((Native.EPOLLOUT | j) & l) != 0L) {
            ((AbstractEpollChannel.AbstractEpollUnsafe)localObject).epollOutReady();
          }
          if (((j | Native.EPOLLIN) & l) != 0L) {
            ((AbstractEpollChannel.AbstractEpollUnsafe)localObject).epollInReady();
          }
          bool2 = bool1;
          if ((l & Native.EPOLLRDHUP) == 0L) {
            break label187;
          }
          ((AbstractEpollChannel.AbstractEpollUnsafe)localObject).epollRdHupReady();
          bool2 = bool1;
        }
      }
      try
      {
        Native.epollCtlDel(this.epollFd.intValue(), j);
        bool2 = bool1;
        label187:
        i++;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          bool2 = bool1;
        }
      }
    }
    return bool1;
  }
  
  void add(AbstractEpollChannel paramAbstractEpollChannel)
    throws IOException
  {
    int i = paramAbstractEpollChannel.socket.intValue();
    Native.epollCtlAdd(this.epollFd.intValue(), i, paramAbstractEpollChannel.flags);
    paramAbstractEpollChannel = (AbstractEpollChannel)this.channels.put(i, paramAbstractEpollChannel);
  }
  
  protected boolean afterScheduledTaskSubmitted(long paramLong)
  {
    boolean bool;
    if (paramLong < this.nextWakeupNanos.get()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected boolean beforeScheduledTaskSubmitted(long paramLong)
  {
    boolean bool;
    if (paramLong < this.nextWakeupNanos.get()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  NativeDatagramPacketArray cleanDatagramPacketArray()
  {
    NativeDatagramPacketArray localNativeDatagramPacketArray = this.datagramPacketArray;
    if (localNativeDatagramPacketArray == null) {
      this.datagramPacketArray = new NativeDatagramPacketArray();
    } else {
      localNativeDatagramPacketArray.clear();
    }
    return this.datagramPacketArray;
  }
  
  IovArray cleanIovArray()
  {
    IovArray localIovArray = this.iovArray;
    if (localIovArray == null) {
      this.iovArray = new IovArray();
    } else {
      localIovArray.clear();
    }
    return this.iovArray;
  }
  
  protected void cleanup()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.pendingWakeup;
        if (!bool) {}
      }
      finally
      {
        try
        {
          int i = epollWaitTimeboxed();
          if (i != 0)
          {
            int j = 0;
            if (j >= i) {
              continue;
            }
            if (this.events.fd(j) == this.eventFd.intValue())
            {
              this.pendingWakeup = false;
              continue;
            }
            j++;
            continue;
          }
          try
          {
            this.eventFd.close();
          }
          catch (IOException localIOException1)
          {
            logger.warn("Failed to close the event fd.", localIOException1);
          }
          try
          {
            this.timerFd.close();
          }
          catch (IOException localIOException2)
          {
            logger.warn("Failed to close the timer fd.", localIOException2);
          }
          try
          {
            this.epollFd.close();
          }
          catch (IOException localIOException3)
          {
            logger.warn("Failed to close the epoll fd.", localIOException3);
          }
          Object localObject1 = this.iovArray;
          if (localObject1 != null)
          {
            ((IovArray)localObject1).release();
            this.iovArray = null;
          }
          localObject1 = this.datagramPacketArray;
          if (localObject1 != null)
          {
            ((NativeDatagramPacketArray)localObject1).release();
            this.datagramPacketArray = null;
          }
          this.events.free();
          return;
        }
        catch (IOException localIOException4) {}
        localObject2 = finally;
        Object localObject3 = this.iovArray;
        if (localObject3 != null)
        {
          ((IovArray)localObject3).release();
          this.iovArray = null;
        }
        localObject3 = this.datagramPacketArray;
        if (localObject3 != null)
        {
          ((NativeDatagramPacketArray)localObject3).release();
          this.datagramPacketArray = null;
        }
        this.events.free();
      }
    }
  }
  
  public int getIoRatio()
  {
    return this.ioRatio;
  }
  
  void handleLoopException(Throwable paramThrowable)
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
  
  void modify(AbstractEpollChannel paramAbstractEpollChannel)
    throws IOException
  {
    Native.epollCtlMod(this.epollFd.intValue(), paramAbstractEpollChannel.socket.intValue(), paramAbstractEpollChannel.flags);
  }
  
  protected Queue<Runnable> newTaskQueue(int paramInt)
  {
    return newTaskQueue0(paramInt);
  }
  
  public int registeredChannels()
  {
    return this.channels.size();
  }
  
  void remove(AbstractEpollChannel paramAbstractEpollChannel)
    throws IOException
  {
    int i = paramAbstractEpollChannel.socket.intValue();
    AbstractEpollChannel localAbstractEpollChannel = (AbstractEpollChannel)this.channels.remove(i);
    if ((localAbstractEpollChannel != null) && (localAbstractEpollChannel != paramAbstractEpollChannel)) {
      this.channels.put(i, localAbstractEpollChannel);
    } else if (paramAbstractEpollChannel.isOpen()) {
      Native.epollCtlDel(this.epollFd.intValue(), i);
    }
  }
  
  /* Error */
  protected void run()
  {
    // Byte code:
    //   0: ldc2_w 18
    //   3: lstore_1
    //   4: lload_1
    //   5: lstore_3
    //   6: aload_0
    //   7: getfield 106	io/netty/channel/epoll/EpollEventLoop:selectStrategy	Lio/netty/channel/SelectStrategy;
    //   10: aload_0
    //   11: getfield 85	io/netty/channel/epoll/EpollEventLoop:selectNowSupplier	Lio/netty/util/IntSupplier;
    //   14: aload_0
    //   15: invokevirtual 385	io/netty/channel/SingleThreadEventLoop:hasTasks	()Z
    //   18: invokeinterface 389 3 0
    //   23: istore 5
    //   25: iload 5
    //   27: bipush -3
    //   29: if_icmpeq +284 -> 313
    //   32: iload 5
    //   34: bipush -2
    //   36: if_icmpeq -32 -> 4
    //   39: iload 5
    //   41: iconst_m1
    //   42: if_icmpeq +6 -> 48
    //   45: goto +276 -> 321
    //   48: iload 5
    //   50: istore 6
    //   52: lload_1
    //   53: lstore_3
    //   54: aload_0
    //   55: getfield 261	io/netty/channel/epoll/EpollEventLoop:pendingWakeup	Z
    //   58: ifeq +55 -> 113
    //   61: lload_1
    //   62: lstore_3
    //   63: aload_0
    //   64: invokespecial 334	io/netty/channel/epoll/EpollEventLoop:epollWaitTimeboxed	()I
    //   67: istore 5
    //   69: iload 5
    //   71: ifeq +6 -> 77
    //   74: goto +247 -> 321
    //   77: lload_1
    //   78: lstore_3
    //   79: getstatic 54	io/netty/channel/epoll/EpollEventLoop:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   82: ldc_w 391
    //   85: invokeinterface 394 2 0
    //   90: lload_1
    //   91: lstore_3
    //   92: aload_0
    //   93: iconst_0
    //   94: putfield 261	io/netty/channel/epoll/EpollEventLoop:pendingWakeup	Z
    //   97: iload 5
    //   99: istore 6
    //   101: lload_1
    //   102: lstore_3
    //   103: aload_0
    //   104: invokevirtual 385	io/netty/channel/SingleThreadEventLoop:hasTasks	()Z
    //   107: ifeq +6 -> 113
    //   110: goto +211 -> 321
    //   113: lload_1
    //   114: lstore_3
    //   115: aload_0
    //   116: invokevirtual 397	io/netty/util/concurrent/AbstractScheduledEventExecutor:nextScheduledTaskDeadlineNanos	()J
    //   119: lstore 7
    //   121: lload 7
    //   123: lstore 9
    //   125: lload 7
    //   127: ldc2_w 12
    //   130: lcmp
    //   131: ifne +8 -> 139
    //   134: ldc2_w 18
    //   137: lstore 9
    //   139: lload_1
    //   140: lstore_3
    //   141: aload_0
    //   142: getfield 92	io/netty/channel/epoll/EpollEventLoop:nextWakeupNanos	Ljava/util/concurrent/atomic/AtomicLong;
    //   145: lload 9
    //   147: invokevirtual 400	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   150: lload_1
    //   151: lstore 7
    //   153: aload_0
    //   154: invokevirtual 385	io/netty/channel/SingleThreadEventLoop:hasTasks	()Z
    //   157: ifne +45 -> 202
    //   160: lload 9
    //   162: lload_1
    //   163: lcmp
    //   164: ifne +15 -> 179
    //   167: aload_0
    //   168: invokespecial 402	io/netty/channel/epoll/EpollEventLoop:epollWaitNoTimerChange	()I
    //   171: istore 6
    //   173: lload_1
    //   174: lstore 7
    //   176: goto +26 -> 202
    //   179: aload_0
    //   180: lload 9
    //   182: invokespecial 404	io/netty/channel/epoll/EpollEventLoop:epollWait	(J)I
    //   185: istore 6
    //   187: lload 9
    //   189: lstore 7
    //   191: goto +11 -> 202
    //   194: astore 11
    //   196: lload 9
    //   198: lstore_1
    //   199: goto +67 -> 266
    //   202: lload 7
    //   204: lstore_3
    //   205: aload_0
    //   206: getfield 92	io/netty/channel/epoll/EpollEventLoop:nextWakeupNanos	Ljava/util/concurrent/atomic/AtomicLong;
    //   209: invokevirtual 311	java/util/concurrent/atomic/AtomicLong:get	()J
    //   212: ldc2_w 12
    //   215: lcmp
    //   216: ifeq +30 -> 246
    //   219: lload 7
    //   221: lstore_1
    //   222: iload 6
    //   224: istore 5
    //   226: lload 7
    //   228: lstore_3
    //   229: aload_0
    //   230: getfield 92	io/netty/channel/epoll/EpollEventLoop:nextWakeupNanos	Ljava/util/concurrent/atomic/AtomicLong;
    //   233: ldc2_w 12
    //   236: invokevirtual 407	java/util/concurrent/atomic/AtomicLong:getAndSet	(J)J
    //   239: ldc2_w 12
    //   242: lcmp
    //   243: ifne +78 -> 321
    //   246: lload 7
    //   248: lstore_3
    //   249: aload_0
    //   250: iconst_1
    //   251: putfield 261	io/netty/channel/epoll/EpollEventLoop:pendingWakeup	Z
    //   254: lload 7
    //   256: lstore_1
    //   257: iload 6
    //   259: istore 5
    //   261: goto +60 -> 321
    //   264: astore 11
    //   266: lload_1
    //   267: lstore_3
    //   268: aload_0
    //   269: getfield 92	io/netty/channel/epoll/EpollEventLoop:nextWakeupNanos	Ljava/util/concurrent/atomic/AtomicLong;
    //   272: invokevirtual 311	java/util/concurrent/atomic/AtomicLong:get	()J
    //   275: ldc2_w 12
    //   278: lcmp
    //   279: ifeq +22 -> 301
    //   282: lload_1
    //   283: lstore_3
    //   284: aload_0
    //   285: getfield 92	io/netty/channel/epoll/EpollEventLoop:nextWakeupNanos	Ljava/util/concurrent/atomic/AtomicLong;
    //   288: ldc2_w 12
    //   291: invokevirtual 407	java/util/concurrent/atomic/AtomicLong:getAndSet	(J)J
    //   294: ldc2_w 12
    //   297: lcmp
    //   298: ifne +10 -> 308
    //   301: lload_1
    //   302: lstore_3
    //   303: aload_0
    //   304: iconst_1
    //   305: putfield 261	io/netty/channel/epoll/EpollEventLoop:pendingWakeup	Z
    //   308: lload_1
    //   309: lstore_3
    //   310: aload 11
    //   312: athrow
    //   313: lload_1
    //   314: lstore_3
    //   315: aload_0
    //   316: invokespecial 409	io/netty/channel/epoll/EpollEventLoop:epollBusyWait	()I
    //   319: istore 5
    //   321: lload_1
    //   322: lstore_3
    //   323: aload_0
    //   324: getfield 94	io/netty/channel/epoll/EpollEventLoop:ioRatio	I
    //   327: istore 6
    //   329: iload 6
    //   331: bipush 100
    //   333: if_icmpne +67 -> 400
    //   336: lload_1
    //   337: lstore 7
    //   339: iload 5
    //   341: ifle +45 -> 386
    //   344: aload_0
    //   345: aload_0
    //   346: getfield 113	io/netty/channel/epoll/EpollEventLoop:events	Lio/netty/channel/epoll/EpollEventArray;
    //   349: iload 5
    //   351: invokespecial 411	io/netty/channel/epoll/EpollEventLoop:processReady	(Lio/netty/channel/epoll/EpollEventArray;I)Z
    //   354: istore 12
    //   356: lload_1
    //   357: lstore 7
    //   359: iload 12
    //   361: ifeq +25 -> 386
    //   364: ldc2_w 18
    //   367: lstore 7
    //   369: goto +17 -> 386
    //   372: astore 11
    //   374: lload_1
    //   375: lstore_3
    //   376: aload_0
    //   377: invokevirtual 416	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	()Z
    //   380: pop
    //   381: lload_1
    //   382: lstore_3
    //   383: aload 11
    //   385: athrow
    //   386: lload 7
    //   388: lstore_3
    //   389: aload_0
    //   390: invokevirtual 416	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	()Z
    //   393: pop
    //   394: lload 7
    //   396: lstore_1
    //   397: goto +102 -> 499
    //   400: iload 5
    //   402: ifle +89 -> 491
    //   405: lload_1
    //   406: lstore_3
    //   407: invokestatic 421	java/lang/System:nanoTime	()J
    //   410: lstore 7
    //   412: aload_0
    //   413: aload_0
    //   414: getfield 113	io/netty/channel/epoll/EpollEventLoop:events	Lio/netty/channel/epoll/EpollEventArray;
    //   417: iload 5
    //   419: invokespecial 411	io/netty/channel/epoll/EpollEventLoop:processReady	(Lio/netty/channel/epoll/EpollEventArray;I)Z
    //   422: istore 12
    //   424: iload 12
    //   426: ifeq +7 -> 433
    //   429: ldc2_w 18
    //   432: lstore_1
    //   433: lload_1
    //   434: lstore_3
    //   435: aload_0
    //   436: invokestatic 421	java/lang/System:nanoTime	()J
    //   439: lload 7
    //   441: lsub
    //   442: bipush 100
    //   444: iload 6
    //   446: isub
    //   447: i2l
    //   448: lmul
    //   449: iload 6
    //   451: i2l
    //   452: ldiv
    //   453: invokevirtual 423	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	(J)Z
    //   456: pop
    //   457: goto +42 -> 499
    //   460: astore 11
    //   462: lload_1
    //   463: lstore_3
    //   464: aload_0
    //   465: invokestatic 421	java/lang/System:nanoTime	()J
    //   468: lload 7
    //   470: lsub
    //   471: bipush 100
    //   473: iload 6
    //   475: isub
    //   476: i2l
    //   477: lmul
    //   478: iload 6
    //   480: i2l
    //   481: ldiv
    //   482: invokevirtual 423	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	(J)Z
    //   485: pop
    //   486: lload_1
    //   487: lstore_3
    //   488: aload 11
    //   490: athrow
    //   491: lload_1
    //   492: lstore_3
    //   493: aload_0
    //   494: lconst_0
    //   495: invokevirtual 423	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	(J)Z
    //   498: pop
    //   499: lload_1
    //   500: lstore_3
    //   501: lload_1
    //   502: lstore 7
    //   504: aload_0
    //   505: getfield 108	io/netty/channel/epoll/EpollEventLoop:allowGrowing	Z
    //   508: ifeq +46 -> 554
    //   511: lload_1
    //   512: lstore_3
    //   513: lload_1
    //   514: lstore 7
    //   516: iload 5
    //   518: aload_0
    //   519: getfield 113	io/netty/channel/epoll/EpollEventLoop:events	Lio/netty/channel/epoll/EpollEventArray;
    //   522: invokevirtual 426	io/netty/channel/epoll/EpollEventArray:length	()I
    //   525: if_icmpne +29 -> 554
    //   528: lload_1
    //   529: lstore_3
    //   530: aload_0
    //   531: getfield 113	io/netty/channel/epoll/EpollEventLoop:events	Lio/netty/channel/epoll/EpollEventArray;
    //   534: invokevirtual 429	io/netty/channel/epoll/EpollEventArray:increase	()V
    //   537: lload_1
    //   538: lstore 7
    //   540: goto +14 -> 554
    //   543: astore 11
    //   545: aload_0
    //   546: aload 11
    //   548: invokevirtual 431	io/netty/channel/epoll/EpollEventLoop:handleLoopException	(Ljava/lang/Throwable;)V
    //   551: lload_3
    //   552: lstore 7
    //   554: lload 7
    //   556: lstore_1
    //   557: aload_0
    //   558: invokevirtual 434	io/netty/util/concurrent/SingleThreadEventExecutor:isShuttingDown	()Z
    //   561: ifeq -557 -> 4
    //   564: aload_0
    //   565: invokespecial 436	io/netty/channel/epoll/EpollEventLoop:closeAll	()V
    //   568: aload_0
    //   569: invokevirtual 439	io/netty/util/concurrent/SingleThreadEventExecutor:confirmShutdown	()Z
    //   572: istore 12
    //   574: lload 7
    //   576: lstore_1
    //   577: iload 12
    //   579: ifeq -575 -> 4
    //   582: return
    //   583: astore 11
    //   585: aload_0
    //   586: aload 11
    //   588: invokevirtual 431	io/netty/channel/epoll/EpollEventLoop:handleLoopException	(Ljava/lang/Throwable;)V
    //   591: lload 7
    //   593: lstore_1
    //   594: goto -590 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	597	0	this	EpollEventLoop
    //   3	591	1	l1	long
    //   5	547	3	l2	long
    //   23	503	5	i	int
    //   50	429	6	j	int
    //   119	473	7	l3	long
    //   123	74	9	l4	long
    //   194	1	11	localObject1	Object
    //   264	47	11	localObject2	Object
    //   372	12	11	localObject3	Object
    //   460	29	11	localObject4	Object
    //   543	4	11	localThrowable1	Throwable
    //   583	4	11	localThrowable2	Throwable
    //   354	224	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   179	187	194	finally
    //   153	160	264	finally
    //   167	173	264	finally
    //   344	356	372	finally
    //   412	424	460	finally
    //   6	25	543	finally
    //   54	61	543	finally
    //   63	69	543	finally
    //   79	90	543	finally
    //   92	97	543	finally
    //   103	110	543	finally
    //   115	121	543	finally
    //   141	150	543	finally
    //   205	219	543	finally
    //   229	246	543	finally
    //   249	254	543	finally
    //   268	282	543	finally
    //   284	301	543	finally
    //   303	308	543	finally
    //   310	313	543	finally
    //   315	321	543	finally
    //   323	329	543	finally
    //   376	381	543	finally
    //   383	386	543	finally
    //   389	394	543	finally
    //   407	412	543	finally
    //   435	457	543	finally
    //   464	486	543	finally
    //   488	491	543	finally
    //   493	499	543	finally
    //   504	511	543	finally
    //   516	528	543	finally
    //   530	537	543	finally
    //   557	574	583	finally
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
    if ((!paramBoolean) && (this.nextWakeupNanos.getAndSet(-1L) != -1L)) {
      Native.eventFdWrite(this.eventFd.intValue(), 1L);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollEventLoop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */