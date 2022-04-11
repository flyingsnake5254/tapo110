package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzht
  extends zzhr
{
  private static final Class<?> zzyv = Collections.unmodifiableList(Collections.emptyList()).getClass();
  
  private zzht()
  {
    super(null);
  }
  
  private static <L> List<L> zza(Object paramObject, long paramLong, int paramInt)
  {
    List localList = zzd(paramObject, paramLong);
    Object localObject;
    if (localList.isEmpty())
    {
      if ((localList instanceof zzho)) {
        localObject = new zzhp(paramInt);
      } else if (((localList instanceof zzit)) && ((localList instanceof zzhe))) {
        localObject = ((zzhe)localList).zzah(paramInt);
      } else {
        localObject = new ArrayList(paramInt);
      }
      zzju.zza(paramObject, paramLong, localObject);
    }
    else
    {
      if (zzyv.isAssignableFrom(localList.getClass()))
      {
        localObject = new ArrayList(localList.size() + paramInt);
        ((ArrayList)localObject).addAll(localList);
        zzju.zza(paramObject, paramLong, localObject);
      }
      for (paramObject = localObject;; paramObject = localObject)
      {
        localObject = paramObject;
        break label266;
        if (!(localList instanceof zzjt)) {
          break;
        }
        localObject = new zzhp(localList.size() + paramInt);
        ((zzfc)localObject).addAll((zzjt)localList);
        zzju.zza(paramObject, paramLong, localObject);
      }
      localObject = localList;
      if ((localList instanceof zzit))
      {
        localObject = localList;
        if ((localList instanceof zzhe))
        {
          zzhe localzzhe = (zzhe)localList;
          localObject = localList;
          if (!localzzhe.zzdp())
          {
            localObject = localzzhe.zzah(localList.size() + paramInt);
            zzju.zza(paramObject, paramLong, localObject);
          }
        }
      }
    }
    label266:
    return (List<L>)localObject;
  }
  
  private static <E> List<E> zzd(Object paramObject, long paramLong)
  {
    return (List)zzju.zzp(paramObject, paramLong);
  }
  
  final <L> List<L> zza(Object paramObject, long paramLong)
  {
    return zza(paramObject, paramLong, 10);
  }
  
  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    paramObject2 = zzd(paramObject2, paramLong);
    List localList = zza(paramObject1, paramLong, ((List)paramObject2).size());
    int i = localList.size();
    int j = ((List)paramObject2).size();
    if ((i > 0) && (j > 0)) {
      localList.addAll((Collection)paramObject2);
    }
    if (i > 0) {
      paramObject2 = localList;
    }
    zzju.zza(paramObject1, paramLong, paramObject2);
  }
  
  final void zzb(Object paramObject, long paramLong)
  {
    Object localObject = (List)zzju.zzp(paramObject, paramLong);
    if ((localObject instanceof zzho))
    {
      localObject = ((zzho)localObject).zzgz();
    }
    else
    {
      if (zzyv.isAssignableFrom(localObject.getClass())) {
        return;
      }
      if (((localObject instanceof zzit)) && ((localObject instanceof zzhe)))
      {
        paramObject = (zzhe)localObject;
        if (((zzhe)paramObject).zzdp()) {
          ((zzhe)paramObject).zzdq();
        }
        return;
      }
      localObject = Collections.unmodifiableList((List)localObject);
    }
    zzju.zza(paramObject, paramLong, localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */