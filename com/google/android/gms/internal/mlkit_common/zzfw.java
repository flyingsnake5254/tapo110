package com.google.android.gms.internal.mlkit_common;

import java.util.List;

final class zzfw
  extends zzfr
{
  private zzfw()
  {
    super(null);
  }
  
  private static <E> zzfi<E> zzb(Object paramObject, long paramLong)
  {
    return (zzfi)zzhw.zzf(paramObject, paramLong);
  }
  
  final void zza(Object paramObject, long paramLong)
  {
    zzb(paramObject, paramLong).zzb();
  }
  
  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    Object localObject = zzb(paramObject1, paramLong);
    zzfi localzzfi = zzb(paramObject2, paramLong);
    int i = ((List)localObject).size();
    int j = localzzfi.size();
    paramObject2 = localObject;
    if (i > 0)
    {
      paramObject2 = localObject;
      if (j > 0)
      {
        paramObject2 = localObject;
        if (!((zzfi)localObject).zza()) {
          paramObject2 = ((zzfi)localObject).zzb(j + i);
        }
        ((List)paramObject2).addAll(localzzfi);
      }
    }
    localObject = localzzfi;
    if (i > 0) {
      localObject = paramObject2;
    }
    zzhw.zza(paramObject1, paramLong, localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzfw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */