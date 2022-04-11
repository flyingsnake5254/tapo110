package com.google.android.gms.internal.mlkit_common;

import java.util.AbstractCollection;
import java.util.List;

final class zzo<E>
  extends zzk<E>
{
  private final zzl<E> zza;
  
  zzo(zzl<E> paramzzl, int paramInt)
  {
    super(paramzzl.size(), paramInt);
    this.zza = paramzzl;
  }
  
  protected final E zza(int paramInt)
  {
    return (E)this.zza.get(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */