package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public abstract class SingleThreadEventLoop
  extends SingleThreadEventExecutor
  implements EventLoop
{
  protected static final int DEFAULT_MAX_PENDING_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventLoop.maxPendingTasks", Integer.MAX_VALUE));
  private final Queue<Runnable> tailTasks;
  
  protected SingleThreadEventLoop(EventLoopGroup paramEventLoopGroup, Executor paramExecutor, boolean paramBoolean)
  {
    this(paramEventLoopGroup, paramExecutor, paramBoolean, DEFAULT_MAX_PENDING_TASKS, RejectedExecutionHandlers.reject());
  }
  
  protected SingleThreadEventLoop(EventLoopGroup paramEventLoopGroup, Executor paramExecutor, boolean paramBoolean, int paramInt, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramEventLoopGroup, paramExecutor, paramBoolean, paramInt, paramRejectedExecutionHandler);
    this.tailTasks = newTaskQueue(paramInt);
  }
  
  protected SingleThreadEventLoop(EventLoopGroup paramEventLoopGroup, Executor paramExecutor, boolean paramBoolean, Queue<Runnable> paramQueue1, Queue<Runnable> paramQueue2, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramEventLoopGroup, paramExecutor, paramBoolean, paramQueue1, paramRejectedExecutionHandler);
    this.tailTasks = ((Queue)ObjectUtil.checkNotNull(paramQueue2, "tailTaskQueue"));
  }
  
  protected SingleThreadEventLoop(EventLoopGroup paramEventLoopGroup, ThreadFactory paramThreadFactory, boolean paramBoolean)
  {
    this(paramEventLoopGroup, paramThreadFactory, paramBoolean, DEFAULT_MAX_PENDING_TASKS, RejectedExecutionHandlers.reject());
  }
  
  protected SingleThreadEventLoop(EventLoopGroup paramEventLoopGroup, ThreadFactory paramThreadFactory, boolean paramBoolean, int paramInt, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramEventLoopGroup, paramThreadFactory, paramBoolean, paramInt, paramRejectedExecutionHandler);
    this.tailTasks = newTaskQueue(paramInt);
  }
  
  protected void afterRunningAllTasks()
  {
    runAllTasksFrom(this.tailTasks);
  }
  
  public final void executeAfterEventLoopIteration(Runnable paramRunnable)
  {
    ObjectUtil.checkNotNull(paramRunnable, "task");
    if (isShutdown()) {
      SingleThreadEventExecutor.reject();
    }
    if (!this.tailTasks.offer(paramRunnable)) {
      reject(paramRunnable);
    }
    if (wakesUpForTask(paramRunnable)) {
      wakeup(inEventLoop());
    }
  }
  
  protected boolean hasTasks()
  {
    boolean bool;
    if ((!super.hasTasks()) && (this.tailTasks.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public EventLoop next()
  {
    return (EventLoop)super.next();
  }
  
  public EventLoopGroup parent()
  {
    return (EventLoopGroup)super.parent();
  }
  
  public int pendingTasks()
  {
    return super.pendingTasks() + this.tailTasks.size();
  }
  
  public ChannelFuture register(Channel paramChannel)
  {
    return register(new DefaultChannelPromise(paramChannel, this));
  }
  
  @Deprecated
  public ChannelFuture register(Channel paramChannel, ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramChannelPromise, "promise");
    ObjectUtil.checkNotNull(paramChannel, "channel");
    paramChannel.unsafe().register(this, paramChannelPromise);
    return paramChannelPromise;
  }
  
  public ChannelFuture register(ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramChannelPromise, "promise");
    paramChannelPromise.channel().unsafe().register(this, paramChannelPromise);
    return paramChannelPromise;
  }
  
  public int registeredChannels()
  {
    return -1;
  }
  
  final boolean removeAfterEventLoopIterationTask(Runnable paramRunnable)
  {
    return this.tailTasks.remove(ObjectUtil.checkNotNull(paramRunnable, "task"));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\SingleThreadEventLoop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */