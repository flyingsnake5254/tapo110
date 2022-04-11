package com.google.android.gms.internal.mlkit_vision_common;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzfd
  extends zzde<String>
  implements zzfc, RandomAccess
{
  private static final zzfd zza;
  private static final zzfc zzb;
  private final List<Object> zzc;
  
  static
  {
    zzfd localzzfd = new zzfd();
    zza = localzzfd;
    localzzfd.b_();
    zzb = localzzfd;
  }
  
  public zzfd()
  {
    this(10);
  }
  
  public zzfd(int paramInt)
  {
    this(new ArrayList(paramInt));
  }
  
  private zzfd(ArrayList<Object> paramArrayList)
  {
    this.zzc = paramArrayList;
  }
  
  private static String zza(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof zzdj)) {
      return ((zzdj)paramObject).zzb();
    }
    return zzem.zzb((byte[])paramObject);
  }
  
  public final zzfc a_()
  {
    if (zza()) {
      return new zzhf(this);
    }
    return this;
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    zzc();
    Object localObject = paramCollection;
    if ((paramCollection instanceof zzfc)) {
      localObject = ((zzfc)paramCollection).zzb();
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
  
  public final void zza(zzdj paramzzdj)
  {
    zzc();
    this.zzc.add(paramzzdj);
    this.modCount += 1;
  }
  
  public final List<?> zzb()
  {
    return Collections.unmodifiableList(this.zzc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */