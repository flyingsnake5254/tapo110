package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewUtils;

public class MaterialShapeUtils
{
  @NonNull
  static CornerTreatment createCornerTreatment(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return createDefaultCornerTreatment();
      }
      return new CutCornerTreatment();
    }
    return new RoundedCornerTreatment();
  }
  
  @NonNull
  static CornerTreatment createDefaultCornerTreatment()
  {
    return new RoundedCornerTreatment();
  }
  
  @NonNull
  static EdgeTreatment createDefaultEdgeTreatment()
  {
    return new EdgeTreatment();
  }
  
  public static void setElevation(@NonNull View paramView, float paramFloat)
  {
    paramView = paramView.getBackground();
    if ((paramView instanceof MaterialShapeDrawable)) {
      ((MaterialShapeDrawable)paramView).setElevation(paramFloat);
    }
  }
  
  public static void setParentAbsoluteElevation(@NonNull View paramView)
  {
    Drawable localDrawable = paramView.getBackground();
    if ((localDrawable instanceof MaterialShapeDrawable)) {
      setParentAbsoluteElevation(paramView, (MaterialShapeDrawable)localDrawable);
    }
  }
  
  public static void setParentAbsoluteElevation(@NonNull View paramView, @NonNull MaterialShapeDrawable paramMaterialShapeDrawable)
  {
    if (paramMaterialShapeDrawable.isElevationOverlayEnabled()) {
      paramMaterialShapeDrawable.setParentAbsoluteElevation(ViewUtils.getParentAbsoluteElevation(paramView));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shape\MaterialShapeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */