package com.jcraft.jsch.jcraft;

import com.jcraft.jsch.MAC;
import java.io.PrintStream;
import java.security.MessageDigest;

public class HMACMD5
  extends HMAC
  implements MAC
{
  private static final String name = "hmac-md5";
  
  public HMACMD5()
  {
    MessageDigest localMessageDigest2;
    try
    {
      MessageDigest localMessageDigest1 = MessageDigest.getInstance("MD5");
    }
    catch (Exception localException)
    {
      System.err.println(localException);
      localMessageDigest2 = null;
    }
    setH(localMessageDigest2);
  }
  
  public String getName()
  {
    return "hmac-md5";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jcraft\HMACMD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */