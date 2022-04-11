package com.google.android.gms.internal.mlkit_common;

final class zzex
  implements zzgi
{
  private static final zzex zza = new zzex();
  
  public static zzex zza()
  {
    return zza;
  }
  
  public final boolean zza(Class<?> paramClass)
  {
    return zzez.class.isAssignableFrom(paramClass);
  }
  
  public final zzgf zzb(Class<?> paramClass)
  {
    if (!zzez.class.isAssignableFrom(paramClass))
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
      zzgf localzzgf = (zzgf)zzez.zza(paramClass.asSubclass(zzez.class)).zza(zzez.zzf.zzc, null, null);
      return localzzgf;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */