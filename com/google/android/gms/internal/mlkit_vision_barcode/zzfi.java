package com.google.android.gms.internal.mlkit_vision_barcode;

public abstract class zzfi
{
  private int zza = 100;
  private int zzb = Integer.MAX_VALUE;
  private boolean zzc = false;
  
  static zzfi zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new zzfk(paramArrayOfByte, 0, paramInt2, false, null);
    try
    {
      paramArrayOfByte.zza(paramInt2);
      return paramArrayOfByte;
    }
    catch (zzgk paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  public abstract int zza();
  
  public abstract int zza(int paramInt)
    throws zzgk;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */