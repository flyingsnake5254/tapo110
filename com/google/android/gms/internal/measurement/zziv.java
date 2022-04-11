package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class zziv
  extends zzix
{
  private int zzb = 0;
  private final int zzc;
  
  zziv(zzjd paramzzjd)
  {
    this.zzc = paramzzjd.zzc();
  }
  
  public final boolean hasNext()
  {
    return this.zzb < this.zzc;
  }
  
  public final byte zza()
  {
    int i = this.zzb;
    if (i < this.zzc)
    {
      this.zzb = (i + 1);
      return this.zza.zzb(i);
    }
    throw new NoSuchElementException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zziv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */