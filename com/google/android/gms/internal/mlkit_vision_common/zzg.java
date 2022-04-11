package com.google.android.gms.internal.mlkit_vision_common;

import java.util.AbstractCollection;
import java.util.List;

final class zzg<E>
  extends zzf<E>
{
  private final zzh<E> zza;
  
  zzg(zzh<E> paramzzh, int paramInt)
  {
    super(paramzzh.size(), paramInt);
    this.zza = paramzzh;
  }
  
  protected final E zza(int paramInt)
  {
    return (E)this.zza.get(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */