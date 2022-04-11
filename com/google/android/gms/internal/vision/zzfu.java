package com.google.android.gms.internal.vision;

final class zzfu
{
  private final byte[] buffer;
  private final zzgf zzss;
  
  private zzfu(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    this.buffer = arrayOfByte;
    this.zzss = zzgf.zze(arrayOfByte);
  }
  
  public final zzfm zzew()
  {
    this.zzss.zzfi();
    return new zzfw(this.buffer);
  }
  
  public final zzgf zzex()
  {
    return this.zzss;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */