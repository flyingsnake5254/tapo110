package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public final class RejectedExecutionHandlers
{
  private static final RejectedExecutionHandler REJECT = new RejectedExecutionHandler()
  {
    public void rejected(Runnable paramAnonymousRunnable, SingleThreadEventExecutor paramAnonymousSingleThreadEventExecutor)
    {
      throw new RejectedExecutionException();
    }
  };
  
  public static RejectedExecutionHandler backoff(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    ObjectUtil.checkPositive(paramInt, "retries");
    new RejectedExecutionHandler()
    {
      public void rejected(Runnable paramAnonymousRunnable, SingleThreadEventExecutor paramAnonymousSingleThreadEventExecutor)
      {
        if (!paramAnonymousSingleThreadEventExecutor.inEventLoop()) {
          for (int i = 0; i < this.val$retries; i++)
          {
            paramAnonymousSingleThreadEventExecutor.wakeup(false);
            LockSupport.parkNanos(this.val$backOffNanos);
            if (paramAnonymousSingleThreadEventExecutor.offerTask(paramAnonymousRunnable)) {
              return;
            }
          }
        }
        throw new RejectedExecutionException();
      }
    };
  }
  
  public static RejectedExecutionHandler reject()
  {
    return REJECT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\RejectedExecutionHandlers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */