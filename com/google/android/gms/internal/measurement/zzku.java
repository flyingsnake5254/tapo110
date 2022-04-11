package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzku
  extends zzkw
{
  private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();
  
  private zzku()
  {
    super(null);
  }
  
  final void zza(Object paramObject, long paramLong)
  {
    Object localObject = (List)zzmr.zzn(paramObject, paramLong);
    if ((localObject instanceof zzks))
    {
      localObject = ((zzks)localObject).zzi();
    }
    else
    {
      if (zza.isAssignableFrom(localObject.getClass())) {
        return;
      }
      if (((localObject instanceof zzlp)) && ((localObject instanceof zzkk)))
      {
        paramObject = (zzkk)localObject;
        if (((zzkk)paramObject).zza()) {
          ((zzkk)paramObject).zzb();
        }
        return;
      }
      localObject = Collections.unmodifiableList((List)localObject);
    }
    zzmr.zzo(paramObject, paramLong, localObject);
  }
  
  final <E> void zzb(Object paramObject1, Object paramObject2, long paramLong)
  {
    List localList = (List)zzmr.zzn(paramObject2, paramLong);
    int i = localList.size();
    Object localObject = (List)zzmr.zzn(paramObject1, paramLong);
    if (((List)localObject).isEmpty())
    {
      if ((localObject instanceof zzks)) {
        paramObject2 = new zzkr(i);
      } else if (((localObject instanceof zzlp)) && ((localObject instanceof zzkk))) {
        paramObject2 = ((zzkk)localObject).zze(i);
      } else {
        paramObject2 = new ArrayList(i);
      }
      zzmr.zzo(paramObject1, paramLong, paramObject2);
    }
    else
    {
      if (zza.isAssignableFrom(localObject.getClass()))
      {
        paramObject2 = new ArrayList(((List)localObject).size() + i);
        ((ArrayList)paramObject2).addAll((Collection)localObject);
        zzmr.zzo(paramObject1, paramLong, paramObject2);
      }
      for (;;)
      {
        break;
        if ((localObject instanceof zzmm))
        {
          paramObject2 = new zzkr(((List)localObject).size() + i);
          localObject = (zzmm)localObject;
          ((zzip)paramObject2).addAll(((zzkr)paramObject2).size(), (Collection)localObject);
          zzmr.zzo(paramObject1, paramLong, paramObject2);
        }
        else
        {
          paramObject2 = localObject;
          if ((localObject instanceof zzlp))
          {
            paramObject2 = localObject;
            if ((localObject instanceof zzkk))
            {
              zzkk localzzkk = (zzkk)localObject;
              paramObject2 = localObject;
              if (!localzzkk.zza())
              {
                paramObject2 = localzzkk.zze(((List)localObject).size() + i);
                zzmr.zzo(paramObject1, paramLong, paramObject2);
              }
            }
          }
        }
      }
    }
    i = ((List)paramObject2).size();
    int j = localList.size();
    if ((i > 0) && (j > 0)) {
      ((List)paramObject2).addAll(localList);
    }
    if (i <= 0) {
      paramObject2 = localList;
    }
    zzmr.zzo(paramObject1, paramLong, paramObject2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */