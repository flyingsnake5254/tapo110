package com.jcraft.jsch.jce;

public class HMACSHA1
  extends HMAC
{
  public HMACSHA1()
  {
    this.name = "hmac-sha1";
    this.bsize = 20;
    this.algorithm = "HmacSHA1";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\HMACSHA1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */