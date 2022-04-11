package com.google.android.gms.internal.mlkit_vision_barcode;

final class zzgb
  implements zzhl
{
  private static final zzgb zza = new zzgb();
  
  public static zzgb zza()
  {
    return zza;
  }
  
  public final boolean zza(Class<?> paramClass)
  {
    return zzga.class.isAssignableFrom(paramClass);
  }
  
  public final zzhi zzb(Class<?> paramClass)
  {
    if (!zzga.class.isAssignableFrom(paramClass))
    {
      paramClass = paramClass.getName();
      if (paramClass.length() != 0) {
        paramClass = "Unsupported message type: ".concat(paramClass);
      } else {
        paramClass = new String("Unsupported message type: ");
      }
      throw new IllegalArgumentException(paramClass);
    }
    try
    {
      zzhi localzzhi = (zzhi)zzga.zza(paramClass.asSubclass(zzga.class)).zza(zzga.zze.zzc, null, null);
      return localzzhi;
    }
    catch (Exception localException)
    {
      paramClass = paramClass.getName();
      if (paramClass.length() != 0) {
        paramClass = "Unable to get message info for ".concat(paramClass);
      } else {
        paramClass = new String("Unable to get message info for ");
      }
      throw new RuntimeException(paramClass, localException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */