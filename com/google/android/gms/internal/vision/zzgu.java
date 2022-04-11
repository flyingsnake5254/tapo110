package com.google.android.gms.internal.vision;

 enum zzgu
{
  private final boolean zzwl;
  
  static
  {
    zzgu localzzgu1 = new zzgu("SCALAR", 0, false);
    zzwh = localzzgu1;
    zzgu localzzgu2 = new zzgu("VECTOR", 1, true);
    zzwi = localzzgu2;
    zzgu localzzgu3 = new zzgu("PACKED_VECTOR", 2, true);
    zzwj = localzzgu3;
    zzgu localzzgu4 = new zzgu("MAP", 3, false);
    zzwk = localzzgu4;
    zzwm = new zzgu[] { localzzgu1, localzzgu2, localzzgu3, localzzgu4 };
  }
  
  private zzgu(boolean paramBoolean)
  {
    this.zzwl = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */