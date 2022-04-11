package com.google.android.gms.internal.mlkit_common;

 enum zzey
{
  private final boolean zze;
  
  static
  {
    zzey localzzey1 = new zzey("SCALAR", 0, false);
    zza = localzzey1;
    zzey localzzey2 = new zzey("VECTOR", 1, true);
    zzb = localzzey2;
    zzey localzzey3 = new zzey("PACKED_VECTOR", 2, true);
    zzc = localzzey3;
    zzey localzzey4 = new zzey("MAP", 3, false);
    zzd = localzzey4;
    zzf = new zzey[] { localzzey1, localzzey2, localzzey3, localzzey4 };
  }
  
  private zzey(boolean paramBoolean)
  {
    this.zze = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */