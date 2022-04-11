package b.d.p;

import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c
{
  private static final String a = "c";
  
  public static byte[] a(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    MessageDigest localMessageDigest = MessageDigest.getInstance("md5");
    localMessageDigest.update(paramArrayOfByte);
    return localMessageDigest.digest();
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return paramString;
    }
    try
    {
      String str = c(a(paramString.getBytes()));
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      Log.e(a, localNoSuchAlgorithmException.toString());
    }
    return paramString;
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++)
    {
      String str = Integer.toHexString(paramArrayOfByte[j] & 0xFF);
      if (str.length() == 1)
      {
        localStringBuilder.append("0");
        localStringBuilder.append(str);
      }
      else
      {
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\p\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */