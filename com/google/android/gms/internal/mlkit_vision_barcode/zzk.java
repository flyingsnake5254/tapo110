package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzk
  extends zzay<K, Collection<V>>
{
  final transient Map<K, Collection<V>> zza;
  
  zzk(Map<K, Collection<V>> paramMap)
  {
    Map localMap;
    this.zza = localMap;
  }
  
  public final void clear()
  {
    if (this.zza == zzl.zza(this.zzb))
    {
      this.zzb.zzc();
      return;
    }
    zzaq.zza(new zzm(this));
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return zzas.zzb(this.zza, paramObject);
  }
  
  public final boolean equals(@NullableDecl Object paramObject)
  {
    return (this == paramObject) || (this.zza.equals(paramObject));
  }
  
  public final int hashCode()
  {
    return this.zza.hashCode();
  }
  
  public final Set<K> keySet()
  {
    return this.zzb.zzh();
  }
  
  public final int size()
  {
    return this.zza.size();
  }
  
  public final String toString()
  {
    return this.zza.toString();
  }
  
  protected final Set<Map.Entry<K, Collection<V>>> zza()
  {
    return new zzn(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */