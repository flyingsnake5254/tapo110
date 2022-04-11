package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzkr
  extends zzip<String>
  implements RandomAccess, zzks
{
  public static final zzks zza;
  private static final zzkr zzb;
  private final List<Object> zzc;
  
  static
  {
    zzkr localzzkr = new zzkr(10);
    zzb = localzzkr;
    localzzkr.zzb();
    zza = localzzkr;
  }
  
  public zzkr()
  {
    this(10);
  }
  
  public zzkr(int paramInt)
  {
    this.zzc = localArrayList;
  }
  
  private zzkr(ArrayList<Object> paramArrayList)
  {
    this.zzc = paramArrayList;
  }
  
  private static String zzj(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof zzjd)) {
      return ((zzjd)paramObject).zzl(zzkl.zza);
    }
    return zzkl.zzd((byte[])paramObject);
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    zzbM();
    Object localObject = paramCollection;
    if ((paramCollection instanceof zzks)) {
      localObject = ((zzks)paramCollection).zzh();
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
    zzbM();
    this.zzc.clear();
    this.modCount += 1;
  }
  
  public final int size()
  {
    return this.zzc.size();
  }
  
  public final String zzd(int paramInt)
  {
    Object localObject1 = this.zzc.get(paramInt);
    if ((localObject1 instanceof String)) {
      return (String)localObject1;
    }
    if ((localObject1 instanceof zzjd))
    {
      localObject2 = (zzjd)localObject1;
      localObject1 = ((zzjd)localObject2).zzl(zzkl.zza);
      if (((zzjd)localObject2).zzh()) {
        this.zzc.set(paramInt, localObject1);
      }
      return (String)localObject1;
    }
    localObject1 = (byte[])localObject1;
    Object localObject2 = zzkl.zzd((byte[])localObject1);
    if (zzkl.zzc((byte[])localObject1)) {
      this.zzc.set(paramInt, localObject2);
    }
    return (String)localObject2;
  }
  
  public final void zzf(zzjd paramzzjd)
  {
    zzbM();
    this.zzc.add(paramzzjd);
    this.modCount += 1;
  }
  
  public final Object zzg(int paramInt)
  {
    return this.zzc.get(paramInt);
  }
  
  public final List<?> zzh()
  {
    return Collections.unmodifiableList(this.zzc);
  }
  
  public final zzks zzi()
  {
    if (zza()) {
      return new zzmm(this);
    }
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzkr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */