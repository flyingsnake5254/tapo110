package com.google.android.gms.internal.vision;

import java.io.IOException;

public abstract class zzfy
{
  int zzsu;
  int zzsv = 100;
  private int zzsw = Integer.MAX_VALUE;
  zzgd zzsx;
  private boolean zzsy = false;
  
  static zzfy zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new zzga(paramArrayOfByte, 0, paramInt2, false, null);
    try
    {
      paramArrayOfByte.zzat(paramInt2);
      return paramArrayOfByte;
    }
    catch (zzhh paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  public static int zzav(int paramInt)
  {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  public static long zzr(long paramLong)
  {
    return -(paramLong & 1L) ^ paramLong >>> 1;
  }
  
  public abstract double readDouble()
    throws IOException;
  
  public abstract float readFloat()
    throws IOException;
  
  public abstract String readString()
    throws IOException;
  
  public abstract void zzar(int paramInt)
    throws zzhh;
  
  public abstract boolean zzas(int paramInt)
    throws IOException;
  
  public abstract int zzat(int paramInt)
    throws zzhh;
  
  public abstract void zzau(int paramInt);
  
  public abstract boolean zzdu()
    throws IOException;
  
  public abstract long zzdx()
    throws IOException;
  
  public abstract long zzdy()
    throws IOException;
  
  public abstract int zzdz()
    throws IOException;
  
  public abstract long zzea()
    throws IOException;
  
  public abstract int zzeb()
    throws IOException;
  
  public abstract boolean zzec()
    throws IOException;
  
  public abstract String zzed()
    throws IOException;
  
  public abstract zzfm zzee()
    throws IOException;
  
  public abstract int zzef()
    throws IOException;
  
  public abstract int zzeg()
    throws IOException;
  
  public abstract int zzeh()
    throws IOException;
  
  public abstract long zzei()
    throws IOException;
  
  public abstract int zzej()
    throws IOException;
  
  public abstract long zzek()
    throws IOException;
  
  public abstract int zzey()
    throws IOException;
  
  abstract long zzez()
    throws IOException;
  
  public abstract int zzfa();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */