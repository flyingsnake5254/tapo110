package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;

public final class z
{
  public static final z a = new z(0L, 0L);
  public final long b;
  public final long c;
  
  public z(long paramLong1, long paramLong2)
  {
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (z.class == paramObject.getClass()))
    {
      paramObject = (z)paramObject;
      if ((this.b != ((z)paramObject).b) || (this.c != ((z)paramObject).c)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (int)this.b * 31 + (int)this.c;
  }
  
  public String toString()
  {
    long l1 = this.b;
    long l2 = this.c;
    StringBuilder localStringBuilder = new StringBuilder(60);
    localStringBuilder.append("[timeUs=");
    localStringBuilder.append(l1);
    localStringBuilder.append(", position=");
    localStringBuilder.append(l2);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */