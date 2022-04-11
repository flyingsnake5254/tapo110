package com.jcraft.jsch;

public class CipherNone
  implements Cipher
{
  private static final int bsize = 16;
  private static final int ivsize = 8;
  
  public int getBlockSize()
  {
    return 16;
  }
  
  public int getIVSize()
  {
    return 8;
  }
  
  public void init(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {}
  
  public boolean isCBC()
  {
    return false;
  }
  
  public void update(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws Exception
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\CipherNone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */