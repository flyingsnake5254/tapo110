package com.tplink.libtpanalytics.utils.l;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class b
{
  public static String a(String paramString1, String paramString2)
    throws Exception
  {
    paramString2 = new SecretKeySpec(paramString2.getBytes("UTF-8"), "HmacSHA1");
    Mac localMac = Mac.getInstance("HmacSHA1");
    localMac.init(paramString2);
    return b(localMac.doFinal(paramString1.getBytes("UTF-8"))).toString().toLowerCase();
  }
  
  public static StringBuilder b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++) {
      localStringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[j]) }));
    }
    return localStringBuilder;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\l\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */