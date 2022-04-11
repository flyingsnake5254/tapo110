package com.jcraft.jsch;

public abstract interface SignatureRSA
  extends Signature
{
  public abstract void setPrvKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception;
  
  public abstract void setPubKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\SignatureRSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */