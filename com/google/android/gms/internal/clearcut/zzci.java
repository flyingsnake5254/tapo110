package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class zzci
{
  private static final Charset ISO_8859_1;
  static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final byte[] zzkt;
  private static final ByteBuffer zzku;
  private static final zzbk zzkv;
  
  static
  {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] arrayOfByte = new byte[0];
    zzkt = arrayOfByte;
    zzku = ByteBuffer.wrap(arrayOfByte);
    zzkv = zzbk.zza(arrayOfByte, 0, arrayOfByte.length, false);
  }
  
  static <T> T checkNotNull(T paramT)
  {
    Objects.requireNonNull(paramT);
    return paramT;
  }
  
  public static int hashCode(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = zza(i, paramArrayOfByte, 0, i);
    i = j;
    if (j == 0) {
      i = 1;
    }
    return i;
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    for (int i = paramInt2; i < paramInt2 + paramInt3; i++) {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[i];
    }
    return paramInt1;
  }
  
  static Object zza(Object paramObject1, Object paramObject2)
  {
    return ((zzdo)paramObject1).zzbc().zza((zzdo)paramObject2).zzbi();
  }
  
  static <T> T zza(T paramT, String paramString)
  {
    Objects.requireNonNull(paramT, paramString);
    return paramT;
  }
  
  public static int zzc(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  public static boolean zze(byte[] paramArrayOfByte)
  {
    return zzff.zze(paramArrayOfByte);
  }
  
  public static String zzf(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, UTF_8);
  }
  
  static boolean zzf(zzdo paramzzdo)
  {
    return false;
  }
  
  public static int zzl(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */