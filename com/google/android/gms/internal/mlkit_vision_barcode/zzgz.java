package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.List;

final class zzgz
  extends zzgu
{
  private zzgz()
  {
    super(null);
  }
  
  private static <E> zzgl<E> zzb(Object paramObject, long paramLong)
  {
    return (zzgl)zziz.zzf(paramObject, paramLong);
  }
  
  final void zza(Object paramObject, long paramLong)
  {
    zzb(paramObject, paramLong).zzb();
  }
  
  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    Object localObject = zzb(paramObject1, paramLong);
    zzgl localzzgl = zzb(paramObject2, paramLong);
    int i = ((List)localObject).size();
    int j = localzzgl.size();
    paramObject2 = localObject;
    if (i > 0)
    {
      paramObject2 = localObject;
      if (j > 0)
      {
        paramObject2 = localObject;
        if (!((zzgl)localObject).zza()) {
          paramObject2 = ((zzgl)localObject).zza(j + i);
        }
        ((List)paramObject2).addAll(localzzgl);
      }
    }
    localObject = localzzgl;
    if (i > 0) {
      localObject = paramObject2;
    }
    zziz.zza(paramObject1, paramLong, localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */