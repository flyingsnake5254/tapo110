package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzcw
  extends zzav<String>
  implements zzcx, RandomAccess
{
  private static final zzcw zzlq;
  private static final zzcx zzlr;
  private final List<Object> zzls;
  
  static
  {
    zzcw localzzcw = new zzcw();
    zzlq = localzzcw;
    localzzcw.zzv();
    zzlr = localzzcw;
  }
  
  public zzcw()
  {
    this(10);
  }
  
  public zzcw(int paramInt)
  {
    this(new ArrayList(paramInt));
  }
  
  private zzcw(ArrayList<Object> paramArrayList)
  {
    this.zzls = paramArrayList;
  }
  
  private static String zze(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof zzbb)) {
      return ((zzbb)paramObject).zzz();
    }
    return zzci.zzf((byte[])paramObject);
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    zzw();
    Object localObject = paramCollection;
    if ((paramCollection instanceof zzcx)) {
      localObject = ((zzcx)paramCollection).zzbt();
    }
    boolean bool = this.zzls.addAll(paramInt, (Collection)localObject);
    this.modCount += 1;
    return bool;
  }
  
  public final boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public final void clear()
  {
    zzw();
    this.zzls.clear();
    this.modCount += 1;
  }
  
  public final Object getRaw(int paramInt)
  {
    return this.zzls.get(paramInt);
  }
  
  public final int size()
  {
    return this.zzls.size();
  }
  
  public final List<?> zzbt()
  {
    return Collections.unmodifiableList(this.zzls);
  }
  
  public final zzcx zzbu()
  {
    if (zzu()) {
      return new zzfa(this);
    }
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */