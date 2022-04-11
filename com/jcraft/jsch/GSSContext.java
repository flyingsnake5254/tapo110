package com.jcraft.jsch;

public abstract interface GSSContext
{
  public abstract void create(String paramString1, String paramString2)
    throws JSchException;
  
  public abstract void dispose();
  
  public abstract byte[] getMIC(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract byte[] init(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws JSchException;
  
  public abstract boolean isEstablished();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\GSSContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */