package com.google.android.exoplayer2;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

public final class t1
{
  public static final t1 a = new t1(1.0F);
  public static final v0<t1> b = i0.a;
  public final float c;
  public final float d;
  private final int e;
  
  public t1(float paramFloat)
  {
    this(paramFloat, 1.0F);
  }
  
  public t1(float paramFloat1, float paramFloat2)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramFloat1 > 0.0F) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    if (paramFloat2 > 0.0F) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = Math.round(paramFloat1 * 1000.0F);
  }
  
  public long a(long paramLong)
  {
    return paramLong * this.e;
  }
  
  @CheckResult
  public t1 b(float paramFloat)
  {
    return new t1(paramFloat, this.d);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (t1.class == paramObject.getClass()))
    {
      paramObject = (t1)paramObject;
      if ((this.c != ((t1)paramObject).c) || (this.d != ((t1)paramObject).d)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (527 + Float.floatToRawIntBits(this.c)) * 31 + Float.floatToRawIntBits(this.d);
  }
  
  public String toString()
  {
    return o0.A("PlaybackParameters(speed=%.2f, pitch=%.2f)", new Object[] { Float.valueOf(this.c), Float.valueOf(this.d) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\t1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */