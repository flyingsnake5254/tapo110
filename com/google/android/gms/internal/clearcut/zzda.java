package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzda
  extends zzcy
{
  private static final Class<?> zzlv = Collections.unmodifiableList(Collections.emptyList()).getClass();
  
  private zzda()
  {
    super(null);
  }
  
  private static <E> List<E> zzb(Object paramObject, long paramLong)
  {
    return (List)zzfd.zzo(paramObject, paramLong);
  }
  
  final void zza(Object paramObject, long paramLong)
  {
    Object localObject = (List)zzfd.zzo(paramObject, paramLong);
    if ((localObject instanceof zzcx))
    {
      localObject = ((zzcx)localObject).zzbu();
    }
    else
    {
      if (zzlv.isAssignableFrom(localObject.getClass())) {
        return;
      }
      localObject = Collections.unmodifiableList((List)localObject);
    }
    zzfd.zza(paramObject, paramLong, localObject);
  }
  
  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    Object localObject = zzb(paramObject2, paramLong);
    int i = ((List)localObject).size();
    List localList = zzb(paramObject1, paramLong);
    if (localList.isEmpty())
    {
      if ((localList instanceof zzcx)) {
        paramObject2 = new zzcw(i);
      } else {
        paramObject2 = new ArrayList(i);
      }
      zzfd.zza(paramObject1, paramLong, paramObject2);
    }
    else
    {
      if (zzlv.isAssignableFrom(localList.getClass()))
      {
        paramObject2 = new ArrayList(localList.size() + i);
        ((ArrayList)paramObject2).addAll(localList);
      }
      for (;;)
      {
        zzfd.zza(paramObject1, paramLong, paramObject2);
        break;
        paramObject2 = localList;
        if (!(localList instanceof zzfa)) {
          break;
        }
        paramObject2 = new zzcw(localList.size() + i);
        ((zzav)paramObject2).addAll((zzfa)localList);
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
    zzfd.zza(paramObject1, paramLong, localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */