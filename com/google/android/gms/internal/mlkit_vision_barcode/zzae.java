package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzae
  extends AbstractSet<Map.Entry<K, V>>
{
  zzae(zzaa paramzzaa) {}
  
  public final void clear()
  {
    this.zza.clear();
  }
  
  public final boolean contains(@NullableDecl Object paramObject)
  {
    Map localMap = this.zza.zzb();
    if (localMap != null) {
      return localMap.entrySet().contains(paramObject);
    }
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      int i = zzaa.zzb(this.zza, ((Map.Entry)paramObject).getKey());
      if ((i != -1) && (zze.zza(this.zza.zzc[i], ((Map.Entry)paramObject).getValue()))) {
        return true;
      }
    }
    return false;
  }
  
  public final Iterator<Map.Entry<K, V>> iterator()
  {
    return this.zza.zzf();
  }
  
  public final boolean remove(@NullableDecl Object paramObject)
  {
    Object localObject1 = this.zza.zzb();
    if (localObject1 != null) {
      return ((Map)localObject1).entrySet().remove(paramObject);
    }
    if ((paramObject instanceof Map.Entry))
    {
      localObject1 = (Map.Entry)paramObject;
      if (this.zza.zza()) {
        return false;
      }
      int i = zzaa.zzb(this.zza);
      paramObject = ((Map.Entry)localObject1).getKey();
      Object localObject2 = ((Map.Entry)localObject1).getValue();
      Object localObject3 = zzaa.zzc(this.zza);
      localObject1 = this.zza;
      int j = zzal.zza(paramObject, localObject2, i, localObject3, ((zzaa)localObject1).zza, ((zzaa)localObject1).zzb, ((zzaa)localObject1).zzc);
      if (j == -1) {
        return false;
      }
      this.zza.zza(j, i);
      zzaa.zzd(this.zza);
      this.zza.zzc();
      return true;
    }
    return false;
  }
  
  public final int size()
  {
    return this.zza.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */