package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

final class zzkk
  implements Runnable
{
  zzkk(zzkl paramzzkl, String paramString1, String paramString2, Bundle paramBundle) {}
  
  public final void run()
  {
    zzas localzzas = this.zzd.zza.zzq().zzV(this.zza, this.zzb, this.zzc, "auto", this.zzd.zza.zzay().currentTimeMillis(), false, false);
    this.zzd.zza.zzv((zzas)Preconditions.checkNotNull(localzzas), this.zza);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzkk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */