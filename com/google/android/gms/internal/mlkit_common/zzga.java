package com.google.android.gms.internal.mlkit_common;

final class zzga
  implements zzgi
{
  private zzgi[] zza;
  
  zzga(zzgi... paramVarArgs)
  {
    this.zza = paramVarArgs;
  }
  
  public final boolean zza(Class<?> paramClass)
  {
    zzgi[] arrayOfzzgi = this.zza;
    int i = arrayOfzzgi.length;
    for (int j = 0; j < i; j++) {
      if (arrayOfzzgi[j].zza(paramClass)) {
        return true;
      }
    }
    return false;
  }
  
  public final zzgf zzb(Class<?> paramClass)
  {
    for (zzgi localzzgi : this.zza) {
      if (localzzgi.zza(paramClass)) {
        return localzzgi.zzb(paramClass);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */