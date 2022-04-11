package com.google.android.gms.common.util;

import android.util.Base64;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class Base64Utils
{
  @KeepForSdk
  public static byte[] decode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Base64.decode(paramString, 0);
  }
  
  @KeepForSdk
  public static byte[] decodeUrlSafe(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Base64.decode(paramString, 10);
  }
  
  @KeepForSdk
  public static byte[] decodeUrlSafeNoPadding(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Base64.decode(paramString, 11);
  }
  
  @KeepForSdk
  public static String encode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return Base64.encodeToString(paramArrayOfByte, 0);
  }
  
  @KeepForSdk
  public static String encodeUrlSafe(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return Base64.encodeToString(paramArrayOfByte, 10);
  }
  
  @KeepForSdk
  public static String encodeUrlSafeNoPadding(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return Base64.encodeToString(paramArrayOfByte, 11);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\Base64Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */