package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzu;
import java.util.Deque;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public class k
  extends zzu
{
  private static final ThreadLocal<Deque<Runnable>> c = new u();
  private final ExecutorService d = new ThreadPoolExecutor(0, Runtime.getRuntime().availableProcessors(), 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new t(this));
  private final ThreadFactory f = Executors.defaultThreadFactory();
  @GuardedBy("threadPoolThreads")
  private final WeakHashMap<Thread, Void> q = new WeakHashMap();
  
  private final Thread c(Runnable arg1)
  {
    Thread localThread = this.f.newThread(???);
    synchronized (this.q)
    {
      this.q.put(localThread, null);
      return localThread;
    }
  }
  
  private static void d(Runnable paramRunnable)
  {
    Deque localDeque = (Deque)c.get();
    localDeque.add(paramRunnable);
    if (localDeque.size() > 1) {
      return;
    }
    Runnable localRunnable;
    do
    {
      paramRunnable.run();
      localDeque.removeFirst();
      localRunnable = (Runnable)localDeque.peekFirst();
      paramRunnable = localRunnable;
    } while (localRunnable != null);
  }
  
  public void execute(Runnable paramRunnable)
  {
    synchronized (this.q)
    {
      boolean bool = this.q.containsKey(Thread.currentThread());
      if (bool)
      {
        d(paramRunnable);
        return;
      }
      this.d.execute(new v(paramRunnable));
      return;
    }
  }
  
  protected final ExecutorService zzb()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */