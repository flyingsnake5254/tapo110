package com.google.android.material.shadow;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

public abstract interface ShadowViewDelegate
{
  public abstract float getRadius();
  
  public abstract boolean isCompatPaddingEnabled();
  
  public abstract void setBackgroundDrawable(@Nullable Drawable paramDrawable);
  
  public abstract void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\shadow\ShadowViewDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */