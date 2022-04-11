package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzby;

public final class zzjz
  extends zzf
{
  protected final zzjy zza = new zzjy(this);
  protected final zzjx zzb = new zzjx(this);
  protected final zzjv zzc = new zzjv(this);
  private Handler zzd;
  
  zzjz(zzfu paramzzfu)
  {
    super(paramzzfu);
  }
  
  @WorkerThread
  private final void zzl()
  {
    zzg();
    if (this.zzd == null) {
      this.zzd = new zzby(Looper.getMainLooper());
    }
  }
  
  protected final boolean zze()
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzjz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */