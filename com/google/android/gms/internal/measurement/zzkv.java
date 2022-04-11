package com.google.android.gms.internal.measurement;

import java.util.List;

final class zzkv
  extends zzkw
{
  private zzkv()
  {
    super(null);
  }
  
  final void zza(Object paramObject, long paramLong)
  {
    ((zzkk)zzmr.zzn(paramObject, paramLong)).zzb();
  }
  
  final <E> void zzb(Object paramObject1, Object paramObject2, long paramLong)
  {
    zzkk localzzkk1 = (zzkk)zzmr.zzn(paramObject1, paramLong);
    zzkk localzzkk2 = (zzkk)zzmr.zzn(paramObject2, paramLong);
    int i = localzzkk1.size();
    int j = localzzkk2.size();
    paramObject2 = localzzkk1;
    if (i > 0)
    {
      paramObject2 = localzzkk1;
      if (j > 0)
      {
        paramObject2 = localzzkk1;
        if (!localzzkk1.zza()) {
          paramObject2 = localzzkk1.zze(j + i);
        }
        ((List)paramObject2).addAll(localzzkk2);
      }
    }
    if (i <= 0) {
      paramObject2 = localzzkk2;
    }
    zzmr.zzo(paramObject1, paramLong, paramObject2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzkv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */