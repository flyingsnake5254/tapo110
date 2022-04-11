package com.google.android.gms.internal.vision;

import java.util.AbstractCollection;
import java.util.List;

final class zzdj<E>
  extends zzdg<E>
{
  private final zzdk<E> zzlz;
  
  zzdj(zzdk<E> paramzzdk, int paramInt)
  {
    super(paramzzdk.size(), paramInt);
    this.zzlz = paramzzdk;
  }
  
  protected final E get(int paramInt)
  {
    return (E)this.zzlz.get(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */