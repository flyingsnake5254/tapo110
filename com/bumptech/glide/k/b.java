package com.bumptech.glide.k;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class b
  implements Closeable
{
  private final InputStream c;
  private final Charset d;
  private byte[] f;
  private int q;
  private int x;
  
  public b(InputStream paramInputStream, int paramInt, Charset paramCharset)
  {
    if ((paramInputStream != null) && (paramCharset != null))
    {
      if (paramInt >= 0)
      {
        if (paramCharset.equals(c.a))
        {
          this.c = paramInputStream;
          this.d = paramCharset;
          this.f = new byte[paramInt];
          return;
        }
        throw new IllegalArgumentException("Unsupported encoding");
      }
      throw new IllegalArgumentException("capacity <= 0");
    }
    throw null;
  }
  
  public b(InputStream paramInputStream, Charset paramCharset)
  {
    this(paramInputStream, 8192, paramCharset);
  }
  
  private void c()
    throws IOException
  {
    InputStream localInputStream = this.c;
    byte[] arrayOfByte = this.f;
    int i = localInputStream.read(arrayOfByte, 0, arrayOfByte.length);
    if (i != -1)
    {
      this.q = 0;
      this.x = i;
      return;
    }
    throw new EOFException();
  }
  
  public void close()
    throws IOException
  {
    synchronized (this.c)
    {
      if (this.f != null)
      {
        this.f = null;
        this.c.close();
      }
      return;
    }
  }
  
  public boolean e()
  {
    boolean bool;
    if (this.x == -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String g()
    throws IOException
  {
    synchronized (this.c)
    {
      if (this.f != null)
      {
        if (this.q >= this.x) {
          c();
        }
        int j;
        byte[] arrayOfByte;
        for (int i = this.q; i != this.x; i++)
        {
          localObject1 = this.f;
          if (localObject1[i] == 10)
          {
            if (i != this.q)
            {
              j = i - 1;
              if (localObject1[j] == 13) {}
            }
            else
            {
              j = i;
            }
            localObject1 = new java/lang/String;
            arrayOfByte = this.f;
            int k = this.q;
            ((String)localObject1).<init>(arrayOfByte, k, j - k, this.d.name());
            this.q = (i + 1);
            return (String)localObject1;
          }
        }
        localObject1 = new com/bumptech/glide/k/b$a;
        ((a)localObject1).<init>(this, this.x - this.q + 80);
        for (;;)
        {
          arrayOfByte = this.f;
          i = this.q;
          ((ByteArrayOutputStream)localObject1).write(arrayOfByte, i, this.x - i);
          this.x = -1;
          c();
          for (i = this.q; i != this.x; i++)
          {
            arrayOfByte = this.f;
            if (arrayOfByte[i] == 10)
            {
              j = this.q;
              if (i != j) {
                ((ByteArrayOutputStream)localObject1).write(arrayOfByte, j, i - j);
              }
              this.q = (i + 1);
              localObject1 = ((ByteArrayOutputStream)localObject1).toString();
              return (String)localObject1;
            }
          }
        }
      }
      Object localObject1 = new java/io/IOException;
      ((IOException)localObject1).<init>("LineReader is closed");
      throw ((Throwable)localObject1);
    }
  }
  
  class a
    extends ByteArrayOutputStream
  {
    a(int paramInt)
    {
      super();
    }
    
    public String toString()
    {
      int i = this.count;
      int j = i;
      if (i > 0)
      {
        j = i;
        if (this.buf[(i - 1)] == 13) {
          j = i - 1;
        }
      }
      try
      {
        String str = new String(this.buf, 0, j, b.a(b.this).name());
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new AssertionError(localUnsupportedEncodingException);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\k\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */