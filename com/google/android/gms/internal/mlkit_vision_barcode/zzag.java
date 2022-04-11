package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzag
  extends AbstractSet<K>
{
  zzag(zzaa paramzzaa) {}
  
  public final void clear()
  {
    this.zza.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    return this.zza.containsKey(paramObject);
  }
  
  public final Iterator<K> iterator()
  {
    return this.zza.zze();
  }
  
  public final boolean remove(@NullableDecl Object paramObject)
  {
    Map localMap = this.zza.zzb();
    if (localMap != null) {
      return localMap.keySet().remove(paramObject);
    }
    return zzaa.zza(this.zza, paramObject) != zzaa.zzh();
  }
  
  public final int size()
  {
    return this.zza.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */