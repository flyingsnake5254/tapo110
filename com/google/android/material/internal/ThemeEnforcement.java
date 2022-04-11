package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class ThemeEnforcement
{
  private static final int[] APPCOMPAT_CHECK_ATTRS = { R.attr.colorPrimary };
  private static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
  private static final int[] MATERIAL_CHECK_ATTRS = { R.attr.colorPrimaryVariant };
  private static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";
  
  public static void checkAppCompatTheme(@NonNull Context paramContext)
  {
    checkTheme(paramContext, APPCOMPAT_CHECK_ATTRS, "Theme.AppCompat");
  }
  
  private static void checkCompatibleTheme(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    boolean bool = paramAttributeSet.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
    paramAttributeSet.recycle();
    if (bool)
    {
      paramAttributeSet = new TypedValue();
      if ((!paramContext.getTheme().resolveAttribute(R.attr.isMaterialTheme, paramAttributeSet, true)) || ((paramAttributeSet.type == 18) && (paramAttributeSet.data == 0))) {
        checkMaterialTheme(paramContext);
      }
    }
    checkAppCompatTheme(paramContext);
  }
  
  public static void checkMaterialTheme(@NonNull Context paramContext)
  {
    checkTheme(paramContext, MATERIAL_CHECK_ATTRS, "Theme.MaterialComponents");
  }
  
  private static void checkTextAppearance(@NonNull Context paramContext, AttributeSet paramAttributeSet, @NonNull @StyleableRes int[] paramArrayOfInt1, @AttrRes int paramInt1, @StyleRes int paramInt2, @Nullable @StyleableRes int... paramVarArgs)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    int i = R.styleable.ThemeEnforcement_enforceTextAppearance;
    boolean bool = false;
    if (!localTypedArray.getBoolean(i, false))
    {
      localTypedArray.recycle();
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
      bool = isCustomTextAppearanceValid(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    } else if (localTypedArray.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1) {
      bool = true;
    }
    localTypedArray.recycle();
    if (bool) {
      return;
    }
    throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
  }
  
  private static void checkTheme(@NonNull Context paramContext, @NonNull int[] paramArrayOfInt, String paramString)
  {
    if (isTheme(paramContext, paramArrayOfInt)) {
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("The style on this component requires your app theme to be ");
    paramContext.append(paramString);
    paramContext.append(" (or a descendant).");
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  public static boolean isAppCompatTheme(@NonNull Context paramContext)
  {
    return isTheme(paramContext, APPCOMPAT_CHECK_ATTRS);
  }
  
  private static boolean isCustomTextAppearanceValid(@NonNull Context paramContext, AttributeSet paramAttributeSet, @NonNull @StyleableRes int[] paramArrayOfInt1, @AttrRes int paramInt1, @StyleRes int paramInt2, @NonNull @StyleableRes int... paramVarArgs)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    paramInt2 = paramVarArgs.length;
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
      if (paramContext.getResourceId(paramVarArgs[paramInt1], -1) == -1)
      {
        paramContext.recycle();
        return false;
      }
    }
    paramContext.recycle();
    return true;
  }
  
  public static boolean isMaterialTheme(@NonNull Context paramContext)
  {
    return isTheme(paramContext, MATERIAL_CHECK_ATTRS);
  }
  
  private static boolean isTheme(@NonNull Context paramContext, @NonNull int[] paramArrayOfInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramArrayOfInt);
    for (int i = 0; i < paramArrayOfInt.length; i++) {
      if (!paramContext.hasValue(i))
      {
        paramContext.recycle();
        return false;
      }
    }
    paramContext.recycle();
    return true;
  }
  
  @NonNull
  public static TypedArray obtainStyledAttributes(@NonNull Context paramContext, AttributeSet paramAttributeSet, @NonNull @StyleableRes int[] paramArrayOfInt1, @AttrRes int paramInt1, @StyleRes int paramInt2, @StyleableRes int... paramVarArgs)
  {
    checkCompatibleTheme(paramContext, paramAttributeSet, paramInt1, paramInt2);
    checkTextAppearance(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    return paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
  
  public static TintTypedArray obtainTintedStyledAttributes(@NonNull Context paramContext, AttributeSet paramAttributeSet, @NonNull @StyleableRes int[] paramArrayOfInt1, @AttrRes int paramInt1, @StyleRes int paramInt2, @StyleableRes int... paramVarArgs)
  {
    checkCompatibleTheme(paramContext, paramAttributeSet, paramInt1, paramInt2);
    checkTextAppearance(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    return TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\ThemeEnforcement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */