package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialToolbar
  extends Toolbar
{
  private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Toolbar;
  
  public MaterialToolbar(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialToolbar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }
  
  public MaterialToolbar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.wrap(paramContext, paramAttributeSet, paramInt, DEF_STYLE_RES), paramAttributeSet, paramInt);
    initBackground(getContext());
  }
  
  private void initBackground(Context paramContext)
  {
    Drawable localDrawable = getBackground();
    if ((localDrawable != null) && (!(localDrawable instanceof ColorDrawable))) {
      return;
    }
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
    int i;
    if (localDrawable != null) {
      i = ((ColorDrawable)localDrawable).getColor();
    } else {
      i = 0;
    }
    localMaterialShapeDrawable.setFillColor(ColorStateList.valueOf(i));
    localMaterialShapeDrawable.initializeElevationOverlay(paramContext);
    localMaterialShapeDrawable.setElevation(ViewCompat.getElevation(this));
    ViewCompat.setBackground(this, localMaterialShapeDrawable);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.setParentAbsoluteElevation(this);
  }
  
  @RequiresApi(21)
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    MaterialShapeUtils.setElevation(this, paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\appbar\MaterialToolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */