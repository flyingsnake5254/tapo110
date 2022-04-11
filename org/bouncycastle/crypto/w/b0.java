package org.bouncycastle.crypto.w;

import org.bouncycastle.crypto.e;

public class b0
  implements e
{
  private byte[] c;
  private e d;
  
  public b0(e parame, byte[] paramArrayOfByte)
  {
    this(parame, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public b0(e parame, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    this.c = arrayOfByte;
    this.d = parame;
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
  }
  
  public byte[] a()
  {
    return this.c;
  }
  
  public e b()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */