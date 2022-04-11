package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class g
{
  private byte[] a;
  private int b = 0;
  private int c = 0;
  private boolean d = false;
  
  public g(int paramInt)
  {
    byte[] arrayOfByte;
    if (paramInt == 0) {
      arrayOfByte = m1.a;
    } else {
      arrayOfByte = new byte[paramInt];
    }
    this.a = arrayOfByte;
  }
  
  public g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = true;
  }
  
  public static int d(int paramInt)
  {
    paramInt |= paramInt >> 1;
    paramInt |= paramInt >> 2;
    paramInt |= paramInt >> 4;
    paramInt |= paramInt >> 8;
    return (paramInt | paramInt >> 16) + 1;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.d)
    {
      int i = this.b;
      int j = this.c;
      if (i + j + paramInt2 > this.a.length)
      {
        j = d(j + paramInt2);
        byte[] arrayOfByte1 = this.a;
        if (j > arrayOfByte1.length)
        {
          byte[] arrayOfByte2 = new byte[j];
          System.arraycopy(arrayOfByte1, this.b, arrayOfByte2, 0, this.c);
          this.a = arrayOfByte2;
        }
        else
        {
          System.arraycopy(arrayOfByte1, this.b, arrayOfByte1, 0, this.c);
        }
        this.b = 0;
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b + this.c, paramInt2);
      this.c += paramInt2;
      return;
    }
    throw new IllegalStateException("Cannot add data to read-only buffer");
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void c(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    if (paramInt <= this.c)
    {
      paramOutputStream.write(this.a, this.b, paramInt);
      return;
    }
    paramOutputStream = new StringBuilder();
    paramOutputStream.append("Cannot copy ");
    paramOutputStream.append(paramInt);
    paramOutputStream.append(" bytes, only got ");
    paramOutputStream.append(this.c);
    throw new IllegalStateException(paramOutputStream.toString());
  }
  
  public void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte.length - paramInt1 >= paramInt2)
    {
      if (this.c - paramInt3 >= paramInt2)
      {
        System.arraycopy(this.a, this.b + paramInt3, paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      throw new IllegalStateException("Not enough data to read");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Buffer size of ");
    localStringBuilder.append(paramArrayOfByte.length);
    localStringBuilder.append(" is too small for a read of ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" bytes");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public ByteArrayInputStream f(int paramInt)
  {
    int i = this.c;
    if (paramInt <= i)
    {
      int j = this.b;
      this.c = (i - paramInt);
      this.b = (j + paramInt);
      return new ByteArrayInputStream(this.a, j, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot read ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" bytes, only got ");
    localStringBuilder.append(this.c);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void g(int paramInt)
  {
    int i = this.c;
    if (paramInt <= i)
    {
      this.c = (i - paramInt);
      this.b += paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot remove ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" bytes, only got ");
    localStringBuilder.append(this.c);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    e(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    g(paramInt3 + paramInt2);
  }
  
  public byte[] i(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt1];
    h(arrayOfByte, 0, paramInt1, paramInt2);
    return arrayOfByte;
  }
  
  public void j()
  {
    int i = this.c;
    if (i == 0) {}
    byte[] arrayOfByte2;
    for (this.a = m1.a;; this.a = arrayOfByte2)
    {
      this.b = 0;
      break;
      i = d(i);
      byte[] arrayOfByte1 = this.a;
      if (i >= arrayOfByte1.length) {
        break;
      }
      arrayOfByte2 = new byte[i];
      System.arraycopy(arrayOfByte1, this.b, arrayOfByte2, 0, this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */