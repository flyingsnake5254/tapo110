package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.MaterialAttributes;

public class MaterialColors
{
  public static final float ALPHA_DISABLED = 0.38F;
  public static final float ALPHA_DISABLED_LOW = 0.12F;
  public static final float ALPHA_FULL = 1.0F;
  public static final float ALPHA_LOW = 0.32F;
  public static final float ALPHA_MEDIUM = 0.54F;
  
  @ColorInt
  public static int compositeARGBWithAlpha(@ColorInt int paramInt1, @IntRange(from=0L, to=255L) int paramInt2)
  {
    return ColorUtils.setAlphaComponent(paramInt1, Color.alpha(paramInt1) * paramInt2 / 255);
  }
  
  @ColorInt
  public static int getColor(@NonNull Context paramContext, @AttrRes int paramInt1, @ColorInt int paramInt2)
  {
    paramContext = MaterialAttributes.resolve(paramContext, paramInt1);
    if (paramContext != null) {
      return paramContext.data;
    }
    return paramInt2;
  }
  
  @ColorInt
  public static int getColor(Context paramContext, @AttrRes int paramInt, String paramString)
  {
    return MaterialAttributes.resolveOrThrow(paramContext, paramInt, paramString);
  }
  
  @ColorInt
  public static int getColor(@NonNull View paramView, @AttrRes int paramInt)
  {
    return MaterialAttributes.resolveOrThrow(paramView, paramInt);
  }
  
  @ColorInt
  public static int getColor(@NonNull View paramView, @AttrRes int paramInt1, @ColorInt int paramInt2)
  {
    return getColor(paramView.getContext(), paramInt1, paramInt2);
  }
  
  @ColorInt
  public static int layer(@ColorInt int paramInt1, @ColorInt int paramInt2)
  {
    return ColorUtils.compositeColors(paramInt2, paramInt1);
  }
  
  @ColorInt
  public static int layer(@ColorInt int paramInt1, @ColorInt int paramInt2, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    return layer(paramInt1, ColorUtils.setAlphaComponent(paramInt2, Math.round(Color.alpha(paramInt2) * paramFloat)));
  }
  
  @ColorInt
  public static int layer(@NonNull View paramView, @AttrRes int paramInt1, @AttrRes int paramInt2)
  {
    return layer(paramView, paramInt1, paramInt2, 1.0F);
  }
  
  @ColorInt
  public static int layer(@NonNull View paramView, @AttrRes int paramInt1, @AttrRes int paramInt2, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    return layer(getColor(paramView, paramInt1), getColor(paramView, paramInt2), paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\color\MaterialColors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */