package com.google.android.gms.internal.mlkit_vision_common;

final class zzel
  implements zzfs
{
  private static final zzel zza = new zzel();
  
  public static zzel zza()
  {
    return zza;
  }
  
  public final boolean zza(Class<?> paramClass)
  {
    return zzek.class.isAssignableFrom(paramClass);
  }
  
  public final zzft zzb(Class<?> paramClass)
  {
    if (!zzek.class.isAssignableFrom(paramClass))
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
      zzft localzzft = (zzft)zzek.zza(paramClass.asSubclass(zzek.class)).zza(zzek.zze.zzc, null, null);
      return localzzft;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */