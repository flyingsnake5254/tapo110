package io.netty.channel.nio;

import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelException;
import io.netty.channel.EventLoopException;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.IntSupplier;
import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReflectionUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public final class NioEventLoop
  extends SingleThreadEventLoop
{
  private static final long AWAKE = -1L;
  private static final int CLEANUP_INTERVAL = 256;
  private static final boolean DISABLE_KEY_SET_OPTIMIZATION;
  private static final int MIN_PREMATURE_SELECTOR_RETURNS = 3;
  private static final long NONE = Long.MAX_VALUE;
  private static final int SELECTOR_AUTO_REBUILD_THRESHOLD;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(NioEventLoop.class);
  private int cancelledKeys;
  private volatile int ioRatio = 50;
  private boolean needsToSelectAgain;
  private final AtomicLong nextWakeupNanos = new AtomicLong(-1L);
  private final SelectorProvider provider;
  private final IntSupplier selectNowSupplier = new IntSupplier()
  {
    public int get()
      throws Exception
    {
      return NioEventLoop.this.selectNow();
    }
  };
  private final SelectStrategy selectStrategy;
  private SelectedSelectionKeySet selectedKeys;
  private Selector selector;
  private Selector unwrappedSelector;
  
  static
  {
    int i = 0;
    DISABLE_KEY_SET_OPTIMIZATION = SystemPropertyUtil.getBoolean("io.netty.noKeySetOptimization", false);
    if (SystemPropertyUtil.get("sun.nio.ch.bugLevel") == null) {
      try
      {
        PrivilegedAction local2 = new io/netty/channel/nio/NioEventLoop$2;
        local2.<init>();
        AccessController.doPrivileged(local2);
      }
      catch (SecurityException localSecurityException)
      {
        logger.debug("Unable to get/set System Property: sun.nio.ch.bugLevel", localSecurityException);
      }
    }
    int j = SystemPropertyUtil.getInt("io.netty.selectorAutoRebuildThreshold", 512);
    if (j < 3) {
      j = i;
    }
    SELECTOR_AUTO_REBUILD_THRESHOLD = j;
    InternalLogger localInternalLogger = logger;
    if (localInternalLogger.isDebugEnabled())
    {
      localInternalLogger.debug("-Dio.netty.noKeySetOptimization: {}", Boolean.valueOf(DISABLE_KEY_SET_OPTIMIZATION));
      localInternalLogger.debug("-Dio.netty.selectorAutoRebuildThreshold: {}", Integer.valueOf(j));
    }
  }
  
  NioEventLoop(NioEventLoopGroup paramNioEventLoopGroup, Executor paramExecutor, SelectorProvider paramSelectorProvider, SelectStrategy paramSelectStrategy, RejectedExecutionHandler paramRejectedExecutionHandler, EventLoopTaskQueueFactory paramEventLoopTaskQueueFactory)
  {
    super(paramNioEventLoopGroup, paramExecutor, false, newTaskQueue(paramEventLoopTaskQueueFactory), newTaskQueue(paramEventLoopTaskQueueFactory), paramRejectedExecutionHandler);
    this.provider = ((SelectorProvider)ObjectUtil.checkNotNull(paramSelectorProvider, "selectorProvider"));
    this.selectStrategy = ((SelectStrategy)ObjectUtil.checkNotNull(paramSelectStrategy, "selectStrategy"));
    paramNioEventLoopGroup = openSelector();
    this.selector = paramNioEventLoopGroup.selector;
    this.unwrappedSelector = paramNioEventLoopGroup.unwrappedSelector;
  }
  
  private void closeAll()
  {
    selectAgain();
    Object localObject1 = this.selector.keys();
    Object localObject2 = new ArrayList(((Set)localObject1).size());
    Iterator localIterator = ((Set)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (SelectionKey)localIterator.next();
      Object localObject3 = ((SelectionKey)localObject1).attachment();
      if ((localObject3 instanceof AbstractNioChannel))
      {
        ((Collection)localObject2).add((AbstractNioChannel)localObject3);
      }
      else
      {
        ((SelectionKey)localObject1).cancel();
        invokeChannelUnregistered((NioTask)localObject3, (SelectionKey)localObject1, null);
      }
    }
    localObject1 = ((Collection)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AbstractNioChannel)((Iterator)localObject1).next();
      ((AbstractNioChannel)localObject2).unsafe().close(((AbstractNioChannel)localObject2).unsafe().voidPromise());
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
  
  private static void invokeChannelUnregistered(NioTask<SelectableChannel> paramNioTask, SelectionKey paramSelectionKey, Throwable paramThrowable)
  {
    try
    {
      paramNioTask.channelUnregistered(paramSelectionKey.channel(), paramThrowable);
    }
    catch (Exception paramNioTask)
    {
      logger.warn("Unexpected exception while running NioTask.channelUnregistered()", paramNioTask);
    }
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
  
  private SelectorTuple openSelector()
  {
    try
    {
      final AbstractSelector localAbstractSelector = this.provider.openSelector();
      if (DISABLE_KEY_SET_OPTIMIZATION) {
        return new SelectorTuple(localAbstractSelector);
      }
      final Object localObject1 = AccessController.doPrivileged(new PrivilegedAction()
      {
        public Object run()
        {
          try
          {
            localClass = Class.forName("sun.nio.ch.SelectorImpl", false, PlatformDependent.getSystemClassLoader());
          }
          finally
          {
            Class localClass;
            return localObject;
          }
        }
      });
      final Object localObject2;
      if ((localObject1 instanceof Class))
      {
        localObject2 = (Class)localObject1;
        if (((Class)localObject2).isAssignableFrom(localAbstractSelector.getClass()))
        {
          localObject1 = new SelectedSelectionKeySet();
          localObject2 = AccessController.doPrivileged(new PrivilegedAction()
          {
            public Object run()
            {
              try
              {
                Field localField1 = localObject2.getDeclaredField("selectedKeys");
                Field localField2 = localObject2.getDeclaredField("publicSelectedKeys");
                if ((PlatformDependent.javaVersion() >= 9) && (PlatformDependent.hasUnsafe()))
                {
                  long l1 = PlatformDependent.objectFieldOffset(localField1);
                  long l2 = PlatformDependent.objectFieldOffset(localField2);
                  if ((l1 != -1L) && (l2 != -1L))
                  {
                    PlatformDependent.putObject(localAbstractSelector, l1, localObject1);
                    PlatformDependent.putObject(localAbstractSelector, l2, localObject1);
                    return null;
                  }
                }
                Throwable localThrowable = ReflectionUtil.trySetAccessible(localField1, true);
                if (localThrowable != null) {
                  return localThrowable;
                }
                localThrowable = ReflectionUtil.trySetAccessible(localField2, true);
                if (localThrowable != null) {
                  return localThrowable;
                }
                localField1.set(localAbstractSelector, localObject1);
                localField2.set(localAbstractSelector, localObject1);
                return null;
              }
              catch (IllegalAccessException localIllegalAccessException)
              {
                return localIllegalAccessException;
              }
              catch (NoSuchFieldException localNoSuchFieldException)
              {
                return localNoSuchFieldException;
              }
            }
          });
          if ((localObject2 instanceof Exception))
          {
            this.selectedKeys = null;
            localObject2 = (Exception)localObject2;
            logger.trace("failed to instrument a special java.util.Set into: {}", localAbstractSelector, localObject2);
            return new SelectorTuple(localAbstractSelector);
          }
          this.selectedKeys = ((SelectedSelectionKeySet)localObject1);
          logger.trace("instrumented a special java.util.Set into: {}", localAbstractSelector);
          return new SelectorTuple(localAbstractSelector, new SelectedSelectionKeySetSelector(localAbstractSelector, (SelectedSelectionKeySet)localObject1));
        }
      }
      if ((localObject1 instanceof Throwable))
      {
        localObject2 = (Throwable)localObject1;
        logger.trace("failed to instrument a special java.util.Set into: {}", localAbstractSelector, localObject2);
      }
      return new SelectorTuple(localAbstractSelector);
    }
    catch (IOException localIOException)
    {
      throw new ChannelException("failed to open a new selector", localIOException);
    }
  }
  
  private void processSelectedKey(SelectionKey paramSelectionKey, AbstractNioChannel paramAbstractNioChannel)
  {
    AbstractNioChannel.NioUnsafe localNioUnsafe = paramAbstractNioChannel.unsafe();
    if (!paramSelectionKey.isValid()) {}
    for (;;)
    {
      try
      {
        paramSelectionKey = paramAbstractNioChannel.eventLoop();
        if (paramSelectionKey == this) {
          localNioUnsafe.close(localNioUnsafe.voidPromise());
        }
        return;
      }
      finally
      {
        int i;
        continue;
      }
      try
      {
        i = paramSelectionKey.readyOps();
        if ((i & 0x8) != 0)
        {
          paramSelectionKey.interestOps(paramSelectionKey.interestOps() & 0xFFFFFFF7);
          localNioUnsafe.finishConnect();
        }
        if ((i & 0x4) != 0) {
          paramAbstractNioChannel.unsafe().forceFlush();
        }
        if (((i & 0x11) != 0) || (i == 0)) {
          localNioUnsafe.read();
        }
      }
      catch (CancelledKeyException paramSelectionKey)
      {
        localNioUnsafe.close(localNioUnsafe.voidPromise());
      }
    }
  }
  
  /* Error */
  private static void processSelectedKey(SelectionKey paramSelectionKey, NioTask<SelectableChannel> paramNioTask)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: invokevirtual 280	java/nio/channels/SelectionKey:channel	()Ljava/nio/channels/SelectableChannel;
    //   5: aload_0
    //   6: invokeinterface 401 3 0
    //   11: aload_0
    //   12: invokevirtual 372	java/nio/channels/SelectionKey:isValid	()Z
    //   15: ifne +27 -> 42
    //   18: aload_1
    //   19: aload_0
    //   20: aconst_null
    //   21: invokestatic 243	io/netty/channel/nio/NioEventLoop:invokeChannelUnregistered	(Lio/netty/channel/nio/NioTask;Ljava/nio/channels/SelectionKey;Ljava/lang/Throwable;)V
    //   24: goto +18 -> 42
    //   27: astore_2
    //   28: goto +15 -> 43
    //   31: astore_2
    //   32: aload_0
    //   33: invokevirtual 237	java/nio/channels/SelectionKey:cancel	()V
    //   36: aload_1
    //   37: aload_0
    //   38: aload_2
    //   39: invokestatic 243	io/netty/channel/nio/NioEventLoop:invokeChannelUnregistered	(Lio/netty/channel/nio/NioTask;Ljava/nio/channels/SelectionKey;Ljava/lang/Throwable;)V
    //   42: return
    //   43: aload_0
    //   44: invokevirtual 237	java/nio/channels/SelectionKey:cancel	()V
    //   47: aload_1
    //   48: aload_0
    //   49: aconst_null
    //   50: invokestatic 243	io/netty/channel/nio/NioEventLoop:invokeChannelUnregistered	(Lio/netty/channel/nio/NioTask;Ljava/nio/channels/SelectionKey;Ljava/lang/Throwable;)V
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramSelectionKey	SelectionKey
    //   0	55	1	paramNioTask	NioTask<SelectableChannel>
    //   27	1	2	localObject	Object
    //   31	23	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	11	27	finally
    //   32	42	27	finally
    //   0	11	31	java/lang/Exception
  }
  
  private void processSelectedKeys()
  {
    if (this.selectedKeys != null) {
      processSelectedKeysOptimized();
    } else {
      processSelectedKeysPlain(this.selector.selectedKeys());
    }
  }
  
  private void processSelectedKeysOptimized()
  {
    int j;
    for (int i = 0;; i = j + 1)
    {
      SelectedSelectionKeySet localSelectedSelectionKeySet = this.selectedKeys;
      if (i >= localSelectedSelectionKeySet.size) {
        break;
      }
      Object localObject = localSelectedSelectionKeySet.keys;
      localSelectedSelectionKeySet = localObject[i];
      localObject[i] = null;
      localObject = localSelectedSelectionKeySet.attachment();
      if ((localObject instanceof AbstractNioChannel)) {
        processSelectedKey(localSelectedSelectionKeySet, (AbstractNioChannel)localObject);
      } else {
        processSelectedKey(localSelectedSelectionKeySet, (NioTask)localObject);
      }
      j = i;
      if (this.needsToSelectAgain)
      {
        this.selectedKeys.reset(i + 1);
        selectAgain();
        j = -1;
      }
    }
  }
  
  private void processSelectedKeysPlain(Set<SelectionKey> paramSet)
  {
    if (paramSet.isEmpty()) {
      return;
    }
    paramSet = paramSet.iterator();
    for (;;)
    {
      SelectionKey localSelectionKey = (SelectionKey)paramSet.next();
      Object localObject = localSelectionKey.attachment();
      paramSet.remove();
      if ((localObject instanceof AbstractNioChannel)) {
        processSelectedKey(localSelectionKey, (AbstractNioChannel)localObject);
      } else {
        processSelectedKey(localSelectionKey, (NioTask)localObject);
      }
      if (paramSet.hasNext())
      {
        if (!this.needsToSelectAgain) {
          continue;
        }
        selectAgain();
        paramSet = this.selector.selectedKeys();
        if (!paramSet.isEmpty()) {}
      }
      else
      {
        return;
      }
      paramSet = paramSet.iterator();
    }
  }
  
  /* Error */
  private void rebuildSelector0()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 174	io/netty/channel/nio/NioEventLoop:selector	Ljava/nio/channels/Selector;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: invokespecial 171	io/netty/channel/nio/NioEventLoop:openSelector	()Lio/netty/channel/nio/NioEventLoop$SelectorTuple;
    //   14: astore_2
    //   15: iconst_0
    //   16: istore_3
    //   17: aload_1
    //   18: invokevirtual 197	java/nio/channels/Selector:keys	()Ljava/util/Set;
    //   21: invokeinterface 212 1 0
    //   26: astore 4
    //   28: aload 4
    //   30: invokeinterface 217 1 0
    //   35: ifeq +170 -> 205
    //   38: aload 4
    //   40: invokeinterface 221 1 0
    //   45: checkcast 223	java/nio/channels/SelectionKey
    //   48: astore 5
    //   50: aload 5
    //   52: invokevirtual 226	java/nio/channels/SelectionKey:attachment	()Ljava/lang/Object;
    //   55: astore 6
    //   57: aload 5
    //   59: invokevirtual 372	java/nio/channels/SelectionKey:isValid	()Z
    //   62: ifeq -34 -> 28
    //   65: aload 5
    //   67: invokevirtual 280	java/nio/channels/SelectionKey:channel	()Ljava/nio/channels/SelectableChannel;
    //   70: aload_2
    //   71: getfield 176	io/netty/channel/nio/NioEventLoop$SelectorTuple:unwrappedSelector	Ljava/nio/channels/Selector;
    //   74: invokevirtual 439	java/nio/channels/SelectableChannel:keyFor	(Ljava/nio/channels/Selector;)Ljava/nio/channels/SelectionKey;
    //   77: ifnull +6 -> 83
    //   80: goto -52 -> 28
    //   83: aload 5
    //   85: invokevirtual 382	java/nio/channels/SelectionKey:interestOps	()I
    //   88: istore 7
    //   90: aload 5
    //   92: invokevirtual 237	java/nio/channels/SelectionKey:cancel	()V
    //   95: aload 5
    //   97: invokevirtual 280	java/nio/channels/SelectionKey:channel	()Ljava/nio/channels/SelectableChannel;
    //   100: aload_2
    //   101: getfield 176	io/netty/channel/nio/NioEventLoop$SelectorTuple:unwrappedSelector	Ljava/nio/channels/Selector;
    //   104: iload 7
    //   106: aload 6
    //   108: invokevirtual 443	java/nio/channels/SelectableChannel:register	(Ljava/nio/channels/Selector;ILjava/lang/Object;)Ljava/nio/channels/SelectionKey;
    //   111: astore 8
    //   113: aload 6
    //   115: instanceof 228
    //   118: ifeq +13 -> 131
    //   121: aload 6
    //   123: checkcast 228	io/netty/channel/nio/AbstractNioChannel
    //   126: aload 8
    //   128: putfield 447	io/netty/channel/nio/AbstractNioChannel:selectionKey	Ljava/nio/channels/SelectionKey;
    //   131: iinc 3 1
    //   134: goto -106 -> 28
    //   137: astore 8
    //   139: getstatic 64	io/netty/channel/nio/NioEventLoop:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   142: ldc_w 449
    //   145: aload 8
    //   147: invokeinterface 267 3 0
    //   152: aload 6
    //   154: instanceof 228
    //   157: ifeq +33 -> 190
    //   160: aload 6
    //   162: checkcast 228	io/netty/channel/nio/AbstractNioChannel
    //   165: astore 6
    //   167: aload 6
    //   169: invokevirtual 248	io/netty/channel/nio/AbstractNioChannel:unsafe	()Lio/netty/channel/nio/AbstractNioChannel$NioUnsafe;
    //   172: aload 6
    //   174: invokevirtual 248	io/netty/channel/nio/AbstractNioChannel:unsafe	()Lio/netty/channel/nio/AbstractNioChannel$NioUnsafe;
    //   177: invokeinterface 254 1 0
    //   182: invokeinterface 258 2 0
    //   187: goto -159 -> 28
    //   190: aload 6
    //   192: checkcast 239	io/netty/channel/nio/NioTask
    //   195: aload 5
    //   197: aload 8
    //   199: invokestatic 243	io/netty/channel/nio/NioEventLoop:invokeChannelUnregistered	(Lio/netty/channel/nio/NioTask;Ljava/nio/channels/SelectionKey;Ljava/lang/Throwable;)V
    //   202: goto -174 -> 28
    //   205: aload_0
    //   206: aload_2
    //   207: getfield 173	io/netty/channel/nio/NioEventLoop$SelectorTuple:selector	Ljava/nio/channels/Selector;
    //   210: putfield 174	io/netty/channel/nio/NioEventLoop:selector	Ljava/nio/channels/Selector;
    //   213: aload_0
    //   214: aload_2
    //   215: getfield 176	io/netty/channel/nio/NioEventLoop$SelectorTuple:unwrappedSelector	Ljava/nio/channels/Selector;
    //   218: putfield 177	io/netty/channel/nio/NioEventLoop:unwrappedSelector	Ljava/nio/channels/Selector;
    //   221: aload_1
    //   222: invokevirtual 451	java/nio/channels/Selector:close	()V
    //   225: goto +27 -> 252
    //   228: astore_2
    //   229: getstatic 64	io/netty/channel/nio/NioEventLoop:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   232: invokeinterface 454 1 0
    //   237: ifeq +15 -> 252
    //   240: getstatic 64	io/netty/channel/nio/NioEventLoop:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   243: ldc_w 456
    //   246: aload_2
    //   247: invokeinterface 267 3 0
    //   252: getstatic 64	io/netty/channel/nio/NioEventLoop:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   255: astore_1
    //   256: aload_1
    //   257: invokeinterface 459 1 0
    //   262: ifeq +43 -> 305
    //   265: new 461	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 462	java/lang/StringBuilder:<init>	()V
    //   272: astore_2
    //   273: aload_2
    //   274: ldc_w 464
    //   277: invokevirtual 468	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_2
    //   282: iload_3
    //   283: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_2
    //   288: ldc_w 473
    //   291: invokevirtual 468	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_1
    //   296: aload_2
    //   297: invokevirtual 477	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokeinterface 481 2 0
    //   305: return
    //   306: astore_2
    //   307: getstatic 64	io/netty/channel/nio/NioEventLoop:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   310: ldc_w 483
    //   313: aload_2
    //   314: invokeinterface 267 3 0
    //   319: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	NioEventLoop
    //   4	292	1	localObject1	Object
    //   14	201	2	localSelectorTuple	SelectorTuple
    //   228	19	2	localThrowable	Throwable
    //   272	25	2	localStringBuilder	StringBuilder
    //   306	8	2	localException1	Exception
    //   16	267	3	i	int
    //   26	13	4	localIterator	Iterator
    //   48	148	5	localSelectionKey1	SelectionKey
    //   55	136	6	localObject2	Object
    //   88	17	7	j	int
    //   111	16	8	localSelectionKey2	SelectionKey
    //   137	61	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   57	80	137	java/lang/Exception
    //   83	131	137	java/lang/Exception
    //   221	225	228	finally
    //   10	15	306	java/lang/Exception
  }
  
  private void register0(SelectableChannel paramSelectableChannel, int paramInt, NioTask<?> paramNioTask)
  {
    try
    {
      paramSelectableChannel.register(this.unwrappedSelector, paramInt, paramNioTask);
      return;
    }
    catch (Exception paramSelectableChannel)
    {
      throw new EventLoopException("failed to register a channel", paramSelectableChannel);
    }
  }
  
  private int select(long paramLong)
    throws IOException
  {
    if (paramLong == Long.MAX_VALUE) {
      return this.selector.select();
    }
    paramLong = AbstractScheduledEventExecutor.deadlineToDelayNanos(paramLong + 995000L) / 1000000L;
    int i;
    if (paramLong <= 0L) {
      i = this.selector.selectNow();
    } else {
      i = this.selector.select(paramLong);
    }
    return i;
  }
  
  /* Error */
  private void selectAgain()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 423	io/netty/channel/nio/NioEventLoop:needsToSelectAgain	Z
    //   5: aload_0
    //   6: getfield 174	io/netty/channel/nio/NioEventLoop:selector	Ljava/nio/channels/Selector;
    //   9: invokevirtual 506	java/nio/channels/Selector:selectNow	()I
    //   12: pop
    //   13: goto +16 -> 29
    //   16: astore_1
    //   17: getstatic 64	io/netty/channel/nio/NioEventLoop:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   20: ldc_w 511
    //   23: aload_1
    //   24: invokeinterface 267 3 0
    //   29: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	NioEventLoop
    //   16	8	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   5	13	16	finally
  }
  
  private boolean unexpectedSelectorWakeup(int paramInt)
  {
    if (Thread.interrupted())
    {
      InternalLogger localInternalLogger = logger;
      if (localInternalLogger.isDebugEnabled()) {
        localInternalLogger.debug("Selector.select() returned prematurely because Thread.currentThread().interrupt() was called. Use NioEventLoop.shutdownGracefully() to shutdown the NioEventLoop.");
      }
      return true;
    }
    int i = SELECTOR_AUTO_REBUILD_THRESHOLD;
    if ((i > 0) && (paramInt >= i))
    {
      logger.warn("Selector.select() returned prematurely {} times in a row; rebuilding Selector {}.", Integer.valueOf(paramInt), this.selector);
      rebuildSelector();
      return true;
    }
    return false;
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
  
  void cancel(SelectionKey paramSelectionKey)
  {
    paramSelectionKey.cancel();
    int i = this.cancelledKeys + 1;
    this.cancelledKeys = i;
    if (i >= 256)
    {
      this.cancelledKeys = 0;
      this.needsToSelectAgain = true;
    }
  }
  
  protected void cleanup()
  {
    try
    {
      this.selector.close();
    }
    catch (IOException localIOException)
    {
      logger.warn("Failed to close a selector.", localIOException);
    }
  }
  
  public int getIoRatio()
  {
    return this.ioRatio;
  }
  
  protected Queue<Runnable> newTaskQueue(int paramInt)
  {
    return newTaskQueue0(paramInt);
  }
  
  public void rebuildSelector()
  {
    if (!inEventLoop())
    {
      execute(new Runnable()
      {
        public void run()
        {
          NioEventLoop.this.rebuildSelector0();
        }
      });
      return;
    }
    rebuildSelector0();
  }
  
  public void register(SelectableChannel paramSelectableChannel, int paramInt, NioTask<?> paramNioTask)
  {
    ObjectUtil.checkNotNull(paramSelectableChannel, "ch");
    if (paramInt != 0)
    {
      if (((paramSelectableChannel.validOps() ^ 0xFFFFFFFF) & paramInt) == 0)
      {
        ObjectUtil.checkNotNull(paramNioTask, "task");
        if (!isShutdown())
        {
          if (inEventLoop()) {
            register0(paramSelectableChannel, paramInt, paramNioTask);
          } else {
            try
            {
              Runnable local5 = new io/netty/channel/nio/NioEventLoop$5;
              local5.<init>(this, paramSelectableChannel, paramInt, paramNioTask);
              submit(local5).sync();
            }
            catch (InterruptedException paramSelectableChannel)
            {
              Thread.currentThread().interrupt();
            }
          }
          return;
        }
        throw new IllegalStateException("event loop shut down");
      }
      paramNioTask = new StringBuilder();
      paramNioTask.append("invalid interestOps: ");
      paramNioTask.append(paramInt);
      paramNioTask.append("(validOps: ");
      paramNioTask.append(paramSelectableChannel.validOps());
      paramNioTask.append(')');
      throw new IllegalArgumentException(paramNioTask.toString());
    }
    throw new IllegalArgumentException("interestOps must be non-zero.");
  }
  
  public int registeredChannels()
  {
    return this.selector.keys().size() - this.cancelledKeys;
  }
  
  /* Error */
  protected void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: istore_2
    //   4: iload_1
    //   5: istore_3
    //   6: aload_0
    //   7: getfield 167	io/netty/channel/nio/NioEventLoop:selectStrategy	Lio/netty/channel/SelectStrategy;
    //   10: aload_0
    //   11: getfield 141	io/netty/channel/nio/NioEventLoop:selectNowSupplier	Lio/netty/util/IntSupplier;
    //   14: aload_0
    //   15: invokevirtual 604	io/netty/channel/SingleThreadEventLoop:hasTasks	()Z
    //   18: invokeinterface 608 3 0
    //   23: istore 4
    //   25: iload 4
    //   27: bipush -3
    //   29: if_icmpeq +19 -> 48
    //   32: iload 4
    //   34: bipush -2
    //   36: if_icmpeq -34 -> 2
    //   39: iload 4
    //   41: iconst_m1
    //   42: if_icmpeq +6 -> 48
    //   45: goto +73 -> 118
    //   48: iload_1
    //   49: istore_2
    //   50: iload_1
    //   51: istore_3
    //   52: aload_0
    //   53: invokevirtual 611	io/netty/util/concurrent/AbstractScheduledEventExecutor:nextScheduledTaskDeadlineNanos	()J
    //   56: lstore 5
    //   58: lload 5
    //   60: lstore 7
    //   62: lload 5
    //   64: ldc2_w 22
    //   67: lcmp
    //   68: ifne +8 -> 76
    //   71: ldc2_w 32
    //   74: lstore 7
    //   76: iload_1
    //   77: istore_2
    //   78: iload_1
    //   79: istore_3
    //   80: aload_0
    //   81: getfield 148	io/netty/channel/nio/NioEventLoop:nextWakeupNanos	Ljava/util/concurrent/atomic/AtomicLong;
    //   84: lload 7
    //   86: invokevirtual 614	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   89: aload_0
    //   90: invokevirtual 604	io/netty/channel/SingleThreadEventLoop:hasTasks	()Z
    //   93: ifne +11 -> 104
    //   96: aload_0
    //   97: lload 7
    //   99: invokespecial 615	io/netty/channel/nio/NioEventLoop:select	(J)I
    //   102: istore 4
    //   104: iload_1
    //   105: istore_2
    //   106: iload_1
    //   107: istore_3
    //   108: aload_0
    //   109: getfield 148	io/netty/channel/nio/NioEventLoop:nextWakeupNanos	Ljava/util/concurrent/atomic/AtomicLong;
    //   112: ldc2_w 22
    //   115: invokevirtual 618	java/util/concurrent/atomic/AtomicLong:lazySet	(J)V
    //   118: iinc 1 1
    //   121: iload_1
    //   122: istore_2
    //   123: iload_1
    //   124: istore_3
    //   125: aload_0
    //   126: iconst_0
    //   127: putfield 536	io/netty/channel/nio/NioEventLoop:cancelledKeys	I
    //   130: iload_1
    //   131: istore_2
    //   132: iload_1
    //   133: istore_3
    //   134: aload_0
    //   135: iconst_0
    //   136: putfield 423	io/netty/channel/nio/NioEventLoop:needsToSelectAgain	Z
    //   139: iload_1
    //   140: istore_2
    //   141: iload_1
    //   142: istore_3
    //   143: aload_0
    //   144: getfield 150	io/netty/channel/nio/NioEventLoop:ioRatio	I
    //   147: istore 9
    //   149: iload 9
    //   151: bipush 100
    //   153: if_icmpne +46 -> 199
    //   156: iload 4
    //   158: ifle +28 -> 186
    //   161: aload_0
    //   162: invokespecial 620	io/netty/channel/nio/NioEventLoop:processSelectedKeys	()V
    //   165: goto +21 -> 186
    //   168: astore 10
    //   170: iload_1
    //   171: istore_2
    //   172: iload_1
    //   173: istore_3
    //   174: aload_0
    //   175: invokevirtual 623	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	()Z
    //   178: pop
    //   179: iload_1
    //   180: istore_2
    //   181: iload_1
    //   182: istore_3
    //   183: aload 10
    //   185: athrow
    //   186: iload_1
    //   187: istore_2
    //   188: iload_1
    //   189: istore_3
    //   190: aload_0
    //   191: invokevirtual 623	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	()Z
    //   194: istore 11
    //   196: goto +97 -> 293
    //   199: iload 4
    //   201: ifle +81 -> 282
    //   204: iload_1
    //   205: istore_2
    //   206: iload_1
    //   207: istore_3
    //   208: invokestatic 628	java/lang/System:nanoTime	()J
    //   211: lstore 7
    //   213: aload_0
    //   214: invokespecial 620	io/netty/channel/nio/NioEventLoop:processSelectedKeys	()V
    //   217: iload_1
    //   218: istore_2
    //   219: iload_1
    //   220: istore_3
    //   221: aload_0
    //   222: invokestatic 628	java/lang/System:nanoTime	()J
    //   225: lload 7
    //   227: lsub
    //   228: bipush 100
    //   230: iload 9
    //   232: isub
    //   233: i2l
    //   234: lmul
    //   235: iload 9
    //   237: i2l
    //   238: ldiv
    //   239: invokevirtual 630	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	(J)Z
    //   242: istore 11
    //   244: goto +49 -> 293
    //   247: astore 10
    //   249: iload_1
    //   250: istore_2
    //   251: iload_1
    //   252: istore_3
    //   253: aload_0
    //   254: invokestatic 628	java/lang/System:nanoTime	()J
    //   257: lload 7
    //   259: lsub
    //   260: bipush 100
    //   262: iload 9
    //   264: isub
    //   265: i2l
    //   266: lmul
    //   267: iload 9
    //   269: i2l
    //   270: ldiv
    //   271: invokevirtual 630	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	(J)Z
    //   274: pop
    //   275: iload_1
    //   276: istore_2
    //   277: iload_1
    //   278: istore_3
    //   279: aload 10
    //   281: athrow
    //   282: iload_1
    //   283: istore_2
    //   284: iload_1
    //   285: istore_3
    //   286: aload_0
    //   287: lconst_0
    //   288: invokevirtual 630	io/netty/util/concurrent/SingleThreadEventExecutor:runAllTasks	(J)Z
    //   291: istore 11
    //   293: iload 11
    //   295: ifne +29 -> 324
    //   298: iload 4
    //   300: ifle +6 -> 306
    //   303: goto +21 -> 324
    //   306: iload_1
    //   307: istore_2
    //   308: iload_1
    //   309: istore_3
    //   310: iload_1
    //   311: istore 4
    //   313: aload_0
    //   314: iload_1
    //   315: invokespecial 632	io/netty/channel/nio/NioEventLoop:unexpectedSelectorWakeup	(I)Z
    //   318: ifeq +210 -> 528
    //   321: goto +55 -> 376
    //   324: iload_1
    //   325: iconst_3
    //   326: if_icmple +50 -> 376
    //   329: iload_1
    //   330: istore_2
    //   331: iload_1
    //   332: istore_3
    //   333: getstatic 64	io/netty/channel/nio/NioEventLoop:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   336: astore 10
    //   338: iload_1
    //   339: istore_2
    //   340: iload_1
    //   341: istore_3
    //   342: aload 10
    //   344: invokeinterface 109 1 0
    //   349: ifeq +27 -> 376
    //   352: iload_1
    //   353: istore_2
    //   354: iload_1
    //   355: istore_3
    //   356: aload 10
    //   358: ldc_w 634
    //   361: iload_1
    //   362: iconst_1
    //   363: isub
    //   364: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   367: aload_0
    //   368: getfield 174	io/netty/channel/nio/NioEventLoop:selector	Ljava/nio/channels/Selector;
    //   371: invokeinterface 636 4 0
    //   376: iconst_0
    //   377: istore 4
    //   379: goto +149 -> 528
    //   382: astore 10
    //   384: iload_1
    //   385: istore_2
    //   386: iload_1
    //   387: istore_3
    //   388: aload_0
    //   389: getfield 148	io/netty/channel/nio/NioEventLoop:nextWakeupNanos	Ljava/util/concurrent/atomic/AtomicLong;
    //   392: ldc2_w 22
    //   395: invokevirtual 618	java/util/concurrent/atomic/AtomicLong:lazySet	(J)V
    //   398: iload_1
    //   399: istore_2
    //   400: iload_1
    //   401: istore_3
    //   402: aload 10
    //   404: athrow
    //   405: astore 10
    //   407: iload_2
    //   408: istore 4
    //   410: goto +41 -> 451
    //   413: astore 10
    //   415: goto +44 -> 459
    //   418: astore 10
    //   420: iload_1
    //   421: istore_2
    //   422: iload_1
    //   423: istore_3
    //   424: aload_0
    //   425: invokespecial 187	io/netty/channel/nio/NioEventLoop:rebuildSelector0	()V
    //   428: aload 10
    //   430: invokestatic 638	io/netty/channel/nio/NioEventLoop:handleLoopException	(Ljava/lang/Throwable;)V
    //   433: goto -433 -> 0
    //   436: astore 10
    //   438: iconst_0
    //   439: istore 4
    //   441: goto +10 -> 451
    //   444: astore 10
    //   446: iconst_0
    //   447: istore_3
    //   448: goto +11 -> 459
    //   451: aload 10
    //   453: invokestatic 638	io/netty/channel/nio/NioEventLoop:handleLoopException	(Ljava/lang/Throwable;)V
    //   456: goto +72 -> 528
    //   459: getstatic 64	io/netty/channel/nio/NioEventLoop:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   462: astore 12
    //   464: iload_3
    //   465: istore 4
    //   467: aload 12
    //   469: invokeinterface 109 1 0
    //   474: ifeq +54 -> 528
    //   477: new 461	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 462	java/lang/StringBuilder:<init>	()V
    //   484: astore 13
    //   486: aload 13
    //   488: ldc_w 369
    //   491: invokevirtual 641	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   494: invokevirtual 468	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 13
    //   500: ldc_w 643
    //   503: invokevirtual 468	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload 12
    //   509: aload 13
    //   511: invokevirtual 477	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: aload_0
    //   515: getfield 174	io/netty/channel/nio/NioEventLoop:selector	Ljava/nio/channels/Selector;
    //   518: aload 10
    //   520: invokeinterface 636 4 0
    //   525: iload_3
    //   526: istore 4
    //   528: iload 4
    //   530: istore_1
    //   531: aload_0
    //   532: invokevirtual 646	io/netty/util/concurrent/SingleThreadEventExecutor:isShuttingDown	()Z
    //   535: ifeq -533 -> 2
    //   538: aload_0
    //   539: invokespecial 648	io/netty/channel/nio/NioEventLoop:closeAll	()V
    //   542: aload_0
    //   543: invokevirtual 651	io/netty/util/concurrent/SingleThreadEventExecutor:confirmShutdown	()Z
    //   546: istore 11
    //   548: iload 4
    //   550: istore_1
    //   551: iload 11
    //   553: ifeq -551 -> 2
    //   556: return
    //   557: astore 10
    //   559: aload 10
    //   561: invokestatic 638	io/netty/channel/nio/NioEventLoop:handleLoopException	(Ljava/lang/Throwable;)V
    //   564: iload 4
    //   566: istore_1
    //   567: goto -565 -> 2
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	570	0	this	NioEventLoop
    //   1	566	1	i	int
    //   3	419	2	j	int
    //   5	521	3	k	int
    //   23	542	4	m	int
    //   56	7	5	l1	long
    //   60	198	7	l2	long
    //   147	121	9	n	int
    //   168	16	10	localObject1	Object
    //   247	33	10	localObject2	Object
    //   336	21	10	localInternalLogger1	InternalLogger
    //   382	21	10	localObject3	Object
    //   405	1	10	localObject4	Object
    //   413	1	10	localCancelledKeyException1	CancelledKeyException
    //   418	11	10	localIOException	IOException
    //   436	1	10	localObject5	Object
    //   444	75	10	localCancelledKeyException2	CancelledKeyException
    //   557	3	10	localThrowable	Throwable
    //   194	358	11	bool	boolean
    //   462	46	12	localInternalLogger2	InternalLogger
    //   484	26	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   161	165	168	finally
    //   213	217	247	finally
    //   89	104	382	finally
    //   6	25	405	finally
    //   52	58	405	finally
    //   80	89	405	finally
    //   108	118	405	finally
    //   125	130	405	finally
    //   134	139	405	finally
    //   143	149	405	finally
    //   174	179	405	finally
    //   183	186	405	finally
    //   190	196	405	finally
    //   208	213	405	finally
    //   221	244	405	finally
    //   253	275	405	finally
    //   279	282	405	finally
    //   286	293	405	finally
    //   313	321	405	finally
    //   333	338	405	finally
    //   342	352	405	finally
    //   356	376	405	finally
    //   388	398	405	finally
    //   402	405	405	finally
    //   424	428	405	finally
    //   6	25	413	java/nio/channels/CancelledKeyException
    //   52	58	413	java/nio/channels/CancelledKeyException
    //   80	89	413	java/nio/channels/CancelledKeyException
    //   108	118	413	java/nio/channels/CancelledKeyException
    //   125	130	413	java/nio/channels/CancelledKeyException
    //   134	139	413	java/nio/channels/CancelledKeyException
    //   143	149	413	java/nio/channels/CancelledKeyException
    //   174	179	413	java/nio/channels/CancelledKeyException
    //   183	186	413	java/nio/channels/CancelledKeyException
    //   190	196	413	java/nio/channels/CancelledKeyException
    //   208	213	413	java/nio/channels/CancelledKeyException
    //   221	244	413	java/nio/channels/CancelledKeyException
    //   253	275	413	java/nio/channels/CancelledKeyException
    //   279	282	413	java/nio/channels/CancelledKeyException
    //   286	293	413	java/nio/channels/CancelledKeyException
    //   313	321	413	java/nio/channels/CancelledKeyException
    //   333	338	413	java/nio/channels/CancelledKeyException
    //   342	352	413	java/nio/channels/CancelledKeyException
    //   356	376	413	java/nio/channels/CancelledKeyException
    //   388	398	413	java/nio/channels/CancelledKeyException
    //   402	405	413	java/nio/channels/CancelledKeyException
    //   424	428	413	java/nio/channels/CancelledKeyException
    //   6	25	418	java/io/IOException
    //   52	58	418	java/io/IOException
    //   80	89	418	java/io/IOException
    //   108	118	418	java/io/IOException
    //   388	398	418	java/io/IOException
    //   402	405	418	java/io/IOException
    //   428	433	436	finally
    //   428	433	444	java/nio/channels/CancelledKeyException
    //   531	548	557	finally
  }
  
  int selectNow()
    throws IOException
  {
    return this.selector.selectNow();
  }
  
  public SelectorProvider selectorProvider()
  {
    return this.provider;
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
  
  Selector unwrappedSelector()
  {
    return this.unwrappedSelector;
  }
  
  protected void wakeup(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.nextWakeupNanos.getAndSet(-1L) != -1L)) {
      this.selector.wakeup();
    }
  }
  
  private static final class SelectorTuple
  {
    final Selector selector;
    final Selector unwrappedSelector;
    
    SelectorTuple(Selector paramSelector)
    {
      this.unwrappedSelector = paramSelector;
      this.selector = paramSelector;
    }
    
    SelectorTuple(Selector paramSelector1, Selector paramSelector2)
    {
      this.unwrappedSelector = paramSelector1;
      this.selector = paramSelector2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\nio\NioEventLoop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */