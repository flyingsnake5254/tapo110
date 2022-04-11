package com.jcraft.jsch;

public abstract interface Cipher
{
  public static final int DECRYPT_MODE = 1;
  public static final int ENCRYPT_MODE = 0;
  
  public abstract int getBlockSize();
  
  public abstract int getIVSize();
  
  public abstract void init(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception;
  
  public abstract boolean isCBC();
  
  public abstract void update(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\Cipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */