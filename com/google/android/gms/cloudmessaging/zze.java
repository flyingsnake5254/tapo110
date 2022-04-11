package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.internal.cloudmessaging.zzb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class zze
{
  @Nullable
  @GuardedBy("MessengerIpcClient.class")
  private static zze zza;
  private final Context zzb;
  private final ScheduledExecutorService zzc;
  @GuardedBy("this")
  private zzf zzd = new zzf(this, null);
  @GuardedBy("this")
  private int zze = 1;
  
  @VisibleForTesting
  private zze(Context paramContext, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.zzc = paramScheduledExecutorService;
    this.zzb = paramContext.getApplicationContext();
  }
  
  private final int zza()
  {
    try
    {
      int i = this.zze;
      this.zze = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static zze zza(Context paramContext)
  {
    try
    {
      if (zza == null)
      {
        zze localzze = new com/google/android/gms/cloudmessaging/zze;
        zzb localzzb = zza.zza();
        NamedThreadFactory localNamedThreadFactory = new com/google/android/gms/common/util/concurrent/NamedThreadFactory;
        localNamedThreadFactory.<init>("MessengerIpcClient");
        localzze.<init>(paramContext, localzzb.zza(1, localNamedThreadFactory, com.google.android.gms.internal.cloudmessaging.zzf.zzb));
        zza = localzze;
      }
      paramContext = zza;
      return paramContext;
    }
    finally {}
  }
  
  private final <T> Task<T> zza(zzq<T> paramzzq)
  {
    try
    {
      Object localObject;
      if (Log.isLoggable("MessengerIpcClient", 3))
      {
        String str = String.valueOf(paramzzq);
        int i = str.length();
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>(i + 9);
        ((StringBuilder)localObject).append("Queueing ");
        ((StringBuilder)localObject).append(str);
        Log.d("MessengerIpcClient", ((StringBuilder)localObject).toString());
      }
      if (!this.zzd.zza(paramzzq))
      {
        localObject = new com/google/android/gms/cloudmessaging/zzf;
        ((zzf)localObject).<init>(this, null);
        this.zzd = ((zzf)localObject);
        ((zzf)localObject).zza(paramzzq);
      }
      paramzzq = paramzzq.zzb.getTask();
      return paramzzq;
    }
    finally {}
  }
  
  public final Task<Void> zza(int paramInt, Bundle paramBundle)
  {
    return zza(new zzn(zza(), 2, paramBundle));
  }
  
  public final Task<Bundle> zzb(int paramInt, Bundle paramBundle)
  {
    return zza(new zzs(zza(), 1, paramBundle));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\cloudmessaging\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */