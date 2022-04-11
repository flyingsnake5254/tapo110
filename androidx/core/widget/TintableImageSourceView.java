package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract interface TintableImageSourceView
{
  @Nullable
  public abstract ColorStateList getSupportImageTintList();
  
  @Nullable
  public abstract PorterDuff.Mode getSupportImageTintMode();
  
  public abstract void setSupportImageTintList(@Nullable ColorStateList paramColorStateList);
  
  public abstract void setSupportImageTintMode(@Nullable PorterDuff.Mode paramMode);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\widget\TintableImageSourceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */