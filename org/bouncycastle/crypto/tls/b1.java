package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;

class b1
  extends OutputStream
{
  private byte[] c = new byte[1];
  private g1 d;
  
  b1(g1 paramg1)
  {
    this.d = paramg1;
  }
  
  public void close()
    throws IOException
  {
    this.d.g();
  }
  
  public void flush()
    throws IOException
  {
    this.d.m();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = this.c;
    arrayOfByte[0] = ((byte)(byte)paramInt);
    write(arrayOfByte, 0, 1);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.d.V(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\b1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */