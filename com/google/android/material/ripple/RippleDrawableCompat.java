package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class RippleDrawableCompat
  extends Drawable
  implements Shapeable, TintAwareDrawable
{
  private RippleDrawableCompatState drawableState;
  
  private RippleDrawableCompat(RippleDrawableCompatState paramRippleDrawableCompatState)
  {
    this.drawableState = paramRippleDrawableCompatState;
  }
  
  public RippleDrawableCompat(ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this(new RippleDrawableCompatState(new MaterialShapeDrawable(paramShapeAppearanceModel)));
  }
  
  public void draw(Canvas paramCanvas)
  {
    RippleDrawableCompatState localRippleDrawableCompatState = this.drawableState;
    if (localRippleDrawableCompatState.shouldDrawDelegate) {
      localRippleDrawableCompatState.delegate.draw(paramCanvas);
    }
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    return this.drawableState;
  }
  
  public int getOpacity()
  {
    return this.drawableState.delegate.getOpacity();
  }
  
  @NonNull
  public ShapeAppearanceModel getShapeAppearanceModel()
  {
    return this.drawableState.delegate.getShapeAppearanceModel();
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  @NonNull
  public RippleDrawableCompat mutate()
  {
    this.drawableState = new RippleDrawableCompatState(this.drawableState);
    return this;
  }
  
  protected void onBoundsChange(@NonNull Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.drawableState.delegate.setBounds(paramRect);
  }
  
  protected boolean onStateChange(@NonNull int[] paramArrayOfInt)
  {
    boolean bool1 = super.onStateChange(paramArrayOfInt);
    boolean bool2 = this.drawableState.delegate.setState(paramArrayOfInt);
    boolean bool3 = true;
    if (bool2) {
      bool1 = true;
    }
    bool2 = RippleUtils.shouldDrawRippleCompat(paramArrayOfInt);
    paramArrayOfInt = this.drawableState;
    if (paramArrayOfInt.shouldDrawDelegate != bool2)
    {
      paramArrayOfInt.shouldDrawDelegate = bool2;
      bool1 = bool3;
    }
    return bool1;
  }
  
  public void setAlpha(int paramInt)
  {
    this.drawableState.delegate.setAlpha(paramInt);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.drawableState.delegate.setColorFilter(paramColorFilter);
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.drawableState.delegate.setShapeAppearanceModel(paramShapeAppearanceModel);
  }
  
  public void setTint(@ColorInt int paramInt)
  {
    this.drawableState.delegate.setTint(paramInt);
  }
  
  public void setTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.drawableState.delegate.setTintList(paramColorStateList);
  }
  
  public void setTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.drawableState.delegate.setTintMode(paramMode);
  }
  
  static final class RippleDrawableCompatState
    extends Drawable.ConstantState
  {
    @NonNull
    MaterialShapeDrawable delegate;
    boolean shouldDrawDelegate;
    
    public RippleDrawableCompatState(@NonNull RippleDrawableCompatState paramRippleDrawableCompatState)
    {
      this.delegate = ((MaterialShapeDrawable)paramRippleDrawableCompatState.delegate.getConstantState().newDrawable());
      this.shouldDrawDelegate = paramRippleDrawableCompatState.shouldDrawDelegate;
    }
    
    public RippleDrawableCompatState(MaterialShapeDrawable paramMaterialShapeDrawable)
    {
      this.delegate = paramMaterialShapeDrawable;
      this.shouldDrawDelegate = false;
    }
    
    public int getChangingConfigurations()
    {
      return 0;
    }
    
    @NonNull
    public RippleDrawableCompat newDrawable()
    {
      return new RippleDrawableCompat(new RippleDrawableCompatState(this), null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\ripple\RippleDrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */