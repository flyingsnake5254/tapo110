package com.jcraft.jsch;

public abstract interface KeyPairGenRSA
{
  public abstract byte[] getC();
  
  public abstract byte[] getD();
  
  public abstract byte[] getE();
  
  public abstract byte[] getEP();
  
  public abstract byte[] getEQ();
  
  public abstract byte[] getN();
  
  public abstract byte[] getP();
  
  public abstract byte[] getQ();
  
  public abstract void init(int paramInt)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\KeyPairGenRSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */