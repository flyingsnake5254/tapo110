package com.google.android.gms.internal.mlkit_common;

public abstract class zzeh
{
  private int zza = 100;
  private int zzb = Integer.MAX_VALUE;
  private boolean zzc = false;
  
  static zzeh zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new zzej(paramArrayOfByte, 0, paramInt2, false, null);
    try
    {
      paramArrayOfByte.zza(paramInt2);
      return paramArrayOfByte;
    }
    catch (zzfh paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  public abstract int zza();
  
  public abstract int zza(int paramInt)
    throws zzfh;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzeh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */