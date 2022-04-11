package com.google.android.gms.internal.clearcut;

 enum zzcd
{
  private final boolean zzjk;
  
  static
  {
    zzcd localzzcd1 = new zzcd("SCALAR", 0, false);
    zzjg = localzzcd1;
    zzcd localzzcd2 = new zzcd("VECTOR", 1, true);
    zzjh = localzzcd2;
    zzcd localzzcd3 = new zzcd("PACKED_VECTOR", 2, true);
    zzji = localzzcd3;
    zzcd localzzcd4 = new zzcd("MAP", 3, false);
    zzjj = localzzcd4;
    zzjl = new zzcd[] { localzzcd1, localzzcd2, localzzcd3, localzzcd4 };
  }
  
  private zzcd(boolean paramBoolean)
  {
    this.zzjk = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzcd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */