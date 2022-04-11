package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

public class CornerTreatment
{
  @Deprecated
  public void getCornerPath(float paramFloat1, float paramFloat2, @NonNull ShapePath paramShapePath) {}
  
  public void getCornerPath(@NonNull ShapePath paramShapePath, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    getCornerPath(paramFloat1, paramFloat2, paramShapePath);
  }
  
  public void getCornerPath(@NonNull ShapePath paramShapePath, float paramFloat1, float paramFloat2, @NonNull RectF paramRectF, @NonNull CornerSize paramCornerSize)
  {
    getCornerPath(paramShapePath, paramFloat1, paramFloat2, paramCornerSize.getCornerSize(paramRectF));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shape\CornerTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */