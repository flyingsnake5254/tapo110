package com.google.android.material.shape;

import androidx.annotation.NonNull;

public final class OffsetEdgeTreatment
  extends EdgeTreatment
{
  private final float offset;
  private final EdgeTreatment other;
  
  public OffsetEdgeTreatment(@NonNull EdgeTreatment paramEdgeTreatment, float paramFloat)
  {
    this.other = paramEdgeTreatment;
    this.offset = paramFloat;
  }
  
  boolean forceIntersection()
  {
    return this.other.forceIntersection();
  }
  
  public void getEdgePath(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull ShapePath paramShapePath)
  {
    this.other.getEdgePath(paramFloat1, paramFloat2 - this.offset, paramFloat3, paramShapePath);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shape\OffsetEdgeTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */