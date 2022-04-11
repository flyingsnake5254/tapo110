package com.google.firebase.analytics;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.measurement.zzee;
import com.google.android.gms.measurement.internal.zzgu;
import com.google.android.gms.measurement.internal.zzgv;
import com.google.android.gms.measurement.internal.zzhx;
import java.util.List;
import java.util.Map;

final class zzc
  implements zzhx
{
  zzc(zzee paramzzee) {}
  
  public final void zza(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.zza.zzh(paramString1, paramString2, paramBundle);
  }
  
  public final void zzb(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    this.zza.zzi(paramString1, paramString2, paramBundle, paramLong);
  }
  
  public final Map<String, Object> zzc(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    return this.zza.zzB(paramString1, paramString2, paramBoolean);
  }
  
  public final void zzd(zzgu paramzzgu)
  {
    this.zza.zzd(paramzzgu);
  }
  
  public final void zze(zzgv paramzzgv)
  {
    this.zza.zze(paramzzgv);
  }
  
  public final void zzf(zzgv paramzzgv)
  {
    this.zza.zzf(paramzzgv);
  }
  
  @Nullable
  public final String zzg()
  {
    return this.zza.zzz();
  }
  
  @Nullable
  public final String zzh()
  {
    return this.zza.zzA();
  }
  
  @Nullable
  public final String zzi()
  {
    return this.zza.zzx();
  }
  
  @Nullable
  public final String zzj()
  {
    return this.zza.zzw();
  }
  
  public final long zzk()
  {
    return this.zza.zzy();
  }
  
  public final void zzl(String paramString)
  {
    this.zza.zzu(paramString);
  }
  
  public final void zzm(String paramString)
  {
    this.zza.zzv(paramString);
  }
  
  public final void zzn(Bundle paramBundle)
  {
    this.zza.zzk(paramBundle);
  }
  
  public final void zzo(String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle)
  {
    this.zza.zzl(paramString1, paramString2, paramBundle);
  }
  
  public final List<Bundle> zzp(@Nullable String paramString1, @Nullable String paramString2)
  {
    return this.zza.zzm(paramString1, paramString2);
  }
  
  public final int zzq(String paramString)
  {
    return this.zza.zzE(paramString);
  }
  
  @Nullable
  public final Object zzr(int paramInt)
  {
    return this.zza.zzH(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\analytics\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */