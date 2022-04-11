package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@VisibleForTesting
public class NumberUtils
{
  @KeepForSdk
  public static long parseHexLong(String paramString)
  {
    if (paramString.length() <= 16)
    {
      if (paramString.length() == 16)
      {
        long l = Long.parseLong(paramString.substring(8), 16);
        return Long.parseLong(paramString.substring(0, 8), 16) << 32 | l;
      }
      return Long.parseLong(paramString, 16);
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 37);
    localStringBuilder.append("Invalid input: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" exceeds 16 characters");
    throw new NumberFormatException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\NumberUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */