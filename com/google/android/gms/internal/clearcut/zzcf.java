package com.google.android.gms.internal.clearcut;

final class zzcf
  implements zzdn
{
  private static final zzcf zzjo = new zzcf();
  
  public static zzcf zzay()
  {
    return zzjo;
  }
  
  public final boolean zza(Class<?> paramClass)
  {
    return zzcg.class.isAssignableFrom(paramClass);
  }
  
  public final zzdm zzb(Class<?> paramClass)
  {
    if (!zzcg.class.isAssignableFrom(paramClass))
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
      zzdm localzzdm = (zzdm)zzcg.zzc(paramClass.asSubclass(zzcg.class)).zza(zzcg.zzg.zzkf, null, null);
      return localzzdm;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzcf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */