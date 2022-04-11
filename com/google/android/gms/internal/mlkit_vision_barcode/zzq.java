package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class zzq
  extends AbstractCollection<V>
{
  @NullableDecl
  final K zza;
  Collection<V> zzb;
  @NullableDecl
  final zzq zzc;
  @NullableDecl
  private final Collection<V> zze;
  
  zzq(@NullableDecl K paramK, Collection<V> paramCollection, @NullableDecl zzq paramzzq)
  {
    this.zza = paramCollection;
    this.zzb = paramzzq;
    zzq localzzq;
    this.zzc = localzzq;
    if (localzzq == null) {
      paramK = null;
    } else {
      paramK = localzzq.zzb;
    }
    this.zze = paramK;
  }
  
  public boolean add(V paramV)
  {
    zza();
    boolean bool1 = this.zzb.isEmpty();
    boolean bool2 = this.zzb.add(paramV);
    if (bool2)
    {
      zzl.zzc(this.zzd);
      if (bool1) {
        zzc();
      }
    }
    return bool2;
  }
  
  public boolean addAll(Collection<? extends V> paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return false;
    }
    int i = size();
    boolean bool = this.zzb.addAll(paramCollection);
    if (bool)
    {
      int j = this.zzb.size();
      zzl.zza(this.zzd, j - i);
      if (i == 0) {
        zzc();
      }
    }
    return bool;
  }
  
  public void clear()
  {
    int i = size();
    if (i == 0) {
      return;
    }
    this.zzb.clear();
    zzl.zzb(this.zzd, i);
    zzb();
  }
  
  public boolean contains(Object paramObject)
  {
    zza();
    return this.zzb.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    zza();
    return this.zzb.containsAll(paramCollection);
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    zza();
    return this.zzb.equals(paramObject);
  }
  
  public int hashCode()
  {
    zza();
    return this.zzb.hashCode();
  }
  
  public Iterator<V> iterator()
  {
    zza();
    return new zzt(this);
  }
  
  public boolean remove(Object paramObject)
  {
    zza();
    boolean bool = this.zzb.remove(paramObject);
    if (bool)
    {
      zzl.zzb(this.zzd);
      zzb();
    }
    return bool;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return false;
    }
    int i = size();
    boolean bool = this.zzb.removeAll(paramCollection);
    if (bool)
    {
      int j = this.zzb.size();
      zzl.zza(this.zzd, j - i);
      zzb();
    }
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    zzh.zza(paramCollection);
    int i = size();
    boolean bool = this.zzb.retainAll(paramCollection);
    if (bool)
    {
      int j = this.zzb.size();
      zzl.zza(this.zzd, j - i);
      zzb();
    }
    return bool;
  }
  
  public int size()
  {
    zza();
    return this.zzb.size();
  }
  
  public String toString()
  {
    zza();
    return this.zzb.toString();
  }
  
  final void zza()
  {
    Object localObject = this.zzc;
    if (localObject != null)
    {
      ((zzq)localObject).zza();
      if (this.zzc.zzb != this.zze) {
        throw new ConcurrentModificationException();
      }
    }
    else if (this.zzb.isEmpty())
    {
      localObject = (Collection)zzl.zza(this.zzd).get(this.zza);
      if (localObject != null) {
        this.zzb = ((Collection)localObject);
      }
    }
  }
  
  final void zzb()
  {
    zzq localzzq;
    for (Object localObject = this;; localObject = localzzq)
    {
      localzzq = ((zzq)localObject).zzc;
      if (localzzq == null) {
        break;
      }
    }
    if (((zzq)localObject).zzb.isEmpty()) {
      zzl.zza(((zzq)localObject).zzd).remove(((zzq)localObject).zza);
    }
  }
  
  final void zzc()
  {
    zzq localzzq;
    for (Object localObject = this;; localObject = localzzq)
    {
      localzzq = ((zzq)localObject).zzc;
      if (localzzq == null) {
        break;
      }
    }
    zzl.zza(((zzq)localObject).zzd).put(((zzq)localObject).zza, ((zzq)localObject).zzb);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */