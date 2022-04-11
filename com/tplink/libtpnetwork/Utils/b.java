package com.tplink.libtpnetwork.Utils;

import android.content.Context;
import b.d.w.h.a;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class b
{
  private String a = null;
  private final String b = "0123456789ABCDEF";
  
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  private void a(StringBuffer paramStringBuffer, byte paramByte)
  {
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte >> 4 & 0xF));
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte & 0xF));
  }
  
  public byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte1, "AES");
    paramArrayOfByte1 = Cipher.getInstance("AES");
    paramArrayOfByte1.init(2, localSecretKeySpec);
    return paramArrayOfByte1.doFinal(paramArrayOfByte2);
  }
  
  public String c(String paramString, Context paramContext)
    throws Exception
  {
    String str1 = this.a;
    String str2 = paramString;
    if (str1 != null) {
      str2 = d(paramString, paramContext, str1);
    }
    return str2;
  }
  
  public String d(String paramString1, Context paramContext, String paramString2)
    throws Exception
  {
    return new String(b(a.f(paramString2.getBytes("utf-8")), h(paramString1)));
  }
  
  public byte[] e(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "AES");
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(1, paramArrayOfByte1);
    return localCipher.doFinal(paramArrayOfByte2);
  }
  
  public String f(String paramString, Context paramContext)
    throws Exception
  {
    String str1 = this.a;
    String str2 = paramString;
    if (str1 != null) {
      str2 = g(paramString, paramContext, str1);
    }
    return str2;
  }
  
  public String g(String paramString1, Context paramContext, String paramString2)
    throws Exception
  {
    return i(e(a.f(paramString2.getBytes("utf-8")), paramString1.getBytes()));
  }
  
  public byte[] h(String paramString)
  {
    int i = paramString.length() / 2;
    byte[] arrayOfByte = new byte[i];
    for (int j = 0; j < i; j++)
    {
      int k = j * 2;
      arrayOfByte[j] = Integer.valueOf(paramString.substring(k, k + 2), 16).byteValue();
    }
    return arrayOfByte;
  }
  
  public String i(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      a(localStringBuffer, paramArrayOfByte[i]);
    }
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */