package com.google.android.material.elevation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R.attr;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;

public class ElevationOverlayProvider
{
  private static final float FORMULA_MULTIPLIER = 4.5F;
  private static final float FORMULA_OFFSET = 2.0F;
  private final int colorSurface;
  private final float displayDensity;
  private final int elevationOverlayColor;
  private final boolean elevationOverlayEnabled;
  
  public ElevationOverlayProvider(@NonNull Context paramContext)
  {
    this.elevationOverlayEnabled = MaterialAttributes.resolveBoolean(paramContext, R.attr.elevationOverlayEnabled, false);
    this.elevationOverlayColor = MaterialColors.getColor(paramContext, R.attr.elevationOverlayColor, 0);
    this.colorSurface = MaterialColors.getColor(paramContext, R.attr.colorSurface, 0);
    this.displayDensity = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private boolean isThemeSurfaceColor(@ColorInt int paramInt)
  {
    boolean bool;
    if (ColorUtils.setAlphaComponent(paramInt, 255) == this.colorSurface) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int calculateOverlayAlpha(float paramFloat)
  {
    return Math.round(calculateOverlayAlphaFraction(paramFloat) * 255.0F);
  }
  
  public float calculateOverlayAlphaFraction(float paramFloat)
  {
    float f = this.displayDensity;
    if ((f > 0.0F) && (paramFloat > 0.0F)) {
      return Math.min(((float)Math.log1p(paramFloat / f) * 4.5F + 2.0F) / 100.0F, 1.0F);
    }
    return 0.0F;
  }
  
  @ColorInt
  public int compositeOverlay(@ColorInt int paramInt, float paramFloat)
  {
    paramFloat = calculateOverlayAlphaFraction(paramFloat);
    int i = Color.alpha(paramInt);
    return ColorUtils.setAlphaComponent(MaterialColors.layer(ColorUtils.setAlphaComponent(paramInt, 255), this.elevationOverlayColor, paramFloat), i);
  }
  
  @ColorInt
  public int compositeOverlay(@ColorInt int paramInt, float paramFloat, @NonNull View paramView)
  {
    return compositeOverlay(paramInt, paramFloat + getParentAbsoluteElevation(paramView));
  }
  
  @ColorInt
  public int compositeOverlayIfNeeded(@ColorInt int paramInt, float paramFloat)
  {
    int i = paramInt;
    if (this.elevationOverlayEnabled)
    {
      i = paramInt;
      if (isThemeSurfaceColor(paramInt)) {
        i = compositeOverlay(paramInt, paramFloat);
      }
    }
    return i;
  }
  
  @ColorInt
  public int compositeOverlayIfNeeded(@ColorInt int paramInt, float paramFloat, @NonNull View paramView)
  {
    return compositeOverlayIfNeeded(paramInt, paramFloat + getParentAbsoluteElevation(paramView));
  }
  
  @ColorInt
  public int compositeOverlayWithThemeSurfaceColorIfNeeded(float paramFloat)
  {
    return compositeOverlayIfNeeded(this.colorSurface, paramFloat);
  }
  
  @ColorInt
  public int compositeOverlayWithThemeSurfaceColorIfNeeded(float paramFloat, @NonNull View paramView)
  {
    return compositeOverlayWithThemeSurfaceColorIfNeeded(paramFloat + getParentAbsoluteElevation(paramView));
  }
  
  public float getParentAbsoluteElevation(@NonNull View paramView)
  {
    return ViewUtils.getParentAbsoluteElevation(paramView);
  }
  
  @ColorInt
  public int getThemeElevationOverlayColor()
  {
    return this.elevationOverlayColor;
  }
  
  @ColorInt
  public int getThemeSurfaceColor()
  {
    return this.colorSurface;
  }
  
  public boolean isThemeElevationOverlayEnabled()
  {
    return this.elevationOverlayEnabled;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\elevation\ElevationOverlayProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */