package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class v
{
  private int a;
  private long[] b;
  
  public v()
  {
    this(32);
  }
  
  public v(int paramInt)
  {
    this.b = new long[paramInt];
  }
  
  public void a(long paramLong)
  {
    int i = this.a;
    long[] arrayOfLong = this.b;
    if (i == arrayOfLong.length) {
      this.b = Arrays.copyOf(arrayOfLong, i * 2);
    }
    arrayOfLong = this.b;
    i = this.a;
    this.a = (i + 1);
    arrayOfLong[i] = paramLong;
  }
  
  public long b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a)) {
      return this.b[paramInt];
    }
    int i = this.a;
    StringBuilder localStringBuilder = new StringBuilder(46);
    localStringBuilder.append("Invalid index ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", size is ");
    localStringBuilder.append(i);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public int c()
  {
    return this.a;
  }
  
  public long[] d()
  {
    return Arrays.copyOf(this.b, this.a);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */