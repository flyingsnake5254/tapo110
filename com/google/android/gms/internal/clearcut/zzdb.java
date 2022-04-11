package com.google.android.gms.internal.clearcut;

import java.util.List;

final class zzdb
  extends zzcy
{
  private zzdb()
  {
    super(null);
  }
  
  private static <E> zzcn<E> zzc(Object paramObject, long paramLong)
  {
    return (zzcn)zzfd.zzo(paramObject, paramLong);
  }
  
  final void zza(Object paramObject, long paramLong)
  {
    zzc(paramObject, paramLong).zzv();
  }
  
  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    Object localObject = zzc(paramObject1, paramLong);
    zzcn localzzcn = zzc(paramObject2, paramLong);
    int i = ((List)localObject).size();
    int j = localzzcn.size();
    paramObject2 = localObject;
    if (i > 0)
    {
      paramObject2 = localObject;
      if (j > 0)
      {
        paramObject2 = localObject;
        if (!((zzcn)localObject).zzu()) {
          paramObject2 = ((zzcn)localObject).zzi(j + i);
        }
        ((List)paramObject2).addAll(localzzcn);
      }
    }
    localObject = localzzcn;
    if (i > 0) {
      localObject = paramObject2;
    }
    zzfd.zza(paramObject1, paramLong, localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */