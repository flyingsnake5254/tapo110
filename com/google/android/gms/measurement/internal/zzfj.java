package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzr;
import java.util.List;

final class zzfj
  implements zzr
{
  zzfj(zzfl paramzzfl) {}
  
  public final void zza(int paramInt, String paramString, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    
    zzek localzzek;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            localzzek = this.zza.zzs.zzau().zzi();
          } else if (paramBoolean1) {
            localzzek = this.zza.zzs.zzau().zzf();
          } else if (!paramBoolean2) {
            localzzek = this.zza.zzs.zzau().zzh();
          } else {
            localzzek = this.zza.zzs.zzau().zze();
          }
        }
        else {
          localzzek = this.zza.zzs.zzau().zzk();
        }
      }
      else if (paramBoolean1) {
        localzzek = this.zza.zzs.zzau().zzc();
      } else if (!paramBoolean2) {
        localzzek = this.zza.zzs.zzau().zzd();
      } else {
        localzzek = this.zza.zzs.zzau().zzb();
      }
    }
    else {
      localzzek = this.zza.zzs.zzau().zzj();
    }
    paramInt = paramList.size();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          localzzek.zza(paramString);
          return;
        }
        localzzek.zzd(paramString, paramList.get(0), paramList.get(1), paramList.get(2));
        return;
      }
      localzzek.zzc(paramString, paramList.get(0), paramList.get(1));
      return;
    }
    localzzek.zzb(paramString, paramList.get(0));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */