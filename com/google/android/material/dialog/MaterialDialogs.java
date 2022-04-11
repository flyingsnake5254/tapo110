package com.google.android.material.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R.dimen;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ThemeEnforcement;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialDialogs
{
  @NonNull
  public static Rect getDialogBackgroundInsets(@NonNull Context paramContext, @AttrRes int paramInt1, int paramInt2)
  {
    TypedArray localTypedArray = ThemeEnforcement.obtainStyledAttributes(paramContext, null, R.styleable.MaterialAlertDialog, paramInt1, paramInt2, new int[0]);
    int i = localTypedArray.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetStart, paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_start));
    int j = localTypedArray.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetTop, paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_top));
    paramInt2 = localTypedArray.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetEnd, paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_end));
    int k = localTypedArray.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetBottom, paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_bottom));
    localTypedArray.recycle();
    int m = paramInt2;
    paramInt1 = i;
    if (Build.VERSION.SDK_INT >= 17)
    {
      m = paramInt2;
      paramInt1 = i;
      if (paramContext.getResources().getConfiguration().getLayoutDirection() == 1)
      {
        m = i;
        paramInt1 = paramInt2;
      }
    }
    return new Rect(paramInt1, j, m, k);
  }
  
  @NonNull
  public static InsetDrawable insetDrawable(@Nullable Drawable paramDrawable, @NonNull Rect paramRect)
  {
    return new InsetDrawable(paramDrawable, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\dialog\MaterialDialogs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */