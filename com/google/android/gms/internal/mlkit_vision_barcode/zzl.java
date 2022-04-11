package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class zzl<K, V>
  extends zzx<K, V>
  implements Serializable
{
  private transient Map<K, Collection<V>> zza;
  private transient int zzb;
  
  protected zzl(Map<K, Collection<V>> paramMap)
  {
    if (paramMap.isEmpty())
    {
      this.zza = paramMap;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  private static <E> Iterator<E> zzb(Collection<E> paramCollection)
  {
    if ((paramCollection instanceof List)) {
      return ((List)paramCollection).listIterator();
    }
    return paramCollection.iterator();
  }
  
  private final void zzc(Object paramObject)
  {
    paramObject = (Collection)zzas.zzc(this.zza, paramObject);
    if (paramObject != null)
    {
      int i = ((Collection)paramObject).size();
      ((Collection)paramObject).clear();
      this.zzb -= i;
    }
  }
  
  Collection<V> zza(@NullableDecl K paramK, Collection<V> paramCollection)
  {
    return new zzq(this, paramK, paramCollection, null);
  }
  
  final List<V> zza(@NullableDecl K paramK, List<V> paramList, @NullableDecl zzq paramzzq)
  {
    if ((paramList instanceof RandomAccess)) {
      return new zzr(this, paramK, paramList, paramzzq);
    }
    return new zzs(this, paramK, paramList, paramzzq);
  }
  
  public boolean zza(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    Collection localCollection = (Collection)this.zza.get(paramK);
    if (localCollection == null)
    {
      localCollection = zzb();
      if (localCollection.add(paramV))
      {
        this.zzb += 1;
        this.zza.put(paramK, localCollection);
        return true;
      }
      throw new AssertionError("New Collection violated the Collection spec");
    }
    if (localCollection.add(paramV))
    {
      this.zzb += 1;
      return true;
    }
    return false;
  }
  
  abstract Collection<V> zzb();
  
  public Collection<V> zzb(@NullableDecl K paramK)
  {
    Collection localCollection1 = (Collection)this.zza.get(paramK);
    Collection localCollection2 = localCollection1;
    if (localCollection1 == null) {
      localCollection2 = zzb();
    }
    return zza(paramK, localCollection2);
  }
  
  public void zzc()
  {
    Iterator localIterator = this.zza.values().iterator();
    while (localIterator.hasNext()) {
      ((Collection)localIterator.next()).clear();
    }
    this.zza.clear();
    this.zzb = 0;
  }
  
  final Set<K> zzd()
  {
    return new zzp(this, this.zza);
  }
  
  final Map<K, Collection<V>> zze()
  {
    return new zzk(this, this.zza);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */