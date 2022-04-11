package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzbj
  extends zzaw
{
  public final zzap zza(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    if ((paramString != null) && (!paramString.isEmpty()) && (paramzzg.zzd(paramString)))
    {
      zzap localzzap = paramzzg.zzh(paramString);
      if ((localzzap instanceof zzai)) {
        return ((zzai)localzzap).zza(paramzzg, paramList);
      }
      throw new IllegalArgumentException(String.format("Function %s is not defined", new Object[] { paramString }));
    }
    throw new IllegalArgumentException(String.format("Command not found: %s", new Object[] { paramString }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */