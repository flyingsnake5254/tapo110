package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import androidx.annotation.Nullable;

public abstract interface TintableCompoundButton
{
  @Nullable
  public abstract ColorStateList getSupportButtonTintList();
  
  @Nullable
  public abstract PorterDuff.Mode getSupportButtonTintMode();
  
  public abstract void setSupportButtonTintList(@Nullable ColorStateList paramColorStateList);
  
  public abstract void setSupportButtonTintMode(@Nullable PorterDuff.Mode paramMode);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\widget\TintableCompoundButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */