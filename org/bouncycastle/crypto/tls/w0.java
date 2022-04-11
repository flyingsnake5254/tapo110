package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;

class w0
  extends InputStream
{
  private byte[] c = new byte[1];
  private g1 d = null;
  
  w0(g1 paramg1)
  {
    this.d = paramg1;
  }
  
  public int available()
    throws IOException
  {
    return this.d.a();
  }
  
  public void close()
    throws IOException
  {
    this.d.g();
  }
  
  public int read()
    throws IOException
  {
    if (read(this.c) < 0) {
      return -1;
    }
    return this.c[0] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.d.L(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\w0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */