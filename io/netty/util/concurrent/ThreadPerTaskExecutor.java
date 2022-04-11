package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public final class ThreadPerTaskExecutor
  implements Executor
{
  private final ThreadFactory threadFactory;
  
  public ThreadPerTaskExecutor(ThreadFactory paramThreadFactory)
  {
    this.threadFactory = ((ThreadFactory)ObjectUtil.checkNotNull(paramThreadFactory, "threadFactory"));
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.threadFactory.newThread(paramRunnable).start();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\ThreadPerTaskExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */