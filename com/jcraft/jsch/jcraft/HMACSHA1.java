package com.jcraft.jsch.jcraft;

import com.jcraft.jsch.MAC;
import java.io.PrintStream;
import java.security.MessageDigest;

public class HMACSHA1
  extends HMAC
  implements MAC
{
  private static final String name = "hmac-sha1";
  
  public HMACSHA1()
  {
    MessageDigest localMessageDigest2;
    try
    {
      MessageDigest localMessageDigest1 = MessageDigest.getInstance("SHA-1");
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
    return "hmac-sha1";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jcraft\HMACSHA1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */