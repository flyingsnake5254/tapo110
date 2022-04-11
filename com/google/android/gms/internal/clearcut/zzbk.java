package com.google.android.gms.internal.clearcut;

public abstract class zzbk
{
  private static volatile boolean zzft = true;
  private int zzfq = 100;
  private int zzfr = Integer.MAX_VALUE;
  private boolean zzfs = false;
  
  public static long zza(long paramLong)
  {
    return -(paramLong & 1L) ^ paramLong >>> 1;
  }
  
  static zzbk zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new zzbm(paramArrayOfByte, 0, paramInt2, false, null);
    try
    {
      paramArrayOfByte.zzl(paramInt2);
      return paramArrayOfByte;
    }
    catch (zzco paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  public static int zzm(int paramInt)
  {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  public abstract int zzaf();
  
  public abstract int zzl(int paramInt)
    throws zzco;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */