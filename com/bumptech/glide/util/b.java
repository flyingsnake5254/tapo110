package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b
  extends FilterInputStream
{
  private final long c;
  private int d;
  
  private b(@NonNull InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    this.c = paramLong;
  }
  
  private int a(int paramInt)
    throws IOException
  {
    if (paramInt >= 0) {
      this.d += paramInt;
    } else {
      if (this.c - this.d > 0L) {
        break label34;
      }
    }
    return paramInt;
    label34:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Failed to read all expected data, expected: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", but read: ");
    localStringBuilder.append(this.d);
    throw new IOException(localStringBuilder.toString());
  }
  
  @NonNull
  public static InputStream c(@NonNull InputStream paramInputStream, long paramLong)
  {
    return new b(paramInputStream, paramLong);
  }
  
  public int available()
    throws IOException
  {
    try
    {
      long l = Math.max(this.c - this.d, this.in.available());
      int i = (int)l;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int read()
    throws IOException
  {
    try
    {
      int i = super.read();
      int j;
      if (i >= 0) {
        j = 1;
      } else {
        j = -1;
      }
      a(j);
      return i;
    }
    finally {}
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      paramInt1 = a(super.read(paramArrayOfByte, paramInt1, paramInt2));
      return paramInt1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */