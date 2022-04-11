package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Map.Entry;

final class zzbv
  extends zzbu<zzcg.zze>
{
  final int zza(Map.Entry<?, ?> paramEntry)
  {
    return ((zzcg.zze)paramEntry.getKey()).number;
  }
  
  final zzby<zzcg.zze> zza(Object paramObject)
  {
    return ((zzcg.zzd)paramObject).zzjv;
  }
  
  final void zza(zzfr paramzzfr, Map.Entry<?, ?> paramEntry)
    throws IOException
  {
    zzcg.zze localzze = (zzcg.zze)paramEntry.getKey();
    switch (zzbw.zzgq[localzze.zzjx.ordinal()])
    {
    default: 
      break;
    case 18: 
      paramzzfr.zza(localzze.number, paramEntry.getValue(), zzea.zzcm().zze(paramEntry.getValue().getClass()));
      break;
    case 17: 
      paramzzfr.zzb(localzze.number, paramEntry.getValue(), zzea.zzcm().zze(paramEntry.getValue().getClass()));
      return;
    case 16: 
      paramzzfr.zza(localzze.number, (String)paramEntry.getValue());
      return;
    case 15: 
      paramzzfr.zza(localzze.number, (zzbb)paramEntry.getValue());
      return;
    case 14: 
      paramzzfr.zzc(localzze.number, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 13: 
      paramzzfr.zzb(localzze.number, ((Long)paramEntry.getValue()).longValue());
      return;
    case 12: 
      paramzzfr.zze(localzze.number, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 11: 
      paramzzfr.zzj(localzze.number, ((Long)paramEntry.getValue()).longValue());
      return;
    case 10: 
      paramzzfr.zzm(localzze.number, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 9: 
      paramzzfr.zzd(localzze.number, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 8: 
      paramzzfr.zzb(localzze.number, ((Boolean)paramEntry.getValue()).booleanValue());
      return;
    case 7: 
      paramzzfr.zzf(localzze.number, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 6: 
      paramzzfr.zzc(localzze.number, ((Long)paramEntry.getValue()).longValue());
      return;
    case 5: 
      paramzzfr.zzc(localzze.number, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 4: 
      paramzzfr.zza(localzze.number, ((Long)paramEntry.getValue()).longValue());
      return;
    case 3: 
      paramzzfr.zzi(localzze.number, ((Long)paramEntry.getValue()).longValue());
      return;
    case 2: 
      paramzzfr.zza(localzze.number, ((Float)paramEntry.getValue()).floatValue());
      return;
    case 1: 
      paramzzfr.zza(localzze.number, ((Double)paramEntry.getValue()).doubleValue());
    }
  }
  
  final void zza(Object paramObject, zzby<zzcg.zze> paramzzby)
  {
    ((zzcg.zzd)paramObject).zzjv = paramzzby;
  }
  
  final zzby<zzcg.zze> zzb(Object paramObject)
  {
    zzby localzzby1 = zza(paramObject);
    zzby localzzby2 = localzzby1;
    if (localzzby1.isImmutable())
    {
      localzzby2 = (zzby)localzzby1.clone();
      zza(paramObject, localzzby2);
    }
    return localzzby2;
  }
  
  final void zzc(Object paramObject)
  {
    zza(paramObject).zzv();
  }
  
  final boolean zze(zzdo paramzzdo)
  {
    return paramzzdo instanceof zzcg.zzd;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */