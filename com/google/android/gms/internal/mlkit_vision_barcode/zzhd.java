package com.google.android.gms.internal.mlkit_vision_barcode;

final class zzhd
  implements zzhl
{
  private zzhl[] zza;
  
  zzhd(zzhl... paramVarArgs)
  {
    this.zza = paramVarArgs;
  }
  
  public final boolean zza(Class<?> paramClass)
  {
    zzhl[] arrayOfzzhl = this.zza;
    int i = arrayOfzzhl.length;
    for (int j = 0; j < i; j++) {
      if (arrayOfzzhl[j].zza(paramClass)) {
        return true;
      }
    }
    return false;
  }
  
  public final zzhi zzb(Class<?> paramClass)
  {
    for (zzhl localzzhl : this.zza) {
      if (localzzhl.zza(paramClass)) {
        return localzzhl.zzb(paramClass);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzhd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */