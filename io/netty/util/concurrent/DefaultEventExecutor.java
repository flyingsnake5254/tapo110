package io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public final class DefaultEventExecutor
  extends SingleThreadEventExecutor
{
  public DefaultEventExecutor()
  {
    this(null);
  }
  
  public DefaultEventExecutor(EventExecutorGroup paramEventExecutorGroup)
  {
    this(paramEventExecutorGroup, new DefaultThreadFactory(DefaultEventExecutor.class));
  }
  
  public DefaultEventExecutor(EventExecutorGroup paramEventExecutorGroup, Executor paramExecutor)
  {
    super(paramEventExecutorGroup, paramExecutor, true);
  }
  
  public DefaultEventExecutor(EventExecutorGroup paramEventExecutorGroup, Executor paramExecutor, int paramInt, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramEventExecutorGroup, paramExecutor, true, paramInt, paramRejectedExecutionHandler);
  }
  
  public DefaultEventExecutor(EventExecutorGroup paramEventExecutorGroup, ThreadFactory paramThreadFactory)
  {
    super(paramEventExecutorGroup, paramThreadFactory, true);
  }
  
  public DefaultEventExecutor(EventExecutorGroup paramEventExecutorGroup, ThreadFactory paramThreadFactory, int paramInt, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramEventExecutorGroup, paramThreadFactory, true, paramInt, paramRejectedExecutionHandler);
  }
  
  public DefaultEventExecutor(Executor paramExecutor)
  {
    this(null, paramExecutor);
  }
  
  public DefaultEventExecutor(ThreadFactory paramThreadFactory)
  {
    this(null, paramThreadFactory);
  }
  
  protected void run()
  {
    do
    {
      Runnable localRunnable = takeTask();
      if (localRunnable != null)
      {
        localRunnable.run();
        updateLastExecutionTime();
      }
    } while (!confirmShutdown());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\DefaultEventExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */