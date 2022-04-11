package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class EdgeTreatment
{
  boolean forceIntersection()
  {
    return false;
  }
  
  public void getEdgePath(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull ShapePath paramShapePath)
  {
    paramShapePath.lineTo(paramFloat1, 0.0F);
  }
  
  @Deprecated
  public void getEdgePath(float paramFloat1, float paramFloat2, @NonNull ShapePath paramShapePath)
  {
    getEdgePath(paramFloat1, paramFloat1 / 2.0F, paramFloat2, paramShapePath);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shape\EdgeTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */