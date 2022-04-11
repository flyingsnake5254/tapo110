package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzbc
  extends zzaw
{
  protected zzbc()
  {
    this.zza.add(zzbl.zzb);
    this.zza.add(zzbl.zzV);
    this.zza.add(zzbl.zzY);
  }
  
  public final zzap zza(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    zzbl localzzbl = zzbl.zza;
    int i = zzh.zze(paramString).ordinal();
    if (i != 1)
    {
      if (i != 47)
      {
        if (i != 50) {
          return super.zzb(paramString);
        }
        zzh.zza(zzbl.zzY.name(), 2, paramList);
        paramString = paramzzg.zza((zzap)paramList.get(0));
        if (paramString.zze().booleanValue()) {
          return paramString;
        }
        return paramzzg.zza((zzap)paramList.get(1));
      }
      zzh.zza(zzbl.zzV.name(), 1, paramList);
      return new zzaf(Boolean.valueOf(paramzzg.zza((zzap)paramList.get(0)).zze().booleanValue() ^ true));
    }
    zzh.zza(zzbl.zzb.name(), 2, paramList);
    paramString = paramzzg.zza((zzap)paramList.get(0));
    if (!paramString.zze().booleanValue()) {
      return paramString;
    }
    return paramzzg.zza((zzap)paramList.get(1));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */