package com.google.android.gms.internal.vision;

import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzg
  implements zzf
{
  @NonNull
  public final ExecutorService zza(int paramInt1, int paramInt2)
  {
    Object localObject = Executors.defaultThreadFactory();
    localObject = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), (ThreadFactory)localObject);
    ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    return Executors.unconfigurableExecutorService((ExecutorService)localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */