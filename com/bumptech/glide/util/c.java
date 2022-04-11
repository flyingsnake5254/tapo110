package com.bumptech.glide.util;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class c
  extends InputStream
{
  @GuardedBy("POOL")
  private static final Queue<c> c = j.f(0);
  private InputStream d;
  private IOException f;
  
  @NonNull
  public static c c(@NonNull InputStream paramInputStream)
  {
    synchronized (c)
    {
      c localc = (c)((Queue)???).poll();
      ??? = localc;
      if (localc == null) {
        ??? = new c();
      }
      ((c)???).g(paramInputStream);
      return (c)???;
    }
  }
  
  @Nullable
  public IOException a()
  {
    return this.f;
  }
  
  public int available()
    throws IOException
  {
    return this.d.available();
  }
  
  public void close()
    throws IOException
  {
    this.d.close();
  }
  
  public void e()
  {
    this.f = null;
    this.d = null;
    synchronized (c)
    {
      ???.offer(this);
      return;
    }
  }
  
  void g(@NonNull InputStream paramInputStream)
  {
    this.d = paramInputStream;
  }
  
  public void mark(int paramInt)
  {
    this.d.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.d.markSupported();
  }
  
  public int read()
    throws IOException
  {
    try
    {
      int i = this.d.read();
      return i;
    }
    catch (IOException localIOException)
    {
      this.f = localIOException;
      throw localIOException;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      int i = this.d.read(paramArrayOfByte);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      this.f = paramArrayOfByte;
      throw paramArrayOfByte;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      paramInt1 = this.d.read(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      this.f = paramArrayOfByte;
      throw paramArrayOfByte;
    }
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      this.d.reset();
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
    try
    {
      paramLong = this.d.skip(paramLong);
      return paramLong;
    }
    catch (IOException localIOException)
    {
      this.f = localIOException;
      throw localIOException;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */