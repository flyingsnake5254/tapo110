package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzp
  extends zzaw<K, Collection<V>>
{
  zzp(Map<K, Collection<V>> paramMap)
  {
    super(localMap);
  }
  
  public final void clear()
  {
    zzaq.zza(iterator());
  }
  
  public final boolean containsAll(Collection<?> paramCollection)
  {
    return this.zzb.keySet().containsAll(paramCollection);
  }
  
  public final boolean equals(@NullableDecl Object paramObject)
  {
    return (this == paramObject) || (this.zzb.keySet().equals(paramObject));
  }
  
  public final int hashCode()
  {
    return this.zzb.keySet().hashCode();
  }
  
  public final Iterator<K> iterator()
  {
    return new zzo(this, this.zzb.entrySet().iterator());
  }
  
  public final boolean remove(Object paramObject)
  {
    paramObject = (Collection)this.zzb.remove(paramObject);
    int i;
    if (paramObject != null)
    {
      i = ((Collection)paramObject).size();
      ((Collection)paramObject).clear();
      zzl.zzb(this.zza, i);
    }
    else
    {
      i = 0;
    }
    return i > 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */