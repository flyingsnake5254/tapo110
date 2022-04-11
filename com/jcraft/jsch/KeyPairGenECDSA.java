package com.jcraft.jsch;

public abstract interface KeyPairGenECDSA
{
  public abstract byte[] getD();
  
  public abstract byte[] getR();
  
  public abstract byte[] getS();
  
  public abstract void init(int paramInt)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\KeyPairGenECDSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */