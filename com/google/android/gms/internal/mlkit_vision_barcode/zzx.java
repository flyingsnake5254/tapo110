package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class zzx<K, V>
  implements zzbb<K, V>
{
  @NullableDecl
  private transient Set<K> zza;
  @NullableDecl
  private transient Map<K, Collection<V>> zzb;
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof zzbb))
    {
      paramObject = (zzbb)paramObject;
      return zzg().equals(((zzbb)paramObject).zzg());
    }
    return false;
  }
  
  public int hashCode()
  {
    return zzg().hashCode();
  }
  
  public String toString()
  {
    return zzg().toString();
  }
  
  public boolean zza(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    return zzb(paramK).add(paramV);
  }
  
  abstract Set<K> zzd();
  
  abstract Map<K, Collection<V>> zze();
  
  public Map<K, Collection<V>> zzg()
  {
    Map localMap1 = this.zzb;
    Map localMap2 = localMap1;
    if (localMap1 == null)
    {
      localMap2 = zze();
      this.zzb = localMap2;
    }
    return localMap2;
  }
  
  public Set<K> zzh()
  {
    Set localSet1 = this.zza;
    Set localSet2 = localSet1;
    if (localSet1 == null)
    {
      localSet2 = zzd();
      this.zza = localSet2;
    }
    return localSet2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */