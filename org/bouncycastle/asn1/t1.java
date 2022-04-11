package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class t1
  extends w1
{
  private int f;
  private int q;
  private boolean x = false;
  private boolean y = true;
  
  t1(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    super(paramInputStream, paramInt);
    this.f = paramInputStream.read();
    paramInt = paramInputStream.read();
    this.q = paramInt;
    if (paramInt >= 0)
    {
      e();
      return;
    }
    throw new EOFException();
  }
  
  private boolean e()
  {
    if ((!this.x) && (this.y) && (this.f == 0) && (this.q == 0))
    {
      this.x = true;
      c(true);
    }
    return this.x;
  }
  
  void g(boolean paramBoolean)
  {
    this.y = paramBoolean;
    e();
  }
  
  public int read()
    throws IOException
  {
    if (e()) {
      return -1;
    }
    int i = this.c.read();
    if (i >= 0)
    {
      int j = this.f;
      this.f = this.q;
      this.q = i;
      return j;
    }
    throw new EOFException();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if ((!this.y) && (paramInt2 >= 3))
    {
      if (this.x) {
        return -1;
      }
      paramInt2 = this.c.read(paramArrayOfByte, paramInt1 + 2, paramInt2 - 2);
      if (paramInt2 >= 0)
      {
        paramArrayOfByte[paramInt1] = ((byte)(byte)this.f);
        paramArrayOfByte[(paramInt1 + 1)] = ((byte)(byte)this.q);
        this.f = this.c.read();
        paramInt1 = this.c.read();
        this.q = paramInt1;
        if (paramInt1 >= 0) {
          return paramInt2 + 2;
        }
        throw new EOFException();
      }
      throw new EOFException();
    }
    return super.read(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\t1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */