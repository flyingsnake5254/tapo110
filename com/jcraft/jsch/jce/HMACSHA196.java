package com.jcraft.jsch.jce;

public class HMACSHA196
  extends HMACSHA1
{
  private final byte[] _buf20 = new byte[20];
  
  public HMACSHA196()
  {
    this.name = "hmac-sha1-96";
  }
  
  public void doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    super.doFinal(this._buf20, 0);
    System.arraycopy(this._buf20, 0, paramArrayOfByte, paramInt, 12);
  }
  
  public int getBlockSize()
  {
    return 12;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\HMACSHA196.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */