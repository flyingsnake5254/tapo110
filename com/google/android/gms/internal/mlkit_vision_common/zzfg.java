package com.google.android.gms.internal.mlkit_vision_common;

import java.util.List;

final class zzfg
  extends zzff
{
  private zzfg()
  {
    super(null);
  }
  
  private static <E> zzes<E> zzb(Object paramObject, long paramLong)
  {
    return (zzes)zzhg.zzf(paramObject, paramLong);
  }
  
  final void zza(Object paramObject, long paramLong)
  {
    zzb(paramObject, paramLong).b_();
  }
  
  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    Object localObject = zzb(paramObject1, paramLong);
    zzes localzzes = zzb(paramObject2, paramLong);
    int i = ((List)localObject).size();
    int j = localzzes.size();
    paramObject2 = localObject;
    if (i > 0)
    {
      paramObject2 = localObject;
      if (j > 0)
      {
        paramObject2 = localObject;
        if (!((zzes)localObject).zza()) {
          paramObject2 = ((zzes)localObject).zzb(j + i);
        }
        ((List)paramObject2).addAll(localzzes);
      }
    }
    localObject = localzzes;
    if (i > 0) {
      localObject = paramObject2;
    }
    zzhg.zza(paramObject1, paramLong, localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */