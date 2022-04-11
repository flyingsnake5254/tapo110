package com.google.android.gms.internal.mlkit_vision_common;

final class zzfk
  implements zzfs
{
  private zzfs[] zza;
  
  zzfk(zzfs... paramVarArgs)
  {
    this.zza = paramVarArgs;
  }
  
  public final boolean zza(Class<?> paramClass)
  {
    zzfs[] arrayOfzzfs = this.zza;
    int i = arrayOfzzfs.length;
    for (int j = 0; j < i; j++) {
      if (arrayOfzzfs[j].zza(paramClass)) {
        return true;
      }
    }
    return false;
  }
  
  public final zzft zzb(Class<?> paramClass)
  {
    for (zzfs localzzfs : this.zza) {
      if (localzzfs.zza(paramClass)) {
        return localzzfs.zzb(paramClass);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzfk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */