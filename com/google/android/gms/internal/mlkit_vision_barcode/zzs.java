package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class zzs
  extends zzq
  implements List<V>
{
  zzs(@NullableDecl K paramK, List<V> paramList, @NullableDecl zzq paramzzq)
  {
    super(paramK, paramList, paramzzq, localzzq);
  }
  
  public void add(int paramInt, V paramV)
  {
    zza();
    boolean bool = this.zzb.isEmpty();
    ((List)this.zzb).add(paramInt, paramV);
    zzl.zzc(this.zzd);
    if (bool) {
      zzc();
    }
  }
  
  public boolean addAll(int paramInt, Collection<? extends V> paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return false;
    }
    int i = size();
    boolean bool = ((List)this.zzb).addAll(paramInt, paramCollection);
    if (bool)
    {
      paramInt = this.zzb.size();
      zzl.zza(this.zzd, paramInt - i);
      if (i == 0) {
        zzc();
      }
    }
    return bool;
  }
  
  public V get(int paramInt)
  {
    zza();
    return (V)((List)this.zzb).get(paramInt);
  }
  
  public int indexOf(Object paramObject)
  {
    zza();
    return ((List)this.zzb).indexOf(paramObject);
  }
  
  public int lastIndexOf(Object paramObject)
  {
    zza();
    return ((List)this.zzb).lastIndexOf(paramObject);
  }
  
  public ListIterator<V> listIterator()
  {
    zza();
    return new zzv(this);
  }
  
  public ListIterator<V> listIterator(int paramInt)
  {
    zza();
    return new zzv(this, paramInt);
  }
  
  public V remove(int paramInt)
  {
    zza();
    Object localObject = ((List)this.zzb).remove(paramInt);
    zzl.zzb(this.zzd);
    zzb();
    return (V)localObject;
  }
  
  public V set(int paramInt, V paramV)
  {
    zza();
    return (V)((List)this.zzb).set(paramInt, paramV);
  }
  
  public List<V> subList(int paramInt1, int paramInt2)
  {
    zza();
    zzl localzzl = this.zzd;
    Object localObject1 = this.zza;
    List localList = ((List)this.zzb).subList(paramInt1, paramInt2);
    zzq localzzq = this.zzc;
    Object localObject2 = localzzq;
    if (localzzq == null) {
      localObject2 = this;
    }
    return localzzl.zza(localObject1, localList, (zzq)localObject2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */