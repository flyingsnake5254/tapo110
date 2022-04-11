package com.google.android.gms.internal.measurement;

public final class zzge
  extends zzjz<zzgf, zzge>
  implements zzlj
{
  private zzge()
  {
    super(zzgf.zzg());
  }
  
  public final zzge zza(int paramInt)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzgf.zzh((zzgf)this.zza, paramInt);
    return this;
  }
  
  public final zzge zzb(Iterable<? extends Long> paramIterable)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zzgf.zzi((zzgf)this.zza, paramIterable);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */