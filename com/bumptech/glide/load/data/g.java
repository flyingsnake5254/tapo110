package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class g
  extends FilterInputStream
{
  private static final byte[] c;
  private static final int d;
  private static final int f;
  private final byte q;
  private int x;
  
  static
  {
    byte[] arrayOfByte = new byte[29];
    arrayOfByte[0] = -1;
    arrayOfByte[1] = -31;
    arrayOfByte[2] = 0;
    arrayOfByte[3] = 28;
    arrayOfByte[4] = 69;
    arrayOfByte[5] = 120;
    arrayOfByte[6] = 105;
    arrayOfByte[7] = 102;
    arrayOfByte[8] = 0;
    arrayOfByte[9] = 0;
    arrayOfByte[10] = 77;
    arrayOfByte[11] = 77;
    arrayOfByte[12] = 0;
    arrayOfByte[13] = 0;
    arrayOfByte[14] = 0;
    arrayOfByte[15] = 0;
    arrayOfByte[16] = 0;
    arrayOfByte[17] = 8;
    arrayOfByte[18] = 0;
    arrayOfByte[19] = 1;
    arrayOfByte[20] = 1;
    arrayOfByte[21] = 18;
    arrayOfByte[22] = 0;
    arrayOfByte[23] = 2;
    arrayOfByte[24] = 0;
    arrayOfByte[25] = 0;
    arrayOfByte[26] = 0;
    arrayOfByte[27] = 1;
    arrayOfByte[28] = 0;
    arrayOfByte;
    c = arrayOfByte;
    int i = arrayOfByte.length;
    d = i;
    f = i + 2;
  }
  
  public g(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream);
    if ((paramInt >= -1) && (paramInt <= 8))
    {
      this.q = ((byte)(byte)paramInt);
      return;
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("Cannot add invalid orientation: ");
    paramInputStream.append(paramInt);
    throw new IllegalArgumentException(paramInputStream.toString());
  }
  
  public void mark(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    int i = this.x;
    if (i >= 2)
    {
      j = f;
      if (i <= j)
      {
        if (i == j)
        {
          j = this.q;
          break label55;
        }
        j = c[(i - 2)] & 0xFF;
        break label55;
      }
    }
    int j = super.read();
    label55:
    if (j != -1) {
      this.x += 1;
    }
    return j;
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.x;
    int j = f;
    if (i > j)
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    else if (i == j)
    {
      paramArrayOfByte[paramInt1] = ((byte)this.q);
      paramInt1 = 1;
    }
    else if (i < 2)
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, 2 - i);
    }
    else
    {
      paramInt2 = Math.min(j - i, paramInt2);
      System.arraycopy(c, this.x - 2, paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = paramInt2;
    }
    if (paramInt1 > 0) {
      this.x += paramInt1;
    }
    return paramInt1;
  }
  
  public void reset()
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    paramLong = super.skip(paramLong);
    if (paramLong > 0L) {
      this.x = ((int)(this.x + paramLong));
    }
    return paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */