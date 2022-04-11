package com.google.android.gms.internal.mlkit_vision_common;

final class zzdr
{
  private final zzdw zza;
  private final byte[] zzb;
  
  private zzdr(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    this.zzb = arrayOfByte;
    this.zza = zzdw.zza(arrayOfByte);
  }
  
  public final zzdj zza()
  {
    this.zza.zzb();
    return new zzdt(this.zzb);
  }
  
  public final zzdw zzb()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzdr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */