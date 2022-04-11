package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

final class zzfp<V>
  extends FutureTask<V>
  implements Comparable<zzfp<V>>
{
  final boolean zza;
  private final long zzc;
  private final String zzd;
  
  zzfp(zzfr paramzzfr, Runnable paramRunnable, boolean paramBoolean, String paramString)
  {
    super(paramRunnable, null);
    Preconditions.checkNotNull(paramString);
    long l = zzfr.zzs().getAndIncrement();
    this.zzc = l;
    this.zzd = paramString;
    this.zza = paramBoolean;
    if (l == Long.MAX_VALUE) {
      paramzzfr.zzs.zzau().zzb().zza("Tasks index overflow");
    }
  }
  
  zzfp(Callable<V> paramCallable, boolean paramBoolean, String paramString)
  {
    super(paramBoolean);
    Preconditions.checkNotNull("Task exception on worker thread");
    long l = zzfr.zzs().getAndIncrement();
    this.zzc = l;
    this.zzd = "Task exception on worker thread";
    this.zza = paramString;
    if (l == Long.MAX_VALUE) {
      paramCallable.zzs.zzau().zzb().zza("Tasks index overflow");
    }
  }
  
  protected final void setException(Throwable paramThrowable)
  {
    this.zzb.zzs.zzau().zzb().zzb(this.zzd, paramThrowable);
    if ((paramThrowable instanceof zzfn))
    {
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      if (localUncaughtExceptionHandler != null) {
        localUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), paramThrowable);
      }
    }
    super.setException(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */