package com.jcraft.jsch.jce;

public class HMACSHA256
  extends HMAC
{
  public HMACSHA256()
  {
    this.name = "hmac-sha2-256";
    this.bsize = 32;
    this.algorithm = "HmacSHA256";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\HMACSHA256.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */