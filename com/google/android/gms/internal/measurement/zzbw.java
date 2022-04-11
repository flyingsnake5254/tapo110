package com.google.android.gms.internal.measurement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzbw
  implements zzbu
{
  public static final ExecutorService zzc(int paramInt1, ThreadFactory paramThreadFactory, int paramInt2)
  {
    paramThreadFactory = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), paramThreadFactory);
    paramThreadFactory.allowCoreThreadTimeOut(true);
    return Executors.unconfigurableExecutorService(paramThreadFactory);
  }
  
  public final ExecutorService zza(int paramInt)
  {
    return zzc(1, Executors.defaultThreadFactory(), 1);
  }
  
  public final ExecutorService zzb(ThreadFactory paramThreadFactory, int paramInt)
  {
    return zzc(1, paramThreadFactory, 1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzbw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */