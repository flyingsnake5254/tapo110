package org.bouncycastle.crypto.w;

import org.bouncycastle.crypto.e;

public class a0
  implements e
{
  private byte[] c;
  
  public a0(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public a0(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    this.c = arrayOfByte;
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
  }
  
  public byte[] a()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */