package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzl
  extends zzam
{
  private final zzab zzb;
  
  public zzl(zzab paramzzab)
  {
    this.zzb = paramzzab;
  }
  
  public final zzap zzbK(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1570616835: 
      if (paramString.equals("setEventName")) {
        i = 4;
      }
      break;
    case 920706790: 
      if (paramString.equals("setParamValue")) {
        i = 5;
      }
      break;
    case 700587132: 
      if (paramString.equals("getParams")) {
        i = 2;
      }
      break;
    case 146575578: 
      if (paramString.equals("getParamValue")) {
        i = 1;
      }
      break;
    case 45521504: 
      if (paramString.equals("getTimestamp")) {
        i = 3;
      }
      break;
    case 21624207: 
      if (paramString.equals("getEventName")) {
        i = 0;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return super.zzbK(paramString, paramzzg, paramList);
              }
              zzh.zza("setParamValue", 2, paramList);
              paramString = paramzzg.zza((zzap)paramList.get(0)).zzc();
              paramzzg = paramzzg.zza((zzap)paramList.get(1));
              this.zzb.zzc().zzd(paramString, zzh.zzj(paramzzg));
              return paramzzg;
            }
            zzh.zza("setEventName", 1, paramList);
            paramString = paramzzg.zza((zzap)paramList.get(0));
            if ((!zzap.zzf.equals(paramString)) && (!zzap.zzg.equals(paramString)))
            {
              this.zzb.zzc().zzc(paramString.zzc());
              return new zzat(paramString.zzc());
            }
            throw new IllegalArgumentException("Illegal event name");
          }
          zzh.zza("getTimestamp", 0, paramList);
          return new zzah(Double.valueOf(this.zzb.zzc().zza()));
        }
        zzh.zza("getParams", 0, paramList);
        paramString = this.zzb.zzc().zzf();
        paramzzg = new zzam();
        Iterator localIterator = paramString.keySet().iterator();
        while (localIterator.hasNext())
        {
          paramList = (String)localIterator.next();
          paramzzg.zzm(paramList, zzi.zza(paramString.get(paramList)));
        }
        return paramzzg;
      }
      zzh.zza("getParamValue", 1, paramList);
      paramString = paramzzg.zza((zzap)paramList.get(0)).zzc();
      return zzi.zza(this.zzb.zzc().zze(paramString));
    }
    zzh.zza("getEventName", 0, paramList);
    return new zzat(this.zzb.zzc().zzb());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */