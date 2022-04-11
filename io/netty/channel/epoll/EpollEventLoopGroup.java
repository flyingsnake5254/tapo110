package io.netty.channel.epoll;

import io.netty.channel.DefaultSelectStrategyFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.SelectStrategyFactory;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public final class EpollEventLoopGroup
  extends MultithreadEventLoopGroup
{
  public EpollEventLoopGroup()
  {
    this(0);
  }
  
  public EpollEventLoopGroup(int paramInt)
  {
    this(paramInt, null);
  }
  
  public EpollEventLoopGroup(int paramInt, SelectStrategyFactory paramSelectStrategyFactory)
  {
    this(paramInt, null, paramSelectStrategyFactory);
  }
  
  public EpollEventLoopGroup(int paramInt, Executor paramExecutor)
  {
    this(paramInt, paramExecutor, DefaultSelectStrategyFactory.INSTANCE);
  }
  
  public EpollEventLoopGroup(int paramInt, Executor paramExecutor, SelectStrategyFactory paramSelectStrategyFactory)
  {
    super(paramInt, paramExecutor, new Object[] { Integer.valueOf(0), paramSelectStrategyFactory, RejectedExecutionHandlers.reject() });
    Epoll.ensureAvailability();
  }
  
  public EpollEventLoopGroup(int paramInt, Executor paramExecutor, EventExecutorChooserFactory paramEventExecutorChooserFactory, SelectStrategyFactory paramSelectStrategyFactory)
  {
    super(paramInt, paramExecutor, paramEventExecutorChooserFactory, new Object[] { Integer.valueOf(0), paramSelectStrategyFactory, RejectedExecutionHandlers.reject() });
    Epoll.ensureAvailability();
  }
  
  public EpollEventLoopGroup(int paramInt, Executor paramExecutor, EventExecutorChooserFactory paramEventExecutorChooserFactory, SelectStrategyFactory paramSelectStrategyFactory, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramInt, paramExecutor, paramEventExecutorChooserFactory, new Object[] { Integer.valueOf(0), paramSelectStrategyFactory, paramRejectedExecutionHandler });
    Epoll.ensureAvailability();
  }
  
  public EpollEventLoopGroup(int paramInt, Executor paramExecutor, EventExecutorChooserFactory paramEventExecutorChooserFactory, SelectStrategyFactory paramSelectStrategyFactory, RejectedExecutionHandler paramRejectedExecutionHandler, EventLoopTaskQueueFactory paramEventLoopTaskQueueFactory)
  {
    super(paramInt, paramExecutor, paramEventExecutorChooserFactory, new Object[] { Integer.valueOf(0), paramSelectStrategyFactory, paramRejectedExecutionHandler, paramEventLoopTaskQueueFactory });
    Epoll.ensureAvailability();
  }
  
  public EpollEventLoopGroup(int paramInt, ThreadFactory paramThreadFactory)
  {
    this(paramInt, paramThreadFactory, 0);
  }
  
  @Deprecated
  public EpollEventLoopGroup(int paramInt1, ThreadFactory paramThreadFactory, int paramInt2)
  {
    this(paramInt1, paramThreadFactory, paramInt2, DefaultSelectStrategyFactory.INSTANCE);
  }
  
  @Deprecated
  public EpollEventLoopGroup(int paramInt1, ThreadFactory paramThreadFactory, int paramInt2, SelectStrategyFactory paramSelectStrategyFactory)
  {
    super(paramInt1, paramThreadFactory, new Object[] { Integer.valueOf(paramInt2), paramSelectStrategyFactory, RejectedExecutionHandlers.reject() });
    Epoll.ensureAvailability();
  }
  
  public EpollEventLoopGroup(int paramInt, ThreadFactory paramThreadFactory, SelectStrategyFactory paramSelectStrategyFactory)
  {
    this(paramInt, paramThreadFactory, 0, paramSelectStrategyFactory);
  }
  
  public EpollEventLoopGroup(ThreadFactory paramThreadFactory)
  {
    this(0, paramThreadFactory, 0);
  }
  
  protected EventLoop newChild(Executor paramExecutor, Object... paramVarArgs)
    throws Exception
  {
    EventLoopTaskQueueFactory localEventLoopTaskQueueFactory;
    if (paramVarArgs.length == 4) {
      localEventLoopTaskQueueFactory = (EventLoopTaskQueueFactory)paramVarArgs[3];
    } else {
      localEventLoopTaskQueueFactory = null;
    }
    return new EpollEventLoop(this, paramExecutor, ((Integer)paramVarArgs[0]).intValue(), ((SelectStrategyFactory)paramVarArgs[1]).newSelectStrategy(), (RejectedExecutionHandler)paramVarArgs[2], localEventLoopTaskQueueFactory);
  }
  
  @Deprecated
  public void setIoRatio(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 100)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ioRatio: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: 0 < ioRatio <= 100)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollEventLoopGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */