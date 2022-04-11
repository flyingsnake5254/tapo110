package com.google.android.gms.internal.mlkit_vision_common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzfh
  extends zzff
{
  private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();
  
  private zzfh()
  {
    super(null);
  }
  
  private static <E> List<E> zzb(Object paramObject, long paramLong)
  {
    return (List)zzhg.zzf(paramObject, paramLong);
  }
  
  final void zza(Object paramObject, long paramLong)
  {
    Object localObject = (List)zzhg.zzf(paramObject, paramLong);
    if ((localObject instanceof zzfc))
    {
      localObject = ((zzfc)localObject).a_();
    }
    else
    {
      if (zza.isAssignableFrom(localObject.getClass())) {
        return;
      }
      if (((localObject instanceof zzge)) && ((localObject instanceof zzes)))
      {
        paramObject = (zzes)localObject;
        if (((zzes)paramObject).zza()) {
          ((zzes)paramObject).b_();
        }
        return;
      }
      localObject = Collections.unmodifiableList((List)localObject);
    }
    zzhg.zza(paramObject, paramLong, localObject);
  }
  
  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    Object localObject = zzb(paramObject2, paramLong);
    int i = ((List)localObject).size();
    List localList = zzb(paramObject1, paramLong);
    if (localList.isEmpty())
    {
      if ((localList instanceof zzfc)) {
        paramObject2 = new zzfd(i);
      } else if (((localList instanceof zzge)) && ((localList instanceof zzes))) {
        paramObject2 = ((zzes)localList).zzb(i);
      } else {
        paramObject2 = new ArrayList(i);
      }
      zzhg.zza(paramObject1, paramLong, paramObject2);
    }
    else
    {
      if (zza.isAssignableFrom(localList.getClass()))
      {
        paramObject2 = new ArrayList(localList.size() + i);
        ((ArrayList)paramObject2).addAll(localList);
        zzhg.zza(paramObject1, paramLong, paramObject2);
      }
      for (;;)
      {
        break;
        if ((localList instanceof zzhf))
        {
          paramObject2 = new zzfd(localList.size() + i);
          ((zzde)paramObject2).addAll((zzhf)localList);
          zzhg.zza(paramObject1, paramLong, paramObject2);
        }
        else
        {
          paramObject2 = localList;
          if ((localList instanceof zzge))
          {
            paramObject2 = localList;
            if ((localList instanceof zzes))
            {
              zzes localzzes = (zzes)localList;
              paramObject2 = localList;
              if (!localzzes.zza())
              {
                paramObject2 = localzzes.zzb(localList.size() + i);
                zzhg.zza(paramObject1, paramLong, paramObject2);
              }
            }
          }
        }
      }
    }
    int j = ((List)paramObject2).size();
    i = ((List)localObject).size();
    if ((j > 0) && (i > 0)) {
      ((List)paramObject2).addAll((Collection)localObject);
    }
    if (j > 0) {
      localObject = paramObject2;
    }
    zzhg.zza(paramObject1, paramLong, localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzfh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */