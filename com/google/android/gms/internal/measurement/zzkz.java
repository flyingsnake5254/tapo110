package com.google.android.gms.internal.measurement;

final class zzkz
  implements zzlg
{
  private final zzlg[] zza;
  
  zzkz(zzlg... paramVarArgs)
  {
    this.zza = paramVarArgs;
  }
  
  public final boolean zzb(Class<?> paramClass)
  {
    zzlg[] arrayOfzzlg = this.zza;
    for (int i = 0; i < 2; i++) {
      if (arrayOfzzlg[i].zzb(paramClass)) {
        return true;
      }
    }
    return false;
  }
  
  public final zzlf zzc(Class<?> paramClass)
  {
    zzlg[] arrayOfzzlg = this.zza;
    for (int i = 0; i < 2; i++)
    {
      zzlg localzzlg = arrayOfzzlg[i];
      if (localzzlg.zzb(paramClass)) {
        return localzzlg.zzc(paramClass);
      }
    }
    paramClass = paramClass.getName();
    if (paramClass.length() != 0) {
      paramClass = "No factory is available for message type: ".concat(paramClass);
    } else {
      paramClass = new String("No factory is available for message type: ");
    }
    throw new UnsupportedOperationException(paramClass);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzkz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */