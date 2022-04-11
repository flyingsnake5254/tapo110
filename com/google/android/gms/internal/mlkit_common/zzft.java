package com.google.android.gms.internal.mlkit_common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzft
  extends zzfr
{
  private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();
  
  private zzft()
  {
    super(null);
  }
  
  private static <E> List<E> zzb(Object paramObject, long paramLong)
  {
    return (List)zzhw.zzf(paramObject, paramLong);
  }
  
  final void zza(Object paramObject, long paramLong)
  {
    Object localObject = (List)zzhw.zzf(paramObject, paramLong);
    if ((localObject instanceof zzfs))
    {
      localObject = ((zzfs)localObject).zze();
    }
    else
    {
      if (zza.isAssignableFrom(localObject.getClass())) {
        return;
      }
      if (((localObject instanceof zzgu)) && ((localObject instanceof zzfi)))
      {
        paramObject = (zzfi)localObject;
        if (((zzfi)paramObject).zza()) {
          ((zzfi)paramObject).zzb();
        }
        return;
      }
      localObject = Collections.unmodifiableList((List)localObject);
    }
    zzhw.zza(paramObject, paramLong, localObject);
  }
  
  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    Object localObject = zzb(paramObject2, paramLong);
    int i = ((List)localObject).size();
    List localList = zzb(paramObject1, paramLong);
    if (localList.isEmpty())
    {
      if ((localList instanceof zzfs)) {
        paramObject2 = new zzfp(i);
      } else if (((localList instanceof zzgu)) && ((localList instanceof zzfi))) {
        paramObject2 = ((zzfi)localList).zzb(i);
      } else {
        paramObject2 = new ArrayList(i);
      }
      zzhw.zza(paramObject1, paramLong, paramObject2);
    }
    else
    {
      if (zza.isAssignableFrom(localList.getClass()))
      {
        paramObject2 = new ArrayList(localList.size() + i);
        ((ArrayList)paramObject2).addAll(localList);
        zzhw.zza(paramObject1, paramLong, paramObject2);
      }
      for (;;)
      {
        break;
        if ((localList instanceof zzhr))
        {
          paramObject2 = new zzfp(localList.size() + i);
          ((zzdu)paramObject2).addAll((zzhr)localList);
          zzhw.zza(paramObject1, paramLong, paramObject2);
        }
        else
        {
          paramObject2 = localList;
          if ((localList instanceof zzgu))
          {
            paramObject2 = localList;
            if ((localList instanceof zzfi))
            {
              zzfi localzzfi = (zzfi)localList;
              paramObject2 = localList;
              if (!localzzfi.zza())
              {
                paramObject2 = localzzfi.zzb(localList.size() + i);
                zzhw.zza(paramObject1, paramLong, paramObject2);
              }
            }
          }
        }
      }
    }
    i = ((List)paramObject2).size();
    int j = ((List)localObject).size();
    if ((i > 0) && (j > 0)) {
      ((List)paramObject2).addAll((Collection)localObject);
    }
    if (i > 0) {
      localObject = paramObject2;
    }
    zzhw.zza(paramObject1, paramLong, localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */