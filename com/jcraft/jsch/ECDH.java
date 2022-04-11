package com.jcraft.jsch;

public abstract interface ECDH
{
  public abstract byte[] getQ()
    throws Exception;
  
  public abstract byte[] getSecret(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception;
  
  public abstract void init(int paramInt)
    throws Exception;
  
  public abstract boolean validate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ECDH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */