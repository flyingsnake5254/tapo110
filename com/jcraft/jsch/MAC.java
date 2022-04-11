package com.jcraft.jsch;

public abstract interface MAC
{
  public abstract void doFinal(byte[] paramArrayOfByte, int paramInt);
  
  public abstract int getBlockSize();
  
  public abstract String getName();
  
  public abstract void init(byte[] paramArrayOfByte)
    throws Exception;
  
  public abstract void update(int paramInt);
  
  public abstract void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\MAC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */