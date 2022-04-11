package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP, androidx.annotation.RestrictTo.Scope.TESTS})
public class MaterialStyledDatePickerDialog
  extends DatePickerDialog
{
  @AttrRes
  private static final int DEF_STYLE_ATTR = 16843612;
  @StyleRes
  private static final int DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;
  @NonNull
  private final Drawable background;
  @NonNull
  private final Rect backgroundInsets;
  
  public MaterialStyledDatePickerDialog(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public MaterialStyledDatePickerDialog(@NonNull Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, null, -1, -1, -1);
  }
  
  public MaterialStyledDatePickerDialog(@NonNull Context paramContext, int paramInt1, @Nullable DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramContext, paramInt1, paramOnDateSetListener, paramInt2, paramInt3, paramInt4);
    paramOnDateSetListener = getContext();
    paramInt2 = MaterialAttributes.resolveOrThrow(getContext(), R.attr.colorSurface, getClass().getCanonicalName());
    paramInt1 = DEF_STYLE_RES;
    paramContext = new MaterialShapeDrawable(paramOnDateSetListener, null, 16843612, paramInt1);
    if (Build.VERSION.SDK_INT >= 21) {
      paramContext.setFillColor(ColorStateList.valueOf(paramInt2));
    } else {
      paramContext.setFillColor(ColorStateList.valueOf(0));
    }
    paramOnDateSetListener = MaterialDialogs.getDialogBackgroundInsets(paramOnDateSetListener, 16843612, paramInt1);
    this.backgroundInsets = paramOnDateSetListener;
    this.background = MaterialDialogs.insetDrawable(paramContext, paramOnDateSetListener);
  }
  
  public MaterialStyledDatePickerDialog(@NonNull Context paramContext, @Nullable DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramContext, 0, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(this.background);
    getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this, this.backgroundInsets));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\MaterialStyledDatePickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */