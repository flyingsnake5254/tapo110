package com.google.android.material.shape;

import androidx.annotation.NonNull;

public final class MarkerEdgeTreatment
  extends EdgeTreatment
{
  private final float radius;
  
  public MarkerEdgeTreatment(float paramFloat)
  {
    this.radius = (paramFloat - 0.001F);
  }
  
  boolean forceIntersection()
  {
    return true;
  }
  
  public void getEdgePath(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull ShapePath paramShapePath)
  {
    paramFloat3 = (float)(this.radius * Math.sqrt(2.0D) / 2.0D);
    paramFloat1 = (float)Math.sqrt(Math.pow(this.radius, 2.0D) - Math.pow(paramFloat3, 2.0D));
    paramShapePath.reset(paramFloat2 - paramFloat3, (float)-(this.radius * Math.sqrt(2.0D) - this.radius) + paramFloat1);
    paramShapePath.lineTo(paramFloat2, (float)-(this.radius * Math.sqrt(2.0D) - this.radius));
    paramShapePath.lineTo(paramFloat2 + paramFloat3, (float)-(this.radius * Math.sqrt(2.0D) - this.radius) + paramFloat1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shape\MarkerEdgeTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */