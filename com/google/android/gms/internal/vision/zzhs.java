package com.google.android.gms.internal.vision;

import java.util.List;

final class zzhs
  extends zzhr
{
  private zzhs()
  {
    super(null);
  }
  
  private static <E> zzhe<E> zzc(Object paramObject, long paramLong)
  {
    return (zzhe)zzju.zzp(paramObject, paramLong);
  }
  
  final <L> List<L> zza(Object paramObject, long paramLong)
  {
    zzhe localzzhe1 = zzc(paramObject, paramLong);
    zzhe localzzhe2 = localzzhe1;
    if (!localzzhe1.zzdp())
    {
      int i = localzzhe1.size();
      if (i == 0) {
        i = 10;
      } else {
        i <<= 1;
      }
      localzzhe2 = localzzhe1.zzah(i);
      zzju.zza(paramObject, paramLong, localzzhe2);
    }
    return localzzhe2;
  }
  
  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    Object localObject = zzc(paramObject1, paramLong);
    zzhe localzzhe = zzc(paramObject2, paramLong);
    int i = ((List)localObject).size();
    int j = localzzhe.size();
    paramObject2 = localObject;
    if (i > 0)
    {
      paramObject2 = localObject;
      if (j > 0)
      {
        paramObject2 = localObject;
        if (!((zzhe)localObject).zzdp()) {
          paramObject2 = ((zzhe)localObject).zzah(j + i);
        }
        ((List)paramObject2).addAll(localzzhe);
      }
    }
    localObject = localzzhe;
    if (i > 0) {
      localObject = paramObject2;
    }
    zzju.zza(paramObject1, paramLong, localObject);
  }
  
  final void zzb(Object paramObject, long paramLong)
  {
    zzc(paramObject, paramLong).zzdq();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzhs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */