package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class RoundedCornerTreatment
  extends CornerTreatment
{
  float radius = -1.0F;
  
  public RoundedCornerTreatment() {}
  
  @Deprecated
  public RoundedCornerTreatment(float paramFloat)
  {
    this.radius = paramFloat;
  }
  
  public void getCornerPath(@NonNull ShapePath paramShapePath, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramShapePath.reset(0.0F, paramFloat3 * paramFloat2, 180.0F, 180.0F - paramFloat1);
    paramFloat2 = paramFloat3 * 2.0F * paramFloat2;
    paramShapePath.addArc(0.0F, 0.0F, paramFloat2, paramFloat2, 180.0F, paramFloat1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shape\RoundedCornerTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */