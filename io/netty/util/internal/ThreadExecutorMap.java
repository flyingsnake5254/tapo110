package io.netty.util.internal;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.FastThreadLocal;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public final class ThreadExecutorMap
{
  private static final FastThreadLocal<EventExecutor> mappings = new FastThreadLocal();
  
  public static Runnable apply(final Runnable paramRunnable, EventExecutor paramEventExecutor)
  {
    ObjectUtil.checkNotNull(paramRunnable, "command");
    ObjectUtil.checkNotNull(paramEventExecutor, "eventExecutor");
    new Runnable()
    {
      public void run()
      {
        ThreadExecutorMap.setCurrentEventExecutor(this.val$eventExecutor);
        try
        {
          paramRunnable.run();
          return;
        }
        finally
        {
          ThreadExecutorMap.setCurrentEventExecutor(null);
        }
      }
    };
  }
  
  public static Executor apply(Executor paramExecutor, final EventExecutor paramEventExecutor)
  {
    ObjectUtil.checkNotNull(paramExecutor, "executor");
    ObjectUtil.checkNotNull(paramEventExecutor, "eventExecutor");
    new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        this.val$executor.execute(ThreadExecutorMap.apply(paramAnonymousRunnable, paramEventExecutor));
      }
    };
  }
  
  public static ThreadFactory apply(ThreadFactory paramThreadFactory, final EventExecutor paramEventExecutor)
  {
    ObjectUtil.checkNotNull(paramThreadFactory, "command");
    ObjectUtil.checkNotNull(paramEventExecutor, "eventExecutor");
    new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        return this.val$threadFactory.newThread(ThreadExecutorMap.apply(paramAnonymousRunnable, paramEventExecutor));
      }
    };
  }
  
  public static EventExecutor currentExecutor()
  {
    return (EventExecutor)mappings.get();
  }
  
  private static void setCurrentEventExecutor(EventExecutor paramEventExecutor)
  {
    mappings.set(paramEventExecutor);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\ThreadExecutorMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */