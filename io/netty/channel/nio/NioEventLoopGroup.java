package io.netty.channel.nio;

import io.netty.channel.DefaultSelectStrategyFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.SelectStrategyFactory;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.MultithreadEventExecutorGroup;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public class NioEventLoopGroup
  extends MultithreadEventLoopGroup
{
  public NioEventLoopGroup()
  {
    this(0);
  }
  
  public NioEventLoopGroup(int paramInt)
  {
    this(paramInt, null);
  }
  
  public NioEventLoopGroup(int paramInt, Executor paramExecutor)
  {
    this(paramInt, paramExecutor, SelectorProvider.provider());
  }
  
  public NioEventLoopGroup(int paramInt, Executor paramExecutor, EventExecutorChooserFactory paramEventExecutorChooserFactory, SelectorProvider paramSelectorProvider, SelectStrategyFactory paramSelectStrategyFactory)
  {
    super(paramInt, paramExecutor, paramEventExecutorChooserFactory, new Object[] { paramSelectorProvider, paramSelectStrategyFactory, RejectedExecutionHandlers.reject() });
  }
  
  public NioEventLoopGroup(int paramInt, Executor paramExecutor, EventExecutorChooserFactory paramEventExecutorChooserFactory, SelectorProvider paramSelectorProvider, SelectStrategyFactory paramSelectStrategyFactory, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramInt, paramExecutor, paramEventExecutorChooserFactory, new Object[] { paramSelectorProvider, paramSelectStrategyFactory, paramRejectedExecutionHandler });
  }
  
  public NioEventLoopGroup(int paramInt, Executor paramExecutor, EventExecutorChooserFactory paramEventExecutorChooserFactory, SelectorProvider paramSelectorProvider, SelectStrategyFactory paramSelectStrategyFactory, RejectedExecutionHandler paramRejectedExecutionHandler, EventLoopTaskQueueFactory paramEventLoopTaskQueueFactory)
  {
    super(paramInt, paramExecutor, paramEventExecutorChooserFactory, new Object[] { paramSelectorProvider, paramSelectStrategyFactory, paramRejectedExecutionHandler, paramEventLoopTaskQueueFactory });
  }
  
  public NioEventLoopGroup(int paramInt, Executor paramExecutor, SelectorProvider paramSelectorProvider)
  {
    this(paramInt, paramExecutor, paramSelectorProvider, DefaultSelectStrategyFactory.INSTANCE);
  }
  
  public NioEventLoopGroup(int paramInt, Executor paramExecutor, SelectorProvider paramSelectorProvider, SelectStrategyFactory paramSelectStrategyFactory)
  {
    super(paramInt, paramExecutor, new Object[] { paramSelectorProvider, paramSelectStrategyFactory, RejectedExecutionHandlers.reject() });
  }
  
  public NioEventLoopGroup(int paramInt, ThreadFactory paramThreadFactory)
  {
    this(paramInt, paramThreadFactory, SelectorProvider.provider());
  }
  
  public NioEventLoopGroup(int paramInt, ThreadFactory paramThreadFactory, SelectorProvider paramSelectorProvider)
  {
    this(paramInt, paramThreadFactory, paramSelectorProvider, DefaultSelectStrategyFactory.INSTANCE);
  }
  
  public NioEventLoopGroup(int paramInt, ThreadFactory paramThreadFactory, SelectorProvider paramSelectorProvider, SelectStrategyFactory paramSelectStrategyFactory)
  {
    super(paramInt, paramThreadFactory, new Object[] { paramSelectorProvider, paramSelectStrategyFactory, RejectedExecutionHandlers.reject() });
  }
  
  public NioEventLoopGroup(ThreadFactory paramThreadFactory)
  {
    this(0, paramThreadFactory, SelectorProvider.provider());
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
    return new NioEventLoop(this, paramExecutor, (SelectorProvider)paramVarArgs[0], ((SelectStrategyFactory)paramVarArgs[1]).newSelectStrategy(), (RejectedExecutionHandler)paramVarArgs[2], localEventLoopTaskQueueFactory);
  }
  
  public void rebuildSelectors()
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((NioEventLoop)localIterator.next()).rebuildSelector();
    }
  }
  
  public void setIoRatio(int paramInt)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((NioEventLoop)localIterator.next()).setIoRatio(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\nio\NioEventLoopGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */