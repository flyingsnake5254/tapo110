package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.z.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class u
  extends FilterInputStream
{
  private volatile byte[] c;
  private int d;
  private int f;
  private int q = -1;
  private int x;
  private final b y;
  
  public u(@NonNull InputStream paramInputStream, @NonNull b paramb)
  {
    this(paramInputStream, paramb, 65536);
  }
  
  @VisibleForTesting
  u(@NonNull InputStream paramInputStream, @NonNull b paramb, int paramInt)
  {
    super(paramInputStream);
    this.y = paramb;
    this.c = ((byte[])paramb.c(paramInt, byte[].class));
  }
  
  private int a(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    int i = this.q;
    if (i != -1)
    {
      int j = this.x;
      k = this.f;
      if (j - i < k)
      {
        byte[] arrayOfByte;
        if ((i == 0) && (k > paramArrayOfByte.length) && (this.d == paramArrayOfByte.length))
        {
          i = paramArrayOfByte.length * 2;
          if (i <= k) {
            k = i;
          }
          arrayOfByte = (byte[])this.y.c(k, byte[].class);
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
          this.c = arrayOfByte;
          this.y.e(paramArrayOfByte);
        }
        else
        {
          arrayOfByte = paramArrayOfByte;
          if (i > 0)
          {
            System.arraycopy(paramArrayOfByte, i, paramArrayOfByte, 0, paramArrayOfByte.length - i);
            arrayOfByte = paramArrayOfByte;
          }
        }
        k = this.x - this.q;
        this.x = k;
        this.q = 0;
        this.d = 0;
        i = paramInputStream.read(arrayOfByte, k, arrayOfByte.length - k);
        k = this.x;
        if (i > 0) {
          k += i;
        }
        this.d = k;
        return i;
      }
    }
    int k = paramInputStream.read(paramArrayOfByte);
    if (k > 0)
    {
      this.q = -1;
      this.x = 0;
      this.d = k;
    }
    return k;
  }
  
  private static IOException g()
    throws IOException
  {
    throw new IOException("BufferedInputStream is closed");
  }
  
  public int available()
    throws IOException
  {
    try
    {
      InputStream localInputStream = this.in;
      if ((this.c != null) && (localInputStream != null))
      {
        int i = this.d;
        int j = this.x;
        int k = localInputStream.available();
        return i - j + k;
      }
      throw g();
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      this.f = this.c.length;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void close()
    throws IOException
  {
    if (this.c != null)
    {
      this.y.e(this.c);
      this.c = null;
    }
    InputStream localInputStream = this.in;
    this.in = null;
    if (localInputStream != null) {
      localInputStream.close();
    }
  }
  
  public void e()
  {
    try
    {
      if (this.c != null)
      {
        this.y.e(this.c);
        this.c = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.f = Math.max(this.f, paramInt);
      this.q = this.x;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
    throws IOException
  {
    try
    {
      byte[] arrayOfByte = this.c;
      Object localObject1 = this.in;
      if ((arrayOfByte != null) && (localObject1 != null))
      {
        if (this.x >= this.d)
        {
          i = a((InputStream)localObject1, arrayOfByte);
          if (i == -1) {
            return -1;
          }
        }
        localObject1 = arrayOfByte;
        if (arrayOfByte != this.c)
        {
          localObject1 = this.c;
          if (localObject1 == null) {
            throw g();
          }
        }
        int j = this.d;
        int i = this.x;
        if (j - i > 0)
        {
          this.x = (i + 1);
          i = localObject1[i];
          return i & 0xFF;
        }
        return -1;
      }
      throw g();
    }
    finally {}
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      Object localObject1 = this.c;
      if (localObject1 != null)
      {
        if (paramInt2 == 0) {
          return 0;
        }
        InputStream localInputStream = this.in;
        if (localInputStream != null)
        {
          int i = this.x;
          int j = this.d;
          if (i < j)
          {
            if (j - i >= paramInt2) {
              j = paramInt2;
            } else {
              j -= i;
            }
            System.arraycopy(localObject1, i, paramArrayOfByte, paramInt1, j);
            this.x += j;
            if (j != paramInt2)
            {
              i = localInputStream.available();
              if (i != 0)
              {
                i = paramInt1 + j;
                paramInt1 = paramInt2 - j;
                j = i;
                break label148;
              }
            }
            return j;
          }
          else
          {
            i = paramInt2;
            j = paramInt1;
            paramInt1 = i;
          }
          for (;;)
          {
            label148:
            i = this.q;
            int k = -1;
            if ((i == -1) && (paramInt1 >= localObject1.length))
            {
              int m = localInputStream.read(paramArrayOfByte, j, paramInt1);
              i = m;
              if (m == -1)
              {
                if (paramInt1 != paramInt2) {
                  k = paramInt2 - paramInt1;
                }
                return k;
              }
            }
            else
            {
              i = a(localInputStream, (byte[])localObject1);
              if (i == -1)
              {
                if (paramInt1 != paramInt2) {
                  k = paramInt2 - paramInt1;
                }
                return k;
              }
              Object localObject2 = localObject1;
              if (localObject1 != this.c)
              {
                localObject2 = this.c;
                if (localObject2 == null) {
                  throw g();
                }
              }
              i = this.d;
              k = this.x;
              if (i - k >= paramInt1) {
                i = paramInt1;
              } else {
                i -= k;
              }
              System.arraycopy(localObject2, k, paramArrayOfByte, j, i);
              this.x += i;
              localObject1 = localObject2;
            }
            paramInt1 -= i;
            if (paramInt1 == 0) {
              return paramInt2;
            }
            k = localInputStream.available();
            if (k == 0) {
              return paramInt2 - paramInt1;
            }
            j += i;
          }
        }
        throw g();
      }
      throw g();
    }
    finally {}
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      if (this.c != null)
      {
        int i = this.q;
        if (-1 != i)
        {
          this.x = i;
          return;
        }
        a locala = new com/bumptech/glide/load/resource/bitmap/u$a;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append("Mark has been invalidated, pos: ");
        ((StringBuilder)localObject1).append(this.x);
        ((StringBuilder)localObject1).append(" markLimit: ");
        ((StringBuilder)localObject1).append(this.f);
        locala.<init>(((StringBuilder)localObject1).toString());
        throw locala;
      }
      Object localObject1 = new java/io/IOException;
      ((IOException)localObject1).<init>("Stream is closed");
      throw ((Throwable)localObject1);
    }
    finally {}
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    if (paramLong < 1L) {
      return 0L;
    }
    try
    {
      byte[] arrayOfByte = this.c;
      if (arrayOfByte != null)
      {
        InputStream localInputStream = this.in;
        if (localInputStream != null)
        {
          int i = this.d;
          int j = this.x;
          if (i - j >= paramLong)
          {
            this.x = ((int)(j + paramLong));
            return paramLong;
          }
          long l1 = i - j;
          this.x = i;
          if ((this.q != -1) && (paramLong <= this.f))
          {
            j = a(localInputStream, arrayOfByte);
            if (j == -1) {
              return l1;
            }
            j = this.d;
            i = this.x;
            if (j - i >= paramLong - l1)
            {
              this.x = ((int)(i + paramLong - l1));
              return paramLong;
            }
            long l2 = j;
            paramLong = i;
            this.x = j;
            return l1 + l2 - paramLong;
          }
          paramLong = localInputStream.skip(paramLong - l1);
          if (paramLong > 0L) {
            this.q = -1;
          }
          return l1 + paramLong;
        }
        throw g();
      }
      throw g();
    }
    finally {}
  }
  
  static class a
    extends IOException
  {
    a(String paramString)
    {
      super();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */