package io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class j
{
  public static final boolean a;
  public static final int b;
  static final AtomicReference<ScheduledExecutorService> c = new AtomicReference();
  static final Map<ScheduledThreadPoolExecutor, Object> d = new ConcurrentHashMap();
  
  static
  {
    b localb = new b();
    boolean bool = b(true, "rx2.purge-enabled", true, true, localb);
    a = bool;
    b = c(bool, "rx2.purge-period-seconds", 1, 1, localb);
    d();
  }
  
  public static ScheduledExecutorService a(ThreadFactory paramThreadFactory)
  {
    paramThreadFactory = Executors.newScheduledThreadPool(1, paramThreadFactory);
    e(a, paramThreadFactory);
    return paramThreadFactory;
  }
  
  static boolean b(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, io.reactivex.g0.j<String, String> paramj)
  {
    if (paramBoolean1) {
      try
      {
        paramString = (String)paramj.apply(paramString);
        if (paramString == null) {
          return paramBoolean2;
        }
        paramBoolean1 = "true".equals(paramString);
      }
      finally
      {
        return paramBoolean2;
      }
    }
    return paramBoolean3;
  }
  
  static int c(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, io.reactivex.g0.j<String, String> paramj)
  {
    if (paramBoolean) {
      try
      {
        paramString = (String)paramj.apply(paramString);
        if (paramString == null) {
          return paramInt1;
        }
        paramInt2 = Integer.parseInt(paramString);
      }
      finally
      {
        return paramInt1;
      }
    }
    return paramInt2;
  }
  
  public static void d()
  {
    f(a);
  }
  
  static void e(boolean paramBoolean, ScheduledExecutorService paramScheduledExecutorService)
  {
    if ((paramBoolean) && ((paramScheduledExecutorService instanceof ScheduledThreadPoolExecutor)))
    {
      ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)paramScheduledExecutorService;
      d.put(localScheduledThreadPoolExecutor, paramScheduledExecutorService);
    }
  }
  
  static void f(boolean paramBoolean)
  {
    if (paramBoolean) {
      for (;;)
      {
        AtomicReference localAtomicReference = c;
        Object localObject = (ScheduledExecutorService)localAtomicReference.get();
        if (localObject != null) {
          return;
        }
        ScheduledExecutorService localScheduledExecutorService = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
        if (localAtomicReference.compareAndSet(localObject, localScheduledExecutorService))
        {
          localObject = new a();
          int i = b;
          localScheduledExecutorService.scheduleAtFixedRate((Runnable)localObject, i, i, TimeUnit.SECONDS);
          return;
        }
        localScheduledExecutorService.shutdownNow();
      }
    }
  }
  
  static final class a
    implements Runnable
  {
    public void run()
    {
      Iterator localIterator = new ArrayList(j.d.keySet()).iterator();
      while (localIterator.hasNext())
      {
        ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)localIterator.next();
        if (localScheduledThreadPoolExecutor.isShutdown()) {
          j.d.remove(localScheduledThreadPoolExecutor);
        } else {
          localScheduledThreadPoolExecutor.purge();
        }
      }
    }
  }
  
  static final class b
    implements io.reactivex.g0.j<String, String>
  {
    public String a(String paramString)
      throws Exception
    {
      return System.getProperty(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\schedulers\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */