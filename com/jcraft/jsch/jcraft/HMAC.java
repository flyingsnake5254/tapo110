package com.jcraft.jsch.jcraft;

import java.security.MessageDigest;

class HMAC
{
  private static final int B = 64;
  private int bsize = 0;
  private byte[] k_ipad = null;
  private byte[] k_opad = null;
  private MessageDigest md = null;
  private final byte[] tmp = new byte[4];
  
  public void doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = this.md.digest();
    this.md.update(this.k_opad, 0, 64);
    this.md.update(arrayOfByte, 0, this.bsize);
    try
    {
      this.md.digest(paramArrayOfByte, paramInt, this.bsize);
      this.md.update(this.k_ipad, 0, 64);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;) {}
    }
  }
  
  public int getBlockSize()
  {
    return this.bsize;
  }
  
  public void init(byte[] paramArrayOfByte)
    throws Exception
  {
    this.md.reset();
    int i = paramArrayOfByte.length;
    int j = this.bsize;
    byte[] arrayOfByte = paramArrayOfByte;
    if (i > j)
    {
      arrayOfByte = new byte[j];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, j);
    }
    paramArrayOfByte = arrayOfByte;
    if (arrayOfByte.length > 64)
    {
      this.md.update(arrayOfByte, 0, arrayOfByte.length);
      paramArrayOfByte = this.md.digest();
    }
    arrayOfByte = new byte[64];
    this.k_ipad = arrayOfByte;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    arrayOfByte = new byte[64];
    this.k_opad = arrayOfByte;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    for (j = 0; j < 64; j++)
    {
      paramArrayOfByte = this.k_ipad;
      paramArrayOfByte[j] = ((byte)(byte)(paramArrayOfByte[j] ^ 0x36));
      paramArrayOfByte = this.k_opad;
      paramArrayOfByte[j] = ((byte)(byte)(paramArrayOfByte[j] ^ 0x5C));
    }
    this.md.update(this.k_ipad, 0, 64);
  }
  
  protected void setH(MessageDigest paramMessageDigest)
  {
    this.md = paramMessageDigest;
    this.bsize = paramMessageDigest.getDigestLength();
  }
  
  public void update(int paramInt)
  {
    byte[] arrayOfByte = this.tmp;
    arrayOfByte[0] = ((byte)(byte)(paramInt >>> 24));
    arrayOfByte[1] = ((byte)(byte)(paramInt >>> 16));
    arrayOfByte[2] = ((byte)(byte)(paramInt >>> 8));
    arrayOfByte[3] = ((byte)(byte)paramInt);
    update(arrayOfByte, 0, 4);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.md.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jcraft\HMAC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */