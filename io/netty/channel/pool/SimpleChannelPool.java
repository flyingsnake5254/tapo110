package io.netty.channel.pool;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.bootstrap.AbstractBootstrapConfig;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.AttributeMap;
import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

public class SimpleChannelPool
  implements ChannelPool
{
  private static final AttributeKey<SimpleChannelPool> POOL_KEY = AttributeKey.newInstance("io.netty.channel.pool.SimpleChannelPool");
  private final Bootstrap bootstrap;
  private final Deque<Channel> deque = PlatformDependent.newConcurrentDeque();
  private final ChannelPoolHandler handler;
  private final ChannelHealthChecker healthCheck;
  private final boolean lastRecentUsed;
  private final boolean releaseHealthCheck;
  
  public SimpleChannelPool(Bootstrap paramBootstrap, ChannelPoolHandler paramChannelPoolHandler)
  {
    this(paramBootstrap, paramChannelPoolHandler, ChannelHealthChecker.ACTIVE);
  }
  
  public SimpleChannelPool(Bootstrap paramBootstrap, ChannelPoolHandler paramChannelPoolHandler, ChannelHealthChecker paramChannelHealthChecker)
  {
    this(paramBootstrap, paramChannelPoolHandler, paramChannelHealthChecker, true);
  }
  
  public SimpleChannelPool(Bootstrap paramBootstrap, ChannelPoolHandler paramChannelPoolHandler, ChannelHealthChecker paramChannelHealthChecker, boolean paramBoolean)
  {
    this(paramBootstrap, paramChannelPoolHandler, paramChannelHealthChecker, paramBoolean, true);
  }
  
  public SimpleChannelPool(Bootstrap paramBootstrap, final ChannelPoolHandler paramChannelPoolHandler, ChannelHealthChecker paramChannelHealthChecker, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.handler = ((ChannelPoolHandler)ObjectUtil.checkNotNull(paramChannelPoolHandler, "handler"));
    this.healthCheck = ((ChannelHealthChecker)ObjectUtil.checkNotNull(paramChannelHealthChecker, "healthCheck"));
    this.releaseHealthCheck = paramBoolean1;
    paramBootstrap = ((Bootstrap)ObjectUtil.checkNotNull(paramBootstrap, "bootstrap")).clone();
    this.bootstrap = paramBootstrap;
    paramBootstrap.handler(new ChannelInitializer()
    {
      protected void initChannel(Channel paramAnonymousChannel)
        throws Exception
      {
        paramChannelPoolHandler.channelCreated(paramAnonymousChannel);
      }
    });
    this.lastRecentUsed = paramBoolean2;
  }
  
  private io.netty.util.concurrent.Future<Channel> acquireHealthyFromPoolOrNew(Promise<Channel> paramPromise)
  {
    try
    {
      Object localObject1 = pollChannel();
      if (localObject1 == null)
      {
        localObject2 = this.bootstrap.clone();
        ((AbstractBootstrap)localObject2).attr(POOL_KEY, this);
        localObject2 = connectChannel((Bootstrap)localObject2);
        if (((java.util.concurrent.Future)localObject2).isDone())
        {
          notifyConnect((ChannelFuture)localObject2, paramPromise);
        }
        else
        {
          localObject1 = new io/netty/channel/pool/SimpleChannelPool$2;
          ((2)localObject1).<init>(this, paramPromise);
        }
        return paramPromise;
      }
      Object localObject2 = ((Channel)localObject1).eventLoop();
      if (((EventExecutor)localObject2).inEventLoop())
      {
        doHealthCheck((Channel)localObject1, paramPromise);
      }
      else
      {
        Runnable local3 = new io/netty/channel/pool/SimpleChannelPool$3;
        local3.<init>(this, (Channel)localObject1, paramPromise);
        ((ScheduledExecutorService)localObject2).execute(local3);
      }
    }
    finally
    {
      paramPromise.tryFailure(localThrowable);
    }
    return paramPromise;
  }
  
  private void closeAndFail(Channel paramChannel, Throwable paramThrowable, Promise<?> paramPromise)
  {
    closeChannel(paramChannel);
    paramPromise.tryFailure(paramThrowable);
  }
  
  private void closeChannel(Channel paramChannel)
  {
    paramChannel.attr(POOL_KEY).getAndSet(null);
    paramChannel.close();
  }
  
  private void doHealthCheck(final Channel paramChannel, final Promise<Channel> paramPromise)
  {
    io.netty.util.concurrent.Future localFuture = this.healthCheck.isHealthy(paramChannel);
    if (localFuture.isDone()) {
      notifyHealthCheck(localFuture, paramChannel, paramPromise);
    } else {
      localFuture.addListener(new a()
      {
        public void operationComplete(io.netty.util.concurrent.Future<Boolean> paramAnonymousFuture)
          throws Exception
        {
          SimpleChannelPool.this.notifyHealthCheck(paramAnonymousFuture, paramChannel, paramPromise);
        }
      });
    }
  }
  
  private void doHealthCheckOnRelease(final Channel paramChannel, final Promise<Void> paramPromise)
    throws Exception
  {
    final io.netty.util.concurrent.Future localFuture = this.healthCheck.isHealthy(paramChannel);
    if (localFuture.isDone()) {
      releaseAndOfferIfHealthy(paramChannel, paramPromise, localFuture);
    } else {
      localFuture.addListener(new a()
      {
        public void operationComplete(io.netty.util.concurrent.Future<Boolean> paramAnonymousFuture)
          throws Exception
        {
          SimpleChannelPool.this.releaseAndOfferIfHealthy(paramChannel, paramPromise, localFuture);
        }
      });
    }
  }
  
  private void doReleaseChannel(Channel paramChannel, Promise<Void> paramPromise)
  {
    if (paramChannel.attr(POOL_KEY).getAndSet(null) != this)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Channel ");
      localStringBuilder.append(paramChannel);
      localStringBuilder.append(" was not acquired from this ChannelPool");
      closeAndFail(paramChannel, new IllegalArgumentException(localStringBuilder.toString()), paramPromise);
    }
    else
    {
      try
      {
        if (this.releaseHealthCheck) {
          doHealthCheckOnRelease(paramChannel, paramPromise);
        } else {
          releaseAndOffer(paramChannel, paramPromise);
        }
      }
      finally
      {
        closeAndFail(paramChannel, localThrowable, paramPromise);
      }
    }
  }
  
  private void notifyConnect(ChannelFuture paramChannelFuture, Promise<Channel> paramPromise)
    throws Exception
  {
    if (paramChannelFuture.isSuccess())
    {
      paramChannelFuture = paramChannelFuture.channel();
      this.handler.channelAcquired(paramChannelFuture);
      if (!paramPromise.trySuccess(paramChannelFuture)) {
        release(paramChannelFuture);
      }
    }
    else
    {
      paramPromise.tryFailure(paramChannelFuture.cause());
    }
  }
  
  /* Error */
  private void notifyHealthCheck(io.netty.util.concurrent.Future<Boolean> paramFuture, Channel paramChannel, Promise<Channel> paramPromise)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 272 1 0
    //   6: ifeq +79 -> 85
    //   9: aload_1
    //   10: invokeinterface 294 1 0
    //   15: checkcast 296	java/lang/Boolean
    //   18: invokevirtual 299	java/lang/Boolean:booleanValue	()Z
    //   21: ifeq +50 -> 71
    //   24: aload_2
    //   25: getstatic 51	io/netty/channel/pool/SimpleChannelPool:POOL_KEY	Lio/netty/util/AttributeKey;
    //   28: invokeinterface 212 2 0
    //   33: aload_0
    //   34: invokeinterface 303 2 0
    //   39: aload_0
    //   40: getfield 89	io/netty/channel/pool/SimpleChannelPool:handler	Lio/netty/channel/pool/ChannelPoolHandler;
    //   43: aload_2
    //   44: invokeinterface 278 2 0
    //   49: aload_3
    //   50: aload_2
    //   51: invokeinterface 307 2 0
    //   56: pop
    //   57: goto +39 -> 96
    //   60: astore_1
    //   61: aload_0
    //   62: aload_2
    //   63: aload_1
    //   64: aload_3
    //   65: invokespecial 264	io/netty/channel/pool/SimpleChannelPool:closeAndFail	(Lio/netty/channel/Channel;Ljava/lang/Throwable;Lio/netty/util/concurrent/Promise;)V
    //   68: goto +28 -> 96
    //   71: aload_0
    //   72: aload_2
    //   73: invokespecial 206	io/netty/channel/pool/SimpleChannelPool:closeChannel	(Lio/netty/channel/Channel;)V
    //   76: aload_0
    //   77: aload_3
    //   78: invokespecial 309	io/netty/channel/pool/SimpleChannelPool:acquireHealthyFromPoolOrNew	(Lio/netty/util/concurrent/Promise;)Lio/netty/util/concurrent/Future;
    //   81: pop
    //   82: goto +14 -> 96
    //   85: aload_0
    //   86: aload_2
    //   87: invokespecial 206	io/netty/channel/pool/SimpleChannelPool:closeChannel	(Lio/netty/channel/Channel;)V
    //   90: aload_0
    //   91: aload_3
    //   92: invokespecial 309	io/netty/channel/pool/SimpleChannelPool:acquireHealthyFromPoolOrNew	(Lio/netty/util/concurrent/Promise;)Lio/netty/util/concurrent/Future;
    //   95: pop
    //   96: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	SimpleChannelPool
    //   0	97	1	paramFuture	io.netty.util.concurrent.Future<Boolean>
    //   0	97	2	paramChannel	Channel
    //   0	97	3	paramPromise	Promise<Channel>
    // Exception table:
    //   from	to	target	type
    //   24	57	60	finally
  }
  
  private void releaseAndOffer(Channel paramChannel, Promise<Void> paramPromise)
    throws Exception
  {
    if (offerChannel(paramChannel))
    {
      this.handler.channelReleased(paramChannel);
      paramPromise.setSuccess(null);
    }
    else
    {
      closeAndFail(paramChannel, new IllegalStateException("ChannelPool full")
      {
        public Throwable fillInStackTrace()
        {
          return this;
        }
      }, paramPromise);
    }
  }
  
  private void releaseAndOfferIfHealthy(Channel paramChannel, Promise<Void> paramPromise, io.netty.util.concurrent.Future<Boolean> paramFuture)
    throws Exception
  {
    if (((Boolean)paramFuture.getNow()).booleanValue())
    {
      releaseAndOffer(paramChannel, paramPromise);
    }
    else
    {
      this.handler.channelReleased(paramChannel);
      paramPromise.setSuccess(null);
    }
  }
  
  public final io.netty.util.concurrent.Future<Channel> acquire()
  {
    return acquire(this.bootstrap.config().group().next().newPromise());
  }
  
  public io.netty.util.concurrent.Future<Channel> acquire(Promise<Channel> paramPromise)
  {
    return acquireHealthyFromPoolOrNew((Promise)ObjectUtil.checkNotNull(paramPromise, "promise"));
  }
  
  protected Bootstrap bootstrap()
  {
    return this.bootstrap;
  }
  
  public void close()
  {
    for (;;)
    {
      Channel localChannel = pollChannel();
      if (localChannel == null) {
        return;
      }
      localChannel.close().awaitUninterruptibly();
    }
  }
  
  public io.netty.util.concurrent.Future<Void> closeAsync()
  {
    GlobalEventExecutor.INSTANCE.submit(new Callable()
    {
      public Void call()
        throws Exception
      {
        SimpleChannelPool.this.close();
        return null;
      }
    });
  }
  
  protected ChannelFuture connectChannel(Bootstrap paramBootstrap)
  {
    return paramBootstrap.connect();
  }
  
  protected ChannelPoolHandler handler()
  {
    return this.handler;
  }
  
  protected ChannelHealthChecker healthChecker()
  {
    return this.healthCheck;
  }
  
  protected boolean offerChannel(Channel paramChannel)
  {
    return this.deque.offer(paramChannel);
  }
  
  protected Channel pollChannel()
  {
    Object localObject;
    if (this.lastRecentUsed) {
      localObject = this.deque.pollLast();
    } else {
      localObject = this.deque.pollFirst();
    }
    return (Channel)localObject;
  }
  
  public final io.netty.util.concurrent.Future<Void> release(Channel paramChannel)
  {
    return release(paramChannel, paramChannel.eventLoop().newPromise());
  }
  
  public io.netty.util.concurrent.Future<Void> release(Channel paramChannel, Promise<Void> paramPromise)
  {
    ObjectUtil.checkNotNull(paramChannel, "channel");
    ObjectUtil.checkNotNull(paramPromise, "promise");
    try
    {
      EventLoop localEventLoop = paramChannel.eventLoop();
      if (localEventLoop.inEventLoop())
      {
        doReleaseChannel(paramChannel, paramPromise);
      }
      else
      {
        Runnable local5 = new io/netty/channel/pool/SimpleChannelPool$5;
        local5.<init>(this, paramChannel, paramPromise);
        localEventLoop.execute(local5);
      }
    }
    finally
    {
      closeAndFail(paramChannel, localThrowable, paramPromise);
    }
    return paramPromise;
  }
  
  protected boolean releaseHealthCheck()
  {
    return this.releaseHealthCheck;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\pool\SimpleChannelPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */