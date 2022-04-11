package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment
  extends EdgeTreatment
  implements Cloneable
{
  private static final int ANGLE_LEFT = 180;
  private static final int ANGLE_UP = 270;
  private static final int ARC_HALF = 180;
  private static final int ARC_QUARTER = 90;
  private float cradleVerticalOffset;
  private float fabDiameter;
  private float fabMargin;
  private float horizontalOffset;
  private float roundedCornerRadius;
  
  public BottomAppBarTopEdgeTreatment(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.fabMargin = paramFloat1;
    this.roundedCornerRadius = paramFloat2;
    setCradleVerticalOffset(paramFloat3);
    this.horizontalOffset = 0.0F;
  }
  
  float getCradleVerticalOffset()
  {
    return this.cradleVerticalOffset;
  }
  
  public void getEdgePath(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull ShapePath paramShapePath)
  {
    float f1 = this.fabDiameter;
    if (f1 == 0.0F)
    {
      paramShapePath.lineTo(paramFloat1, 0.0F);
      return;
    }
    f1 = (this.fabMargin * 2.0F + f1) / 2.0F;
    float f2 = paramFloat3 * this.roundedCornerRadius;
    paramFloat2 += this.horizontalOffset;
    paramFloat3 = this.cradleVerticalOffset * paramFloat3 + (1.0F - paramFloat3) * f1;
    if (paramFloat3 / f1 >= 1.0F)
    {
      paramShapePath.lineTo(paramFloat1, 0.0F);
      return;
    }
    float f3 = f1 + f2;
    float f4 = paramFloat3 + f2;
    float f5 = (float)Math.sqrt(f3 * f3 - f4 * f4);
    float f6 = paramFloat2 - f5;
    f3 = paramFloat2 + f5;
    f4 = (float)Math.toDegrees(Math.atan(f5 / f4));
    float f7 = 90.0F - f4;
    paramShapePath.lineTo(f6, 0.0F);
    f5 = f2 * 2.0F;
    paramShapePath.addArc(f6 - f2, 0.0F, f6 + f2, f5, 270.0F, f4);
    paramShapePath.addArc(paramFloat2 - f1, -f1 - paramFloat3, paramFloat2 + f1, f1 - paramFloat3, 180.0F - f7, f7 * 2.0F - 180.0F);
    paramShapePath.addArc(f3 - f2, 0.0F, f3 + f2, f5, 270.0F - f4, f4);
    paramShapePath.lineTo(paramFloat1, 0.0F);
  }
  
  float getFabCradleMargin()
  {
    return this.fabMargin;
  }
  
  float getFabCradleRoundedCornerRadius()
  {
    return this.roundedCornerRadius;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public float getFabDiameter()
  {
    return this.fabDiameter;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public float getHorizontalOffset()
  {
    return this.horizontalOffset;
  }
  
  void setCradleVerticalOffset(@FloatRange(from=0.0D) float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      this.cradleVerticalOffset = paramFloat;
      return;
    }
    throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
  }
  
  void setFabCradleMargin(float paramFloat)
  {
    this.fabMargin = paramFloat;
  }
  
  void setFabCradleRoundedCornerRadius(float paramFloat)
  {
    this.roundedCornerRadius = paramFloat;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setFabDiameter(float paramFloat)
  {
    this.fabDiameter = paramFloat;
  }
  
  void setHorizontalOffset(float paramFloat)
  {
    this.horizontalOffset = paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\bottomappbar\BottomAppBarTopEdgeTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */