package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class CutCornerTreatment
  extends CornerTreatment
{
  float size = -1.0F;
  
  public CutCornerTreatment() {}
  
  @Deprecated
  public CutCornerTreatment(float paramFloat)
  {
    this.size = paramFloat;
  }
  
  public void getCornerPath(@NonNull ShapePath paramShapePath, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramShapePath.reset(0.0F, paramFloat3 * paramFloat2, 180.0F, 180.0F - paramFloat1);
    double d1 = Math.sin(Math.toRadians(paramFloat1));
    double d2 = paramFloat3;
    double d3 = paramFloat2;
    paramShapePath.lineTo((float)(d1 * d2 * d3), (float)(Math.sin(Math.toRadians(90.0F - paramFloat1)) * d2 * d3));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shape\CutCornerTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */