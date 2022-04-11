package com.google.android.gms.internal.vision;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class zzgy
{
  private static final Charset ISO_8859_1;
  static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final byte[] zzxr;
  private static final ByteBuffer zzxs;
  private static final zzfy zzxt;
  
  static
  {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] arrayOfByte = new byte[0];
    zzxr = arrayOfByte;
    zzxs = ByteBuffer.wrap(arrayOfByte);
    zzxt = zzfy.zza(arrayOfByte, 0, arrayOfByte.length, false);
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
  
  static <T> T zza(T paramT, String paramString)
  {
    Objects.requireNonNull(paramT, paramString);
    return paramT;
  }
  
  public static int zzab(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  static Object zzb(Object paramObject1, Object paramObject2)
  {
    return ((zzih)paramObject1).zzgj().zza((zzih)paramObject2).zzgc();
  }
  
  static boolean zzf(zzih paramzzih)
  {
    if ((paramzzih instanceof zzfa)) {
      paramzzih = (zzfa)paramzzih;
    }
    return false;
  }
  
  public static boolean zzg(byte[] paramArrayOfByte)
  {
    return zzjx.zzg(paramArrayOfByte);
  }
  
  public static String zzh(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, UTF_8);
  }
  
  public static int zzm(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzgy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */