package com.google.android.gms.internal.mlkit_common;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzfp
  extends zzdu<String>
  implements zzfs, RandomAccess
{
  private static final zzfp zza;
  private static final zzfs zzb;
  private final List<Object> zzc;
  
  static
  {
    zzfp localzzfp = new zzfp();
    zza = localzzfp;
    localzzfp.zzb();
    zzb = localzzfp;
  }
  
  public zzfp()
  {
    this(10);
  }
  
  public zzfp(int paramInt)
  {
    this(new ArrayList(paramInt));
  }
  
  private zzfp(ArrayList<Object> paramArrayList)
  {
    this.zzc = paramArrayList;
  }
  
  private static String zza(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof zzdv)) {
      return ((zzdv)paramObject).zzb();
    }
    return zzfc.zzb((byte[])paramObject);
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    zzc();
    Object localObject = paramCollection;
    if ((paramCollection instanceof zzfs)) {
      localObject = ((zzfs)paramCollection).zzd();
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
  
  public final Object zza(int paramInt)
  {
    return this.zzc.get(paramInt);
  }
  
  public final void zza(zzdv paramzzdv)
  {
    zzc();
    this.zzc.add(paramzzdv);
    this.modCount += 1;
  }
  
  public final List<?> zzd()
  {
    return Collections.unmodifiableList(this.zzc);
  }
  
  public final zzfs zze()
  {
    if (zza()) {
      return new zzhr(this);
    }
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */