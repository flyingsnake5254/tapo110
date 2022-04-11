package com.tplink.libtpanalytics.utils.l;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c
{
  public static String a(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 2);
  }
  
  public static byte[] b(String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      paramString = (String)localObject;
    }
    try
    {
      paramString = c(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      return localMessageDigest.digest();
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new RuntimeException("报错内容", paramArrayOfByte);
    }
  }
  
  public static String d(String paramString)
  {
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
      paramString = new java/lang/StringBuffer;
      paramString.<init>();
      for (int i = 0; i < arrayOfByte.length; i++)
      {
        int j = arrayOfByte[i] & 0xFF;
        if (j < 16) {
          paramString.append("0");
        }
        paramString.append(Integer.toHexString(j));
      }
      paramString = paramString.toString().toLowerCase();
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static String e(String paramString)
    throws Exception
  {
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = a(b(paramString));
    }
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\l\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */