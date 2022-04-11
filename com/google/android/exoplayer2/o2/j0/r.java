package com.google.android.exoplayer2.o2.j0;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

final class r
{
  public final o a;
  public final int b;
  public final long[] c;
  public final int[] d;
  public final int e;
  public final long[] f;
  public final int[] g;
  public final long h;
  
  public r(o paramo, long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2, long paramLong)
  {
    int i = paramArrayOfInt1.length;
    int j = paramArrayOfLong2.length;
    boolean bool1 = false;
    if (i == j) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    if (paramArrayOfLong1.length == paramArrayOfLong2.length) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    boolean bool2 = bool1;
    if (paramArrayOfInt2.length == paramArrayOfLong2.length) {
      bool2 = true;
    }
    g.a(bool2);
    this.a = paramo;
    this.c = paramArrayOfLong1;
    this.d = paramArrayOfInt1;
    this.e = paramInt;
    this.f = paramArrayOfLong2;
    this.g = paramArrayOfInt2;
    this.h = paramLong;
    this.b = paramArrayOfLong1.length;
    if (paramArrayOfInt2.length > 0)
    {
      paramInt = paramArrayOfInt2.length - 1;
      paramArrayOfInt2[paramInt] |= 0x20000000;
    }
  }
  
  public int a(long paramLong)
  {
    for (int i = o0.h(this.f, paramLong, true, false); i >= 0; i--) {
      if ((this.g[i] & 0x1) != 0) {
        return i;
      }
    }
    return -1;
  }
  
  public int b(long paramLong)
  {
    for (int i = o0.d(this.f, paramLong, true, false); i < this.f.length; i++) {
      if ((this.g[i] & 0x1) != 0) {
        return i;
      }
    }
    return -1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\j0\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */