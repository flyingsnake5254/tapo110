package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
@ShowFirstParty
public class Hex
{
  private static final char[] zzgy = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final char[] zzgz = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  @KeepForSdk
  public static String bytesToStringLowercase(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[paramArrayOfByte.length << 1];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      int m = j + 1;
      char[] arrayOfChar2 = zzgz;
      arrayOfChar1[j] = ((char)arrayOfChar2[(k >>> 4)]);
      j = m + 1;
      arrayOfChar1[m] = ((char)arrayOfChar2[(k & 0xF)]);
      i++;
    }
    return new String(arrayOfChar1);
  }
  
  @KeepForSdk
  public static String bytesToStringUppercase(byte[] paramArrayOfByte)
  {
    return bytesToStringUppercase(paramArrayOfByte, false);
  }
  
  @KeepForSdk
  public static String bytesToStringUppercase(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = paramArrayOfByte.length;
    StringBuilder localStringBuilder = new StringBuilder(i << 1);
    for (int j = 0; (j < i) && ((!paramBoolean) || (j != i - 1) || ((paramArrayOfByte[j] & 0xFF) != 0)); j++)
    {
      char[] arrayOfChar = zzgy;
      localStringBuilder.append(arrayOfChar[((paramArrayOfByte[j] & 0xF0) >>> 4)]);
      localStringBuilder.append(arrayOfChar[(paramArrayOfByte[j] & 0xF)]);
    }
    return localStringBuilder.toString();
  }
  
  @KeepForSdk
  public static byte[] stringToBytes(String paramString)
    throws IllegalArgumentException
  {
    int i = paramString.length();
    if (i % 2 == 0)
    {
      byte[] arrayOfByte = new byte[i / 2];
      int m;
      for (int j = 0; j < i; j = m)
      {
        int k = j / 2;
        m = j + 2;
        arrayOfByte[k] = ((byte)(byte)Integer.parseInt(paramString.substring(j, m), 16));
      }
      return arrayOfByte;
    }
    throw new IllegalArgumentException("Hex string has odd number of characters");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */