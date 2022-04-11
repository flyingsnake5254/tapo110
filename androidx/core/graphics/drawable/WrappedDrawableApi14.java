package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

class WrappedDrawableApi14
  extends Drawable
  implements Drawable.Callback, WrappedDrawable, TintAwareDrawable
{
  static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
  private boolean mColorFilterSet;
  private int mCurrentColor;
  private PorterDuff.Mode mCurrentMode;
  Drawable mDrawable;
  private boolean mMutated;
  WrappedDrawableState mState;
  
  WrappedDrawableApi14(@Nullable Drawable paramDrawable)
  {
    this.mState = mutateConstantState();
    setWrappedDrawable(paramDrawable);
  }
  
  WrappedDrawableApi14(@NonNull WrappedDrawableState paramWrappedDrawableState, @Nullable Resources paramResources)
  {
    this.mState = paramWrappedDrawableState;
    updateLocalState(paramResources);
  }
  
  @NonNull
  private WrappedDrawableState mutateConstantState()
  {
    return new WrappedDrawableState(this.mState);
  }
  
  private void updateLocalState(@Nullable Resources paramResources)
  {
    Object localObject = this.mState;
    if (localObject != null)
    {
      localObject = ((WrappedDrawableState)localObject).mDrawableState;
      if (localObject != null) {
        setWrappedDrawable(((Drawable.ConstantState)localObject).newDrawable(paramResources));
      }
    }
  }
  
  private boolean updateTint(int[] paramArrayOfInt)
  {
    if (!isCompatTintEnabled()) {
      return false;
    }
    Object localObject = this.mState;
    ColorStateList localColorStateList = ((WrappedDrawableState)localObject).mTint;
    localObject = ((WrappedDrawableState)localObject).mTintMode;
    if ((localColorStateList != null) && (localObject != null))
    {
      int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
      if ((!this.mColorFilterSet) || (i != this.mCurrentColor) || (localObject != this.mCurrentMode))
      {
        setColorFilter(i, (PorterDuff.Mode)localObject);
        this.mCurrentColor = i;
        this.mCurrentMode = ((PorterDuff.Mode)localObject);
        this.mColorFilterSet = true;
        return true;
      }
    }
    else
    {
      this.mColorFilterSet = false;
      clearColorFilter();
    }
    return false;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    this.mDrawable.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    int i = super.getChangingConfigurations();
    WrappedDrawableState localWrappedDrawableState = this.mState;
    int j;
    if (localWrappedDrawableState != null) {
      j = localWrappedDrawableState.getChangingConfigurations();
    } else {
      j = 0;
    }
    return i | j | this.mDrawable.getChangingConfigurations();
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    WrappedDrawableState localWrappedDrawableState = this.mState;
    if ((localWrappedDrawableState != null) && (localWrappedDrawableState.canConstantState()))
    {
      this.mState.mChangingConfigurations = getChangingConfigurations();
      return this.mState;
    }
    return null;
  }
  
  @NonNull
  public Drawable getCurrent()
  {
    return this.mDrawable.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return this.mDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mDrawable.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.mDrawable.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.mDrawable.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return this.mDrawable.getOpacity();
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    return this.mDrawable.getPadding(paramRect);
  }
  
  @NonNull
  public int[] getState()
  {
    return this.mDrawable.getState();
  }
  
  public Region getTransparentRegion()
  {
    return this.mDrawable.getTransparentRegion();
  }
  
  public final Drawable getWrappedDrawable()
  {
    return this.mDrawable;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  @RequiresApi(19)
  public boolean isAutoMirrored()
  {
    return this.mDrawable.isAutoMirrored();
  }
  
  protected boolean isCompatTintEnabled()
  {
    return true;
  }
  
  public boolean isStateful()
  {
    if (isCompatTintEnabled())
    {
      localObject = this.mState;
      if (localObject != null)
      {
        localObject = ((WrappedDrawableState)localObject).mTint;
        break label26;
      }
    }
    Object localObject = null;
    label26:
    boolean bool;
    if (((localObject != null) && (((ColorStateList)localObject).isStateful())) || (this.mDrawable.isStateful())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void jumpToCurrentState()
  {
    this.mDrawable.jumpToCurrentState();
  }
  
  @NonNull
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      this.mState = mutateConstantState();
      Object localObject = this.mDrawable;
      if (localObject != null) {
        ((Drawable)localObject).mutate();
      }
      WrappedDrawableState localWrappedDrawableState = this.mState;
      if (localWrappedDrawableState != null)
      {
        localObject = this.mDrawable;
        if (localObject != null) {
          localObject = ((Drawable)localObject).getConstantState();
        } else {
          localObject = null;
        }
        localWrappedDrawableState.mDrawableState = ((Drawable.ConstantState)localObject);
      }
      this.mMutated = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return this.mDrawable.setLevel(paramInt);
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mDrawable.setAlpha(paramInt);
  }
  
  @RequiresApi(19)
  public void setAutoMirrored(boolean paramBoolean)
  {
    this.mDrawable.setAutoMirrored(paramBoolean);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    this.mDrawable.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDrawable.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mDrawable.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mDrawable.setFilterBitmap(paramBoolean);
  }
  
  public boolean setState(@NonNull int[] paramArrayOfInt)
  {
    boolean bool = this.mDrawable.setState(paramArrayOfInt);
    if ((!updateTint(paramArrayOfInt)) && (!bool)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.mState.mTint = paramColorStateList;
    updateTint(getState());
  }
  
  public void setTintMode(@NonNull PorterDuff.Mode paramMode)
  {
    this.mState.mTintMode = paramMode;
    updateTint(getState());
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!super.setVisible(paramBoolean1, paramBoolean2)) && (!this.mDrawable.setVisible(paramBoolean1, paramBoolean2))) {
      paramBoolean1 = false;
    } else {
      paramBoolean1 = true;
    }
    return paramBoolean1;
  }
  
  public final void setWrappedDrawable(Drawable paramDrawable)
  {
    Object localObject = this.mDrawable;
    if (localObject != null) {
      ((Drawable)localObject).setCallback(null);
    }
    this.mDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      setVisible(paramDrawable.isVisible(), true);
      setState(paramDrawable.getState());
      setLevel(paramDrawable.getLevel());
      setBounds(paramDrawable.getBounds());
      localObject = this.mState;
      if (localObject != null) {
        ((WrappedDrawableState)localObject).mDrawableState = paramDrawable.getConstantState();
      }
    }
    invalidateSelf();
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\drawable\WrappedDrawableApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */