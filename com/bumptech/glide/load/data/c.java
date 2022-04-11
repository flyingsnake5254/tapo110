package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.z.b;
import java.io.IOException;
import java.io.OutputStream;

public final class c
  extends OutputStream
{
  @NonNull
  private final OutputStream c;
  private byte[] d;
  private b f;
  private int q;
  
  public c(@NonNull OutputStream paramOutputStream, @NonNull b paramb)
  {
    this(paramOutputStream, paramb, 65536);
  }
  
  @VisibleForTesting
  c(@NonNull OutputStream paramOutputStream, b paramb, int paramInt)
  {
    this.c = paramOutputStream;
    this.f = paramb;
    this.d = ((byte[])paramb.c(paramInt, byte[].class));
  }
  
  private void a()
    throws IOException
  {
    int i = this.q;
    if (i > 0)
    {
      this.c.write(this.d, 0, i);
      this.q = 0;
    }
  }
  
  private void c()
    throws IOException
  {
    if (this.q == this.d.length) {
      a();
    }
  }
  
  private void e()
  {
    byte[] arrayOfByte = this.d;
    if (arrayOfByte != null)
    {
      this.f.e(arrayOfByte);
      this.d = null;
    }
  }
  
  public void close()
    throws IOException
  {
    try
    {
      flush();
      this.c.close();
      e();
      return;
    }
    finally
    {
      this.c.close();
    }
  }
  
  public void flush()
    throws IOException
  {
    a();
    this.c.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = this.d;
    int i = this.q;
    this.q = (i + 1);
    arrayOfByte[i] = ((byte)(byte)paramInt);
    c();
  }
  
  public void write(@NonNull byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 0;
    int k;
    do
    {
      int j = paramInt2 - i;
      k = paramInt1 + i;
      int m = this.q;
      if ((m == 0) && (j >= this.d.length))
      {
        this.c.write(paramArrayOfByte, k, j);
        return;
      }
      m = Math.min(j, this.d.length - m);
      System.arraycopy(paramArrayOfByte, k, this.d, this.q, m);
      this.q += m;
      k = i + m;
      c();
      i = k;
    } while (k < paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */