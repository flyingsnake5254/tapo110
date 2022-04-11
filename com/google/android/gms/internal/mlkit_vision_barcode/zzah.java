package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class zzah<T>
  implements Iterator<T>
{
  private int zza;
  private int zzb;
  private int zzc;
  
  private zzah(zzaa paramzzaa)
  {
    this.zza = zzaa.zza(paramzzaa);
    this.zzb = paramzzaa.zzd();
    this.zzc = -1;
  }
  
  private final void zza()
  {
    if (zzaa.zza(this.zzd) == this.zza) {
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean hasNext()
  {
    return this.zzb >= 0;
  }
  
  public T next()
  {
    zza();
    if (hasNext())
    {
      int i = this.zzb;
      this.zzc = i;
      Object localObject = zza(i);
      this.zzb = this.zzd.zza(this.zzb);
      return (T)localObject;
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    zza();
    boolean bool;
    if (this.zzc >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    zzh.zza(bool, "no calls to next() since the last call to remove()");
    this.zza += 32;
    zzaa localzzaa = this.zzd;
    localzzaa.remove(localzzaa.zzb[this.zzc]);
    this.zzb = zzaa.zzb(this.zzb, this.zzc);
    this.zzc = -1;
  }
  
  abstract T zza(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */