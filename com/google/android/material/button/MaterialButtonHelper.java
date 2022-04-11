package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class MaterialButtonHelper
{
  private static final boolean IS_LOLLIPOP;
  private boolean backgroundOverwritten = false;
  @Nullable
  private ColorStateList backgroundTint;
  @Nullable
  private PorterDuff.Mode backgroundTintMode;
  private boolean checkable;
  private int cornerRadius;
  private boolean cornerRadiusSet = false;
  private int insetBottom;
  private int insetLeft;
  private int insetRight;
  private int insetTop;
  @Nullable
  private Drawable maskDrawable;
  private final MaterialButton materialButton;
  @Nullable
  private ColorStateList rippleColor;
  private LayerDrawable rippleDrawable;
  @NonNull
  private ShapeAppearanceModel shapeAppearanceModel;
  private boolean shouldDrawSurfaceColorStroke = false;
  @Nullable
  private ColorStateList strokeColor;
  private int strokeWidth;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    IS_LOLLIPOP = bool;
  }
  
  MaterialButtonHelper(MaterialButton paramMaterialButton, @NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.materialButton = paramMaterialButton;
    this.shapeAppearanceModel = paramShapeAppearanceModel;
  }
  
  private Drawable createBackground()
  {
    Object localObject1 = new MaterialShapeDrawable(this.shapeAppearanceModel);
    ((MaterialShapeDrawable)localObject1).initializeElevationOverlay(this.materialButton.getContext());
    DrawableCompat.setTintList((Drawable)localObject1, this.backgroundTint);
    Object localObject2 = this.backgroundTintMode;
    if (localObject2 != null) {
      DrawableCompat.setTintMode((Drawable)localObject1, (PorterDuff.Mode)localObject2);
    }
    ((MaterialShapeDrawable)localObject1).setStroke(this.strokeWidth, this.strokeColor);
    localObject2 = new MaterialShapeDrawable(this.shapeAppearanceModel);
    ((MaterialShapeDrawable)localObject2).setTint(0);
    float f = this.strokeWidth;
    int i;
    if (this.shouldDrawSurfaceColorStroke) {
      i = MaterialColors.getColor(this.materialButton, R.attr.colorSurface);
    } else {
      i = 0;
    }
    ((MaterialShapeDrawable)localObject2).setStroke(f, i);
    if (IS_LOLLIPOP)
    {
      localObject3 = new MaterialShapeDrawable(this.shapeAppearanceModel);
      this.maskDrawable = ((Drawable)localObject3);
      DrawableCompat.setTint((Drawable)localObject3, -1);
      localObject1 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), wrapDrawableWithInset(new LayerDrawable(new Drawable[] { localObject2, localObject1 })), this.maskDrawable);
      this.rippleDrawable = ((LayerDrawable)localObject1);
      return (Drawable)localObject1;
    }
    Object localObject3 = new RippleDrawableCompat(this.shapeAppearanceModel);
    this.maskDrawable = ((Drawable)localObject3);
    DrawableCompat.setTintList((Drawable)localObject3, RippleUtils.sanitizeRippleDrawableColor(this.rippleColor));
    localObject1 = new LayerDrawable(new Drawable[] { localObject2, localObject1, this.maskDrawable });
    this.rippleDrawable = ((LayerDrawable)localObject1);
    return wrapDrawableWithInset((Drawable)localObject1);
  }
  
  @Nullable
  private MaterialShapeDrawable getMaterialShapeDrawable(boolean paramBoolean)
  {
    LayerDrawable localLayerDrawable = this.rippleDrawable;
    if ((localLayerDrawable != null) && (localLayerDrawable.getNumberOfLayers() > 0))
    {
      if (IS_LOLLIPOP) {
        return (MaterialShapeDrawable)((LayerDrawable)((InsetDrawable)this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(paramBoolean ^ true);
      }
      return (MaterialShapeDrawable)this.rippleDrawable.getDrawable(paramBoolean ^ true);
    }
    return null;
  }
  
  @Nullable
  private MaterialShapeDrawable getSurfaceColorStrokeDrawable()
  {
    return getMaterialShapeDrawable(true);
  }
  
  private void updateButtonShape(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    if (getMaterialShapeDrawable() != null) {
      getMaterialShapeDrawable().setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    if (getSurfaceColorStrokeDrawable() != null) {
      getSurfaceColorStrokeDrawable().setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    if (getMaskDrawable() != null) {
      getMaskDrawable().setShapeAppearanceModel(paramShapeAppearanceModel);
    }
  }
  
  private void updateStroke()
  {
    MaterialShapeDrawable localMaterialShapeDrawable1 = getMaterialShapeDrawable();
    MaterialShapeDrawable localMaterialShapeDrawable2 = getSurfaceColorStrokeDrawable();
    if (localMaterialShapeDrawable1 != null)
    {
      localMaterialShapeDrawable1.setStroke(this.strokeWidth, this.strokeColor);
      if (localMaterialShapeDrawable2 != null)
      {
        float f = this.strokeWidth;
        int i;
        if (this.shouldDrawSurfaceColorStroke) {
          i = MaterialColors.getColor(this.materialButton, R.attr.colorSurface);
        } else {
          i = 0;
        }
        localMaterialShapeDrawable2.setStroke(f, i);
      }
    }
  }
  
  @NonNull
  private InsetDrawable wrapDrawableWithInset(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
  }
  
  int getCornerRadius()
  {
    return this.cornerRadius;
  }
  
  @Nullable
  public Shapeable getMaskDrawable()
  {
    LayerDrawable localLayerDrawable = this.rippleDrawable;
    if ((localLayerDrawable != null) && (localLayerDrawable.getNumberOfLayers() > 1))
    {
      if (this.rippleDrawable.getNumberOfLayers() > 2) {
        return (Shapeable)this.rippleDrawable.getDrawable(2);
      }
      return (Shapeable)this.rippleDrawable.getDrawable(1);
    }
    return null;
  }
  
  @Nullable
  MaterialShapeDrawable getMaterialShapeDrawable()
  {
    return getMaterialShapeDrawable(false);
  }
  
  @Nullable
  ColorStateList getRippleColor()
  {
    return this.rippleColor;
  }
  
  @NonNull
  ShapeAppearanceModel getShapeAppearanceModel()
  {
    return this.shapeAppearanceModel;
  }
  
  @Nullable
  ColorStateList getStrokeColor()
  {
    return this.strokeColor;
  }
  
  int getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  ColorStateList getSupportBackgroundTintList()
  {
    return this.backgroundTint;
  }
  
  PorterDuff.Mode getSupportBackgroundTintMode()
  {
    return this.backgroundTintMode;
  }
  
  boolean isBackgroundOverwritten()
  {
    return this.backgroundOverwritten;
  }
  
  boolean isCheckable()
  {
    return this.checkable;
  }
  
  void loadFromAttributes(@NonNull TypedArray paramTypedArray)
  {
    this.insetLeft = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
    this.insetRight = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
    this.insetTop = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
    this.insetBottom = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
    int i = R.styleable.MaterialButton_cornerRadius;
    if (paramTypedArray.hasValue(i))
    {
      i = paramTypedArray.getDimensionPixelSize(i, -1);
      this.cornerRadius = i;
      setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(i));
      this.cornerRadiusSet = true;
    }
    this.strokeWidth = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
    this.backgroundTintMode = ViewUtils.parseTintMode(paramTypedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
    this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), paramTypedArray, R.styleable.MaterialButton_backgroundTint);
    this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), paramTypedArray, R.styleable.MaterialButton_strokeColor);
    this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), paramTypedArray, R.styleable.MaterialButton_rippleColor);
    this.checkable = paramTypedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
    int j = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
    int k = ViewCompat.getPaddingStart(this.materialButton);
    int m = this.materialButton.getPaddingTop();
    i = ViewCompat.getPaddingEnd(this.materialButton);
    int n = this.materialButton.getPaddingBottom();
    if (paramTypedArray.hasValue(R.styleable.MaterialButton_android_background))
    {
      setBackgroundOverwritten();
    }
    else
    {
      this.materialButton.setInternalBackground(createBackground());
      paramTypedArray = getMaterialShapeDrawable();
      if (paramTypedArray != null) {
        paramTypedArray.setElevation(j);
      }
    }
    ViewCompat.setPaddingRelative(this.materialButton, k + this.insetLeft, m + this.insetTop, i + this.insetRight, n + this.insetBottom);
  }
  
  void setBackgroundColor(int paramInt)
  {
    if (getMaterialShapeDrawable() != null) {
      getMaterialShapeDrawable().setTint(paramInt);
    }
  }
  
  void setBackgroundOverwritten()
  {
    this.backgroundOverwritten = true;
    this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
    this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
  }
  
  void setCheckable(boolean paramBoolean)
  {
    this.checkable = paramBoolean;
  }
  
  void setCornerRadius(int paramInt)
  {
    if ((!this.cornerRadiusSet) || (this.cornerRadius != paramInt))
    {
      this.cornerRadius = paramInt;
      this.cornerRadiusSet = true;
      setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(paramInt));
    }
  }
  
  void setRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.rippleColor != paramColorStateList)
    {
      this.rippleColor = paramColorStateList;
      boolean bool = IS_LOLLIPOP;
      if ((bool) && ((this.materialButton.getBackground() instanceof RippleDrawable))) {
        ((RippleDrawable)this.materialButton.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(paramColorStateList));
      } else if ((!bool) && ((this.materialButton.getBackground() instanceof RippleDrawableCompat))) {
        ((RippleDrawableCompat)this.materialButton.getBackground()).setTintList(RippleUtils.sanitizeRippleDrawableColor(paramColorStateList));
      }
    }
  }
  
  void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.shapeAppearanceModel = paramShapeAppearanceModel;
    updateButtonShape(paramShapeAppearanceModel);
  }
  
  void setShouldDrawSurfaceColorStroke(boolean paramBoolean)
  {
    this.shouldDrawSurfaceColorStroke = paramBoolean;
    updateStroke();
  }
  
  void setStrokeColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.strokeColor != paramColorStateList)
    {
      this.strokeColor = paramColorStateList;
      updateStroke();
    }
  }
  
  void setStrokeWidth(int paramInt)
  {
    if (this.strokeWidth != paramInt)
    {
      this.strokeWidth = paramInt;
      updateStroke();
    }
  }
  
  void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.backgroundTint != paramColorStateList)
    {
      this.backgroundTint = paramColorStateList;
      if (getMaterialShapeDrawable() != null) {
        DrawableCompat.setTintList(getMaterialShapeDrawable(), this.backgroundTint);
      }
    }
  }
  
  void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.backgroundTintMode != paramMode)
    {
      this.backgroundTintMode = paramMode;
      if ((getMaterialShapeDrawable() != null) && (this.backgroundTintMode != null)) {
        DrawableCompat.setTintMode(getMaterialShapeDrawable(), this.backgroundTintMode);
      }
    }
  }
  
  void updateMaskBounds(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = this.maskDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(this.insetLeft, this.insetTop, paramInt2 - this.insetRight, paramInt1 - this.insetBottom);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\button\MaterialButtonHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */