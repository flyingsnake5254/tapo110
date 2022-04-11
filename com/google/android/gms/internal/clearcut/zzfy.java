package com.google.android.gms.internal.clearcut;

import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzfy
{
  private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final Object zzrr = new Object();
  
  public static boolean equals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1 != null) && (paramArrayOfInt1.length != 0)) {
      return Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
    }
    return (paramArrayOfInt2 == null) || (paramArrayOfInt2.length == 0);
  }
  
  public static boolean equals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1 != null) && (paramArrayOfLong1.length != 0)) {
      return Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
    }
    return (paramArrayOfLong2 == null) || (paramArrayOfLong2.length == 0);
  }
  
  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    int i;
    if (paramArrayOfObject1 == null) {
      i = 0;
    } else {
      i = paramArrayOfObject1.length;
    }
    int j;
    if (paramArrayOfObject2 == null) {
      j = 0;
    } else {
      j = paramArrayOfObject2.length;
    }
    int k = 0;
    int m = 0;
    for (;;)
    {
      int n = m;
      if (k < i)
      {
        n = m;
        if (paramArrayOfObject1[k] == null)
        {
          k++;
          continue;
        }
      }
      while ((n < j) && (paramArrayOfObject2[n] == null)) {
        n++;
      }
      if (k >= i) {
        m = 1;
      } else {
        m = 0;
      }
      int i1;
      if (n >= j) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((m != 0) && (i1 != 0)) {
        return true;
      }
      if (m != i1) {
        return false;
      }
      if (!paramArrayOfObject1[k].equals(paramArrayOfObject2[n])) {
        return false;
      }
      k++;
      m = n + 1;
    }
  }
  
  public static int hashCode(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0)) {
      return Arrays.hashCode(paramArrayOfInt);
    }
    return 0;
  }
  
  public static int hashCode(long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length != 0)) {
      return Arrays.hashCode(paramArrayOfLong);
    }
    return 0;
  }
  
  public static int hashCode(Object[] paramArrayOfObject)
  {
    int i = 0;
    int j;
    if (paramArrayOfObject == null) {
      j = 0;
    } else {
      j = paramArrayOfObject.length;
    }
    int m;
    for (int k = 0; i < j; k = m)
    {
      Object localObject = paramArrayOfObject[i];
      m = k;
      if (localObject != null) {
        m = k * 31 + localObject.hashCode();
      }
      i++;
    }
    return k;
  }
  
  public static int zza(byte[][] paramArrayOfByte)
  {
    int i = 0;
    int j;
    if (paramArrayOfByte == null) {
      j = 0;
    } else {
      j = paramArrayOfByte.length;
    }
    int m;
    for (int k = 0; i < j; k = m)
    {
      byte[] arrayOfByte = paramArrayOfByte[i];
      m = k;
      if (arrayOfByte != null) {
        m = k * 31 + Arrays.hashCode(arrayOfByte);
      }
      i++;
    }
    return k;
  }
  
  public static void zza(zzfu paramzzfu1, zzfu paramzzfu2)
  {
    paramzzfu1 = paramzzfu1.zzrj;
    if (paramzzfu1 != null) {
      paramzzfu2.zzrj = ((zzfw)paramzzfu1.clone());
    }
  }
  
  public static boolean zza(byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2)
  {
    int i;
    if (paramArrayOfByte1 == null) {
      i = 0;
    } else {
      i = paramArrayOfByte1.length;
    }
    int j;
    if (paramArrayOfByte2 == null) {
      j = 0;
    } else {
      j = paramArrayOfByte2.length;
    }
    int k = 0;
    int m = 0;
    for (;;)
    {
      int n = m;
      if (k < i)
      {
        n = m;
        if (paramArrayOfByte1[k] == null)
        {
          k++;
          continue;
        }
      }
      while ((n < j) && (paramArrayOfByte2[n] == null)) {
        n++;
      }
      if (k >= i) {
        m = 1;
      } else {
        m = 0;
      }
      int i1;
      if (n >= j) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((m != 0) && (i1 != 0)) {
        return true;
      }
      if (m != i1) {
        return false;
      }
      if (!Arrays.equals(paramArrayOfByte1[k], paramArrayOfByte2[n])) {
        return false;
      }
      k++;
      m = n + 1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */