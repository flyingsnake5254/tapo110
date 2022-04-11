package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class ScheduledDirectTask
  extends a
  implements Callable<Void>
{
  private static final long serialVersionUID = 1811839108042568751L;
  
  public ScheduledDirectTask(Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  public Void call()
    throws Exception
  {
    this.runner = Thread.currentThread();
    try
    {
      this.runnable.run();
      return null;
    }
    finally
    {
      lazySet(a.FINISHED);
      this.runner = null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\ScheduledDirectTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */