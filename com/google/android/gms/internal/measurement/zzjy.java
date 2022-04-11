package com.google.android.gms.internal.measurement;

final class zzjy
  implements zzlg
{
  private static final zzjy zza = new zzjy();
  
  public static zzjy zza()
  {
    return zza;
  }
  
  public final boolean zzb(Class<?> paramClass)
  {
    return zzkd.class.isAssignableFrom(paramClass);
  }
  
  public final zzlf zzc(Class<?> paramClass)
  {
    if (!zzkd.class.isAssignableFrom(paramClass))
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
      zzlf localzzlf = (zzlf)zzkd.zzbx(paramClass.asSubclass(zzkd.class)).zzl(3, null, null);
      return localzzlf;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */