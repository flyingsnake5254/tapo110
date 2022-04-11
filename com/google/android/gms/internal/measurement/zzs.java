package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzs
  extends zzai
{
  final boolean zza;
  final boolean zzb;
  
  public zzs(zzt paramzzt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super("log");
    this.zza = paramBoolean1;
    this.zzb = paramBoolean2;
  }
  
  public final zzap zza(zzg paramzzg, List<zzap> paramList)
  {
    zzh.zzb("log", 1, paramList);
    if (paramList.size() == 1)
    {
      zzt.zzb(this.zzc).zza(3, paramzzg.zza((zzap)paramList.get(0)).zzc(), Collections.emptyList(), this.zza, this.zzb);
      return zzap.zzf;
    }
    int i = zzh.zzg(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue());
    int j = 2;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 5)
        {
          if (i != 6) {
            i = 3;
          } else {
            i = 2;
          }
        }
        else {
          i = 5;
        }
      }
      else {
        i = 1;
      }
    }
    else {
      i = 4;
    }
    String str = paramzzg.zza((zzap)paramList.get(1)).zzc();
    if (paramList.size() == 2)
    {
      zzt.zzb(this.zzc).zza(i, str, Collections.emptyList(), this.zza, this.zzb);
      return zzap.zzf;
    }
    ArrayList localArrayList = new ArrayList();
    while (j < Math.min(paramList.size(), 5))
    {
      localArrayList.add(paramzzg.zza((zzap)paramList.get(j)).zzc());
      j++;
    }
    zzt.zzb(this.zzc).zza(i, str, localArrayList, this.zza, this.zzb);
    return zzap.zzf;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */