package com.google.android.gms.internal.measurement;

final class zzjf
  extends zzjg
{
  private final byte[] zza;
  private int zzb;
  private int zzc;
  private int zzd;
  
  public final int zza(int paramInt)
    throws zzkn
  {
    int i = this.zzd;
    this.zzd = 0;
    paramInt = this.zzb + this.zzc;
    this.zzb = paramInt;
    if (paramInt > 0)
    {
      this.zzc = paramInt;
      this.zzb = 0;
    }
    else
    {
      this.zzc = 0;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */