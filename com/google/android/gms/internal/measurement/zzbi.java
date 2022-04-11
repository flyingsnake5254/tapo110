package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzbi
  extends zzaw
{
  protected zzbi()
  {
    this.zza.add(zzbl.zza);
    this.zza.add(zzbl.zzv);
    this.zza.add(zzbl.zzS);
    this.zza.add(zzbl.zzT);
    this.zza.add(zzbl.zzU);
    this.zza.add(zzbl.zzaa);
    this.zza.add(zzbl.zzab);
    this.zza.add(zzbl.zzad);
    this.zza.add(zzbl.zzae);
    this.zza.add(zzbl.zzah);
  }
  
  public final zzap zza(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    zzbl localzzbl = zzbl.zza;
    int i = zzh.zze(paramString).ordinal();
    if (i != 0)
    {
      if (i != 21)
      {
        if (i != 59)
        {
          if ((i != 52) && (i != 53))
          {
            if ((i != 55) && (i != 56))
            {
              switch (i)
              {
              default: 
                return super.zzb(paramString);
              case 46: 
                zzh.zza(zzbl.zzU.name(), 1, paramList);
                return new zzah(Double.valueOf(-paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue()));
              case 45: 
                zzh.zza(zzbl.zzT.name(), 2, paramList);
                return new zzah(Double.valueOf(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue() * paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue()));
              }
              zzh.zza(zzbl.zzS.name(), 2, paramList);
              return new zzah(Double.valueOf(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue() % paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue()));
            }
            zzh.zza(paramString, 1, paramList);
            return paramzzg.zza((zzap)paramList.get(0));
          }
          zzh.zza(paramString, 2, paramList);
          paramString = paramzzg.zza((zzap)paramList.get(0));
          paramzzg.zza((zzap)paramList.get(1));
          return paramString;
        }
        zzh.zza(zzbl.zzah.name(), 2, paramList);
        paramString = paramzzg.zza((zzap)paramList.get(0));
        paramzzg = new zzah(Double.valueOf(-paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue()));
        return new zzah(Double.valueOf(paramString.zzd().doubleValue() + paramzzg.zzd().doubleValue()));
      }
      zzh.zza(zzbl.zzv.name(), 2, paramList);
      return new zzah(Double.valueOf(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue() / paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue()));
    }
    zzh.zza(localzzbl.name(), 2, paramList);
    paramString = paramzzg.zza((zzap)paramList.get(0));
    paramzzg = paramzzg.zza((zzap)paramList.get(1));
    if ((!(paramString instanceof zzal)) && (!(paramString instanceof zzat)) && (!(paramzzg instanceof zzal)) && (!(paramzzg instanceof zzat)))
    {
      paramString = new zzah(Double.valueOf(paramString.zzd().doubleValue() + paramzzg.zzd().doubleValue()));
    }
    else
    {
      paramString = String.valueOf(paramString.zzc());
      paramzzg = String.valueOf(paramzzg.zzc());
      if (paramzzg.length() != 0) {
        paramString = paramString.concat(paramzzg);
      } else {
        paramString = new String(paramString);
      }
      paramString = new zzat(paramString);
    }
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */