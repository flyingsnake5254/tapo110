package com.jcraft.jsch.jce;

public class HMACSHA512
  extends HMAC
{
  public HMACSHA512()
  {
    this.name = "hmac-sha2-512";
    this.bsize = 64;
    this.algorithm = "HmacSHA512";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\HMACSHA512.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */