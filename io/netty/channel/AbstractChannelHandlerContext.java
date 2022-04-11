package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.AttributeMap;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ResourceLeakHint;
import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.b;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

abstract class AbstractChannelHandlerContext
  implements ChannelHandlerContext, ResourceLeakHint
{
  private static final int ADD_COMPLETE = 2;
  private static final int ADD_PENDING = 1;
  private static final AtomicIntegerFieldUpdater<AbstractChannelHandlerContext> HANDLER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractChannelHandlerContext.class, "handlerState");
  private static final int INIT = 0;
  private static final int REMOVE_COMPLETE = 3;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractChannelHandlerContext.class);
  private final int executionMask;
  final EventExecutor executor;
  private volatile int handlerState;
  private Tasks invokeTasks;
  private final String name;
  volatile AbstractChannelHandlerContext next;
  private final boolean ordered;
  private final DefaultChannelPipeline pipeline;
  volatile AbstractChannelHandlerContext prev;
  private ChannelFuture succeededFuture;
  
  AbstractChannelHandlerContext(DefaultChannelPipeline paramDefaultChannelPipeline, EventExecutor paramEventExecutor, String paramString, Class<? extends ChannelHandler> paramClass)
  {
    boolean bool = false;
    this.handlerState = 0;
    this.name = ((String)ObjectUtil.checkNotNull(paramString, "name"));
    this.pipeline = paramDefaultChannelPipeline;
    this.executor = paramEventExecutor;
    this.executionMask = ChannelHandlerMask.mask(paramClass);
    if ((paramEventExecutor == null) || ((paramEventExecutor instanceof b))) {
      bool = true;
    }
    this.ordered = bool;
  }
  
  private AbstractChannelHandlerContext findContextInbound(int paramInt)
  {
    EventExecutor localEventExecutor = executor();
    Object localObject = this;
    AbstractChannelHandlerContext localAbstractChannelHandlerContext;
    do
    {
      localAbstractChannelHandlerContext = ((AbstractChannelHandlerContext)localObject).next;
      localObject = localAbstractChannelHandlerContext;
    } while (skipContext(localAbstractChannelHandlerContext, localEventExecutor, paramInt, 510));
    return localAbstractChannelHandlerContext;
  }
  
  private AbstractChannelHandlerContext findContextOutbound(int paramInt)
  {
    EventExecutor localEventExecutor = executor();
    Object localObject = this;
    AbstractChannelHandlerContext localAbstractChannelHandlerContext;
    do
    {
      localAbstractChannelHandlerContext = ((AbstractChannelHandlerContext)localObject).prev;
      localObject = localAbstractChannelHandlerContext;
    } while (skipContext(localAbstractChannelHandlerContext, localEventExecutor, paramInt, 130560));
    return localAbstractChannelHandlerContext;
  }
  
  /* Error */
  private void invokeBind(SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +32 -> 36
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 237	io/netty/channel/ChannelOutboundHandler
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: invokeinterface 241 4 0
    //   24: goto +19 -> 43
    //   27: astore_1
    //   28: aload_1
    //   29: aload_2
    //   30: invokestatic 245	io/netty/channel/AbstractChannelHandlerContext:notifyOutboundHandlerException	(Ljava/lang/Throwable;Lio/netty/channel/ChannelPromise;)V
    //   33: goto +10 -> 43
    //   36: aload_0
    //   37: aload_1
    //   38: aload_2
    //   39: invokevirtual 248	io/netty/channel/AbstractChannelHandlerContext:bind	(Ljava/net/SocketAddress;Lio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelFuture;
    //   42: pop
    //   43: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	AbstractChannelHandlerContext
    //   0	44	1	paramSocketAddress	SocketAddress
    //   0	44	2	paramChannelPromise	ChannelPromise
    // Exception table:
    //   from	to	target	type
    //   7	24	27	finally
  }
  
  /* Error */
  private void invokeChannelActive()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +30 -> 34
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 250	io/netty/channel/ChannelInboundHandler
    //   16: aload_0
    //   17: invokeinterface 254 2 0
    //   22: goto +17 -> 39
    //   25: astore_1
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 196	io/netty/channel/AbstractChannelHandlerContext:invokeExceptionCaught	(Ljava/lang/Throwable;)V
    //   31: goto +8 -> 39
    //   34: aload_0
    //   35: invokevirtual 258	io/netty/channel/AbstractChannelHandlerContext:fireChannelActive	()Lio/netty/channel/ChannelHandlerContext;
    //   38: pop
    //   39: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	AbstractChannelHandlerContext
    //   25	3	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	22	25	finally
  }
  
  static void invokeChannelActive(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
  {
    EventExecutor localEventExecutor = paramAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop()) {
      paramAbstractChannelHandlerContext.invokeChannelActive();
    } else {
      localEventExecutor.execute(new Runnable()
      {
        public void run()
        {
          this.val$next.invokeChannelActive();
        }
      });
    }
  }
  
  /* Error */
  private void invokeChannelInactive()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +30 -> 34
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 250	io/netty/channel/ChannelInboundHandler
    //   16: aload_0
    //   17: invokeinterface 274 2 0
    //   22: goto +17 -> 39
    //   25: astore_1
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 196	io/netty/channel/AbstractChannelHandlerContext:invokeExceptionCaught	(Ljava/lang/Throwable;)V
    //   31: goto +8 -> 39
    //   34: aload_0
    //   35: invokevirtual 277	io/netty/channel/AbstractChannelHandlerContext:fireChannelInactive	()Lio/netty/channel/ChannelHandlerContext;
    //   38: pop
    //   39: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	AbstractChannelHandlerContext
    //   25	3	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	22	25	finally
  }
  
  static void invokeChannelInactive(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
  {
    EventExecutor localEventExecutor = paramAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop()) {
      paramAbstractChannelHandlerContext.invokeChannelInactive();
    } else {
      localEventExecutor.execute(new Runnable()
      {
        public void run()
        {
          this.val$next.invokeChannelInactive();
        }
      });
    }
  }
  
  static void invokeChannelRead(AbstractChannelHandlerContext paramAbstractChannelHandlerContext, Object paramObject)
  {
    final Object localObject = paramAbstractChannelHandlerContext.pipeline.touch(ObjectUtil.checkNotNull(paramObject, "msg"), paramAbstractChannelHandlerContext);
    paramObject = paramAbstractChannelHandlerContext.executor();
    if (((EventExecutor)paramObject).inEventLoop()) {
      paramAbstractChannelHandlerContext.invokeChannelRead(localObject);
    } else {
      ((ScheduledExecutorService)paramObject).execute(new Runnable()
      {
        public void run()
        {
          this.val$next.invokeChannelRead(localObject);
        }
      });
    }
  }
  
  /* Error */
  private void invokeChannelRead(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +31 -> 35
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 250	io/netty/channel/ChannelInboundHandler
    //   16: aload_0
    //   17: aload_1
    //   18: invokeinterface 292 3 0
    //   23: goto +18 -> 41
    //   26: astore_1
    //   27: aload_0
    //   28: aload_1
    //   29: invokespecial 196	io/netty/channel/AbstractChannelHandlerContext:invokeExceptionCaught	(Ljava/lang/Throwable;)V
    //   32: goto +9 -> 41
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 296	io/netty/channel/AbstractChannelHandlerContext:fireChannelRead	(Ljava/lang/Object;)Lio/netty/channel/ChannelHandlerContext;
    //   40: pop
    //   41: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	AbstractChannelHandlerContext
    //   0	42	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	23	26	finally
  }
  
  /* Error */
  private void invokeChannelReadComplete()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +30 -> 34
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 250	io/netty/channel/ChannelInboundHandler
    //   16: aload_0
    //   17: invokeinterface 299 2 0
    //   22: goto +17 -> 39
    //   25: astore_1
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 196	io/netty/channel/AbstractChannelHandlerContext:invokeExceptionCaught	(Ljava/lang/Throwable;)V
    //   31: goto +8 -> 39
    //   34: aload_0
    //   35: invokevirtual 302	io/netty/channel/AbstractChannelHandlerContext:fireChannelReadComplete	()Lio/netty/channel/ChannelHandlerContext;
    //   38: pop
    //   39: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	AbstractChannelHandlerContext
    //   25	3	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	22	25	finally
  }
  
  static void invokeChannelReadComplete(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
  {
    EventExecutor localEventExecutor = paramAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop())
    {
      paramAbstractChannelHandlerContext.invokeChannelReadComplete();
    }
    else
    {
      Tasks localTasks1 = paramAbstractChannelHandlerContext.invokeTasks;
      Tasks localTasks2 = localTasks1;
      if (localTasks1 == null)
      {
        localTasks2 = new Tasks(paramAbstractChannelHandlerContext);
        paramAbstractChannelHandlerContext.invokeTasks = localTasks2;
      }
      localEventExecutor.execute(localTasks2.invokeChannelReadCompleteTask);
    }
  }
  
  /* Error */
  private void invokeChannelRegistered()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +30 -> 34
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 250	io/netty/channel/ChannelInboundHandler
    //   16: aload_0
    //   17: invokeinterface 312 2 0
    //   22: goto +17 -> 39
    //   25: astore_1
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 196	io/netty/channel/AbstractChannelHandlerContext:invokeExceptionCaught	(Ljava/lang/Throwable;)V
    //   31: goto +8 -> 39
    //   34: aload_0
    //   35: invokevirtual 315	io/netty/channel/AbstractChannelHandlerContext:fireChannelRegistered	()Lio/netty/channel/ChannelHandlerContext;
    //   38: pop
    //   39: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	AbstractChannelHandlerContext
    //   25	3	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	22	25	finally
  }
  
  static void invokeChannelRegistered(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
  {
    EventExecutor localEventExecutor = paramAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop()) {
      paramAbstractChannelHandlerContext.invokeChannelRegistered();
    } else {
      localEventExecutor.execute(new Runnable()
      {
        public void run()
        {
          this.val$next.invokeChannelRegistered();
        }
      });
    }
  }
  
  /* Error */
  private void invokeChannelUnregistered()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +30 -> 34
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 250	io/netty/channel/ChannelInboundHandler
    //   16: aload_0
    //   17: invokeinterface 319 2 0
    //   22: goto +17 -> 39
    //   25: astore_1
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 196	io/netty/channel/AbstractChannelHandlerContext:invokeExceptionCaught	(Ljava/lang/Throwable;)V
    //   31: goto +8 -> 39
    //   34: aload_0
    //   35: invokevirtual 322	io/netty/channel/AbstractChannelHandlerContext:fireChannelUnregistered	()Lio/netty/channel/ChannelHandlerContext;
    //   38: pop
    //   39: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	AbstractChannelHandlerContext
    //   25	3	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	22	25	finally
  }
  
  static void invokeChannelUnregistered(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
  {
    EventExecutor localEventExecutor = paramAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop()) {
      paramAbstractChannelHandlerContext.invokeChannelUnregistered();
    } else {
      localEventExecutor.execute(new Runnable()
      {
        public void run()
        {
          this.val$next.invokeChannelUnregistered();
        }
      });
    }
  }
  
  /* Error */
  private void invokeChannelWritabilityChanged()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +30 -> 34
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 250	io/netty/channel/ChannelInboundHandler
    //   16: aload_0
    //   17: invokeinterface 326 2 0
    //   22: goto +17 -> 39
    //   25: astore_1
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 196	io/netty/channel/AbstractChannelHandlerContext:invokeExceptionCaught	(Ljava/lang/Throwable;)V
    //   31: goto +8 -> 39
    //   34: aload_0
    //   35: invokevirtual 329	io/netty/channel/AbstractChannelHandlerContext:fireChannelWritabilityChanged	()Lio/netty/channel/ChannelHandlerContext;
    //   38: pop
    //   39: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	AbstractChannelHandlerContext
    //   25	3	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	22	25	finally
  }
  
  static void invokeChannelWritabilityChanged(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
  {
    EventExecutor localEventExecutor = paramAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop())
    {
      paramAbstractChannelHandlerContext.invokeChannelWritabilityChanged();
    }
    else
    {
      Tasks localTasks1 = paramAbstractChannelHandlerContext.invokeTasks;
      Tasks localTasks2 = localTasks1;
      if (localTasks1 == null)
      {
        localTasks2 = new Tasks(paramAbstractChannelHandlerContext);
        paramAbstractChannelHandlerContext.invokeTasks = localTasks2;
      }
      localEventExecutor.execute(localTasks2.invokeChannelWritableStateChangedTask);
    }
  }
  
  /* Error */
  private void invokeClose(ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +31 -> 35
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 237	io/netty/channel/ChannelOutboundHandler
    //   16: aload_0
    //   17: aload_1
    //   18: invokeinterface 336 3 0
    //   23: goto +18 -> 41
    //   26: astore_2
    //   27: aload_2
    //   28: aload_1
    //   29: invokestatic 245	io/netty/channel/AbstractChannelHandlerContext:notifyOutboundHandlerException	(Ljava/lang/Throwable;Lio/netty/channel/ChannelPromise;)V
    //   32: goto +9 -> 41
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 339	io/netty/channel/AbstractChannelHandlerContext:close	(Lio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelFuture;
    //   40: pop
    //   41: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	AbstractChannelHandlerContext
    //   0	42	1	paramChannelPromise	ChannelPromise
    //   26	2	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	23	26	finally
  }
  
  /* Error */
  private void invokeConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +33 -> 37
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 237	io/netty/channel/ChannelOutboundHandler
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: aload_3
    //   20: invokeinterface 343 5 0
    //   25: goto +20 -> 45
    //   28: astore_1
    //   29: aload_1
    //   30: aload_3
    //   31: invokestatic 245	io/netty/channel/AbstractChannelHandlerContext:notifyOutboundHandlerException	(Ljava/lang/Throwable;Lio/netty/channel/ChannelPromise;)V
    //   34: goto +11 -> 45
    //   37: aload_0
    //   38: aload_1
    //   39: aload_2
    //   40: aload_3
    //   41: invokevirtual 346	io/netty/channel/AbstractChannelHandlerContext:connect	(Ljava/net/SocketAddress;Ljava/net/SocketAddress;Lio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelFuture;
    //   44: pop
    //   45: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	AbstractChannelHandlerContext
    //   0	46	1	paramSocketAddress1	SocketAddress
    //   0	46	2	paramSocketAddress2	SocketAddress
    //   0	46	3	paramChannelPromise	ChannelPromise
    // Exception table:
    //   from	to	target	type
    //   7	25	28	finally
  }
  
  /* Error */
  private void invokeDeregister(ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +31 -> 35
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 237	io/netty/channel/ChannelOutboundHandler
    //   16: aload_0
    //   17: aload_1
    //   18: invokeinterface 349 3 0
    //   23: goto +18 -> 41
    //   26: astore_2
    //   27: aload_2
    //   28: aload_1
    //   29: invokestatic 245	io/netty/channel/AbstractChannelHandlerContext:notifyOutboundHandlerException	(Ljava/lang/Throwable;Lio/netty/channel/ChannelPromise;)V
    //   32: goto +9 -> 41
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 351	io/netty/channel/AbstractChannelHandlerContext:deregister	(Lio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelFuture;
    //   40: pop
    //   41: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	AbstractChannelHandlerContext
    //   0	42	1	paramChannelPromise	ChannelPromise
    //   26	2	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	23	26	finally
  }
  
  /* Error */
  private void invokeDisconnect(ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +31 -> 35
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 237	io/netty/channel/ChannelOutboundHandler
    //   16: aload_0
    //   17: aload_1
    //   18: invokeinterface 354 3 0
    //   23: goto +18 -> 41
    //   26: astore_2
    //   27: aload_2
    //   28: aload_1
    //   29: invokestatic 245	io/netty/channel/AbstractChannelHandlerContext:notifyOutboundHandlerException	(Ljava/lang/Throwable;Lio/netty/channel/ChannelPromise;)V
    //   32: goto +9 -> 41
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 356	io/netty/channel/AbstractChannelHandlerContext:disconnect	(Lio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelFuture;
    //   40: pop
    //   41: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	AbstractChannelHandlerContext
    //   0	42	1	paramChannelPromise	ChannelPromise
    //   26	2	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	23	26	finally
  }
  
  /* Error */
  static void invokeExceptionCaught(AbstractChannelHandlerContext paramAbstractChannelHandlerContext, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 358
    //   4: invokestatic 113	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   7: pop
    //   8: aload_0
    //   9: invokevirtual 217	io/netty/channel/AbstractChannelHandlerContext:executor	()Lio/netty/util/concurrent/EventExecutor;
    //   12: astore_2
    //   13: aload_2
    //   14: invokeinterface 263 1 0
    //   19: ifeq +11 -> 30
    //   22: aload_0
    //   23: aload_1
    //   24: invokespecial 196	io/netty/channel/AbstractChannelHandlerContext:invokeExceptionCaught	(Ljava/lang/Throwable;)V
    //   27: goto +57 -> 84
    //   30: new 24	io/netty/channel/AbstractChannelHandlerContext$5
    //   33: astore_3
    //   34: aload_3
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 360	io/netty/channel/AbstractChannelHandlerContext$5:<init>	(Lio/netty/channel/AbstractChannelHandlerContext;Ljava/lang/Throwable;)V
    //   40: aload_2
    //   41: aload_3
    //   42: invokeinterface 271 2 0
    //   47: goto +37 -> 84
    //   50: astore_0
    //   51: getstatic 90	io/netty/channel/AbstractChannelHandlerContext:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   54: astore_3
    //   55: aload_3
    //   56: invokeinterface 365 1 0
    //   61: ifeq +23 -> 84
    //   64: aload_3
    //   65: ldc_w 367
    //   68: aload_0
    //   69: invokeinterface 371 3 0
    //   74: aload_3
    //   75: ldc_w 373
    //   78: aload_1
    //   79: invokeinterface 371 3 0
    //   84: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramAbstractChannelHandlerContext	AbstractChannelHandlerContext
    //   0	85	1	paramThrowable	Throwable
    //   12	29	2	localEventExecutor	EventExecutor
    //   33	42	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	47	50	finally
  }
  
  /* Error */
  private void invokeExceptionCaught(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +73 -> 77
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: aload_0
    //   14: aload_1
    //   15: invokeinterface 379 3 0
    //   20: goto +63 -> 83
    //   23: astore_2
    //   24: getstatic 90	io/netty/channel/AbstractChannelHandlerContext:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   27: astore_3
    //   28: aload_3
    //   29: invokeinterface 382 1 0
    //   34: ifeq +20 -> 54
    //   37: aload_3
    //   38: ldc_w 384
    //   41: aload_2
    //   42: invokestatic 390	io/netty/util/internal/ThrowableUtil:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   45: aload_1
    //   46: invokeinterface 394 4 0
    //   51: goto +32 -> 83
    //   54: aload_3
    //   55: invokeinterface 365 1 0
    //   60: ifeq +23 -> 83
    //   63: aload_3
    //   64: ldc_w 396
    //   67: aload_2
    //   68: aload_1
    //   69: invokeinterface 398 4 0
    //   74: goto +9 -> 83
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 402	io/netty/channel/AbstractChannelHandlerContext:fireExceptionCaught	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelHandlerContext;
    //   82: pop
    //   83: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	AbstractChannelHandlerContext
    //   0	84	1	paramThrowable	Throwable
    //   23	45	2	localThrowable	Throwable
    //   27	37	3	localInternalLogger	InternalLogger
    // Exception table:
    //   from	to	target	type
    //   7	20	23	finally
  }
  
  private void invokeFlush()
  {
    if (invokeHandler()) {
      invokeFlush0();
    } else {
      flush();
    }
  }
  
  /* Error */
  private void invokeFlush0()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 235 1 0
    //   6: checkcast 237	io/netty/channel/ChannelOutboundHandler
    //   9: aload_0
    //   10: invokeinterface 410 2 0
    //   15: goto +9 -> 24
    //   18: astore_1
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 196	io/netty/channel/AbstractChannelHandlerContext:invokeExceptionCaught	(Ljava/lang/Throwable;)V
    //   24: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	AbstractChannelHandlerContext
    //   18	3	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	15	18	finally
  }
  
  private boolean invokeHandler()
  {
    int i = this.handlerState;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (i != 2) {
      if ((!this.ordered) && (i == 1)) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  /* Error */
  private void invokeRead()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +30 -> 34
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 237	io/netty/channel/ChannelOutboundHandler
    //   16: aload_0
    //   17: invokeinterface 413 2 0
    //   22: goto +17 -> 39
    //   25: astore_1
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 196	io/netty/channel/AbstractChannelHandlerContext:invokeExceptionCaught	(Ljava/lang/Throwable;)V
    //   31: goto +8 -> 39
    //   34: aload_0
    //   35: invokevirtual 415	io/netty/channel/AbstractChannelHandlerContext:read	()Lio/netty/channel/ChannelHandlerContext;
    //   38: pop
    //   39: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	AbstractChannelHandlerContext
    //   25	3	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	22	25	finally
  }
  
  static void invokeUserEventTriggered(AbstractChannelHandlerContext paramAbstractChannelHandlerContext, final Object paramObject)
  {
    ObjectUtil.checkNotNull(paramObject, "event");
    EventExecutor localEventExecutor = paramAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop()) {
      paramAbstractChannelHandlerContext.invokeUserEventTriggered(paramObject);
    } else {
      localEventExecutor.execute(new Runnable()
      {
        public void run()
        {
          this.val$next.invokeUserEventTriggered(paramObject);
        }
      });
    }
  }
  
  /* Error */
  private void invokeUserEventTriggered(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 231	io/netty/channel/AbstractChannelHandlerContext:invokeHandler	()Z
    //   4: ifeq +31 -> 35
    //   7: aload_0
    //   8: invokeinterface 235 1 0
    //   13: checkcast 250	io/netty/channel/ChannelInboundHandler
    //   16: aload_0
    //   17: aload_1
    //   18: invokeinterface 421 3 0
    //   23: goto +18 -> 41
    //   26: astore_1
    //   27: aload_0
    //   28: aload_1
    //   29: invokespecial 196	io/netty/channel/AbstractChannelHandlerContext:invokeExceptionCaught	(Ljava/lang/Throwable;)V
    //   32: goto +9 -> 41
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 424	io/netty/channel/AbstractChannelHandlerContext:fireUserEventTriggered	(Ljava/lang/Object;)Lio/netty/channel/ChannelHandlerContext;
    //   40: pop
    //   41: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	AbstractChannelHandlerContext
    //   0	42	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	23	26	finally
  }
  
  /* Error */
  private void invokeWrite0(Object paramObject, ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 235 1 0
    //   6: checkcast 237	io/netty/channel/ChannelOutboundHandler
    //   9: aload_0
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 430 4 0
    //   17: goto +9 -> 26
    //   20: astore_1
    //   21: aload_1
    //   22: aload_2
    //   23: invokestatic 245	io/netty/channel/AbstractChannelHandlerContext:notifyOutboundHandlerException	(Ljava/lang/Throwable;Lio/netty/channel/ChannelPromise;)V
    //   26: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	AbstractChannelHandlerContext
    //   0	27	1	paramObject	Object
    //   0	27	2	paramChannelPromise	ChannelPromise
    // Exception table:
    //   from	to	target	type
    //   0	17	20	finally
  }
  
  private boolean isNotValidPromise(ChannelPromise paramChannelPromise, boolean paramBoolean)
  {
    ObjectUtil.checkNotNull(paramChannelPromise, "promise");
    if (paramChannelPromise.isDone())
    {
      if (paramChannelPromise.isCancelled()) {
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("promise already done: ");
      localStringBuilder.append(paramChannelPromise);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    if (paramChannelPromise.channel() == channel())
    {
      if (paramChannelPromise.getClass() == DefaultChannelPromise.class) {
        return false;
      }
      if ((!paramBoolean) && ((paramChannelPromise instanceof VoidChannelPromise)))
      {
        paramChannelPromise = new StringBuilder();
        paramChannelPromise.append(StringUtil.simpleClassName(VoidChannelPromise.class));
        paramChannelPromise.append(" not allowed for this operation");
        throw new IllegalArgumentException(paramChannelPromise.toString());
      }
      if (!(paramChannelPromise instanceof AbstractChannel.CloseFuture)) {
        return false;
      }
      paramChannelPromise = new StringBuilder();
      paramChannelPromise.append(StringUtil.simpleClassName(AbstractChannel.CloseFuture.class));
      paramChannelPromise.append(" not allowed in a pipeline");
      throw new IllegalArgumentException(paramChannelPromise.toString());
    }
    throw new IllegalArgumentException(String.format("promise.channel does not match: %s (expected: %s)", new Object[] { paramChannelPromise.channel(), channel() }));
  }
  
  private static void notifyOutboundHandlerException(Throwable paramThrowable, ChannelPromise paramChannelPromise)
  {
    InternalLogger localInternalLogger;
    if ((paramChannelPromise instanceof VoidChannelPromise)) {
      localInternalLogger = null;
    } else {
      localInternalLogger = logger;
    }
    PromiseNotificationUtil.tryFailure(paramChannelPromise, paramThrowable, localInternalLogger);
  }
  
  private static boolean safeExecute(EventExecutor paramEventExecutor, Runnable paramRunnable, ChannelPromise paramChannelPromise, Object paramObject, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if ((paramEventExecutor instanceof AbstractEventExecutor)) {
        ((AbstractEventExecutor)paramEventExecutor).lazyExecute(paramRunnable);
      } else {
        paramEventExecutor.execute(paramRunnable);
      }
      return true;
    }
    finally
    {
      try
      {
        paramChannelPromise.setFailure(paramEventExecutor);
        return false;
      }
      finally
      {
        if (paramObject != null) {
          ReferenceCountUtil.release(paramObject);
        }
      }
    }
  }
  
  private static boolean skipContext(AbstractChannelHandlerContext paramAbstractChannelHandlerContext, EventExecutor paramEventExecutor, int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((((paramInt2 | paramInt1) & paramAbstractChannelHandlerContext.executionMask) != 0) && ((paramAbstractChannelHandlerContext.executor() != paramEventExecutor) || ((paramAbstractChannelHandlerContext.executionMask & paramInt1) != 0))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void write(Object paramObject, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramObject, "msg");
    try
    {
      if (isNotValidPromise(paramChannelPromise, true))
      {
        ReferenceCountUtil.release(paramObject);
        return;
      }
      int i;
      if (paramBoolean) {
        i = 98304;
      } else {
        i = 32768;
      }
      Object localObject1 = findContextOutbound(i);
      Object localObject2 = this.pipeline.touch(paramObject, (AbstractChannelHandlerContext)localObject1);
      paramObject = ((AbstractChannelHandlerContext)localObject1).executor();
      if (((EventExecutor)paramObject).inEventLoop())
      {
        if (paramBoolean) {
          ((AbstractChannelHandlerContext)localObject1).invokeWriteAndFlush(localObject2, paramChannelPromise);
        } else {
          ((AbstractChannelHandlerContext)localObject1).invokeWrite(localObject2, paramChannelPromise);
        }
      }
      else
      {
        localObject1 = WriteTask.newInstance((AbstractChannelHandlerContext)localObject1, localObject2, paramChannelPromise, paramBoolean);
        if (!safeExecute((EventExecutor)paramObject, (Runnable)localObject1, paramChannelPromise, localObject2, paramBoolean ^ true)) {
          ((WriteTask)localObject1).cancel();
        }
      }
      return;
    }
    catch (RuntimeException paramChannelPromise)
    {
      ReferenceCountUtil.release(paramObject);
      throw paramChannelPromise;
    }
  }
  
  public ByteBufAllocator alloc()
  {
    return channel().config().getAllocator();
  }
  
  public <T> Attribute<T> attr(AttributeKey<T> paramAttributeKey)
  {
    return channel().attr(paramAttributeKey);
  }
  
  public ChannelFuture bind(SocketAddress paramSocketAddress)
  {
    return bind(paramSocketAddress, newPromise());
  }
  
  public ChannelFuture bind(final SocketAddress paramSocketAddress, final ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramSocketAddress, "localAddress");
    if (isNotValidPromise(paramChannelPromise, false)) {
      return paramChannelPromise;
    }
    final AbstractChannelHandlerContext localAbstractChannelHandlerContext = findContextOutbound(512);
    EventExecutor localEventExecutor = localAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop()) {
      localAbstractChannelHandlerContext.invokeBind(paramSocketAddress, paramChannelPromise);
    } else {
      safeExecute(localEventExecutor, new Runnable()
      {
        public void run()
        {
          localAbstractChannelHandlerContext.invokeBind(paramSocketAddress, paramChannelPromise);
        }
      }, paramChannelPromise, null, false);
    }
    return paramChannelPromise;
  }
  
  final void callHandlerAdded()
    throws Exception
  {
    if (setAddComplete()) {
      handler().handlerAdded(this);
    }
  }
  
  final void callHandlerRemoved()
    throws Exception
  {
    try
    {
      if (this.handlerState == 2) {
        handler().handlerRemoved(this);
      }
      return;
    }
    finally
    {
      setRemoved();
    }
  }
  
  public Channel channel()
  {
    return this.pipeline.channel();
  }
  
  public ChannelFuture close()
  {
    return close(newPromise());
  }
  
  public ChannelFuture close(final ChannelPromise paramChannelPromise)
  {
    if (isNotValidPromise(paramChannelPromise, false)) {
      return paramChannelPromise;
    }
    final AbstractChannelHandlerContext localAbstractChannelHandlerContext = findContextOutbound(4096);
    EventExecutor localEventExecutor = localAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop()) {
      localAbstractChannelHandlerContext.invokeClose(paramChannelPromise);
    } else {
      safeExecute(localEventExecutor, new Runnable()
      {
        public void run()
        {
          localAbstractChannelHandlerContext.invokeClose(paramChannelPromise);
        }
      }, paramChannelPromise, null, false);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture connect(SocketAddress paramSocketAddress)
  {
    return connect(paramSocketAddress, newPromise());
  }
  
  public ChannelFuture connect(SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
  {
    return connect(paramSocketAddress, null, paramChannelPromise);
  }
  
  public ChannelFuture connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
  {
    return connect(paramSocketAddress1, paramSocketAddress2, newPromise());
  }
  
  public ChannelFuture connect(final SocketAddress paramSocketAddress1, final SocketAddress paramSocketAddress2, final ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramSocketAddress1, "remoteAddress");
    if (isNotValidPromise(paramChannelPromise, false)) {
      return paramChannelPromise;
    }
    final AbstractChannelHandlerContext localAbstractChannelHandlerContext = findContextOutbound(1024);
    EventExecutor localEventExecutor = localAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop()) {
      localAbstractChannelHandlerContext.invokeConnect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
    } else {
      safeExecute(localEventExecutor, new Runnable()
      {
        public void run()
        {
          localAbstractChannelHandlerContext.invokeConnect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
        }
      }, paramChannelPromise, null, false);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture deregister()
  {
    return deregister(newPromise());
  }
  
  public ChannelFuture deregister(final ChannelPromise paramChannelPromise)
  {
    if (isNotValidPromise(paramChannelPromise, false)) {
      return paramChannelPromise;
    }
    final AbstractChannelHandlerContext localAbstractChannelHandlerContext = findContextOutbound(8192);
    EventExecutor localEventExecutor = localAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop()) {
      localAbstractChannelHandlerContext.invokeDeregister(paramChannelPromise);
    } else {
      safeExecute(localEventExecutor, new Runnable()
      {
        public void run()
        {
          localAbstractChannelHandlerContext.invokeDeregister(paramChannelPromise);
        }
      }, paramChannelPromise, null, false);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture disconnect()
  {
    return disconnect(newPromise());
  }
  
  public ChannelFuture disconnect(final ChannelPromise paramChannelPromise)
  {
    if (!channel().metadata().hasDisconnect()) {
      return close(paramChannelPromise);
    }
    if (isNotValidPromise(paramChannelPromise, false)) {
      return paramChannelPromise;
    }
    final AbstractChannelHandlerContext localAbstractChannelHandlerContext = findContextOutbound(2048);
    EventExecutor localEventExecutor = localAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop()) {
      localAbstractChannelHandlerContext.invokeDisconnect(paramChannelPromise);
    } else {
      safeExecute(localEventExecutor, new Runnable()
      {
        public void run()
        {
          localAbstractChannelHandlerContext.invokeDisconnect(paramChannelPromise);
        }
      }, paramChannelPromise, null, false);
    }
    return paramChannelPromise;
  }
  
  public EventExecutor executor()
  {
    EventExecutor localEventExecutor = this.executor;
    Object localObject = localEventExecutor;
    if (localEventExecutor == null) {
      localObject = channel().eventLoop();
    }
    return (EventExecutor)localObject;
  }
  
  public ChannelHandlerContext fireChannelActive()
  {
    invokeChannelActive(findContextInbound(8));
    return this;
  }
  
  public ChannelHandlerContext fireChannelInactive()
  {
    invokeChannelInactive(findContextInbound(16));
    return this;
  }
  
  public ChannelHandlerContext fireChannelRead(Object paramObject)
  {
    invokeChannelRead(findContextInbound(32), paramObject);
    return this;
  }
  
  public ChannelHandlerContext fireChannelReadComplete()
  {
    invokeChannelReadComplete(findContextInbound(64));
    return this;
  }
  
  public ChannelHandlerContext fireChannelRegistered()
  {
    invokeChannelRegistered(findContextInbound(2));
    return this;
  }
  
  public ChannelHandlerContext fireChannelUnregistered()
  {
    invokeChannelUnregistered(findContextInbound(4));
    return this;
  }
  
  public ChannelHandlerContext fireChannelWritabilityChanged()
  {
    invokeChannelWritabilityChanged(findContextInbound(256));
    return this;
  }
  
  public ChannelHandlerContext fireExceptionCaught(Throwable paramThrowable)
  {
    invokeExceptionCaught(findContextInbound(1), paramThrowable);
    return this;
  }
  
  public ChannelHandlerContext fireUserEventTriggered(Object paramObject)
  {
    invokeUserEventTriggered(findContextInbound(128), paramObject);
    return this;
  }
  
  public ChannelHandlerContext flush()
  {
    AbstractChannelHandlerContext localAbstractChannelHandlerContext = findContextOutbound(65536);
    EventExecutor localEventExecutor = localAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop())
    {
      localAbstractChannelHandlerContext.invokeFlush();
    }
    else
    {
      Tasks localTasks1 = localAbstractChannelHandlerContext.invokeTasks;
      Tasks localTasks2 = localTasks1;
      if (localTasks1 == null)
      {
        localTasks2 = new Tasks(localAbstractChannelHandlerContext);
        localAbstractChannelHandlerContext.invokeTasks = localTasks2;
      }
      safeExecute(localEventExecutor, localTasks2.invokeFlushTask, channel().voidPromise(), null, false);
    }
    return this;
  }
  
  public <T> boolean hasAttr(AttributeKey<T> paramAttributeKey)
  {
    return channel().hasAttr(paramAttributeKey);
  }
  
  void invokeWrite(Object paramObject, ChannelPromise paramChannelPromise)
  {
    if (invokeHandler()) {
      invokeWrite0(paramObject, paramChannelPromise);
    } else {
      write(paramObject, paramChannelPromise);
    }
  }
  
  void invokeWriteAndFlush(Object paramObject, ChannelPromise paramChannelPromise)
  {
    if (invokeHandler())
    {
      invokeWrite0(paramObject, paramChannelPromise);
      invokeFlush0();
    }
    else
    {
      writeAndFlush(paramObject, paramChannelPromise);
    }
  }
  
  public boolean isRemoved()
  {
    boolean bool;
    if (this.handlerState == 3) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String name()
  {
    return this.name;
  }
  
  public ChannelFuture newFailedFuture(Throwable paramThrowable)
  {
    return new FailedChannelFuture(channel(), executor(), paramThrowable);
  }
  
  public ChannelProgressivePromise newProgressivePromise()
  {
    return new DefaultChannelProgressivePromise(channel(), executor());
  }
  
  public ChannelPromise newPromise()
  {
    return new DefaultChannelPromise(channel(), executor());
  }
  
  public ChannelFuture newSucceededFuture()
  {
    ChannelFuture localChannelFuture = this.succeededFuture;
    Object localObject = localChannelFuture;
    if (localChannelFuture == null)
    {
      localObject = new SucceededChannelFuture(channel(), executor());
      this.succeededFuture = ((ChannelFuture)localObject);
    }
    return (ChannelFuture)localObject;
  }
  
  public ChannelPipeline pipeline()
  {
    return this.pipeline;
  }
  
  public ChannelHandlerContext read()
  {
    AbstractChannelHandlerContext localAbstractChannelHandlerContext = findContextOutbound(16384);
    EventExecutor localEventExecutor = localAbstractChannelHandlerContext.executor();
    if (localEventExecutor.inEventLoop())
    {
      localAbstractChannelHandlerContext.invokeRead();
    }
    else
    {
      Tasks localTasks1 = localAbstractChannelHandlerContext.invokeTasks;
      Tasks localTasks2 = localTasks1;
      if (localTasks1 == null)
      {
        localTasks2 = new Tasks(localAbstractChannelHandlerContext);
        localAbstractChannelHandlerContext.invokeTasks = localTasks2;
      }
      localEventExecutor.execute(localTasks2.invokeReadTask);
    }
    return this;
  }
  
  final boolean setAddComplete()
  {
    int i;
    do
    {
      i = this.handlerState;
      if (i == 3) {
        return false;
      }
    } while (!HANDLER_STATE_UPDATER.compareAndSet(this, i, 2));
    return true;
  }
  
  final void setAddPending()
  {
    HANDLER_STATE_UPDATER.compareAndSet(this, 0, 1);
  }
  
  final void setRemoved()
  {
    this.handlerState = 3;
  }
  
  public String toHintString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\'');
    localStringBuilder.append(this.name);
    localStringBuilder.append("' will handle the message from this point.");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(ChannelHandlerContext.class));
    localStringBuilder.append('(');
    localStringBuilder.append(this.name);
    localStringBuilder.append(", ");
    localStringBuilder.append(channel());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public ChannelPromise voidPromise()
  {
    return channel().voidPromise();
  }
  
  public ChannelFuture write(Object paramObject)
  {
    return write(paramObject, newPromise());
  }
  
  public ChannelFuture write(Object paramObject, ChannelPromise paramChannelPromise)
  {
    write(paramObject, false, paramChannelPromise);
    return paramChannelPromise;
  }
  
  public ChannelFuture writeAndFlush(Object paramObject)
  {
    return writeAndFlush(paramObject, newPromise());
  }
  
  public ChannelFuture writeAndFlush(Object paramObject, ChannelPromise paramChannelPromise)
  {
    write(paramObject, true, paramChannelPromise);
    return paramChannelPromise;
  }
  
  private static final class Tasks
  {
    private final Runnable invokeChannelReadCompleteTask = new Runnable()
    {
      public void run()
      {
        AbstractChannelHandlerContext.this.invokeChannelReadComplete();
      }
    };
    private final Runnable invokeChannelWritableStateChangedTask = new Runnable()
    {
      public void run()
      {
        AbstractChannelHandlerContext.this.invokeChannelWritabilityChanged();
      }
    };
    private final Runnable invokeFlushTask = new Runnable()
    {
      public void run()
      {
        AbstractChannelHandlerContext.this.invokeFlush();
      }
    };
    private final Runnable invokeReadTask = new Runnable()
    {
      public void run()
      {
        AbstractChannelHandlerContext.this.invokeRead();
      }
    };
    private final AbstractChannelHandlerContext next;
    
    Tasks(AbstractChannelHandlerContext paramAbstractChannelHandlerContext)
    {
      this.next = paramAbstractChannelHandlerContext;
    }
  }
  
  static final class WriteTask
    implements Runnable
  {
    private static final boolean ESTIMATE_TASK_SIZE_ON_SUBMIT = SystemPropertyUtil.getBoolean("io.netty.transport.estimateSizeOnSubmit", true);
    private static final ObjectPool<WriteTask> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
    {
      public AbstractChannelHandlerContext.WriteTask newObject(ObjectPool.Handle<AbstractChannelHandlerContext.WriteTask> paramAnonymousHandle)
      {
        return new AbstractChannelHandlerContext.WriteTask(paramAnonymousHandle, null);
      }
    });
    private static final int WRITE_TASK_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.writeTaskSizeOverhead", 32);
    private AbstractChannelHandlerContext ctx;
    private final ObjectPool.Handle<WriteTask> handle;
    private Object msg;
    private ChannelPromise promise;
    private int size;
    
    private WriteTask(ObjectPool.Handle<? extends WriteTask> paramHandle)
    {
      this.handle = paramHandle;
    }
    
    private void decrementPendingOutboundBytes()
    {
      if (ESTIMATE_TASK_SIZE_ON_SUBMIT) {
        this.ctx.pipeline.decrementPendingOutboundBytes(this.size & 0x7FFFFFFF);
      }
    }
    
    protected static void init(WriteTask paramWriteTask, AbstractChannelHandlerContext paramAbstractChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise, boolean paramBoolean)
    {
      paramWriteTask.ctx = paramAbstractChannelHandlerContext;
      paramWriteTask.msg = paramObject;
      paramWriteTask.promise = paramChannelPromise;
      if (ESTIMATE_TASK_SIZE_ON_SUBMIT)
      {
        paramWriteTask.size = (paramAbstractChannelHandlerContext.pipeline.estimatorHandle().size(paramObject) + WRITE_TASK_OVERHEAD);
        paramAbstractChannelHandlerContext.pipeline.incrementPendingOutboundBytes(paramWriteTask.size);
      }
      else
      {
        paramWriteTask.size = 0;
      }
      if (paramBoolean) {
        paramWriteTask.size |= 0x80000000;
      }
    }
    
    static WriteTask newInstance(AbstractChannelHandlerContext paramAbstractChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise, boolean paramBoolean)
    {
      WriteTask localWriteTask = (WriteTask)RECYCLER.get();
      init(localWriteTask, paramAbstractChannelHandlerContext, paramObject, paramChannelPromise, paramBoolean);
      return localWriteTask;
    }
    
    private void recycle()
    {
      this.ctx = null;
      this.msg = null;
      this.promise = null;
      this.handle.recycle(this);
    }
    
    void cancel()
    {
      try
      {
        decrementPendingOutboundBytes();
        return;
      }
      finally
      {
        recycle();
      }
    }
    
    public void run()
    {
      try
      {
        decrementPendingOutboundBytes();
        if (this.size >= 0) {
          this.ctx.invokeWrite(this.msg, this.promise);
        } else {
          this.ctx.invokeWriteAndFlush(this.msg, this.promise);
        }
        return;
      }
      finally
      {
        recycle();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\AbstractChannelHandlerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */