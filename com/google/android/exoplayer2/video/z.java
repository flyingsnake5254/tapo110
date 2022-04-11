package com.google.android.exoplayer2.video;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.v0;

public final class z
{
  public static final z a = new z(0, 0);
  public static final v0<z> b = l.a;
  @IntRange(from=0L)
  public final int c;
  @IntRange(from=0L)
  public final int d;
  @IntRange(from=0L, to=359L)
  public final int e;
  @FloatRange(from=0.0D, fromInclusive=false)
  public final float f;
  
  public z(@IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2)
  {
    this(paramInt1, paramInt2, 0, 1.0F);
  }
  
  public z(@IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=0L, to=359L) int paramInt3, @FloatRange(from=0.0D, fromInclusive=false) float paramFloat)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramFloat;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof z))
    {
      paramObject = (z)paramObject;
      if ((this.c != ((z)paramObject).c) || (this.d != ((z)paramObject).d) || (this.e != ((z)paramObject).e) || (this.f != ((z)paramObject).f)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (((217 + this.c) * 31 + this.d) * 31 + this.e) * 31 + Float.floatToRawIntBits(this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */