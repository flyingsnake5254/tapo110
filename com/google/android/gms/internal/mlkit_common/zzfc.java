package com.google.android.gms.internal.mlkit_common;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class zzfc
{
  static final Charset zza = Charset.forName("UTF-8");
  public static final byte[] zzb;
  private static final Charset zzc = Charset.forName("ISO-8859-1");
  private static final ByteBuffer zzd;
  private static final zzeh zze;
  
  static
  {
    byte[] arrayOfByte = new byte[0];
    zzb = arrayOfByte;
    zzd = ByteBuffer.wrap(arrayOfByte);
    zze = zzeh.zza(arrayOfByte, 0, arrayOfByte.length, false);
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    for (int i = paramInt2; i < paramInt2 + paramInt3; i++) {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[i];
    }
    return paramInt1;
  }
  
  public static int zza(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  public static int zza(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  static <T> T zza(T paramT)
  {
    Objects.requireNonNull(paramT);
    return paramT;
  }
  
  static Object zza(Object paramObject1, Object paramObject2)
  {
    return ((zzgh)paramObject1).zzm().zza((zzgh)paramObject2).zzg();
  }
  
  static <T> T zza(T paramT, String paramString)
  {
    Objects.requireNonNull(paramT, paramString);
    return paramT;
  }
  
  static boolean zza(zzgh paramzzgh)
  {
    if ((paramzzgh instanceof zzds)) {
      paramzzgh = (zzds)paramzzgh;
    }
    return false;
  }
  
  public static boolean zza(byte[] paramArrayOfByte)
  {
    return zzhy.zza(paramArrayOfByte);
  }
  
  public static String zzb(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, zza);
  }
  
  public static int zzc(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = zza(i, paramArrayOfByte, 0, i);
    i = j;
    if (j == 0) {
      i = 1;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */