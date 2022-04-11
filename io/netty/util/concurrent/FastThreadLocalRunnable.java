package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;

final class FastThreadLocalRunnable
  implements Runnable
{
  private final Runnable runnable;
  
  private FastThreadLocalRunnable(Runnable paramRunnable)
  {
    this.runnable = ((Runnable)ObjectUtil.checkNotNull(paramRunnable, "runnable"));
  }
  
  static Runnable wrap(Runnable paramRunnable)
  {
    if (!(paramRunnable instanceof FastThreadLocalRunnable)) {
      paramRunnable = new FastThreadLocalRunnable(paramRunnable);
    }
    return paramRunnable;
  }
  
  public void run()
  {
    try
    {
      this.runnable.run();
      return;
    }
    finally
    {
      FastThreadLocal.removeAll();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\FastThreadLocalRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */