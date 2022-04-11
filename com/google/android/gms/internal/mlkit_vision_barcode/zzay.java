package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class zzay<K, V>
  extends AbstractMap<K, V>
{
  @NullableDecl
  private transient Set<Map.Entry<K, V>> zza;
  @NullableDecl
  private transient Set<K> zzb;
  @NullableDecl
  private transient Collection<V> zzc;
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set localSet1 = this.zza;
    Set localSet2 = localSet1;
    if (localSet1 == null)
    {
      localSet2 = zza();
      this.zza = localSet2;
    }
    return localSet2;
  }
  
  public Set<K> keySet()
  {
    Set localSet = this.zzb;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new zzaw(this);
      this.zzb = ((Set)localObject);
    }
    return (Set<K>)localObject;
  }
  
  public Collection<V> values()
  {
    Collection localCollection = this.zzc;
    Object localObject = localCollection;
    if (localCollection == null)
    {
      localObject = new zzaz(this);
      this.zzc = ((Collection)localObject);
    }
    return (Collection<V>)localObject;
  }
  
  abstract Set<Map.Entry<K, V>> zza();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */