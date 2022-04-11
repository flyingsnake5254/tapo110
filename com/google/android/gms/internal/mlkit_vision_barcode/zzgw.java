package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzgw
  extends zzgu
{
  private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();
  
  private zzgw()
  {
    super(null);
  }
  
  private static <E> List<E> zzb(Object paramObject, long paramLong)
  {
    return (List)zziz.zzf(paramObject, paramLong);
  }
  
  final void zza(Object paramObject, long paramLong)
  {
    Object localObject = (List)zziz.zzf(paramObject, paramLong);
    if ((localObject instanceof zzgv))
    {
      localObject = ((zzgv)localObject).zze();
    }
    else
    {
      if (zza.isAssignableFrom(localObject.getClass())) {
        return;
      }
      if (((localObject instanceof zzhx)) && ((localObject instanceof zzgl)))
      {
        paramObject = (zzgl)localObject;
        if (((zzgl)paramObject).zza()) {
          ((zzgl)paramObject).zzb();
        }
        return;
      }
      localObject = Collections.unmodifiableList((List)localObject);
    }
    zziz.zza(paramObject, paramLong, localObject);
  }
  
  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    Object localObject = zzb(paramObject2, paramLong);
    int i = ((List)localObject).size();
    List localList = zzb(paramObject1, paramLong);
    if (localList.isEmpty())
    {
      if ((localList instanceof zzgv)) {
        paramObject2 = new zzgs(i);
      } else if (((localList instanceof zzhx)) && ((localList instanceof zzgl))) {
        paramObject2 = ((zzgl)localList).zza(i);
      } else {
        paramObject2 = new ArrayList(i);
      }
      zziz.zza(paramObject1, paramLong, paramObject2);
    }
    else
    {
      if (zza.isAssignableFrom(localList.getClass()))
      {
        paramObject2 = new ArrayList(localList.size() + i);
        ((ArrayList)paramObject2).addAll(localList);
        zziz.zza(paramObject1, paramLong, paramObject2);
      }
      for (;;)
      {
        break;
        if ((localList instanceof zziu))
        {
          paramObject2 = new zzgs(localList.size() + i);
          ((zzev)paramObject2).addAll((zziu)localList);
          zziz.zza(paramObject1, paramLong, paramObject2);
        }
        else
        {
          paramObject2 = localList;
          if ((localList instanceof zzhx))
          {
            paramObject2 = localList;
            if ((localList instanceof zzgl))
            {
              zzgl localzzgl = (zzgl)localList;
              paramObject2 = localList;
              if (!localzzgl.zza())
              {
                paramObject2 = localzzgl.zza(localList.size() + i);
                zziz.zza(paramObject1, paramLong, paramObject2);
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
    zziz.zza(paramObject1, paramLong, localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzgw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */