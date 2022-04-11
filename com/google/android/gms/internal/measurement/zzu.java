package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzu
  extends zzai
{
  private final zzz zza;
  
  public zzu(zzz paramzzz)
  {
    super("internal.registerCallback");
    this.zza = paramzzz;
  }
  
  public final zzap zza(zzg paramzzg, List<zzap> paramList)
  {
    zzh.zza(this.zzd, 3, paramList);
    String str = paramzzg.zza((zzap)paramList.get(0)).zzc();
    zzap localzzap = paramzzg.zza((zzap)paramList.get(1));
    if ((localzzap instanceof zzao))
    {
      paramzzg = paramzzg.zza((zzap)paramList.get(2));
      if ((paramzzg instanceof zzam))
      {
        paramzzg = (zzam)paramzzg;
        if (paramzzg.zzj("type"))
        {
          paramList = paramzzg.zzk("type").zzc();
          int i;
          if (paramzzg.zzj("priority")) {
            i = zzh.zzg(paramzzg.zzk("priority").zzd().doubleValue());
          } else {
            i = 1000;
          }
          this.zza.zza(str, i, (zzao)localzzap, paramList);
          return zzap.zzf;
        }
        throw new IllegalArgumentException("Undefined rule type");
      }
      throw new IllegalArgumentException("Invalid callback params");
    }
    throw new IllegalArgumentException("Invalid callback type");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */