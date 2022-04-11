package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialRadioButton
  extends AppCompatRadioButton
{
  private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_CompoundButton_RadioButton;
  private static final int[][] ENABLED_CHECKED_STATES = { { 16842910, 16842912 }, { 16842910, -16842912 }, { -16842910, 16842912 }, { -16842910, -16842912 } };
  @Nullable
  private ColorStateList materialThemeColorsTintList;
  private boolean useMaterialThemeColors;
  
  public MaterialRadioButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialRadioButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.radioButtonStyle);
  }
  
  public MaterialRadioButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.wrap(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.MaterialRadioButton, paramInt, i, new int[0]);
    paramInt = R.styleable.MaterialRadioButton_buttonTint;
    if (paramAttributeSet.hasValue(paramInt)) {
      CompoundButtonCompat.setButtonTintList(this, MaterialResources.getColorStateList(paramContext, paramAttributeSet, paramInt));
    }
    this.useMaterialThemeColors = paramAttributeSet.getBoolean(R.styleable.MaterialRadioButton_useMaterialThemeColors, false);
    paramAttributeSet.recycle();
  }
  
  private ColorStateList getMaterialThemeColorsTintList()
  {
    if (this.materialThemeColorsTintList == null)
    {
      int i = MaterialColors.getColor(this, R.attr.colorControlActivated);
      int j = MaterialColors.getColor(this, R.attr.colorOnSurface);
      int k = MaterialColors.getColor(this, R.attr.colorSurface);
      int[][] arrayOfInt = ENABLED_CHECKED_STATES;
      int[] arrayOfInt1 = new int[arrayOfInt.length];
      arrayOfInt1[0] = MaterialColors.layer(k, i, 1.0F);
      arrayOfInt1[1] = MaterialColors.layer(k, j, 0.54F);
      arrayOfInt1[2] = MaterialColors.layer(k, j, 0.38F);
      arrayOfInt1[3] = MaterialColors.layer(k, j, 0.38F);
      this.materialThemeColorsTintList = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.materialThemeColorsTintList;
  }
  
  public boolean isUseMaterialThemeColors()
  {
    return this.useMaterialThemeColors;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.useMaterialThemeColors) && (CompoundButtonCompat.getButtonTintList(this) == null)) {
      setUseMaterialThemeColors(true);
    }
  }
  
  public void setUseMaterialThemeColors(boolean paramBoolean)
  {
    this.useMaterialThemeColors = paramBoolean;
    if (paramBoolean) {
      CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
    } else {
      CompoundButtonCompat.setButtonTintList(this, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\radiobutton\MaterialRadioButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */