package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class WrappedDrawableState
  extends Drawable.ConstantState
{
  int mChangingConfigurations;
  Drawable.ConstantState mDrawableState;
  ColorStateList mTint = null;
  PorterDuff.Mode mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;
  
  WrappedDrawableState(@Nullable WrappedDrawableState paramWrappedDrawableState)
  {
    if (paramWrappedDrawableState != null)
    {
      this.mChangingConfigurations = paramWrappedDrawableState.mChangingConfigurations;
      this.mDrawableState = paramWrappedDrawableState.mDrawableState;
      this.mTint = paramWrappedDrawableState.mTint;
      this.mTintMode = paramWrappedDrawableState.mTintMode;
    }
  }
  
  boolean canConstantState()
  {
    boolean bool;
    if (this.mDrawableState != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int getChangingConfigurations()
  {
    int i = this.mChangingConfigurations;
    Drawable.ConstantState localConstantState = this.mDrawableState;
    int j;
    if (localConstantState != null) {
      j = localConstantState.getChangingConfigurations();
    } else {
      j = 0;
    }
    return i | j;
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return newDrawable(null);
  }
  
  @NonNull
  public Drawable newDrawable(@Nullable Resources paramResources)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new WrappedDrawableApi21(this, paramResources);
    }
    return new WrappedDrawableApi14(this, paramResources);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\drawable\WrappedDrawableState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */