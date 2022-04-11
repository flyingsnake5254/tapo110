package com.google.android.material.resources;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialAttributes
{
  @Nullable
  public static TypedValue resolve(@NonNull Context paramContext, @AttrRes int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true)) {
      return localTypedValue;
    }
    return null;
  }
  
  public static boolean resolveBoolean(@NonNull Context paramContext, @AttrRes int paramInt, boolean paramBoolean)
  {
    paramContext = resolve(paramContext, paramInt);
    boolean bool = paramBoolean;
    if (paramContext != null)
    {
      bool = paramBoolean;
      if (paramContext.type == 18) {
        if (paramContext.data != 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    return bool;
  }
  
  public static boolean resolveBooleanOrThrow(@NonNull Context paramContext, @AttrRes int paramInt, @NonNull String paramString)
  {
    boolean bool;
    if (resolveOrThrow(paramContext, paramInt, paramString) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Px
  public static int resolveDimension(@NonNull Context paramContext, @AttrRes int paramInt1, @DimenRes int paramInt2)
  {
    TypedValue localTypedValue = resolve(paramContext, paramInt1);
    if ((localTypedValue != null) && (localTypedValue.type == 5)) {}
    for (float f = localTypedValue.getDimension(paramContext.getResources().getDisplayMetrics());; f = paramContext.getResources().getDimension(paramInt2)) {
      return (int)f;
    }
  }
  
  @Px
  public static int resolveMinimumAccessibleTouchTarget(@NonNull Context paramContext)
  {
    return resolveDimension(paramContext, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
  }
  
  public static int resolveOrThrow(@NonNull Context paramContext, @AttrRes int paramInt, @NonNull String paramString)
  {
    TypedValue localTypedValue = resolve(paramContext, paramInt);
    if (localTypedValue != null) {
      return localTypedValue.data;
    }
    throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[] { paramString, paramContext.getResources().getResourceName(paramInt) }));
  }
  
  public static int resolveOrThrow(@NonNull View paramView, @AttrRes int paramInt)
  {
    return resolveOrThrow(paramView.getContext(), paramInt, paramView.getClass().getCanonicalName());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\resources\MaterialAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */