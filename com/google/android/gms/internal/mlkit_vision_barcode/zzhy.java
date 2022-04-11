package com.google.android.gms.internal.mlkit_vision_barcode;

final class zzhy
  implements zzhi
{
  private final zzhk zza;
  private final String zzb;
  private final Object[] zzc;
  private final int zzd;
  
  zzhy(zzhk paramzzhk, String paramString, Object[] paramArrayOfObject)
  {
    this.zza = paramzzhk;
    this.zzb = paramString;
    this.zzc = paramArrayOfObject;
    int i = paramString.charAt(0);
    if (i < 55296)
    {
      this.zzd = i;
      return;
    }
    int j = i & 0x1FFF;
    int k = 13;
    int m;
    for (i = 1;; i++)
    {
      m = paramString.charAt(i);
      if (m < 55296) {
        break;
      }
      j |= (m & 0x1FFF) << k;
      k += 13;
    }
    this.zzd = (j | m << k);
  }
  
  public final int zza()
  {
    if ((this.zzd & 0x1) == 1) {
      return zzga.zze.zzh;
    }
    return zzga.zze.zzi;
  }
  
  public final boolean zzb()
  {
    return (this.zzd & 0x2) == 2;
  }
  
  public final zzhk zzc()
  {
    return this.zza;
  }
  
  final String zzd()
  {
    return this.zzb;
  }
  
  final Object[] zze()
  {
    return this.zzc;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzhy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */