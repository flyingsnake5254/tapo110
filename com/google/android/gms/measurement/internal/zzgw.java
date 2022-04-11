package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzcl;

@VisibleForTesting
public final class zzgw
{
  final Context zza;
  @Nullable
  String zzb;
  @Nullable
  String zzc;
  @Nullable
  String zzd;
  @Nullable
  Boolean zze;
  long zzf;
  @Nullable
  zzcl zzg;
  boolean zzh = true;
  @Nullable
  final Long zzi;
  @Nullable
  String zzj;
  
  @VisibleForTesting
  public zzgw(Context paramContext, @Nullable zzcl paramzzcl, @Nullable Long paramLong)
  {
    Preconditions.checkNotNull(paramContext);
    paramContext = paramContext.getApplicationContext();
    Preconditions.checkNotNull(paramContext);
    this.zza = paramContext;
    this.zzi = paramLong;
    if (paramzzcl != null)
    {
      this.zzg = paramzzcl;
      this.zzb = paramzzcl.zzf;
      this.zzc = paramzzcl.zze;
      this.zzd = paramzzcl.zzd;
      this.zzh = paramzzcl.zzc;
      this.zzf = paramzzcl.zzb;
      this.zzj = paramzzcl.zzh;
      paramContext = paramzzcl.zzg;
      if (paramContext != null) {
        this.zze = Boolean.valueOf(paramContext.getBoolean("dataCollectionDefaultEnabled", true));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzgw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */