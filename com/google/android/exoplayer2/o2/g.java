package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.o0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

public final class g
  implements k
{
  private final byte[] b;
  private final i c;
  private final long d;
  private long e;
  private byte[] f;
  private int g;
  private int h;
  
  public g(i parami, long paramLong1, long paramLong2)
  {
    this.c = parami;
    this.e = paramLong1;
    this.d = paramLong2;
    this.f = new byte[65536];
    this.b = new byte['က'];
  }
  
  private void o(int paramInt)
  {
    if (paramInt != -1) {
      this.e += paramInt;
    }
  }
  
  private void p(int paramInt)
  {
    paramInt = this.g + paramInt;
    byte[] arrayOfByte = this.f;
    if (paramInt > arrayOfByte.length)
    {
      paramInt = o0.p(arrayOfByte.length * 2, 65536 + paramInt, paramInt + 524288);
      this.f = Arrays.copyOf(this.f, paramInt);
    }
  }
  
  private int q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.h;
    if (i == 0) {
      return 0;
    }
    paramInt2 = Math.min(i, paramInt2);
    System.arraycopy(this.f, 0, paramArrayOfByte, paramInt1, paramInt2);
    u(paramInt2);
    return paramInt2;
  }
  
  private int r(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws IOException
  {
    if (!Thread.interrupted())
    {
      paramInt1 = this.c.read(paramArrayOfByte, paramInt1 + paramInt3, paramInt2 - paramInt3);
      if (paramInt1 == -1)
      {
        if ((paramInt3 == 0) && (paramBoolean)) {
          return -1;
        }
        throw new EOFException();
      }
      return paramInt3 + paramInt1;
    }
    throw new InterruptedIOException();
  }
  
  private int s(int paramInt)
  {
    paramInt = Math.min(this.h, paramInt);
    u(paramInt);
    return paramInt;
  }
  
  private void u(int paramInt)
  {
    int i = this.h - paramInt;
    this.h = i;
    this.g = 0;
    byte[] arrayOfByte1 = this.f;
    byte[] arrayOfByte2;
    if (i < arrayOfByte1.length - 524288) {
      arrayOfByte2 = new byte[65536 + i];
    } else {
      arrayOfByte2 = arrayOfByte1;
    }
    System.arraycopy(arrayOfByte1, paramInt, arrayOfByte2, 0, i);
    this.f = arrayOfByte2;
  }
  
  public long a()
  {
    return this.d;
  }
  
  public boolean c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    if (!m(paramInt2, paramBoolean)) {
      return false;
    }
    System.arraycopy(this.f, this.g - paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    return true;
  }
  
  public void e()
  {
    this.g = 0;
  }
  
  public boolean f(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    for (int i = q(paramArrayOfByte, paramInt1, paramInt2); (i < paramInt2) && (i != -1); i = r(paramArrayOfByte, paramInt1, paramInt2, i, paramBoolean)) {}
    o(i);
    if (i != -1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public long g()
  {
    return this.e + this.g;
  }
  
  public long getPosition()
  {
    return this.e;
  }
  
  public void h(int paramInt)
    throws IOException
  {
    m(paramInt, false);
  }
  
  public int i(int paramInt)
    throws IOException
  {
    int i = s(paramInt);
    int j = i;
    if (i == 0)
    {
      byte[] arrayOfByte = this.b;
      j = r(arrayOfByte, 0, Math.min(paramInt, arrayOfByte.length), 0, true);
    }
    o(j);
    return j;
  }
  
  public int k(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    p(paramInt2);
    int i = this.h;
    int j = this.g;
    i -= j;
    if (i == 0)
    {
      paramInt2 = r(this.f, j, paramInt2, 0, true);
      if (paramInt2 == -1) {
        return -1;
      }
      this.h += paramInt2;
    }
    else
    {
      paramInt2 = Math.min(paramInt2, i);
    }
    System.arraycopy(this.f, this.g, paramArrayOfByte, paramInt1, paramInt2);
    this.g += paramInt2;
    return paramInt2;
  }
  
  public void l(int paramInt)
    throws IOException
  {
    t(paramInt, false);
  }
  
  public boolean m(int paramInt, boolean paramBoolean)
    throws IOException
  {
    p(paramInt);
    int i = this.h - this.g;
    while (i < paramInt)
    {
      i = r(this.f, this.g, paramInt, i, paramBoolean);
      if (i == -1) {
        return false;
      }
      this.h = (this.g + i);
    }
    this.g += paramInt;
    return true;
  }
  
  public void n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    c(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = q(paramArrayOfByte, paramInt1, paramInt2);
    int j = i;
    if (i == 0) {
      j = r(paramArrayOfByte, paramInt1, paramInt2, 0, true);
    }
    o(j);
    return j;
  }
  
  public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    f(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public boolean t(int paramInt, boolean paramBoolean)
    throws IOException
  {
    int j;
    for (int i = s(paramInt); (i < paramInt) && (i != -1); i = r(this.b, -i, j, i, paramBoolean)) {
      j = Math.min(paramInt, this.b.length + i);
    }
    o(i);
    if (i != -1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */