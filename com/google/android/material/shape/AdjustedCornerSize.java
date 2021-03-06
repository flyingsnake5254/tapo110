package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class AdjustedCornerSize
  implements CornerSize
{
  private final float adjustment;
  private final CornerSize other;
  
  public AdjustedCornerSize(float paramFloat, @NonNull CornerSize paramCornerSize)
  {
    while ((paramCornerSize instanceof AdjustedCornerSize))
    {
      paramCornerSize = ((AdjustedCornerSize)paramCornerSize).other;
      paramFloat += ((AdjustedCornerSize)paramCornerSize).adjustment;
    }
    this.other = paramCornerSize;
    this.adjustment = paramFloat;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof AdjustedCornerSize)) {
      return false;
    }
    paramObject = (AdjustedCornerSize)paramObject;
    if ((!this.other.equals(((AdjustedCornerSize)paramObject).other)) || (this.adjustment != ((AdjustedCornerSize)paramObject).adjustment)) {
      bool = false;
    }
    return bool;
  }
  
  public float getCornerSize(@NonNull RectF paramRectF)
  {
    return Math.max(0.0F, this.other.getCornerSize(paramRectF) + this.adjustment);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.other, Float.valueOf(this.adjustment) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shape\AdjustedCornerSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */