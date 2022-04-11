package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgv;

final class zzdv
  extends zzch
{
  private final zzgv zza;
  
  zzdv(zzgv paramzzgv)
  {
    this.zza = paramzzgv;
  }
  
  public final void zzd(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    this.zza.onEvent(paramString1, paramString2, paramBundle, paramLong);
  }
  
  public final int zze()
  {
    return System.identityHashCode(this.zza);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzdv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */