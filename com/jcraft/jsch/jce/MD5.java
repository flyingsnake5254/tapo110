package com.jcraft.jsch.jce;

import com.jcraft.jsch.HASH;
import java.io.PrintStream;
import java.security.MessageDigest;

public class MD5
  implements HASH
{
  MessageDigest md;
  
  public byte[] digest()
    throws Exception
  {
    return this.md.digest();
  }
  
  public int getBlockSize()
  {
    return 16;
  }
  
  public void init()
    throws Exception
  {
    try
    {
      this.md = MessageDigest.getInstance("MD5");
    }
    catch (Exception localException)
    {
      System.err.println(localException);
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws Exception
  {
    this.md.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\MD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */