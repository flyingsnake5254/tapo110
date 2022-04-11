package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.b;

class r1
  extends w1
{
  private static final byte[] f = new byte[0];
  private final int q;
  private int x;
  
  r1(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream, paramInt);
    if (paramInt >= 0)
    {
      this.q = paramInt;
      this.x = paramInt;
      if (paramInt == 0) {
        c(true);
      }
      return;
    }
    throw new IllegalArgumentException("negative lengths not allowed");
  }
  
  int a()
  {
    return this.x;
  }
  
  byte[] e()
    throws IOException
  {
    int i = this.x;
    if (i == 0) {
      return f;
    }
    Object localObject = new byte[i];
    i -= b.c(this.c, (byte[])localObject);
    this.x = i;
    if (i == 0)
    {
      c(true);
      return (byte[])localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DEF length ");
    ((StringBuilder)localObject).append(this.q);
    ((StringBuilder)localObject).append(" object truncated by ");
    ((StringBuilder)localObject).append(this.x);
    throw new EOFException(((StringBuilder)localObject).toString());
  }
  
  public int read()
    throws IOException
  {
    if (this.x == 0) {
      return -1;
    }
    int i = this.c.read();
    if (i >= 0)
    {
      int j = this.x - 1;
      this.x = j;
      if (j == 0) {
        c(true);
      }
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DEF length ");
    localStringBuilder.append(this.q);
    localStringBuilder.append(" object truncated by ");
    localStringBuilder.append(this.x);
    throw new EOFException(localStringBuilder.toString());
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.x;
    if (i == 0) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, i);
    paramInt1 = this.c.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 >= 0)
    {
      paramInt2 = this.x - paramInt1;
      this.x = paramInt2;
      if (paramInt2 == 0) {
        c(true);
      }
      return paramInt1;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("DEF length ");
    paramArrayOfByte.append(this.q);
    paramArrayOfByte.append(" object truncated by ");
    paramArrayOfByte.append(this.x);
    throw new EOFException(paramArrayOfByte.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\r1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */