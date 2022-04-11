package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DefaultChannelPipeline
  implements ChannelPipeline
{
  private static final AtomicReferenceFieldUpdater<DefaultChannelPipeline, MessageSizeEstimator.Handle> ESTIMATOR = AtomicReferenceFieldUpdater.newUpdater(DefaultChannelPipeline.class, MessageSizeEstimator.Handle.class, "estimatorHandle");
  private static final String HEAD_NAME;
  private static final String TAIL_NAME;
  static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultChannelPipeline.class);
  private static final FastThreadLocal<Map<Class<?>, String>> nameCaches;
  private final Channel channel;
  private Map<EventExecutorGroup, EventExecutor> childExecutors;
  private volatile MessageSizeEstimator.Handle estimatorHandle;
  private boolean firstRegistration = true;
  final AbstractChannelHandlerContext head;
  private PendingHandlerCallback pendingHandlerCallbackHead;
  private boolean registered;
  private final ChannelFuture succeededFuture;
  final AbstractChannelHandlerContext tail;
  private final boolean touch = ResourceLeakDetector.isEnabled();
  private final VoidChannelPromise voidPromise;
  
  static
  {
    HEAD_NAME = generateName0(HeadContext.class);
    TAIL_NAME = generateName0(TailContext.class);
    nameCaches = new FastThreadLocal()
    {
      protected Map<Class<?>, String> initialValue()
      {
        return new WeakHashMap();
      }
    };
  }
  
  protected DefaultChannelPipeline(Channel paramChannel)
  {
    this.channel = ((Channel)ObjectUtil.checkNotNull(paramChannel, "channel"));
    this.succeededFuture = new SucceededChannelFuture(paramChannel, null);
    this.voidPromise = new VoidChannelPromise(paramChannel, true);
    TailContext localTailContext = new TailContext(this);
    this.tail = localTailContext;
    paramChannel = new HeadContext(this);
    this.head = paramChannel;
    paramChannel.next = localTailContext;
    localTailContext.prev = paramChannel;
  }
  
  private static void addAfter0(AbstractChannelHandlerContext paramAbstractChannelHandlerContext1, AbstractChannelHandlerContext paramAbstractChannelHandlerContext2)
  {
    paramAbstractChannelHandlerContext2.prev = paramAbstractChannelHandlerContext1;
    paramAbstractChannelHandlerContext2.next = paramAbstractChannelHandlerContext1.next;
    paramAbstractChannelHandlerContext1.next.prev = paramAbstractChannelHandlerContext2;
    paramAbstractChannelHandlerContext1.next = paramAbstractChannelHandlerContext2;
  }
  
  private static void addBefore0(AbstractChannelHandlerContext paramAbstractChannelHandlerContext1, AbstractChannelHandlerContext paramAbstractChannelHandlerContext2)
  {
    paramAbstractChannelHandlerContext2.prev = paramAbstractChannelHandlerContext1.prev;
    paramAbstractChannelHandlerContext2.next = paramAbstractChannelHandlerContext1;
    paramAbstractChannelHandlerContext1.prev.next = paramAbstractChannelHandlerContext2;
    paramAbstractChannelHandlerContext1.prev = paramAbstractChannelHandlerContext2;
  }
  
  private void addFirst0(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
  {
    AbstractChannelHandlerContext localAbstractChannelHandlerContext = this.head.next;
    paramAbstractChannelHandlerContext.prev = this.head;
    paramAbstractChannelHandlerContext.next = localAbstractChannelHandlerContext;
    this.head.next = paramAbstractChannelHandlerContext;
    localAbstractChannelHandlerContext.prev = paramAbstractChannelHandlerContext;
  }
  
  private void addLast0(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
  {
    AbstractChannelHandlerContext localAbstractChannelHandlerContext = this.tail.prev;
    paramAbstractChannelHandlerContext.prev = localAbstractChannelHandlerContext;
    paramAbstractChannelHandlerContext.next = this.tail;
    localAbstractChannelHandlerContext.next = paramAbstractChannelHandlerContext;
    this.tail.prev = paramAbstractChannelHandlerContext;
  }
  
  private void atomicRemoveFromHandlerList(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
  {
    try
    {
      AbstractChannelHandlerContext localAbstractChannelHandlerContext = paramAbstractChannelHandlerContext.prev;
      paramAbstractChannelHandlerContext = paramAbstractChannelHandlerContext.next;
      localAbstractChannelHandlerContext.next = paramAbstractChannelHandlerContext;
      paramAbstractChannelHandlerContext.prev = localAbstractChannelHandlerContext;
      return;
    }
    finally
    {
      paramAbstractChannelHandlerContext = finally;
      throw paramAbstractChannelHandlerContext;
    }
  }
  
  /* Error */
  private void callHandlerAdded0(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 198	io/netty/channel/AbstractChannelHandlerContext:callHandlerAdded	()V
    //   4: goto +199 -> 203
    //   7: astore_2
    //   8: iconst_0
    //   9: istore_3
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 190	io/netty/channel/DefaultChannelPipeline:atomicRemoveFromHandlerList	(Lio/netty/channel/AbstractChannelHandlerContext;)V
    //   15: aload_1
    //   16: invokevirtual 201	io/netty/channel/AbstractChannelHandlerContext:callHandlerRemoved	()V
    //   19: iconst_1
    //   20: istore 4
    //   22: goto +67 -> 89
    //   25: astore 5
    //   27: getstatic 76	io/netty/channel/DefaultChannelPipeline:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   30: astore 6
    //   32: iload_3
    //   33: istore 4
    //   35: aload 6
    //   37: invokeinterface 206 1 0
    //   42: ifeq +47 -> 89
    //   45: new 208	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   52: astore 7
    //   54: aload 7
    //   56: ldc -45
    //   58: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 7
    //   64: aload_1
    //   65: invokevirtual 218	io/netty/channel/AbstractChannelHandlerContext:name	()Ljava/lang/String;
    //   68: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 6
    //   74: aload 7
    //   76: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aload 5
    //   81: invokeinterface 225 3 0
    //   86: iload_3
    //   87: istore 4
    //   89: iload 4
    //   91: ifeq +59 -> 150
    //   94: new 208	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   101: astore 6
    //   103: aload 6
    //   105: aload_1
    //   106: invokeinterface 231 1 0
    //   111: invokevirtual 235	java/lang/Object:getClass	()Ljava/lang/Class;
    //   114: invokevirtual 240	java/lang/Class:getName	()Ljava/lang/String;
    //   117: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 6
    //   123: ldc -14
    //   125: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_0
    //   130: new 244	io/netty/channel/ChannelPipelineException
    //   133: dup
    //   134: aload 6
    //   136: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: aload_2
    //   140: invokespecial 246	io/netty/channel/ChannelPipelineException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: invokevirtual 250	io/netty/channel/DefaultChannelPipeline:fireExceptionCaught	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPipeline;
    //   146: pop
    //   147: goto +56 -> 203
    //   150: new 208	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   157: astore 6
    //   159: aload 6
    //   161: aload_1
    //   162: invokeinterface 231 1 0
    //   167: invokevirtual 235	java/lang/Object:getClass	()Ljava/lang/Class;
    //   170: invokevirtual 240	java/lang/Class:getName	()Ljava/lang/String;
    //   173: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 6
    //   179: ldc -4
    //   181: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_0
    //   186: new 244	io/netty/channel/ChannelPipelineException
    //   189: dup
    //   190: aload 6
    //   192: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aload_2
    //   196: invokespecial 246	io/netty/channel/ChannelPipelineException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   199: invokevirtual 250	io/netty/channel/DefaultChannelPipeline:fireExceptionCaught	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPipeline;
    //   202: pop
    //   203: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	DefaultChannelPipeline
    //   0	204	1	paramAbstractChannelHandlerContext	AbstractChannelHandlerContext
    //   7	189	2	localThrowable1	Throwable
    //   9	78	3	i	int
    //   20	70	4	j	int
    //   25	55	5	localThrowable2	Throwable
    //   30	161	6	localObject	Object
    //   52	23	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	4	7	finally
    //   10	19	25	finally
  }
  
  private void callHandlerAddedForAllHandlers()
  {
    try
    {
      this.registered = true;
      localPendingHandlerCallback = this.pendingHandlerCallbackHead;
      this.pendingHandlerCallbackHead = null;
      if (localPendingHandlerCallback != null)
      {
        localPendingHandlerCallback.execute();
        localPendingHandlerCallback = localPendingHandlerCallback.next;
      }
      return;
    }
    finally
    {
      PendingHandlerCallback localPendingHandlerCallback;
      for (;;) {}
    }
    throw localPendingHandlerCallback;
  }
  
  private void callHandlerAddedInEventLoop(final AbstractChannelHandlerContext paramAbstractChannelHandlerContext, EventExecutor paramEventExecutor)
  {
    paramAbstractChannelHandlerContext.setAddPending();
    paramEventExecutor.execute(new Runnable()
    {
      public void run()
      {
        DefaultChannelPipeline.this.callHandlerAdded0(paramAbstractChannelHandlerContext);
      }
    });
  }
  
  private void callHandlerCallbackLater(AbstractChannelHandlerContext paramAbstractChannelHandlerContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramAbstractChannelHandlerContext = new PendingHandlerAddedTask(paramAbstractChannelHandlerContext);
    } else {
      paramAbstractChannelHandlerContext = new PendingHandlerRemovedTask(paramAbstractChannelHandlerContext);
    }
    PendingHandlerCallback localPendingHandlerCallback1 = this.pendingHandlerCallbackHead;
    PendingHandlerCallback localPendingHandlerCallback2 = localPendingHandlerCallback1;
    if (localPendingHandlerCallback1 == null)
    {
      this.pendingHandlerCallbackHead = paramAbstractChannelHandlerContext;
    }
    else
    {
      for (;;)
      {
        localPendingHandlerCallback1 = localPendingHandlerCallback2.next;
        if (localPendingHandlerCallback1 == null) {
          break;
        }
        localPendingHandlerCallback2 = localPendingHandlerCallback1;
      }
      localPendingHandlerCallback2.next = paramAbstractChannelHandlerContext;
    }
  }
  
  /* Error */
  private void callHandlerRemoved0(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 201	io/netty/channel/AbstractChannelHandlerContext:callHandlerRemoved	()V
    //   4: goto +54 -> 58
    //   7: astore_2
    //   8: new 208	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   15: astore_3
    //   16: aload_3
    //   17: aload_1
    //   18: invokeinterface 231 1 0
    //   23: invokevirtual 235	java/lang/Object:getClass	()Ljava/lang/Class;
    //   26: invokevirtual 240	java/lang/Class:getName	()Ljava/lang/String;
    //   29: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_3
    //   34: ldc_w 279
    //   37: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_0
    //   42: new 244	io/netty/channel/ChannelPipelineException
    //   45: dup
    //   46: aload_3
    //   47: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: aload_2
    //   51: invokespecial 246	io/netty/channel/ChannelPipelineException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   54: invokevirtual 250	io/netty/channel/DefaultChannelPipeline:fireExceptionCaught	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPipeline;
    //   57: pop
    //   58: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	DefaultChannelPipeline
    //   0	59	1	paramAbstractChannelHandlerContext	AbstractChannelHandlerContext
    //   7	44	2	localThrowable	Throwable
    //   15	32	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	4	7	finally
  }
  
  private void checkDuplicateName(String paramString)
  {
    if (context0(paramString) == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Duplicate handler name: ");
    localStringBuilder.append(paramString);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static void checkMultiplicity(ChannelHandler paramChannelHandler)
  {
    if ((paramChannelHandler instanceof ChannelHandlerAdapter))
    {
      paramChannelHandler = (ChannelHandlerAdapter)paramChannelHandler;
      if ((!paramChannelHandler.isSharable()) && (paramChannelHandler.added))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramChannelHandler.getClass().getName());
        localStringBuilder.append(" is not a @Sharable handler, so can't be added or removed multiple times.");
        throw new ChannelPipelineException(localStringBuilder.toString());
      }
      paramChannelHandler.added = true;
    }
  }
  
  private EventExecutor childExecutor(EventExecutorGroup paramEventExecutorGroup)
  {
    if (paramEventExecutorGroup == null) {
      return null;
    }
    Object localObject1 = (Boolean)this.channel.config().getOption(ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP);
    if ((localObject1 != null) && (!((Boolean)localObject1).booleanValue())) {
      return paramEventExecutorGroup.next();
    }
    Object localObject2 = this.childExecutors;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new IdentityHashMap(4);
      this.childExecutors = ((Map)localObject1);
    }
    EventExecutor localEventExecutor = (EventExecutor)((Map)localObject1).get(paramEventExecutorGroup);
    localObject2 = localEventExecutor;
    if (localEventExecutor == null)
    {
      localObject2 = paramEventExecutorGroup.next();
      ((Map)localObject1).put(paramEventExecutorGroup, localObject2);
    }
    return (EventExecutor)localObject2;
  }
  
  private AbstractChannelHandlerContext context0(String paramString)
  {
    for (AbstractChannelHandlerContext localAbstractChannelHandlerContext = this.head.next; localAbstractChannelHandlerContext != this.tail; localAbstractChannelHandlerContext = localAbstractChannelHandlerContext.next) {
      if (localAbstractChannelHandlerContext.name().equals(paramString)) {
        return localAbstractChannelHandlerContext;
      }
    }
    return null;
  }
  
  private void destroy()
  {
    try
    {
      destroyUp(this.head.next, false);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void destroyDown(Thread paramThread, final AbstractChannelHandlerContext paramAbstractChannelHandlerContext, boolean paramBoolean)
  {
    AbstractChannelHandlerContext localAbstractChannelHandlerContext = this.head;
    for (;;)
    {
      if (paramAbstractChannelHandlerContext != localAbstractChannelHandlerContext)
      {
        EventExecutor localEventExecutor = paramAbstractChannelHandlerContext.executor();
        if ((!paramBoolean) && (!localEventExecutor.inEventLoop(paramThread))) {
          localEventExecutor.execute(new Runnable()
          {
            public void run()
            {
              DefaultChannelPipeline.this.destroyDown(Thread.currentThread(), paramAbstractChannelHandlerContext, true);
            }
          });
        }
      }
      else
      {
        return;
      }
      atomicRemoveFromHandlerList(paramAbstractChannelHandlerContext);
      callHandlerRemoved0(paramAbstractChannelHandlerContext);
      paramAbstractChannelHandlerContext = paramAbstractChannelHandlerContext.prev;
      paramBoolean = false;
    }
  }
  
  private void destroyUp(final AbstractChannelHandlerContext paramAbstractChannelHandlerContext, boolean paramBoolean)
  {
    Thread localThread = Thread.currentThread();
    AbstractChannelHandlerContext localAbstractChannelHandlerContext = this.tail;
    for (;;)
    {
      if (paramAbstractChannelHandlerContext == localAbstractChannelHandlerContext)
      {
        destroyDown(localThread, localAbstractChannelHandlerContext.prev, paramBoolean);
      }
      else
      {
        EventExecutor localEventExecutor = paramAbstractChannelHandlerContext.executor();
        if ((paramBoolean) || (localEventExecutor.inEventLoop(localThread))) {
          break label68;
        }
        localEventExecutor.execute(new Runnable()
        {
          public void run()
          {
            DefaultChannelPipeline.this.destroyUp(paramAbstractChannelHandlerContext, true);
          }
        });
      }
      return;
      label68:
      paramAbstractChannelHandlerContext = paramAbstractChannelHandlerContext.next;
      paramBoolean = false;
    }
  }
  
  private String filterName(String paramString, ChannelHandler paramChannelHandler)
  {
    if (paramString == null) {
      return generateName(paramChannelHandler);
    }
    checkDuplicateName(paramString);
    return paramString;
  }
  
  private String generateName(ChannelHandler paramChannelHandler)
  {
    Map localMap = (Map)nameCaches.get();
    Class localClass = paramChannelHandler.getClass();
    Object localObject = (String)localMap.get(localClass);
    paramChannelHandler = (ChannelHandler)localObject;
    if (localObject == null)
    {
      paramChannelHandler = generateName0(localClass);
      localMap.put(localClass, paramChannelHandler);
    }
    localObject = paramChannelHandler;
    if (context0(paramChannelHandler) != null)
    {
      int i = paramChannelHandler.length();
      int j = 1;
      paramChannelHandler = paramChannelHandler.substring(0, i - 1);
      for (;;)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramChannelHandler);
        ((StringBuilder)localObject).append(j);
        localObject = ((StringBuilder)localObject).toString();
        if (context0((String)localObject) == null) {
          break;
        }
        j++;
      }
    }
    return (String)localObject;
  }
  
  private static String generateName0(Class<?> paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(paramClass));
    localStringBuilder.append("#0");
    return localStringBuilder.toString();
  }
  
  private AbstractChannelHandlerContext getContextOrDie(ChannelHandler paramChannelHandler)
  {
    AbstractChannelHandlerContext localAbstractChannelHandlerContext = (AbstractChannelHandlerContext)context(paramChannelHandler);
    if (localAbstractChannelHandlerContext != null) {
      return localAbstractChannelHandlerContext;
    }
    throw new NoSuchElementException(paramChannelHandler.getClass().getName());
  }
  
  private AbstractChannelHandlerContext getContextOrDie(Class<? extends ChannelHandler> paramClass)
  {
    AbstractChannelHandlerContext localAbstractChannelHandlerContext = (AbstractChannelHandlerContext)context(paramClass);
    if (localAbstractChannelHandlerContext != null) {
      return localAbstractChannelHandlerContext;
    }
    throw new NoSuchElementException(paramClass.getName());
  }
  
  private AbstractChannelHandlerContext getContextOrDie(String paramString)
  {
    AbstractChannelHandlerContext localAbstractChannelHandlerContext = (AbstractChannelHandlerContext)context(paramString);
    if (localAbstractChannelHandlerContext != null) {
      return localAbstractChannelHandlerContext;
    }
    throw new NoSuchElementException(paramString);
  }
  
  private AbstractChannelHandlerContext newContext(EventExecutorGroup paramEventExecutorGroup, String paramString, ChannelHandler paramChannelHandler)
  {
    return new DefaultChannelHandlerContext(this, childExecutor(paramEventExecutorGroup), paramString, paramChannelHandler);
  }
  
  private AbstractChannelHandlerContext remove(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
  {
    try
    {
      atomicRemoveFromHandlerList(paramAbstractChannelHandlerContext);
      if (!this.registered)
      {
        callHandlerCallbackLater(paramAbstractChannelHandlerContext, false);
        return paramAbstractChannelHandlerContext;
      }
      EventExecutor localEventExecutor = paramAbstractChannelHandlerContext.executor();
      if (!localEventExecutor.inEventLoop())
      {
        Runnable local2 = new io/netty/channel/DefaultChannelPipeline$2;
        local2.<init>(this, paramAbstractChannelHandlerContext);
        localEventExecutor.execute(local2);
        return paramAbstractChannelHandlerContext;
      }
      callHandlerRemoved0(paramAbstractChannelHandlerContext);
      return paramAbstractChannelHandlerContext;
    }
    finally {}
  }
  
  private <T extends ChannelHandler> T removeIfExists(ChannelHandlerContext paramChannelHandlerContext)
  {
    if (paramChannelHandlerContext == null) {
      return null;
    }
    return remove((AbstractChannelHandlerContext)paramChannelHandlerContext).handler();
  }
  
  private ChannelHandler replace(AbstractChannelHandlerContext paramAbstractChannelHandlerContext, String paramString, ChannelHandler paramChannelHandler)
  {
    try
    {
      checkMultiplicity(paramChannelHandler);
      Object localObject;
      if (paramString == null)
      {
        localObject = generateName(paramChannelHandler);
      }
      else
      {
        localObject = paramString;
        if (!paramAbstractChannelHandlerContext.name().equals(paramString))
        {
          checkDuplicateName(paramString);
          localObject = paramString;
        }
      }
      paramChannelHandler = newContext(paramAbstractChannelHandlerContext.executor, (String)localObject, paramChannelHandler);
      replace0(paramAbstractChannelHandlerContext, paramChannelHandler);
      if (!this.registered)
      {
        callHandlerCallbackLater(paramChannelHandler, true);
        callHandlerCallbackLater(paramAbstractChannelHandlerContext, false);
        paramAbstractChannelHandlerContext = paramAbstractChannelHandlerContext.handler();
        return paramAbstractChannelHandlerContext;
      }
      paramString = paramAbstractChannelHandlerContext.executor();
      if (!paramString.inEventLoop())
      {
        localObject = new io/netty/channel/DefaultChannelPipeline$3;
        ((3)localObject).<init>(this, paramChannelHandler, paramAbstractChannelHandlerContext);
        paramString.execute((Runnable)localObject);
        paramAbstractChannelHandlerContext = paramAbstractChannelHandlerContext.handler();
        return paramAbstractChannelHandlerContext;
      }
      callHandlerAdded0(paramChannelHandler);
      callHandlerRemoved0(paramAbstractChannelHandlerContext);
      return paramAbstractChannelHandlerContext.handler();
    }
    finally {}
  }
  
  private static void replace0(AbstractChannelHandlerContext paramAbstractChannelHandlerContext1, AbstractChannelHandlerContext paramAbstractChannelHandlerContext2)
  {
    AbstractChannelHandlerContext localAbstractChannelHandlerContext1 = paramAbstractChannelHandlerContext1.prev;
    AbstractChannelHandlerContext localAbstractChannelHandlerContext2 = paramAbstractChannelHandlerContext1.next;
    paramAbstractChannelHandlerContext2.prev = localAbstractChannelHandlerContext1;
    paramAbstractChannelHandlerContext2.next = localAbstractChannelHandlerContext2;
    localAbstractChannelHandlerContext1.next = paramAbstractChannelHandlerContext2;
    localAbstractChannelHandlerContext2.prev = paramAbstractChannelHandlerContext2;
    paramAbstractChannelHandlerContext1.prev = paramAbstractChannelHandlerContext2;
    paramAbstractChannelHandlerContext1.next = paramAbstractChannelHandlerContext2;
  }
  
  public final ChannelPipeline addAfter(EventExecutorGroup paramEventExecutorGroup, String paramString1, String paramString2, ChannelHandler paramChannelHandler)
  {
    try
    {
      checkMultiplicity(paramChannelHandler);
      paramString2 = filterName(paramString2, paramChannelHandler);
      paramString1 = getContextOrDie(paramString1);
      paramEventExecutorGroup = newContext(paramEventExecutorGroup, paramString2, paramChannelHandler);
      addAfter0(paramString1, paramEventExecutorGroup);
      if (!this.registered)
      {
        paramEventExecutorGroup.setAddPending();
        callHandlerCallbackLater(paramEventExecutorGroup, true);
        return this;
      }
      paramString1 = paramEventExecutorGroup.executor();
      if (!paramString1.inEventLoop())
      {
        callHandlerAddedInEventLoop(paramEventExecutorGroup, paramString1);
        return this;
      }
      callHandlerAdded0(paramEventExecutorGroup);
      return this;
    }
    finally {}
  }
  
  public final ChannelPipeline addAfter(String paramString1, String paramString2, ChannelHandler paramChannelHandler)
  {
    return addAfter(null, paramString1, paramString2, paramChannelHandler);
  }
  
  public final ChannelPipeline addBefore(EventExecutorGroup paramEventExecutorGroup, String paramString1, String paramString2, ChannelHandler paramChannelHandler)
  {
    try
    {
      checkMultiplicity(paramChannelHandler);
      paramString2 = filterName(paramString2, paramChannelHandler);
      paramString1 = getContextOrDie(paramString1);
      paramEventExecutorGroup = newContext(paramEventExecutorGroup, paramString2, paramChannelHandler);
      addBefore0(paramString1, paramEventExecutorGroup);
      if (!this.registered)
      {
        paramEventExecutorGroup.setAddPending();
        callHandlerCallbackLater(paramEventExecutorGroup, true);
        return this;
      }
      paramString1 = paramEventExecutorGroup.executor();
      if (!paramString1.inEventLoop())
      {
        callHandlerAddedInEventLoop(paramEventExecutorGroup, paramString1);
        return this;
      }
      callHandlerAdded0(paramEventExecutorGroup);
      return this;
    }
    finally {}
  }
  
  public final ChannelPipeline addBefore(String paramString1, String paramString2, ChannelHandler paramChannelHandler)
  {
    return addBefore(null, paramString1, paramString2, paramChannelHandler);
  }
  
  public final ChannelPipeline addFirst(ChannelHandler paramChannelHandler)
  {
    return addFirst(null, paramChannelHandler);
  }
  
  public final ChannelPipeline addFirst(EventExecutorGroup paramEventExecutorGroup, String paramString, ChannelHandler paramChannelHandler)
  {
    try
    {
      checkMultiplicity(paramChannelHandler);
      paramString = newContext(paramEventExecutorGroup, filterName(paramString, paramChannelHandler), paramChannelHandler);
      addFirst0(paramString);
      if (!this.registered)
      {
        paramString.setAddPending();
        callHandlerCallbackLater(paramString, true);
        return this;
      }
      paramEventExecutorGroup = paramString.executor();
      if (!paramEventExecutorGroup.inEventLoop())
      {
        callHandlerAddedInEventLoop(paramString, paramEventExecutorGroup);
        return this;
      }
      callHandlerAdded0(paramString);
      return this;
    }
    finally {}
  }
  
  public final ChannelPipeline addFirst(EventExecutorGroup paramEventExecutorGroup, ChannelHandler... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "handlers");
    if ((paramVarArgs.length != 0) && (paramVarArgs[0] != null))
    {
      for (int i = 1; (i < paramVarArgs.length) && (paramVarArgs[i] != null); i++) {}
      i--;
      while (i >= 0)
      {
        addFirst(paramEventExecutorGroup, null, paramVarArgs[i]);
        i--;
      }
    }
    return this;
  }
  
  public final ChannelPipeline addFirst(String paramString, ChannelHandler paramChannelHandler)
  {
    return addFirst(null, paramString, paramChannelHandler);
  }
  
  public final ChannelPipeline addFirst(ChannelHandler... paramVarArgs)
  {
    return addFirst(null, paramVarArgs);
  }
  
  public final ChannelPipeline addLast(ChannelHandler paramChannelHandler)
  {
    return addLast(null, paramChannelHandler);
  }
  
  public final ChannelPipeline addLast(EventExecutorGroup paramEventExecutorGroup, String paramString, ChannelHandler paramChannelHandler)
  {
    try
    {
      checkMultiplicity(paramChannelHandler);
      paramString = newContext(paramEventExecutorGroup, filterName(paramString, paramChannelHandler), paramChannelHandler);
      addLast0(paramString);
      if (!this.registered)
      {
        paramString.setAddPending();
        callHandlerCallbackLater(paramString, true);
        return this;
      }
      paramEventExecutorGroup = paramString.executor();
      if (!paramEventExecutorGroup.inEventLoop())
      {
        callHandlerAddedInEventLoop(paramString, paramEventExecutorGroup);
        return this;
      }
      callHandlerAdded0(paramString);
      return this;
    }
    finally {}
  }
  
  public final ChannelPipeline addLast(EventExecutorGroup paramEventExecutorGroup, ChannelHandler... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "handlers");
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      ChannelHandler localChannelHandler = paramVarArgs[j];
      if (localChannelHandler == null) {
        break;
      }
      addLast(paramEventExecutorGroup, null, localChannelHandler);
    }
    return this;
  }
  
  public final ChannelPipeline addLast(String paramString, ChannelHandler paramChannelHandler)
  {
    return addLast(null, paramString, paramChannelHandler);
  }
  
  public final ChannelPipeline addLast(ChannelHandler... paramVarArgs)
  {
    return addLast(null, paramVarArgs);
  }
  
  public final ChannelFuture bind(SocketAddress paramSocketAddress)
  {
    return this.tail.bind(paramSocketAddress);
  }
  
  public final ChannelFuture bind(SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
  {
    return this.tail.bind(paramSocketAddress, paramChannelPromise);
  }
  
  public final Channel channel()
  {
    return this.channel;
  }
  
  public final ChannelFuture close()
  {
    return this.tail.close();
  }
  
  public final ChannelFuture close(ChannelPromise paramChannelPromise)
  {
    return this.tail.close(paramChannelPromise);
  }
  
  public final ChannelFuture connect(SocketAddress paramSocketAddress)
  {
    return this.tail.connect(paramSocketAddress);
  }
  
  public final ChannelFuture connect(SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
  {
    return this.tail.connect(paramSocketAddress, paramChannelPromise);
  }
  
  public final ChannelFuture connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
  {
    return this.tail.connect(paramSocketAddress1, paramSocketAddress2);
  }
  
  public final ChannelFuture connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
  {
    return this.tail.connect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
  }
  
  public final ChannelHandlerContext context(ChannelHandler paramChannelHandler)
  {
    ObjectUtil.checkNotNull(paramChannelHandler, "handler");
    for (AbstractChannelHandlerContext localAbstractChannelHandlerContext = this.head.next;; localAbstractChannelHandlerContext = localAbstractChannelHandlerContext.next)
    {
      if (localAbstractChannelHandlerContext == null) {
        return null;
      }
      if (localAbstractChannelHandlerContext.handler() == paramChannelHandler) {
        return localAbstractChannelHandlerContext;
      }
    }
  }
  
  public final ChannelHandlerContext context(Class<? extends ChannelHandler> paramClass)
  {
    ObjectUtil.checkNotNull(paramClass, "handlerType");
    for (AbstractChannelHandlerContext localAbstractChannelHandlerContext = this.head.next;; localAbstractChannelHandlerContext = localAbstractChannelHandlerContext.next)
    {
      if (localAbstractChannelHandlerContext == null) {
        return null;
      }
      if (paramClass.isAssignableFrom(localAbstractChannelHandlerContext.handler().getClass())) {
        return localAbstractChannelHandlerContext;
      }
    }
  }
  
  public final ChannelHandlerContext context(String paramString)
  {
    return context0((String)ObjectUtil.checkNotNull(paramString, "name"));
  }
  
  protected void decrementPendingOutboundBytes(long paramLong)
  {
    ChannelOutboundBuffer localChannelOutboundBuffer = this.channel.unsafe().outboundBuffer();
    if (localChannelOutboundBuffer != null) {
      localChannelOutboundBuffer.decrementPendingOutboundBytes(paramLong);
    }
  }
  
  public final ChannelFuture deregister()
  {
    return this.tail.deregister();
  }
  
  public final ChannelFuture deregister(ChannelPromise paramChannelPromise)
  {
    return this.tail.deregister(paramChannelPromise);
  }
  
  public final ChannelFuture disconnect()
  {
    return this.tail.disconnect();
  }
  
  public final ChannelFuture disconnect(ChannelPromise paramChannelPromise)
  {
    return this.tail.disconnect(paramChannelPromise);
  }
  
  final MessageSizeEstimator.Handle estimatorHandle()
  {
    MessageSizeEstimator.Handle localHandle1 = this.estimatorHandle;
    MessageSizeEstimator.Handle localHandle2 = localHandle1;
    if (localHandle1 == null)
    {
      localHandle1 = this.channel.config().getMessageSizeEstimator().newHandle();
      localHandle2 = localHandle1;
      if (!ESTIMATOR.compareAndSet(this, null, localHandle1)) {
        localHandle2 = this.estimatorHandle;
      }
    }
    return localHandle2;
  }
  
  public final ChannelPipeline fireChannelActive()
  {
    AbstractChannelHandlerContext.invokeChannelActive(this.head);
    return this;
  }
  
  public final ChannelPipeline fireChannelInactive()
  {
    AbstractChannelHandlerContext.invokeChannelInactive(this.head);
    return this;
  }
  
  public final ChannelPipeline fireChannelRead(Object paramObject)
  {
    AbstractChannelHandlerContext.invokeChannelRead(this.head, paramObject);
    return this;
  }
  
  public final ChannelPipeline fireChannelReadComplete()
  {
    AbstractChannelHandlerContext.invokeChannelReadComplete(this.head);
    return this;
  }
  
  public final ChannelPipeline fireChannelRegistered()
  {
    AbstractChannelHandlerContext.invokeChannelRegistered(this.head);
    return this;
  }
  
  public final ChannelPipeline fireChannelUnregistered()
  {
    AbstractChannelHandlerContext.invokeChannelUnregistered(this.head);
    return this;
  }
  
  public final ChannelPipeline fireChannelWritabilityChanged()
  {
    AbstractChannelHandlerContext.invokeChannelWritabilityChanged(this.head);
    return this;
  }
  
  public final ChannelPipeline fireExceptionCaught(Throwable paramThrowable)
  {
    AbstractChannelHandlerContext.invokeExceptionCaught(this.head, paramThrowable);
    return this;
  }
  
  public final ChannelPipeline fireUserEventTriggered(Object paramObject)
  {
    AbstractChannelHandlerContext.invokeUserEventTriggered(this.head, paramObject);
    return this;
  }
  
  public final ChannelHandler first()
  {
    ChannelHandlerContext localChannelHandlerContext = firstContext();
    if (localChannelHandlerContext == null) {
      return null;
    }
    return localChannelHandlerContext.handler();
  }
  
  public final ChannelHandlerContext firstContext()
  {
    if (this.head.next == this.tail) {
      return null;
    }
    return this.head.next;
  }
  
  public final ChannelPipeline flush()
  {
    this.tail.flush();
    return this;
  }
  
  public final <T extends ChannelHandler> T get(Class<T> paramClass)
  {
    paramClass = context(paramClass);
    if (paramClass == null) {
      return null;
    }
    return paramClass.handler();
  }
  
  public final ChannelHandler get(String paramString)
  {
    paramString = context(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.handler();
  }
  
  protected void incrementPendingOutboundBytes(long paramLong)
  {
    ChannelOutboundBuffer localChannelOutboundBuffer = this.channel.unsafe().outboundBuffer();
    if (localChannelOutboundBuffer != null) {
      localChannelOutboundBuffer.incrementPendingOutboundBytes(paramLong);
    }
  }
  
  final void invokeHandlerAddedIfNeeded()
  {
    if (this.firstRegistration)
    {
      this.firstRegistration = false;
      callHandlerAddedForAllHandlers();
    }
  }
  
  public final Iterator<Map.Entry<String, ChannelHandler>> iterator()
  {
    return toMap().entrySet().iterator();
  }
  
  public final ChannelHandler last()
  {
    AbstractChannelHandlerContext localAbstractChannelHandlerContext = this.tail.prev;
    if (localAbstractChannelHandlerContext == this.head) {
      return null;
    }
    return localAbstractChannelHandlerContext.handler();
  }
  
  public final ChannelHandlerContext lastContext()
  {
    AbstractChannelHandlerContext localAbstractChannelHandlerContext1 = this.tail.prev;
    AbstractChannelHandlerContext localAbstractChannelHandlerContext2 = localAbstractChannelHandlerContext1;
    if (localAbstractChannelHandlerContext1 == this.head) {
      localAbstractChannelHandlerContext2 = null;
    }
    return localAbstractChannelHandlerContext2;
  }
  
  public final List<String> names()
  {
    ArrayList localArrayList = new ArrayList();
    for (AbstractChannelHandlerContext localAbstractChannelHandlerContext = this.head.next;; localAbstractChannelHandlerContext = localAbstractChannelHandlerContext.next)
    {
      if (localAbstractChannelHandlerContext == null) {
        return localArrayList;
      }
      localArrayList.add(localAbstractChannelHandlerContext.name());
    }
  }
  
  public final ChannelFuture newFailedFuture(Throwable paramThrowable)
  {
    return new FailedChannelFuture(this.channel, null, paramThrowable);
  }
  
  public final ChannelProgressivePromise newProgressivePromise()
  {
    return new DefaultChannelProgressivePromise(this.channel);
  }
  
  public final ChannelPromise newPromise()
  {
    return new DefaultChannelPromise(this.channel);
  }
  
  public final ChannelFuture newSucceededFuture()
  {
    return this.succeededFuture;
  }
  
  protected void onUnhandledChannelWritabilityChanged() {}
  
  protected void onUnhandledInboundChannelActive() {}
  
  protected void onUnhandledInboundChannelInactive() {}
  
  protected void onUnhandledInboundChannelReadComplete() {}
  
  protected void onUnhandledInboundException(Throwable paramThrowable)
  {
    try
    {
      logger.warn("An exceptionCaught() event was fired, and it reached at the tail of the pipeline. It usually means the last handler in the pipeline did not handle the exception.", paramThrowable);
      return;
    }
    finally
    {
      ReferenceCountUtil.release(paramThrowable);
    }
  }
  
  protected void onUnhandledInboundMessage(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
  {
    onUnhandledInboundMessage(paramObject);
    paramObject = logger;
    if (((InternalLogger)paramObject).isDebugEnabled()) {
      ((InternalLogger)paramObject).debug("Discarded message pipeline : {}. Channel : {}.", paramChannelHandlerContext.pipeline().names(), paramChannelHandlerContext.channel());
    }
  }
  
  protected void onUnhandledInboundMessage(Object paramObject)
  {
    try
    {
      logger.debug("Discarded inbound message {} that reached at the tail of the pipeline. Please check your pipeline configuration.", paramObject);
      return;
    }
    finally
    {
      ReferenceCountUtil.release(paramObject);
    }
  }
  
  protected void onUnhandledInboundUserEventTriggered(Object paramObject)
  {
    ReferenceCountUtil.release(paramObject);
  }
  
  public final ChannelPipeline read()
  {
    this.tail.read();
    return this;
  }
  
  public final <T extends ChannelHandler> T remove(Class<T> paramClass)
  {
    return remove(getContextOrDie(paramClass)).handler();
  }
  
  public final ChannelHandler remove(String paramString)
  {
    return remove(getContextOrDie(paramString)).handler();
  }
  
  public final ChannelPipeline remove(ChannelHandler paramChannelHandler)
  {
    remove(getContextOrDie(paramChannelHandler));
    return this;
  }
  
  public final ChannelHandler removeFirst()
  {
    if (this.head.next != this.tail) {
      return remove(this.head.next).handler();
    }
    throw new NoSuchElementException();
  }
  
  public final <T extends ChannelHandler> T removeIfExists(ChannelHandler paramChannelHandler)
  {
    return removeIfExists(context(paramChannelHandler));
  }
  
  public final <T extends ChannelHandler> T removeIfExists(Class<T> paramClass)
  {
    return removeIfExists(context(paramClass));
  }
  
  public final <T extends ChannelHandler> T removeIfExists(String paramString)
  {
    return removeIfExists(context(paramString));
  }
  
  public final ChannelHandler removeLast()
  {
    AbstractChannelHandlerContext localAbstractChannelHandlerContext1 = this.head.next;
    AbstractChannelHandlerContext localAbstractChannelHandlerContext2 = this.tail;
    if (localAbstractChannelHandlerContext1 != localAbstractChannelHandlerContext2) {
      return remove(localAbstractChannelHandlerContext2.prev).handler();
    }
    throw new NoSuchElementException();
  }
  
  public final <T extends ChannelHandler> T replace(Class<T> paramClass, String paramString, ChannelHandler paramChannelHandler)
  {
    return replace(getContextOrDie(paramClass), paramString, paramChannelHandler);
  }
  
  public final ChannelHandler replace(String paramString1, String paramString2, ChannelHandler paramChannelHandler)
  {
    return replace(getContextOrDie(paramString1), paramString2, paramChannelHandler);
  }
  
  public final ChannelPipeline replace(ChannelHandler paramChannelHandler1, String paramString, ChannelHandler paramChannelHandler2)
  {
    replace(getContextOrDie(paramChannelHandler1), paramString, paramChannelHandler2);
    return this;
  }
  
  public final Map<String, ChannelHandler> toMap()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    for (AbstractChannelHandlerContext localAbstractChannelHandlerContext = this.head.next;; localAbstractChannelHandlerContext = localAbstractChannelHandlerContext.next)
    {
      if (localAbstractChannelHandlerContext == this.tail) {
        return localLinkedHashMap;
      }
      localLinkedHashMap.put(localAbstractChannelHandlerContext.name(), localAbstractChannelHandlerContext.handler());
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append('{');
    AbstractChannelHandlerContext localAbstractChannelHandlerContext = this.head.next;
    for (;;)
    {
      if (localAbstractChannelHandlerContext != this.tail)
      {
        localStringBuilder.append('(');
        localStringBuilder.append(localAbstractChannelHandlerContext.name());
        localStringBuilder.append(" = ");
        localStringBuilder.append(localAbstractChannelHandlerContext.handler().getClass().getName());
        localStringBuilder.append(')');
        localAbstractChannelHandlerContext = localAbstractChannelHandlerContext.next;
        if (localAbstractChannelHandlerContext != this.tail) {}
      }
      else
      {
        localStringBuilder.append('}');
        return localStringBuilder.toString();
      }
      localStringBuilder.append(", ");
    }
  }
  
  final Object touch(Object paramObject, AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
  {
    Object localObject = paramObject;
    if (this.touch) {
      localObject = ReferenceCountUtil.touch(paramObject, paramAbstractChannelHandlerContext);
    }
    return localObject;
  }
  
  public final ChannelPromise voidPromise()
  {
    return this.voidPromise;
  }
  
  public final ChannelFuture write(Object paramObject)
  {
    return this.tail.write(paramObject);
  }
  
  public final ChannelFuture write(Object paramObject, ChannelPromise paramChannelPromise)
  {
    return this.tail.write(paramObject, paramChannelPromise);
  }
  
  public final ChannelFuture writeAndFlush(Object paramObject)
  {
    return this.tail.writeAndFlush(paramObject);
  }
  
  public final ChannelFuture writeAndFlush(Object paramObject, ChannelPromise paramChannelPromise)
  {
    return this.tail.writeAndFlush(paramObject, paramChannelPromise);
  }
  
  final class HeadContext
    extends AbstractChannelHandlerContext
    implements ChannelOutboundHandler, ChannelInboundHandler
  {
    private final Channel.Unsafe unsafe;
    
    HeadContext(DefaultChannelPipeline paramDefaultChannelPipeline)
    {
      super(null, DefaultChannelPipeline.HEAD_NAME, HeadContext.class);
      this.unsafe = paramDefaultChannelPipeline.channel().unsafe();
      setAddComplete();
    }
    
    private void readIfIsAutoRead()
    {
      if (DefaultChannelPipeline.this.channel.config().isAutoRead()) {
        DefaultChannelPipeline.this.channel.read();
      }
    }
    
    public void bind(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    {
      this.unsafe.bind(paramSocketAddress, paramChannelPromise);
    }
    
    public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
    {
      paramChannelHandlerContext.fireChannelActive();
      readIfIsAutoRead();
    }
    
    public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    {
      paramChannelHandlerContext.fireChannelInactive();
    }
    
    public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    {
      paramChannelHandlerContext.fireChannelRead(paramObject);
    }
    
    public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    {
      paramChannelHandlerContext.fireChannelReadComplete();
      readIfIsAutoRead();
    }
    
    public void channelRegistered(ChannelHandlerContext paramChannelHandlerContext)
    {
      DefaultChannelPipeline.this.invokeHandlerAddedIfNeeded();
      paramChannelHandlerContext.fireChannelRegistered();
    }
    
    public void channelUnregistered(ChannelHandlerContext paramChannelHandlerContext)
    {
      paramChannelHandlerContext.fireChannelUnregistered();
      if (!DefaultChannelPipeline.this.channel.isOpen()) {
        DefaultChannelPipeline.this.destroy();
      }
    }
    
    public void channelWritabilityChanged(ChannelHandlerContext paramChannelHandlerContext)
    {
      paramChannelHandlerContext.fireChannelWritabilityChanged();
    }
    
    public void close(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    {
      this.unsafe.close(paramChannelPromise);
    }
    
    public void connect(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    {
      this.unsafe.connect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
    }
    
    public void deregister(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    {
      this.unsafe.deregister(paramChannelPromise);
    }
    
    public void disconnect(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    {
      this.unsafe.disconnect(paramChannelPromise);
    }
    
    public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    {
      paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
    }
    
    public void flush(ChannelHandlerContext paramChannelHandlerContext)
    {
      this.unsafe.flush();
    }
    
    public ChannelHandler handler()
    {
      return this;
    }
    
    public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext) {}
    
    public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext) {}
    
    public void read(ChannelHandlerContext paramChannelHandlerContext)
    {
      this.unsafe.beginRead();
    }
    
    public void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    {
      paramChannelHandlerContext.fireUserEventTriggered(paramObject);
    }
    
    public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    {
      this.unsafe.write(paramObject, paramChannelPromise);
    }
  }
  
  private final class PendingHandlerAddedTask
    extends DefaultChannelPipeline.PendingHandlerCallback
  {
    PendingHandlerAddedTask(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
    {
      super();
    }
    
    void execute()
    {
      EventExecutor localEventExecutor = this.ctx.executor();
      if (localEventExecutor.inEventLoop()) {
        DefaultChannelPipeline.this.callHandlerAdded0(this.ctx);
      } else {
        try
        {
          localEventExecutor.execute(this);
        }
        catch (RejectedExecutionException localRejectedExecutionException)
        {
          if (DefaultChannelPipeline.logger.isWarnEnabled()) {
            DefaultChannelPipeline.logger.warn("Can't invoke handlerAdded() as the EventExecutor {} rejected it, removing handler {}.", new Object[] { localEventExecutor, this.ctx.name(), localRejectedExecutionException });
          }
          DefaultChannelPipeline.this.atomicRemoveFromHandlerList(this.ctx);
          this.ctx.setRemoved();
        }
      }
    }
    
    public void run()
    {
      DefaultChannelPipeline.this.callHandlerAdded0(this.ctx);
    }
  }
  
  private static abstract class PendingHandlerCallback
    implements Runnable
  {
    final AbstractChannelHandlerContext ctx;
    PendingHandlerCallback next;
    
    PendingHandlerCallback(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
    {
      this.ctx = paramAbstractChannelHandlerContext;
    }
    
    abstract void execute();
  }
  
  private final class PendingHandlerRemovedTask
    extends DefaultChannelPipeline.PendingHandlerCallback
  {
    PendingHandlerRemovedTask(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
    {
      super();
    }
    
    void execute()
    {
      EventExecutor localEventExecutor = this.ctx.executor();
      if (localEventExecutor.inEventLoop()) {
        DefaultChannelPipeline.this.callHandlerRemoved0(this.ctx);
      } else {
        try
        {
          localEventExecutor.execute(this);
        }
        catch (RejectedExecutionException localRejectedExecutionException)
        {
          if (DefaultChannelPipeline.logger.isWarnEnabled()) {
            DefaultChannelPipeline.logger.warn("Can't invoke handlerRemoved() as the EventExecutor {} rejected it, removing handler {}.", new Object[] { localEventExecutor, this.ctx.name(), localRejectedExecutionException });
          }
          this.ctx.setRemoved();
        }
      }
    }
    
    public void run()
    {
      DefaultChannelPipeline.this.callHandlerRemoved0(this.ctx);
    }
  }
  
  final class TailContext
    extends AbstractChannelHandlerContext
    implements ChannelInboundHandler
  {
    TailContext(DefaultChannelPipeline paramDefaultChannelPipeline)
    {
      super(null, DefaultChannelPipeline.TAIL_NAME, TailContext.class);
      setAddComplete();
    }
    
    public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
    {
      DefaultChannelPipeline.this.onUnhandledInboundChannelActive();
    }
    
    public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    {
      DefaultChannelPipeline.this.onUnhandledInboundChannelInactive();
    }
    
    public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    {
      DefaultChannelPipeline.this.onUnhandledInboundMessage(paramChannelHandlerContext, paramObject);
    }
    
    public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    {
      DefaultChannelPipeline.this.onUnhandledInboundChannelReadComplete();
    }
    
    public void channelRegistered(ChannelHandlerContext paramChannelHandlerContext) {}
    
    public void channelUnregistered(ChannelHandlerContext paramChannelHandlerContext) {}
    
    public void channelWritabilityChanged(ChannelHandlerContext paramChannelHandlerContext)
    {
      DefaultChannelPipeline.this.onUnhandledChannelWritabilityChanged();
    }
    
    public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    {
      DefaultChannelPipeline.this.onUnhandledInboundException(paramThrowable);
    }
    
    public ChannelHandler handler()
    {
      return this;
    }
    
    public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext) {}
    
    public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext) {}
    
    public void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    {
      DefaultChannelPipeline.this.onUnhandledInboundUserEventTriggered(paramObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultChannelPipeline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */