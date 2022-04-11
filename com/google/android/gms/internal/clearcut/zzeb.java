package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

final class zzeb<E>
  extends zzav<E>
{
  private static final zzeb<Object> zznf;
  private final List<E> zzls;
  
  static
  {
    zzeb localzzeb = new zzeb();
    zznf = localzzeb;
    localzzeb.zzv();
  }
  
  zzeb()
  {
    this(new ArrayList(10));
  }
  
  private zzeb(List<E> paramList)
  {
    this.zzls = paramList;
  }
  
  public static <E> zzeb<E> zzcn()
  {
    return zznf;
  }
  
  public final void add(int paramInt, E paramE)
  {
    zzw();
    this.zzls.add(paramInt, paramE);
    this.modCount += 1;
  }
  
  public final E get(int paramInt)
  {
    return (E)this.zzls.get(paramInt);
  }
  
  public final E remove(int paramInt)
  {
    zzw();
    Object localObject = this.zzls.remove(paramInt);
    this.modCount += 1;
    return (E)localObject;
  }
  
  public final E set(int paramInt, E paramE)
  {
    zzw();
    paramE = this.zzls.set(paramInt, paramE);
    this.modCount += 1;
    return paramE;
  }
  
  public final int size()
  {
    return this.zzls.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */