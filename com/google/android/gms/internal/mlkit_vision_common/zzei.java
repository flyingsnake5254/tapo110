package com.google.android.gms.internal.mlkit_vision_common;

 enum zzei
{
  private final boolean zze;
  
  static
  {
    zzei localzzei1 = new zzei("SCALAR", 0, false);
    zza = localzzei1;
    zzei localzzei2 = new zzei("VECTOR", 1, true);
    zzb = localzzei2;
    zzei localzzei3 = new zzei("PACKED_VECTOR", 2, true);
    zzc = localzzei3;
    zzei localzzei4 = new zzei("MAP", 3, false);
    zzd = localzzei4;
    zzf = new zzei[] { localzzei1, localzzei2, localzzei3, localzzei4 };
  }
  
  private zzei(boolean paramBoolean)
  {
    this.zze = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */