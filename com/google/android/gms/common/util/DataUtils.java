package com.google.android.gms.common.util;

import android.database.CharArrayBuffer;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.ByteArrayOutputStream;

@KeepForSdk
public final class DataUtils
{
  @KeepForSdk
  public static void copyStringToBuffer(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramCharArrayBuffer.sizeCopied = 0;
    }
    else
    {
      char[] arrayOfChar = paramCharArrayBuffer.data;
      if ((arrayOfChar != null) && (arrayOfChar.length >= paramString.length())) {
        paramString.getChars(0, paramString.length(), paramCharArrayBuffer.data, 0);
      } else {
        paramCharArrayBuffer.data = paramString.toCharArray();
      }
    }
    paramCharArrayBuffer.sizeCopied = paramString.length();
  }
  
  @KeepForSdk
  public static byte[] loadImageBytes(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\DataUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */