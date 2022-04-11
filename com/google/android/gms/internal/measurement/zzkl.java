package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class zzkl
{
  static final Charset zza = Charset.forName("UTF-8");
  static final Charset zzb = Charset.forName("ISO-8859-1");
  public static final byte[] zzc;
  public static final ByteBuffer zzd;
  public static final zzjg zze;
  
  static
  {
    Object localObject = new byte[0];
    zzc = (byte[])localObject;
    zzd = ByteBuffer.wrap((byte[])localObject);
    localObject = new zzjf((byte[])localObject, 0, 0, false, null);
    try
    {
      ((zzjf)localObject).zza(0);
      zze = (zzjg)localObject;
      return;
    }
    catch (zzkn localzzkn)
    {
      throw new IllegalArgumentException(localzzkn);
    }
  }
  
  static <T> T zza(T paramT)
  {
    Objects.requireNonNull(paramT);
    return paramT;
  }
  
  static <T> T zzb(T paramT, String paramString)
  {
    Objects.requireNonNull(paramT, paramString);
    return paramT;
  }
  
  public static boolean zzc(byte[] paramArrayOfByte)
  {
    return zzmw.zza(paramArrayOfByte);
  }
  
  public static String zzd(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, zza);
  }
  
  public static int zze(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  public static int zzf(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  public static int zzg(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = zzh(i, paramArrayOfByte, 0, i);
    i = j;
    if (j == 0) {
      i = 1;
    }
    return i;
  }
  
  static int zzh(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    for (paramInt2 = 0; paramInt2 < paramInt3; paramInt2++) {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[paramInt2];
    }
    return paramInt1;
  }
  
  static Object zzi(Object paramObject1, Object paramObject2)
  {
    return ((zzli)paramObject1).zzbG().zzau((zzli)paramObject2).zzaD();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzkl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */