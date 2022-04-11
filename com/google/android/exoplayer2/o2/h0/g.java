package com.google.android.exoplayer2.o2.h0;

import com.google.android.exoplayer2.o2.k;
import java.io.IOException;

final class g
{
  private static final long[] a = { 128L, 64L, 32L, 16L, 8L, 4L, 2L, 1L };
  private final byte[] b = new byte[8];
  private int c;
  private int d;
  
  public static long a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    long l1 = paramArrayOfByte[0] & 0xFF;
    long l2 = l1;
    if (paramBoolean) {
      l2 = l1 & (a[(paramInt - 1)] ^ 0xFFFFFFFFFFFFFFFF);
    }
    for (int i = 1; i < paramInt; i++) {
      l2 = l2 << 8 | paramArrayOfByte[i] & 0xFF;
    }
    return l2;
  }
  
  public static int c(int paramInt)
  {
    for (int i = 0;; i++)
    {
      long[] arrayOfLong = a;
      if (i >= arrayOfLong.length) {
        break;
      }
      if ((arrayOfLong[i] & paramInt) != 0L) {
        return i + 1;
      }
    }
    paramInt = -1;
    return paramInt;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public long d(k paramk, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    throws IOException
  {
    if (this.c == 0)
    {
      if (!paramk.f(this.b, 0, 1, paramBoolean1)) {
        return -1L;
      }
      i = c(this.b[0] & 0xFF);
      this.d = i;
      if (i != -1) {
        this.c = 1;
      } else {
        throw new IllegalStateException("No valid varint length mask found");
      }
    }
    int i = this.d;
    if (i > paramInt)
    {
      this.c = 0;
      return -2L;
    }
    if (i != 1) {
      paramk.readFully(this.b, 1, i - 1);
    }
    this.c = 0;
    return a(this.b, this.d, paramBoolean2);
  }
  
  public void e()
  {
    this.c = 0;
    this.d = 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\h0\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */