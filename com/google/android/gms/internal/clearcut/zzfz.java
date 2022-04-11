package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public class zzfz
{
  protected volatile int zzrs = -1;
  
  public static final void zza(zzfz paramzzfz, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = zzfs.zzh(paramArrayOfByte, 0, paramInt2);
      paramzzfz.zza(paramArrayOfByte);
      paramArrayOfByte.zzem();
      return;
    }
    catch (IOException paramzzfz)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramzzfz);
    }
  }
  
  public String toString()
  {
    return zzga.zza(this);
  }
  
  public void zza(zzfs paramzzfs)
    throws IOException
  {}
  
  public final int zzas()
  {
    int i = zzen();
    this.zzrs = i;
    return i;
  }
  
  protected int zzen()
  {
    return 0;
  }
  
  public zzfz zzep()
    throws CloneNotSupportedException
  {
    return (zzfz)super.clone();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */