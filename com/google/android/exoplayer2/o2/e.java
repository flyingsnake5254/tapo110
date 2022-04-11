package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

public final class e
  implements y
{
  public final int a;
  public final int[] b;
  public final long[] c;
  public final long[] d;
  public final long[] e;
  private final long f;
  
  public e(int[] paramArrayOfInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    this.b = paramArrayOfInt;
    this.c = paramArrayOfLong1;
    this.d = paramArrayOfLong2;
    this.e = paramArrayOfLong3;
    int i = paramArrayOfInt.length;
    this.a = i;
    if (i > 0) {
      this.f = (paramArrayOfLong2[(i - 1)] + paramArrayOfLong3[(i - 1)]);
    } else {
      this.f = 0L;
    }
  }
  
  public y.a a(long paramLong)
  {
    int i = b(paramLong);
    z localz = new z(this.e[i], this.c[i]);
    if ((localz.b < paramLong) && (i != this.a - 1))
    {
      long[] arrayOfLong = this.e;
      i++;
      return new y.a(localz, new z(arrayOfLong[i], this.c[i]));
    }
    return new y.a(localz);
  }
  
  public int b(long paramLong)
  {
    return o0.h(this.e, paramLong, true, true);
  }
  
  public boolean g()
  {
    return true;
  }
  
  public long i()
  {
    return this.f;
  }
  
  public String toString()
  {
    int i = this.a;
    String str1 = Arrays.toString(this.b);
    String str2 = Arrays.toString(this.c);
    String str3 = Arrays.toString(this.e);
    String str4 = Arrays.toString(this.d);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 71 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
    localStringBuilder.append("ChunkIndex(length=");
    localStringBuilder.append(i);
    localStringBuilder.append(", sizes=");
    localStringBuilder.append(str1);
    localStringBuilder.append(", offsets=");
    localStringBuilder.append(str2);
    localStringBuilder.append(", timeUs=");
    localStringBuilder.append(str3);
    localStringBuilder.append(", durationsUs=");
    localStringBuilder.append(str4);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */