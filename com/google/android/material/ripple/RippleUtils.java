package com.google.android.material.ripple;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class RippleUtils
{
  private static final int[] ENABLED_PRESSED_STATE_SET = { 16842910, 16842919 };
  private static final int[] FOCUSED_STATE_SET;
  private static final int[] HOVERED_FOCUSED_STATE_SET;
  private static final int[] HOVERED_STATE_SET;
  @VisibleForTesting
  static final String LOG_TAG = RippleUtils.class.getSimpleName();
  private static final int[] PRESSED_STATE_SET;
  private static final int[] SELECTED_FOCUSED_STATE_SET;
  private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET;
  private static final int[] SELECTED_HOVERED_STATE_SET;
  private static final int[] SELECTED_PRESSED_STATE_SET;
  private static final int[] SELECTED_STATE_SET;
  @VisibleForTesting
  static final String TRANSPARENT_DEFAULT_COLOR_WARNING = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";
  public static final boolean USE_FRAMEWORK_RIPPLE;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    USE_FRAMEWORK_RIPPLE = bool;
    PRESSED_STATE_SET = new int[] { 16842919 };
    HOVERED_FOCUSED_STATE_SET = new int[] { 16843623, 16842908 };
    FOCUSED_STATE_SET = new int[] { 16842908 };
    HOVERED_STATE_SET = new int[] { 16843623 };
    SELECTED_PRESSED_STATE_SET = new int[] { 16842913, 16842919 };
    SELECTED_HOVERED_FOCUSED_STATE_SET = new int[] { 16842913, 16843623, 16842908 };
    SELECTED_FOCUSED_STATE_SET = new int[] { 16842913, 16842908 };
    SELECTED_HOVERED_STATE_SET = new int[] { 16842913, 16843623 };
    SELECTED_STATE_SET = new int[] { 16842913 };
  }
  
  @NonNull
  public static ColorStateList convertToRippleDrawableColor(@Nullable ColorStateList paramColorStateList)
  {
    if (USE_FRAMEWORK_RIPPLE)
    {
      arrayOfInt1 = SELECTED_STATE_SET;
      i = getColorForState(paramColorStateList, SELECTED_PRESSED_STATE_SET);
      arrayOfInt2 = StateSet.NOTHING;
      j = getColorForState(paramColorStateList, PRESSED_STATE_SET);
      return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2 }, new int[] { i, j });
    }
    int[] arrayOfInt1 = SELECTED_PRESSED_STATE_SET;
    int i = getColorForState(paramColorStateList, arrayOfInt1);
    int[] arrayOfInt2 = SELECTED_HOVERED_FOCUSED_STATE_SET;
    int k = getColorForState(paramColorStateList, arrayOfInt2);
    int[] arrayOfInt3 = SELECTED_FOCUSED_STATE_SET;
    int m = getColorForState(paramColorStateList, arrayOfInt3);
    int[] arrayOfInt4 = SELECTED_HOVERED_STATE_SET;
    int n = getColorForState(paramColorStateList, arrayOfInt4);
    int[] arrayOfInt5 = SELECTED_STATE_SET;
    int[] arrayOfInt6 = PRESSED_STATE_SET;
    int j = getColorForState(paramColorStateList, arrayOfInt6);
    int[] arrayOfInt7 = HOVERED_FOCUSED_STATE_SET;
    int i1 = getColorForState(paramColorStateList, arrayOfInt7);
    int[] arrayOfInt8 = FOCUSED_STATE_SET;
    int i2 = getColorForState(paramColorStateList, arrayOfInt8);
    int[] arrayOfInt9 = HOVERED_STATE_SET;
    int i3 = getColorForState(paramColorStateList, arrayOfInt9);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, StateSet.NOTHING }, new int[] { i, k, m, n, 0, j, i1, i2, i3, 0 });
  }
  
  @TargetApi(21)
  @ColorInt
  private static int doubleAlpha(@ColorInt int paramInt)
  {
    return ColorUtils.setAlphaComponent(paramInt, Math.min(Color.alpha(paramInt) * 2, 255));
  }
  
  @ColorInt
  private static int getColorForState(@Nullable ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    int i;
    if (paramColorStateList != null) {
      i = paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor());
    } else {
      i = 0;
    }
    int j = i;
    if (USE_FRAMEWORK_RIPPLE) {
      j = doubleAlpha(i);
    }
    return j;
  }
  
  @NonNull
  public static ColorStateList sanitizeRippleDrawableColor(@Nullable ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      int i = Build.VERSION.SDK_INT;
      if ((i >= 22) && (i <= 27) && (Color.alpha(paramColorStateList.getDefaultColor()) == 0) && (Color.alpha(paramColorStateList.getColorForState(ENABLED_PRESSED_STATE_SET, 0)) != 0)) {
        Log.w(LOG_TAG, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
      }
      return paramColorStateList;
    }
    return ColorStateList.valueOf(0);
  }
  
  public static boolean shouldDrawRippleCompat(@NonNull int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    boolean bool1 = false;
    int j = 0;
    int k = 0;
    int m = 0;
    while (j < i)
    {
      int n = paramArrayOfInt[j];
      int i1;
      if (n == 16842910)
      {
        i1 = 1;
      }
      else
      {
        if (n == 16842908) {}
        do
        {
          do
          {
            m = 1;
            i1 = k;
            break;
          } while (n == 16842919);
          i1 = k;
        } while (n == 16843623);
      }
      j++;
      k = i1;
    }
    boolean bool2 = bool1;
    if (k != 0)
    {
      bool2 = bool1;
      if (m != 0) {
        bool2 = true;
      }
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\ripple\RippleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */