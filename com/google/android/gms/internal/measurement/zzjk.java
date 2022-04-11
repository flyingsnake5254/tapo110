package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzjk
  extends zziu
{
  private static final Logger zzb = Logger.getLogger(zzjk.class.getName());
  private static final boolean zzc = zzmr.zza();
  zzjl zza;
  
  public static int zzA(zzjd paramzzjd)
  {
    int i = paramzzjd.zzc();
    return zzw(i) + i;
  }
  
  static int zzB(zzli paramzzli, zzlt paramzzlt)
  {
    paramzzli = (zzio)paramzzli;
    int i = paramzzli.zzbq();
    int j = i;
    if (i == -1)
    {
      j = paramzzlt.zze(paramzzli);
      paramzzli.zzbr(j);
    }
    return zzw(j) + j;
  }
  
  @Deprecated
  static int zzE(int paramInt, zzli paramzzli, zzlt paramzzlt)
  {
    int i = zzw(paramInt << 3);
    paramzzli = (zzio)paramzzli;
    int j = paramzzli.zzbq();
    paramInt = j;
    if (j == -1)
    {
      paramInt = paramzzlt.zze(paramzzli);
      paramzzli.zzbr(paramInt);
    }
    return i + i + paramInt;
  }
  
  public static zzjk zzt(byte[] paramArrayOfByte)
  {
    return new zzji(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int zzu(int paramInt)
  {
    return zzw(paramInt << 3);
  }
  
  public static int zzv(int paramInt)
  {
    if (paramInt >= 0) {
      return zzw(paramInt);
    }
    return 10;
  }
  
  public static int zzw(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((paramInt & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int zzx(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if (paramLong < 0L) {
      return 10;
    }
    if ((0xFFFFFFF800000000 & paramLong) != 0L)
    {
      paramLong >>>= 28;
      i = 6;
    }
    else
    {
      i = 2;
    }
    int j = i;
    long l = paramLong;
    if ((0xFFFFFFFFFFE00000 & paramLong) != 0L)
    {
      j = i + 2;
      l = paramLong >>> 14;
    }
    int i = j;
    if ((l & 0xFFFFFFFFFFFFC000) != 0L) {
      i = j + 1;
    }
    return i;
  }
  
  public static int zzy(String paramString)
  {
    int i;
    try
    {
      i = zzmw.zzc(paramString);
    }
    catch (zzmv localzzmv)
    {
      i = paramString.getBytes(zzkl.zza).length;
    }
    return zzw(i) + i;
  }
  
  public static int zzz(zzkq paramzzkq)
  {
    int i = paramzzkq.zza();
    return zzw(i) + i;
  }
  
  public final void zzC()
  {
    if (zzs() == 0) {
      return;
    }
    throw new IllegalStateException("Did not write as much data as expected.");
  }
  
  final void zzD(String paramString, zzmv paramzzmv)
    throws IOException
  {
    zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramzzmv);
    paramString = paramString.getBytes(zzkl.zza);
    try
    {
      int i = paramString.length;
      zzl(i);
      zzq(paramString, 0, i);
      return;
    }
    catch (zzjj paramString)
    {
      throw paramString;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new zzjj(paramString);
    }
  }
  
  public abstract void zza(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zzb(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zzc(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zzd(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zze(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void zzf(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void zzg(int paramInt, boolean paramBoolean)
    throws IOException;
  
  public abstract void zzh(int paramInt, String paramString)
    throws IOException;
  
  public abstract void zzi(int paramInt, zzjd paramzzjd)
    throws IOException;
  
  public abstract void zzj(byte paramByte)
    throws IOException;
  
  public abstract void zzk(int paramInt)
    throws IOException;
  
  public abstract void zzl(int paramInt)
    throws IOException;
  
  public abstract void zzm(int paramInt)
    throws IOException;
  
  public abstract void zzn(long paramLong)
    throws IOException;
  
  public abstract void zzo(long paramLong)
    throws IOException;
  
  public abstract void zzq(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract int zzs();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */