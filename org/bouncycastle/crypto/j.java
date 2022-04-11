package org.bouncycastle.crypto;

public abstract interface j
{
  public abstract int a();
  
  public abstract String b();
  
  public abstract void c(byte paramByte)
    throws IllegalStateException;
  
  public abstract void d(e parame)
    throws IllegalArgumentException;
  
  public abstract int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException;
  
  public abstract void reset();
  
  public abstract void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalStateException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */