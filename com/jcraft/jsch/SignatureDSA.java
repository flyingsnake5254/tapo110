package com.jcraft.jsch;

public abstract interface SignatureDSA
  extends Signature
{
  public abstract void setPrvKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
    throws Exception;
  
  public abstract void setPubKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\SignatureDSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */