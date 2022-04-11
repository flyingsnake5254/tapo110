package com.google.android.material.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialAlertDialogBuilder
  extends AlertDialog.Builder
{
  @AttrRes
  private static final int DEF_STYLE_ATTR = R.attr.alertDialogStyle;
  @StyleRes
  private static final int DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents;
  @AttrRes
  private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = R.attr.materialAlertDialogTheme;
  @Nullable
  private Drawable background;
  @Dimension
  @NonNull
  private final Rect backgroundInsets;
  
  public MaterialAlertDialogBuilder(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public MaterialAlertDialogBuilder(@NonNull Context paramContext, int paramInt)
  {
    super(createMaterialAlertDialogThemedContext(paramContext), getOverridingThemeResId(paramContext, paramInt));
    Object localObject = getContext();
    Resources.Theme localTheme = ((Context)localObject).getTheme();
    int i = DEF_STYLE_ATTR;
    int j = DEF_STYLE_RES;
    this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets((Context)localObject, i, j);
    paramInt = MaterialColors.getColor((Context)localObject, R.attr.colorSurface, getClass().getCanonicalName());
    paramContext = new MaterialShapeDrawable((Context)localObject, null, i, j);
    paramContext.initializeElevationOverlay((Context)localObject);
    paramContext.setFillColor(ColorStateList.valueOf(paramInt));
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject = new TypedValue();
      localTheme.resolveAttribute(16844145, (TypedValue)localObject, true);
      float f = ((TypedValue)localObject).getDimension(getContext().getResources().getDisplayMetrics());
      if ((((TypedValue)localObject).type == 5) && (f >= 0.0F)) {
        paramContext.setCornerSize(f);
      }
    }
    this.background = paramContext;
  }
  
  private static Context createMaterialAlertDialogThemedContext(@NonNull Context paramContext)
  {
    int i = getMaterialAlertDialogThemeOverlay(paramContext);
    paramContext = MaterialThemeOverlay.wrap(paramContext, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
    if (i == 0) {
      return paramContext;
    }
    return new ContextThemeWrapper(paramContext, i);
  }
  
  private static int getMaterialAlertDialogThemeOverlay(@NonNull Context paramContext)
  {
    paramContext = MaterialAttributes.resolve(paramContext, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
    if (paramContext == null) {
      return 0;
    }
    return paramContext.data;
  }
  
  private static int getOverridingThemeResId(@NonNull Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = getMaterialAlertDialogThemeOverlay(paramContext);
    }
    return i;
  }
  
  @NonNull
  public AlertDialog create()
  {
    AlertDialog localAlertDialog = super.create();
    Window localWindow = localAlertDialog.getWindow();
    View localView = localWindow.getDecorView();
    Drawable localDrawable = this.background;
    if ((localDrawable instanceof MaterialShapeDrawable)) {
      ((MaterialShapeDrawable)localDrawable).setElevation(ViewCompat.getElevation(localView));
    }
    localWindow.setBackgroundDrawable(MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
    localView.setOnTouchListener(new InsetDialogOnTouchListener(localAlertDialog, this.backgroundInsets));
    return localAlertDialog;
  }
  
  @Nullable
  public Drawable getBackground()
  {
    return this.background;
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setAdapter(@Nullable ListAdapter paramListAdapter, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setAdapter(paramListAdapter, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setBackground(@Nullable Drawable paramDrawable)
  {
    this.background = paramDrawable;
    return this;
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setBackgroundInsetBottom(@Px int paramInt)
  {
    this.backgroundInsets.bottom = paramInt;
    return this;
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setBackgroundInsetEnd(@Px int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 17) && (getContext().getResources().getConfiguration().getLayoutDirection() == 1)) {
      this.backgroundInsets.left = paramInt;
    } else {
      this.backgroundInsets.right = paramInt;
    }
    return this;
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setBackgroundInsetStart(@Px int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 17) && (getContext().getResources().getConfiguration().getLayoutDirection() == 1)) {
      this.backgroundInsets.right = paramInt;
    } else {
      this.backgroundInsets.left = paramInt;
    }
    return this;
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setBackgroundInsetTop(@Px int paramInt)
  {
    this.backgroundInsets.top = paramInt;
    return this;
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setCancelable(boolean paramBoolean)
  {
    return (MaterialAlertDialogBuilder)super.setCancelable(paramBoolean);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setCursor(@Nullable Cursor paramCursor, @Nullable DialogInterface.OnClickListener paramOnClickListener, @NonNull String paramString)
  {
    return (MaterialAlertDialogBuilder)super.setCursor(paramCursor, paramOnClickListener, paramString);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setCustomTitle(@Nullable View paramView)
  {
    return (MaterialAlertDialogBuilder)super.setCustomTitle(paramView);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setIcon(@DrawableRes int paramInt)
  {
    return (MaterialAlertDialogBuilder)super.setIcon(paramInt);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setIcon(@Nullable Drawable paramDrawable)
  {
    return (MaterialAlertDialogBuilder)super.setIcon(paramDrawable);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setIconAttribute(@AttrRes int paramInt)
  {
    return (MaterialAlertDialogBuilder)super.setIconAttribute(paramInt);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setItems(@ArrayRes int paramInt, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setItems(paramInt, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setItems(@Nullable CharSequence[] paramArrayOfCharSequence, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setItems(paramArrayOfCharSequence, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setMessage(@StringRes int paramInt)
  {
    return (MaterialAlertDialogBuilder)super.setMessage(paramInt);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setMessage(@Nullable CharSequence paramCharSequence)
  {
    return (MaterialAlertDialogBuilder)super.setMessage(paramCharSequence);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setMultiChoiceItems(@ArrayRes int paramInt, @Nullable boolean[] paramArrayOfBoolean, @Nullable DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setMultiChoiceItems(paramInt, paramArrayOfBoolean, paramOnMultiChoiceClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable Cursor paramCursor, @NonNull String paramString1, @NonNull String paramString2, @Nullable DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setMultiChoiceItems(paramCursor, paramString1, paramString2, paramOnMultiChoiceClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable CharSequence[] paramArrayOfCharSequence, @Nullable boolean[] paramArrayOfBoolean, @Nullable DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setMultiChoiceItems(paramArrayOfCharSequence, paramArrayOfBoolean, paramOnMultiChoiceClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setNegativeButton(@StringRes int paramInt, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setNegativeButton(paramInt, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setNegativeButton(@Nullable CharSequence paramCharSequence, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setNegativeButton(paramCharSequence, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setNegativeButtonIcon(@Nullable Drawable paramDrawable)
  {
    return (MaterialAlertDialogBuilder)super.setNegativeButtonIcon(paramDrawable);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setNeutralButton(@StringRes int paramInt, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setNeutralButton(paramInt, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setNeutralButton(@Nullable CharSequence paramCharSequence, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setNeutralButton(paramCharSequence, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setNeutralButtonIcon(@Nullable Drawable paramDrawable)
  {
    return (MaterialAlertDialogBuilder)super.setNeutralButtonIcon(paramDrawable);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setOnCancelListener(@Nullable DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return (MaterialAlertDialogBuilder)super.setOnCancelListener(paramOnCancelListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setOnDismissListener(@Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return (MaterialAlertDialogBuilder)super.setOnDismissListener(paramOnDismissListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    return (MaterialAlertDialogBuilder)super.setOnItemSelectedListener(paramOnItemSelectedListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setOnKeyListener(@Nullable DialogInterface.OnKeyListener paramOnKeyListener)
  {
    return (MaterialAlertDialogBuilder)super.setOnKeyListener(paramOnKeyListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setPositiveButton(@StringRes int paramInt, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setPositiveButton(paramInt, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setPositiveButton(@Nullable CharSequence paramCharSequence, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setPositiveButton(paramCharSequence, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setPositiveButtonIcon(@Nullable Drawable paramDrawable)
  {
    return (MaterialAlertDialogBuilder)super.setPositiveButtonIcon(paramDrawable);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setSingleChoiceItems(@ArrayRes int paramInt1, int paramInt2, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setSingleChoiceItems(paramInt1, paramInt2, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable Cursor paramCursor, int paramInt, @NonNull String paramString, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setSingleChoiceItems(paramCursor, paramInt, paramString, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable ListAdapter paramListAdapter, int paramInt, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setSingleChoiceItems(paramListAdapter, paramInt, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable CharSequence[] paramArrayOfCharSequence, int paramInt, @Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    return (MaterialAlertDialogBuilder)super.setSingleChoiceItems(paramArrayOfCharSequence, paramInt, paramOnClickListener);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setTitle(@StringRes int paramInt)
  {
    return (MaterialAlertDialogBuilder)super.setTitle(paramInt);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setTitle(@Nullable CharSequence paramCharSequence)
  {
    return (MaterialAlertDialogBuilder)super.setTitle(paramCharSequence);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setView(int paramInt)
  {
    return (MaterialAlertDialogBuilder)super.setView(paramInt);
  }
  
  @NonNull
  public MaterialAlertDialogBuilder setView(@Nullable View paramView)
  {
    return (MaterialAlertDialogBuilder)super.setView(paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\dialog\MaterialAlertDialogBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */