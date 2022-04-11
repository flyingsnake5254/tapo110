package org.bouncycastle.crypto.u;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.e;

public abstract interface a
{
  public abstract void a(boolean paramBoolean, e parame)
    throws IllegalArgumentException;
  
  public abstract int b(int paramInt);
  
  public abstract int c(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws DataLengthException;
  
  public abstract int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws IllegalStateException, InvalidCipherTextException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\u\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */