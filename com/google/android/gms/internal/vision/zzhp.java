package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzhp
  extends zzfc<String>
  implements zzho, RandomAccess
{
  private static final zzhp zzyq;
  private static final zzho zzyr;
  private final List<Object> zzys;
  
  static
  {
    zzhp localzzhp = new zzhp();
    zzyq = localzzhp;
    localzzhp.zzdq();
    zzyr = localzzhp;
  }
  
  public zzhp()
  {
    this(10);
  }
  
  public zzhp(int paramInt)
  {
    this(new ArrayList(paramInt));
  }
  
  private zzhp(ArrayList<Object> paramArrayList)
  {
    this.zzys = paramArrayList;
  }
  
  private static String zzk(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof zzfm)) {
      return ((zzfm)paramObject).zzes();
    }
    return zzgy.zzh((byte[])paramObject);
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    zzdr();
    Object localObject = paramCollection;
    if ((paramCollection instanceof zzho)) {
      localObject = ((zzho)paramCollection).zzgy();
    }
    boolean bool = this.zzys.addAll(paramInt, (Collection)localObject);
    this.modCount += 1;
    return bool;
  }
  
  public final boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public final void clear()
  {
    zzdr();
    this.zzys.clear();
    this.modCount += 1;
  }
  
  public final Object getRaw(int paramInt)
  {
    return this.zzys.get(paramInt);
  }
  
  public final int size()
  {
    return this.zzys.size();
  }
  
  public final void zzc(zzfm paramzzfm)
  {
    zzdr();
    this.zzys.add(paramzzfm);
    this.modCount += 1;
  }
  
  public final List<?> zzgy()
  {
    return Collections.unmodifiableList(this.zzys);
  }
  
  public final zzho zzgz()
  {
    if (zzdp()) {
      return new zzjt(this);
    }
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzhp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */