package com.jcraft.jsch;

public abstract interface KeyPairGenDSA
{
  public abstract byte[] getG();
  
  public abstract byte[] getP();
  
  public abstract byte[] getQ();
  
  public abstract byte[] getX();
  
  public abstract byte[] getY();
  
  public abstract void init(int paramInt)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\KeyPairGenDSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */