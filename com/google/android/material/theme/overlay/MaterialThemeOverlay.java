package com.google.android.material.theme.overlay;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ContextThemeWrapper;
import com.google.android.material.R.attr;

public class MaterialThemeOverlay
{
  private static final int[] ANDROID_THEME_OVERLAY_ATTRS = { 16842752, R.attr.theme };
  private static final int[] MATERIAL_THEME_OVERLAY_ATTR = { R.attr.materialThemeOverlay };
  
  @StyleRes
  private static int obtainAndroidThemeOverlayId(@NonNull Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ANDROID_THEME_OVERLAY_ATTRS);
    int i = paramContext.getResourceId(0, 0);
    int j = paramContext.getResourceId(1, 0);
    paramContext.recycle();
    if (i != 0) {
      j = i;
    }
    return j;
  }
  
  @StyleRes
  private static int obtainMaterialThemeOverlayId(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, MATERIAL_THEME_OVERLAY_ATTR, paramInt1, paramInt2);
    paramInt1 = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    return paramInt1;
  }
  
  @NonNull
  public static Context wrap(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramInt2 = obtainMaterialThemeOverlayId(paramContext, paramAttributeSet, paramInt1, paramInt2);
    if (((paramContext instanceof ContextThemeWrapper)) && (((ContextThemeWrapper)paramContext).getThemeResId() == paramInt2)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramInt2 != 0) && (paramInt1 == 0))
    {
      ContextThemeWrapper localContextThemeWrapper = new ContextThemeWrapper(paramContext, paramInt2);
      paramInt1 = obtainAndroidThemeOverlayId(paramContext, paramAttributeSet);
      if (paramInt1 != 0) {
        localContextThemeWrapper.getTheme().applyStyle(paramInt1, true);
      }
      return localContextThemeWrapper;
    }
    return paramContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\theme\overlay\MaterialThemeOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */