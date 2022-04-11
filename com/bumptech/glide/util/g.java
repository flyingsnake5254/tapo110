package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class g
  extends FilterInputStream
{
  private int c = Integer.MIN_VALUE;
  
  public g(@NonNull InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private long a(long paramLong)
  {
    int i = this.c;
    if (i == 0) {
      return -1L;
    }
    long l = paramLong;
    if (i != Integer.MIN_VALUE)
    {
      l = paramLong;
      if (paramLong > i) {
        l = i;
      }
    }
    return l;
  }
  
  private void c(long paramLong)
  {
    int i = this.c;
    if ((i != Integer.MIN_VALUE) && (paramLong != -1L)) {
      this.c = ((int)(i - paramLong));
    }
  }
  
  public int available()
    throws IOException
  {
    int i = this.c;
    if (i == Integer.MIN_VALUE) {
      i = super.available();
    } else {
      i = Math.min(i, super.available());
    }
    return i;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      super.mark(paramInt);
      this.c = paramInt;
      return;
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
    if (a(1L) == -1L) {
      return -1;
    }
    int i = super.read();
    c(1L);
    return i;
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt2 = (int)a(paramInt2);
    if (paramInt2 == -1) {
      return -1;
    }
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    c(paramInt1);
    return paramInt1;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      super.reset();
      this.c = Integer.MIN_VALUE;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    paramLong = a(paramLong);
    if (paramLong == -1L) {
      return 0L;
    }
    paramLong = super.skip(paramLong);
    c(paramLong);
    return paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\util\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */