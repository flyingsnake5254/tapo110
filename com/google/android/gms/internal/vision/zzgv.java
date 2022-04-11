package com.google.android.gms.internal.vision;

final class zzgv
  implements zzie
{
  private static final zzgv zzwn = new zzgv();
  
  public static zzgv zzfx()
  {
    return zzwn;
  }
  
  public final boolean zza(Class<?> paramClass)
  {
    return zzgx.class.isAssignableFrom(paramClass);
  }
  
  public final zzif zzb(Class<?> paramClass)
  {
    if (!zzgx.class.isAssignableFrom(paramClass))
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
      zzif localzzif = (zzif)zzgx.zzd(paramClass.asSubclass(zzgx.class)).zza(zzgx.zzf.zzxc, null, null);
      return localzzif;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */