package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzfo
  implements Thread.UncaughtExceptionHandler
{
  private final String zzb;
  
  public zzfo(zzfr paramzzfr, String paramString)
  {
    Preconditions.checkNotNull(paramString);
    this.zzb = paramString;
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      this.zza.zzs.zzau().zzb().zzb(this.zzb, paramThrowable);
      return;
    }
    finally
    {
      paramThread = finally;
      throw paramThread;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */