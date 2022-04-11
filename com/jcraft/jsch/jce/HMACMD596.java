package com.jcraft.jsch.jce;

public class HMACMD596
  extends HMACMD5
{
  private final byte[] _buf16 = new byte[16];
  
  public HMACMD596()
  {
    this.name = "hmac-md5-96";
  }
  
  public void doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    super.doFinal(this._buf16, 0);
    System.arraycopy(this._buf16, 0, paramArrayOfByte, paramInt, 12);
  }
  
  public int getBlockSize()
  {
    return 12;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\HMACMD596.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */