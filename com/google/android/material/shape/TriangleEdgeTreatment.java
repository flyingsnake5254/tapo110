package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class TriangleEdgeTreatment
  extends EdgeTreatment
{
  private final boolean inside;
  private final float size;
  
  public TriangleEdgeTreatment(float paramFloat, boolean paramBoolean)
  {
    this.size = paramFloat;
    this.inside = paramBoolean;
  }
  
  public void getEdgePath(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull ShapePath paramShapePath)
  {
    paramShapePath.lineTo(paramFloat2 - this.size * paramFloat3, 0.0F);
    float f;
    if (this.inside) {
      f = this.size;
    } else {
      f = -this.size;
    }
    paramShapePath.lineTo(paramFloat2, f * paramFloat3);
    paramShapePath.lineTo(paramFloat2 + this.size * paramFloat3, 0.0F);
    paramShapePath.lineTo(paramFloat1, 0.0F);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shape\TriangleEdgeTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */