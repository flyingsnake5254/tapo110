package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import androidx.annotation.Nullable;

public abstract interface TintableBackgroundView
{
  @Nullable
  public abstract ColorStateList getSupportBackgroundTintList();
  
  @Nullable
  public abstract PorterDuff.Mode getSupportBackgroundTintMode();
  
  public abstract void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList);
  
  public abstract void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\view\TintableBackgroundView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */