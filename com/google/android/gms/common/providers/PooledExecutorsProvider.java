package com.google.android.gms.common.providers;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

@KeepForSdk
public class PooledExecutorsProvider
{
  private static PooledExecutorFactory zzey;
  
  @KeepForSdk
  public static PooledExecutorFactory getInstance()
  {
    try
    {
      if (zzey == null)
      {
        localObject1 = new com/google/android/gms/common/providers/zza;
        ((zza)localObject1).<init>();
        zzey = (PooledExecutorFactory)localObject1;
      }
      Object localObject1 = zzey;
      return (PooledExecutorFactory)localObject1;
    }
    finally {}
  }
  
  public static abstract interface PooledExecutorFactory
  {
    @KeepForSdk
    public abstract ScheduledExecutorService newSingleThreadScheduledExecutor();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\providers\PooledExecutorsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */