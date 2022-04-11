package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzgs
  extends zzev<String>
  implements zzgv, RandomAccess
{
  private static final zzgs zza;
  private static final zzgv zzb;
  private final List<Object> zzc;
  
  static
  {
    zzgs localzzgs = new zzgs();
    zza = localzzgs;
    localzzgs.zzb();
    zzb = localzzgs;
  }
  
  public zzgs()
  {
    this(10);
  }
  
  public zzgs(int paramInt)
  {
    this(new ArrayList(paramInt));
  }
  
  private zzgs(ArrayList<Object> paramArrayList)
  {
    this.zzc = paramArrayList;
  }
  
  private static String zza(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof zzew)) {
      return ((zzew)paramObject).zzb();
    }
    return zzgc.zzb((byte[])paramObject);
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    zzc();
    Object localObject = paramCollection;
    if ((paramCollection instanceof zzgv)) {
      localObject = ((zzgv)paramCollection).zzd();
    }
    boolean bool = this.zzc.addAll(paramInt, (Collection)localObject);
    this.modCount += 1;
    return bool;
  }
  
  public final boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public final void clear()
  {
    zzc();
    this.zzc.clear();
    this.modCount += 1;
  }
  
  public final int size()
  {
    return this.zzc.size();
  }
  
  public final void zza(zzew paramzzew)
  {
    zzc();
    this.zzc.add(paramzzew);
    this.modCount += 1;
  }
  
  public final Object zzb(int paramInt)
  {
    return this.zzc.get(paramInt);
  }
  
  public final List<?> zzd()
  {
    return Collections.unmodifiableList(this.zzc);
  }
  
  public final zzgv zze()
  {
    if (zza()) {
      return new zziu(this);
    }
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */