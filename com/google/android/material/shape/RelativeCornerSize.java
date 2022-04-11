package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import java.util.Arrays;

public final class RelativeCornerSize
  implements CornerSize
{
  private final float percent;
  
  public RelativeCornerSize(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.percent = paramFloat;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof RelativeCornerSize)) {
      return false;
    }
    paramObject = (RelativeCornerSize)paramObject;
    if (this.percent != ((RelativeCornerSize)paramObject).percent) {
      bool = false;
    }
    return bool;
  }
  
  public float getCornerSize(@NonNull RectF paramRectF)
  {
    return this.percent * paramRectF.height();
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getRelativePercent()
  {
    return this.percent;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Float.valueOf(this.percent) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shape\RelativeCornerSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */