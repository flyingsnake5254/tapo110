package com.jcraft.jsch;

public abstract interface DH
{
  public abstract void checkRange()
    throws Exception;
  
  public abstract byte[] getE()
    throws Exception;
  
  public abstract byte[] getK()
    throws Exception;
  
  public abstract void init()
    throws Exception;
  
  public abstract void setF(byte[] paramArrayOfByte);
  
  public abstract void setG(byte[] paramArrayOfByte);
  
  public abstract void setP(byte[] paramArrayOfByte);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\DH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */