package io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public class DefaultEventExecutorGroup
  extends MultithreadEventExecutorGroup
{
  public DefaultEventExecutorGroup(int paramInt)
  {
    this(paramInt, null);
  }
  
  public DefaultEventExecutorGroup(int paramInt, ThreadFactory paramThreadFactory)
  {
    this(paramInt, paramThreadFactory, SingleThreadEventExecutor.DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
  }
  
  public DefaultEventExecutorGroup(int paramInt1, ThreadFactory paramThreadFactory, int paramInt2, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramInt1, paramThreadFactory, new Object[] { Integer.valueOf(paramInt2), paramRejectedExecutionHandler });
  }
  
  protected EventExecutor newChild(Executor paramExecutor, Object... paramVarArgs)
    throws Exception
  {
    return new DefaultEventExecutor(this, paramExecutor, ((Integer)paramVarArgs[0]).intValue(), (RejectedExecutionHandler)paramVarArgs[1]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\DefaultEventExecutorGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */