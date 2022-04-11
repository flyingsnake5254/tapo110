package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzav
  extends zzaw
{
  public zzav()
  {
    this.zza.add(zzbl.zze);
    this.zza.add(zzbl.zzf);
    this.zza.add(zzbl.zzg);
    this.zza.add(zzbl.zzh);
    this.zza.add(zzbl.zzi);
    this.zza.add(zzbl.zzj);
    this.zza.add(zzbl.zzk);
  }
  
  public final zzap zza(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    zzbl localzzbl = zzbl.zza;
    switch (zzh.zze(paramString).ordinal())
    {
    default: 
      return super.zzb(paramString);
    case 10: 
      zzh.zza(zzbl.zzk.name(), 2, paramList);
      return new zzah(Double.valueOf(zzh.zzg(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue()) ^ zzh.zzg(paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue())));
    case 9: 
      zzh.zza(zzbl.zzj.name(), 2, paramList);
      return new zzah(Double.valueOf(zzh.zzh(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue()) >>> (int)(zzh.zzh(paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue()) & 0x1F)));
    case 8: 
      zzh.zza(zzbl.zzi.name(), 2, paramList);
      return new zzah(Double.valueOf(zzh.zzg(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue()) >> (int)(zzh.zzh(paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue()) & 0x1F)));
    case 7: 
      zzh.zza(zzbl.zzh.name(), 2, paramList);
      return new zzah(Double.valueOf(zzh.zzg(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue()) | zzh.zzg(paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue())));
    case 6: 
      zzh.zza(zzbl.zzg.name(), 1, paramList);
      return new zzah(Double.valueOf(zzh.zzg(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue()) ^ 0xFFFFFFFF));
    case 5: 
      zzh.zza(zzbl.zzf.name(), 2, paramList);
      return new zzah(Double.valueOf(zzh.zzg(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue()) << (int)(zzh.zzh(paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue()) & 0x1F)));
    }
    zzh.zza(zzbl.zze.name(), 2, paramList);
    return new zzah(Double.valueOf(zzh.zzg(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue()) & zzh.zzg(paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue())));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */