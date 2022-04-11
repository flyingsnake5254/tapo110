package com.google.android.gms.internal.vision;

final class zzhw
  implements zzie
{
  private zzie[] zzza;
  
  zzhw(zzie... paramVarArgs)
  {
    this.zzza = paramVarArgs;
  }
  
  public final boolean zza(Class<?> paramClass)
  {
    zzie[] arrayOfzzie = this.zzza;
    int i = arrayOfzzie.length;
    for (int j = 0; j < i; j++) {
      if (arrayOfzzie[j].zza(paramClass)) {
        return true;
      }
    }
    return false;
  }
  
  public final zzif zzb(Class<?> paramClass)
  {
    for (zzie localzzie : this.zzza) {
      if (localzzie.zza(paramClass)) {
        return localzzie.zzb(paramClass);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */