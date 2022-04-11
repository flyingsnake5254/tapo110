package com.jcraft.jsch;

public abstract interface Signature
{
  public abstract void init()
    throws Exception;
  
  public abstract byte[] sign()
    throws Exception;
  
  public abstract void update(byte[] paramArrayOfByte)
    throws Exception;
  
  public abstract boolean verify(byte[] paramArrayOfByte)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\Signature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */