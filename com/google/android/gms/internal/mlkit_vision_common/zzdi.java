package com.google.android.gms.internal.mlkit_vision_common;

import java.util.NoSuchElementException;

final class zzdi
  extends zzdk
{
  private int zza = 0;
  private final int zzb;
  
  zzdi(zzdj paramzzdj)
  {
    this.zzb = paramzzdj.zza();
  }
  
  public final boolean hasNext()
  {
    return this.zza < this.zzb;
  }
  
  public final byte zza()
  {
    int i = this.zza;
    if (i < this.zzb)
    {
      this.zza = (i + 1);
      return this.zzc.zzb(i);
    }
    throw new NoSuchElementException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzdi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */