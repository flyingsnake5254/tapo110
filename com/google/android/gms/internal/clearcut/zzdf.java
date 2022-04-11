package com.google.android.gms.internal.clearcut;

final class zzdf
  implements zzdn
{
  private zzdn[] zzma;
  
  zzdf(zzdn... paramVarArgs)
  {
    this.zzma = paramVarArgs;
  }
  
  public final boolean zza(Class<?> paramClass)
  {
    zzdn[] arrayOfzzdn = this.zzma;
    int i = arrayOfzzdn.length;
    for (int j = 0; j < i; j++) {
      if (arrayOfzzdn[j].zza(paramClass)) {
        return true;
      }
    }
    return false;
  }
  
  public final zzdm zzb(Class<?> paramClass)
  {
    for (zzdn localzzdn : this.zzma) {
      if (localzzdn.zza(paramClass)) {
        return localzzdn.zzb(paramClass);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */