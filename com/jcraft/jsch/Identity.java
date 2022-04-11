package com.jcraft.jsch;

public abstract interface Identity
{
  public abstract void clear();
  
  public abstract boolean decrypt();
  
  public abstract String getAlgName();
  
  public abstract String getName();
  
  public abstract byte[] getPublicKeyBlob();
  
  public abstract byte[] getSignature(byte[] paramArrayOfByte);
  
  public abstract boolean isEncrypted();
  
  public abstract boolean setPassphrase(byte[] paramArrayOfByte)
    throws JSchException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\Identity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */