package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

public final class w
  implements y
{
  private final long[] a;
  private final long[] b;
  private final long c;
  private final boolean d;
  
  public w(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong)
  {
    boolean bool;
    if (paramArrayOfLong1.length == paramArrayOfLong2.length) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    int i = paramArrayOfLong2.length;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
    if ((bool) && (paramArrayOfLong2[0] > 0L))
    {
      int j = i + 1;
      long[] arrayOfLong1 = new long[j];
      this.a = arrayOfLong1;
      long[] arrayOfLong2 = new long[j];
      this.b = arrayOfLong2;
      System.arraycopy(paramArrayOfLong1, 0, arrayOfLong1, 1, i);
      System.arraycopy(paramArrayOfLong2, 0, arrayOfLong2, 1, i);
    }
    else
    {
      this.a = paramArrayOfLong1;
      this.b = paramArrayOfLong2;
    }
    this.c = paramLong;
  }
  
  public y.a a(long paramLong)
  {
    if (!this.d) {
      return new y.a(z.a);
    }
    int i = o0.h(this.b, paramLong, true, true);
    z localz = new z(this.b[i], this.a[i]);
    if ((localz.b != paramLong) && (i != this.b.length - 1))
    {
      long[] arrayOfLong = this.b;
      i++;
      return new y.a(localz, new z(arrayOfLong[i], this.a[i]));
    }
    return new y.a(localz);
  }
  
  public boolean g()
  {
    return this.d;
  }
  
  public long i()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */