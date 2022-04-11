package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutorGroup;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.ThreadPerTaskExecutor;
import io.netty.util.concurrent.a;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReadOnlyIterator;
import io.netty.util.internal.ThrowableUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@Deprecated
public class ThreadPerChannelEventLoopGroup
  extends AbstractEventExecutorGroup
  implements EventLoopGroup
{
  final Set<EventLoop> activeChildren = Collections.newSetFromMap(PlatformDependent.newConcurrentHashMap());
  private final Object[] childArgs;
  private final a<Object> childTerminationListener = new a()
  {
    public void operationComplete(Future<Object> paramAnonymousFuture)
      throws Exception
    {
      if (ThreadPerChannelEventLoopGroup.this.isTerminated()) {
        ThreadPerChannelEventLoopGroup.this.terminationFuture.trySuccess(null);
      }
    }
  };
  final Executor executor;
  final Queue<EventLoop> idleChildren = new ConcurrentLinkedQueue();
  private final int maxChannels;
  private volatile boolean shuttingDown;
  private final Promise<?> terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
  private final ChannelException tooManyChannels;
  
  protected ThreadPerChannelEventLoopGroup()
  {
    this(0);
  }
  
  protected ThreadPerChannelEventLoopGroup(int paramInt)
  {
    this(paramInt, null, new Object[0]);
  }
  
  protected ThreadPerChannelEventLoopGroup(int paramInt, Executor paramExecutor, Object... paramVarArgs)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "maxChannels");
    Object localObject = paramExecutor;
    if (paramExecutor == null) {
      localObject = new ThreadPerTaskExecutor(new DefaultThreadFactory(getClass()));
    }
    if (paramVarArgs == null) {
      this.childArgs = EmptyArrays.EMPTY_OBJECTS;
    } else {
      this.childArgs = ((Object[])paramVarArgs.clone());
    }
    this.maxChannels = paramInt;
    this.executor = ((Executor)localObject);
    paramExecutor = new StringBuilder();
    paramExecutor.append("too many channels (max: ");
    paramExecutor.append(paramInt);
    paramExecutor.append(')');
    this.tooManyChannels = ((ChannelException)ThrowableUtil.unknownStackTrace(ChannelException.newStatic(paramExecutor.toString(), null), ThreadPerChannelEventLoopGroup.class, "nextChild()"));
  }
  
  protected ThreadPerChannelEventLoopGroup(int paramInt, ThreadFactory paramThreadFactory, Object... paramVarArgs)
  {
    this(paramInt, paramThreadFactory, paramVarArgs);
  }
  
  private EventLoop nextChild()
    throws Exception
  {
    if (!this.shuttingDown)
    {
      EventLoop localEventLoop1 = (EventLoop)this.idleChildren.poll();
      EventLoop localEventLoop2 = localEventLoop1;
      if (localEventLoop1 == null)
      {
        if ((this.maxChannels > 0) && (this.activeChildren.size() >= this.maxChannels)) {
          throw this.tooManyChannels;
        }
        localEventLoop2 = newChild(this.childArgs);
        localEventLoop2.terminationFuture().addListener(this.childTerminationListener);
      }
      this.activeChildren.add(localEventLoop2);
      return localEventLoop2;
    }
    throw new RejectedExecutionException("shutting down");
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    paramLong = System.nanoTime() + paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.activeChildren.iterator();
    long l;
    while (paramTimeUnit.hasNext())
    {
      localObject = (EventLoop)paramTimeUnit.next();
      do
      {
        l = paramLong - System.nanoTime();
        if (l <= 0L) {
          return isTerminated();
        }
      } while (!((ScheduledExecutorService)localObject).awaitTermination(l, TimeUnit.NANOSECONDS));
    }
    Object localObject = this.idleChildren.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramTimeUnit = (EventLoop)((Iterator)localObject).next();
      do
      {
        l = paramLong - System.nanoTime();
        if (l <= 0L) {
          return isTerminated();
        }
      } while (!paramTimeUnit.awaitTermination(l, TimeUnit.NANOSECONDS));
    }
    return isTerminated();
  }
  
  public boolean isShutdown()
  {
    Iterator localIterator = this.activeChildren.iterator();
    while (localIterator.hasNext()) {
      if (!((EventLoop)localIterator.next()).isShutdown()) {
        return false;
      }
    }
    localIterator = this.idleChildren.iterator();
    while (localIterator.hasNext()) {
      if (!((EventLoop)localIterator.next()).isShutdown()) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isShuttingDown()
  {
    Iterator localIterator = this.activeChildren.iterator();
    while (localIterator.hasNext()) {
      if (!((EventLoop)localIterator.next()).isShuttingDown()) {
        return false;
      }
    }
    localIterator = this.idleChildren.iterator();
    while (localIterator.hasNext()) {
      if (!((EventLoop)localIterator.next()).isShuttingDown()) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isTerminated()
  {
    Iterator localIterator = this.activeChildren.iterator();
    while (localIterator.hasNext()) {
      if (!((EventLoop)localIterator.next()).isTerminated()) {
        return false;
      }
    }
    localIterator = this.idleChildren.iterator();
    while (localIterator.hasNext()) {
      if (!((EventLoop)localIterator.next()).isTerminated()) {
        return false;
      }
    }
    return true;
  }
  
  public Iterator<EventExecutor> iterator()
  {
    return new ReadOnlyIterator(this.activeChildren.iterator());
  }
  
  protected EventLoop newChild(Object... paramVarArgs)
    throws Exception
  {
    return new ThreadPerChannelEventLoop(this);
  }
  
  public EventLoop next()
  {
    throw new UnsupportedOperationException();
  }
  
  public ChannelFuture register(Channel paramChannel)
  {
    ObjectUtil.checkNotNull(paramChannel, "channel");
    try
    {
      localObject = nextChild();
      DefaultChannelPromise localDefaultChannelPromise = new io/netty/channel/DefaultChannelPromise;
      localDefaultChannelPromise.<init>(paramChannel, (EventExecutor)localObject);
      localObject = ((EventLoopGroup)localObject).register(localDefaultChannelPromise);
    }
    finally
    {
      Object localObject;
      return new FailedChannelFuture(paramChannel, GlobalEventExecutor.INSTANCE, localThrowable);
    }
  }
  
  @Deprecated
  public ChannelFuture register(Channel paramChannel, ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramChannel, "channel");
    try
    {
      paramChannel = nextChild().register(paramChannel, paramChannelPromise);
      return paramChannel;
    }
    finally
    {
      paramChannelPromise.setFailure(paramChannel);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture register(ChannelPromise paramChannelPromise)
  {
    try
    {
      ChannelFuture localChannelFuture = nextChild().register(paramChannelPromise);
      return localChannelFuture;
    }
    finally
    {
      paramChannelPromise.setFailure(localThrowable);
    }
    return paramChannelPromise;
  }
  
  @Deprecated
  public void shutdown()
  {
    this.shuttingDown = true;
    Iterator localIterator = this.activeChildren.iterator();
    while (localIterator.hasNext()) {
      ((EventLoop)localIterator.next()).shutdown();
    }
    localIterator = this.idleChildren.iterator();
    while (localIterator.hasNext()) {
      ((EventLoop)localIterator.next()).shutdown();
    }
    if (isTerminated()) {
      this.terminationFuture.trySuccess(null);
    }
  }
  
  public Future<?> shutdownGracefully(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    this.shuttingDown = true;
    Iterator localIterator = this.activeChildren.iterator();
    while (localIterator.hasNext()) {
      ((EventLoop)localIterator.next()).shutdownGracefully(paramLong1, paramLong2, paramTimeUnit);
    }
    localIterator = this.idleChildren.iterator();
    while (localIterator.hasNext()) {
      ((EventLoop)localIterator.next()).shutdownGracefully(paramLong1, paramLong2, paramTimeUnit);
    }
    if (isTerminated()) {
      this.terminationFuture.trySuccess(null);
    }
    return terminationFuture();
  }
  
  public Future<?> terminationFuture()
  {
    return this.terminationFuture;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ThreadPerChannelEventLoopGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */