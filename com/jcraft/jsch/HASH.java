package com.jcraft.jsch;

public abstract interface HASH
{
  public abstract byte[] digest()
    throws Exception;
  
  public abstract int getBlockSize();
  
  public abstract void init()
    throws Exception;
  
  public abstract void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\HASH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */