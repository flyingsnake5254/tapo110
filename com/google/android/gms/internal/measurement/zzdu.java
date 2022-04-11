package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgu;

final class zzdu
  extends zzch
{
  private final zzgu zza;
  
  zzdu(zzgu paramzzgu)
  {
    this.zza = paramzzgu;
  }
  
  public final void zzd(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    this.zza.interceptEvent(paramString1, paramString2, paramBundle, paramLong);
  }
  
  public final int zze()
  {
    return System.identityHashCode(this.zza);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */