package com.jcraft.jsch.jce;

public class HMACMD5
  extends HMAC
{
  public HMACMD5()
  {
    this.name = "hmac-md5";
    this.bsize = 16;
    this.algorithm = "HmacMD5";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\HMACMD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */