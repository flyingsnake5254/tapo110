package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzk
  extends zzai
{
  private final zzab zza;
  
  public zzk(zzab paramzzab)
  {
    super("internal.eventLogger");
    this.zza = paramzzab;
  }
  
  public final zzap zza(zzg paramzzg, List<zzap> paramList)
  {
    zzh.zza(this.zzd, 3, paramList);
    String str1 = paramzzg.zza((zzap)paramList.get(0)).zzc();
    long l = zzh.zzi(paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue());
    paramList = paramzzg.zza((zzap)paramList.get(2));
    paramzzg = new HashMap();
    if ((paramList instanceof zzam))
    {
      zzam localzzam = (zzam)paramList;
      paramList = localzzam.zzb().iterator();
      while (paramList.hasNext())
      {
        String str2 = (String)paramList.next();
        Object localObject = zzh.zzj(localzzam.zzk(str2));
        if (localObject != null) {
          paramzzg.put(str2, localObject);
        }
      }
    }
    this.zza.zze(str1, l, paramzzg);
    return zzap.zzf;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */