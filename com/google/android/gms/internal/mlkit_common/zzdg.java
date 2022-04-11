package com.google.android.gms.internal.mlkit_common;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.a.a;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.e;
import com.google.mlkit.common.sdkinternal.m;

public final class zzdg
{
  public static final Component<?> zza = Component.builder(zza.class).add(Dependency.required(zzdb.class)).add(Dependency.required(m.class)).factory(zzdf.zza).build();
  private static final GmsLogger zzb = new GmsLogger("ModelDownloadLogger", "");
  private final zzdb zzc;
  private final a zzd;
  private final m zze;
  
  private zzdg(@NonNull zzdb paramzzdb, @NonNull m paramm, @NonNull a parama)
  {
    this.zzc = paramzzdb;
    this.zzd = parama;
    this.zze = paramm;
  }
  
  private final void zza(zzal paramzzal, String paramString, boolean paramBoolean1, boolean paramBoolean2, ModelType paramModelType, zzaa.zzak.zzb paramzzb, int paramInt)
  {
    Object localObject = this.zzd;
    String str = ((a)localObject).a();
    zzaa.zzal.zza localzza = zzdj.zza(paramModelType);
    zzaa.zzam.zzb localzzb = zzaa.zzam.zza();
    localObject = zzaa.zzal.zza().zza(((a)localObject).b()).zza(zzaa.zzal.zzc.zza);
    paramModelType = str;
    if (str == null) {
      paramModelType = "";
    }
    paramModelType = (zzaa.zzam)localzzb.zza(((zzaa.zzal.zzb)localObject).zzb(paramModelType).zza(localzza)).zzh();
    paramzzal = zzaa.zzak.zza().zza(paramzzal).zza(paramzzb).zzc(paramInt).zza(paramModelType);
    long l3;
    if (paramBoolean1)
    {
      long l1 = this.zze.b(this.zzd);
      if (l1 == 0L)
      {
        zzb.w("ModelDownloadLogger", "Model downloaded without its beginning time recorded.");
      }
      else
      {
        long l2 = this.zze.c(this.zzd);
        l3 = l2;
        if (l2 == 0L)
        {
          l3 = SystemClock.elapsedRealtime();
          this.zze.d(this.zzd, l3);
        }
        paramzzal.zza(l3 - l1);
      }
    }
    if (paramBoolean2)
    {
      l3 = this.zze.b(this.zzd);
      if (l3 == 0L) {
        zzb.w("ModelDownloadLogger", "Model downloaded without its beginning time recorded.");
      } else {
        paramzzal.zzb(SystemClock.elapsedRealtime() - l3);
      }
    }
    this.zzc.zza(zzaa.zzad.zzb().zza(zzaa.zzbg.zzb().zzd(paramString)).zza(paramzzal), zzap.zza);
  }
  
  public final void zza(int paramInt1, ModelType paramModelType, int paramInt2)
  {
    zza(zzdk.zza(0), "NA", false, true, paramModelType, zzdi.zza(6), 0);
  }
  
  public final void zza(int paramInt1, boolean paramBoolean, ModelType paramModelType, int paramInt2)
  {
    zza(zzdk.zza(paramInt1), "NA", paramBoolean, false, paramModelType, zzdi.zza(paramInt2), 0);
  }
  
  public final void zza(boolean paramBoolean, ModelType paramModelType, int paramInt)
  {
    zza(zzal.zzn, "NA", false, false, paramModelType, zzaa.zzak.zzb.zzh, paramInt);
  }
  
  public static class zza
    extends e<a, zzdg>
  {
    private final zzdb zza;
    private final m zzb;
    
    private zza(zzdb paramzzdb, m paramm)
    {
      this.zza = paramzzdb;
      this.zzb = paramm;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzdg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */