package com.google.android.gms.internal.cloudmessaging;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzc
  implements zzb
{
  public final ExecutorService zza(ThreadFactory paramThreadFactory, int paramInt)
  {
    paramThreadFactory = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), paramThreadFactory);
    paramThreadFactory.allowCoreThreadTimeOut(true);
    return Executors.unconfigurableExecutorService(paramThreadFactory);
  }
  
  public final ScheduledExecutorService zza(int paramInt1, ThreadFactory paramThreadFactory, int paramInt2)
  {
    return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, paramThreadFactory));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\cloudmessaging\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */