package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;

public final class x
{
  public final int a;
  public final float b;
  
  public x(int paramInt, float paramFloat)
  {
    this.a = paramInt;
    this.b = paramFloat;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (x.class == paramObject.getClass()))
    {
      paramObject = (x)paramObject;
      if ((this.a != ((x)paramObject).a) || (Float.compare(((x)paramObject).b, this.b) != 0)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (527 + this.a) * 31 + Float.floatToIntBits(this.b);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */