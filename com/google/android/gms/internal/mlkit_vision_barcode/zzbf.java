package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

abstract class zzbf<E>
  extends AbstractSet<E>
{
  public boolean removeAll(Collection<?> paramCollection)
  {
    zzh.zza(paramCollection);
    Object localObject = paramCollection;
    if ((paramCollection instanceof zzba)) {
      localObject = ((zzba)paramCollection).zza();
    }
    if (((localObject instanceof Set)) && (((Collection)localObject).size() > size()))
    {
      paramCollection = iterator();
      zzh.zza(localObject);
      boolean bool = false;
      while (paramCollection.hasNext()) {
        if (((Collection)localObject).contains(paramCollection.next()))
        {
          paramCollection.remove();
          bool = true;
        }
      }
      return bool;
    }
    return zzbc.zza(this, ((Collection)localObject).iterator());
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return super.retainAll((Collection)zzh.zza(paramCollection));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */