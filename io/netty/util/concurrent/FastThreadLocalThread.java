package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;

public class FastThreadLocalThread
  extends Thread
{
  private final boolean cleanupFastThreadLocals;
  private InternalThreadLocalMap threadLocalMap;
  
  public FastThreadLocalThread()
  {
    this.cleanupFastThreadLocals = false;
  }
  
  public FastThreadLocalThread(Runnable paramRunnable)
  {
    super(FastThreadLocalRunnable.wrap(paramRunnable));
    this.cleanupFastThreadLocals = true;
  }
  
  public FastThreadLocalThread(Runnable paramRunnable, String paramString)
  {
    super(FastThreadLocalRunnable.wrap(paramRunnable), paramString);
    this.cleanupFastThreadLocals = true;
  }
  
  public FastThreadLocalThread(String paramString)
  {
    super(paramString);
    this.cleanupFastThreadLocals = false;
  }
  
  public FastThreadLocalThread(ThreadGroup paramThreadGroup, Runnable paramRunnable)
  {
    super(paramThreadGroup, FastThreadLocalRunnable.wrap(paramRunnable));
    this.cleanupFastThreadLocals = true;
  }
  
  public FastThreadLocalThread(ThreadGroup paramThreadGroup, Runnable paramRunnable, String paramString)
  {
    super(paramThreadGroup, FastThreadLocalRunnable.wrap(paramRunnable), paramString);
    this.cleanupFastThreadLocals = true;
  }
  
  public FastThreadLocalThread(ThreadGroup paramThreadGroup, Runnable paramRunnable, String paramString, long paramLong)
  {
    super(paramThreadGroup, FastThreadLocalRunnable.wrap(paramRunnable), paramString, paramLong);
    this.cleanupFastThreadLocals = true;
  }
  
  public FastThreadLocalThread(ThreadGroup paramThreadGroup, String paramString)
  {
    super(paramThreadGroup, paramString);
    this.cleanupFastThreadLocals = false;
  }
  
  public static boolean willCleanupFastThreadLocals(Thread paramThread)
  {
    boolean bool;
    if (((paramThread instanceof FastThreadLocalThread)) && (((FastThreadLocalThread)paramThread).willCleanupFastThreadLocals())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void setThreadLocalMap(InternalThreadLocalMap paramInternalThreadLocalMap)
  {
    this.threadLocalMap = paramInternalThreadLocalMap;
  }
  
  public final InternalThreadLocalMap threadLocalMap()
  {
    return this.threadLocalMap;
  }
  
  public boolean willCleanupFastThreadLocals()
  {
    return this.cleanupFastThreadLocals;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\FastThreadLocalThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */